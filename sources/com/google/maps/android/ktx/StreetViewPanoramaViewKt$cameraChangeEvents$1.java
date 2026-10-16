package com.google.maps.android.ktx;

import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
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
@DebugMetadata(c = "com.google.maps.android.ktx.StreetViewPanoramaViewKt$cameraChangeEvents$1", f = "StreetViewPanoramaView.kt", l = {41}, m = "invokeSuspend")
final class StreetViewPanoramaViewKt$cameraChangeEvents$1 extends SuspendLambda implements Function2<ProducerScope<? super StreetViewPanoramaCamera>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f91494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f91495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StreetViewPanorama f91496c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StreetViewPanoramaViewKt$cameraChangeEvents$1(StreetViewPanorama streetViewPanorama, Continuation continuation) {
        super(2, continuation);
        this.f91496c = streetViewPanorama;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ProducerScope producerScope, StreetViewPanoramaCamera streetViewPanoramaCamera) {
        producerScope.h(streetViewPanoramaCamera);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StreetViewPanoramaViewKt$cameraChangeEvents$1 streetViewPanoramaViewKt$cameraChangeEvents$1 = new StreetViewPanoramaViewKt$cameraChangeEvents$1(this.f91496c, continuation);
        streetViewPanoramaViewKt$cameraChangeEvents$1.f91495b = obj;
        return streetViewPanoramaViewKt$cameraChangeEvents$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f91494a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f91495b;
            this.f91496c.b(new StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener() { // from class: com.google.maps.android.ktx.v
                @Override // com.google.android.gms.maps.StreetViewPanorama.OnStreetViewPanoramaCameraChangeListener
                public final void a(StreetViewPanoramaCamera streetViewPanoramaCamera) {
                    StreetViewPanoramaViewKt$cameraChangeEvents$1.y(producerScope, streetViewPanoramaCamera);
                }
            });
            final StreetViewPanorama streetViewPanorama = this.f91496c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.google.maps.android.ktx.StreetViewPanoramaViewKt$cameraChangeEvents$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m401invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m401invoke() {
                    streetViewPanorama.b(null);
                }
            };
            this.f91494a = 1;
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

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((StreetViewPanoramaViewKt$cameraChangeEvents$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
