package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final RectF f2755a;

    private RoundRectDrawableWithShadow p(Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f3, f4, f5);
    }

    private RoundRectDrawableWithShadow q(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.e();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void a(CardViewDelegate cardViewDelegate, float f3) {
        q(cardViewDelegate).p(f3);
        k(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float b(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).g();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void c(CardViewDelegate cardViewDelegate, float f3) {
        q(cardViewDelegate).r(f3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float d(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).i();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList e(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).f();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float f(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).j();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void g(CardViewDelegate cardViewDelegate) {
        q(cardViewDelegate).m(cardViewDelegate.g());
        k(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void h(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        RoundRectDrawableWithShadow roundRectDrawableWithShadowP = p(context, colorStateList, f3, f4, f5);
        roundRectDrawableWithShadowP.m(cardViewDelegate.g());
        cardViewDelegate.c(roundRectDrawableWithShadowP);
        k(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float i(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).l();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void k(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        q(cardViewDelegate).h(rect);
        cardViewDelegate.f((int) Math.ceil(m(cardViewDelegate)), (int) Math.ceil(f(cardViewDelegate)));
        cardViewDelegate.b(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void l() {
        RoundRectDrawableWithShadow.f2769r = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: androidx.cardview.widget.CardViewBaseImpl.1
            @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void a(Canvas canvas, RectF rectF, float f3, Paint paint) {
                float f4 = 2.0f * f3;
                float fWidth = (rectF.width() - f4) - 1.0f;
                float fHeight = (rectF.height() - f4) - 1.0f;
                if (f3 >= 1.0f) {
                    float f5 = f3 + 0.5f;
                    float f6 = -f5;
                    CardViewBaseImpl.this.f2755a.set(f6, f6, f5, f5);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f5, rectF.top + f5);
                    canvas.drawArc(CardViewBaseImpl.this.f2755a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2755a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2755a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f2755a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    float f7 = (rectF.left + f5) - 1.0f;
                    float f8 = rectF.top;
                    canvas.drawRect(f7, f8, (rectF.right - f5) + 1.0f, f8 + f5, paint);
                    float f9 = (rectF.left + f5) - 1.0f;
                    float f10 = rectF.bottom;
                    canvas.drawRect(f9, f10 - f5, (rectF.right - f5) + 1.0f, f10, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f3, rectF.right, rectF.bottom - f3, paint);
            }
        };
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float m(CardViewDelegate cardViewDelegate) {
        return q(cardViewDelegate).k();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void n(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        q(cardViewDelegate).o(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void o(CardViewDelegate cardViewDelegate, float f3) {
        q(cardViewDelegate).q(f3);
        k(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void j(CardViewDelegate cardViewDelegate) {
    }
}
