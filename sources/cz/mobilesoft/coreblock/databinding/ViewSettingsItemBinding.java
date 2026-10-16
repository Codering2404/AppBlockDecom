package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ViewSettingsItemBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96865d;

    private ViewSettingsItemBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f96862a = linearLayout;
        this.f96863b = textView;
        this.f96864c = textView2;
        this.f96865d = textView3;
    }

    public static ViewSettingsItemBinding a(View view) {
        int i3 = R.id.f95596b2;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.f95628j2;
            TextView textView2 = (TextView) ViewBindings.a(view, i3);
            if (textView2 != null) {
                i3 = R.id.f95652p2;
                TextView textView3 = (TextView) ViewBindings.a(view, i3);
                if (textView3 != null) {
                    return new ViewSettingsItemBinding((LinearLayout) view, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ViewSettingsItemBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95725u0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96862a;
    }
}
