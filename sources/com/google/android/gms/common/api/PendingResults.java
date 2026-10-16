package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class PendingResults {
    public static PendingResult a(Result result, GoogleApiClient googleApiClient) {
        Preconditions.n(result, "Result must not be null");
        Preconditions.b(!result.getStatus().w0(), "Status code must not be SUCCESS");
        zag zagVar = new zag(googleApiClient, result);
        zagVar.setResult(result);
        return zagVar;
    }

    public static PendingResult b(Status status, GoogleApiClient googleApiClient) {
        Preconditions.n(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.setResult(status);
        return statusPendingResult;
    }
}
