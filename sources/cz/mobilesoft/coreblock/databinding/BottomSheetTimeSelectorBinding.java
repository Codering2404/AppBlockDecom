package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class BottomSheetTimeSelectorBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Barrier f96478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewBottomButtonBinding f96479d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinearLayout f96480e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LinearLayout f96481f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearLayout f96482g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinearLayout f96483h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f96484i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RadioButton f96485j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final RadioButton f96486k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f96487l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final TextView f96488m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ImageView f96489n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f96490o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Button f96491p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Button f96492q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final TextView f96493r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TextView f96494s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RadioGroup f96495t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final LinearLayout f96496u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f96497v;

    private BottomSheetTimeSelectorBinding(NestedScrollView nestedScrollView, ImageView imageView, Barrier barrier, ViewBottomButtonBinding viewBottomButtonBinding, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView, RadioButton radioButton, RadioButton radioButton2, View view, TextView textView2, ImageView imageView2, TextView textView3, Button button, Button button2, TextView textView4, TextView textView5, RadioGroup radioGroup, LinearLayout linearLayout5, View view2) {
        this.f96476a = nestedScrollView;
        this.f96477b = imageView;
        this.f96478c = barrier;
        this.f96479d = viewBottomButtonBinding;
        this.f96480e = linearLayout;
        this.f96481f = linearLayout2;
        this.f96482g = linearLayout3;
        this.f96483h = linearLayout4;
        this.f96484i = textView;
        this.f96485j = radioButton;
        this.f96486k = radioButton2;
        this.f96487l = view;
        this.f96488m = textView2;
        this.f96489n = imageView2;
        this.f96490o = textView3;
        this.f96491p = button;
        this.f96492q = button2;
        this.f96493r = textView4;
        this.f96494s = textView5;
        this.f96495t = radioGroup;
        this.f96496u = linearLayout5;
        this.f96497v = view2;
    }

    public static BottomSheetTimeSelectorBinding a(View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i3 = R.id.f95645o;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.f95657r;
            Barrier barrier = (Barrier) ViewBindings.a(view, i3);
            if (barrier != null && (viewA = ViewBindings.a(view, (i3 = R.id.f95675x))) != null) {
                ViewBottomButtonBinding viewBottomButtonBindingA = ViewBottomButtonBinding.a(viewA);
                i3 = R.id.f95681z;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i3);
                if (linearLayout != null) {
                    i3 = R.id.A;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.a(view, i3);
                    if (linearLayout2 != null) {
                        i3 = R.id.B;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.a(view, i3);
                        if (linearLayout3 != null) {
                            i3 = R.id.C;
                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.a(view, i3);
                            if (linearLayout4 != null) {
                                i3 = R.id.T;
                                TextView textView = (TextView) ViewBindings.a(view, i3);
                                if (textView != null) {
                                    i3 = R.id.U;
                                    RadioButton radioButton = (RadioButton) ViewBindings.a(view, i3);
                                    if (radioButton != null) {
                                        i3 = R.id.I0;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.a(view, i3);
                                        if (radioButton2 != null && (viewA2 = ViewBindings.a(view, (i3 = R.id.J0))) != null) {
                                            i3 = R.id.K0;
                                            TextView textView2 = (TextView) ViewBindings.a(view, i3);
                                            if (textView2 != null) {
                                                i3 = R.id.f95595b1;
                                                ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
                                                if (imageView2 != null) {
                                                    i3 = R.id.f95619h1;
                                                    TextView textView3 = (TextView) ViewBindings.a(view, i3);
                                                    if (textView3 != null) {
                                                        i3 = R.id.f95683z1;
                                                        Button button = (Button) ViewBindings.a(view, i3);
                                                        if (button != null) {
                                                            i3 = R.id.A1;
                                                            Button button2 = (Button) ViewBindings.a(view, i3);
                                                            if (button2 != null) {
                                                                i3 = R.id.B1;
                                                                TextView textView4 = (TextView) ViewBindings.a(view, i3);
                                                                if (textView4 != null) {
                                                                    i3 = R.id.E1;
                                                                    TextView textView5 = (TextView) ViewBindings.a(view, i3);
                                                                    if (textView5 != null) {
                                                                        i3 = R.id.G1;
                                                                        RadioGroup radioGroup = (RadioGroup) ViewBindings.a(view, i3);
                                                                        if (radioGroup != null) {
                                                                            i3 = R.id.T1;
                                                                            LinearLayout linearLayout5 = (LinearLayout) ViewBindings.a(view, i3);
                                                                            if (linearLayout5 != null && (viewA3 = ViewBindings.a(view, (i3 = R.id.r2))) != null) {
                                                                                return new BottomSheetTimeSelectorBinding((NestedScrollView) view, imageView, barrier, viewBottomButtonBindingA, linearLayout, linearLayout2, linearLayout3, linearLayout4, textView, radioButton, radioButton2, viewA2, textView2, imageView2, textView3, button, button2, textView4, textView5, radioGroup, linearLayout5, viewA3);
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

    public static BottomSheetTimeSelectorBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static BottomSheetTimeSelectorBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95700i, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96476a;
    }
}
