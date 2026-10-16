package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        boolean zX = false;
        boolean zX2 = false;
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        float fC5 = 0.0f;
        float fC6 = 0.0f;
        float fC7 = 0.0f;
        IBinder iBinderF = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 3:
                    latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
                    break;
                case 4:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 5:
                    fC2 = SafeParcelReader.C(parcel, iE);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.p(parcel, iE, LatLngBounds.CREATOR);
                    break;
                case 7:
                    fC3 = SafeParcelReader.C(parcel, iE);
                    break;
                case 8:
                    fC4 = SafeParcelReader.C(parcel, iE);
                    break;
                case 9:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    fC5 = SafeParcelReader.C(parcel, iE);
                    break;
                case 11:
                    fC6 = SafeParcelReader.C(parcel, iE);
                    break;
                case 12:
                    fC7 = SafeParcelReader.C(parcel, iE);
                    break;
                case 13:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GroundOverlayOptions(iBinderF, latLng, fC, fC2, latLngBounds, fC3, fC4, zX, fC5, fC6, fC7, zX2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GroundOverlayOptions[i3];
    }
}
