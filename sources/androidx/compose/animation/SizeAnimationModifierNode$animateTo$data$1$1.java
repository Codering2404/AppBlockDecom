package androidx.compose.animation;

import androidx.compose.animation.SizeAnimationModifierNode;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationEndReason;
import androidx.compose.animation.core.AnimationResult;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.unit.IntSize;
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
@DebugMetadata(c = "androidx.compose.animation.SizeAnimationModifierNode$animateTo$data$1$1", f = "AnimationModifier.kt", l = {230}, m = "invokeSuspend")
final class SizeAnimationModifierNode$animateTo$data$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3726a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SizeAnimationModifierNode.AnimData f3727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f3728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SizeAnimationModifierNode f3729d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SizeAnimationModifierNode$animateTo$data$1$1(SizeAnimationModifierNode.AnimData animData, long j3, SizeAnimationModifierNode sizeAnimationModifierNode, Continuation continuation) {
        super(2, continuation);
        this.f3727b = animData;
        this.f3728c = j3;
        this.f3729d = sizeAnimationModifierNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SizeAnimationModifierNode$animateTo$data$1$1(this.f3727b, this.f3728c, this.f3729d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        SizeAnimationModifierNode$animateTo$data$1$1 sizeAnimationModifierNode$animateTo$data$1$1;
        Function2 function2Q2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f3726a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatableA = this.f3727b.a();
            IntSize intSizeB = IntSize.b(this.f3728c);
            AnimationSpec animationSpecP2 = this.f3729d.p2();
            this.f3726a = 1;
            sizeAnimationModifierNode$animateTo$data$1$1 = this;
            obj = Animatable.f(animatableA, intSizeB, animationSpecP2, null, null, sizeAnimationModifierNode$animateTo$data$1$1, 12, null);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            sizeAnimationModifierNode$animateTo$data$1$1 = this;
        }
        AnimationResult animationResult = (AnimationResult) obj;
        if (animationResult.a() == AnimationEndReason.f3831b && (function2Q2 = sizeAnimationModifierNode$animateTo$data$1$1.f3729d.q2()) != null) {
            function2Q2.invoke(IntSize.b(sizeAnimationModifierNode$animateTo$data$1$1.f3727b.b()), animationResult.b().getValue());
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SizeAnimationModifierNode$animateTo$data$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
