package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.AutocompleteSessionToken;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPlaceRequest;
import com.google.android.libraries.places.api.net.FetchPlaceResponse;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsRequest;
import com.google.android.libraries.places.api.net.FindAutocompletePredictionsResponse;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.statistics.di.BaseViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LocationPlacesSelectViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PlacesClient f115466f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AutocompleteSessionToken f115467g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableLiveData f115468h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableLiveData f115469i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableLiveData f115470j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableLiveData f115471k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Mutex f115472l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Job f115473m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocationPlacesSelectViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        AutocompleteSessionToken autocompleteSessionTokenC = AutocompleteSessionToken.c();
        Intrinsics.checkNotNullExpressionValue(autocompleteSessionTokenC, "newInstance(...)");
        this.f115467g = autocompleteSessionTokenC;
        Application applicationY0 = y0();
        Places.b(applicationY0, applicationY0.getPackageManager().getApplicationInfo(applicationY0.getPackageName(), ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).metaData.getString("com.google.android.geo.API_KEY", ""));
        PlacesClient placesClientA = Places.a(applicationY0);
        Intrinsics.checkNotNullExpressionValue(placesClientA, "createClient(...)");
        this.f115466f = placesClientA;
        this.f115468h = new MutableLiveData(CollectionsKt.emptyList());
        Success success = Success.f128020a;
        this.f115469i = new MutableLiveData(success);
        this.f115470j = new MutableLiveData();
        this.f115471k = new MutableLiveData(success);
        this.f115472l = MutexKt.b(false, 1, null);
    }

    private final void K0() {
        BuildersKt__Builders_commonKt.d(this, null, null, new LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(LocationPlacesSelectViewModel locationPlacesSelectViewModel, FetchPlaceResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        LatLng latLngJ = response.a().J();
        if (latLngJ != null) {
            locationPlacesSelectViewModel.U0();
            locationPlacesSelectViewModel.f115470j.n(latLngJ);
            locationPlacesSelectViewModel.f115471k.n(Success.f128020a);
        } else {
            locationPlacesSelectViewModel.f115471k.n(new FailedWithError(null, null, null, null, 15, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S0(LocationPlacesSelectViewModel locationPlacesSelectViewModel, Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        locationPlacesSelectViewModel.f115471k.n(new FailedWithError(exception, null, null, null, 14, null));
    }

    private final void U0() {
        AutocompleteSessionToken autocompleteSessionTokenC = AutocompleteSessionToken.c();
        Intrinsics.checkNotNullExpressionValue(autocompleteSessionTokenC, "newInstance(...)");
        this.f115467g = autocompleteSessionTokenC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V0(String str) {
        Task taskC = this.f115466f.c(FindAutocompletePredictionsRequest.b().m(this.f115467g).k(str).a());
        final Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.r1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectViewModel.W0(this.f115604a, (FindAutocompletePredictionsResponse) obj);
            }
        };
        taskC.addOnSuccessListener(new OnSuccessListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.s1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                LocationPlacesSelectViewModel.X0(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.t1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationPlacesSelectViewModel.Y0(this.f115623a, exc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(LocationPlacesSelectViewModel locationPlacesSelectViewModel, FindAutocompletePredictionsResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        locationPlacesSelectViewModel.f115468h.n(response.a());
        locationPlacesSelectViewModel.f115469i.n(Success.f128020a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X0(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(LocationPlacesSelectViewModel locationPlacesSelectViewModel, Exception exc) {
        if (exc != null) {
            exc.printStackTrace();
        }
        CrashHelper.j(exc);
        locationPlacesSelectViewModel.f115468h.n(CollectionsKt.emptyList());
        locationPlacesSelectViewModel.f115469i.n(Success.f128020a);
    }

    public final MutableLiveData L0() {
        return this.f115471k;
    }

    public final MutableLiveData M0() {
        return this.f115470j;
    }

    public final MutableLiveData N0() {
        return this.f115468h;
    }

    public final MutableLiveData O0() {
        return this.f115469i;
    }

    public final void P0(AutocompletePrediction prediction) {
        Intrinsics.checkNotNullParameter(prediction, "prediction");
        this.f115471k.n(Loading.f127895a);
        Task taskI = this.f115466f.i(FetchPlaceRequest.b(prediction.d(), CollectionsKt.listOf(Place.Field.LOCATION)).c(this.f115467g).a());
        final Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.u1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LocationPlacesSelectViewModel.Q0(this.f115637a, (FetchPlaceResponse) obj);
            }
        };
        taskI.addOnSuccessListener(new OnSuccessListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.v1
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                LocationPlacesSelectViewModel.R0(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.w1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                LocationPlacesSelectViewModel.S0(this.f115659a, exc);
            }
        });
    }

    public final void T0(String query) {
        Intrinsics.checkNotNullParameter(query, "query");
        if (query.length() < 3) {
            K0();
            this.f115468h.n(CollectionsKt.emptyList());
            this.f115469i.n(Success.f128020a);
        } else {
            this.f115469i.n(Loading.f127895a);
            K0();
            BuildersKt__Builders_commonKt.d(this, null, null, new LocationPlacesSelectViewModel$onQueryChanged$1(this, query, null), 3, null);
        }
    }
}
