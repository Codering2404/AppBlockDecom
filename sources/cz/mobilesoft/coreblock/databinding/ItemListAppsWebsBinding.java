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
import cz.mobilesoft.coreblock.view.AppWebsUsageBar;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListAppsWebsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AppWebsUsageBar f96720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f96721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f96723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96725g;

    private ItemListAppsWebsBinding(ConstraintLayout constraintLayout, AppWebsUsageBar appWebsUsageBar, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.f96719a = constraintLayout;
        this.f96720b = appWebsUsageBar;
        this.f96721c = constraintLayout2;
        this.f96722d = imageView;
        this.f96723e = imageView2;
        this.f96724f = textView;
        this.f96725g = textView2;
    }

    public static ItemListAppsWebsBinding a(View view) {
        int i3 = R.id.f95625j;
        AppWebsUsageBar appWebsUsageBar = (AppWebsUsageBar) ViewBindings.a(view, i3);
        if (appWebsUsageBar != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i3 = android.R.id.icon;
            ImageView imageView = (ImageView) ViewBindings.a(view, android.R.id.icon);
            if (imageView != null) {
                i3 = R.id.f95611f1;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
                if (imageView2 != null) {
                    i3 = R.id.f95631k1;
                    TextView textView = (TextView) ViewBindings.a(view, i3);
                    if (textView != null) {
                        i3 = R.id.f95620h2;
                        TextView textView2 = (TextView) ViewBindings.a(view, i3);
                        if (textView2 != null) {
                            return new ItemListAppsWebsBinding(constraintLayout, appWebsUsageBar, constraintLayout, imageView, imageView2, textView, textView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ItemListAppsWebsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.S, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96719a;
    }
}
