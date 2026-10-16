package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzfz {
    public final int zzd;

    public static String zze(int i3) {
        char c3 = (char) ((i3 >> 24) & 255);
        int length = String.valueOf(c3).length();
        char c4 = (char) ((i3 >> 16) & 255);
        int length2 = String.valueOf(c4).length();
        char c5 = (char) ((i3 >> 8) & 255);
        char c6 = (char) (i3 & 255);
        StringBuilder sb = new StringBuilder(length + length2 + String.valueOf(c5).length() + String.valueOf(c6).length());
        sb.append(c3);
        sb.append(c4);
        sb.append(c5);
        sb.append(c6);
        return sb.toString();
    }

    public String toString() {
        return zze(this.zzd);
    }
}
