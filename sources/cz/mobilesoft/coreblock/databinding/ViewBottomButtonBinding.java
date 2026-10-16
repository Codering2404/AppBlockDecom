package cz.mobilesoft.coreblock.databinding;

import android.view.View;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ViewBottomButtonBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Button f96853b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConstraintLayout f96854c;

    private ViewBottomButtonBinding(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2) {
        this.f96852a = constraintLayout;
        this.f96853b = button;
        this.f96854c = constraintLayout2;
    }

    public static ViewBottomButtonBinding a(View view) {
        int i3 = R.id.f95666u;
        Button button = (Button) ViewBindings.a(view, i3);
        if (button == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        return new ViewBottomButtonBinding(constraintLayout, button, constraintLayout);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96852a;
    }
}
