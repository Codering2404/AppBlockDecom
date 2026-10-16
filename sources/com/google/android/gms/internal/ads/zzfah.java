package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfah implements zzfci {
    public final zzfke zza;

    public zzfah(zzfke zzfkeVar) {
        this.zza = zzfkeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfke zzfkeVar = this.zza;
        if (zzfkeVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zznt)).booleanValue()) {
                return;
            }
            bundle.putBoolean("render_in_browser", zzfkeVar.zzb());
            bundle.putBoolean("disable_ml", zzfkeVar.zzc());
        }
    }
}
