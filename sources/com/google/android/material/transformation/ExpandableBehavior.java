package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.expandable.ExpandableWidget;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f82537a;

    public ExpandableBehavior() {
        this.f82537a = 0;
    }

    private boolean L(boolean z2) {
        if (!z2) {
            return this.f82537a == 1;
        }
        int i3 = this.f82537a;
        return i3 == 0 || i3 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected ExpandableWidget M(CoordinatorLayout coordinatorLayout, View view) {
        List listV = coordinatorLayout.v(view);
        int size = listV.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view2 = (View) listV.get(i3);
            if (k(coordinatorLayout, view, view2)) {
                return (ExpandableWidget) view2;
            }
        }
        return null;
    }

    protected abstract boolean N(View view, View view2, boolean z2, boolean z3);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public abstract boolean k(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean n(CoordinatorLayout coordinatorLayout, View view, View view2) {
        ExpandableWidget expandableWidget = (ExpandableWidget) view2;
        if (!L(expandableWidget.a())) {
            return false;
        }
        this.f82537a = expandableWidget.a() ? 1 : 2;
        return N((View) expandableWidget, view, expandableWidget.a(), true);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean r(CoordinatorLayout coordinatorLayout, final View view, int i3) {
        final ExpandableWidget expandableWidgetM;
        if (ViewCompat.R(view) || (expandableWidgetM = M(coordinatorLayout, view)) == null || !L(expandableWidgetM.a())) {
            return false;
        }
        final int i4 = expandableWidgetM.a() ? 1 : 2;
        this.f82537a = i4;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.google.android.material.transformation.ExpandableBehavior.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.f82537a == i4) {
                    ExpandableBehavior expandableBehavior = ExpandableBehavior.this;
                    ExpandableWidget expandableWidget = expandableWidgetM;
                    expandableBehavior.N((View) expandableWidget, view, expandableWidget.a(), false);
                }
                return false;
            }
        });
        return false;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f82537a = 0;
    }
}
