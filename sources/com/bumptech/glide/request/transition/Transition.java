package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface Transition<R> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ViewAdapter {
        View a();

        void d(Drawable drawable);

        Drawable e();
    }

    boolean a(Object obj, ViewAdapter viewAdapter);
}
