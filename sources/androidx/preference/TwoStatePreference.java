package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TwoStatePreference extends Preference {
    protected boolean Q;
    private CharSequence R;
    private CharSequence S;
    private boolean T;
    private boolean U;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
    }

    public boolean E0() {
        return this.Q;
    }

    public void F0(boolean z2) {
        boolean z3 = this.Q != z2;
        if (z3 || !this.T) {
            this.Q = z2;
            this.T = true;
            c0(z2);
            if (z3) {
                I(x0());
                H();
            }
        }
    }

    public void G0(boolean z2) {
        this.U = z2;
    }

    public void H0(CharSequence charSequence) {
        this.S = charSequence;
        if (E0()) {
            return;
        }
        H();
    }

    public void I0(CharSequence charSequence) {
        this.R = charSequence;
        if (E0()) {
            H();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void J0(android.view.View r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r5 = (android.widget.TextView) r5
            boolean r0 = r4.Q
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r4.R
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r4.R
            r5.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r4.Q
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.S
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r4.S
            r5.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r2 = r4.x()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L3e
            r5.setText(r2)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r0 = r5.getVisibility()
            if (r1 == r0) goto L4c
            r5.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.J0(android.view.View):void");
    }

    protected void K0(PreferenceViewHolder preferenceViewHolder) {
        J0(preferenceViewHolder.b(android.R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected void R() {
        super.R();
        boolean z2 = !E0();
        if (b(Boolean.valueOf(z2))) {
            F0(z2);
        }
    }

    @Override // androidx.preference.Preference
    protected Object U(TypedArray typedArray, int i3) {
        return Boolean.valueOf(typedArray.getBoolean(i3, false));
    }

    @Override // androidx.preference.Preference
    protected void Y(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Y(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Y(savedState.getSuperState());
        F0(savedState.f51068a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        Parcelable parcelableZ = super.Z();
        if (E()) {
            return parcelableZ;
        }
        SavedState savedState = new SavedState(parcelableZ);
        savedState.f51068a = E0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public boolean x0() {
        return (this.U ? this.Q : !this.Q) || super.x0();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.TwoStatePreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f51068a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f51068a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f51068a ? 1 : 0);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
