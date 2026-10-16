package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.badge.BadgeView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutUsageLimitEndBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppCompatImageView f96833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BadgeView f96836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96837f;

    private LayoutUsageLimitEndBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, TextView textView, ImageView imageView, BadgeView badgeView, TextView textView2) {
        this.f96832a = constraintLayout;
        this.f96833b = appCompatImageView;
        this.f96834c = textView;
        this.f96835d = imageView;
        this.f96836e = badgeView;
        this.f96837f = textView2;
    }

    public static LayoutUsageLimitEndBinding a(View view) {
        int i3 = R.id.H;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i3);
        if (appCompatImageView != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.L0;
                ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                if (imageView != null) {
                    i3 = R.id.f95603d1;
                    BadgeView badgeView = (BadgeView) ViewBindings.a(view, i3);
                    if (badgeView != null) {
                        i3 = R.id.f95628j2;
                        TextView textView2 = (TextView) ViewBindings.a(view, i3);
                        if (textView2 != null) {
                            return new LayoutUsageLimitEndBinding((ConstraintLayout) view, appCompatImageView, textView, imageView, badgeView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutUsageLimitEndBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static LayoutUsageLimitEndBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95715p0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96832a;
    }
}
