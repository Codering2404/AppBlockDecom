package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzadi extends zzbdq implements zzbey {
    private static final zzadi zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private zzadg zze;
    private zzadg zzf;
    private byte zzg = 2;

    static {
        zzadi zzadiVar = new zzadi();
        zzh = zzadiVar;
        zzbdq.D(zzadi.class, zzadiVar);
    }

    private zzadi() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0002ᐉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzadi();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzadh(bArr);
        }
        if (i4 == 5) {
            return zzh;
        }
        if (i4 != 6) {
            this.zzg = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzi;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzadi.class) {
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
