package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "androidx.compose.animation.core.DeferredTargetAnimation$updateTarget$1", f = "DeferredTargetAnimation.kt", l = {76}, m = "invokeSuspend")
final class DeferredTargetAnimation$updateTarget$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f3915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeferredTargetAnimation f3916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Object f3917d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f3918f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeferredTargetAnimation$updateTarget$1(Animatable animatable, DeferredTargetAnimation deferredTargetAnimation, Object obj, FiniteAnimationSpec finiteAnimationSpec, Continuation continuation) {
        super(2, continuation);
        this.f3915b = animatable;
        this.f3916c = deferredTargetAnimation;
        this.f3917d = obj;
        this.f3918f = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeferredTargetAnimation$updateTarget$1(this.f3915b, this.f3916c, this.f3917d, this.f3918f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f3914a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!Intrinsics.areEqual(this.f3915b.l(), this.f3916c.b())) {
                Animatable animatable = this.f3915b;
                Object obj2 = this.f3917d;
                FiniteAnimationSpec finiteAnimationSpec = this.f3918f;
                this.f3914a = 1;
                if (Animatable.f(animatable, obj2, finiteAnimationSpec, null, null, this, 12, null) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeferredTargetAnimation$updateTarget$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
