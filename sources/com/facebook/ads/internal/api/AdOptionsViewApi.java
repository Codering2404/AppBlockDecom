package com.facebook.ads.internal.api;

import com.facebook.ads.AdClosedListener;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AdOptionsViewApi extends AdComponentViewApiProvider {
    void setIconColor(int i3);

    void setIconSizeDp(int i3);

    void setOnAdClosedListener(AdClosedListener adClosedListener);

    void setSingleIcon(boolean z2);
}
