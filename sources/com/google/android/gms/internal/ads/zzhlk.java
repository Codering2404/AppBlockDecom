package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhlk extends zzibm {
    public static final zzibg zza(zzicd zzicdVar) throws IOException {
        String strZzh;
        int iZzm = zzicdVar.zzm();
        zzibg zzibgVarZzc = zzc(zzicdVar, iZzm);
        if (zzibgVarZzc == null) {
            return zzb(zzicdVar, iZzm);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (zzicdVar.zzf()) {
                if (zzibgVarZzc instanceof zzibi) {
                    strZzh = zzicdVar.zzh();
                    if (!zzhlm.zza(strZzh)) {
                        throw new IOException("illegal characters in string");
                    }
                } else {
                    strZzh = null;
                }
                int iZzm2 = zzicdVar.zzm();
                zzibg zzibgVarZzc2 = zzc(zzicdVar, iZzm2);
                zzibg zzibgVarZzb = zzibgVarZzc2 == null ? zzb(zzicdVar, iZzm2) : zzibgVarZzc2;
                if (zzibgVarZzc instanceof zzibf) {
                    ((zzibf) zzibgVarZzc).zza(zzibgVarZzb);
                } else {
                    zzibi zzibiVar = (zzibi) zzibgVarZzc;
                    if (zzibiVar.zzc(strZzh)) {
                        throw new IOException("duplicate key: ".concat(String.valueOf(strZzh)));
                    }
                    zzibiVar.zza(strZzh, zzibgVarZzb);
                }
                if (zzibgVarZzc2 != null) {
                    arrayDeque.addLast(zzibgVarZzc);
                    if (arrayDeque.size() > 100) {
                        throw new IOException("too many recursions");
                    }
                    zzibgVarZzc = zzibgVarZzb;
                } else {
                    continue;
                }
            } else {
                if (zzibgVarZzc instanceof zzibf) {
                    zzicdVar.zzc();
                } else {
                    zzicdVar.zze();
                }
                if (arrayDeque.isEmpty()) {
                    return zzibgVarZzc;
                }
                zzibgVarZzc = (zzibg) arrayDeque.removeLast();
            }
        }
    }

    private static final zzibg zzb(zzicd zzicdVar, int i3) throws IOException {
        int i4 = i3 - 1;
        if (i4 == 5) {
            String strZzi = zzicdVar.zzi();
            if (zzhlm.zza(strZzi)) {
                return new zzibk(strZzi);
            }
            throw new IOException("illegal characters in string");
        }
        if (i4 == 6) {
            return new zzibk(new zzhll(zzicdVar.zzi()));
        }
        if (i4 == 7) {
            return new zzibk(Boolean.valueOf(zzicdVar.zzj()));
        }
        if (i4 != 8) {
            throw new IllegalStateException("Unexpected token: ".concat(zzice.zza(i3)));
        }
        zzicdVar.zzk();
        return zzibh.zza;
    }

    @Nullable
    private static final zzibg zzc(zzicd zzicdVar, int i3) throws IOException {
        int i4 = i3 - 1;
        if (i4 == 0) {
            zzicdVar.zzb();
            return new zzibf();
        }
        if (i4 != 2) {
            return null;
        }
        zzicdVar.zzd();
        return new zzibi();
    }
}
