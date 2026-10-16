package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeqn implements zzelu {
    private final zzerr zza;
    private final zzdxc zzb;

    zzeqn(zzerr zzerrVar, zzdxc zzdxcVar) {
        this.zza = zzerrVar;
        this.zzb = zzdxcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzelu
    public final zzelv zza(String str, JSONObject jSONObject) throws zzflf {
        zzbxb zzbxbVarZzb;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcp)).booleanValue()) {
            try {
                zzbxbVarZzb = this.zzb.zzb(str);
            } catch (RemoteException e3) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.d("Coundn't create RTB adapter: ", e3);
                zzbxbVarZzb = null;
            }
        } else {
            zzbxbVarZzb = this.zza.zzb(str);
        }
        if (zzbxbVarZzb == null) {
            return null;
        }
        return new zzelv(zzbxbVarZzb, new zzenh(), str);
    }
}
