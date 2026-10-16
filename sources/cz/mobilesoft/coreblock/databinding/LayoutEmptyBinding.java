package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.MaterialProgressButton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutEmptyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConstraintLayout f96779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f96782e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Guideline f96783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Guideline f96784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MaterialProgressButton f96785h;

    private LayoutEmptyBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, ImageView imageView, Guideline guideline, Guideline guideline2, MaterialProgressButton materialProgressButton) {
        this.f96778a = constraintLayout;
        this.f96779b = constraintLayout2;
        this.f96780c = textView;
        this.f96781d = textView2;
        this.f96782e = imageView;
        this.f96783f = guideline;
        this.f96784g = guideline2;
        this.f96785h = materialProgressButton;
    }

    public static LayoutEmptyBinding a(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i3 = R.id.f95630k0;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.f95634l0;
            TextView textView2 = (TextView) ViewBindings.a(view, i3);
            if (textView2 != null) {
                i3 = R.id.R0;
                ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                if (imageView != null) {
                    i3 = R.id.W0;
                    Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                    if (guideline != null) {
                        i3 = R.id.P1;
                        Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                        if (guideline2 != null) {
                            i3 = R.id.f95640m2;
                            MaterialProgressButton materialProgressButton = (MaterialProgressButton) ViewBindings.a(view, i3);
                            if (materialProgressButton != null) {
                                return new LayoutEmptyBinding(constraintLayout, constraintLayout, textView, textView2, imageView, guideline, guideline2, materialProgressButton);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutEmptyBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95701i0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96778a;
    }
}
