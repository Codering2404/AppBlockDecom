package cz.mobilesoft.coreblock.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutLessonCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f96790b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f96791c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImageView f96792d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f96793e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96794f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96795g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96796h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f96797i;

    private LayoutLessonCardBinding(ConstraintLayout constraintLayout, FrameLayout frameLayout, Button button, ImageView imageView, FrameLayout frameLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.f96789a = constraintLayout;
        this.f96790b = frameLayout;
        this.f96791c = button;
        this.f96792d = imageView;
        this.f96793e = frameLayout2;
        this.f96794f = textView;
        this.f96795g = textView2;
        this.f96796h = textView3;
        this.f96797i = textView4;
    }

    public static LayoutLessonCardBinding a(View view) {
        int i3 = R.id.button1;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.a(view, R.id.button1);
        if (frameLayout != null) {
            i3 = cz.mobilesoft.coreblock.R.id.f95654q0;
            Button button = (Button) ViewBindings.a(view, i3);
            if (button != null) {
                i3 = R.id.icon;
                ImageView imageView = (ImageView) ViewBindings.a(view, R.id.icon);
                if (imageView != null) {
                    i3 = cz.mobilesoft.coreblock.R.id.M0;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.a(view, i3);
                    if (frameLayout2 != null) {
                        i3 = cz.mobilesoft.coreblock.R.id.f95659r1;
                        TextView textView = (TextView) ViewBindings.a(view, i3);
                        if (textView != null) {
                            i3 = R.id.text1;
                            TextView textView2 = (TextView) ViewBindings.a(view, R.id.text1);
                            if (textView2 != null) {
                                i3 = R.id.text2;
                                TextView textView3 = (TextView) ViewBindings.a(view, R.id.text2);
                                if (textView3 != null) {
                                    i3 = R.id.title;
                                    TextView textView4 = (TextView) ViewBindings.a(view, R.id.title);
                                    if (textView4 != null) {
                                        return new LayoutLessonCardBinding((ConstraintLayout) view, frameLayout, button, imageView, frameLayout2, textView, textView2, textView3, textView4);
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

    public static LayoutLessonCardBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(cz.mobilesoft.coreblock.R.layout.f95703j0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96789a;
    }
}
