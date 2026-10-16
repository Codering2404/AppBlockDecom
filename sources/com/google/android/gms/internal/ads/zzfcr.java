package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfcr implements zzfci {
    private final int zza;
    private final int zzb;

    zzfcr(int i3, int i4) {
        this.zza = i3;
        this.zzb = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i3;
        int i4 = this.zza;
        Bundle bundle = (Bundle) obj;
        if (i4 == -1 || (i3 = this.zzb) == -1) {
            return;
        }
        bundle.putInt("sessions_without_flags", i4);
        bundle.putInt("crashes_without_flags", i3);
        int i5 = com.google.android.gms.ads.internal.client.zzay.f69830h;
        if (com.google.android.gms.ads.internal.client.zzba.c().zzc()) {
            bundle.putBoolean("did_reset", true);
        }
    }
}
