package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zztu extends zznd implements zzoj {
    private static final zztu zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zztu zztuVar = new zztu();
        zzb = zztuVar;
        zznd.zzI(zztu.class, zztuVar);
    }

    private zztu() {
    }

    public static zztu zzg(InputStream inputStream) throws IOException {
        return (zztu) zznd.zzw(zzb, inputStream);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zztu();
        }
        zzug zzugVar = null;
        if (i4 == 4) {
            return new zztt(zzugVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        if (i4 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zztu.class) {
            try {
                zzmyVar = zzd;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzb);
                    zzd = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }

    public final zztv zzi() {
        zztv zztvVarZzb = zztv.zzb(this.zzg);
        return zztvVarZzb == null ? zztv.UNRECOGNIZED : zztvVarZzb;
    }
}
