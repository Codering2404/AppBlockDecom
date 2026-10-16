package com.google.android.libraries.places.internal;

import android.location.Location;
import android.text.TextUtils;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.PlaceLikelihood;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.FetchPhotoResponse;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.FindCurrentPlaceRequest;
import com.google.android.libraries.places.api.net.FindCurrentPlaceResponse;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzln implements zzfv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zznh f78107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzga f78108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzgg f78109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzmo f78110d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzef f78111e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzks f78112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzla f78113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzmp f78114h;

    zzln(zzmp zzmpVar, zznh zznhVar, zzga zzgaVar, zzgg zzggVar, zzmo zzmoVar, zzef zzefVar, zzko zzkoVar, zzks zzksVar, zzkw zzkwVar, zzla zzlaVar) {
        this.f78114h = zzmpVar;
        this.f78107a = zznhVar;
        this.f78108b = zzgaVar;
        this.f78109c = zzggVar;
        this.f78110d = zzmoVar;
        this.f78111e = zzefVar;
        this.f78112f = zzksVar;
        this.f78113g = zzlaVar;
    }

    static final /* synthetic */ FetchPlaceResponse i(Task task) throws ApiException {
        zzkr zzkrVar = (zzkr) task.getResult();
        int iA = zzlu.a(zzkrVar.f78075a);
        if (PlacesStatusCodes.b(iA)) {
            throw new ApiException(new Status(iA, zzlu.b(zzkrVar.f78075a, zzkrVar.f78076b)));
        }
        zzlt zzltVar = zzkrVar.f78077c;
        String[] strArr = zzkrVar.f78078d;
        return FetchPlaceResponse.b(zzlq.f(zzltVar, strArr != null ? ImmutableList.v(strArr) : null));
    }

    static final /* synthetic */ FindCurrentPlaceResponse j(Task task) throws ApiException {
        zzkz zzkzVar = (zzkz) task.getResult();
        int iA = zzlu.a(zzkzVar.f78084a);
        if (PlacesStatusCodes.b(iA)) {
            throw new ApiException(new Status(iA, zzlu.b(zzkzVar.f78084a, zzkzVar.f78085b)));
        }
        ArrayList arrayList = new ArrayList();
        zzls[] zzlsVarArr = zzkzVar.f78087d;
        if (zzlsVarArr != null) {
            for (zzls zzlsVar : zzlsVarArr) {
                if (zzlsVar.b() == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a Place value"));
                }
                Double dA = zzlsVar.a();
                if (dA == null) {
                    throw new ApiException(new Status(8, "Unexpected server error: PlaceLikelihood returned without a likelihood value"));
                }
                zzlt zzltVarB = zzlsVar.b();
                String[] strArr = zzkzVar.f78086c;
                arrayList.add(PlaceLikelihood.e(zzlq.f(zzltVarB, strArr != null ? ImmutableList.v(strArr) : null), dA.doubleValue()));
            }
        }
        return FindCurrentPlaceResponse.b(arrayList);
    }

    @Override // com.google.android.libraries.places.internal.zzfv
    public final Task a(FetchPhotoRequest fetchPhotoRequest, final zzmy zzmyVar) {
        Integer numD = fetchPhotoRequest.d();
        Integer numC = fetchPhotoRequest.c();
        if (numD == null && numC == null) {
            return Tasks.forException(new ApiException(new Status(9012, "Must include max width or max height in request.")));
        }
        if (numD != null && numD.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(9012, String.format("Max Width must not be < 1, but was: %d.", numD))));
        }
        if (numC != null && numC.intValue() <= 0) {
            return Tasks.forException(new ApiException(new Status(9012, String.format("Max Height must not be < 1, but was: %d.", numC))));
        }
        zzmp zzmpVar = this.f78114h;
        zzkl zzklVar = new zzkl(fetchPhotoRequest, zzmpVar.c(), this.f78107a);
        zzef zzefVar = this.f78111e;
        zzgg zzggVar = this.f78109c;
        final long jZzb = zzefVar.zzb();
        return zzggVar.b(zzklVar, new zzkm()).continueWith(new Continuation(this) { // from class: com.google.android.libraries.places.internal.zzlg
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return FetchPhotoResponse.b(((zzkn) task.getResult()).f78074a);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlh
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return this.f78096a.f(jZzb, zzmyVar, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzfv
    public final Task b(FindAutocompletePredictionsRequest findAutocompletePredictionsRequest, final zzmy zzmyVar) {
        String strH = findAutocompletePredictionsRequest.h();
        if (strH == null || TextUtils.isEmpty(strH.trim())) {
            return Tasks.forResult(FindAutocompletePredictionsResponse.b(ImmutableList.y()));
        }
        zzmp zzmpVar = this.f78114h;
        zzku zzkuVar = new zzku(findAutocompletePredictionsRequest, zzmpVar.d(), zzmpVar.c(), this.f78107a);
        zzef zzefVar = this.f78111e;
        zzga zzgaVar = this.f78108b;
        final long jZzb = zzefVar.zzb();
        return zzgaVar.a(zzkuVar, zzkv.class).continueWith(new Continuation(this) { // from class: com.google.android.libraries.places.internal.zzlm
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return zzkw.a((zzkv) task.getResult());
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlf
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return this.f78093a.e(jZzb, zzmyVar, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzfv
    public final Task c(FindCurrentPlaceRequest findCurrentPlaceRequest, Location location, ImmutableList immutableList, final zzmy zzmyVar) {
        if (findCurrentPlaceRequest.c().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place Fields must not be empty.")));
        }
        zzmp zzmpVar = this.f78114h;
        zzky zzkyVar = new zzky(findCurrentPlaceRequest, location, immutableList, zzmpVar.d(), zzmpVar.c(), this.f78107a);
        zzef zzefVar = this.f78111e;
        zzga zzgaVar = this.f78108b;
        final long jZzb = zzefVar.zzb();
        return zzgaVar.a(zzkyVar, zzkz.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlk
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return zzln.j(task);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzll
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return this.f78104a.h(jZzb, zzmyVar, task);
            }
        });
    }

    @Override // com.google.android.libraries.places.internal.zzfv
    public final Task d(FetchPlaceRequest fetchPlaceRequest, final zzmy zzmyVar) {
        if (TextUtils.isEmpty(fetchPlaceRequest.d())) {
            return Tasks.forException(new ApiException(new Status(9012, "Place ID must not be empty.")));
        }
        if (fetchPlaceRequest.c().isEmpty()) {
            return Tasks.forException(new ApiException(new Status(9012, "Place Fields must not be empty.")));
        }
        zzmp zzmpVar = this.f78114h;
        zzkq zzkqVar = new zzkq(fetchPlaceRequest, zzmpVar.d(), zzmpVar.c(), this.f78107a);
        zzef zzefVar = this.f78111e;
        zzga zzgaVar = this.f78108b;
        final long jZzb = zzefVar.zzb();
        return zzgaVar.a(zzkqVar, zzkr.class).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzli
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return zzln.i(task);
            }
        }).continueWith(new Continuation() { // from class: com.google.android.libraries.places.internal.zzlj
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                return this.f78100a.g(jZzb, zzmyVar, task);
            }
        });
    }

    final /* synthetic */ FindAutocompletePredictionsResponse e(long j3, zzmy zzmyVar, Task task) {
        this.f78110d.e(task, j3, this.f78111e.zzb(), 2, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        return (FindAutocompletePredictionsResponse) task.getResult();
    }

    final /* synthetic */ FetchPhotoResponse f(long j3, zzmy zzmyVar, Task task) {
        this.f78110d.i(task, j3, this.f78111e.zzb(), zzmyVar);
        return (FetchPhotoResponse) task.getResult();
    }

    final /* synthetic */ FetchPlaceResponse g(long j3, zzmy zzmyVar, Task task) {
        this.f78110d.g(task, j3, this.f78111e.zzb(), 2, zzmyVar, com.google.android.libraries.places.api.auth.zzb.f74903a);
        return (FetchPlaceResponse) task.getResult();
    }

    final /* synthetic */ FindCurrentPlaceResponse h(long j3, zzmy zzmyVar, Task task) {
        this.f78110d.k(task, j3, this.f78111e.zzb(), zzmyVar);
        return (FindCurrentPlaceResponse) task.getResult();
    }
}
