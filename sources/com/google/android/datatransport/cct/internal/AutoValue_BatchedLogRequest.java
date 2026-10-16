package com.google.android.datatransport.cct.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_BatchedLogRequest extends BatchedLogRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f69157a;

    AutoValue_BatchedLogRequest(List list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.f69157a = list;
    }

    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    public List c() {
        return this.f69157a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.f69157a.equals(((BatchedLogRequest) obj).c());
        }
        return false;
    }

    public int hashCode() {
        return this.f69157a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.f69157a + "}";
    }
}
