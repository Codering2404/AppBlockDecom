package com.google.android.libraries.places.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaxy extends zzbdq implements zzbey {
    private static final zzaxy zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbea zze = zzbdq.s();
    private zzbea zzf = zzbdq.s();

    static {
        zzaxy zzaxyVar = new zzaxy();
        zzg = zzaxyVar;
        zzbdq.D(zzaxy.class, zzaxyVar);
    }

    private zzaxy() {
    }

    public static zzaxy I() {
        return zzg;
    }

    public final int G() {
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
            return zzbdq.m(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u0004\u0002\u001b\u0003\u001b", new Object[]{"zzb", "zze", zzaxv.class, "zzf", zzaxx.class});
        }
        if (i4 == 3) {
            return new zzaxy();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaxt(bArr);
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
        synchronized (zzaxy.class) {
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
