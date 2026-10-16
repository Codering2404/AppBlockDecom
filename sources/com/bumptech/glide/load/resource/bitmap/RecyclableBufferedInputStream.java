package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.facebook.internal.NativeProtocol;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RecyclableBufferedInputStream extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile byte[] f66903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f66904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f66905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66906d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f66907f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayPool f66908g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class InvalidMarkException extends IOException {
        private static final long serialVersionUID = -4338378848813561757L;

        InvalidMarkException(String str) {
            super(str);
        }
    }

    public RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool) {
        this(inputStream, arrayPool, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    private int a(InputStream inputStream, byte[] bArr) throws IOException {
        int i3 = this.f66906d;
        if (i3 != -1) {
            int i4 = this.f66907f - i3;
            int i5 = this.f66905c;
            if (i4 < i5) {
                if (i3 == 0 && i5 > bArr.length && this.f66904b == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i5) {
                        i5 = length;
                    }
                    byte[] bArr2 = (byte[]) this.f66908g.c(i5, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f66903a = bArr2;
                    this.f66908g.put(bArr);
                    bArr = bArr2;
                } else if (i3 > 0) {
                    System.arraycopy(bArr, i3, bArr, 0, bArr.length - i3);
                }
                int i6 = this.f66907f - this.f66906d;
                this.f66907f = i6;
                this.f66906d = 0;
                this.f66904b = 0;
                int i7 = inputStream.read(bArr, i6, bArr.length - i6);
                int i8 = this.f66907f;
                if (i7 > 0) {
                    i8 += i7;
                }
                this.f66904b = i8;
                return i7;
            }
        }
        int i9 = inputStream.read(bArr);
        if (i9 > 0) {
            this.f66906d = -1;
            this.f66907f = 0;
            this.f66904b = i9;
        }
        return i9;
    }

    private static IOException f() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f66903a == null || inputStream == null) {
            throw f();
        }
        return (this.f66904b - this.f66907f) + inputStream.available();
    }

    public synchronized void b() {
        this.f66905c = this.f66903a.length;
    }

    public synchronized void c() {
        if (this.f66903a != null) {
            this.f66908g.put(this.f66903a);
            this.f66903a = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f66903a != null) {
            this.f66908g.put(this.f66903a);
            this.f66903a = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i3) {
        this.f66905c = Math.max(this.f66905c, i3);
        this.f66906d = this.f66907f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f66903a;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw f();
        }
        if (this.f66907f >= this.f66904b && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f66903a && (bArr = this.f66903a) == null) {
            throw f();
        }
        int i3 = this.f66904b;
        int i4 = this.f66907f;
        if (i3 - i4 <= 0) {
            return -1;
        }
        this.f66907f = i4 + 1;
        return bArr[i4] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f66903a == null) {
            throw new IOException("Stream is closed");
        }
        int i3 = this.f66906d;
        if (-1 == i3) {
            throw new InvalidMarkException("Mark has been invalidated, pos: " + this.f66907f + " markLimit: " + this.f66905c);
        }
        this.f66907f = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j3) {
        if (j3 < 1) {
            return 0L;
        }
        byte[] bArr = this.f66903a;
        if (bArr == null) {
            throw f();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw f();
        }
        int i3 = this.f66904b;
        int i4 = this.f66907f;
        if (i3 - i4 >= j3) {
            this.f66907f = (int) (((long) i4) + j3);
            return j3;
        }
        long j4 = ((long) i3) - ((long) i4);
        this.f66907f = i3;
        if (this.f66906d == -1 || j3 > this.f66905c) {
            long jSkip = inputStream.skip(j3 - j4);
            if (jSkip > 0) {
                this.f66906d = -1;
            }
            return j4 + jSkip;
        }
        if (a(inputStream, bArr) == -1) {
            return j4;
        }
        int i5 = this.f66904b;
        int i6 = this.f66907f;
        if (i5 - i6 >= j3 - j4) {
            this.f66907f = (int) ((((long) i6) + j3) - j4);
            return j3;
        }
        long j5 = (j4 + ((long) i5)) - ((long) i6);
        this.f66907f = i5;
        return j5;
    }

    RecyclableBufferedInputStream(InputStream inputStream, ArrayPool arrayPool, int i3) {
        super(inputStream);
        this.f66906d = -1;
        this.f66908g = arrayPool;
        this.f66903a = (byte[]) arrayPool.c(i3, byte[].class);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i3, int i4) {
        int i5;
        int i6;
        byte[] bArr2 = this.f66903a;
        if (bArr2 == null) {
            throw f();
        }
        if (i4 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream != null) {
            int i7 = this.f66907f;
            int i8 = this.f66904b;
            if (i7 < i8) {
                int i9 = i8 - i7 >= i4 ? i4 : i8 - i7;
                System.arraycopy(bArr2, i7, bArr, i3, i9);
                this.f66907f += i9;
                if (i9 == i4 || inputStream.available() == 0) {
                    return i9;
                }
                i3 += i9;
                i5 = i4 - i9;
            } else {
                i5 = i4;
            }
            while (true) {
                if (this.f66906d == -1 && i5 >= bArr2.length) {
                    i6 = inputStream.read(bArr, i3, i5);
                    if (i6 == -1) {
                        return i5 != i4 ? i4 - i5 : -1;
                    }
                } else {
                    if (a(inputStream, bArr2) == -1) {
                        return i5 != i4 ? i4 - i5 : -1;
                    }
                    if (bArr2 != this.f66903a && (bArr2 = this.f66903a) == null) {
                        throw f();
                    }
                    int i10 = this.f66904b;
                    int i11 = this.f66907f;
                    i6 = i10 - i11 >= i5 ? i5 : i10 - i11;
                    System.arraycopy(bArr2, i11, bArr, i3, i6);
                    this.f66907f += i6;
                }
                i5 -= i6;
                if (i5 == 0) {
                    return i4;
                }
                if (inputStream.available() == 0) {
                    return i4 - i5;
                }
                i3 += i6;
            }
        } else {
            throw f();
        }
    }
}
