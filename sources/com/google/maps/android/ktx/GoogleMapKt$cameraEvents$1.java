package com.google.maps.android.ktx;

import com.google.android.gms.maps.GoogleMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.maps.android.ktx.GoogleMapKt$cameraEvents$1", f = "GoogleMap.kt", l = {113}, m = "invokeSuspend")
final class GoogleMapKt$cameraEvents$1 extends SuspendLambda implements Function2<ProducerScope<? super CameraEvent>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f91403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f91404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleMap f91405c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleMapKt$cameraEvents$1(GoogleMap googleMap, Continuation continuation) {
        super(2, continuation);
        this.f91405c = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ProducerScope producerScope) {
        producerScope.h(CameraIdleEvent.f91396a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ProducerScope producerScope) {
        producerScope.h(CameraMoveCanceledEvent.f91397a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ProducerScope producerScope) {
        producerScope.h(CameraMoveEvent.f91398a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ProducerScope producerScope, int i3) {
        producerScope.h(new CameraMoveStartedEvent(i3));
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((GoogleMapKt$cameraEvents$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GoogleMapKt$cameraEvents$1 googleMapKt$cameraEvents$1 = new GoogleMapKt$cameraEvents$1(this.f91405c, continuation);
        googleMapKt$cameraEvents$1.f91404b = obj;
        return googleMapKt$cameraEvents$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f91403a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f91404b;
            this.f91405c.y(new GoogleMap.OnCameraIdleListener() { // from class: com.google.maps.android.ktx.a
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
                public final void a() {
                    GoogleMapKt$cameraEvents$1.G(producerScope);
                }
            });
            this.f91405c.z(new GoogleMap.OnCameraMoveCanceledListener() { // from class: com.google.maps.android.ktx.b
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveCanceledListener
                public final void a() {
                    GoogleMapKt$cameraEvents$1.J(producerScope);
                }
            });
            this.f91405c.A(new GoogleMap.OnCameraMoveListener() { // from class: com.google.maps.android.ktx.c
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
                public final void a() {
                    GoogleMapKt$cameraEvents$1.K(producerScope);
                }
            });
            this.f91405c.B(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.google.maps.android.ktx.d
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
                public final void a(int i4) {
                    GoogleMapKt$cameraEvents$1.L(producerScope, i4);
                }
            });
            final GoogleMap googleMap = this.f91405c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.google.maps.android.ktx.GoogleMapKt$cameraEvents$1.5
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m381invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m381invoke() {
                    googleMap.y(null);
                    googleMap.z(null);
                    googleMap.A(null);
                    googleMap.B(null);
                }
            };
            this.f91403a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
