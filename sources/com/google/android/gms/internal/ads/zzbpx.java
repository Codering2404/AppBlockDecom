package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbpx implements zzbpq {
    static final Map zza = CollectionUtils.d(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbya zzc;
    private final zzbyh zzd;

    public zzbpx(com.google.android.gms.ads.internal.zzb zzbVar, zzbya zzbyaVar, zzbyh zzbyhVar) {
        this.zzb = zzbVar;
        this.zzc = zzbyaVar;
        this.zzd = zzbyhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        int iIntValue = ((Integer) zza.get((String) map.get("a"))).intValue();
        int i3 = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzb;
                if (!zzbVar.b()) {
                    zzbVar.c(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zza(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbyd(zzckuVar, map).zza();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbxx(zzckuVar, map).zza();
                    return;
                }
                if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zzb(true);
                        return;
                    } else if (iIntValue != 7) {
                        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.e("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z2 = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzckuVar == null) {
            int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("AdWebView is null");
            return;
        }
        if ("portrait".equalsIgnoreCase(str)) {
            i3 = 7;
        } else if (!"landscape".equalsIgnoreCase(str)) {
            i3 = z2 ? -1 : 14;
        }
        zzckuVar.zzam(i3);
    }
}
