package com.google.android.datatransport.cct.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LogResponse extends LogResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f69206a;

    AutoValue_LogResponse(long j3) {
        this.f69206a = j3;
    }

    @Override // com.google.android.datatransport.cct.internal.LogResponse
    public long c() {
        return this.f69206a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof LogResponse) && this.f69206a == ((LogResponse) obj).c();
    }

    public int hashCode() {
        long j3 = this.f69206a;
        return ((int) (j3 ^ (j3 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f69206a + "}";
    }
}
