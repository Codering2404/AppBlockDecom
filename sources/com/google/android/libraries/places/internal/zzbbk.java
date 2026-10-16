package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbbk extends zzbdq implements zzbey {
    private static final zzbbk zzf;
    private static volatile zzbff zzg;
    private zzbea zzb = zzbdq.s();
    private zzbea zze = zzbdq.s();

    static {
        zzbbk zzbbkVar = new zzbbk();
        zzf = zzbbkVar;
        zzbdq.D(zzbbk.class, zzbbkVar);
    }

    private zzbbk() {
    }

    public static zzbbk I() {
        return zzf;
    }

    public final List G() {
        return this.zzb;
    }

    public final List H() {
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
            return zzbdq.m(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", new Object[]{"zzb", zzbai.class, "zze", zzbbc.class});
        }
        if (i4 == 3) {
            return new zzbbk();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbbj(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzg;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbbk.class) {
            try {
                zzbdlVar = zzg;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzf);
                    zzg = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
