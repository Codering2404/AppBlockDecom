package com.facebook.ads.internal.api;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface AdComponentView {
    void addView(View view);

    void addView(View view, int i3);

    void addView(View view, int i3, int i4);

    void addView(View view, int i3, ViewGroup.LayoutParams layoutParams);

    void addView(View view, ViewGroup.LayoutParams layoutParams);

    void onWindowFocusChanged(boolean z2);

    void setLayoutParams(ViewGroup.LayoutParams layoutParams);
}
