package com.bumptech.glide.util;

import com.bumptech.glide.ListPreloader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class FixedPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f67281a;

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] a(Object obj, int i3, int i4) {
        return this.f67281a;
    }
}
