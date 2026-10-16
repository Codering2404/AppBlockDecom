package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzadg extends zzbdq implements zzbey {
    private static final zzadg zzh;
    private static volatile zzbff zzi;
    private int zzb;
    private int zze;
    private int zzf;
    private byte zzg = 2;

    static {
        zzadg zzadgVar = new zzadg();
        zzh = zzadgVar;
        zzbdq.D(zzadg.class, zzadgVar);
    }

    private zzadg() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i4 == 2) {
            return zzbdq.m(zzh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔆ\u0000\u0002ᔆ\u0001", new Object[]{"zzb", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzadg();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzadf(bArr);
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
        synchronized (zzadg.class) {
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
