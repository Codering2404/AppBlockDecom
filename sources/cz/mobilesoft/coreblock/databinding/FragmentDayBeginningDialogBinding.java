package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.borax12.materialdaterangepicker.time.RadialPickerLayout;
import cz.mobilesoft.coreblock.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class FragmentDayBeginningDialogBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConstraintLayout f96630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RadialPickerLayout f96631b;

    private FragmentDayBeginningDialogBinding(ConstraintLayout constraintLayout, RadialPickerLayout radialPickerLayout) {
        this.f96630a = constraintLayout;
        this.f96631b = radialPickerLayout;
    }

    public static FragmentDayBeginningDialogBinding a(View view) {
        int i3 = R.id.H0;
        RadialPickerLayout radialPickerLayout = (RadialPickerLayout) ViewBindings.a(view, i3);
        if (radialPickerLayout != null) {
            return new FragmentDayBeginningDialogBinding((ConstraintLayout) view, radialPickerLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static FragmentDayBeginningDialogBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static FragmentDayBeginningDialogBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.D, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f96630a;
    }
}
