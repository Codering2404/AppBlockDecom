package com.google.android.gms.fido.u2f;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.fido.zzx;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class U2fApiClient extends GoogleApi<Api.ApiOptions.NoOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f72694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api f72695b;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72694a = clientKey;
        f72695b = new Api("Fido.U2F_API", new zzx(), clientKey);
    }
}
