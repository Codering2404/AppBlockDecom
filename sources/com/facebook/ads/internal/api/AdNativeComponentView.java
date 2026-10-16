package com.facebook.ads.internal.api;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AdNativeComponentView extends RelativeLayout implements AdComponentView {
    protected AdComponentViewApi mAdComponentViewApi;
    private final AdComponentViewParentApi mAdComponentViewParentApi;

    public AdNativeComponentView(Context context) {
        super(context);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i3, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i3, int i4) {
                AdNativeComponentView.super.onMeasure(i3, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i3) {
                AdNativeComponentView.super.onVisibilityChanged(view, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z2) {
                AdNativeComponentView.super.onWindowFocusChanged(z2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i3, int i4) {
                AdNativeComponentView.super.setMeasuredDimension(i3, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3) {
                AdNativeComponentView.super.addView(view, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3, int i4) {
                AdNativeComponentView.super.addView(view, i3, i4);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view);
        } else {
            super.addView(view);
        }
    }

    protected void attachAdComponentViewApi(AdComponentViewApiProvider adComponentViewApiProvider) {
        if (DynamicLoaderFactory.isFallbackMode()) {
            return;
        }
        if (this.mAdComponentViewApi != null) {
            throw new IllegalStateException("AdComponentViewApi can't be attached more then once.");
        }
        adComponentViewApiProvider.getAdComponentViewApi().onAttachedToView(this, this.mAdComponentViewParentApi);
        this.mAdComponentViewApi = adComponentViewApiProvider.getAdComponentViewApi();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.bringChildToFront(view);
        } else {
            super.bringChildToFront(view);
        }
    }

    public abstract View getAdContentsView();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onAttachedToWindow();
        } else {
            super.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onDetachedFromWindow();
        } else {
            super.onDetachedFromWindow();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onMeasure(i3, i4);
        } else {
            super.onMeasure(i3, i4);
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onVisibilityChanged(view, i3);
        } else {
            super.onVisibilityChanged(view, i3);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void onWindowFocusChanged(boolean z2) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.onWindowFocusChanged(z2);
        } else {
            super.onWindowFocusChanged(z2);
        }
    }

    @Override // android.view.View, com.facebook.ads.internal.api.AdComponentView
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.setLayoutParams(layoutParams);
        } else {
            super.setLayoutParams(layoutParams);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i3, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i3, int i4) {
                AdNativeComponentView.super.onMeasure(i3, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i3) {
                AdNativeComponentView.super.onVisibilityChanged(view, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z2) {
                AdNativeComponentView.super.onWindowFocusChanged(z2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i3, int i4) {
                AdNativeComponentView.super.setMeasuredDimension(i3, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3) {
                AdNativeComponentView.super.addView(view, i3);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i3, int i4) {
                AdNativeComponentView.super.addView(view, i3, i4);
            }
        };
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i3);
        } else {
            super.addView(view, i3);
        }
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i32, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i32, int i4) {
                AdNativeComponentView.super.onMeasure(i32, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i32) {
                AdNativeComponentView.super.onVisibilityChanged(view, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z2) {
                AdNativeComponentView.super.onWindowFocusChanged(z2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i32, int i4) {
                AdNativeComponentView.super.setMeasuredDimension(i32, i4);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32) {
                AdNativeComponentView.super.addView(view, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32, int i4) {
                AdNativeComponentView.super.addView(view, i32, i4);
            }
        };
    }

    public AdNativeComponentView(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.mAdComponentViewParentApi = new AdComponentViewParentApi() { // from class: com.facebook.ads.internal.api.AdNativeComponentView.1
            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, i32, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void bringChildToFront(View view) {
                AdNativeComponentView.super.bringChildToFront(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onAttachedToWindow() {
                AdNativeComponentView.super.onAttachedToWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onDetachedFromWindow() {
                AdNativeComponentView.super.onDetachedFromWindow();
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onMeasure(int i32, int i42) {
                AdNativeComponentView.super.onMeasure(i32, i42);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void onVisibilityChanged(View view, int i32) {
                AdNativeComponentView.super.onVisibilityChanged(view, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void onWindowFocusChanged(boolean z2) {
                AdNativeComponentView.super.onWindowFocusChanged(z2);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentViewParentApi
            public void setMeasuredDimension(int i32, int i42) {
                AdNativeComponentView.super.setMeasuredDimension(i32, i42);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view) {
                AdNativeComponentView.super.addView(view);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32) {
                AdNativeComponentView.super.addView(view, i32);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView, android.view.ViewManager
            public void addView(View view, ViewGroup.LayoutParams layoutParams) {
                AdNativeComponentView.super.addView(view, layoutParams);
            }

            @Override // com.facebook.ads.internal.api.AdComponentView
            public void addView(View view, int i32, int i42) {
                AdNativeComponentView.super.addView(view, i32, i42);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.ViewManager, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, layoutParams);
        } else {
            super.addView(view, layoutParams);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3, int i4) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i3, i4);
        } else {
            super.addView(view, i3, i4);
        }
    }

    @Override // android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        AdComponentViewApi adComponentViewApi = this.mAdComponentViewApi;
        if (adComponentViewApi != null) {
            adComponentViewApi.addView(view, i3, layoutParams);
        } else {
            super.addView(view, i3, layoutParams);
        }
    }
}
