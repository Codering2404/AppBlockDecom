package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentStatisticsOverviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RadioButton f96687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RadioButton f96688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RecyclerView f96689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f96691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ConstraintLayout f96694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f96695j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final FrameLayout f96696k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Guideline f96697l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final RadioGroup f96698m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NestedScrollView f96699n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LayoutStatisticsHeaderBinding f96700o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LayoutStatisticsToolbarBinding f96701p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final RadioButton f96702q;

    private FragmentStatisticsOverviewBinding(LinearLayout linearLayout, RadioButton radioButton, RadioButton radioButton2, RecyclerView recyclerView, TextView textView, ImageView imageView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout, View view, FrameLayout frameLayout, Guideline guideline, RadioGroup radioGroup, NestedScrollView nestedScrollView, LayoutStatisticsHeaderBinding layoutStatisticsHeaderBinding, LayoutStatisticsToolbarBinding layoutStatisticsToolbarBinding, RadioButton radioButton3) {
        this.f96686a = linearLayout;
        this.f96687b = radioButton;
        this.f96688c = radioButton2;
        this.f96689d = recyclerView;
        this.f96690e = textView;
        this.f96691f = imageView;
        this.f96692g = textView2;
        this.f96693h = textView3;
        this.f96694i = constraintLayout;
        this.f96695j = view;
        this.f96696k = frameLayout;
        this.f96697l = guideline;
        this.f96698m = radioGroup;
        this.f96699n = nestedScrollView;
        this.f96700o = layoutStatisticsHeaderBinding;
        this.f96701p = layoutStatisticsToolbarBinding;
        this.f96702q = radioButton3;
    }

    public static FragmentStatisticsOverviewBinding a(View view) {
        View viewA;
        View viewA2;
        int i3 = R.id.f95617h;
        RadioButton radioButton = (RadioButton) ViewBindings.a(view, i3);
        if (radioButton != null) {
            i3 = R.id.f95633l;
            RadioButton radioButton2 = (RadioButton) ViewBindings.a(view, i3);
            if (radioButton2 != null) {
                i3 = R.id.f95637m;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.a(view, i3);
                if (recyclerView != null) {
                    i3 = R.id.Z;
                    TextView textView = (TextView) ViewBindings.a(view, i3);
                    if (textView != null) {
                        i3 = R.id.f95590a0;
                        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                        if (imageView != null) {
                            i3 = R.id.f95594b0;
                            TextView textView2 = (TextView) ViewBindings.a(view, i3);
                            if (textView2 != null) {
                                i3 = R.id.f95598c0;
                                TextView textView3 = (TextView) ViewBindings.a(view, i3);
                                if (textView3 != null) {
                                    i3 = R.id.f95602d0;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.a(view, i3);
                                    if (constraintLayout != null && (viewA = ViewBindings.a(view, (i3 = R.id.f95606e0))) != null) {
                                        i3 = R.id.f95667u0;
                                        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, i3);
                                        if (frameLayout != null) {
                                            i3 = R.id.S0;
                                            Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                                            if (guideline != null) {
                                                i3 = R.id.G1;
                                                RadioGroup radioGroup = (RadioGroup) ViewBindings.a(view, i3);
                                                if (radioGroup != null) {
                                                    i3 = R.id.Q1;
                                                    NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.a(view, i3);
                                                    if (nestedScrollView != null && (viewA2 = ViewBindings.a(view, (i3 = R.id.Y1))) != null) {
                                                        LayoutStatisticsHeaderBinding layoutStatisticsHeaderBindingA = LayoutStatisticsHeaderBinding.a(viewA2);
                                                        i3 = R.id.Z1;
                                                        View viewA3 = ViewBindings.a(view, i3);
                                                        if (viewA3 != null) {
                                                            LayoutStatisticsToolbarBinding layoutStatisticsToolbarBindingA = LayoutStatisticsToolbarBinding.a(viewA3);
                                                            i3 = R.id.t2;
                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.a(view, i3);
                                                            if (radioButton3 != null) {
                                                                return new FragmentStatisticsOverviewBinding((LinearLayout) view, radioButton, radioButton2, recyclerView, textView, imageView, textView2, textView3, constraintLayout, viewA, frameLayout, guideline, radioGroup, nestedScrollView, layoutStatisticsHeaderBindingA, layoutStatisticsToolbarBindingA, radioButton3);
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

    public static FragmentStatisticsOverviewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.O, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96686a;
    }
}
