package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentBackupProgressBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f96624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CircularProgressIndicator f96626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final NestedScrollView f96627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TextView f96628h;

    private FragmentBackupProgressBinding(NestedScrollView nestedScrollView, ImageView imageView, TextView textView, Button button, TextView textView2, CircularProgressIndicator circularProgressIndicator, NestedScrollView nestedScrollView2, TextView textView3) {
        this.f96621a = nestedScrollView;
        this.f96622b = imageView;
        this.f96623c = textView;
        this.f96624d = button;
        this.f96625e = textView2;
        this.f96626f = circularProgressIndicator;
        this.f96627g = nestedScrollView2;
        this.f96628h = textView3;
    }

    public static FragmentBackupProgressBinding a(View view) {
        int i3 = R.id.E;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.f95615g1;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.f95662s1;
                Button button = (Button) ViewBindings.a(view, i3);
                if (button != null) {
                    i3 = R.id.f95674w1;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        i3 = R.id.F1;
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.a(view, i3);
                        if (circularProgressIndicator != null) {
                            NestedScrollView nestedScrollView = (NestedScrollView) view;
                            i3 = R.id.f95628j2;
                            TextView textView3 = (TextView) ViewBindings.a(view, i3);
                            if (textView3 != null) {
                                return new FragmentBackupProgressBinding(nestedScrollView, imageView, textView, button, textView2, circularProgressIndicator, nestedScrollView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentBackupProgressBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.C, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96621a;
    }
}
