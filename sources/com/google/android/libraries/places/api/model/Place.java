package com.google.android.libraries.places.api.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Range;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class Place implements Parcelable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum BooleanPlaceAttributeValue implements Parcelable {
        UNKNOWN,
        TRUE,
        FALSE;

        public static final Parcelable.Creator<BooleanPlaceAttributeValue> CREATOR = new zzgb();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract Builder A(Uri uri);

        public abstract Builder B(Integer num);

        public abstract Builder C(String str);

        public abstract Builder D(String str);

        public abstract Builder E(String str);

        public abstract Builder F(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder G(LatLng latLng);

        public abstract Builder H(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder I(String str);

        public abstract Builder J(NeighborhoodSummary neighborhoodSummary);

        public abstract Builder K(OpeningHours openingHours);

        public abstract Builder L(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder M(ParkingOptions parkingOptions);

        public abstract Builder N(PaymentOptions paymentOptions);

        public abstract Builder O(List list);

        public abstract Builder P(List list);

        public abstract Builder Q(PlusCode plusCode);

        public abstract Builder R(Integer num);

        public abstract Builder S(String str);

        public abstract Builder T(String str);

        public abstract Builder U(String str);

        public abstract Builder V(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder W(Double d3);

        public abstract Builder X(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder Y(String str);

        public abstract Builder Z(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public Place a() {
            Place placeV0 = v0();
            List listH = placeV0.h();
            if (listH != null) {
                Iterator it = listH.iterator();
                while (it.hasNext()) {
                    Preconditions.e(!TextUtils.isEmpty((String) it.next()), "Attributions must not contain null or empty values.");
                }
            }
            Integer numU = placeV0.U();
            if (numU != null) {
                Preconditions.p(Range.f(0, 4).i(numU), "Price Level must not be out-of-range: %s to %s, but was: %s.", 0, 4, numU);
            }
            Double dA0 = placeV0.a0();
            if (dA0 != null) {
                Double dValueOf = Double.valueOf(1.0d);
                Double dValueOf2 = Double.valueOf(5.0d);
                Preconditions.p(Range.f(dValueOf, dValueOf2).i(dA0), "Rating must not be out-of-range: %s to %s, but was: %s.", dValueOf, dValueOf2, dA0);
            }
            Integer numU0 = placeV0.u0();
            if (numU0 != null) {
                Preconditions.m(Range.c(0).i(numU0), "User Ratings Total must not be < 0, but was: %s.", numU0);
            }
            if (listH != null) {
                f(ImmutableList.t(listH));
            }
            List listR = placeV0.R();
            if (listR != null) {
                O(ImmutableList.t(listR));
            }
            List listS = placeV0.S();
            if (listS != null) {
                P(ImmutableList.t(listS));
            }
            List listG0 = placeV0.g0();
            if (listG0 != null) {
                c0(ImmutableList.t(listG0));
            }
            List listF0 = placeV0.f0();
            if (listF0 != null) {
                b0(ImmutableList.t(listF0));
            }
            return v0();
        }

        public abstract Builder a0(ReviewSummary reviewSummary);

        public abstract Builder b(AccessibilityOptions accessibilityOptions);

        public abstract Builder b0(List list);

        public abstract Builder c(AddressComponents addressComponents);

        public abstract Builder c0(List list);

        public abstract Builder d(String str);

        public abstract Builder d0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder e(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder e0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder f(List list);

        public abstract Builder f0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder g(BusinessStatus businessStatus);

        public abstract Builder g0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder h(ConsumerAlert consumerAlert);

        public abstract Builder h0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder i(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder i0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder j(OpeningHours openingHours);

        public abstract Builder j0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder k(List list);

        public abstract Builder k0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder l(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder l0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder m(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder m0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder n(String str);

        public abstract Builder n0(String str);

        public abstract Builder o(String str);

        public abstract Builder o0(List list);

        public abstract Builder p(String str);

        public abstract Builder p0(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder q(String str);

        public abstract Builder q0(Integer num);

        public abstract Builder r(EvChargeAmenitySummary evChargeAmenitySummary);

        public abstract Builder r0(Integer num);

        public abstract Builder s(EVChargeOptions eVChargeOptions);

        public abstract Builder s0(LatLngBounds latLngBounds);

        public abstract Builder t(String str);

        public abstract Builder t0(Uri uri);

        public abstract Builder u(FuelOptions fuelOptions);

        public abstract Builder u0(zzgf zzgfVar);

        public abstract Builder v(GenerativeSummary generativeSummary);

        abstract Place v0();

        public abstract Builder w(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder x(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder y(BooleanPlaceAttributeValue booleanPlaceAttributeValue);

        public abstract Builder z(GoogleMapsLinks googleMapsLinks);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum BusinessStatus implements Parcelable {
        OPERATIONAL,
        CLOSED_TEMPORARILY,
        CLOSED_PERMANENTLY;

        public static final Parcelable.Creator<BusinessStatus> CREATOR = new zzgc();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Field implements Parcelable {
        ACCESSIBILITY_OPTIONS,
        ADDRESS_COMPONENTS,
        ADR_FORMAT_ADDRESS,
        ALLOWS_DOGS,
        BUSINESS_STATUS,
        CONSUMER_ALERT,
        CURBSIDE_PICKUP,
        CURRENT_OPENING_HOURS,
        CURRENT_SECONDARY_OPENING_HOURS,
        DELIVERY,
        DINE_IN,
        DISPLAY_NAME,
        EDITORIAL_SUMMARY,
        EV_CHARGE_AMENITY_SUMMARY,
        EV_CHARGE_OPTIONS,
        FORMATTED_ADDRESS,
        FUEL_OPTIONS,
        GENERATIVE_SUMMARY,
        GOOD_FOR_CHILDREN,
        GOOD_FOR_GROUPS,
        GOOD_FOR_WATCHING_SPORTS,
        GOOGLE_MAPS_LINKS,
        GOOGLE_MAPS_URI,
        ICON_BACKGROUND_COLOR,
        ICON_MASK_URL,
        ID,
        INTERNATIONAL_PHONE_NUMBER,
        LIVE_MUSIC,
        LOCATION,
        MENU_FOR_CHILDREN,
        NATIONAL_PHONE_NUMBER,
        NEIGHBORHOOD_SUMMARY,
        OPENING_HOURS,
        OUTDOOR_SEATING,
        PARKING_OPTIONS,
        PAYMENT_OPTIONS,
        PHOTO_METADATAS,
        PLUS_CODE,
        PRICE_LEVEL,
        PRIMARY_TYPE,
        PRIMARY_TYPE_DISPLAY_NAME,
        PURE_SERVICE_AREA_BUSINESS,
        RATING,
        RESERVABLE,
        RESOURCE_NAME,
        RESTROOM,
        REVIEWS,
        REVIEW_SUMMARY,
        SECONDARY_OPENING_HOURS,
        SERVES_BEER,
        SERVES_BREAKFAST,
        SERVES_BRUNCH,
        SERVES_COCKTAILS,
        SERVES_COFFEE,
        SERVES_DESSERT,
        SERVES_DINNER,
        SERVES_LUNCH,
        SERVES_VEGETARIAN_FOOD,
        SERVES_WINE,
        SHORT_FORMATTED_ADDRESS,
        SUB_DESTINATIONS,
        TAKEOUT,
        TYPES,
        USER_RATING_COUNT,
        UTC_OFFSET,
        VIEWPORT,
        WEBSITE_URI,
        PRICE_RANGE;

        public static final Parcelable.Creator<Field> CREATOR = new zzgd();

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(name());
        }
    }

    public static Builder c() {
        zzbe zzbeVar = new zzbe();
        BooleanPlaceAttributeValue booleanPlaceAttributeValue = BooleanPlaceAttributeValue.UNKNOWN;
        zzbeVar.i(booleanPlaceAttributeValue);
        zzbeVar.l(booleanPlaceAttributeValue);
        zzbeVar.m(booleanPlaceAttributeValue);
        zzbeVar.X(booleanPlaceAttributeValue);
        zzbeVar.d0(booleanPlaceAttributeValue);
        zzbeVar.e0(booleanPlaceAttributeValue);
        zzbeVar.f0(booleanPlaceAttributeValue);
        zzbeVar.j0(booleanPlaceAttributeValue);
        zzbeVar.k0(booleanPlaceAttributeValue);
        zzbeVar.l0(booleanPlaceAttributeValue);
        zzbeVar.m0(booleanPlaceAttributeValue);
        zzbeVar.p0(booleanPlaceAttributeValue);
        zzbeVar.L(booleanPlaceAttributeValue);
        zzbeVar.F(booleanPlaceAttributeValue);
        zzbeVar.H(booleanPlaceAttributeValue);
        zzbeVar.g0(booleanPlaceAttributeValue);
        zzbeVar.i0(booleanPlaceAttributeValue);
        zzbeVar.h0(booleanPlaceAttributeValue);
        zzbeVar.w(booleanPlaceAttributeValue);
        zzbeVar.e(booleanPlaceAttributeValue);
        zzbeVar.Z(booleanPlaceAttributeValue);
        zzbeVar.x(booleanPlaceAttributeValue);
        zzbeVar.y(booleanPlaceAttributeValue);
        zzbeVar.V(booleanPlaceAttributeValue);
        return zzbeVar;
    }

    public abstract BooleanPlaceAttributeValue A();

    public abstract BooleanPlaceAttributeValue B();

    public abstract GoogleMapsLinks C();

    public abstract Uri D();

    public abstract Integer E();

    public abstract String F();

    public abstract String G();

    public abstract String H();

    public abstract BooleanPlaceAttributeValue I();

    public abstract LatLng J();

    public abstract BooleanPlaceAttributeValue K();

    public abstract String L();

    public abstract NeighborhoodSummary M();

    public abstract OpeningHours N();

    public abstract BooleanPlaceAttributeValue O();

    public abstract ParkingOptions P();

    public abstract PaymentOptions Q();

    public abstract List R();

    public abstract List S();

    public abstract PlusCode T();

    public abstract Integer U();

    public abstract String W();

    public abstract String X();

    public abstract String Y();

    public abstract BooleanPlaceAttributeValue Z();

    public abstract Double a0();

    public abstract BooleanPlaceAttributeValue b0();

    public abstract String c0();

    public abstract AccessibilityOptions d();

    public abstract BooleanPlaceAttributeValue d0();

    public abstract AddressComponents e();

    public abstract ReviewSummary e0();

    public abstract String f();

    public abstract List f0();

    public abstract BooleanPlaceAttributeValue g();

    public abstract List g0();

    public abstract List h();

    public abstract BooleanPlaceAttributeValue h0();

    public abstract BusinessStatus i();

    public abstract BooleanPlaceAttributeValue i0();

    public abstract ConsumerAlert j();

    public abstract BooleanPlaceAttributeValue j0();

    public abstract BooleanPlaceAttributeValue k();

    public abstract BooleanPlaceAttributeValue k0();

    public abstract OpeningHours l();

    public abstract BooleanPlaceAttributeValue l0();

    public abstract List m();

    public abstract BooleanPlaceAttributeValue m0();

    public abstract BooleanPlaceAttributeValue n();

    public abstract BooleanPlaceAttributeValue n0();

    public abstract BooleanPlaceAttributeValue o();

    public abstract BooleanPlaceAttributeValue o0();

    public abstract String p();

    public abstract BooleanPlaceAttributeValue p0();

    public abstract String q();

    public abstract BooleanPlaceAttributeValue q0();

    public abstract String r();

    public abstract String r0();

    public abstract String s();

    public abstract List s0();

    public abstract EvChargeAmenitySummary t();

    public abstract BooleanPlaceAttributeValue t0();

    public abstract EVChargeOptions u();

    public abstract Integer u0();

    public abstract String v();

    public abstract Integer v0();

    public abstract FuelOptions w();

    public abstract LatLngBounds w0();

    public abstract GenerativeSummary x();

    public abstract Uri x0();

    public abstract BooleanPlaceAttributeValue y();

    public abstract zzgf y0();
}
