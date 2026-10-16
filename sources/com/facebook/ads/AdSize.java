package com.facebook.ads;

import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AdSize implements Serializable {
    private final int UNDEFINED;
    private AdSizeApi mAdSizeApi;
    private final int mInitHeight;
    private final int mInitSizeType;
    private final int mInitWidth;

    @Deprecated
    public static final AdSize BANNER_320_50 = new AdSize(4);
    public static final AdSize INTERSTITIAL = new AdSize(100);
    public static final AdSize BANNER_HEIGHT_50 = new AdSize(5);
    public static final AdSize BANNER_HEIGHT_90 = new AdSize(6);
    public static final AdSize RECTANGLE_HEIGHT_250 = new AdSize(7);

    public AdSize(int i3, int i4) {
        this.UNDEFINED = -1;
        this.mInitSizeType = -1;
        this.mInitWidth = i3;
        this.mInitHeight = i4;
    }

    public static AdSize fromWidthAndHeight(int i3, int i4) {
        AdSize adSize = INTERSTITIAL;
        if (adSize.getHeight() == i4 && adSize.getWidth() == i3) {
            return adSize;
        }
        AdSize adSize2 = BANNER_320_50;
        if (adSize2.getHeight() == i4 && adSize2.getWidth() == i3) {
            return adSize2;
        }
        AdSize adSize3 = BANNER_HEIGHT_50;
        if (adSize3.getHeight() == i4 && adSize3.getWidth() == i3) {
            return adSize3;
        }
        AdSize adSize4 = BANNER_HEIGHT_90;
        if (adSize4.getHeight() == i4 && adSize4.getWidth() == i3) {
            return adSize4;
        }
        AdSize adSize5 = RECTANGLE_HEIGHT_250;
        if (adSize5.getHeight() == i4 && adSize5.getWidth() == i3) {
            return adSize5;
        }
        throw new IllegalArgumentException("Can't create AdSize using this width = " + i3 + " && height = " + i4);
    }

    private AdSizeApi getAdSizeApi(int i3) {
        if (this.mAdSizeApi == null) {
            this.mAdSizeApi = DynamicLoaderFactory.makeLoaderUnsafe().createAdSizeApi(i3);
        }
        return this.mAdSizeApi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AdSize adSize = (AdSize) obj;
            if (getWidth() == adSize.getWidth() && getHeight() == adSize.getHeight()) {
                return true;
            }
        }
        return false;
    }

    public int getHeight() {
        int i3 = this.mInitSizeType;
        return i3 != -1 ? getAdSizeApi(i3).getHeight() : this.mInitHeight;
    }

    public int getWidth() {
        int i3 = this.mInitSizeType;
        return i3 != -1 ? getAdSizeApi(i3).getWidth() : this.mInitWidth;
    }

    public int hashCode() {
        return (getWidth() * 31) + getHeight();
    }

    private AdSize(int i3) {
        this.UNDEFINED = -1;
        this.mInitSizeType = i3;
        this.mInitWidth = -1;
        this.mInitHeight = -1;
    }
}
