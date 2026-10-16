package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ViewSwitchCardBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SwitchCompat f96869d;

    private ViewSwitchCardBinding(ConstraintLayout constraintLayout, TextView textView, TextView textView2, SwitchCompat switchCompat) {
        this.f96866a = constraintLayout;
        this.f96867b = textView;
        this.f96868c = textView2;
        this.f96869d = switchCompat;
    }

    public static ViewSwitchCardBinding a(View view) {
        int i3 = R.id.f95665t1;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.K1;
            TextView textView2 = (TextView) ViewBindings.a(view, i3);
            if (textView2 != null) {
                i3 = R.id.f95604d2;
                SwitchCompat switchCompat = (SwitchCompat) ViewBindings.a(view, i3);
                if (switchCompat != null) {
                    return new ViewSwitchCardBinding((ConstraintLayout) view, textView, textView2, switchCompat);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ViewSwitchCardBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95727v0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96866a;
    }
}
