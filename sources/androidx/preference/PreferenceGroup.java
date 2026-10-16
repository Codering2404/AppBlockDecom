package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PreferenceGroup extends Preference {
    final SimpleArrayMap Q;
    private final Handler R;
    private final List S;
    private boolean T;
    private int U;
    private boolean V;
    private int W;
    private OnExpandButtonClickListener X;
    private final Runnable Y;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnExpandButtonClickListener {
        void a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface PreferencePositionCallback {
        int b(Preference preference);

        int f(String str);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.Q = new SimpleArrayMap();
        this.R = new Handler(Looper.getMainLooper());
        this.T = true;
        this.U = 0;
        this.V = false;
        this.W = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.X = null;
        this.Y = new Runnable() { // from class: androidx.preference.PreferenceGroup.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    PreferenceGroup.this.Q.clear();
                }
            }
        };
        this.S = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.E0, i3, i4);
        int i5 = R.styleable.G0;
        this.T = TypedArrayUtils.b(typedArrayObtainStyledAttributes, i5, i5, true);
        int i6 = R.styleable.F0;
        if (typedArrayObtainStyledAttributes.hasValue(i6)) {
            M0(TypedArrayUtils.d(typedArrayObtainStyledAttributes, i6, i6, Api.BaseClientBuilder.API_PRIORITY_OTHER));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean L0(Preference preference) {
        boolean zRemove;
        synchronized (this) {
            try {
                preference.X();
                if (preference.q() == this) {
                    preference.a(null);
                }
                zRemove = this.S.remove(preference);
                if (zRemove) {
                    String strO = preference.o();
                    if (strO != null) {
                        this.Q.put(strO, Long.valueOf(preference.m()));
                        this.R.removeCallbacks(this.Y);
                        this.R.post(this.Y);
                    }
                    if (this.V) {
                        preference.T();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zRemove;
    }

    public Preference E0(CharSequence charSequence) {
        Preference preferenceE0;
        if (charSequence == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
        if (TextUtils.equals(o(), charSequence)) {
            return this;
        }
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            Preference preferenceH0 = H0(i3);
            if (TextUtils.equals(preferenceH0.o(), charSequence)) {
                return preferenceH0;
            }
            if ((preferenceH0 instanceof PreferenceGroup) && (preferenceE0 = ((PreferenceGroup) preferenceH0).E0(charSequence)) != null) {
                return preferenceE0;
            }
        }
        return null;
    }

    public int F0() {
        return this.W;
    }

    public OnExpandButtonClickListener G0() {
        return this.X;
    }

    public Preference H0(int i3) {
        return (Preference) this.S.get(i3);
    }

    @Override // androidx.preference.Preference
    public void I(boolean z2) {
        super.I(z2);
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            H0(i3).W(this, z2);
        }
    }

    public int I0() {
        return this.S.size();
    }

    protected boolean J0() {
        return true;
    }

    public boolean K0(Preference preference) {
        boolean zL0 = L0(preference);
        O();
        return zL0;
    }

    public void M0(int i3) {
        if (i3 != Integer.MAX_VALUE && !B()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
        this.W = i3;
    }

    void N0() {
        synchronized (this) {
            Collections.sort(this.S);
        }
    }

    @Override // androidx.preference.Preference
    public void P() {
        super.P();
        this.V = true;
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            H0(i3).P();
        }
    }

    @Override // androidx.preference.Preference
    public void T() {
        super.T();
        this.V = false;
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            H0(i3).T();
        }
    }

    @Override // androidx.preference.Preference
    protected void Y(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Y(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.W = savedState.f50908a;
        super.Y(savedState.getSuperState());
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        return new SavedState(super.Z(), this.W);
    }

    @Override // androidx.preference.Preference
    protected void e(Bundle bundle) {
        super.e(bundle);
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            H0(i3).e(bundle);
        }
    }

    @Override // androidx.preference.Preference
    protected void f(Bundle bundle) {
        super.f(bundle);
        int iI0 = I0();
        for (int i3 = 0; i3 < iI0; i3++) {
            H0(i3).f(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.PreferenceGroup.SavedState.1
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
        int f50908a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f50908a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f50908a);
        }

        SavedState(Parcelable parcelable, int i3) {
            super(parcelable);
            this.f50908a = i3;
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
