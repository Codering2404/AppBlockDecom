package com.google.firebase;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_StartupTime extends StartupTime {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f87586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f87587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f87588c;

    AutoValue_StartupTime(long j3, long j4, long j5) {
        this.f87586a = j3;
        this.f87587b = j4;
        this.f87588c = j5;
    }

    @Override // com.google.firebase.StartupTime
    public long b() {
        return this.f87587b;
    }

    @Override // com.google.firebase.StartupTime
    public long c() {
        return this.f87586a;
    }

    @Override // com.google.firebase.StartupTime
    public long d() {
        return this.f87588c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof StartupTime) {
            StartupTime startupTime = (StartupTime) obj;
            if (this.f87586a == startupTime.c() && this.f87587b == startupTime.b() && this.f87588c == startupTime.d()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j3 = this.f87586a;
        long j4 = this.f87587b;
        int i3 = (((((int) (j3 ^ (j3 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        long j5 = this.f87588c;
        return i3 ^ ((int) ((j5 >>> 32) ^ j5));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f87586a + ", elapsedRealtime=" + this.f87587b + ", uptimeMillis=" + this.f87588c + "}";
    }
}
