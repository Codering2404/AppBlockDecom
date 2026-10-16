package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.DayOfWeek;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$ScheduleCustomizationScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ScheduleCustomizationScreenKt f122669a = new ComposableSingletons$ScheduleCustomizationScreenKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f122670b = ComposableLambdaKt.c(-1350701476, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleCustomizationScreenKt.j((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f122671c = ComposableLambdaKt.c(1682855718, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ScheduleCustomizationScreenKt.g((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Function3 f122672d = ComposableLambdaKt.c(717363651, false, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.e
        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$ScheduleCustomizationScreenKt.i((BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f122673a = EnumEntriesKt.a(DayOfWeek.values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Composer composer, int i3) {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1682855718, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$ScheduleCustomizationScreenKt.lambda$1682855718.<anonymous> (ScheduleCustomizationScreen.kt:60)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
            Modifier modifierI = PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(18));
            int i4 = 6;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, Alignment.f25072a.l(), composer2, 6);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2.a0(428541699);
            for (DayOfWeek dayOfWeek : EntriesMappings.f122673a) {
                final boolean z2 = dayOfWeek.getValue() < i4;
                boolean zB = composer2.b(z2);
                Object objG = composer2.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Boolean.valueOf(ComposableSingletons$ScheduleCustomizationScreenKt.h(z2));
                        }
                    });
                    composer2.w(objG);
                }
                BaseConditionScreenKt.c0((State) objG, dayOfWeek, null, 0L, ComposeColorsKt.j(composer2, 0).i(), ComposeColorsKt.j(composer2, 0).q0(), ComposeColorsKt.j(composer2, 0).O(), composer2, 384, 8);
                composer2 = composer;
                i4 = i4;
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
    public static final Unit i(BoxScope BasePremiumOnboardingScreen, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BasePremiumOnboardingScreen, "$this$BasePremiumOnboardingScreen");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BasePremiumOnboardingScreen) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(717363651, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$ScheduleCustomizationScreenKt.lambda$717363651.<anonymous> (ScheduleCustomizationScreen.kt:41)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.gb, composer, 0), null, BasePremiumOnboardingScreen.f(companion, companion2.b()), null, ContentScale.f27054a.d(), 0.0f, null, composer, 24624, 104);
            float f3 = 16;
            CardKt.a(BasePremiumOnboardingScreen.f(SizeKt.h(PaddingKt.i(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), Dp.g(f3)), 0.0f, 1, null), companion2.e()), RoundedCornerShapeKt.d(Dp.g(f3)), ComposeColorsKt.j(composer, 0).l0(), ComposeColorsKt.j(composer, 0).l0(), null, Dp.g(0), f122671c, composer, 1769472, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1350701476, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.ComposableSingletons$ScheduleCustomizationScreenKt.lambda$-1350701476.<anonymous> (ScheduleCustomizationScreen.kt:29)");
            }
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ComposableSingletons$ScheduleCustomizationScreenKt.k();
                    }
                };
                composer.w(objG);
            }
            ScheduleCustomizationScreenKt.b((Function0) objG, composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    public final Function3 f() {
        return f122672d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(boolean z2) {
        return z2;
    }
}
