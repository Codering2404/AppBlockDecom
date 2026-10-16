package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        FidoAppIdExtension fidoAppIdExtension = null;
        zzs zzsVar = null;
        UserVerificationMethodExtension userVerificationMethodExtension = null;
        zzz zzzVar = null;
        zzab zzabVar = null;
        zzad zzadVar = null;
        zzu zzuVar = null;
        zzag zzagVar = null;
        GoogleThirdPartyPaymentExtension googleThirdPartyPaymentExtension = null;
        zzak zzakVar = null;
        zzaw zzawVar = null;
        zzai zzaiVar = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    fidoAppIdExtension = (FidoAppIdExtension) SafeParcelReader.p(parcel, iE, FidoAppIdExtension.CREATOR);
                    break;
                case 3:
                    zzsVar = (zzs) SafeParcelReader.p(parcel, iE, zzs.CREATOR);
                    break;
                case 4:
                    userVerificationMethodExtension = (UserVerificationMethodExtension) SafeParcelReader.p(parcel, iE, UserVerificationMethodExtension.CREATOR);
                    break;
                case 5:
                    zzzVar = (zzz) SafeParcelReader.p(parcel, iE, zzz.CREATOR);
                    break;
                case 6:
                    zzabVar = (zzab) SafeParcelReader.p(parcel, iE, zzab.CREATOR);
                    break;
                case 7:
                    zzadVar = (zzad) SafeParcelReader.p(parcel, iE, zzad.CREATOR);
                    break;
                case 8:
                    zzuVar = (zzu) SafeParcelReader.p(parcel, iE, zzu.CREATOR);
                    break;
                case 9:
                    zzagVar = (zzag) SafeParcelReader.p(parcel, iE, zzag.CREATOR);
                    break;
                case 10:
                    googleThirdPartyPaymentExtension = (GoogleThirdPartyPaymentExtension) SafeParcelReader.p(parcel, iE, GoogleThirdPartyPaymentExtension.CREATOR);
                    break;
                case 11:
                    zzakVar = (zzak) SafeParcelReader.p(parcel, iE, zzak.CREATOR);
                    break;
                case 12:
                    zzawVar = (zzaw) SafeParcelReader.p(parcel, iE, zzaw.CREATOR);
                    break;
                case 13:
                    zzaiVar = (zzai) SafeParcelReader.p(parcel, iE, zzai.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AuthenticationExtensions(fidoAppIdExtension, zzsVar, userVerificationMethodExtension, zzzVar, zzabVar, zzadVar, zzuVar, zzagVar, googleThirdPartyPaymentExtension, zzakVar, zzawVar, zzaiVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AuthenticationExtensions[i3];
    }
}
