package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyLessonUnavailableBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Guideline f96588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Guideline f96589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScrollView f96590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Button f96592i;

    private FragmentAcademyLessonUnavailableBinding(FrameLayout frameLayout, ImageView imageView, TextView textView, ImageView imageView2, Guideline guideline, Guideline guideline2, ScrollView scrollView, TextView textView2, Button button) {
        this.f96584a = frameLayout;
        this.f96585b = imageView;
        this.f96586c = textView;
        this.f96587d = imageView2;
        this.f96588e = guideline;
        this.f96589f = guideline2;
        this.f96590g = scrollView;
        this.f96591h = textView2;
        this.f96592i = button;
    }

    public static FragmentAcademyLessonUnavailableBinding a(View view) {
        int i3 = R.id.H;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = android.R.id.icon;
                ImageView imageView2 = (ImageView) ViewBindings.a(view, android.R.id.icon);
                if (imageView2 != null) {
                    i3 = R.id.W0;
                    Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                    if (guideline != null) {
                        i3 = R.id.P1;
                        Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                        if (guideline2 != null) {
                            i3 = R.id.Q1;
                            ScrollView scrollView = (ScrollView) ViewBindings.a(view, i3);
                            if (scrollView != null) {
                                i3 = R.id.f95628j2;
                                TextView textView2 = (TextView) ViewBindings.a(view, i3);
                                if (textView2 != null) {
                                    i3 = R.id.f95648o2;
                                    Button button = (Button) ViewBindings.a(view, i3);
                                    if (button != null) {
                                        return new FragmentAcademyLessonUnavailableBinding((FrameLayout) view, imageView, textView, imageView2, guideline, guideline2, scrollView, textView2, button);
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

    public static FragmentAcademyLessonUnavailableBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95730x, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96584a;
    }
}
