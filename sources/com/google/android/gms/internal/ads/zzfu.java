package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfu {
    public final String zza;

    private zzfu(int i3, int i4, String str) {
        this.zza = str;
    }

    public static zzfu zza(zzet zzetVar) {
        String str;
        zzetVar.zzk(2);
        int iZzs = zzetVar.zzs();
        int i3 = iZzs >> 1;
        int i4 = iZzs & 1;
        int iZzs2 = zzetVar.zzs() >> 3;
        if (i3 == 4 || i3 == 5 || i3 == 7 || i3 == 8) {
            str = "dvhe";
        } else if (i3 == 9) {
            str = "dvav";
        } else {
            if (i3 != 10) {
                return null;
            }
            str = "dav1";
        }
        int i5 = iZzs2 | (i4 << 5);
        String str2 = i3 < 10 ? ".0" : ".";
        int length = str2.length() + 4;
        int length2 = String.valueOf(i3).length();
        int length3 = String.valueOf(i5).length();
        String str3 = i5 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(length + length2 + str3.length() + length3);
        sb.append(str);
        sb.append(str2);
        sb.append(i3);
        sb.append(str3);
        sb.append(i5);
        return new zzfu(i3, i5, sb.toString());
    }
}
