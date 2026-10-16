package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzao;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AccountTransfer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey f70989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Api f70991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzao f70992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzao f70993e;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f70989a = clientKey;
        zza zzaVar = new zza();
        f70990b = zzaVar;
        f70991c = new Api("AccountTransfer.ACCOUNT_TRANSFER_API", zzaVar, clientKey);
        f70992d = new zzao();
        f70993e = new zzao();
    }
}
