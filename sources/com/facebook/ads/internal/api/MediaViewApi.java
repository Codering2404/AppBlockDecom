package com.facebook.ads.internal.api;

import android.view.View;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.MediaViewVideoRenderer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MediaViewApi extends AdComponentViewApiProvider {
    void destroy();

    View getAdContentsView();

    int getMediaHeight();

    int getMediaWidth();

    int getVideoDuration();

    void initialize(AdViewConstructorParams adViewConstructorParams, MediaView mediaView);

    boolean isVideoContent();

    void setListener(MediaViewListener mediaViewListener);

    void setVideoRenderer(MediaViewVideoRenderer mediaViewVideoRenderer);
}
