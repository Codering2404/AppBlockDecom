package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzavp extends zzbdq implements zzbey {
    private static final zzavp zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbea zze = zzbdq.s();
    private zzavy zzf;

    static {
        zzavp zzavpVar = new zzavp();
        zzg = zzavpVar;
        zzbdq.D(zzavp.class, zzavpVar);
    }

    private zzavp() {
    }

    public static zzavp H() {
        return zzg;
    }

    public final List G() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zze", zzavt.class, "zzf"});
        }
        if (i4 == 3) {
            return new zzavp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzavo(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzavp.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
