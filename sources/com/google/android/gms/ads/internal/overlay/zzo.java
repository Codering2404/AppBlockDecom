package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzo implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        long J = 0;
        boolean zX = false;
        int iG = 0;
        int iG2 = 0;
        boolean zX2 = false;
        zzc zzcVar = null;
        IBinder iBinderF = null;
        IBinder iBinderF2 = null;
        IBinder iBinderF3 = null;
        IBinder iBinderF4 = null;
        String strQ = null;
        String strQ2 = null;
        IBinder iBinderF5 = null;
        String strQ3 = null;
        VersionInfoParcel versionInfoParcel = null;
        String strQ4 = null;
        com.google.android.gms.ads.internal.zzl zzlVar = null;
        IBinder iBinderF6 = null;
        String strQ5 = null;
        String strQ6 = null;
        String strQ7 = null;
        IBinder iBinderF7 = null;
        IBinder iBinderF8 = null;
        IBinder iBinderF9 = null;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 2:
                    zzcVar = (zzc) SafeParcelReader.p(parcel, iE, zzc.CREATOR);
                    break;
                case 3:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 4:
                    iBinderF2 = SafeParcelReader.F(parcel, iE);
                    break;
                case 5:
                    iBinderF3 = SafeParcelReader.F(parcel, iE);
                    break;
                case 6:
                    iBinderF4 = SafeParcelReader.F(parcel, iE);
                    break;
                case 7:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 9:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 10:
                    iBinderF5 = SafeParcelReader.F(parcel, iE);
                    break;
                case 11:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 12:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 13:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) SafeParcelReader.p(parcel, iE, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                case 20:
                case 21:
                case 22:
                case 23:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 16:
                    strQ4 = SafeParcelReader.q(parcel, iE);
                    break;
                case 17:
                    zzlVar = (com.google.android.gms.ads.internal.zzl) SafeParcelReader.p(parcel, iE, com.google.android.gms.ads.internal.zzl.CREATOR);
                    break;
                case 18:
                    iBinderF6 = SafeParcelReader.F(parcel, iE);
                    break;
                case 19:
                    strQ5 = SafeParcelReader.q(parcel, iE);
                    break;
                case 24:
                    strQ6 = SafeParcelReader.q(parcel, iE);
                    break;
                case 25:
                    strQ7 = SafeParcelReader.q(parcel, iE);
                    break;
                case 26:
                    iBinderF7 = SafeParcelReader.F(parcel, iE);
                    break;
                case 27:
                    iBinderF8 = SafeParcelReader.F(parcel, iE);
                    break;
                case 28:
                    iBinderF9 = SafeParcelReader.F(parcel, iE);
                    break;
                case 29:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 30:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new AdOverlayInfoParcel(zzcVar, iBinderF, iBinderF2, iBinderF3, iBinderF4, strQ, zX, strQ2, iBinderF5, iG, iG2, strQ3, versionInfoParcel, strQ4, zzlVar, iBinderF6, strQ5, strQ6, strQ7, iBinderF7, iBinderF8, iBinderF9, zX2, J);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new AdOverlayInfoParcel[i3];
    }
}
