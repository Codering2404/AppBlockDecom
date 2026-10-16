package com.google.android.libraries.places.widget.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        return new AutocompleteUiCustomization(parcel.readInt() == 0 ? null : AutocompleteListDensity.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : AutocompleteUiIcon.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null, null);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AutocompleteUiCustomization[i3];
    }
}
