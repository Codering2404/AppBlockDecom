package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Fido2PrivilegedApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api f72436b;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72435a = clientKey;
        f72436b = new Api("Fido.FIDO2_PRIVILEGED_API", new com.google.android.gms.internal.fido.zzj(), clientKey);
    }
}
