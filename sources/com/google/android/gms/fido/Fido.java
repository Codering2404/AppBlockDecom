package com.google.android.gms.fido;

import android.app.Activity;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.Fido2ApiClient;
import com.google.android.gms.internal.fido.zzaa;
import com.google.android.gms.internal.fido.zzab;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class Fido {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Api.ClientKey f72421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Api f72422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzaa f72423c;

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        f72421a = clientKey;
        f72422b = new Api("Fido.U2F_ZERO_PARTY_API", new zzab(), clientKey);
        f72423c = new zzaa();
    }

    public static Fido2ApiClient a(Activity activity) {
        return new Fido2ApiClient(activity);
    }
}
