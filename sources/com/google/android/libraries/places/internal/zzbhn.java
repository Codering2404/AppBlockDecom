package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class zzbhn extends zzbdn implements zzbey {
    private static final zzbhn zzf;
    private static volatile zzbff zzg;
    private byte zze = 2;

    static {
        zzbhn zzbhnVar = new zzbhn();
        zzf = zzbhnVar;
        zzbdq.D(zzbhn.class, zzbhnVar);
    }

    private zzbhn() {
    }

    public static zzbhn G() {
        return zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zze);
        }
        byte[] bArr = null;
        if (i4 == 2) {
            return zzbdq.m(zzf, "\u0003\u0000", null);
        }
        if (i4 == 3) {
            return new zzbhn();
        }
        if (i4 == 4) {
            return new zzbhm(bArr);
        }
        if (i4 == 5) {
            return zzf;
        }
        if (i4 != 6) {
            this.zze = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzg;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzbhn.class) {
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
