package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

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
public final class SnapFlingBehaviorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f6466a = Dp.g(RCHTTPStatusCodes.BAD_REQUEST);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object f(final androidx.compose.foundation.gestures.ScrollScope r5, final float r6, androidx.compose.animation.core.AnimationState r7, androidx.compose.animation.core.DecayAnimationSpec r8, final kotlin.jvm.functions.Function1 r9, kotlin.coroutines.Continuation r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1) r0
            int r1 = r0.f6471f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6471f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1 r0 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f6470d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6471f
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            float r6 = r0.f6467a
            java.lang.Object r5 = r0.f6469c
            kotlin.jvm.internal.Ref$FloatRef r5 = (kotlin.jvm.internal.Ref.FloatRef) r5
            java.lang.Object r7 = r0.f6468b
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7
            kotlin.ResultKt.b(r10)
            goto L6b
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.b(r10)
            kotlin.jvm.internal.Ref$FloatRef r10 = new kotlin.jvm.internal.Ref$FloatRef
            r10.<init>()
            java.lang.Object r2 = r7.p()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L54
            r2 = r3
            goto L55
        L54:
            r2 = 0
        L55:
            r2 = r2 ^ r3
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2 r4 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateDecay$2
            r4.<init>()
            r0.f6468b = r7
            r0.f6469c = r10
            r0.f6467a = r6
            r0.f6471f = r3
            java.lang.Object r5 = androidx.compose.animation.core.SuspendAnimationKt.h(r7, r8, r2, r4, r0)
            if (r5 != r1) goto L6a
            return r1
        L6a:
            r5 = r10
        L6b:
            androidx.compose.foundation.gestures.snapping.AnimationResult r8 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r5 = r5.f140141a
            float r6 = r6 - r5
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.c(r6)
            r8.<init>(r5, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.f(androidx.compose.foundation.gestures.ScrollScope, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.DecayAnimationSpec, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(AnimationScope animationScope, ScrollScope scrollScope, Function1 function1, float f3) {
        float fD;
        if (ComposeFoundationFlags.f4886b) {
            try {
                fD = scrollScope.d(f3);
            } catch (CancellationException unused) {
                animationScope.a();
                fD = 0.0f;
            }
        } else {
            fD = scrollScope.d(f3);
        }
        function1.invoke(Float.valueOf(fD));
        if (Math.abs(f3 - fD) > 0.5f) {
            animationScope.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object h(final androidx.compose.foundation.gestures.ScrollScope r20, float r21, final float r22, androidx.compose.animation.core.AnimationState r23, androidx.compose.animation.core.AnimationSpec r24, final kotlin.jvm.functions.Function1 r25, kotlin.coroutines.Continuation r26) throws java.lang.Throwable {
        /*
            r0 = r26
            boolean r1 = r0 instanceof androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1
            if (r1 == 0) goto L16
            r1 = r0
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1 r1 = (androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1) r1
            int r2 = r1.f6481g
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.f6481g = r2
        L14:
            r7 = r1
            goto L1c
        L16:
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1 r1 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$1
            r1.<init>(r0)
            goto L14
        L1c:
            java.lang.Object r0 = r7.f6480f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f6481g
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            float r1 = r7.f6477b
            float r2 = r7.f6476a
            java.lang.Object r3 = r7.f6479d
            kotlin.jvm.internal.Ref$FloatRef r3 = (kotlin.jvm.internal.Ref.FloatRef) r3
            java.lang.Object r4 = r7.f6478c
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4
            kotlin.ResultKt.b(r0)
            r9 = r2
            r10 = r4
            goto L95
        L3b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L43:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$FloatRef r0 = new kotlin.jvm.internal.Ref$FloatRef
            r0.<init>()
            java.lang.Object r2 = r23.p()
            java.lang.Number r2 = (java.lang.Number) r2
            float r8 = r2.floatValue()
            java.lang.Float r2 = kotlin.coroutines.jvm.internal.Boxing.c(r21)
            java.lang.Object r4 = r23.p()
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L6a
            r4 = r3
            goto L6b
        L6a:
            r4 = 0
        L6b:
            r5 = r4 ^ 1
            androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$2 r6 = new androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt$animateWithTarget$2
            r4 = r20
            r9 = r22
            r10 = r25
            r6.<init>()
            r4 = r23
            r7.f6478c = r4
            r7.f6479d = r0
            r9 = r21
            r7.f6476a = r9
            r7.f6477b = r8
            r7.f6481g = r3
            r3 = r2
            r2 = r4
            r4 = r24
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.j(r2, r3, r4, r5, r6, r7)
            if (r3 != r1) goto L91
            return r1
        L91:
            r10 = r23
            r3 = r0
            r1 = r8
        L95:
            java.lang.Object r0 = r10.p()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r12 = l(r0, r1)
            androidx.compose.foundation.gestures.snapping.AnimationResult r0 = new androidx.compose.foundation.gestures.snapping.AnimationResult
            float r1 = r3.f140141a
            float r9 = r9 - r1
            java.lang.Float r1 = kotlin.coroutines.jvm.internal.Boxing.c(r9)
            r18 = 29
            r19 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            androidx.compose.animation.core.AnimationState r2 = androidx.compose.animation.core.AnimationStateKt.g(r10, r11, r12, r13, r15, r17, r18, r19)
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.h(androidx.compose.foundation.gestures.ScrollScope, float, float, androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.AnimationSpec, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(ScrollScope scrollScope, float f3, float f4, ApproachAnimation approachAnimation, Function1 function1, Continuation continuation) {
        return approachAnimation.a(scrollScope, Boxing.c(f3), Boxing.c(f4), function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final float j(int r3, float r4, float r5) {
        /*
            androidx.compose.foundation.gestures.snapping.FinalSnappingItem$Companion r0 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f6430b
            int r1 = r0.a()
            boolean r1 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r3, r1)
            r2 = 0
            if (r1 == 0) goto L1a
            float r3 = java.lang.Math.abs(r5)
            float r0 = java.lang.Math.abs(r4)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 > 0) goto L32
            goto L24
        L1a:
            int r1 = r0.b()
            boolean r1 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r3, r1)
            if (r1 == 0) goto L26
        L24:
            r4 = r5
            goto L32
        L26:
            int r5 = r0.c()
            boolean r3 = androidx.compose.foundation.gestures.snapping.FinalSnappingItem.f(r3, r5)
            if (r3 == 0) goto L31
            goto L32
        L31:
            r4 = r2
        L32:
            boolean r3 = k(r4)
            if (r3 == 0) goto L39
            return r4
        L39:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt.j(int, float, float):float");
    }

    private static final boolean k(float f3) {
        return (f3 == Float.POSITIVE_INFINITY || f3 == Float.NEGATIVE_INFINITY) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float l(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        return f4 > 0.0f ? RangesKt.j(f3, f4) : RangesKt.e(f3, f4);
    }

    public static final float m() {
        return f6466a;
    }

    public static final TargetedFlingBehavior n(SnapLayoutInfoProvider snapLayoutInfoProvider, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1921733134, i3, -1, "androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior (SnapFlingBehavior.kt:231)");
        }
        Object obj = (Density) composer.q(CompositionLocalsKt.f());
        DecayAnimationSpec decayAnimationSpecB = SplineBasedFloatDecayAnimationSpec_androidKt.b(composer, 0);
        boolean Z = composer.Z(decayAnimationSpecB) | ((((i3 & 14) ^ 6) > 4 && composer.Z(snapLayoutInfoProvider)) || (i3 & 6) == 4) | composer.Z(obj);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = o(snapLayoutInfoProvider, decayAnimationSpecB, AnimationSpecKt.l(0.0f, 400.0f, null, 5, null));
            composer.w(objG);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehavior;
    }

    public static final TargetedFlingBehavior o(SnapLayoutInfoProvider snapLayoutInfoProvider, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec) {
        return new SnapFlingBehavior(snapLayoutInfoProvider, decayAnimationSpec, animationSpec);
    }
}
