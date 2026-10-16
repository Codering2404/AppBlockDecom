package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbaf extends zzbdq implements zzbey {
    private static final zzbaf zzi;
    private static volatile zzbff zzj;
    private int zzb;
    private zzbhv zze;
    private zzbhv zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        zzbaf zzbafVar = new zzbaf();
        zzi = zzbafVar;
        zzbdq.D(zzbaf.class, zzbafVar);
    }

    private zzbaf() {
    }

    public static zzbaf K() {
        return zzi;
    }

    public final zzbhv G() {
        zzbhv zzbhvVar = this.zze;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final String H() {
        return this.zzf;
    }

    public final zzbhv I() {
        zzbhv zzbhvVar = this.zzg;
        return zzbhvVar == null ? zzbhv.I() : zzbhvVar;
    }

    public final String J() {
        return this.zzh;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzbdq.m(zzi, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002Ȉ\u0003ဉ\u0001\u0004Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        }
        if (i4 == 3) {
            return new zzbaf();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbae(bArr);
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
        synchronized (zzbaf.class) {
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
