package com.google.android.libraries.places.internal;

import android.graphics.Color;
import android.net.Uri;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.AccessibilityOptions;
import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import com.google.android.libraries.places.api.model.AuthorAttribution;
import com.google.android.libraries.places.api.model.AuthorAttributions;
import com.google.android.libraries.places.api.model.ConnectorAggregation;
import com.google.android.libraries.places.api.model.ConsumerAlert;
import com.google.android.libraries.places.api.model.ConsumerAlertDetails;
import com.google.android.libraries.places.api.model.ContentBlock;
import com.google.android.libraries.places.api.model.DayOfWeek;
import com.google.android.libraries.places.api.model.EVChargeOptions;
import com.google.android.libraries.places.api.model.EVConnectorType;
import com.google.android.libraries.places.api.model.EvChargeAmenitySummary;
import com.google.android.libraries.places.api.model.FuelOptions;
import com.google.android.libraries.places.api.model.FuelPrice;
import com.google.android.libraries.places.api.model.GenerativeSummary;
import com.google.android.libraries.places.api.model.GoogleMapsLinks;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.LocalTime;
import com.google.android.libraries.places.api.model.Money;
import com.google.android.libraries.places.api.model.NeighborhoodSummary;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.ParkingOptions;
import com.google.android.libraries.places.api.model.PaymentOptions;
import com.google.android.libraries.places.api.model.Period;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.PlusCode;
import com.google.android.libraries.places.api.model.Review;
import com.google.android.libraries.places.api.model.ReviewSummary;
import com.google.android.libraries.places.api.model.SpecialDay;
import com.google.android.libraries.places.api.model.SubDestination;
import com.google.android.libraries.places.api.model.TimeOfWeek;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableMap f78018a = ImmutableMap.a().g(zzayy.OPERATIONAL, Place.BusinessStatus.OPERATIONAL).g(zzayy.CLOSED_TEMPORARILY, Place.BusinessStatus.CLOSED_TEMPORARILY).g(zzayy.CLOSED_PERMANENTLY, Place.BusinessStatus.CLOSED_PERMANENTLY).d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImmutableMap f78019b = ImmutableMap.a().g(zzazu.ACCESS, OpeningHours.HoursType.ACCESS).g(zzazu.BREAKFAST, OpeningHours.HoursType.BREAKFAST).g(zzazu.BRUNCH, OpeningHours.HoursType.f74953c).g(zzazu.DELIVERY, OpeningHours.HoursType.DELIVERY).g(zzazu.DINNER, OpeningHours.HoursType.DINNER).g(zzazu.DRIVE_THROUGH, OpeningHours.HoursType.DRIVE_THROUGH).g(zzazu.HAPPY_HOUR, OpeningHours.HoursType.HAPPY_HOUR).g(zzazu.KITCHEN, OpeningHours.HoursType.KITCHEN).g(zzazu.LUNCH, OpeningHours.HoursType.LUNCH).g(zzazu.ONLINE_SERVICE_HOURS, OpeningHours.HoursType.ONLINE_SERVICE_HOURS).g(zzazu.PICKUP, OpeningHours.HoursType.PICKUP).g(zzazu.SENIOR_HOURS, OpeningHours.HoursType.SENIOR_HOURS).g(zzazu.TAKEOUT, OpeningHours.HoursType.TAKEOUT).d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ImmutableMap f78020c = ImmutableMap.a().g(zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED, EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED).g(zzaxz.EV_CONNECTOR_TYPE_OTHER, EVConnectorType.EV_CONNECTOR_TYPE_OTHER).g(zzaxz.EV_CONNECTOR_TYPE_J1772, EVConnectorType.EV_CONNECTOR_TYPE_J1772).g(zzaxz.EV_CONNECTOR_TYPE_TYPE_2, EVConnectorType.EV_CONNECTOR_TYPE_TYPE_2).g(zzaxz.EV_CONNECTOR_TYPE_CHADEMO, EVConnectorType.EV_CONNECTOR_TYPE_CHADEMO).g(zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_1, EVConnectorType.EV_CONNECTOR_TYPE_CCS_COMBO_1).g(zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_2, EVConnectorType.EV_CONNECTOR_TYPE_CCS_COMBO_2).g(zzaxz.EV_CONNECTOR_TYPE_TESLA, EVConnectorType.EV_CONNECTOR_TYPE_TESLA).g(zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T, EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T).g(zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET, EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET).g(zzaxz.EV_CONNECTOR_TYPE_NACS, EVConnectorType.EV_CONNECTOR_TYPE_NACS).d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ImmutableMap f78021d = ImmutableMap.a().g(zzayc.FUEL_TYPE_UNSPECIFIED, FuelPrice.FuelType.FUEL_TYPE_UNSPECIFIED).g(zzayc.DIESEL, FuelPrice.FuelType.DIESEL).g(zzayc.REGULAR_UNLEADED, FuelPrice.FuelType.REGULAR_UNLEADED).g(zzayc.MIDGRADE, FuelPrice.FuelType.MIDGRADE).g(zzayc.PREMIUM, FuelPrice.FuelType.PREMIUM).g(zzayc.SP91, FuelPrice.FuelType.SP91).g(zzayc.SP91_E10, FuelPrice.FuelType.SP91_E10).g(zzayc.SP92, FuelPrice.FuelType.SP92).g(zzayc.SP95, FuelPrice.FuelType.SP95).g(zzayc.SP95_E10, FuelPrice.FuelType.SP95_E10).g(zzayc.SP98, FuelPrice.FuelType.SP98).g(zzayc.SP99, FuelPrice.FuelType.SP99).g(zzayc.SP100, FuelPrice.FuelType.SP100).g(zzayc.LPG, FuelPrice.FuelType.LPG).g(zzayc.E80, FuelPrice.FuelType.E80).g(zzayc.E85, FuelPrice.FuelType.E85).g(zzayc.METHANE, FuelPrice.FuelType.METHANE).g(zzayc.BIO_DIESEL, FuelPrice.FuelType.BIO_DIESEL).g(zzayc.TRUCK_DIESEL, FuelPrice.FuelType.TRUCK_DIESEL).d();

    zzji() {
    }

    private final List f(List list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(g((zzazx) it.next()));
        }
        return arrayList;
    }

    private final OpeningHours g(zzazx zzazxVar) throws ApiException {
        OpeningHours.Builder builderC = OpeningHours.c();
        List listI = zzazxVar.I();
        ArrayList arrayList = new ArrayList();
        Iterator it = listI.iterator();
        while (true) {
            TimeOfWeek timeOfWeekU = null;
            if (!it.hasNext()) {
                break;
            }
            zzazt zzaztVar = (zzazt) it.next();
            Period.Builder builderC2 = Period.c();
            builderC2.c(zzaztVar.G() ? u(zzaztVar.H()) : null);
            if (zzaztVar.I()) {
                timeOfWeekU = u(zzaztVar.J());
            }
            builderC2.b(timeOfWeekU);
            arrayList.add(builderC2.a());
        }
        builderC.c(arrayList);
        builderC.e(zzazxVar.J());
        builderC.b((OpeningHours.HoursType) this.f78019b.getOrDefault(zzazxVar.K(), null));
        List listL = zzazxVar.L();
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = listL.iterator();
        while (it2.hasNext()) {
            try {
                SpecialDay.Builder builderA = SpecialDay.a(o(((zzazw) it2.next()).G()));
                builderA.b(true);
                arrayList2.add(builderA.a());
            } catch (IllegalArgumentException e3) {
                throw h(String.format("Special day is not properly defined: %s", e3.getMessage()));
            }
        }
        builderC.d(arrayList2);
        builderC.f(zzazxVar.G() ? Boolean.valueOf(zzazxVar.H()) : null);
        builderC.g(zzazxVar.M() ? j(zzazxVar.N()) : null);
        builderC.h(zzazxVar.O() ? j(zzazxVar.P()) : null);
        return builderC.a();
    }

    private static final ApiException h(String str) {
        return new ApiException(new Status(8, "Unexpected server error: ".concat(String.valueOf(str))));
    }

    private static final String i(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    private static final Instant j(zzbfw zzbfwVar) {
        return Instant.ofEpochSecond(zzbfwVar.G(), zzbfwVar.H());
    }

    private static final Place.BooleanPlaceAttributeValue k(boolean z2, boolean z3) {
        return !z2 ? Place.BooleanPlaceAttributeValue.UNKNOWN : z3 ? Place.BooleanPlaceAttributeValue.TRUE : Place.BooleanPlaceAttributeValue.FALSE;
    }

    private static final String l(String str) {
        return str.startsWith("//") ? "https:".concat(str) : str;
    }

    private static final Instant m(zzbfw zzbfwVar) {
        return Instant.ofEpochSecond(zzbfwVar.G(), zzbfwVar.H());
    }

    private static final LatLng n(zzbht zzbhtVar) {
        return new LatLng(zzbhtVar.G(), zzbhtVar.H());
    }

    private static final LocalDate o(zzbhr zzbhrVar) {
        return LocalDate.f(zzbhrVar.G(), zzbhrVar.H(), zzbhrVar.I());
    }

    private static final Money p(zzbhx zzbhxVar) {
        return Money.f(zzbhxVar.G(), Long.valueOf(zzbhxVar.H()), Integer.valueOf(zzbhxVar.I()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q(String str, String str2) {
        zzxj zzxjVar = new zzxj("a");
        int i3 = zzxm.f78835d;
        zzxjVar.a(zzxm.a(str, zzxl.f78830b));
        zzxjVar.b(str2);
        return zzxjVar.c().a();
    }

    private static final Uri r(String str) {
        if (str.isEmpty()) {
            return null;
        }
        return Uri.parse(str);
    }

    private static final AuthorAttribution s(zzawg zzawgVar) throws ApiException {
        String strG = zzawgVar.G();
        if (strG.isEmpty()) {
            throw h("Author name not provided for an AuthorAttribution result.");
        }
        AuthorAttribution.Builder builderA = AuthorAttribution.a(strG);
        builderA.c(i(zzawgVar.H()));
        builderA.b(i(zzawgVar.I()));
        return builderA.a();
    }

    private static final ContentBlock t(zzaxe zzaxeVar) {
        ContentBlock.Builder builderC = ContentBlock.c();
        builderC.b(i(zzaxeVar.G().G()));
        builderC.c(i(zzaxeVar.G().H()));
        builderC.e(zzaxeVar.H().isEmpty() ? null : zzaxeVar.H());
        builderC.d(zzaxeVar.H().isEmpty() ? null : (ImmutableList) zzaxeVar.H().stream().map(zzjh.f78017a).collect(ImmutableList.N()));
        return builderC.a();
    }

    private static final TimeOfWeek u(zzazs zzazsVar) throws ApiException {
        DayOfWeek dayOfWeek;
        int iG = zzazsVar.G();
        LocalTime localTimeE = LocalTime.e(zzazsVar.H(), zzazsVar.I());
        LocalDate localDateO = zzazsVar.J() ? o(zzazsVar.K()) : null;
        switch (iG) {
            case 0:
                dayOfWeek = DayOfWeek.SUNDAY;
                break;
            case 1:
                dayOfWeek = DayOfWeek.MONDAY;
                break;
            case 2:
                dayOfWeek = DayOfWeek.TUESDAY;
                break;
            case 3:
                dayOfWeek = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                dayOfWeek = DayOfWeek.THURSDAY;
                break;
            case 5:
                dayOfWeek = DayOfWeek.FRIDAY;
                break;
            case 6:
                dayOfWeek = DayOfWeek.SATURDAY;
                break;
            default:
                throw h("Day of week must an integer between 0 and 6");
        }
        TimeOfWeek.Builder builderA = TimeOfWeek.a(dayOfWeek, localTimeE);
        builderA.b(localDateO);
        builderA.d(zzazsVar.L());
        return builderA.a();
    }

    final Place a(zzbai zzbaiVar) throws ApiException {
        AddressComponents addressComponentsD;
        ConsumerAlert consumerAlertA;
        EvChargeAmenitySummary evChargeAmenitySummaryA;
        EVChargeOptions eVChargeOptionsE;
        GenerativeSummary generativeSummaryA;
        GoogleMapsLinks googleMapsLinksA;
        Integer numValueOf;
        NeighborhoodSummary neighborhoodSummaryA;
        ArrayList arrayList;
        AuthorAttributions authorAttributionsD;
        PlusCode plusCodeA;
        com.google.android.libraries.places.api.model.zzgf zzgfVarC;
        ReviewSummary reviewSummaryA;
        ArrayList arrayList2;
        ArrayList arrayList3;
        LatLngBounds latLngBounds;
        ConsumerAlertDetails consumerAlertDetailsA;
        Place.Builder builderC = Place.c();
        zzayq zzayqVarV0 = zzbaiVar.v0();
        AccessibilityOptions.Builder builderC2 = AccessibilityOptions.c();
        builderC2.c(k(zzayqVarV0.G(), zzayqVarV0.H()));
        builderC2.b(k(zzayqVarV0.I(), zzayqVarV0.J()));
        builderC2.d(k(zzayqVarV0.K(), zzayqVarV0.L()));
        builderC2.e(k(zzayqVarV0.M(), zzayqVarV0.N()));
        builderC.b(builderC2.a());
        List<zzays> listD1 = zzbaiVar.D1();
        String str = null;
        if (listD1.isEmpty()) {
            addressComponentsD = null;
        } else {
            ArrayList arrayList4 = new ArrayList();
            for (zzays zzaysVar : listD1) {
                try {
                    AddressComponent.Builder builderA = AddressComponent.a(zzaysVar.G(), zzaysVar.I());
                    builderA.b(i(zzaysVar.H()));
                    arrayList4.add(builderA.a());
                } catch (IllegalArgumentException e3) {
                    throw h(String.format("AddressComponent is not properly defined: %s.", e3.getMessage()));
                }
            }
            addressComponentsD = AddressComponents.d(arrayList4);
        }
        builderC.c(addressComponentsD);
        String strJ = zzbaiVar.J();
        builderC.d(strJ.isEmpty() ? null : zzxk.a(strJ).a());
        builderC.e(k(zzbaiVar.k0(), zzbaiVar.l0()));
        List listM = zzbaiVar.M();
        builderC.f(listM.isEmpty() ? null : (List) listM.stream().map(new Function(this) { // from class: com.google.android.libraries.places.internal.zzje
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                zzayw zzaywVar = (zzayw) obj;
                return zzji.q(zzji.l(zzaywVar.H()), zzaywVar.G());
            }
        }).collect(ImmutableList.N()));
        builderC.g((Place.BusinessStatus) this.f78018a.getOrDefault(zzbaiVar.K(), null));
        if (zzbaiVar.o1()) {
            zzaze zzazeVarP1 = zzbaiVar.p1();
            ConsumerAlert.Builder builderC3 = ConsumerAlert.c();
            builderC3.d(i(zzazeVarP1.G()));
            if (zzazeVarP1.H()) {
                zzazd zzazdVarI = zzazeVarP1.I();
                ConsumerAlertDetails.Builder builderC4 = ConsumerAlertDetails.c();
                builderC4.e(i(zzazdVarI.G()));
                builderC4.d(i(zzazdVarI.H()));
                builderC4.b(i(zzazdVarI.I().G()));
                builderC4.c(r(zzazdVarI.I().H()));
                consumerAlertDetailsA = builderC4.a();
            } else {
                consumerAlertDetailsA = null;
            }
            builderC3.b(consumerAlertDetailsA);
            builderC3.c(i(zzazeVarP1.J()));
            consumerAlertA = builderC3.a();
        } else {
            consumerAlertA = null;
        }
        builderC.h(consumerAlertA);
        builderC.i(k(zzbaiVar.X(), zzbaiVar.Y()));
        builderC.j(zzbaiVar.Q0() ? g(zzbaiVar.R0()) : null);
        builderC.k(f(zzbaiVar.S0()));
        builderC.l(k(zzbaiVar.T(), zzbaiVar.U()));
        builderC.m(k(zzbaiVar.V(), zzbaiVar.W()));
        builderC.n(zzbaiVar.t1() ? i(zzbaiVar.u1().G()) : null);
        builderC.o(zzbaiVar.t1() ? i(zzbaiVar.u1().H()) : null);
        builderC.p(zzbaiVar.U0() ? i(zzbaiVar.V0().G()) : null);
        builderC.q(zzbaiVar.U0() ? i(zzbaiVar.V0().H()) : null);
        if (zzbaiVar.k1()) {
            zzazi zzaziVarL1 = zzbaiVar.l1();
            EvChargeAmenitySummary.Builder builderA2 = EvChargeAmenitySummary.a(t(zzaziVarL1.G()));
            builderA2.b(zzaziVarL1.H() ? t(zzaziVarL1.I()) : null);
            builderA2.f(zzaziVarL1.J() ? t(zzaziVarL1.K()) : null);
            builderA2.g(zzaziVarL1.L() ? t(zzaziVarL1.M()) : null);
            builderA2.e(r(zzaziVarL1.N()));
            builderA2.c(i(zzaziVarL1.O().G()));
            builderA2.d(i(zzaziVarL1.O().H()));
            evChargeAmenitySummaryA = builderA2.a();
        } else {
            evChargeAmenitySummaryA = null;
        }
        builderC.r(evChargeAmenitySummaryA);
        if (zzbaiVar.y0()) {
            zzaxy zzaxyVarZ0 = zzbaiVar.z0();
            eVChargeOptionsE = EVChargeOptions.e(Integer.valueOf(zzaxyVarZ0.G()), (ImmutableList) zzaxyVarZ0.H().stream().map(new Function() { // from class: com.google.android.libraries.places.internal.zzjg
                @Override // java.util.function.Function
                public final /* synthetic */ Object apply(Object obj) {
                    return this.f78016a.c((zzaxv) obj);
                }
            }).collect(ImmutableList.N()));
        } else {
            eVChargeOptionsE = null;
        }
        builderC.s(eVChargeOptionsE);
        builderC.t(i(zzbaiVar.B1()));
        builderC.u(zzbaiVar.w0() ? FuelOptions.d((ImmutableList) zzbaiVar.x0().G().stream().map(new Function() { // from class: com.google.android.libraries.places.internal.zzjf
            @Override // java.util.function.Function
            public final /* synthetic */ Object apply(Object obj) {
                return this.f78015a.b((zzayd) obj);
            }
        }).collect(ImmutableList.N())) : null);
        if (zzbaiVar.A0()) {
            zzazk zzazkVarB0 = zzbaiVar.B0();
            GenerativeSummary.Builder builderC5 = GenerativeSummary.c();
            builderC5.e(zzazkVarB0.G() ? i(zzazkVarB0.H().G()) : null);
            builderC5.f(zzazkVarB0.G() ? i(zzazkVarB0.H().H()) : null);
            builderC5.d(r(zzazkVarB0.I()));
            builderC5.b(zzazkVarB0.J() ? i(zzazkVarB0.K().G()) : null);
            builderC5.c(zzazkVarB0.J() ? i(zzazkVarB0.K().H()) : null);
            generativeSummaryA = builderC5.a();
        } else {
            generativeSummaryA = null;
        }
        builderC.v(generativeSummaryA);
        builderC.w(k(zzbaiVar.i0(), zzbaiVar.j0()));
        builderC.x(k(zzbaiVar.o0(), zzbaiVar.p0()));
        builderC.y(k(zzbaiVar.q0(), zzbaiVar.r0()));
        if (zzbaiVar.E0()) {
            zzazm zzazmVarF0 = zzbaiVar.F0();
            GoogleMapsLinks.Builder builderC6 = GoogleMapsLinks.c();
            builderC6.b(r(zzazmVarF0.G()));
            builderC6.d(r(zzazmVarF0.H()));
            builderC6.f(r(zzazmVarF0.I()));
            builderC6.e(r(zzazmVarF0.J()));
            builderC6.c(r(zzazmVarF0.K()));
            googleMapsLinksA = builderC6.a();
        } else {
            googleMapsLinksA = null;
        }
        builderC.z(googleMapsLinksA);
        builderC.A(r(zzbaiVar.L1()));
        String strQ = zzbaiVar.Q();
        if (strQ.isEmpty()) {
            numValueOf = null;
        } else {
            try {
                numValueOf = Integer.valueOf(Color.parseColor(strQ));
            } catch (IllegalArgumentException unused) {
                numValueOf = null;
            }
        }
        builderC.B(numValueOf);
        String strP = zzbaiVar.P();
        builderC.C(!strP.isEmpty() ? strP.concat(".png") : null);
        builderC.D(i(zzbaiVar.s1()));
        builderC.E(i(zzbaiVar.A1()));
        builderC.F(k(zzbaiVar.Y0(), zzbaiVar.Z0()));
        builderC.G(zzbaiVar.G1() ? n(zzbaiVar.H1()) : null);
        builderC.H(k(zzbaiVar.b1(), zzbaiVar.c1()));
        builderC.I(i(zzbaiVar.z1()));
        if (zzbaiVar.m1()) {
            zzazo zzazoVarN1 = zzbaiVar.n1();
            NeighborhoodSummary.Builder builderC7 = NeighborhoodSummary.c();
            builderC7.f(zzazoVarN1.G() ? t(zzazoVarN1.H()) : null);
            builderC7.b(zzazoVarN1.I() ? t(zzazoVarN1.J()) : null);
            builderC7.e(r(zzazoVarN1.K()));
            builderC7.c(i(zzazoVarN1.L().G()));
            builderC7.d(i(zzazoVarN1.L().H()));
            neighborhoodSummaryA = builderC7.a();
        } else {
            neighborhoodSummaryA = null;
        }
        builderC.J(neighborhoodSummaryA);
        builderC.K(zzbaiVar.O1() ? g(zzbaiVar.P1()) : null);
        builderC.L(k(zzbaiVar.W0(), zzbaiVar.X0()));
        zzazz zzazzVarT0 = zzbaiVar.t0();
        ParkingOptions.Builder builderC8 = ParkingOptions.c();
        builderC8.c(k(zzazzVarT0.G(), zzazzVarT0.H()));
        builderC8.f(k(zzazzVarT0.I(), zzazzVarT0.J()));
        builderC8.d(k(zzazzVarT0.K(), zzazzVarT0.L()));
        builderC8.g(k(zzazzVarT0.M(), zzazzVarT0.N()));
        builderC8.h(k(zzazzVarT0.O(), zzazzVarT0.P()));
        builderC8.b(k(zzazzVarT0.Q(), zzazzVarT0.R()));
        builderC8.e(k(zzazzVarT0.S(), zzazzVarT0.T()));
        builderC.M(builderC8.a());
        zzbab zzbabVarS0 = zzbaiVar.s0();
        PaymentOptions.Builder builderC9 = PaymentOptions.c();
        builderC9.c(k(zzbabVarS0.G(), zzbabVarS0.H()));
        builderC9.d(k(zzbabVarS0.I(), zzbabVarS0.J()));
        builderC9.b(k(zzbabVarS0.K(), zzbabVarS0.L()));
        builderC9.e(k(zzbabVarS0.M(), zzbabVarS0.N()));
        builderC.N(builderC9.a());
        List<zzaym> listI = zzbaiVar.I();
        if (listI.isEmpty()) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (zzaym zzaymVar : listI) {
                String strG = zzaymVar.G();
                if (strG.isEmpty() || strG.split("/").length != 4) {
                    throw h("Photo reference not provided for a PhotoMetadata result.");
                }
                PhotoMetadata.Builder builderA3 = PhotoMetadata.a((String) Iterables.h(Splitter.f('/').k(strG), 3));
                builderA3.f(zzaymVar.G());
                builderA3.b((String) zzaymVar.J().stream().map(new Function(this) { // from class: com.google.android.libraries.places.internal.zzjd
                    @Override // java.util.function.Function
                    public final /* synthetic */ Object apply(Object obj) {
                        zzawg zzawgVar = (zzawg) obj;
                        return zzji.q(zzji.l(zzawgVar.H()), zzawgVar.G());
                    }
                }).collect(Collectors.joining(", ")));
                builderA3.d(zzaymVar.I());
                builderA3.e(zzaymVar.H());
                List listJ = zzaymVar.J();
                if (listJ.isEmpty()) {
                    authorAttributionsD = null;
                } else {
                    ImmutableList.Builder builderO = ImmutableList.o();
                    Iterator it = listJ.iterator();
                    while (it.hasNext()) {
                        builderO.a(s((zzawg) it.next()));
                    }
                    authorAttributionsD = AuthorAttributions.d(builderO.m());
                }
                builderA3.c(authorAttributionsD);
                builderA3.g(r(zzaymVar.K()));
                arrayList.add(builderA3.a());
            }
        }
        builderC.O(arrayList);
        builderC.P(zzbaiVar.v1().isEmpty() ? null : zzbaiVar.v1());
        if (zzbaiVar.E1()) {
            zzbad zzbadVarF1 = zzbaiVar.F1();
            PlusCode.Builder builderC10 = PlusCode.c();
            builderC10.b(i(zzbadVarF1.H()));
            builderC10.c(i(zzbadVarF1.G()));
            plusCodeA = builderC10.a();
        } else {
            plusCodeA = null;
        }
        builderC.Q(plusCodeA);
        int iOrdinal = zzbaiVar.L().ordinal();
        builderC.R(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? null : 4 : 3 : 2 : 1 : 0);
        if (zzbaiVar.G0().G()) {
            com.google.android.libraries.places.api.model.zzge zzgeVarE = com.google.android.libraries.places.api.model.zzgf.e();
            zzgeVarE.a(p(zzbaiVar.G0().H()));
            if (zzbaiVar.G0().I()) {
                zzgeVarE.b(p(zzbaiVar.G0().J()));
            }
            zzgfVarC = zzgeVarE.c();
        } else {
            zzgfVarC = null;
        }
        builderC.u0(zzgfVarC);
        builderC.S(i(zzbaiVar.w1()));
        builderC.T(zzbaiVar.x1() ? i(zzbaiVar.y1().G()) : null);
        builderC.U(zzbaiVar.x1() ? i(zzbaiVar.y1().H()) : null);
        builderC.V(k(zzbaiVar.C0(), zzbaiVar.D0()));
        double dK1 = zzbaiVar.K1();
        builderC.W(dK1 < 1.0d ? null : Double.valueOf(dK1));
        builderC.X(k(zzbaiVar.Z(), zzbaiVar.a0()));
        builderC.Y(i(zzbaiVar.g0()));
        builderC.Z(k(zzbaiVar.m0(), zzbaiVar.n0()));
        if (zzbaiVar.i1()) {
            zzbaf zzbafVarJ1 = zzbaiVar.j1();
            ReviewSummary.Builder builderC11 = ReviewSummary.c();
            builderC11.f(i(zzbafVarJ1.G().G()));
            builderC11.g(i(zzbafVarJ1.G().H()));
            builderC11.d(r(zzbafVarJ1.H()));
            builderC11.b(i(zzbafVarJ1.I().G()));
            builderC11.c(i(zzbafVarJ1.I().H()));
            builderC11.e(r(zzbafVarJ1.J()));
            reviewSummaryA = builderC11.a();
        } else {
            reviewSummaryA = null;
        }
        builderC.a0(reviewSummaryA);
        List<zzbau> listN1 = zzbaiVar.N1();
        if (listN1.isEmpty()) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList();
            for (zzbau zzbauVar : listN1) {
                double dL = zzbauVar.L();
                if (dL == 0.0d) {
                    throw h("Review rating not provided for a Review result.");
                }
                if (!zzbauVar.M()) {
                    throw h("Author attribution not provided for a Review result.");
                }
                String strA = zzbauVar.O() ? zzbgq.a(zzbauVar.P()) : str;
                String strI = zzbauVar.H() ? i(zzbauVar.I().G()) : str;
                String strI2 = zzbauVar.H() ? i(zzbauVar.I().H()) : str;
                String strI3 = zzbauVar.J() ? i(zzbauVar.K().G()) : str;
                String strI4 = zzbauVar.J() ? i(zzbauVar.K().H()) : str;
                String strI5 = i(zzbauVar.G());
                LocalDate localDateF = zzbauVar.R() ? LocalDate.f(zzbauVar.S().G(), zzbauVar.S().H(), 1) : null;
                Review.Builder builderA4 = Review.a(Double.valueOf(dL), s(zzbauVar.N()));
                builderA4.e(strA);
                builderA4.g(strI);
                builderA4.h(strI2);
                builderA4.c(strI3);
                builderA4.d(strI4);
                builderA4.f(strI5);
                builderA4.b(r(zzbauVar.Q()));
                builderA4.i(localDateF);
                arrayList2.add(builderA4.a());
                str = null;
            }
        }
        builderC.b0(arrayList2);
        builderC.c0(f(zzbaiVar.T0()));
        builderC.d0(k(zzbaiVar.I0(), zzbaiVar.J0()));
        builderC.e0(k(zzbaiVar.b0(), zzbaiVar.c0()));
        builderC.f0(k(zzbaiVar.M0(), zzbaiVar.N0()));
        builderC.g0(k(zzbaiVar.d1(), zzbaiVar.e1()));
        builderC.h0(k(zzbaiVar.h1(), zzbaiVar.h0()));
        builderC.i0(k(zzbaiVar.f1(), zzbaiVar.g1()));
        builderC.j0(k(zzbaiVar.f0(), zzbaiVar.H0()));
        builderC.k0(k(zzbaiVar.d0(), zzbaiVar.e0()));
        builderC.l0(k(zzbaiVar.O0(), zzbaiVar.P0()));
        builderC.m0(k(zzbaiVar.K0(), zzbaiVar.L0()));
        builderC.n0(i(zzbaiVar.C1()));
        List<zzbah> listU0 = zzbaiVar.u0();
        if (listU0.isEmpty()) {
            arrayList3 = null;
        } else {
            arrayList3 = new ArrayList();
            for (zzbah zzbahVar : listU0) {
                arrayList3.add(SubDestination.d(zzbahVar.H(), zzbahVar.G()));
            }
        }
        builderC.o0(arrayList3);
        builderC.p0(k(zzbaiVar.R(), zzbaiVar.S()));
        builderC.q0(zzbaiVar.N() ? Integer.valueOf(zzbaiVar.O()) : null);
        builderC.r0(zzbaiVar.G() ? Integer.valueOf(zzbaiVar.H()) : null);
        if (zzbaiVar.I1()) {
            zzaua zzauaVarJ1 = zzbaiVar.J1();
            latLngBounds = new LatLngBounds(n(zzauaVarJ1.G()), n(zzauaVarJ1.H()));
        } else {
            latLngBounds = null;
        }
        builderC.s0(latLngBounds);
        builderC.t0(r(zzbaiVar.M1()));
        return builderC.a();
    }

    final /* synthetic */ FuelPrice b(zzayd zzaydVar) {
        return FuelPrice.f((FuelPrice.FuelType) this.f78021d.getOrDefault(zzaydVar.G(), FuelPrice.FuelType.FUEL_TYPE_UNSPECIFIED), p(zzaydVar.H()), m(zzaydVar.I()));
    }

    final /* synthetic */ ConnectorAggregation c(zzaxv zzaxvVar) {
        ConnectorAggregation.Builder builderA = ConnectorAggregation.a((EVConnectorType) this.f78020c.getOrDefault(zzaxvVar.G(), EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED), Double.valueOf(zzaxvVar.H()), Integer.valueOf(zzaxvVar.I()));
        builderA.c(zzaxvVar.J() ? Integer.valueOf(zzaxvVar.K()) : null);
        builderA.f(zzaxvVar.L() ? Integer.valueOf(zzaxvVar.M()) : null);
        builderA.b(zzaxvVar.N() ? m(zzaxvVar.O()) : null);
        return builderA.a();
    }
}
