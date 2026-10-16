package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Objects;
import kotlinx.serialization.json.internal.OBeo.vgWWUoTKYyuC;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzciw implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ int zzd;
    final /* synthetic */ long zze;
    final /* synthetic */ long zzf;
    final /* synthetic */ boolean zzg;
    final /* synthetic */ int zzh;
    final /* synthetic */ int zzi;
    final /* synthetic */ zzcja zzj;

    zzciw(zzcja zzcjaVar, String str, String str2, int i3, int i4, long j3, long j4, boolean z2, int i5, int i6) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i3;
        this.zzd = i4;
        this.zze = j3;
        this.zzf = j4;
        this.zzg = z2;
        this.zzh = i5;
        this.zzi = i6;
        Objects.requireNonNull(zzcjaVar);
        this.zzj = zzcjaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap map = new HashMap();
        map.put("event", "precacheProgress");
        map.put("src", this.zza);
        map.put("cachedSrc", this.zzb);
        map.put("bytesLoaded", Integer.toString(this.zzc));
        map.put("totalBytes", Integer.toString(this.zzd));
        map.put("bufferedDuration", Long.toString(this.zze));
        map.put("totalDuration", Long.toString(this.zzf));
        map.put("cacheReady", true != this.zzg ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        map.put(vgWWUoTKYyuC.RLeIAgIFhQcuK, Integer.toString(this.zzh));
        map.put("playerPreparedCount", Integer.toString(this.zzi));
        this.zzj.zzw("onPrecacheEvent", map);
    }
}
