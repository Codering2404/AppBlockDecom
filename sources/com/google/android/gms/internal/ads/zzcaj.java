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
public final class zzcaj implements Parcelable.Creator {
    public static final zzcai zza(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        com.google.android.gms.ads.internal.client.zzm zzmVar = null;
        com.google.android.gms.ads.internal.client.zzr zzrVar = null;
        String strQ = null;
        ApplicationInfo applicationInfo = null;
        PackageInfo packageInfo = null;
        String strQ2 = null;
        String strQ3 = null;
        String strQ4 = null;
        VersionInfoParcel versionInfoParcel = null;
        Bundle bundleF2 = null;
        ArrayList arrayListS = null;
        Bundle bundleF3 = null;
        String strQ5 = null;
        String strQ6 = null;
        ArrayList arrayListS2 = null;
        String strQ7 = null;
        zzblt zzbltVar = null;
        ArrayList arrayListS3 = null;
        String strQ8 = null;
        String strQ9 = null;
        String strQ10 = null;
        Bundle bundleF4 = null;
        String strQ11 = null;
        com.google.android.gms.ads.internal.client.zzee zzeeVar = null;
        Bundle bundleF5 = null;
        String strQ12 = null;
        String strQ13 = null;
        String strQ14 = null;
        ArrayList arrayListL = null;
        String strQ15 = null;
        ArrayList arrayListS4 = null;
        ArrayList arrayListS5 = null;
        String strQ16 = null;
        zzbsb zzbsbVar = null;
        String strQ17 = null;
        Bundle bundleF6 = null;
        int iG = 0;
        int iG2 = 0;
        boolean zX = false;
        int iG3 = 0;
        int iG4 = 0;
        boolean zX2 = false;
        int iG5 = 0;
        int iG6 = 0;
        boolean zX3 = false;
        boolean zX4 = false;
        int iG7 = 0;
        boolean zX5 = false;
        boolean zX6 = false;
        int iG8 = 0;
        boolean zX7 = false;
        boolean zX8 = false;
        boolean zX9 = false;
        float fC = 0.0f;
        float fC2 = 0.0f;
        long J = 0;
        long J2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    bundleF = SafeParcelReader.f(parcel, iE);
                    break;
                case 3:
                    zzmVar = (com.google.android.gms.ads.internal.client.zzm) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzm.CREATOR);
                    break;
                case 4:
                    zzrVar = (com.google.android.gms.ads.internal.client.zzr) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzr.CREATOR);
                    break;
                case 5:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 6:
                    applicationInfo = (ApplicationInfo) SafeParcelReader.p(parcel, iE, ApplicationInfo.CREATOR);
                    break;
                case 7:
                    packageInfo = (PackageInfo) SafeParcelReader.p(parcel, iE, PackageInfo.CREATOR);
                    break;
                case 8:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 9:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 11:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.p(parcel, iE, VersionInfoParcel.CREATOR);
                    break;
                case 12:
                    bundleF2 = SafeParcelReader.f(parcel, iE);
                    break;
                case 13:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 14:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 15:
                    bundleF3 = SafeParcelReader.f(parcel, iE);
                    break;
                case 16:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 17:
                case 22:
                case 23:
                case 24:
                case 32:
                case 38:
                case 62:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 18:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 19:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 20:
                    fC = SafeParcelReader.C(parcel, iE);
                    break;
                case 21:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 25:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 26:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 27:
                    arrayListS2 = SafeParcelReader.s(parcel, iE);
                    break;
                case 28:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 29:
                    zzbltVar = (zzblt) SafeParcelReader.p(parcel, iE, zzblt.CREATOR);
                    break;
                case 30:
                    arrayListS3 = SafeParcelReader.s(parcel, iE);
                    break;
                case 31:
                    J2 = SafeParcelReader.J(parcel, iE);
                    break;
                case 33:
                    strQ8 = SafeParcelReader.q(parcel, iE);
                    break;
                case 34:
                    fC2 = SafeParcelReader.C(parcel, iE);
                    break;
                case 35:
                    iG5 = SafeParcelReader.G(parcel, iE);
                    break;
                case 36:
                    iG6 = SafeParcelReader.G(parcel, iE);
                    break;
                case 37:
                    zX3 = SafeParcelReader.x(parcel, iE);
                    break;
                case 39:
                    strQ9 = SafeParcelReader.q(parcel, iE);
                    break;
                case 40:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 41:
                    strQ10 = SafeParcelReader.q(parcel, iE);
                    break;
                case 42:
                    zX4 = SafeParcelReader.x(parcel, iE);
                    break;
                case 43:
                    iG7 = SafeParcelReader.G(parcel, iE);
                    break;
                case 44:
                    bundleF4 = SafeParcelReader.f(parcel, iE);
                    break;
                case 45:
                    strQ11 = SafeParcelReader.q(parcel, iE);
                    break;
                case 46:
                    zzeeVar = (com.google.android.gms.ads.internal.client.zzee) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.client.zzee.CREATOR);
                    break;
                case 47:
                    zX5 = SafeParcelReader.x(parcel, iE);
                    break;
                case 48:
                    bundleF5 = SafeParcelReader.f(parcel, iE);
                    break;
                case 49:
                    strQ12 = SafeParcelReader.q(parcel, iE);
                    break;
                case 50:
                    strQ13 = SafeParcelReader.q(parcel, iE);
                    break;
                case 51:
                    strQ14 = SafeParcelReader.q(parcel, iE);
                    break;
                case 52:
                    zX6 = SafeParcelReader.x(parcel, iE);
                    break;
                case 53:
                    arrayListL = SafeParcelReader.l(parcel, iE);
                    break;
                case 54:
                    strQ15 = SafeParcelReader.q(parcel, iE);
                    break;
                case 55:
                    arrayListS4 = SafeParcelReader.s(parcel, iE);
                    break;
                case 56:
                    iG8 = SafeParcelReader.G(parcel, iE);
                    break;
                case 57:
                    zX7 = SafeParcelReader.x(parcel, iE);
                    break;
                case 58:
                    zX8 = SafeParcelReader.x(parcel, iE);
                    break;
                case 59:
                    zX9 = SafeParcelReader.x(parcel, iE);
                    break;
                case 60:
                    arrayListS5 = SafeParcelReader.s(parcel, iE);
                    break;
                case 61:
                    strQ16 = SafeParcelReader.q(parcel, iE);
                    break;
                case 63:
                    zzbsbVar = (zzbsb) SafeParcelReader.p(parcel, iE, zzbsb.CREATOR);
                    break;
                case 64:
                    strQ17 = SafeParcelReader.q(parcel, iE);
                    break;
                case 65:
                    bundleF6 = SafeParcelReader.f(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzcai(iG, bundleF, zzmVar, zzrVar, strQ, applicationInfo, packageInfo, strQ2, strQ3, strQ4, versionInfoParcel, bundleF2, iG2, arrayListS, bundleF3, zX, iG3, iG4, fC, strQ5, J, strQ6, arrayListS2, strQ7, zzbltVar, arrayListS3, J2, strQ8, fC2, zX2, iG5, iG6, zX3, strQ9, strQ10, zX4, iG7, bundleF4, strQ11, zzeeVar, zX5, bundleF5, strQ12, strQ13, strQ14, zX6, arrayListL, strQ15, arrayListS4, iG8, zX7, zX8, zX9, arrayListS5, strQ16, zzbsbVar, strQ17, bundleF6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zza(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzcai[i3];
    }
}
