package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private final Listener V;
    private CharSequence W;
    private CharSequence X;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (SwitchPreferenceCompat.this.b(Boolean.valueOf(z2))) {
                SwitchPreferenceCompat.this.F0(z2);
            } else {
                compoundButton.setChecked(!z2);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.V = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f51004d1, i3, i4);
        I0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51028l1, R.styleable.f51007e1));
        H0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51025k1, R.styleable.f51010f1));
        M0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51034n1, R.styleable.f51016h1));
        L0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51031m1, R.styleable.f51019i1));
        G0(TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51022j1, R.styleable.f51013g1, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N0(View view) {
        boolean z2 = view instanceof SwitchCompat;
        if (z2) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.Q);
        }
        if (z2) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.W);
            switchCompat.setTextOff(this.X);
            switchCompat.setOnCheckedChangeListener(this.V);
        }
    }

    private void O0(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            N0(view.findViewById(R.id.f50980i));
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
        N0(preferenceViewHolder.b(R.id.f50980i));
        K0(preferenceViewHolder);
    }

    @Override // androidx.preference.Preference
    protected void b0(View view) {
        super.b0(view);
        O0(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f50967l);
    }
}
