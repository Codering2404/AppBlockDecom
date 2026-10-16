package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzl implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        RootTelemetryConfiguration rootTelemetryConfiguration = null;
        int[] iArrK = null;
        int[] iArrK2 = null;
        boolean zX = false;
        boolean zX2 = false;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    rootTelemetryConfiguration = (RootTelemetryConfiguration) SafeParcelReader.p(parcel, iE, RootTelemetryConfiguration.CREATOR);
                    break;
                case 2:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 3:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 4:
                    iArrK = SafeParcelReader.k(parcel, iE);
                    break;
                case 5:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 6:
                    iArrK2 = SafeParcelReader.k(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new ConnectionTelemetryConfiguration(rootTelemetryConfiguration, zX, zX2, iArrK, iG, iArrK2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new ConnectionTelemetryConfiguration[i3];
    }
}
