package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabh extends zzxv implements zzzh {
    private static final zzabh zza;
    private int zzd;
    private int zze;
    private String zzf = "*";

    static {
        zzabh zzabhVar = new zzabh();
        zza = zzabhVar;
        zzxv.zzan(zzabh.class, zzabhVar);
    }

    private zzabh() {
    }

    public static zzabh zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzabj.zza, "zzf"});
        }
        if (i4 == 3) {
            return new zzabh();
        }
        zzabf zzabfVar = null;
        if (i4 == 4) {
            return new zzabg(zzabfVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zza;
    }
}
