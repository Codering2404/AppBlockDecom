package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityFragmentEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f96463b;

    private ActivityFragmentEmptyBinding(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f96462a = frameLayout;
        this.f96463b = frameLayout2;
    }

    public static ActivityFragmentEmptyBinding a(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        FrameLayout frameLayout = (FrameLayout) view;
        return new ActivityFragmentEmptyBinding(frameLayout, frameLayout);
    }

    public static ActivityFragmentEmptyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityFragmentEmptyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95692e, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96462a;
    }
}
