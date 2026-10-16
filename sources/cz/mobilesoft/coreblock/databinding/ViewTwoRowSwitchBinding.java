package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.switchmaterial.SwitchMaterial;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ViewTwoRowSwitchBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f96872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AppCompatTextView f96873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SwitchMaterial f96874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96875f;

    private ViewTwoRowSwitchBinding(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, AppCompatTextView appCompatTextView, SwitchMaterial switchMaterial, TextView textView) {
        this.f96870a = constraintLayout;
        this.f96871b = imageView;
        this.f96872c = imageView2;
        this.f96873d = appCompatTextView;
        this.f96874e = switchMaterial;
        this.f96875f = textView;
    }

    public static ViewTwoRowSwitchBinding a(View view) {
        int i3 = R.id.f95642n0;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.R0;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
            if (imageView2 != null) {
                i3 = R.id.f95596b2;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.a(view, i3);
                if (appCompatTextView != null) {
                    i3 = R.id.f95600c2;
                    SwitchMaterial switchMaterial = (SwitchMaterial) ViewBindings.a(view, i3);
                    if (switchMaterial != null) {
                        i3 = R.id.f95628j2;
                        TextView textView = (TextView) ViewBindings.a(view, i3);
                        if (textView != null) {
                            return new ViewTwoRowSwitchBinding((ConstraintLayout) view, imageView, imageView2, appCompatTextView, switchMaterial, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ViewTwoRowSwitchBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95729w0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96870a;
    }
}
