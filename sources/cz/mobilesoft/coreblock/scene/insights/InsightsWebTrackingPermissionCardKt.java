package cz.mobilesoft.coreblock.scene.insights;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PermissionAccessibilityReason;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class InsightsWebTrackingPermissionCardKt {
    public static final void d(final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(884309922);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onEvent) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(884309922, i4, -1, "cz.mobilesoft.coreblock.scene.insights.WebTrackingPermissionCard (InsightsWebTrackingPermissionCard.kt:36)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            final ManagedActivityResultLauncher managedActivityResultLauncherX2 = InsightsScreenComponentsKt.X2(onEvent, composerK, i4 & 14);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                PermissionDTO permissionDTO = new PermissionDTO(new Permission.ACCESSIBILITY(PermissionAccessibilityReason.Statistics.f97009a, false, 2, null), false, false, 6, null);
                composerK.w(permissionDTO);
                objG = permissionDTO;
            }
            final PermissionDTO permissionDTO2 = (PermissionDTO) objG;
            boolean zI = composerK.I(managedActivityResultLauncherX2) | composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.y7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsWebTrackingPermissionCardKt.e(managedActivityResultLauncherX2, context, permissionDTO2);
                    }
                };
                composerK.w(objG2);
            }
            final Function0 function0 = (Function0) objG2;
            float f3 = 16;
            float f4 = 8;
            InsightsScreenHabitsListKt.o(null, PaddingKt.d(Dp.g(f3), Dp.g(f4), Dp.g(f3), Dp.g(f4)), PaddingKt.b(Dp.g(f3), Dp.g(12)), ComposableLambdaKt.e(-370567779, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.insights.z7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return InsightsWebTrackingPermissionCardKt.f(function0, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3456, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.a8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsWebTrackingPermissionCardKt.g(onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(ManagedActivityResultLauncher managedActivityResultLauncher, Context context, PermissionDTO permissionDTO) {
        managedActivityResultLauncher.b(PermissionActivity.Companion.b(PermissionActivity.f111772j, context, CollectionsKt.listOf(permissionDTO), true, false, false, null, null, 112, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function0 function0, BoxScope BorderedBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BorderedBox, "$this$BorderedBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-370567779, i3, -1, "cz.mobilesoft.coreblock.scene.insights.WebTrackingPermissionCard.<anonymous> (InsightsWebTrackingPermissionCard.kt:60)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = InteractionSourceKt.a();
                composer.w(objG);
            }
            Modifier modifierD = ClickableKt.d(modifierH, (MutableInteractionSource) objG, null, false, null, null, function0, 28, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T6, composer, 6), null, null, ComposeColorsKt.j(composer, 0).q(), composer, 48, 4);
            float f3 = 12;
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Fh, composer, 0), RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 3, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 3120, 55288);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composer, 6);
            FlatButtonsKt.u(null, Dp.g(40), 0.0f, null, FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, null, Color.n(ComposeColorsKt.j(composer, 0).l0()), 1, null), null, StringResources_androidKt.b(R.string.f95831p0, composer, 0), null, 0L, null, null, false, false, function0, composer, 805306416, 384, 3501);
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
    public static final Unit g(Function1 function1, int i3, Composer composer, int i4) {
        d(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
