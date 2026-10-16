package cz.mobilesoft.coreblock.scene.dashboard.card;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.QuestionnaireConfig;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ServerImageKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class AnnouncementCardKt {
    /* JADX WARN: Removed duplicated region for block: B:33:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(androidx.compose.ui.Modifier r21, final cz.mobilesoft.coreblock.dto.QuestionnaireConfig r22, kotlin.jvm.functions.Function0 r23, kotlin.jvm.functions.Function0 r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.card.AnnouncementCardKt.e(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.dto.QuestionnaireConfig, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function0 function0, QuestionnaireConfig questionnaireConfig, Function0 function02, Composer composer, int i3) throws XmlPullParserException, IOException {
        char c3;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(924333726, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.card.AnnouncementCard.<anonymous> (AnnouncementCard.kt:48)");
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
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion4, R.drawable.C1, composer, 6);
            long jS = ComposeColorsKt.j(composer, 0).s();
            String strB = StringResources_androidKt.b(R.string.N7, composer, 0);
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.o());
            float f3 = 6;
            ComposeButtonsKt.q0(PaddingKt.m(modifierF2, Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 12, null), imageVectorB, null, false, 0.0f, 0.0f, jS, strB, function0, composer, 0, 60);
            Composer composer2 = composer;
            float f4 = 16;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(f4)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strD = questionnaireConfig != null ? questionnaireConfig.d() : null;
            if (strD == null) {
                composer2.a0(-681233018);
                strD = StringResources_androidKt.c(R.string.f95832p1, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer2, 0)}, composer2, 0);
                composer2.U();
            } else {
                composer2.a0(-681234692);
                composer2.U();
            }
            String str = strD;
            String strA = questionnaireConfig != null ? questionnaireConfig.a() : null;
            if (strA == null) {
                composer2.a0(-681226821);
                strA = StringResources_androidKt.b(R.string.BH, composer2, 0);
                composer2.U();
            } else {
                composer2.a0(-681228681);
                composer2.U();
            }
            String str2 = strA;
            String strB2 = StringResources_androidKt.b(questionnaireConfig != null ? R.string.Ci : R.string.Gv, composer2, 0);
            if (questionnaireConfig != null) {
                composer2.a0(357082016);
                if (questionnaireConfig.c() != null) {
                    composer2.a0(357142962);
                    ServerImageKt.c(questionnaireConfig.c(), StringResources_androidKt.b(R.string.Yf, composer2, 0), PaddingKt.m(SizeKt.g(SizeKt.C(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(300), 1, null), 0.8f), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), null, null, composer, 0, 24);
                    composer2 = composer;
                } else {
                    composer2.a0(354231008);
                }
                composer2.U();
                composer2.U();
                c3 = '\b';
            } else {
                composer2.a0(357718198);
                c3 = '\b';
                ImageKt.b(VectorResources_androidKt.b(companion4, R.drawable.i8, composer2, 6), StringResources_androidKt.b(R.string.Yf, composer2, 0), PaddingKt.m(SizeKt.C(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(300), 1, null), 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), null, null, 0.0f, null, composer, 0, 120);
                composer2 = composer;
                composer2.U();
            }
            TextStyle textStyleI = ComposeTypographyKt.g(composer2, 0).i();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            float f5 = 24;
            TextKt.c(str, PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), Dp.g(f5), Dp.g(f4), Dp.g(f5), 0.0f, 8, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleI, composer, 0, 0, 65020);
            TextKt.c(str2, columnScopeInstance.c(PaddingKt.m(companion, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), companion2.g()), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65020);
            ComposeButtonsKt.i0(columnScopeInstance.c(PaddingKt.m(companion, 0.0f, Dp.g(f5), 0.0f, Dp.g(8), 5, null), companion2.g()), new ButtonType.SmallRound(null, null, strB2, null, false, 27, null), new ButtonColor.Accent(false, null, false, null, 11, null), function02, composer, 0, 0);
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
    public static final Unit i(Modifier modifier, QuestionnaireConfig questionnaireConfig, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        e(modifier, questionnaireConfig, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
