package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class CardView extends FrameLayout {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f2743i = {R.attr.colorBackground};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final CardViewImpl f2744j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f2747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f2748d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Rect f2749f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Rect f2750g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CardViewDelegate f2751h;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        f2744j = cardViewApi21Impl;
        cardViewApi21Impl.l();
    }

    public CardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.cardview.R.attr.f2722a);
    }

    public ColorStateList getCardBackgroundColor() {
        return f2744j.e(this.f2751h);
    }

    public float getCardElevation() {
        return f2744j.i(this.f2751h);
    }

    public int getContentPaddingBottom() {
        return this.f2749f.bottom;
    }

    public int getContentPaddingLeft() {
        return this.f2749f.left;
    }

    public int getContentPaddingRight() {
        return this.f2749f.right;
    }

    public int getContentPaddingTop() {
        return this.f2749f.top;
    }

    public float getMaxCardElevation() {
        return f2744j.d(this.f2751h);
    }

    public boolean getPreventCornerOverlap() {
        return this.f2746b;
    }

    public float getRadius() {
        return f2744j.b(this.f2751h);
    }

    public boolean getUseCompatPadding() {
        return this.f2745a;
    }

    public void h(int i3, int i4, int i5, int i6) {
        this.f2749f.set(i3, i4, i5, i6);
        f2744j.k(this.f2751h);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        if (f2744j instanceof CardViewApi21Impl) {
            super.onMeasure(i3, i4);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.m(this.f2751h)), View.MeasureSpec.getSize(i3)), mode);
        }
        int mode2 = View.MeasureSpec.getMode(i4);
        if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
            i4 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.f(this.f2751h)), View.MeasureSpec.getSize(i4)), mode2);
        }
        super.onMeasure(i3, i4);
    }

    public void setCardBackgroundColor(int i3) {
        f2744j.n(this.f2751h, ColorStateList.valueOf(i3));
    }

    public void setCardElevation(float f3) {
        f2744j.c(this.f2751h, f3);
    }

    public void setMaxCardElevation(float f3) {
        f2744j.o(this.f2751h, f3);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.f2748d = i3;
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        this.f2747c = i3;
        super.setMinimumWidth(i3);
    }

    public void setPreventCornerOverlap(boolean z2) {
        if (z2 != this.f2746b) {
            this.f2746b = z2;
            f2744j.g(this.f2751h);
        }
    }

    public void setRadius(float f3) {
        f2744j.a(this.f2751h, f3);
    }

    public void setUseCompatPadding(boolean z2) {
        if (this.f2745a != z2) {
            this.f2745a = z2;
            f2744j.j(this.f2751h);
        }
    }

    public CardView(Context context, AttributeSet attributeSet, int i3) {
        ColorStateList colorStateListValueOf;
        super(context, attributeSet, i3);
        Rect rect = new Rect();
        this.f2749f = rect;
        this.f2750g = new Rect();
        CardViewDelegate cardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Drawable f2752a;

            @Override // androidx.cardview.widget.CardViewDelegate
            public void b(int i4, int i5, int i6, int i7) {
                CardView.this.f2750g.set(i4, i5, i6, i7);
                CardView cardView = CardView.this;
                Rect rect2 = cardView.f2749f;
                CardView.super.setPadding(i4 + rect2.left, i5 + rect2.top, i6 + rect2.right, i7 + rect2.bottom);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void c(Drawable drawable) {
                this.f2752a = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean d() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public Drawable e() {
                return this.f2752a;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void f(int i4, int i5) {
                CardView cardView = CardView.this;
                if (i4 > cardView.f2747c) {
                    CardView.super.setMinimumWidth(i4);
                }
                CardView cardView2 = CardView.this;
                if (i5 > cardView2.f2748d) {
                    CardView.super.setMinimumHeight(i5);
                }
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean g() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public View h() {
                return CardView.this;
            }
        };
        this.f2751h = cardViewDelegate;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.f2729a, i3, androidx.cardview.R.style.f2728a);
        int i4 = androidx.cardview.R.styleable.f2732d;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            colorStateListValueOf = typedArrayObtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(f2743i);
            int color = typedArrayObtainStyledAttributes2.getColor(0, 0);
            typedArrayObtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            colorStateListValueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(androidx.cardview.R.color.f2724b) : getResources().getColor(androidx.cardview.R.color.f2723a));
        }
        ColorStateList colorStateList = colorStateListValueOf;
        float dimension = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.f2733e, 0.0f);
        float dimension2 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.f2734f, 0.0f);
        float dimension3 = typedArrayObtainStyledAttributes.getDimension(androidx.cardview.R.styleable.f2735g, 0.0f);
        this.f2745a = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.f2737i, false);
        this.f2746b = typedArrayObtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.f2736h, true);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2738j, 0);
        rect.left = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2740l, dimensionPixelSize);
        rect.top = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2742n, dimensionPixelSize);
        rect.right = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2741m, dimensionPixelSize);
        rect.bottom = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2739k, dimensionPixelSize);
        float f3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.f2747c = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2730b, 0);
        this.f2748d = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.f2731c, 0);
        typedArrayObtainStyledAttributes.recycle();
        f2744j.h(cardViewDelegate, context, colorStateList, dimension, dimension2, f3);
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        f2744j.n(this.f2751h, colorStateList);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
    }
}
