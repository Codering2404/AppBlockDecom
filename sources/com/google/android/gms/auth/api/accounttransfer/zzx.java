package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzx implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        HashSet hashSet = new HashSet();
        int iG = 0;
        String strQ = null;
        byte[] bArrG = null;
        PendingIntent pendingIntent = null;
        DeviceMetaData deviceMetaData = null;
        int iG2 = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    hashSet.add(1);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    hashSet.add(2);
                    break;
                case 3:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    hashSet.add(3);
                    break;
                case 4:
                    bArrG = SafeParcelReader.g(parcel, iE);
                    hashSet.add(4);
                    break;
                case 5:
                    pendingIntent = (PendingIntent) SafeParcelReader.p(parcel, iE, PendingIntent.CREATOR);
                    hashSet.add(5);
                    break;
                case 6:
                    deviceMetaData = (DeviceMetaData) SafeParcelReader.p(parcel, iE, DeviceMetaData.CREATOR);
                    hashSet.add(6);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        if (parcel.dataPosition() == iO) {
            return new zzw(hashSet, iG, strQ, iG2, bArrG, pendingIntent, deviceMetaData);
        }
        throw new SafeParcelReader.ParseException("Overread allowed size end=" + iO, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzw[i3];
    }
}
