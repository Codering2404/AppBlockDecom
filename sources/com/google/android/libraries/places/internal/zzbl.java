package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbl extends zzbdq implements zzbey {
    private static final zzbl zzn;
    private static volatile zzbff zzo;
    private int zzb;
    private zzbdy zze = zzbdq.p();
    private int zzf;
    private int zzg;
    private int zzh;
    private long zzi;
    private float zzj;
    private float zzk;
    private int zzl;
    private zzbh zzm;

    static {
        zzbl zzblVar = new zzbl();
        zzn = zzblVar;
        zzbdq.D(zzbl.class, zzblVar);
    }

    private zzbl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            zzbdw zzbdwVar = zzav.f75901a;
            zzbdw zzbdwVar2 = zzbf.f76123a;
            return zzbdq.m(zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ࠬ\u0002᠌\u0000\u0003᠌\u0001\u0004င\u0002\u0005ဂ\u0003\u0006ခ\u0004\u0007ခ\u0005\b᠌\u0006\tဉ\u0007", new Object[]{"zzb", "zze", zzbdwVar, "zzf", zzbdwVar2, "zzg", zzbdwVar2, "zzh", "zzi", "zzj", "zzk", "zzl", zzbdwVar, "zzm"});
        }
        if (i4 == 3) {
            return new zzbl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbk(bArr);
        }
        if (i4 == 5) {
            return zzn;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzo;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbl.class) {
            try {
                zzbdlVar = zzo;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzn);
                    zzo = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
