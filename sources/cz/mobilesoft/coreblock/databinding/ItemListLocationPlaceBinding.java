package cz.mobilesoft.coreblock.databinding;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ItemListLocationPlaceBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96734c;

    private ItemListLocationPlaceBinding(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f96732a = linearLayout;
        this.f96733b = textView;
        this.f96734c = textView2;
    }

    public static ItemListLocationPlaceBinding a(View view) {
        int i3 = R.id.text1;
        TextView textView = (TextView) ViewBindings.a(view, R.id.text1);
        if (textView != null) {
            i3 = R.id.title;
            TextView textView2 = (TextView) ViewBindings.a(view, R.id.title);
            if (textView2 != null) {
                return new ItemListLocationPlaceBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ItemListLocationPlaceBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(cz.mobilesoft.coreblock.R.layout.V, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96732a;
    }
}
