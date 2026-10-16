package androidx.compose.animation;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
final class CrossfadeKt$Crossfade$5$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Transition f3462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FiniteAnimationSpec f3463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f3464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function3 f3465d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CrossfadeKt$Crossfade$5$1(Transition transition, FiniteAnimationSpec finiteAnimationSpec, Object obj, Function3 function3) {
        super(2);
        this.f3462a = transition;
        this.f3463b = finiteAnimationSpec;
        this.f3464c = obj;
        this.f3465d = function3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.f139807a;
    }

    public final void invoke(Composer composer, int i3) {
        if (!composer.r((i3 & 3) != 2, i3 & 1)) {
            composer.Q();
            return;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1426421288, i3, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous> (Crossfade.kt:125)");
        }
        Transition transition = this.f3462a;
        final FiniteAnimationSpec finiteAnimationSpec = this.f3463b;
        Function3<Transition.Segment<Object>, Composer, Integer, FiniteAnimationSpec<Float>> function3 = new Function3<Transition.Segment<Object>, Composer, Integer, FiniteAnimationSpec<Float>>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$5$1$alpha$2
            {
                super(3);
            }

            public final FiniteAnimationSpec c(Transition.Segment segment, Composer composer2, int i4) {
                composer2.a0(438406499);
                if (ComposerKt.M()) {
                    ComposerKt.U(438406499, i4, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:126)");
                }
                FiniteAnimationSpec finiteAnimationSpec2 = finiteAnimationSpec;
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer2.U();
                return finiteAnimationSpec2;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Transition.Segment) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        };
        Object obj = this.f3464c;
        TwoWayConverter twoWayConverterI = VectorConvertersKt.i(FloatCompanionObject.f140130a);
        Object objI = transition.i();
        composer.a0(-438678252);
        if (ComposerKt.M()) {
            ComposerKt.U(-438678252, 0, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:127)");
        }
        float f3 = Intrinsics.areEqual(objI, obj) ? 1.0f : 0.0f;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        Float fValueOf = Float.valueOf(f3);
        Object objQ = transition.q();
        composer.a0(-438678252);
        if (ComposerKt.M()) {
            ComposerKt.U(-438678252, 0, -1, "androidx.compose.animation.Crossfade.<anonymous>.<anonymous>.<anonymous> (Crossfade.kt:127)");
        }
        float f4 = Intrinsics.areEqual(objQ, obj) ? 1.0f : 0.0f;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        final State stateF = androidx.compose.animation.core.TransitionKt.f(transition, fValueOf, Float.valueOf(f4), (FiniteAnimationSpec) function3.invoke(transition.o(), composer, 0), twoWayConverterI, "FloatAnimation", composer, 0);
        Modifier.Companion companion = Modifier.b8;
        boolean Z = composer.Z(stateF);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$5$1$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((GraphicsLayerScope) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                    graphicsLayerScope.c(CrossfadeKt$Crossfade$5$1.d(stateF));
                }
            };
            composer.w(objG);
        }
        Modifier modifierA = GraphicsLayerModifierKt.a(companion, (Function1) objG);
        Function3 function32 = this.f3465d;
        Object obj2 = this.f3464c;
        MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
        ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
        Function0 function0A = companion2.a();
        if (composer.m() == null) {
            ComposablesKt.c();
        }
        composer.L();
        if (composer.i()) {
            composer.P(function0A);
        } else {
            composer.v();
        }
        Composer composerA = Updater.a(composer);
        Updater.e(composerA, measurePolicyG, companion2.e());
        Updater.e(composerA, compositionLocalMapU, companion2.g());
        Function2 function2B = companion2.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion2.f());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
        function32.invoke(obj2, composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }
}
