package com.facebook.ads.internal.api;

import android.view.View;
import android.widget.ImageView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.VideoAutoplayBehavior;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface NativeAdApi {
    NativeAd.AdCreativeType getAdCreativeType();

    VideoAutoplayBehavior getVideoAutoplayBehavior();

    void registerViewForInteraction(View view, MediaView mediaView);

    void registerViewForInteraction(View view, MediaView mediaView, ImageView imageView);

    void registerViewForInteraction(View view, MediaView mediaView, ImageView imageView, List<View> list);

    void registerViewForInteraction(View view, MediaView mediaView, MediaView mediaView2);

    void registerViewForInteraction(View view, MediaView mediaView, MediaView mediaView2, List<View> list);

    void registerViewForInteraction(View view, MediaView mediaView, List<View> list);
}
