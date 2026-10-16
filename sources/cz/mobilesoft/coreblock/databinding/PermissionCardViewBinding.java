package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class PermissionCardViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f96841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96842d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96843e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96844f;

    private PermissionCardViewBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, TextView textView, TextView textView2) {
        this.f96839a = constraintLayout;
        this.f96840b = imageView;
        this.f96841c = imageView2;
        this.f96842d = imageView3;
        this.f96843e = textView;
        this.f96844f = textView2;
    }

    public static PermissionCardViewBinding a(View view) {
        int i3 = R.id.E;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.F;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
            if (imageView2 != null) {
                i3 = R.id.L0;
                ImageView imageView3 = (ImageView) ViewBindings.a(view, i3);
                if (imageView3 != null) {
                    i3 = R.id.f95596b2;
                    TextView textView = (TextView) ViewBindings.a(view, i3);
                    if (textView != null) {
                        i3 = R.id.f95628j2;
                        TextView textView2 = (TextView) ViewBindings.a(view, i3);
                        if (textView2 != null) {
                            return new PermissionCardViewBinding((ConstraintLayout) view, imageView, imageView2, imageView3, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static PermissionCardViewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95717q0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96839a;
    }
}
