package cz.mobilesoft.coreblock.scene.more.notifications;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.activity.EdgeToEdge;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.paging.compose.LazyPagingItems;
import androidx.paging.compose.LazyPagingItemsKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.AdsBaseActivity;
import cz.mobilesoft.coreblock.databinding.ActivityComposeAdBannerBinding;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsViewEvent;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.BlockedNotification;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.constants.AdUnitId;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.util.view.GradientUtils;
import cz.mobilesoft.coreblock.util.view.ViewHelper;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ImmutableList;
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
public final class BlockedNotificationsActivity extends AdsBaseActivity<ActivityComposeAdBannerBinding> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f107859o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f107860p = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AdUnitId f107861n = AdUnitId.PROFILE_LIST_BANNER;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) BlockedNotificationsActivity.class);
        }

        private Companion() {
        }
    }

    private final void R0(final MutableState mutableState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2005149755);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(mutableState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2005149755, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.ConfirmDeleteDialog (BlockedNotificationsActivity.kt:422)");
            }
            String strB = StringResources_androidKt.b(R.string.M7, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.L7, composerK, 0);
            String strB3 = StringResources_androidKt.b(R.string.K7, composerK, 0);
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockedNotificationsActivity.S0(function1);
                    }
                };
                composerK.w(objG);
            }
            ComposeDialogsKt.x0(mutableState, strB, strB2, null, strB3, 0L, false, (Function0) objG, null, 0L, null, composerK, i4 & 14, 0, 1896);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.T0(this.f107908a, mutableState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Function1 function1) {
        function1.invoke(BlockedNotificationsViewEvent.OnClearConfirmed.f107863a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(BlockedNotificationsActivity blockedNotificationsActivity, MutableState mutableState, Function1 function1, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.R0(mutableState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(BlockedNotificationsActivity blockedNotificationsActivity, PaddingValues paddingValues, AppIconCache appIconCache, BlockedNotificationsViewState blockedNotificationsViewState, LazyPagingItems lazyPagingItems, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        blockedNotificationsActivity.U0(paddingValues, appIconCache, blockedNotificationsViewState, lazyPagingItems, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(BlockedNotificationsActivity blockedNotificationsActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.W0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void Y0(final PaddingValues paddingValues, final AppIconCache appIconCache, final DateFormat dateFormat, final ImmutableList immutableList, final int i3, Composer composer, final int i4) throws XmlPullParserException, IOException {
        int i5;
        AppIconCache appIconCache2;
        DateFormat dateFormat2;
        ImmutableList immutableList2;
        Composer composerK = composer.k(-2015122831);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(paddingValues) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            appIconCache2 = appIconCache;
            i5 |= composerK.Z(appIconCache2) ? 32 : 16;
        } else {
            appIconCache2 = appIconCache;
        }
        if ((i4 & 384) == 0) {
            dateFormat2 = dateFormat;
            i5 |= composerK.I(dateFormat2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            dateFormat2 = dateFormat;
        }
        if ((i4 & 3072) == 0) {
            immutableList2 = immutableList;
            i5 |= composerK.Z(immutableList2) ? 2048 : 1024;
        } else {
            immutableList2 = immutableList;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.e(i3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i6 = i5;
        if (composerK.r((74899 & i6) != 74898, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2015122831, i6, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.LimitedItemsList (BlockedNotificationsActivity.kt:233)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierG = ScrollKt.g(PaddingKt.h(SizeKt.f(Modifier.b8, 0.0f, 1, null), paddingValues), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            composerK.a0(-1849291206);
            Iterator<E> it = immutableList2.iterator();
            while (it.hasNext()) {
                b1(appIconCache2, dateFormat2, (BlockedNotificationWithApplication) it.next(), composerK, ((i6 >> 3) & 126) | ((i6 >> 6) & 7168));
                appIconCache2 = appIconCache;
                dateFormat2 = dateFormat;
            }
            composerK.U();
            int size = i3 - immutableList2.size();
            if (size > 0) {
                composerK.a0(-1493183642);
                PremiumFeature premiumFeature = PremiumFeature.NOTIFICATIONS_UNLIMITED;
                String strT = ComposableExtKt.t(R.plurals.f95742c, size, new Object[]{Integer.valueOf(size)}, composerK, 0);
                Modifier modifierJ = PaddingKt.j(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), Dp.g(16));
                boolean zI = composerK.I(context) | composerK.I(this);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlockedNotificationsActivity.Z0(context, this);
                        }
                    };
                    composerK.w(objG);
                }
                ComposeCardsKt.s(modifierJ, premiumFeature, false, null, 0L, 0L, false, false, false, null, strT, null, false, null, false, (Function0) objG, composerK, 48, 0, 31740);
            } else {
                composerK.a0(-1503061017);
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.a1(this.f107890a, paddingValues, appIconCache, dateFormat, immutableList, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Context context, BlockedNotificationsActivity blockedNotificationsActivity) {
        blockedNotificationsActivity.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.NOTIFICATIONS_UNLIMITED), "blocked_notifications_screen", "blocked_notifications_screen", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(BlockedNotificationsActivity blockedNotificationsActivity, PaddingValues paddingValues, AppIconCache appIconCache, DateFormat dateFormat, ImmutableList immutableList, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        blockedNotificationsActivity.Y0(paddingValues, appIconCache, dateFormat, immutableList, i3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0445  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0456  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x04b8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x053f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b1(final cz.mobilesoft.coreblock.util.view.AppIconCache r69, final java.text.DateFormat r70, final cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication r71, androidx.compose.runtime.Composer r72, final int r73) {
        /*
            Method dump skipped, instruction units count: 1369
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.b1(cz.mobilesoft.coreblock.util.view.AppIconCache, java.text.DateFormat, cz.mobilesoft.coreblock.storage.room.dto.blocking.BlockedNotificationWithApplication, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier c1(final BlockedNotificationWithApplication blockedNotificationWithApplication, final BlockedNotificationsActivity blockedNotificationsActivity, final Context context, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return ClickableKt.f(applyIf, false, null, null, new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BlockedNotificationsActivity.d1(blockedNotificationWithApplication, blockedNotificationsActivity, context);
            }
        }, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(BlockedNotificationWithApplication blockedNotificationWithApplication, BlockedNotificationsActivity blockedNotificationsActivity, Context context) {
        String strD;
        Application applicationA = blockedNotificationWithApplication.a();
        if (applicationA != null && (strD = applicationA.d()) != null) {
            blockedNotificationsActivity.y1(context, strD);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(BlockedNotificationsActivity blockedNotificationsActivity, AppIconCache appIconCache, DateFormat dateFormat, BlockedNotificationWithApplication blockedNotificationWithApplication, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.b1(appIconCache, dateFormat, blockedNotificationWithApplication, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void f1(final PaddingValues paddingValues, final AppIconCache appIconCache, final Shimmer shimmer, final DateFormat dateFormat, final LazyPagingItems lazyPagingItems, Composer composer, final int i3) {
        int i4;
        AppIconCache appIconCache2;
        Composer composer2;
        Composer composerK = composer.k(-2051789698);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            appIconCache2 = appIconCache;
            i4 |= composerK.Z(appIconCache2) ? 32 : 16;
        } else {
            appIconCache2 = appIconCache;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(shimmer) : composerK.I(shimmer) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(dateFormat) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= (i3 & 32768) == 0 ? composerK.Z(lazyPagingItems) : composerK.I(lazyPagingItems) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        boolean z2 = false;
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2051789698, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.PagedItemsList (BlockedNotificationsActivity.kt:274)");
            }
            Modifier modifierH = PaddingKt.h(SizeKt.f(Modifier.b8, 0.0f, 1, null), paddingValues);
            boolean zI = ((57344 & i4) == 16384 || ((i4 & 32768) != 0 && composerK.I(lazyPagingItems))) | composerK.I(this) | ((i4 & 112) == 32) | composerK.I(dateFormat);
            if ((i4 & 896) == 256 || ((i4 & 512) != 0 && composerK.I(shimmer))) {
                z2 = true;
            }
            boolean z3 = zI | z2;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                final AppIconCache appIconCache3 = appIconCache2;
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlockedNotificationsActivity.g1(lazyPagingItems, this, appIconCache3, dateFormat, shimmer, (LazyListScope) obj);
                    }
                };
                composerK.w(function1);
                objG = function1;
            }
            composer2 = composerK;
            LazyDslKt.b(modifierH, null, null, false, null, null, null, false, null, (Function1) objG, composer2, 0, 510);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.k1(this.f107951a, paddingValues, appIconCache, shimmer, dateFormat, lazyPagingItems, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(final LazyPagingItems lazyPagingItems, final BlockedNotificationsActivity blockedNotificationsActivity, final AppIconCache appIconCache, final DateFormat dateFormat, final Shimmer shimmer, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyColumn.h(lazyPagingItems.g(), new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationsActivity.h1(lazyPagingItems, ((Integer) obj).intValue());
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockedNotificationsActivity.i1(((Integer) obj).intValue());
            }
        }, ComposableLambdaKt.c(494652704, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.m
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BlockedNotificationsActivity.j1(lazyPagingItems, blockedNotificationsActivity, appIconCache, dateFormat, shimmer, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object h1(LazyPagingItems lazyPagingItems, int i3) {
        BlockedNotification blockedNotificationB;
        BlockedNotificationWithApplication blockedNotificationWithApplication = (BlockedNotificationWithApplication) lazyPagingItems.f(i3);
        if (blockedNotificationWithApplication == null || (blockedNotificationB = blockedNotificationWithApplication.b()) == null) {
            return -1;
        }
        return Long.valueOf(blockedNotificationB.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i1(int i3) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(LazyPagingItems lazyPagingItems, BlockedNotificationsActivity blockedNotificationsActivity, AppIconCache appIconCache, DateFormat dateFormat, Shimmer shimmer, LazyItemScope items, int i3, Composer composer, int i4) {
        int i5;
        Unit unit;
        Intrinsics.checkNotNullParameter(items, "$this$items");
        if ((i4 & 6) == 0) {
            i5 = (composer.Z(items) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composer.e(i3) ? 32 : 16;
        }
        if (composer.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(494652704, i5, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.PagedItemsList.<anonymous>.<anonymous>.<anonymous> (BlockedNotificationsActivity.kt:285)");
            }
            BlockedNotificationWithApplication blockedNotificationWithApplication = (BlockedNotificationWithApplication) lazyPagingItems.f(i3);
            if (blockedNotificationWithApplication == null) {
                composer.a0(165963935);
                composer.U();
                unit = null;
            } else {
                composer.a0(165963936);
                blockedNotificationsActivity.b1(appIconCache, dateFormat, blockedNotificationWithApplication, composer, 0);
                composer.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composer.a0(166065492);
                SchedulesSectionKt.r(shimmer, composer, Shimmer.f93784d, 0);
                composer.U();
            } else {
                composer.a0(-1380119966);
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(BlockedNotificationsActivity blockedNotificationsActivity, PaddingValues paddingValues, AppIconCache appIconCache, Shimmer shimmer, DateFormat dateFormat, LazyPagingItems lazyPagingItems, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.f1(paddingValues, appIconCache, shimmer, dateFormat, lazyPagingItems, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void l1(Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Composer composerK = composer.k(1100424902);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(this) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1100424902, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.RootCompose (BlockedNotificationsActivity.kt:115)");
            }
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
            KClass kClassB = Reflection.b(BlockedNotificationsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            BlockedNotificationsViewModel blockedNotificationsViewModel = (BlockedNotificationsViewModel) viewModelA;
            final AppIconCache appIconCacheY0 = blockedNotificationsViewModel.Y0();
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            final BlockedNotificationsViewState blockedNotificationsViewState = (BlockedNotificationsViewState) FlowExtKt.m(blockedNotificationsViewModel, composerK, 0);
            final LazyPagingItems lazyPagingItemsB = LazyPagingItemsKt.b(blockedNotificationsViewModel.a1(), null, composerK, 0, 1);
            final Function1 function1N = FlowExtKt.n(blockedNotificationsViewModel, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), scaffoldStateG, ComposableLambdaKt.e(-1433450847, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.m1(this.f107931a, function1N, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, ComposableSingletons$BlockedNotificationsActivityKt.f107884a.e(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1691884088, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockedNotificationsActivity.o1(this.f107933a, appIconCacheY0, blockedNotificationsViewState, lazyPagingItemsB, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 24960, 12582912, 131048);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.p1(this.f107937a, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(final BlockedNotificationsActivity blockedNotificationsActivity, Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1433450847, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.RootCompose.<anonymous> (BlockedNotificationsActivity.kt:132)");
            }
            boolean zI = composer.I(blockedNotificationsActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockedNotificationsActivity.n1(this.f107939a);
                    }
                };
                composer.w(objG);
            }
            blockedNotificationsActivity.q1((Function0) objG, function1, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(BlockedNotificationsActivity blockedNotificationsActivity) {
        blockedNotificationsActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(BlockedNotificationsActivity blockedNotificationsActivity, AppIconCache appIconCache, BlockedNotificationsViewState blockedNotificationsViewState, LazyPagingItems lazyPagingItems, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1691884088, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.RootCompose.<anonymous> (BlockedNotificationsActivity.kt:140)");
            }
            blockedNotificationsActivity.U0(it, appIconCache, blockedNotificationsViewState, lazyPagingItems, composer, (i3 & 14) | (LazyPagingItems.f50756f << 9));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(BlockedNotificationsActivity blockedNotificationsActivity, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.l1(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void q1(final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1222577514);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1222577514, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.Toolbar (BlockedNotificationsActivity.kt:151)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            int i5 = i4;
            AppBarKt.g(ComposableSingletons$BlockedNotificationsActivityKt.f107884a.f(), null, ComposableLambdaKt.e(-550706588, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.r1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(187056603, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockedNotificationsActivity.s1(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), ComposeColorsKt.j(composerK, 0).e(), 0L, Dp.g(0), composerK, 1576326, 34);
            R0(mutableState, function1, composerK, (i5 & 896) | (i5 & 112) | 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.u1(this.f107900a, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-550706588, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.Toolbar.<anonymous> (BlockedNotificationsActivity.kt:164)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composer, 0).b(), StringResources_androidKt.b(R.string.N7, composer, 0), function0, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(final MutableState mutableState, RowScope TopAppBar, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(187056603, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.Toolbar.<anonymous> (BlockedNotificationsActivity.kt:172)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.B1, composer, 6);
            long jO = ComposeColorsKt.j(composer, 0).O();
            String strB = StringResources_androidKt.b(R.string.K7, composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockedNotificationsActivity.t1(mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, jO, strB, (Function0) objG, composer, 100663296, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(BlockedNotificationsActivity blockedNotificationsActivity, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        blockedNotificationsActivity.q1(function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(final BlockedNotificationsActivity blockedNotificationsActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(576964199, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.initViews.<anonymous> (BlockedNotificationsActivity.kt:108)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(321240216, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.x1(this.f107914a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(BlockedNotificationsActivity blockedNotificationsActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(321240216, i3, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.initViews.<anonymous>.<anonymous> (BlockedNotificationsActivity.kt:109)");
            }
            blockedNotificationsActivity.l1(composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private final void y1(Context context, String str) {
        try {
            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str));
        } catch (Throwable unused) {
        }
    }

    public final void U0(final PaddingValues paddingValues, final AppIconCache appIconCache, final BlockedNotificationsViewState viewState, final LazyPagingItems pagedItems, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(appIconCache, "appIconCache");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(pagedItems, "pagedItems");
        Composer composerK = composer.k(-706195722);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(appIconCache) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(viewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(pagedItems) : composerK.I(pagedItems) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-706195722, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.Content (BlockedNotificationsActivity.kt:194)");
            }
            Shimmer shimmerA = ShimmerThemeKt.a(null, composerK, 0, 1);
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = DateHelperExtKt.i(context, true, true);
                composerK.w(objG);
            }
            DateFormat dateFormat = (DateFormat) objG;
            if (pagedItems.g() == 0) {
                composerK.a0(-1526402271);
                W0(paddingValues, composerK, (i4 & 14) | ((i4 >> 9) & 112));
                composerK.U();
            } else if (viewState.d()) {
                composerK.a0(-1526278488);
                int i5 = (i4 & 126) | (Shimmer.f93784d << 6) | (LazyPagingItems.f50756f << 12);
                int i6 = i4 << 3;
                f1(paddingValues, appIconCache, shimmerA, dateFormat, pagedItems, composerK, i5 | (57344 & i6) | (i6 & 458752));
                composerK.U();
            } else {
                composerK.a0(-1525935690);
                Y0(paddingValues, appIconCache, dateFormat, viewState.c(), pagedItems.g(), composerK, (i4 & 126) | ((i4 << 3) & 458752));
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.V0(this.f107940a, paddingValues, appIconCache, viewState, pagedItems, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public final void W0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1809304933);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1809304933, i4, -1, "cz.mobilesoft.coreblock.scene.more.notifications.BlockedNotificationsActivity.EmptyContent (BlockedNotificationsActivity.kt:296)");
            }
            ComposeCardsKt.m(PaddingKt.k(PaddingKt.h(SizeKt.h(Modifier.b8, 0.0f, 1, null), paddingValues), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), CardType.Dashed.f130352f, null, ComposableSingletons$BlockedNotificationsActivityKt.f107884a.d(), composerK, 3504, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockedNotificationsActivity.X0(this.f107904a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    protected AdUnitId b0() {
        return this.f107861n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        EdgeToEdge.b(this, null, null, 3, null);
        if (ViewHelper.e(this)) {
            return;
        }
        GradientUtils.a(this);
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public void l0(ActivityComposeAdBannerBinding binding, Bundle bundle) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.l0(binding, bundle);
        binding.f96454c.setContent(ComposableLambdaKt.c(576964199, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.notifications.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BlockedNotificationsActivity.w1(this.f107888a, (Composer) obj, ((Integer) obj2).intValue());
            }
        }));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseAdsBaseActivity
    /* JADX INFO: renamed from: z1, reason: merged with bridge method [inline-methods] */
    public ActivityComposeAdBannerBinding o0(LayoutInflater inflater) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        ActivityComposeAdBannerBinding activityComposeAdBannerBindingC = ActivityComposeAdBannerBinding.c(inflater);
        Intrinsics.checkNotNullExpressionValue(activityComposeAdBannerBindingC, "inflate(...)");
        return activityComposeAdBannerBindingC;
    }
}
