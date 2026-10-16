package cz.mobilesoft.coreblock.scene.more.settings;

import android.content.Context;
import android.content.Intent;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public class SettingsActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f108043h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f108044i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f108045f = LazyKt.b(new Function0() { // from class: c1.e0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SettingsActivity.F0(this.f55379a);
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f108046g = LazyKt.b(new Function0() { // from class: c1.f0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Boolean.valueOf(SettingsActivity.E0(this.f55380a));
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, SettingsScreenType settingsScreenType, boolean z2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            return companion.a(context, settingsScreenType, z2);
        }

        public final Intent a(Context context, SettingsScreenType screenType, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(screenType, "screenType");
            Intent intent = new Intent(context, (Class<?>) SettingsActivity.class);
            intent.putExtra("SCREEN_TYPE", screenType);
            intent.putExtra("extra_is_trial_eligible", z2);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f108047a;

        static {
            int[] iArr = new int[SettingsScreenType.values().length];
            try {
                iArr[SettingsScreenType.OVERVIEW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsScreenType.NOTIFICATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsScreenType.STATISTICS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SettingsScreenType.BLOCKING_PREFERENCES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SettingsScreenType.PREMIUM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SettingsScreenType.TIME_NUDGE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f108047a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(SettingsActivity settingsActivity) {
        settingsActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E0(SettingsActivity settingsActivity) {
        return settingsActivity.getIntent().getBooleanExtra("extra_is_trial_eligible", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SettingsScreenType F0(SettingsActivity settingsActivity) {
        Serializable serializableExtra = settingsActivity.getIntent().getSerializableExtra("SCREEN_TYPE");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type cz.mobilesoft.coreblock.enums.SettingsScreenType");
        return (SettingsScreenType) serializableExtra;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final SettingsActivity settingsActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1993085289, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity.RootCompose.<anonymous> (SettingsActivity.kt:74)");
            }
            if (settingsActivity.B0() == SettingsScreenType.TIME_NUDGE) {
                composer.a0(-1918933598);
                boolean zI = composer.I(settingsActivity);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: c1.j0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsActivity.v0(this.f55384a);
                        }
                    };
                    composer.w(objG);
                }
                ToolbarKt.e(null, (Function0) objG, null, false, null, false, false, null, null, composer, 0, 509);
                composer.U();
            } else {
                composer.a0(-1918318899);
                String string = settingsActivity.getString(settingsActivity.B0().getTitleResId());
                boolean zI2 = composer.I(settingsActivity);
                Object objG2 = composer.G();
                if (zI2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: c1.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return SettingsActivity.w0(this.f55385a);
                        }
                    };
                    composer.w(objG2);
                }
                cz.mobilesoft.coreblock.view.compose.ToolbarKt.d(string, null, (Function0) objG2, composer, 0, 2);
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
    public static final Unit v0(SettingsActivity settingsActivity) {
        settingsActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(SettingsActivity settingsActivity) {
        settingsActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(final SettingsActivity settingsActivity, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(415096464, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity.RootCompose.<anonymous> (SettingsActivity.kt:94)");
            }
            NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composer, 0);
            Object objC0 = settingsActivity.C0();
            Modifier modifierH = PaddingKt.h(Modifier.b8, it);
            boolean zI = composer.I(settingsActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: c1.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return SettingsActivity.y0(this.f55383a, (NavGraphBuilder) obj);
                    }
                };
                composer.w(objG);
            }
            NavHostKt.u(navHostControllerB, objC0, modifierH, null, null, null, null, null, null, null, null, (Function1) objG, composer, 0, 0, 2040);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(final SettingsActivity settingsActivity, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableSingletons$SettingsActivityKt composableSingletons$SettingsActivityKt = ComposableSingletons$SettingsActivityKt.f108025a;
        Function4 function4H = composableSingletons$SettingsActivityKt.h();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavGeneralSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4H);
        Function4 function4I = composableSingletons$SettingsActivityKt.i();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavBlockingPreferences.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4I);
        Function4 function4G = composableSingletons$SettingsActivityKt.g();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavNotificationSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4G);
        Function4 function4F = composableSingletons$SettingsActivityKt.f();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavStatisticsSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4F);
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(1725748277, true, new Function4() { // from class: c1.l0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return SettingsActivity.z0(this.f55386a, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavPremiumSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        Function4 function4J = composableSingletons$SettingsActivityKt.j();
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavTimeNudgeSettings.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, function4J);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final SettingsActivity settingsActivity, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1725748277, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsActivity.kt:113)");
        }
        boolean zD0 = settingsActivity.D0();
        boolean zI = composer.I(settingsActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: c1.m0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SettingsActivity.A0(this.f55387a);
                }
            };
            composer.w(objG);
        }
        PremiumSettingsScreenKt.m(zD0, (Function0) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    public final SettingsScreenType B0() {
        return (SettingsScreenType) this.f108045f.getValue();
    }

    public final Object C0() {
        switch (WhenMappings.f108047a[B0().ordinal()]) {
            case 1:
                return NavGeneralSettings.INSTANCE;
            case 2:
                return NavNotificationSettings.INSTANCE;
            case 3:
                return NavStatisticsSettings.INSTANCE;
            case 4:
                return NavBlockingPreferences.INSTANCE;
            case 5:
                return NavPremiumSettings.INSTANCE;
            case 6:
                return NavTimeNudgeSettings.INSTANCE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final boolean D0() {
        return ((Boolean) this.f108046g.getValue()).booleanValue();
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(PaddingValues paddingValues, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        composer.a0(-1206199410);
        if (ComposerKt.M()) {
            ComposerKt.U(-1206199410, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity.RootCompose (SettingsActivity.kt:71)");
        }
        ScaffoldKt.a(null, null, ComposableLambdaKt.e(1993085289, true, new Function2() { // from class: c1.g0
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SettingsActivity.u0(this.f55381a, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(415096464, true, new Function3() { // from class: c1.h0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SettingsActivity.x0(this.f55382a, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 384, 12582912, 131067);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
    }
}
