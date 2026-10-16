package androidx.navigation.compose;

import androidx.collection.MutableObjectFloatMap;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.State;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavHostController;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.navigation.compose.NavHostKt$NavHost$33$1", f = "NavHost.kt", l = {}, m = "invokeSuspend")
final class NavHostKt$NavHost$33$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Transition f49123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ NavHostController f49124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ NavBackStackEntry f49125d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableObjectFloatMap f49126f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ State f49127g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ComposeNavigator f49128h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NavHostKt$NavHost$33$1(Transition transition, NavHostController navHostController, NavBackStackEntry navBackStackEntry, MutableObjectFloatMap mutableObjectFloatMap, State state, ComposeNavigator composeNavigator, Continuation continuation) {
        super(2, continuation);
        this.f49123b = transition;
        this.f49124c = navHostController;
        this.f49125d = navBackStackEntry;
        this.f49126f = mutableObjectFloatMap;
        this.f49127g = state;
        this.f49128h = composeNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new NavHostKt$NavHost$33$1(this.f49123b, this.f49124c, this.f49125d, this.f49126f, this.f49127g, this.f49128h, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r0 = r14.f49122a
            if (r0 != 0) goto Lb0
            kotlin.ResultKt.b(r15)
            androidx.compose.animation.core.Transition r15 = r14.f49123b
            java.lang.Object r15 = r15.i()
            androidx.compose.animation.core.Transition r0 = r14.f49123b
            java.lang.Object r0 = r0.q()
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r0)
            if (r15 == 0) goto Lad
            androidx.navigation.NavHostController r15 = r14.f49124c
            androidx.navigation.NavBackStackEntry r15 = r15.t()
            if (r15 == 0) goto L32
            androidx.compose.animation.core.Transition r15 = r14.f49123b
            java.lang.Object r15 = r15.q()
            androidx.navigation.NavBackStackEntry r0 = r14.f49125d
            boolean r15 = kotlin.jvm.internal.Intrinsics.areEqual(r15, r0)
            if (r15 == 0) goto Lad
        L32:
            androidx.compose.runtime.State r15 = r14.f49127g
            java.util.List r15 = androidx.navigation.compose.NavHostKt.b0(r15)
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            androidx.navigation.compose.ComposeNavigator r0 = r14.f49128h
            java.util.Iterator r15 = r15.iterator()
        L40:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L50
            java.lang.Object r1 = r15.next()
            androidx.navigation.NavBackStackEntry r1 = (androidx.navigation.NavBackStackEntry) r1
            r0.s(r1)
            goto L40
        L50:
            androidx.collection.MutableObjectFloatMap r15 = r14.f49126f
            androidx.compose.animation.core.Transition r0 = r14.f49123b
            long[] r1 = r15.f3069a
            int r2 = r1.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto Lad
            r3 = 0
            r4 = r3
        L5d:
            r5 = r1[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto La8
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L77:
            if (r9 >= r7) goto La6
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto La2
            int r10 = r4 << 3
            int r10 = r10 + r9
            java.lang.Object[] r11 = r15.f3070b
            r11 = r11[r10]
            float[] r12 = r15.f3071c
            r12 = r12[r10]
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.q()
            androidx.navigation.NavBackStackEntry r12 = (androidx.navigation.NavBackStackEntry) r12
            java.lang.String r12 = r12.f()
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual(r11, r12)
            if (r11 != 0) goto La2
            r15.p(r10)
        La2:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L77
        La6:
            if (r7 != r8) goto Lad
        La8:
            if (r4 == r2) goto Lad
            int r4 = r4 + 1
            goto L5d
        Lad:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        Lb0:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.compose.NavHostKt$NavHost$33$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((NavHostKt$NavHost$33$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
