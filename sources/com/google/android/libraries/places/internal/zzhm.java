package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.OpeningHours;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.IsOpenRequest;
import com.google.android.libraries.places.api.net.IsOpenResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzhm implements PlacesClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzfv f77927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzfl f77928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzfq f77929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzmo f77930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzef f77931e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzja f77932f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzfa f77933g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzmp f77934h;

    zzhm(zzmp zzmpVar, zzfv zzfvVar, zzfl zzflVar, zzfq zzfqVar, zzmo zzmoVar, zzef zzefVar, zzja zzjaVar, zzfa zzfaVar) {
        this.f77934h = zzmpVar;
        this.f77927a = zzfvVar;
        this.f77928b = zzflVar;
        this.f77929c = zzfqVar;
        this.f77930d = zzmoVar;
        this.f77931e = zzefVar;
        this.f77932f = zzjaVar;
        this.f77933g = zzfaVar;
        zzfaVar.zza();
    }

    private static void u(zzfi zzfiVar, zzfj zzfjVar) {
        zzfi.b(zzfiVar, zzfi.a("Duration"));
        zzek.a();
        zzek.a();
        zzfi.b(zzfiVar, zzfi.a("Battery"));
        zzek.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Task v(Task task) {
        Exception exception = task.getException();
        if (exception != null) {
            return Tasks.forException(exception instanceof ApiException ? (ApiException) exception : exception instanceof zzbns ? zzfu.b((zzbns) exception) : ((exception instanceof ExecutionException) && (exception.getCause() instanceof zzbns)) ? zzfu.b((zzbns) exception.getCause()) : new ApiException(new Status(13, exception.toString())));
        }
        return task;
    }

    final /* synthetic */ FetchPhotoResponse B(FetchPhotoRequest fetchPhotoRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.l(fetchPhotoRequest, zzmyVar);
        u(zzfi.a("FetchPhoto"), zzfjVar);
        return (FetchPhotoResponse) task.getResult();
    }

    final /* synthetic */ FetchResolvedPhotoUriResponse D(FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.d(fetchResolvedPhotoUriRequest, zzmyVar);
        u(zzfi.a("GetPhotoMedia"), zzfjVar);
        return (FetchResolvedPhotoUriResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse F(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.j(fetchPlaceRequest, 2, zzmyVar);
        u(zzfi.a("FetchPlace"), zzfjVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse H(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.j(fetchPlaceRequest, 3, zzmyVar);
        u(zzfi.a("GetPlace"), zzfjVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ Task J(FindCurrentPlaceRequest findCurrentPlaceRequest, String str, zzmy zzmyVar, Location location) {
        Preconditions.u(location, "Location must not be null.");
        return this.f77927a.c(findCurrentPlaceRequest, location, this.f77929c.a(null), zzmyVar);
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task a(final FetchPhotoRequest fetchPhotoRequest, final zzmy zzmyVar) {
        try {
            Preconditions.u(fetchPhotoRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return this.f77927a.a(fetchPhotoRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhe
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77904a.B(fetchPhotoRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzhf.f77908a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task b(final FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, final zzmy zzmyVar) throws Throwable {
        try {
            Preconditions.u(findAutocompletePredictionsRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            if (!zzmyVar.equals(zzmy.PLACES_UI_KIT) && !zzmyVar.equals(zzmy.ONE_PLATFORM_AUTOCOMPLETE_WIDGET) && (!this.f77934h.e() || zzmyVar.equals(zzmy.AUTOCOMPLETE_WIDGET))) {
                return this.f77927a.b(findAutocompletePredictionsRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhl
                    @Override // com.google.android.gms.tasks.Continuation
                    public final /* synthetic */ Object then(Task task) {
                        return this.f77923a.x(findAutocompletePredictionsRequest, zzmyVar, zzfjVarA, task);
                    }
                }).continueWithTask(zzgn.f77862a);
            }
            return this.f77932f.b(findAutocompletePredictionsRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgy
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77889a.z(findAutocompletePredictionsRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzhd.f77903a);
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task c(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest) {
        return b(findAutocompletePredictionsRequest, zzmy.PROGRAMMATIC_API);
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task d(final SearchByTextRequest searchByTextRequest, final zzmy zzmyVar) {
        try {
            Preconditions.u(searchByTextRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return this.f77932f.a(searchByTextRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgz
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77893a.q(searchByTextRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzha.f77897a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task e(IsOpenRequest isOpenRequest, final zzmy zzmyVar) throws Throwable {
        List arrayList;
        try {
            Preconditions.u(isOpenRequest, "Request must not be null.");
            final Place placeF = isOpenRequest.f();
            String strG = isOpenRequest.g();
            final long jH = isOpenRequest.h();
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            if (placeF == null) {
                int i3 = com.google.android.libraries.places.api.model.zzga.f75348c;
                arrayList = Arrays.asList(Place.Field.BUSINESS_STATUS, Place.Field.CURRENT_OPENING_HOURS, Place.Field.OPENING_HOURS, Place.Field.UTC_OFFSET);
            } else {
                int i4 = com.google.android.libraries.places.api.model.zzga.f75348c;
                arrayList = new ArrayList();
                Place.BusinessStatus businessStatusI = placeF.i();
                if (businessStatusI == null || businessStatusI == Place.BusinessStatus.OPERATIONAL) {
                    if (businessStatusI == null) {
                        arrayList.add(Place.Field.BUSINESS_STATUS);
                    }
                    if (placeF.l() == null) {
                        arrayList.add(Place.Field.CURRENT_OPENING_HOURS);
                    }
                    if (placeF.N() == null) {
                        arrayList.add(Place.Field.OPENING_HOURS);
                    }
                    if (placeF.v0() == null) {
                        arrayList.add(Place.Field.UTC_OFFSET);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                taskCompletionSource.setResult(IsOpenResponse.b(com.google.android.libraries.places.api.model.zzga.a((Place) Preconditions.t(placeF), jH)));
                return taskCompletionSource.getTask();
            }
            if (placeF != null) {
                strG = placeF.G();
            }
            FetchPlaceRequest.Builder builderB = FetchPlaceRequest.b((String) Preconditions.t(strG), arrayList);
            builderB.b(isOpenRequest.a());
            final FetchPlaceRequest fetchPlaceRequestA = builderB.a();
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return this.f77934h.e() ? this.f77932f.c(fetchPlaceRequestA, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgv
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77881a.o(fetchPlaceRequestA, zzmyVar, zzfjVarA, task);
                }
            }).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgw
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final /* synthetic */ Task then(Object obj) {
                    Place placeA = ((FetchPlaceResponse) obj).a();
                    Place.BusinessStatus businessStatusI2 = placeA.i();
                    OpeningHours openingHoursL = placeA.l();
                    OpeningHours openingHoursN = placeA.N();
                    Integer numV0 = placeA.v0();
                    Place place = placeF;
                    if (place != null) {
                        if (numV0 == null) {
                            numV0 = place.v0();
                        }
                        if (businessStatusI2 == null) {
                            businessStatusI2 = place.i();
                        }
                        if (openingHoursL == null) {
                            openingHoursL = place.l();
                        }
                        if (openingHoursN == null) {
                            openingHoursN = place.N();
                        }
                    }
                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                    long j3 = jH;
                    Place.Builder builderC = Place.c();
                    builderC.g(businessStatusI2);
                    builderC.j(openingHoursL);
                    builderC.K(openingHoursN);
                    builderC.r0(numV0);
                    taskCompletionSource2.setResult(IsOpenResponse.b(com.google.android.libraries.places.api.model.zzga.a(builderC.a(), j3)));
                    return taskCompletionSource2.getTask();
                }
            }).continueWithTask(zzgx.f77888a) : this.f77927a.d(fetchPlaceRequestA, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgs
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77873a.m(fetchPlaceRequestA, zzmyVar, zzfjVarA, task);
                }
            }).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzgt
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final /* synthetic */ Task then(Object obj) {
                    Place placeA = ((FetchPlaceResponse) obj).a();
                    Place.BusinessStatus businessStatusI2 = placeA.i();
                    OpeningHours openingHoursL = placeA.l();
                    OpeningHours openingHoursN = placeA.N();
                    Integer numV0 = placeA.v0();
                    Place place = placeF;
                    if (place != null) {
                        if (numV0 == null) {
                            numV0 = place.v0();
                        }
                        if (businessStatusI2 == null) {
                            businessStatusI2 = place.i();
                        }
                        if (openingHoursL == null) {
                            openingHoursL = place.l();
                        }
                        if (openingHoursN == null) {
                            openingHoursN = place.N();
                        }
                    }
                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                    long j3 = jH;
                    Place.Builder builderC = Place.c();
                    builderC.g(businessStatusI2);
                    builderC.j(openingHoursL);
                    builderC.K(openingHoursN);
                    builderC.r0(numV0);
                    taskCompletionSource2.setResult(IsOpenResponse.b(com.google.android.libraries.places.api.model.zzga.a(builderC.a(), j3)));
                    return taskCompletionSource2.getTask();
                }
            }).continueWithTask(zzgu.f77880a);
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task f(final FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, final zzmy zzmyVar) {
        try {
            Preconditions.u(fetchResolvedPhotoUriRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return this.f77932f.d(fetchResolvedPhotoUriRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhg
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77909a.D(fetchResolvedPhotoUriRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzhh.f77913a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task g(final FetchPlaceRequest fetchPlaceRequest, final zzmy zzmyVar) throws Throwable {
        try {
            Preconditions.u(fetchPlaceRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return (!this.f77934h.e() || zzmyVar.equals(zzmy.AUTOCOMPLETE_WIDGET)) ? this.f77927a.d(fetchPlaceRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhi
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77914a.F(fetchPlaceRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzhj.f77918a) : this.f77932f.c(fetchPlaceRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhk
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77919a.H(fetchPlaceRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzgo.f77863a);
        } catch (Error e3) {
            e = e3;
            zznb.b(e);
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            zznb.b(e);
            throw e;
        }
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task h(FindCurrentPlaceRequest findCurrentPlaceRequest, zzmy zzmyVar) {
        return w(findCurrentPlaceRequest, null, zzmyVar);
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task i(FetchPlaceRequest fetchPlaceRequest) {
        return g(fetchPlaceRequest, zzmy.PROGRAMMATIC_API);
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final Task j(final SearchNearbyRequest searchNearbyRequest, final zzmy zzmyVar) {
        try {
            Preconditions.u(searchNearbyRequest, "Request must not be null.");
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            return this.f77932f.e(searchNearbyRequest, zzmyVar).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzhb
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77898a.s(searchNearbyRequest, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzhc.f77902a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    final /* synthetic */ FindCurrentPlaceResponse k(FindCurrentPlaceRequest findCurrentPlaceRequest, long j3, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.b(findCurrentPlaceRequest, task, j3, this.f77931e.zzb(), zzmyVar);
        u(zzfi.a("FindCurrentPlace"), zzfjVar);
        return (FindCurrentPlaceResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse m(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.f(fetchPlaceRequest, 2, zzmyVar);
        u(zzfi.a("IsOpenFetchPlace"), zzfjVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse o(FetchPlaceRequest fetchPlaceRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.f(fetchPlaceRequest, 3, zzmyVar);
        u(zzfi.a("IsOpenGetPlace"), zzfjVar);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ SearchByTextResponse q(SearchByTextRequest searchByTextRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.h(searchByTextRequest, zzmyVar);
        u(zzfi.a("SearchByText"), zzfjVar);
        String strF = ((SearchByTextResponse) task.getResult()).f();
        SearchByTextResponse.Builder builderA = SearchByTextResponse.a(((SearchByTextResponse) task.getResult()).c());
        builderA.e(strF == null ? null : new zzgm(this, searchByTextRequest, strF, zzmyVar, ((SearchByTextResponse) task.getResult()).g() + 1));
        builderA.i(strF);
        builderA.g(((SearchByTextResponse) task.getResult()).d());
        builderA.h(((SearchByTextResponse) task.getResult()).e());
        return builderA.b();
    }

    final /* synthetic */ SearchNearbyResponse s(SearchNearbyRequest searchNearbyRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.a(searchNearbyRequest, zzmyVar);
        u(zzfi.a("SearchNearby"), zzfjVar);
        return (SearchNearbyResponse) task.getResult();
    }

    public final Task w(final FindCurrentPlaceRequest findCurrentPlaceRequest, String str, final zzmy zzmyVar) {
        try {
            Preconditions.u(findCurrentPlaceRequest, "Request must not be null.");
            final long jZzb = this.f77931e.zzb();
            zzek.a();
            final zzfj zzfjVarA = zzfj.a();
            final String str2 = null;
            return this.f77928b.a(findCurrentPlaceRequest.a()).onSuccessTask(new SuccessContinuation(findCurrentPlaceRequest, str2, zzmyVar) { // from class: com.google.android.libraries.places.internal.zzgp

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final /* synthetic */ FindCurrentPlaceRequest f77865b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private final /* synthetic */ zzmy f77866c;

                {
                    this.f77866c = zzmyVar;
                }

                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final /* synthetic */ Task then(Object obj) {
                    return this.f77864a.J(this.f77865b, null, this.f77866c, (Location) obj);
                }
            }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzgq
                @Override // com.google.android.gms.tasks.Continuation
                public final /* synthetic */ Object then(Task task) {
                    return this.f77867a.k(findCurrentPlaceRequest, jZzb, zzmyVar, zzfjVarA, task);
                }
            }).continueWithTask(zzgr.f77872a);
        } catch (Error | RuntimeException e3) {
            zznb.b(e3);
            throw e3;
        }
    }

    final /* synthetic */ FindAutocompletePredictionsResponse x(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.c(findAutocompletePredictionsRequest, 2, zzmyVar);
        u(zzfi.a("FindAutocompletePredictions"), zzfjVar);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    final /* synthetic */ FindAutocompletePredictionsResponse z(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, zzmy zzmyVar, zzfj zzfjVar, Task task) {
        this.f77930d.c(findAutocompletePredictionsRequest, 3, zzmyVar);
        u(zzfi.a("FindAutocompletePredictionsOnePlatform"), zzfjVar);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final void zzk() {
        this.f77932f.f();
        this.f77933g.zzb();
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final void zzl() {
        this.f77932f.g();
    }

    @Override // com.google.android.libraries.places.api.net.PlacesClient
    public final void zzm() {
        this.f77932f.h();
    }
}
