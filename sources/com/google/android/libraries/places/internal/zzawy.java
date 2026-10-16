package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzawy extends zzbdq implements zzbey {
    private static final zzawy zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzawq zze;
    private zzawq zzf;

    static {
        zzawy zzawyVar = new zzawy();
        zzg = zzawyVar;
        zzbdq.D(zzawy.class, zzawyVar);
    }

    private zzawy() {
    }

    public static zzawy I() {
        return zzg;
    }

    public final zzawq G() {
        zzawq zzawqVar = this.zze;
        return zzawqVar == null ? zzawq.I() : zzawqVar;
    }

    public final zzawq H() {
        zzawq zzawqVar = this.zzf;
        return zzawqVar == null ? zzawq.I() : zzawqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzawy();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzawx(bArr);
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
        synchronized (zzawy.class) {
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
