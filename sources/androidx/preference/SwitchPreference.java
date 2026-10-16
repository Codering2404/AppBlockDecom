package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SwitchPreference extends TwoStatePreference {
    private final Listener V;
    private CharSequence W;
    private CharSequence X;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (SwitchPreference.this.b(Boolean.valueOf(z2))) {
                SwitchPreference.this.F0(z2);
            } else {
                compoundButton.setChecked(!z2);
            }
        }
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.V = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.S0, i3, i4);
        I0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f50995a1, R.styleable.T0));
        H0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.Z0, R.styleable.U0));
        M0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51001c1, R.styleable.W0));
        L0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f50998b1, R.styleable.X0));
        G0(TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.Y0, R.styleable.V0, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N0(View view) {
        boolean z2 = view instanceof Switch;
        if (z2) {
            ((Switch) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.Q);
        }
        if (z2) {
            Switch r4 = (Switch) view;
            r4.setTextOn(this.W);
            r4.setTextOff(this.X);
            r4.setOnCheckedChangeListener(this.V);
        }
    }

    private void O0(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            N0(view.findViewById(android.R.id.switch_widget));
            J0(view.findViewById(android.R.id.summary));
        }
    }

    public void L0(CharSequence charSequence) {
        this.X = charSequence;
        H();
    }

    public void M0(CharSequence charSequence) {
        this.W = charSequence;
        H();
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        super.Q(preferenceViewHolder);
        N0(preferenceViewHolder.b(android.R.id.switch_widget));
        K0(preferenceViewHolder);
    }

    @Override // androidx.preference.Preference
    protected void b0(View view) {
        super.b0(view);
        O0(view);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50968m, android.R.attr.switchPreferenceStyle));
    }
}
