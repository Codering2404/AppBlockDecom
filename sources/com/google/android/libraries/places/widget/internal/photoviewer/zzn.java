package com.google.android.libraries.places.widget.internal.photoviewer;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i3 = parcel.readInt();
        ArrayList arrayList = new ArrayList(i3);
        for (int i4 = 0; i4 != i3; i4++) {
            arrayList.add(zzd.CREATOR.createFromParcel(parcel));
        }
        return new zzo(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzo[i3];
    }
}
