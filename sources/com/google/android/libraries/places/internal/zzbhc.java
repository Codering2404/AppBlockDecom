package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbhc extends zzbdq implements zzbey {
    private static final zzbhc zzg;
    private static volatile zzbff zzh;
    private String zzb = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzbhc zzbhcVar = new zzbhc();
        zzg = zzbhcVar;
        zzbdq.D(zzbhc.class, zzbhcVar);
    }

    private zzbhc() {
    }

    public static zzbhc H() {
        return zzg;
    }

    public final String G() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzbhc();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbhb(bArr);
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
        synchronized (zzbhc.class) {
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
