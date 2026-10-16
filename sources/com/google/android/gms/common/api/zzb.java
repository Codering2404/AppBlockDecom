package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator {
    public static final ApiMetadata a(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        ComplianceOptions complianceOptions = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                complianceOptions = (ComplianceOptions) SafeParcelReader.p(parcel, iE, ComplianceOptions.CREATOR);
            } else if (iW != 2) {
                SafeParcelReader.N(parcel, iE);
            } else {
                zX = SafeParcelReader.x(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ApiMetadata(complianceOptions, zX);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ApiMetadata[i3];
    }
}
