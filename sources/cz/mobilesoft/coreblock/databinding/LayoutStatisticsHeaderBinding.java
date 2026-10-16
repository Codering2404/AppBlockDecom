package cz.mobilesoft.coreblock.databinding;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutStatisticsHeaderBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f96818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewPager2 f96819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f96823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageButton f96824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f96825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ImageButton f96826j;

    private LayoutStatisticsHeaderBinding(LinearLayout linearLayout, LinearLayout linearLayout2, ViewPager2 viewPager2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageButton imageButton, TextView textView5, ImageButton imageButton2) {
        this.f96817a = linearLayout;
        this.f96818b = linearLayout2;
        this.f96819c = viewPager2;
        this.f96820d = textView;
        this.f96821e = textView2;
        this.f96822f = textView3;
        this.f96823g = textView4;
        this.f96824h = imageButton;
        this.f96825i = textView5;
        this.f96826j = imageButton2;
    }

    public static LayoutStatisticsHeaderBinding a(View view) {
        LinearLayout linearLayout = (LinearLayout) view;
        int i3 = R.id.f95676x0;
        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.a(view, i3);
        if (viewPager2 != null) {
            i3 = R.id.f95679y0;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.f95682z0;
                TextView textView2 = (TextView) ViewBindings.a(view, i3);
                if (textView2 != null) {
                    i3 = R.id.A0;
                    TextView textView3 = (TextView) ViewBindings.a(view, i3);
                    if (textView3 != null) {
                        i3 = R.id.U0;
                        TextView textView4 = (TextView) ViewBindings.a(view, i3);
                        if (textView4 != null) {
                            i3 = R.id.V0;
                            ImageButton imageButton = (ImageButton) ViewBindings.a(view, i3);
                            if (imageButton != null) {
                                i3 = R.id.f95647o1;
                                TextView textView5 = (TextView) ViewBindings.a(view, i3);
                                if (textView5 != null) {
                                    i3 = R.id.O1;
                                    ImageButton imageButton2 = (ImageButton) ViewBindings.a(view, i3);
                                    if (imageButton2 != null) {
                                        return new LayoutStatisticsHeaderBinding(linearLayout, linearLayout, viewPager2, textView, textView2, textView3, textView4, imageButton, textView5, imageButton2);
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

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96817a;
    }
}
