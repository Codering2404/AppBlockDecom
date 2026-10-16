package com.applovin.adview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinAdView extends RelativeLayout {
    public static final String NAMESPACE = "http://schemas.applovin.com/android/1.0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.applovin.impl.adview.a f57858a;

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinAdSize, (String) null, context);
    }

    private void a(AppLovinAdSize appLovinAdSize, String str, AppLovinSdk appLovinSdk, Context context, AttributeSet attributeSet) {
        if (isInEditMode()) {
            a(attributeSet, context);
            return;
        }
        com.applovin.impl.adview.a aVar = new com.applovin.impl.adview.a();
        this.f57858a = aVar;
        aVar.a(this, context, appLovinAdSize, str, appLovinSdk, attributeSet);
    }

    public void destroy() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public com.applovin.impl.adview.a getController() {
        return this.f57858a;
    }

    public AppLovinAdSize getSize() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            return aVar.m();
        }
        return null;
    }

    public String getZoneId() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            return aVar.n();
        }
        return null;
    }

    public void loadNextAd() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.v();
        } else {
            n.i("AppLovinSdk", "Unable to load next ad: AppLovinAdView is not initialized.");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.B();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.C();
        }
        super.onDetachedFromWindow();
    }

    public void pause() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.F();
        }
    }

    public void renderAd(AppLovinAd appLovinAd) {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.c(appLovinAd);
        }
    }

    public void resume() {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.H();
        }
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.a(appLovinAdClickListener);
        }
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.a(appLovinAdDisplayListener);
        }
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.a(appLovinAdLoadListener);
        }
    }

    public void setAdViewEventListener(AppLovinAdViewEventListener appLovinAdViewEventListener) {
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.a(appLovinAdViewEventListener);
        }
    }

    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        com.applovin.impl.adview.a aVar = this.f57858a;
        if (aVar != null) {
            aVar.a(str, obj);
        }
    }

    @Override // android.view.View
    public String toString() {
        return "AppLovinAdView{zoneId='" + getZoneId() + "\", size=" + getSize() + '}';
    }

    public AppLovinAdView(AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context);
        a(appLovinAdSize, str, null, context, null);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, Context context) {
        this(appLovinSdk, appLovinAdSize, null, context);
    }

    public AppLovinAdView(AppLovinSdk appLovinSdk, AppLovinAdSize appLovinAdSize, String str, Context context) {
        super(context.getApplicationContext());
        a(appLovinAdSize, str, appLovinSdk, context, null);
    }

    private void a(AttributeSet attributeSet, Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int iApplyDimension = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(220, 220, 220));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin Ad");
        textView.setGravity(17);
        addView(textView, i3, iApplyDimension);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppLovinAdView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(null, null, null, context, attributeSet);
    }
}
