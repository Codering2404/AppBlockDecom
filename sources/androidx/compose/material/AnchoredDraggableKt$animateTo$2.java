package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableKt$animateTo$2", f = "AnchoredDraggable.kt", l = {706}, m = "invokeSuspend")
final class AnchoredDraggableKt$animateTo$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<Object>, Object, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f11657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f11658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f11659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f11660d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f11661f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f11662g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateTo$2(AnchoredDraggableState anchoredDraggableState, float f3, Continuation continuation) {
        super(4, continuation);
        this.f11661f = anchoredDraggableState;
        this.f11662g = f3;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Object obj, Continuation continuation) {
        AnchoredDraggableKt$animateTo$2 anchoredDraggableKt$animateTo$2 = new AnchoredDraggableKt$animateTo$2(this.f11661f, this.f11662g, continuation);
        anchoredDraggableKt$animateTo$2.f11658b = anchoredDragScope;
        anchoredDraggableKt$animateTo$2.f11659c = draggableAnchors;
        anchoredDraggableKt$animateTo$2.f11660d = obj;
        return anchoredDraggableKt$animateTo$2.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f11657a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final AnchoredDragScope anchoredDragScope = (AnchoredDragScope) this.f11658b;
            float fC = ((DraggableAnchors) this.f11659c).c(this.f11660d);
            if (!Float.isNaN(fC)) {
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                float fW = Float.isNaN(this.f11661f.w()) ? 0.0f : this.f11661f.w();
                floatRef.f140141a = fW;
                float f3 = this.f11662g;
                AnimationSpec animationSpecP = this.f11661f.p();
                Function2<Float, Float, Unit> function2 = new Function2<Float, Float, Unit>() { // from class: androidx.compose.material.AnchoredDraggableKt$animateTo$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    public final void c(float f4, float f5) {
                        anchoredDragScope.a(f4, f5);
                        floatRef.f140141a = f4;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                        return Unit.f139807a;
                    }
                };
                this.f11658b = null;
                this.f11659c = null;
                this.f11657a = 1;
                if (SuspendAnimationKt.b(fW, fC, f3, animationSpecP, function2, this) == objF) {
                    return objF;
                }
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
