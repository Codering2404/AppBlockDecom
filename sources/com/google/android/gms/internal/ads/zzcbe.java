package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcbe implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        VersionInfoParcel versionInfoParcel = null;
        ApplicationInfo applicationInfo = null;
        String strQ = null;
        ArrayList arrayListS = null;
        PackageInfo packageInfo = null;
        String strQ2 = null;
        String strQ3 = null;
        zzfmu zzfmuVar = null;
        String strQ4 = null;
        Bundle bundleF2 = null;
        boolean zX = false;
        boolean zX2 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 2:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.p(parcel, iE, VersionInfoParcel.CREATOR);
                    break;
                case 3:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.p(parcel, iE, ApplicationInfo.CREATOR);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 6:
                    packageInfo = (PackageInfo) SafeParcelReader.p(parcel, iE, PackageInfo.CREATOR);
                    break;
                case 7:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 9:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    zzfmuVar = (zzfmu) SafeParcelReader.p(parcel, iE, zzfmu.CREATOR);
                    break;
                case 11:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 12:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 13:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 14:
                    bundleF2 = SafeParcelReader.f(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzcbd(bundleF, versionInfoParcel, applicationInfo, strQ, arrayListS, packageInfo, strQ2, strQ3, zzfmuVar, strQ4, zX, zX2, bundleF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzcbd[i3];
    }
}
