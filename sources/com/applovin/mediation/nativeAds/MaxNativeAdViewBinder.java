package com.applovin.mediation.nativeAds;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxNativeAdViewBinder {
    protected final int advertiserTextViewId;
    protected final int bodyTextViewId;
    protected final int callToActionButtonId;
    protected final int iconContentViewId;
    protected final int iconImageViewId;
    protected final int layoutResourceId;
    protected final View mainView;
    protected final int mediaContentFrameLayoutId;
    protected final int mediaContentViewGroupId;
    protected final int optionsContentFrameLayoutId;
    protected final int optionsContentViewGroupId;
    protected final int starRatingContentViewGroupId;
    protected final String templateType;
    protected final int titleTextViewId;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f65554a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f65555b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f65556c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f65557d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f65558e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f65559f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f65560g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f65561h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f65562i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f65563j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f65564k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f65565l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f65566m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private String f65567n;

        public Builder(View view) {
            this(-1, view);
        }

        public MaxNativeAdViewBinder build() {
            return new MaxNativeAdViewBinder(this.f65554a, this.f65555b, this.f65556c, this.f65557d, this.f65558e, this.f65559f, this.f65560g, this.f65563j, this.f65561h, this.f65562i, this.f65564k, this.f65565l, this.f65566m, this.f65567n);
        }

        public Builder setAdvertiserTextViewId(int i3) {
            this.f65557d = i3;
            return this;
        }

        public Builder setBodyTextViewId(int i3) {
            this.f65558e = i3;
            return this;
        }

        public Builder setCallToActionButtonId(int i3) {
            this.f65566m = i3;
            return this;
        }

        @Deprecated
        protected Builder setIconContentViewId(int i3) {
            this.f65560g = i3;
            return this;
        }

        public Builder setIconImageViewId(int i3) {
            this.f65559f = i3;
            return this;
        }

        @Deprecated
        protected Builder setMediaContentFrameLayoutId(int i3) {
            this.f65565l = i3;
            return this;
        }

        public Builder setMediaContentViewGroupId(int i3) {
            this.f65564k = i3;
            return this;
        }

        @Deprecated
        protected Builder setOptionsContentFrameLayoutId(int i3) {
            this.f65562i = i3;
            return this;
        }

        public Builder setOptionsContentViewGroupId(int i3) {
            this.f65561h = i3;
            return this;
        }

        public Builder setStarRatingContentViewGroupId(int i3) {
            this.f65563j = i3;
            return this;
        }

        protected Builder setTemplateType(String str) {
            this.f65567n = str;
            return this;
        }

        public Builder setTitleTextViewId(int i3) {
            this.f65556c = i3;
            return this;
        }

        public Builder(int i3) {
            this(i3, null);
        }

        private Builder(int i3, View view) {
            this.f65556c = -1;
            this.f65557d = -1;
            this.f65558e = -1;
            this.f65559f = -1;
            this.f65560g = -1;
            this.f65561h = -1;
            this.f65562i = -1;
            this.f65563j = -1;
            this.f65564k = -1;
            this.f65565l = -1;
            this.f65566m = -1;
            this.f65555b = i3;
            this.f65554a = view;
        }
    }

    private MaxNativeAdViewBinder(View view, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, String str) {
        this.mainView = view;
        this.layoutResourceId = i3;
        this.titleTextViewId = i4;
        this.advertiserTextViewId = i5;
        this.bodyTextViewId = i6;
        this.iconImageViewId = i7;
        this.iconContentViewId = i8;
        this.starRatingContentViewGroupId = i9;
        this.optionsContentViewGroupId = i10;
        this.optionsContentFrameLayoutId = i11;
        this.mediaContentViewGroupId = i12;
        this.mediaContentFrameLayoutId = i13;
        this.callToActionButtonId = i14;
        this.templateType = str;
    }
}
