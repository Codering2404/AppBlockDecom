package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class CharSequenceReader extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CharSequence f85240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f85241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f85242c;

    public CharSequenceReader(CharSequence charSequence) {
        this.f85240a = (CharSequence) Preconditions.t(charSequence);
    }

    private void a() throws IOException {
        if (this.f85240a == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean b() {
        return c() > 0;
    }

    private int c() {
        Objects.requireNonNull(this.f85240a);
        return this.f85240a.length() - this.f85241b;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f85240a = null;
    }

    @Override // java.io.Reader
    public synchronized void mark(int i3) {
        Preconditions.h(i3 >= 0, "readAheadLimit (%s) may not be negative", i3);
        a();
        this.f85242c = this.f85241b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer charBuffer) {
        Preconditions.t(charBuffer);
        a();
        Objects.requireNonNull(this.f85240a);
        if (!b()) {
            return -1;
        }
        int iMin = Math.min(charBuffer.remaining(), c());
        for (int i3 = 0; i3 < iMin; i3++) {
            CharSequence charSequence = this.f85240a;
            int i4 = this.f85241b;
            this.f85241b = i4 + 1;
            charBuffer.put(charSequence.charAt(i4));
        }
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() {
        a();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() {
        a();
        this.f85241b = this.f85242c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long j3) {
        int iMin;
        Preconditions.k(j3 >= 0, "n (%s) may not be negative", j3);
        a();
        iMin = (int) Math.min(c(), j3);
        this.f85241b += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read() {
        int iCharAt;
        a();
        Objects.requireNonNull(this.f85240a);
        if (b()) {
            CharSequence charSequence = this.f85240a;
            int i3 = this.f85241b;
            this.f85241b = i3 + 1;
            iCharAt = charSequence.charAt(i3);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cArr, int i3, int i4) {
        Preconditions.y(i3, i3 + i4, cArr.length);
        a();
        Objects.requireNonNull(this.f85240a);
        if (!b()) {
            return -1;
        }
        int iMin = Math.min(i4, c());
        for (int i5 = 0; i5 < iMin; i5++) {
            CharSequence charSequence = this.f85240a;
            int i6 = this.f85241b;
            this.f85241b = i6 + 1;
            cArr[i3 + i5] = charSequence.charAt(i6);
        }
        return iMin;
    }
}
