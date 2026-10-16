package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.DraggableNode$onDragStopped$1", f = "Draggable.kt", l = {316}, m = "invokeSuspend")
final class DraggableNode$onDragStopped$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DraggableNode f5938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f5939d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DraggableNode$onDragStopped$1(DraggableNode draggableNode, long j3, Continuation continuation) {
        super(2, continuation);
        this.f5938c = draggableNode;
        this.f5939d = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        DraggableNode$onDragStopped$1 draggableNode$onDragStopped$1 = new DraggableNode$onDragStopped$1(this.f5938c, this.f5939d, continuation);
        draggableNode$onDragStopped$1.f5937b = obj;
        return draggableNode$onDragStopped$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5936a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.f5937b;
            Function3 function3 = this.f5938c.f5924q;
            Float fC = Boxing.c(DraggableKt.k(this.f5938c.T2(this.f5939d), this.f5938c.f5921n));
            this.f5936a = 1;
            if (function3.invoke(coroutineScope, fC, this) == objF) {
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
        return ((DraggableNode$onDragStopped$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
