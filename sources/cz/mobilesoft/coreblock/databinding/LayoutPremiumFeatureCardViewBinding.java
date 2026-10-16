package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutPremiumFeatureCardViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96807c;

    private LayoutPremiumFeatureCardViewBinding(LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.f96805a = linearLayout;
        this.f96806b = imageView;
        this.f96807c = textView;
    }

    public static LayoutPremiumFeatureCardViewBinding a(View view) {
        int i3 = R.id.R0;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.f95628j2;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                return new LayoutPremiumFeatureCardViewBinding((LinearLayout) view, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutPremiumFeatureCardViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95707l0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96805a;
    }
}
