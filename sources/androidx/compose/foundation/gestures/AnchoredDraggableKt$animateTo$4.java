package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$4", f = "AnchoredDraggable.kt", l = {1344}, m = "invokeSuspend")
final class AnchoredDraggableKt$animateTo$4 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<Object>, Object, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f5401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f5402d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f5403f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f5404g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateTo$4(AnchoredDraggableState anchoredDraggableState, AnimationSpec animationSpec, Continuation continuation) {
        super(4, continuation);
        this.f5403f = anchoredDraggableState;
        this.f5404g = animationSpec;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Object obj, Continuation continuation) {
        AnchoredDraggableKt$animateTo$4 anchoredDraggableKt$animateTo$4 = new AnchoredDraggableKt$animateTo$4(this.f5403f, this.f5404g, continuation);
        anchoredDraggableKt$animateTo$4.f5400b = anchoredDragScope;
        anchoredDraggableKt$animateTo$4.f5401c = draggableAnchors;
        anchoredDraggableKt$animateTo$4.f5402d = obj;
        return anchoredDraggableKt$animateTo$4.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5399a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f5400b;
            DraggableAnchors draggableAnchors = (DraggableAnchors) this.f5401c;
            Object obj2 = this.f5402d;
            AnchoredDraggableState anchoredDraggableState = this.f5403f;
            float fQ = anchoredDraggableState.q();
            AnimationSpec animationSpec = this.f5404g;
            this.f5400b = null;
            this.f5401c = null;
            this.f5399a = 1;
            if (AnchoredDraggableKt.k(anchoredDraggableState, fQ, anchoredDragScope, draggableAnchors, obj2, animationSpec, this) == objF) {
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
