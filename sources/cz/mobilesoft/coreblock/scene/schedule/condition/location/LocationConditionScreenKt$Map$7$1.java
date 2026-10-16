package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.compose.CameraPositionState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$Map$7$1", f = "LocationConditionScreen.kt", l = {732}, m = "invokeSuspend", v = 1)
final class LocationConditionScreenKt$Map$7$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f115395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f115396d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f115397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f115398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LocationConfigurationViewState f115399h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f115400i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ boolean f115401j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ CameraPositionState f115402k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionScreenKt$Map$7$1(LocationConfigurationViewState locationConfigurationViewState, boolean z2, boolean z3, CameraPositionState cameraPositionState, Continuation continuation) {
        super(2, continuation);
        this.f115399h = locationConfigurationViewState;
        this.f115400i = z2;
        this.f115401j = z3;
        this.f115402k = cameraPositionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationConditionScreenKt$Map$7$1(this.f115399h, this.f115400i, this.f115401j, this.f115402k, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115398g;
        if (i3 == 0) {
            ResultKt.b(obj);
            LatLngBounds latLngBoundsF = this.f115399h.f();
            if (latLngBoundsF != null) {
                LocationConfigurationViewState locationConfigurationViewState = this.f115399h;
                boolean z2 = this.f115400i;
                boolean z3 = this.f115401j;
                CameraPositionState cameraPositionState = this.f115402k;
                LatLngBounds latLngBoundsF2 = locationConfigurationViewState.f();
                LatLng latLng = latLngBoundsF2.f73165a;
                LatLng latLngJ1 = LocationConditionScreenKt.j1(z2, latLng.f73163a, latLng.f73164b, locationConfigurationViewState.j(), (16 & 16) != 0 ? 0.5d : 0.0d);
                LatLng latLng2 = latLngBoundsF2.f73166b;
                LatLngBounds latLngBounds = new LatLngBounds(latLngJ1, LocationConditionScreenKt.j1(z2, latLng2.f73163a, latLng2.f73164b, locationConfigurationViewState.j(), (16 & 16) != 0 ? 0.5d : 0.0d));
                CameraUpdate cameraUpdateB = CameraUpdateFactory.b(latLngBounds, 100);
                Intrinsics.checkNotNullExpressionValue(cameraUpdateB, "newLatLngBounds(...)");
                if (z3) {
                    this.f115393a = SpillingKt.a(latLngBoundsF);
                    this.f115394b = SpillingKt.a(latLngBoundsF2);
                    this.f115395c = SpillingKt.a(latLngBounds);
                    this.f115396d = SpillingKt.a(cameraUpdateB);
                    this.f115397f = 0;
                    this.f115398g = 1;
                    if (cameraPositionState.i(cameraUpdateB, 1000, this) == objF) {
                        return objF;
                    }
                } else {
                    cameraPositionState.q(cameraUpdateB);
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationConditionScreenKt$Map$7$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
