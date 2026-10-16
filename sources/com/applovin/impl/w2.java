package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class w2 extends e2 {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final o5 f64534n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ah f64535o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f64536p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private v2 f64537q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f64538r;

    public w2() {
        super(6);
        this.f64534n = new o5(1);
        this.f64535o = new ah();
    }

    private void z() {
        v2 v2Var = this.f64537q;
        if (v2Var != null) {
            v2Var.a();
        }
    }

    @Override // com.applovin.impl.e2, com.applovin.impl.rh.b
    public void a(int i3, Object obj) {
        if (i3 == 8) {
            this.f64537q = (v2) obj;
        } else {
            super.a(i3, obj);
        }
    }

    @Override // com.applovin.impl.qi
    public boolean c() {
        return j();
    }

    @Override // com.applovin.impl.qi
    public boolean d() {
        return true;
    }

    @Override // com.applovin.impl.qi, com.applovin.impl.ri
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // com.applovin.impl.e2
    protected void v() {
        z();
    }

    @Override // com.applovin.impl.e2
    protected void a(long j3, boolean z2) {
        this.f64538r = Long.MIN_VALUE;
        z();
    }

    @Override // com.applovin.impl.e2
    protected void a(e9[] e9VarArr, long j3, long j4) {
        this.f64536p = j4;
    }

    private float[] a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f64535o.a(byteBuffer.array(), byteBuffer.limit());
        this.f64535o.f(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr[i3] = Float.intBitsToFloat(this.f64535o.m());
        }
        return fArr;
    }

    @Override // com.applovin.impl.qi
    public void a(long j3, long j4) {
        while (!j() && this.f64538r < 100000 + j3) {
            this.f64534n.b();
            if (a(r(), this.f64534n, 0) != -4 || this.f64534n.e()) {
                return;
            }
            o5 o5Var = this.f64534n;
            this.f64538r = o5Var.f62185f;
            if (this.f64537q != null && !o5Var.d()) {
                this.f64534n.g();
                float[] fArrA = a((ByteBuffer) xp.a(this.f64534n.f62183c));
                if (fArrA != null) {
                    ((v2) xp.a(this.f64537q)).a(this.f64538r - this.f64536p, fArrA);
                }
            }
        }
    }

    @Override // com.applovin.impl.ri
    public int a(e9 e9Var) {
        if ("application/x-camera-motion".equals(e9Var.f59394m)) {
            return ri.a(4);
        }
        return ri.a(0);
    }
}
