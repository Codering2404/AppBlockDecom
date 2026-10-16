package com.facebook.ads;

import android.content.Context;
import android.graphics.Typeface;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NativeAdViewAttributes {
    private final NativeAdViewAttributesApi mNativeAdViewAttributesApi;

    public NativeAdViewAttributes(Context context) {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoader(context).createNativeAdViewAttributesApi();
    }

    @Deprecated
    public boolean getAutoplay() {
        return AdSettings.isVideoAutoplay();
    }

    @Deprecated
    public boolean getAutoplayOnMobile() {
        return AdSettings.isVideoAutoplayOnMobile();
    }

    @Deprecated
    public int getBackgroundColor() {
        return 0;
    }

    @Deprecated
    public int getButtonBorderColor() {
        return 0;
    }

    @Deprecated
    public int getButtonColor() {
        return 0;
    }

    @Deprecated
    public int getButtonTextColor() {
        return 0;
    }

    @Deprecated
    public int getDescriptionTextColor() {
        return 0;
    }

    @Deprecated
    public int getDescriptionTextSize() {
        return 0;
    }

    public NativeAdViewAttributesApi getInternalAttributes() {
        return this.mNativeAdViewAttributesApi;
    }

    @Deprecated
    public int getTitleTextColor() {
        return 0;
    }

    @Deprecated
    public int getTitleTextSize() {
        return 0;
    }

    @Deprecated
    public Typeface getTypeface() {
        return null;
    }

    public NativeAdViewAttributes setBackgroundColor(int i3) {
        this.mNativeAdViewAttributesApi.setBackgroundColor(i3);
        return this;
    }

    public NativeAdViewAttributes setButtonBorderColor(int i3) {
        this.mNativeAdViewAttributesApi.setCTABorderColor(i3);
        return this;
    }

    public NativeAdViewAttributes setButtonColor(int i3) {
        this.mNativeAdViewAttributesApi.setCTABackgroundColor(i3);
        return this;
    }

    public NativeAdViewAttributes setButtonTextColor(int i3) {
        this.mNativeAdViewAttributesApi.setCTATextColor(i3);
        return this;
    }

    public NativeAdViewAttributes setDescriptionTextColor(int i3) {
        this.mNativeAdViewAttributesApi.setSecondaryTextColor(i3);
        return this;
    }

    public NativeAdViewAttributes setTitleTextColor(int i3) {
        this.mNativeAdViewAttributesApi.setPrimaryTextColor(i3);
        return this;
    }

    public NativeAdViewAttributes setTypeface(Typeface typeface) {
        this.mNativeAdViewAttributesApi.setTypeface(typeface);
        return this;
    }

    @Deprecated
    public NativeAdViewAttributes() {
        this.mNativeAdViewAttributesApi = DynamicLoaderFactory.makeLoaderUnsafe().createNativeAdViewAttributesApi();
    }

    @Deprecated
    public NativeAdViewAttributes setAutoplay(boolean z2) {
        return this;
    }

    @Deprecated
    public NativeAdViewAttributes setAutoplayOnMobile(boolean z2) {
        return this;
    }
}
