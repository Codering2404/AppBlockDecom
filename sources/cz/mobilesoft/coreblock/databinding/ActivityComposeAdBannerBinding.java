package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.compose.ui.platform.ComposeView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ActivityComposeAdBannerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f96453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ComposeView f96454c;

    private ActivityComposeAdBannerBinding(LinearLayout linearLayout, FrameLayout frameLayout, ComposeView composeView) {
        this.f96452a = linearLayout;
        this.f96453b = frameLayout;
        this.f96454c = composeView;
    }

    public static ActivityComposeAdBannerBinding a(View view) {
        int i3 = R.id.f95613g;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i3);
        if (frameLayout != null) {
            i3 = R.id.K;
            ComposeView composeView = (ComposeView) ViewBindings.a(view, i3);
            if (composeView != null) {
                return new ActivityComposeAdBannerBinding((LinearLayout) view, frameLayout, composeView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ActivityComposeAdBannerBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static ActivityComposeAdBannerBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95686b, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96452a;
    }
}
