package com.google.android.gms.auth.account;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class WorkAccount {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api f70956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final WorkAccountApi f70957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Api.ClientKey f70958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Api.AbstractClientBuilder f70959d;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f70958c = clientKey;
        zzf zzfVar = new zzf();
        f70959d = zzfVar;
        f70956a = new Api("WorkAccount.API", zzfVar, clientKey);
        f70957b = new zzal();
    }
}
