package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.IntentFilter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfwh {
    private static int zza = 2;

    public static void zza(Context context) {
        context.registerReceiver(new zzfwg(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }

    public static int zzb() {
        if (zzfwd.zzb() != zzfuq.CTV) {
            return 2;
        }
        return zza;
    }
}
