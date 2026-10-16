package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class g2 extends o5 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f59853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f59854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f59855l;

    public g2() {
        super(2);
        this.f59855l = 32;
    }

    private boolean b(o5 o5Var) {
        ByteBuffer byteBuffer;
        if (!m()) {
            return true;
        }
        if (this.f59854k >= this.f59855l || o5Var.d() != d()) {
            return false;
        }
        ByteBuffer byteBuffer2 = o5Var.f62183c;
        return byteBuffer2 == null || (byteBuffer = this.f62183c) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public boolean a(o5 o5Var) {
        b1.a(!o5Var.h());
        b1.a(!o5Var.c());
        b1.a(!o5Var.e());
        if (!b(o5Var)) {
            return false;
        }
        int i3 = this.f59854k;
        this.f59854k = i3 + 1;
        if (i3 == 0) {
            this.f62185f = o5Var.f62185f;
            if (o5Var.f()) {
                e(1);
            }
        }
        if (o5Var.d()) {
            e(Integer.MIN_VALUE);
        }
        ByteBuffer byteBuffer = o5Var.f62183c;
        if (byteBuffer != null) {
            g(byteBuffer.remaining());
            this.f62183c.put(byteBuffer);
        }
        this.f59853j = o5Var.f62185f;
        return true;
    }

    public void i(int i3) {
        b1.a(i3 > 0);
        this.f59855l = i3;
    }

    public long j() {
        return this.f62185f;
    }

    public long k() {
        return this.f59853j;
    }

    public int l() {
        return this.f59854k;
    }

    public boolean m() {
        return this.f59854k > 0;
    }

    @Override // com.applovin.impl.o5, com.applovin.impl.l2
    public void b() {
        super.b();
        this.f59854k = 0;
    }
}
