package androidx.constraintlayout.utils.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MockView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f33027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Paint f33028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Paint f33029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f33030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f33031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f33032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Rect f33033h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f33034i;

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Canvas canvas2;
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f33030d) {
            width--;
            height--;
            float f3 = width;
            float f4 = height;
            canvas2 = canvas;
            canvas2.drawLine(0.0f, 0.0f, f3, f4, this.f33027a);
            canvas2.drawLine(0.0f, f4, f3, 0.0f, this.f33027a);
            canvas2.drawLine(0.0f, 0.0f, f3, 0.0f, this.f33027a);
            canvas2.drawLine(f3, 0.0f, f3, f4, this.f33027a);
            canvas2.drawLine(f3, f4, 0.0f, f4, this.f33027a);
            canvas2.drawLine(0.0f, f4, 0.0f, 0.0f, this.f33027a);
        } else {
            canvas2 = canvas;
        }
        String str = this.f33032g;
        if (str == null || !this.f33031f) {
            return;
        }
        this.f33028b.getTextBounds(str, 0, str.length(), this.f33033h);
        float fWidth = (width - this.f33033h.width()) / 2.0f;
        float fHeight = ((height - this.f33033h.height()) / 2.0f) + this.f33033h.height();
        this.f33033h.offset((int) fWidth, (int) fHeight);
        Rect rect = this.f33033h;
        int i3 = rect.left;
        int i4 = this.f33034i;
        rect.set(i3 - i4, rect.top - i4, rect.right + i4, rect.bottom + i4);
        canvas2.drawRect(this.f33033h, this.f33029c);
        canvas2.drawText(this.f33032g, fWidth, fHeight, this.f33028b);
    }
}
