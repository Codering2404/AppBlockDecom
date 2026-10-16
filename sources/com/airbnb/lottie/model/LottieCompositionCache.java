package com.airbnb.lottie.model;

import androidx.collection.LruCache;
import com.airbnb.lottie.LottieComposition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class LottieCompositionCache {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final LottieCompositionCache f56711b = new LottieCompositionCache();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache f56712a = new LruCache(20);

    LottieCompositionCache() {
    }

    public static LottieCompositionCache b() {
        return f56711b;
    }

    public LottieComposition a(String str) {
        if (str == null) {
            return null;
        }
        return (LottieComposition) this.f56712a.get(str);
    }

    public void c(String str, LottieComposition lottieComposition) {
        if (str == null) {
            return;
        }
        this.f56712a.put(str, lottieComposition);
    }
}
