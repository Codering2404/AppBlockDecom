package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Integer numH = null;
        Double dB = null;
        Uri uri = null;
        ArrayList arrayListU = null;
        ArrayList arrayListU2 = null;
        ChannelIdValue channelIdValue = null;
        String strQ = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    numH = SafeParcelReader.H(parcel, iE);
                    break;
                case 3:
                    dB = SafeParcelReader.B(parcel, iE);
                    break;
                case 4:
                    uri = (Uri) SafeParcelReader.p(parcel, iE, Uri.CREATOR);
                    break;
                case 5:
                    arrayListU = SafeParcelReader.u(parcel, iE, RegisterRequest.CREATOR);
                    break;
                case 6:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, RegisteredKey.CREATOR);
                    break;
                case 7:
                    channelIdValue = (ChannelIdValue) SafeParcelReader.p(parcel, iE, ChannelIdValue.CREATOR);
                    break;
                case 8:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new RegisterRequestParams(numH, dB, uri, arrayListU, arrayListU2, channelIdValue, strQ);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new RegisterRequestParams[i3];
    }
}
