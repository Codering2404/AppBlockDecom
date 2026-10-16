package com.bumptech.glide.util;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.ListPreloader;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ViewPreloadSizeProvider<T> implements ListPreloader.PreloadSizeProvider<T>, SizeReadyCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f67299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SizeViewTarget f67300b;

    @Override // com.bumptech.glide.ListPreloader.PreloadSizeProvider
    public int[] a(Object obj, int i3, int i4) {
        int[] iArr = this.f67299a;
        if (iArr == null) {
            return null;
        }
        return Arrays.copyOf(iArr, iArr.length);
    }

    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public void d(int i3, int i4) {
        this.f67299a = new int[]{i3, i4};
        this.f67300b = null;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SizeViewTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.Target
        public void j(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void l(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void h(Object obj, Transition transition) {
        }
    }
}
