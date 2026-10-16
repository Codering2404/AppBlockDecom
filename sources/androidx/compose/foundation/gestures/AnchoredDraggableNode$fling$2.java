package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2", f = "AnchoredDraggable.kt", l = {469}, m = "invokeSuspend")
final class AnchoredDraggableNode$fling$2<T> extends SuspendLambda implements Function3<AnchoredDragScope, DraggableAnchors<T>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableNode f5467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f5468d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f5469f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableNode$fling$2(AnchoredDraggableNode anchoredDraggableNode, Ref.FloatRef floatRef, float f3, Continuation continuation) {
        super(3, continuation);
        this.f5467c = anchoredDraggableNode;
        this.f5468d = floatRef;
        this.f5469f = f3;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Continuation continuation) {
        AnchoredDraggableNode$fling$2 anchoredDraggableNode$fling$2 = new AnchoredDraggableNode$fling$2(this.f5467c, this.f5468d, this.f5469f, continuation);
        anchoredDraggableNode$fling$2.f5466b = anchoredDragScope;
        return anchoredDraggableNode$fling$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.FloatRef floatRef;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5465a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f5466b;
            final AnchoredDraggableNode anchoredDraggableNode = this.f5467c;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableNode$fling$2$scrollScope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public float d(float f3) {
                    float fZ = anchoredDraggableNode.f5445m.z(f3);
                    float fR = fZ - anchoredDraggableNode.f5445m.r();
                    AnchoredDragScope.b(anchoredDragScope, fZ, 0.0f, 2, null);
                    return fR;
                }
            };
            FlingBehavior flingBehaviorY2 = this.f5467c.Y2();
            Ref.FloatRef floatRef2 = this.f5468d;
            float f3 = this.f5469f;
            this.f5466b = floatRef2;
            this.f5465a = 1;
            obj = flingBehaviorY2.a(scrollScope, f3, this);
            if (obj == objF) {
                return objF;
            }
            floatRef = floatRef2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            floatRef = (Ref.FloatRef) this.f5466b;
            ResultKt.b(obj);
        }
        floatRef.f140141a = ((Number) obj).floatValue();
        return Unit.f139807a;
    }
}
