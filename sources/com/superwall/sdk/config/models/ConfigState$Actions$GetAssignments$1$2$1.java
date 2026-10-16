package com.superwall.sdk.config.models;

import com.superwall.sdk.config.ConfigContext;
import com.superwall.sdk.config.models.ConfigState;
import com.superwall.sdk.models.assignment.Assignment;
import java.util.List;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.superwall.sdk.config.models.ConfigState$Actions$GetAssignments$1$2$1", f = "ConfigState.kt", l = {}, m = "invokeSuspend")
final class ConfigState$Actions$GetAssignments$1$2$1 extends SuspendLambda implements Function2<List<? extends Assignment>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ConfigContext $$this$exec;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ConfigState$Actions$GetAssignments$1$2$1(ConfigContext configContext, Continuation<? super ConfigState$Actions$GetAssignments$1$2$1> continuation) {
        super(2, continuation);
        this.$$this$exec = configContext;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ConfigState$Actions$GetAssignments$1$2$1(this.$$this$exec, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.$$this$exec.getPaywallPreload().invalidatePreloadFingerprint$superwall_release();
        this.$$this$exec.effect(ConfigState.Actions.PreloadIfEnabled.INSTANCE);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(List<Assignment> list, Continuation<? super Unit> continuation) {
        return ((ConfigState$Actions$GetAssignments$1$2$1) create(list, continuation)).invokeSuspend(Unit.f139807a);
    }
}
