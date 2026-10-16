package com.applovin.impl.adview;

import android.content.Context;
import android.widget.VideoView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinVideoView extends VideoView {
    public AppLovinVideoView(Context context) {
        super(context, null, 0);
    }

    public void setVideoSize(int i3, int i4) {
        getHolder().setFixedSize(i3, i4);
        requestLayout();
        invalidate();
    }
}
