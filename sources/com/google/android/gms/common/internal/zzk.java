package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzk implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Bundle bundleF = null;
        ConnectionTelemetryConfiguration connectionTelemetryConfiguration = null;
        int iG = 0;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            int iW = SafeParcelReader.w(iE);
            if (iW == 1) {
                bundleF = SafeParcelReader.f(parcel, iE);
            } else if (iW == 2) {
                featureArr = (Feature[]) SafeParcelReader.t(parcel, iE, Feature.CREATOR);
            } else if (iW == 3) {
                iG = SafeParcelReader.G(parcel, iE);
            } else if (iW != 4) {
                SafeParcelReader.N(parcel, iE);
            } else {
                connectionTelemetryConfiguration = (ConnectionTelemetryConfiguration) SafeParcelReader.p(parcel, iE, ConnectionTelemetryConfiguration.CREATOR);
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzj(bundleF, featureArr, iG, connectionTelemetryConfiguration);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzj[i3];
    }
}
