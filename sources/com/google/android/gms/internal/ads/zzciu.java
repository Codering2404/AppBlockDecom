package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzciu implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ zzcja zze;

    zzciu(zzcja zzcjaVar, String str, String str2, int i3, int i4, boolean z2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i3;
        this.zzd = i4;
        Objects.requireNonNull(zzcjaVar);
        this.zze = zzcjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("bytesLoaded", Integer.toString(this.zzc));
        map.put("totalBytes", Integer.toString(this.zzd));
        map.put("cacheReady", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.zze.zzw("onPrecacheEvent", map);
    }
}
