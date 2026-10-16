package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ViewBottomButtonsBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f96857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Button f96858d;

    private ViewBottomButtonsBinding(ConstraintLayout constraintLayout, Button button, View view, Button button2) {
        this.f96855a = constraintLayout;
        this.f96856b = button;
        this.f96857c = view;
        this.f96858d = button2;
    }

    public static ViewBottomButtonsBinding a(View view) {
        View viewA;
        int i3 = R.id.f95666u;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button != null && (viewA = ViewBindings.a(view, (i3 = R.id.f95673w0))) != null) {
            i3 = R.id.S1;
            Button button2 = (Button) ViewBindings.a(view, i3);
            if (button2 != null) {
                return new ViewBottomButtonsBinding((ConstraintLayout) view, button, viewA, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static ViewBottomButtonsBinding c(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95723t0, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96855a;
    }
}
