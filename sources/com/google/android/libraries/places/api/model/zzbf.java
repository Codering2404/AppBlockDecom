package com.google.android.libraries.places.api.model;

import android.net.Uri;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbf extends Place {
    private final List A;
    private final PlusCode B;
    private final Integer C;
    private final zzgf D;
    private final String E;
    private final String F;
    private final String G;
    private final Double H;
    private final Place.BooleanPlaceAttributeValue I;
    private final List J;
    private final List K;
    private final Place.BooleanPlaceAttributeValue L;
    private final Place.BooleanPlaceAttributeValue M;
    private final Place.BooleanPlaceAttributeValue N;
    private final Place.BooleanPlaceAttributeValue O;
    private final Place.BooleanPlaceAttributeValue P;
    private final Place.BooleanPlaceAttributeValue Q;
    private final Place.BooleanPlaceAttributeValue R;
    private final Place.BooleanPlaceAttributeValue S;
    private final Integer T;
    private final Integer U;
    private final LatLngBounds V;
    private final Uri W;
    private final Uri X;
    private final AccessibilityOptions Y;
    private final ParkingOptions Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75209a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final PaymentOptions f75210a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75211b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final EVChargeOptions f75212b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75213c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75214c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AddressComponents f75215d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75216d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75217e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f75218f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75219f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Place.BusinessStatus f75220g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75221g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConsumerAlert f75222h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75223h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75224i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75225i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final OpeningHours f75226j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75227j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75228k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75229k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75230l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75231l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f75232m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75233m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f75234n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final List f75235n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final Integer f75236o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    private final FuelOptions f75237o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f75238p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    private final Place.BooleanPlaceAttributeValue f75239p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f75240q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    private final GenerativeSummary f75241q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final LatLng f75242r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    private final EvChargeAmenitySummary f75243r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f75244s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    private final NeighborhoodSummary f75245s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f75246t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    private final ReviewSummary f75247t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f75248u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    private final GoogleMapsLinks f75249u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final OpeningHours f75250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f75251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f75252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final List f75253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final List f75254z;

    zzbf(String str, String str2, String str3, AddressComponents addressComponents, List list, Place.BusinessStatus businessStatus, ConsumerAlert consumerAlert, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue, OpeningHours openingHours, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3, String str4, String str5, Integer num, String str6, String str7, LatLng latLng, String str8, String str9, String str10, OpeningHours openingHours2, String str11, String str12, List list2, List list3, List list4, PlusCode plusCode, Integer num2, zzgf zzgfVar, String str13, String str14, String str15, Double d3, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4, List list5, List list6, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue5, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue6, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue7, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue8, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue9, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue10, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue11, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue12, Integer num3, Integer num4, LatLngBounds latLngBounds, Uri uri, Uri uri2, AccessibilityOptions accessibilityOptions, ParkingOptions parkingOptions, PaymentOptions paymentOptions, EVChargeOptions eVChargeOptions, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue13, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue14, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue15, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue16, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue17, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue18, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue19, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue20, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue21, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue22, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue23, List list7, FuelOptions fuelOptions, Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue24, GenerativeSummary generativeSummary, EvChargeAmenitySummary evChargeAmenitySummary, NeighborhoodSummary neighborhoodSummary, ReviewSummary reviewSummary, GoogleMapsLinks googleMapsLinks) {
        this.f75209a = str;
        this.f75211b = str2;
        this.f75213c = str3;
        this.f75215d = addressComponents;
        this.f75218f = list;
        this.f75220g = businessStatus;
        this.f75222h = consumerAlert;
        if (booleanPlaceAttributeValue == null) {
            throw new NullPointerException("Null curbsidePickup");
        }
        this.f75224i = booleanPlaceAttributeValue;
        this.f75226j = openingHours;
        if (booleanPlaceAttributeValue2 == null) {
            throw new NullPointerException("Null delivery");
        }
        this.f75228k = booleanPlaceAttributeValue2;
        if (booleanPlaceAttributeValue3 == null) {
            throw new NullPointerException("Null dineIn");
        }
        this.f75230l = booleanPlaceAttributeValue3;
        this.f75232m = str4;
        this.f75234n = str5;
        this.f75236o = num;
        this.f75238p = str6;
        this.f75240q = str7;
        this.f75242r = latLng;
        this.f75244s = str8;
        this.f75246t = str9;
        this.f75248u = str10;
        this.f75250v = openingHours2;
        this.f75251w = str11;
        this.f75252x = str12;
        this.f75253y = list2;
        this.f75254z = list3;
        this.A = list4;
        this.B = plusCode;
        this.C = num2;
        this.D = zzgfVar;
        this.E = str13;
        this.F = str14;
        this.G = str15;
        this.H = d3;
        if (booleanPlaceAttributeValue4 == null) {
            throw new NullPointerException("Null reservable");
        }
        this.I = booleanPlaceAttributeValue4;
        this.J = list5;
        this.K = list6;
        if (booleanPlaceAttributeValue5 == null) {
            throw new NullPointerException("Null servesBeer");
        }
        this.L = booleanPlaceAttributeValue5;
        if (booleanPlaceAttributeValue6 == null) {
            throw new NullPointerException("Null servesBreakfast");
        }
        this.M = booleanPlaceAttributeValue6;
        if (booleanPlaceAttributeValue7 == null) {
            throw new NullPointerException("Null servesBrunch");
        }
        this.N = booleanPlaceAttributeValue7;
        if (booleanPlaceAttributeValue8 == null) {
            throw new NullPointerException("Null servesDinner");
        }
        this.O = booleanPlaceAttributeValue8;
        if (booleanPlaceAttributeValue9 == null) {
            throw new NullPointerException("Null servesLunch");
        }
        this.P = booleanPlaceAttributeValue9;
        if (booleanPlaceAttributeValue10 == null) {
            throw new NullPointerException("Null servesVegetarianFood");
        }
        this.Q = booleanPlaceAttributeValue10;
        if (booleanPlaceAttributeValue11 == null) {
            throw new NullPointerException("Null servesWine");
        }
        this.R = booleanPlaceAttributeValue11;
        if (booleanPlaceAttributeValue12 == null) {
            throw new NullPointerException("Null takeout");
        }
        this.S = booleanPlaceAttributeValue12;
        this.T = num3;
        this.U = num4;
        this.V = latLngBounds;
        this.W = uri;
        this.X = uri2;
        this.Y = accessibilityOptions;
        this.Z = parkingOptions;
        this.f75210a0 = paymentOptions;
        this.f75212b0 = eVChargeOptions;
        if (booleanPlaceAttributeValue13 == null) {
            throw new NullPointerException("Null outdoorSeating");
        }
        this.f75214c0 = booleanPlaceAttributeValue13;
        if (booleanPlaceAttributeValue14 == null) {
            throw new NullPointerException("Null liveMusic");
        }
        this.f75216d0 = booleanPlaceAttributeValue14;
        if (booleanPlaceAttributeValue15 == null) {
            throw new NullPointerException("Null menuForChildren");
        }
        this.f75217e0 = booleanPlaceAttributeValue15;
        if (booleanPlaceAttributeValue16 == null) {
            throw new NullPointerException("Null servesCocktails");
        }
        this.f75219f0 = booleanPlaceAttributeValue16;
        if (booleanPlaceAttributeValue17 == null) {
            throw new NullPointerException("Null servesDessert");
        }
        this.f75221g0 = booleanPlaceAttributeValue17;
        if (booleanPlaceAttributeValue18 == null) {
            throw new NullPointerException("Null servesCoffee");
        }
        this.f75223h0 = booleanPlaceAttributeValue18;
        if (booleanPlaceAttributeValue19 == null) {
            throw new NullPointerException("Null goodForChildren");
        }
        this.f75225i0 = booleanPlaceAttributeValue19;
        if (booleanPlaceAttributeValue20 == null) {
            throw new NullPointerException("Null allowsDogs");
        }
        this.f75227j0 = booleanPlaceAttributeValue20;
        if (booleanPlaceAttributeValue21 == null) {
            throw new NullPointerException("Null restroom");
        }
        this.f75229k0 = booleanPlaceAttributeValue21;
        if (booleanPlaceAttributeValue22 == null) {
            throw new NullPointerException("Null goodForGroups");
        }
        this.f75231l0 = booleanPlaceAttributeValue22;
        if (booleanPlaceAttributeValue23 == null) {
            throw new NullPointerException("Null goodForWatchingSports");
        }
        this.f75233m0 = booleanPlaceAttributeValue23;
        this.f75235n0 = list7;
        this.f75237o0 = fuelOptions;
        if (booleanPlaceAttributeValue24 == null) {
            throw new NullPointerException("Null pureServiceAreaBusiness");
        }
        this.f75239p0 = booleanPlaceAttributeValue24;
        this.f75241q0 = generativeSummary;
        this.f75243r0 = evChargeAmenitySummary;
        this.f75245s0 = neighborhoodSummary;
        this.f75247t0 = reviewSummary;
        this.f75249u0 = googleMapsLinks;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue A() {
        return this.f75231l0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue B() {
        return this.f75233m0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public GoogleMapsLinks C() {
        return this.f75249u0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Uri D() {
        return this.X;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Integer E() {
        return this.f75236o;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String F() {
        return this.f75238p;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String G() {
        return this.f75240q;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String H() {
        return this.f75251w;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue I() {
        return this.f75216d0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public LatLng J() {
        return this.f75242r;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue K() {
        return this.f75217e0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String L() {
        return this.f75252x;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public NeighborhoodSummary M() {
        return this.f75245s0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public OpeningHours N() {
        return this.f75250v;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue O() {
        return this.f75214c0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public ParkingOptions P() {
        return this.Z;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public PaymentOptions Q() {
        return this.f75210a0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List R() {
        return this.f75253y;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List S() {
        return this.A;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public PlusCode T() {
        return this.B;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Integer U() {
        return this.C;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String W() {
        return this.E;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String X() {
        return this.F;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String Y() {
        return this.G;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue Z() {
        return this.f75239p0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Double a0() {
        return this.H;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue b0() {
        return this.I;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String c0() {
        return this.f75248u;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public AccessibilityOptions d() {
        return this.Y;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue d0() {
        return this.f75229k0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public AddressComponents e() {
        return this.f75215d;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public ReviewSummary e0() {
        return this.f75247t0;
    }

    public final boolean equals(Object obj) {
        OpeningHours openingHours;
        String str;
        String str2;
        Integer num;
        String str3;
        String str4;
        LatLng latLng;
        String str5;
        String str6;
        String str7;
        OpeningHours openingHours2;
        String str8;
        String str9;
        List list;
        List list2;
        List list3;
        PlusCode plusCode;
        Integer num2;
        zzgf zzgfVar;
        String str10;
        String str11;
        String str12;
        Double d3;
        List list4;
        List list5;
        Integer num3;
        Integer num4;
        LatLngBounds latLngBounds;
        Uri uri;
        Uri uri2;
        AccessibilityOptions accessibilityOptions;
        ParkingOptions parkingOptions;
        PaymentOptions paymentOptions;
        EVChargeOptions eVChargeOptions;
        List list6;
        FuelOptions fuelOptions;
        GenerativeSummary generativeSummary;
        EvChargeAmenitySummary evChargeAmenitySummary;
        NeighborhoodSummary neighborhoodSummary;
        ReviewSummary reviewSummary;
        GoogleMapsLinks googleMapsLinks;
        if (obj == this) {
            return true;
        }
        if (obj instanceof Place) {
            Place place = (Place) obj;
            String str13 = this.f75209a;
            if (str13 != null ? str13.equals(place.v()) : place.v() == null) {
                String str14 = this.f75211b;
                if (str14 != null ? str14.equals(place.r0()) : place.r0() == null) {
                    String str15 = this.f75213c;
                    if (str15 != null ? str15.equals(place.f()) : place.f() == null) {
                        AddressComponents addressComponents = this.f75215d;
                        if (addressComponents != null ? addressComponents.equals(place.e()) : place.e() == null) {
                            List list7 = this.f75218f;
                            if (list7 != null ? list7.equals(place.h()) : place.h() == null) {
                                Place.BusinessStatus businessStatus = this.f75220g;
                                if (businessStatus != null ? businessStatus.equals(place.i()) : place.i() == null) {
                                    ConsumerAlert consumerAlert = this.f75222h;
                                    if (consumerAlert != null ? consumerAlert.equals(place.j()) : place.j() == null) {
                                        if (this.f75224i.equals(place.k()) && ((openingHours = this.f75226j) != null ? openingHours.equals(place.l()) : place.l() == null) && this.f75228k.equals(place.n()) && this.f75230l.equals(place.o()) && ((str = this.f75232m) != null ? str.equals(place.r()) : place.r() == null) && ((str2 = this.f75234n) != null ? str2.equals(place.s()) : place.s() == null) && ((num = this.f75236o) != null ? num.equals(place.E()) : place.E() == null) && ((str3 = this.f75238p) != null ? str3.equals(place.F()) : place.F() == null) && ((str4 = this.f75240q) != null ? str4.equals(place.G()) : place.G() == null) && ((latLng = this.f75242r) != null ? latLng.equals(place.J()) : place.J() == null) && ((str5 = this.f75244s) != null ? str5.equals(place.p()) : place.p() == null) && ((str6 = this.f75246t) != null ? str6.equals(place.q()) : place.q() == null) && ((str7 = this.f75248u) != null ? str7.equals(place.c0()) : place.c0() == null) && ((openingHours2 = this.f75250v) != null ? openingHours2.equals(place.N()) : place.N() == null) && ((str8 = this.f75251w) != null ? str8.equals(place.H()) : place.H() == null) && ((str9 = this.f75252x) != null ? str9.equals(place.L()) : place.L() == null) && ((list = this.f75253y) != null ? list.equals(place.R()) : place.R() == null) && ((list2 = this.f75254z) != null ? list2.equals(place.f0()) : place.f0() == null) && ((list3 = this.A) != null ? list3.equals(place.S()) : place.S() == null) && ((plusCode = this.B) != null ? plusCode.equals(place.T()) : place.T() == null) && ((num2 = this.C) != null ? num2.equals(place.U()) : place.U() == null) && ((zzgfVar = this.D) != null ? zzgfVar.equals(place.y0()) : place.y0() == null) && ((str10 = this.E) != null ? str10.equals(place.W()) : place.W() == null) && ((str11 = this.F) != null ? str11.equals(place.X()) : place.X() == null) && ((str12 = this.G) != null ? str12.equals(place.Y()) : place.Y() == null) && ((d3 = this.H) != null ? d3.equals(place.a0()) : place.a0() == null) && this.I.equals(place.b0()) && ((list4 = this.J) != null ? list4.equals(place.g0()) : place.g0() == null) && ((list5 = this.K) != null ? list5.equals(place.m()) : place.m() == null) && this.L.equals(place.h0()) && this.M.equals(place.i0()) && this.N.equals(place.j0()) && this.O.equals(place.n0()) && this.P.equals(place.o0()) && this.Q.equals(place.p0()) && this.R.equals(place.q0()) && this.S.equals(place.t0()) && ((num3 = this.T) != null ? num3.equals(place.u0()) : place.u0() == null) && ((num4 = this.U) != null ? num4.equals(place.v0()) : place.v0() == null) && ((latLngBounds = this.V) != null ? latLngBounds.equals(place.w0()) : place.w0() == null) && ((uri = this.W) != null ? uri.equals(place.x0()) : place.x0() == null) && ((uri2 = this.X) != null ? uri2.equals(place.D()) : place.D() == null) && ((accessibilityOptions = this.Y) != null ? accessibilityOptions.equals(place.d()) : place.d() == null) && ((parkingOptions = this.Z) != null ? parkingOptions.equals(place.P()) : place.P() == null) && ((paymentOptions = this.f75210a0) != null ? paymentOptions.equals(place.Q()) : place.Q() == null) && ((eVChargeOptions = this.f75212b0) != null ? eVChargeOptions.equals(place.u()) : place.u() == null) && this.f75214c0.equals(place.O()) && this.f75216d0.equals(place.I()) && this.f75217e0.equals(place.K()) && this.f75219f0.equals(place.k0()) && this.f75221g0.equals(place.m0()) && this.f75223h0.equals(place.l0()) && this.f75225i0.equals(place.y()) && this.f75227j0.equals(place.g()) && this.f75229k0.equals(place.d0()) && this.f75231l0.equals(place.A()) && this.f75233m0.equals(place.B()) && ((list6 = this.f75235n0) != null ? list6.equals(place.s0()) : place.s0() == null) && ((fuelOptions = this.f75237o0) != null ? fuelOptions.equals(place.w()) : place.w() == null) && this.f75239p0.equals(place.Z()) && ((generativeSummary = this.f75241q0) != null ? generativeSummary.equals(place.x()) : place.x() == null) && ((evChargeAmenitySummary = this.f75243r0) != null ? evChargeAmenitySummary.equals(place.t()) : place.t() == null) && ((neighborhoodSummary = this.f75245s0) != null ? neighborhoodSummary.equals(place.M()) : place.M() == null) && ((reviewSummary = this.f75247t0) != null ? reviewSummary.equals(place.e0()) : place.e0() == null) && ((googleMapsLinks = this.f75249u0) != null ? googleMapsLinks.equals(place.C()) : place.C() == null)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String f() {
        return this.f75213c;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List f0() {
        return this.f75254z;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue g() {
        return this.f75227j0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List g0() {
        return this.J;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List h() {
        return this.f75218f;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue h0() {
        return this.L;
    }

    public final int hashCode() {
        String str = this.f75209a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75211b;
        int iHashCode2 = str2 == null ? 0 : str2.hashCode();
        int i3 = iHashCode ^ 1000003;
        String str3 = this.f75213c;
        int iHashCode3 = ((((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        AddressComponents addressComponents = this.f75215d;
        int iHashCode4 = (iHashCode3 ^ (addressComponents == null ? 0 : addressComponents.hashCode())) * 1000003;
        List list = this.f75218f;
        int iHashCode5 = (iHashCode4 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        Place.BusinessStatus businessStatus = this.f75220g;
        int iHashCode6 = (iHashCode5 ^ (businessStatus == null ? 0 : businessStatus.hashCode())) * 1000003;
        ConsumerAlert consumerAlert = this.f75222h;
        int iHashCode7 = (((iHashCode6 ^ (consumerAlert == null ? 0 : consumerAlert.hashCode())) * 1000003) ^ this.f75224i.hashCode()) * 1000003;
        OpeningHours openingHours = this.f75226j;
        int iHashCode8 = (((((iHashCode7 ^ (openingHours == null ? 0 : openingHours.hashCode())) * 1000003) ^ this.f75228k.hashCode()) * 1000003) ^ this.f75230l.hashCode()) * 1000003;
        String str4 = this.f75232m;
        int iHashCode9 = (iHashCode8 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f75234n;
        int iHashCode10 = (iHashCode9 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        Integer num = this.f75236o;
        int iHashCode11 = (iHashCode10 ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str6 = this.f75238p;
        int iHashCode12 = (iHashCode11 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f75240q;
        int iHashCode13 = (iHashCode12 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        LatLng latLng = this.f75242r;
        int iHashCode14 = (iHashCode13 ^ (latLng == null ? 0 : latLng.hashCode())) * 1000003;
        String str8 = this.f75244s;
        int iHashCode15 = (iHashCode14 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f75246t;
        int iHashCode16 = (iHashCode15 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f75248u;
        int iHashCode17 = (iHashCode16 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        OpeningHours openingHours2 = this.f75250v;
        int iHashCode18 = (iHashCode17 ^ (openingHours2 == null ? 0 : openingHours2.hashCode())) * 1000003;
        String str11 = this.f75251w;
        int iHashCode19 = (iHashCode18 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
        String str12 = this.f75252x;
        int iHashCode20 = (iHashCode19 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003;
        List list2 = this.f75253y;
        int iHashCode21 = (iHashCode20 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        List list3 = this.f75254z;
        int iHashCode22 = (iHashCode21 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
        List list4 = this.A;
        int iHashCode23 = (iHashCode22 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
        PlusCode plusCode = this.B;
        int iHashCode24 = (iHashCode23 ^ (plusCode == null ? 0 : plusCode.hashCode())) * 1000003;
        Integer num2 = this.C;
        int iHashCode25 = (iHashCode24 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
        zzgf zzgfVar = this.D;
        int iHashCode26 = (iHashCode25 ^ (zzgfVar == null ? 0 : zzgfVar.hashCode())) * 1000003;
        String str13 = this.E;
        int iHashCode27 = (iHashCode26 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
        String str14 = this.F;
        int iHashCode28 = (iHashCode27 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
        String str15 = this.G;
        int iHashCode29 = (iHashCode28 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
        Double d3 = this.H;
        int iHashCode30 = (((iHashCode29 ^ (d3 == null ? 0 : d3.hashCode())) * 1000003) ^ this.I.hashCode()) * 1000003;
        List list5 = this.J;
        int iHashCode31 = (iHashCode30 ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
        List list6 = this.K;
        int iHashCode32 = (((((((((((((((((iHashCode31 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003) ^ this.L.hashCode()) * 1000003) ^ this.M.hashCode()) * 1000003) ^ this.N.hashCode()) * 1000003) ^ this.O.hashCode()) * 1000003) ^ this.P.hashCode()) * 1000003) ^ this.Q.hashCode()) * 1000003) ^ this.R.hashCode()) * 1000003) ^ this.S.hashCode()) * 1000003;
        Integer num3 = this.T;
        int iHashCode33 = (iHashCode32 ^ (num3 == null ? 0 : num3.hashCode())) * 1000003;
        Integer num4 = this.U;
        int iHashCode34 = (iHashCode33 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
        LatLngBounds latLngBounds = this.V;
        int iHashCode35 = (iHashCode34 ^ (latLngBounds == null ? 0 : latLngBounds.hashCode())) * 1000003;
        Uri uri = this.W;
        int iHashCode36 = (iHashCode35 ^ (uri == null ? 0 : uri.hashCode())) * 1000003;
        Uri uri2 = this.X;
        int iHashCode37 = (iHashCode36 ^ (uri2 == null ? 0 : uri2.hashCode())) * 1000003;
        AccessibilityOptions accessibilityOptions = this.Y;
        int iHashCode38 = (iHashCode37 ^ (accessibilityOptions == null ? 0 : accessibilityOptions.hashCode())) * 1000003;
        ParkingOptions parkingOptions = this.Z;
        int iHashCode39 = (iHashCode38 ^ (parkingOptions == null ? 0 : parkingOptions.hashCode())) * 1000003;
        PaymentOptions paymentOptions = this.f75210a0;
        int iHashCode40 = (iHashCode39 ^ (paymentOptions == null ? 0 : paymentOptions.hashCode())) * 1000003;
        EVChargeOptions eVChargeOptions = this.f75212b0;
        int iHashCode41 = (((((((((((((((((((((((iHashCode40 ^ (eVChargeOptions == null ? 0 : eVChargeOptions.hashCode())) * 1000003) ^ this.f75214c0.hashCode()) * 1000003) ^ this.f75216d0.hashCode()) * 1000003) ^ this.f75217e0.hashCode()) * 1000003) ^ this.f75219f0.hashCode()) * 1000003) ^ this.f75221g0.hashCode()) * 1000003) ^ this.f75223h0.hashCode()) * 1000003) ^ this.f75225i0.hashCode()) * 1000003) ^ this.f75227j0.hashCode()) * 1000003) ^ this.f75229k0.hashCode()) * 1000003) ^ this.f75231l0.hashCode()) * 1000003) ^ this.f75233m0.hashCode()) * 1000003;
        List list7 = this.f75235n0;
        int iHashCode42 = (iHashCode41 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
        FuelOptions fuelOptions = this.f75237o0;
        int iHashCode43 = (((iHashCode42 ^ (fuelOptions == null ? 0 : fuelOptions.hashCode())) * 1000003) ^ this.f75239p0.hashCode()) * 1000003;
        GenerativeSummary generativeSummary = this.f75241q0;
        int iHashCode44 = (iHashCode43 ^ (generativeSummary == null ? 0 : generativeSummary.hashCode())) * 1000003;
        EvChargeAmenitySummary evChargeAmenitySummary = this.f75243r0;
        int iHashCode45 = (iHashCode44 ^ (evChargeAmenitySummary == null ? 0 : evChargeAmenitySummary.hashCode())) * 1000003;
        NeighborhoodSummary neighborhoodSummary = this.f75245s0;
        int iHashCode46 = (iHashCode45 ^ (neighborhoodSummary == null ? 0 : neighborhoodSummary.hashCode())) * 1000003;
        ReviewSummary reviewSummary = this.f75247t0;
        int iHashCode47 = (iHashCode46 ^ (reviewSummary == null ? 0 : reviewSummary.hashCode())) * 1000003;
        GoogleMapsLinks googleMapsLinks = this.f75249u0;
        return iHashCode47 ^ (googleMapsLinks != null ? googleMapsLinks.hashCode() : 0);
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BusinessStatus i() {
        return this.f75220g;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue i0() {
        return this.M;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public ConsumerAlert j() {
        return this.f75222h;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue j0() {
        return this.N;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue k() {
        return this.f75224i;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue k0() {
        return this.f75219f0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public OpeningHours l() {
        return this.f75226j;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue l0() {
        return this.f75223h0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List m() {
        return this.K;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue m0() {
        return this.f75221g0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue n() {
        return this.f75228k;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue n0() {
        return this.O;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue o() {
        return this.f75230l;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue o0() {
        return this.P;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String p() {
        return this.f75244s;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue p0() {
        return this.Q;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String q() {
        return this.f75246t;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue q0() {
        return this.R;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String r() {
        return this.f75232m;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String r0() {
        return this.f75211b;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String s() {
        return this.f75234n;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public List s0() {
        return this.f75235n0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public EvChargeAmenitySummary t() {
        return this.f75243r0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue t0() {
        return this.S;
    }

    public final String toString() {
        List list = this.K;
        List list2 = this.J;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue = this.I;
        zzgf zzgfVar = this.D;
        PlusCode plusCode = this.B;
        List list3 = this.A;
        List list4 = this.f75254z;
        List list5 = this.f75253y;
        OpeningHours openingHours = this.f75250v;
        LatLng latLng = this.f75242r;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue2 = this.f75230l;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue3 = this.f75228k;
        OpeningHours openingHours2 = this.f75226j;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue4 = this.f75224i;
        ConsumerAlert consumerAlert = this.f75222h;
        Place.BusinessStatus businessStatus = this.f75220g;
        String strValueOf = String.valueOf(this.f75215d);
        String strValueOf2 = String.valueOf(this.f75218f);
        String strValueOf3 = String.valueOf(businessStatus);
        String strValueOf4 = String.valueOf(consumerAlert);
        String string = booleanPlaceAttributeValue4.toString();
        String strValueOf5 = String.valueOf(openingHours2);
        String string2 = booleanPlaceAttributeValue3.toString();
        String string3 = booleanPlaceAttributeValue2.toString();
        String strValueOf6 = String.valueOf(latLng);
        String strValueOf7 = String.valueOf(openingHours);
        String strValueOf8 = String.valueOf(list5);
        String strValueOf9 = String.valueOf(list4);
        String strValueOf10 = String.valueOf(list3);
        String strValueOf11 = String.valueOf(plusCode);
        String strValueOf12 = String.valueOf(zzgfVar);
        String string4 = booleanPlaceAttributeValue.toString();
        String strValueOf13 = String.valueOf(list2);
        String strValueOf14 = String.valueOf(list);
        GoogleMapsLinks googleMapsLinks = this.f75249u0;
        ReviewSummary reviewSummary = this.f75247t0;
        NeighborhoodSummary neighborhoodSummary = this.f75245s0;
        EvChargeAmenitySummary evChargeAmenitySummary = this.f75243r0;
        GenerativeSummary generativeSummary = this.f75241q0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue5 = this.f75239p0;
        FuelOptions fuelOptions = this.f75237o0;
        List list6 = this.f75235n0;
        String str = this.f75209a;
        String str2 = this.f75211b;
        String str3 = this.f75213c;
        String str4 = this.f75232m;
        String str5 = this.f75234n;
        Integer num = this.f75236o;
        String str6 = this.f75238p;
        String str7 = this.f75240q;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue6 = this.L;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue7 = this.M;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue8 = this.N;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue9 = this.O;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue10 = this.P;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue11 = this.Q;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue12 = this.R;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue13 = this.S;
        LatLngBounds latLngBounds = this.V;
        Uri uri = this.W;
        Uri uri2 = this.X;
        AccessibilityOptions accessibilityOptions = this.Y;
        ParkingOptions parkingOptions = this.Z;
        PaymentOptions paymentOptions = this.f75210a0;
        EVChargeOptions eVChargeOptions = this.f75212b0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue14 = this.f75214c0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue15 = this.f75216d0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue16 = this.f75217e0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue17 = this.f75219f0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue18 = this.f75221g0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue19 = this.f75223h0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue20 = this.f75225i0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue21 = this.f75227j0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue22 = this.f75229k0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue23 = this.f75231l0;
        Place.BooleanPlaceAttributeValue booleanPlaceAttributeValue24 = this.f75233m0;
        String string5 = booleanPlaceAttributeValue6.toString();
        String string6 = booleanPlaceAttributeValue7.toString();
        String string7 = booleanPlaceAttributeValue8.toString();
        String string8 = booleanPlaceAttributeValue9.toString();
        String string9 = booleanPlaceAttributeValue10.toString();
        String string10 = booleanPlaceAttributeValue11.toString();
        String string11 = booleanPlaceAttributeValue12.toString();
        String string12 = booleanPlaceAttributeValue13.toString();
        String strValueOf15 = String.valueOf(latLngBounds);
        String strValueOf16 = String.valueOf(uri);
        String strValueOf17 = String.valueOf(uri2);
        String strValueOf18 = String.valueOf(accessibilityOptions);
        String strValueOf19 = String.valueOf(parkingOptions);
        String strValueOf20 = String.valueOf(paymentOptions);
        String strValueOf21 = String.valueOf(eVChargeOptions);
        String string13 = booleanPlaceAttributeValue14.toString();
        String string14 = booleanPlaceAttributeValue15.toString();
        String string15 = booleanPlaceAttributeValue16.toString();
        String string16 = booleanPlaceAttributeValue17.toString();
        String string17 = booleanPlaceAttributeValue18.toString();
        String string18 = booleanPlaceAttributeValue19.toString();
        String string19 = booleanPlaceAttributeValue20.toString();
        String string20 = booleanPlaceAttributeValue21.toString();
        String string21 = booleanPlaceAttributeValue22.toString();
        String string22 = booleanPlaceAttributeValue23.toString();
        String string23 = booleanPlaceAttributeValue24.toString();
        String strValueOf22 = String.valueOf(list6);
        String strValueOf23 = String.valueOf(fuelOptions);
        String string24 = booleanPlaceAttributeValue5.toString();
        String strValueOf24 = String.valueOf(generativeSummary);
        String strValueOf25 = String.valueOf(evChargeAmenitySummary);
        String strValueOf26 = String.valueOf(neighborhoodSummary);
        String strValueOf27 = String.valueOf(reviewSummary);
        String strValueOf28 = String.valueOf(googleMapsLinks);
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(str2).length();
        int length3 = String.valueOf(str3).length();
        int length4 = strValueOf.length();
        int length5 = strValueOf2.length();
        int length6 = strValueOf3.length();
        int length7 = strValueOf4.length();
        int length8 = string.length();
        int length9 = strValueOf5.length();
        int length10 = string2.length();
        int length11 = string3.length();
        int length12 = String.valueOf(str4).length();
        int length13 = String.valueOf(str5).length();
        int length14 = String.valueOf(num).length();
        int length15 = String.valueOf(str6).length();
        Double d3 = this.H;
        String str8 = this.G;
        String str9 = this.F;
        String str10 = this.E;
        Integer num2 = this.C;
        String str11 = this.f75252x;
        String str12 = this.f75251w;
        String str13 = this.f75248u;
        String str14 = this.f75246t;
        String str15 = this.f75244s;
        int length16 = length + 47 + length2 + 19 + length3 + 20 + length4 + 15 + length5 + 17 + length6 + 16 + length7 + 17 + length8 + 22 + length9 + 11 + length10 + 9 + length11 + 19 + length12 + 31 + length13 + 22 + length14 + 14 + length15 + 5 + String.valueOf(str7).length();
        int length17 = strValueOf6.length();
        int length18 = String.valueOf(str15).length();
        int length19 = String.valueOf(str14).length();
        int length20 = String.valueOf(str13).length();
        int length21 = strValueOf7.length();
        int length22 = String.valueOf(str12).length();
        int length23 = String.valueOf(str11).length();
        int length24 = strValueOf8.length();
        int length25 = strValueOf9.length();
        int length26 = strValueOf10.length();
        int length27 = strValueOf11.length();
        int length28 = String.valueOf(num2).length();
        int length29 = strValueOf12.length();
        int length30 = String.valueOf(str10).length();
        int length31 = String.valueOf(str9).length();
        int length32 = String.valueOf(str8).length();
        int length33 = String.valueOf(d3).length();
        int length34 = string4.length();
        int length35 = strValueOf13.length();
        int length36 = strValueOf14.length();
        int length37 = string5.length();
        int length38 = string6.length();
        int length39 = string7.length();
        int length40 = string8.length();
        int length41 = string9.length();
        int length42 = string10.length();
        int length43 = string11.length();
        int length44 = string12.length();
        Integer num3 = this.U;
        Integer num4 = this.T;
        StringBuilder sb = new StringBuilder(length16 + 11 + length17 + 14 + length18 + 26 + length19 + 15 + length20 + 15 + length21 + 27 + length22 + 22 + length23 + 17 + length24 + 10 + length25 + 13 + length26 + 11 + length27 + 13 + length28 + 13 + length29 + 14 + length30 + 25 + length31 + 37 + length32 + 9 + length33 + 13 + length34 + 24 + length35 + 31 + length36 + 13 + length37 + 18 + length38 + 15 + length39 + 15 + length40 + 14 + length41 + 23 + length42 + 13 + length43 + 10 + length44 + 18 + String.valueOf(num4).length() + 19 + String.valueOf(num3).length() + 11 + strValueOf15.length() + 13 + strValueOf16.length() + 16 + strValueOf17.length() + 23 + strValueOf18.length() + 17 + strValueOf19.length() + 17 + strValueOf20.length() + 18 + strValueOf21.length() + 17 + string13.length() + 12 + string14.length() + 18 + string15.length() + 18 + string16.length() + 16 + string17.length() + 15 + string18.length() + 18 + string19.length() + 13 + string20.length() + 11 + string21.length() + 16 + string22.length() + 24 + string23.length() + 18 + strValueOf22.length() + 14 + strValueOf23.length() + 26 + string24.length() + 20 + strValueOf24.length() + 25 + strValueOf25.length() + 22 + strValueOf26.length() + 16 + strValueOf27.length() + 18 + strValueOf28.length() + 1);
        sb.append("Place{formattedAddress=");
        sb.append(str);
        sb.append(", shortFormattedAddress=");
        sb.append(str2);
        sb.append(", adrFormatAddress=");
        sb.append(str3);
        sb.append(", addressComponents=");
        sb.append(strValueOf);
        sb.append(", attributions=");
        sb.append(strValueOf2);
        sb.append(", businessStatus=");
        sb.append(strValueOf3);
        sb.append(", consumerAlert=");
        sb.append(strValueOf4);
        sb.append(", curbsidePickup=");
        sb.append(string);
        sb.append(", currentOpeningHours=");
        sb.append(strValueOf5);
        sb.append(", delivery=");
        sb.append(string2);
        sb.append(", dineIn=");
        sb.append(string3);
        sb.append(", editorialSummary=");
        sb.append(str4);
        sb.append(", editorialSummaryLanguageCode=");
        sb.append(str5);
        sb.append(", iconBackgroundColor=");
        sb.append(num);
        sb.append(", iconMaskUrl=");
        sb.append(str6);
        sb.append(", id=");
        sb.append(str7);
        sb.append(", location=");
        sb.append(strValueOf6);
        sb.append(", displayName=");
        sb.append(str15);
        sb.append(", displayNameLanguageCode=");
        sb.append(str14);
        sb.append(", resourceName=");
        sb.append(str13);
        sb.append(", openingHours=");
        sb.append(strValueOf7);
        sb.append(", internationalPhoneNumber=");
        sb.append(str12);
        sb.append(", nationalPhoneNumber=");
        sb.append(str11);
        sb.append(", photoMetadatas=");
        sb.append(strValueOf8);
        sb.append(", reviews=");
        sb.append(strValueOf9);
        sb.append(", placeTypes=");
        sb.append(strValueOf10);
        sb.append(", plusCode=");
        sb.append(strValueOf11);
        sb.append(", priceLevel=");
        sb.append(num2);
        sb.append(", priceRange=");
        sb.append(strValueOf12);
        sb.append(", primaryType=");
        sb.append(str10);
        sb.append(", primaryTypeDisplayName=");
        sb.append(str9);
        sb.append(", primaryTypeDisplayNameLanguageCode=");
        sb.append(str8);
        sb.append(", rating=");
        sb.append(d3);
        sb.append(", reservable=");
        sb.append(string4);
        sb.append(", secondaryOpeningHours=");
        sb.append(strValueOf13);
        sb.append(", currentSecondaryOpeningHours=");
        sb.append(strValueOf14);
        sb.append(", servesBeer=");
        sb.append(string5);
        sb.append(", servesBreakfast=");
        sb.append(string6);
        sb.append(", servesBrunch=");
        sb.append(string7);
        sb.append(", servesDinner=");
        sb.append(string8);
        sb.append(", servesLunch=");
        sb.append(string9);
        sb.append(", servesVegetarianFood=");
        sb.append(string10);
        sb.append(", servesWine=");
        sb.append(string11);
        sb.append(", takeout=");
        sb.append(string12);
        sb.append(", userRatingCount=");
        sb.append(num4);
        sb.append(", utcOffsetMinutes=");
        sb.append(num3);
        sb.append(", viewport=");
        sb.append(strValueOf15);
        sb.append(", websiteUri=");
        sb.append(strValueOf16);
        sb.append(", googleMapsUri=");
        sb.append(strValueOf17);
        sb.append(", accessibilityOptions=");
        sb.append(strValueOf18);
        sb.append(", parkingOptions=");
        sb.append(strValueOf19);
        sb.append(", paymentOptions=");
        sb.append(strValueOf20);
        sb.append(", evChargeOptions=");
        sb.append(strValueOf21);
        sb.append(", outdoorSeating=");
        sb.append(string13);
        sb.append(", liveMusic=");
        sb.append(string14);
        sb.append(", menuForChildren=");
        sb.append(string15);
        sb.append(", servesCocktails=");
        sb.append(string16);
        sb.append(", servesDessert=");
        sb.append(string17);
        sb.append(", servesCoffee=");
        sb.append(string18);
        sb.append(", goodForChildren=");
        sb.append(string19);
        sb.append(", allowsDogs=");
        sb.append(string20);
        sb.append(", restroom=");
        sb.append(string21);
        sb.append(", goodForGroups=");
        sb.append(string22);
        sb.append(", goodForWatchingSports=");
        sb.append(string23);
        sb.append(", subDestinations=");
        sb.append(strValueOf22);
        sb.append(", fuelOptions=");
        sb.append(strValueOf23);
        sb.append(", pureServiceAreaBusiness=");
        sb.append(string24);
        sb.append(", generativeSummary=");
        sb.append(strValueOf24);
        sb.append(", evChargeAmenitySummary=");
        sb.append(strValueOf25);
        sb.append(", neighborhoodSummary=");
        sb.append(strValueOf26);
        sb.append(", reviewSummary=");
        sb.append(strValueOf27);
        sb.append(", googleMapsLinks=");
        sb.append(strValueOf28);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public EVChargeOptions u() {
        return this.f75212b0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Integer u0() {
        return this.T;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public String v() {
        return this.f75209a;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Integer v0() {
        return this.U;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public FuelOptions w() {
        return this.f75237o0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public LatLngBounds w0() {
        return this.V;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public GenerativeSummary x() {
        return this.f75241q0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Uri x0() {
        return this.W;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public Place.BooleanPlaceAttributeValue y() {
        return this.f75225i0;
    }

    @Override // com.google.android.libraries.places.api.model.Place
    public final zzgf y0() {
        return this.D;
    }
}
