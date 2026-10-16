package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.Assertions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DrawableOverlay extends BitmapOverlay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f42370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f42371g;

    /* JADX INFO: renamed from: androidx.media3.effect.DrawableOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends DrawableOverlay {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Drawable f42372h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ StaticOverlaySettings f42373i;

        @Override // androidx.media3.effect.TextureOverlay
        public OverlaySettings b(long j3) {
            return this.f42373i;
        }

        @Override // androidx.media3.effect.DrawableOverlay
        public Drawable h(long j3) {
            return this.f42372h;
        }
    }

    @Override // androidx.media3.effect.BitmapOverlay
    public Bitmap g(long j3) {
        Drawable drawableH = h(j3);
        if (!drawableH.equals(this.f42371g)) {
            this.f42371g = drawableH;
            Bitmap bitmap = this.f42370f;
            if (bitmap == null || bitmap.getWidth() != this.f42371g.getIntrinsicWidth() || this.f42370f.getHeight() != this.f42371g.getIntrinsicHeight()) {
                this.f42370f = Bitmap.createBitmap(this.f42371g.getIntrinsicWidth(), this.f42371g.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(this.f42370f);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f42371g.draw(canvas);
        }
        return (Bitmap) Assertions.e(this.f42370f);
    }

    public abstract Drawable h(long j3);
}
