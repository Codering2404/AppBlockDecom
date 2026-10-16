package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ItemTouchUIUtil f51741a = new ItemTouchUIUtilImpl();

    ItemTouchUIUtilImpl() {
    }

    private static float e(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f3 = 0.0f;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = recyclerView.getChildAt(i3);
            if (childAt != view) {
                float fT = ViewCompat.t(childAt);
                if (fT > f3) {
                    f3 = fT;
                }
            }
        }
        return f3;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void a(View view) {
        int i3 = R.id.f51445a;
        Object tag = view.getTag(i3);
        if (tag instanceof Float) {
            ViewCompat.u0(view, ((Float) tag).floatValue());
        }
        view.setTag(i3, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void c(Canvas canvas, RecyclerView recyclerView, View view, float f3, float f4, int i3, boolean z2) {
        if (z2) {
            int i4 = R.id.f51445a;
            if (view.getTag(i4) == null) {
                Float fValueOf = Float.valueOf(ViewCompat.t(view));
                ViewCompat.u0(view, e(recyclerView, view) + 1.0f);
                view.setTag(i4, fValueOf);
            }
        }
        view.setTranslationX(f3);
        view.setTranslationY(f4);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void d(Canvas canvas, RecyclerView recyclerView, View view, float f3, float f4, int i3, boolean z2) {
    }
}
