package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoa {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzaoa(int i3, int i4, int i5, int i6, int i7, int i8) {
        this.zza = i3;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = i7;
        this.zzf = i8;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static zzaoa zza(String str) {
        zzgtj.zza(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i3 = 0;
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i3 >= length) {
                if (i5 == -1 || i6 == -1 || i8 == -1) {
                    return null;
                }
                return new zzaoa(i4, i5, i6, i7, i8, length);
            }
            String strZza = zzgss.zza(strArrSplit[i3].trim());
            switch (strZza.hashCode()) {
                case 100571:
                    if (strZza.equals("end")) {
                        i6 = i3;
                    }
                    break;
                case 3556653:
                    if (strZza.equals("text")) {
                        i8 = i3;
                    }
                    break;
                case 102749521:
                    if (strZza.equals("layer")) {
                        i4 = i3;
                    }
                    break;
                case 109757538:
                    if (strZza.equals("start")) {
                        i5 = i3;
                    }
                    break;
                case 109780401:
                    if (strZza.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        i7 = i3;
                    }
                    break;
            }
            i3++;
        }
    }
}
