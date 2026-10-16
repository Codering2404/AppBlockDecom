package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzamt extends zzbdq implements zzbey {
    private static final zzamt zzp;
    private static volatile zzbff zzq;
    private int zzb;
    private zzamo zzg;
    private zzadi zzh;
    private int zzk;
    private int zzl;
    private int zzn;
    private byte zzo = 2;
    private String zze = "";
    private String zzf = "";
    private int zzi = 1;
    private String zzj = "";
    private String zzm = "";

    static {
        zzamt zzamtVar = new zzamt();
        zzp = zzamtVar;
        zzbdq.D(zzamt.class, zzamtVar);
    }

    private zzamt() {
    }

    @Override // com.google.android.libraries.places.internal.zzbdq
    protected final Object l(int i3, Object obj, Object obj2) {
        zzbff zzbdlVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i4 == 2) {
            return zzbdq.m(zzp, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0001\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ᐉ\u0003\u0005᠌\u0004\u0006ဈ\u0005\u0007᠌\u0006\bင\u0007\tဈ\b\n᠌\t", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzamq.f75716a, "zzj", "zzk", zzams.f75718a, "zzl", "zzm", "zzn", zzamr.f75717a});
        }
        if (i4 == 3) {
            return new zzamt();
        }
        byte[] bArr = null;
        if (i4 == 4) {
            return new zzamp(bArr);
        }
        if (i4 == 5) {
            return zzp;
        }
        if (i4 != 6) {
            this.zzo = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzbff zzbffVar = zzq;
        if (zzbffVar != null) {
            return zzbffVar;
        }
        synchronized (zzamt.class) {
            try {
                zzbdlVar = zzq;
                if (zzbdlVar == null) {
                    zzbdlVar = new zzbdl(zzp);
                    zzq = zzbdlVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbdlVar;
    }
}
