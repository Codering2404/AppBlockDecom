package com.google.android.datatransport.runtime.backends;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BackendResponse {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
    }

    public static BackendResponse d() {
        return new AutoValue_BackendResponse(Status.INVALID_PAYLOAD, -1L);
    }

    public static BackendResponse e(long j3) {
        return new AutoValue_BackendResponse(Status.OK, j3);
    }

    public static BackendResponse f() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
    }

    public abstract long b();

    public abstract Status c();
}
