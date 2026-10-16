package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AccountTransferClient extends GoogleApi<zzr> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f70994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api f70996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f70997d = 0;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f70994a = clientKey;
        zzb zzbVar = new zzb();
        f70995b = zzbVar;
        f70996c = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzbVar, clientKey);
    }
}
