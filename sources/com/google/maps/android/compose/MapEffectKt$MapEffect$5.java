package com.google.maps.android.compose;

import com.google.android.gms.maps.GoogleMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.maps.android.compose.MapEffectKt$MapEffect$5", f = "MapEffect.kt", l = {71}, m = "invokeSuspend")
final class MapEffectKt$MapEffect$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f90903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f90904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function3 f90905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ GoogleMap f90906d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MapEffectKt$MapEffect$5(Function3 function3, GoogleMap googleMap, Continuation continuation) {
        super(2, continuation);
        this.f90905c = function3;
        this.f90906d = googleMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MapEffectKt$MapEffect$5 mapEffectKt$MapEffect$5 = new MapEffectKt$MapEffect$5(this.f90905c, this.f90906d, continuation);
        mapEffectKt$MapEffect$5.f90904b = obj;
        return mapEffectKt$MapEffect$5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f90903a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f90904b;
            Function3 function3 = this.f90905c;
            GoogleMap googleMap = this.f90906d;
            this.f90903a = 1;
            if (function3.invoke(coroutineScope, googleMap, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MapEffectKt$MapEffect$5) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
