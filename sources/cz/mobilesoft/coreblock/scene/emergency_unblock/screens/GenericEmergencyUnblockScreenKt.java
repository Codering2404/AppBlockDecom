package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class GenericEmergencyUnblockScreenKt {
    public static final void g(final String text, final Function0 onClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-246272373);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(text) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-246272373, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockSurfaceButton (GenericEmergencyUnblockScreen.kt:102)");
            }
            ComposeButtonsKt.i0(null, new ButtonType.EmptyWrapperBig(PaddingKt.a(Dp.g(16)), ComposableLambdaKt.e(-358789783, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.r0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GenericEmergencyUnblockScreenKt.h(text, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54)), new ButtonColor.Surface(false, null, false, null, null, 31, null), onClick, composerK, (i4 << 6) & 7168, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GenericEmergencyUnblockScreenKt.i(text, onClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String str, RowScope EmptyWrapperBig, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(EmptyWrapperBig, "$this$EmptyWrapperBig");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-358789783, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockSurfaceButton.<anonymous> (GenericEmergencyUnblockScreen.kt:106)");
            }
            TextKt.c(str, SizeKt.h(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 196656, 0, 64984);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(String str, Function0 function0, int i3, Composer composer, int i4) {
        g(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void j(final Function0 onCloseClicked, final Function0 onContinueUnblocking, final String screenTitle, final List buttonTitles, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onContinueUnblocking, "onContinueUnblocking");
        Intrinsics.checkNotNullParameter(screenTitle, "screenTitle");
        Intrinsics.checkNotNullParameter(buttonTitles, "buttonTitles");
        Composer composerK = composer.k(2093399105);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueUnblocking) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(screenTitle) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(buttonTitles) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2093399105, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.GenericEmergencyUnblockScreen (GenericEmergencyUnblockScreen.kt:51)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.n0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GenericEmergencyUnblockScreenKt.k();
                    }
                };
                composerK.w(objG);
            }
            BackHandlerKt.a(false, (Function0) objG, composerK, 48, 1);
            ComposeBackgroundKt.m(null, false, false, true, null, 2000L, null, ComposableLambdaKt.e(-1633754417, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.o0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GenericEmergencyUnblockScreenKt.l(onCloseClicked, screenTitle, buttonTitles, onContinueUnblocking, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12782592, 87);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GenericEmergencyUnblockScreenKt.n(onCloseClicked, onContinueUnblocking, screenTitle, buttonTitles, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final Function0 function0, String str, List list, Function0 function02, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1633754417, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.GenericEmergencyUnblockScreen.<anonymous> (GenericEmergencyUnblockScreen.kt:58)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(ScrollKt.g(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return GenericEmergencyUnblockScreenKt.m(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 253);
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(str, PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer, 6);
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            composer.a0(1593690759);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g((String) it.next(), function02, composer, 0);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer, 6);
            }
            composer.U();
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
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, Function0 function02, String str, List list, int i3, Composer composer, int i4) {
        j(function0, function02, str, list, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
