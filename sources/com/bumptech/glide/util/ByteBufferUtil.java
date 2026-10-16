package com.bumptech.glide.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteBufferUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicReference f67263a = new AtomicReference();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SafeArray {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f67266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f67267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final byte[] f67268c;

        SafeArray(byte[] bArr, int i3, int i4) {
            this.f67268c = bArr;
            this.f67266a = i3;
            this.f67267b = i4;
        }
    }

    public static ByteBuffer a(File file) throws Throwable {
        Throwable th;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, "r");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] bArr = (byte[]) f67263a.getAndSet(null);
        if (bArr == null) {
            bArr = new byte[16384];
        }
        while (true) {
            int i3 = inputStream.read(bArr);
            if (i3 < 0) {
                f67263a.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return d(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
    }

    private static SafeArray c(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static ByteBuffer d(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static byte[] e(ByteBuffer byteBuffer) {
        SafeArray safeArrayC = c(byteBuffer);
        if (safeArrayC != null && safeArrayC.f67266a == 0 && safeArrayC.f67267b == safeArrayC.f67268c.length) {
            return byteBuffer.array();
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[byteBufferAsReadOnlyBuffer.limit()];
        d(byteBufferAsReadOnlyBuffer);
        byteBufferAsReadOnlyBuffer.get(bArr);
        return bArr;
    }

    public static void f(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        d(byteBuffer);
        FileChannel channel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                channel.write(byteBuffer);
                channel.force(false);
                channel.close();
                randomAccessFile.close();
                try {
                    channel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
            } catch (Throwable th) {
                th = th;
                if (channel != null) {
                    try {
                        channel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static InputStream g(ByteBuffer byteBuffer) {
        return new ByteBufferStream(byteBuffer);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteBufferStream extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ByteBuffer f67264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f67265b = -1;

        ByteBufferStream(ByteBuffer byteBuffer) {
            this.f67264a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f67264a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i3) {
            this.f67265b = this.f67264a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f67264a.hasRemaining()) {
                return this.f67264a.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i3 = this.f67265b;
            if (i3 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f67264a.position(i3);
        }

        @Override // java.io.InputStream
        public long skip(long j3) {
            if (!this.f67264a.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j3, available());
            ByteBuffer byteBuffer = this.f67264a;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i3, int i4) {
            if (!this.f67264a.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i4, available());
            this.f67264a.get(bArr, i3, iMin);
            return iMin;
        }
    }
}
