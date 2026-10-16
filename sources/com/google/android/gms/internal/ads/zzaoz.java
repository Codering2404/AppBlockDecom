package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoz {
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final Set zzd;

    private zzaoz(String str, int i3, String str2, Set set) {
        this.zzb = i3;
        this.zza = str;
        this.zzc = str2;
        this.zzd = set;
    }

    public static zzaoz zza(String str, int i3) {
        String str2;
        String strTrim = str.trim();
        zzgtj.zza(!strTrim.isEmpty());
        int iIndexOf = strTrim.indexOf(" ");
        if (iIndexOf == -1) {
            str2 = "";
        } else {
            String strTrim2 = strTrim.substring(iIndexOf).trim();
            strTrim = strTrim.substring(0, iIndexOf);
            str2 = strTrim2;
        }
        String str3 = zzfl.zza;
        String[] strArrSplit = strTrim.split("\\.", -1);
        String str4 = strArrSplit[0];
        HashSet hashSet = new HashSet();
        for (int i4 = 1; i4 < strArrSplit.length; i4++) {
            hashSet.add(strArrSplit[i4]);
        }
        return new zzaoz(str4, i3, str2, hashSet);
    }

    public static zzaoz zzb() {
        return new zzaoz("", 0, "", Collections.EMPTY_SET);
    }
}
