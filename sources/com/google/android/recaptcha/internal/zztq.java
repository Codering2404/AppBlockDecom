package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zztq extends zznd implements zzoj {
    private static final zztq zzb;
    private static volatile zzoq zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zztq zztqVar = new zztq();
        zzb = zztqVar;
        zznd.zzI(zztq.class, zztqVar);
    }

    private zztq() {
    }

    public static zztp zzf() {
        return (zztp) zzb.zzq();
    }

    static /* synthetic */ void zzi(zztq zztqVar, String str) {
        str.getClass();
        zztqVar.zze = str;
    }

    @Override // com.google.android.recaptcha.internal.zznd
    protected final Object zzh(int i3, Object obj, Object obj2) {
        zzoq zzmyVar;
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zznd.zzF(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zze", "zzf"});
        }
        if (i4 == 3) {
            return new zztq();
        }
        zzug zzugVar = null;
        if (i4 == 4) {
            return new zztp(zzugVar);
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
        synchronized (zztq.class) {
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
