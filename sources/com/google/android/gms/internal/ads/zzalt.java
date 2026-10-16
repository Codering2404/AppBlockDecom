package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzalt {
    public static void zza(int i3, zzap zzapVar, zzt zztVar, zzap zzapVar2, zzap... zzapVarArr) {
        if (zzapVar2 == null) {
            zzapVar2 = new zzap(-9223372036854775807L, new zzao[0]);
        }
        if (zzapVar != null) {
            zzgwm zzgwmVarZzd = zzapVar.zzd(zzfv.class);
            int size = zzgwmVarZzd.size();
            for (int i4 = 0; i4 < size; i4++) {
                zzfv zzfvVar = (zzfv) zzgwmVarZzd.get(i4);
                if (!zzfvVar.zza.equals("com.android.capture.fps") || i3 == 2) {
                    zzapVar2 = zzapVar2.zzg(zzfvVar);
                }
            }
        }
        for (zzap zzapVar3 : zzapVarArr) {
            zzapVar2 = zzapVar2.zzf(zzapVar3);
        }
        if (zzapVar2.zza() > 0) {
            zztVar.zzl(zzapVar2);
        }
    }

    public static void zzb(int i3, zzagr zzagrVar, zzt zztVar) {
        if (i3 == 1 && zzagrVar.zzb()) {
            zztVar.zzJ(zzagrVar.zza);
            zztVar.zzK(zzagrVar.zzb);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x0281 A[Catch: all -> 0x0047, TryCatch #0 {all -> 0x0047, blocks: (B:9:0x0030, B:11:0x003b, B:15:0x004a, B:18:0x0056, B:21:0x0063, B:24:0x0070, B:27:0x007d, B:30:0x008b, B:32:0x0097, B:40:0x00b2, B:41:0x00d0, B:42:0x00e2, B:45:0x00ee, B:48:0x00fb, B:51:0x0108, B:54:0x0115, B:57:0x0122, B:60:0x012f, B:63:0x013c, B:66:0x0149, B:69:0x0156, B:72:0x0163, B:76:0x0174, B:78:0x017a, B:80:0x018e, B:81:0x0195, B:83:0x019c, B:88:0x01a7, B:93:0x01b3, B:137:0x0281, B:94:0x01c8, B:96:0x01cf, B:98:0x01db, B:99:0x01ef, B:112:0x0219, B:115:0x0226, B:118:0x0233, B:121:0x0240, B:124:0x024c, B:127:0x0258, B:130:0x0262, B:133:0x026e, B:136:0x027a, B:138:0x029e, B:139:0x02a5), top: B:144:0x0022 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzao zzc(com.google.android.gms.internal.ads.zzet r15) {
        /*
            Method dump skipped, instruction units count: 691
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalt.zzc(com.google.android.gms.internal.ads.zzet):com.google.android.gms.internal.ads.zzao");
    }

    private static zzajt zzd(int i3, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            return new zzajt(str, null, zzgwm.zzj(zzetVar.zzL(iZzB - 16)));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse text attribute: ".concat(zzfz.zze(i3)));
        return null;
    }

    private static zzajo zze(int i3, String str, zzet zzetVar, boolean z2, boolean z3) {
        int iZzf = zzf(zzetVar);
        if (z3) {
            iZzf = Math.min(1, iZzf);
        }
        if (iZzf >= 0) {
            return z2 ? new zzajt(str, null, zzgwm.zzj(Integer.toString(iZzf))) : new zzaji("und", str, Integer.toString(iZzf));
        }
        zzeg.zzc("MetadataUtil", "Failed to parse uint8 attribute: ".concat(zzfz.zze(i3)));
        return null;
    }

    private static int zzf(zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385) {
            zzetVar.zzk(8);
            int i3 = iZzB - 16;
            if (i3 == 1) {
                return zzetVar.zzs();
            }
            if (i3 == 2) {
                return zzetVar.zzt();
            }
            if (i3 == 3) {
                return zzetVar.zzx();
            }
            if (i3 == 4 && (zzetVar.zzn() & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
                return zzetVar.zzH();
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    private static zzajt zzg(int i3, String str, zzet zzetVar) {
        int iZzB = zzetVar.zzB();
        if (zzetVar.zzB() == 1684108385 && iZzB >= 22) {
            zzetVar.zzk(10);
            int iZzt = zzetVar.zzt();
            if (iZzt > 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(iZzt).length());
                sb.append(iZzt);
                String string = sb.toString();
                int iZzt2 = zzetVar.zzt();
                if (iZzt2 > 0) {
                    StringBuilder sb2 = new StringBuilder(string.length() + 1 + String.valueOf(iZzt2).length());
                    sb2.append(string);
                    sb2.append("/");
                    sb2.append(iZzt2);
                    string = sb2.toString();
                }
                return new zzajt(str, null, zzgwm.zzj(string));
            }
        }
        zzeg.zzc("MetadataUtil", "Failed to parse index/count attribute: ".concat(zzfz.zze(i3)));
        return null;
    }
}
