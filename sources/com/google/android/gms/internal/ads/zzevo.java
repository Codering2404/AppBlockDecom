package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevo implements zzfci {
    private final com.google.android.gms.ads.internal.client.zzx zza;
    private final boolean zzb;

    public zzevo(com.google.android.gms.ads.internal.client.zzx zzxVar, boolean z2) {
        this.zza = zzxVar;
        this.zzb = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgu)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzb);
        }
        com.google.android.gms.ads.internal.client.zzx zzxVar = this.zza;
        if (zzxVar != null) {
            int i3 = zzxVar.f70032a;
            if (i3 == 1) {
                bundle.putString("avo", "p");
            } else if (i3 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
