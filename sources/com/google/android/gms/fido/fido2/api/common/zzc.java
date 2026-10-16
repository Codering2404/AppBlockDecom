package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        UvmEntries uvmEntries = null;
        zzf zzfVar = null;
        AuthenticationExtensionsCredPropsOutputs authenticationExtensionsCredPropsOutputs = null;
        zzh zzhVar = null;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                uvmEntries = (UvmEntries) SafeParcelReader.p(parcel, iE, UvmEntries.CREATOR);
            } else if (iW == 2) {
                zzfVar = (zzf) SafeParcelReader.p(parcel, iE, zzf.CREATOR);
            } else if (iW == 3) {
                authenticationExtensionsCredPropsOutputs = (AuthenticationExtensionsCredPropsOutputs) SafeParcelReader.p(parcel, iE, AuthenticationExtensionsCredPropsOutputs.CREATOR);
            } else if (iW == 4) {
                zzhVar = (zzh) SafeParcelReader.p(parcel, iE, zzh.CREATOR);
            } else if (iW != 5) {
                SafeParcelReader.N(parcel, iE);
            } else {
                strQ = SafeParcelReader.q(parcel, iE);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AuthenticationExtensionsClientOutputs(uvmEntries, zzfVar, authenticationExtensionsCredPropsOutputs, zzhVar, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AuthenticationExtensionsClientOutputs[i3];
    }
}
