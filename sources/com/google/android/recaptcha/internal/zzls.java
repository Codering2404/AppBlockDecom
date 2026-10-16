package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzls extends zzna implements zzoj {
    private static final zzls zzd;
    private static volatile zzoq zze;
    private int zzf;
    private boolean zzg;
    private zzma zzh;
    private boolean zzi;
    private zzmc zzj;
    private byte zzl = 2;
    private zznk zzk = zzot.zze();

    static {
        zzls zzlsVar = new zzls();
        zzd = zzlsVar;
        zznd.zzI(zzls.class, zzlsVar);
    }

    private zzls() {
    }

    public static zzls zzg() {
        return zzd;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i4 == 2) {
            return new zzou(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzmg.class});
        }
        if (i4 == 3) {
            return new zzls();
        }
        zzmh zzmhVar = null;
        if (i4 == 4) {
            return new zzlr(zzmhVar);
        }
        if (i4 == 5) {
            return zzd;
        }
        if (i4 != 6) {
            this.zzl = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzoq zzoqVar = zze;
        if (zzoqVar != null) {
            return zzoqVar;
        }
        synchronized (zzls.class) {
            try {
                zzmyVar = zze;
                if (zzmyVar == null) {
                    zzmyVar = new zzmy(zzd);
                    zze = zzmyVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzmyVar;
    }
}
