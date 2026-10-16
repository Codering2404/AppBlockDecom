package com.google.firebase.crashlytics.internal.metadata;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_RolloutAssignment extends RolloutAssignment {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f88508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f88509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f88510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f88511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f88512f;

    AutoValue_RolloutAssignment(String str, String str2, String str3, String str4, long j3) {
        if (str == null) {
            throw new NullPointerException("Null rolloutId");
        }
        this.f88508b = str;
        if (str2 == null) {
            throw new NullPointerException("Null parameterKey");
        }
        this.f88509c = str2;
        if (str3 == null) {
            throw new NullPointerException("Null parameterValue");
        }
        this.f88510d = str3;
        if (str4 == null) {
            throw new NullPointerException("Null variantId");
        }
        this.f88511e = str4;
        this.f88512f = j3;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public String c() {
        return this.f88509c;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public String d() {
        return this.f88510d;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public String e() {
        return this.f88508b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RolloutAssignment) {
            RolloutAssignment rolloutAssignment = (RolloutAssignment) obj;
            if (this.f88508b.equals(rolloutAssignment.e()) && this.f88509c.equals(rolloutAssignment.c()) && this.f88510d.equals(rolloutAssignment.d()) && this.f88511e.equals(rolloutAssignment.g()) && this.f88512f == rolloutAssignment.f()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public long f() {
        return this.f88512f;
    }

    @Override // com.google.firebase.crashlytics.internal.metadata.RolloutAssignment
    public String g() {
        return this.f88511e;
    }

    public int hashCode() {
        int iHashCode = (((((((this.f88508b.hashCode() ^ 1000003) * 1000003) ^ this.f88509c.hashCode()) * 1000003) ^ this.f88510d.hashCode()) * 1000003) ^ this.f88511e.hashCode()) * 1000003;
        long j3 = this.f88512f;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "RolloutAssignment{rolloutId=" + this.f88508b + ", parameterKey=" + this.f88509c + ", parameterValue=" + this.f88510d + ", variantId=" + this.f88511e + ", templateVersion=" + this.f88512f + "}";
    }
}
