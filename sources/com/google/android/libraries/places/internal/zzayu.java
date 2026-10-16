package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzayu extends zzbdq implements zzbey {
    private static final zzayu zzj;
    private static volatile zzbff zzk;
    private int zzb;
    private zzbhv zze;
    private zzbhv zzf;
    private zzbas zzg;
    private zzbea zzh = zzbdq.s();
    private String zzi = "";

    static {
        zzayu zzayuVar = new zzayu();
        zzj = zzayuVar;
        zzbdq.D(zzayu.class, zzayuVar);
    }

    private zzayu() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzj, "\u0000\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0002\u0003ဉ\u0001\u0004\u001b\u0005Ȉ", new Object[]{"zzb", "zze", "zzg", "zzf", "zzh", zzaxe.class, "zzi"});
        }
        if (i4 == 3) {
            return new zzayu();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzayt(bArr);
        }
        if (i4 == 5) {
            return zzj;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzk;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzayu.class) {
            try {
                zzbdlVar = zzk;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzj);
                    zzk = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
