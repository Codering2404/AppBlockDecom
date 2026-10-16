package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Target<R> extends LifecycleListener {
    Request b();

    void c(SizeReadyCallback sizeReadyCallback);

    void f(Drawable drawable);

    void g(Drawable drawable);

    void h(Object obj, Transition transition);

    void i(Request request);

    void j(Drawable drawable);

    void k(SizeReadyCallback sizeReadyCallback);
}
