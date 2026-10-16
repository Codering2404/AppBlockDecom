package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityStatisticsDefaultAppsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewBottomButtonBinding f96465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f96466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Toolbar f96467d;

    private ActivityStatisticsDefaultAppsBinding(LinearLayout linearLayout, ViewBottomButtonBinding viewBottomButtonBinding, FrameLayout frameLayout, Toolbar toolbar) {
        this.f96464a = linearLayout;
        this.f96465b = viewBottomButtonBinding;
        this.f96466c = frameLayout;
        this.f96467d = toolbar;
    }

    public static ActivityStatisticsDefaultAppsBinding a(View view) {
        int i3 = R.id.f95669v;
        View viewA = ViewBindings.a(view, i3);
        if (viewA != null) {
            ViewBottomButtonBinding viewBottomButtonBindingA = ViewBottomButtonBinding.a(viewA);
            int i4 = R.id.f95664t0;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i4);
            if (frameLayout != null) {
                i4 = R.id.f95636l2;
                Toolbar toolbar = (Toolbar) ViewBindings.a(view, i4);
                if (toolbar != null) {
                    return new ActivityStatisticsDefaultAppsBinding((LinearLayout) view, viewBottomButtonBindingA, frameLayout, toolbar);
                }
            }
            i3 = i4;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityStatisticsDefaultAppsBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityStatisticsDefaultAppsBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95694f, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96464a;
    }
}
