package com.applovin.impl;

import android.content.Context;
import android.graphics.PorterDuff;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class o extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProgressBar f62150a;

    public o(Context context, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams;
        super(context);
        setClickable(false);
        ProgressBar progressBar = new ProgressBar(context, null, i4);
        this.f62150a = progressBar;
        progressBar.setIndeterminate(true);
        progressBar.setClickable(false);
        if (i3 == -2 || i3 == -1) {
            layoutParams = new RelativeLayout.LayoutParams(i3, i3);
        } else {
            int iDpToPx = AppLovinSdkUtils.dpToPx(context, i3);
            layoutParams = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx);
        }
        layoutParams.addRule(13);
        progressBar.setLayoutParams(layoutParams);
        addView(progressBar);
    }

    public void a() {
        setVisibility(0);
    }

    public void b() {
        setVisibility(8);
    }

    public void setColor(int i3) {
        this.f62150a.getIndeterminateDrawable().setColorFilter(i3, PorterDuff.Mode.SRC_IN);
    }
}
