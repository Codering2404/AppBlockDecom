package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnTokenCanceledListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.auth.PlacesAppCheckTokenProvider;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.EVConnectorType;
import com.google.android.libraries.places.api.model.EVSearchOptions;
import com.google.android.libraries.places.api.model.EncodedPolyline;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import com.google.android.libraries.places.api.model.RoutingParameters;
import com.google.android.libraries.places.api.model.SearchAlongRouteParameters;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzja {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbak f78001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzblw f78002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzjc f78003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzmo f78004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzef f78005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzkd f78006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzkf f78007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzji f78008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzjp f78009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzjw f78010j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzbiy f78011k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final zzhw f78012l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzmp f78013m;

    zzja(zzmp zzmpVar, zzblw zzblwVar, zzmo zzmoVar, zzef zzefVar, zzkf zzkfVar, zzkd zzkdVar, zzib zzibVar, zzhy zzhyVar, zzho zzhoVar, zzji zzjiVar, zzka zzkaVar, zzkh zzkhVar, zzjc zzjcVar, zzjp zzjpVar, zzjw zzjwVar, zzbiy zzbiyVar, zzhw zzhwVar) {
        this.f78013m = zzmpVar;
        this.f78002b = zzblwVar;
        this.f78001a = zzbal.f(zzblwVar);
        this.f78003c = zzjcVar;
        this.f78004d = zzmoVar;
        this.f78005e = zzefVar;
        this.f78007g = zzkfVar;
        this.f78006f = zzkdVar;
        this.f78008h = zzjiVar;
        this.f78009i = zzjpVar;
        this.f78010j = zzjwVar;
        this.f78011k = zzbiyVar;
        this.f78012l = zzhwVar;
    }

    private final ListenableFuture w() {
        PlacesAppCheckTokenProvider placesAppCheckTokenProviderF = this.f78013m.f();
        if (placesAppCheckTokenProviderF == null) {
            return Futures.f(com.google.android.libraries.places.api.auth.zzb.f74903a);
        }
        SettableFuture settableFutureF = SettableFuture.F();
        Futures.a(placesAppCheckTokenProviderF.a(), new zzie(this, settableFutureF), MoreExecutors.a());
        return settableFutureF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final zzbak x(zzmy zzmyVar, String str, com.google.android.libraries.places.api.auth.zzb zzbVar, zzbgs zzbgsVar) {
        zzbiy zzbiyVarA = zzcei.a(zzmyVar == zzmy.PLACES_UI_KIT ? this.f78003c.b(y((zzbgs) Preconditions.t(zzbgsVar)), str) : this.f78003c.a(this.f78013m.c(), str));
        zzbiy zzbiyVarA2 = zzey.a(zzbVar.b());
        ImmutableList clientTypes = ImmutableList.z(zzer.f77794a);
        Intrinsics.checkNotNullParameter(clientTypes, "clientTypes");
        zzava builder = zzavl.H();
        Intrinsics.checkNotNullParameter(builder, "builder");
        int size = clientTypes.size();
        int i3 = 0;
        while (i3 < size) {
            E e3 = clientTypes.get(i3);
            i3++;
            if (((zzer) e3).ordinal() != 0) {
                throw new NoWhenBranchMatchedException();
            }
            List listY = builder.y();
            Intrinsics.checkNotNullExpressionValue(listY, "getSolutionIdList(...)");
            zzbgm zzbgmVar = new zzbgm(listY);
            Set setA = zzeo.a();
            Intrinsics.checkNotNullExpressionValue(setA, "getInternalUsageAttributionIds(...)");
            Set values = setA;
            Intrinsics.checkNotNullParameter(zzbgmVar, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            builder.z(values);
        }
        zzbak zzbakVar = this.f78001a;
        zzbdq zzbdqVarZzG = builder.zzG();
        Intrinsics.checkNotNullExpressionValue(zzbdqVarZzG, "build(...)");
        zzbmg zzbmgVar = new zzbmg();
        zzbmgVar.c(zzbmc.c("x-goog-gmp-client-signals", zzbmg.f76399d), Base64.getEncoder().encodeToString(((zzavl) zzbdqVarZzG).b()));
        return (zzbak) zzbakVar.d(zzbiyVarA, zzbiyVarA2, zzcei.a(zzbmgVar), this.f78011k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String y(zzbgs zzbgsVar) {
        return zzbgsVar == zzbgs.PLACE_AUTOCOMPLETE ? (String) this.f78010j.b(zzbgsVar).get() : (String) this.f78010j.a(zzbgsVar).get();
    }

    public final Task a(final SearchByTextRequest searchByTextRequest, final zzmy zzmyVar) {
        List listI = searchByTextRequest.i();
        if (listI.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place fields must not be empty.")));
        }
        if (searchByTextRequest.o().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Text query must not be an empty string.")));
        }
        String strD = searchByTextRequest.d();
        if (strD != null && strD.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Included type must not be an empty string.")));
        }
        String strL = searchByTextRequest.l();
        if (strL != null && strL.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Region code must not be an empty string.")));
        }
        final long jZzb = this.f78005e.zzb();
        ArrayList arrayList = new ArrayList();
        if (searchByTextRequest.r()) {
            arrayList.add(zzht.ROUTING_SUMMARIES);
        }
        if (searchByTextRequest.s()) {
            arrayList.add(zzht.SEARCH_URI);
        }
        arrayList.add(zzht.NEXT_PAGE_TOKEN);
        final String strA = zzhu.a(zzjl.a(listI), arrayList);
        final ListenableFuture listenableFutureW = w();
        final ListenableFuture listenableFutureI = Futures.i(listenableFutureW, new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zziz
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f77997a.i(zzmyVar, strA, searchByTextRequest, (com.google.android.libraries.places.api.auth.zzb) obj);
            }
        }, MoreExecutors.a());
        CancellationToken cancellationTokenA = searchByTextRequest.a();
        if (cancellationTokenA != null) {
            cancellationTokenA.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzir
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    listenableFutureI.cancel(true);
                }
            });
        }
        return zzen.a(listenableFutureI).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzif
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                return this.f77948a.j(searchByTextRequest, (zzbbw) obj);
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zziq
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                this.f77974a.k(searchByTextRequest, jZzb, zzmyVar, listenableFutureW, task);
                return task;
            }
        });
    }

    public final Task b(final FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, final zzmy zzmyVar) {
        String strI = findAutocompletePredictionsRequest.i();
        if (strI != null && strI.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Region code must not be an empty string.")));
        }
        String strH = findAutocompletePredictionsRequest.h();
        if (strH == null) {
            return Tasks.forException(new ApiException(new Status(9012, "Query must not be null.")));
        }
        if (TextUtils.isEmpty(strH.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.b(ImmutableList.y()));
        }
        final long jZzb = this.f78005e.zzb();
        final ListenableFuture listenableFutureW = w();
        final ListenableFuture listenableFutureI = Futures.i(listenableFutureW, new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzis
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f77980a.l(zzmyVar, findAutocompletePredictionsRequest, (com.google.android.libraries.places.api.auth.zzb) obj);
            }
        }, MoreExecutors.a());
        CancellationToken cancellationTokenA = findAutocompletePredictionsRequest.a();
        if (cancellationTokenA != null) {
            cancellationTokenA.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zziv
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    listenableFutureI.cancel(true);
                }
            });
        }
        return zzen.a(listenableFutureI).onSuccessTask(new SuccessContinuation(this) { // from class: com.google.android.libraries.places.internal.zzit
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                ArrayList arrayList = new ArrayList();
                for (zzawz zzawzVar : ((zzaxa) obj).G()) {
                    zzaws zzawsVarH = zzawzVar.H();
                    if (!zzawzVar.G()) {
                        throw new IllegalArgumentException("Suggestion does not contain a PlacePrediction.");
                    }
                    AutocompletePrediction.Builder builderA = AutocompletePrediction.a(zzawsVarH.G());
                    builderA.b(zzawsVarH.K() == 0 ? null : Integer.valueOf(zzawsVarH.K()));
                    builderA.f(ImmutableList.t(zzawsVarH.J()));
                    builderA.c(zzawsVarH.H().G());
                    builderA.h(zzkh.a(zzawsVarH.H().H()));
                    builderA.d(zzawsVarH.I().G().G());
                    builderA.i(zzkh.a(zzawsVarH.I().G().H()));
                    builderA.e(zzawsVarH.I().H().G());
                    builderA.j(zzkh.a(zzawsVarH.I().H().H()));
                    arrayList.add(builderA.a());
                }
                taskCompletionSource.setResult(FindAutocompletePredictionsResponse.b(arrayList));
                return taskCompletionSource.getTask();
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zziu
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                this.f77983a.m(jZzb, zzmyVar, listenableFutureW, task);
                return task;
            }
        });
    }

    public final Task c(final FetchPlaceRequest fetchPlaceRequest, final zzmy zzmyVar) {
        if (fetchPlaceRequest.d().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place id must not be an empty string.")));
        }
        List listC = fetchPlaceRequest.c();
        if (listC.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place fields must not be empty.")));
        }
        String strE = fetchPlaceRequest.e();
        if (strE != null && strE.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Region code must not be an empty string.")));
        }
        final long jZzb = this.f78005e.zzb();
        final String strB = zzhu.b(zzjl.a(listC));
        final ListenableFuture listenableFutureW = w();
        final ListenableFuture listenableFutureI = Futures.i(listenableFutureW, new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zziw
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f77988a.n(zzmyVar, strB, fetchPlaceRequest, (com.google.android.libraries.places.api.auth.zzb) obj);
            }
        }, MoreExecutors.a());
        CancellationToken cancellationTokenA = fetchPlaceRequest.a();
        if (cancellationTokenA != null) {
            cancellationTokenA.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzig
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    listenableFutureI.cancel(true);
                }
            });
        }
        return zzen.a(listenableFutureI).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzix
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                return this.f77992a.o((zzbai) obj);
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zziy
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                this.f77993a.p(jZzb, zzmyVar, listenableFutureW, task);
                return task;
            }
        });
    }

    public final Task d(final FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, final zzmy zzmyVar) {
        if (zzmyVar == zzmy.PLACES_UI_KIT && this.f78010j.f78051g == null) {
            return Tasks.forException(new ApiException(new Status(9012, "Get Photo Media for Places UI Kit but widget type is null")));
        }
        final long jZzb = this.f78005e.zzb();
        final ListenableFuture listenableFutureW = w();
        final ListenableFuture listenableFutureI = Futures.i(listenableFutureW, new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzih
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f77951a.q(zzmyVar, fetchResolvedPhotoUriRequest, (com.google.android.libraries.places.api.auth.zzb) obj);
            }
        }, MoreExecutors.a());
        CancellationToken cancellationTokenA = fetchResolvedPhotoUriRequest.a();
        if (cancellationTokenA != null) {
            cancellationTokenA.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzik
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    listenableFutureI.cancel(true);
                }
            });
        }
        return zzen.a(listenableFutureI).onSuccessTask(zzii.f77954a).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzij
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                this.f77955a.r(jZzb, zzmyVar, listenableFutureW, task);
                return task;
            }
        });
    }

    public final Task e(final SearchNearbyRequest searchNearbyRequest, final zzmy zzmyVar) {
        List listI = searchNearbyRequest.i();
        if (listI.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place fields must not be empty.")));
        }
        String strK = searchNearbyRequest.k();
        if (strK != null && strK.isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Region code must not be an empty string.")));
        }
        final long jZzb = this.f78005e.zzb();
        ArrayList arrayList = new ArrayList();
        if (searchNearbyRequest.m()) {
            arrayList.add(zzht.ROUTING_SUMMARIES);
        }
        final String strA = zzhu.a(zzjl.a(listI), arrayList);
        final ListenableFuture listenableFutureW = w();
        final ListenableFuture listenableFutureI = Futures.i(listenableFutureW, new AsyncFunction() { // from class: com.google.android.libraries.places.internal.zzim
            @Override // com.google.common.util.concurrent.AsyncFunction
            public final /* synthetic */ ListenableFuture apply(Object obj) {
                return this.f77962a.t(zzmyVar, strA, searchNearbyRequest, (com.google.android.libraries.places.api.auth.zzb) obj);
            }
        }, MoreExecutors.a());
        CancellationToken cancellationTokenA = searchNearbyRequest.a();
        if (cancellationTokenA != null) {
            cancellationTokenA.onCanceledRequested(new OnTokenCanceledListener() { // from class: com.google.android.libraries.places.internal.zzip
                @Override // com.google.android.gms.tasks.OnTokenCanceledListener
                public final /* synthetic */ void onCanceled() {
                    listenableFutureI.cancel(true);
                }
            });
        }
        return zzen.a(listenableFutureI).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.libraries.places.internal.zzin
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final /* synthetic */ Task then(Object obj) {
                return this.f77966a.u(searchNearbyRequest, (zzbbk) obj);
            }
        }).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzio
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                this.f77968a.v(searchNearbyRequest, jZzb, zzmyVar, listenableFutureW, task);
                return task;
            }
        });
    }

    public final void f() {
        this.f78002b.g();
        zzjp zzjpVar = this.f78009i;
        zzjpVar.f78030d.shutdownNow();
        zzjpVar.f78027a.g();
        this.f78010j.c();
    }

    public final void g() {
        this.f78009i.b();
    }

    public final void h() {
        this.f78010j.c();
    }

    final /* synthetic */ ListenableFuture i(zzmy zzmyVar, String str, SearchByTextRequest searchByTextRequest, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        int i3;
        zzaxz zzaxzVar;
        zzbak zzbakVarX = x(zzmyVar, str, zzbVar, zzbgs.PLACE_LIST);
        Locale localeD = this.f78013m.d();
        zzbbl zzbblVarG = zzbbu.G();
        String strD = searchByTextRequest.d();
        if (strD != null) {
            zzbblVarG.B(strD);
        }
        LocationBias locationBiasE = searchByTextRequest.e();
        if (locationBiasE != null) {
            boolean z2 = locationBiasE instanceof RectangularBounds;
            Preconditions.e(z2 || (locationBiasE instanceof CircularBounds), "LocationBias must be of type RectangularBounds or CircularBounds.");
            zzbbo zzbboVarG = zzbbp.G();
            if (z2) {
                zzbboVarG.y(zzhq.c((RectangularBounds) locationBiasE));
            } else {
                zzbboVarG.z(zzhq.b((CircularBounds) locationBiasE));
            }
            zzbblVarG.J((zzbbp) zzbboVarG.zzG());
        }
        LocationRestriction locationRestrictionF = searchByTextRequest.f();
        if (locationRestrictionF != null) {
            Preconditions.e(locationRestrictionF instanceof RectangularBounds, "LocationRestriction must be of type RectangularBounds.");
            zzbbq zzbbqVarG = zzbbr.G();
            zzbbqVarG.y(zzhq.c((RectangularBounds) locationRestrictionF));
            zzbblVarG.K((zzbbr) zzbbqVarG.zzG());
        }
        Integer numG = searchByTextRequest.g();
        if (numG != null) {
            zzbblVarG.F(numG.intValue());
        }
        Double dH = searchByTextRequest.h();
        if (dH != null) {
            zzbblVarG.E(dH.doubleValue());
        }
        zzbblVarG.D(searchByTextRequest.p());
        List listJ = searchByTextRequest.j();
        ArrayList arrayList = new ArrayList();
        Iterator it = listJ.iterator();
        while (true) {
            i3 = 4;
            if (!it.hasNext()) {
                break;
            }
            int iIntValue = ((Integer) it.next()).intValue();
            if (iIntValue == 0) {
                arrayList.add(zzbao.PRICE_LEVEL_FREE);
            } else if (iIntValue == 1) {
                arrayList.add(zzbao.PRICE_LEVEL_INEXPENSIVE);
            } else if (iIntValue == 2) {
                arrayList.add(zzbao.PRICE_LEVEL_MODERATE);
            } else if (iIntValue == 3) {
                arrayList.add(zzbao.PRICE_LEVEL_EXPENSIVE);
            } else if (iIntValue == 4) {
                arrayList.add(zzbao.PRICE_LEVEL_VERY_EXPENSIVE);
            }
        }
        zzbblVarG.H(arrayList);
        SearchByTextRequest.RankPreference rankPreferenceK = searchByTextRequest.k();
        if (rankPreferenceK == null) {
            i3 = 2;
        } else {
            EVConnectorType eVConnectorType = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
            if (rankPreferenceK.ordinal() == 0) {
                i3 = 3;
            }
        }
        zzbblVarG.P(i3);
        String strL = searchByTextRequest.l();
        if (strL != null) {
            zzbblVarG.A(strL);
        }
        zzbblVarG.I(searchByTextRequest.t());
        zzbblVarG.y(searchByTextRequest.o());
        zzbblVarG.z(localeD.toLanguageTag());
        EVSearchOptions eVSearchOptionsC = searchByTextRequest.c();
        if (eVSearchOptionsC != null) {
            zzbbm zzbbmVarG = zzbbn.G();
            Double d3 = eVSearchOptionsC.d();
            if (d3 != null) {
                zzbbmVarG.y(d3.doubleValue());
            }
            List<EVConnectorType> listC = eVSearchOptionsC.c();
            if (listC != null) {
                ArrayList arrayList2 = new ArrayList();
                for (EVConnectorType eVConnectorType2 : listC) {
                    EVConnectorType eVConnectorType3 = EVConnectorType.EV_CONNECTOR_TYPE_UNSPECIFIED;
                    SearchByTextRequest.RankPreference rankPreference = SearchByTextRequest.RankPreference.DISTANCE;
                    switch (eVConnectorType2.ordinal()) {
                        case 1:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_OTHER;
                            break;
                        case 2:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_J1772;
                            break;
                        case 3:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_TYPE_2;
                            break;
                        case 4:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CHADEMO;
                            break;
                        case 5:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_1;
                            break;
                        case 6:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_CCS_COMBO_2;
                            break;
                        case 7:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_TESLA;
                            break;
                        case 8:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_GB_T;
                            break;
                        case 9:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED_WALL_OUTLET;
                            break;
                        case 10:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_NACS;
                            break;
                        default:
                            zzaxzVar = zzaxz.EV_CONNECTOR_TYPE_UNSPECIFIED;
                            break;
                    }
                    arrayList2.add(zzaxzVar);
                }
                zzbbmVarG.z(arrayList2);
            }
            zzbblVarG.L((zzbbn) zzbbmVarG.zzG());
        }
        SearchAlongRouteParameters searchAlongRouteParametersN = searchByTextRequest.n();
        if (searchAlongRouteParametersN != null) {
            zzbbs zzbbsVarG = zzbbt.G();
            EncodedPolyline encodedPolyline = (EncodedPolyline) searchAlongRouteParametersN.c();
            zzbam zzbamVarG = zzban.G();
            zzbamVarG.y(encodedPolyline.c());
            zzbbsVarG.y((zzban) zzbamVarG.zzG());
            zzbblVarG.N((zzbbt) zzbbsVarG.zzG());
        }
        RoutingParameters routingParametersM = searchByTextRequest.m();
        if (routingParametersM != null) {
            zzbblVarG.M(zzjy.a(routingParametersM));
        }
        if (searchByTextRequest.q()) {
            zzbblVarG.O(true);
        }
        String strU = searchByTextRequest.u();
        if (strU != null) {
            zzbblVarG.G(strU);
        }
        return zzcef.b(zzbakVarX.b().d(zzbal.b(), zzbakVarX.c()), (zzbbu) zzbblVarG.zzG());
    }

    final /* synthetic */ Task j(SearchByTextRequest searchByTextRequest, zzbbw zzbbwVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List listG = zzbbwVar.G();
        List listH = zzbbwVar.H();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String strI = zzbbwVar.I();
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f78008h.a((zzbai) it.next()));
        }
        Iterator it2 = listH.iterator();
        while (it2.hasNext()) {
            arrayList2.add(zzka.a((zzbbc) it2.next()));
        }
        String strJ = zzbbwVar.J();
        SearchByTextResponse.Builder builderA = SearchByTextResponse.a(arrayList);
        if (true != searchByTextRequest.r()) {
            arrayList2 = null;
        }
        builderA.g(arrayList2);
        if (true == strI.isEmpty()) {
            strI = null;
        }
        builderA.i(strI);
        builderA.j(searchByTextRequest.v());
        builderA.h(strJ.isEmpty() ? null : Uri.parse(strJ));
        taskCompletionSource.setResult(builderA.b());
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Task k(SearchByTextRequest searchByTextRequest, long j3, zzmy zzmyVar, ListenableFuture listenableFuture, Task task) {
        if (!task.isCanceled()) {
            this.f78004d.o(searchByTextRequest, task, j3, this.f78005e.zzb(), zzmyVar, (com.google.android.libraries.places.api.auth.zzb) listenableFuture.get());
        }
        return task;
    }

    final /* synthetic */ ListenableFuture l(zzmy zzmyVar, FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzbak zzbakVarX = x(zzmyVar, "", zzbVar, zzbgs.PLACE_AUTOCOMPLETE);
        Locale localeD = this.f78013m.d();
        zzawh zzawhVarG = zzawm.G();
        zzawhVarG.y((String) Preconditions.t(findAutocompletePredictionsRequest.h()));
        zzawhVarG.E(localeD.toLanguageTag());
        Integer numD = findAutocompletePredictionsRequest.d();
        if (numD != null) {
            zzawhVarG.H(numD.intValue());
        }
        String strI = findAutocompletePredictionsRequest.i();
        if (strI != null) {
            zzawhVarG.F(strI);
        }
        LocationBias locationBiasE = findAutocompletePredictionsRequest.e();
        if (locationBiasE != null) {
            boolean z2 = locationBiasE instanceof CircularBounds;
            Preconditions.d(z2 || (locationBiasE instanceof RectangularBounds));
            zzawi zzawiVarG = zzawj.G();
            if (z2) {
                zzawiVarG.z(zzhq.b((CircularBounds) locationBiasE));
            }
            if (locationBiasE instanceof RectangularBounds) {
                zzawiVarG.y(zzhq.c((RectangularBounds) locationBiasE));
            }
            zzawhVarG.z((zzawj) zzawiVarG.zzG());
        }
        LocationRestriction locationRestrictionF = findAutocompletePredictionsRequest.f();
        if (locationRestrictionF != null) {
            boolean z3 = locationRestrictionF instanceof CircularBounds;
            Preconditions.d(z3 || (locationRestrictionF instanceof RectangularBounds));
            zzawk zzawkVarG = zzawl.G();
            if (z3) {
                zzawkVarG.z(zzhq.b((CircularBounds) locationRestrictionF));
            }
            if (locationRestrictionF instanceof RectangularBounds) {
                zzawkVarG.y(zzhq.c((RectangularBounds) locationRestrictionF));
            }
            zzawhVarG.A((zzawl) zzawkVarG.zzG());
        }
        LatLng latLngG = findAutocompletePredictionsRequest.g();
        if (latLngG != null) {
            zzawhVarG.G(zzhq.a(latLngG));
        }
        Iterator it = findAutocompletePredictionsRequest.c().iterator();
        while (it.hasNext()) {
            zzawhVarG.D((String) it.next());
        }
        AutocompleteSessionToken autocompleteSessionTokenJ = findAutocompletePredictionsRequest.j();
        if (autocompleteSessionTokenJ != null) {
            zzawhVarG.I(autocompleteSessionTokenJ.toString());
        }
        Iterator it2 = findAutocompletePredictionsRequest.k().iterator();
        while (it2.hasNext()) {
            zzawhVarG.B((String) it2.next());
        }
        if (findAutocompletePredictionsRequest.l()) {
            zzawhVarG.J(true);
        }
        return zzcef.b(zzbakVarX.b().d(zzbal.e(), zzbakVarX.c()), (zzawm) zzawhVarG.zzG());
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Task m(long j3, zzmy zzmyVar, ListenableFuture listenableFuture, Task task) {
        if (task.isCanceled()) {
            return task;
        }
        this.f78004d.e(task, j3, this.f78005e.zzb(), 3, zzmyVar, (com.google.android.libraries.places.api.auth.zzb) listenableFuture.get());
        return task;
    }

    final /* synthetic */ ListenableFuture n(zzmy zzmyVar, String str, FetchPlaceRequest fetchPlaceRequest, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzbak zzbakVarX = x(zzmyVar, str, zzbVar, zzbgs.PLACE_DETAILS);
        Locale localeD = this.f78013m.d();
        zzayh zzayhVarG = zzayi.G();
        zzayhVarG.y("places/".concat(String.valueOf(fetchPlaceRequest.d())));
        String strE = fetchPlaceRequest.e();
        if (strE != null) {
            zzayhVarG.A(strE);
        }
        AutocompleteSessionToken autocompleteSessionTokenF = fetchPlaceRequest.f();
        if (autocompleteSessionTokenF != null) {
            zzayhVarG.B(autocompleteSessionTokenF.toString());
        }
        zzayhVarG.z(localeD.toLanguageTag());
        return zzcef.b(zzbakVarX.b().d(zzbal.d(), zzbakVarX.c()), (zzayi) zzayhVarG.zzG());
    }

    final /* synthetic */ Task o(zzbai zzbaiVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.setResult(FetchPlaceResponse.b(this.f78008h.a(zzbaiVar)));
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Task p(long j3, zzmy zzmyVar, ListenableFuture listenableFuture, Task task) {
        if (task.isCanceled()) {
            return task;
        }
        this.f78004d.g(task, j3, this.f78005e.zzb(), 3, zzmyVar, (com.google.android.libraries.places.api.auth.zzb) listenableFuture.get());
        return task;
    }

    final /* synthetic */ ListenableFuture q(zzmy zzmyVar, FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequest, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzbak zzbakVarX = x(zzmyVar, "", zzbVar, this.f78010j.f78051g);
        zzayf zzayfVarG = zzayg.G();
        zzayfVarG.y(String.valueOf((String) Preconditions.t(fetchResolvedPhotoUriRequest.e().h())).concat("/media"));
        Integer numC = fetchResolvedPhotoUriRequest.c();
        if (numC != null) {
            zzayfVarG.A(numC.intValue());
        }
        Integer numD = fetchResolvedPhotoUriRequest.d();
        if (numD != null) {
            zzayfVarG.z(numD.intValue());
        }
        zzayfVarG.B(true);
        return zzcef.b(zzbakVarX.b().d(zzbal.c(), zzbakVarX.c()), (zzayg) zzayfVarG.zzG());
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Task r(long j3, zzmy zzmyVar, ListenableFuture listenableFuture, Task task) {
        if (task.isCanceled()) {
            return task;
        }
        this.f78004d.m(task, j3, this.f78005e.zzb(), zzmyVar, (com.google.android.libraries.places.api.auth.zzb) listenableFuture.get());
        return task;
    }

    final /* synthetic */ ListenableFuture s(LatLng latLng, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        return this.f78012l.a(latLng, zzbVar, y(zzbgs.PLACE_DETAILS));
    }

    final /* synthetic */ ListenableFuture t(zzmy zzmyVar, String str, SearchNearbyRequest searchNearbyRequest, com.google.android.libraries.places.api.auth.zzb zzbVar) {
        zzbak zzbakVarX = x(zzmyVar, str, zzbVar, zzbgs.PLACE_LIST);
        Locale localeD = this.f78013m.d();
        zzbbd zzbbdVarG = zzbbi.G();
        zzbbdVarG.y(localeD.toLanguageTag());
        String strK = searchNearbyRequest.k();
        if (strK != null) {
            zzbbdVarG.z(strK);
        }
        List listF = searchNearbyRequest.f();
        if (listF != null) {
            zzbbdVarG.A(listF);
        }
        List listD = searchNearbyRequest.d();
        if (listD != null) {
            zzbbdVarG.B(listD);
        }
        List listE = searchNearbyRequest.e();
        if (listE != null) {
            zzbbdVarG.D(listE);
        }
        List listC = searchNearbyRequest.c();
        if (listC != null) {
            zzbbdVarG.E(listC);
        }
        Integer numH = searchNearbyRequest.h();
        if (numH != null) {
            zzbbdVarG.F(numH.intValue());
        }
        RoutingParameters routingParametersL = searchNearbyRequest.l();
        if (routingParametersL != null) {
            zzbbdVarG.H(zzjy.a(routingParametersL));
        }
        zzbbg zzbbgVarG = zzbbh.G();
        zzbbgVarG.y(zzhq.b((CircularBounds) searchNearbyRequest.g()));
        zzbbdVarG.G((zzbbh) zzbbgVarG.zzG());
        SearchNearbyRequest.RankPreference rankPreferenceJ = searchNearbyRequest.j();
        zzbbdVarG.I(rankPreferenceJ == null ? 2 : rankPreferenceJ.ordinal() != 0 ? 4 : 3);
        return zzcef.b(zzbakVarX.b().d(zzbal.a(), zzbakVarX.c()), (zzbbi) zzbbdVarG.zzG());
    }

    final /* synthetic */ Task u(SearchNearbyRequest searchNearbyRequest, zzbbk zzbbkVar) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        List listG = zzbbkVar.G();
        List listH = zzbbkVar.H();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = listG.iterator();
        while (it.hasNext()) {
            arrayList.add(this.f78008h.a((zzbai) it.next()));
        }
        Iterator it2 = listH.iterator();
        while (it2.hasNext()) {
            arrayList2.add(zzka.a((zzbbc) it2.next()));
        }
        SearchNearbyResponse.Builder builderA = SearchNearbyResponse.a(arrayList);
        if (true != searchNearbyRequest.m()) {
            arrayList2 = null;
        }
        builderA.f(arrayList2);
        taskCompletionSource.setResult(builderA.b());
        return taskCompletionSource.getTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ Task v(SearchNearbyRequest searchNearbyRequest, long j3, zzmy zzmyVar, ListenableFuture listenableFuture, Task task) {
        if (!task.isCanceled()) {
            this.f78004d.n(searchNearbyRequest, task, j3, this.f78005e.zzb(), zzmyVar, (com.google.android.libraries.places.api.auth.zzb) listenableFuture.get());
        }
        return task;
    }
}
