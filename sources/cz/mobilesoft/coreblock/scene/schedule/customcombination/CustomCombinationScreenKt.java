package cz.mobilesoft.coreblock.scene.schedule.customcombination;

import androidx.activity.result.ActivityResult;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.launchcount.LaunchCountConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.SharedLocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LaunchCountConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.WifiConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.usagelimit.UsageLimitConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.SharedWifiConditionEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.wifi.WifiConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerState;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.threeten.bp.DayOfWeek;

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
public final class CustomCombinationScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f116259b;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f116258a = iArr;
            int[] iArr2 = new int[ProfileType.values().length];
            try {
                iArr2[ProfileType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ProfileType.USAGE_LIMIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ProfileType.LAUNCH_COUNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ProfileType.WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ProfileType.LOCATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            f116259b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(CustomCombinationViewState customCombinationViewState, boolean z2, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1310107736, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomCombinationScreen.kt:337)");
        }
        LocationConfigurationViewState locationConfigurationViewStateE = customCombinationViewState.e();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.i0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomCombinationScreenKt.B0(function1, (LocationConditionViewEvent) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.j0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomCombinationScreenKt.C0(navHostController);
                }
            };
            composer.w(objG2);
        }
        LocationConditionScreenKt.u0(locationConfigurationViewStateE, z2, false, false, null, false, function12, (Function0) objG2, composer, 196608, 28);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, LocationConditionViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(NavHostController navHostController) {
        NavController.O(navHostController, CustomCombinationScreenNavigation.CustomCombination.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(ScaffoldState scaffoldState, NavHostController navHostController, CustomCombinationViewState customCombinationViewState, boolean z2, boolean z3, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        s0(scaffoldState, navHostController, customCombinationViewState, z2, z3, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void E0(final java.lang.String r33, final boolean r34, boolean r35, final kotlin.jvm.functions.Function1 r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt.E0(java.lang.String, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(String str, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        E0(str, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void N(final kotlinx.coroutines.CoroutineScope r19, final androidx.navigation.NavHostController r20, final androidx.compose.material.ScaffoldState r21, final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.CombinationDTO r22, final boolean r23, final cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel r24, final kotlin.jvm.functions.Function1 r25, final kotlin.jvm.functions.Function1 r26, final kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt.N(kotlinx.coroutines.CoroutineScope, androidx.navigation.NavHostController, androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$CombinationDTO, boolean, cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewModel, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.COMBINED, z2);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() != -1) {
            function1.invoke(CustomCombinationViewEvent.OnWifiPermissionDeclined.f116280a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function0 function0, Map it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.isEmpty()) {
            function0.invoke();
        } else {
            Iterator it2 = it.entrySet().iterator();
            while (it2.hasNext()) {
                if (((Boolean) ((Map.Entry) it2.next()).getValue()).booleanValue()) {
                    break;
                }
            }
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            function1.invoke(new CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.OnLocationServicesEnabled.f115991a)));
        } else {
            function1.invoke(CustomCombinationViewEvent.OnPermissionsDenied.f116278a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(CoroutineScope coroutineScope, NavHostController navHostController, ScaffoldState scaffoldState, ConditionDTO.CombinationDTO combinationDTO, boolean z2, CustomCombinationViewModel customCombinationViewModel, Function1 function1, Function1 function12, Function0 function0, int i3, Composer composer, int i4) {
        N(coroutineScope, navHostController, scaffoldState, combinationDTO, z2, customCombinationViewModel, function1, function12, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void T(final ProfileType profileType, final CustomCombinationViewState customCombinationViewState, final Function1 function1, final Function1 function12, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1995674963);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(profileType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(customCombinationViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function12) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1995674963, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.ConditionContent (CustomCombinationScreen.kt:411)");
            }
            int i5 = WhenMappings.f116259b[profileType.ordinal()];
            if (i5 == 1) {
                composerK.a0(-2079151218);
                TimeConditionConfigurationViewState timeConditionConfigurationViewStateG = customCombinationViewState.g();
                Configuration configurationF = timeConditionConfigurationViewStateG.f();
                boolean zI = timeConditionConfigurationViewStateG.i();
                boolean zM = timeConditionConfigurationViewStateG.m();
                int i6 = i4 & 896;
                boolean z2 = i6 == 256;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CustomCombinationScreenKt.U(function1);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                boolean z3 = i6 == 256;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.h
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.V(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerK.w(objG2);
                }
                Function1 function13 = (Function1) objG2;
                boolean z4 = i6 == 256;
                Object objG3 = composerK.G();
                if (z4 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.i
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.Y(function1, (IntervalDTO) obj);
                        }
                    };
                    composerK.w(objG3);
                }
                Function1 function14 = (Function1) objG3;
                boolean z5 = i6 == 256;
                Object objG4 = composerK.G();
                if (z5 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.j
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.Z(function1, (IntervalDTO) obj);
                        }
                    };
                    composerK.w(objG4);
                }
                BaseConditionScreenKt.R0(configurationF, zI, zM, function0, function13, function14, (Function1) objG4, composerK, 0, 0);
                composerK = composerK;
                Configuration configurationF2 = timeConditionConfigurationViewStateG.f();
                boolean zH = timeConditionConfigurationViewStateG.h();
                boolean z6 = i6 == 256;
                Object objG5 = composerK.G();
                if (z6 || objG5 == Composer.f23746a.a()) {
                    objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.k
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CustomCombinationScreenKt.a0(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                        }
                    };
                    composerK.w(objG5);
                }
                BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG5, composerK, 0, 0);
                composerK.U();
            } else if (i5 == 2) {
                composerK.a0(-2077446125);
                boolean zK = customCombinationViewState.h().k();
                UsageLimit.PeriodType periodTypeH = customCombinationViewState.h().h();
                TimePickerState timePickerStateI = customCombinationViewState.h().i();
                int i7 = i4 & 896;
                boolean z7 = i7 == 256;
                Object objG6 = composerK.G();
                if (z7 || objG6 == Composer.f23746a.a()) {
                    objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.m
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.b0(function1, (UsageLimit.PeriodType) obj);
                        }
                    };
                    composerK.w(objG6);
                }
                Function1 function15 = (Function1) objG6;
                boolean z8 = i7 == 256;
                Object objG7 = composerK.G();
                if (z8 || objG7 == Composer.f23746a.a()) {
                    objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.c0(function1, (TimePickerState) obj);
                        }
                    };
                    composerK.w(objG7);
                }
                UsageLimitConditionScreenKt.V(timePickerStateI, zK, periodTypeH, function15, (Function1) objG7, composerK, 0);
                composerK = composerK;
                composerK.U();
            } else if (i5 == 3) {
                composerK.a0(-2076616069);
                LaunchCountConditionConfigurationViewState launchCountConditionConfigurationViewStateD = customCombinationViewState.d();
                int i8 = i4 & 896;
                boolean z9 = i8 == 256;
                Object objG8 = composerK.G();
                if (z9 || objG8 == Composer.f23746a.a()) {
                    objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.d0(function1, (UsageLimit.PeriodType) obj);
                        }
                    };
                    composerK.w(objG8);
                }
                Function1 function16 = (Function1) objG8;
                boolean z10 = i8 == 256;
                Object objG9 = composerK.G();
                if (z10 || objG9 == Composer.f23746a.a()) {
                    objG9 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.p
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CustomCombinationScreenKt.e0(function1, ((Integer) obj).intValue());
                        }
                    };
                    composerK.w(objG9);
                }
                LaunchCountConditionScreenKt.R(launchCountConditionConfigurationViewStateD, function16, (Function1) objG9, composerK, 0);
                composerK.U();
            } else if (i5 == 4) {
                composerK.a0(-2075993744);
                int size = customCombinationViewState.j().k().size();
                boolean z11 = ((i4 & 7168) == 2048) | ((i4 & 14) == 4);
                Object objG10 = composerK.G();
                if (z11 || objG10 == Composer.f23746a.a()) {
                    objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CustomCombinationScreenKt.f0(function12, profileType);
                        }
                    };
                    composerK.w(objG10);
                }
                WifiConditionScreenKt.O0(false, (Function0) objG10, size, composerK, 0, 1);
                composerK.U();
            } else if (i5 != 5) {
                composerK.a0(-2075485747);
                composerK.U();
            } else {
                composerK.a0(-2075729469);
                LocationConfigurationViewState locationConfigurationViewStateE = customCombinationViewState.e();
                boolean z12 = ((i4 & 7168) == 2048) | ((i4 & 14) == 4);
                Object objG11 = composerK.G();
                if (z12 || objG11 == Composer.f23746a.a()) {
                    objG11 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return CustomCombinationScreenKt.W(function12, profileType);
                        }
                    };
                    composerK.w(objG11);
                }
                LocationConditionScreenKt.r0(locationConfigurationViewStateE, (Function0) objG11, composerK, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomCombinationScreenKt.X(profileType, customCombinationViewState, function1, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1) {
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(TimeConditionViewEvent.OnAddIntervalClicked.f115749a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1, boolean z2) {
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1, ProfileType profileType) {
        function1.invoke(profileType);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(ProfileType profileType, CustomCombinationViewState customCombinationViewState, Function1 function1, Function1 function12, int i3, Composer composer, int i4) {
        T(profileType, customCombinationViewState, function1, function12, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1, UsageLimit.PeriodType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationUsageLimitConditionViewEvent(new UsageLimitConditionViewEvent.OnPeriodTypeChanged(it)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Function1 function1, TimePickerState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationUsageLimitConditionViewEvent(new UsageLimitConditionViewEvent.OnTimePickerStateChanged(it)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(Function1 function1, UsageLimit.PeriodType it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationLaunchCountConditionViewEvent(new LaunchCountConditionViewEvent.OnPeriodTypeChanged(it)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Function1 function1, int i3) {
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationLaunchCountConditionViewEvent(new LaunchCountConditionViewEvent.OnLaunchCountChanged(i3)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1, ProfileType profileType) {
        function1.invoke(profileType);
        return Unit.f139807a;
    }

    private static final void g0(final ColumnScope columnScope, final CustomCombinationViewState customCombinationViewState, final Function1 function1, Composer composer, final int i3) {
        ProfileType profileType;
        float f3;
        float f4;
        int i4;
        int i5;
        Composer composerK = composer.k(1292644782);
        int i6 = (i3 & 48) == 0 ? (composerK.Z(customCombinationViewState) ? 32 : 16) | i3 : i3;
        if ((i3 & 384) == 0) {
            i6 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i7 = i6;
        int i8 = 1;
        if (composerK.r((i7 & 145) != 144, i7 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1292644782, i7, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.Content (CustomCombinationScreen.kt:356)");
            }
            float f5 = 0.0f;
            float f6 = 8;
            float f7 = 1;
            int i9 = 0;
            DividerKt.b(SizeKt.h(PaddingKt.k(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(f6), 1, null), 0.0f, 1, null), Dp.g(f7), ComposeColorsKt.j(composerK, 0).u(), composerK, 48, 0);
            composerK.a0(986103428);
            for (final ProfileType profileType2 : customCombinationViewState.c()) {
                Integer titleResId = profileType2.getTitleResId();
                if (titleResId == null) {
                    composerK.a0(985809839);
                    composerK.U();
                    profileType = profileType2;
                } else {
                    composerK.a0(985809840);
                    String strB = StringResources_androidKt.b(titleResId.intValue(), composerK, i9);
                    boolean zContains = customCombinationViewState.f().contains(profileType2);
                    boolean zN = customCombinationViewState.n(profileType2);
                    int i10 = ((i7 & 896) == 256 ? i8 : i9) | (composerK.e(profileType2.ordinal()) ? 1 : 0);
                    Object objG = composerK.G();
                    if (i10 != 0 || objG == Composer.f23746a.a()) {
                        objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.m0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CustomCombinationScreenKt.h0(function1, profileType2, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerK.w(objG);
                    }
                    profileType = profileType2;
                    E0(strB, zContains, zN, (Function1) objG, composerK, 0, 0);
                    composerK.U();
                }
                if (customCombinationViewState.l(profileType)) {
                    composerK.a0(986231564);
                    int i11 = (i7 & 896) == 256 ? i8 : 0;
                    Object objG2 = composerK.G();
                    if (i11 != 0 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.b
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return CustomCombinationScreenKt.i0(function1, (ProfileType) obj);
                            }
                        };
                        composerK.w(objG2);
                    }
                    f3 = f6;
                    i5 = 0;
                    i4 = i8;
                    f4 = f5;
                    T(profileType, customCombinationViewState, function1, (Function1) objG2, composerK, i7 & 1008);
                } else {
                    f3 = f6;
                    f4 = f5;
                    i4 = i8;
                    i5 = 0;
                    composerK.a0(968904672);
                }
                composerK.U();
                i9 = i5;
                DividerKt.b(SizeKt.h(PaddingKt.k(PaddingKt.k(Modifier.b8, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, i5), f4, 2, null), f4, Dp.g(f3), i4, null), f4, i4, null), Dp.g(f7), ComposeColorsKt.j(composerK, i5).u(), composerK, 48, 0);
                i8 = i4;
                f6 = f3;
                f5 = 0.0f;
            }
            composerK.U();
            if (customCombinationViewState.f().size() < 2) {
                composerK.a0(505615275);
                BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.UE, composerK, i9), composerK, i9);
            } else {
                composerK.a0(487561588);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomCombinationScreenKt.j0(columnScope, customCombinationViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Function1 function1, ProfileType profileType, boolean z2) {
        function1.invoke(new CustomCombinationViewEvent.OnConditionChecked(profileType, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Function1 function1, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(profileType, "profileType");
        function1.invoke(new CustomCombinationViewEvent.OpenCondition(profileType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(ColumnScope columnScope, CustomCombinationViewState customCombinationViewState, Function1 function1, int i3, Composer composer, int i4) {
        g0(columnScope, customCombinationViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:178:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00df  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k0(final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.CombinationDTO r33, final java.lang.Long r34, final boolean r35, final kotlin.jvm.functions.Function1 r36, boolean r37, boolean r38, boolean r39, final kotlin.jvm.functions.Function0 r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 915
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt.k0(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$CombinationDTO, java.lang.Long, boolean, kotlin.jvm.functions.Function1, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder l0(ConditionDTO.CombinationDTO combinationDTO, Long l3, boolean z2, boolean z3) {
        return ParametersHolderKt.b(combinationDTO, l3, Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnMissingPermissionsChanged.f115492a)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(boolean z2, Function0 function0) {
        if (z2) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1) {
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function1 function1, CustomCombinationViewState customCombinationViewState, long j3, long j4) {
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalSet(customCombinationViewState.g().g(), j3, j4)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(CustomCombinationViewState customCombinationViewState, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.f116258a[event.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                function1.invoke(new CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnPaused.f115493a)));
            }
        } else if (!customCombinationViewState.j().i() && customCombinationViewState.k()) {
            if (customCombinationViewState.l(ProfileType.WIFI)) {
                function1.invoke(new CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent(new WifiConditionViewEvent.OnSharedWifiConditionEvent(SharedWifiConditionEvent.CheckPermissionState.f115990a)));
            } else {
                function1.invoke(new CustomCombinationViewEvent.CustomCombinationLocationConditionViewEvent(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnResumed.f115495a)));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(ConditionDTO.CombinationDTO combinationDTO, Long l3, boolean z2, Function1 function1, boolean z3, boolean z4, boolean z5, Function0 function0, int i3, int i4, Composer composer, int i5) {
        k0(combinationDTO, l3, z2, function1, z3, z4, z5, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void s0(final androidx.compose.material.ScaffoldState r20, final androidx.navigation.NavHostController r21, final cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewState r22, boolean r23, boolean r24, final kotlin.jvm.functions.Function1 r25, final kotlin.jvm.functions.Function0 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 409
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationScreenKt.s0(androidx.compose.material.ScaffoldState, androidx.navigation.NavHostController, cz.mobilesoft.coreblock.scene.schedule.customcombination.CustomCombinationViewState, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(final CustomCombinationViewState customCombinationViewState, final ScaffoldState scaffoldState, final boolean z2, final boolean z3, final Function0 function0, final Function1 function1, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(701601888, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.a
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomCombinationScreenKt.u0(customCombinationViewState, scaffoldState, z2, z3, function0, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(CustomCombinationScreenNavigation.CustomCombination.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(1646367305, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomCombinationScreenKt.x0(scaffoldState, customCombinationViewState, z2, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(WifiConditionScreenNavigation.WifiSelection.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(-1310107736, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.w
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomCombinationScreenKt.A0(customCombinationViewState, z2, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(LocationConditionScreenNavigation.LocationSelection.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final CustomCombinationViewState customCombinationViewState, ScaffoldState scaffoldState, boolean z2, boolean z3, Function0 function0, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(701601888, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomCombinationScreen.kt:303)");
        }
        boolean zO = customCombinationViewState.o();
        String strB = StringResources_androidKt.b(R.string.Q8, composer, 0);
        boolean z4 = customCombinationViewState.p() && !customCombinationViewState.m();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.g0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomCombinationScreenKt.v0(function1);
                }
            };
            composer.w(objG);
        }
        BaseConditionScreenKt.W(scaffoldState, z2, z3, zO, strB, null, z4, function0, (Function0) objG, ComposableLambdaKt.e(-873424402, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.h0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CustomCombinationScreenKt.w0(customCombinationViewState, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 805306368, 32);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function1 function1) {
        function1.invoke(CustomCombinationViewEvent.OnSaveClicked.f116279a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(CustomCombinationViewState customCombinationViewState, Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(BaseConditionScreen) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-873424402, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.RootCompose.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomCombinationScreen.kt:315)");
            }
            g0(BaseConditionScreen, customCombinationViewState, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(ScaffoldState scaffoldState, CustomCombinationViewState customCombinationViewState, boolean z2, final Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1646367305, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.customcombination.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomCombinationScreen.kt:323)");
        }
        WifiConfigurationViewState wifiConfigurationViewStateJ = customCombinationViewState.j();
        boolean Z = composer.Z(function1);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.k0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomCombinationScreenKt.y0(function1, (WifiConditionViewEvent) obj);
                }
            };
            composer.w(objG);
        }
        Function1 function12 = (Function1) objG;
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.customcombination.l0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomCombinationScreenKt.z0(navHostController);
                }
            };
            composer.w(objG2);
        }
        WifiConditionScreenKt.R0(scaffoldState, wifiConfigurationViewStateJ, false, z2, false, null, function12, (Function0) objG2, composer, 0, 52);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(Function1 function1, WifiConditionViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        function1.invoke(new CustomCombinationViewEvent.CustomCombinationWifiConditionViewEvent(event));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(NavHostController navHostController) {
        NavController.O(navHostController, CustomCombinationScreenNavigation.CustomCombination.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }
}
