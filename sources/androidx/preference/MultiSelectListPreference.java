package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MultiSelectListPreference extends DialogPreference {
    private CharSequence[] W;
    private CharSequence[] X;
    private Set Y;

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.Y = new HashSet();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.E, i3, i4);
        this.W = TypedArrayUtils.o(typedArrayObtainStyledAttributes, R.styleable.H, R.styleable.F);
        this.X = TypedArrayUtils.o(typedArrayObtainStyledAttributes, R.styleable.I, R.styleable.G);
        typedArrayObtainStyledAttributes.recycle();
    }

    public CharSequence[] K0() {
        return this.W;
    }

    public CharSequence[] L0() {
        return this.X;
    }

    public Set M0() {
        return this.Y;
    }

    public void N0(Set set) {
        this.Y.clear();
        this.Y.addAll(set);
        f0(set);
        H();
    }

    @Override // androidx.preference.Preference
    protected Object U(TypedArray typedArray, int i3) {
        CharSequence[] textArray = typedArray.getTextArray(i3);
        HashSet hashSet = new HashSet();
        for (CharSequence charSequence : textArray) {
            hashSet.add(charSequence.toString());
        }
        return hashSet;
    }

    @Override // androidx.preference.Preference
    protected void Y(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Y(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Y(savedState.getSuperState());
        N0(savedState.f50808a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        Parcelable parcelableZ = super.Z();
        if (E()) {
            return parcelableZ;
        }
        SavedState savedState = new SavedState(parcelableZ);
        savedState.f50808a = M0();
        return savedState;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.MultiSelectListPreference.SavedState.1
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
        Set f50808a;

        SavedState(Parcel parcel) {
            super(parcel);
            int i3 = parcel.readInt();
            this.f50808a = new HashSet();
            String[] strArr = new String[i3];
            parcel.readStringArray(strArr);
            Collections.addAll(this.f50808a, strArr);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f50808a.size());
            Set set = this.f50808a;
            parcel.writeStringArray((String[]) set.toArray(new String[set.size()]));
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public MultiSelectListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50957b, android.R.attr.dialogPreferenceStyle));
    }
}
