package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzfac implements Callable {
    static final /* synthetic */ zzfac zza = new zzfac();

    private /* synthetic */ zzfac() {
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        Bundle bundle = new Bundle();
        Runtime runtime = Runtime.getRuntime();
        bundle.putLong("runtime_free", runtime.freeMemory());
        bundle.putLong("runtime_max", runtime.maxMemory());
        bundle.putLong("runtime_total", runtime.totalMemory());
        bundle.putInt("web_view_count", com.google.android.gms.ads.internal.zzt.l().zzl());
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpP)).booleanValue()) {
            ActivityManager.MemoryInfo memoryInfoZzw = com.google.android.gms.ads.internal.zzt.l().zzw();
            if (memoryInfoZzw != null) {
                if (PlatformVersion.j()) {
                    bundle.putLong("a_ad_mem", memoryInfoZzw.advertisedMem);
                }
                bundle.putLong("a_total", memoryInfoZzw.totalMem);
                bundle.putLong("a_avai", memoryInfoZzw.availMem);
                bundle.putLong("a_threshold", memoryInfoZzw.threshold);
                bundle.putBoolean("a_is_low_mem", memoryInfoZzw.lowMemory);
            }
            bundle.putLong("runtime_avai_processors", runtime.availableProcessors());
        }
        return new zzfae(bundle);
    }
}
