package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentDisclaimerDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ScrollView f96635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CheckBox f96637c;

    private FragmentDisclaimerDialogBinding(ScrollView scrollView, TextView textView, CheckBox checkBox) {
        this.f96635a = scrollView;
        this.f96636b = textView;
        this.f96637c = checkBox;
    }

    public static FragmentDisclaimerDialogBinding a(View view) {
        int i3 = R.id.X;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.f95635l1;
            CheckBox checkBox = (CheckBox) ViewBindings.a(view, i3);
            if (checkBox != null) {
                return new FragmentDisclaimerDialogBinding((ScrollView) view, textView, checkBox);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentDisclaimerDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static FragmentDisclaimerDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.F, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ScrollView getRoot() {
        return this.f96635a;
    }
}
