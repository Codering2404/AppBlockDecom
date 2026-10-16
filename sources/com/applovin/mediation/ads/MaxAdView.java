package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.e0;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.zq;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxAdView extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MaxAdViewImpl f65507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f65508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f65509c;

    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    private void a(String str, MaxAdFormat maxAdFormat, int i3, AppLovinSdk appLovinSdk, Context context) {
        View view = new View(context.getApplicationContext());
        this.f65508b = view;
        view.setBackgroundColor(0);
        addView(this.f65508b);
        this.f65508b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f65509c = getVisibility();
        this.f65507a = new MaxAdViewImpl(str.trim(), maxAdFormat, this, this.f65508b, appLovinSdk.a(), context);
        setGravity(i3);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f65507a.logApiCall("destroy()");
        this.f65507a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f65507a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f65507a.getAdUnitId();
    }

    public String getPlacement() {
        this.f65507a.logApiCall("getPlacement()");
        return this.f65507a.getPlacement();
    }

    public void loadAd() {
        this.f65507a.logApiCall("loadAd()");
        this.f65507a.loadAd();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        if (isInEditMode()) {
            return;
        }
        this.f65507a.logApiCall("onWindowVisibilityChanged(visibility=" + i3 + ")");
        if (this.f65507a != null && zq.a(this.f65509c, i3)) {
            this.f65507a.onWindowVisibilityChanged(i3);
        }
        this.f65509c = i3;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f65507a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f65507a.setAdReviewListener(maxAdReviewListener);
    }

    @Override // android.view.View
    public void setAlpha(float f3) {
        this.f65507a.logApiCall("setAlpha(alpha=" + f3 + ")");
        View view = this.f65508b;
        if (view != null) {
            view.setAlpha(f3);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        this.f65507a.logApiCall("setBackgroundColor(color=" + i3 + ")");
        MaxAdViewImpl maxAdViewImpl = this.f65507a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i3);
        }
        View view = this.f65508b;
        if (view != null) {
            view.setBackgroundColor(i3);
        }
    }

    public void setCustomData(String str) {
        this.f65507a.logApiCall("setCustomData(value=" + str + ")");
        this.f65507a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f65507a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f65507a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f65507a.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f65507a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f65507a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f65507a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f65507a.logApiCall("setPlacement(placement=" + str + ")");
        this.f65507a.setPlacement(str);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f65507a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f65507a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f65507a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f65507a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f65507a.logApiCall("startAutoRefresh()");
        this.f65507a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f65507a.logApiCall("stopAutoRefresh()");
        this.f65507a.stopAutoRefresh();
    }

    @Override // android.view.View
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f65507a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, e0.a(context), appLovinSdk, context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context.getApplicationContext());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", sdk=" + appLovinSdk + ")");
        a(str, maxAdFormat, 49, appLovinSdk, context);
    }

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i3) {
        MaxAdFormat maxAdFormatA;
        super(context, attributeSet, i3);
        String strA = e0.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String strA2 = e0.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        if (StringUtils.isValidString(strA2)) {
            maxAdFormatA = MaxAdFormat.formatFromString(strA2);
        } else {
            maxAdFormatA = e0.a(context);
        }
        MaxAdFormat maxAdFormat = maxAdFormatA;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (strA != null) {
            if (!TextUtils.isEmpty(strA)) {
                if (isInEditMode()) {
                    a(context);
                    return;
                } else {
                    a(strA, maxAdFormat, attributeIntValue, AppLovinSdk.getInstance(context), context);
                    return;
                }
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i3, i4);
    }
}
