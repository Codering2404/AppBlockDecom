package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.RemoteViews;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class NotificationTarget extends CustomTarget<Bitmap> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RemoteViews f67213d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f67214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f67215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f67216h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Notification f67217i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f67218j;

    private void d(Bitmap bitmap) {
        this.f67213d.setImageViewBitmap(this.f67218j, bitmap);
        e();
    }

    private void e() {
        ((NotificationManager) Preconditions.e((NotificationManager) this.f67214f.getSystemService("notification"))).notify(this.f67216h, this.f67215g, this.f67217i);
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
