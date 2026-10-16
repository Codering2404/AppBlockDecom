package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class DialogBlockingReasonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f96513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f96514c;

    private DialogBlockingReasonBinding(LinearLayout linearLayout, TextView textView, Button button) {
        this.f96512a = linearLayout;
        this.f96513b = textView;
        this.f96514c = button;
    }

    public static DialogBlockingReasonBinding a(View view) {
        int i3 = R.id.f95663t;
        TextView textView = (TextView) ViewBindings.a(view, i3);
        if (textView != null) {
            i3 = R.id.f95650p0;
            Button button = (Button) ViewBindings.a(view, i3);
            if (button != null) {
                return new DialogBlockingReasonBinding((LinearLayout) view, textView, button);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static DialogBlockingReasonBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static DialogBlockingReasonBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95708m, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96512a;
    }
}
