package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T, V] */
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
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", l = {305}, m = "invokeSuspend")
final class Animatable$runAnimation$2<T, V> extends SuspendLambda implements Function1<Continuation<? super AnimationResult<T, V>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f3782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f3783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Animatable f3785d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Object f3786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Animation f3787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ long f3788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function1 f3789i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Animatable$runAnimation$2(Animatable animatable, Object obj, Animation animation, long j3, Function1 function1, Continuation continuation) {
        super(1, continuation);
        this.f3785d = animatable;
        this.f3786f = obj;
        this.f3787g = animation;
        this.f3788h = j3;
        this.f3789i = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new Animatable$runAnimation$2(this.f3785d, this.f3786f, this.f3787g, this.f3788h, this.f3789i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AnimationState animationState;
        Ref.BooleanRef booleanRef;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f3784c;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                this.f3785d.j().z((AnimationVector) this.f3785d.m().a().invoke(this.f3786f));
                this.f3785d.t(this.f3787g.g());
                this.f3785d.s(true);
                final AnimationState animationStateH = AnimationStateKt.h(this.f3785d.j(), null, null, 0L, Long.MIN_VALUE, false, 23, null);
                final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                Animation animation = this.f3787g;
                long j3 = this.f3788h;
                final Animatable animatable = this.f3785d;
                final Function1 function1 = this.f3789i;
                Function1<AnimationScope<T, V>, Unit> function12 = new Function1<AnimationScope<T, V>, Unit>() { // from class: androidx.compose.animation.core.Animatable$runAnimation$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(AnimationScope animationScope) {
                        SuspendAnimationKt.p(animationScope, animatable.j());
                        Object objH = animatable.h(animationScope.e());
                        if (Intrinsics.areEqual(objH, animationScope.e())) {
                            Function1 function13 = function1;
                            if (function13 != null) {
                                function13.invoke(animatable);
                                return;
                            }
                            return;
                        }
                        animatable.j().y(objH);
                        animationStateH.y(objH);
                        Function1 function14 = function1;
                        if (function14 != null) {
                            function14.invoke(animatable);
                        }
                        animationScope.a();
                        booleanRef2.f140137a = true;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        c((AnimationScope) obj2);
                        return Unit.f139807a;
                    }
                };
                this.f3782a = animationStateH;
                this.f3783b = booleanRef2;
                this.f3784c = 1;
                if (SuspendAnimationKt.c(animationStateH, animation, j3, function12, this) == objF) {
                    return objF;
                }
                animationState = animationStateH;
                booleanRef = booleanRef2;
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) this.f3783b;
                animationState = (AnimationState) this.f3782a;
                ResultKt.b(obj);
            }
            AnimationEndReason animationEndReason = booleanRef.f140137a ? AnimationEndReason.f3830a : AnimationEndReason.f3831b;
            this.f3785d.i();
            return new AnimationResult(animationState, animationEndReason);
        } catch (CancellationException e3) {
            this.f3785d.i();
            throw e3;
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
