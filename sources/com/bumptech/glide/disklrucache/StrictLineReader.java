package com.bumptech.glide.disklrucache;

import com.facebook.internal.Utility;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class StrictLineReader implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f66163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Charset f66164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private byte[] f66165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f66166d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f66167f;

    StrictLineReader(InputStream inputStream, Charset charset) {
        this(inputStream, Utility.DEFAULT_STREAM_BUFFER_SIZE, charset);
    }

    private void b() throws IOException {
        InputStream inputStream = this.f66163a;
        byte[] bArr = this.f66165c;
        int i3 = inputStream.read(bArr, 0, bArr.length);
        if (i3 == -1) {
            throw new EOFException();
        }
        this.f66166d = 0;
        this.f66167f = i3;
    }

    boolean c() {
        return this.f66167f == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f66163a) {
            try {
                if (this.f66165c != null) {
                    this.f66165c = null;
                    this.f66163a.close();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String f() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f66163a
            monitor-enter(r0)
            byte[] r1 = r7.f66165c     // Catch: java.lang.Throwable -> L11
            if (r1 == 0) goto L83
            int r1 = r7.f66166d     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f66167f     // Catch: java.lang.Throwable -> L11
            if (r1 < r2) goto L14
            r7.b()     // Catch: java.lang.Throwable -> L11
            goto L14
        L11:
            r1 = move-exception
            goto L8b
        L14:
            int r1 = r7.f66166d     // Catch: java.lang.Throwable -> L11
        L16:
            int r2 = r7.f66167f     // Catch: java.lang.Throwable -> L11
            r3 = 10
            if (r1 == r2) goto L45
            byte[] r2 = r7.f66165c     // Catch: java.lang.Throwable -> L11
            r4 = r2[r1]     // Catch: java.lang.Throwable -> L11
            if (r4 != r3) goto L42
            int r3 = r7.f66166d     // Catch: java.lang.Throwable -> L11
            if (r1 == r3) goto L2f
            int r4 = r1 + (-1)
            r5 = r2[r4]     // Catch: java.lang.Throwable -> L11
            r6 = 13
            if (r5 != r6) goto L2f
            goto L30
        L2f:
            r4 = r1
        L30:
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Throwable -> L11
            int r4 = r4 - r3
            java.nio.charset.Charset r6 = r7.f66164b     // Catch: java.lang.Throwable -> L11
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L11
            r5.<init>(r2, r3, r4, r6)     // Catch: java.lang.Throwable -> L11
            int r1 = r1 + 1
            r7.f66166d = r1     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r5
        L42:
            int r1 = r1 + 1
            goto L16
        L45:
            com.bumptech.glide.disklrucache.StrictLineReader$1 r1 = new com.bumptech.glide.disklrucache.StrictLineReader$1     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f66167f     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f66166d     // Catch: java.lang.Throwable -> L11
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
        L51:
            byte[] r2 = r7.f66165c     // Catch: java.lang.Throwable -> L11
            int r4 = r7.f66166d     // Catch: java.lang.Throwable -> L11
            int r5 = r7.f66167f     // Catch: java.lang.Throwable -> L11
            int r5 = r5 - r4
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L11
            r2 = -1
            r7.f66167f = r2     // Catch: java.lang.Throwable -> L11
            r7.b()     // Catch: java.lang.Throwable -> L11
            int r2 = r7.f66166d     // Catch: java.lang.Throwable -> L11
        L63:
            int r4 = r7.f66167f     // Catch: java.lang.Throwable -> L11
            if (r2 == r4) goto L51
            byte[] r4 = r7.f66165c     // Catch: java.lang.Throwable -> L11
            r5 = r4[r2]     // Catch: java.lang.Throwable -> L11
            if (r5 != r3) goto L80
            int r3 = r7.f66166d     // Catch: java.lang.Throwable -> L11
            if (r2 == r3) goto L76
            int r5 = r2 - r3
            r1.write(r4, r3, r5)     // Catch: java.lang.Throwable -> L11
        L76:
            int r2 = r2 + 1
            r7.f66166d = r2     // Catch: java.lang.Throwable -> L11
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            return r1
        L80:
            int r2 = r2 + 1
            goto L63
        L83:
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L11
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L11
            throw r1     // Catch: java.lang.Throwable -> L11
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L11
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.disklrucache.StrictLineReader.f():java.lang.String");
    }

    StrictLineReader(InputStream inputStream, int i3, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(Util.f66169a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f66163a = inputStream;
        this.f66164b = charset;
        this.f66165c = new byte[i3];
    }
}
