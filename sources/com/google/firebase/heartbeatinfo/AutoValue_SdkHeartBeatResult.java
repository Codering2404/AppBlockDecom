package com.google.firebase.heartbeatinfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_SdkHeartBeatResult extends SdkHeartBeatResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f89186b;

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public long b() {
        return this.f89186b;
    }

    @Override // com.google.firebase.heartbeatinfo.SdkHeartBeatResult
    public String c() {
        return this.f89185a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SdkHeartBeatResult) {
            SdkHeartBeatResult sdkHeartBeatResult = (SdkHeartBeatResult) obj;
            if (this.f89185a.equals(sdkHeartBeatResult.c()) && this.f89186b == sdkHeartBeatResult.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f89185a.hashCode() ^ 1000003) * 1000003;
        long j3 = this.f89186b;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "SdkHeartBeatResult{sdkName=" + this.f89185a + ", millis=" + this.f89186b + "}";
    }
}
