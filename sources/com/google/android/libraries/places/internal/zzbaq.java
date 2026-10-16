package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbaq extends zzbdq implements zzbey {
    private static final zzbaq zzg;
    private static volatile zzbff zzh;
    private int zzb;
    private zzbhx zze;
    private zzbhx zzf;

    static {
        zzbaq zzbaqVar = new zzbaq();
        zzg = zzbaqVar;
        zzbdq.D(zzbaq.class, zzbaqVar);
    }

    private zzbaq() {
    }

    public static zzbaq K() {
        return zzg;
    }

    public final boolean G() {
        return (this.zzb & 1) != 0;
    }

    public final zzbhx H() {
        zzbhx zzbhxVar = this.zze;
        return zzbhxVar == null ? zzbhx.J() : zzbhxVar;
    }

    public final boolean I() {
        return (this.zzb & 2) != 0;
    }

    public final zzbhx J() {
        zzbhx zzbhxVar = this.zzf;
        return zzbhxVar == null ? zzbhx.J() : zzbhxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzg, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzbaq();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbap(bArr);
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
        synchronized (zzbaq.class) {
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
