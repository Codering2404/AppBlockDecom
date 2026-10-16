package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbaw extends zzbdq implements zzbey {
    private static final zzbaw zzh;
    private static volatile zzbff zzi;
    private boolean zzb;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;

    static {
        zzbaw zzbawVar = new zzbaw();
        zzh = zzbawVar;
        zzbdq.D(zzbaw.class, zzbawVar);
    }

    private zzbaw() {
    }

    public static zzbav G() {
        return (zzbav) zzh.A();
    }

    final /* synthetic */ void H(boolean z2) {
        this.zzb = z2;
    }

    final /* synthetic */ void I(boolean z2) {
        this.zze = z2;
    }

    final /* synthetic */ void J(boolean z2) {
        this.zzf = z2;
    }

    final /* synthetic */ void K(boolean z2) {
        this.zzg = z2;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0007\u0002\u0007\u0003\u0007\u0004\u0007", new Object[]{"zzb", "zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzbaw();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbav(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbaw.class) {
            try {
                zzbdlVar = zzi;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzh);
                    zzi = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
