package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzacp extends zzbdq implements zzbey {
    private static final zzacp zzm;
    private static volatile zzbff zzn;
    private int zzb;
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private double zzl;
    private zzbdy zze = zzbdq.p();
    private zzbdy zzf = zzbdq.p();
    private zzbea zzk = zzbdq.s();

    static {
        zzacp zzacpVar = new zzacp();
        zzm = zzacpVar;
        zzbdq.D(zzacp.class, zzacpVar);
    }

    private zzacp() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0016\u0002\u0016\u0003င\u0000\u0004င\u0001\u0005ဂ\u0002\u0006င\u0003\u0007\u001b\bက\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzaco.class, "zzl"});
        }
        if (i4 == 3) {
            return new zzacp();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzacb(bArr);
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
        synchronized (zzacp.class) {
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
