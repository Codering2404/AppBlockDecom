package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2", f = "AnchoredDraggable.kt", l = {408}, m = "invokeSuspend")
final class AnchoredDraggableNode$drag$2<T> extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function2 f5455c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableNode f5456d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$drag$2(Function2 function2, AnchoredDraggableNode anchoredDraggableNode, Continuation continuation) {
        super(3, continuation);
        this.f5455c = function2;
        this.f5456d = anchoredDraggableNode;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Continuation continuation) {
        AnchoredDraggableNode$drag$2 anchoredDraggableNode$drag$2 = new AnchoredDraggableNode$drag$2(this.f5455c, this.f5456d, continuation);
        anchoredDraggableNode$drag$2.f5454b = anchoredDragScope;
        return anchoredDraggableNode$drag$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5453a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f5454b;
            Function2 function2 = this.f5455c;
            final AnchoredDraggableNode anchoredDraggableNode = this.f5456d;
            Function1<DragEvent.DragDelta, Unit> function1 = new Function1<DragEvent.DragDelta, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$drag$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(DragEvent.DragDelta dragDelta) {
                    AnchoredDraggableNode anchoredDraggableNode2 = anchoredDraggableNode;
                    float fE3 = anchoredDraggableNode2.e3(anchoredDraggableNode2.b3(dragDelta.a()));
                    if (anchoredDraggableNode.f5448p == null) {
                        AnchoredDragScope.b(anchoredDragScope, anchoredDraggableNode.f5445m.z(fE3), 0.0f, 2, null);
                        return;
                    }
                    OverscrollEffect overscrollEffect = anchoredDraggableNode.f5448p;
                    Intrinsics.checkNotNull(overscrollEffect);
                    long jF3 = anchoredDraggableNode.f3(fE3);
                    int iB = NestedScrollSource.f26772b.b();
                    final AnchoredDraggableNode anchoredDraggableNode3 = anchoredDraggableNode;
                    final AnchoredDragScope anchoredDragScope2 = anchoredDragScope;
                    overscrollEffect.b(jF3, iB, new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode.drag.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final long c(long j3) {
                            float fZ = anchoredDraggableNode3.f5445m.z(anchoredDraggableNode3.e3(j3));
                            AnchoredDraggableNode anchoredDraggableNode4 = anchoredDraggableNode3;
                            long jF32 = anchoredDraggableNode4.f3(fZ - anchoredDraggableNode4.f5445m.A());
                            AnchoredDragScope.b(anchoredDragScope2, fZ, 0.0f, 2, null);
                            return jF32;
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            return Offset.d(c(((Offset) obj2).u()));
                        }
                    });
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((DragEvent.DragDelta) obj2);
                    return Unit.f139807a;
                }
            };
            this.f5453a = 1;
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
