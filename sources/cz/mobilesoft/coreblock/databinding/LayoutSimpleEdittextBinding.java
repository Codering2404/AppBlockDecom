package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class LayoutSimpleEdittextBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FrameLayout f96814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EditText f96815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f96816c;

    private LayoutSimpleEdittextBinding(FrameLayout frameLayout, EditText editText, TextView textView) {
        this.f96814a = frameLayout;
        this.f96815b = editText;
        this.f96816c = textView;
    }

    public static LayoutSimpleEdittextBinding a(View view) {
        int i3 = R.id.f95622i0;
        EditText editText = (EditText) ViewBindings.a(view, i3);
        if (editText != null) {
            i3 = R.id.f95591a1;
            TextView textView = (TextView) ViewBindings.a(view, i3);
            if (textView != null) {
                return new LayoutSimpleEdittextBinding((FrameLayout) view, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static LayoutSimpleEdittextBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static LayoutSimpleEdittextBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95711n0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f96814a;
    }
}
