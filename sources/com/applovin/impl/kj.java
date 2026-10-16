package com.applovin.impl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class kj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final kj f61037c = new kj(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f61038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f61039b;

    public kj(long j3, long j4) {
        this.f61038a = j3;
        this.f61039b = j4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && kj.class == obj.getClass()) {
            kj kjVar = (kj) obj;
            if (this.f61038a == kjVar.f61038a && this.f61039b == kjVar.f61039b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((int) this.f61038a) * 31) + ((int) this.f61039b);
    }

    public String toString() {
        return "[timeUs=" + this.f61038a + ", position=" + this.f61039b + "]";
    }
}
