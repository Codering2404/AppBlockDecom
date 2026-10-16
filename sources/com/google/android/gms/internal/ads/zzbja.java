package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbja extends zzbjb {
    zzbja() {
    }

    private static final String zzb(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i4 < str.length() && str.charAt(i4) == ',') {
            i4++;
        }
        while (length > 0) {
            int i5 = length - 1;
            if (str.charAt(i5) != ',') {
                break;
            }
            length = i5;
        }
        if (length < i4) {
            return null;
        }
        if (i4 != 0) {
            i3 = i4;
        } else if (length == str.length()) {
            return str;
        }
        return str.substring(i3, length);
    }

    @Override // com.google.android.gms.internal.ads.zzbjb
    public final String zza(String str, String str2) {
        String strZzb = zzb(str);
        String strZzb2 = zzb(str2);
        if (TextUtils.isEmpty(strZzb)) {
            return strZzb2;
        }
        if (TextUtils.isEmpty(strZzb2)) {
            return strZzb;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(strZzb).length() + 1 + String.valueOf(strZzb2).length());
        sb.append(strZzb);
        sb.append(",");
        sb.append(strZzb2);
        return sb.toString();
    }
}
