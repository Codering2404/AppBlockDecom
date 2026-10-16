package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaha extends zzbdq implements zzbey {
    private static final zzaha zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private long zzf;
    private zzbea zze = zzbdq.s();
    private zzbdy zzg = zzbdq.p();
    private zzbdy zzh = zzbdq.p();

    static {
        zzaha zzahaVar = new zzaha();
        zzi = zzahaVar;
        zzbdq.D(zzaha.class, zzahaVar);
    }

    private zzaha() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzaab.f75602a;
            return zzbdq.m(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0003\u0000\u0001\u001b\u0002ဂ\u0000\u0003ࠬ\u0004ࠬ", new Object[]{"zzb", "zze", zzagz.class, "zzf", "zzg", zzbdwVar, "zzh", zzbdwVar});
        }
        if (i4 == 3) {
            return new zzaha();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzagx(bArr);
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
        synchronized (zzaha.class) {
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
