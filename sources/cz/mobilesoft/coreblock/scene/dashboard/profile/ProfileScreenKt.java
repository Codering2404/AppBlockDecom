package cz.mobilesoft.coreblock.scene.dashboard.profile;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.AuthenticationToken;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.SocialMedia;
import cz.mobilesoft.coreblock.scene.dashboard.BlockingScreenKt;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewEvent;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState;
import cz.mobilesoft.coreblock.scene.dashboard.profile.type.ProfileSectionItemType;
import cz.mobilesoft.coreblock.scene.more.LicensesDialog;
import cz.mobilesoft.coreblock.scene.more.backup.BackupMainActivity;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.premium.premium_expiring.PremiumExpiringActivity;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.badge.PremiumExpiringCardKt;
import cz.mobilesoft.coreblock.view.badge.PremiumGiftCardKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;
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
public final class ProfileScreenKt {
    private static final void A0(final ProfileViewState profileViewState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strC;
        float f3;
        Modifier.Companion companion;
        int i5;
        Composer composerK = composer.k(1658267681);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(profileViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1658267681, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Footer (ProfileScreen.kt:983)");
            }
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalK = companion2.k();
            Modifier.Companion companion3 = Modifier.b8;
            float f4 = 24;
            Modifier modifierM = PaddingKt.m(SizeKt.f(companion3, 0.0f, 1, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalK, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            if (((Boolean) composerK.q(InspectionModeKt.a())).booleanValue()) {
                composerK.a0(1683541450);
                composerK.U();
                strC = "Version 6.0.0_prev";
            } else {
                composerK.a0(1683624344);
                int i6 = R.string.SF;
                String VERSION_NAME = LockieApplication.f95358c;
                Intrinsics.checkNotNullExpressionValue(VERSION_NAME, "VERSION_NAME");
                strC = StringResources_androidKt.c(i6, new Object[]{VERSION_NAME}, composerK, 0);
                composerK.U();
            }
            String str = strC;
            int i7 = R.dimen.f95467a;
            Modifier modifierM2 = PaddingKt.m(companion3, PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 0.0f, Dp.g(12), 6, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM2);
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (profileViewState.h()) {
                composerK.a0(965779515);
                Modifier modifierM3 = PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(4), 0.0f, 11, null);
                companion = companion3;
                i5 = i7;
                f3 = f4;
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C2, composerK, 6), null, modifierM3, null, null, 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composerK, 0).q(), 0, 2, null), composerK, 432, 56);
            } else {
                f3 = f4;
                companion = companion3;
                i5 = i7;
                composerK.a0(922933051);
            }
            composerK.U();
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            composerK.y();
            Modifier modifierK = PaddingKt.k(SizeKt.i(companion, Dp.g(f3)), PrimitiveResources_androidKt.a(i5, composerK, 0), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.LF, composerK, 0);
            float fG = Dp.g(0);
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.B0(context);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            ComposeButtonsKt.c0(strB, modifierK, false, 0L, null, fG, null, (Function0) objG, composer2, 196608, 92);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.C0(profileViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Context context) {
        LicensesDialog licensesDialog = new LicensesDialog();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        licensesDialog.show(((AppCompatActivity) context).getSupportFragmentManager(), "ABOUT_LICENSES_INFO_DIALOG");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(ProfileViewState profileViewState, int i3, Composer composer, int i4) {
        A0(profileViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void D0(Modifier modifier, final Function1 function1, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        final Function1 function12;
        Composer composerK = composer.k(-567089845);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-567089845, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.MoreSocialMedia (ProfileScreen.kt:934)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier3);
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
            String strB = StringResources_androidKt.b(R.string.te, composerK, 0);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion3, 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null);
            int i7 = R.dimen.f95467a;
            Modifier modifier4 = modifier3;
            int i8 = i5;
            boolean z2 = true;
            TextKt.c(strB, PaddingKt.k(modifierM, PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null), jP, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleG, composerK, 0, 0, 65528);
            composerK = composerK;
            float f3 = 16;
            SpacerKt.a(SizeKt.v(companion3, Dp.g(f3)), composerK, 6);
            Modifier modifierK = PaddingKt.k(ScrollKt.b(companion3, ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null);
            float f4 = 12;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(f4)), companion.i(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyB, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composerK.a0(364639452);
            for (final SocialMedia socialMedia : SocialMedia.getEntries()) {
                Modifier.Companion companion4 = Modifier.b8;
                Modifier modifierC = BackgroundKt.c(companion4, ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f3)));
                boolean zE = composerK.e(socialMedia.ordinal()) | ((i8 & 112) == 32 ? z2 : false);
                Object objG = composerK.G();
                if (zE || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileScreenKt.E0(function1, socialMedia);
                        }
                    };
                    composerK.w(objG);
                }
                Modifier modifierF3 = ClickableKt.f(modifierC, false, null, null, (Function0) objG, 7, null);
                MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.e(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A3 = companion5.a();
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
                Updater.e(composerA3, measurePolicyG, companion5.e());
                Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                Function2 function2B3 = companion5.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF4, companion5.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, socialMedia.getOutlinedIconRes(), composerK, 6), null, PaddingKt.i(companion4, Dp.g(f4)), null, null, 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composerK, 0).p(), 0, 2, null), composerK, 432, 56);
                composerK.y();
                z2 = true;
            }
            function12 = function1;
            composerK.U();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            function12 = function1;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.F0(modifier2, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(Function1 function1, SocialMedia socialMedia) {
        function1.invoke(new ProfileViewEvent.OnSocialMediaItemClicked(socialMedia));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Modifier modifier, Function1 function1, int i3, int i4, Composer composer, int i5) {
        D0(modifier, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void G0(Modifier modifier, final ProfileViewState profileViewState, final Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Modifier modifier4;
        int i6;
        int i7;
        int i8;
        Composer composerK = composer.k(-841426551);
        int i9 = i4 & 1;
        if (i9 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(profileViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier5 = i9 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-841426551, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileHeaderSection (ProfileScreen.kt:569)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierThen = modifier5.then(PaddingKt.k(companion, 0.0f, Dp.g(f3), 1, null));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.g(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierThen);
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
            Modifier modifierV = SizeKt.v(companion, Dp.g(120));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierV);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            AccountDetailViewState.ProfileImageState profileImageStateO = profileViewState.o();
            int i10 = i5 & 896;
            boolean z2 = (i10 == 256) | ((i5 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.H0(profileViewState, function1);
                    }
                };
                composerK.w(objG);
            }
            ProfileImageKt.A(boxScopeInstance, false, profileImageStateO, (Function0) objG, composerK, 6, 1);
            if (profileViewState.m().g()) {
                composerK.a0(-1594068462);
                Modifier modifierJ = PaddingKt.j(BackgroundKt.c(PaddingKt.m(boxScopeInstance.f(companion, companion2.b()), 0.0f, 0.0f, 0.0f, Dp.g(8), 7, null), ComposeColorsKt.j(composerK, 0).V(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(12), Dp.g(3));
                String upperCase = StringResources_androidKt.b(R.string.JD, composerK, 0).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                modifier4 = modifier5;
                i7 = 32;
                i6 = i10;
                TextKt.c(upperCase, modifierJ, ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).j(), 0L, TextUnitKt.i(11), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composerK, 0, 0, 65528);
                composerK = composerK;
            } else {
                modifier4 = modifier5;
                i6 = i10;
                i7 = 32;
                composerK.a0(-1622681059);
            }
            composerK.U();
            composerK.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(20)), composerK, 6);
            Modifier modifierK = PaddingKt.k(companion, Dp.g(i7), 0.0f, 2, null);
            String strL = profileViewState.l();
            if (strL == null || StringsKt.p0(strL)) {
                strL = null;
            }
            if (strL == null) {
                composerK.a0(-679334846);
                i8 = 0;
                strL = StringResources_androidKt.b(R.string.Xe, composerK, 0);
            } else {
                i8 = 0;
                composerK.a0(-679336396);
            }
            composerK.U();
            TextStyle textStyleE = ComposeTypographyKt.g(composerK, i8).e();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            Composer composer2 = composerK;
            TextKt.c(strL, modifierK, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleE, composer2, 48, 0, 65020);
            SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composer2, 6);
            if (profileViewState.w()) {
                composer2.a0(416581494);
                int i11 = R.string.Jq;
                String strQ = profileViewState.q();
                if (strQ == null) {
                    strQ = "";
                }
                TextKt.c(StringResources_androidKt.c(i11, new Object[]{strQ}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer2, 0, 0, 65530);
                composerK = composer2;
                SpacerKt.a(SizeKt.v(companion, Dp.g(12)), composerK, 6);
                composerK.U();
            } else {
                composer2.a0(415721492);
                float f4 = 40;
                TextKt.c(StringResources_androidKt.b(R.string.Hq, composer2, 0), PaddingKt.m(companion, Dp.g(f4), 0.0f, Dp.g(f4), Dp.g(f3), 2, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, 0, 0, 65016);
                composerK = composer2;
                Modifier modifierK2 = PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
                ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.KC, composerK, 0), 0.0f, 11, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(true, null, false, null, 14, null);
                boolean z3 = i6 == 256;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.n0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileScreenKt.I0(function1);
                        }
                    };
                    composerK.w(objG2);
                }
                ComposeButtonsKt.i0(modifierK2, big, accent, (Function0) objG2, composerK, 0, 0);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.o0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.J0(modifier3, profileViewState, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(ProfileViewState profileViewState, Function1 function1) {
        if (profileViewState.w()) {
            function1.invoke(new ProfileViewEvent.OnProfileSectionItemClicked(ProfileSectionItemType.Account));
        } else {
            function1.invoke(ProfileViewEvent.RequestSignUpLoginEvent.f100932a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function1 function1) {
        function1.invoke(ProfileViewEvent.RequestSignUpLoginEvent.f100932a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Modifier modifier, ProfileViewState profileViewState, Function1 function1, int i3, int i4, Composer composer, int i5) {
        G0(modifier, profileViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void K0(final ScaffoldState scaffoldState, final Function1 onDashboardEvent, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(onDashboardEvent, "onDashboardEvent");
        Composer composerK = composer.k(-1662075364);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDashboardEvent) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1662075364, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreen (ProfileScreen.kt:131)");
            }
            AnswersHelper.f128199a.m5("ProfileScreen");
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(ProfileViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            ProfileViewModel profileViewModel = (ProfileViewModel) viewModelA;
            ProfileViewState profileViewState = (ProfileViewState) FlowExtKt.m(profileViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(profileViewModel, composerK, 0);
            U0(scaffoldState, profileViewState.j(), profileViewState, function1N, composerK, i5 & 14);
            Y(profileViewModel, onDashboardEvent, function1N, composerK, i5 & 112);
            boolean Z = composerK.Z(function1N);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.f1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProfileScreenKt.L0(function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG);
            }
            ComposableExtKt.j(null, (Function2) objG, composerK, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.M0(scaffoldState, onDashboardEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_RESUME) {
            function1.invoke(ProfileViewEvent.OnResume.f100930a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(ScaffoldState scaffoldState, Function1 function1, int i3, Composer composer, int i4) {
        K0(scaffoldState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void N0(Modifier modifier, final List list, final String str, final Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(-715079890);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(str) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-715079890, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileSection (ProfileScreen.kt:655)");
            }
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier4);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.r0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.O0((ProfileSectionItemType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.s0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.P0((ProfileSectionItemType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.t0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return Boolean.valueOf(ProfileScreenKt.Q0((ProfileSectionItemType) obj, (Composer) obj2, ((Integer) obj3).intValue()));
                }
            };
            boolean z2 = true;
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.u0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.R0(str, (ProfileSectionItemType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            if ((i5 & 7168) != 2048) {
                z2 = false;
            }
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.v0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ProfileScreenKt.S0(function1, (ProfileSectionItemType) obj, ((Integer) obj2).intValue());
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            SectionedItemKt.r0(list, function3, null, function32, true, false, function33, function34, null, (Function2) objG, composer2, ((i5 >> 3) & 14) | 24576, 146);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.T0(modifier3, list, str, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O0(ProfileSectionItemType it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-897650946);
        if (ComposerKt.M()) {
            ComposerKt.U(-897650946, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileSection.<anonymous>.<anonymous> (ProfileScreen.kt:660)");
        }
        String strB = StringResources_androidKt.b(it.getTitleResId(), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector P0(ProfileSectionItemType it, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(314044377);
        if (ComposerKt.M()) {
            ComposerKt.U(314044377, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileSection.<anonymous>.<anonymous> (ProfileScreen.kt:662)");
        }
        ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, it.getIconResId(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageVectorB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Q0(ProfileSectionItemType it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1923332020);
        if (ComposerKt.M()) {
            ComposerKt.U(-1923332020, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileSection.<anonymous>.<anonymous> (ProfileScreen.kt:664)");
        }
        boolean zIsNew = it.isNew();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return zIsNew;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String R0(String str, ProfileSectionItemType item, Composer composer, int i3) {
        String strC;
        Intrinsics.checkNotNullParameter(item, "item");
        composer.a0(1900778168);
        if (ComposerKt.M()) {
            ComposerKt.U(1900778168, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileSection.<anonymous>.<anonymous> (ProfileScreen.kt:666)");
        }
        if (item != ProfileSectionItemType.MySubscription || str == null) {
            composer.a0(1233793765);
            composer.U();
            strC = null;
        } else {
            composer.a0(1233684863);
            strC = StringResources_androidKt.c(R.string.Mt, new Object[]{str}, composer, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Function1 function1, ProfileSectionItemType item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        function1.invoke(new ProfileViewEvent.OnProfileSectionItemClicked(item));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Modifier modifier, List list, String str, Function1 function1, int i3, int i4, Composer composer, int i5) {
        N0(modifier, list, str, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void U0(final ScaffoldState scaffoldState, final List list, final ProfileViewState profileViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-17046564);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(profileViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-17046564, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.RootCompose (ProfileScreen.kt:349)");
            }
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(936627050, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.w0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.V0(scaffoldState, list, profileViewState, function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.X0(scaffoldState, list, profileViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(ScaffoldState scaffoldState, final List list, final ProfileViewState profileViewState, final Function1 function1, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(936627050, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.RootCompose.<anonymous> (ProfileScreen.kt:352)");
            }
            ScaffoldKt.a(null, scaffoldState, null, null, ComposableSingletons$ProfileScreenKt.f100900a.d(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-631390612, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.k1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.W0(list, profileViewState, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 24576, 12779520, 98285);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(List list, ProfileViewState profileViewState, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-631390612, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.RootCompose.<anonymous>.<anonymous> (ProfileScreen.kt:359)");
            }
            b0(it, list, profileViewState, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(ScaffoldState scaffoldState, List list, ProfileViewState profileViewState, Function1 function1, int i3, Composer composer, int i4) {
        U0(scaffoldState, list, profileViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void Y(final ProfileViewModel profileViewModel, final Function1 function1, final Function1 function12, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(557017051);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(profileViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function12) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(557017051, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.CommandProcessor (ProfileScreen.kt:163)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.i1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.Z(context, (ActivityResult) obj);
                    }
                };
                composerK.w(objG);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composerK, 0);
            boolean zI2 = composerK.I(context) | ((i5 & 896) == 256) | ((i5 & 112) == 32) | composerK.I(managedActivityResultLauncherA);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                ProfileScreenKt$CommandProcessor$1$1 profileScreenKt$CommandProcessor$1$1 = new ProfileScreenKt$CommandProcessor$1$1(context, function12, function1, managedActivityResultLauncherA, null);
                composerK.w(profileScreenKt$CommandProcessor$1$1);
                objG2 = profileScreenKt$CommandProcessor$1$1;
            }
            FlowExtKt.g(profileViewModel, null, (Function2) objG2, composerK, i5 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.a0(profileViewModel, function1, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void Y0(final RowScope rowScope, String str, Function2 function2, Composer composer, final int i3) {
        int i4;
        final String str2;
        final Function2 function22;
        Composer composer2;
        Function2 function23 = function2;
        Composer composerK = composer.k(-353338517);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function23) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-353338517, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticColumn (ProfileScreen.kt:840)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierC = RowScope.c(rowScope, companion, 0.5f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.a(), Alignment.f25072a.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
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
            str2 = str;
            TextKt.c(str2, null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, (i5 >> 3) & 14, 0, 65018);
            Composer composer3 = composerK;
            SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer3, 6);
            Function2 function24 = function2;
            function24.invoke(composer3, Integer.valueOf((i5 >> 6) & 14));
            composer3.y();
            composer2 = composer3;
            function22 = function24;
            if (ComposerKt.M()) {
                ComposerKt.T();
                composer2 = composer3;
                function22 = function24;
            }
        } else {
            str2 = str;
            Composer composer4 = composerK;
            composer4.Q();
            composer2 = composer4;
            function22 = function23;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.Z0(rowScope, str2, function22, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Context context, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            context.startActivity(BackupMainActivity.f106365v.a(context));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(RowScope rowScope, String str, Function2 function2, int i3, Composer composer, int i4) {
        Y0(rowScope, str, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(ProfileViewModel profileViewModel, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        Y(profileViewModel, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void a1(final ProfileViewState profileViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-686333730);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(profileViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-686333730, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticsReadySection (ProfileScreen.kt:699)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            Modifier modifierK = SizeKt.k(companion, Dp.g(96), 0.0f, 2, null);
            int i5 = i4 & 112;
            boolean z2 = i5 == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.y0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.b1(function1);
                    }
                };
                composerK.w(objG);
            }
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(ClickableKt.f(modifierK, false, null, null, (Function0) objG, 7, null), Dp.g(f3));
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI);
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
            Y0(rowScopeInstance, StringResources_androidKt.b(R.string.qA, composerK, 0), ComposableLambdaKt.e(1154279242, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.c1(profileViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 390);
            float f4 = 1;
            Modifier modifierI2 = SizeKt.i(SizeKt.A(companion, Dp.g(f4)), Dp.g(40));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierI2);
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
            Updater.e(composerA3, measurePolicyG, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            DividerKt.a(SizeKt.A(SizeKt.d(companion, 0.0f, 1, null), Dp.g(f4)), 0L, 0.0f, 0.0f, composerK, 6, 14);
            composerK.y();
            Y0(rowScopeInstance, StringResources_androidKt.b(R.string.SD, composerK, 0), ComposableLambdaKt.e(-254845325, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.d1(profileViewState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 390);
            composerK.y();
            androidx.compose.material3.DividerKt.b(SizeKt.h(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), 0.0f, 1, null), Dp.g(f4), Color.r(ComposeColorsKt.j(composerK, 0).m0(), 0.08f, 0.0f, 0.0f, 0.0f, 14, null), composerK, 54, 0);
            Modifier modifierI3 = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(68));
            boolean z3 = i5 == 32;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.b1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.e1(function1);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierK2 = PaddingKt.k(ClickableKt.f(modifierI3, false, null, null, (Function0) objG2, 7, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierK2);
            Function0 function0A4 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyB2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            float f5 = 24;
            Modifier modifierV = SizeKt.v(companion, Dp.g(f5));
            ImageVector.Companion companion4 = ImageVector.f26323k;
            IconKt.d(VectorResources_androidKt.b(companion4, R.drawable.D5, composerK, 6), null, modifierV, ComposeColorsKt.j(composerK, 0).b(), composerK, 432, 0);
            TextKt.c(StringResources_androidKt.b(R.string.MG, composerK, 0), PaddingKt.m(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65528);
            composerK = composerK;
            if (profileViewState.k()) {
                composerK.a0(187519963);
                Modifier modifierM = PaddingKt.m(BackgroundKt.c(SizeKt.i(companion, Dp.g(32)), ComposeColorsKt.j(composerK, 0).A(), RoundedCornerShapeKt.a(50)), Dp.g(12), 0.0f, Dp.g(2), 0.0f, 10, null);
                MeasurePolicy measurePolicyB3 = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
                int iA5 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU5 = composerK.u();
                Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierM);
                Function0 function0A5 = companion3.a();
                if (composerK.m() == null) {
                    ComposablesKt.c();
                }
                composerK.L();
                if (composerK.i()) {
                    composerK.P(function0A5);
                } else {
                    composerK.v();
                }
                Composer composerA5 = Updater.a(composerK);
                Updater.e(composerA5, measurePolicyB3, companion3.e());
                Updater.e(composerA5, compositionLocalMapU5, companion3.g());
                Function2 function2B5 = companion3.b();
                if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                    composerA5.w(Integer.valueOf(iA5));
                    composerA5.p(Integer.valueOf(iA5), function2B5);
                }
                Updater.e(composerA5, modifierF5, companion3.f());
                TextKt.c(StringResources_androidKt.b(R.string.b7, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
                composerK = composerK;
                IconKt.d(VectorResources_androidKt.b(companion4, R.drawable.f95580y1, composerK, 6), null, SizeKt.v(companion, Dp.g(f5)), ComposeColorsKt.j(composerK, 0).q0(), composerK, 432, 0);
                composerK.y();
            } else {
                composerK.a0(151144501);
            }
            composerK.U();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.c1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.f1(profileViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void b0(final PaddingValues paddingValues, final List list, final ProfileViewState profileViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1175159803);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(profileViewState) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1175159803, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content (ProfileScreen.kt:376)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierF = SizeKt.f(PaddingKt.h(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.d(WindowInsets.f7172a, composerK, 6)), paddingValues), 0.0f, 1, null);
            PaddingValues paddingValuesE = PaddingKt.e(0.0f, Dp.g(64), 0.0f, 0.0f, 13, null);
            boolean zI = ((i4 & 896) == 256) | ((i4 & 7168) == 2048) | composerK.I(context) | composerK.I(list);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.l1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.c0(profileViewState, function1, context, list, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            LazyDslKt.b(modifierF, null, paddingValuesE, false, null, null, null, false, null, (Function1) objG, composer2, 384, 506);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.m1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.r0(paddingValues, list, profileViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(Function1 function1) {
        function1.invoke(ProfileViewEvent.ShowStatisticsPageEvent.f100933a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(final ProfileViewState profileViewState, final Function1 function1, final Context context, final List list, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, AuthenticationToken.HEADER_KEY, null, ComposableLambdaKt.c(-755567610, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.q
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.d0(profileViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        LazyListScope.c(LazyColumn, "premium", null, ComposableLambdaKt.c(-2042224273, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.r
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.e0(context, profileViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        if (profileViewState.i().isEmpty()) {
            LazyListScope.c(LazyColumn, "statistics", null, ComposableLambdaKt.c(666531019, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.s
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProfileScreenKt.m0(profileViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 2, null);
        }
        LazyListScope.c(LazyColumn, "more", null, ComposableLambdaKt.c(-892391986, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.t
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.n0(profileViewState, list, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        LazyListScope.c(LazyColumn, "discover", null, ComposableLambdaKt.c(257440301, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.u
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.o0(profileViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        LazyListScope.c(LazyColumn, "socials", null, ComposableLambdaKt.c(1407272588, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.v
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.p0(function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        LazyListScope.c(LazyColumn, "footer", null, ComposableLambdaKt.c(-1737862421, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.w
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ProfileScreenKt.q0(profileViewState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(ProfileViewState profileViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1154279242, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticsReadySection.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:717)");
            }
            String strN = profileViewState.n();
            TextKt.c((strN == null || StringsKt.p0(strN)) ? "-" : profileViewState.n(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65534);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ProfileViewState profileViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-755567610, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:389)");
            }
            G0(SizeKt.h(Modifier.b8, 0.0f, 1, null), profileViewState, function1, composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(ProfileViewState profileViewState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-254845325, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticsReadySection.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:737)");
            }
            Modifier.Companion companion = Modifier.b8;
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composer, 48);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, Intrinsics.areEqual(profileViewState.x(), Boolean.TRUE) ? R.drawable.A6 : R.drawable.C6, composer, 6), "", BoxScopeInstance.f6642a.f(companion, companion2.f()), Color.f25715b.k(), composer, 3120, 0);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(2)), composer, 6);
            String strU = profileViewState.u();
            TextKt.c((strU == null || StringsKt.p0(strU)) ? "-" : profileViewState.u(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65534);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
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
    public static final Unit e0(final Context context, ProfileViewState profileViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Integer num;
        boolean z2;
        boolean z3;
        Modifier.Companion companion;
        float f3;
        boolean z4;
        boolean z5;
        String strC;
        boolean z6;
        String strM1;
        int i4;
        String strC2;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2042224273, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:397)");
            }
            long jA = ((WindowInfo) composer2.q(CompositionLocalsKt.u())).a();
            Density density = (Density) composer2.q(CompositionLocalsKt.f());
            float fA = PrimitiveResources_androidKt.a(R.dimen.f95467a, composer2, 0);
            final boolean zL = RunnabilityHelper.f129617a.L(context);
            float f4 = 0;
            final float fL = ((Dp) RangesKt.h(Dp.d(Dp.g(density.F((int) (jA >> 32)) - Dp.g(2 * fA))), Dp.d(Dp.g(f4)))).l();
            Long lD = profileViewState.d();
            if (lD == null || !profileViewState.e().getShowsCard()) {
                lD = null;
            }
            final boolean z7 = lD != null;
            boolean z8 = profileViewState.c() && profileViewState.e().getShowsCard();
            final boolean z9 = z7 || z8;
            boolean zP = profileViewState.p();
            if (z9 || profileViewState.s()) {
                num = 14;
                z2 = true;
            } else {
                num = 14;
                z2 = false;
            }
            boolean z10 = (zP || z2) ? false : true;
            float fG = z2 ? Dp.g(8) : zP ? Dp.g(16) : Dp.g(f4);
            boolean z11 = (zL && !z2) || z10;
            float fL2 = ((Dp) RangesKt.h(Dp.d(Dp.g(fL - fG)), Dp.d(Dp.g(f4)))).l();
            float fG2 = z10 ? zL ? Dp.g(fL * 0.5f) : fL : (zL && z2) ? Dp.g(fL2 * 0.25f) : Dp.g(fL2 * 0.5f);
            float fL3 = zL ? ((Dp) RangesKt.h(Dp.d(Dp.g(Dp.g(fL - fA) * 0.5f)), Dp.d(Dp.g(f4)))).l() : fL;
            Modifier.Companion companion2 = Modifier.b8;
            float f5 = fG2;
            Long l3 = lD;
            boolean z12 = z8;
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            boolean z13 = !z11;
            Object objG = composer2.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.f0((Modifier) obj);
                    }
                };
                composer2.w(objG);
            }
            Modifier modifierR = ComposableExtKt.r(modifierH, z13, (Function1) objG);
            boolean zC = composer2.c(fL) | composer2.b(zL);
            Object objG2 = composer2.G();
            if (zC || objG2 == companion3.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.g0(fL, zL, (Modifier) obj);
                    }
                };
                composer2.w(objG2);
            }
            Modifier modifierJ = PaddingKt.j(ScrollKt.b(ComposableExtKt.r(modifierR, z11, (Function1) objG2), ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null), fA, Dp.g(16));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.o(fG), Alignment.f25072a.l(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyB, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (z2) {
                composer2.a0(-816359034);
                String strB = null;
                Modifier modifierD = SizeKt.d(SizeKt.A(companion2, fL3), 0.0f, 1, null);
                Integer numValueOf = l3 != null ? Integer.valueOf((int) TimeUnit.MILLISECONDS.toDays(l3.longValue())) : z12 ? null : profileViewState.f();
                if (l3 != null) {
                    z6 = z11;
                    strM1 = BlockingScreenKt.M1(l3.longValue());
                } else {
                    z6 = z11;
                    strM1 = null;
                }
                if (l3 == null) {
                    composer2.a0(-815598729);
                    composer2.U();
                    strC2 = null;
                    i4 = 0;
                } else {
                    composer2.a0(-815598728);
                    i4 = 0;
                    strC2 = StringResources_androidKt.c(R.string.f95808j2, new Object[]{""}, composer2, 0);
                    composer2.U();
                }
                if (z9) {
                    composer2.a0(-1688873542);
                    strB = StringResources_androidKt.b(R.string.X1, composer2, i4);
                } else {
                    composer2.a0(-815421006);
                }
                composer2.U();
                boolean zB = composer2.b(z9) | composer2.b(z7) | composer2.I(context);
                Object objG3 = composer2.G();
                if (zB || objG3 == companion3.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.c0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileScreenKt.h0(z9, z7, context);
                        }
                    };
                    composer2.w(objG3);
                }
                z3 = z6;
                companion = companion2;
                f3 = f5;
                PremiumExpiringCardKt.n(modifierD, numValueOf, (Function0) objG3, strM1, strC2, strB, composer, 0, 0);
                composer2 = composer;
            } else {
                z3 = z11;
                companion = companion2;
                f3 = f5;
                composer2.a0(-838431561);
            }
            composer2.U();
            if (zP) {
                composer2.a0(-814161444);
                Modifier modifierA = SizeKt.A(companion, f3);
                Object objG4 = composer2.G();
                if (objG4 == companion3.a()) {
                    objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.d0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ProfileScreenKt.i0((Modifier) obj);
                        }
                    };
                    composer2.w(objG4);
                }
                Modifier modifierR2 = ComposableExtKt.r(modifierA, z2, (Function1) objG4);
                if (profileViewState.y()) {
                    composer2.a0(-1688820062);
                    strC = StringResources_androidKt.c(R.string.Ke, new Object[]{StringResources_androidKt.c(R.string.yl, new Object[]{num}, composer2, 0)}, composer2, 0);
                } else {
                    composer2.a0(-1688816061);
                    strC = StringResources_androidKt.c(R.string.Pe, new Object[]{StringResources_androidKt.c(R.string.yl, new Object[]{num}, composer2, 0)}, composer2, 0);
                }
                composer2.U();
                Function2 function2C = ComposableSingletons$ProfileScreenKt.f100900a.c();
                boolean Z = composer2.Z(function1);
                Object objG5 = composer2.G();
                if (Z || objG5 == companion3.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileScreenKt.j0(function1);
                        }
                    };
                    composer2.w(objG5);
                }
                boolean z14 = z3;
                z4 = z2;
                PremiumGiftCardKt.g(modifierR2, strC, null, function2C, 0.0f, 0L, z14, (Function0) objG5, composer2, 3072, 52);
                z5 = z14;
            } else {
                z4 = z2;
                z5 = z3;
                composer2.a0(-838431561);
            }
            composer2.U();
            Modifier modifierA2 = SizeKt.A(companion, f3);
            Object objG6 = composer2.G();
            if (objG6 == companion3.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.k0((Modifier) obj);
                    }
                };
                composer2.w(objG6);
            }
            Modifier modifierR3 = ComposableExtKt.r(modifierA2, z4, (Function1) objG6);
            String strB2 = StringResources_androidKt.b(R.string.ok, composer2, 0);
            Painter painterC = PainterResources_androidKt.c(R.drawable.z8, composer2, 0);
            long jH = ComposeColorsKt.j(composer2, 0).h();
            boolean zI = composer2.I(context);
            Object objG7 = composer2.G();
            if (zI || objG7 == companion3.a()) {
                objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.l0(context);
                    }
                };
                composer2.w(objG7);
            }
            PremiumGiftCardKt.g(modifierR3, strB2, painterC, null, 0.3f, jH, z5, (Function0) objG7, composer, 24576, 8);
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
    public static final Unit e1(Function1 function1) {
        function1.invoke(ProfileViewEvent.ShowWeeklyInsights.f100934a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier f0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return IntrinsicKt.a(applyIf, IntrinsicSize.f6987b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(ProfileViewState profileViewState, Function1 function1, int i3, Composer composer, int i4) {
        a1(profileViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier g0(float f3, boolean z2, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.i(applyIf, Dp.g(f3 * (z2 ? 0.25f : 0.5f)));
    }

    private static final void g1(Modifier modifier, final ProfileViewState profileViewState, final Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(859486450);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(profileViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(859486450, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticsSection (ProfileScreen.kt:679)");
            }
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier3);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ComposeCardsKt.m(null, new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(213999905, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.h0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.h1(profileViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3456, 1);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.i1(modifier3, profileViewState, function1, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(boolean z2, boolean z3, Context context) {
        AnswersHelper.f128199a.P3("profile");
        if (z2) {
            context.startActivity(PremiumExpiringActivity.f113543g.a(context, "profile_tab", z3 ? "auto_trial_active_card" : "auto_trial_expired_card", PremiumExpiringActivity.PremiumExpiringTrialType.Monthly));
        } else {
            context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.ExpiredSubDiscount(false), "renewal_screen", "profile_tab", false, false, false, null, 240, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(ProfileViewState profileViewState, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(213999905, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.StatisticsSection.<anonymous>.<anonymous> (ProfileScreen.kt:687)");
            }
            a1(profileViewState, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier i0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.d(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(Modifier modifier, ProfileViewState profileViewState, Function1 function1, int i3, int i4, Composer composer, int i5) {
        g1(modifier, profileViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Function1 function1) {
        function1.invoke(new ProfileViewEvent.OnProfileSectionItemClicked(ProfileSectionItemType.GuestPass));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier k0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return SizeKt.d(applyIf, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(Context context) {
        AnswersHelper.f128199a.Y3();
        ExternalLinksHelper.f127866a.d(context, "https://appblock.app/gift-card/cart/");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(ProfileViewState profileViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(666531019, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:519)");
            }
            Modifier.Companion companion = Modifier.b8;
            g1(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), profileViewState, function1, composer, 0, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(24)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ProfileViewState profileViewState, List list, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-892391986, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:531)");
            }
            N0(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), list, profileViewState.v(), function1, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(ProfileViewState profileViewState, Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(257440301, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:542)");
            }
            w0(SizeKt.h(Modifier.b8, 0.0f, 1, null), profileViewState.g(), function1, composer, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1407272588, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:551)");
            }
            D0(null, function1, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(ProfileViewState profileViewState, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1737862421, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.Content.<anonymous>.<anonymous>.<anonymous> (ProfileScreen.kt:557)");
            }
            A0(profileViewState, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(PaddingValues paddingValues, List list, ProfileViewState profileViewState, Function1 function1, int i3, Composer composer, int i4) {
        b0(paddingValues, list, profileViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(final ProfileSectionItemType profileSectionItemType, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-917375444);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(profileSectionItemType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-917375444, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.DiscoverCard (ProfileScreen.kt:900)");
            }
            Modifier modifierB = AspectRatioKt.b(SizeKt.A(Modifier.b8, Dp.g(140)), 1.0f, false, 2, null);
            CardType.Surface surface = new CardType.Surface(null, null, null, 7, null);
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 14) == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileScreenKt.t0(function1, profileSectionItemType);
                    }
                };
                composerK.w(objG);
            }
            ComposeCardsKt.m(modifierB, surface, (Function0) objG, ComposableLambdaKt.e(1656068113, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.u0(profileSectionItemType, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.v0(profileSectionItemType, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Function1 function1, ProfileSectionItemType profileSectionItemType) {
        function1.invoke(new ProfileViewEvent.OnProfileSectionItemClicked(profileSectionItemType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(ProfileSectionItemType profileSectionItemType, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1656068113, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.DiscoverCard.<anonymous> (ProfileScreen.kt:909)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, profileSectionItemType.getIconResId(), composer, 6), "ic_discover_" + profileSectionItemType.name(), null, ComposeColorsKt.j(composer, 0).b(), composer, 0, 4);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            TextKt.c(StringResources_androidKt.b(profileSectionItemType.getTitleResId(), composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
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
    public static final Unit v0(ProfileSectionItemType profileSectionItemType, Function1 function1, int i3, Composer composer, int i4) {
        s0(profileSectionItemType, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w0(Modifier modifier, List list, Function1 function1, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final List list2;
        Composer composer2;
        final Function1 function12 = function1;
        Composer composerK = composer.k(-975073219);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(list) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-975073219, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.DiscoverSection (ProfileScreen.kt:864)");
            }
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier3);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier.Companion companion2 = Modifier.b8;
            int i7 = R.dimen.f95467a;
            int i8 = i5;
            Modifier modifier4 = modifier3;
            TextKt.c(StringResources_androidKt.b(R.string.tc, composerK, 0), PaddingKt.k(companion2, PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65532);
            SpacerKt.a(SizeKt.v(companion2, Dp.g(12)), composerK, 6);
            Modifier modifierH = SizeKt.h(companion2, 0.0f, 1, null);
            PaddingValues paddingValuesC = PaddingKt.c(PrimitiveResources_androidKt.a(i7, composerK, 0), 0.0f, 2, null);
            list2 = list;
            boolean zI = composerK.I(list2) | ((i8 & 896) == 256);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                function12 = function1;
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.p0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileScreenKt.x0(list2, function12, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            } else {
                function12 = function1;
            }
            LazyDslKt.e(modifierH, null, paddingValuesC, false, null, null, null, false, null, (Function1) objG, composerK, 6, 506);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            list2 = list;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final List list3 = list2;
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileScreenKt.z0(modifier5, list3, function12, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(final List list, final Function1 function1, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.d1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ProfileScreenKt.y0(((Integer) obj).intValue(), (ProfileSectionItemType) obj2);
            }
        };
        LazyRow.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreenKt$DiscoverSection$lambda$0$0$0$$inlined$itemsIndexed$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return function2.invoke(Integer.valueOf(i3), list.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreenKt$DiscoverSection$lambda$0$0$0$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                list.get(i3);
                return null;
            }
        }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileScreenKt$DiscoverSection$lambda$0$0$0$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(-1091073711, i5, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                ProfileSectionItemType profileSectionItemType = (ProfileSectionItemType) list.get(i3);
                composer.a0(1964277175);
                ProfileScreenKt.s0(profileSectionItemType, function1, composer, 0);
                if (i3 < list.size() - 1) {
                    composer.a0(1964363664);
                    SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(12)), composer, 6);
                } else {
                    composer.a0(1925370655);
                }
                composer.U();
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object y0(int i3, ProfileSectionItemType item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.name();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Modifier modifier, List list, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w0(modifier, list, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
