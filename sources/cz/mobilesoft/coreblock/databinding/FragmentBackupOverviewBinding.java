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
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentBackupOverviewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f96614d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f96615e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f96616f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f96617g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Button f96618h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final NestedScrollView f96619i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final TextView f96620j;

    private FragmentBackupOverviewBinding(NestedScrollView nestedScrollView, Button button, TextView textView, Button button2, TextView textView2, TextView textView3, ImageView imageView, Button button3, NestedScrollView nestedScrollView2, TextView textView4) {
        this.f96611a = nestedScrollView;
        this.f96612b = button;
        this.f96613c = textView;
        this.f96614d = button2;
        this.f96615e = textView2;
        this.f96616f = textView3;
        this.f96617g = imageView;
        this.f96618h = button3;
        this.f96619i = nestedScrollView2;
        this.f96620j = textView4;
    }

    public static FragmentBackupOverviewBinding a(View view) {
        int i3 = R.id.f95649p;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null) {
            i3 = R.id.f95653q;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.W;
                Button button2 = (Button) ViewBindings.a(view, i3);
                if (button2 != null) {
                    i3 = R.id.X;
                    TextView textView2 = (TextView) ViewBindings.a(view, i3);
                    if (textView2 != null) {
                        i3 = R.id.Y;
                        TextView textView3 = (TextView) ViewBindings.a(view, i3);
                        if (textView3 != null) {
                            i3 = R.id.R0;
                            ImageView imageView = (ImageView) ViewBindings.a(view, i3);
                            if (imageView != null) {
                                i3 = R.id.L1;
                                Button button3 = (Button) ViewBindings.a(view, i3);
                                if (button3 != null) {
                                    NestedScrollView nestedScrollView = (NestedScrollView) view;
                                    i3 = R.id.f95628j2;
                                    TextView textView4 = (TextView) ViewBindings.a(view, i3);
                                    if (textView4 != null) {
                                        return new FragmentBackupOverviewBinding(nestedScrollView, button, textView, button2, textView2, textView3, imageView, button3, nestedScrollView, textView4);
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

    public static FragmentBackupOverviewBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.B, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96611a;
    }
}
