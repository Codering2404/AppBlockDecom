package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        float fC = 0.0f;
        float fC2 = 0.0f;
        float fC3 = 0.0f;
        float fC4 = 0.0f;
        float fC5 = 0.0f;
        float fC6 = 0.0f;
        LatLng latLng = null;
        String strQ = null;
        String strQ2 = null;
        IBinder iBinderF = null;
        IBinder iBinderF2 = null;
        String strQ3 = null;
        boolean zX = false;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG = 0;
        int iG2 = 0;
        float fC7 = 1.0f;
        float fC8 = 0.5f;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    latLng = (LatLng) SafeParcelReader.p(parcel, iE, LatLng.CREATOR);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 6:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 7:
                    fC2 = SafeParcelReader.C(parcel, iE);
                    break;
                case 8:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 10:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    fC3 = SafeParcelReader.C(parcel, iE);
                    break;
                case 12:
                    fC8 = SafeParcelReader.C(parcel, iE);
                    break;
                case 13:
                    fC4 = SafeParcelReader.C(parcel, iE);
                    break;
                case 14:
                    fC7 = SafeParcelReader.C(parcel, iE);
                    break;
                case 15:
                    fC5 = SafeParcelReader.C(parcel, iE);
                    break;
                case 16:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 17:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 18:
                    iBinderF2 = SafeParcelReader.F(parcel, iE);
                    break;
                case 19:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 20:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 21:
                    fC6 = SafeParcelReader.C(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new MarkerOptions(latLng, strQ, strQ2, iBinderF, fC, fC2, zX, zX2, zX3, fC3, fC8, fC4, fC7, fC5, iG, iBinderF2, iG2, strQ3, fC6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new MarkerOptions[i3];
    }
}
