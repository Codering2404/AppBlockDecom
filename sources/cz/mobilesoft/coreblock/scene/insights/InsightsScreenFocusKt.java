package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
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
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.statistics.model.RecordDuration;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsScreenFocusKt {
    public static final void b(LazyListScope lazyListScope, final InsightsViewState viewState) {
        Intrinsics.checkNotNullParameter(lazyListScope, "<this>");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        LazyListScope.c(lazyListScope, null, null, ComposableSingletons$InsightsScreenFocusKt.f102579a.b(), 3, null);
        LazyListScope.c(lazyListScope, null, null, ComposableLambdaKt.c(-439652782, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.v4
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return InsightsScreenFocusKt.c(viewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(InsightsViewState insightsViewState, LazyItemScope item, Composer composer, int i3) {
        Context context;
        Long l3;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-439652782, i3, -1, "cz.mobilesoft.coreblock.scene.insights.focus.<anonymous> (InsightsScreenFocus.kt:45)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(Dp.g(f3)), Alignment.f25072a.l(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Context context2 = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            Long lM = insightsViewState.M();
            RecordDuration recordDurationN = insightsViewState.N();
            if (lM == null) {
                composer.a0(-25734910);
                composer.U();
                context = context2;
                l3 = null;
            } else {
                composer.a0(-25734909);
                context = context2;
                l3 = null;
                InsightsScreenComponentsKt.l1(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), StringResources_androidKt.b(R.string.Cj, composer, 0), StringHelper.f(context2, lM.longValue()), null, StringResources_androidKt.b(R.string.VD, composer, 0), R.drawable.A2, composer, 0, 8);
                composer.U();
            }
            Long lValueOf = recordDurationN != null ? Long.valueOf(recordDurationN.c()) : l3;
            if (lValueOf == null) {
                composer.a0(-25270251);
            } else {
                composer.a0(-25270250);
                InsightsScreenComponentsKt.l1(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), StringResources_androidKt.b(R.string.r8, composer, 0), StringHelper.f(context, lValueOf.longValue() * ((long) 1000)), null, StringResources_androidKt.b(R.string.UD, composer, 0), R.drawable.i4, composer, 0, 8);
            }
            composer.U();
            if (lM == null || recordDurationN == null) {
                composer.a0(-24707290);
                SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            } else {
                composer.a0(-27634868);
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
}
