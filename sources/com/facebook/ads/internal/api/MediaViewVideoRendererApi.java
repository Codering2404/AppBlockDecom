package com.facebook.ads.internal.api;

import android.view.View;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.VideoStartReason;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface MediaViewVideoRendererApi extends AdComponentViewApiProvider {
    void destroy();

    void disengageSeek(VideoStartReason videoStartReason);

    void engageSeek();

    int getCurrentTimeMs();

    int getDuration();

    View getVideoView();

    float getVolume();

    void initialize(AdViewConstructorParams adViewConstructorParams, MediaViewVideoRenderer mediaViewVideoRenderer);

    void pause(boolean z2);

    void play(VideoStartReason videoStartReason);

    void seekTo(int i3);

    void setVolume(float f3);

    boolean shouldAutoplay();
}
