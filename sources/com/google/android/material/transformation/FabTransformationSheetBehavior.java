package com.google.android.material.transformation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map f82568j;

    public FabTransformationSheetBehavior() {
    }

    private void m0(View view, boolean z2) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z2) {
                this.f82568j = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                boolean z3 = (childAt.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) && (((CoordinatorLayout.LayoutParams) childAt.getLayoutParams()).f() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z3) {
                    if (z2) {
                        this.f82568j.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        ViewCompat.w0(childAt, 4);
                    } else {
                        Map map = this.f82568j;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.w0(childAt, ((Integer) this.f82568j.get(childAt)).intValue());
                        }
                    }
                }
            }
            if (z2) {
                return;
            }
            this.f82568j = null;
        }
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior, com.google.android.material.transformation.ExpandableBehavior
    protected boolean N(View view, View view2, boolean z2, boolean z3) {
        m0(view2, z2);
        return super.N(view, view2, z2, z3);
    }

    @Override // com.google.android.material.transformation.FabTransformationBehavior
    protected FabTransformationBehavior.FabTransformationSpec k0(Context context, boolean z2) {
        int i3 = z2 ? R.animator.f79475h : R.animator.f79474g;
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.f82561a = MotionSpec.d(context, i3);
        fabTransformationSpec.f82562b = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
