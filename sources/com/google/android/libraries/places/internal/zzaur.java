package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaur extends zzbdq implements zzbey {
    private static final zzaur zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private int zze;
    private int zzf = 1;
    private int zzg;
    private int zzh;

    static {
        zzaur zzaurVar = new zzaur();
        zzi = zzaurVar;
        zzbdq.D(zzaur.class, zzaurVar);
    }

    private zzaur() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzb", "zze", zzaup.f75899a, "zzf", zzauq.f75900a, "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzaur();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzauo(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaur.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
