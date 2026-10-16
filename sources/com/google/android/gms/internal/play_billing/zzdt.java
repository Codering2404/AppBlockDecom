package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdt extends zzfu implements zzhc {
    private static final zzdt zzb;
    private zzfz zzd = zzfu.zzv();

    static {
        zzdt zzdtVar = new zzdt();
        zzb = zzdtVar;
        zzfu.zzB(zzdt.class, zzdtVar);
    }

    private zzdt() {
    }

    public static zzds zza() {
        return (zzds) zzb.zzp();
    }

    static /* synthetic */ void zzc(zzdt zzdtVar, Iterable iterable) {
        zzfz zzfzVar = zzdtVar.zzd;
        if (!zzfzVar.zzc()) {
            int size = zzfzVar.size();
            zzdtVar.zzd = zzfzVar.zzd(size + size);
        }
        zzeg.zzk(iterable, zzdtVar.zzd);
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzdr.class});
        }
        if (i4 == 3) {
            return new zzdt();
        }
        zzdu zzduVar = null;
        if (i4 == 4) {
            return new zzds(zzduVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
