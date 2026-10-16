package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2", f = "AnchoredDraggable.kt", l = {1391, 1409, 1433}, m = "invokeSuspend")
final class AnchoredDraggableKt$animateToWithDecay$2 extends SuspendLambda implements Function4<AnchoredDragScope, DraggableAnchors<Object>, Object, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f5409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f5410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f5411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f5412d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnchoredDraggableState f5413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f5414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f5415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Ref.FloatRef f5416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ DecayAnimationSpec f5417j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AnchoredDraggableKt$animateToWithDecay$2(AnchoredDraggableState anchoredDraggableState, float f3, AnimationSpec animationSpec, Ref.FloatRef floatRef, DecayAnimationSpec decayAnimationSpec, Continuation continuation) {
        super(4, continuation);
        this.f5413f = anchoredDraggableState;
        this.f5414g = f3;
        this.f5415h = animationSpec;
        this.f5416i = floatRef;
        this.f5417j = decayAnimationSpec;
    }

    @Override // kotlin.jvm.functions.Function4
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Object obj, Continuation continuation) {
        AnchoredDraggableKt$animateToWithDecay$2 anchoredDraggableKt$animateToWithDecay$2 = new AnchoredDraggableKt$animateToWithDecay$2(this.f5413f, this.f5414g, this.f5415h, this.f5416i, this.f5417j, continuation);
        anchoredDraggableKt$animateToWithDecay$2.f5410b = anchoredDragScope;
        anchoredDraggableKt$animateToWithDecay$2.f5411c = draggableAnchors;
        anchoredDraggableKt$animateToWithDecay$2.f5412d = obj;
        return anchoredDraggableKt$animateToWithDecay$2.invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.i(r1, r1, false, r3, r24, 2, null) != r7) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00d5, code lost:
    
        if (androidx.compose.foundation.gestures.AnchoredDraggableKt.k(r0, r16, r2, r4, r5, r5, r24) != r7) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        if (androidx.compose.foundation.gestures.AnchoredDraggableKt.k(r0, r12, r0, r4, r5, r5, r24) == r7) goto L44;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
