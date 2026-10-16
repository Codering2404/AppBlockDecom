package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezv implements zzfck {
    private final Context zza;
    private final Intent zzb;

    zzezv(Context context, Intent intent) {
        this.zza = context;
        this.zzb = intent;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        com.google.android.gms.ads.internal.util.zze.k("HsdpMigrationSignal.produce");
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzon)).booleanValue()) {
            return zzhbw.zza(new zzezw(null));
        }
        boolean z2 = false;
        try {
            if (this.zzb.resolveActivity(this.zza.getPackageManager()) != null) {
                com.google.android.gms.ads.internal.util.zze.k("HSDP intent is supported");
                z2 = true;
            }
        } catch (Exception e3) {
            com.google.android.gms.ads.internal.zzt.l().zzg(e3, "HsdpMigrationSignal.isHsdpMigrationSupported");
        }
        return zzhbw.zza(new zzezw(Boolean.valueOf(z2)));
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 60;
    }
}
