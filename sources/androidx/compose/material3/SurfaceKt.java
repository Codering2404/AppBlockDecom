package androidx.compose.material3;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class SurfaceKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f20349a = CompositionLocalKt.e(null, new Function0<Dp>() { // from class: androidx.compose.material3.SurfaceKt$LocalAbsoluteTonalElevation$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Dp.d(m188invokeD9Ej5fM());
        }

        /* JADX INFO: renamed from: invoke-D9Ej5fM, reason: not valid java name */
        public final float m188invokeD9Ej5fM() {
            return Dp.g(0);
        }
    }, 1, null);

    public static final void a(Modifier modifier, Shape shape, long j3, long j4, float f3, float f4, BorderStroke borderStroke, final Function2 function2, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            modifier = Modifier.b8;
        }
        if ((i4 & 2) != 0) {
            shape = RectangleShapeKt.a();
        }
        if ((i4 & 4) != 0) {
            j3 = MaterialTheme.f18110a.a(composer, 6).o0();
        }
        if ((i4 & 8) != 0) {
            j4 = ColorSchemeKt.c(j3, composer, (i3 >> 6) & 14);
        }
        if ((i4 & 16) != 0) {
            f3 = Dp.g(0);
        }
        if ((i4 & 32) != 0) {
            f4 = Dp.g(0);
        }
        if ((i4 & 64) != 0) {
            borderStroke = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-513881741, i3, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        ProvidableCompositionLocal providableCompositionLocal = f20349a;
        final float fG = Dp.g(((Dp) composer.q(providableCompositionLocal)).l() + f3);
        ProvidedValue[] providedValueArr = {ContentColorKt.a().d(Color.n(j4)), providableCompositionLocal.d(Dp.d(fG))};
        final long j5 = j3;
        final Shape shape2 = shape;
        final BorderStroke borderStroke2 = borderStroke;
        final float f5 = f4;
        final Modifier modifier2 = modifier;
        CompositionLocalKt.c(providedValueArr, ComposableLambdaKt.e(-70914509, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1

            /* JADX INFO: renamed from: androidx.compose.material3.SurfaceKt$Surface$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "androidx.compose.material3.SurfaceKt$Surface$1$3", f = "Surface.kt", l = {}, m = "invokeSuspend")
            static final class AnonymousClass3 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f20359a;

                AnonymousClass3(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation create(Object obj, Continuation continuation) {
                    return new AnonymousClass3(continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation continuation) {
                    return ((AnonymousClass3) create(pointerInputScope, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.f20359a != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Unit.f139807a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i5) {
                if ((i5 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-70914509, i5, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:108)");
                }
                Modifier modifierThen = SemanticsModifierKt.e(SurfaceKt.h(modifier2, shape2, SurfaceKt.i(j5, fG, composer2, 0), borderStroke2, ((Density) composer2.q(CompositionLocalsKt.f())).M1(f5)), false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.b0(semanticsPropertyReceiver, true);
                    }
                }).then(new SuspendPointerInputElement(Unit.f139807a, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new AnonymousClass3(null)), 6, null));
                Function2 function22 = function2;
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierThen);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function22.invoke(composer2, 0);
                composer2.y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, ProvidedValue.f24012i | 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void b(final boolean z2, final Function0 function0, Modifier modifier, boolean z3, Shape shape, long j3, long j4, float f3, float f4, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2 function2, Composer composer, int i3, int i4, int i5) {
        final Modifier modifier2 = (i5 & 4) != 0 ? Modifier.b8 : modifier;
        final boolean z4 = (i5 & 8) != 0 ? true : z3;
        final Shape shapeA = (i5 & 16) != 0 ? RectangleShapeKt.a() : shape;
        final long jO0 = (i5 & 32) != 0 ? MaterialTheme.f18110a.a(composer, 6).o0() : j3;
        long jC = (i5 & 64) != 0 ? ColorSchemeKt.c(jO0, composer, (i3 >> 15) & 14) : j4;
        float fG = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Dp.g(0) : f3;
        final float fG2 = (i5 & Function.MAX_NARGS) != 0 ? Dp.g(0) : f4;
        BorderStroke borderStroke2 = (i5 & 512) != 0 ? null : borderStroke;
        final MutableInteractionSource mutableInteractionSource2 = (i5 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.M()) {
            ComposerKt.U(540296512, i3, i4, "androidx.compose.material3.Surface (Surface.kt:306)");
        }
        ProvidableCompositionLocal providableCompositionLocal = f20349a;
        final float fG3 = Dp.g(((Dp) composer.q(providableCompositionLocal)).l() + fG);
        final BorderStroke borderStroke3 = borderStroke2;
        CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(jC)), providableCompositionLocal.d(Dp.d(fG3))}, ComposableLambdaKt.e(-1164547968, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                if ((i6 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1164547968, i6, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:312)");
                }
                Modifier modifierB = SelectableKt.b(SurfaceKt.h(InteractiveComponentSizeKt.b(modifier2), shapeA, SurfaceKt.i(jO0, fG3, composer2, 0), borderStroke3, ((Density) composer2.q(CompositionLocalsKt.f())).M1(fG2)), z2, mutableInteractionSource2, RippleKt.d(false, 0.0f, 0L, composer2, 0, 7), z4, null, function0, 16, null);
                Function2 function22 = function2;
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierB);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function22.invoke(composer2, 0);
                composer2.y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, ProvidedValue.f24012i | 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void c(final boolean z2, final Function1 function1, Modifier modifier, boolean z3, Shape shape, long j3, long j4, float f3, float f4, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2 function2, Composer composer, int i3, int i4, int i5) {
        final Modifier modifier2 = (i5 & 4) != 0 ? Modifier.b8 : modifier;
        final boolean z4 = (i5 & 8) != 0 ? true : z3;
        final Shape shapeA = (i5 & 16) != 0 ? RectangleShapeKt.a() : shape;
        final long jO0 = (i5 & 32) != 0 ? MaterialTheme.f18110a.a(composer, 6).o0() : j3;
        long jC = (i5 & 64) != 0 ? ColorSchemeKt.c(jO0, composer, (i3 >> 15) & 14) : j4;
        float fG = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Dp.g(0) : f3;
        final float fG2 = (i5 & Function.MAX_NARGS) != 0 ? Dp.g(0) : f4;
        BorderStroke borderStroke2 = (i5 & 512) != 0 ? null : borderStroke;
        final MutableInteractionSource mutableInteractionSource2 = (i5 & 1024) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.M()) {
            ComposerKt.U(-1877401889, i3, i4, "androidx.compose.material3.Surface (Surface.kt:410)");
        }
        ProvidableCompositionLocal providableCompositionLocal = f20349a;
        final float fG3 = Dp.g(((Dp) composer.q(providableCompositionLocal)).l() + fG);
        final BorderStroke borderStroke3 = borderStroke2;
        CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(jC)), providableCompositionLocal.d(Dp.d(fG3))}, ComposableLambdaKt.e(712720927, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                if ((i6 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(712720927, i6, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:416)");
                }
                Modifier modifierB = ToggleableKt.b(SurfaceKt.h(InteractiveComponentSizeKt.b(modifier2), shapeA, SurfaceKt.i(jO0, fG3, composer2, 0), borderStroke3, ((Density) composer2.q(CompositionLocalsKt.f())).M1(fG2)), z2, mutableInteractionSource2, RippleKt.d(false, 0.0f, 0L, composer2, 0, 7), z4, null, function1, 16, null);
                Function2 function22 = function2;
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierB);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function22.invoke(composer2, 0);
                composer2.y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, ProvidedValue.f24012i | 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final void d(final Function0 function0, Modifier modifier, boolean z2, Shape shape, long j3, long j4, float f3, float f4, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function2 function2, Composer composer, int i3, int i4, int i5) {
        final Modifier modifier2 = (i5 & 2) != 0 ? Modifier.b8 : modifier;
        final boolean z3 = (i5 & 4) != 0 ? true : z2;
        final Shape shapeA = (i5 & 8) != 0 ? RectangleShapeKt.a() : shape;
        final long jO0 = (i5 & 16) != 0 ? MaterialTheme.f18110a.a(composer, 6).o0() : j3;
        long jC = (i5 & 32) != 0 ? ColorSchemeKt.c(jO0, composer, (i3 >> 12) & 14) : j4;
        float fG = (i5 & 64) != 0 ? Dp.g(0) : f3;
        final float fG2 = (i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Dp.g(0) : f4;
        BorderStroke borderStroke2 = (i5 & Function.MAX_NARGS) != 0 ? null : borderStroke;
        MutableInteractionSource mutableInteractionSource2 = (i5 & 512) == 0 ? mutableInteractionSource : null;
        if (ComposerKt.M()) {
            ComposerKt.U(-789752804, i3, i4, "androidx.compose.material3.Surface (Surface.kt:203)");
        }
        ProvidableCompositionLocal providableCompositionLocal = f20349a;
        final float fG3 = Dp.g(((Dp) composer.q(providableCompositionLocal)).l() + fG);
        final BorderStroke borderStroke3 = borderStroke2;
        final MutableInteractionSource mutableInteractionSource3 = mutableInteractionSource2;
        CompositionLocalKt.c(new ProvidedValue[]{ContentColorKt.a().d(Color.n(jC)), providableCompositionLocal.d(Dp.d(fG3))}, ComposableLambdaKt.e(1279702876, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.SurfaceKt$Surface$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(Composer composer2, int i6) {
                if ((i6 & 3) == 2 && composer2.l()) {
                    composer2.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(1279702876, i6, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:209)");
                }
                Modifier modifierD = ClickableKt.d(SurfaceKt.h(InteractiveComponentSizeKt.b(modifier2), shapeA, SurfaceKt.i(jO0, fG3, composer2, 0), borderStroke3, ((Density) composer2.q(CompositionLocalsKt.f())).M1(fG2)), mutableInteractionSource3, RippleKt.d(false, 0.0f, 0L, composer2, 0, 7), z3, null, null, function0, 24, null);
                Function2 function22 = function2;
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), true);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                ComposeUiNode.Companion companion = ComposeUiNode.f8;
                Function0 function0A = companion.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A);
                } else {
                    composer2.v();
                }
                Composer composerA = Updater.a(composer2);
                Updater.e(composerA, measurePolicyG, companion.e());
                Updater.e(composerA, compositionLocalMapU, companion.g());
                Function2 function2B = companion.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function22.invoke(composer2, 0);
                composer2.y();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }, composer, 54), composer, ProvidedValue.f24012i | 48);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    public static final ProvidableCompositionLocal g() {
        return f20349a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier h(Modifier modifier, Shape shape, long j3, BorderStroke borderStroke, float f3) {
        Shape shape2;
        Modifier modifierC;
        if (f3 > 0.0f) {
            shape2 = shape;
            modifierC = GraphicsLayerModifierKt.c(Modifier.b8, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, 0L, shape2, false, null, 0L, 0L, 0, 124895, null);
        } else {
            shape2 = shape;
            modifierC = Modifier.b8;
        }
        return ClipKt.a(BackgroundKt.c(modifier.then(modifierC).then(borderStroke != null ? BorderKt.e(Modifier.b8, borderStroke, shape2) : Modifier.b8), j3, shape2), shape2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(long j3, float f3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2079918090, i3, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        long jA = ColorSchemeKt.a(MaterialTheme.f18110a.a(composer, 6), j3, f3, composer, (i3 << 3) & 1008);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jA;
    }
}
