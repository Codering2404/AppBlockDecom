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
public final class ActivityStatisticsDetailBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f96469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Toolbar f96470c;

    private ActivityStatisticsDetailBinding(LinearLayout linearLayout, FrameLayout frameLayout, Toolbar toolbar) {
        this.f96468a = linearLayout;
        this.f96469b = frameLayout;
        this.f96470c = toolbar;
    }

    public static ActivityStatisticsDetailBinding a(View view) {
        int i3 = R.id.f95664t0;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i3);
        if (frameLayout != null) {
            i3 = R.id.f95636l2;
            Toolbar toolbar = (Toolbar) ViewBindings.a(view, i3);
            if (toolbar != null) {
                return new ActivityStatisticsDetailBinding((LinearLayout) view, frameLayout, toolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityStatisticsDetailBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityStatisticsDetailBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95696g, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96468a;
    }
}
