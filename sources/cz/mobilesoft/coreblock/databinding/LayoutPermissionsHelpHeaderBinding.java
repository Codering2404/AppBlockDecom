package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutPermissionsHelpHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinearLayout f96802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96803e;

    private LayoutPermissionsHelpHeaderBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2) {
        this.f96799a = frameLayout;
        this.f96800b = imageView;
        this.f96801c = textView;
        this.f96802d = linearLayout;
        this.f96803e = textView2;
    }

    public static LayoutPermissionsHelpHeaderBinding a(View view) {
        int i3 = R.id.E;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.f95616g2;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i3);
                if (linearLayout != null) {
                    i3 = R.id.f95628j2;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        return new LayoutPermissionsHelpHeaderBinding((FrameLayout) view, imageView, textView, linearLayout, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutPermissionsHelpHeaderBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95705k0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96799a;
    }
}
