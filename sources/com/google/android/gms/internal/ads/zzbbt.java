package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbbt {
    private long zza = -1;
    private long zzb = -1;
    private long zzc = -1;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;

    private static boolean zzl(View view) {
        try {
            if (view.getClass().getName().contains("DebugGestureViewWrapper")) {
                view = ((ViewGroup) view).getChildAt(0);
            }
            Object objInvoke = view.getClass().getMethod("getAdConfiguration", null).invoke(view, null);
            Integer num = (Integer) objInvoke.getClass().getField("adType").get(objInvoke);
            num.intValue();
            String str = (String) objInvoke.getClass().getMethod("adTypeToString", Integer.TYPE).invoke(null, num);
            if (str.contains("INTERSTITIAL") || str.contains("APP_OPEN")) {
                return true;
            }
            return str.contains("REWARDED");
        } catch (ReflectiveOperationException | SecurityException unused) {
            return false;
        }
    }

    private static DisplayMetrics zzm(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            defaultDisplay.getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (NoSuchMethodError unused) {
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        }
    }

    public final void zza() {
        this.zzb = this.zza;
        this.zza = SystemClock.uptimeMillis();
    }

    public final void zzb(Context context, View view) {
        this.zzd = this.zzc;
        this.zzc = SystemClock.uptimeMillis();
        long j3 = this.zze;
        if (j3 != -1) {
            this.zzf = j3;
        }
        DisplayMetrics displayMetricsZzm = zzm(context);
        int i3 = displayMetricsZzm.widthPixels * displayMetricsZzm.heightPixels;
        if (view != null) {
            int iMin = Math.min(view.getWidth(), displayMetricsZzm.widthPixels) * Math.min(view.getHeight(), displayMetricsZzm.heightPixels);
            if (iMin + iMin >= i3 || (iMin == 0 && zzl(view))) {
                this.zze = this.zzc;
                return;
            }
        }
        this.zze = -1L;
    }

    public final void zzc() {
        this.zzh = this.zzg;
        this.zzg = SystemClock.uptimeMillis();
    }

    public final long zzd() {
        return this.zzb;
    }

    public final long zze() {
        return this.zza;
    }

    public final long zzf() {
        return this.zzc;
    }

    public final long zzg() {
        return this.zzd;
    }

    public final long zzh() {
        return this.zzf;
    }

    public final long zzi() {
        return this.zze;
    }

    public final long zzj() {
        return this.zzg;
    }

    public final long zzk() {
        return this.zzh;
    }
}
