package com.applovin.impl;

import com.applovin.impl.ae;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class yd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ae.a f65182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f65183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f65184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f65185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f65186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f65187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f65188g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f65189h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f65190i;

    yd(ae.a aVar, long j3, long j4, long j5, long j6, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6 = true;
        b1.a(!z5 || z3);
        b1.a(!z4 || z3);
        if (z2 && (z3 || z4 || z5)) {
            z6 = false;
        }
        b1.a(z6);
        this.f65182a = aVar;
        this.f65183b = j3;
        this.f65184c = j4;
        this.f65185d = j5;
        this.f65186e = j6;
        this.f65187f = z2;
        this.f65188g = z3;
        this.f65189h = z4;
        this.f65190i = z5;
    }

    public yd a(long j3) {
        return j3 == this.f65184c ? this : new yd(this.f65182a, this.f65183b, j3, this.f65185d, this.f65186e, this.f65187f, this.f65188g, this.f65189h, this.f65190i);
    }

    public yd b(long j3) {
        return j3 == this.f65183b ? this : new yd(this.f65182a, j3, this.f65184c, this.f65185d, this.f65186e, this.f65187f, this.f65188g, this.f65189h, this.f65190i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && yd.class == obj.getClass()) {
            yd ydVar = (yd) obj;
            if (this.f65183b == ydVar.f65183b && this.f65184c == ydVar.f65184c && this.f65185d == ydVar.f65185d && this.f65186e == ydVar.f65186e && this.f65187f == ydVar.f65187f && this.f65188g == ydVar.f65188g && this.f65189h == ydVar.f65189h && this.f65190i == ydVar.f65190i && xp.a(this.f65182a, ydVar.f65182a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((this.f65182a.hashCode() + 527) * 31) + ((int) this.f65183b)) * 31) + ((int) this.f65184c)) * 31) + ((int) this.f65185d)) * 31) + ((int) this.f65186e)) * 31) + (this.f65187f ? 1 : 0)) * 31) + (this.f65188g ? 1 : 0)) * 31) + (this.f65189h ? 1 : 0)) * 31) + (this.f65190i ? 1 : 0);
    }
}
