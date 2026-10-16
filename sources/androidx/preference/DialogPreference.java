package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence Q;
    private CharSequence R;
    private Drawable S;
    private CharSequence T;
    private CharSequence U;
    private int V;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TargetFragment {
        Preference h(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f51020j, i3, i4);
        String strM = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51045t, R.styleable.f51023k);
        this.Q = strM;
        if (strM == null) {
            this.Q = z();
        }
        this.R = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51043s, R.styleable.f51026l);
        this.S = TypedArrayUtils.c(typedArrayObtainStyledAttributes, R.styleable.f51039q, R.styleable.f51029m);
        this.T = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51049v, R.styleable.f51032n);
        this.U = TypedArrayUtils.m(typedArrayObtainStyledAttributes, R.styleable.f51047u, R.styleable.f51035o);
        this.V = TypedArrayUtils.l(typedArrayObtainStyledAttributes, R.styleable.f51041r, R.styleable.f51037p, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable E0() {
        return this.S;
    }

    public int F0() {
        return this.V;
    }

    public CharSequence G0() {
        return this.R;
    }

    public CharSequence H0() {
        return this.Q;
    }

    public CharSequence I0() {
        return this.U;
    }

    public CharSequence J0() {
        return this.T;
    }

    @Override // androidx.preference.Preference
    protected void R() {
        w().q(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50957b, android.R.attr.dialogPreferenceStyle));
    }
}
