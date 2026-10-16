package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ListPreference extends DialogPreference {
    private CharSequence[] W;
    private CharSequence[] X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f50797a0;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<ListPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SimpleSummaryProvider f50799a;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider b() {
            if (f50799a == null) {
                f50799a = new SimpleSummaryProvider();
            }
            return f50799a;
        }

        @Override // androidx.preference.Preference.SummaryProvider
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(ListPreference listPreference) {
            return TextUtils.isEmpty(listPreference.M0()) ? listPreference.h().getString(R.string.f50989c) : listPreference.M0();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f51055y, i3, i4);
        this.W = TypedArrayUtils.o(typedArrayObtainStyledAttributes, R.styleable.B, R.styleable.f51057z);
        this.X = TypedArrayUtils.o(typedArrayObtainStyledAttributes, R.styleable.C, R.styleable.A);
        int i5 = R.styleable.D;
        if (TypedArrayUtils.b(typedArrayObtainStyledAttributes, i5, i5, false)) {
            t0(SimpleSummaryProvider.b());
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.J, i3, i4);
        this.Z = TypedArrayUtils.m(typedArrayObtainStyledAttributes2, R.styleable.f51042r0, R.styleable.R);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private int P0() {
        return K0(this.Y);
    }

    public int K0(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.X) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (TextUtils.equals(this.X[length].toString(), str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] L0() {
        return this.W;
    }

    public CharSequence M0() {
        CharSequence[] charSequenceArr;
        int iP0 = P0();
        if (iP0 < 0 || (charSequenceArr = this.W) == null) {
            return null;
        }
        return charSequenceArr[iP0];
    }

    public CharSequence[] N0() {
        return this.X;
    }

    public String O0() {
        return this.Y;
    }

    public void Q0(String str) {
        boolean zEquals = TextUtils.equals(this.Y, str);
        if (zEquals && this.f50797a0) {
            return;
        }
        this.Y = str;
        this.f50797a0 = true;
        e0(str);
        if (zEquals) {
            return;
        }
        H();
    }

    @Override // androidx.preference.Preference
    protected Object U(TypedArray typedArray, int i3) {
        return typedArray.getString(i3);
    }

    @Override // androidx.preference.Preference
    protected void Y(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Y(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Y(savedState.getSuperState());
        Q0(savedState.f50798a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        Parcelable parcelableZ = super.Z();
        if (E()) {
            return parcelableZ;
        }
        SavedState savedState = new SavedState(parcelableZ);
        savedState.f50798a = O0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public CharSequence x() {
        if (y() != null) {
            return y().a(this);
        }
        CharSequence charSequenceM0 = M0();
        CharSequence charSequenceX = super.x();
        String str = this.Z;
        if (str != null) {
            if (charSequenceM0 == null) {
                charSequenceM0 = "";
            }
            String str2 = String.format(str, charSequenceM0);
            if (!TextUtils.equals(str2, charSequenceX)) {
                Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
                return str2;
            }
        }
        return charSequenceX;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.ListPreference.SavedState.1
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
        String f50798a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f50798a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f50798a);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50957b, android.R.attr.dialogPreferenceStyle));
    }
}
