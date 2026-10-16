package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentAcademyAnotherCurrentLessonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f96550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Guideline f96551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f96552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ImageView f96553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f96554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Guideline f96555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Button f96556i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f96557j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final TextView f96558k;

    private FragmentAcademyAnotherCurrentLessonBinding(ConstraintLayout constraintLayout, Button button, ImageView imageView, Guideline guideline, ImageView imageView2, ImageView imageView3, ImageView imageView4, Guideline guideline2, Button button2, TextView textView, TextView textView2) {
        this.f96548a = constraintLayout;
        this.f96549b = button;
        this.f96550c = imageView;
        this.f96551d = guideline;
        this.f96552e = imageView2;
        this.f96553f = imageView3;
        this.f96554g = imageView4;
        this.f96555h = guideline2;
        this.f96556i = button2;
        this.f96557j = textView;
        this.f96558k = textView2;
    }

    public static FragmentAcademyAnotherCurrentLessonBinding a(View view) {
        int i3 = R.id.P;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.S;
            ImageView imageView = (ImageView) ViewBindings.a(view, i3);
            if (imageView != null) {
                i3 = R.id.W0;
                Guideline guideline = (Guideline) ViewBindings.a(view, i3);
                if (guideline != null) {
                    i3 = R.id.f95639m1;
                    ImageView imageView2 = (ImageView) ViewBindings.a(view, i3);
                    if (imageView2 != null) {
                        i3 = R.id.f95671v1;
                        ImageView imageView3 = (ImageView) ViewBindings.a(view, i3);
                        if (imageView3 != null) {
                            i3 = R.id.f95680y1;
                            ImageView imageView4 = (ImageView) ViewBindings.a(view, i3);
                            if (imageView4 != null) {
                                i3 = R.id.P1;
                                Guideline guideline2 = (Guideline) ViewBindings.a(view, i3);
                                if (guideline2 != null) {
                                    i3 = R.id.W1;
                                    Button button2 = (Button) ViewBindings.a(view, i3);
                                    if (button2 != null) {
                                        i3 = R.id.f95596b2;
                                        TextView textView = (TextView) ViewBindings.a(view, i3);
                                        if (textView != null) {
                                            i3 = R.id.f95628j2;
                                            TextView textView2 = (TextView) ViewBindings.a(view, i3);
                                            if (textView2 != null) {
                                                return new FragmentAcademyAnotherCurrentLessonBinding((ConstraintLayout) view, button, imageView, guideline, imageView2, imageView3, imageView4, guideline2, button2, textView, textView2);
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

    public static FragmentAcademyAnotherCurrentLessonBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95722t, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96548a;
    }
}
