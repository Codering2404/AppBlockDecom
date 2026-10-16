package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbay extends zzbdq implements zzbey {
    private static final zzbay zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzbht zze;
    private int zzf;
    private zzbaw zzg;
    private int zzh;

    static {
        zzbay zzbayVar = new zzbay();
        zzi = zzbayVar;
        zzbdq.D(zzbay.class, zzbayVar);
    }

    private zzbay() {
    }

    public static zzbax G() {
        return (zzbax) zzi.A();
    }

    final /* synthetic */ void H(zzbht zzbhtVar) {
        zzbhtVar.getClass();
        this.zze = zzbhtVar;
        this.zzb |= 1;
    }

    final /* synthetic */ void I(zzbaw zzbawVar) {
        zzbawVar.getClass();
        this.zzg = zzbawVar;
        this.zzb |= 2;
    }

    final /* synthetic */ void K(int i3) {
        this.zzf = i3 - 2;
    }

    final /* synthetic */ void L(int i3) {
        this.zzh = i3 - 2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzbay();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbax(bArr);
        }
        if (i4 == 5) {
            return zzi;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzj;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbay.class) {
            try {
                zzbdlVar = zzj;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzi);
                    zzj = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
