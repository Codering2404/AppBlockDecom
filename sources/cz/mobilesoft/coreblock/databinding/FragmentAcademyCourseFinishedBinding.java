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
import nl.dionsegijn.konfetti.KonfettiView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyCourseFinishedBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f96561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final KonfettiView f96562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Button f96563e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f96564f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Guideline f96565g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Guideline f96566h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ScrollView f96567i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f96568j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f96569k;

    private FragmentAcademyCourseFinishedBinding(FrameLayout frameLayout, ImageView imageView, ImageView imageView2, KonfettiView konfettiView, Button button, ImageView imageView3, Guideline guideline, Guideline guideline2, ScrollView scrollView, TextView textView, TextView textView2) {
        this.f96559a = frameLayout;
        this.f96560b = imageView;
        this.f96561c = imageView2;
        this.f96562d = konfettiView;
        this.f96563e = button;
        this.f96564f = imageView3;
        this.f96565g = guideline;
        this.f96566h = guideline2;
        this.f96567i = scrollView;
        this.f96568j = textView;
        this.f96569k = textView2;
    }

    public static FragmentAcademyCourseFinishedBinding a(View view) {
        int i3 = R.id.E;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.H;
            ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
            if (imageView2 != null) {
                i3 = R.id.L;
                KonfettiView konfettiView = (KonfettiView) ViewBindings.a(view, i3);
                if (konfettiView != null) {
                    i3 = R.id.f95670v0;
                    Button button = (Button) ViewBindings.a(view, i3);
                    if (button != null) {
                        i3 = android.R.id.icon;
                        ImageView imageView3 = (ImageView) ViewBindings.a(view, android.R.id.icon);
                        if (imageView3 != null) {
                            i3 = R.id.W0;
                            Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                            if (guideline != null) {
                                i3 = R.id.P1;
                                Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                                if (guideline2 != null) {
                                    i3 = R.id.Q1;
                                    ScrollView scrollView = (ScrollView) ViewBindings.a(view, i3);
                                    if (scrollView != null) {
                                        i3 = android.R.id.text1;
                                        TextView textView = (TextView) ViewBindings.a(view, android.R.id.text1);
                                        if (textView != null) {
                                            i3 = android.R.id.title;
                                            TextView textView2 = (TextView) ViewBindings.a(view, android.R.id.title);
                                            if (textView2 != null) {
                                                return new FragmentAcademyCourseFinishedBinding((FrameLayout) view, imageView, imageView2, konfettiView, button, imageView3, guideline, guideline2, scrollView, textView, textView2);
                                            }
                                        }
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

    public static FragmentAcademyCourseFinishedBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95724u, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96559a;
    }
}
