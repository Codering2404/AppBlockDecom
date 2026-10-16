package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
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
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", l = {183, 185}, m = "invokeSuspend")
final class LazyLayoutItemAnimation$animateAppearance$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f8046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f8047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyLayoutItemAnimation f8048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f8049d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ GraphicsLayer f8050f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutItemAnimation$animateAppearance$2(boolean z2, LazyLayoutItemAnimation lazyLayoutItemAnimation, FiniteAnimationSpec finiteAnimationSpec, GraphicsLayer graphicsLayer, Continuation continuation) {
        super(2, continuation);
        this.f8047b = z2;
        this.f8048c = lazyLayoutItemAnimation;
        this.f8049d = finiteAnimationSpec;
        this.f8050f = graphicsLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LazyLayoutItemAnimation$animateAppearance$2(this.f8047b, this.f8048c, this.f8049d, this.f8050f, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|2|33|(1:(1:(4:6|7|25|26)(2:10|11))(1:12))(6:14|36|15|(3:17|(1:19)|24)|31|32)|20|21|34|22|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r4, r5, r6, null, r8, r9, 4, null) == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
    
        r0 = th;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r12.f8046a
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L20
            if (r1 != r3) goto L18
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L14
            r9 = r12
            goto L64
        L14:
            r0 = move-exception
            r13 = r0
            r9 = r12
            goto L72
        L18:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L20:
            kotlin.ResultKt.b(r13)     // Catch: java.lang.Throwable -> L14
            goto L40
        L24:
            kotlin.ResultKt.b(r13)
            boolean r13 = r12.f8047b     // Catch: java.lang.Throwable -> L6f
            if (r13 == 0) goto L40
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.f8048c     // Catch: java.lang.Throwable -> L14
            androidx.compose.animation.core.Animatable r13 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.d(r13)     // Catch: java.lang.Throwable -> L14
            r1 = 0
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r1)     // Catch: java.lang.Throwable -> L14
            r12.f8046a = r4     // Catch: java.lang.Throwable -> L14
            java.lang.Object r13 = r13.u(r1, r12)     // Catch: java.lang.Throwable -> L14
            if (r13 != r0) goto L40
            r9 = r12
            goto L63
        L40:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r12.f8048c     // Catch: java.lang.Throwable -> L6f
            androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.d(r13)     // Catch: java.lang.Throwable -> L6f
            r13 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r13)     // Catch: java.lang.Throwable -> L6f
            androidx.compose.animation.core.FiniteAnimationSpec r6 = r12.f8049d     // Catch: java.lang.Throwable -> L6f
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1 r8 = new androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2$1     // Catch: java.lang.Throwable -> L6f
            androidx.compose.ui.graphics.layer.GraphicsLayer r13 = r12.f8050f     // Catch: java.lang.Throwable -> L6f
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r1 = r12.f8048c     // Catch: java.lang.Throwable -> L6f
            r8.<init>()     // Catch: java.lang.Throwable -> L6f
            r12.f8046a = r3     // Catch: java.lang.Throwable -> L6f
            r7 = 0
            r10 = 4
            r11 = 0
            r9 = r12
            java.lang.Object r13 = androidx.compose.animation.core.Animatable.f(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L6c
            if (r13 != r0) goto L64
        L63:
            return r0
        L64:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r13 = r9.f8048c
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.e(r13, r2)
            kotlin.Unit r13 = kotlin.Unit.f139807a
            return r13
        L6c:
            r0 = move-exception
        L6d:
            r13 = r0
            goto L72
        L6f:
            r0 = move-exception
            r9 = r12
            goto L6d
        L72:
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation r0 = r9.f8048c
            androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation.e(r0, r2)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LazyLayoutItemAnimation$animateAppearance$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
