package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzccz extends zzcce {
    private final String zza;
    private final int zzb;

    public zzccz(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzccf
    public final String zze() throws RemoteException {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzccf
    public final int zzf() throws RemoteException {
        return this.zzb;
    }

    public zzccz(String str, int i3) {
        this.zza = str;
        this.zzb = i3;
    }
}
