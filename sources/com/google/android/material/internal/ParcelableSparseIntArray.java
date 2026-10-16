package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new Parcelable.Creator<ParcelableSparseIntArray>() { // from class: com.google.android.material.internal.ParcelableSparseIntArray.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int i3 = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i3);
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i4 = 0; i4 < i3; i4++) {
                parcelableSparseIntArray.put(iArr[i4], iArr2[i4]);
            }
            return parcelableSparseIntArray;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseIntArray[] newArray(int i3) {
            return new ParcelableSparseIntArray[i3];
        }
    };

    public ParcelableSparseIntArray(int i3) {
        super(i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i4 = 0; i4 < size(); i4++) {
            iArr[i4] = keyAt(i4);
            iArr2[i4] = valueAt(i4);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
