package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzalc extends zzbdq implements zzbey {
    private static final zzalc zzf;
    private static volatile zzbff zzg;
    private int zzb;
    private int zze;

    static {
        zzalc zzalcVar = new zzalc();
        zzf = zzalcVar;
        zzbdq.D(zzalc.class, zzalcVar);
    }

    private zzalc() {
    }

    public static zzalb G() {
        return (zzalb) zzf.A();
    }

    final /* synthetic */ void H(int i3) {
        this.zzb |= 1;
        this.zze = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzb", "zze"});
        }
        if (i4 == 3) {
            return new zzalc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzalb(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzg;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzalc.class) {
            try {
                zzbdlVar = zzg;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzf);
                    zzg = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
