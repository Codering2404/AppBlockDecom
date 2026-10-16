package com.applovin.impl;

import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class j5 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h5 f60603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k5 f60604b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f60608f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f60606d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f60607e = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f60605c = new byte[1];

    public j5(h5 h5Var, k5 k5Var) {
        this.f60603a = h5Var;
        this.f60604b = k5Var;
    }

    private void a() {
        if (this.f60606d) {
            return;
        }
        this.f60603a.a(this.f60604b);
        this.f60606d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f60607e) {
            return;
        }
        this.f60603a.close();
        this.f60607e = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f60605c) == -1) {
            return -1;
        }
        return this.f60605c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i3, int i4) {
        b1.b(!this.f60607e);
        a();
        int iA = this.f60603a.a(bArr, i3, i4);
        if (iA == -1) {
            return -1;
        }
        this.f60608f += (long) iA;
        return iA;
    }
}
