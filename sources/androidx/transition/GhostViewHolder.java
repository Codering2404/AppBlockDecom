package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GhostViewHolder extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f53427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f53428b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static float a(View view) {
            return view.getZ();
        }
    }

    GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f53427a = viewGroup;
        viewGroup.setTag(R.id.f53455b, this);
        this.f53427a.getOverlay().add(this);
        this.f53428b = true;
    }

    static GhostViewHolder b(ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.f53455b);
    }

    private int c(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i3 = 0;
        while (i3 <= childCount) {
            int i4 = (i3 + childCount) / 2;
            d(((GhostViewPort) getChildAt(i4)).f53438c, arrayList2);
            if (f(arrayList, arrayList2)) {
                i3 = i4 + 1;
            } else {
                childCount = i4 - 1;
            }
            arrayList2.clear();
        }
        return i3;
    }

    private static void d(View view, ArrayList arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            d((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean e(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Api21Impl.a(view) != Api21Impl.a(view2)) {
            return Api21Impl.a(view) > Api21Impl.a(view2);
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(ViewGroupUtils.a(viewGroup, i3));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }

    private static boolean f(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i3 = 1; i3 < iMin; i3++) {
            View view = (View) arrayList.get(i3);
            View view2 = (View) arrayList2.get(i3);
            if (view != view2) {
                return e(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    void a(GhostViewPort ghostViewPort) {
        ArrayList arrayList = new ArrayList();
        d(ghostViewPort.f53438c, arrayList);
        int iC = c(arrayList);
        if (iC < 0 || iC >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, iC);
        }
    }

    void g() {
        if (!this.f53428b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        this.f53427a.getOverlay().remove(this);
        this.f53427a.getOverlay().add(this);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f53428b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f53427a.setTag(R.id.f53455b, null);
            this.f53427a.getOverlay().remove(this);
            this.f53428b = false;
        }
    }
}
