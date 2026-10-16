package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzanl extends zzbdq implements zzbey {
    private static final zzanl zzl;
    private static volatile zzbff zzm;
    private int zzb;
    private zzadg zzf;
    private byte zzk = 2;
    private String zze = "";
    private String zzg = "";
    private zzbea zzh = zzbdq.s();
    private String zzi = "";
    private String zzj = "";

    static {
        zzanl zzanlVar = new zzanl();
        zzl = zzanlVar;
        zzbdq.D(zzanl.class, zzanlVar);
    }

    private zzanl() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i4 == 2) {
            return zzbdq.m(zzl, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ဈ\u0002\u0004\u001a\u0005ဈ\u0003\u0006ဈ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i4 == 3) {
            return new zzanl();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzank(bArr);
        }
        if (i4 == 5) {
            return zzl;
        }
        if (i4 != 6) {
            this.zzk = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzm;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzanl.class) {
            try {
                zzbdlVar = zzm;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzl);
                    zzm = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
