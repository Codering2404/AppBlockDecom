package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = 0;
        long J2 = 0;
        long J3 = 0;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        int iG3 = 0;
        boolean zX2 = false;
        boolean zX3 = false;
        int iG4 = 0;
        int iG5 = 0;
        int iG6 = 0;
        Bundle bundleF = null;
        ArrayList arrayListS = null;
        String strQ = null;
        zzft zzftVar = null;
        Location location = null;
        String strQ2 = null;
        Bundle bundleF2 = null;
        Bundle bundleF3 = null;
        ArrayList arrayListS2 = null;
        String strQ3 = null;
        String strQ4 = null;
        zzc zzcVar = null;
        String strQ5 = null;
        ArrayList arrayListS3 = null;
        String strQ6 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 3:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 4:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 5:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 6:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 7:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 8:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    zzftVar = (zzft) SafeParcelReader.p(parcel, iE, zzft.CREATOR);
                    break;
                case 11:
                    location = (Location) SafeParcelReader.p(parcel, iE, Location.CREATOR);
                    break;
                case 12:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 13:
                    bundleF2 = SafeParcelReader.f(parcel, iE);
                    break;
                case 14:
                    bundleF3 = SafeParcelReader.f(parcel, iE);
                    break;
                case 15:
                    arrayListS2 = SafeParcelReader.s(parcel, iE);
                    break;
                case 16:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 17:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 18:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 19:
                    zzcVar = (zzc) SafeParcelReader.p(parcel, iE, zzc.CREATOR);
                    break;
                case 20:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 21:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 22:
                    arrayListS3 = SafeParcelReader.s(parcel, iE);
                    break;
                case 23:
                    iG5 = SafeParcelReader.G(parcel, iE);
                    break;
                case 24:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 25:
                    iG6 = SafeParcelReader.G(parcel, iE);
                    break;
                case 26:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 27:
                    J3 = SafeParcelReader.J(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzm(iG, J, bundleF, iG2, arrayListS, zX, iG3, zX2, strQ, zzftVar, location, strQ2, bundleF2, bundleF3, arrayListS2, strQ3, strQ4, zX3, zzcVar, iG4, strQ5, arrayListS3, iG5, strQ6, iG6, J2, J3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzm[i3];
    }
}
