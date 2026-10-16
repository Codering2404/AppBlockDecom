package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbg {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzv[] zzd;
    private int zze;

    static {
        String str = zzfl.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbg(String str, zzv... zzvVarArr) {
        int length = zzvVarArr.length;
        int i3 = 1;
        zzgtj.zza(length > 0);
        this.zzb = str;
        this.zzd = zzvVarArr;
        this.zza = length;
        String str2 = zzvVarArr[0].zzp;
        this.zzc = TextUtils.isEmpty(str2) ? zzas.zzf(zzvVarArr[0].zzo) : zzas.zzf(str2);
        zzv zzvVar = zzvVarArr[0];
        String strZzc = zzc(zzvVar.zzd);
        int i4 = zzvVar.zzf | 16384;
        while (true) {
            zzv[] zzvVarArr2 = this.zzd;
            if (i3 >= zzvVarArr2.length) {
                return;
            }
            zzv zzvVar2 = zzvVarArr2[i3];
            String str3 = zzvVar2.zzd;
            if (!strZzc.equals(zzc(str3))) {
                zzd("languages", zzvVarArr2[0].zzd, str3, i3);
                return;
            } else {
                if (i4 != (zzvVar2.zzf | 16384)) {
                    zzd("role flags", Integer.toBinaryString(zzvVarArr2[0].zzf), Integer.toBinaryString(this.zzd[i3].zzf), i3);
                    return;
                }
                i3++;
            }
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i3) {
        int length = String.valueOf(str2).length();
        int length2 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(str.length() + 40 + length + 17 + length2 + 9 + String.valueOf(i3).length() + 1);
        sb.append("Different ");
        sb.append(str);
        sb.append(" combined in one TrackGroup: '");
        sb.append(str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i3);
        sb.append(")");
        zzeg.zzf("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbg.class == obj.getClass()) {
            zzbg zzbgVar = (zzbg) obj;
            if (this.zzb.equals(zzbgVar.zzb) && Arrays.equals(this.zzd, zzbgVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.zze;
        if (i3 != 0) {
            return i3;
        }
        int iHashCode = ((this.zzb.hashCode() + 527) * 31) + Arrays.hashCode(this.zzd);
        this.zze = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        String string = Arrays.toString(this.zzd);
        String str = this.zzb;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(string).length());
        sb.append(str);
        sb.append(": ");
        sb.append(string);
        return sb.toString();
    }

    public final zzv zza(int i3) {
        return this.zzd[i3];
    }

    public final int zzb(zzv zzvVar) {
        int i3 = 0;
        while (true) {
            zzv[] zzvVarArr = this.zzd;
            if (i3 >= zzvVarArr.length) {
                return -1;
            }
            if (zzvVar == zzvVarArr[i3]) {
                return i3;
            }
            i3++;
        }
    }
}
