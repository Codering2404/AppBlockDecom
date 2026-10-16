package com.google.android.gms.internal.ads;

import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhe {
    public static int zza(int i3) {
        int i4 = 0;
        while (i3 > 0) {
            i3 >>>= 1;
            i4++;
        }
        return i4;
    }

    public static zzhb zzb(zzet zzetVar, boolean z2, boolean z3) throws zzat {
        if (z2) {
            zzc(3, zzetVar, false);
        }
        String strZzK = zzetVar.zzK((int) zzetVar.zzA(), StandardCharsets.UTF_8);
        int length = strZzK.length();
        long jZzA = zzetVar.zzA();
        String[] strArr = new String[(int) jZzA];
        int length2 = length + 15;
        for (int i3 = 0; i3 < jZzA; i3++) {
            String strZzK2 = zzetVar.zzK((int) zzetVar.zzA(), StandardCharsets.UTF_8);
            strArr[i3] = strZzK2;
            length2 = length2 + 4 + strZzK2.length();
        }
        if (z3 && (zzetVar.zzs() & 1) == 0) {
            throw zzat.zzb("framing bit expected to be set", null);
        }
        return new zzhb(strZzK, strArr, length2 + 1);
    }

    public static boolean zzc(int i3, zzet zzetVar, boolean z2) throws zzat {
        if (zzetVar.zzd() < 7) {
            if (z2) {
                return false;
            }
            int iZzd = zzetVar.zzd();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzd).length() + 18);
            sb.append("too short header: ");
            sb.append(iZzd);
            throw zzat.zzb(sb.toString(), null);
        }
        if (zzetVar.zzs() != i3) {
            if (z2) {
                return false;
            }
            throw zzat.zzb("expected header type ".concat(String.valueOf(Integer.toHexString(i3))), null);
        }
        if (zzetVar.zzs() == 118 && zzetVar.zzs() == 111 && zzetVar.zzs() == 114 && zzetVar.zzs() == 98 && zzetVar.zzs() == 105 && zzetVar.zzs() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw zzat.zzb("expected characters 'vorbis'", null);
    }
}
