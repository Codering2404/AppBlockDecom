package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaii extends zzbdq implements zzbey {
    private static final zzaii zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private boolean zzi;
    private int zzj;

    static {
        zzaii zzaiiVar = new zzaii();
        zzk = zzaiiVar;
        zzbdq.D(zzaii.class, zzaiiVar);
    }

    private zzaii() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003\u0005ဇ\u0004\u0006᠌\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzaih.f75631a});
        }
        if (i4 == 3) {
            return new zzaii();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaig(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaii.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
