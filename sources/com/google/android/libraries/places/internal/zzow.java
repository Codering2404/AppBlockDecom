package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzow implements Parcelable {
    PABLO,
    ONE_PLATFORM,
    JWT_AND_ONE_PLATFORM;

    public static final Parcelable.Creator<zzow> CREATOR = new Parcelable.Creator() { // from class: com.google.android.libraries.places.internal.zzov
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return (zzow) Enum.valueOf(zzow.class, (String) Preconditions.t(parcel.readString()));
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Object[] newArray(int i3) {
            return new zzow[i3];
        }
    };

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(name());
    }
}
