package cz.mobilesoft.coreblock.scene.more.settings.notification;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.NotificationsActiveKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.EventShowAsType;
import cz.mobilesoft.coreblock.scene.more.settings.compose.PreferenceShimmerKt;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreenKt;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationPreference;
import cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.scope.Scope;

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
public final class NotificationSettingsScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f109973a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f109973a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(AppCompatActivity appCompatActivity) {
        GeneralSettingsScreenKt.c0(appCompatActivity, EventTimePickerDialogFragment.EventType.PAUSE_END);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(NotificationSettingsViewState notificationSettingsViewState, boolean z2, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-249075523, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:302)");
            }
            String strB = StringResources_androidKt.b(R.string.rl, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.f95797h0, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(notificationSettingsViewState.h());
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.C0(function1);
                    }
                };
                composer.w(objG);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB, strB2, null, boolValueOf, null, z2, false, (Function0) objG, 84, null);
            String strB3 = StringResources_androidKt.b(R.string.fx, composer, 0);
            String strB4 = StringResources_androidKt.b(R.string.f95825nl, composer, 0);
            NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotificationsI = notificationSettingsViewState.i();
            Boolean boolValueOf2 = showAfterQuickBlockEndBlockedNotificationsI != null ? Boolean.valueOf(showAfterQuickBlockEndBlockedNotificationsI.a()) : null;
            NotificationPreference.ShowAfterQuickBlockEndBlockedNotifications showAfterQuickBlockEndBlockedNotificationsI2 = notificationSettingsViewState.i();
            boolean z3 = showAfterQuickBlockEndBlockedNotificationsI2 != null && showAfterQuickBlockEndBlockedNotificationsI2.b() && z2;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.D0(function1);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB3, strB4, null, boolValueOf2, null, z3, false, (Function0) objG2, 84, null);
            String strB5 = StringResources_androidKt.b(R.string.Wo, composer, 0);
            String strB6 = StringResources_androidKt.b(R.string.Vo, composer, 0);
            Boolean boolValueOf3 = Boolean.valueOf(notificationSettingsViewState.m());
            boolean Z3 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.E0(function1);
                    }
                };
                composer.w(objG3);
            }
            List listListOf = CollectionsKt.listOf((Object[]) new GeneralSettingsViewState.SettingsItem[]{settingsItem, settingsItem2, new GeneralSettingsViewState.SettingsItem(strB5, strB6, null, boolValueOf3, null, z2, false, (Function0) objG3, 84, null)});
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.F0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.b0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.G0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.H0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.e0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.I0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG4 = composer.G();
            if (objG4 == Composer.f23746a.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.f0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.J0((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG4);
            }
            SectionedItemKt.f0(listListOf, function3, function32, function33, null, null, null, function34, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG4, composer, 0, 196608, 196608, 16760760);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowAfterQuickBlockEndChanged.f109978a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowAfterQuickBlockEndBlockedNotificationsChanged.f109977a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowPomodoroNotificationChanged.f109983a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String F0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1191490168);
        if (ComposerKt.M()) {
            ComposerKt.U(1191490168, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:331)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String G0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(604027897);
        if (ComposerKt.M()) {
            ComposerKt.U(604027897, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:335)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String H0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(16565626);
        if (ComposerKt.M()) {
            ComposerKt.U(16565626, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:332)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean I0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(438251301);
        if (ComposerKt.M()) {
            ComposerKt.U(438251301, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:334)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(NotificationSettingsViewState notificationSettingsViewState, boolean z2, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(614694591, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:352)");
            }
            String strB = StringResources_androidKt.b(R.string.Yo, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.Xo, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(notificationSettingsViewState.p());
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.L0(function1);
                    }
                };
                composer.w(objG);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB, strB2, null, boolValueOf, null, z2, false, (Function0) objG, 84, null);
            String strB3 = StringResources_androidKt.b(R.string.bp, composer, 0);
            String strB4 = StringResources_androidKt.b(R.string.ap, composer, 0);
            Boolean boolValueOf2 = Boolean.valueOf(notificationSettingsViewState.q());
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.M0(function1);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB3, strB4, null, boolValueOf2, null, z2, false, (Function0) objG2, 84, null);
            String strB5 = StringResources_androidKt.b(R.string.Jg, composer, 0);
            String strB6 = StringResources_androidKt.b(R.string.Zo, composer, 0);
            Boolean boolValueOf3 = Boolean.valueOf(notificationSettingsViewState.c());
            ImageVector imageVectorA = NotificationsActiveKt.a(Icons.Outlined.f15155a);
            boolean Z3 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.N0(function1);
                    }
                };
                composer.w(objG3);
            }
            List listListOf = CollectionsKt.listOf((Object[]) new GeneralSettingsViewState.SettingsItem[]{settingsItem, settingsItem2, new GeneralSettingsViewState.SettingsItem(strB5, strB6, null, boolValueOf3, imageVectorA, false, false, (Function0) objG3, 100, null)});
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.O0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.P0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.u
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.Q0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.R0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG4 = composer.G();
            if (objG4 == Composer.f23746a.a()) {
                objG4 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.w
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.S0((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG4);
            }
            SectionedItemKt.f0(listListOf, function3, function32, function33, null, null, null, function34, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG4, composer, 0, 196608, 196608, 16760760);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowUsageStatisticsNotificationChanged.f109986a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowWeeklyStatisticsReportNotificationChanged.f109987a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowDailyInsightsMotivationChanged.f109982a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String O0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(2055260282);
        if (ComposerKt.M()) {
            ComposerKt.U(2055260282, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:381)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String P0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1467798011);
        if (ComposerKt.M()) {
            ComposerKt.U(1467798011, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:385)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Q0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(880335740);
        if (ComposerKt.M()) {
            ComposerKt.U(880335740, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:382)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean R0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1302021415);
        if (ComposerKt.M()) {
            ComposerKt.U(1302021415, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:384)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(NotificationSettingsViewState notificationSettingsViewState, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-13885941, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:404)");
            }
            String strB = StringResources_androidKt.b(R.string.Mo, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(notificationSettingsViewState.r());
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.U0(function1);
                    }
                };
                composer.w(objG);
            }
            List listListOf = CollectionsKt.listOf(new GeneralSettingsViewState.SettingsItem(strB, null, null, boolValueOf, null, false, false, (Function0) objG, 118, null));
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.l
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.V0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.W0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.X0((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG2);
            }
            SectionedItemKt.f0(listListOf, function3, null, null, null, null, null, function32, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG2, composer, 0, 196608, 196608, 16760766);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnNewsletterChanged.f109975a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String V0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(135898950);
        if (ComposerKt.M()) {
            ComposerKt.U(135898950, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:413)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean W0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1444575117);
        if (ComposerKt.M()) {
            ComposerKt.U(-1444575117, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:415)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    private static final void Y(final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, NotificationSettingsViewModel notificationSettingsViewModel, Composer composer, final int i3) {
        int i4;
        final NotificationSettingsViewModel notificationSettingsViewModel2;
        Composer composerK = composer.k(1708514246);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(coroutineScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(notificationSettingsViewModel) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1708514246, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.CommandProcessor (NotificationSettingsScreen.kt:96)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(context) | composerK.I(coroutineScope) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new NotificationSettingsScreenKt$CommandProcessor$1$1(context, coroutineScope, scaffoldState, null);
                composerK.w(objG);
            }
            notificationSettingsViewModel2 = notificationSettingsViewModel;
            FlowExtKt.g(notificationSettingsViewModel2, null, (Function2) objG, composerK, (i4 >> 6) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            notificationSettingsViewModel2 = notificationSettingsViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationSettingsScreenKt.Z(coroutineScope, scaffoldState, notificationSettingsViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(PaddingValues paddingValues, NotificationSettingsViewState notificationSettingsViewState, Function1 function1, int i3, Composer composer, int i4) {
        e0(paddingValues, notificationSettingsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(CoroutineScope coroutineScope, ScaffoldState scaffoldState, NotificationSettingsViewModel notificationSettingsViewModel, int i3, Composer composer, int i4) {
        Y(coroutineScope, scaffoldState, notificationSettingsViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void a0(Composer composer, final int i3) {
        Bundle bundleB;
        Composer composerK = composer.k(2137535918);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2137535918, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsScreen (NotificationSettingsScreen.kt:59)");
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
            KClass kClassB = Reflection.b(NotificationSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            NotificationSettingsViewModel notificationSettingsViewModel = (NotificationSettingsViewModel) viewModelA;
            final NotificationSettingsViewState notificationSettingsViewState = (NotificationSettingsViewState) FlowExtKt.m(notificationSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(notificationSettingsViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), scaffoldStateG, null, null, ComposableSingletons$NotificationSettingsScreenKt.f109939a.l(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1129742384, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.b0(notificationSettingsViewState, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 24576, 12582912, 131052);
            composerK = composerK;
            boolean zI = composerK.I(coroutineScopeI) | composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.s
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.c0(coroutineScopeI, function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG2);
            }
            ComposableExtKt.j(null, (Function2) objG2, composerK, 0, 1);
            Y(coroutineScopeI, scaffoldStateG, notificationSettingsViewModel, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationSettingsScreenKt.d0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(NotificationSettingsViewState notificationSettingsViewState, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1129742384, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsScreen.<anonymous> (NotificationSettingsScreen.kt:72)");
            }
            e0(it, notificationSettingsViewState, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(CoroutineScope coroutineScope, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f109973a[event.ordinal()] == 1) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new NotificationSettingsScreenKt$NotificationSettingsScreen$2$1$1(function1, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(int i3, Composer composer, int i4) {
        a0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void e0(final PaddingValues paddingValues, final NotificationSettingsViewState notificationSettingsViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(-2146146685);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(notificationSettingsViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2146146685, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView (NotificationSettingsScreen.kt:128)");
            }
            Object objQ = composerK.q(AndroidCompositionLocals_androidKt.g());
            final AppCompatActivity appCompatActivity = objQ instanceof AppCompatActivity ? (AppCompatActivity) objQ : null;
            if (appCompatActivity == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.o0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotificationSettingsScreenKt.f0(paddingValues, notificationSettingsViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.k(PaddingKt.h(companion, paddingValues), Dp.g(16), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (notificationSettingsViewState.d() == null) {
                composerK.a0(-357618483);
                PreferenceShimmerKt.b(0.0f, 0, composerK, 0, 3);
                composerK.U();
            } else {
                composerK.a0(-356940482);
                Modifier modifierF3 = SizeKt.f(companion, 0.0f, 1, null);
                boolean zI = ((i4 & 112) == 32) | ((i4 & 896) == 256) | composerK.I(appCompatActivity);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.z0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotificationSettingsScreenKt.g0(notificationSettingsViewState, function1, appCompatActivity, (LazyListScope) obj);
                        }
                    };
                    composerK.w(objG);
                }
                LazyDslKt.b(modifierF3, null, null, false, null, null, null, false, null, (Function1) objG, composerK, 6, 510);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotificationSettingsScreenKt.Y0(paddingValues, notificationSettingsViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(PaddingValues paddingValues, NotificationSettingsViewState notificationSettingsViewState, Function1 function1, int i3, Composer composer, int i4) {
        e0(paddingValues, notificationSettingsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(final NotificationSettingsViewState notificationSettingsViewState, final Function1 function1, final AppCompatActivity appCompatActivity, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        if (notificationSettingsViewState.d().booleanValue()) {
            LazyListScope.c(LazyColumn, null, null, ComposableSingletons$NotificationSettingsScreenKt.f109939a.h(), 3, null);
        }
        final boolean z2 = !notificationSettingsViewState.d().booleanValue();
        ComposableSingletons$NotificationSettingsScreenKt composableSingletons$NotificationSettingsScreenKt = ComposableSingletons$NotificationSettingsScreenKt.f109939a;
        LazyListScope.c(LazyColumn, null, null, composableSingletons$NotificationSettingsScreenKt.j(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-1976615751, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.c1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NotificationSettingsScreenKt.h0(notificationSettingsViewState, z2, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$NotificationSettingsScreenKt.n(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-1112845637, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.d1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NotificationSettingsScreenKt.p0(notificationSettingsViewState, z2, appCompatActivity, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$NotificationSettingsScreenKt.k(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-249075523, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.e1
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NotificationSettingsScreenKt.B0(notificationSettingsViewState, z2, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$NotificationSettingsScreenKt.i(), 3, null);
        LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(614694591, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.i
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return NotificationSettingsScreenKt.K0(notificationSettingsViewState, z2, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        if (notificationSettingsViewState.s()) {
            LazyListScope.c(LazyColumn, null, null, composableSingletons$NotificationSettingsScreenKt.m(), 3, null);
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(-13885941, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.T0(notificationSettingsViewState, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(NotificationSettingsViewState notificationSettingsViewState, boolean z2, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1976615751, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:170)");
            }
            String strB = StringResources_androidKt.b(R.string.dx, composer, 0);
            String strB2 = StringResources_androidKt.b(R.string.cx, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(notificationSettingsViewState.l());
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.i0(function1);
                    }
                };
                composer.w(objG);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB, strB2, null, boolValueOf, null, z2, false, (Function0) objG, 84, null);
            String strB3 = StringResources_androidKt.b(R.string.tB, composer, 0);
            String strB4 = StringResources_androidKt.b(R.string.sB, composer, 0);
            Boolean boolValueOf2 = Boolean.valueOf(notificationSettingsViewState.n());
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.j0(function1);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB3, strB4, null, boolValueOf2, null, z2, false, (Function0) objG2, 84, null);
            if (!notificationSettingsViewState.t()) {
                settingsItem2 = null;
            }
            List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new GeneralSettingsViewState.SettingsItem[]{settingsItem, settingsItem2});
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.u0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.k0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.v0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.l0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.w0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.m0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.x0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.n0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG3 = composer.G();
            if (objG3 == Composer.f23746a.a()) {
                objG3 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.y0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.o0((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG3);
            }
            SectionedItemKt.f0(listListOfNotNull, function3, function32, function33, null, null, null, function34, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG3, composer, 0, 196608, 196608, 16760760);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowBlockedAppsChanged.f109981a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowStreakNudgeChanged.f109984a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-536050060);
        if (ComposerKt.M()) {
            ComposerKt.U(-536050060, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:190)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String l0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1123512331);
        if (ComposerKt.M()) {
            ComposerKt.U(-1123512331, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:195)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String m0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1710974602);
        if (ComposerKt.M()) {
            ComposerKt.U(-1710974602, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:191)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean n0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-1289288927);
        if (ComposerKt.M()) {
            ComposerKt.U(-1289288927, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:193)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(NotificationSettingsViewState notificationSettingsViewState, boolean z2, final AppCompatActivity appCompatActivity, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        String strB;
        String strB2;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1112845637, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:211)");
            }
            String strB3 = StringResources_androidKt.b(R.string.tl, composer, 0);
            String strB4 = StringResources_androidKt.b(R.string.g3, composer, 0);
            Integer numValueOf = Integer.valueOf(notificationSettingsViewState.e());
            String strB5 = null;
            if (numValueOf.intValue() <= 0) {
                numValueOf = null;
            }
            if (numValueOf == null) {
                composer.a0(68672751);
                composer.U();
                strB = null;
            } else {
                composer.a0(68672752);
                int iIntValue = numValueOf.intValue();
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                strB = String.format(StringResources_androidKt.b(R.string.Nj, composer, 0), Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue)}, 1));
                Intrinsics.checkNotNullExpressionValue(strB, "format(...)");
                composer.U();
            }
            if (strB == null) {
                composer.a0(2218525);
                strB = StringResources_androidKt.b(R.string.Bc, composer, 0);
                composer.U();
            } else {
                composer.a0(2213441);
                composer.U();
            }
            String str = strB;
            boolean zI = composer.I(appCompatActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.v0(appCompatActivity);
                    }
                };
                composer.w(objG);
            }
            GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB3, strB4, str, null, null, z2, false, (Function0) objG, 88, null);
            String strB6 = StringResources_androidKt.b(R.string.rl, composer, 0);
            String strB7 = StringResources_androidKt.b(R.string.f95801i0, composer, 0);
            Boolean boolValueOf = Boolean.valueOf(notificationSettingsViewState.j());
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.w0(function1);
                    }
                };
                composer.w(objG2);
            }
            GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB6, strB7, null, boolValueOf, null, z2, false, (Function0) objG2, 84, null);
            String strB8 = StringResources_androidKt.b(R.string.fx, composer, 0);
            String strB9 = StringResources_androidKt.b(R.string.ol, composer, 0);
            NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotificationsK = notificationSettingsViewState.k();
            Boolean boolValueOf2 = showAfterScheduleEndBlockedNotificationsK != null ? Boolean.valueOf(showAfterScheduleEndBlockedNotificationsK.a()) : null;
            NotificationPreference.ShowAfterScheduleEndBlockedNotifications showAfterScheduleEndBlockedNotificationsK2 = notificationSettingsViewState.k();
            boolean z3 = showAfterScheduleEndBlockedNotificationsK2 != null && showAfterScheduleEndBlockedNotificationsK2.b() && z2;
            boolean Z2 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.x0(function1);
                    }
                };
                composer.w(objG3);
            }
            GeneralSettingsViewState.SettingsItem settingsItem3 = new GeneralSettingsViewState.SettingsItem(strB8, strB9, null, boolValueOf2, null, z3, false, (Function0) objG3, 84, null);
            String strB10 = StringResources_androidKt.b(R.string.kx, composer, 0);
            String strB11 = StringResources_androidKt.b(R.string.jx, composer, 0);
            Boolean boolValueOf3 = Boolean.valueOf(notificationSettingsViewState.o());
            boolean Z3 = composer.Z(function1);
            Object objG4 = composer.G();
            if (Z3 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.y0(function1);
                    }
                };
                composer.w(objG4);
            }
            GeneralSettingsViewState.SettingsItem settingsItem4 = new GeneralSettingsViewState.SettingsItem(strB10, strB11, null, boolValueOf3, null, z2, false, (Function0) objG4, 84, null);
            String strB12 = StringResources_androidKt.b(R.string.Oo, composer, 0);
            String strB13 = StringResources_androidKt.b(R.string.No, composer, 0);
            NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEndG = notificationSettingsViewState.g();
            if (notificationBeforeUsageLimitEndG == null || notificationBeforeUsageLimitEndG.a() != 0) {
                composer.a0(71750277);
                NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEndG2 = notificationSettingsViewState.g();
                String strB14 = StringResources_androidKt.b((notificationBeforeUsageLimitEndG2 != null ? notificationBeforeUsageLimitEndG2.b() : null) == EventShowAsType.NOTIFICATION ? R.string.CF : R.string.DF, composer, 0);
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.f140150a;
                String strB15 = StringResources_androidKt.b(R.string.Nj, composer, 0);
                NotificationPreference.NotificationBeforeUsageLimitEnd notificationBeforeUsageLimitEndG3 = notificationSettingsViewState.g();
                String str2 = String.format(strB15, Arrays.copyOf(new Object[]{notificationBeforeUsageLimitEndG3 != null ? Integer.valueOf(notificationBeforeUsageLimitEndG3.a()) : null}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                strB2 = MessageFormat.format("{0}, {1}", strB14, str2);
                composer.U();
            } else {
                composer.a0(71608917);
                strB2 = StringResources_androidKt.b(R.string.Bc, composer, 0);
                composer.U();
            }
            String str3 = strB2;
            boolean zI2 = composer.I(appCompatActivity);
            Object objG5 = composer.G();
            if (zI2 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.l0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.z0(appCompatActivity);
                    }
                };
                composer.w(objG5);
            }
            GeneralSettingsViewState.SettingsItem settingsItem5 = new GeneralSettingsViewState.SettingsItem(strB12, strB13, str3, null, null, z2, false, (Function0) objG5, 88, null);
            String strB16 = StringResources_androidKt.b(R.string.sl, composer, 0);
            String strB17 = StringResources_androidKt.b(R.string.f3, composer, 0);
            Integer numValueOf2 = Integer.valueOf(notificationSettingsViewState.f());
            if (numValueOf2.intValue() <= 0) {
                numValueOf2 = null;
            }
            if (numValueOf2 == null) {
                composer.a0(73247855);
                composer.U();
            } else {
                composer.a0(73247856);
                int iIntValue2 = numValueOf2.intValue();
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.f140150a;
                String str4 = String.format(StringResources_androidKt.b(R.string.Nj, composer, 0), Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue2)}, 1));
                Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                composer.U();
                strB5 = str4;
            }
            if (strB5 == null) {
                composer.a0(2366109);
                strB5 = StringResources_androidKt.b(R.string.Bc, composer, 0);
                composer.U();
            } else {
                composer.a0(2361180);
                composer.U();
            }
            String str5 = strB5;
            boolean zI3 = composer.I(appCompatActivity);
            Object objG6 = composer.G();
            if (zI3 || objG6 == Composer.f23746a.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotificationSettingsScreenKt.A0(appCompatActivity);
                    }
                };
                composer.w(objG6);
            }
            List listListOf = CollectionsKt.listOf((Object[]) new GeneralSettingsViewState.SettingsItem[]{settingsItem, settingsItem2, settingsItem3, settingsItem4, settingsItem5, new GeneralSettingsViewState.SettingsItem(strB16, strB17, str5, null, null, z2, false, (Function0) objG6, 88, null)});
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.n0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.q0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.p0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.r0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.q0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.s0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.r0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotificationSettingsScreenKt.t0((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Object objG7 = composer.G();
            if (objG7 == Composer.f23746a.a()) {
                objG7 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.notification.h0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotificationSettingsScreenKt.u0((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG7);
            }
            SectionedItemKt.f0(listListOf, function3, function32, function33, null, null, null, function34, null, null, null, null, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG7, composer, 0, 196608, 196608, 16760760);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composer, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String q0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(327720054);
        if (ComposerKt.M()) {
            ComposerKt.U(327720054, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:281)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String r0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-259742217);
        if (ComposerKt.M()) {
            ComposerKt.U(-259742217, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:285)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String s0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-847204488);
        if (ComposerKt.M()) {
            ComposerKt.U(-847204488, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:282)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean t0(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-425518813);
        if (ComposerKt.M()) {
            ComposerKt.U(-425518813, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.notification.NotificationSettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (NotificationSettingsScreen.kt:284)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(AppCompatActivity appCompatActivity) {
        GeneralSettingsScreenKt.c0(appCompatActivity, EventTimePickerDialogFragment.EventType.INTERVAL_START);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowAfterScheduleEndChanged.f109980a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowAfterScheduleEndBlockedNotificationsChanged.f109979a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1) {
        function1.invoke(NotificationSettingsViewEvent.OnShowUsageLimitChanged.f109985a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(AppCompatActivity appCompatActivity) {
        GeneralSettingsScreenKt.c0(appCompatActivity, EventTimePickerDialogFragment.EventType.USAGE_LIMIT_END);
        return Unit.f139807a;
    }
}
