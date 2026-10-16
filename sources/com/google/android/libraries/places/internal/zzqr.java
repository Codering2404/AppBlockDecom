package com.google.android.libraries.places.internal;

import android.app.Application;
import android.util.Log;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchResolvedPhotoUriRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextResponse;
import com.google.android.libraries.places.api.net.SearchNearbyResponse;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzqr extends AndroidViewModel {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableLiveData f78477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LiveData f78478c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableLiveData f78479d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LiveData f78480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableLiveData f78481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LiveData f78482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PlacesClient f78483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private zzpt f78484j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzqr(Application app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        MutableLiveData mutableLiveData = new MutableLiveData();
        this.f78477b = mutableLiveData;
        this.f78478c = mutableLiveData;
        MutableLiveData mutableLiveData2 = new MutableLiveData();
        this.f78479d = mutableLiveData2;
        this.f78480f = mutableLiveData2;
        MutableLiveData mutableLiveData3 = new MutableLiveData();
        this.f78481g = mutableLiveData3;
        this.f78482h = mutableLiveData3;
    }

    static /* synthetic */ Unit H0(zzqr zzqrVar, SearchByTextResponse searchByTextResponse) {
        zzqrVar.f78477b.n(searchByTextResponse.c());
        List listC = searchByTextResponse.c();
        Intrinsics.checkNotNullExpressionValue(listC, "getPlaces(...)");
        zzqrVar.E0(listC);
        return Unit.f139807a;
    }

    static /* synthetic */ void I0(zzqr zzqrVar, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        zzqrVar.f78479d.n(e3);
    }

    static /* synthetic */ Unit J0(zzqr zzqrVar, SearchNearbyResponse searchNearbyResponse) {
        zzqrVar.f78477b.n(searchNearbyResponse.b());
        List listB = searchNearbyResponse.b();
        Intrinsics.checkNotNullExpressionValue(listB, "getPlaces(...)");
        zzqrVar.E0(listB);
        return Unit.f139807a;
    }

    static /* synthetic */ void K0(zzqr zzqrVar, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        zzqrVar.f78479d.n(e3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object L0(List list, Continuation continuation) {
        PhotoMetadata photoMetadata = list != null ? (PhotoMetadata) CollectionsKt.firstOrNull(list) : null;
        if (photoMetadata == null) {
            Log.i("PlaceSearchViewModel", "No photo metadatas, falling back to placeholder image.");
            return com.google.android.libraries.places.widget.internal.placedetails.zzbp.f79277a;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        FetchResolvedPhotoUriRequest fetchResolvedPhotoUriRequestF = FetchResolvedPhotoUriRequest.f(photoMetadata);
        Log.i("PlaceSearchViewModel", "Resolving photo URI.");
        PlacesClient placesClientC0 = C0();
        Task taskF = placesClientC0 != null ? placesClientC0.f(fetchResolvedPhotoUriRequestF, zzmy.PLACES_UI_KIT) : null;
        if (taskF != null) {
            final zzqo zzqoVar = new zzqo(cancellableContinuationImpl);
            taskF.addOnSuccessListener(new OnSuccessListener(zzqoVar) { // from class: com.google.android.libraries.places.internal.zzqq

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final /* synthetic */ Function1 f78476a;

                {
                    Intrinsics.checkNotNullParameter(zzqoVar, "function");
                    this.f78476a = zzqoVar;
                }

                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final /* synthetic */ void onSuccess(Object obj) {
                    this.f78476a.invoke(obj);
                }
            });
        }
        if (taskF != null) {
            taskF.addOnFailureListener(new zzqp(cancellableContinuationImpl));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public final LiveData A0() {
        return this.f78480f;
    }

    public final LiveData B0() {
        return this.f78482h;
    }

    public final PlacesClient C0() {
        if (this.f78483i == null) {
            zzpt zzptVarD0 = D0();
            this.f78483i = zzptVarD0 != null ? zzptVarD0.zzc() : null;
        }
        return this.f78483i;
    }

    public final zzpt D0() {
        if (this.f78484j == null) {
            zzps zzpsVarA = zzpr.a();
            zzpsVarA.zzc(y0().getApplicationContext());
            zzpsVarA.a(zzmy.PLACES_UI_KIT);
            this.f78484j = zzpsVarA.zza();
        }
        return this.f78484j;
    }

    public final void E0(List places) {
        Intrinsics.checkNotNullParameter(places, "places");
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new zzqn(places, this, null), 3, null);
    }

    @Override // androidx.lifecycle.ViewModel
    protected final void onCleared() {
        System.out.println("onCleared");
        super.onCleared();
        PlacesClient placesClientC0 = C0();
        if (placesClientC0 != null) {
            placesClientC0.zzk();
        }
    }

    public final LiveData z0() {
        return this.f78478c;
    }
}
