package cz.mobilesoft.coreblock.scene.streaks.banner;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$StreakBannerWeekRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StreakBannerWeekRowKt f120596a = new ComposableSingletons$StreakBannerWeekRowKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f120597b = ComposableLambdaKt.c(-631275983, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.banner.a
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StreakBannerWeekRowKt.b((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-631275983, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.banner.ComposableSingletons$StreakBannerWeekRowKt.lambda$-631275983.<anonymous> (StreakBannerWeekRow.kt:233)");
            }
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(Modifier.b8, ComposeColorsKt.j(composer, 0).X(), null, 2, null), Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(24)), Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            StreakWeekDayStatus streakWeekDayStatus = StreakWeekDayStatus.Inactive;
            StreakWeekDayStatus streakWeekDayStatus2 = StreakWeekDayStatus.Obtained;
            StreakWeekDayStatus streakWeekDayStatus3 = StreakWeekDayStatus.Rest;
            StreakWeekDayStatus streakWeekDayStatus4 = StreakWeekDayStatus.Future;
            StreakBannerWeekRowKt.o(CollectionsKt.listOf((Object[]) new StreakWeekDayStatus[]{streakWeekDayStatus, streakWeekDayStatus2, streakWeekDayStatus2, streakWeekDayStatus3, streakWeekDayStatus2, streakWeekDayStatus4, streakWeekDayStatus4}), null, false, composer, 390, 2);
            ArrayList arrayList = new ArrayList(7);
            for (int i4 = 0; i4 < 7; i4++) {
                arrayList.add(StreakWeekDayStatus.Obtained);
            }
            StreakBannerWeekRowKt.o(arrayList, null, false, composer, 384, 2);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
