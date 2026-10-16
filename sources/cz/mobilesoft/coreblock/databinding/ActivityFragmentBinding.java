package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityFragmentBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96460a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f96461b;

    private ActivityFragmentBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f96460a = frameLayout;
        this.f96461b = frameLayout2;
    }

    public static ActivityFragmentBinding a(View view) {
        int i3 = R.id.f95664t0;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i3);
        if (frameLayout != null) {
            return new ActivityFragmentBinding((FrameLayout) view, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityFragmentBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityFragmentBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95690d, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96460a;
    }
}
