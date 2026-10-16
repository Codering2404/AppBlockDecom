package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.gestures.Draggable2DNode$drag$2", f = "Draggable2D.kt", l = {257}, m = "invokeSuspend")
final class Draggable2DNode$drag$2 extends SuspendLambda implements Function2<Drag2DScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f5900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Draggable2DNode f5901d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Draggable2DNode$drag$2(Function2 function2, Draggable2DNode draggable2DNode, Continuation continuation) {
        super(2, continuation);
        this.f5900c = function2;
        this.f5901d = draggable2DNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        Draggable2DNode$drag$2 draggable2DNode$drag$2 = new Draggable2DNode$drag$2(this.f5900c, this.f5901d, continuation);
        draggable2DNode$drag$2.f5899b = obj;
        return draggable2DNode$drag$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Drag2DScope drag2DScope, Continuation continuation) {
        return ((Draggable2DNode$drag$2) create(drag2DScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5898a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Drag2DScope drag2DScope = (Drag2DScope) this.f5899b;
            Function2 function2 = this.f5900c;
            final Draggable2DNode draggable2DNode = this.f5901d;
            Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.Draggable2DNode$drag$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(DragEvent.DragDelta dragDelta) {
                    Drag2DScope drag2DScope2 = drag2DScope;
                    Draggable2DNode draggable2DNode2 = draggable2DNode;
                    long jA = dragDelta.a();
                    if (draggable2DNode2.f5895o) {
                        jA = Offset.e(jA ^ (-9223372034707292160L));
                    }
                    drag2DScope2.a(jA);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((DragEvent.DragDelta) obj2);
                    return Unit.f139807a;
                }
            };
            this.f5898a = 1;
            if (function2.invoke(function1, this) == objF) {
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
