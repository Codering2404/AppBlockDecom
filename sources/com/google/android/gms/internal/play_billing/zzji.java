package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzji extends zzfu implements zzhc {
    private static final zzji zzb;

    static {
        zzji zzjiVar = new zzji();
        zzb = zzjiVar;
        zzfu.zzB(zzji.class, zzjiVar);
    }

    private zzji() {
    }

    public static zzji zzb() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfu
    protected final Object zzd(int i3, Object obj, Object obj2) {
        int i4 = i3 - 1;
        if (i4 == 0) {
            return (byte) 1;
        }
        zzjh zzjhVar = null;
        if (i4 == 2) {
            return zzfu.zzy(zzb, "\u0004\u0000", null);
        }
        if (i4 == 3) {
            return new zzji();
        }
        if (i4 == 4) {
            return new zzjg(zzjhVar);
        }
        if (i4 == 5) {
            return zzb;
        }
        throw null;
    }
}
