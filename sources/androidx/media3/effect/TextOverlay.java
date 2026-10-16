package androidx.media3.effect;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.media3.common.OverlaySettings;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TextOverlay extends BitmapOverlay {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Bitmap f42632f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SpannableString f42633g;

    /* JADX INFO: renamed from: androidx.media3.effect.TextOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends TextOverlay {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ SpannableString f42634h;

        @Override // androidx.media3.effect.TextOverlay
        public SpannableString j(long j3) {
            return this.f42634h;
        }
    }

    /* JADX INFO: renamed from: androidx.media3.effect.TextOverlay$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends TextOverlay {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ SpannableString f42635h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ StaticOverlaySettings f42636i;

        @Override // androidx.media3.effect.TextureOverlay
        public OverlaySettings b(long j3) {
            return this.f42636i;
        }

        @Override // androidx.media3.effect.TextOverlay
        public SpannableString j(long j3) {
            return this.f42635h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Api23 {
        public static StaticLayout a(SpannableString spannableString, TextPaint textPaint, int i3) {
            return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i3).build();
        }
    }

    private StaticLayout h(SpannableString spannableString, TextPaint textPaint, int i3) {
        return Util.f41609a >= 23 ? Api23.a(spannableString, textPaint, i3) : new StaticLayout(spannableString, textPaint, i3, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private int i(SpannableString spannableString, TextPaint textPaint) {
        StaticLayout staticLayoutH = h(spannableString, textPaint, (int) textPaint.measureText(spannableString, 0, spannableString.length()));
        int lineCount = staticLayoutH.getLineCount();
        float lineWidth = 0.0f;
        for (int i3 = 0; i3 < lineCount; i3++) {
            lineWidth += staticLayoutH.getLineWidth(i3);
        }
        return (int) Math.ceil(lineWidth);
    }

    @Override // androidx.media3.effect.BitmapOverlay
    public Bitmap g(long j3) {
        SpannableString spannableStringJ = j(j3);
        if (!spannableStringJ.equals(this.f42633g)) {
            this.f42633g = spannableStringJ;
            TextPaint textPaint = new TextPaint();
            textPaint.setTextSize(100.0f);
            StaticLayout staticLayoutH = h(spannableStringJ, textPaint, i(spannableStringJ, textPaint));
            Bitmap bitmap = this.f42632f;
            if (bitmap == null || bitmap.getWidth() != staticLayoutH.getWidth() || this.f42632f.getHeight() != staticLayoutH.getHeight()) {
                this.f42632f = Bitmap.createBitmap(staticLayoutH.getWidth(), staticLayoutH.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas((Bitmap) Assertions.e(this.f42632f));
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            staticLayoutH.draw(canvas);
        }
        return (Bitmap) Assertions.e(this.f42632f);
    }

    public abstract SpannableString j(long j3);
}
