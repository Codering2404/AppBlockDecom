package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeht implements zzhbt {
    final /* synthetic */ zzcbd zza;
    final /* synthetic */ zzcau zzb;

    zzeht(zzeii zzeiiVar, zzcbd zzcbdVar, zzcau zzcauVar) {
        this.zza = zzcbdVar;
        this.zzb = zzcauVar;
        Objects.requireNonNull(zzeiiVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        try {
            this.zzb.zzf(com.google.android.gms.ads.internal.util.zzba.M(th));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle;
        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) obj;
        try {
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue()) {
                this.zzb.zze(parcelFileDescriptor);
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcO)).booleanValue() && (bundle = this.zza.zzm) != null) {
                bundle.putLong(zzdyu.BINDER_CALL_START.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
            }
            this.zzb.zzg(parcelFileDescriptor, this.zza);
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Service can't call client", e3);
        }
    }
}
