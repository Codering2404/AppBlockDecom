package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzimu;
import com.google.android.gms.internal.ads.zzinc;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzav implements zzimu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzat f70693a;

    private zzav(zzat zzatVar) {
        this.f70693a = zzatVar;
    }

    public static zzav a(zzat zzatVar) {
        return new zzav(zzatVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        String strB = this.f70693a.b();
        zzinc.zzb(strB);
        return strB;
    }
}
