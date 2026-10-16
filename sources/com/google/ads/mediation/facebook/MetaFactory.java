package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.RewardedVideoAd;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MetaFactory {
    public InterstitialAd a(Context context, String str) {
        return new InterstitialAd(context, str);
    }

    public InterstitialAd b(Context context, String str) {
        return new InterstitialAd(context, str);
    }

    public MediaView c(Context context) {
        return new MediaView(context);
    }

    public AdView d(Context context, String str, String str2) {
        return new AdView(context, str, str2);
    }

    public RewardedVideoAd e(Context context, String str) {
        return new RewardedVideoAd(context, str);
    }
}
