package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class CardViewApi21Impl implements CardViewImpl {
    CardViewApi21Impl() {
    }

    private RoundRectDrawable p(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawable) cardViewDelegate.e();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void a(CardViewDelegate cardViewDelegate, float f3) {
        p(cardViewDelegate).h(f3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float b(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).d();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void c(CardViewDelegate cardViewDelegate, float f3) {
        cardViewDelegate.h().setElevation(f3);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float d(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).c();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList e(CardViewDelegate cardViewDelegate) {
        return p(cardViewDelegate).b();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float f(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void g(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void h(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f3, float f4, float f5) {
        cardViewDelegate.c(new RoundRectDrawable(colorStateList, f3));
        View viewH = cardViewDelegate.h();
        viewH.setClipToOutline(true);
        viewH.setElevation(f4);
        o(cardViewDelegate, f5);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float i(CardViewDelegate cardViewDelegate) {
        return cardViewDelegate.h().getElevation();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void j(CardViewDelegate cardViewDelegate) {
        o(cardViewDelegate, d(cardViewDelegate));
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void k(CardViewDelegate cardViewDelegate) {
        if (!cardViewDelegate.d()) {
            cardViewDelegate.b(0, 0, 0, 0);
            return;
        }
        float fD = d(cardViewDelegate);
        float fB = b(cardViewDelegate);
        int iCeil = (int) Math.ceil(RoundRectDrawableWithShadow.c(fD, fB, cardViewDelegate.g()));
        int iCeil2 = (int) Math.ceil(RoundRectDrawableWithShadow.d(fD, fB, cardViewDelegate.g()));
        cardViewDelegate.b(iCeil, iCeil2, iCeil, iCeil2);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float m(CardViewDelegate cardViewDelegate) {
        return b(cardViewDelegate) * 2.0f;
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void n(CardViewDelegate cardViewDelegate, ColorStateList colorStateList) {
        p(cardViewDelegate).f(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void o(CardViewDelegate cardViewDelegate, float f3) {
        p(cardViewDelegate).g(f3, cardViewDelegate.d(), cardViewDelegate.g());
        k(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void l() {
    }
}
