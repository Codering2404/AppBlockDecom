package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbcy extends zzbdq implements zzbey {
    private static final zzbcy zzf;
    private static volatile zzbff zzg;
    private long zzb;
    private int zze;

    static {
        zzbcy zzbcyVar = new zzbcy();
        zzf = zzbcyVar;
        zzbdq.D(zzbcy.class, zzbcyVar);
    }

    private zzbcy() {
    }

    public static zzbcy I() {
        return zzf;
    }

    public final long G() {
        return this.zzb;
    }

    public final int H() {
        return this.zze;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzbfj(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzb", "zze"});
        }
        if (i4 == 3) {
            return new zzbcy();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzbcx(bArr);
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
        synchronized (zzbcy.class) {
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
