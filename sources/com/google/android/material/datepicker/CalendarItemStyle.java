package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.widget.TextView;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class CalendarItemStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f80754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ColorStateList f80755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ColorStateList f80756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ColorStateList f80757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f80758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ShapeAppearanceModel f80759f;

    private CalendarItemStyle(ColorStateList colorStateList, ColorStateList colorStateList2, ColorStateList colorStateList3, int i3, ShapeAppearanceModel shapeAppearanceModel, Rect rect) {
        Preconditions.e(rect.left);
        Preconditions.e(rect.top);
        Preconditions.e(rect.right);
        Preconditions.e(rect.bottom);
        this.f80754a = rect;
        this.f80755b = colorStateList2;
        this.f80756c = colorStateList;
        this.f80757d = colorStateList3;
        this.f80758e = i3;
        this.f80759f = shapeAppearanceModel;
    }

    static CalendarItemStyle a(Context context, int i3) {
        Preconditions.b(i3 != 0, "Cannot create a CalendarItemStyle with a styleResId of 0");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, R.styleable.H4);
        Rect rect = new Rect(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.I4, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.K4, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.J4, 0), typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.L4, 0));
        ColorStateList colorStateListA = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.M4);
        ColorStateList colorStateListA2 = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.R4);
        ColorStateList colorStateListA3 = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.P4);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.Q4, 0);
        ShapeAppearanceModel shapeAppearanceModelM = ShapeAppearanceModel.b(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.N4, 0), typedArrayObtainStyledAttributes.getResourceId(R.styleable.O4, 0)).m();
        typedArrayObtainStyledAttributes.recycle();
        return new CalendarItemStyle(colorStateListA, colorStateListA2, colorStateListA3, dimensionPixelSize, shapeAppearanceModelM, rect);
    }

    int b() {
        return this.f80754a.bottom;
    }

    int c() {
        return this.f80754a.top;
    }

    void d(TextView textView) {
        e(textView, null, null);
    }

    void e(TextView textView, ColorStateList colorStateList, ColorStateList colorStateList2) {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable();
        materialShapeDrawable.setShapeAppearanceModel(this.f80759f);
        materialShapeDrawable2.setShapeAppearanceModel(this.f80759f);
        if (colorStateList == null) {
            colorStateList = this.f80756c;
        }
        materialShapeDrawable.a0(colorStateList);
        materialShapeDrawable.k0(this.f80758e, this.f80757d);
        if (colorStateList2 == null) {
            colorStateList2 = this.f80755b;
        }
        textView.setTextColor(colorStateList2);
        RippleDrawable rippleDrawable = new RippleDrawable(this.f80755b.withAlpha(30), materialShapeDrawable, materialShapeDrawable2);
        Rect rect = this.f80754a;
        ViewCompat.q0(textView, new InsetDrawable((Drawable) rippleDrawable, rect.left, rect.top, rect.right, rect.bottom));
    }
}
