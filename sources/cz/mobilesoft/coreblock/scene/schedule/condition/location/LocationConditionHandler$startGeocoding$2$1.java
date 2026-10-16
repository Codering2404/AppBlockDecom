package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.location.Address;
import com.google.android.gms.maps.model.LatLng;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.location.GeofenceHelper;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$startGeocoding$2$1", f = "LocationConditionScreenViewModel.kt", l = {384}, m = "invokeSuspend", v = 1)
final class LocationConditionHandler$startGeocoding$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f115356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f115357d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f115358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ LocationConditionHandler f115359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LatLng f115360h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionHandler$startGeocoding$2$1(LocationConditionHandler locationConditionHandler, LatLng latLng, Continuation continuation) {
        super(2, continuation);
        this.f115359g = locationConditionHandler;
        this.f115360h = latLng;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationConditionHandler$startGeocoding$2$1(this.f115359g, this.f115360h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        LocationConditionHandler locationConditionHandler;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115358f;
        if (i3 == 0) {
            ResultKt.b(obj);
            Address addressQ = GeofenceHelper.f128735a.q(this.f115359g.getContext(), this.f115360h);
            if (addressQ != null) {
                LocationConditionHandler locationConditionHandler2 = this.f115359g;
                LocationConfigurationViewState locationConfigurationViewStateO = locationConditionHandler2.o();
                Success success = Success.f128020a;
                Locale locale = addressQ.getLocale();
                Intrinsics.checkNotNullExpressionValue(locale, "getLocale(...)");
                locationConditionHandler2.f0(LocationConfigurationViewState.d(locationConfigurationViewStateO, 0, null, false, null, null, null, GeofenceHelper.r(locale), addressQ.getFeatureName(), addressQ.getAdminArea(), addressQ.getSubAdminArea(), addressQ.getLocality(), addressQ.getSubLocality(), addressQ.getThoroughfare(), addressQ.getSubThoroughfare(), addressQ.getPremises(), addressQ.getPostalCode(), addressQ.getCountryCode(), addressQ.getCountryName(), null, success, null, null, null, 7602239, null));
            } else {
                LocationConditionHandler locationConditionHandler3 = this.f115359g;
                locationConditionHandler3.f0(LocationConfigurationViewState.d(locationConditionHandler3.o(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new FailedWithError(null, null, null, null, 15, null), null, null, null, 7864319, null));
            }
            Mutex mutexL = this.f115359g.L();
            LocationConditionHandler locationConditionHandler4 = this.f115359g;
            this.f115354a = SpillingKt.a(addressQ);
            this.f115355b = mutexL;
            this.f115356c = locationConditionHandler4;
            this.f115357d = 0;
            this.f115358f = 1;
            if (mutexL.f(null, this) == objF) {
                return objF;
            }
            mutex = mutexL;
            locationConditionHandler = locationConditionHandler4;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            locationConditionHandler = (LocationConditionHandler) this.f115356c;
            mutex = (Mutex) this.f115355b;
            ResultKt.b(obj);
        }
        try {
            locationConditionHandler.P(null);
            Unit unit = Unit.f139807a;
            mutex.i(null);
            return Unit.f139807a;
        } catch (Throwable th) {
            mutex.i(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationConditionHandler$startGeocoding$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
