package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class zzffc implements Callable {
    static final /* synthetic */ zzffc zza = new zzffc();

    private /* synthetic */ zzffc() {
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        HashMap map = new HashMap();
        String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzax);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzay)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    map.put(str2, com.google.android.gms.ads.internal.util.zzch.a(str2));
                }
            }
        }
        return new zzffe(map);
    }
}
