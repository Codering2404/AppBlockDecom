package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class CheckBoxPreference extends TwoStatePreference {
    private final Listener V;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Listener implements CompoundButton.OnCheckedChangeListener {
        Listener() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
            if (CheckBoxPreference.this.b(Boolean.valueOf(z2))) {
                CheckBoxPreference.this.F0(z2);
            } else {
                compoundButton.setChecked(!z2);
            }
        }
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void L0(View view) {
        boolean z2 = view instanceof CompoundButton;
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.Q);
        }
        if (z2) {
            ((CompoundButton) view).setOnCheckedChangeListener(this.V);
        }
    }

    private void M0(View view) {
        if (((AccessibilityManager) h().getSystemService("accessibility")).isEnabled()) {
            L0(view.findViewById(android.R.id.checkbox));
            J0(view.findViewById(android.R.id.summary));
        }
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        super.Q(preferenceViewHolder);
        L0(preferenceViewHolder.b(android.R.id.checkbox));
        K0(preferenceViewHolder);
    }

    @Override // androidx.preference.Preference
    protected void b0(View view) {
        super.b0(view);
        M0(view);
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.V = new Listener();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f50999c, i3, i4);
        I0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51017i, R.styleable.f51002d));
        H0(TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51014h, R.styleable.f51005e));
        G0(TypedArrayUtils.b(typedArrayObtainStyledAttributes, R.styleable.f51011g, R.styleable.f51008f, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    public CheckBoxPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50956a, android.R.attr.checkBoxPreferenceStyle));
    }
}
