package com.google.android.datatransport.runtime.backends;

import com.google.android.datatransport.runtime.backends.BackendResponse;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BackendResponse extends BackendResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BackendResponse.Status f69376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f69377b;

    AutoValue_BackendResponse(BackendResponse.Status status, long j3) {
        if (status == null) {
            throw new NullPointerException("Null status");
        }
        this.f69376a = status;
        this.f69377b = j3;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public long b() {
        return this.f69377b;
    }

    @Override // com.google.android.datatransport.runtime.backends.BackendResponse
    public BackendResponse.Status c() {
        return this.f69376a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BackendResponse) {
            BackendResponse backendResponse = (BackendResponse) obj;
            if (this.f69376a.equals(backendResponse.c()) && this.f69377b == backendResponse.b()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.f69376a.hashCode() ^ 1000003) * 1000003;
        long j3 = this.f69377b;
        return iHashCode ^ ((int) (j3 ^ (j3 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f69376a + ", nextRequestWaitMillis=" + this.f69377b + "}";
    }
}
