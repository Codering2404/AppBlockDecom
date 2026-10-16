package com.google.android.libraries.places.internal;

import com.google.android.gms.maps.model.LatLng;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzhw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzblw f77943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzjc f77944b;

    zzhw(zzblw zzblwVar, zzjc zzjcVar) {
        this.f77943a = zzblwVar;
        this.f77944b = zzjcVar;
    }

    public final ListenableFuture a(LatLng latLng, com.google.android.libraries.places.api.auth.zzb zzbVar, String str) {
        zzavv zzavvVar = (zzavv) zzavw.b(this.f77943a).d(zzcei.a(this.f77944b.b(str, "results.placeId,results.types")), zzey.a(zzbVar.b()));
        zzavm zzavmVarG = zzavn.G();
        double d3 = latLng.f73163a;
        double d4 = latLng.f73164b;
        StringBuilder sb = new StringBuilder(String.valueOf(d3).length() + 1 + String.valueOf(d4).length());
        sb.append(d3);
        sb.append(",");
        sb.append(d4);
        zzavmVarG.y(sb.toString());
        zzavn zzavnVar = (zzavn) zzavmVarG.zzG();
        SettableFuture settableFutureF = SettableFuture.F();
        zzcef.a(zzavvVar.b().d(zzavw.a(), zzavvVar.c()), zzavnVar, new zzhv(this, settableFutureF));
        return settableFutureF;
    }
}
