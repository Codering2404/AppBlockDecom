package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzeq extends zzbf {
    public static final Parcelable.Creator<zzeq> CREATOR = new zzep();

    zzeq(String str, String str2, String str3, AddressComponents addressComponents, List list, Place.BusinessStatus businessStatus, ConsumerAlert consumerAlert, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue, OpeningHours openingHours, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3, String str4, String str5, Integer num, String str6, String str7, LatLng latLng, String str8, String str9, String str10, OpeningHours openingHours2, String str11, String str12, List list2, List list3, List list4, PlusCode plusCode, Integer num2, zzgf zzgfVar, String str13, String str14, String str15, Double d3, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4, List list5, List list6, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue5, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue6, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue7, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue8, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue9, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue10, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue11, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue12, Integer num3, Integer num4, LatLngBounds latLngBounds, Uri uri, Uri uri2, AccessibilityOptions accessibilityOptions, ParkingOptions parkingOptions, PaymentOptions paymentOptions, EVChargeOptions eVChargeOptions, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue13, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue14, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue15, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue16, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue17, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue18, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue19, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue20, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue21, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue22, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue23, List list7, FuelOptions fuelOptions, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue24, GenerativeSummary generativeSummary, EvChargeAmenitySummary evChargeAmenitySummary, NeighborhoodSummary neighborhoodSummary, ReviewSummary reviewSummary, GoogleMapsLinks googleMapsLinks) {
        super(str, str2, str3, addressComponents, list, businessStatus, consumerAlert, booleanPlaceAttributeValue, openingHours, booleanPlaceAttributeValue2, booleanPlaceAttributeValue3, str4, str5, num, str6, str7, latLng, str8, str9, str10, openingHours2, str11, str12, list2, list3, list4, plusCode, num2, zzgfVar, str13, str14, str15, d3, booleanPlaceAttributeValue4, list5, list6, booleanPlaceAttributeValue5, booleanPlaceAttributeValue6, booleanPlaceAttributeValue7, booleanPlaceAttributeValue8, booleanPlaceAttributeValue9, booleanPlaceAttributeValue10, booleanPlaceAttributeValue11, booleanPlaceAttributeValue12, num3, num4, latLngBounds, uri, uri2, accessibilityOptions, parkingOptions, paymentOptions, eVChargeOptions, booleanPlaceAttributeValue13, booleanPlaceAttributeValue14, booleanPlaceAttributeValue15, booleanPlaceAttributeValue16, booleanPlaceAttributeValue17, booleanPlaceAttributeValue18, booleanPlaceAttributeValue19, booleanPlaceAttributeValue20, booleanPlaceAttributeValue21, booleanPlaceAttributeValue22, booleanPlaceAttributeValue23, list7, fuelOptions, booleanPlaceAttributeValue24, generativeSummary, evChargeAmenitySummary, neighborhoodSummary, reviewSummary, googleMapsLinks);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        if (v() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(v());
        }
        if (r0() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(r0());
        }
        if (f() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(f());
        }
        parcel.writeParcelable(e(), i3);
        parcel.writeList(h());
        parcel.writeParcelable(i(), i3);
        parcel.writeParcelable(j(), i3);
        parcel.writeParcelable(k(), i3);
        parcel.writeParcelable(l(), i3);
        parcel.writeParcelable(n(), i3);
        parcel.writeParcelable(o(), i3);
        if (r() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(r());
        }
        if (s() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(s());
        }
        if (E() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(E().intValue());
        }
        if (F() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(F());
        }
        if (G() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(G());
        }
        parcel.writeParcelable(J(), i3);
        if (p() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(p());
        }
        if (q() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(q());
        }
        if (c0() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(c0());
        }
        parcel.writeParcelable(N(), i3);
        if (H() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(H());
        }
        if (L() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(L());
        }
        parcel.writeList(R());
        parcel.writeList(f0());
        parcel.writeList(S());
        parcel.writeParcelable(T(), i3);
        if (U() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(U().intValue());
        }
        parcel.writeParcelable(y0(), i3);
        if (W() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(W());
        }
        if (X() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(X());
        }
        if (Y() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(Y());
        }
        if (a0() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeDouble(a0().doubleValue());
        }
        parcel.writeParcelable(b0(), i3);
        parcel.writeList(g0());
        parcel.writeList(m());
        parcel.writeParcelable(h0(), i3);
        parcel.writeParcelable(i0(), i3);
        parcel.writeParcelable(j0(), i3);
        parcel.writeParcelable(n0(), i3);
        parcel.writeParcelable(o0(), i3);
        parcel.writeParcelable(p0(), i3);
        parcel.writeParcelable(q0(), i3);
        parcel.writeParcelable(t0(), i3);
        if (u0() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(u0().intValue());
        }
        if (v0() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeInt(v0().intValue());
        }
        parcel.writeParcelable(w0(), i3);
        parcel.writeParcelable(x0(), i3);
        parcel.writeParcelable(D(), i3);
        parcel.writeParcelable(d(), i3);
        parcel.writeParcelable(P(), i3);
        parcel.writeParcelable(Q(), i3);
        parcel.writeParcelable(u(), i3);
        parcel.writeParcelable(O(), i3);
        parcel.writeParcelable(I(), i3);
        parcel.writeParcelable(K(), i3);
        parcel.writeParcelable(k0(), i3);
        parcel.writeParcelable(m0(), i3);
        parcel.writeParcelable(l0(), i3);
        parcel.writeParcelable(y(), i3);
        parcel.writeParcelable(g(), i3);
        parcel.writeParcelable(d0(), i3);
        parcel.writeParcelable(A(), i3);
        parcel.writeParcelable(B(), i3);
        parcel.writeList(s0());
        parcel.writeParcelable(w(), i3);
        parcel.writeParcelable(Z(), i3);
        parcel.writeParcelable(x(), i3);
        parcel.writeParcelable(t(), i3);
        parcel.writeParcelable(M(), i3);
        parcel.writeParcelable(e0(), i3);
        parcel.writeParcelable(C(), i3);
    }
}
