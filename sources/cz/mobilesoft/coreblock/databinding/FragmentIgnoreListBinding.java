package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentIgnoreListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutEmptyBinding f96642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FloatingActionButton f96643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f96644d;

    private FragmentIgnoreListBinding(FrameLayout frameLayout, LayoutEmptyBinding layoutEmptyBinding, FloatingActionButton floatingActionButton, RecyclerView recyclerView) {
        this.f96641a = frameLayout;
        this.f96642b = layoutEmptyBinding;
        this.f96643c = floatingActionButton;
        this.f96644d = recyclerView;
    }

    public static FragmentIgnoreListBinding a(View view) {
        int i3 = R.id.f95638m0;
        View viewA = ViewBindings.a(view, i3);
        if (viewA != null) {
            LayoutEmptyBinding layoutEmptyBindingA = LayoutEmptyBinding.a(viewA);
            int i4 = R.id.f95658r0;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.a(view, i4);
            if (floatingActionButton != null) {
                i4 = R.id.O0;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i4);
                if (recyclerView != null) {
                    return new FragmentIgnoreListBinding((FrameLayout) view, layoutEmptyBindingA, floatingActionButton, recyclerView);
                }
            }
            i3 = i4;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentIgnoreListBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.H, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96641a;
    }
}
