package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzm implements Parcelable.Creator {
    static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i3) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, getServiceRequest.f71976a);
        SafeParcelWriter.u(parcel, 2, getServiceRequest.f71977b);
        SafeParcelWriter.u(parcel, 3, getServiceRequest.f71978c);
        SafeParcelWriter.G(parcel, 4, getServiceRequest.f71979d, false);
        SafeParcelWriter.t(parcel, 5, getServiceRequest.f71980f, false);
        SafeParcelWriter.J(parcel, 6, getServiceRequest.f71981g, i3, false);
        SafeParcelWriter.j(parcel, 7, getServiceRequest.f71982h, false);
        SafeParcelWriter.E(parcel, 8, getServiceRequest.f71983i, i3, false);
        SafeParcelWriter.J(parcel, 10, getServiceRequest.f71984j, i3, false);
        SafeParcelWriter.J(parcel, 11, getServiceRequest.f71985k, i3, false);
        SafeParcelWriter.g(parcel, 12, getServiceRequest.f71986l);
        SafeParcelWriter.u(parcel, 13, getServiceRequest.f71987m);
        SafeParcelWriter.g(parcel, 14, getServiceRequest.f71988n);
        SafeParcelWriter.G(parcel, 15, getServiceRequest.M(), false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        Scope[] scopeArr = GetServiceRequest.f71974p;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f71975q;
        Feature[] featureArr2 = featureArr;
        String strQ = null;
        IBinder iBinderF = null;
        Account account = null;
        String strQ2 = null;
        int iG = 0;
        int iG2 = 0;
        int iG3 = 0;
        boolean zX = false;
        int iG4 = 0;
        boolean zX2 = false;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    iG2 = SafeParcelReader.G(parcel, iE);
                    break;
                case 3:
                    iG3 = SafeParcelReader.G(parcel, iE);
                    break;
                case 4:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 5:
                    iBinderF = SafeParcelReader.F(parcel, iE);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.t(parcel, iE, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.f(parcel, iE);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.p(parcel, iE, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.t(parcel, iE, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.t(parcel, iE, Feature.CREATOR);
                    break;
                case 12:
                    zX = SafeParcelReader.x(parcel, iE);
                    break;
                case 13:
                    iG4 = SafeParcelReader.G(parcel, iE);
                    break;
                case 14:
                    zX2 = SafeParcelReader.x(parcel, iE);
                    break;
                case 15:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new GetServiceRequest(iG, iG2, iG3, strQ, iBinderF, scopeArr, bundle, account, featureArr, featureArr2, zX, iG4, zX2, strQ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new GetServiceRequest[i3];
    }
}
