package androidx.compose.animation.core;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1", f = "InfiniteTransition.kt", l = {172, 193}, m = "invokeSuspend")
final class InfiniteTransition$run$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f3984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f3985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f3986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f3987d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ InfiniteTransition f3988f;

    /* JADX INFO: renamed from: androidx.compose.animation.core.InfiniteTransition$run$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.compose.animation.core.InfiniteTransition$run$1$1$3", f = "InfiniteTransition.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Float, Continuation<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ float f3995b;

        AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(continuation);
            anonymousClass3.f3995b = ((Number) obj).floatValue();
            return anonymousClass3;
        }

        public final Object h(float f3, Continuation continuation) {
            return ((AnonymousClass3) create(Float.valueOf(f3), continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return h(((Number) obj).floatValue(), (Continuation) obj2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f3994a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Boxing.a(this.f3995b > 0.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InfiniteTransition$run$1$1(MutableState mutableState, InfiniteTransition infiniteTransition, Continuation continuation) {
        super(2, continuation);
        this.f3987d = mutableState;
        this.f3988f = infiniteTransition;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        InfiniteTransition$run$1$1 infiniteTransition$run$1$1 = new InfiniteTransition$run$1$1(this.f3987d, this.f3988f, continuation);
        infiniteTransition$run$1$1.f3986c = obj;
        return infiniteTransition$run$1$1;
    }

    /* JADX WARN: Path cross not found for [B:11:0x0040, B:16:0x005d], limit reached: 18 */
    /* JADX WARN: Path cross not found for [B:16:0x005d, B:11:0x0040], limit reached: 18 */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0056 A[PHI: r1 r8
      0x0056: PHI (r1v2 kotlin.jvm.internal.Ref$FloatRef) = (r1v3 kotlin.jvm.internal.Ref$FloatRef), (r1v5 kotlin.jvm.internal.Ref$FloatRef) binds: [B:12:0x0053, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]
      0x0056: PHI (r8v3 kotlinx.coroutines.CoroutineScope) = (r8v4 kotlinx.coroutines.CoroutineScope), (r8v5 kotlinx.coroutines.CoroutineScope) binds: [B:12:0x0053, B:9:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x005b -> B:11:0x0040). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0076 -> B:11:0x0040). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f3985b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r7.f3984a
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r4 = r7.f3986c
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r8)
            r8 = r4
            goto L40
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            java.lang.Object r1 = r7.f3984a
            kotlin.jvm.internal.Ref$FloatRef r1 = (kotlin.jvm.internal.Ref.FloatRef) r1
            java.lang.Object r4 = r7.f3986c
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.b(r8)
            r8 = r4
            goto L56
        L30:
            kotlin.ResultKt.b(r8)
            java.lang.Object r8 = r7.f3986c
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
            r1.<init>()
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.f140141a = r4
        L40:
            androidx.compose.animation.core.InfiniteTransition$run$1$1$1 r4 = new androidx.compose.animation.core.InfiniteTransition$run$1$1$1
            androidx.compose.runtime.MutableState r5 = r7.f3987d
            androidx.compose.animation.core.InfiniteTransition r6 = r7.f3988f
            r4.<init>()
            r7.f3986c = r8
            r7.f3984a = r1
            r7.f3985b = r3
            java.lang.Object r4 = androidx.compose.animation.core.InfiniteAnimationPolicyKt.a(r4, r7)
            if (r4 != r0) goto L56
            goto L78
        L56:
            float r4 = r1.f140141a
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L40
            androidx.compose.animation.core.InfiniteTransition$run$1$1$2 r4 = new androidx.compose.animation.core.InfiniteTransition$run$1$1$2
            r4.<init>()
            kotlinx.coroutines.flow.Flow r4 = androidx.compose.runtime.SnapshotStateKt.q(r4)
            androidx.compose.animation.core.InfiniteTransition$run$1$1$3 r5 = new androidx.compose.animation.core.InfiniteTransition$run$1$1$3
            r6 = 0
            r5.<init>(r6)
            r7.f3986c = r8
            r7.f3984a = r1
            r7.f3985b = r2
            java.lang.Object r4 = kotlinx.coroutines.flow.FlowKt.E(r4, r5, r7)
            if (r4 != r0) goto L40
        L78:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.InfiniteTransition$run$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InfiniteTransition$run$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
