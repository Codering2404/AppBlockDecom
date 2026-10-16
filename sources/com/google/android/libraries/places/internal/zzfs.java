package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.EVConnectorType;
import com.google.android.libraries.places.api.model.EVSearchOptions;
import com.google.android.libraries.places.api.model.RouteModifiers;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzfs implements zzmo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zznf f77836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzmz f77837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzmp f77838c;

    zzfs(zznf zznfVar, zzmz zzmzVar, zzmp zzmpVar) {
        this.f77836a = zznfVar;
        this.f77837b = zzmzVar;
        this.f77838c = zzmpVar;
    }

    static final int p(Task task) {
        if (task.isSuccessful()) {
            return 2;
        }
        Exception exc = (Exception) Preconditions.t(task.getException());
        int statusCode = (exc instanceof ApiException ? (ApiException) exc : new ApiException(new Status(13, exc.getMessage()))).getStatusCode();
        if (statusCode != 7) {
            return statusCode != 15 ? 1 : 3;
        }
        return 4;
    }

    private final zzapt q() {
        Locale localeD = this.f77838c.d();
        Locale locale = Locale.getDefault();
        zzapt zzaptVarG = zzapv.G();
        zzaptVarG.y(localeD.toLanguageTag());
        if (!localeD.equals(locale)) {
            zzaptVarG.z(locale.toLanguageTag());
        }
        return zzaptVarG;
    }

    private final void r(zzalz zzalzVar, zzmy zzmyVar) {
        t(zzalzVar, 2, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
    }

    private static final zzaqu s(RoutingParameters routingParameters) {
        zzaqt zzaqtVarG = zzaqu.G();
        RoutingParameters.TravelMode travelModeF = routingParameters.f();
        int i3 = 4;
        if (travelModeF != null) {
            EVConnectorType eVConnectorType = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
            RoutingParameters.RoutingPreference routingPreference = RoutingParameters.RoutingPreference.ROUTING_PREFERENCE_UNSPECIFIED;
            int iOrdinal = travelModeF.ordinal();
            zzaqtVarG.z(iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? 1 : 5 : 4 : 3 : 2);
        }
        RouteModifiers routeModifiersD = routingParameters.d();
        if (routeModifiersD != null) {
            zzaqr zzaqrVarG = zzaqs.G();
            zzaqrVarG.y(routeModifiersD.f());
            zzaqrVarG.z(routeModifiersD.d());
            zzaqrVarG.A(routeModifiersD.c());
            zzaqrVarG.B(routeModifiersD.e());
            zzaqtVarG.y((zzaqs) zzaqrVarG.zzG());
        }
        RoutingParameters.RoutingPreference routingPreferenceE = routingParameters.e();
        if (routingPreferenceE != null) {
            EVConnectorType eVConnectorType2 = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
            RoutingParameters.TravelMode travelMode = RoutingParameters.TravelMode.TRAVEL_MODE_UNSPECIFIED;
            int iOrdinal2 = routingPreferenceE.ordinal();
            if (iOrdinal2 == 1) {
                i3 = 2;
            } else if (iOrdinal2 == 2) {
                i3 = 3;
            } else if (iOrdinal2 != 3) {
                i3 = 1;
            }
            zzaqtVarG.A(i3);
        }
        return (zzaqu) zzaqtVarG.zzG();
    }

    private final void t(zzalz zzalzVar, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzaoc zzaocVarB = zzng.b(this.f77837b, i3, zzmyVar, zzbVar);
        zzaocVarB.O(16);
        zzaocVarB.E(zzalzVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void a(SearchNearbyRequest searchNearbyRequest, zzmy zzmyVar) {
        zzaqh zzaqhVarG = zzaqj.G();
        zzapo zzapoVarG = zzapp.G();
        zzapoVarG.y(zzjl.a(searchNearbyRequest.i()));
        zzaqhVarG.E((zzapp) zzapoVarG.zzG());
        SearchNearbyRequest.RankPreference rankPreferenceJ = searchNearbyRequest.j();
        zzaqhVarG.H(rankPreferenceJ == null ? 1 : true != rankPreferenceJ.equals(SearchNearbyRequest.RankPreference.DISTANCE) ? 3 : 2);
        zzaqhVarG.G(searchNearbyRequest.m());
        List listF = searchNearbyRequest.f();
        if (listF != null) {
            zzaqhVarG.y(listF);
        }
        List listD = searchNearbyRequest.d();
        if (listD != null) {
            zzaqhVarG.z(listD);
        }
        List listE = searchNearbyRequest.e();
        if (listE != null) {
            zzaqhVarG.A(listE);
        }
        List listC = searchNearbyRequest.c();
        if (listC != null) {
            zzaqhVarG.B(listC);
        }
        Integer numH = searchNearbyRequest.h();
        if (numH != null) {
            zzaqhVarG.D(numH.intValue());
        }
        RoutingParameters routingParametersL = searchNearbyRequest.l();
        if (routingParametersL != null) {
            zzaqhVarG.F(s(routingParametersL));
        }
        zzapt zzaptVarQ = q();
        zzaptVarQ.G(2);
        zzaptVarQ.E((zzaqj) zzaqhVarG.zzG());
        zzapv zzapvVar = (zzapv) zzaptVarQ.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, 3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(1);
        zzaocVarB.z(zzapvVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void b(FindCurrentPlaceRequest findCurrentPlaceRequest, Task task, long j3, long j4, zzmy zzmyVar) {
        int i3 = true == task.isSuccessful() ? 2 : 1;
        zzaou zzaouVarG = zzaow.G();
        zzapo zzapoVarG = zzapp.G();
        zzapoVarG.y(zzlw.a(findCurrentPlaceRequest.c()));
        zzaouVarG.z((zzapp) zzapoVarG.zzG());
        zzaouVarG.y((int) (j4 - j3));
        zzaouVarG.A(i3);
        zzaow zzaowVar = (zzaow) zzaouVarG.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, 2, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(6);
        zzaocVarB.B(zzaowVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void c(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, int i3, zzmy zzmyVar) {
        zzamn zzamnVarG = zzamo.G();
        List listK = findAutocompletePredictionsRequest.k();
        Integer numD = findAutocompletePredictionsRequest.d();
        if (!listK.isEmpty()) {
            Iterator it = listK.iterator();
            while (it.hasNext()) {
                zzamnVarG.y((String) it.next());
            }
        }
        if (numD != null) {
            zzamnVarG.z(numD.intValue());
        }
        zzamo zzamoVar = (zzamo) zzamnVarG.zzG();
        zzanm zzanmVarG = zzann.G();
        if (zzamoVar != null) {
            zzanmVarG.y(zzamoVar);
        }
        zzann zzannVar = (zzann) zzanmVarG.zzG();
        zzapt zzaptVarQ = q();
        zzaptVarQ.G(6);
        zzaptVarQ.B(zzannVar);
        zzapv zzapvVar = (zzapv) zzaptVarQ.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, i3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(1);
        zzaocVarB.z(zzapvVar);
        zzaocVarB.I(this.f77838c.c());
        AutocompleteSessionToken autocompleteSessionTokenJ = findAutocompletePredictionsRequest.j();
        if (autocompleteSessionTokenJ != null) {
            zzaocVarB.G(autocompleteSessionTokenJ.toString());
        }
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void d(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, zzmy zzmyVar) {
        zzapl zzaplVarG = zzapn.G();
        zzaplVarG.y(2);
        zzapn zzapnVar = (zzapn) zzaplVarG.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, 3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(5);
        zzaocVarB.A(zzapnVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void e(Task task, long j3, long j4, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        int size = task.isSuccessful() ? ((FindAutocompletePredictionsResponse) task.getResult()).a().size() : 0;
        zzalh zzalhVarG = zzali.G();
        zzalhVarG.y(size);
        zzali zzaliVar = (zzali) zzalhVarG.zzG();
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(6);
        zzaluVarG.B(zzaliVar);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        t((zzalz) zzaluVarG.zzG(), i3, zzmyVar, zzbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void f(FetchPlaceRequest fetchPlaceRequest, int i3, zzmy zzmyVar) {
        zzaoo zzaooVarG = zzaop.G();
        zzaooVarG.y(1);
        zzapo zzapoVarG = zzapp.G();
        zzapoVarG.y(zzjl.a(fetchPlaceRequest.c()));
        zzaooVarG.z((zzapp) zzapoVarG.zzG());
        zzaop zzaopVar = (zzaop) zzaooVarG.zzG();
        zzapt zzaptVarQ = q();
        zzaptVarQ.G(5);
        zzaptVarQ.F(zzaopVar);
        zzapv zzapvVar = (zzapv) zzaptVarQ.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, i3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(1);
        zzaocVarB.z(zzapvVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void g(Task task, long j3, long j4, int i3, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        boolean zIsSuccessful = task.isSuccessful();
        zzalm zzalmVarG = zzaln.G();
        zzalmVarG.y(1);
        zzalmVarG.z(zIsSuccessful ? 1 : 0);
        zzaln zzalnVar = (zzaln) zzalmVarG.zzG();
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(8);
        zzaluVarG.z(zzalnVar);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        t((zzalz) zzaluVarG.zzG(), i3, zzmyVar, zzbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void h(SearchByTextRequest searchByTextRequest, zzmy zzmyVar) {
        zzala zzalaVar;
        zzaqc zzaqcVarG = zzaqg.G();
        zzaqcVarG.z(searchByTextRequest.p());
        zzapo zzapoVarG = zzapp.G();
        zzapoVarG.y(zzjl.a(searchByTextRequest.i()));
        zzaqcVarG.F((zzapp) zzapoVarG.zzG());
        SearchByTextRequest.RankPreference rankPreferenceK = searchByTextRequest.k();
        zzaqcVarG.L(rankPreferenceK == null ? 1 : true != rankPreferenceK.equals(SearchByTextRequest.RankPreference.DISTANCE) ? 3 : 2);
        zzaqcVarG.E(searchByTextRequest.t());
        zzaqcVarG.I(searchByTextRequest.r());
        zzaqcVarG.K(searchByTextRequest.s());
        String strD = searchByTextRequest.d();
        if (strD != null) {
            zzaqcVarG.y(strD);
        }
        Double dH = searchByTextRequest.h();
        if (dH != null) {
            zzaqcVarG.A(dH.doubleValue());
        }
        Integer numG = searchByTextRequest.g();
        if (numG != null) {
            zzaqcVarG.B(numG.intValue());
        }
        EVSearchOptions eVSearchOptionsC = searchByTextRequest.c();
        if (eVSearchOptionsC != null) {
            zzaqd zzaqdVarG = zzaqe.G();
            Double d3 = eVSearchOptionsC.d();
            if (d3 != null) {
                zzaqdVarG.y(d3.doubleValue());
            }
            List<EVConnectorType> listC = eVSearchOptionsC.c();
            if (listC != null) {
                ArrayList arrayList = new ArrayList();
                for (EVConnectorType eVConnectorType : listC) {
                    EVConnectorType eVConnectorType2 = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
                    RoutingParameters.TravelMode travelMode = RoutingParameters.TravelMode.TRAVEL_MODE_UNSPECIFIED;
                    RoutingParameters.RoutingPreference routingPreference = RoutingParameters.RoutingPreference.ROUTING_PREFERENCE_UNSPECIFIED;
                    int iOrdinal = eVConnectorType.ordinal();
                    if (iOrdinal != 0) {
                        switch (iOrdinal) {
                            case 2:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_J1772;
                                break;
                            case 3:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_TYPE_2;
                                break;
                            case 4:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_CHADEMO;
                                break;
                            case 5:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_CCS_COMBO_1;
                                break;
                            case 6:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_CCS_COMBO_2;
                                break;
                            case 7:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_TESLA;
                                break;
                            case 8:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T;
                                break;
                            case 9:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET;
                                break;
                            case 10:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_NACS;
                                break;
                            default:
                                zzalaVar = zzala.EV_CONNECTOR_TYPE_OTHER;
                                break;
                        }
                    } else {
                        zzalaVar = zzala.EV_CONNECTOR_TYPE_UNSPECIFIED;
                    }
                    arrayList.add(zzalaVar);
                }
                zzaqdVarG.z(arrayList);
            }
            zzaqcVarG.G((zzaqe) zzaqdVarG.zzG());
        }
        RoutingParameters routingParametersM = searchByTextRequest.m();
        if (routingParametersM != null) {
            zzaqcVarG.H(s(routingParametersM));
        }
        zzaqcVarG.J(searchByTextRequest.u() != null);
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : searchByTextRequest.j()) {
            if (num != null) {
                arrayList2.add(num);
            }
        }
        zzaqcVarG.D(arrayList2);
        zzapt zzaptVarQ = q();
        zzaptVarQ.G(2);
        zzaptVarQ.D((zzaqg) zzaqcVarG.zzG());
        zzapv zzapvVar = (zzapv) zzaptVarQ.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, 3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(1);
        zzaocVarB.z(zzapvVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void i(Task task, long j3, long j4, zzmy zzmyVar) {
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(15);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        r((zzalz) zzaluVarG.zzG(), zzmyVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void j(FetchPlaceRequest fetchPlaceRequest, int i3, zzmy zzmyVar) {
        zzaoo zzaooVarG = zzaop.G();
        zzaooVarG.y(1);
        zzapo zzapoVarG = zzapp.G();
        zzapoVarG.y(zzjl.a(fetchPlaceRequest.c()));
        zzaooVarG.z((zzapp) zzapoVarG.zzG());
        zzaop zzaopVar = (zzaop) zzaooVarG.zzG();
        zzapt zzaptVarQ = q();
        zzaptVarQ.G(5);
        zzaptVarQ.A(zzaopVar);
        zzapv zzapvVar = (zzapv) zzaptVarQ.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, i3, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(1);
        zzaocVarB.z(zzapvVar);
        zzaocVarB.I(this.f77838c.c());
        AutocompleteSessionToken autocompleteSessionTokenF = fetchPlaceRequest.f();
        if (autocompleteSessionTokenF != null) {
            zzaocVarB.G(autocompleteSessionTokenF.toString());
        }
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void k(Task task, long j3, long j4, zzmy zzmyVar) {
        int size = task.isSuccessful() ? ((FindCurrentPlaceResponse) task.getResult()).a().size() : 0;
        zzalb zzalbVarG = zzalc.G();
        zzalbVarG.y(size);
        zzalc zzalcVar = (zzalc) zzalbVarG.zzG();
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(4);
        zzaluVarG.A(zzalcVar);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        r((zzalz) zzaluVarG.zzG(), zzmyVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void l(FetchPhotoRequest fetchPhotoRequest, zzmy zzmyVar) {
        zzapl zzaplVarG = zzapn.G();
        zzaplVarG.y(2);
        zzapn zzapnVar = (zzapn) zzaplVarG.zzG();
        zzaoc zzaocVarB = zzng.b(this.f77837b, 2, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        zzaocVarB.O(5);
        zzaocVarB.A(zzapnVar);
        zzaocVarB.I(this.f77838c.c());
        this.f77836a.a(zzaocVarB);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void m(Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(15);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        t((zzalz) zzaluVarG.zzG(), 3, zzmyVar, zzbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void n(SearchNearbyRequest searchNearbyRequest, Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        List listC;
        int size = task.isSuccessful() ? ((SearchNearbyResponse) task.getResult()).b().size() : 0;
        int size2 = (searchNearbyRequest.m() && task.isSuccessful() && (listC = ((SearchNearbyResponse) task.getResult()).c()) != null) ? listC.size() : 0;
        Integer numH = searchNearbyRequest.h();
        zzarg zzargVarG = zzarh.G();
        zzargVarG.y(numH != null ? numH.intValue() : 0);
        zzargVarG.z(size);
        zzargVarG.A(size2);
        zzarh zzarhVar = (zzarh) zzargVarG.zzG();
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(10);
        zzaluVarG.D(zzarhVar);
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        t((zzalz) zzaluVarG.zzG(), 3, zzmyVar, zzbVar);
    }

    @Override // com.google.android.libraries.places.internal.zzmo
    public final void o(SearchByTextRequest searchByTextRequest, Task task, long j3, long j4, zzmy zzmyVar, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        List listD;
        int size = task.isSuccessful() ? ((SearchByTextResponse) task.getResult()).c().size() : 0;
        int size2 = (searchByTextRequest.r() && task.isSuccessful() && (listD = ((SearchByTextResponse) task.getResult()).d()) != null) ? listD.size() : 0;
        Integer numG = searchByTextRequest.g();
        zzarg zzargVarG = zzarh.G();
        zzargVarG.y(numG == null ? 0 : numG.intValue());
        zzargVarG.z(size);
        zzargVarG.A(size2);
        if (task.isSuccessful()) {
            SearchByTextResponse searchByTextResponse = (SearchByTextResponse) task.getResult();
            zzargVarG.B(searchByTextResponse.f() != null);
            zzargVarG.D(searchByTextResponse.g());
        }
        zzalu zzaluVarG = zzalz.G();
        zzaluVarG.E(10);
        zzaluVarG.D((zzarh) zzargVarG.zzG());
        zzaluVarG.F(p(task));
        zzaluVarG.y((int) (j4 - j3));
        t((zzalz) zzaluVarG.zzG(), 3, zzmyVar, zzbVar);
    }
}
