package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class t5 implements s4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f63876b = -9223372036854775807L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f63875a = -9223372036854775807L;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f63877c = false;

    @Override // com.applovin.impl.s4
    public boolean a(qh qhVar) {
        qhVar.u();
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean b(qh qhVar) {
        qhVar.b();
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean c(qh qhVar) {
        if (!this.f63877c) {
            qhVar.B();
            return true;
        }
        if (!b() || !qhVar.y()) {
            return true;
        }
        a(qhVar, -this.f63875a);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean d(qh qhVar) {
        if (!this.f63877c) {
            qhVar.w();
            return true;
        }
        if (!a() || !qhVar.y()) {
            return true;
        }
        a(qhVar, this.f63876b);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean e(qh qhVar) {
        qhVar.D();
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean a(qh qhVar, int i3, long j3) {
        qhVar.a(i3, j3);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean b(qh qhVar, boolean z2) {
        qhVar.a(z2);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean a(qh qhVar, int i3) {
        qhVar.a(i3);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean b() {
        return !this.f63877c || this.f63875a > 0;
    }

    @Override // com.applovin.impl.s4
    public boolean a(qh qhVar, boolean z2) {
        qhVar.b(z2);
        return true;
    }

    @Override // com.applovin.impl.s4
    public boolean a() {
        return !this.f63877c || this.f63876b > 0;
    }

    private static void a(qh qhVar, long j3) {
        long currentPosition = qhVar.getCurrentPosition() + j3;
        long duration = qhVar.getDuration();
        if (duration != -9223372036854775807L) {
            currentPosition = Math.min(currentPosition, duration);
        }
        qhVar.a(Math.max(currentPosition, 0L));
    }
}
