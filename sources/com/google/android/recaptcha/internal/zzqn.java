package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqn extends zznd implements zzoj {
    private static final zzqn zzb;
    private static volatile zzoq zzd;
    private zzle zze;
    private String zzf;
    private zzle zzg;
    private String zzh;
    private String zzi;
    private zzle zzj;
    private String zzk;
    private zzle zzl;

    static {
        zzqn zzqnVar = new zzqn();
        zzb = zzqnVar;
        zznd.zzI(zzqn.class, zzqnVar);
    }

    private zzqn() {
        zzle zzleVar = zzle.zzb;
        this.zze = zzleVar;
        this.zzf = "";
        this.zzg = zzleVar;
        this.zzh = "";
        this.zzi = "";
        this.zzj = zzleVar;
        this.zzk = "";
        this.zzl = zzleVar;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\n\u0002Ȉ\u0003\n\u0004Ȉ\u0005Ȉ\u0006\n\u0007Ȉ\b\n", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i4 == 3) {
            return new zzqn();
        }
        zzqm zzqmVar = null;
        if (i4 == 4) {
            return new zzql(zzqmVar);
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
        synchronized (zzqn.class) {
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
