package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbiq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zzu extends zzt {
    static final boolean l(int i3, int i4, int i5) {
        return Math.abs(i3 - i4) <= i5;
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final boolean d(Activity activity, Configuration configuration) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfZ)).booleanValue()) {
            return false;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgb)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        com.google.android.gms.ads.internal.client.zzay.a();
        int iE = com.google.android.gms.ads.internal.util.client.zzf.e(activity, configuration.screenHeightDp);
        int iE2 = com.google.android.gms.ads.internal.util.client.zzf.e(activity, configuration.screenWidthDp);
        WindowManager windowManager = (WindowManager) activity.getApplicationContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzt.g();
        DisplayMetrics displayMetricsG0 = zzs.g0(windowManager);
        int i3 = displayMetricsG0.heightPixels;
        int i4 = displayMetricsG0.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0;
        int iRound = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfX)).intValue();
        return (l(i3, iE + dimensionPixelSize, iRound) && l(i4, iE2, iRound)) ? false : true;
    }
}
