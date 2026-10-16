package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxv implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbxx zza;

    zzbxv(zzbxx zzbxxVar) {
        Objects.requireNonNull(zzbxxVar);
        this.zza = zzbxxVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        zzbxx zzbxxVar = this.zza;
        Intent intentZzb = zzbxxVar.zzb();
        com.google.android.gms.ads.internal.zzt.g();
        com.google.android.gms.ads.internal.util.zzs.y(zzbxxVar.zzc(), intentZzb);
    }
}
