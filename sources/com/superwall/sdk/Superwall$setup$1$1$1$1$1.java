package com.superwall.sdk;

import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.TrackingResult;
import com.superwall.sdk.analytics.internal.trackable.Trackable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.Superwall$setup$1$1$1$1$1", f = "Superwall.kt", l = {719}, m = "invokeSuspend")
final class Superwall$setup$1$1$1$1$1 extends SuspendLambda implements Function2<Trackable, Continuation<? super Result<? extends TrackingResult>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ Superwall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Superwall$setup$1$1$1$1$1(Superwall superwall, Continuation<? super Superwall$setup$1$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = superwall;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Superwall$setup$1$1$1$1$1 superwall$setup$1$1$1$1$1 = new Superwall$setup$1$1$1$1$1(this.this$0, continuation);
        superwall$setup$1$1$1$1$1.L$0 = obj;
        return superwall$setup$1$1$1$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Trackable trackable, Continuation<? super Result<TrackingResult>> continuation) {
        return ((Superwall$setup$1$1$1$1$1) create(trackable, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objTrack;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            Trackable trackable = (Trackable) this.L$0;
            Superwall superwall = this.this$0;
            this.label = 1;
            objTrack = TrackingKt.track(superwall, trackable, this);
            if (objTrack == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            objTrack = ((Result) obj).j();
        }
        return Result.a(objTrack);
    }
}
