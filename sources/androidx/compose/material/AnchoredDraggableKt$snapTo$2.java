package androidx.compose.material;

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
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$snapTo$2", f = "AnchoredDraggable.kt", l = {}, m = "invokeSuspend")
final class AnchoredDraggableKt$snapTo$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<Object>, Object, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f11685b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f11686c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f11687d;

    AnchoredDraggableKt$snapTo$2(Continuation continuation) {
        super(4, continuation);
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Object obj, Continuation continuation) {
        AnchoredDraggableKt$snapTo$2 anchoredDraggableKt$snapTo$2 = new AnchoredDraggableKt$snapTo$2(continuation);
        anchoredDraggableKt$snapTo$2.f11685b = anchoredDragScope;
        anchoredDraggableKt$snapTo$2.f11686c = draggableAnchors;
        anchoredDraggableKt$snapTo$2.f11687d = obj;
        return anchoredDraggableKt$snapTo$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f11684a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f11685b;
        float fC = ((DraggableAnchors) this.f11686c).c(this.f11687d);
        if (!Float.isNaN(fC)) {
            AnchoredDragScope.b(anchoredDragScope, fC, 0.0f, 2, null);
        }
        return Unit.f139807a;
    }
}
