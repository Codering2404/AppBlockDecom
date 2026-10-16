package androidx.constraintlayout.compose;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;

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
public final class LateMotionLayoutKt {
    public static final void a(final MutableState mutableState, final MutableState mutableState2, final AnimationSpec animationSpec, Channel channel, final androidx.compose.runtime.State state, final Ref ref, final int i3, final Function0 function0, final Modifier modifier, final Function2 function2, Composer composer, final int i4) {
        int i5;
        androidx.compose.runtime.State state2;
        int i6;
        Composer composer2;
        final Channel channel2;
        Composer composerK = composer.k(688627412);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(mutableState) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.Z(mutableState2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(animationSpec) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(channel) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            state2 = state;
            i5 |= composerK.Z(state2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            state2 = state;
        }
        if ((196608 & i4) == 0) {
            i5 |= (i4 & 262144) == 0 ? composerK.Z(ref) : composerK.I(ref) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i6 = i3;
            i5 |= composerK.e(i6) ? 1048576 : 524288;
        } else {
            i6 = i3;
        }
        if ((i4 & 12582912) == 0) {
            i5 |= composerK.I(function0) ? 8388608 : 4194304;
        }
        if ((i4 & 100663296) == 0) {
            i5 |= composerK.Z(modifier) ? 67108864 : 33554432;
        }
        if ((i4 & 805306368) == 0) {
            i5 |= composerK.I(function2) ? 536870912 : 268435456;
        }
        if ((i5 & 306783379) == 306783378 && composerK.l()) {
            composerK.Q();
            channel2 = channel;
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(688627412, i5, -1, "androidx.constraintlayout.compose.LateMotionLayout (LateMotionLayout.kt:55)");
            }
            Density density = (Density) composerK.q(CompositionLocalsKt.f());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new MotionMeasurer(density);
                composerK.w(objG);
            }
            final MotionMeasurer motionMeasurer = (MotionMeasurer) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG2);
            }
            Animatable animatable = (Animatable) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = animatable.g();
                composerK.w(objG3);
            }
            androidx.compose.runtime.State state3 = (androidx.compose.runtime.State) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotIntStateKt.a(1);
                composerK.w(objG4);
            }
            MutableIntState mutableIntState = (MutableIntState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new Function0<ConstraintSet>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$measurePolicy$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final ConstraintSet invoke() {
                        Object value = mutableState.getValue();
                        Intrinsics.checkNotNull(value);
                        return (ConstraintSet) value;
                    }
                };
                composerK.w(objG5);
            }
            Function0 function02 = (Function0) objG5;
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = new Function0<ConstraintSet>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$measurePolicy$2$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final ConstraintSet invoke() {
                        Object value = mutableState2.getValue();
                        Intrinsics.checkNotNull(value);
                        return (ConstraintSet) value;
                    }
                };
                composerK.w(objG6);
            }
            int i7 = i5;
            MeasurePolicy measurePolicyB = b(function02, (Function0) objG6, state2, ref, state3, motionMeasurer, i6);
            boolean zI = composerK.I(motionMeasurer);
            Object objG7 = composerK.G();
            if (zI || objG7 == companion.a()) {
                objG7 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$1$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        ToolingUtilsKt.a(semanticsPropertyReceiver, motionMeasurer);
                    }
                };
                composerK.w(objG7);
            }
            boolean z2 = true;
            composer2 = composerK;
            LayoutKt.a(SemanticsModifierKt.f(modifier, false, (Function1) objG7, 1, null), function2, measurePolicyB, composer2, (i7 >> 24) & 112, 0);
            boolean zI2 = composer2.I(channel) | ((i7 & 14) == 4) | ((i7 & 112) == 32) | ((i7 & 458752) == 131072 || ((i7 & 262144) != 0 && composer2.I(ref))) | composer2.I(animatable) | composer2.I(animationSpec);
            if ((i7 & 29360128) != 8388608) {
                z2 = false;
            }
            boolean z3 = zI2 | z2;
            Object objG8 = composer2.G();
            if (z3 || objG8 == companion.a()) {
                LateMotionLayoutKt$LateMotionLayout$2$1 lateMotionLayoutKt$LateMotionLayout$2$1 = new LateMotionLayoutKt$LateMotionLayout$2$1(channel, mutableIntState, mutableState, mutableState2, ref, animatable, animationSpec, function0, null);
                channel2 = channel;
                composer2.w(lateMotionLayoutKt$LateMotionLayout$2$1);
                objG8 = lateMotionLayoutKt$LateMotionLayout$2$1;
            } else {
                channel2 = channel;
            }
            EffectsKt.g(channel2, (Function2) objG8, composer2, (i7 >> 9) & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$LateMotionLayout$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i8) {
                    LateMotionLayoutKt.a(mutableState, mutableState2, animationSpec, channel2, state, ref, i3, function0, modifier, function2, composer3, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    private static final MeasurePolicy b(final Function0 function0, final Function0 function02, final androidx.compose.runtime.State state, final Ref ref, final androidx.compose.runtime.State state2, final MotionMeasurer motionMeasurer, final int i3) {
        return new MeasurePolicy() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$lateMotionLayoutMeasurePolicy$1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* JADX INFO: renamed from: measure-3p2s80s */
            public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, final List list, long j3) {
                state.getValue();
                MotionMeasurer motionMeasurer2 = motionMeasurer;
                LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                ConstraintSet constraintSet = (ConstraintSet) function0.invoke();
                ConstraintSet constraintSet2 = (ConstraintSet) function02.invoke();
                TransitionImpl transitionImplA = TransitionImpl.f30993b.a();
                int i4 = i3;
                float fFloatValue = ((Number) state2.getValue()).floatValue();
                CompositionSource compositionSource = (CompositionSource) ref.a();
                if (compositionSource == null) {
                    compositionSource = CompositionSource.Unknown;
                }
                long jK = motionMeasurer2.K(j3, layoutDirection, constraintSet, constraintSet2, transitionImplA, list, i4, fFloatValue, compositionSource, null);
                ref.b(CompositionSource.Unknown);
                int iG = IntSize.g(jK);
                int iF = IntSize.f(jK);
                final MotionMeasurer motionMeasurer3 = motionMeasurer;
                return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.constraintlayout.compose.LateMotionLayoutKt$lateMotionLayoutMeasurePolicy$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope) {
                        motionMeasurer3.w(placementScope, list);
                    }
                }, 4, null);
            }
        };
    }
}
