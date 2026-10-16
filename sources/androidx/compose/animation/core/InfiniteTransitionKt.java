package androidx.compose.animation.core;

import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransition.TransitionAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
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
public final class InfiniteTransitionKt {
    public static final State a(InfiniteTransition infiniteTransition, float f3, float f4, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int i3, int i4) {
        if ((i4 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        if (ComposerKt.M()) {
            ComposerKt.U(-644770905, i3, -1, "androidx.compose.animation.core.animateFloat (InfiniteTransition.kt:296)");
        }
        int i5 = i3 << 3;
        State stateB = b(infiniteTransition, Float.valueOf(f3), Float.valueOf(f4), VectorConvertersKt.i(FloatCompanionObject.f140130a), infiniteRepeatableSpec, str2, composer, (i3 & 1022) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateB;
    }

    public static final State b(InfiniteTransition infiniteTransition, Object obj, Object obj2, TwoWayConverter twoWayConverter, InfiniteRepeatableSpec infiniteRepeatableSpec, String str, Composer composer, int i3, int i4) {
        final InfiniteTransition infiniteTransition2;
        final Object obj3;
        final Object obj4;
        final InfiniteRepeatableSpec infiniteRepeatableSpec2;
        if ((i4 & 16) != 0) {
            str = "ValueAnimation";
        }
        String str2 = str;
        if (ComposerKt.M()) {
            ComposerKt.U(-1062847727, i3, -1, "androidx.compose.animation.core.animateValue (InfiniteTransition.kt:245)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            infiniteTransition2 = infiniteTransition;
            obj3 = obj;
            obj4 = obj2;
            infiniteRepeatableSpec2 = infiniteRepeatableSpec;
            InfiniteTransition.TransitionAnimationState transitionAnimationState = infiniteTransition2.new TransitionAnimationState(obj3, obj4, twoWayConverter, infiniteRepeatableSpec2, str2);
            composer.w(transitionAnimationState);
            objG = transitionAnimationState;
        } else {
            infiniteTransition2 = infiniteTransition;
            obj3 = obj;
            obj4 = obj2;
            infiniteRepeatableSpec2 = infiniteRepeatableSpec;
        }
        final InfiniteTransition.TransitionAnimationState transitionAnimationState2 = (InfiniteTransition.TransitionAnimationState) objG;
        boolean z2 = true;
        boolean z3 = ((((i3 & 112) ^ 48) > 32 && composer.I(obj3)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.I(obj4)) || (i3 & 384) == 256);
        if ((((57344 & i3) ^ 24576) <= 16384 || !composer.I(infiniteRepeatableSpec2)) && (i3 & 24576) != 16384) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        Object objG2 = composer.G();
        if (z4 || objG2 == companion.a()) {
            objG2 = new Function0<Unit>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m22invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m22invoke() {
                    if (Intrinsics.areEqual(obj3, transitionAnimationState2.n()) && Intrinsics.areEqual(obj4, transitionAnimationState2.p())) {
                        return;
                    }
                    transitionAnimationState2.z(obj3, obj4, infiniteRepeatableSpec2);
                }
            };
            composer.w(objG2);
        }
        EffectsKt.j((Function0) objG2, composer, 0);
        boolean zI = composer.I(infiniteTransition2);
        Object objG3 = composer.G();
        if (zI || objG3 == companion.a()) {
            objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    infiniteTransition2.f(transitionAnimationState2);
                    final InfiniteTransition infiniteTransition3 = infiniteTransition2;
                    final InfiniteTransition.TransitionAnimationState transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.InfiniteTransitionKt$animateValue$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            infiniteTransition3.l(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.w(objG3);
        }
        EffectsKt.c(transitionAnimationState2, (Function1) objG3, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transitionAnimationState2;
    }

    public static final InfiniteTransition c(String str, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            str = "InfiniteTransition";
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1013651573, i3, -1, "androidx.compose.animation.core.rememberInfiniteTransition (InfiniteTransition.kt:44)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new InfiniteTransition(str);
            composer.w(objG);
        }
        InfiniteTransition infiniteTransition = (InfiniteTransition) objG;
        infiniteTransition.m(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return infiniteTransition;
    }
}
