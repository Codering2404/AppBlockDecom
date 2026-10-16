package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrv extends zznd implements zzoj {
    private static final zzrv zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zzrt zzf;
    private zzrt zzg;

    static {
        zzrv zzrvVar = new zzrv();
        zzb = zzrvVar;
        zznd.zzI(zzrv.class, zzrvVar);
    }

    private zzrv() {
    }

    public static zzrv zzj(byte[] bArr) throws zznn {
        return (zzrv) zznd.zzx(zzb, bArr);
    }

    public final zzrt zzf() {
        zzrt zzrtVar = this.zzf;
        return zzrtVar == null ? zzrt.zzg() : zzrtVar;
    }

    public final zzrt zzg() {
        zzrt zzrtVar = this.zzg;
        return zzrtVar == null ? zzrt.zzg() : zzrtVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzrv();
        }
        zzrw zzrwVar = null;
        if (i4 == 4) {
            return new zzru(zzrwVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        if (i4 != 6) {
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzrv.class) {
            try {
                zzmyVar = zzd;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzb);
                    zzd = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }
}
