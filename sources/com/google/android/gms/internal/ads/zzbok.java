package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbok implements zzbpq {
    zzbok() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcku zzckuVar = (zzcku) obj;
        WindowManager windowManager = (WindowManager) zzckuVar.getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzt.g();
        DisplayMetrics displayMetricsG0 = com.google.android.gms.ads.internal.util.zzs.g0(windowManager);
        int i3 = displayMetricsG0.widthPixels;
        int i4 = displayMetricsG0.heightPixels;
        int[] iArr = new int[2];
        HashMap map2 = new HashMap();
        ((View) zzckuVar).getLocationInWindow(iArr);
        map2.put("xInPixels", Integer.valueOf(iArr[0]));
        map2.put("yInPixels", Integer.valueOf(iArr[1]));
        map2.put("windowWidthInPixels", Integer.valueOf(i3));
        map2.put("windowHeightInPixels", Integer.valueOf(i4));
        zzckuVar.zze("locationReady", map2);
        int i5 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("GET LOCATION COMPILED");
    }
}
