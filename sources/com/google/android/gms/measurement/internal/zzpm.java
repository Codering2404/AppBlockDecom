package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpm implements Parcelable.Creator {
    static void a(zzpl zzplVar, Parcel parcel, int i3) {
        int i4 = zzplVar.f74477a;
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, i4);
        SafeParcelWriter.G(parcel, 2, zzplVar.f74478b, false);
        SafeParcelWriter.z(parcel, 3, zzplVar.f74479c);
        SafeParcelWriter.B(parcel, 4, zzplVar.f74480d, false);
        SafeParcelWriter.s(parcel, 5, null, false);
        SafeParcelWriter.G(parcel, 6, zzplVar.f74481f, false);
        SafeParcelWriter.G(parcel, 7, zzplVar.f74482g, false);
        SafeParcelWriter.p(parcel, 8, zzplVar.f74483h, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iO = SafeParcelReader.O(parcel);
        String strQ = null;
        Long lK = null;
        Float fD = null;
        String strQ2 = null;
        String strQ3 = null;
        Double dB = null;
        long J = 0;
        int iG = 0;
        while (parcel.dataPosition() < iO) {
            int iE = SafeParcelReader.E(parcel);
            switch (SafeParcelReader.w(iE)) {
                case 1:
                    iG = SafeParcelReader.G(parcel, iE);
                    break;
                case 2:
                    strQ = SafeParcelReader.q(parcel, iE);
                    break;
                case 3:
                    J = SafeParcelReader.J(parcel, iE);
                    break;
                case 4:
                    lK = SafeParcelReader.K(parcel, iE);
                    break;
                case 5:
                    fD = SafeParcelReader.D(parcel, iE);
                    break;
                case 6:
                    strQ2 = SafeParcelReader.q(parcel, iE);
                    break;
                case 7:
                    strQ3 = SafeParcelReader.q(parcel, iE);
                    break;
                case 8:
                    dB = SafeParcelReader.B(parcel, iE);
                    break;
                default:
                    SafeParcelReader.N(parcel, iE);
                    break;
            }
        }
        SafeParcelReader.v(parcel, iO);
        return new zzpl(iG, strQ, J, lK, fD, strQ2, strQ3, dB);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i3) {
        return new zzpl[i3];
    }
}
