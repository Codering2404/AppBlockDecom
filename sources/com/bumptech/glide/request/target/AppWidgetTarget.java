package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppWidgetTarget extends CustomTarget<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f67181d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ComponentName f67182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RemoteViews f67183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f67184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f67185i;

    private void d(Bitmap bitmap) {
        this.f67183g.setImageViewBitmap(this.f67185i, bitmap);
        e();
    }

    private void e() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.f67184h);
        ComponentName componentName = this.f67182f;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.f67183g);
        } else {
            appWidgetManager.updateAppWidget(this.f67181d, this.f67183g);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void h(Bitmap bitmap, Transition transition) {
        d(bitmap);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void g(Drawable drawable) {
        d(null);
    }
}
