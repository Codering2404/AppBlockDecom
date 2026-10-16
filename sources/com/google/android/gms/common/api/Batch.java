package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Batch extends BasePendingResult<BatchResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f71488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f71489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f71490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PendingResult[] f71491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f71492e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.f71491d);
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        int i3 = 0;
        while (true) {
            PendingResult[] pendingResultArr = this.f71491d;
            if (i3 >= pendingResultArr.length) {
                return;
            }
            pendingResultArr[i3].cancel();
            i3++;
        }
    }
}
