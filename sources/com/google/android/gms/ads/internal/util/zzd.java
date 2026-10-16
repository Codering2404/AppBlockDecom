package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.ads.zzbkm;
import com.google.android.gms.internal.ads.zzcfr;
import com.google.android.gms.internal.ads.zzcfu;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd {
    public static void a(Context context) {
        int i3 = com.google.android.gms.ads.internal.util.client.zzl.f70182g;
        if (((Boolean) zzbkm.zza.zze()).booleanValue()) {
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) == 0 || com.google.android.gms.ads.internal.util.client.zzl.i()) {
                    return;
                }
                ListenableFuture listenableFutureZzb = new zzc(context).zzb();
                int i4 = zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.e("Updating ad debug logging enablement.");
                zzcfu.zza(listenableFutureZzb, "AdDebugLogUpdater.updateEnablement", zzcfr.zzh);
            } catch (Exception e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Fail to determine debug setting.", e3);
            }
        }
    }
}
