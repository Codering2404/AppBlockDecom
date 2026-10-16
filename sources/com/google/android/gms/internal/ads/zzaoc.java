package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoc {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzaoc(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = i8;
        this.zzg = i9;
        this.zzh = i10;
        this.zzi = i11;
        this.zzj = i12;
        this.zzk = i13;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzaoc zza(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i3 >= length) {
                if (i4 != -1) {
                    return new zzaoc(i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, length);
                }
                return null;
            }
            String strZza = zzgss.zza(strArrSplit[i3].trim());
            switch (strZza.hashCode()) {
                case -1178781136:
                    if (strZza.equals("italic")) {
                        i10 = i3;
                    }
                    break;
                case -1026963764:
                    if (strZza.equals("underline")) {
                        i11 = i3;
                    }
                    break;
                case -192095652:
                    if (strZza.equals("strikeout")) {
                        i12 = i3;
                    }
                    break;
                case -70925746:
                    if (strZza.equals("primarycolour")) {
                        i6 = i3;
                    }
                    break;
                case 3029637:
                    if (strZza.equals("bold")) {
                        i9 = i3;
                    }
                    break;
                case 3373707:
                    if (strZza.equals("name")) {
                        i4 = i3;
                    }
                    break;
                case 366554320:
                    if (strZza.equals("fontsize")) {
                        i8 = i3;
                    }
                    break;
                case 767321349:
                    if (strZza.equals("borderstyle")) {
                        i13 = i3;
                    }
                    break;
                case 1767875043:
                    if (strZza.equals("alignment")) {
                        i5 = i3;
                    }
                    break;
                case 1988365454:
                    if (strZza.equals("outlinecolour")) {
                        i7 = i3;
                    }
                    break;
            }
            i3++;
        }
    }
}
