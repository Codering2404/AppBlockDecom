package com.google.android.material.textfield;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ListPopupWindow f82303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AccessibilityManager f82304g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Rect f82305h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f82306i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f82307j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f82308k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f82309l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorStateList f82310m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class MaterialArrayAdapter<T> extends ArrayAdapter<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ColorStateList f82312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ColorStateList f82313b;

        MaterialArrayAdapter(Context context, int i3, String[] strArr) {
            super(context, i3, strArr);
            f();
        }

        private ColorStateList a() {
            if (!c() || !d()) {
                return null;
            }
            int[] iArr = {R.attr.state_hovered, -16842919};
            int[] iArr2 = {R.attr.state_selected, -16842919};
            int colorForState = MaterialAutoCompleteTextView.this.f82310m.getColorForState(iArr2, 0);
            int colorForState2 = MaterialAutoCompleteTextView.this.f82310m.getColorForState(iArr, 0);
            return new ColorStateList(new int[][]{iArr2, iArr, new int[0]}, new int[]{MaterialColors.k(MaterialAutoCompleteTextView.this.f82309l, colorForState), MaterialColors.k(MaterialAutoCompleteTextView.this.f82309l, colorForState2), MaterialAutoCompleteTextView.this.f82309l});
        }

        private Drawable b() {
            if (!c()) {
                return null;
            }
            ColorDrawable colorDrawable = new ColorDrawable(MaterialAutoCompleteTextView.this.f82309l);
            if (this.f82313b == null) {
                return colorDrawable;
            }
            DrawableCompat.o(colorDrawable, this.f82312a);
            return new RippleDrawable(this.f82313b, colorDrawable, null);
        }

        private boolean c() {
            return MaterialAutoCompleteTextView.this.f82309l != 0;
        }

        private boolean d() {
            return MaterialAutoCompleteTextView.this.f82310m != null;
        }

        private ColorStateList e() {
            if (!d()) {
                return null;
            }
            int[] iArr = {R.attr.state_pressed};
            return new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.f82310m.getColorForState(iArr, 0), 0});
        }

        void f() {
            this.f82313b = e();
            this.f82312a = a();
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i3, view, viewGroup);
            if (view2 instanceof TextView) {
                TextView textView = (TextView) view2;
                ViewCompat.q0(textView, MaterialAutoCompleteTextView.this.getText().toString().contentEquals(textView.getText()) ? b() : null);
            }
            return view2;
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.f79480c);
    }

    private TextInputLayout f() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    private boolean g() {
        return i() || h();
    }

    private boolean h() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = this.f82304g;
        if (accessibilityManager != null && accessibilityManager.isEnabled() && (enabledAccessibilityServiceList = this.f82304g.getEnabledAccessibilityServiceList(16)) != null) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (accessibilityServiceInfo.getSettingsActivityName() != null && accessibilityServiceInfo.getSettingsActivityName().contains("SwitchAccess")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean i() {
        AccessibilityManager accessibilityManager = this.f82304g;
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private int j() {
        ListAdapter adapter = getAdapter();
        TextInputLayout textInputLayoutF = f();
        int i3 = 0;
        if (adapter == null || textInputLayoutF == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMin = Math.min(adapter.getCount(), Math.max(0, this.f82303f.w()) + 15);
        View view = null;
        int iMax = 0;
        for (int iMax2 = Math.max(0, iMin - 15); iMax2 < iMin; iMax2++) {
            int itemViewType = adapter.getItemViewType(iMax2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = adapter.getView(iMax2, view, textInputLayoutF);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax = Math.max(iMax, view.getMeasuredWidth());
        }
        Drawable drawableG = this.f82303f.g();
        if (drawableG != null) {
            drawableG.getPadding(this.f82305h);
            Rect rect = this.f82305h;
            iMax += rect.left + rect.right;
        }
        return iMax + textInputLayoutF.getEndIconView().getMeasuredWidth();
    }

    private void k() {
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null) {
            textInputLayoutF.p0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Object obj) {
        setText(convertSelectionToString(obj), false);
    }

    @Override // android.widget.AutoCompleteTextView
    public void dismissDropDown() {
        if (g()) {
            this.f82303f.dismiss();
        } else {
            super.dismissDropDown();
        }
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.f82308k;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout textInputLayoutF = f();
        return (textInputLayoutF == null || !textInputLayoutF.R()) ? super.getHint() : textInputLayoutF.getHint();
    }

    public float getPopupElevation() {
        return this.f82307j;
    }

    public int getSimpleItemSelectedColor() {
        return this.f82309l;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.f82310m;
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout textInputLayoutF = f();
        if (textInputLayoutF != null && textInputLayoutF.R() && super.getHint() == null && ManufacturerUtils.d()) {
            setHint("");
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f82303f.dismiss();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), j()), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z2) {
        if (g()) {
            return;
        }
        super.onWindowFocusChanged(z2);
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t2) {
        super.setAdapter(t2);
        this.f82303f.m(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundDrawable(Drawable drawable) {
        super.setDropDownBackgroundDrawable(drawable);
        ListPopupWindow listPopupWindow = this.f82303f;
        if (listPopupWindow != null) {
            listPopupWindow.a(drawable);
        }
    }

    public void setDropDownBackgroundTint(int i3) {
        setDropDownBackgroundTintList(ColorStateList.valueOf(i3));
    }

    public void setDropDownBackgroundTintList(ColorStateList colorStateList) {
        this.f82308k = colorStateList;
        Drawable dropDownBackground = getDropDownBackground();
        if (dropDownBackground instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) dropDownBackground).a0(this.f82308k);
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        super.setOnItemSelectedListener(onItemSelectedListener);
        this.f82303f.L(getOnItemSelectedListener());
    }

    @Override // android.widget.TextView
    public void setRawInputType(int i3) {
        super.setRawInputType(i3);
        k();
    }

    public void setSimpleItemSelectedColor(int i3) {
        this.f82309l = i3;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList colorStateList) {
        this.f82310m = colorStateList;
        if (getAdapter() instanceof MaterialArrayAdapter) {
            ((MaterialArrayAdapter) getAdapter()).f();
        }
    }

    public void setSimpleItems(int i3) {
        setSimpleItems(getResources().getStringArray(i3));
    }

    @Override // android.widget.AutoCompleteTextView
    public void showDropDown() {
        if (g()) {
            this.f82303f.show();
        } else {
            super.showDropDown();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i3) {
        super(MaterialThemeOverlay.c(context, attributeSet, i3, 0), attributeSet, i3);
        this.f82305h = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayI = ThemeEnforcement.i(context2, attributeSet, com.google.android.material.R.styleable.P3, i3, com.google.android.material.R.style.f79741n, new int[0]);
        int i4 = com.google.android.material.R.styleable.Q3;
        if (typedArrayI.hasValue(i4) && typedArrayI.getInt(i4, 0) == 0) {
            setKeyListener(null);
        }
        this.f82306i = typedArrayI.getResourceId(com.google.android.material.R.styleable.T3, com.google.android.material.R.layout.f79690u);
        this.f82307j = typedArrayI.getDimensionPixelOffset(com.google.android.material.R.styleable.R3, com.google.android.material.R.dimen.f79601x0);
        int i5 = com.google.android.material.R.styleable.S3;
        if (typedArrayI.hasValue(i5)) {
            this.f82308k = ColorStateList.valueOf(typedArrayI.getColor(i5, 0));
        }
        this.f82309l = typedArrayI.getColor(com.google.android.material.R.styleable.U3, 0);
        this.f82310m = MaterialResources.a(context2, typedArrayI, com.google.android.material.R.styleable.V3);
        this.f82304g = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.f82303f = listPopupWindow;
        listPopupWindow.I(true);
        listPopupWindow.C(this);
        listPopupWindow.H(2);
        listPopupWindow.m(getAdapter());
        listPopupWindow.K(new AdapterView.OnItemClickListener() { // from class: com.google.android.material.textfield.MaterialAutoCompleteTextView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i6, long j3) {
                MaterialAutoCompleteTextView materialAutoCompleteTextView = MaterialAutoCompleteTextView.this;
                MaterialAutoCompleteTextView.this.l(i6 < 0 ? materialAutoCompleteTextView.f82303f.u() : materialAutoCompleteTextView.getAdapter().getItem(i6));
                AdapterView.OnItemClickListener onItemClickListener = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if (onItemClickListener != null) {
                    if (view == null || i6 < 0) {
                        view = MaterialAutoCompleteTextView.this.f82303f.x();
                        i6 = MaterialAutoCompleteTextView.this.f82303f.w();
                        j3 = MaterialAutoCompleteTextView.this.f82303f.v();
                    }
                    onItemClickListener.onItemClick(MaterialAutoCompleteTextView.this.f82303f.o(), view, i6, j3);
                }
                MaterialAutoCompleteTextView.this.f82303f.dismiss();
            }
        });
        int i6 = com.google.android.material.R.styleable.W3;
        if (typedArrayI.hasValue(i6)) {
            setSimpleItems(typedArrayI.getResourceId(i6, 0));
        }
        typedArrayI.recycle();
    }

    public void setSimpleItems(String[] strArr) {
        setAdapter(new MaterialArrayAdapter(getContext(), this.f82306i, strArr));
    }
}
