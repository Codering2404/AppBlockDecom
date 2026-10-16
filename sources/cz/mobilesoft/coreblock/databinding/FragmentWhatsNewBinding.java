package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentWhatsNewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Guideline f96709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Guideline f96710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96711g;

    private FragmentWhatsNewBinding(ConstraintLayout constraintLayout, Button button, TextView textView, ImageView imageView, Guideline guideline, Guideline guideline2, TextView textView2) {
        this.f96705a = constraintLayout;
        this.f96706b = button;
        this.f96707c = textView;
        this.f96708d = imageView;
        this.f96709e = guideline;
        this.f96710f = guideline2;
        this.f96711g = textView2;
    }

    public static FragmentWhatsNewBinding a(View view) {
        int i3 = R.id.f95678y;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.R0;
                ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                if (imageView != null) {
                    i3 = R.id.W0;
                    Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                    if (guideline != null) {
                        i3 = R.id.P1;
                        Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                        if (guideline2 != null) {
                            i3 = R.id.f95628j2;
                            TextView textView2 = (TextView) ViewBindings.a(view, i3);
                            if (textView2 != null) {
                                return new FragmentWhatsNewBinding((ConstraintLayout) view, button, textView, imageView, guideline, guideline2, textView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentWhatsNewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.P, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96705a;
    }
}
