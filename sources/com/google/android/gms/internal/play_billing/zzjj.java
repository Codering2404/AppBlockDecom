package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjj implements zzfx {
    static final zzfx zza = new zzjj();

    private zzjj() {
    }

    @Override // com.google.android.gms.internal.play_billing.zzfx
    public final boolean zza(int i3) {
        return (i3 != 0 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? null : zzjk.ALTERNATIVE_BILLING_ACTION : zzjk.LOCAL_PURCHASES_UPDATED_ACTION : zzjk.PURCHASES_UPDATED_ACTION : zzjk.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
