package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2", f = "Recomposer.kt", l = {}, m = "invokeSuspend")
final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f24132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Recomposer f24133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ControlledComposition f24134c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(Recomposer recomposer, ControlledComposition controlledComposition, Continuation continuation) {
        super(2, continuation);
        this.f24133b = recomposer;
        this.f24134c = controlledComposition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2(this.f24133b, this.f24134c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CancellableContinuation cancellableContinuationM0;
        IntrinsicsKt.f();
        if (this.f24132a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        ControlledComposition controlledCompositionC0 = this.f24133b.C0(this.f24134c, null);
        Object obj2 = this.f24133b.f24037c;
        Recomposer recomposer = this.f24133b;
        synchronized (obj2) {
            if (controlledCompositionC0 != null) {
                try {
                    recomposer.f24044j.add(controlledCompositionC0);
                } catch (Throwable th) {
                    throw th;
                }
            }
            recomposer.f24053s--;
            cancellableContinuationM0 = recomposer.m0();
        }
        if (cancellableContinuationM0 != null) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationM0.resumeWith(Result.b(Unit.f139807a));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$2$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
