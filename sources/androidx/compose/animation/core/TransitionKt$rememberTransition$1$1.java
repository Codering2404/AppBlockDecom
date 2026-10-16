package androidx.compose.animation.core;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.animation.core.TransitionKt$rememberTransition$1$1", f = "Transition.kt", l = {2147}, m = "invokeSuspend")
final class TransitionKt$rememberTransition$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f4273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f4274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f4275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TransitionState f4276d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransitionKt$rememberTransition$1$1(TransitionState transitionState, Continuation continuation) {
        super(2, continuation);
        this.f4276d = transitionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TransitionKt$rememberTransition$1$1(this.f4276d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutexH;
        TransitionState transitionState;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f4275c;
        if (i3 == 0) {
            ResultKt.b(obj);
            ((SeekableTransitionState) this.f4276d).L();
            mutexH = ((SeekableTransitionState) this.f4276d).H();
            TransitionState transitionState2 = this.f4276d;
            this.f4273a = mutexH;
            this.f4274b = transitionState2;
            this.f4275c = 1;
            if (mutexH.f(null, this) == objF) {
                return objF;
            }
            transitionState = transitionState2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            transitionState = (TransitionState) this.f4274b;
            mutexH = (Mutex) this.f4273a;
            ResultKt.b(obj);
        }
        try {
            ((SeekableTransitionState) transitionState).S(transitionState.b());
            CancellableContinuation cancellableContinuationG = ((SeekableTransitionState) transitionState).G();
            if (cancellableContinuationG != null) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationG.resumeWith(Result.b(transitionState.b()));
            }
            ((SeekableTransitionState) transitionState).T(null);
            Unit unit = Unit.f139807a;
            mutexH.i(null);
            return Unit.f139807a;
        } catch (Throwable th) {
            mutexH.i(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TransitionKt$rememberTransition$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
