package cz.mobilesoft.coreblock.scene.schedule.detail;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOption;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.monetization.AccessPolicyKt;
import cz.mobilesoft.coreblock.util.monetization.Capability;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class ExtraOptionsRowKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116574a;

        static {
            int[] iArr = new int[PremiumFeature.values().length];
            try {
                iArr[PremiumFeature.ADD_NEWLY_INSTALLED_APPS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PremiumFeature.BLOCK_UNSUPPORTED_BROWSERS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PremiumFeature.ADULT_CONTENT_BLOCKING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PremiumFeature.IN_APP_PURCHASES_BLOCKING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f116574a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final cz.mobilesoft.coreblock.enums.PremiumFeature r20, final boolean r21, boolean r22, final boolean r23, final boolean r24, final kotlin.jvm.functions.Function1 r25, final boolean r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsRowKt.k(cz.mobilesoft.coreblock.enums.PremiumFeature, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function1, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean l(boolean z2) {
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(PremiumFeature premiumFeature, Context context, boolean z2) {
        if (premiumFeature == PremiumFeature.ADULT_CONTENT_BLOCKING) {
            AnswersHelper.f128199a.U();
        }
        int i3 = WhenMappings.f116574a[premiumFeature.ordinal()];
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.EXTRA_OPTIONS), z2 ? "schedule_create" : "schedule_edit", i3 != 1 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? "" : "block_in_app_purchases" : "block_18+" : "block_unsupported_browsers" : "add_new_apps", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(PremiumFeature premiumFeature, boolean z2, boolean z3, boolean z4, boolean z5, Function1 function1, boolean z6, int i3, int i4, Composer composer, int i5) {
        k(premiumFeature, z2, z3, z4, z5, function1, z6, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PremiumFeature premiumFeature, boolean z2, boolean z3, Function1 function1, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1480261451, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsCard.<anonymous> (ExtraOptionsRow.kt:204)");
            }
            s(premiumFeature, z2, true, z3, function1, composer, 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(PremiumFeature premiumFeature, boolean z2, boolean z3, Function1 function1, ColumnScope DashedBorderCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(DashedBorderCard, "$this$DashedBorderCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1932617133, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsCard.<anonymous> (ExtraOptionsRow.kt:218)");
            }
            s(premiumFeature, z2, false, z3, function1, composer, 384, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(PremiumFeature premiumFeature, boolean z2, boolean z3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        o(premiumFeature, z2, z3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x041e  */
    /* JADX WARN: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Type inference failed for: r10v10, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(final cz.mobilesoft.coreblock.enums.PremiumFeature r41, final boolean r42, boolean r43, final boolean r44, final kotlin.jvm.functions.Function1 r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instruction units count: 1071
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsRowKt.s(cz.mobilesoft.coreblock.enums.PremiumFeature, boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Function1 function1, boolean z2) {
        function1.invoke(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(PremiumFeature premiumFeature, boolean z2, boolean z3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        s(premiumFeature, z2, z3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void v(final ScheduleViewState.DetailViewState viewState, final boolean z2, final Function1 onEvent, Composer composer, final int i3) {
        final Function1 function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(153610091);
        int i4 = (i3 & 6) == 0 ? (composerK.Z(viewState) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(153610091, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsRow (ExtraOptionsRow.kt:94)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.ge, composerK, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            int i5 = R.dimen.f95467a;
            float f3 = 8;
            int i6 = i4;
            TextKt.c(strB, PaddingKt.k(PaddingKt.k(companion, PrimitiveResources_androidKt.a(i5, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 1, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleG, composerK, 0, 0, 65532);
            composerK = composerK;
            Modifier modifierH2 = SizeKt.h(PaddingKt.k(PaddingKt.k(companion, PrimitiveResources_androidKt.a(i5, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f3), 1, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH2);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            composerK.a0(2132865416);
            ImmutableList immutableListH = viewState.h();
            ArrayList arrayList = new ArrayList();
            for (Object obj : immutableListH) {
                if (z2 ? ((ExtraOption) obj) instanceof ExtraOption.AddNewlyInstalledApps : true) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            int i7 = 0;
            while (i7 < size) {
                int i8 = i7 + 1;
                final ExtraOption extraOption = (ExtraOption) arrayList.get(i7);
                PremiumFeature premiumFeatureA = extraOption.a();
                boolean zA = AccessPolicyKt.a(viewState.m(), Capability.SubscriptionFeatures);
                boolean z3 = !viewState.F();
                boolean zB = extraOption.b();
                boolean zD = viewState.D();
                boolean z4 = viewState.d().b() == Profile.BlockingMode.Allowlist;
                int i9 = i6;
                boolean Z = ((i9 & 896) == 256) | composerK.Z(extraOption);
                Object objG = composerK.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ExtraOptionsRowKt.w(onEvent, extraOption, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composerK.w(objG);
                }
                k(premiumFeatureA, zB, z3, z4, zA, (Function1) objG, zD, composerK, 0, 0);
                i7 = i8;
                i6 = i9;
            }
            function1 = onEvent;
            composerK.U();
            composerK.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ExtraOptionsRowKt.x(viewState, z2, function1, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, ExtraOption extraOption, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnExtraOptionClicked(extraOption));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(ScheduleViewState.DetailViewState detailViewState, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        v(detailViewState, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void o(final cz.mobilesoft.coreblock.enums.PremiumFeature r22, final boolean r23, boolean r24, final boolean r25, final kotlin.jvm.functions.Function1 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ExtraOptionsRowKt.o(cz.mobilesoft.coreblock.enums.PremiumFeature, boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
