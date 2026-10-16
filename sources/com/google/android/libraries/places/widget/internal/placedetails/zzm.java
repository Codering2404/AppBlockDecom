package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AccessibilityOptions;
import com.google.android.libraries.places.api.model.ParkingOptions;
import com.google.android.libraries.places.api.model.PaymentOptions;
import com.google.android.libraries.places.api.model.Place;
import java.util.ArrayList;
import java.util.List;
import kotlin.experimental.kJ.HcgZcEUYo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzm {
    private static final boolean b(Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue) {
        return booleanPlaceAttributeValue == Place.BooleanPlaceAttributeValue.TRUE;
    }

    public static final List a(Place place, Context context) {
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        if (zzcj.a(place)) {
            String string = context.getString(R.string.C);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList.add(new zzh(string));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO = place.o();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO, "getDineIn(...)");
            if (b(booleanPlaceAttributeValueO)) {
                String string2 = context.getString(R.string.U);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                arrayList.add(new zzg(string2));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO2 = place.O();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO2, "getOutdoorSeating(...)");
            if (b(booleanPlaceAttributeValueO2)) {
                String string3 = context.getString(R.string.f74863o0);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                arrayList.add(new zzg(string3));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueB0 = place.b0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueB0, "getReservable(...)");
            if (b(booleanPlaceAttributeValueB0)) {
                String string4 = context.getString(R.string.R0);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                arrayList.add(new zzg(string4));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueT0 = place.t0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueT0, "getTakeout(...)");
            if (b(booleanPlaceAttributeValueT0)) {
                String string5 = context.getString(R.string.Q0);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                arrayList.add(new zzg(string5));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueN = place.n();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueN, "getDelivery(...)");
            if (b(booleanPlaceAttributeValueN)) {
                String string6 = context.getString(R.string.T);
                Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
                arrayList.add(new zzg(string6));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK = place.k();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK, "getCurbsidePickup(...)");
            if (b(booleanPlaceAttributeValueK)) {
                String string7 = context.getString(R.string.L);
                Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
                arrayList.add(new zzg(string7));
            }
        }
        if (zzcj.b(place)) {
            String string8 = context.getString(R.string.B);
            Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
            arrayList.add(new zzh(string8));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI0 = place.i0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI0, "getServesBreakfast(...)");
            if (b(booleanPlaceAttributeValueI0)) {
                String string9 = context.getString(R.string.C0);
                Intrinsics.checkNotNullExpressionValue(string9, "getString(...)");
                arrayList.add(new zzg(string9));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueO0 = place.o0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueO0, "getServesLunch(...)");
            if (b(booleanPlaceAttributeValueO0)) {
                String string10 = context.getString(R.string.G0);
                Intrinsics.checkNotNullExpressionValue(string10, "getString(...)");
                arrayList.add(new zzg(string10));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueJ0 = place.j0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueJ0, HcgZcEUYo.MVJXsyfqfIPv);
            if (b(booleanPlaceAttributeValueJ0)) {
                String string11 = context.getString(R.string.D0);
                Intrinsics.checkNotNullExpressionValue(string11, "getString(...)");
                arrayList.add(new zzg(string11));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueN0 = place.n0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueN0, "getServesDinner(...)");
            if (b(booleanPlaceAttributeValueN0)) {
                String string12 = context.getString(R.string.F0);
                Intrinsics.checkNotNullExpressionValue(string12, "getString(...)");
                arrayList.add(new zzg(string12));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueM0 = place.m0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueM0, "getServesDessert(...)");
            if (b(booleanPlaceAttributeValueM0)) {
                String string13 = context.getString(R.string.E0);
                Intrinsics.checkNotNullExpressionValue(string13, "getString(...)");
                arrayList.add(new zzg(string13));
            }
        }
        AccessibilityOptions accessibilityOptionsD = place.d();
        if (zzcj.c(place) && accessibilityOptionsD != null) {
            String string14 = context.getString(R.string.f74872t);
            Intrinsics.checkNotNullExpressionValue(string14, "getString(...)");
            arrayList.add(new zzh(string14));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD = accessibilityOptionsD.d();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD, "getWheelchairAccessibleEntrance(...)");
            if (b(booleanPlaceAttributeValueD)) {
                String string15 = context.getString(R.string.E);
                Intrinsics.checkNotNullExpressionValue(string15, "getString(...)");
                arrayList.add(new zzg(string15));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE = accessibilityOptionsD.e();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE, "getWheelchairAccessibleParking(...)");
            if (b(booleanPlaceAttributeValueE)) {
                String string16 = context.getString(R.string.F);
                Intrinsics.checkNotNullExpressionValue(string16, "getString(...)");
                arrayList.add(new zzg(string16));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG = accessibilityOptionsD.g();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG, "getWheelchairAccessibleSeating(...)");
            if (b(booleanPlaceAttributeValueG)) {
                String string17 = context.getString(R.string.H);
                Intrinsics.checkNotNullExpressionValue(string17, "getString(...)");
                arrayList.add(new zzg(string17));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF = accessibilityOptionsD.f();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF, "getWheelchairAccessibleRestroom(...)");
            if (b(booleanPlaceAttributeValueF)) {
                String string18 = context.getString(R.string.G);
                Intrinsics.checkNotNullExpressionValue(string18, "getString(...)");
                arrayList.add(new zzg(string18));
            }
        }
        if (zzcj.d(place)) {
            String string19 = context.getString(R.string.f74880x);
            Intrinsics.checkNotNullExpressionValue(string19, "getString(...)");
            arrayList.add(new zzh(string19));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueH0 = place.h0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueH0, "getServesBeer(...)");
            if (b(booleanPlaceAttributeValueH0)) {
                String string20 = context.getString(R.string.f74835e0);
                Intrinsics.checkNotNullExpressionValue(string20, "getString(...)");
                arrayList.add(new zzg(string20));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueQ0 = place.q0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueQ0, "getServesWine(...)");
            if (b(booleanPlaceAttributeValueQ0)) {
                String string21 = context.getString(R.string.f74847i0);
                Intrinsics.checkNotNullExpressionValue(string21, "getString(...)");
                arrayList.add(new zzg(string21));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueL0 = place.l0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueL0, "getServesCoffee(...)");
            if (b(booleanPlaceAttributeValueL0)) {
                String string22 = context.getString(R.string.f74841g0);
                Intrinsics.checkNotNullExpressionValue(string22, "getString(...)");
                arrayList.add(new zzg(string22));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK0 = place.k0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK0, "getServesCocktails(...)");
            if (b(booleanPlaceAttributeValueK0)) {
                String string23 = context.getString(R.string.f74838f0);
                Intrinsics.checkNotNullExpressionValue(string23, "getString(...)");
                arrayList.add(new zzg(string23));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueP0 = place.p0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueP0, "getServesVegetarianFood(...)");
            if (b(booleanPlaceAttributeValueP0)) {
                String string24 = context.getString(R.string.f74844h0);
                Intrinsics.checkNotNullExpressionValue(string24, "getString(...)");
                arrayList.add(new zzg(string24));
            }
        }
        if (zzcj.e(place)) {
            String string25 = context.getString(R.string.f74874u);
            Intrinsics.checkNotNullExpressionValue(string25, "getString(...)");
            arrayList.add(new zzh(string25));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD0 = place.d0();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD0, "getRestroom(...)");
            if (b(booleanPlaceAttributeValueD0)) {
                String string26 = context.getString(R.string.I);
                Intrinsics.checkNotNullExpressionValue(string26, "getString(...)");
                arrayList.add(new zzg(string26));
            }
        }
        if (zzcj.f(place)) {
            String string27 = context.getString(R.string.f74878w);
            Intrinsics.checkNotNullExpressionValue(string27, "getString(...)");
            arrayList.add(new zzh(string27));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueA = place.A();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueA, "getGoodForGroups(...)");
            if (b(booleanPlaceAttributeValueA)) {
                String string28 = context.getString(R.string.W);
                Intrinsics.checkNotNullExpressionValue(string28, "getString(...)");
                arrayList.add(new zzg(string28));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueB = place.B();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueB, "getGoodForWatchingSports(...)");
            if (b(booleanPlaceAttributeValueB)) {
                String string29 = context.getString(R.string.Y);
                Intrinsics.checkNotNullExpressionValue(string29, "getString(...)");
                arrayList.add(new zzg(string29));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI = place.I();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI, "getLiveMusic(...)");
            if (b(booleanPlaceAttributeValueI)) {
                String string30 = context.getString(R.string.X);
                Intrinsics.checkNotNullExpressionValue(string30, "getString(...)");
                arrayList.add(new zzg(string30));
            }
        }
        PaymentOptions paymentOptionsQ = place.Q();
        if (zzcj.g(place) && paymentOptionsQ != null) {
            String string31 = context.getString(R.string.f74884z);
            Intrinsics.checkNotNullExpressionValue(string31, "getString(...)");
            arrayList.add(new zzh(string31));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE2 = paymentOptionsQ.e();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE2, "getAcceptsCreditCards(...)");
            if (b(booleanPlaceAttributeValueE2)) {
                String string32 = context.getString(R.string.f74883y0);
                Intrinsics.checkNotNullExpressionValue(string32, "getString(...)");
                arrayList.add(new zzg(string32));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF2 = paymentOptionsQ.f();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF2, "getAcceptsDebitCards(...)");
            if (b(booleanPlaceAttributeValueF2)) {
                String string33 = context.getString(R.string.f74885z0);
                Intrinsics.checkNotNullExpressionValue(string33, "getString(...)");
                arrayList.add(new zzg(string33));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG2 = paymentOptionsQ.g();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG2, "getAcceptsNfc(...)");
            if (b(booleanPlaceAttributeValueG2)) {
                String string34 = context.getString(R.string.A0);
                Intrinsics.checkNotNullExpressionValue(string34, "getString(...)");
                arrayList.add(new zzg(string34));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD2 = paymentOptionsQ.d();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD2, "getAcceptsCashOnly(...)");
            if (b(booleanPlaceAttributeValueD2)) {
                String string35 = context.getString(R.string.f74881x0);
                Intrinsics.checkNotNullExpressionValue(string35, "getString(...)");
                arrayList.add(new zzg(string35));
            }
        }
        if (zzcj.h(place)) {
            String string36 = context.getString(R.string.f74876v);
            Intrinsics.checkNotNullExpressionValue(string36, "getString(...)");
            arrayList.add(new zzh(string36));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueY = place.y();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueY, "getGoodForChildren(...)");
            if (b(booleanPlaceAttributeValueY)) {
                String string37 = context.getString(R.string.J);
                Intrinsics.checkNotNullExpressionValue(string37, "getString(...)");
                arrayList.add(new zzg(string37));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueK2 = place.K();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueK2, "getMenuForChildren(...)");
            if (b(booleanPlaceAttributeValueK2)) {
                String string38 = context.getString(R.string.K);
                Intrinsics.checkNotNullExpressionValue(string38, "getString(...)");
                arrayList.add(new zzg(string38));
            }
        }
        if (zzcj.i(place)) {
            String string39 = context.getString(R.string.A);
            Intrinsics.checkNotNullExpressionValue(string39, "getString(...)");
            arrayList.add(new zzh(string39));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG3 = place.g();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG3, "getAllowsDogs(...)");
            if (b(booleanPlaceAttributeValueG3)) {
                String string40 = context.getString(R.string.B0);
                Intrinsics.checkNotNullExpressionValue(string40, "getString(...)");
                arrayList.add(new zzg(string40));
            }
        }
        ParkingOptions parkingOptionsP = place.P();
        if (zzcj.j(place) && parkingOptionsP != null) {
            String string41 = context.getString(R.string.f74882y);
            Intrinsics.checkNotNullExpressionValue(string41, "getString(...)");
            arrayList.add(new zzh(string41));
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueE3 = parkingOptionsP.e();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueE3, "getFreeParkingLot(...)");
            if (b(booleanPlaceAttributeValueE3)) {
                String string42 = context.getString(R.string.f74869r0);
                Intrinsics.checkNotNullExpressionValue(string42, "getString(...)");
                arrayList.add(new zzg(string42));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueH = parkingOptionsP.h();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueH, "getPaidParkingLot(...)");
            if (b(booleanPlaceAttributeValueH)) {
                String string43 = context.getString(R.string.f74875u0);
                Intrinsics.checkNotNullExpressionValue(string43, "getString(...)");
                arrayList.add(new zzg(string43));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueF3 = parkingOptionsP.f();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueF3, "getFreeStreetParking(...)");
            if (b(booleanPlaceAttributeValueF3)) {
                String string44 = context.getString(R.string.f74871s0);
                Intrinsics.checkNotNullExpressionValue(string44, "getString(...)");
                arrayList.add(new zzg(string44));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueI2 = parkingOptionsP.i();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueI2, "getPaidStreetParking(...)");
            if (b(booleanPlaceAttributeValueI2)) {
                String string45 = context.getString(R.string.f74877v0);
                Intrinsics.checkNotNullExpressionValue(string45, "getString(...)");
                arrayList.add(new zzg(string45));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueJ = parkingOptionsP.j();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueJ, "getValetParking(...)");
            if (b(booleanPlaceAttributeValueJ)) {
                String string46 = context.getString(R.string.f74879w0);
                Intrinsics.checkNotNullExpressionValue(string46, "getString(...)");
                arrayList.add(new zzg(string46));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueD3 = parkingOptionsP.d();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueD3, "getFreeGarageParking(...)");
            if (b(booleanPlaceAttributeValueD3)) {
                String string47 = context.getString(R.string.f74867q0);
                Intrinsics.checkNotNullExpressionValue(string47, "getString(...)");
                arrayList.add(new zzg(string47));
            }
            Place.BooleanPlaceAttributeValue booleanPlaceAttributeValueG4 = parkingOptionsP.g();
            Intrinsics.checkNotNullExpressionValue(booleanPlaceAttributeValueG4, "getPaidGarageParking(...)");
            if (b(booleanPlaceAttributeValueG4)) {
                String string48 = context.getString(R.string.f74873t0);
                Intrinsics.checkNotNullExpressionValue(string48, "getString(...)");
                arrayList.add(new zzg(string48));
            }
        }
        return arrayList;
    }
}
