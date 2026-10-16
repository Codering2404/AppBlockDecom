package com.facebook.ads.internal.bridge.gms;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdvertisingId {
    private final String mId;
    private final boolean mLimitAdTracking;

    public AdvertisingId(String str, boolean z2) {
        this.mId = str;
        this.mLimitAdTracking = z2;
    }

    public static AdvertisingId getAdvertisingIdInfoDirectly(Context context) {
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return new AdvertisingId(advertisingIdInfo.getId(), advertisingIdInfo.isLimitAdTrackingEnabled());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getId() {
        return this.mId;
    }

    public boolean isLimitAdTracking() {
        return this.mLimitAdTracking;
    }
}
