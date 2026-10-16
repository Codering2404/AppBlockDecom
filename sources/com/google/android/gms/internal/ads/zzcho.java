package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcho {
    private static final boolean zza;
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;
    private final zzbjc zze;
    private final zzbjf zzf;
    private final com.google.android.gms.ads.internal.util.zzbf zzg;
    private final long[] zzh;
    private final String[] zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private boolean zzn;
    private zzcgt zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;

    static {
        zza = com.google.android.gms.ads.internal.client.zzay.h().nextInt(100) < ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoh)).intValue();
    }

    public zzcho(Context context, VersionInfoParcel versionInfoParcel, String str, zzbjf zzbjfVar, zzbjc zzbjcVar) {
        com.google.android.gms.ads.internal.util.zzbe zzbeVar = new com.google.android.gms.ads.internal.util.zzbe();
        zzbeVar.a("min_1", Double.MIN_VALUE, 1.0d);
        zzbeVar.a("1_5", 1.0d, 5.0d);
        zzbeVar.a("5_10", 5.0d, 10.0d);
        zzbeVar.a("10_20", 10.0d, 20.0d);
        zzbeVar.a("20_30", 20.0d, 30.0d);
        zzbeVar.a("30_max", 30.0d, Double.MAX_VALUE);
        this.zzg = zzbeVar.b();
        this.zzj = false;
        this.zzk = false;
        this.zzl = false;
        this.zzm = false;
        this.zzr = -1L;
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zzc = str;
        this.zzf = zzbjfVar;
        this.zze = zzbjcVar;
        String str2 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzao);
        if (str2 == null) {
            this.zzi = new String[0];
            this.zzh = new long[0];
            return;
        }
        String[] strArrSplit = TextUtils.split(str2, ",");
        int length = strArrSplit.length;
        this.zzi = new String[length];
        this.zzh = new long[length];
        for (int i3 = 0; i3 < strArrSplit.length; i3++) {
            try {
                this.zzh[i3] = Long.parseLong(strArrSplit[i3]);
            } catch (NumberFormatException e3) {
                int i4 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.g("Unable to parse frame hash target time number.", e3);
                this.zzh[i3] = -1;
            }
        }
    }

    public final void zza(zzcgt zzcgtVar) {
        zzbjf zzbjfVar = this.zzf;
        zzbix.zza(zzbjfVar, this.zze, "vpc2");
        this.zzj = true;
        zzbjfVar.zzd("vpn", zzcgtVar.zza());
        this.zzo = zzcgtVar;
    }

    public final void zzb() {
        if (!this.zzj || this.zzk) {
            return;
        }
        zzbix.zza(this.zzf, this.zze, "vfr2");
        this.zzk = true;
    }

    public final void zzc() {
        if (!zza || this.zzp) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("type", "native-player-metrics");
        bundle.putString("request", this.zzc);
        bundle.putString("player", this.zzo.zza());
        for (com.google.android.gms.ads.internal.util.zzbd zzbdVar : this.zzg.b()) {
            String str = zzbdVar.f70265a;
            String strValueOf = String.valueOf(str);
            bundle.putString("fps_c_".concat(strValueOf), Integer.toString(zzbdVar.f70269e));
            String strValueOf2 = String.valueOf(str);
            bundle.putString("fps_p_".concat(strValueOf2), Double.toString(zzbdVar.f70268d));
        }
        int i3 = 0;
        while (true) {
            long[] jArr = this.zzh;
            if (i3 >= jArr.length) {
                com.google.android.gms.ads.internal.zzt.g().R(this.zzb, this.zzd.f70149a, "gmob-apps", bundle, true);
                this.zzp = true;
                return;
            }
            String str2 = this.zzi[i3];
            if (str2 != null) {
                Long lValueOf = Long.valueOf(jArr[i3]);
                new StringBuilder(lValueOf.toString().length() + 3);
                bundle.putString("fh_".concat(lValueOf.toString()), str2);
            }
            i3++;
        }
    }

    public final void zzd(zzcgt zzcgtVar) {
        if (this.zzl && !this.zzm) {
            if (com.google.android.gms.ads.internal.util.zze.m() && !this.zzm) {
                com.google.android.gms.ads.internal.util.zze.k("VideoMetricsMixin first frame");
            }
            zzbix.zza(this.zzf, this.zze, "vff2");
            this.zzm = true;
        }
        long jB = com.google.android.gms.ads.internal.zzt.o().b();
        if (this.zzn && this.zzq && this.zzr != -1) {
            this.zzg.a(TimeUnit.SECONDS.toNanos(1L) / (jB - this.zzr));
        }
        this.zzq = this.zzn;
        this.zzr = jB;
        long jLongValue = ((Long) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzap)).longValue();
        long jZzh = zzcgtVar.zzh();
        int i3 = 0;
        while (true) {
            String[] strArr = this.zzi;
            if (i3 >= strArr.length) {
                return;
            }
            if (strArr[i3] == null && jLongValue > Math.abs(jZzh - this.zzh[i3])) {
                int i4 = 8;
                Bitmap bitmap = zzcgtVar.getBitmap(8, 8);
                long j3 = 63;
                long j4 = 0;
                int i5 = 0;
                while (i5 < i4) {
                    int i6 = 0;
                    while (i6 < i4) {
                        int pixel = bitmap.getPixel(i6, i5);
                        j4 |= ((Color.blue(pixel) + Color.red(pixel)) + Color.green(pixel) > 128 ? 1L : 0L) << ((int) j3);
                        j3--;
                        i6++;
                        i4 = 8;
                    }
                    i5++;
                    i4 = 8;
                }
                strArr[i3] = String.format("%016X", Long.valueOf(j4));
                return;
            }
            i3++;
        }
    }

    public final void zze() {
        this.zzn = true;
        if (!this.zzk || this.zzl) {
            return;
        }
        zzbix.zza(this.zzf, this.zze, "vfp2");
        this.zzl = true;
    }

    public final void zzf() {
        this.zzn = false;
    }
}
