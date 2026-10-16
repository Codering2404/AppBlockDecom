package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzafx extends zzbdq implements zzbey {
    private static final zzafx zzo;
    private static volatile zzbff zzp;
    private int zzb;
    private long zze;
    private long zzf;
    private zzbea zzg = zzbdq.s();
    private zzbea zzh = zzbdq.s();
    private zzbea zzi = zzbdq.s();
    private zzbea zzj = zzbdq.s();
    private zzagg zzk;
    private zzagg zzl;
    private zzagg zzm;
    private zzagg zzn;

    static {
        zzafx zzafxVar = new zzafx();
        zzo = zzafxVar;
        zzbdq.D(zzafx.class, zzafxVar);
    }

    private zzafx() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzo, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0004\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003\u001b\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဉ\u0002\bဉ\u0003\tဉ\u0004\nဉ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", zzafz.class, "zzh", zzafz.class, "zzi", zzafz.class, "zzj", zzafz.class, "zzk", "zzl", "zzm", "zzn"});
        }
        if (i4 == 3) {
            return new zzafx();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzafw(bArr);
        }
        if (i4 == 5) {
            return zzo;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzp;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzafx.class) {
            try {
                zzbdlVar = zzp;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzo);
                    zzp = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
