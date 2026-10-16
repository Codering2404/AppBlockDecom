package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzetn {
    private final zzets zza;
    private final String zzb;
    private com.google.android.gms.ads.internal.client.zzdx zzc;

    public zzetn(zzets zzetsVar, String str) {
        this.zza = zzetsVar;
        this.zzb = str;
    }

    public final synchronized boolean zza() throws RemoteException {
        return this.zza.zzb();
    }

    public final synchronized void zzb(com.google.android.gms.ads.internal.client.zzm zzmVar, int i3) throws RemoteException {
        this.zzc = null;
        zzett zzettVar = new zzett(i3);
        zzetm zzetmVar = new zzetm(this);
        this.zza.zza(zzmVar, this.zzb, zzettVar, zzetmVar);
    }

    public final synchronized String zzc() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVar;
        try {
            zzdxVar = this.zzc;
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            return null;
        }
        return zzdxVar != null ? zzdxVar.zze() : null;
    }

    public final synchronized String zzd() {
        com.google.android.gms.ads.internal.client.zzdx zzdxVar;
        try {
            zzdxVar = this.zzc;
        } catch (RemoteException e3) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
            return null;
        }
        return zzdxVar != null ? zzdxVar.zze() : null;
    }

    final /* synthetic */ void zze(com.google.android.gms.ads.internal.client.zzdx zzdxVar) {
        this.zzc = zzdxVar;
    }
}
