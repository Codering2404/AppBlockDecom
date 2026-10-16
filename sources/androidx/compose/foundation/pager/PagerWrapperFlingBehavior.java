package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;

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
final class PagerWrapperFlingBehavior implements FlingBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TargetedFlingBehavior f8911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PagerState f8912b;

    public PagerWrapperFlingBehavior(TargetedFlingBehavior targetedFlingBehavior, PagerState pagerState) {
        this.f8911a = targetedFlingBehavior;
        this.f8912b = pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(final androidx.compose.foundation.gestures.ScrollScope r6, float r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1) r0
            int r1 = r0.f8916d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8916d = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f8914b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f8916d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.f8913a
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior r6 = (androidx.compose.foundation.pager.PagerWrapperFlingBehavior) r6
            kotlin.ResultKt.b(r8)
            goto L4b
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.gestures.TargetedFlingBehavior r8 = r5.f8911a
            androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$resultVelocity$1$1 r2 = new androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$resultVelocity$1$1
            r2.<init>()
            r0.f8913a = r5
            r0.f8916d = r3
            java.lang.Object r8 = r8.c(r6, r7, r2, r0)
            if (r8 != r1) goto L4a
            return r1
        L4a:
            r6 = r5
        L4b:
            java.lang.Number r8 = (java.lang.Number) r8
            float r7 = r8.floatValue()
            androidx.compose.foundation.pager.PagerState r8 = r6.f8912b
            float r8 = r8.w()
            r0 = 0
            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r8 != 0) goto L5d
            goto L7d
        L5d:
            androidx.compose.foundation.pager.PagerState r8 = r6.f8912b
            float r8 = r8.w()
            float r8 = java.lang.Math.abs(r8)
            double r1 = (double) r8
            r3 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            int r8 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r8 >= 0) goto L7d
            androidx.compose.foundation.pager.PagerState r6 = r6.f8912b
            int r8 = r6.v()
            r1 = 2
            r2 = 0
            androidx.compose.foundation.pager.PagerState.c0(r6, r8, r0, r1, r2)
            goto L82
        L7d:
            androidx.compose.foundation.pager.PagerState r6 = r6.f8912b
            r6.w()
        L82:
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.c(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerWrapperFlingBehavior.a(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PagerState d() {
        return this.f8912b;
    }
}
