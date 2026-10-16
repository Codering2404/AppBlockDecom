package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccs implements RewardItem {
    private final zzccf zza;

    public zzccs(zzccf zzccfVar) {
        this.zza = zzccfVar;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzccf zzccfVar = this.zza;
        if (zzccfVar != null) {
            try {
                return zzccfVar.zzf();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not forward getAmount to RewardItem", e3);
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzccf zzccfVar = this.zza;
        if (zzccfVar != null) {
            try {
                return zzccfVar.zze();
            } catch (RemoteException e3) {
                com.google.android.gms.ads.internal.util.client.zzo.g("Could not forward getType to RewardItem", e3);
            }
        }
        return null;
    }
}
