package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new Parcelable.Creator<ParcelableSparseBooleanArray>() { // from class: com.google.android.material.internal.ParcelableSparseBooleanArray.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int i3 = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i3);
            int[] iArr = new int[i3];
            boolean[] zArr = new boolean[i3];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i4 = 0; i4 < i3; i4++) {
                parcelableSparseBooleanArray.put(iArr[i4], zArr[i4]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ParcelableSparseBooleanArray[] newArray(int i3) {
            return new ParcelableSparseBooleanArray[i3];
        }
    };

    public ParcelableSparseBooleanArray(int i3) {
        super(i3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i4 = 0; i4 < size(); i4++) {
            iArr[i4] = keyAt(i4);
            zArr[i4] = valueAt(i4);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
