package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzaqm extends zzbdq implements zzbey {
    private static final zzaqm zzk;
    private static volatile zzbff zzl;
    private int zzb;
    private zzadi zze;
    private int zzf;
    private int zzg;
    private int zzi;
    private byte zzj = 2;
    private String zzh = "";

    static {
        zzaqm zzaqmVar = new zzaqm();
        zzk = zzaqmVar;
        zzbdq.D(zzaqm.class, zzaqmVar);
    }

    private zzaqm() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i4 == 2) {
            return zzbdq.m(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001ᐉ\u0000\u0002င\u0001\u0003င\u0002\u0004ဈ\u0003\u0005᠌\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzaql.f75779a});
        }
        if (i4 == 3) {
            return new zzaqm();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzaqk(bArr);
        }
        if (i4 == 5) {
            return zzk;
        }
        if (i4 != 6) {
            this.zzj = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzl;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzaqm.class) {
            try {
                zzbdlVar = zzl;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzk);
                    zzl = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
