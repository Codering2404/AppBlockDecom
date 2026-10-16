package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabs extends zzxv implements zzzh {
    private static final zzyb zza = new zzyb<Integer, zzaby>() { // from class: com.google.android.gms.internal.gtm.zzabs.1
        @Override // com.google.android.gms.internal.gtm.zzyb
        public /* bridge */ /* synthetic */ zzaby zzb(Integer num) {
            throw null;
        }
    };
    private static final zzabs zzd;
    private zzya zze = zzxv.zzag();

    static {
        zzabs zzabsVar = new zzabs();
        zzd = zzabsVar;
        zzxv.zzan(zzabs.class, zzabsVar);
    }

    private zzabs() {
    }

    public static zzabs zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzxv
    protected final Object zzb(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        if (i4 == 2) {
            return zzxv.zzak(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zze", zzabx.zza});
        }
        if (i4 == 3) {
            return new zzabs();
        }
        zzabl zzablVar = null;
        if (i4 == 4) {
            return new zzabt(zzablVar);
        }
        if (i4 != 5) {
            return null;
        }
        return zzd;
    }
}
