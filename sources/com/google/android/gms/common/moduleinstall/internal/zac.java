package com.google.android.gms.common.moduleinstall.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zac implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        ArrayList arrayListU = null;
        String strQ = null;
        boolean zX = false;
        String strQ2 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                arrayListU = SafeParcelReader.u(parcel, iE, Feature.CREATOR);
            } else if (iW == 2) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW == 3) {
                strQ2 = SafeParcelReader.q(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ApiFeatureRequest(arrayListU, zX, strQ2, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ApiFeatureRequest[i3];
    }
}
