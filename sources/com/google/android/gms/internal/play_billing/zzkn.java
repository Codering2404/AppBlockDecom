package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkn extends zzfu implements zzhc {
    private static final zzkn zzb;
    private int zzd;
    private zzjf zze;
    private long zzf;

    static {
        zzkn zzknVar = new zzkn();
        zzb = zzknVar;
        zzfu.zzB(zzkn.class, zzknVar);
    }

    private zzkn() {
    }

    public static zzkl zza() {
        return (zzkl) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzkn zzknVar, zzjf zzjfVar) {
        zzjfVar.getClass();
        zzknVar.zze = zzjfVar;
        zzknVar.zzd |= 1;
    }

    static /* synthetic */ void zze(zzkn zzknVar, long j3) {
        zzknVar.zzd |= 2;
        zzknVar.zzf = j3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i4 == 3) {
            return new zzkn();
        }
        zzkm zzkmVar = null;
        if (i4 == 4) {
            return new zzkl(zzkmVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
