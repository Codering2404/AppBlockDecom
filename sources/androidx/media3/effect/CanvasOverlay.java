package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Size;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class CanvasOverlay extends BitmapOverlay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f42226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Bitmap f42227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Canvas f42228h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f42229i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f42230j;

    @Override // androidx.media3.effect.TextureOverlay
    public void a(Size size) {
        super.a(size);
        if (this.f42226f) {
            i(size.b(), size.a());
        }
    }

    @Override // androidx.media3.effect.BitmapOverlay, androidx.media3.effect.TextureOverlay
    public void f() throws VideoFrameProcessingException {
        super.f();
        Bitmap bitmap = this.f42227g;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    @Override // androidx.media3.effect.BitmapOverlay
    public Bitmap g(long j3) {
        Bitmap bitmap = this.f42227g;
        if (bitmap == null || bitmap.getWidth() != this.f42229i || this.f42227g.getHeight() != this.f42230j) {
            this.f42227g = Bitmap.createBitmap(this.f42229i, this.f42230j, Bitmap.Config.ARGB_8888);
            this.f42228h = new Canvas(this.f42227g);
        }
        h((Canvas) Assertions.e(this.f42228h), j3);
        return this.f42227g;
    }

    public abstract void h(Canvas canvas, long j3);

    public void i(int i3, int i4) {
        this.f42229i = i3;
        this.f42230j = i4;
    }
}
