package com.google.android.libraries.places.widget.internal.placedetails;

import android.app.Application;
import android.net.Uri;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.AuthorAttribution;
import com.google.android.libraries.places.api.model.AuthorAttributions;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzmy;
import com.google.android.libraries.places.internal.zzpr;
import com.google.android.libraries.places.internal.zzps;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.internal.zzpu;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbj extends AndroidViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableLiveData f79261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LiveData f79262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableLiveData f79263d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LiveData f79264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final List f79265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f79266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableLiveData f79268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableLiveData f79269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzpt f79270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private PlacesClient f79271m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbj(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f79261b = mutableLiveData;
        this.f79262c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f79263d = mutableLiveData2;
        this.f79264f = mutableLiveData2;
        List listMutableListOf = CollectionsKt.mutableListOf(new MutableLiveData(), new MutableLiveData(), new MutableLiveData());
        this.f79265g = listMutableListOf;
        this.f79266h = new ArrayList();
        this.f79267i = listMutableListOf;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.f79268j = mutableLiveData3;
        this.f79269k = mutableLiveData3;
    }

    static /* synthetic */ Unit J0(zzbj zzbjVar, zzbd zzbdVar, FetchPlaceResponse fetchPlaceResponse) {
        List list;
        MutableLiveData mutableLiveData = zzbjVar.f79261b;
        Place placeA = fetchPlaceResponse.a();
        mutableLiveData.n(placeA);
        if (zzbdVar.a()) {
            List<PhotoMetadata> listR = placeA.R();
            int i3 = 0;
            if (listR == null) {
                Log.i("PlaceDetailsViewModel", "No photo metadatas, falling back to placeholder image.");
                List list2 = zzbjVar.f79265g;
                ((MutableLiveData) list2.get(0)).n(zzbp.f79277a);
                MutableLiveData mutableLiveData2 = (MutableLiveData) list2.get(1);
                zzbo zzboVar = zzbo.f79276a;
                mutableLiveData2.n(zzboVar);
                ((MutableLiveData) list2.get(2)).n(zzboVar);
            } else if (listR.isEmpty()) {
                ((MutableLiveData) zzbjVar.f79265g.get(0)).n(zzbp.f79277a);
            } else {
                while (true) {
                    list = zzbjVar.f79265g;
                    if (list.size() >= listR.size()) {
                        break;
                    }
                    list.add(new MutableLiveData());
                }
                List list3 = zzbjVar.f79266h;
                int size = listR.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.add(new MutableLiveData());
                }
                list3.addAll(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (PhotoMetadata photoMetadata : listR) {
                    arrayList2.add(new zzav(photoMetadata, zzbdVar.c(), (MutableLiveData) list.get(i3)));
                    arrayList2.add(new zzav(photoMetadata, zzbdVar.d(), (MutableLiveData) list3.get(i3)));
                    i3++;
                }
                for (int size2 = listR.size(); size2 < 3; size2++) {
                    ((MutableLiveData) list.get(size2)).n(zzbo.f79276a);
                }
                BuildersKt__Builders_commonKt.d(ViewModelKt.a(zzbjVar), null, null, new zzbf(arrayList2, zzbjVar, null), 3, null);
            }
        }
        return Unit.f139807a;
    }

    static /* synthetic */ void K0(zzbj zzbjVar, String str, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        zzbjVar.f79263d.n(e3);
        Log.w("PlaceDetailsViewModel", "Failed to load details for ".concat(String.valueOf(str)));
    }

    static /* synthetic */ void L0(zzbj zzbjVar, LatLng latLng, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        zzbjVar.f79263d.n(e3);
        new StringBuilder(String.valueOf(latLng).length() + 27);
        Objects.toString(latLng);
        Log.w("PlaceDetailsViewModel", "Failed to load details for ".concat(String.valueOf(latLng)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object M0(PhotoMetadata photoMetadata, int i3, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        FetchResolvedPhotoUriRequest.Builder builderB = FetchResolvedPhotoUriRequest.b(photoMetadata);
        builderB.f(Boxing.d(i3));
        builderB.e(Boxing.d(i3));
        FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequestA = builderB.a();
        Log.i("PlaceDetailsViewModel", "Resolving photo URI.");
        PlacesClient placesClient = this.f79271m;
        Task taskF = placesClient != null ? placesClient.f(fetchResolvedPhotoUriRequestA, zzmy.PLACES_UI_KIT) : null;
        if (taskF != null) {
            final zzbg zzbgVar = new zzbg(cancellableContinuationImpl);
            taskF.addOnSuccessListener(new OnSuccessListener(zzbgVar) { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbi

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final /* synthetic */ Function1 f79260a;

                {
                    Intrinsics.checkNotNullParameter(zzbgVar, "function");
                    this.f79260a = zzbgVar;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    this.f79260a.invoke(obj);
                }
            });
        }
        if (taskF != null) {
            taskF.addOnFailureListener(new zzbh(cancellableContinuationImpl));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public final LiveData A0() {
        return this.f79264f;
    }

    public final List B0() {
        return this.f79267i;
    }

    public final MutableLiveData C0() {
        return this.f79269k;
    }

    public final zzpt D0() {
        if (this.f79270l == null) {
            zzps zzpsVarA = zzpr.a();
            zzpsVarA.zzc(y0().getApplicationContext());
            zzpsVarA.a(zzmy.PLACES_UI_KIT);
            this.f79270l = zzpsVarA.zza();
        }
        return this.f79270l;
    }

    public final void E0(final String placeId, final zzbd configuration) {
        Intrinsics.checkNotNullParameter(placeId, "placeId");
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        for (int i3 = 0; i3 < 3; i3++) {
            ((MutableLiveData) this.f79265g.get(i3)).n(zzbn.f79275a);
        }
        zzpt zzptVarD0 = D0();
        this.f79271m = zzptVarD0 != null ? zzptVarD0.zzc() : null;
        FetchPlaceRequest fetchPlaceRequestG = FetchPlaceRequest.g(placeId, configuration.b());
        PlacesClient placesClient = this.f79271m;
        Task taskG = placesClient != null ? placesClient.g(fetchPlaceRequestG, zzmy.PLACES_UI_KIT) : null;
        if (taskG != null) {
            final Function1 function1 = new Function1() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbb
                @Override // kotlin.jvm.functions.Function1
                public final /* synthetic */ Object invoke(Object obj) {
                    return zzbj.J0(this.f79244a, configuration, (FetchPlaceResponse) obj);
                }
            };
            taskG.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzaw
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            });
        }
        if (taskG != null) {
            taskG.addOnFailureListener(new OnFailureListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzax
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final /* synthetic */ void onFailure(Exception exc) {
                    zzbj.K0(this.f79236a, placeId, exc);
                }
            });
        }
    }

    public final void F0() {
        this.f79268j.n(Unit.f139807a);
    }

    public final zzpu G0() {
        zzpt zzptVarD0 = D0();
        if (zzptVarD0 != null) {
            return zzptVarD0.zzd();
        }
        return null;
    }

    public final ArrayList H0() {
        List listR;
        ArrayList arrayList = new ArrayList();
        Place place = (Place) this.f79261b.f();
        if (place != null && (listR = place.R()) != null) {
            int size = listR.size();
            for (int i3 = 0; i3 < size; i3++) {
                PhotoMetadata photoMetadata = (PhotoMetadata) listR.get(i3);
                Uri uriI = photoMetadata.i();
                String strD = null;
                String string = uriI != null ? uriI.toString() : null;
                AuthorAttributions authorAttributionsD = photoMetadata.d();
                AuthorAttribution authorAttribution = authorAttributionsD != null ? (AuthorAttribution) authorAttributionsD.c().get(0) : null;
                MutableLiveData mutableLiveData = (MutableLiveData) CollectionsKt.getOrNull(this.f79266h, i3);
                zzbq zzbqVar = mutableLiveData != null ? (zzbq) mutableLiveData.f() : null;
                Intrinsics.checkNotNull(zzbqVar, "null cannot be cast to non-null type com.google.android.libraries.places.widget.internal.placedetails.PlaceImage.ImageUri");
                String string2 = ((zzbm) zzbqVar).a().toString();
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                MutableLiveData mutableLiveData2 = (MutableLiveData) CollectionsKt.getOrNull(this.f79265g, i3);
                zzbq zzbqVar2 = mutableLiveData2 != null ? (zzbq) mutableLiveData2.f() : null;
                zzbm zzbmVar = zzbqVar2 instanceof zzbm ? (zzbm) zzbqVar2 : null;
                String string3 = zzbmVar != null ? zzbmVar.a().toString() : null;
                String name = authorAttribution != null ? authorAttribution.getName() : null;
                String strC = authorAttribution != null ? authorAttribution.c() : null;
                if (authorAttribution != null) {
                    strD = authorAttribution.d();
                }
                arrayList.add(new com.google.android.libraries.places.widget.internal.photoviewer.zzd(string2, string3, string, name, strC, strD));
            }
        }
        return arrayList;
    }

    public final LiveData z0() {
        return this.f79262c;
    }
}
