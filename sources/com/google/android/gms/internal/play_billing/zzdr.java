package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdr extends zzfu implements zzhc {
    private static final zzdr zzb;
    private int zzd;
    private zzeb zze;
    private zzeb zzf;
    private int zzg;

    static {
        zzdr zzdrVar = new zzdr();
        zzb = zzdrVar;
        zzfu.zzB(zzdr.class, zzdrVar);
    }

    private zzdr() {
    }

    public static zzdq zza() {
        return (zzdq) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzdr zzdrVar, zzeb zzebVar) {
        zzebVar.getClass();
        zzdrVar.zze = zzebVar;
        zzdrVar.zzd |= 1;
    }

    static /* synthetic */ void zze(zzdr zzdrVar, zzeb zzebVar) {
        zzebVar.getClass();
        zzdrVar.zzf = zzebVar;
        zzdrVar.zzd |= 2;
    }

    static /* synthetic */ void zzf(zzdr zzdrVar, int i3) {
        zzdrVar.zzg = i3 - 1;
        zzdrVar.zzd |= 4;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", "zzf", "zzg", zzee.zza()});
        }
        if (i4 == 3) {
            return new zzdr();
        }
        zzdu zzduVar = null;
        if (i4 == 4) {
            return new zzdq(zzduVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
