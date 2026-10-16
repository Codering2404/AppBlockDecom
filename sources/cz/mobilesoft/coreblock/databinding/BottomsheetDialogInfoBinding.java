package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class BottomsheetDialogInfoBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96507d;

    private BottomsheetDialogInfoBinding(NestedScrollView nestedScrollView, ImageView imageView, TextView textView, TextView textView2) {
        this.f96504a = nestedScrollView;
        this.f96505b = imageView;
        this.f96506c = textView;
        this.f96507d = textView2;
    }

    public static BottomsheetDialogInfoBinding a(View view) {
        int i3 = R.id.R0;
        ImageView imageView = (ImageView) ViewBindings.a(view, i3);
        if (imageView != null) {
            i3 = R.id.f95615g1;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                i3 = R.id.f95628j2;
                TextView textView2 = (TextView) ViewBindings.a(view, i3);
                if (textView2 != null) {
                    return new BottomsheetDialogInfoBinding((NestedScrollView) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static BottomsheetDialogInfoBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static BottomsheetDialogInfoBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95704k, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96504a;
    }
}
