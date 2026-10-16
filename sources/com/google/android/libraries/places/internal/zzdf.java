package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzdf extends zzbdq implements zzbey {
    private static final zzdf zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private int zze;
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();
    private zzbea zzi = zzbdq.s();
    private zzbea zzj = zzbdq.s();
    private zzbea zzk = zzbdq.s();
    private zzbea zzl = zzbdq.s();

    static {
        zzdf zzdfVar = new zzdf();
        zzm = zzdfVar;
        zzbdq.D(zzdf.class, zzdfVar);
    }

    private zzdf() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001✐\b\u0000\u0007\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004\u001b\u0005\u001b\u0006\u001b\u0007\u001b✐᠌\u0000", new Object[]{"zzb", "zzf", zzdj.class, "zzg", zzdl.class, "zzh", zzec.class, "zzi", zzdt.class, "zzj", zzee.class, "zzk", zzdr.class, "zzl", zzdp.class, "zze", zzde.f77778a});
        }
        if (i4 == 3) {
            return new zzdf();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzdd(bArr);
        }
        if (i4 == 5) {
            return zzm;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzn;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzdf.class) {
            try {
                zzbdlVar = zzn;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzm);
                    zzn = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
