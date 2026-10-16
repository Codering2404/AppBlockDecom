package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzggz implements zzimu {
    private final zzind zza;

    private zzggz(zzind zzindVar) {
        this.zza = zzindVar;
    }

    public static zzggz zza(zzind zzindVar) {
        return new zzggz(zzindVar);
    }

    @Override // com.google.android.gms.internal.ads.zzinj, com.google.android.gms.internal.ads.zzini
    public final /* bridge */ /* synthetic */ Object zzb() {
        DisplayMetrics displayMetrics = ((Context) this.zza.zzb()).getResources().getDisplayMetrics();
        zzinc.zzb(displayMetrics);
        return displayMetrics;
    }
}
