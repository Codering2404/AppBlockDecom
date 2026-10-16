package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcix implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ zzcja zzd;

    zzcix(zzcja zzcjaVar, String str, String str2, int i3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i3;
        Objects.requireNonNull(zzcjaVar);
        this.zzd = zzcjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheComplete");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("totalBytes", Integer.toString(this.zzc));
        this.zzd.zzw("onPrecacheEvent", map);
    }
}
