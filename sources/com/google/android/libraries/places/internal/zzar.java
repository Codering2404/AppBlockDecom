package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzar extends zzbdq implements zzbey {
    private static final zzar zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    private long zzj;
    private int zzk;

    static {
        zzar zzarVar = new zzar();
        zzl = zzarVar;
        zzbdq.D(zzar.class, zzarVar);
    }

    private zzar() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004᠌\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzap.f75770a, "zzi", "zzj", "zzk", zzaq.f75776a});
        }
        if (i4 == 3) {
            return new zzar();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzao(bArr);
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
        synchronized (zzar.class) {
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
