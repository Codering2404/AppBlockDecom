package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NativeAdScrollView extends LinearLayout {
    public static final int DEFAULT_INSET = 20;
    public static final int DEFAULT_MAX_ADS = 10;
    private final NativeAdScrollViewApi mNativeAdScrollViewApi;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AdViewProvider {
        View createView(NativeAd nativeAd, int i3);

        void destroyView(NativeAd nativeAd, View view);
    }

    private NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i3, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i4) {
        super(context);
        this.mNativeAdScrollViewApi = DynamicLoaderFactory.makeLoader(context).createNativeAdScrollViewApi(this, context, nativeAdsManager, adViewProvider, i3, type, nativeAdViewAttributes, i4);
    }

    public void setInset(int i3) {
        this.mNativeAdScrollViewApi.setInset(i3);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, AdViewProvider adViewProvider, int i3) {
        this(context, nativeAdsManager, adViewProvider, 0, null, null, i3);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i3) {
        this(context, nativeAdsManager, null, i3, null, null, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i3, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, i3, null, nativeAdViewAttributes, 10);
    }

    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, int i3, NativeAdViewAttributes nativeAdViewAttributes, int i4) {
        this(context, nativeAdsManager, null, i3, null, nativeAdViewAttributes, i4);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type) {
        this(context, nativeAdsManager, null, 0, type, null, 10);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, 10);
    }

    @Deprecated
    public NativeAdScrollView(Context context, NativeAdsManager nativeAdsManager, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i3) {
        this(context, nativeAdsManager, null, 0, type, nativeAdViewAttributes, i3);
    }
}
