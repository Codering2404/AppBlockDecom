package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentBackupMainBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FragmentContainerView f96609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f96610c;

    private FragmentBackupMainBinding(FrameLayout frameLayout, FragmentContainerView fragmentContainerView, ProgressBar progressBar) {
        this.f96608a = frameLayout;
        this.f96609b = fragmentContainerView;
        this.f96610c = progressBar;
    }

    public static FragmentBackupMainBinding a(View view) {
        int i3 = R.id.f95667u0;
        FragmentContainerView fragmentContainerView = (FragmentContainerView) ViewBindings.a(view, i3);
        if (fragmentContainerView != null) {
            i3 = R.id.F1;
            ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, i3);
            if (progressBar != null) {
                return new FragmentBackupMainBinding((FrameLayout) view, fragmentContainerView, progressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentBackupMainBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.A, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96608a;
    }
}
