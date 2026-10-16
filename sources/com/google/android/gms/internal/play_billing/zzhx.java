package com.google.android.gms.internal.play_billing;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhx extends zzfu implements zzhc {
    private static final zzhx zzb;
    private zzgv zzd = zzgv.zza();

    static {
        zzhx zzhxVar = new zzhx();
        zzb = zzhxVar;
        zzfu.zzB(zzhx.class, zzhxVar);
    }

    private zzhx() {
    }

    public static zzhu zza() {
        return (zzhu) zzb.zzp();
    }

    static /* synthetic */ Map zzc(zzhx zzhxVar) {
        if (!zzhxVar.zzd.zze()) {
            zzhxVar.zzd = zzhxVar.zzd.zzb();
        }
        return zzhxVar.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return new zzhk(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zzd", zzhv.zza});
        }
        if (i4 == 3) {
            return new zzhx();
        }
        zzhw zzhwVar = null;
        if (i4 == 4) {
            return new zzhu(zzhwVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
