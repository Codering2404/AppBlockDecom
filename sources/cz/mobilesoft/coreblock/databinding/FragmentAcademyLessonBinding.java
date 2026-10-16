package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.MaterialProgressButton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyLessonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoordinatorLayout f96575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f96576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AppBarLayout f96577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CollapsingToolbarLayout f96578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MaterialProgressButton f96579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final NestedScrollView f96580f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96581g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Toolbar f96582h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WebView f96583i;

    private FragmentAcademyLessonBinding(CoordinatorLayout coordinatorLayout, LinearLayout linearLayout, AppBarLayout appBarLayout, CollapsingToolbarLayout collapsingToolbarLayout, MaterialProgressButton materialProgressButton, NestedScrollView nestedScrollView, TextView textView, Toolbar toolbar, WebView webView) {
        this.f96575a = coordinatorLayout;
        this.f96576b = linearLayout;
        this.f96577c = appBarLayout;
        this.f96578d = collapsingToolbarLayout;
        this.f96579e = materialProgressButton;
        this.f96580f = nestedScrollView;
        this.f96581g = textView;
        this.f96582h = toolbar;
        this.f96583i = webView;
    }

    public static FragmentAcademyLessonBinding a(View view) {
        int i3 = R.id.f95593b;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i3);
        if (linearLayout != null) {
            i3 = R.id.f95621i;
            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.a(view, i3);
            if (appBarLayout != null) {
                i3 = R.id.J;
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.a(view, i3);
                if (collapsingToolbarLayout != null) {
                    i3 = R.id.f95661s0;
                    MaterialProgressButton materialProgressButton = (MaterialProgressButton) ViewBindings.a(view, i3);
                    if (materialProgressButton != null) {
                        i3 = R.id.Q1;
                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i3);
                        if (nestedScrollView != null) {
                            i3 = android.R.id.summary;
                            TextView textView = (TextView) ViewBindings.a(view, android.R.id.summary);
                            if (textView != null) {
                                i3 = R.id.f95636l2;
                                Toolbar toolbar = (Toolbar) ViewBindings.a(view, i3);
                                if (toolbar != null) {
                                    i3 = R.id.s2;
                                    WebView webView = (WebView) ViewBindings.a(view, i3);
                                    if (webView != null) {
                                        return new FragmentAcademyLessonBinding((CoordinatorLayout) view, linearLayout, appBarLayout, collapsingToolbarLayout, materialProgressButton, nestedScrollView, textView, toolbar, webView);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentAcademyLessonBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95728w, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public CoordinatorLayout getRoot() {
        return this.f96575a;
    }
}
