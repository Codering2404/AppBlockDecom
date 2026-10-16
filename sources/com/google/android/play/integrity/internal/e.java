package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class e extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f83185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f83186b;

    e(int i3, long j3) {
        this.f83185a = i3;
        this.f83186b = j3;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final int a() {
        return this.f83185a;
    }

    @Override // com.google.android.play.integrity.internal.f
    public final long b() {
        return this.f83186b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.f83185a == fVar.a() && this.f83186b == fVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j3 = this.f83186b;
        return ((int) (j3 ^ (j3 >>> 32))) ^ ((this.f83185a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f83185a + ", eventTimestamp=" + this.f83186b + "}";
    }
}
