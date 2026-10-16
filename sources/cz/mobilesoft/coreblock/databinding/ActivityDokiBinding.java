package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;
import dev.doubledot.doki.views.DokiContentView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityDokiBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DokiContentView f96458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Toolbar f96459c;

    private ActivityDokiBinding(LinearLayout linearLayout, DokiContentView dokiContentView, Toolbar toolbar) {
        this.f96457a = linearLayout;
        this.f96458b = dokiContentView;
        this.f96459c = toolbar;
    }

    public static ActivityDokiBinding a(View view) {
        int i3 = R.id.f95614g0;
        DokiContentView dokiContentView = (DokiContentView) ViewBindings.a(view, i3);
        if (dokiContentView != null) {
            i3 = R.id.f95636l2;
            Toolbar toolbar = (Toolbar) ViewBindings.a(view, i3);
            if (toolbar != null) {
                return new ActivityDokiBinding((LinearLayout) view, dokiContentView, toolbar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityDokiBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityDokiBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95688c, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96457a;
    }
}
