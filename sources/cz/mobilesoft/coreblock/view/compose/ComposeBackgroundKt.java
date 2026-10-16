package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.ScreenProgressBarKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeBackgroundKt {
    private static final void k(final BoxScope boxScope, Function0 function0, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final Function0 function02;
        Composer composerK = composer.k(2045565427);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(function0) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2045565427, i4, -1, "cz.mobilesoft.coreblock.view.compose.CloseButton (ComposeBackground.kt:235)");
            }
            function02 = function0;
            FlatButtonsKt.L(null, Dp.g(40), VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composerK, 6), FlatButtonColors.Secondary.f131167a, StringResources_androidKt.b(R.string.N7, composerK, 0), function02, composerK, ((i4 << 12) & 458752) | 3120, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeBackgroundKt.l(boxScope, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(BoxScope boxScope, Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        k(boxScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:163:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:168:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(androidx.compose.ui.Modifier r31, boolean r32, boolean r33, boolean r34, java.lang.String r35, long r36, androidx.compose.ui.graphics.Brush r38, final kotlin.jvm.functions.Function3 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt.m(androidx.compose.ui.Modifier, boolean, boolean, boolean, java.lang.String, long, androidx.compose.ui.graphics.Brush, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean n(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(BoxScope boxScope, String str, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(1199550655, i3, -1, "cz.mobilesoft.coreblock.view.compose.GradientBox.<anonymous>.<anonymous>.<anonymous> (ComposeBackground.kt:106)");
        }
        androidx.compose.material.TextKt.c(str, PaddingKt.k(boxScope.f(Modifier.b8, Alignment.f25072a.e()), Dp.g(16), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65016);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function3 function3, BoxScope boxScope, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-468929473, i3, -1, "cz.mobilesoft.coreblock.view.compose.GradientBox.<anonymous>.<anonymous> (ComposeBackground.kt:128)");
        }
        function3.invoke(boxScope, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, boolean z2, boolean z3, boolean z4, String str, long j3, Brush brush, Function3 function3, int i3, int i4, Composer composer, int i5) {
        m(modifier, z2, z3, z4, str, j3, brush, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(androidx.compose.ui.Modifier r19, androidx.compose.ui.Modifier r20, final java.lang.Float r21, kotlin.jvm.functions.Function0 r22, final kotlin.jvm.functions.Function3 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt.s(androidx.compose.ui.Modifier, androidx.compose.ui.Modifier, java.lang.Float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Modifier modifier, final Function0 function0, Float f3, Function3 function3, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1111267102, i3, -1, "cz.mobilesoft.coreblock.view.compose.GradientBoxWithProgress.<anonymous> (ComposeBackground.kt:147)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(companion, 0.0f, 1, null), WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6));
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifier);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (function0 == null) {
                composer.a0(1008142403);
            } else {
                composer.a0(1008142404);
                boolean Z = composer.Z(function0);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.y1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeBackgroundKt.u(function0);
                        }
                    };
                    composer.w(objG);
                }
                k(boxScopeInstance, (Function0) objG, composer, 6);
            }
            composer.U();
            if (f3 == null) {
                composer.a0(1008240983);
            } else {
                composer.a0(1008240984);
                ScreenProgressBarKt.b(boxScopeInstance.f(SizeKt.A(companion, Dp.g(72)), companion2.e()), f3.floatValue(), composer, 0, 0);
            }
            composer.U();
            composer.y();
            Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            function3.invoke(boxScopeInstance, composer, 6);
            composer.y();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, Modifier modifier2, Float f3, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        s(modifier, modifier2, f3, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void w(androidx.compose.ui.Modifier r19, final java.lang.Float r20, kotlin.jvm.functions.Function0 r21, final kotlin.jvm.functions.Function3 r22, final kotlin.jvm.functions.Function3 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt.w(androidx.compose.ui.Modifier, java.lang.Float, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function3 function3, final Function0 function0, Float f3, Function3 function32, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1786885895, i3, -1, "cz.mobilesoft.coreblock.view.compose.GradientOnboardingBox.<anonymous> (ComposeBackground.kt:188)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(companion, 0.0f, 1, null), WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6));
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (function0 == null) {
                composer.a0(1220056148);
            } else {
                composer.a0(1220056149);
                float f4 = 16;
                Modifier modifierM = PaddingKt.m(companion, Dp.g(f4), Dp.g(f4), 0.0f, 0.0f, 12, null);
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                int iA3 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU3 = composer.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer, modifierM);
                Function0 function0A3 = companion3.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A3);
                } else {
                    composer.v();
                }
                Composer composerA3 = Updater.a(composer);
                Updater.e(composerA3, measurePolicyG2, companion3.e());
                Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                Function2 function2B3 = companion3.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion3.f());
                boolean Z = composer.Z(function0);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.z1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ComposeBackgroundKt.y(function0);
                        }
                    };
                    composer.w(objG);
                }
                k(boxScopeInstance, (Function0) objG, composer, 6);
                composer.y();
                Unit unit = Unit.f139807a;
            }
            composer.U();
            if (f3 == null) {
                composer.a0(1220248906);
            } else {
                composer.a0(1220248907);
                ScreenProgressBarKt.b(PaddingKt.m(boxScopeInstance.f(companion, companion2.e()), 0.0f, Dp.g(32), 0.0f, Dp.g(14), 5, null), f3.floatValue(), composer, 0, 0);
                Unit unit2 = Unit.f139807a;
            }
            composer.U();
            composer.y();
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion2.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierB);
            Function0 function0A4 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyG3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            function32.invoke(boxScopeInstance, composer, 6);
            composer.y();
            if (function3 == null) {
                composer.a0(-1793471752);
            } else {
                composer.a0(-1793471751);
                float f5 = 16;
                Modifier modifierL = PaddingKt.l(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null), Dp.g(f5), Dp.g(f5), Dp.g(f5), Dp.g(f5));
                MeasurePolicy measurePolicyG4 = BoxKt.g(companion2.o(), false);
                int iA5 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU5 = composer.u();
                Modifier modifierF5 = ComposedModifierKt.f(composer, modifierL);
                Function0 function0A5 = companion3.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A5);
                } else {
                    composer.v();
                }
                Composer composerA5 = Updater.a(composer);
                Updater.e(composerA5, measurePolicyG4, companion3.e());
                Updater.e(composerA5, compositionLocalMapU5, companion3.g());
                Function2 function2B5 = companion3.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF5, companion3.f());
                function3.invoke(boxScopeInstance, composer, 6);
                composer.y();
                Unit unit3 = Unit.f139807a;
            }
            composer.U();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, Float f3, Function0 function0, Function3 function3, Function3 function32, int i3, int i4, Composer composer, int i5) {
        w(modifier, f3, function0, function3, function32, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
