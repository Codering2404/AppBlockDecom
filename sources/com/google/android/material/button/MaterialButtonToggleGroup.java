package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f80275l = R.style.N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f80276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PressedStateTracker f80277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LinkedHashSet f80278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator f80279d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer[] f80280f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f80281g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f80282h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f80283i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f80284j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Set f80285k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CornerData {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final CornerSize f80288e = new AbsoluteCornerSize(0.0f);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        CornerSize f80289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CornerSize f80290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CornerSize f80291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        CornerSize f80292d;

        CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f80289a = cornerSize;
            this.f80290b = cornerSize3;
            this.f80291c = cornerSize4;
            this.f80292d = cornerSize2;
        }

        public static CornerData a(CornerData cornerData) {
            CornerSize cornerSize = f80288e;
            return new CornerData(cornerSize, cornerData.f80292d, cornerSize, cornerData.f80291c);
        }

        public static CornerData b(CornerData cornerData, View view) {
            return ViewUtils.o(view) ? c(cornerData) : d(cornerData);
        }

        public static CornerData c(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f80289a;
            CornerSize cornerSize2 = cornerData.f80292d;
            CornerSize cornerSize3 = f80288e;
            return new CornerData(cornerSize, cornerSize2, cornerSize3, cornerSize3);
        }

        public static CornerData d(CornerData cornerData) {
            CornerSize cornerSize = f80288e;
            return new CornerData(cornerSize, cornerSize, cornerData.f80290b, cornerData.f80291c);
        }

        public static CornerData e(CornerData cornerData, View view) {
            return ViewUtils.o(view) ? d(cornerData) : c(cornerData);
        }

        public static CornerData f(CornerData cornerData) {
            CornerSize cornerSize = cornerData.f80289a;
            CornerSize cornerSize2 = f80288e;
            return new CornerData(cornerSize, cornerSize2, cornerData.f80290b, cornerSize2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnButtonCheckedListener {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i3, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void a(MaterialButton materialButton, boolean z2) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.L);
    }

    private void c() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton materialButtonI = i(i3);
            int iMin = Math.min(materialButtonI.getStrokeWidth(), i(i3 - 1).getStrokeWidth());
            LinearLayout.LayoutParams layoutParamsD = d(materialButtonI);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.c(layoutParamsD, 0);
                MarginLayoutParamsCompat.d(layoutParamsD, -iMin);
                layoutParamsD.topMargin = 0;
            } else {
                layoutParamsD.bottomMargin = 0;
                layoutParamsD.topMargin = -iMin;
                MarginLayoutParamsCompat.d(layoutParamsD, 0);
            }
            materialButtonI.setLayoutParams(layoutParamsD);
        }
        o(firstVisibleChildIndex);
    }

    private LinearLayout.LayoutParams d(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void f(int i3, boolean z2) {
        if (i3 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i3);
            return;
        }
        HashSet hashSet = new HashSet(this.f80285k);
        if (z2 && !hashSet.contains(Integer.valueOf(i3))) {
            if (this.f80282h && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i3));
        } else {
            if (z2 || !hashSet.contains(Integer.valueOf(i3))) {
                return;
            }
            if (!this.f80283i || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i3));
            }
        }
        r(hashSet);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (l(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (l(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof MaterialButton) && l(i4)) {
                i3++;
            }
        }
        return i3;
    }

    private void h(int i3, boolean z2) {
        Iterator it = this.f80278c.iterator();
        while (it.hasNext()) {
            ((OnButtonCheckedListener) it.next()).a(this, i3, z2);
        }
    }

    private MaterialButton i(int i3) {
        return (MaterialButton) getChildAt(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j(View view) {
        if (!(view instanceof MaterialButton)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == view) {
                return i3;
            }
            if ((getChildAt(i4) instanceof MaterialButton) && l(i4)) {
                i3++;
            }
        }
        return -1;
    }

    private CornerData k(int i3, int i4, int i5) {
        CornerData cornerData = (CornerData) this.f80276a.get(i3);
        if (i4 == i5) {
            return cornerData;
        }
        boolean z2 = getOrientation() == 0;
        if (i3 == i4) {
            return z2 ? CornerData.e(cornerData, this) : CornerData.f(cornerData);
        }
        if (i3 == i5) {
            return z2 ? CornerData.b(cornerData, this) : CornerData.a(cornerData);
        }
        return null;
    }

    private boolean l(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    private void o(int i3) {
        if (getChildCount() == 0 || i3 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) i(i3).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
        } else {
            MarginLayoutParamsCompat.c(layoutParams, 0);
            MarginLayoutParamsCompat.d(layoutParams, 0);
            layoutParams.leftMargin = 0;
            layoutParams.rightMargin = 0;
        }
    }

    private void p(int i3, boolean z2) {
        View viewFindViewById = findViewById(i3);
        if (viewFindViewById instanceof MaterialButton) {
            this.f80281g = true;
            ((MaterialButton) viewFindViewById).setChecked(z2);
            this.f80281g = false;
        }
    }

    private static void q(ShapeAppearanceModel.Builder builder, CornerData cornerData) {
        if (cornerData == null) {
            builder.o(0.0f);
        } else {
            builder.E(cornerData.f80289a).w(cornerData.f80292d).I(cornerData.f80290b).A(cornerData.f80291c);
        }
    }

    private void r(Set set) {
        Set set2 = this.f80285k;
        this.f80285k = new HashSet(set);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = i(i3).getId();
            p(id, set.contains(Integer.valueOf(id)));
            if (set2.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                h(id, set.contains(Integer.valueOf(id)));
            }
        }
        invalidate();
    }

    private void s() {
        TreeMap treeMap = new TreeMap(this.f80279d);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put(i(i3), Integer.valueOf(i3));
        }
        this.f80280f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.j());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f80277b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void u() {
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            i(i3).setA11yClassName((this.f80282h ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        f(materialButton.getId(), materialButton.isChecked());
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f80276a.add(new CornerData(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        materialButton.setEnabled(isEnabled());
        ViewCompat.m0(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void g(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.g(view2, accessibilityNodeInfoCompat);
                accessibilityNodeInfoCompat.l0(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, MaterialButtonToggleGroup.this.j(view2), 1, false, ((MaterialButton) view2).isChecked()));
            }
        });
    }

    public void b(OnButtonCheckedListener onButtonCheckedListener) {
        this.f80278c.add(onButtonCheckedListener);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        s();
        super.dispatchDraw(canvas);
    }

    public void e(int i3) {
        f(i3, true);
    }

    public void g() {
        r(new HashSet());
    }

    public int getCheckedButtonId() {
        if (!this.f80282h || this.f80285k.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f80285k.iterator().next()).intValue();
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            int id = i(i3).getId();
            if (this.f80285k.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i3, int i4) {
        Integer[] numArr = this.f80280f;
        if (numArr != null && i4 < numArr.length) {
            return numArr[i4].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i4;
    }

    public boolean m() {
        return this.f80282h;
    }

    void n(MaterialButton materialButton, boolean z2) {
        if (this.f80281g) {
            return;
        }
        f(materialButton.getId(), z2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f80284j;
        if (i3 != -1) {
            r(Collections.singleton(Integer.valueOf(i3)));
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(1, getVisibleButtonCount(), false, m() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        t();
        c();
        super.onMeasure(i3, i4);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f80276a.remove(iIndexOfChild);
        }
        t();
        c();
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            i(i3).setEnabled(z2);
        }
    }

    public void setSelectionRequired(boolean z2) {
        this.f80283i = z2;
    }

    public void setSingleSelection(boolean z2) {
        if (this.f80282h != z2) {
            this.f80282h = z2;
            g();
        }
        u();
    }

    void t() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButtonI = i(i3);
            if (materialButtonI.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builderV = materialButtonI.getShapeAppearanceModel().v();
                q(builderV, k(i3, firstVisibleChildIndex, lastVisibleChildIndex));
                materialButtonI.setShapeAppearanceModel(builderV.m());
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f80275l;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f80276a = new ArrayList();
        this.f80277b = new PressedStateTracker();
        this.f80278c = new LinkedHashSet();
        this.f80279d = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                int iCompareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
                return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
            }
        };
        this.f80281g = false;
        this.f80285k = new HashSet();
        TypedArray typedArrayI = ThemeEnforcement.i(getContext(), attributeSet, R.styleable.s4, i3, i4, new int[0]);
        setSingleSelection(typedArrayI.getBoolean(R.styleable.w4, false));
        this.f80284j = typedArrayI.getResourceId(R.styleable.u4, -1);
        this.f80283i = typedArrayI.getBoolean(R.styleable.v4, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayI.getBoolean(R.styleable.t4, true));
        typedArrayI.recycle();
        ViewCompat.w0(this, 1);
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
