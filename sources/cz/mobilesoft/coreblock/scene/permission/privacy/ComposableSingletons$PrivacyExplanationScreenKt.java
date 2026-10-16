package cz.mobilesoft.coreblock.scene.permission.privacy;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$PrivacyExplanationScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$PrivacyExplanationScreenKt f112291a = new ComposableSingletons$PrivacyExplanationScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f112292b = ComposableLambdaKt.c(-1576337326, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyExplanationScreenKt.r((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f112293c = ComposableLambdaKt.c(-551303751, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyExplanationScreenKt.v((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function2 f112294d = ComposableLambdaKt.c(1195971018, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$PrivacyExplanationScreenKt.n((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Function3 f112295e = ComposableLambdaKt.c(-252059837, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.d
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyExplanationScreenKt.u((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Function3 f112296f = ComposableLambdaKt.c(416402812, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$PrivacyExplanationScreenKt.o((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1195971018, i3, -1, "cz.mobilesoft.coreblock.scene.permission.privacy.ComposableSingletons$PrivacyExplanationScreenKt.lambda$1195971018.<anonymous> (PrivacyExplanationScreen.kt:124)");
            }
            ComposeCommonsKt.n(StringResources_androidKt.b(R.string.zq, composer, 0), null, null, composer, 0, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(PaddingValues paddingValues, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        int i4 = (i3 & 6) == 0 ? i3 | (composer.Z(paddingValues) ? 4 : 2) : i3;
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(416402812, i4, -1, "cz.mobilesoft.coreblock.scene.permission.privacy.ComposableSingletons$PrivacyExplanationScreenKt.lambda$416402812.<anonymous> (PrivacyExplanationScreen.kt:184)");
            }
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Modifier modifierJ = PaddingKt.j(PaddingKt.h(ScrollKt.g(SizeKt.f(Modifier.b8, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            composer.a0(797966325);
            for (PrivacyItem privacyItem : PrivacyItem.values()) {
                PrivacyExplanationScreenKt.E(privacyItem, composer, 0);
            }
            composer.U();
            String strB = StringResources_androidKt.b(R.string.Ci, composer, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            long jM = ComposeColorsKt.j(composer, 0).M();
            Modifier.Companion companion2 = Modifier.b8;
            TextKt.c(strB, PaddingKt.m(companion2, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), jM, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleH, composer, 48, 0, 65528);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.BC, composer, 0), null, false, 27, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            boolean zI = composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PrivacyExplanationScreenKt.p(context);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(modifierH, smallRound, surface, (Function0) objG, composer, 6, 0);
            ButtonType.SmallRound smallRound2 = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.tq, composer, 0), null, false, 27, null);
            ButtonColor.Surface surface2 = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            Modifier modifierH2 = SizeKt.h(companion2, 0.0f, 1, null);
            boolean zI2 = composer.I(context);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PrivacyExplanationScreenKt.q(context);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(modifierH2, smallRound2, surface2, (Function0) objG2, composer, 6, 0);
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
    public static final Unit p(Context context) {
        AnswersHelper.f128199a.f4();
        ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
        Uri uri = Uri.parse(PrefManager.f126839a.t0());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        externalLinksHelper.c(context, uri);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Context context) {
        AnswersHelper.f128199a.d4();
        ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
        Uri uri = Uri.parse(PrefManager.f126839a.Q0());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        externalLinksHelper.c(context, uri);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1576337326, i3, -1, "cz.mobilesoft.coreblock.scene.permission.privacy.ComposableSingletons$PrivacyExplanationScreenKt.lambda$-1576337326.<anonymous> (PrivacyExplanationScreen.kt:55)");
            }
            Object objG = composer.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PrivacyExplanationScreenKt.s();
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PrivacyExplanationScreenKt.t();
                    }
                };
                composer.w(objG2);
            }
            PrivacyExplanationScreenKt.B(function0, (Function0) objG2, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-252059837, i4, -1, "cz.mobilesoft.coreblock.scene.permission.privacy.ComposableSingletons$PrivacyExplanationScreenKt.lambda$-252059837.<anonymous> (PrivacyExplanationScreen.kt:129)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(PaddingKt.h(ScrollKt.g(SizeKt.f(companion, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), paddingValues), Dp.g(PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0) + Dp.g(8)), 0.0f, 2, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            TextKt.c(StringResources_androidKt.b(R.string.yq, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65534);
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.g8, composer, 6), null, ColumnScope.b(columnScopeInstance, PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(16), 1, null), 1.0f, false, 2, null), null, null, 0.0f, null, composer, 48, 120);
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
    public static final Unit v(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-551303751, i3, -1, "cz.mobilesoft.coreblock.scene.permission.privacy.ComposableSingletons$PrivacyExplanationScreenKt.lambda$-551303751.<anonymous> (PrivacyExplanationScreen.kt:66)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.privacy.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$PrivacyExplanationScreenKt.w();
                    }
                };
                composer.w(objG);
            }
            PrivacyExplanationScreenKt.o((Function0) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w() {
        return Unit.f139807a;
    }

    public final Function3 k() {
        return f112295e;
    }

    public final Function2 l() {
        return f112294d;
    }

    public final Function3 m() {
        return f112296f;
    }
}
