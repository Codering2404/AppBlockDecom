package com.google.android.libraries.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzoj implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int i3;
        boolean z2;
        int i4;
        boolean z3;
        int i5;
        boolean z4;
        boolean z5;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        int i6 = parcel.readInt();
        int i7 = parcel.readInt();
        int i8 = parcel.readInt();
        int i9 = parcel.readInt();
        int i10 = parcel.readInt();
        boolean z6 = false;
        if (i6 != 0) {
            i3 = i7;
            z2 = true;
        } else {
            i3 = i7;
            z2 = false;
        }
        if (i3 != 0) {
            i4 = i8;
            z3 = true;
        } else {
            i4 = i8;
            z3 = false;
        }
        if (i4 != 0) {
            i5 = i9;
            z4 = true;
        } else {
            i5 = i9;
            z4 = false;
        }
        if (i5 != 0) {
            z5 = false;
            z6 = true;
        } else {
            z5 = false;
        }
        return new zzok(z2, z3, z4, z6, i10 == 0 ? z5 : true);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzok[i3];
    }
}
