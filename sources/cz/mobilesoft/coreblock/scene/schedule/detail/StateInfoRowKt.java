package cz.mobilesoft.coreblock.scene.schedule.detail;

import android.content.Context;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.scene.dashboard.card.PermissionsCardKt;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.PermissionRequestReason;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
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
public final class StateInfoRowKt {
    public static final void A(final String lockMessage, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(lockMessage, "lockMessage");
        Composer composerK = composer.k(-1774699731);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(lockMessage) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1774699731, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.StrictModeLockStateRow (StateInfoRow.kt:137)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierH = SizeKt.h(PaddingKt.k(PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 1, null), 0.0f, 1, null);
            int i5 = R.dimen.f95480n;
            Modifier modifierB = BackgroundKt.b(ClipKt.a(modifierH, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composerK, 0))), Brush.Companion.b(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4286454783L)), Color.n(ColorKt.d(4285872070L)), Color.n(ColorKt.d(4284820377L))}), 0.0f, 0.0f, 0, 14, null), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i5, composerK, 0)), 0.0f, 4, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float f4 = 64;
            Modifier modifierM = PaddingKt.m(SizeKt.k(companion, Dp.g(f4), 0.0f, 2, null), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Alignment alignmentE = companion2.e();
            Modifier modifierB2 = AspectRatioKt.b(SizeKt.v(companion, Dp.g(f4)), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(alignmentE, false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB2);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.Za, composerK, 6), null, SizeKt.v(companion, Dp.g(24)), null, null, 0.0f, null, composerK, 432, 120);
            StrictModeBallKt.m(SizeKt.f(companion, 0.0f, 1, null), ColorKt.d(4289160447L), Color.r(ComposeColorsKt.j(composerK, 0).j0(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), false, composerK, 3126, 0);
            composerK.y();
            composer2 = composerK;
            TextKt.c(lockMessage, PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null), ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, (i4 & 14) | 48, 0, 65528);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.B(lockMessage, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(String str, int i3, Composer composer, int i4) {
        A(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void l(final ImmutableList immutableList, final boolean z2, final Function1 function1, final boolean z3, Composer composer, final int i3) {
        int i4;
        final boolean z4;
        final Function1 function12;
        final boolean z5;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(342478880);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z3) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(342478880, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ExceededLimitsRow (StateInfoRow.kt:226)");
            }
            if (immutableList.isEmpty()) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return StateInfoRowKt.m(immutableList, z2, function1, z3, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            z4 = z2;
            function12 = function1;
            z5 = z3;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z6 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z6 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StateInfoRowKt.n(function12, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(managedActivityResultLauncherA) | composerK.I(context) | ((i4 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StateInfoRowKt.o(managedActivityResultLauncherA, context, z5);
                    }
                };
                composerK.w(objG2);
            }
            final Function0 function0 = (Function0) objG2;
            CardType.Dashed dashed = CardType.Dashed.f130352f;
            Modifier.Companion companion = Modifier.b8;
            int i5 = R.dimen.f95467a;
            composer2 = composerK;
            ComposeCardsKt.m(SizeKt.h(PaddingKt.m(companion, PrimitiveResources_androidKt.a(i5, composerK, 0), 0.0f, PrimitiveResources_androidKt.a(i5, composerK, 0), Dp.g(16), 2, null), 0.0f, 1, null), dashed, function0, ComposableLambdaKt.e(272465883, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.p(immutableList, z4, context, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composer2, 3120, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            z4 = z2;
            function12 = function1;
            z5 = z3;
            composer2 = composerK;
            composer2.Q();
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final boolean z7 = z4;
            final Function1 function13 = function12;
            final boolean z8 = z5;
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.q(immutableList, z7, function13, z8, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(ImmutableList immutableList, boolean z2, Function1 function1, boolean z3, int i3, Composer composer, int i4) {
        l(immutableList, z2, function1, z3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            function1.invoke(ScheduleViewEvent.OnScheduleChangedInDB.f114578a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ManagedActivityResultLauncher managedActivityResultLauncher, Context context, boolean z2) {
        managedActivityResultLauncher.b(Paywall.c(Paywall.f113165a, context, PaywallTarget.Generic.INSTANCE, z2 ? "schedule_create" : "schedule_edit", "schedule_info_box", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(ImmutableList immutableList, boolean z2, Context context, Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        String strC;
        long jK;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(272465883, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ExceededLimitsRow.<anonymous> (StateInfoRow.kt:254)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
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
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Modifier modifierH = SizeKt.h(PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(12), 0.0f, 10, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalO, companion2.l(), composer, 6);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            TextKt.c(StringResources_androidKt.b(R.string.HH, composer, 0), RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65532);
            IconCircleBackgroundKt.c(null, Dp.g(32), Dp.g(6), VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.p4, composer, 6), ComposeColorsKt.j(composer, 0).Y(), ComposeColorsKt.j(composer, 0).l0(), null, composer, 432, 65);
            composer.y();
            TextKt.c(StringResources_androidKt.b(R.string.qp, composer, 0), PaddingKt.l(companion, Dp.g(f3), Dp.g(8), Dp.g(f3), Dp.g(f3)), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65528);
            Composer composer2 = composer;
            composer2.a0(1640954058);
            Iterator<E> it = immutableList.iterator();
            while (it.hasNext()) {
                ExceededLimit exceededLimit = (ExceededLimit) it.next();
                String readableLimit = (z2 && (exceededLimit.a() == Limit.APP_LIMIT || exceededLimit.a() == Limit.WEBSITE_LIMIT)) ? Limit.APP_WEB_LIMIT_QUICK_BLOCK.getReadableLimit(context) : exceededLimit.a().getReadableLimit(context);
                Arrangement.HorizontalOrVertical horizontalOrVerticalO2 = Arrangement.f6574a.o(Dp.g(4));
                Alignment.Vertical verticalI = Alignment.f25072a.i();
                Modifier.Companion companion4 = Modifier.b8;
                Modifier modifierJ = PaddingKt.j(companion4, Dp.g(f3), Dp.g(2));
                MeasurePolicy measurePolicyB2 = RowKt.b(horizontalOrVerticalO2, verticalI, composer2, 54);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierJ);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A3 = companion5.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyB2, companion5.e());
                Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                Function2 function2B3 = companion5.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion5.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                String strB = StringResources_androidKt.b(exceededLimit.a().getTitleResId(), composer2, 0);
                if (readableLimit == null) {
                    composer2.a0(-486590960);
                    composer2.U();
                    strC = null;
                } else {
                    composer2.a0(-486590959);
                    strC = StringResources_androidKt.c(R.string.Yi, new Object[]{strB, readableLimit}, composer2, 0);
                    composer2.U();
                }
                String str = strC == null ? strB : strC;
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.R6, composer2, 6);
                if (exceededLimit.b()) {
                    composer2.a0(-431328412);
                    jK = ComposeColorsKt.j(composer2, 0).s();
                } else {
                    composer2.a0(-431327585);
                    jK = ComposeColorsKt.j(composer2, 0).k();
                }
                composer2.U();
                IconKt.d(imageVectorB, null, SizeKt.v(companion4, Dp.g(f3)), jK, composer2, 432, 0);
                TextStyle textStyleB = ComposeTypographyKt.g(composer2, 0).b();
                if (exceededLimit.b()) {
                    textStyleB = TextStyle.e(textStyleB, 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, TextDecoration.f29625b.b(), null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16773119, null);
                }
                TextKt.c(str, null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleB, composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
            }
            composer2.U();
            Arrangement.HorizontalOrVertical horizontalOrVerticalO3 = Arrangement.f6574a.o(Dp.g(f3));
            Alignment.Vertical verticalI2 = Alignment.f25072a.i();
            Modifier.Companion companion6 = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion6, Dp.g(f3));
            MeasurePolicy measurePolicyB3 = RowKt.b(horizontalOrVerticalO3, verticalI2, composer2, 54);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierI);
            ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
            Function0 function0A4 = companion7.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyB3, companion7.e());
            Updater.e(composerA4, compositionLocalMapU4, companion7.g());
            Function2 function2B4 = companion7.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion7.f());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
            r(rowScopeInstance2, composer2, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Wm, composer2, 0), PaddingKt.m(companion6, 0.0f, 0.0f, 0.0f, Dp.g(3), 7, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 48, 0, 65528);
            r(rowScopeInstance2, composer, 6);
            composer.y();
            ComposeButtonsKt.i0(PaddingKt.k(companion6, Dp.g(f3), 0.0f, 2, null), new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.bC, composer, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function0, composer, 6, 0);
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
    public static final Unit q(ImmutableList immutableList, boolean z2, Function1 function1, boolean z3, int i3, Composer composer, int i4) {
        l(immutableList, z2, function1, z3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void r(RowScope rowScope, Composer composer, final int i3) {
        int i4;
        final RowScope rowScope2;
        Composer composerK = composer.k(282980570);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(282980570, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.OrSeparatorLine (StateInfoRow.kt:356)");
            }
            rowScope2 = rowScope;
            BoxKt.a(BackgroundKt.d(SizeKt.i(RowScope.c(rowScope2, Modifier.b8, 1.0f, false, 2, null), Dp.g(1)), ComposeColorsKt.j(composerK, 0).s(), null, 2, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            rowScope2 = rowScope;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.s(rowScope2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(RowScope rowScope, int i3, Composer composer, int i4) {
        r(rowScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void t(ImmutableList immutableList, boolean z2, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final ImmutableList immutableList2;
        final boolean z3;
        Composer composerK = composer.k(881769095);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(881769095, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.PermissionsRow (StateInfoRow.kt:197)");
            }
            float fG = (z2 || !immutableList.isEmpty()) ? Dp.g(16) : Dp.g(0);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z4 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StateInfoRowKt.u(function1, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            Modifier modifierJ = PaddingKt.j(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), fG);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            immutableList2 = immutableList;
            z3 = z2;
            PermissionsCardKt.d(StringResources_androidKt.b(R.string.W8, composerK, 0), immutableList2, z3, managedActivityResultLauncherA, 0, null, composerK, ((i4 << 3) & 1008) | (ManagedActivityResultLauncher.f461c << 9), 48);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            immutableList2 = immutableList;
            z3 = z2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.v(immutableList2, z3, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new ScheduleViewEvent.OnMissingPermissionsChanged(PermissionRequestReason.General, it.d() == -1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(ImmutableList immutableList, boolean z2, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        t(immutableList, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void w(final String lockMessage, final ImageVector icon, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(lockMessage, "lockMessage");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Composer composerK = composer.k(129211252);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(lockMessage) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(icon) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(129211252, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleLockStateRow (StateInfoRow.kt:369)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(PaddingKt.k(PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null), 0.0f, 1, null);
            int i6 = R.dimen.f95480n;
            Modifier modifierC = BackgroundKt.c(ClipKt.a(modifierH, RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i6, composerK, 0))), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(i6, composerK, 0)));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierM = PaddingKt.m(SizeKt.i(companion, Dp.g(64)), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Alignment alignmentE = companion2.e();
            Modifier modifierB = AspectRatioKt.b(companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(alignmentE, false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            IconKt.d(icon, null, SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composerK, 0).p(), composerK, ((i5 >> 3) & 14) | 432, 0);
            StrictModeBallKt.m(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).K(), Color.r(ComposeColorsKt.j(composerK, 0).l0(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null), false, composerK, 3078, 0);
            composerK.y();
            TextKt.c(lockMessage, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, i5 & 14, 0, 65530);
            composerK = composerK;
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.x(lockMessage, icon, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(String str, ImageVector imageVector, int i3, Composer composer, int i4) {
        w(str, imageVector, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void y(final ScheduleViewState.DetailViewState viewState, final ScheduleDescriptor scheduleDescriptor, Function1 onEvent, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(scheduleDescriptor, "scheduleDescriptor");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-288310139);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scheduleDescriptor) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-288310139, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.StateInfoRow (StateInfoRow.kt:103)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImmutableList immutableListD = viewState.l().d();
            boolean zC = viewState.l().c();
            if (scheduleDescriptor instanceof ScheduleDescriptor.NewSchedule) {
                composerK.a0(620874247);
            } else {
                composerK.a0(625791281);
                if (viewState.F()) {
                    composerK.a0(625827954);
                    w(viewState.p(), VectorResources_androidKt.b(ImageVector.f26323k, viewState.q(), composerK, 6), composerK, 0);
                } else {
                    composerK.a0(620874247);
                }
                composerK.U();
                if (viewState.C()) {
                    composerK.a0(626119633);
                    A(StringResources_androidKt.b(R.string.Ut, composerK, 0), composerK, 0);
                } else {
                    composerK.a0(620874247);
                }
                composerK.U();
            }
            composerK.U();
            int i5 = i4 & 896;
            t(immutableListD, zC, onEvent, composerK, i5);
            function1 = onEvent;
            l(viewState.g(), viewState.E(), function1, viewState.D(), composerK, i5);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onEvent;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StateInfoRowKt.z(viewState, scheduleDescriptor, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(ScheduleViewState.DetailViewState detailViewState, ScheduleDescriptor scheduleDescriptor, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        y(detailViewState, scheduleDescriptor, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
