package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", l = {141, 148}, m = "invokeSuspend")
final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f8059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f8060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyLayoutItemAnimation f8061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f8062d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f8063f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec finiteAnimationSpec, long j3, Continuation continuation) {
        super(2, continuation);
        this.f8061c = lazyLayoutItemAnimation;
        this.f8062d = finiteAnimationSpec;
        this.f8063f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.f8061c, this.f8062d, this.f8063f, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|(1:40)|(1:(1:(5:6|7|34|35|36)(2:9|10))(2:11|12))(7:14|15|(2:17|(1:19)(1:20))(1:22)|21|23|(2:25|(1:27))(4:29|30|38|31)|33)|28|29|30|38|31) */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ad, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r12, r4, r5, null, r7, r8, 4, null) != r0) goto L34;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f8060b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L27
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            kotlin.ResultKt.b(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            r8 = r11
            goto Lb0
        L14:
            r8 = r11
            goto Lbb
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            java.lang.Object r1 = r11.f8059a
            androidx.compose.animation.core.FiniteAnimationSpec r1 = (androidx.compose.animation.core.FiniteAnimationSpec) r1
            kotlin.ResultKt.b(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            goto L6c
        L27:
            kotlin.ResultKt.b(r12)
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.c(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            boolean r12 = r12.q()     // Catch: java.util.concurrent.CancellationException -> L14
            if (r12 == 0) goto L45
            androidx.compose.animation.core.FiniteAnimationSpec r12 = r11.f8062d     // Catch: java.util.concurrent.CancellationException -> L14
            boolean r1 = r12 instanceof androidx.compose.animation.core.SpringSpec     // Catch: java.util.concurrent.CancellationException -> L14
            if (r1 == 0) goto L3f
            androidx.compose.animation.core.SpringSpec r12 = (androidx.compose.animation.core.SpringSpec) r12     // Catch: java.util.concurrent.CancellationException -> L14
            goto L43
        L3f:
            androidx.compose.animation.core.SpringSpec r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimationKt.a()     // Catch: java.util.concurrent.CancellationException -> L14
        L43:
            r1 = r12
            goto L48
        L45:
            androidx.compose.animation.core.FiniteAnimationSpec r12 = r11.f8062d     // Catch: java.util.concurrent.CancellationException -> L14
            goto L43
        L48:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.c(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            boolean r12 = r12.q()     // Catch: java.util.concurrent.CancellationException -> L14
            if (r12 != 0) goto L75
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.c(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            long r4 = r11.f8063f     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.c(r4)     // Catch: java.util.concurrent.CancellationException -> L14
            r11.f8059a = r1     // Catch: java.util.concurrent.CancellationException -> L14
            r11.f8060b = r3     // Catch: java.util.concurrent.CancellationException -> L14
            java.lang.Object r12 = r12.u(r4, r11)     // Catch: java.util.concurrent.CancellationException -> L14
            if (r12 != r0) goto L6c
            r8 = r11
            goto Laf
        L6c:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            kotlin.jvm.functions.Function0 r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.b(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            r12.invoke()     // Catch: java.util.concurrent.CancellationException -> L14
        L75:
            r5 = r1
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.c(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            java.lang.Object r12 = r12.n()     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.ui.unit.IntOffset r12 = (androidx.compose.ui.unit.IntOffset) r12     // Catch: java.util.concurrent.CancellationException -> L14
            long r3 = r12.r()     // Catch: java.util.concurrent.CancellationException -> L14
            long r6 = r11.f8063f     // Catch: java.util.concurrent.CancellationException -> L14
            long r3 = androidx.compose.ui.unit.IntOffset.n(r3, r6)     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.animation.core.Animatable r12 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.c(r12)     // Catch: java.util.concurrent.CancellationException -> L14
            r6 = r3
            androidx.compose.ui.unit.IntOffset r4 = androidx.compose.ui.unit.IntOffset.c(r6)     // Catch: java.util.concurrent.CancellationException -> L14
            r8 = r6
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1 r7 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1$1     // Catch: java.util.concurrent.CancellationException -> L14
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r1 = r11.f8061c     // Catch: java.util.concurrent.CancellationException -> L14
            r7.<init>()     // Catch: java.util.concurrent.CancellationException -> L14
            r1 = 0
            r11.f8059a = r1     // Catch: java.util.concurrent.CancellationException -> L14
            r11.f8060b = r2     // Catch: java.util.concurrent.CancellationException -> L14
            r6 = 0
            r9 = 4
            r10 = 0
            r8 = r11
            r3 = r12
            java.lang.Object r12 = androidx.compose.animation.core.Animatable.f(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> Lbb
            if (r12 != r0) goto Lb0
        Laf:
            return r0
        Lb0:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r8.f8061c     // Catch: java.util.concurrent.CancellationException -> Lbb
            r0 = 0
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.h(r12, r0)     // Catch: java.util.concurrent.CancellationException -> Lbb
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r12 = r8.f8061c     // Catch: java.util.concurrent.CancellationException -> Lbb
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.j(r12, r0)     // Catch: java.util.concurrent.CancellationException -> Lbb
        Lbb:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
