package com.facebook.stetho.websocket;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class WebSocketSession implements SimpleSession {
    private final SimpleEndpoint mEndpoint;
    private final ReadHandler mReadHandler;
    private volatile boolean mSentClose;
    private final WriteHandler mWriteHandler;
    private AtomicBoolean mIsOpen = new AtomicBoolean(false);
    private final ReadCallback mReadCallback = new ReadCallback() { // from class: com.facebook.stetho.websocket.WebSocketSession.1
        private void handleBinaryFrame(byte[] bArr, int i3) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, bArr, i3);
        }

        private void handleClose(byte[] bArr, int i3) {
            int i4;
            String str;
            if (i3 >= 2) {
                i4 = ((bArr[0] & 255) << 8) | (bArr[1] & 255);
                str = i3 > 2 ? new String(bArr, 2, i3 - 2) : null;
            } else {
                i4 = CloseCodes.CLOSED_ABNORMALLY;
                str = "Unparseable close frame";
            }
            if (!WebSocketSession.this.mSentClose) {
                WebSocketSession.this.sendClose(1000, "Received close frame");
            }
            WebSocketSession.this.markAndSignalClosed(i4, str);
        }

        private void handlePing(byte[] bArr, int i3) {
            WebSocketSession.this.doWrite(FrameHelper.createPongFrame(bArr, i3));
        }

        private void handleTextFrame(byte[] bArr, int i3) {
            WebSocketSession.this.mEndpoint.onMessage(WebSocketSession.this, new String(bArr, 0, i3));
        }

        @Override // com.facebook.stetho.websocket.ReadCallback
        public void onCompleteFrame(byte b3, byte[] bArr, int i3) {
            if (b3 == 1) {
                handleTextFrame(bArr, i3);
                return;
            }
            if (b3 == 2) {
                handleBinaryFrame(bArr, i3);
                return;
            }
            switch (b3) {
                case 8:
                    handleClose(bArr, i3);
                    break;
                case 9:
                    handlePing(bArr, i3);
                    break;
                case 10:
                    handlePong(bArr, i3);
                    break;
                default:
                    WebSocketSession.this.signalError(new IOException("Unsupported frame opcode=" + ((int) b3)));
                    break;
            }
        }

        private void handlePong(byte[] bArr, int i3) {
        }
    };
    private final WriteCallback mErrorForwardingWriteCallback = new WriteCallback() { // from class: com.facebook.stetho.websocket.WebSocketSession.2
        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onFailure(IOException iOException) {
            WebSocketSession.this.signalError(iOException);
        }

        @Override // com.facebook.stetho.websocket.WriteCallback
        public void onSuccess() {
        }
    };

    public WebSocketSession(InputStream inputStream, OutputStream outputStream, SimpleEndpoint simpleEndpoint) {
        this.mReadHandler = new ReadHandler(inputStream, simpleEndpoint);
        this.mWriteHandler = new WriteHandler(outputStream);
        this.mEndpoint = simpleEndpoint;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doWrite(Frame frame) {
        if (signalErrorIfNotOpen()) {
            return;
        }
        this.mWriteHandler.write(frame, this.mErrorForwardingWriteCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendClose(int i3, String str) {
        doWrite(FrameHelper.createCloseFrame(i3, str));
        markSentClose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void signalError(IOException iOException) {
        this.mEndpoint.onError(this, iOException);
    }

    private boolean signalErrorIfNotOpen() {
        if (isOpen()) {
            return false;
        }
        signalError(new IOException("Session is closed"));
        return true;
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void close(int i3, String str) {
        sendClose(i3, str);
        markAndSignalClosed(i3, str);
    }

    public void handle() throws IOException {
        markAndSignalOpen();
        try {
            this.mReadHandler.readLoop(this.mReadCallback);
        } catch (EOFException unused) {
            markAndSignalClosed(CloseCodes.UNEXPECTED_CONDITION, "EOF while reading");
        } catch (IOException e3) {
            markAndSignalClosed(CloseCodes.CLOSED_ABNORMALLY, null);
            throw e3;
        }
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public boolean isOpen() {
        return this.mIsOpen.get();
    }

    void markAndSignalClosed(int i3, String str) {
        if (this.mIsOpen.getAndSet(false)) {
            this.mEndpoint.onClose(this, i3, str);
        }
    }

    void markAndSignalOpen() {
        if (this.mIsOpen.getAndSet(true)) {
            return;
        }
        this.mEndpoint.onOpen(this);
    }

    void markSentClose() {
        this.mSentClose = true;
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void sendBinary(byte[] bArr) {
        doWrite(FrameHelper.createBinaryFrame(bArr));
    }

    @Override // com.facebook.stetho.websocket.SimpleSession
    public void sendText(String str) {
        doWrite(FrameHelper.createTextFrame(str));
    }
}
