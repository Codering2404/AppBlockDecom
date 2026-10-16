package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbt implements ProxyApi {
    public final PendingResult<ProxyApi.SpatulaHeaderResult> getSpatulaHeader(GoogleApiClient googleApiClient) {
        Preconditions.m(googleApiClient);
        return googleApiClient.h(new zzbs(this, googleApiClient));
    }

    public final PendingResult<ProxyApi.ProxyResult> performProxyRequest(GoogleApiClient googleApiClient, ProxyRequest proxyRequest) {
        Preconditions.m(googleApiClient);
        Preconditions.m(proxyRequest);
        return googleApiClient.h(new zzbq(this, googleApiClient, proxyRequest));
    }
}
