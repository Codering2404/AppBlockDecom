package androidx.compose.animation.core;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

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
public final class AnimateAsStateKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SpringSpec f3807a = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SpringSpec f3808b = AnimationSpecKt.l(0.0f, 0.0f, Dp.d(VisibilityThresholdsKt.a(Dp.f29970b)), 3, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SpringSpec f3809c = AnimationSpecKt.l(0.0f, 0.0f, Size.c(VisibilityThresholdsKt.d(Size.f25617b)), 3, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SpringSpec f3810d = AnimationSpecKt.l(0.0f, 0.0f, Offset.d(VisibilityThresholdsKt.c(Offset.f25596b)), 3, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SpringSpec f3811e = AnimationSpecKt.l(0.0f, 0.0f, VisibilityThresholdsKt.g(Rect.f25601e), 3, null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SpringSpec f3812f = AnimationSpecKt.l(0.0f, 0.0f, Integer.valueOf(VisibilityThresholdsKt.b(IntCompanionObject.f140132a)), 3, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SpringSpec f3813g = AnimationSpecKt.l(0.0f, 0.0f, IntOffset.c(VisibilityThresholdsKt.e(IntOffset.f29988b)), 3, null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SpringSpec f3814h = AnimationSpecKt.l(0.0f, 0.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 3, null);

    public static final State c(float f3, AnimationSpec animationSpec, String str, Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = f3808b;
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i4 & 4) != 0) {
            str = "DpAnimation";
        }
        String str2 = str;
        if ((i4 & 8) != 0) {
            function1 = null;
        }
        Function1 function12 = function1;
        if (ComposerKt.M()) {
            ComposerKt.U(-1407150062, i3, -1, "androidx.compose.animation.core.animateDpAsState (AnimateAsState.kt:111)");
        }
        int i5 = i3 << 6;
        State stateE = e(Dp.d(f3), VectorConvertersKt.e(Dp.f29970b), animationSpec2, null, str2, function12, composer, (i3 & 14) | ((i3 << 3) & 896) | (57344 & i5) | (i5 & 458752), 8);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateE;
    }

    public static final State d(float f3, AnimationSpec animationSpec, float f4, String str, Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = f3807a;
        }
        if ((i4 & 4) != 0) {
            f4 = 0.01f;
        }
        if ((i4 & 8) != 0) {
            str = "FloatAnimation";
        }
        String str2 = str;
        Function1 function12 = (i4 & 16) != 0 ? null : function1;
        if (ComposerKt.M()) {
            ComposerKt.U(668842840, i3, -1, "androidx.compose.animation.core.animateFloatAsState (AnimateAsState.kt:67)");
        }
        if (animationSpec == f3807a) {
            composer.a0(1125558999);
            boolean z2 = (((i3 & 896) ^ 384) > 256 && composer.c(f4)) || (i3 & 384) == 256;
            Object objG = composer.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = AnimationSpecKt.l(0.0f, 0.0f, Float.valueOf(f4), 3, null);
                composer.w(objG);
            }
            animationSpec = (SpringSpec) objG;
            composer.U();
        } else {
            composer.a0(1125668925);
            composer.U();
        }
        AnimationSpec animationSpec2 = animationSpec;
        Float fValueOf = Float.valueOf(f3);
        TwoWayConverter twoWayConverterI = VectorConvertersKt.i(FloatCompanionObject.f140130a);
        Float fValueOf2 = Float.valueOf(f4);
        int i5 = i3 << 3;
        State stateE = e(fValueOf, twoWayConverterI, animationSpec2, fValueOf2, str2, function12, composer, (i3 & 14) | (i5 & 7168) | (57344 & i5) | (i5 & 458752), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateE;
    }

    public static final State e(final Object obj, TwoWayConverter twoWayConverter, AnimationSpec animationSpec, Object obj2, String str, Function1 function1, Composer composer, int i3, int i4) {
        AnimationSpec animationSpecK;
        Channel channel;
        if ((i4 & 4) != 0) {
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
                composer.w(objG);
            }
            animationSpecK = (SpringSpec) objG;
        } else {
            animationSpecK = animationSpec;
        }
        Object obj3 = (i4 & 8) != 0 ? null : obj2;
        String str2 = (i4 & 16) != 0 ? "ValueAnimation" : str;
        Function1 function12 = (i4 & 32) != 0 ? null : function1;
        if (ComposerKt.M()) {
            ComposerKt.U(-1994373980, i3, -1, "androidx.compose.animation.core.animateValueAsState (AnimateAsState.kt:395)");
        }
        Object objG2 = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG2 == companion.a()) {
            objG2 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
            composer.w(objG2);
        }
        MutableState mutableState = (MutableState) objG2;
        Object objG3 = composer.G();
        if (objG3 == companion.a()) {
            objG3 = new Animatable(obj, twoWayConverter, obj3, str2);
            composer.w(objG3);
        }
        Animatable animatable = (Animatable) objG3;
        State stateP = SnapshotStateKt.p(function12, composer, (i3 >> 15) & 14);
        if (obj3 != null && (animationSpecK instanceof SpringSpec)) {
            SpringSpec springSpec = (SpringSpec) animationSpecK;
            if (!Intrinsics.areEqual(springSpec.h(), obj3)) {
                animationSpecK = AnimationSpecKt.k(springSpec.f(), springSpec.g(), obj3);
            }
        }
        State stateP2 = SnapshotStateKt.p(animationSpecK, composer, 0);
        Object objG4 = composer.G();
        if (objG4 == companion.a()) {
            objG4 = ChannelKt.b(-1, null, null, 6, null);
            composer.w(objG4);
        }
        final Channel channel2 = (Channel) objG4;
        boolean zI = ((((i3 & 14) ^ 6) > 4 && composer.I(obj)) || (i3 & 6) == 4) | composer.I(channel2);
        Object objG5 = composer.G();
        if (zI || objG5 == companion.a()) {
            objG5 = new Function0<Unit>() { // from class: androidx.compose.animation.core.AnimateAsStateKt$animateValueAsState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m21invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m21invoke() {
                    channel2.h(obj);
                }
            };
            composer.w(objG5);
        }
        EffectsKt.j((Function0) objG5, composer, 0);
        boolean zI2 = composer.I(channel2) | composer.I(animatable) | composer.Z(stateP2) | composer.Z(stateP);
        Object objG6 = composer.G();
        if (zI2 || objG6 == companion.a()) {
            channel = channel2;
            Object animateAsStateKt$animateValueAsState$3$1 = new AnimateAsStateKt$animateValueAsState$3$1(channel, animatable, stateP2, stateP, null);
            composer.w(animateAsStateKt$animateValueAsState$3$1);
            objG6 = animateAsStateKt$animateValueAsState$3$1;
        } else {
            channel = channel2;
        }
        EffectsKt.g(channel, (Function2) objG6, composer, 0);
        State stateG = (State) mutableState.getValue();
        if (stateG == null) {
            stateG = animatable.g();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 f(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationSpec g(State state) {
        return (AnimationSpec) state.getValue();
    }
}
