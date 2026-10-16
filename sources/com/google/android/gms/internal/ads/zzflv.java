package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzflv {
    public static void zza(int i3, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 20);
        sb.append("Ad failed to load : ");
        sb.append(i3);
        String string = sb.toString();
        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e(string);
        com.google.android.gms.ads.internal.util.zze.l(str, th);
        if (i3 == 3) {
            return;
        }
        com.google.android.gms.ads.internal.zzt.l().zzh(th, str);
    }

    public static void zzb(Context context, boolean z2) {
        if (z2) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.e("This request is sent from a test device.");
            return;
        }
        com.google.android.gms.ads.internal.client.zzay.a();
        String strF = com.google.android.gms.ads.internal.util.client.zzf.f(context);
        StringBuilder sb = new StringBuilder(String.valueOf(strF).length() + 102);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(strF);
        sb.append("\")) to get test ads on this device.");
        String string = sb.toString();
        int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.e(string);
    }
}
