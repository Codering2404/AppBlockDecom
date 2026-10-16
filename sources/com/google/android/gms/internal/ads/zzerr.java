package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzerr {
    private final ConcurrentHashMap zza = new ConcurrentHashMap();
    private final zzdxc zzb;

    public zzerr(zzdxc zzdxcVar) {
        this.zzb = zzdxcVar;
    }

    public final void zza(String str) {
        try {
            this.zza.put(str, this.zzb.zzb(str));
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Couldn't create RTB adapter : ", e3);
        }
    }

    @CheckForNull
    public final zzbxb zzb(String str) {
        ConcurrentHashMap concurrentHashMap = this.zza;
        if (concurrentHashMap.containsKey(str)) {
            return (zzbxb) concurrentHashMap.get(str);
        }
        return null;
    }
}
