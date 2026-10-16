package com.google.android.gms.tagmanager;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcx extends zzbt {
    private static final String zza = com.google.android.gms.internal.gtm.zza.JOINER.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ITEM_SEPARATOR.toString();
    private static final String zzd = com.google.android.gms.internal.gtm.zzb.KEY_VALUE_SEPARATOR.toString();
    private static final String zze = com.google.android.gms.internal.gtm.zzb.ESCAPE.toString();

    public zzcx() {
        super(zza, zzb);
    }

    private static final void zzc(Set set, String str) {
        for (int i3 = 0; i3 < str.length(); i3++) {
            set.add(Character.valueOf(str.charAt(i3)));
        }
    }

    private static final String zzd(String str, int i3, Set set) {
        int i4 = i3 - 1;
        if (i4 == 1) {
            try {
                return zzfx.zza(str);
            } catch (UnsupportedEncodingException e3) {
                Log.e("GoogleTagManager", "Joiner: unsupported encoding", e3);
                return str;
            }
        }
        if (i4 != 2) {
            return str;
        }
        String strReplace = str.replace("\\", "\\\\");
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String string = ((Character) it.next()).toString();
            strReplace = strReplace.replace(string, "\\".concat(String.valueOf(string)));
        }
        return strReplace;
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final com.google.android.gms.internal.gtm.zzam zza(Map map) {
        int i3;
        com.google.android.gms.internal.gtm.zzam zzamVar = (com.google.android.gms.internal.gtm.zzam) map.get(zzb);
        if (zzamVar == null) {
            return zzfu.zza();
        }
        com.google.android.gms.internal.gtm.zzam zzamVar2 = (com.google.android.gms.internal.gtm.zzam) map.get(zzc);
        String strZzm = zzamVar2 != null ? zzfu.zzm(zzfu.zzk(zzamVar2)) : "";
        com.google.android.gms.internal.gtm.zzam zzamVar3 = (com.google.android.gms.internal.gtm.zzam) map.get(zzd);
        String strZzm2 = zzamVar3 != null ? zzfu.zzm(zzfu.zzk(zzamVar3)) : "=";
        com.google.android.gms.internal.gtm.zzam zzamVar4 = (com.google.android.gms.internal.gtm.zzam) map.get(zze);
        HashSet hashSet = null;
        boolean z2 = true;
        if (zzamVar4 != null) {
            String strZzm3 = zzfu.zzm(zzfu.zzk(zzamVar4));
            if ("url".equals(strZzm3)) {
                i3 = 2;
            } else {
                if (!"backslash".equals(strZzm3)) {
                    Log.e("GoogleTagManager", "Joiner: unsupported escape type: ".concat(String.valueOf(strZzm3)));
                    return zzfu.zza();
                }
                hashSet = new HashSet();
                zzc(hashSet, strZzm);
                zzc(hashSet, strZzm2);
                hashSet.remove('\\');
                i3 = 3;
            }
        } else {
            i3 = 1;
        }
        StringBuilder sb = new StringBuilder();
        com.google.android.gms.internal.gtm.zzat zzatVar = com.google.android.gms.internal.gtm.zzat.STRING;
        int iOrdinal = zzamVar.zzh().ordinal();
        if (iOrdinal == 1) {
            for (com.google.android.gms.internal.gtm.zzam zzamVar5 : zzamVar.zzs()) {
                if (!z2) {
                    sb.append(strZzm);
                }
                sb.append(zzd(zzfu.zzm(zzfu.zzk(zzamVar5)), i3, hashSet));
                z2 = false;
            }
        } else if (iOrdinal != 2) {
            sb.append(zzd(zzfu.zzm(zzfu.zzk(zzamVar)), i3, hashSet));
        } else {
            for (int i4 = 0; i4 < zzamVar.zzc(); i4++) {
                if (i4 > 0) {
                    sb.append(strZzm);
                }
                String strZzm4 = zzfu.zzm(zzfu.zzk(zzamVar.zzl(i4)));
                String strZzm5 = zzfu.zzm(zzfu.zzk(zzamVar.zzm(i4)));
                sb.append(zzd(strZzm4, i3, hashSet));
                sb.append(strZzm2);
                sb.append(zzd(strZzm5, i3, hashSet));
            }
        }
        return zzfu.zzb(sb.toString());
    }

    @Override // com.google.android.gms.tagmanager.zzbt
    public final boolean zzb() {
        return true;
    }
}
