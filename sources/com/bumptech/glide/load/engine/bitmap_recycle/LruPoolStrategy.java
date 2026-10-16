package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
interface LruPoolStrategy {
    String a(Bitmap bitmap);

    String b(int i3, int i4, Bitmap.Config config);

    void c(Bitmap bitmap);

    Bitmap d(int i3, int i4, Bitmap.Config config);

    int e(Bitmap bitmap);

    Bitmap removeLast();
}
