package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbxy implements View.OnClickListener {
    final /* synthetic */ zzbya zza;

    zzbxy(zzbya zzbyaVar) {
        Objects.requireNonNull(zzbyaVar);
        this.zza = zzbyaVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zza.zzb(true);
    }
}
