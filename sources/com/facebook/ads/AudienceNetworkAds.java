package com.facebook.ads;

import android.content.Context;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AudienceNetworkAds {
    public static final String TAG = "FBAudienceNetwork";

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdFormat {
        public static final int BANNER = 1;
        public static final int INTERSTITIAL = 2;
        public static final int NATIVE = 4;
        public static final int NATIVE_BANNER = 5;
        public static final int REWARDED_VIDEO = 6;
        public static final int UNKNOWN = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InitListener {
        void onInitialized(InitResult initResult);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InitResult {
        String getMessage();

        boolean isSuccess();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface InitSettingsBuilder {
        void initialize();

        InitSettingsBuilder withInitListener(InitListener initListener);

        InitSettingsBuilder withMediationService(String str);

        InitSettingsBuilder withPlacementIds(List<String> list);
    }

    private AudienceNetworkAds() {
    }

    public static InitSettingsBuilder buildInitSettings(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        return new com.facebook.ads.internal.api.InitSettingsBuilder(context);
    }

    public static int getAdFormatForPlacement(Context context, String str) {
        return DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().getAdFormatForPlacement(str);
    }

    public static void initialize(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null.");
        DynamicLoaderFactory.initialize(context, null, null, false);
    }

    public static boolean isInitialized(Context context) {
        if (DynamicLoaderFactory.getDynamicLoader() == null) {
            return false;
        }
        return DynamicLoaderFactory.makeLoader(context).createAudienceNetworkAdsApi().isInitialized();
    }
}
