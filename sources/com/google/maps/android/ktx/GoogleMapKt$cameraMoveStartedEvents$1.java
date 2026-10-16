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
@DebugMetadata(c = "com.google.maps.android.ktx.GoogleMapKt$cameraMoveStartedEvents$1", f = "GoogleMap.kt", l = {222}, m = "invokeSuspend")
final class GoogleMapKt$cameraMoveStartedEvents$1 extends SuspendLambda implements Function2<ProducerScope<? super Integer>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f91419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f91420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleMap f91421c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleMapKt$cameraMoveStartedEvents$1(GoogleMap googleMap, Continuation continuation) {
        super(2, continuation);
        this.f91421c = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(ProducerScope producerScope, int i3) {
        producerScope.h(Integer.valueOf(i3));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        GoogleMapKt$cameraMoveStartedEvents$1 googleMapKt$cameraMoveStartedEvents$1 = new GoogleMapKt$cameraMoveStartedEvents$1(this.f91421c, continuation);
        googleMapKt$cameraMoveStartedEvents$1.f91420b = obj;
        return googleMapKt$cameraMoveStartedEvents$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f91419a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f91420b;
            this.f91421c.B(new GoogleMap.OnCameraMoveStartedListener() { // from class: com.google.maps.android.ktx.h
                @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
                public final void a(int i4) {
                    GoogleMapKt$cameraMoveStartedEvents$1.y(producerScope, i4);
                }
            });
            final GoogleMap googleMap = this.f91421c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.google.maps.android.ktx.GoogleMapKt$cameraMoveStartedEvents$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m385invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m385invoke() {
                    googleMap.B(null);
                }
            };
            this.f91419a = 1;
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
        return ((GoogleMapKt$cameraMoveStartedEvents$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
