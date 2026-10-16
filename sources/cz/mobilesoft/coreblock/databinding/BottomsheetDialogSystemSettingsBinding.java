package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class BottomsheetDialogSystemSettingsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f96510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96511c;

    private BottomsheetDialogSystemSettingsBinding(NestedScrollView nestedScrollView, LinearLayout linearLayout, TextView textView) {
        this.f96509a = nestedScrollView;
        this.f96510b = linearLayout;
        this.f96511c = textView;
    }

    public static BottomsheetDialogSystemSettingsBinding a(View view) {
        int i3 = R.id.M;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.a(view, i3);
        if (linearLayout != null) {
            i3 = R.id.f95628j2;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                return new BottomsheetDialogSystemSettingsBinding((NestedScrollView) view, linearLayout, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static BottomsheetDialogSystemSettingsBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static BottomsheetDialogSystemSettingsBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95706l, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96509a;
    }
}
