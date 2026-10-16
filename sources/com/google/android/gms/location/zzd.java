package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        Bundle bundleF = null;
        int iG = 0;
        long J = 0;
        long J2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                arrayListU = SafeParcelReader.u(parcel, iE, DetectedActivity.CREATOR);
            } else if (iW == 2) {
                J = SafeParcelReader.J(parcel, iE);
            } else if (iW == 3) {
                J2 = SafeParcelReader.J(parcel, iE);
            } else if (iW == 4) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                bundleF = SafeParcelReader.f(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ActivityRecognitionResult(arrayListU, J, J2, iG, bundleF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ActivityRecognitionResult[i3];
    }
}
