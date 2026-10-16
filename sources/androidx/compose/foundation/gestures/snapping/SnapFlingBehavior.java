package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class SnapFlingBehavior implements TargetedFlingBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapLayoutInfoProvider f6442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DecayAnimationSpec f6443b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimationSpec f6444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private MotionDurationScale f6445d = ScrollableKt.f();

    public SnapFlingBehavior(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec) {
        this.f6442a = snapLayoutInfoProvider;
        this.f6443b = decayAnimationSpec;
        this.f6444c = animationSpec;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(androidx.compose.foundation.gestures.ScrollScope r11, float r12, kotlin.jvm.functions.Function1 r13, kotlin.coroutines.Continuation r14) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r14 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            if (r0 == 0) goto L13
            r0 = r14
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1) r0
            int r1 = r0.f6449d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6449d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$1
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.f6447b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6449d
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r11 = r0.f6446a
            r13 = r11
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            kotlin.ResultKt.b(r14)
            goto L51
        L2e:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L36:
            kotlin.ResultKt.b(r14)
            androidx.compose.ui.MotionDurationScale r14 = r10.f6445d
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1 r4 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1
            r9 = 0
            r5 = r10
            r8 = r11
            r6 = r12
            r7 = r13
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f6446a = r7
            r0.f6449d = r3
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt.g(r14, r4, r0)
            if (r14 != r1) goto L50
            return r1
        L50:
            r13 = r7
        L51:
            androidx.compose.foundation.gestures.snapping.AnimationResult r14 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r14
            r11 = 0
            java.lang.Float r11 = kotlin.coroutines.jvm.internal.Boxing.c(r11)
            r13.invoke(r11)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.i(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean j(float f3, float f4) {
        return Math.abs(DecayAnimationSpecKt.a(this.f6443b, 0.0f, f4)) >= Math.abs(f3);
    }

    private final Object k(ScrollScope scrollScope, float f3, float f4, Function1 function1, Continuation continuation) {
        return SnapFlingBehaviorKt.i(scrollScope, f3, f4, j(f3, f4) ? new DecayApproachAnimation(this.f6443b) : new TargetApproachAnimation(this.f6444c), function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object l(androidx.compose.foundation.gestures.ScrollScope r18, float r19, float r20, kotlin.jvm.functions.Function1 r21, kotlin.coroutines.Continuation r22) throws java.lang.Throwable {
        /*
            r17 = this;
            r0 = r22
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1
            if (r1 == 0) goto L18
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 r1 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1) r1
            int r2 = r1.f6465c
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L18
            int r2 = r2 - r3
            r1.f6465c = r2
            r2 = r17
        L16:
            r7 = r1
            goto L20
        L18:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$tryApproach$1
            r2 = r17
            r1.<init>(r2, r0)
            goto L16
        L20:
            java.lang.Object r0 = r7.f6463a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r3 = r7.f6465c
            r4 = 1
            if (r3 == 0) goto L39
            if (r3 != r4) goto L31
            kotlin.ResultKt.b(r0)
            goto L71
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.b(r0)
            float r0 = java.lang.Math.abs(r19)
            r3 = 0
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L46
            goto L4e
        L46:
            float r0 = java.lang.Math.abs(r20)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L60
        L4e:
            r15 = 28
            r16 = 0
            r10 = 0
            r12 = 0
            r14 = 0
            r8 = r19
            r9 = r20
            androidx.compose.animation.core.AnimationState r0 = androidx.compose.animation.core.AnimationStateKt.c(r8, r9, r10, r12, r14, r15, r16)
            return r0
        L60:
            r7.f6465c = r4
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r21
            java.lang.Object r0 = r2.k(r3, r4, r5, r6, r7)
            if (r0 != r1) goto L71
            return r1
        L71:
            androidx.compose.foundation.gestures.snapping.AnimationResult r0 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r0
            androidx.compose.animation.core.AnimationState r0 = r0.c()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.l(androidx.compose.foundation.gestures.ScrollScope, float, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.TargetedFlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(androidx.compose.foundation.gestures.ScrollScope r5, float r6, kotlin.jvm.functions.Function1 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1) r0
            int r1 = r0.f6462c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6462c = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$performFling$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.f6460a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6462c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r8)
            goto L3d
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            kotlin.ResultKt.b(r8)
            r0.f6462c = r3
            java.lang.Object r8 = r4.i(r5, r6, r7, r0)
            if (r8 != r1) goto L3d
            return r1
        L3d:
            androidx.compose.foundation.gestures.snapping.AnimationResult r8 = (androidx.compose.foundation.gestures.snapping.AnimationResult) r8
            java.lang.Object r5 = r8.a()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.animation.core.AnimationState r6 = r8.b()
            r7 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L53
            goto L5d
        L53:
            java.lang.Object r5 = r6.p()
            java.lang.Number r5 = (java.lang.Number) r5
            float r7 = r5.floatValue()
        L5d:
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior.c(androidx.compose.foundation.gestures.ScrollScope, float, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean equals(Object obj) {
        if (obj instanceof SnapFlingBehavior) {
            SnapFlingBehavior snapFlingBehavior = (SnapFlingBehavior) obj;
            if (Intrinsics.areEqual(snapFlingBehavior.f6444c, this.f6444c) && Intrinsics.areEqual(snapFlingBehavior.f6443b, this.f6443b) && Intrinsics.areEqual(snapFlingBehavior.f6442a, this.f6442a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f6444c.hashCode() * 31) + this.f6443b.hashCode()) * 31) + this.f6442a.hashCode();
    }
}
