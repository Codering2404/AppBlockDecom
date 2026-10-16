package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Utf8Charset;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class Framer {
    public static final byte ENTER_FRAME_PREFIX = 33;
    public static final byte EXIT_FRAME_PREFIX = 120;
    public static final byte STDERR_FRAME_PREFIX = 50;
    public static final byte STDIN_FRAME_PREFIX = 45;
    public static final byte STDIN_REQUEST_FRAME_PREFIX = 95;
    public static final byte STDOUT_FRAME_PREFIX = 49;
    private static final String TAG = "FramingSocket";
    private final DataInputStream mInput;
    private final DataOutputStream mMultiplexedOutputStream;
    private final InputStream mStdin = new FramingInputStream();
    private final PrintStream mStdout = new PrintStream(new BufferedOutputStream(new FramingOutputStream(STDOUT_FRAME_PREFIX)));
    private final PrintStream mStderr = new PrintStream(new FramingOutputStream(STDERR_FRAME_PREFIX));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ClosedHelper {
        private volatile boolean mClosed;

        private ClosedHelper() {
        }

        public void close() {
            this.mClosed = true;
        }

        public void throwIfClosed() throws IOException {
            if (this.mClosed) {
                throw new IOException("Stream is closed");
            }
        }
    }

    public Framer(InputStream inputStream, OutputStream outputStream) throws IOException {
        this.mInput = new DataInputStream(inputStream);
        this.mMultiplexedOutputStream = new DataOutputStream(outputStream);
    }

    private static <T extends Throwable> T handleSuppression(@Nullable T t2, T t3) {
        if (t2 == null) {
            return t3;
        }
        LogUtil.i(TAG, t3, "Suppressed while handling " + t2);
        return t2;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public byte readFrameType() throws IOException {
        return this.mInput.readByte();
    }

    public int readInt() throws IOException {
        return this.mInput.readInt();
    }

    public String readString() throws IOException {
        byte[] bArr = new byte[this.mInput.readUnsignedShort()];
        this.mInput.readFully(bArr);
        return new String(bArr, Charset.forName(Utf8Charset.NAME));
    }

    public void writeBlob(byte[] bArr, int i3, int i4) throws IOException {
        this.mMultiplexedOutputStream.write(bArr, i3, i4);
    }

    public void writeExitCode(int i3) throws IOException {
        this.mStdout.flush();
        this.mStderr.flush();
        writeIntFrame(EXIT_FRAME_PREFIX, i3);
    }

    public void writeIntFrame(byte b3, int i3) throws IOException {
        this.mMultiplexedOutputStream.write(b3);
        this.mMultiplexedOutputStream.writeInt(i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class FramingInputStream extends InputStream {
        private final ClosedHelper mClosedHelper;

        private FramingInputStream() {
            this.mClosedHelper = new ClosedHelper();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mClosedHelper.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            byte[] bArr = new byte[1];
            if (read(bArr) == 0) {
                return -1;
            }
            return bArr[0];
        }

        @Override // java.io.InputStream
        public long skip(long j3) throws IOException {
            long j4;
            byte[] bArr = new byte[(int) Math.min(j3, 2048L)];
            synchronized (Framer.this) {
                j4 = 0;
                while (j4 < j3) {
                    try {
                        int i3 = read(bArr);
                        if (i3 >= 0) {
                            j4 += (long) i3;
                        }
                    } finally {
                    }
                }
            }
            return j4;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) throws IOException {
            int i5;
            this.mClosedHelper.throwIfClosed();
            synchronized (Framer.this) {
                try {
                    Framer.this.writeIntFrame(Framer.STDIN_REQUEST_FRAME_PREFIX, i4);
                    byte frameType = Framer.this.readFrameType();
                    if (frameType == 45) {
                        i5 = Framer.this.readInt();
                        if (i5 > 0) {
                            if (i5 <= i4) {
                                Framer.this.mInput.readFully(bArr, i3, i5);
                            } else {
                                throw new DumpappFramingException("Expected at most " + i4 + " bytes, got: " + i5);
                            }
                        }
                    } else {
                        throw new UnexpectedFrameException(Framer.STDIN_FRAME_PREFIX, frameType);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class FramingOutputStream extends OutputStream {
        private final ClosedHelper mClosedHelper = new ClosedHelper();
        private final byte mPrefix;

        public FramingOutputStream(byte b3) {
            this.mPrefix = b3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mClosedHelper.close();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i3, int i4) throws IOException {
            this.mClosedHelper.throwIfClosed();
            if (i4 > 0) {
                try {
                    synchronized (Framer.this) {
                        Framer.this.writeIntFrame(this.mPrefix, i4);
                        Framer.this.writeBlob(bArr, i3, i4);
                        Framer.this.mMultiplexedOutputStream.flush();
                    }
                } catch (IOException e3) {
                    throw new DumpappOutputBrokenException(e3);
                }
            }
        }

        @Override // java.io.OutputStream
        public void write(int i3) throws IOException {
            write(new byte[]{(byte) i3}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            write(bArr, 0, bArr.length);
        }
    }
}
