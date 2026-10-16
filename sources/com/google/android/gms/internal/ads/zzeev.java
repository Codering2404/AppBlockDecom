package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeev implements zzimu {
    private final zzind zza;
    private final zzind zzb;

    private zzeev(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
        this.zzb = zzindVar2;
    }

    public static zzeev zza(zzind zzindVar, zzind zzindVar2) {
        return new zzeev(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* synthetic */ Object zzb() {
        zzfpk zzfpkVar = (zzfpk) this.zza.zzb();
        final CookieManager cookieManagerA = com.google.android.gms.ads.internal.zzt.j().a((Context) this.zzb.zzb());
        zzfpe zzfpeVar = zzfpe.WEBVIEW_COOKIE;
        Objects.requireNonNull(zzfpkVar);
        return zzfov.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeeq
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                CookieManager cookieManager = cookieManagerA;
                if (cookieManager == null) {
                    return "";
                }
                return cookieManager.getCookie((String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbz));
            }
        }, zzfpeVar, zzfpkVar).zzh(1L, TimeUnit.SECONDS).zzf(Exception.class, zzeen.zza).zzi();
    }
}
