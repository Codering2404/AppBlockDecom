package cz.mobilesoft.coreblock.scene.more.changelog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.DividerKt;
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
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.fragment.BaseComposeFragment;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.SignInEntryPoint;
import cz.mobilesoft.coreblock.repository.AppVersionRepository;
import cz.mobilesoft.coreblock.scene.more.backup.BackupMainActivity;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogClickAction;
import cz.mobilesoft.coreblock.scene.more.changelog.ChangelogViewEvent;
import cz.mobilesoft.coreblock.scene.more.signin.SignInActivity;
import cz.mobilesoft.coreblock.scene.more.signin.SignInConfig;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.SessionManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DialogHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.LabelsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ChangelogFragment extends BaseComposeFragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f106934a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f106935b = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChangelogFragment a() {
            Bundle bundle = new Bundle();
            ChangelogFragment changelogFragment = new ChangelogFragment();
            changelogFragment.setArguments(bundle);
            return changelogFragment;
        }

        private Companion() {
        }
    }

    private final void R(final ChangelogFeature changelogFeature, final PremiumState premiumState, Composer composer, final int i3) {
        int i4;
        Object obj;
        float f3;
        String[] strArr;
        Integer numG;
        Composer composerK = composer.k(-63786729);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(changelogFeature) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(premiumState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-63786729, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.FeatureItem (ChangelogFragment.kt:218)");
            }
            TextKt.c(StringResources_androidKt.b(changelogFeature.j(), composerK, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65534);
            Composer composer2 = composerK;
            final List listD = changelogFeature.d();
            if (listD == null) {
                composer2.a0(-1894674521);
                composer2.U();
                obj = null;
                f3 = 0.0f;
            } else {
                composer2.a0(-1894674520);
                Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(8));
                Modifier modifierM = PaddingKt.m(SizeKt.f(Modifier.b8, 0.0f, 1, null), 0.0f, Dp.g(6), 0.0f, 0.0f, 13, null);
                boolean zI = composer2.I(listD);
                Object objG = composer2.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.l
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return ChangelogFragment.S(listD, (LazyListScope) obj2);
                        }
                    };
                    composer2.w(objG);
                }
                obj = null;
                f3 = 0.0f;
                LazyDslKt.e(modifierM, null, null, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composer2, 24582, 494);
                composer2 = composer2;
                composer2.U();
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, f3, 1, obj);
            float f4 = 14;
            Modifier modifierM2 = PaddingKt.m(modifierF, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composer2, 0);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierM2);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            int iH = changelogFeature.h();
            List listI = changelogFeature.i();
            if (listI == null || (strArr = (String[]) listI.toArray(new String[0])) == null) {
                strArr = new String[0];
            }
            Composer composer3 = composer2;
            TextKt.c(StringHelperExtKt.f(StringResources_androidKt.c(iH, Arrays.copyOf(strArr, strArr.length), composer2, 0), true).toString(), null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer3, 0, 0, 65530);
            composerK = composer3;
            composerK.y();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            if (Intrinsics.areEqual(premiumState, PremiumState.Lifetime.INSTANCE) || (premiumState instanceof PremiumState.Subscription)) {
                numG = changelogFeature.g();
                objectRef.f140144a = changelogFeature.f();
            } else if (Intrinsics.areEqual(premiumState, PremiumState.OldFull.INSTANCE)) {
                numG = changelogFeature.b();
                objectRef.f140144a = changelogFeature.e();
            } else {
                if (!Intrinsics.areEqual(premiumState, PremiumState.None.INSTANCE) && !(premiumState instanceof PremiumState.OldPartial)) {
                    throw new NoWhenBranchMatchedException();
                }
                numG = changelogFeature.b();
                objectRef.f140144a = changelogFeature.a();
            }
            if (numG == null || objectRef.f140144a == null) {
                composerK.a0(-1903889301);
            } else {
                composerK.a0(-1893084065);
                Object obj2 = objectRef.f140144a;
                if ((obj2 instanceof ChangelogClickAction.OpenLimitScreen) || (obj2 instanceof ChangelogClickAction.OpenOldPremiumToSubscriptionScreen)) {
                    composerK.a0(-1892936226);
                    ComposeButtonsKt.i0(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), new ButtonType.Big(null, null, StringResources_androidKt.b(numG.intValue(), composerK, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.m
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChangelogFragment.T(this.f107047a, objectRef);
                        }
                    }, composerK, 6, 0);
                    composerK.U();
                } else {
                    composerK.a0(-1892475101);
                    ComposeButtonsKt.i0(PaddingKt.m(companion, 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null), new ButtonType.Big(null, null, StringResources_androidKt.b(numG.intValue(), composerK, 0), 0.0f, 11, null), new ButtonColor.Surface(false, null, false, null, null, 31, null), new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.n
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ChangelogFragment.U(this.f107049a, objectRef);
                        }
                    }, composerK, 6, 0);
                    composerK.U();
                }
            }
            composerK.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    return ChangelogFragment.V(this.f106969a, changelogFeature, premiumState, i3, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(final List list, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        final ChangelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$1 changelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyRow.h(list.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return changelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$1.invoke(list.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$FeatureItem$lambda$0$0$0$$inlined$items$default$4
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
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                ChangelogLabel changelogLabel = (ChangelogLabel) list.get(i3);
                composer.a0(1327892632);
                LabelsKt.c(changelogLabel, composer, 0);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(ChangelogFragment changelogFragment, Ref.ObjectRef objectRef) {
        changelogFragment.k0((ChangelogClickAction) objectRef.f140144a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(ChangelogFragment changelogFragment, Ref.ObjectRef objectRef) {
        changelogFragment.k0((ChangelogClickAction) objectRef.f140144a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(ChangelogFragment changelogFragment, ChangelogFeature changelogFeature, PremiumState premiumState, int i3, Composer composer, int i4) {
        changelogFragment.R(changelogFeature, premiumState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(ChangelogFragment changelogFragment, int i3, Composer composer, int i4) {
        changelogFragment.y(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(final ChangelogVersionItem changelogVersionItem, final boolean z2, final PremiumState premiumState, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        String str;
        Composer composerK = composer.k(278444213);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(changelogVersionItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(premiumState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(278444213, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.VersionItem (ChangelogFragment.kt:135)");
            }
            final float fA = PrimitiveResources_androidKt.a(R.dimen.f95468b, composerK, 0);
            final float fA2 = PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
            int i5 = i4 & 7168;
            int i6 = i4 & 14;
            boolean z3 = (i5 == 2048) | (i6 == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChangelogFragment.Y(function1, changelogVersionItem);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifierF4 = ClickableKt.f(modifierF3, false, null, null, (Function0) objG, 7, null);
            int i7 = i4;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
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
            Updater.e(composerA2, modifierF5, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier modifierF6 = SizeKt.f(PaddingKt.j(companion, fA2, fA), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF7 = ComposedModifierKt.f(composerK, modifierF6);
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
            Updater.e(composerA3, modifierF7, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF8 = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA4, measurePolicyA2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF8, companion3.f());
            int iH = changelogVersionItem.e().h();
            int i8 = changelogVersionItem.e().i();
            if (changelogVersionItem.e().g() != 0) {
                str = "." + changelogVersionItem.e().g();
            } else {
                str = "";
            }
            boolean z4 = false;
            TextKt.c(iH + "." + i8 + str, null, ComposeColorsKt.j(composerK, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65530);
            TextKt.c(changelogVersionItem.a(), PaddingKt.m(companion, 0.0f, Dp.g((float) 4), 0.0f, 0.0f, 13, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65532);
            composerK.y();
            Modifier modifierF9 = boxScopeInstance.f(companion, companion2.f());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA5 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU5 = composerK.u();
            Modifier modifierF10 = ComposedModifierKt.f(composerK, modifierF9);
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
            Updater.e(composerA5, measurePolicyG2, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF10, companion3.f());
            float fG = Dp.g(28);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95544n2, composerK, 6);
            long jB = ComposeColorsKt.j(composerK, 0).b();
            long jL0 = ComposeColorsKt.j(composerK, 0).l0();
            int i9 = i7 & 112;
            boolean z5 = i9 == 32;
            Object objG2 = composerK.G();
            if (z5 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChangelogFragment.Z(z2, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierA = GraphicsLayerModifierKt.a(companion, (Function1) objG2);
            boolean z6 = i5 == 2048;
            if (i6 == 4) {
                z4 = true;
            }
            boolean z7 = z6 | z4;
            Object objG3 = composerK.G();
            if (z7 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ChangelogFragment.a0(function1, changelogVersionItem);
                    }
                };
                composerK.w(objG3);
            }
            ComposeButtonsKt.k0(fG, 0.0f, imageVectorB, jB, jL0, modifierA, (Function0) objG3, composerK, 6, 2);
            composerK.y();
            composerK.y();
            composerK.y();
            AnimatedVisibilityKt.g(columnScopeInstance, z2, null, null, null, null, ComposableLambdaKt.e(-252658813, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ChangelogFragment.b0(fA2, fA, this, changelogVersionItem, premiumState, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1572870 | i9, 30);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogFragment.c0(this.f106988a, changelogVersionItem, z2, premiumState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, ChangelogVersionItem changelogVersionItem) {
        function1.invoke(new ChangelogViewEvent.OnItemClicked(changelogVersionItem));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(boolean z2, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (z2) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, ChangelogVersionItem changelogVersionItem) {
        function1.invoke(new ChangelogViewEvent.OnItemClicked(changelogVersionItem));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(float f3, float f4, ChangelogFragment changelogFragment, ChangelogVersionItem changelogVersionItem, PremiumState premiumState, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-252658813, i3, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.VersionItem.<anonymous>.<anonymous> (ChangelogFragment.kt:184)");
        }
        Modifier modifierH = PaddingKt.h(Modifier.b8, PaddingKt.d(f3, Dp.g(0), f3, f4));
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
        changelogFragment.d0(changelogVersionItem, premiumState, composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(ChangelogFragment changelogFragment, ChangelogVersionItem changelogVersionItem, boolean z2, PremiumState premiumState, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        changelogFragment.X(changelogVersionItem, z2, premiumState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void d0(final ChangelogVersionItem changelogVersionItem, final PremiumState premiumState, Composer composer, final int i3) {
        int i4;
        int i5;
        int i6;
        Composer composerK = composer.k(1170707101);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(changelogVersionItem) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        int i7 = 16;
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(premiumState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i8 = i4;
        int i9 = 0;
        int i10 = 1;
        if (composerK.r((i8 & 147) != 146, i8 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1170707101, i8, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.VersionItemExpanded (ChangelogFragment.kt:197)");
            }
            Iterator it = changelogVersionItem.b().iterator();
            int i11 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ChangelogFeature changelogFeature = (ChangelogFeature) next;
                Modifier.Companion companion = Modifier.b8;
                float f3 = i7;
                Modifier modifierF = SizeKt.f(PaddingKt.m(companion, Dp.g(24), Dp.g(f3), 0.0f, 0.0f, 12, null), 0.0f, i10, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, i9);
                int iA = ComposablesKt.a(composerK, i9);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
                Iterator it2 = it;
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF2, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                R(changelogFeature, premiumState, composerK, i8 & 1008);
                if (i11 < CollectionsKt.getLastIndex(changelogVersionItem.b())) {
                    composerK.a0(891490475);
                    i5 = 0;
                    i6 = 1;
                    DividerKt.a(PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composerK, 0).N(), 0.0f, 0.0f, composerK, 6, 12);
                } else {
                    i5 = 0;
                    i6 = 1;
                    composerK.a0(882881434);
                }
                composerK.U();
                composerK.y();
                i9 = i5;
                i11 = i12;
                i10 = i6;
                it = it2;
                i7 = 16;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogFragment.e0(this.f107040a, changelogVersionItem, premiumState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(ChangelogFragment changelogFragment, ChangelogVersionItem changelogVersionItem, PremiumState premiumState, int i3, Composer composer, int i4) {
        changelogFragment.d0(changelogVersionItem, premiumState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(ChangelogViewState changelogViewState, final ChangelogFragment changelogFragment, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final List listE = changelogViewState.e();
        final Set setC = changelogViewState.c();
        final PremiumState premiumStateD = changelogViewState.d();
        final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.e
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ChangelogFragment.h0(((Integer) obj).intValue(), (ChangelogVersionItem) obj2);
            }
        };
        LazyColumn.h(listE.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$VersionList$lambda$0$0$$inlined$itemsIndexed$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return function2.invoke(Integer.valueOf(i3), listE.get(i3));
            }
        }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$VersionList$lambda$0$0$$inlined$itemsIndexed$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                listE.get(i3);
                return null;
            }
        }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment$VersionList$lambda$0$0$$inlined$itemsIndexed$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) throws XmlPullParserException, IOException {
                invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
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
                ChangelogVersionItem changelogVersionItem = (ChangelogVersionItem) listE.get(i3);
                composer.a0(-1921106651);
                changelogFragment.X(changelogVersionItem, setC.contains(changelogVersionItem), premiumStateD, function1, composer, 0);
                if (i3 < CollectionsKt.getLastIndex(listE)) {
                    composer.a0(-1920825079);
                    DividerKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).N(), 0.0f, 0.0f, composer, 6, 12);
                } else {
                    composer.a0(-1925885891);
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
    public static final Object h0(int i3, ChangelogVersionItem dto) {
        Intrinsics.checkNotNullParameter(dto, "dto");
        return "version_" + dto.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(ChangelogFragment changelogFragment, ChangelogViewState changelogViewState, Function1 function1, int i3, Composer composer, int i4) {
        changelogFragment.f0(changelogViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void k0(ChangelogClickAction changelogClickAction) {
        Intent intentA;
        AnswersHelper.f128199a.m1();
        if (Intrinsics.areEqual(changelogClickAction, ChangelogClickAction.OpenBackups.f106920a)) {
            Context contextRequireContext = requireContext();
            if (SessionManager.f127910a.r()) {
                BackupMainActivity.Companion companion = BackupMainActivity.f106365v;
                Context contextRequireContext2 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                intentA = companion.a(contextRequireContext2);
            } else {
                SignInActivity.Companion companion2 = SignInActivity.f110366h;
                Context contextRequireContext3 = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                intentA = companion2.a(contextRequireContext3, new SignInConfig(SignInEntryPoint.BACKUP, null, false, false, true, false, false, false, false, false, null, 2030, null));
            }
            contextRequireContext.startActivity(intentA);
            return;
        }
        if (Intrinsics.areEqual(changelogClickAction, ChangelogClickAction.OpenKeywordsBottomSheet.f106921a)) {
            Context contextRequireContext4 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext4, "requireContext(...)");
            FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            DialogHelperExtKt.x(contextRequireContext4, supportFragmentManager);
            return;
        }
        if (changelogClickAction instanceof ChangelogClickAction.OpenLimitScreen) {
            Paywall paywall = Paywall.f113165a;
            Context contextRequireContext5 = requireContext();
            Intrinsics.checkNotNullExpressionValue(contextRequireContext5, "requireContext(...)");
            startActivity(Paywall.c(paywall, contextRequireContext5, new PaywallTarget.LimitScreen(((ChangelogClickAction.OpenLimitScreen) changelogClickAction).a()), "changelog", "changelog", false, false, false, null, 240, null));
            return;
        }
        if (!(changelogClickAction instanceof ChangelogClickAction.OpenOldPremiumToSubscriptionScreen)) {
            throw new NoWhenBranchMatchedException();
        }
        Paywall paywall2 = Paywall.f113165a;
        Context contextRequireContext6 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext6, "requireContext(...)");
        String string = requireContext().getString(R.string.r2);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        startActivity(Paywall.c(paywall2, contextRequireContext6, new PaywallTarget.OneTimeToSub(string), "changelog", "changelog", false, false, false, null, 240, null));
    }

    public final void f0(final ChangelogViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1271252997);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1271252997, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.VersionList (ChangelogFragment.kt:102)");
            }
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
            boolean zI = ((i4 & 14) == 4) | composerK.I(this) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChangelogFragment.g0(viewState, this, onEvent, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            LazyDslKt.b(modifierD, null, null, false, null, null, null, false, null, (Function1) objG, composerK, 0, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogFragment.i0(this.f106976a, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseComposeFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NotificationHelper notificationHelper = NotificationHelper.f128940a;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        notificationHelper.a(contextRequireContext);
        AppVersionRepository.f97355a.G();
    }

    @Override // cz.mobilesoft.coreblock.base.fragment.BaseComposeFragment
    public void y(Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Composer composerK = composer.k(1852833062);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1852833062, i4, -1, "cz.mobilesoft.coreblock.scene.more.changelog.ChangelogFragment.RootCompose (ChangelogFragment.kt:82)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(ChangelogViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            ChangelogViewModel changelogViewModel = (ChangelogViewModel) viewModelA;
            f0((ChangelogViewState) FlowExtKt.m(changelogViewModel, composerK, 0), FlowExtKt.n(changelogViewModel, composerK, 0), composerK, (i4 << 6) & 896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.changelog.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChangelogFragment.W(this.f107044a, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
