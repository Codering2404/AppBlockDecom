package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public enum AutocompleteActivityMode implements Parcelable {
    FULLSCREEN,
    OVERLAY;

    public static final Parcelable.Creator<AutocompleteActivityMode> CREATOR = new Parcelable.Creator() { // from class: com.google.android.libraries.places.widget.model.zzb
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return AutocompleteActivityMode.valueOf((String) Preconditions.t(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new AutocompleteActivityMode[i3];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(name());
    }
}
