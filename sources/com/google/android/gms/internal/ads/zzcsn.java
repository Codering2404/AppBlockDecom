package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.devicetier.DeviceTierManager;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcsn implements zzcru {
    private final DeviceTierManager zza;

    zzcsn(DeviceTierManager deviceTierManager) {
        this.zza = deviceTierManager;
    }

    @Override // com.google.android.gms.internal.ads.zzcru
    public final void zza(JSONObject jSONObject) {
        DeviceTierManager.AdvertisedMemoryTier advertisedMemoryTierA;
        DeviceTierManager.AvailableProcessorTier availableProcessorTierA;
        DeviceTierManager.AvailableMemoryTier availableMemoryTierA;
        if (jSONObject.has("AvailableMemoryTier") && (availableMemoryTierA = DeviceTierManager.AvailableMemoryTier.a(jSONObject.optInt("AvailableMemoryTier", -1))) != null) {
            this.zza.e(availableMemoryTierA);
        }
        if (jSONObject.has("AvailableProcessorTier") && (availableProcessorTierA = DeviceTierManager.AvailableProcessorTier.a(jSONObject.optInt("AvailableProcessorTier", -1))) != null) {
            this.zza.f(availableProcessorTierA);
        }
        if (!jSONObject.has("AdvertisedMemoryTier") || (advertisedMemoryTierA = DeviceTierManager.AdvertisedMemoryTier.a(jSONObject.optInt("AdvertisedMemoryTier", -1))) == null) {
            return;
        }
        this.zza.d(advertisedMemoryTierA);
    }
}
