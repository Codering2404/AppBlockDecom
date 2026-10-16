package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zam;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zad f71945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f71946b;

    protected abstract void a(Drawable drawable, boolean z2, boolean z3, boolean z4);

    final void b(Context context, zam zamVar, boolean z2) {
        int i3 = this.f71946b;
        a(i3 != 0 ? context.getResources().getDrawable(i3) : null, z2, false, false);
    }

    final void c(Context context, Bitmap bitmap, boolean z2) {
        Asserts.c(bitmap);
        a(new BitmapDrawable(context.getResources(), bitmap), false, false, true);
    }
}
