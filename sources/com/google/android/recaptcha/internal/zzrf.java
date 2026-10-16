package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrf extends zznd implements zzoj {
    private static final zzrf zzb;
    private static volatile zzoq zzd;
    private int zze;
    private zznk zzf = zznd.zzB();
    private zznk zzg = zznd.zzB();
    private zzqn zzh;

    static {
        zzrf zzrfVar = new zzrf();
        zzb = zzrfVar;
        zznd.zzI(zzrf.class, zzrfVar);
    }

    private zzrf() {
    }

    static /* synthetic */ void zzM(zzrf zzrfVar, zzrc zzrcVar) {
        zzrcVar.getClass();
        zznk zznkVar = zzrfVar.zzf;
        if (!zznkVar.zzc()) {
            zzrfVar.zzf = zznd.zzC(zznkVar);
        }
        zzrfVar.zzf.add(zzrcVar);
    }

    static /* synthetic */ void zzN(zzrf zzrfVar, zzrr zzrrVar) {
        zzrrVar.getClass();
        zznk zznkVar = zzrfVar.zzg;
        if (!zznkVar.zzc()) {
            zzrfVar.zzg = zznd.zzC(zznkVar);
        }
        zzrfVar.zzg.add(zzrrVar);
    }

    public static zzrd zzi() {
        return (zzrd) zzb.zzq();
    }

    public static zzrf zzk(byte[] bArr) throws zznn {
        return (zzrf) zznd.zzx(zzb, bArr);
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final int zzg() {
        return this.zzg.size();
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zze", "zzf", zzrc.class, "zzg", zzrr.class, "zzh"});
        }
        if (i4 == 3) {
            return new zzrf();
        }
        zzre zzreVar = null;
        if (i4 == 4) {
            return new zzrd(zzreVar);
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
        synchronized (zzrf.class) {
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

    public final List zzl() {
        return this.zzf;
    }
}
