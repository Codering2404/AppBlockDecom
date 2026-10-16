package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgrp extends zzgqn {
    final /* synthetic */ zzgrr zza;
    private final zzgrw zzb;

    zzgrp(zzgrr zzgrrVar, zzgrw zzgrwVar) {
        Objects.requireNonNull(zzgrrVar);
        this.zza = zzgrrVar;
        this.zzb = zzgrwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgqo
    public final void zzb(Bundle bundle) {
        int i3 = bundle.getInt("statusCode", 8150);
        String string = bundle.getString("sessionToken");
        int i4 = bundle.getInt("uiMode", 0);
        zzgru zzgruVarZzd = zzgrv.zzd();
        zzgruVarZzd.zza(i3);
        if (string != null) {
            zzgruVarZzd.zzb(string);
        }
        zzgruVarZzd.zzc(i4);
        this.zzb.zza(zzgruVarZzd.zzd());
        if (i3 == 8157) {
            this.zza.zzd();
        }
    }
}
