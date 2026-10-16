package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyCoursesBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final NestedScrollView f96571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutEmptyBinding f96572c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f96573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f96574e;

    private FragmentAcademyCoursesBinding(FrameLayout frameLayout, NestedScrollView nestedScrollView, LayoutEmptyBinding layoutEmptyBinding, LinearLayout linearLayout, RecyclerView recyclerView) {
        this.f96570a = frameLayout;
        this.f96571b = nestedScrollView;
        this.f96572c = layoutEmptyBinding;
        this.f96573d = linearLayout;
        this.f96574e = recyclerView;
    }

    public static FragmentAcademyCoursesBinding a(View view) {
        View viewA;
        int i3 = R.id.N;
        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i3);
        if (nestedScrollView != null && (viewA = ViewBindings.a(view, (i3 = R.id.f95638m0))) != null) {
            LayoutEmptyBinding layoutEmptyBindingA = LayoutEmptyBinding.a(viewA);
            i3 = R.id.C0;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i3);
            if (linearLayout != null) {
                i3 = R.id.I1;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i3);
                if (recyclerView != null) {
                    return new FragmentAcademyCoursesBinding((FrameLayout) view, nestedScrollView, layoutEmptyBindingA, linearLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentAcademyCoursesBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95726v, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96570a;
    }
}
