package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzae implements Parcelable.Creator<zzaf> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        zzahv zzahvVar = null;
        zzab zzabVar = null;
        String strQ = null;
        String strQ2 = null;
        ArrayList arrayListU = null;
        ArrayList arrayListS = null;
        String strQ3 = null;
        Boolean boolY = null;
        zzah zzahVar = null;
        com.google.firebase.auth.zze zzeVar = null;
        zzbj zzbjVar = null;
        ArrayList arrayListU2 = null;
        boolean zX = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    zzahvVar = (zzahv) SafeParcelReader.p(parcel, iE, zzahv.CREATOR);
                    break;
                case 2:
                    zzabVar = (zzab) SafeParcelReader.p(parcel, iE, zzab.CREATOR);
                    break;
                case 3:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 4:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    arrayListU = SafeParcelReader.u(parcel, iE, zzab.CREATOR);
                    break;
                case 6:
                    arrayListS = SafeParcelReader.s(parcel, iE);
                    break;
                case 7:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    boolY = SafeParcelReader.y(parcel, iE);
                    break;
                case 9:
                    zzahVar = (zzah) SafeParcelReader.p(parcel, iE, zzah.CREATOR);
                    break;
                case 10:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 11:
                    zzeVar = (com.google.firebase.auth.zze) SafeParcelReader.p(parcel, iE, com.google.firebase.auth.zze.CREATOR);
                    break;
                case 12:
                    zzbjVar = (zzbj) SafeParcelReader.p(parcel, iE, zzbj.CREATOR);
                    break;
                case 13:
                    arrayListU2 = SafeParcelReader.u(parcel, iE, com.google.firebase.auth.zzan.CREATOR);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzaf(zzahvVar, zzabVar, strQ, strQ2, arrayListU, arrayListS, strQ3, boolY, zzahVar, zX, zzeVar, zzbjVar, arrayListU2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzaf[] newArray(int i3) {
        return new zzaf[i3];
    }
}
