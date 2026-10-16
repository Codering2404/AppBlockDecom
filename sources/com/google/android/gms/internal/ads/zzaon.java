package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaon {
    public static zzaoo zza(zzaoo zzaooVar, String[] strArr, Map map) {
        int length;
        int i3 = 0;
        if (zzaooVar == null) {
            if (strArr == null) {
                return null;
            }
            int length2 = strArr.length;
            if (length2 == 1) {
                return (zzaoo) map.get(strArr[0]);
            }
            if (length2 > 1) {
                zzaoo zzaooVar2 = new zzaoo();
                while (i3 < length2) {
                    zzaooVar2.zzr((zzaoo) map.get(strArr[i3]));
                    i3++;
                }
                return zzaooVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                zzaooVar.zzr((zzaoo) map.get(strArr[0]));
                return zzaooVar;
            }
            if (strArr != null && (length = strArr.length) > 1) {
                while (i3 < length) {
                    zzaooVar.zzr((zzaoo) map.get(strArr[i3]));
                    i3++;
                }
            }
        }
        return zzaooVar;
    }
}
