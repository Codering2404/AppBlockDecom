package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ChipGroup extends FlowLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f80481l = R.style.F;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f80482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f80483g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OnCheckedStateChangeListener f80484h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CheckableGroup f80485i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f80486j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final PassThroughHierarchyChangeListener f80487k;

    /* JADX INFO: renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements CheckableGroup.OnCheckedStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ChipGroup f80488a;

        @Override // com.google.android.material.internal.CheckableGroup.OnCheckedStateChangeListener
        public void a(Set set) {
            if (this.f80488a.f80484h != null) {
                OnCheckedStateChangeListener onCheckedStateChangeListener = this.f80488a.f80484h;
                ChipGroup chipGroup = this.f80488a;
                onCheckedStateChangeListener.a(chipGroup, chipGroup.f80485i.j(this.f80488a));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public interface OnCheckedChangeListener {
        void a(ChipGroup chipGroup, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnCheckedStateChangeListener {
        void a(ChipGroup chipGroup, List list);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ViewGroup.OnHierarchyChangeListener f80491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ChipGroup f80492b;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == this.f80492b && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.j());
                }
                this.f80492b.f80485i.e((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f80491a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = this.f80492b;
            if (view == chipGroup && (view2 instanceof Chip)) {
                chipGroup.f80485i.n((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f80491a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    private boolean g(int i3) {
        return getChildAt(i3).getVisibility() == 0;
    }

    private int getVisibleChipCount() {
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if ((getChildAt(i4) instanceof Chip) && g(i4)) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    int f(View view) {
        if (!(view instanceof Chip)) {
            return -1;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            View childAt = getChildAt(i4);
            if ((childAt instanceof Chip) && g(i4)) {
                if (((Chip) childAt) == view) {
                    return i3;
                }
                i3++;
            }
        }
        return -1;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        return this.f80485i.k();
    }

    public List<Integer> getCheckedChipIds() {
        return this.f80485i.j(this);
    }

    public int getChipSpacingHorizontal() {
        return this.f80482f;
    }

    public int getChipSpacingVertical() {
        return this.f80483g;
    }

    public boolean h() {
        return this.f80485i.l();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f80486j;
        if (i3 != -1) {
            this.f80485i.f(i3);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.Z0(accessibilityNodeInfo).k0(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(getRowCount(), c() ? getVisibleChipCount() : -1, false, h() ? 1 : 2));
    }

    public void setChipSpacing(int i3) {
        setChipSpacingHorizontal(i3);
        setChipSpacingVertical(i3);
    }

    public void setChipSpacingHorizontal(int i3) {
        if (this.f80482f != i3) {
            this.f80482f = i3;
            setItemSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i3) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingResource(int i3) {
        setChipSpacing(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingVertical(int i3) {
        if (this.f80483g != i3) {
            this.f80483g = i3;
            setLineSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i3) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i3));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i3) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(final OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new OnCheckedStateChangeListener() { // from class: com.google.android.material.chip.ChipGroup.2
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
                public void a(ChipGroup chipGroup, List list) {
                    if (ChipGroup.this.f80485i.l()) {
                        onCheckedChangeListener.a(chipGroup, ChipGroup.this.getCheckedChipId());
                    }
                }
            });
        }
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.f80484h = onCheckedStateChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f80487k.f80491a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z2) {
        this.f80485i.o(z2);
    }

    @Deprecated
    public void setShowDividerHorizontal(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z2) {
        super.setSingleLine(z2);
    }

    public void setSingleSelection(boolean z2) {
        this.f80485i.p(z2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(int i3) {
        setSingleLine(getResources().getBoolean(i3));
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
