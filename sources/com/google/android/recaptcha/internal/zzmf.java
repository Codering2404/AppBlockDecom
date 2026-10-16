package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzmf extends zznd implements zzoj {
    private static final zzmf zzb;
    private static volatile zzoq zzd;
    private int zze;
    private boolean zzg;
    private byte zzh = 2;
    private String zzf = "";

    static {
        zzmf zzmfVar = new zzmf();
        zzb = zzmfVar;
        zznd.zzI(zzmf.class, zzmfVar);
    }

    private zzmf() {
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i4 == 2) {
            return new zzou(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i4 == 3) {
            return new zzmf();
        }
        zzmh zzmhVar = null;
        if (i4 == 4) {
            return new zzme(zzmhVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        if (i4 != 6) {
            this.zzh = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzoq zzoqVar = zzd;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzmf.class) {
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
