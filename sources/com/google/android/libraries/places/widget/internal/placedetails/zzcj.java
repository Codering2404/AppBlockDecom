package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.net.Uri;
import com.google.android.libraries.places.api.model.AccessibilityOptions;
import com.google.android.libraries.places.api.model.EVChargeOptions;
import com.google.android.libraries.places.api.model.FuelOptions;
import com.google.android.libraries.places.api.model.FuelPrice;
import com.google.android.libraries.places.api.model.ParkingOptions;
import com.google.android.libraries.places.api.model.PaymentOptions;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcj {
    public static final boolean a(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO = place.o();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO, "getDineIn(...)");
        if (m(booleanPlaceAttributeValueO)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO2 = place.O();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO2, "getOutdoorSeating(...)");
        if (m(booleanPlaceAttributeValueO2)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueB0 = place.b0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueB0, "getReservable(...)");
        if (m(booleanPlaceAttributeValueB0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueT0 = place.t0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueT0, "getTakeout(...)");
        if (m(booleanPlaceAttributeValueT0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueN = place.n();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueN, "getDelivery(...)");
        if (m(booleanPlaceAttributeValueN)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK = place.k();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK, "getCurbsidePickup(...)");
        return m(booleanPlaceAttributeValueK);
    }

    public static final boolean b(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI0 = place.i0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI0, "getServesBreakfast(...)");
        if (m(booleanPlaceAttributeValueI0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO0 = place.o0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO0, "getServesLunch(...)");
        if (m(booleanPlaceAttributeValueO0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueJ0 = place.j0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueJ0, "getServesBrunch(...)");
        if (m(booleanPlaceAttributeValueJ0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueN0 = place.n0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueN0, "getServesDinner(...)");
        if (m(booleanPlaceAttributeValueN0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueM0 = place.m0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueM0, "getServesDessert(...)");
        return m(booleanPlaceAttributeValueM0);
    }

    public static final boolean c(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        AccessibilityOptions accessibilityOptionsD = place.d();
        if (accessibilityOptionsD == null) {
            return false;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD = accessibilityOptionsD.d();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD, "getWheelchairAccessibleEntrance(...)");
        if (!m(booleanPlaceAttributeValueD)) {
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE = accessibilityOptionsD.e();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE, "getWheelchairAccessibleParking(...)");
            if (!m(booleanPlaceAttributeValueE)) {
                Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG = accessibilityOptionsD.g();
                Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG, "getWheelchairAccessibleSeating(...)");
                if (!m(booleanPlaceAttributeValueG)) {
                    Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF = accessibilityOptionsD.f();
                    Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF, "getWheelchairAccessibleRestroom(...)");
                    return m(booleanPlaceAttributeValueF);
                }
            }
        }
        return true;
    }

    public static final boolean d(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueH0 = place.h0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueH0, "getServesBeer(...)");
        if (m(booleanPlaceAttributeValueH0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueQ0 = place.q0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueQ0, "getServesWine(...)");
        if (m(booleanPlaceAttributeValueQ0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueL0 = place.l0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueL0, "getServesCoffee(...)");
        if (m(booleanPlaceAttributeValueL0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK0 = place.k0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK0, "getServesCocktails(...)");
        if (m(booleanPlaceAttributeValueK0)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueP0 = place.p0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueP0, "getServesVegetarianFood(...)");
        return m(booleanPlaceAttributeValueP0);
    }

    public static final boolean e(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD0 = place.d0();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD0, "getRestroom(...)");
        return m(booleanPlaceAttributeValueD0);
    }

    public static final boolean f(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueA = place.A();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueA, "getGoodForGroups(...)");
        if (m(booleanPlaceAttributeValueA)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueB = place.B();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueB, "getGoodForWatchingSports(...)");
        if (m(booleanPlaceAttributeValueB)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI = place.I();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI, "getLiveMusic(...)");
        return m(booleanPlaceAttributeValueI);
    }

    public static final boolean g(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        PaymentOptions paymentOptionsQ = place.Q();
        if (paymentOptionsQ == null) {
            return false;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE = paymentOptionsQ.e();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE, "getAcceptsCreditCards(...)");
        if (!m(booleanPlaceAttributeValueE)) {
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD = paymentOptionsQ.d();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD, "getAcceptsCashOnly(...)");
            if (!m(booleanPlaceAttributeValueD)) {
                Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF = paymentOptionsQ.f();
                Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF, "getAcceptsDebitCards(...)");
                if (!m(booleanPlaceAttributeValueF)) {
                    Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG = paymentOptionsQ.g();
                    Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG, "getAcceptsNfc(...)");
                    return m(booleanPlaceAttributeValueG);
                }
            }
        }
        return true;
    }

    public static final boolean h(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueY = place.y();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueY, "getGoodForChildren(...)");
        if (m(booleanPlaceAttributeValueY)) {
            return true;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK = place.K();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK, "getMenuForChildren(...)");
        return m(booleanPlaceAttributeValueK);
    }

    public static final boolean i(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG = place.g();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG, "getAllowsDogs(...)");
        return m(booleanPlaceAttributeValueG);
    }

    public static final boolean j(Place place) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        ParkingOptions parkingOptionsP = place.P();
        if (parkingOptionsP == null) {
            return false;
        }
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE = parkingOptionsP.e();
        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE, "getFreeParkingLot(...)");
        if (!m(booleanPlaceAttributeValueE)) {
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueH = parkingOptionsP.h();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueH, "getPaidParkingLot(...)");
            if (!m(booleanPlaceAttributeValueH)) {
                Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF = parkingOptionsP.f();
                Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF, "getFreeStreetParking(...)");
                if (!m(booleanPlaceAttributeValueF)) {
                    Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI = parkingOptionsP.i();
                    Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI, "getPaidStreetParking(...)");
                    if (!m(booleanPlaceAttributeValueI)) {
                        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueJ = parkingOptionsP.j();
                        Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueJ, "getValetParking(...)");
                        if (!m(booleanPlaceAttributeValueJ)) {
                            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD = parkingOptionsP.d();
                            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD, "getFreeGarageParking(...)");
                            if (!m(booleanPlaceAttributeValueD)) {
                                Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG = parkingOptionsP.g();
                                Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG, "getPaidGarageParking(...)");
                                return m(booleanPlaceAttributeValueG);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static final boolean k(Place place, Context context, boolean z2) {
        ArrayList arrayList;
        String strV;
        String strH;
        String strC;
        List listC;
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        EVChargeOptions eVChargeOptionsU = place.u();
        List listC2 = eVChargeOptionsU != null ? eVChargeOptionsU.c() : null;
        boolean z3 = (listC2 == null || listC2.isEmpty()) ? false : true;
        FuelOptions fuelOptionsW = place.w();
        if (fuelOptionsW == null || (listC = fuelOptionsW.c()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (Object obj : listC) {
                FuelPrice.FuelType fuelTypeD = ((FuelPrice) obj).d();
                Intrinsics.checkNotNullExpressionValue(fuelTypeD, "getType(...)");
                if (zzz.a(fuelTypeD)) {
                    arrayList.add(obj);
                }
            }
        }
        boolean z4 = (arrayList == null || arrayList.isEmpty()) ? false : true;
        boolean z5 = (!z2 || (strC = zzag.c(place, context)) == null || StringsKt.p0(strC)) ? false : true;
        if (!z3 && !z4 && (((strV = place.v()) == null || StringsKt.p0(strV)) && !z5 && (((strH = place.H()) == null || StringsKt.p0(strH)) && l(place.x0())))) {
            PlusCode plusCodeT = place.T();
            String strD = plusCodeT != null ? plusCodeT.d() : null;
            if ((strD == null || StringsKt.p0(strD)) && place.j() == null) {
                return false;
            }
        }
        return true;
    }

    private static final boolean l(Uri uri) {
        if (uri == null) {
            return true;
        }
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return StringsKt.p0(string);
    }

    private static final boolean m(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        return booleanPlaceAttributeValue == Place.BooleanPlaceAttributeValue.TRUE;
    }
}
