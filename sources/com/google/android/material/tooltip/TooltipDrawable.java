package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int S = R.style.W;
    private static final int T = R.attr.G0;
    private CharSequence A;
    private final Context B;
    private final Paint.FontMetrics C;
    private final TextDrawableHelper D;
    private final View.OnLayoutChangeListener E;
    private final Rect F;
    private int G;
    private int H;
    private int I;
    private int J;
    private boolean K;
    private int L;
    private int M;
    private float N;
    private float O;
    private final float P;
    private float Q;
    private float R;

    private TooltipDrawable(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.C = new Paint.FontMetrics();
        TextDrawableHelper textDrawableHelper = new TextDrawableHelper(this);
        this.D = textDrawableHelper;
        this.E = new View.OnLayoutChangeListener() { // from class: com.google.android.material.tooltip.TooltipDrawable.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
                TooltipDrawable.this.E0(view);
            }
        };
        this.F = new Rect();
        this.N = 1.0f;
        this.O = 1.0f;
        this.P = 0.5f;
        this.Q = 0.5f;
        this.R = 1.0f;
        this.B = context;
        textDrawableHelper.g().density = context.getResources().getDisplayMetrics().density;
        textDrawableHelper.g().setTextAlign(Paint.Align.CENTER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        this.M = iArr[0];
        view.getWindowVisibleDisplayFrame(this.F);
    }

    private float r0() {
        int i3;
        if (((this.F.right - getBounds().right) - this.M) - this.J < 0) {
            i3 = ((this.F.right - getBounds().right) - this.M) - this.J;
        } else {
            if (((this.F.left - getBounds().left) - this.M) + this.J <= 0) {
                return 0.0f;
            }
            i3 = ((this.F.left - getBounds().left) - this.M) + this.J;
        }
        return i3;
    }

    private float s0() {
        this.D.g().getFontMetrics(this.C);
        Paint.FontMetrics fontMetrics = this.C;
        return (fontMetrics.descent + fontMetrics.ascent) / 2.0f;
    }

    private float t0(Rect rect) {
        return rect.centerY() - s0();
    }

    public static TooltipDrawable u0(Context context, AttributeSet attributeSet, int i3, int i4) {
        TooltipDrawable tooltipDrawable = new TooltipDrawable(context, attributeSet, i3, i4);
        tooltipDrawable.z0(attributeSet, i3, i4);
        return tooltipDrawable;
    }

    private EdgeTreatment v0() {
        float f3 = -r0();
        float fWidth = ((float) (((double) getBounds().width()) - (((double) this.L) * Math.sqrt(2.0d)))) / 2.0f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(this.L), Math.min(Math.max(f3, -fWidth), fWidth));
    }

    private void x0(Canvas canvas) {
        if (this.A == null) {
            return;
        }
        int iT0 = (int) t0(getBounds());
        if (this.D.e() != null) {
            this.D.g().drawableState = getState();
            this.D.n(this.B);
            this.D.g().setAlpha((int) (this.R * 255.0f));
        }
        CharSequence charSequence = this.A;
        canvas.drawText(charSequence, 0, charSequence.length(), r0.centerX(), iT0, this.D.g());
    }

    private float y0() {
        CharSequence charSequence = this.A;
        if (charSequence == null) {
            return 0.0f;
        }
        return this.D.h(charSequence.toString());
    }

    private void z0(AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayI = ThemeEnforcement.i(this.B, attributeSet, R.styleable.H9, i3, i4, new int[0]);
        this.L = this.B.getResources().getDimensionPixelSize(R.dimen.N0);
        boolean z2 = typedArrayI.getBoolean(R.styleable.Q9, true);
        this.K = z2;
        if (z2) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().s(v0()).m());
        } else {
            this.L = 0;
        }
        C0(typedArrayI.getText(R.styleable.O9));
        TextAppearance textAppearanceH = MaterialResources.h(this.B, typedArrayI, R.styleable.I9);
        if (textAppearanceH != null) {
            int i5 = R.styleable.J9;
            if (typedArrayI.hasValue(i5)) {
                textAppearanceH.k(MaterialResources.a(this.B, typedArrayI, i5));
            }
        }
        D0(textAppearanceH);
        a0(ColorStateList.valueOf(typedArrayI.getColor(R.styleable.P9, MaterialColors.k(ColorUtils.k(MaterialColors.c(this.B, android.R.attr.colorBackground, TooltipDrawable.class.getCanonicalName()), 229), ColorUtils.k(MaterialColors.c(this.B, R.attr.f79504o, TooltipDrawable.class.getCanonicalName()), 153)))));
        l0(ColorStateList.valueOf(MaterialColors.c(this.B, R.attr.f79518v, TooltipDrawable.class.getCanonicalName())));
        this.G = typedArrayI.getDimensionPixelSize(R.styleable.K9, 0);
        this.H = typedArrayI.getDimensionPixelSize(R.styleable.M9, 0);
        this.I = typedArrayI.getDimensionPixelSize(R.styleable.N9, 0);
        this.J = typedArrayI.getDimensionPixelSize(R.styleable.L9, 0);
        typedArrayI.recycle();
    }

    public void A0(View view) {
        if (view == null) {
            return;
        }
        E0(view);
        view.addOnLayoutChangeListener(this.E);
    }

    public void B0(float f3) {
        this.Q = 1.2f;
        this.N = f3;
        this.O = f3;
        this.R = AnimationUtils.b(0.0f, 1.0f, 0.19f, 1.0f, f3);
        invalidateSelf();
    }

    public void C0(CharSequence charSequence) {
        if (TextUtils.equals(this.A, charSequence)) {
            return;
        }
        this.A = charSequence;
        this.D.m(true);
        invalidateSelf();
    }

    public void D0(TextAppearance textAppearance) {
        this.D.k(textAppearance, this.B);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void a() {
        invalidateSelf();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.save();
        float fR0 = r0();
        float f3 = (float) (-((((double) this.L) * Math.sqrt(2.0d)) - ((double) this.L)));
        canvas.scale(this.N, this.O, getBounds().left + (getBounds().width() * 0.5f), getBounds().top + (getBounds().height() * this.Q));
        canvas.translate(fR0, f3);
        super.draw(canvas);
        x0(canvas);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) Math.max(this.D.g().getTextSize(), this.I);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) Math.max((this.G * 2) + y0(), this.H);
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.K) {
            setShapeAppearanceModel(getShapeAppearanceModel().v().s(v0()).m());
        }
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public void w0(View view) {
        if (view == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.E);
    }
}
