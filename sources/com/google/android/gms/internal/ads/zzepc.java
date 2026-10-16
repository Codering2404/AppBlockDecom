package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzepc {
    final String zza;
    final String zzb;
    int zzc;
    long zzd;
    final Integer zze;

    zzepc(String str, String str2, int i3, long j3, Integer num) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = i3;
        this.zzd = j3;
        this.zze = num;
    }

    public final String toString() {
        Integer num;
        String str = this.zza;
        int i3 = this.zzc;
        long j3 = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(i3).length() + 1 + String.valueOf(j3).length());
        sb.append(str);
        sb.append(".");
        sb.append(i3);
        sb.append(".");
        sb.append(j3);
        String string = sb.toString();
        String str2 = this.zzb;
        if (!TextUtils.isEmpty(str2)) {
            StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(str2).length());
            sb2.append(string);
            sb2.append(".");
            sb2.append(str2);
            string = sb2.toString();
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcn)).booleanValue() || (num = this.zze) == null || TextUtils.isEmpty(str2)) {
            return string;
        }
        StringBuilder sb3 = new StringBuilder(string.length() + 1 + num.toString().length());
        sb3.append(string);
        sb3.append(".");
        sb3.append(num);
        return sb3.toString();
    }
}
