package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaes extends zzbdq implements zzbey {
    private static final zzaes zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private int zze;
    private long zzf;
    private zzaee zzg;
    private long zzh;
    private int zzi;
    private zzbdy zzj = zzbdq.p();
    private zzbdy zzk = zzbdq.p();
    private int zzl;

    static {
        zzaes zzaesVar = new zzaes();
        zzm = zzaesVar;
        zzbdq.D(zzaes.class, zzaesVar);
    }

    private zzaes() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0002\u0000\u0001᠌\u0000\u0002စ\u0001\u0003ဉ\u0002\u0004ဂ\u0003\u0005င\u0004\u0006\u0016\u0007\u0016\bင\u0005", new Object[]{"zzb", "zze", zzaer.f75620a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzaes();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaeq(bArr);
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
        synchronized (zzaes.class) {
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
