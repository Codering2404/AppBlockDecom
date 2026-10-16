package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class UpdatableAnimationState {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Companion f6406f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f6407g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final AnimationVector1D f6408h = new AnimationVector1D(0.0f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedAnimationSpec f6409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6410b = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationVector1D f6411c = f6408h;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f6412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f6413e;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimationVector1D a() {
            return UpdatableAnimationState.f6408h;
        }

        public final boolean b(float f3) {
            return Math.abs(f3) < 0.01f;
        }

        private Companion() {
        }
    }

    public UpdatableAnimationState(AnimationSpec animationSpec) {
        this.f6409a = animationSpec.a(VectorConvertersKt.i(FloatCompanionObject.f140130a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00d3, code lost:
    
        if (androidx.compose.runtime.MonotonicFrameClockKt.c(r0, r2) == r1) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0087 A[Catch: all -> 0x00b3, PHI: r0 r2 r12 r13 r14
      0x0087: PHI (r0v9 ??) = (r0v3 ??), (r0v15 ??) binds: [B:31:0x0080, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x0087: PHI (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v2 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:31:0x0080, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x0087: PHI (r12v6 float) = (r12v3 float), (r12v7 float) binds: [B:31:0x0080, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x0087: PHI (r13v6 kotlin.jvm.functions.Function1) = (r13v3 kotlin.jvm.functions.Function1), (r13v7 kotlin.jvm.functions.Function1) binds: [B:31:0x0080, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x0087: PHI (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v9 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v17 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:31:0x0080, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #0 {all -> 0x00b3, blocks: (B:37:0x00a7, B:32:0x0087, B:34:0x0091), top: B:54:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[Catch: all -> 0x00b3, TryCatch #0 {all -> 0x00b3, blocks: (B:37:0x00a7, B:32:0x0087, B:34:0x0091), top: B:54:0x00a7 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae A[PHI: r0 r2 r13 r14
      0x00ae: PHI (r0v4 ??) = (r0v16 ??), (r0v17 ??) binds: [B:33:0x008f, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r2v3 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1) = 
      (r2v4 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
      (r2v5 androidx.compose.foundation.gestures.UpdatableAnimationState$animateToZero$1)
     binds: [B:33:0x008f, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r13v4 kotlin.jvm.functions.Function1) = (r13v6 kotlin.jvm.functions.Function1), (r13v7 kotlin.jvm.functions.Function1) binds: [B:33:0x008f, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00ae: PHI (r14v12 androidx.compose.foundation.gestures.UpdatableAnimationState) = 
      (r14v16 androidx.compose.foundation.gestures.UpdatableAnimationState)
      (r14v17 androidx.compose.foundation.gestures.UpdatableAnimationState)
     binds: [B:33:0x008f, B:39:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r0v10, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v11, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [kotlin.jvm.functions.Function0] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v18 */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [androidx.compose.foundation.gestures.UpdatableAnimationState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a4 -> B:54:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(kotlin.jvm.functions.Function1 r12, kotlin.jvm.functions.Function0 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.h(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float i() {
        return this.f6413e;
    }

    public final void j(float f3) {
        this.f6413e = f3;
    }
}
