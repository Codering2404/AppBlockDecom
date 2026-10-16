package cz.mobilesoft.coreblock.view.compose;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.lockscreen.ossettings.SystemSettingsType;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class ComposeDialogsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Modifier modifier, final Function3 function3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(922798231, i3, -1, "cz.mobilesoft.coreblock.view.compose.CustomDialog.<anonymous> (ComposeDialogs.kt:184)");
            }
            SurfaceKt.a(modifier, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), ComposeColorsKt.j(composer, 0).l0(), 0L, null, 0.0f, ComposableLambdaKt.e(1061062363, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.s6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.C0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Function3 function3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1061062363, i3, -1, "cz.mobilesoft.coreblock.view.compose.CustomDialog.<anonymous>.<anonymous> (ComposeDialogs.kt:189)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            function3.invoke(BoxScopeInstance.f6642a, composer, 6);
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
    public static final Unit D0(MutableState mutableState, Modifier modifier, DialogProperties dialogProperties, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        z0(mutableState, modifier, dialogProperties, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:85:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void E0(androidx.compose.ui.Modifier r20, final java.lang.String r21, long r22, boolean r24, final kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.E0(androidx.compose.ui.Modifier, java.lang.String, long, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(String str, boolean z2, long j3, RowScope TextButton, Composer composer, int i3) {
        long jS;
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1737936797, i3, -1, "cz.mobilesoft.coreblock.view.compose.DialogButton.<anonymous> (ComposeDialogs.kt:282)");
            }
            Modifier modifierJ = PaddingKt.j(Modifier.b8, Dp.g(6), Dp.g(4));
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            if (z2) {
                composer.a0(-585010618);
                composer.U();
                jS = j3;
            } else {
                composer.a0(-585009910);
                jS = ComposeColorsKt.j(composer, 0).s();
                composer.U();
            }
            androidx.compose.material.TextKt.c(upperCase, modifierJ, jS, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, TextUnitKt.i(13), new FontWeight(ColorExtractionConstants.MAXIMUM_BRIGHTNESS_THRESHOLD), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777209, null), composer, 0, 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Modifier modifier, String str, long j3, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        E0(modifier, str, j3, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void H0(final MutableState showDialog, final Function0 onDiscardClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(onDiscardClicked, "onDiscardClicked");
        Composer composerK = composer.k(1870088751);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(showDialog) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDiscardClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1870088751, i4, -1, "cz.mobilesoft.coreblock.view.compose.ExitConfirmationDialog (ComposeDialogs.kt:409)");
            }
            String strB = StringResources_androidKt.b(R.string.Kq, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.lc, composerK, 0);
            long jK = ComposeColorsKt.j(composerK, 0).k();
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.x6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.I0(onDiscardClicked);
                    }
                };
                composerK.w(objG);
            }
            x0(showDialog, strB, null, null, strB2, jK, false, (Function0) objG, StringResources_androidKt.b(R.string.di, composerK, 0), 0L, null, composerK, (i4 & 14) | 384, 0, 1608);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.y6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.J0(showDialog, onDiscardClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        H0(mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void K0(final androidx.compose.runtime.MutableState r25, final androidx.compose.runtime.State r26, final java.lang.String r27, final java.lang.String r28, final java.lang.String r29, final kotlin.jvm.functions.Function1 r30, kotlin.jvm.functions.Function0 r31, kotlin.jvm.functions.Function0 r32, int r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.K0(androidx.compose.runtime.MutableState, androidx.compose.runtime.State, java.lang.String, java.lang.String, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(final MutableState mutableState, final Function0 function0, int i3, String str, String str2, State state, final Function1 function1, String str3, final Function0 function02, BoxScope CustomDialog, Composer composer, int i4) throws XmlPullParserException, IOException {
        int i5;
        Intrinsics.checkNotNullParameter(CustomDialog, "$this$CustomDialog");
        if ((i4 & 6) == 0) {
            i5 = i4 | (composer.Z(CustomDialog) ? 4 : 2);
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(697988968, i5, -1, "cz.mobilesoft.coreblock.view.compose.FeatureSuggestionDialog.<anonymous> (ComposeDialogs.kt:320)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierL = PaddingKt.l(companion2, Dp.g(f3), Dp.g(32), Dp.g(f3), Dp.g(f4));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierL);
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
            androidx.compose.foundation.ImageKt.a(PainterResources_androidKt.c(i3, composer, 0), null, PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), null, null, 0.0f, null, composer, 432, 120);
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            androidx.compose.material.TextKt.c(str, SizeKt.g(PaddingKt.m(companion2, 0.0f, 0.0f, 0.0f, Dp.g(8), 7, null), 0.9f), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleH, composer, 48, 0, 65016);
            androidx.compose.material.TextKt.c(str2, SizeKt.g(PaddingKt.m(companion2, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0.9f), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            String strB = StringResources_androidKt.b(R.string.Dk, composer, 0);
            Modifier modifierM = PaddingKt.m(companion2, 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.f7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeDialogsKt.N0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG);
            }
            ComposeCheckablesKt.h(state, strB, modifierM, null, null, 0L, 0.0f, (Function1) objG, composer, 384, 120);
            ButtonType.Big big = new ButtonType.Big(null, null, str3, 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean Z2 = composer.Z(mutableState) | composer.Z(function02);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.g7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.O0(mutableState, function02);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG2, composer, 0, 1);
            composer.y();
            Modifier modifierF2 = CustomDialog.f(companion2, companion.o());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            boolean Z3 = composer.Z(mutableState) | composer.Z(function0);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.h7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.P0(mutableState, function0);
                    }
                };
                composer.w(objG3);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG3, composer, 0, 188);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Function1 function1, boolean z2) {
        function1.invoke(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(MutableState mutableState, State state, String str, String str2, String str3, Function1 function1, Function0 function0, Function0 function02, int i3, int i4, int i5, Composer composer, int i6) {
        K0(mutableState, state, str, str2, str3, function1, function0, function02, i3, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void R0(final androidx.compose.runtime.MutableState r17, java.lang.String r18, java.lang.String r19, kotlin.jvm.functions.Function2 r20, java.lang.String r21, kotlin.jvm.functions.Function0 r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.R0(androidx.compose.runtime.MutableState, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(MutableState mutableState, String str, String str2, Function2 function2, String str3, Function0 function0, int i3, int i4, Composer composer, int i5) {
        R0(mutableState, str, str2, function2, str3, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void U0(final Function0 onDismissed, final Function0 onCreateAccountClicked, final Function0 onSignInClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onDismissed, "onDismissed");
        Intrinsics.checkNotNullParameter(onCreateAccountClicked, "onCreateAccountClicked");
        Intrinsics.checkNotNullParameter(onSignInClicked, "onSignInClicked");
        Composer composerK = composer.k(875591699);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onDismissed) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCreateAccountClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onSignInClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(875591699, i4, -1, "cz.mobilesoft.coreblock.view.compose.PremiumRegistrationDialog (ComposeDialogs.kt:571)");
            }
            function0 = onDismissed;
            AndroidDialog_androidKt.a(function0, new DialogProperties(false, false, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.e(240240156, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.r5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.V0(onDismissed, onCreateAccountClicked, onSignInClicked, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 14) | 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismissed;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.t5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.a1(function0, onCreateAccountClicked, onSignInClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final Function0 function0, final Function0 function02, final Function0 function03, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(240240156, i3, -1, "cz.mobilesoft.coreblock.view.compose.PremiumRegistrationDialog.<anonymous> (ComposeDialogs.kt:578)");
            }
            SurfaceKt.a(null, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), ComposeColorsKt.j(composer, 0).l0(), 0L, null, 0.0f, ComposableLambdaKt.e(2072204896, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.u5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.W0(function0, function02, function03, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 57);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(final Function0 function0, final Function0 function02, final Function0 function03, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2072204896, i3, -1, "cz.mobilesoft.coreblock.view.compose.PremiumRegistrationDialog.<anonymous>.<anonymous> (ComposeDialogs.kt:582)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.p6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.X0(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG, composer, 0, 189);
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            androidx.compose.foundation.ImageKt.a(PainterResources_androidKt.c(R.drawable.s8, composer, 0), null, SizeKt.v(companion, Dp.g(100)), null, null, 0.0f, null, composer, 432, 120);
            float f4 = 24;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.Jp, composer, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composer, 0).g();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            androidx.compose.material.TextKt.c(strB, modifierK, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleG, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.Ip, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.C8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean Z2 = composer.Z(function02);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.q6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.Y0(function02);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG2, composer, 0, 1);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.lx, composer, 0), 0.0f, 11, null);
            ButtonColor.Disabled disabled = new ButtonColor.Disabled(false, null, false, null, 11, null);
            boolean Z3 = composer.Z(function03);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.r6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.Z0(function03);
                    }
                };
                composer.w(objG3);
            }
            ComposeButtonsKt.i0(null, big2, disabled, (Function0) objG3, composer, 0, 1);
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
    public static final Unit X0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        U0(function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void b1(final Function0 onConfirmClick, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onConfirmClick, "onConfirmClick");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(1557666624);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onConfirmClick) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1557666624, i4, -1, "cz.mobilesoft.coreblock.view.compose.StopQBDialog (ComposeDialogs.kt:717)");
            }
            function0 = onDismiss;
            ComposeBottomSheetsKt.f(null, null, false, ComposableLambdaKt.e(-1592181087, true, new Function4() { // from class: cz.mobilesoft.coreblock.view.compose.h5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ComposeDialogsKt.c1(onConfirmClick, onDismiss, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function0, composerK, ((i4 << 12) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.s5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.d1(onConfirmClick, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(Function0 function0, Function0 function02, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1592181087, i3, -1, "cz.mobilesoft.coreblock.view.compose.StopQBDialog.<anonymous> (ComposeDialogs.kt:721)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 24;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 36;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.td, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextStyle textStyleF = materialTheme.c(composer, i4).f();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            androidx.compose.material.TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65022);
            SpacerKt.a(SizeKt.v(companion, Dp.g(16)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.sd, composer, 0), PaddingKt.k(companion, Dp.g(48), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion, Dp.g(18)), composer, 6);
            ButtonKt.a(function0, SizeKt.k(companion, Dp.g(40), 0.0f, 2, null), false, null, null, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95478l, composer, 0)), null, ComposeButtonsKt.L0(ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q0(), null, composer, 384), PaddingKt.c(Dp.g(f4), 0.0f, 2, null), ComposableSingletons$ComposeDialogsKt.f130376a.m(), composer, 905994288, 76);
            SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer, 6);
            ComposeButtonsKt.c0(StringResources_androidKt.b(R.string.ei, composer, 0), null, false, ComposeColorsKt.j(composer, 0).q(), materialTheme.c(composer, i4).j(), 0.0f, null, function02, composer, 0, 102);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public static final void d0(final MutableState showDialog, final Function0 onAddClicked, final Function0 onNotNowClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(showDialog, "showDialog");
        Intrinsics.checkNotNullParameter(onAddClicked, "onAddClicked");
        Intrinsics.checkNotNullParameter(onNotNowClicked, "onNotNowClicked");
        Composer composerK = composer.k(-2079747683);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(showDialog) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onAddClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onNotNowClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2079747683, i4, -1, "cz.mobilesoft.coreblock.view.compose.AddToStrictModeFollowSchedulesBottomSheet (ComposeDialogs.kt:512)");
            }
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1225135170, true, new Function4() { // from class: cz.mobilesoft.coreblock.view.compose.l5
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ComposeDialogsKt.e0(showDialog, onAddClicked, onNotNowClicked, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54);
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.m5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.h0(showDialog);
                    }
                };
                composerK.w(objG);
            }
            ComposeBottomSheetsKt.f(null, null, false, composableLambdaE, null, (Function0) objG, composerK, 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.n5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.i0(showDialog, onAddClicked, onNotNowClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        b1(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(final MutableState mutableState, final Function0 function0, final Function0 function02, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1225135170, i3, -1, "cz.mobilesoft.coreblock.view.compose.AddToStrictModeFollowSchedulesBottomSheet.<anonymous> (ComposeDialogs.kt:516)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f4 = 24;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null);
            String strC = StringResources_androidKt.c(R.string.Gx, new Object[]{StringResources_androidKt.b(R.string.MB, composer, 0)}, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            androidx.compose.material.TextKt.c(strC, modifierK, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.Fx, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.M, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean Z = composer.Z(mutableState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.e6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.f0(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.kl, composer, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, null, 31, null);
            boolean Z2 = composer.Z(mutableState) | composer.Z(function02);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.f6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.g0(mutableState, function02);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big2, light, (Function0) objG2, composer, 0, 1);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void e1(final SystemSettingsType systemSettingsType, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-115231464);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(systemSettingsType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-115231464, i4, -1, "cz.mobilesoft.coreblock.view.compose.SystemSettingsItem (ComposeDialogs.kt:480)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(ClickableKt.f(SizeKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(48), 0.0f, 2, null), false, null, null, function0, 7, null), Dp.g(24), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, systemSettingsType.getIconResId(), composerK, 6), "settings_icon_row", null, Color.f25715b.k(), composerK, 3120, 4);
            SpacerKt.a(SizeKt.v(companion, Dp.g(16)), composerK, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(systemSettingsType.getTitleResId(), composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).j(), composerK, 0, 0, 65534);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.e7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.f1(systemSettingsType, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(SystemSettingsType systemSettingsType, Function0 function0, int i3, Composer composer, int i4) {
        e1(systemSettingsType, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    public static final void g1(final Set selectedAvailableSettings, final Function1 onSettingsSelected, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(selectedAvailableSettings, "selectedAvailableSettings");
        Intrinsics.checkNotNullParameter(onSettingsSelected, "onSettingsSelected");
        Composer composerK = composer.k(1126007810);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(selectedAvailableSettings) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSettingsSelected) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1126007810, i4, -1, "cz.mobilesoft.coreblock.view.compose.SystemSettingsNewBottomSheetDialog (ComposeDialogs.kt:428)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objQ = composerK.q(AndroidCompositionLocals_androidKt.g());
            final Activity activity = objQ instanceof Activity ? (Activity) objQ : null;
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(coroutineScope) | composerK.I(context) | composerK.I(selectedAvailableSettings);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1 composeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1 = new ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1(coroutineScope, context, selectedAvailableSettings, mutableState, null);
                composerK.w(composeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1);
                objG3 = composeDialogsKt$SystemSettingsNewBottomSheetDialog$1$1;
            }
            EffectsKt.g(unit, (Function2) objG3, composerK, 6);
            boolean zI2 = composerK.I(activity);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.u6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeDialogsKt.j1(activity, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            EffectsKt.c(unit, (Function1) objG4, composerK, 6);
            ComposeBottomSheetsKt.f(null, null, false, ComposableLambdaKt.e(-1357527709, true, new Function4() { // from class: cz.mobilesoft.coreblock.view.compose.v6
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return ComposeDialogsKt.k1(mutableState, onSettingsSelected, coroutineScope, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, null, composerK, 3072, 55);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.w6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.m1(selectedAvailableSettings, onSettingsSelected, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    private static final List h1(MutableState mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(MutableState mutableState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        d0(mutableState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(MutableState mutableState, List list) {
        mutableState.setValue(list);
    }

    public static final void j0(final Function0 onDismissed, final Function0 onAppAllowed, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onDismissed, "onDismissed");
        Intrinsics.checkNotNullParameter(onAppAllowed, "onAppAllowed");
        Composer composerK = composer.k(1170569723);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onDismissed) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onAppAllowed) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1170569723, i4, -1, "cz.mobilesoft.coreblock.view.compose.AllowAppBottomSheet (ComposeDialogs.kt:648)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), Color.r(Color.f25715b.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.o5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.k0(onDismissed);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF = ClickableKt.f(modifierD, false, null, null, (Function0) objG, 7, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            SurfaceKt.a(BoxScopeInstance.f6642a.f(companion, companion2.b()), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, 0)), ComposeColorsKt.j(composerK, 0).l(), 0L, null, 0.0f, ComposableLambdaKt.e(1133251449, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.p5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.l0(onAppAllowed, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 1572864, 56);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.q5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.n0(onDismissed, onAppAllowed, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult j1(Activity activity, DisposableEffectScope DisposableEffect) {
        Window window;
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setType(2038);
        }
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$lambda$4$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(MutableState mutableState, final Function1 function1, final CoroutineScope coroutineScope, ColumnScope AppBottomSheet, SheetState sheetState, Composer composer, int i3) {
        int i4;
        final SystemSettingsType systemSettingsType;
        int i5;
        final SheetState state = sheetState;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(state, "state");
        int i6 = 32;
        int i7 = (i3 & 48) == 0 ? i3 | (composer.Z(state) ? 32 : 16) : i3;
        if (composer.r((i7 & 145) != 144, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1357527709, i7, -1, "cz.mobilesoft.coreblock.view.compose.SystemSettingsNewBottomSheetDialog.<anonymous> (ComposeDialogs.kt:449)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.f95837q2, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).h(), composer, 0, 0, 65534);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            List<Pair> listH1 = h1(mutableState);
            if (listH1 == null) {
                composer.a0(127033085);
            } else {
                composer.a0(127033086);
                for (Pair pair : listH1) {
                    SystemSettingsType systemSettingsType2 = (SystemSettingsType) pair.a();
                    final Intent intent = (Intent) pair.b();
                    boolean zE = composer.e(systemSettingsType2.ordinal()) | composer.Z(function1) | composer.I(intent) | composer.I(coroutineScope) | ((i7 & 112) == i6);
                    Object objG = composer.G();
                    if (zE || objG == Composer.f23746a.a()) {
                        i4 = i7;
                        systemSettingsType = systemSettingsType2;
                        i5 = i6;
                        Object obj = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.d7
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return ComposeDialogsKt.l1(systemSettingsType, function1, intent, coroutineScope, state);
                            }
                        };
                        composer.w(obj);
                        objG = obj;
                    } else {
                        i4 = i7;
                        systemSettingsType = systemSettingsType2;
                        i5 = i6;
                    }
                    e1(systemSettingsType, (Function0) objG, composer, 0);
                    state = sheetState;
                    i7 = i4;
                    i6 = i5;
                }
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
    public static final Unit l0(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1133251449, i3, -1, "cz.mobilesoft.coreblock.view.compose.AllowAppBottomSheet.<anonymous>.<anonymous> (ComposeDialogs.kt:663)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion2);
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
            float f3 = 32;
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f3)), composer, 6);
            IconCircleBackgroundKt.c(null, Dp.g(40), 0.0f, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.U0, composer, 6), ComposeColorsKt.j(composer, 0).q0(), ComposeColorsKt.j(composer, 0).C(), null, composer, 48, 69);
            float f4 = 16;
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f4)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.tF, composer, 0);
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f5 = 48;
            androidx.compose.material.TextKt.c(strB, PaddingKt.k(companion2, Dp.g(f5), 0.0f, 2, null), jQ0, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f4)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.sF, composer, 0), PaddingKt.k(companion2, Dp.g(f4), 0.0f, 2, null), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f3)), composer, 6);
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f5), 0.0f, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
            String strB2 = StringResources_androidKt.b(R.string.f95835q0, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.x5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.m0(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB2, false, false, null, (Function0) objG, composer, 0, 29);
            composer.y();
            SpacerKt.a(SizeKt.v(companion2, Dp.g(f3)), composer, 6);
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
    public static final Unit l1(SystemSettingsType systemSettingsType, Function1 function1, Intent intent, CoroutineScope coroutineScope, SheetState sheetState) {
        AnswersHelper.f128199a.x0(systemSettingsType);
        function1.invoke(intent);
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new ComposeDialogsKt$SystemSettingsNewBottomSheetDialog$3$1$1$1$1$1(sheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Set set, Function1 function1, int i3, Composer composer, int i4) {
        g1(set, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        j0(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:153:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void n1(final kotlin.jvm.functions.Function3 r28, androidx.compose.ui.Modifier r29, androidx.compose.material.ModalBottomSheetState r30, androidx.compose.ui.graphics.Shape r31, float r32, long r33, long r35, long r37, final kotlin.jvm.functions.Function2 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.n1(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.ModalBottomSheetState, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void o0(final androidx.compose.runtime.MutableState r34, java.lang.String r35, java.lang.String r36, kotlin.jvm.functions.Function2 r37, java.lang.String r38, long r39, boolean r41, final kotlin.jvm.functions.Function0 r42, java.lang.String r43, long r44, kotlin.jvm.functions.Function0 r46, androidx.compose.runtime.Composer r47, final int r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 883
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.o0(androidx.compose.runtime.MutableState, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, java.lang.String, long, boolean, kotlin.jvm.functions.Function0, java.lang.String, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(Function3 function3, Modifier modifier, ModalBottomSheetState modalBottomSheetState, Shape shape, float f3, long j3, long j4, long j5, Function2 function2, int i3, int i4, Composer composer, int i5) {
        n1(function3, modifier, modalBottomSheetState, shape, f3, j3, j4, j5, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function2 function2, String str, Composer composer, int i3) {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(929170156, i3, -1, "cz.mobilesoft.coreblock.view.compose.AppBlockAlertDialog.<anonymous> (ComposeDialogs.kt:221)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (function2 != null) {
                composer2.a0(-797053467);
                SpacerKt.a(SizeKt.i(companion, Dp.g(16)), composer2, 6);
                function2.invoke(composer2, 0);
                composer2.U();
            } else {
                if (str != null) {
                    composer2.a0(-796883401);
                    androidx.compose.material.TextKt.c(str, null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 0, 0, 65530);
                    composer2 = composer;
                } else {
                    composer2.a0(-805377184);
                }
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p1(kotlin.jvm.functions.Function0 r18, kotlin.jvm.functions.Function0 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.p1(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(String str, long j3, final MutableState mutableState, final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2057931571, i3, -1, "cz.mobilesoft.coreblock.view.compose.AppBlockAlertDialog.<anonymous>.<anonymous> (ComposeDialogs.kt:251)");
            }
            boolean Z = composer.Z(mutableState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.a7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.r0(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            E0(null, str, j3, false, (Function0) objG, composer, 0, 9);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(MutableState mutableState, Function0 function0) {
        if (mutableState != null) {
            mutableState.setValue(Boolean.FALSE);
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-645064464, i3, -1, "cz.mobilesoft.coreblock.view.compose.AppBlockAlertDialog.<anonymous>.<anonymous> (ComposeDialogs.kt:261)");
            }
            androidx.compose.material.TextKt.c(str, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(final Function0 function0, final Function0 function02, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(451283403, i3, -1, "cz.mobilesoft.coreblock.view.compose.WeeklyInsightsAvailableDialog.<anonymous> (ComposeDialogs.kt:796)");
            }
            SurfaceKt.a(null, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0)), ComposeColorsKt.j(composer, 0).l0(), 0L, null, 0.0f, ComposableLambdaKt.e(1871322383, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.k5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeDialogsKt.t1(function0, function02, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 57);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(MutableState mutableState, Function0 function0) {
        if (mutableState != null) {
            mutableState.setValue(Boolean.FALSE);
        }
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(final Function0 function0, final Function0 function02, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1871322383, i3, -1, "cz.mobilesoft.coreblock.view.compose.WeeklyInsightsAvailableDialog.<anonymous>.<anonymous> (ComposeDialogs.kt:800)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion2);
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
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
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
            Modifier modifierF3 = BoxScopeInstance.f6642a.f(companion2, companion.f());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            long jQ = ComposeColorsKt.j(composer, 0).q();
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.v5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.u1(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierF3, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG, composer, 0, 188);
            composer.y();
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion2, Dp.g(f3));
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion.g(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            androidx.compose.foundation.ImageKt.a(PainterResources_androidKt.c(R.drawable.j8, composer, 0), null, null, null, null, 0.0f, null, composer, 48, 124);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(6)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.MG, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextStyle textStyleG = materialTheme.c(composer, i4).g();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            androidx.compose.material.TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleG, composer, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.LG, composer, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).a(), composer, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Pm, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 11, null);
            boolean Z2 = composer.Z(function02);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.w5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.v1(function02);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG2, composer, 0, 1);
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
    public static final Unit u0(String str, long j3, boolean z2, final MutableState mutableState, final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1137109076, i3, -1, "cz.mobilesoft.coreblock.view.compose.AppBlockAlertDialog.<anonymous> (ComposeDialogs.kt:240)");
            }
            boolean Z = composer.Z(mutableState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.t6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposeDialogsKt.v0(mutableState, function0);
                    }
                };
                composer.w(objG);
            }
            E0(null, str, j3, z2, (Function0) objG, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(MutableState mutableState, Function0 function0) {
        if (mutableState != null) {
            mutableState.setValue(Boolean.FALSE);
        }
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(MutableState mutableState, String str, String str2, Function2 function2, String str3, long j3, boolean z2, Function0 function0, String str4, long j4, Function0 function02, int i3, int i4, int i5, Composer composer, int i6) {
        o0(mutableState, str, str2, function2, str3, j3, z2, function0, str4, j4, function02, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        p1(function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0116  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void x0(final androidx.compose.runtime.MutableState r25, final java.lang.String r26, java.lang.String r27, kotlin.jvm.functions.Function2 r28, java.lang.String r29, long r30, boolean r32, final kotlin.jvm.functions.Function0 r33, java.lang.String r34, long r35, kotlin.jvm.functions.Function0 r37, androidx.compose.runtime.Composer r38, final int r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 611
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.x0(androidx.compose.runtime.MutableState, java.lang.String, java.lang.String, kotlin.jvm.functions.Function2, java.lang.String, long, boolean, kotlin.jvm.functions.Function0, java.lang.String, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(MutableState mutableState, String str, String str2, Function2 function2, String str3, long j3, boolean z2, Function0 function0, String str4, long j4, Function0 function02, int i3, int i4, int i5, Composer composer, int i6) {
        x0(mutableState, str, str2, function2, str3, j3, z2, function0, str4, j4, function02, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void z0(final androidx.compose.runtime.MutableState r22, androidx.compose.ui.Modifier r23, androidx.compose.ui.window.DialogProperties r24, kotlin.jvm.functions.Function0 r25, final kotlin.jvm.functions.Function3 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt.z0(androidx.compose.runtime.MutableState, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }
}
