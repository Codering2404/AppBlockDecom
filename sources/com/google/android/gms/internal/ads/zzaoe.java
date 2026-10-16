package com.google.android.gms.internal.ads;

import android.graphics.Color;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoe {
    public final String zza;
    public final int zzb;
    public final Integer zzc;
    public final Integer zzd;
    public final float zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final int zzj;

    private zzaoe(String str, int i3, Integer num, Integer num2, float f3, boolean z2, boolean z3, boolean z4, boolean z5, int i4) {
        this.zza = str;
        this.zzb = i3;
        this.zzc = num;
        this.zzd = num2;
        this.zze = f3;
        this.zzf = z2;
        this.zzg = z3;
        this.zzh = z4;
        this.zzi = z5;
        this.zzj = i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0115 A[Catch: RuntimeException -> 0x00b8, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x00b8, blocks: (B:33:0x00be, B:35:0x00c4, B:39:0x00d4, B:41:0x00d8, B:45:0x00e7, B:47:0x00eb, B:51:0x00fc, B:53:0x0100, B:57:0x0111, B:59:0x0115, B:60:0x011d, B:68:0x013b, B:66:0x012e, B:28:0x009f, B:23:0x008b), top: B:73:0x0081, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzaoe zza(java.lang.String r20, com.google.android.gms.internal.ads.zzaoc r21) {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoe.zza(java.lang.String, com.google.android.gms.internal.ads.zzaoc):com.google.android.gms.internal.ads.zzaoe");
    }

    public static Integer zzb(String str) {
        try {
            long j3 = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            zzgtj.zza(j3 <= 4294967295L);
            return Integer.valueOf(Color.argb(zzhah.zza(((j3 >> 24) & 255) ^ 255), zzhah.zza(j3 & 255), zzhah.zza((j3 >> 8) & 255), zzhah.zza((j3 >> 16) & 255)));
        } catch (IllegalArgumentException e3) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
            sb.append("Failed to parse color expression: '");
            sb.append(str);
            sb.append("'");
            zzeg.zzd("SsaStyle", sb.toString(), e3);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzd(String str) {
        int i3;
        try {
            i3 = Integer.parseInt(str.trim());
        } catch (NumberFormatException unused) {
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return i3;
            default:
                zzeg.zzc("SsaStyle", "Ignoring unknown alignment: ".concat(String.valueOf(str)));
                return -1;
        }
    }

    private static boolean zze(String str) {
        try {
            int i3 = Integer.parseInt(str);
            return i3 == 1 || i3 == -1;
        } catch (NumberFormatException e3) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
            sb.append("Failed to parse boolean value: '");
            sb.append(str);
            sb.append("'");
            zzeg.zzd("SsaStyle", sb.toString(), e3);
            return false;
        }
    }
}
