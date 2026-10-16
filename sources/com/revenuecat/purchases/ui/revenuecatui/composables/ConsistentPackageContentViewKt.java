package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConsistentPackageContentViewKt {
    public static final void ConsistentPackageContentView(final PaywallState.Loaded.Legacy state, final Function3<? super TemplateConfiguration.PackageInfo, ? super Composer, ? super Integer, Unit> creator, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Composer composerK = composer.k(-499614075);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(creator) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-499614075, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentView (ConsistentPackageContentView.kt:14)");
            }
            ConsistentPackageContentView(state.getTemplateConfiguration().getPackages().getAll(), (TemplateConfiguration.PackageInfo) state.getSelectedPackage().getValue(), creator, composerK, (i4 << 3) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentViewKt.ConsistentPackageContentView.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ConsistentPackageContentViewKt.ConsistentPackageContentView(state, creator, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    public static final void ConsistentPackageContentView(final List<TemplateConfiguration.PackageInfo> packages, final TemplateConfiguration.PackageInfo selected, final Function3<? super TemplateConfiguration.PackageInfo, ? super Composer, ? super Integer, Unit> creator, Composer composer, final int i3) {
        Intrinsics.checkNotNullParameter(packages, "packages");
        Intrinsics.checkNotNullParameter(selected, "selected");
        Intrinsics.checkNotNullParameter(creator, "creator");
        Composer composerK = composer.k(-1899321464);
        int i4 = (i3 & 6) == 0 ? (composerK.I(packages) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(selected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(creator) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1899321464, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentView (ConsistentPackageContentView.kt:31)");
            }
            Modifier.Companion companion = Modifier.b8;
            ?? r8 = 0;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            composerK.a0(533206241);
            for (TemplateConfiguration.PackageInfo packageInfo : packages) {
                Modifier modifierA = AlphaKt.a(Modifier.b8, 0.0f);
                Alignment.Companion companion3 = Alignment.f25072a;
                Modifier modifierF2 = boxScopeInstance.f(modifierA, companion3.e());
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), r8);
                int iA2 = ComposablesKt.a(composerK, r8);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A2 = companion4.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A2);
                } else {
                    composerK.v();
                }
                Composer composerA2 = Updater.a(composerK);
                Updater.e(composerA2, measurePolicyG2, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion4.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                creator.invoke(packageInfo, composerK, Integer.valueOf((i4 >> 3) & 112));
                composerK.y();
                r8 = 0;
            }
            composerK.U();
            Modifier.Companion companion5 = Modifier.b8;
            Alignment.Companion companion6 = Alignment.f25072a;
            Modifier modifierF4 = boxScopeInstance.f(companion5, companion6.e());
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion6.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
            ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
            Function0 function0A3 = companion7.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG3, companion7.e());
            Updater.e(composerA3, compositionLocalMapU3, companion7.g());
            Function2 function2B3 = companion7.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF5, companion7.f());
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.f6642a;
            creator.invoke(selected, composerK, Integer.valueOf((i4 >> 3) & 126));
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.ConsistentPackageContentViewKt.ConsistentPackageContentView.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ConsistentPackageContentViewKt.ConsistentPackageContentView(packages, selected, creator, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
