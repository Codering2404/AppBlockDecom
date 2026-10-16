package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzebj implements zzeau {
    private final long zza;
    private final zzeay zzb;
    private final zzfjw zzc;

    zzebj(long j3, Context context, zzeay zzeayVar, zzcnj zzcnjVar, String str) {
        this.zza = j3;
        this.zzb = zzeayVar;
        zzfjy zzfjyVarZzq = zzcnjVar.zzq();
        zzfjyVarZzq.zzc(context);
        zzfjyVarZzq.zzb(str);
        this.zzc = zzfjyVarZzq.zza().zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zza(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            this.zzc.zzc(zzmVar, new zzebh(this));
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzb() {
        try {
            zzfjw zzfjwVar = this.zzc;
            zzfjwVar.zze(new zzebi(this));
            zzfjwVar.zzb(ObjectWrapper.i5(null));
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }

    final /* synthetic */ long zzd() {
        return this.zza;
    }

    final /* synthetic */ zzeay zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzeau
    public final void zzc() {
    }
}
