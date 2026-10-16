package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebf implements zzeau {
    private final long zza;
    private final zzetk zzb;

    zzebf(long j3, Context context, zzeay zzeayVar, zzcnj zzcnjVar, String str) {
        this.zza = j3;
        zzfik zzfikVarZzn = zzcnjVar.zzn();
        zzfikVarZzn.zzd(context);
        zzfikVarZzn.zzb(new com.google.android.gms.ads.internal.client.zzr());
        zzfikVarZzn.zzc(str);
        zzetk zzetkVarZza = zzfikVarZzn.zza().zza();
        this.zzb = zzetkVarZza;
        zzetkVarZza.zzdS(new zzebe(this, zzeayVar));
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.zzb.zze(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzb() {
        this.zzb.zzR(ObjectWrapper.i5(null));
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzc() {
        this.zzb.zzc();
    }

    final /* synthetic */ long zzd() {
        return this.zza;
    }
}
