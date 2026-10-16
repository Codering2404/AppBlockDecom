package com.google.android.material.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialAlertDialogBuilder extends AlertDialog.Builder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f80932e = R.attr.f79476a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f80933f = R.style.f79731d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f80934g = R.attr.J;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Drawable f80935c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f80936d;

    public MaterialAlertDialogBuilder(Context context) {
        this(context, 0);
    }

    private static Context w(Context context) {
        int iX = x(context);
        Context contextC = MaterialThemeOverlay.c(context, null, f80932e, f80933f);
        return iX == 0 ? contextC : new ContextThemeWrapper(contextC, iX);
    }

    private static int x(Context context) {
        TypedValue typedValueA = MaterialAttributes.a(context, f80934g);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    private static int y(Context context, int i3) {
        return i3 == 0 ? x(context) : i3;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder d(boolean z2) {
        return (MaterialAlertDialogBuilder) super.d(z2);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder e(View view) {
        return (MaterialAlertDialogBuilder) super.e(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder f(Drawable drawable) {
        return (MaterialAlertDialogBuilder) super.f(drawable);
    }

    public MaterialAlertDialogBuilder D(int i3) {
        return (MaterialAlertDialogBuilder) super.g(i3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder h(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.h(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder i(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
        return (MaterialAlertDialogBuilder) super.i(charSequenceArr, zArr, onMultiChoiceClickListener);
    }

    public MaterialAlertDialogBuilder G(int i3, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.j(i3, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder k(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.k(charSequence, onClickListener);
    }

    public MaterialAlertDialogBuilder I(int i3, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.l(i3, onClickListener);
    }

    public MaterialAlertDialogBuilder J(DialogInterface.OnCancelListener onCancelListener) {
        return (MaterialAlertDialogBuilder) super.m(onCancelListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder n(DialogInterface.OnKeyListener onKeyListener) {
        return (MaterialAlertDialogBuilder) super.n(onKeyListener);
    }

    public MaterialAlertDialogBuilder L(int i3, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.o(i3, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder p(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.p(charSequence, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder q(ListAdapter listAdapter, int i3, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.q(listAdapter, i3, onClickListener);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder r(CharSequence[] charSequenceArr, int i3, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.r(charSequenceArr, i3, onClickListener);
    }

    public MaterialAlertDialogBuilder P(int i3) {
        return (MaterialAlertDialogBuilder) super.s(i3);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder t(CharSequence charSequence) {
        return (MaterialAlertDialogBuilder) super.t(charSequence);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder u(View view) {
        return (MaterialAlertDialogBuilder) super.u(view);
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    public AlertDialog a() {
        AlertDialog alertDialogA = super.a();
        Window window = alertDialogA.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.f80935c;
        if (drawable instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) drawable).Z(ViewCompat.t(decorView));
        }
        window.setBackgroundDrawable(MaterialDialogs.b(this.f80935c, this.f80936d));
        decorView.setOnTouchListener(new InsetDialogOnTouchListener(alertDialogA, this.f80936d));
        return alertDialogA;
    }

    @Override // androidx.appcompat.app.AlertDialog.Builder
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public MaterialAlertDialogBuilder c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (MaterialAlertDialogBuilder) super.c(listAdapter, onClickListener);
    }

    public MaterialAlertDialogBuilder(Context context, int i3) {
        super(w(context), y(context, i3));
        Context contextB = b();
        Resources.Theme theme = contextB.getTheme();
        int i4 = f80932e;
        int i5 = f80933f;
        this.f80936d = MaterialDialogs.a(contextB, i4, i5);
        int iC = MaterialColors.c(contextB, R.attr.f79518v, getClass().getCanonicalName());
        TypedArray typedArrayObtainStyledAttributes = contextB.obtainStyledAttributes(null, R.styleable.I3, i4, i5);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.N3, iC);
        typedArrayObtainStyledAttributes.recycle();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(contextB, null, i4, i5);
        materialShapeDrawable.P(contextB);
        materialShapeDrawable.a0(ColorStateList.valueOf(color));
        TypedValue typedValue = new TypedValue();
        theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
        float dimension = typedValue.getDimension(b().getResources().getDisplayMetrics());
        if (typedValue.type == 5 && dimension >= 0.0f) {
            materialShapeDrawable.X(dimension);
        }
        this.f80935c = materialShapeDrawable;
    }
}
