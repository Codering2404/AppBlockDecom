package com.facebook.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ads.internal.api.AdComponentFrameLayout;
import com.facebook.ads.internal.api.AdViewConstructorParams;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MediaViewVideoRenderer extends AdComponentFrameLayout {
    private MediaViewVideoRendererApi mMediaViewVideoRendererApi;

    @Deprecated
    protected NativeAd nativeAd;

    @Deprecated
    protected VideoAutoplayBehavior videoAutoplayBehavior;

    public MediaViewVideoRenderer(Context context) {
        super(context);
        initialize(new AdViewConstructorParams(context));
    }

    private void initialize(AdViewConstructorParams adViewConstructorParams) {
        MediaViewVideoRendererApi mediaViewVideoRendererApiCreateMediaViewVideoRendererApi = DynamicLoaderFactory.makeLoader(adViewConstructorParams.getContext()).createMediaViewVideoRendererApi();
        this.mMediaViewVideoRendererApi = mediaViewVideoRendererApiCreateMediaViewVideoRendererApi;
        attachAdComponentViewApi(mediaViewVideoRendererApiCreateMediaViewVideoRendererApi);
        this.mMediaViewVideoRendererApi.initialize(adViewConstructorParams, this);
    }

    @Override // com.facebook.ads.internal.api.AdComponentFrameLayout, android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view) {
    }

    public final void disengageSeek(VideoStartReason videoStartReason) {
        this.mMediaViewVideoRendererApi.disengageSeek(videoStartReason);
    }

    public final void engageSeek() {
        this.mMediaViewVideoRendererApi.engageSeek();
    }

    public final int getCurrentTimeMs() {
        return this.mMediaViewVideoRendererApi.getCurrentTimeMs();
    }

    public final int getDuration() {
        return this.mMediaViewVideoRendererApi.getDuration();
    }

    public MediaViewVideoRendererApi getMediaViewVideoRendererApi() {
        return this.mMediaViewVideoRendererApi;
    }

    @Deprecated
    final View getVideoView() {
        return this.mMediaViewVideoRendererApi.getVideoView();
    }

    public final float getVolume() {
        return this.mMediaViewVideoRendererApi.getVolume();
    }

    public final void pause(boolean z2) {
        this.mMediaViewVideoRendererApi.pause(z2);
    }

    public final void play(VideoStartReason videoStartReason) {
        this.mMediaViewVideoRendererApi.play(videoStartReason);
    }

    public final void seekTo(int i3) {
        this.mMediaViewVideoRendererApi.seekTo(i3);
    }

    @Deprecated
    public void setNativeAd(NativeAd nativeAd) {
        this.nativeAd = nativeAd;
        this.videoAutoplayBehavior = nativeAd.getVideoAutoplayBehavior();
    }

    public final void setVolume(float f3) {
        this.mMediaViewVideoRendererApi.setVolume(f3);
    }

    public boolean shouldAllowBackgroundPlayback() {
        return false;
    }

    public final boolean shouldAutoplay() {
        return this.mMediaViewVideoRendererApi.shouldAutoplay();
    }

    @Deprecated
    public void unsetNativeAd() {
        this.nativeAd = null;
        this.videoAutoplayBehavior = VideoAutoplayBehavior.DEFAULT;
    }

    @Override // com.facebook.ads.internal.api.AdComponentFrameLayout, android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3) {
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initialize(new AdViewConstructorParams(context, attributeSet));
    }

    @Override // com.facebook.ads.internal.api.AdComponentFrameLayout, android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3, int i4) {
    }

    @Override // com.facebook.ads.internal.api.AdComponentFrameLayout, android.view.ViewGroup, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        initialize(new AdViewConstructorParams(context, attributeSet, i3));
    }

    @Override // com.facebook.ads.internal.api.AdComponentFrameLayout, android.view.ViewGroup, android.view.ViewManager, com.facebook.ads.internal.api.AdComponentView
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
    }

    public MediaViewVideoRenderer(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        initialize(new AdViewConstructorParams(context, attributeSet, i3, i4));
    }

    @Deprecated
    public void destroy() {
    }

    public void onCompleted() {
    }

    public void onError() {
    }

    public void onPaused() {
    }

    public void onPlayed() {
    }

    public void onPrepared() {
    }

    public void onSeek() {
    }

    public void onSeekDisengaged() {
    }

    public void onSeekEngaged() {
    }

    public void onVolumeChanged() {
    }

    @Deprecated
    final void setListener(Object obj) {
    }
}
