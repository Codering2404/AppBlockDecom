package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zag<R extends Result> extends BasePendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Result f71880a;

    public zag(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.f71880a = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final Result createFailedResult(Status status) {
        return this.f71880a;
    }
}
