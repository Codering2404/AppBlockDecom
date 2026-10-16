package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcn extends zzbdq implements zzbey {
    private static final zzcn zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private zzbea zze = zzbdq.s();
    private zzbea zzf = zzbdq.s();
    private zzbea zzg = zzbdq.s();
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;

    static {
        zzcn zzcnVar = new zzcn();
        zzl = zzcnVar;
        zzbdq.D(zzcn.class, zzcnVar);
    }

    private zzcn() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0003\u0000\u0002\u001b\u0003\u001b\u0004င\u0000\u0005င\u0001\u0006င\u0002\u0007ဂ\u0003\b\u001b", new Object[]{"zzb", "zzf", zzcm.class, "zzg", zzck.class, "zzh", "zzi", "zzj", "zzk", "zze", zzby.class});
        }
        if (i4 == 3) {
            return new zzcn();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzci(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzcn.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
