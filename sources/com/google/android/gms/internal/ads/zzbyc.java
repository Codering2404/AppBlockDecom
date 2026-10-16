package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbyc implements DialogInterface.OnClickListener {
    final /* synthetic */ zzbyd zza;

    zzbyc(zzbyd zzbydVar) {
        Objects.requireNonNull(zzbydVar);
        this.zza = zzbydVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i3) {
        this.zza.zzg("User canceled the download.");
    }
}
