package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbhe extends zzbdq implements zzbey {
    private static final zzbhe zzf;
    private static volatile zzbff zzg;
    private int zzb;
    private String zze = "";

    static {
        zzbhe zzbheVar = new zzbhe();
        zzf = zzbheVar;
        zzbdq.D(zzbhe.class, zzbheVar);
    }

    private zzbhe() {
    }

    public static zzbhd G() {
        return (zzbhd) zzf.A();
    }

    public static zzbhe H() {
        return zzf;
    }

    final /* synthetic */ void I(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzf, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"zzb", "zze"});
        }
        if (i4 == 3) {
            return new zzbhe();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbhd(bArr);
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
        synchronized (zzbhe.class) {
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
