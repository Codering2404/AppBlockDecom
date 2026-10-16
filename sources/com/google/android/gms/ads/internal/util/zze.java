package com.google.android.gms.ads.internal.util;

import android.util.Log;
import com.google.android.gms.internal.ads.zzbks;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zze extends com.google.android.gms.ads.internal.util.client.zzo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f70328b = 0;

    public static void k(String str) {
        if (m()) {
            if (str == null || str.length() <= 4000) {
                Log.v("Ads", str);
                return;
            }
            boolean z2 = true;
            for (String str2 : com.google.android.gms.ads.internal.util.client.zzo.f70191a.zzd(str)) {
                if (z2) {
                    Log.v("Ads", str2);
                } else {
                    Log.v("Ads-cont", str2);
                }
                z2 = false;
            }
        }
    }

    public static void l(String str, Throwable th) {
        if (m()) {
            Log.v("Ads", str, th);
        }
    }

    public static boolean m() {
        return com.google.android.gms.ads.internal.util.client.zzo.j(2) && ((Boolean) zzbks.zza.zze()).booleanValue();
    }
}
