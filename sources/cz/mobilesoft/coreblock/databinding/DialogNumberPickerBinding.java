package cz.mobilesoft.coreblock.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.UnfocusableNumberPicker;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class DialogNumberPickerBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinearLayout f96524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RadioButton f96525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UnfocusableNumberPicker f96526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RadioButton f96527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RadioGroup f96528e;

    private DialogNumberPickerBinding(LinearLayout linearLayout, RadioButton radioButton, UnfocusableNumberPicker unfocusableNumberPicker, RadioButton radioButton2, RadioGroup radioGroup) {
        this.f96524a = linearLayout;
        this.f96525b = radioButton;
        this.f96526c = unfocusableNumberPicker;
        this.f96527d = radioButton2;
        this.f96528e = radioGroup;
    }

    public static DialogNumberPickerBinding a(View view) {
        int i3 = R.id.f95651p1;
        RadioButton radioButton = (RadioButton) ViewBindings.a(view, i3);
        if (radioButton != null) {
            i3 = R.id.f95655q1;
            UnfocusableNumberPicker unfocusableNumberPicker = (UnfocusableNumberPicker) ViewBindings.a(view, i3);
            if (unfocusableNumberPicker != null) {
                i3 = R.id.C1;
                RadioButton radioButton2 = (RadioButton) ViewBindings.a(view, i3);
                if (radioButton2 != null) {
                    i3 = R.id.G1;
                    RadioGroup radioGroup = (RadioGroup) ViewBindings.a(view, i3);
                    if (radioGroup != null) {
                        return new DialogNumberPickerBinding((LinearLayout) view, radioButton, unfocusableNumberPicker, radioButton2, radioGroup);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i3)));
    }

    public static DialogNumberPickerBinding c(LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    public static DialogNumberPickerBinding d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z2) {
        View viewInflate = layoutInflater.inflate(R.layout.f95716q, viewGroup, false);
        if (z2) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f96524a;
    }
}
