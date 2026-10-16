package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultDraggable2DState$drag$2", f = "Draggable2D.kt", l = {320}, m = "invokeSuspend")
final class DefaultDraggable2DState$drag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DefaultDraggable2DState f5591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutatePriority f5592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function2 f5593d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultDraggable2DState$drag$2(DefaultDraggable2DState defaultDraggable2DState, MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f5591b = defaultDraggable2DState;
        this.f5592c = mutatePriority;
        this.f5593d = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultDraggable2DState$drag$2(this.f5591b, this.f5592c, this.f5593d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5590a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutatorMutex mutatorMutex = this.f5591b.f5589c;
            Drag2DScope drag2DScope = this.f5591b.f5588b;
            MutatePriority mutatePriority = this.f5592c;
            Function2 function2 = this.f5593d;
            this.f5590a = 1;
            if (mutatorMutex.f(drag2DScope, mutatePriority, function2, this) == objF) {
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
        return ((DefaultDraggable2DState$drag$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
