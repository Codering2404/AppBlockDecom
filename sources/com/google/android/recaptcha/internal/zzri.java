package com.google.android.recaptcha.internal;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzri extends zznd implements zzoj {
    private static final zzri zzb;
    private static volatile zzoq zzd;
    private int zze;
    private int zzf = 0;
    private Object zzg;
    private zzrl zzh;
    private int zzi;
    private zzqq zzj;
    private zzqz zzk;

    static {
        zzri zzriVar = new zzri();
        zzb = zzriVar;
        zznd.zzI(zzri.class, zzriVar);
    }

    private zzri() {
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000,\u0001\u0001\u0001,,\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003ဉ\u0001\u0004?\u0000\u0005?\u0000\u0006?\u0000\u0007?\u0000\b?\u0000\t?\u0000\n?\u0000\u000b?\u0000\f?\u0000\r?\u0000\u000e?\u0000\u000f?\u0000\u0010?\u0000\u0011?\u0000\u0012?\u0000\u0013?\u0000\u0014?\u0000\u0015?\u0000\u0016?\u0000\u0017?\u0000\u0018?\u0000\u0019ဉ\u0002\u001a?\u0000\u001b?\u0000\u001c?\u0000\u001d?\u0000\u001e?\u0000\u001f?\u0000 ?\u0000!?\u0000\"?\u0000#?\u0000$?\u0000%?\u0000&?\u0000'?\u0000(?\u0000)?\u0000*?\u0000+?\u0000,?\u0000", new Object[]{"zzg", "zzf", "zze", "zzh", tDEtWsFLJfe.vqywPEZr, "zzj", "zzk"});
        }
        if (i4 == 3) {
            return new zzri();
        }
        zzrh zzrhVar = null;
        if (i4 == 4) {
            return new zzrg(zzrhVar);
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
        synchronized (zzri.class) {
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
