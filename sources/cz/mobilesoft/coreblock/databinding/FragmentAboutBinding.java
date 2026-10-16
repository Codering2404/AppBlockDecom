package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAboutBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f96537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f96539c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Guideline f96540d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AppCompatImageView f96541e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Button f96542f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96543g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Guideline f96544h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f96545i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f96546j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f96547k;

    private FragmentAboutBinding(ScrollView scrollView, Button button, Button button2, Guideline guideline, AppCompatImageView appCompatImageView, Button button3, TextView textView, Guideline guideline2, TextView textView2, TextView textView3, TextView textView4) {
        this.f96537a = scrollView;
        this.f96538b = button;
        this.f96539c = button2;
        this.f96540d = guideline;
        this.f96541e = appCompatImageView;
        this.f96542f = button3;
        this.f96543g = textView;
        this.f96544h = guideline2;
        this.f96545i = textView2;
        this.f96546j = textView3;
        this.f96547k = textView4;
    }

    public static FragmentAboutBinding a(View view) {
        int i3 = R.id.f95589a;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.f95626j0;
            Button button2 = (Button) ViewBindings.a(view, i3);
            if (button2 != null) {
                i3 = R.id.W0;
                Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                if (guideline != null) {
                    i3 = R.id.f95607e1;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.a(view, i3);
                    if (appCompatImageView != null) {
                        i3 = R.id.f95623i1;
                        Button button3 = (Button) ViewBindings.a(view, i3);
                        if (button3 != null) {
                            i3 = R.id.f95627j1;
                            TextView textView = (TextView) ViewBindings.a(view, i3);
                            if (textView != null) {
                                i3 = R.id.P1;
                                Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                                if (guideline2 != null) {
                                    i3 = R.id.f95612f2;
                                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                                    if (textView2 != null) {
                                        i3 = R.id.f95628j2;
                                        TextView textView3 = (TextView) ViewBindings.a(view, i3);
                                        if (textView3 != null) {
                                            i3 = R.id.f95656q2;
                                            TextView textView4 = (TextView) ViewBindings.a(view, i3);
                                            if (textView4 != null) {
                                                return new FragmentAboutBinding((ScrollView) view, button, button2, guideline, appCompatImageView, button3, textView, guideline2, textView2, textView3, textView4);
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

    public static FragmentAboutBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95720s, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f96537a;
    }
}
