package cz.mobilesoft.coreblock.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutCourseCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ProgressBar f96766c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96769f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96770g;

    private LayoutCourseCardBinding(ConstraintLayout constraintLayout, ImageView imageView, ProgressBar progressBar, ImageView imageView2, TextView textView, TextView textView2, TextView textView3) {
        this.f96764a = constraintLayout;
        this.f96765b = imageView;
        this.f96766c = progressBar;
        this.f96767d = imageView2;
        this.f96768e = textView;
        this.f96769f = textView2;
        this.f96770g = textView3;
    }

    public static LayoutCourseCardBinding a(View view) {
        int i3 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.a(view, R.id.icon);
        if (imageView != null) {
            i3 = R.id.progress;
            ProgressBar progressBar = (ProgressBar) ViewBindings.a(view, R.id.progress);
            if (progressBar != null) {
                i3 = cz.mobilesoft.coreblock.R.id.X1;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
                if (imageView2 != null) {
                    i3 = R.id.text1;
                    TextView textView = (TextView) ViewBindings.a(view, R.id.text1);
                    if (textView != null) {
                        i3 = R.id.text2;
                        TextView textView2 = (TextView) ViewBindings.a(view, R.id.text2);
                        if (textView2 != null) {
                            i3 = R.id.title;
                            TextView textView3 = (TextView) ViewBindings.a(view, R.id.title);
                            if (textView3 != null) {
                                return new LayoutCourseCardBinding((ConstraintLayout) view, imageView, progressBar, imageView2, textView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutCourseCardBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(cz.mobilesoft.coreblock.R.layout.f95699h0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96764a;
    }
}
