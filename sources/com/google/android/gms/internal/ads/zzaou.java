package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaou {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzet zzc = new zzet();
    private final StringBuilder zzd = new StringBuilder();

    static void zzb(zzet zzetVar) {
        while (true) {
            for (boolean z2 = true; zzetVar.zzd() > 0 && z2; z2 = false) {
                char c3 = (char) zzetVar.zzi()[zzetVar.zzg()];
                if (c3 == '\t' || c3 == '\n' || c3 == '\f' || c3 == '\r' || c3 == ' ') {
                    zzetVar.zzk(1);
                } else {
                    int iZzg = zzetVar.zzg();
                    int iZze = zzetVar.zze();
                    byte[] bArrZzi = zzetVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i3 = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i4 = iZzg + 2;
                            if (bArrZzi[i3] == 42) {
                                while (true) {
                                    int i5 = i4 + 1;
                                    if (i5 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i4]) == '*' && ((char) bArrZzi[i5]) == '/') {
                                        iZze = i4 + 2;
                                        i4 = iZze;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                zzetVar.zzk(iZze - zzetVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    static String zzc(zzet zzetVar, StringBuilder sb) {
        zzb(zzetVar);
        if (zzetVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzetVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzetVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzet zzetVar, StringBuilder sb) {
        boolean z2;
        char c3;
        sb.setLength(0);
        int iZzg = zzetVar.zzg();
        int iZze = zzetVar.zze();
        loop0: while (true) {
            for (false; iZzg < iZze && !z2; true) {
                c3 = (char) zzetVar.zzi()[iZzg];
                z2 = (c3 < 'A' || c3 > 'Z') && (c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_');
            }
            sb.append(c3);
            iZzg++;
        }
        zzetVar.zzk(iZzg - zzetVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x02fd, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(com.google.android.gms.internal.ads.zzet r18) {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaou.zza(com.google.android.gms.internal.ads.zzet):java.util.List");
    }
}
