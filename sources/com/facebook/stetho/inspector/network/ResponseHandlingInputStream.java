package com.facebook.stetho.inspector.network;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.protocol.module.Console;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ResponseHandlingInputStream extends FilterInputStream {
    private static final int BUFFER_SIZE = 1024;
    public static final String TAG = "ResponseHandlingInputStream";
    private boolean mClosed;

    @Nullable
    private final CountingOutputStream mDecompressedCounter;
    private boolean mEofSeen;
    private long mLastDecompressedCount;
    private final ChromePeerManager mNetworkPeerManager;
    private final OutputStream mOutputStream;
    private final String mRequestId;
    private final ResponseHandler mResponseHandler;

    @Nullable
    private byte[] mSkipBuffer;

    public ResponseHandlingInputStream(InputStream inputStream, String str, OutputStream outputStream, @Nullable CountingOutputStream countingOutputStream, ChromePeerManager chromePeerManager, ResponseHandler responseHandler) {
        super(inputStream);
        this.mLastDecompressedCount = 0L;
        this.mRequestId = str;
        this.mOutputStream = outputStream;
        this.mDecompressedCounter = countingOutputStream;
        this.mNetworkPeerManager = chromePeerManager;
        this.mResponseHandler = responseHandler;
        this.mClosed = false;
    }

    private synchronized int checkEOF(int i3) {
        if (i3 == -1) {
            closeOutputStreamQuietly();
            this.mResponseHandler.onEOF();
            this.mEofSeen = true;
        }
        return i3;
    }

    private synchronized void closeOutputStreamQuietly() {
        if (!this.mClosed) {
            try {
                try {
                    this.mOutputStream.close();
                    reportDecodedSizeIfApplicable();
                } catch (IOException e3) {
                    CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Could not close the output stream" + e3);
                }
            } finally {
                this.mClosed = true;
            }
        }
    }

    @Nonnull
    private byte[] getSkipBufferLocked() {
        if (this.mSkipBuffer == null) {
            this.mSkipBuffer = new byte[BUFFER_SIZE];
        }
        return this.mSkipBuffer;
    }

    private IOException handleIOException(IOException iOException) {
        this.mResponseHandler.onError(iOException);
        return iOException;
    }

    private void handleIOExceptionWritingToStream(IOException iOException) {
        CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "Could not write response body to the stream " + iOException);
        closeOutputStreamQuietly();
    }

    private void reportDecodedSizeIfApplicable() {
        CountingOutputStream countingOutputStream = this.mDecompressedCounter;
        if (countingOutputStream != null) {
            long count = countingOutputStream.getCount();
            this.mResponseHandler.onReadDecoded((int) (count - this.mLastDecompressedCount));
            this.mLastDecompressedCount = count;
        }
    }

    private synchronized void writeToOutputStream(int i3) {
        if (this.mClosed) {
            return;
        }
        try {
            this.mOutputStream.write(i3);
            reportDecodedSizeIfApplicable();
        } catch (IOException e3) {
            handleIOExceptionWritingToStream(e3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        long j3;
        try {
            if (!this.mEofSeen) {
                byte[] bArr = new byte[BUFFER_SIZE];
                j3 = 0;
                while (true) {
                    int i3 = read(bArr);
                    if (i3 == -1) {
                        break;
                    } else {
                        j3 += (long) i3;
                    }
                }
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                CLog.writeToConsole(this.mNetworkPeerManager, Console.MessageLevel.ERROR, Console.MessageSource.NETWORK, "There were " + String.valueOf(j3) + " bytes that were not consumed while processing request " + this.mRequestId);
            }
            super.close();
            closeOutputStreamQuietly();
        } catch (Throwable th) {
            super.close();
            closeOutputStreamQuietly();
            throw th;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        try {
            int iCheckEOF = checkEOF(((FilterInputStream) this).in.read());
            if (iCheckEOF == -1) {
                return iCheckEOF;
            }
            this.mResponseHandler.onRead(1);
            writeToOutputStream(iCheckEOF);
            return iCheckEOF;
        } catch (IOException e3) {
            throw handleIOException(e3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new UnsupportedOperationException("Mark not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j3) throws IOException {
        long j4;
        byte[] skipBufferLocked = getSkipBufferLocked();
        j4 = 0;
        while (j4 < j3) {
            int i3 = read(skipBufferLocked, 0, (int) Math.min(skipBufferLocked.length, j3 - j4));
            if (i3 == -1) {
                break;
            }
            j4 += (long) i3;
        }
        return j4;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) throws IOException {
        try {
            int iCheckEOF = checkEOF(((FilterInputStream) this).in.read(bArr, i3, i4));
            if (iCheckEOF == -1) {
                return iCheckEOF;
            }
            this.mResponseHandler.onRead(iCheckEOF);
            writeToOutputStream(bArr, i3, iCheckEOF);
            return iCheckEOF;
        } catch (IOException e3) {
            throw handleIOException(e3);
        }
    }

    private synchronized void writeToOutputStream(byte[] bArr, int i3, int i4) {
        if (this.mClosed) {
            return;
        }
        try {
            this.mOutputStream.write(bArr, i3, i4);
            reportDecodedSizeIfApplicable();
        } catch (IOException e3) {
            handleIOExceptionWritingToStream(e3);
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i3) {
    }
}
