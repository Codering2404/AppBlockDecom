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
public final class DialogGenerateBackdoorCodeBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f96517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96518d;

    private DialogGenerateBackdoorCodeBinding(LinearLayout linearLayout, TextView textView, ImageView imageView, ImageView imageView2) {
        this.f96515a = linearLayout;
        this.f96516b = textView;
        this.f96517c = imageView;
        this.f96518d = imageView2;
    }

    public static DialogGenerateBackdoorCodeBinding a(View view) {
        int i3 = R.id.I;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.Q;
            ImageView imageView = (ImageView) ViewBindings.a(view, i3);
            if (imageView != null) {
                i3 = R.id.J1;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
                if (imageView2 != null) {
                    return new DialogGenerateBackdoorCodeBinding((LinearLayout) view, textView, imageView, imageView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static DialogGenerateBackdoorCodeBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static DialogGenerateBackdoorCodeBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95710n, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96515a;
    }
}
