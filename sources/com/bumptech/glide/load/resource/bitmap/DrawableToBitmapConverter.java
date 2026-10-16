package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class DrawableToBitmapConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final BitmapPool f66865a = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.DrawableToBitmapConverter.1
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
        public void c(Bitmap bitmap) {
        }
    };

    static Resource a(BitmapPool bitmapPool, Drawable drawable, int i3, int i4) {
        Bitmap bitmapB;
        Drawable current = drawable.getCurrent();
        boolean z2 = false;
        if (current instanceof BitmapDrawable) {
            bitmapB = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmapB = null;
        } else {
            bitmapB = b(bitmapPool, current, i3, i4);
            z2 = true;
        }
        if (!z2) {
            bitmapPool = f66865a;
        }
        return BitmapResource.d(bitmapB, bitmapPool);
    }

    private static Bitmap b(BitmapPool bitmapPool, Drawable drawable, int i3, int i4) {
        if (i3 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        }
        if (i4 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
        if (drawable.getIntrinsicWidth() > 0) {
            i3 = drawable.getIntrinsicWidth();
        }
        if (drawable.getIntrinsicHeight() > 0) {
            i4 = drawable.getIntrinsicHeight();
        }
        Lock lockI = TransformationUtils.i();
        lockI.lock();
        Bitmap bitmapD = bitmapPool.d(i3, i4, Bitmap.Config.ARGB_8888);
        try {
            Canvas canvas = new Canvas(bitmapD);
            drawable.setBounds(0, 0, i3, i4);
            drawable.draw(canvas);
            canvas.setBitmap(null);
            return bitmapD;
        } finally {
            lockI.unlock();
        }
    }
}
