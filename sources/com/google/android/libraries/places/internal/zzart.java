package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzart extends zzbdq implements zzbey {
    private static final zzart zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbcl zze;
    private zzbcl zzf;

    static {
        zzart zzartVar = new zzart();
        zzg = zzartVar;
        zzbdq.D(zzart.class, zzartVar);
    }

    private zzart() {
        zzbcl zzbclVar = zzbcl.f75997b;
        this.zze = zzbclVar;
        this.zzf = zzbclVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzart();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzars(bArr);
        }
        if (i4 == 5) {
            return zzg;
        }
        if (i4 != 6) {
            throw null;
        }
        zzbff zzbffVar = zzh;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzart.class) {
            try {
                zzbdlVar = zzh;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzg);
                    zzh = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
