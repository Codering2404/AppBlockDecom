package androidx.navigation.compose;

import androidx.compose.animation.core.SeekableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$29$1", f = "NavHost.kt", l = {636, 643}, m = "invokeSuspend")
final class NavHostKt$NavHost$29$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SeekableTransitionState f49108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavBackStackEntry f49109d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Transition f49110f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$29$1(SeekableTransitionState seekableTransitionState, NavBackStackEntry navBackStackEntry, Transition transition, Continuation continuation) {
        super(2, continuation);
        this.f49108c = seekableTransitionState;
        this.f49109d = navBackStackEntry;
        this.f49110f = transition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(CoroutineScope coroutineScope, SeekableTransitionState seekableTransitionState, NavBackStackEntry navBackStackEntry, float f3, float f4) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new NavHostKt$NavHost$29$1$1$1(f3, seekableTransitionState, navBackStackEntry, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        NavHostKt$NavHost$29$1 navHostKt$NavHost$29$1 = new NavHostKt$NavHost$29$1(this.f49108c, this.f49109d, this.f49110f, continuation);
        navHostKt$NavHost$29$1.f49107b = obj;
        return navHostKt$NavHost$29$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
    
        if (androidx.compose.animation.core.SeekableTransitionState.C(r4, r5, null, r10, 2, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007d, code lost:
    
        if (androidx.compose.animation.core.SuspendAnimationKt.e(r1, 0.0f, 0.0f, r4, r5, r10, 4, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x007f, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f49106a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            goto L80
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.b(r11)
            r6 = r10
            goto L80
        L20:
            kotlin.ResultKt.b(r11)
            java.lang.Object r11 = r10.f49107b
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            androidx.compose.animation.core.SeekableTransitionState r1 = r10.f49108c
            java.lang.Object r1 = r1.a()
            androidx.navigation.NavBackStackEntry r4 = r10.f49109d
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r4)
            if (r1 != 0) goto L47
            androidx.compose.animation.core.SeekableTransitionState r4 = r10.f49108c
            androidx.navigation.NavBackStackEntry r5 = r10.f49109d
            r10.f49106a = r3
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r10
            java.lang.Object r11 = androidx.compose.animation.core.SeekableTransitionState.C(r4, r5, r6, r7, r8, r9)
            r6 = r7
            if (r11 != r0) goto L80
            goto L7f
        L47:
            r6 = r10
            androidx.compose.animation.core.Transition r1 = r6.f49110f
            long r3 = r1.r()
            r1 = 1000000(0xf4240, float:1.401298E-39)
            long r7 = (long) r1
            long r3 = r3 / r7
            androidx.compose.animation.core.SeekableTransitionState r1 = r6.f49108c
            float r1 = r1.I()
            androidx.compose.animation.core.SeekableTransitionState r5 = r6.f49108c
            float r5 = r5.I()
            float r3 = (float) r3
            float r5 = r5 * r3
            int r3 = (int) r5
            r4 = 0
            r5 = 6
            r7 = 0
            androidx.compose.animation.core.TweenSpec r4 = androidx.compose.animation.core.AnimationSpecKt.n(r3, r4, r7, r5, r7)
            androidx.compose.animation.core.SeekableTransitionState r3 = r6.f49108c
            androidx.navigation.NavBackStackEntry r5 = r6.f49109d
            r7 = r5
            androidx.navigation.compose.g0 r5 = new androidx.navigation.compose.g0
            r5.<init>()
            r6.f49106a = r2
            r2 = 0
            r3 = 0
            r7 = 4
            r8 = 0
            java.lang.Object r11 = androidx.compose.animation.core.SuspendAnimationKt.e(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L80
        L7f:
            return r0
        L80:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$29$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NavHostKt$NavHost$29$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
