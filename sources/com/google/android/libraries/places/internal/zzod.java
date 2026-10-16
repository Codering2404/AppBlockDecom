package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzod implements zznx {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ImmutableList f78306g = ImmutableList.A(Place.Field.ID, Place.Field.TYPES);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f78307h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlacesClient f78308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zznq f78309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AutocompleteSessionToken f78310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzmy f78311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzoa f78312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzob f78313f;

    public zzod(PlacesClient placesClient, zznq zznqVar, AutocompleteSessionToken autocompleteSessionToken, zzmy zzmyVar) {
        this.f78308a = placesClient;
        this.f78309b = zznqVar;
        this.f78310c = autocompleteSessionToken;
        this.f78311d = zzmyVar;
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final Task a(String str, int i3) {
        Preconditions.d(!TextUtils.isEmpty(str));
        zzoa zzoaVar = this.f78312e;
        if (zzoaVar != null) {
            if (zzoaVar.d().equals(str)) {
                return (Task) Preconditions.t(zzoaVar.b());
            }
            zzoaVar.a().cancel();
        }
        final zznv zznvVar = new zznv(new CancellationTokenSource(), str);
        this.f78312e = zznvVar;
        PlacesClient placesClient = this.f78308a;
        FindAutocompletePredictionsRequest.Builder builderB = FindAutocompletePredictionsRequest.b();
        builderB.k(str);
        zznq zznqVar = this.f78309b;
        builderB.g(zznqVar.j());
        builderB.h(zznqVar.k());
        builderB.e(zznqVar.l());
        builderB.l(zznqVar.p());
        builderB.f(Integer.valueOf(i3));
        builderB.n(zznqVar.m());
        builderB.m(this.f78310c);
        builderB.d(zznvVar.a().getToken());
        builderB.i(zznqVar.g());
        builderB.j(zznqVar.r());
        Task taskContinueWithTask = placesClient.b(builderB.a(), this.f78311d).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zznz
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i4 = zzod.f78307h;
                return zznvVar.a().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zznvVar.c(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final Task b(AutocompletePrediction autocompletePrediction) {
        ImmutableList immutableList = f78306g;
        zznq zznqVar = this.f78309b;
        if (immutableList.containsAll(zznqVar.e())) {
            Place.Builder builderC = Place.c();
            builderC.D(autocompletePrediction.d());
            builderC.P(autocompletePrediction.g().isEmpty() ? null : autocompletePrediction.g());
            return Tasks.forResult(FetchPlaceResponse.b(builderC.a()));
        }
        zzob zzobVar = this.f78313f;
        if (zzobVar != null) {
            if (zzobVar.d().equals(autocompletePrediction.d())) {
                return (Task) Preconditions.t(zzobVar.b());
            }
            zzobVar.a().cancel();
        }
        final zznw zznwVar = new zznw(new CancellationTokenSource(), autocompletePrediction.d());
        this.f78313f = zznwVar;
        PlacesClient placesClient = this.f78308a;
        FetchPlaceRequest.Builder builderB = FetchPlaceRequest.b(autocompletePrediction.d(), zznqVar.e());
        builderB.c(this.f78310c);
        builderB.b(zznwVar.a().getToken());
        Task taskContinueWithTask = placesClient.g(builderB.a(), zzmy.AUTOCOMPLETE_WIDGET).continueWithTask(new Continuation() { // from class: com.google.android.libraries.places.internal.zzny
            @Override // com.google.android.gms.tasks.Continuation
            public final /* synthetic */ Object then(Task task) {
                int i3 = zzod.f78307h;
                return zznwVar.a().getToken().isCancellationRequested() ? Tasks.forCanceled() : task;
            }
        });
        zznwVar.c(taskContinueWithTask);
        return taskContinueWithTask;
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final void zzc() {
        zzoa zzoaVar = this.f78312e;
        if (zzoaVar != null) {
            zzoaVar.a().cancel();
        }
        zzob zzobVar = this.f78313f;
        if (zzobVar != null) {
            zzobVar.a().cancel();
        }
        this.f78312e = null;
        this.f78313f = null;
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final void zzd() {
        this.f78308a.zzk();
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final void zze() {
        this.f78308a.zzl();
    }

    @Override // com.google.android.libraries.places.internal.zznx
    public final zzmy zzf() {
        return this.f78311d;
    }
}
