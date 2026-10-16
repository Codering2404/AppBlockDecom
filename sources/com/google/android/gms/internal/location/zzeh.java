package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = Long.MAX_VALUE;
        LocationRequest locationRequest = null;
        ArrayList arrayListU = null;
        String strQ = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        boolean zX4 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                locationRequest = (LocationRequest) SafeParcelReader.p(parcel, iE, LocationRequest.CREATOR);
            } else if (iW == 5) {
                arrayListU = SafeParcelReader.u(parcel, iE, ClientIdentity.CREATOR);
            } else if (iW == 8) {
                zX = SafeParcelReader.x(parcel, iE);
            } else if (iW != 9) {
                switch (iW) {
                    case 11:
                        zX3 = SafeParcelReader.x(parcel, iE);
                        break;
                    case 12:
                        zX4 = SafeParcelReader.x(parcel, iE);
                        break;
                    case 13:
                        strQ = SafeParcelReader.q(parcel, iE);
                        break;
                    case 14:
                        J = SafeParcelReader.J(parcel, iE);
                        break;
                    default:
                        SafeParcelReader.N(parcel, iE);
                        break;
                }
            } else {
                zX2 = SafeParcelReader.x(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzeg(locationRequest, arrayListU, zX, zX2, zX3, zX4, strQ, J);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzeg[i3];
    }
}
