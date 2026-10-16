package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TextInputLayout extends LinearLayout implements ViewTreeObserver.OnGlobalLayoutListener {
    private static final int D0 = R.style.f79749v;
    private static final int[][] E0 = {new int[]{android.R.attr.state_pressed}, new int[0]};
    private ColorStateList A;
    private boolean A0;
    private ColorStateList B;
    private boolean B0;
    private ColorStateList C;
    private boolean C0;
    private boolean D;
    private CharSequence E;
    private boolean F;
    private MaterialShapeDrawable G;
    private MaterialShapeDrawable H;
    private StateListDrawable I;
    private boolean J;
    private MaterialShapeDrawable K;
    private MaterialShapeDrawable L;
    private ShapeAppearanceModel M;
    private boolean N;
    private final int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private int V;
    private final Rect W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f82330a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final Rect f82331a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StartCompoundLayout f82332b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final RectF f82333b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final EndCompoundLayout f82334c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private Typeface f82335c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    EditText f82336d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private Drawable f82337d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private int f82338e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f82339f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final LinkedHashSet f82340f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f82341g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private Drawable f82342g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f82343h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private int f82344h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f82345i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private Drawable f82346i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f82347j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private ColorStateList f82348j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final IndicatorViewController f82349k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private ColorStateList f82350k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f82351l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private int f82352l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f82353m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private int f82354m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f82355n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private int f82356n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LengthCounter f82357o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private ColorStateList f82358o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private TextView f82359p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private int f82360p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f82361q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private int f82362q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f82363r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private int f82364r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f82365s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private int f82366s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f82367t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private int f82368t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private TextView f82369u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    int f82370u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private ColorStateList f82371v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    private boolean f82372v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f82373w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    final CollapsingTextHelper f82374w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Fade f82375x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    private boolean f82376x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Fade f82377y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    private boolean f82378y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private ColorStateList f82379z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    private ValueAnimator f82380z0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final TextInputLayout f82386d;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f82386d = textInputLayout;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void g(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.g(view, accessibilityNodeInfoCompat);
            EditText editText = this.f82386d.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f82386d.getHint();
            CharSequence error = this.f82386d.getError();
            CharSequence placeholderText = this.f82386d.getPlaceholderText();
            int counterMaxLength = this.f82386d.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.f82386d.getCounterOverflowDescription();
            boolean zIsEmpty = TextUtils.isEmpty(text);
            boolean zIsEmpty2 = TextUtils.isEmpty(hint);
            boolean zP = this.f82386d.P();
            boolean zIsEmpty3 = TextUtils.isEmpty(error);
            boolean z2 = (zIsEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
            String string = !zIsEmpty2 ? hint.toString() : "";
            this.f82386d.f82332b.A(accessibilityNodeInfoCompat);
            if (!zIsEmpty) {
                accessibilityNodeInfoCompat.Q0(text);
            } else if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.Q0(string);
                if (!zP && placeholderText != null) {
                    accessibilityNodeInfoCompat.Q0(string + ", " + ((Object) placeholderText));
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.Q0(placeholderText);
            }
            if (!TextUtils.isEmpty(string)) {
                accessibilityNodeInfoCompat.v0(string);
                accessibilityNodeInfoCompat.M0(zIsEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.A0(counterMaxLength);
            if (z2) {
                if (zIsEmpty3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.r0(error);
            }
            View viewT = this.f82386d.f82349k.t();
            if (viewT != null) {
                accessibilityNodeInfoCompat.x0(viewT);
            }
            this.f82386d.f82334c.m().o(view, accessibilityNodeInfoCompat);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            super.h(view, accessibilityEvent);
            this.f82386d.f82334c.m().p(view, accessibilityEvent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LengthCounter {
        int a(Editable editable);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnEditTextAttachedListener {
        void a(TextInputLayout textInputLayout);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnEndIconChangedListener {
        void a(TextInputLayout textInputLayout, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.google.android.material.textfield.TextInputLayout.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f82387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f82388d;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f82387c) + "}";
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            TextUtils.writeToParcel(this.f82387c, parcel, i3);
            parcel.writeInt(this.f82388d ? 1 : 0);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f82387c = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f82388d = parcel.readInt() == 1;
        }
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.D0);
    }

    private Fade A() {
        Fade fade = new Fade();
        fade.h0(MotionUtils.f(getContext(), R.attr.f79477a0, 87));
        fade.j0(MotionUtils.g(getContext(), R.attr.f79489g0, AnimationUtils.f79849a));
        return fade;
    }

    private boolean B() {
        return this.D && !TextUtils.isEmpty(this.E) && (this.G instanceof CutoutDrawable);
    }

    private void C() {
        Iterator it = this.f82340f0.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).a(this);
        }
    }

    private void D(Canvas canvas) {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.L == null || (materialShapeDrawable = this.K) == null) {
            return;
        }
        materialShapeDrawable.draw(canvas);
        if (this.f82336d.isFocused()) {
            Rect bounds = this.L.getBounds();
            Rect bounds2 = this.K.getBounds();
            float F = this.f82374w0.F();
            int iCenterX = bounds2.centerX();
            bounds.left = AnimationUtils.c(iCenterX, bounds2.left, F);
            bounds.right = AnimationUtils.c(iCenterX, bounds2.right, F);
            this.L.draw(canvas);
        }
    }

    private void E(Canvas canvas) {
        if (this.D) {
            this.f82374w0.l(canvas);
        }
    }

    private void F(boolean z2) {
        ValueAnimator valueAnimator = this.f82380z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f82380z0.cancel();
        }
        if (z2 && this.f82378y0) {
            l(0.0f);
        } else {
            this.f82374w0.y0(0.0f);
        }
        if (B() && ((CutoutDrawable) this.G).t0()) {
            y();
        }
        this.f82372v0 = true;
        L();
        this.f82332b.l(true);
        this.f82334c.H(true);
    }

    private MaterialShapeDrawable G(boolean z2) {
        float dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.G0);
        float f3 = z2 ? dimensionPixelOffset : 0.0f;
        EditText editText = this.f82336d;
        float popupElevation = editText instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText).getPopupElevation() : getResources().getDimensionPixelOffset(R.dimen.A);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.f79603y0);
        ShapeAppearanceModel shapeAppearanceModelM = ShapeAppearanceModel.a().D(f3).H(f3).v(dimensionPixelOffset).z(dimensionPixelOffset).m();
        EditText editText2 = this.f82336d;
        MaterialShapeDrawable materialShapeDrawableM = MaterialShapeDrawable.m(getContext(), popupElevation, editText2 instanceof MaterialAutoCompleteTextView ? ((MaterialAutoCompleteTextView) editText2).getDropDownBackgroundTintList() : null);
        materialShapeDrawableM.setShapeAppearanceModel(shapeAppearanceModelM);
        materialShapeDrawableM.c0(0, dimensionPixelOffset2, 0, dimensionPixelOffset2);
        return materialShapeDrawableM;
    }

    private static Drawable H(MaterialShapeDrawable materialShapeDrawable, int i3, int i4, int[][] iArr) {
        return new RippleDrawable(new ColorStateList(iArr, new int[]{MaterialColors.l(i4, i3, 0.1f), i3}), materialShapeDrawable, materialShapeDrawable);
    }

    private int I(int i3, boolean z2) {
        return i3 + ((z2 || getPrefixText() == null) ? (!z2 || getSuffixText() == null) ? this.f82336d.getCompoundPaddingLeft() : this.f82334c.y() : this.f82332b.c());
    }

    private int J(int i3, boolean z2) {
        return i3 - ((z2 || getSuffixText() == null) ? (!z2 || getPrefixText() == null) ? this.f82336d.getCompoundPaddingRight() : this.f82332b.c() : this.f82334c.y());
    }

    private static Drawable K(Context context, MaterialShapeDrawable materialShapeDrawable, int i3, int[][] iArr) {
        int iC = MaterialColors.c(context, R.attr.f79518v, "TextInputLayout");
        MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        int iL = MaterialColors.l(i3, iC, 0.1f);
        materialShapeDrawable2.a0(new ColorStateList(iArr, new int[]{iL, 0}));
        materialShapeDrawable2.setTint(iC);
        ColorStateList colorStateList = new ColorStateList(iArr, new int[]{iL, iC});
        MaterialShapeDrawable materialShapeDrawable3 = new MaterialShapeDrawable(materialShapeDrawable.getShapeAppearanceModel());
        materialShapeDrawable3.setTint(-1);
        return new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, materialShapeDrawable2, materialShapeDrawable3), materialShapeDrawable});
    }

    private void L() {
        TextView textView = this.f82369u;
        if (textView == null || !this.f82367t) {
            return;
        }
        textView.setText((CharSequence) null);
        TransitionManager.b(this.f82330a, this.f82377y);
        this.f82369u.setVisibility(4);
    }

    private boolean Q() {
        if (b0()) {
            return true;
        }
        return this.f82359p != null && this.f82355n;
    }

    private boolean S() {
        return this.P == 1 && this.f82336d.getMinLines() <= 1;
    }

    private void T() {
        p();
        p0();
        y0();
        f0();
        k();
        if (this.P != 0) {
            r0();
        }
        Z();
    }

    private void U() {
        if (B()) {
            RectF rectF = this.f82333b0;
            this.f82374w0.o(rectF, this.f82336d.getWidth(), this.f82336d.getGravity());
            if (rectF.width() <= 0.0f || rectF.height() <= 0.0f) {
                return;
            }
            o(rectF);
            rectF.offset(-getPaddingLeft(), ((-getPaddingTop()) - (rectF.height() / 2.0f)) + this.R);
            ((CutoutDrawable) this.G).w0(rectF);
        }
    }

    private void V() {
        if (!B() || this.f82372v0) {
            return;
        }
        y();
        U();
    }

    private static void W(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                W((ViewGroup) childAt, z2);
            }
        }
    }

    private void Y() {
        TextView textView = this.f82369u;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void Z() {
        EditText editText = this.f82336d;
        if (editText instanceof AutoCompleteTextView) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
            if (autoCompleteTextView.getDropDownBackground() == null) {
                int i3 = this.P;
                if (i3 == 2) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateOutlinedDropDownMenuBackground());
                } else if (i3 == 1) {
                    autoCompleteTextView.setDropDownBackgroundDrawable(getOrCreateFilledDropDownMenuBackground());
                }
            }
        }
    }

    public static /* synthetic */ int b(Editable editable) {
        if (editable != null) {
            return editable.length();
        }
        return 0;
    }

    private boolean c0() {
        return (this.f82334c.G() || ((this.f82334c.A() && M()) || this.f82334c.w() != null)) && this.f82334c.getMeasuredWidth() > 0;
    }

    private boolean d0() {
        return (getStartIconDrawable() != null || (getPrefixText() != null && getPrefixTextView().getVisibility() == 0)) && this.f82332b.getMeasuredWidth() > 0;
    }

    private void e0() {
        if (this.f82369u == null || !this.f82367t || TextUtils.isEmpty(this.f82365s)) {
            return;
        }
        this.f82369u.setText(this.f82365s);
        TransitionManager.b(this.f82330a, this.f82375x);
        this.f82369u.setVisibility(0);
        this.f82369u.bringToFront();
        announceForAccessibility(this.f82365s);
    }

    private void f0() {
        if (this.P == 1) {
            if (MaterialResources.k(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R.dimen.U);
            } else if (MaterialResources.j(getContext())) {
                this.Q = getResources().getDimensionPixelSize(R.dimen.T);
            }
        }
    }

    private void g0(Rect rect) {
        MaterialShapeDrawable materialShapeDrawable = this.K;
        if (materialShapeDrawable != null) {
            int i3 = rect.bottom;
            materialShapeDrawable.setBounds(rect.left, i3 - this.S, rect.right, i3);
        }
        MaterialShapeDrawable materialShapeDrawable2 = this.L;
        if (materialShapeDrawable2 != null) {
            int i4 = rect.bottom;
            materialShapeDrawable2.setBounds(rect.left, i4 - this.T, rect.right, i4);
        }
    }

    private Drawable getEditTextBoxBackground() {
        EditText editText = this.f82336d;
        if (!(editText instanceof AutoCompleteTextView) || EditTextUtils.a(editText)) {
            return this.G;
        }
        int iD = MaterialColors.d(this.f82336d, R.attr.f79498l);
        int i3 = this.P;
        if (i3 == 2) {
            return K(getContext(), this.G, iD, E0);
        }
        if (i3 == 1) {
            return H(this.G, this.V, iD, E0);
        }
        return null;
    }

    private Drawable getOrCreateFilledDropDownMenuBackground() {
        if (this.I == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.I = stateListDrawable;
            stateListDrawable.addState(new int[]{android.R.attr.state_above_anchor}, getOrCreateOutlinedDropDownMenuBackground());
            this.I.addState(new int[0], G(false));
        }
        return this.I;
    }

    private Drawable getOrCreateOutlinedDropDownMenuBackground() {
        if (this.H == null) {
            this.H = G(true);
        }
        return this.H;
    }

    private void h0() {
        if (this.f82359p != null) {
            EditText editText = this.f82336d;
            i0(editText == null ? null : editText.getText());
        }
    }

    private void j() {
        TextView textView = this.f82369u;
        if (textView != null) {
            this.f82330a.addView(textView);
            this.f82369u.setVisibility(0);
        }
    }

    private static void j0(Context context, TextView textView, int i3, int i4, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? R.string.f79701c : R.string.f79699b, Integer.valueOf(i3), Integer.valueOf(i4)));
    }

    private void k() {
        if (this.f82336d == null || this.P != 1) {
            return;
        }
        if (MaterialResources.k(getContext())) {
            EditText editText = this.f82336d;
            ViewCompat.D0(editText, ViewCompat.D(editText), getResources().getDimensionPixelSize(R.dimen.S), ViewCompat.C(this.f82336d), getResources().getDimensionPixelSize(R.dimen.R));
        } else if (MaterialResources.j(getContext())) {
            EditText editText2 = this.f82336d;
            ViewCompat.D0(editText2, ViewCompat.D(editText2), getResources().getDimensionPixelSize(R.dimen.Q), ViewCompat.C(this.f82336d), getResources().getDimensionPixelSize(R.dimen.P));
        }
    }

    private void k0() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f82359p;
        if (textView != null) {
            a0(textView, this.f82355n ? this.f82361q : this.f82363r);
            if (!this.f82355n && (colorStateList2 = this.f82379z) != null) {
                this.f82359p.setTextColor(colorStateList2);
            }
            if (!this.f82355n || (colorStateList = this.A) == null) {
                return;
            }
            this.f82359p.setTextColor(colorStateList);
        }
    }

    private void l0() {
        ColorStateList colorStateList;
        ColorStateList colorStateListH = this.B;
        if (colorStateListH == null) {
            colorStateListH = MaterialColors.h(getContext(), R.attr.f79496k);
        }
        EditText editText = this.f82336d;
        if (editText == null || editText.getTextCursorDrawable() == null) {
            return;
        }
        Drawable drawableMutate = DrawableCompat.r(this.f82336d.getTextCursorDrawable()).mutate();
        if (Q() && (colorStateList = this.C) != null) {
            colorStateListH = colorStateList;
        }
        DrawableCompat.o(drawableMutate, colorStateListH);
    }

    private void m() {
        MaterialShapeDrawable materialShapeDrawable = this.G;
        if (materialShapeDrawable == null) {
            return;
        }
        ShapeAppearanceModel shapeAppearanceModel = materialShapeDrawable.getShapeAppearanceModel();
        ShapeAppearanceModel shapeAppearanceModel2 = this.M;
        if (shapeAppearanceModel != shapeAppearanceModel2) {
            this.G.setShapeAppearanceModel(shapeAppearanceModel2);
        }
        if (w()) {
            this.G.j0(this.R, this.U);
        }
        int iQ = q();
        this.V = iQ;
        this.G.a0(ColorStateList.valueOf(iQ));
        n();
        p0();
    }

    private void n() {
        if (this.K == null || this.L == null) {
            return;
        }
        if (x()) {
            this.K.a0(this.f82336d.isFocused() ? ColorStateList.valueOf(this.f82352l0) : ColorStateList.valueOf(this.U));
            this.L.a0(ColorStateList.valueOf(this.U));
        }
        invalidate();
    }

    private void o(RectF rectF) {
        float f3 = rectF.left;
        int i3 = this.O;
        rectF.left = f3 - i3;
        rectF.right += i3;
    }

    private void o0() {
        ViewCompat.q0(this.f82336d, getEditTextBoxBackground());
    }

    private void p() {
        int i3 = this.P;
        if (i3 == 0) {
            this.G = null;
            this.K = null;
            this.L = null;
            return;
        }
        if (i3 == 1) {
            this.G = new MaterialShapeDrawable(this.M);
            this.K = new MaterialShapeDrawable();
            this.L = new MaterialShapeDrawable();
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException(this.P + " is illegal; only @BoxBackgroundMode constants are supported.");
            }
            if (!this.D || (this.G instanceof CutoutDrawable)) {
                this.G = new MaterialShapeDrawable(this.M);
            } else {
                this.G = CutoutDrawable.r0(this.M);
            }
            this.K = null;
            this.L = null;
        }
    }

    private int q() {
        return this.P == 1 ? MaterialColors.k(MaterialColors.e(this, R.attr.f79518v, 0), this.V) : this.V;
    }

    private boolean q0() {
        int iMax;
        if (this.f82336d == null || this.f82336d.getMeasuredHeight() >= (iMax = Math.max(this.f82334c.getMeasuredHeight(), this.f82332b.getMeasuredHeight()))) {
            return false;
        }
        this.f82336d.setMinimumHeight(iMax);
        return true;
    }

    private Rect r(Rect rect) {
        if (this.f82336d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f82331a0;
        boolean zO = ViewUtils.o(this);
        rect2.bottom = rect.bottom;
        int i3 = this.P;
        if (i3 == 1) {
            rect2.left = I(rect.left, zO);
            rect2.top = rect.top + this.Q;
            rect2.right = J(rect.right, zO);
            return rect2;
        }
        if (i3 != 2) {
            rect2.left = I(rect.left, zO);
            rect2.top = getPaddingTop();
            rect2.right = J(rect.right, zO);
            return rect2;
        }
        rect2.left = rect.left + this.f82336d.getPaddingLeft();
        rect2.top = rect.top - v();
        rect2.right = rect.right - this.f82336d.getPaddingRight();
        return rect2;
    }

    private void r0() {
        if (this.P != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f82330a.getLayoutParams();
            int iV = v();
            if (iV != layoutParams.topMargin) {
                layoutParams.topMargin = iV;
                this.f82330a.requestLayout();
            }
        }
    }

    private int s(Rect rect, Rect rect2, float f3) {
        return S() ? (int) (rect2.top + f3) : rect.bottom - this.f82336d.getCompoundPaddingBottom();
    }

    private void setEditText(EditText editText) {
        if (this.f82336d != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (getEndIconMode() != 3 && !(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f82336d = editText;
        int i3 = this.f82341g;
        if (i3 != -1) {
            setMinEms(i3);
        } else {
            setMinWidth(this.f82345i);
        }
        int i4 = this.f82343h;
        if (i4 != -1) {
            setMaxEms(i4);
        } else {
            setMaxWidth(this.f82347j);
        }
        this.J = false;
        T();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        this.f82374w0.N0(this.f82336d.getTypeface());
        this.f82374w0.v0(this.f82336d.getTextSize());
        int i5 = Build.VERSION.SDK_INT;
        this.f82374w0.q0(this.f82336d.getLetterSpacing());
        int gravity = this.f82336d.getGravity();
        this.f82374w0.j0((gravity & (-113)) | 48);
        this.f82374w0.u0(gravity);
        this.f82370u0 = ViewCompat.z(editText);
        this.f82336d.addTextChangedListener(new TextWatcher(editText) { // from class: com.google.android.material.textfield.TextInputLayout.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f82381a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EditText f82382b;

            {
                this.f82382b = editText;
                this.f82381a = editText.getLineCount();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.s0(!r0.B0);
                TextInputLayout textInputLayout = TextInputLayout.this;
                if (textInputLayout.f82351l) {
                    textInputLayout.i0(editable);
                }
                if (TextInputLayout.this.f82367t) {
                    TextInputLayout.this.w0(editable);
                }
                int lineCount = this.f82382b.getLineCount();
                int i6 = this.f82381a;
                if (lineCount != i6) {
                    if (lineCount < i6) {
                        int iZ = ViewCompat.z(this.f82382b);
                        int i7 = TextInputLayout.this.f82370u0;
                        if (iZ != i7) {
                            this.f82382b.setMinimumHeight(i7);
                        }
                    }
                    this.f82381a = lineCount;
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i6, int i7, int i8) {
            }
        });
        if (this.f82348j0 == null) {
            this.f82348j0 = this.f82336d.getHintTextColors();
        }
        if (this.D) {
            if (TextUtils.isEmpty(this.E)) {
                CharSequence hint = this.f82336d.getHint();
                this.f82339f = hint;
                setHint(hint);
                this.f82336d.setHint((CharSequence) null);
            }
            this.F = true;
        }
        if (i5 >= 29) {
            l0();
        }
        if (this.f82359p != null) {
            i0(this.f82336d.getText());
        }
        n0();
        this.f82349k.f();
        this.f82332b.bringToFront();
        this.f82334c.bringToFront();
        C();
        this.f82334c.x0();
        if (!isEnabled()) {
            editText.setEnabled(false);
        }
        t0(false, true);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.E)) {
            return;
        }
        this.E = charSequence;
        this.f82374w0.K0(charSequence);
        if (this.f82372v0) {
            return;
        }
        U();
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.f82367t == z2) {
            return;
        }
        if (z2) {
            j();
        } else {
            Y();
            this.f82369u = null;
        }
        this.f82367t = z2;
    }

    private int t(Rect rect, float f3) {
        return S() ? (int) (rect.centerY() - (f3 / 2.0f)) : rect.top + this.f82336d.getCompoundPaddingTop();
    }

    private void t0(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        TextView textView;
        boolean zIsEnabled = isEnabled();
        EditText editText = this.f82336d;
        boolean z4 = false;
        boolean z5 = (editText == null || TextUtils.isEmpty(editText.getText())) ? false : true;
        EditText editText2 = this.f82336d;
        if (editText2 != null && editText2.hasFocus()) {
            z4 = true;
        }
        ColorStateList colorStateList2 = this.f82348j0;
        if (colorStateList2 != null) {
            this.f82374w0.d0(colorStateList2);
        }
        if (!zIsEnabled) {
            ColorStateList colorStateList3 = this.f82348j0;
            this.f82374w0.d0(ColorStateList.valueOf(colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.f82368t0) : this.f82368t0));
        } else if (b0()) {
            this.f82374w0.d0(this.f82349k.r());
        } else if (this.f82355n && (textView = this.f82359p) != null) {
            this.f82374w0.d0(textView.getTextColors());
        } else if (z4 && (colorStateList = this.f82350k0) != null) {
            this.f82374w0.i0(colorStateList);
        }
        if (z5 || !this.f82376x0 || (isEnabled() && z4)) {
            if (z3 || this.f82372v0) {
                z(z2);
                return;
            }
            return;
        }
        if (z3 || !this.f82372v0) {
            F(z2);
        }
    }

    private Rect u(Rect rect) {
        if (this.f82336d == null) {
            throw new IllegalStateException();
        }
        Rect rect2 = this.f82331a0;
        float fC = this.f82374w0.C();
        rect2.left = rect.left + this.f82336d.getCompoundPaddingLeft();
        rect2.top = t(rect, fC);
        rect2.right = rect.right - this.f82336d.getCompoundPaddingRight();
        rect2.bottom = s(rect, rect2, fC);
        return rect2;
    }

    private void u0() {
        EditText editText;
        if (this.f82369u == null || (editText = this.f82336d) == null) {
            return;
        }
        this.f82369u.setGravity(editText.getGravity());
        this.f82369u.setPadding(this.f82336d.getCompoundPaddingLeft(), this.f82336d.getCompoundPaddingTop(), this.f82336d.getCompoundPaddingRight(), this.f82336d.getCompoundPaddingBottom());
    }

    private int v() {
        float fR;
        if (!this.D) {
            return 0;
        }
        int i3 = this.P;
        if (i3 == 0) {
            fR = this.f82374w0.r();
        } else {
            if (i3 != 2) {
                return 0;
            }
            fR = this.f82374w0.r() / 2.0f;
        }
        return (int) fR;
    }

    private void v0() {
        EditText editText = this.f82336d;
        w0(editText == null ? null : editText.getText());
    }

    private boolean w() {
        return this.P == 2 && x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Editable editable) {
        if (this.f82357o.a(editable) != 0 || this.f82372v0) {
            L();
        } else {
            e0();
        }
    }

    private boolean x() {
        return this.R > -1 && this.U != 0;
    }

    private void x0(boolean z2, boolean z3) {
        int defaultColor = this.f82358o0.getDefaultColor();
        int colorForState = this.f82358o0.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, defaultColor);
        int colorForState2 = this.f82358o0.getColorForState(new int[]{android.R.attr.state_activated, android.R.attr.state_enabled}, defaultColor);
        if (z2) {
            this.U = colorForState2;
        } else if (z3) {
            this.U = colorForState;
        } else {
            this.U = defaultColor;
        }
    }

    private void y() {
        if (B()) {
            ((CutoutDrawable) this.G).u0();
        }
    }

    private void z(boolean z2) {
        ValueAnimator valueAnimator = this.f82380z0;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f82380z0.cancel();
        }
        if (z2 && this.f82378y0) {
            l(1.0f);
        } else {
            this.f82374w0.y0(1.0f);
        }
        this.f82372v0 = false;
        if (B()) {
            U();
        }
        v0();
        this.f82332b.l(false);
        this.f82334c.H(false);
    }

    public boolean M() {
        return this.f82334c.F();
    }

    public boolean N() {
        return this.f82349k.A();
    }

    public boolean O() {
        return this.f82349k.B();
    }

    final boolean P() {
        return this.f82372v0;
    }

    public boolean R() {
        return this.F;
    }

    public void X() {
        this.f82332b.m();
    }

    void a0(TextView textView, int i3) {
        try {
            TextViewCompat.o(textView, i3);
            if (textView.getTextColors().getDefaultColor() != -65281) {
                return;
            }
        } catch (Exception unused) {
        }
        TextViewCompat.o(textView, R.style.f79734g);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.f79528a));
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof EditText)) {
            super.addView(view, i3, layoutParams);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
        layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
        this.f82330a.addView(view, layoutParams2);
        this.f82330a.setLayoutParams(layoutParams);
        r0();
        setEditText((EditText) view);
    }

    boolean b0() {
        return this.f82349k.l();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i3) {
        EditText editText = this.f82336d;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i3);
            return;
        }
        if (this.f82339f != null) {
            boolean z2 = this.F;
            this.F = false;
            CharSequence hint = editText.getHint();
            this.f82336d.setHint(this.f82339f);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i3);
                return;
            } finally {
                this.f82336d.setHint(hint);
                this.F = z2;
            }
        }
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i3);
        onProvideAutofillVirtualStructure(viewStructure, i3);
        viewStructure.setChildCount(this.f82330a.getChildCount());
        for (int i4 = 0; i4 < this.f82330a.getChildCount(); i4++) {
            View childAt = this.f82330a.getChildAt(i4);
            ViewStructure viewStructureNewChild = viewStructure.newChild(i4);
            childAt.dispatchProvideAutofillStructure(viewStructureNewChild, i3);
            if (childAt == this.f82336d) {
                viewStructureNewChild.setHint(getHint());
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.B0 = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.B0 = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        E(canvas);
        D(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.A0) {
            return;
        }
        this.A0 = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        CollapsingTextHelper collapsingTextHelper = this.f82374w0;
        boolean zI0 = collapsingTextHelper != null ? collapsingTextHelper.I0(drawableState) : false;
        if (this.f82336d != null) {
            s0(ViewCompat.R(this) && isEnabled());
        }
        n0();
        y0();
        if (zI0) {
            invalidate();
        }
        this.A0 = false;
    }

    @Override // android.widget.LinearLayout, android.view.View
    public int getBaseline() {
        EditText editText = this.f82336d;
        return editText != null ? editText.getBaseline() + getPaddingTop() + v() : super.getBaseline();
    }

    MaterialShapeDrawable getBoxBackground() {
        int i3 = this.P;
        if (i3 == 1 || i3 == 2) {
            return this.G;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.V;
    }

    public int getBoxBackgroundMode() {
        return this.P;
    }

    public int getBoxCollapsedPaddingTop() {
        return this.Q;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return ViewUtils.o(this) ? this.M.j().a(this.f82333b0) : this.M.l().a(this.f82333b0);
    }

    public float getBoxCornerRadiusBottomStart() {
        return ViewUtils.o(this) ? this.M.l().a(this.f82333b0) : this.M.j().a(this.f82333b0);
    }

    public float getBoxCornerRadiusTopEnd() {
        return ViewUtils.o(this) ? this.M.r().a(this.f82333b0) : this.M.t().a(this.f82333b0);
    }

    public float getBoxCornerRadiusTopStart() {
        return ViewUtils.o(this) ? this.M.t().a(this.f82333b0) : this.M.r().a(this.f82333b0);
    }

    public int getBoxStrokeColor() {
        return this.f82356n0;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.f82358o0;
    }

    public int getBoxStrokeWidth() {
        return this.S;
    }

    public int getBoxStrokeWidthFocused() {
        return this.T;
    }

    public int getCounterMaxLength() {
        return this.f82353m;
    }

    CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (this.f82351l && this.f82355n && (textView = this.f82359p) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.A;
    }

    public ColorStateList getCounterTextColor() {
        return this.f82379z;
    }

    public ColorStateList getCursorColor() {
        return this.B;
    }

    public ColorStateList getCursorErrorColor() {
        return this.C;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f82348j0;
    }

    public EditText getEditText() {
        return this.f82336d;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f82334c.l();
    }

    public Drawable getEndIconDrawable() {
        return this.f82334c.n();
    }

    public int getEndIconMinSize() {
        return this.f82334c.o();
    }

    public int getEndIconMode() {
        return this.f82334c.p();
    }

    public ImageView.ScaleType getEndIconScaleType() {
        return this.f82334c.q();
    }

    CheckableImageButton getEndIconView() {
        return this.f82334c.r();
    }

    public CharSequence getError() {
        if (this.f82349k.A()) {
            return this.f82349k.p();
        }
        return null;
    }

    public int getErrorAccessibilityLiveRegion() {
        return this.f82349k.n();
    }

    public CharSequence getErrorContentDescription() {
        return this.f82349k.o();
    }

    public int getErrorCurrentTextColors() {
        return this.f82349k.q();
    }

    public Drawable getErrorIconDrawable() {
        return this.f82334c.s();
    }

    public CharSequence getHelperText() {
        if (this.f82349k.B()) {
            return this.f82349k.s();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f82349k.u();
    }

    public CharSequence getHint() {
        if (this.D) {
            return this.E;
        }
        return null;
    }

    final float getHintCollapsedTextHeight() {
        return this.f82374w0.r();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f82374w0.w();
    }

    public ColorStateList getHintTextColor() {
        return this.f82350k0;
    }

    public LengthCounter getLengthCounter() {
        return this.f82357o;
    }

    public int getMaxEms() {
        return this.f82343h;
    }

    public int getMaxWidth() {
        return this.f82347j;
    }

    public int getMinEms() {
        return this.f82341g;
    }

    public int getMinWidth() {
        return this.f82345i;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f82334c.u();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f82334c.v();
    }

    public CharSequence getPlaceholderText() {
        if (this.f82367t) {
            return this.f82365s;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f82373w;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f82371v;
    }

    public CharSequence getPrefixText() {
        return this.f82332b.a();
    }

    public ColorStateList getPrefixTextColor() {
        return this.f82332b.b();
    }

    public TextView getPrefixTextView() {
        return this.f82332b.d();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.M;
    }

    public CharSequence getStartIconContentDescription() {
        return this.f82332b.e();
    }

    public Drawable getStartIconDrawable() {
        return this.f82332b.f();
    }

    public int getStartIconMinSize() {
        return this.f82332b.g();
    }

    public ImageView.ScaleType getStartIconScaleType() {
        return this.f82332b.h();
    }

    public CharSequence getSuffixText() {
        return this.f82334c.w();
    }

    public ColorStateList getSuffixTextColor() {
        return this.f82334c.x();
    }

    public TextView getSuffixTextView() {
        return this.f82334c.z();
    }

    public Typeface getTypeface() {
        return this.f82335c0;
    }

    public void i(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f82340f0.add(onEditTextAttachedListener);
        if (this.f82336d != null) {
            onEditTextAttachedListener.a(this);
        }
    }

    void i0(Editable editable) {
        int iA = this.f82357o.a(editable);
        boolean z2 = this.f82355n;
        int i3 = this.f82353m;
        if (i3 == -1) {
            this.f82359p.setText(String.valueOf(iA));
            this.f82359p.setContentDescription(null);
            this.f82355n = false;
        } else {
            this.f82355n = iA > i3;
            j0(getContext(), this.f82359p, iA, this.f82353m, this.f82355n);
            if (z2 != this.f82355n) {
                k0();
            }
            this.f82359p.setText(BidiFormatter.c().j(getContext().getString(R.string.f79703d, Integer.valueOf(iA), Integer.valueOf(this.f82353m))));
        }
        if (this.f82336d == null || z2 == this.f82355n) {
            return;
        }
        s0(false);
        y0();
        n0();
    }

    void l(float f3) {
        if (this.f82374w0.F() == f3) {
            return;
        }
        if (this.f82380z0 == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.f82380z0 = valueAnimator;
            valueAnimator.setInterpolator(MotionUtils.g(getContext(), R.attr.f79487f0, AnimationUtils.f79850b));
            this.f82380z0.setDuration(MotionUtils.f(getContext(), R.attr.Y, 167));
            this.f82380z0.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    TextInputLayout.this.f82374w0.y0(((Float) valueAnimator2.getAnimatedValue()).floatValue());
                }
            });
        }
        this.f82380z0.setFloatValues(this.f82374w0.F(), f3);
        this.f82380z0.start();
    }

    boolean m0() {
        boolean z2;
        if (this.f82336d == null) {
            return false;
        }
        boolean z3 = true;
        if (d0()) {
            int measuredWidth = this.f82332b.getMeasuredWidth() - this.f82336d.getPaddingLeft();
            if (this.f82337d0 == null || this.f82338e0 != measuredWidth) {
                ColorDrawable colorDrawable = new ColorDrawable();
                this.f82337d0 = colorDrawable;
                this.f82338e0 = measuredWidth;
                colorDrawable.setBounds(0, 0, measuredWidth, 1);
            }
            Drawable[] drawableArrA = TextViewCompat.a(this.f82336d);
            Drawable drawable = drawableArrA[0];
            Drawable drawable2 = this.f82337d0;
            if (drawable != drawable2) {
                TextViewCompat.i(this.f82336d, drawable2, drawableArrA[1], drawableArrA[2], drawableArrA[3]);
                z2 = true;
            }
            z2 = false;
        } else {
            if (this.f82337d0 != null) {
                Drawable[] drawableArrA2 = TextViewCompat.a(this.f82336d);
                TextViewCompat.i(this.f82336d, null, drawableArrA2[1], drawableArrA2[2], drawableArrA2[3]);
                this.f82337d0 = null;
                z2 = true;
            }
            z2 = false;
        }
        if (c0()) {
            int measuredWidth2 = this.f82334c.z().getMeasuredWidth() - this.f82336d.getPaddingRight();
            CheckableImageButton checkableImageButtonK = this.f82334c.k();
            if (checkableImageButtonK != null) {
                measuredWidth2 = measuredWidth2 + checkableImageButtonK.getMeasuredWidth() + MarginLayoutParamsCompat.b((ViewGroup.MarginLayoutParams) checkableImageButtonK.getLayoutParams());
            }
            Drawable[] drawableArrA3 = TextViewCompat.a(this.f82336d);
            Drawable drawable3 = this.f82342g0;
            if (drawable3 != null && this.f82344h0 != measuredWidth2) {
                this.f82344h0 = measuredWidth2;
                drawable3.setBounds(0, 0, measuredWidth2, 1);
                TextViewCompat.i(this.f82336d, drawableArrA3[0], drawableArrA3[1], this.f82342g0, drawableArrA3[3]);
                return true;
            }
            if (drawable3 == null) {
                ColorDrawable colorDrawable2 = new ColorDrawable();
                this.f82342g0 = colorDrawable2;
                this.f82344h0 = measuredWidth2;
                colorDrawable2.setBounds(0, 0, measuredWidth2, 1);
            }
            Drawable drawable4 = drawableArrA3[2];
            Drawable drawable5 = this.f82342g0;
            if (drawable4 != drawable5) {
                this.f82346i0 = drawable4;
                TextViewCompat.i(this.f82336d, drawableArrA3[0], drawableArrA3[1], drawable5, drawableArrA3[3]);
                return true;
            }
        } else if (this.f82342g0 != null) {
            Drawable[] drawableArrA4 = TextViewCompat.a(this.f82336d);
            if (drawableArrA4[2] == this.f82342g0) {
                TextViewCompat.i(this.f82336d, drawableArrA4[0], drawableArrA4[1], this.f82346i0, drawableArrA4[3]);
            } else {
                z3 = z2;
            }
            this.f82342g0 = null;
            return z3;
        }
        return z2;
    }

    void n0() {
        Drawable background;
        TextView textView;
        EditText editText = this.f82336d;
        if (editText == null || this.P != 0 || (background = editText.getBackground()) == null) {
            return;
        }
        if (DrawableUtils.a(background)) {
            background = background.mutate();
        }
        if (b0()) {
            background.setColorFilter(AppCompatDrawableManager.e(getErrorCurrentTextColors(), PorterDuff.Mode.SRC_IN));
        } else if (this.f82355n && (textView = this.f82359p) != null) {
            background.setColorFilter(AppCompatDrawableManager.e(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.c(background);
            this.f82336d.refreshDrawableState();
        }
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f82374w0.Y(configuration);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.f82334c.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.C0 = false;
        boolean zQ0 = q0();
        boolean zM0 = m0();
        if (zQ0 || zM0) {
            this.f82336d.post(new Runnable() { // from class: com.google.android.material.textfield.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f82402a.f82336d.requestLayout();
                }
            });
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        super.onLayout(z2, i3, i4, i5, i6);
        EditText editText = this.f82336d;
        if (editText != null) {
            Rect rect = this.W;
            DescendantOffsetUtils.a(this, editText, rect);
            g0(rect);
            if (this.D) {
                this.f82374w0.v0(this.f82336d.getTextSize());
                int gravity = this.f82336d.getGravity();
                this.f82374w0.j0((gravity & (-113)) | 48);
                this.f82374w0.u0(gravity);
                this.f82374w0.f0(r(rect));
                this.f82374w0.p0(u(rect));
                this.f82374w0.a0();
                if (!B() || this.f82372v0) {
                    return;
                }
                U();
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (!this.C0) {
            this.f82334c.getViewTreeObserver().addOnGlobalLayoutListener(this);
            this.C0 = true;
        }
        u0();
        this.f82334c.x0();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.c());
        setError(savedState.f82387c);
        if (savedState.f82388d) {
            post(new Runnable() { // from class: com.google.android.material.textfield.TextInputLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    TextInputLayout.this.f82334c.h();
                }
            });
        }
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onRtlPropertiesChanged(int i3) {
        super.onRtlPropertiesChanged(i3);
        boolean z2 = i3 == 1;
        if (z2 != this.N) {
            float fA = this.M.r().a(this.f82333b0);
            float fA2 = this.M.t().a(this.f82333b0);
            ShapeAppearanceModel shapeAppearanceModelM = ShapeAppearanceModel.a().C(this.M.s()).G(this.M.q()).u(this.M.k()).y(this.M.i()).D(fA2).H(fA).v(this.M.l().a(this.f82333b0)).z(this.M.j().a(this.f82333b0)).m();
            this.N = z2;
            setShapeAppearanceModel(shapeAppearanceModelM);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (b0()) {
            savedState.f82387c = getError();
        }
        savedState.f82388d = this.f82334c.E();
        return savedState;
    }

    void p0() {
        EditText editText = this.f82336d;
        if (editText == null || this.G == null) {
            return;
        }
        if ((this.J || editText.getBackground() == null) && this.P != 0) {
            o0();
            this.J = true;
        }
    }

    void s0(boolean z2) {
        t0(z2, false);
    }

    public void setBoxBackgroundColor(int i3) {
        if (this.V != i3) {
            this.V = i3;
            this.f82360p0 = i3;
            this.f82364r0 = i3;
            this.f82366s0 = i3;
            m();
        }
    }

    public void setBoxBackgroundColorResource(int i3) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f82360p0 = defaultColor;
        this.V = defaultColor;
        this.f82362q0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f82364r0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        this.f82366s0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
        m();
    }

    public void setBoxBackgroundMode(int i3) {
        if (i3 == this.P) {
            return;
        }
        this.P = i3;
        if (this.f82336d != null) {
            T();
        }
    }

    public void setBoxCollapsedPaddingTop(int i3) {
        this.Q = i3;
    }

    public void setBoxCornerFamily(int i3) {
        this.M = this.M.v().B(i3, this.M.r()).F(i3, this.M.t()).t(i3, this.M.j()).x(i3, this.M.l()).m();
        m();
    }

    public void setBoxStrokeColor(int i3) {
        if (this.f82356n0 != i3) {
            this.f82356n0 = i3;
            y0();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        if (colorStateList.isStateful()) {
            this.f82352l0 = colorStateList.getDefaultColor();
            this.f82368t0 = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f82354m0 = colorStateList.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            this.f82356n0 = colorStateList.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
        } else if (this.f82356n0 != colorStateList.getDefaultColor()) {
            this.f82356n0 = colorStateList.getDefaultColor();
        }
        y0();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f82358o0 != colorStateList) {
            this.f82358o0 = colorStateList;
            y0();
        }
    }

    public void setBoxStrokeWidth(int i3) {
        this.S = i3;
        y0();
    }

    public void setBoxStrokeWidthFocused(int i3) {
        this.T = i3;
        y0();
    }

    public void setBoxStrokeWidthFocusedResource(int i3) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i3));
    }

    public void setBoxStrokeWidthResource(int i3) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f82351l != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f82359p = appCompatTextView;
                appCompatTextView.setId(R.id.f79645m0);
                Typeface typeface = this.f82335c0;
                if (typeface != null) {
                    this.f82359p.setTypeface(typeface);
                }
                this.f82359p.setMaxLines(1);
                this.f82349k.e(this.f82359p, 2);
                MarginLayoutParamsCompat.d((ViewGroup.MarginLayoutParams) this.f82359p.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.M0));
                k0();
                h0();
            } else {
                this.f82349k.C(this.f82359p, 2);
                this.f82359p = null;
            }
            this.f82351l = z2;
        }
    }

    public void setCounterMaxLength(int i3) {
        if (this.f82353m != i3) {
            if (i3 > 0) {
                this.f82353m = i3;
            } else {
                this.f82353m = -1;
            }
            if (this.f82351l) {
                h0();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i3) {
        if (this.f82361q != i3) {
            this.f82361q = i3;
            k0();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.A != colorStateList) {
            this.A = colorStateList;
            k0();
        }
    }

    public void setCounterTextAppearance(int i3) {
        if (this.f82363r != i3) {
            this.f82363r = i3;
            k0();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f82379z != colorStateList) {
            this.f82379z = colorStateList;
            k0();
        }
    }

    public void setCursorColor(ColorStateList colorStateList) {
        if (this.B != colorStateList) {
            this.B = colorStateList;
            l0();
        }
    }

    public void setCursorErrorColor(ColorStateList colorStateList) {
        if (this.C != colorStateList) {
            this.C = colorStateList;
            if (Q()) {
                l0();
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f82348j0 = colorStateList;
        this.f82350k0 = colorStateList;
        if (this.f82336d != null) {
            s0(false);
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        W(this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f82334c.N(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f82334c.O(z2);
    }

    public void setEndIconContentDescription(int i3) {
        this.f82334c.P(i3);
    }

    public void setEndIconDrawable(int i3) {
        this.f82334c.R(i3);
    }

    public void setEndIconMinSize(int i3) {
        this.f82334c.T(i3);
    }

    public void setEndIconMode(int i3) {
        this.f82334c.U(i3);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f82334c.V(onClickListener);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f82334c.W(onLongClickListener);
    }

    public void setEndIconScaleType(ImageView.ScaleType scaleType) {
        this.f82334c.X(scaleType);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        this.f82334c.Y(colorStateList);
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        this.f82334c.Z(mode);
    }

    public void setEndIconVisible(boolean z2) {
        this.f82334c.a0(z2);
    }

    public void setError(CharSequence charSequence) {
        if (!this.f82349k.A()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f82349k.w();
        } else {
            this.f82349k.Q(charSequence);
        }
    }

    public void setErrorAccessibilityLiveRegion(int i3) {
        this.f82349k.E(i3);
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f82349k.F(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.f82349k.G(z2);
    }

    public void setErrorIconDrawable(int i3) {
        this.f82334c.b0(i3);
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        this.f82334c.d0(onClickListener);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f82334c.e0(onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f82334c.f0(colorStateList);
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        this.f82334c.g0(mode);
    }

    public void setErrorTextAppearance(int i3) {
        this.f82349k.H(i3);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f82349k.I(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.f82376x0 != z2) {
            this.f82376x0 = z2;
            s0(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (O()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!O()) {
                setHelperTextEnabled(true);
            }
            this.f82349k.R(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f82349k.L(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f82349k.K(z2);
    }

    public void setHelperTextTextAppearance(int i3) {
        this.f82349k.J(i3);
    }

    public void setHint(CharSequence charSequence) {
        if (this.D) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.f82378y0 = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.D) {
            this.D = z2;
            if (z2) {
                CharSequence hint = this.f82336d.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.E)) {
                        setHint(hint);
                    }
                    this.f82336d.setHint((CharSequence) null);
                }
                this.F = true;
            } else {
                this.F = false;
                if (!TextUtils.isEmpty(this.E) && TextUtils.isEmpty(this.f82336d.getHint())) {
                    this.f82336d.setHint(this.E);
                }
                setHintInternal(null);
            }
            if (this.f82336d != null) {
                r0();
            }
        }
    }

    public void setHintTextAppearance(int i3) {
        this.f82374w0.g0(i3);
        this.f82350k0 = this.f82374w0.p();
        if (this.f82336d != null) {
            s0(false);
            r0();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f82350k0 != colorStateList) {
            if (this.f82348j0 == null) {
                this.f82374w0.i0(colorStateList);
            }
            this.f82350k0 = colorStateList;
            if (this.f82336d != null) {
                s0(false);
            }
        }
    }

    public void setLengthCounter(LengthCounter lengthCounter) {
        this.f82357o = lengthCounter;
    }

    public void setMaxEms(int i3) {
        this.f82343h = i3;
        EditText editText = this.f82336d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxEms(i3);
    }

    public void setMaxWidth(int i3) {
        this.f82347j = i3;
        EditText editText = this.f82336d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMaxWidth(i3);
    }

    public void setMaxWidthResource(int i3) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    public void setMinEms(int i3) {
        this.f82341g = i3;
        EditText editText = this.f82336d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinEms(i3);
    }

    public void setMinWidth(int i3) {
        this.f82345i = i3;
        EditText editText = this.f82336d;
        if (editText == null || i3 == -1) {
            return;
        }
        editText.setMinWidth(i3);
    }

    public void setMinWidthResource(int i3) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i3));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i3) {
        this.f82334c.i0(i3);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i3) {
        this.f82334c.k0(i3);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        this.f82334c.m0(z2);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f82334c.n0(colorStateList);
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f82334c.o0(mode);
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (this.f82369u == null) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
            this.f82369u = appCompatTextView;
            appCompatTextView.setId(R.id.f79651p0);
            ViewCompat.w0(this.f82369u, 2);
            Fade fadeA = A();
            this.f82375x = fadeA;
            fadeA.m0(67L);
            this.f82377y = A();
            setPlaceholderTextAppearance(this.f82373w);
            setPlaceholderTextColor(this.f82371v);
        }
        if (TextUtils.isEmpty(charSequence)) {
            setPlaceholderTextEnabled(false);
        } else {
            if (!this.f82367t) {
                setPlaceholderTextEnabled(true);
            }
            this.f82365s = charSequence;
        }
        v0();
    }

    public void setPlaceholderTextAppearance(int i3) {
        this.f82373w = i3;
        TextView textView = this.f82369u;
        if (textView != null) {
            TextViewCompat.o(textView, i3);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f82371v != colorStateList) {
            this.f82371v = colorStateList;
            TextView textView = this.f82369u;
            if (textView == null || colorStateList == null) {
                return;
            }
            textView.setTextColor(colorStateList);
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f82332b.n(charSequence);
    }

    public void setPrefixTextAppearance(int i3) {
        this.f82332b.o(i3);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f82332b.p(colorStateList);
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        MaterialShapeDrawable materialShapeDrawable = this.G;
        if (materialShapeDrawable == null || materialShapeDrawable.getShapeAppearanceModel() == shapeAppearanceModel) {
            return;
        }
        this.M = shapeAppearanceModel;
        m();
    }

    public void setStartIconCheckable(boolean z2) {
        this.f82332b.q(z2);
    }

    public void setStartIconContentDescription(int i3) {
        setStartIconContentDescription(i3 != 0 ? getResources().getText(i3) : null);
    }

    public void setStartIconDrawable(int i3) {
        setStartIconDrawable(i3 != 0 ? AppCompatResources.b(getContext(), i3) : null);
    }

    public void setStartIconMinSize(int i3) {
        this.f82332b.t(i3);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        this.f82332b.u(onClickListener);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f82332b.v(onLongClickListener);
    }

    public void setStartIconScaleType(ImageView.ScaleType scaleType) {
        this.f82332b.w(scaleType);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        this.f82332b.x(colorStateList);
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        this.f82332b.y(mode);
    }

    public void setStartIconVisible(boolean z2) {
        this.f82332b.z(z2);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f82334c.p0(charSequence);
    }

    public void setSuffixTextAppearance(int i3) {
        this.f82334c.q0(i3);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f82334c.r0(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f82336d;
        if (editText != null) {
            ViewCompat.m0(editText, accessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f82335c0) {
            this.f82335c0 = typeface;
            this.f82374w0.N0(typeface);
            this.f82349k.N(typeface);
            TextView textView = this.f82359p;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }

    void y0() {
        TextView textView;
        EditText editText;
        EditText editText2;
        if (this.G == null || this.P == 0) {
            return;
        }
        boolean z2 = false;
        boolean z3 = isFocused() || ((editText2 = this.f82336d) != null && editText2.hasFocus());
        if (isHovered() || ((editText = this.f82336d) != null && editText.isHovered())) {
            z2 = true;
        }
        if (!isEnabled()) {
            this.U = this.f82368t0;
        } else if (b0()) {
            if (this.f82358o0 != null) {
                x0(z3, z2);
            } else {
                this.U = getErrorCurrentTextColors();
            }
        } else if (!this.f82355n || (textView = this.f82359p) == null) {
            if (z3) {
                this.U = this.f82356n0;
            } else if (z2) {
                this.U = this.f82354m0;
            } else {
                this.U = this.f82352l0;
            }
        } else if (this.f82358o0 != null) {
            x0(z3, z2);
        } else {
            this.U = textView.getCurrentTextColor();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            l0();
        }
        this.f82334c.I();
        X();
        if (this.P == 2) {
            int i3 = this.R;
            if (z3 && isEnabled()) {
                this.R = this.T;
            } else {
                this.R = this.S;
            }
            if (this.R != i3) {
                V();
            }
        }
        if (this.P == 1) {
            if (!isEnabled()) {
                this.V = this.f82362q0;
            } else if (z2 && !z3) {
                this.V = this.f82366s0;
            } else if (z3) {
                this.V = this.f82364r0;
            } else {
                this.V = this.f82360p0;
            }
        }
        m();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public TextInputLayout(Context context, AttributeSet attributeSet, int i3) {
        int i4 = D0;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f82341g = -1;
        this.f82343h = -1;
        this.f82345i = -1;
        this.f82347j = -1;
        this.f82349k = new IndicatorViewController(this);
        this.f82357o = new LengthCounter() { // from class: com.google.android.material.textfield.p
            @Override // com.google.android.material.textfield.TextInputLayout.LengthCounter
            public final int a(Editable editable) {
                return TextInputLayout.b(editable);
            }
        };
        this.W = new Rect();
        this.f82331a0 = new Rect();
        this.f82333b0 = new RectF();
        this.f82340f0 = new LinkedHashSet();
        CollapsingTextHelper collapsingTextHelper = new CollapsingTextHelper(this);
        this.f82374w0 = collapsingTextHelper;
        this.C0 = false;
        Context context2 = getContext();
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        FrameLayout frameLayout = new FrameLayout(context2);
        this.f82330a = frameLayout;
        frameLayout.setAddStatesFromChildren(true);
        TimeInterpolator timeInterpolator = AnimationUtils.f79849a;
        collapsingTextHelper.L0(timeInterpolator);
        collapsingTextHelper.G0(timeInterpolator);
        collapsingTextHelper.j0(8388659);
        int[] iArr = R.styleable.h8;
        int i5 = R.styleable.E8;
        int i6 = R.styleable.C8;
        int i7 = R.styleable.W8;
        int i8 = R.styleable.b9;
        int i9 = R.styleable.f9;
        TintTypedArray tintTypedArrayJ = ThemeEnforcement.j(context2, attributeSet, iArr, i3, i4, i5, i6, i7, i8, i9);
        StartCompoundLayout startCompoundLayout = new StartCompoundLayout(this, tintTypedArrayJ);
        this.f82332b = startCompoundLayout;
        this.D = tintTypedArrayJ.a(R.styleable.e9, true);
        setHint(tintTypedArrayJ.p(R.styleable.m8));
        this.f82378y0 = tintTypedArrayJ.a(R.styleable.d9, true);
        this.f82376x0 = tintTypedArrayJ.a(R.styleable.Y8, true);
        int i10 = R.styleable.o8;
        if (tintTypedArrayJ.s(i10)) {
            setMinEms(tintTypedArrayJ.k(i10, -1));
        } else {
            int i11 = R.styleable.l8;
            if (tintTypedArrayJ.s(i11)) {
                setMinWidth(tintTypedArrayJ.f(i11, -1));
            }
        }
        int i12 = R.styleable.n8;
        if (tintTypedArrayJ.s(i12)) {
            setMaxEms(tintTypedArrayJ.k(i12, -1));
        } else {
            int i13 = R.styleable.k8;
            if (tintTypedArrayJ.s(i13)) {
                setMaxWidth(tintTypedArrayJ.f(i13, -1));
            }
        }
        this.M = ShapeAppearanceModel.e(context2, attributeSet, i3, i4).m();
        this.O = context2.getResources().getDimensionPixelOffset(R.dimen.J0);
        this.Q = tintTypedArrayJ.e(R.styleable.r8, 0);
        this.S = tintTypedArrayJ.f(R.styleable.y8, context2.getResources().getDimensionPixelSize(R.dimen.K0));
        this.T = tintTypedArrayJ.f(R.styleable.z8, context2.getResources().getDimensionPixelSize(R.dimen.L0));
        this.R = this.S;
        float fD = tintTypedArrayJ.d(R.styleable.v8, -1.0f);
        float fD2 = tintTypedArrayJ.d(R.styleable.u8, -1.0f);
        float fD3 = tintTypedArrayJ.d(R.styleable.s8, -1.0f);
        float fD4 = tintTypedArrayJ.d(R.styleable.t8, -1.0f);
        ShapeAppearanceModel.Builder builderV = this.M.v();
        if (fD >= 0.0f) {
            builderV.D(fD);
        }
        if (fD2 >= 0.0f) {
            builderV.H(fD2);
        }
        if (fD3 >= 0.0f) {
            builderV.z(fD3);
        }
        if (fD4 >= 0.0f) {
            builderV.v(fD4);
        }
        this.M = builderV.m();
        ColorStateList colorStateListB = MaterialResources.b(context2, tintTypedArrayJ, R.styleable.p8);
        if (colorStateListB != null) {
            int defaultColor = colorStateListB.getDefaultColor();
            this.f82360p0 = defaultColor;
            this.V = defaultColor;
            if (colorStateListB.isStateful()) {
                this.f82362q0 = colorStateListB.getColorForState(new int[]{-16842910}, -1);
                this.f82364r0 = colorStateListB.getColorForState(new int[]{android.R.attr.state_focused, android.R.attr.state_enabled}, -1);
                this.f82366s0 = colorStateListB.getColorForState(new int[]{android.R.attr.state_hovered, android.R.attr.state_enabled}, -1);
            } else {
                this.f82364r0 = this.f82360p0;
                ColorStateList colorStateListA = AppCompatResources.a(context2, R.color.W);
                this.f82362q0 = colorStateListA.getColorForState(new int[]{-16842910}, -1);
                this.f82366s0 = colorStateListA.getColorForState(new int[]{android.R.attr.state_hovered}, -1);
            }
        } else {
            this.V = 0;
            this.f82360p0 = 0;
            this.f82362q0 = 0;
            this.f82364r0 = 0;
            this.f82366s0 = 0;
        }
        int i14 = R.styleable.j8;
        if (tintTypedArrayJ.s(i14)) {
            ColorStateList colorStateListC = tintTypedArrayJ.c(i14);
            this.f82350k0 = colorStateListC;
            this.f82348j0 = colorStateListC;
        }
        int i15 = R.styleable.w8;
        ColorStateList colorStateListB2 = MaterialResources.b(context2, tintTypedArrayJ, i15);
        this.f82356n0 = tintTypedArrayJ.b(i15, 0);
        this.f82352l0 = ContextCompat.getColor(context2, R.color.X);
        this.f82368t0 = ContextCompat.getColor(context2, R.color.Y);
        this.f82354m0 = ContextCompat.getColor(context2, R.color.Z);
        if (colorStateListB2 != null) {
            setBoxStrokeColorStateList(colorStateListB2);
        }
        int i16 = R.styleable.x8;
        if (tintTypedArrayJ.s(i16)) {
            setBoxStrokeErrorColor(MaterialResources.b(context2, tintTypedArrayJ, i16));
        }
        if (tintTypedArrayJ.n(i9, -1) != -1) {
            setHintTextAppearance(tintTypedArrayJ.n(i9, 0));
        }
        this.B = tintTypedArrayJ.c(R.styleable.G8);
        this.C = tintTypedArrayJ.c(R.styleable.H8);
        int iN = tintTypedArrayJ.n(i7, 0);
        CharSequence charSequenceP = tintTypedArrayJ.p(R.styleable.R8);
        int iK = tintTypedArrayJ.k(R.styleable.Q8, 1);
        boolean zA = tintTypedArrayJ.a(R.styleable.S8, false);
        int iN2 = tintTypedArrayJ.n(i8, 0);
        boolean zA2 = tintTypedArrayJ.a(R.styleable.a9, false);
        CharSequence charSequenceP2 = tintTypedArrayJ.p(R.styleable.Z8);
        int iN3 = tintTypedArrayJ.n(R.styleable.n9, 0);
        CharSequence charSequenceP3 = tintTypedArrayJ.p(R.styleable.m9);
        boolean zA3 = tintTypedArrayJ.a(R.styleable.A8, false);
        setCounterMaxLength(tintTypedArrayJ.k(R.styleable.B8, -1));
        this.f82363r = tintTypedArrayJ.n(i5, 0);
        this.f82361q = tintTypedArrayJ.n(i6, 0);
        setBoxBackgroundMode(tintTypedArrayJ.k(R.styleable.q8, 0));
        setErrorContentDescription(charSequenceP);
        setErrorAccessibilityLiveRegion(iK);
        setCounterOverflowTextAppearance(this.f82361q);
        setHelperTextTextAppearance(iN2);
        setErrorTextAppearance(iN);
        setCounterTextAppearance(this.f82363r);
        setPlaceholderText(charSequenceP3);
        setPlaceholderTextAppearance(iN3);
        int i17 = R.styleable.X8;
        if (tintTypedArrayJ.s(i17)) {
            setErrorTextColor(tintTypedArrayJ.c(i17));
        }
        int i18 = R.styleable.c9;
        if (tintTypedArrayJ.s(i18)) {
            setHelperTextColor(tintTypedArrayJ.c(i18));
        }
        int i19 = R.styleable.g9;
        if (tintTypedArrayJ.s(i19)) {
            setHintTextColor(tintTypedArrayJ.c(i19));
        }
        int i20 = R.styleable.F8;
        if (tintTypedArrayJ.s(i20)) {
            setCounterTextColor(tintTypedArrayJ.c(i20));
        }
        int i21 = R.styleable.D8;
        if (tintTypedArrayJ.s(i21)) {
            setCounterOverflowTextColor(tintTypedArrayJ.c(i21));
        }
        int i22 = R.styleable.o9;
        if (tintTypedArrayJ.s(i22)) {
            setPlaceholderTextColor(tintTypedArrayJ.c(i22));
        }
        EndCompoundLayout endCompoundLayout = new EndCompoundLayout(this, tintTypedArrayJ);
        this.f82334c = endCompoundLayout;
        boolean zA4 = tintTypedArrayJ.a(R.styleable.i8, true);
        tintTypedArrayJ.x();
        ViewCompat.w0(this, 2);
        ViewCompat.y0(this, 1);
        frameLayout.addView(startCompoundLayout);
        frameLayout.addView(endCompoundLayout);
        addView(frameLayout);
        setEnabled(zA4);
        setHelperTextEnabled(zA2);
        setErrorEnabled(zA);
        setCounterEnabled(zA3);
        setHelperText(charSequenceP2);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        this.f82334c.Q(charSequence);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f82334c.S(drawable);
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f82334c.c0(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f82334c.j0(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f82334c.l0(drawable);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        this.f82332b.r(charSequence);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.f82332b.s(drawable);
    }

    public void setHint(int i3) {
        setHint(i3 != 0 ? getResources().getText(i3) : null);
    }
}
