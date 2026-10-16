package com.applovin.impl.sdk.nativeAd;

import android.content.Context;
import android.net.Uri;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.applovin.impl.adview.AppLovinTouchToClickListener;
import com.applovin.impl.aq;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sj;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinMediaView extends FrameLayout {
    protected final ImageView imageView;
    protected final n logger;
    protected final com.applovin.impl.sdk.j sdk;

    public AppLovinMediaView(AppLovinNativeAdImpl appLovinNativeAdImpl, com.applovin.impl.sdk.j jVar, Context context) {
        super(context);
        setBackgroundColor(-16777216);
        this.sdk = jVar;
        this.logger = jVar.I();
        LayoutInflater.from(context).inflate(R.layout.applovin_native_ad_media_view, (ViewGroup) this, true);
        Uri mainImageUri = appLovinNativeAdImpl.getMainImageUri();
        aq vastAd = appLovinNativeAdImpl.getVastAd();
        Uri uriU0 = vastAd != null ? vastAd.u0() : null;
        if (mainImageUri == null && uriU0 == null) {
            throw new IllegalStateException("AppLovin native ad missing image AND video resources");
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (((Boolean) jVar.a(sj.I2)).booleanValue()) {
            setOnTouchListener(new AppLovinTouchToClickListener(jVar, sj.f63766m0, context, appLovinNativeAdImpl));
        } else {
            setOnClickListener(appLovinNativeAdImpl);
        }
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        this.imageView = imageView;
        if (mainImageUri != null) {
            ImageViewUtils.setAndDownscaleImageUri(imageView, mainImageUri);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    public void destroy() {
        setOnClickListener(null);
        setOnTouchListener(null);
        removeAllViews();
    }
}
