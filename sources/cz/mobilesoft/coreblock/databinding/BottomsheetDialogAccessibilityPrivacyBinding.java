package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class BottomsheetDialogAccessibilityPrivacyBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NestedScrollView f96499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewBottomButtonsBinding f96500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f96502d;

    private BottomsheetDialogAccessibilityPrivacyBinding(NestedScrollView nestedScrollView, ViewBottomButtonsBinding viewBottomButtonsBinding, TextView textView, TextView textView2) {
        this.f96499a = nestedScrollView;
        this.f96500b = viewBottomButtonsBinding;
        this.f96501c = textView;
        this.f96502d = textView2;
    }

    public static BottomsheetDialogAccessibilityPrivacyBinding a(View view) {
        int i3 = R.id.f95672w;
        View viewA = ViewBindings.a(view, i3);
        if (viewA != null) {
            ViewBottomButtonsBinding viewBottomButtonsBindingA = ViewBottomButtonsBinding.a(viewA);
            int i4 = R.id.f95615g1;
            TextView textView = (TextView) ViewBindings.a(view, i4);
            if (textView != null) {
                i4 = R.id.f95628j2;
                TextView textView2 = (TextView) ViewBindings.a(view, i4);
                if (textView2 != null) {
                    return new BottomsheetDialogAccessibilityPrivacyBinding((NestedScrollView) view, viewBottomButtonsBindingA, textView, textView2);
                }
            }
            i3 = i4;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static BottomsheetDialogAccessibilityPrivacyBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static BottomsheetDialogAccessibilityPrivacyBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95702j, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f96499a;
    }
}
