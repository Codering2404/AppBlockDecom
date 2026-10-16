package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqo extends zzbdq implements zzbey {
    private static final zzaqo zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzaqo zzaqoVar = new zzaqo();
        zzh = zzaqoVar;
        zzbdq.D(zzaqo.class, zzaqoVar);
    }

    private zzaqo() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzb", "zze", zzakt.f75654a, "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzaqo();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqn(bArr);
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
        synchronized (zzaqo.class) {
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
