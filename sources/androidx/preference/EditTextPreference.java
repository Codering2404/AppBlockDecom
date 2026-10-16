package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.core.content.res.TypedArrayUtils;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class EditTextPreference extends DialogPreference {
    private String W;
    private OnBindEditTextListener X;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnBindEditTextListener {
        void a(EditText editText);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class SimpleSummaryProvider implements Preference.SummaryProvider<EditTextPreference> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static SimpleSummaryProvider f50789a;

        private SimpleSummaryProvider() {
        }

        public static SimpleSummaryProvider b() {
            if (f50789a == null) {
                f50789a = new SimpleSummaryProvider();
            }
            return f50789a;
        }

        @Override // androidx.preference.Preference.SummaryProvider
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CharSequence a(EditTextPreference editTextPreference) {
            return TextUtils.isEmpty(editTextPreference.L0()) ? editTextPreference.h().getString(R.string.f50989c) : editTextPreference.L0();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f51051w, i3, i4);
        int i5 = R.styleable.f51053x;
        if (TypedArrayUtils.b(typedArrayObtainStyledAttributes, i5, i5, false)) {
            t0(SimpleSummaryProvider.b());
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    OnBindEditTextListener K0() {
        return this.X;
    }

    public String L0() {
        return this.W;
    }

    public void M0(String str) {
        boolean zX0 = x0();
        this.W = str;
        e0(str);
        boolean zX02 = x0();
        if (zX02 != zX0) {
            I(zX02);
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
        M0(savedState.f50788a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        Parcelable parcelableZ = super.Z();
        if (E()) {
            return parcelableZ;
        }
        SavedState savedState = new SavedState(parcelableZ);
        savedState.f50788a = L0();
        return savedState;
    }

    @Override // androidx.preference.Preference
    public boolean x0() {
        return TextUtils.isEmpty(this.W) || super.x0();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.EditTextPreference.SavedState.1
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
        String f50788a;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f50788a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeString(this.f50788a);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, TypedArrayUtils.a(context, R.attr.f50959d, android.R.attr.editTextPreferenceStyle));
    }
}
