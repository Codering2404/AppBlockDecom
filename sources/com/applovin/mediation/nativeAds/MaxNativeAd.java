package com.applovin.mediation.nativeAds;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.applovin.impl.mediation.nativeAds.MaxNativeAdImpl;
import com.applovin.mediation.MaxAdFormat;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAd extends MaxNativeAdImpl {
    private static final float MINIMUM_STARS_TO_RENDER = 3.0f;
    private final String advertiser;
    private final String body;
    private final String callToAction;
    private final MaxAdFormat format;
    private final MaxNativeAdImage icon;
    private final View iconView;
    private boolean isExpired;
    private final MaxNativeAdImage mainImage;
    private final float mediaContentAspectRatio;
    private final View mediaView;
    private MaxNativeAdView nativeAdView;
    private final View optionsView;
    private final Double starRating;
    private final String title;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MaxAdFormat f65523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f65524b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f65525c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f65526d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f65527e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private MaxNativeAdImage f65528f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private View f65529g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private View f65530h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private View f65531i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private MaxNativeAdImage f65532j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private float f65533k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Double f65534l;

        public MaxNativeAd build() {
            return new MaxNativeAd(this);
        }

        public Builder setAdFormat(MaxAdFormat maxAdFormat) {
            this.f65523a = maxAdFormat;
            return this;
        }

        public Builder setAdvertiser(String str) {
            this.f65525c = str;
            return this;
        }

        public Builder setBody(String str) {
            this.f65526d = str;
            return this;
        }

        public Builder setCallToAction(String str) {
            this.f65527e = str;
            return this;
        }

        public Builder setIcon(MaxNativeAdImage maxNativeAdImage) {
            this.f65528f = maxNativeAdImage;
            return this;
        }

        public Builder setIconView(View view) {
            this.f65529g = view;
            return this;
        }

        public Builder setMainImage(MaxNativeAdImage maxNativeAdImage) {
            this.f65532j = maxNativeAdImage;
            return this;
        }

        public Builder setMediaContentAspectRatio(float f3) {
            this.f65533k = f3;
            return this;
        }

        public Builder setMediaView(View view) {
            this.f65531i = view;
            return this;
        }

        public Builder setOptionsView(View view) {
            this.f65530h = view;
            return this;
        }

        public Builder setStarRating(Double d3) {
            this.f65534l = d3;
            return this;
        }

        public Builder setTitle(String str) {
            this.f65524b = str;
            return this;
        }
    }

    public MaxNativeAd(Builder builder) {
        this.format = builder.f65523a;
        this.title = builder.f65524b;
        this.advertiser = builder.f65525c;
        this.body = builder.f65526d;
        this.callToAction = builder.f65527e;
        this.icon = builder.f65528f;
        this.iconView = builder.f65529g;
        this.optionsView = builder.f65530h;
        this.mediaView = builder.f65531i;
        this.mainImage = builder.f65532j;
        this.mediaContentAspectRatio = builder.f65533k;
        Double d3 = builder.f65534l;
        this.starRating = (d3 == null || d3.doubleValue() < 3.0d) ? null : d3;
    }

    public final String getAdvertiser() {
        return this.advertiser;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCallToAction() {
        return this.callToAction;
    }

    public final MaxAdFormat getFormat() {
        return this.format;
    }

    public final MaxNativeAdImage getIcon() {
        return this.icon;
    }

    public final View getIconView() {
        return this.iconView;
    }

    public final MaxNativeAdImage getMainImage() {
        return this.mainImage;
    }

    public final float getMediaContentAspectRatio() {
        return this.mediaContentAspectRatio;
    }

    public final View getMediaView() {
        return this.mediaView;
    }

    public final View getOptionsView() {
        return this.optionsView;
    }

    public final Double getStarRating() {
        return this.starRating;
    }

    public final String getTitle() {
        return this.title;
    }

    public boolean isContainerClickable() {
        return false;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public void performClick() {
        Button callToActionButton;
        MaxNativeAdView maxNativeAdView = this.nativeAdView;
        if (maxNativeAdView == null || (callToActionButton = maxNativeAdView.getCallToActionButton()) == null) {
            return;
        }
        callToActionButton.performClick();
    }

    public boolean prepareForInteraction(List<View> list, ViewGroup viewGroup) {
        return false;
    }

    public void setExpired() {
        this.isExpired = true;
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.nativeAdView = maxNativeAdView;
    }

    public boolean shouldPrepareViewForInteractionOnMainThread() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MaxNativeAdImage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f65535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f65536b;

        public MaxNativeAdImage(Drawable drawable) {
            this.f65535a = drawable;
        }

        public Drawable getDrawable() {
            return this.f65535a;
        }

        public Uri getUri() {
            return this.f65536b;
        }

        public MaxNativeAdImage(Uri uri) {
            this.f65536b = uri;
        }
    }

    @Deprecated
    public void prepareViewForInteraction(MaxNativeAdView maxNativeAdView) {
    }
}
