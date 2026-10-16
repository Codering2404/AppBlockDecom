package cz.mobilesoft.coreblock.scene.onboarding;

import android.content.Context;
import android.net.Uri;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.privacy.PrivacyItem;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.Iterator;
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
public final class ComposableSingletons$OnboardingDataUsageScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$OnboardingDataUsageScreenKt f110874a = new ComposableSingletons$OnboardingDataUsageScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function3 f110875b = ComposableLambdaKt.c(-1435276330, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.i
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$OnboardingDataUsageScreenKt.e((PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1435276330, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.ComposableSingletons$OnboardingDataUsageScreenKt.lambda$-1435276330.<anonymous> (OnboardingDataUsageScreen.kt:57)");
            }
            float f3 = 16;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f3));
            Modifier modifierJ = PaddingKt.j(PaddingKt.h(ScrollKt.g(SizeKt.f(Modifier.b8, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), paddingValues), Dp.g(PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0) + Dp.g(f3)), Dp.g(f3));
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
            composer.a0(2027475066);
            Iterator<PrivacyItem> it = PrivacyItem.getEntries().iterator();
            while (it.hasNext()) {
                OnboardingDataUsageScreenKt.j(it.next(), composer, 0);
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
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$OnboardingDataUsageScreenKt.f(context);
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
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$OnboardingDataUsageScreenKt.g(context);
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
    public static final Unit f(Context context) {
        AnswersHelper.f128199a.f4();
        ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
        Uri uri = Uri.parse(PrefManager.f126839a.t0());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        externalLinksHelper.c(context, uri);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Context context) {
        AnswersHelper.f128199a.d4();
        ExternalLinksHelper externalLinksHelper = ExternalLinksHelper.f127866a;
        Uri uri = Uri.parse(PrefManager.f126839a.Q0());
        Intrinsics.checkNotNullExpressionValue(uri, "parse(...)");
        externalLinksHelper.c(context, uri);
        return Unit.f139807a;
    }

    public final Function3 d() {
        return f110875b;
    }
}
