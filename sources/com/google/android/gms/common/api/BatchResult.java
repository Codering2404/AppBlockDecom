package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class BatchResult implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f71493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PendingResult[] f71494b;

    BatchResult(Status status, PendingResult[] pendingResultArr) {
        this.f71493a = status;
        this.f71494b = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f71493a;
    }
}
