package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzti extends zznd implements zzoj {
    private static final zzti zzb;
    private static volatile zzoq zzd;
    private zznk zze = zznd.zzB();
    private int zzf;

    static {
        zzti zztiVar = new zzti();
        zzb = zztiVar;
        zznd.zzI(zzti.class, zztiVar);
    }

    private zzti() {
    }

    public static zztf zzf() {
        return (zztf) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzti zztiVar, Iterable iterable) {
        zztiVar.zzl();
        zzko.zzc(iterable, zztiVar.zze);
    }

    static /* synthetic */ void zzj(zzti zztiVar, zzth zzthVar) {
        zzthVar.getClass();
        zztiVar.zzl();
        zztiVar.zze.add(zzthVar);
    }

    private final void zzl() {
        zznk zznkVar = this.zze;
        if (zznkVar.zzc()) {
            return;
        }
        this.zze = zznd.zzC(zznkVar);
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u000b", new Object[]{"zze", zzth.class, "zzf"});
        }
        if (i4 == 3) {
            return new zzti();
        }
        zztj zztjVar = null;
        if (i4 == 4) {
            return new zztf(zztjVar);
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
        synchronized (zzti.class) {
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
