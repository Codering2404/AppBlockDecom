package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.GradientTextView;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentIntroQuestion4Binding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f96653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScrollView f96659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final GradientTextView f96660h;

    private FragmentIntroQuestion4Binding(ScrollView scrollView, Button button, TextView textView, ImageView imageView, TextView textView2, TextView textView3, ScrollView scrollView2, GradientTextView gradientTextView) {
        this.f96653a = scrollView;
        this.f96654b = button;
        this.f96655c = textView;
        this.f96656d = imageView;
        this.f96657e = textView2;
        this.f96658f = textView3;
        this.f96659g = scrollView2;
        this.f96660h = gradientTextView;
    }

    public static FragmentIntroQuestion4Binding a(View view) {
        int i3 = R.id.O;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.X;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.R0;
                ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                if (imageView != null) {
                    i3 = R.id.f95668u1;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        i3 = R.id.f95677x1;
                        TextView textView3 = (TextView) ViewBindings.a(view, i3);
                        if (textView3 != null) {
                            ScrollView scrollView = (ScrollView) view;
                            i3 = R.id.f95628j2;
                            GradientTextView gradientTextView = (GradientTextView) ViewBindings.a(view, i3);
                            if (gradientTextView != null) {
                                return new FragmentIntroQuestion4Binding(scrollView, button, textView, imageView, textView2, textView3, scrollView, gradientTextView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentIntroQuestion4Binding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.K, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f96653a;
    }
}
