package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentDefaultApplicationIgnoreListBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f96633b;

    private FragmentDefaultApplicationIgnoreListBinding(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f96632a = frameLayout;
        this.f96633b = recyclerView;
    }

    public static FragmentDefaultApplicationIgnoreListBinding a(View view) {
        int i3 = R.id.V;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i3);
        if (recyclerView != null) {
            return new FragmentDefaultApplicationIgnoreListBinding((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentDefaultApplicationIgnoreListBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.E, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96632a;
    }
}
