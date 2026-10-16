package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzxu extends zzbdq implements zzbey {
    private static final zzxu zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private int zzl;
    private zzbdy zze = zzbdq.p();
    private String zzf = "";
    private zzbcl zzk = zzbcl.f75997b;

    static {
        zzxu zzxuVar = new zzxu();
        zzm = zzxuVar;
        zzbdq.D(zzxu.class, zzxuVar);
    }

    private zzxu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001ࠬ\u0002ဈ\u0000\u0003ဇ\u0001\u0004ဇ\u0002\u0005ဂ\u0003\u0006ခ\u0004\u0007ည\u0005\bင\u0006", new Object[]{"zzb", "zze", zzxt.f78837a, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzxu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzxs(bArr);
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
        synchronized (zzxu.class) {
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
