package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1", f = "LazyLayoutItemAnimation.kt", l = {204}, m = "invokeSuspend")
final class LazyLayoutItemAnimation$animateDisappearance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyLayoutItemAnimation f8054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f8055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ GraphicsLayer f8056d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animateDisappearance$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation continuation) {
        super(2, continuation);
        this.f8054b = lazyLayoutItemAnimation;
        this.f8055c = finiteAnimationSpec;
        this.f8056d = graphicsLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyLayoutItemAnimation$animateDisappearance$1(this.f8054b, this.f8055c, this.f8056d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LazyLayoutItemAnimation$animateDisappearance$1 lazyLayoutItemAnimation$animateDisappearance$1;
        Throwable th;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f8053a;
        if (i3 == 0) {
            ResultKt.b(obj);
            try {
                Animatable animatable = this.f8054b.f8040p;
                Float fC = Boxing.c(0.0f);
                FiniteAnimationSpec finiteAnimationSpec = this.f8055c;
                final GraphicsLayer graphicsLayer = this.f8056d;
                final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.f8054b;
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateDisappearance$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(Animatable animatable2) {
                        graphicsLayer.L(((Number) animatable2.n()).floatValue());
                        lazyLayoutItemAnimation.f8027c.invoke();
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        c((Animatable) obj2);
                        return Unit.f139807a;
                    }
                };
                this.f8053a = 1;
                lazyLayoutItemAnimation$animateDisappearance$1 = this;
                try {
                    if (Animatable.f(animatable, fC, finiteAnimationSpec, null, function1, lazyLayoutItemAnimation$animateDisappearance$1, 4, null) == objF) {
                        return objF;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    th = th;
                    lazyLayoutItemAnimation$animateDisappearance$1.f8054b.B(false);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                lazyLayoutItemAnimation$animateDisappearance$1 = this;
                th = th;
                lazyLayoutItemAnimation$animateDisappearance$1.f8054b.B(false);
                throw th;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            try {
                ResultKt.b(obj);
                lazyLayoutItemAnimation$animateDisappearance$1 = this;
            } catch (Throwable th4) {
                th = th4;
                lazyLayoutItemAnimation$animateDisappearance$1 = this;
                lazyLayoutItemAnimation$animateDisappearance$1.f8054b.B(false);
                throw th;
            }
        }
        lazyLayoutItemAnimation$animateDisappearance$1.f8054b.A(true);
        lazyLayoutItemAnimation$animateDisappearance$1.f8054b.B(false);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LazyLayoutItemAnimation$animateDisappearance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
