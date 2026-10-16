package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbrj extends zzbrg {
    final /* synthetic */ zzcfw zza;

    zzbrj(zzbrk zzbrkVar, zzcfw zzcfwVar) {
        this.zza = zzcfwVar;
        Objects.requireNonNull(zzbrkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbrh
    public final void zzb(ParcelFileDescriptor parcelFileDescriptor) {
        this.zza.zzc(parcelFileDescriptor);
    }
}
