package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Build;
import android.os.Parcelable;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.LocationOnKt;
import androidx.compose.material3.SliderColors;
import androidx.compose.material3.SliderDefaults;
import androidx.compose.material3.SliderKt;
import androidx.compose.material3.SliderState;
import androidx.compose.material3.SwitchColors;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryKt;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.compose.CameraPositionState;
import com.google.maps.android.compose.CircleKt;
import com.google.maps.android.compose.GoogleMapKt;
import com.google.maps.android.compose.MapProperties;
import com.google.maps.android.compose.MapUiSettings;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenNavigation;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.location.SharedLocationConditionViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.CameraCenterMoveDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.Configuration;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionConfigurationViewState;
import cz.mobilesoft.coreblock.scene.schedule.condition.time.TimeConditionViewEvent;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeLoadingDotsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.SwitchKt;
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
import kotlin.ranges.RangesKt;
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
public final class LocationConditionScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f115410a;

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
            f115410a = iArr;
        }
    }

    private static final MapProperties A0(MutableState mutableState) {
        return (MapProperties) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, LatLng latLng) {
        Intrinsics.checkNotNullParameter(latLng, "latLng");
        function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(new SharedLocationConditionViewEvent.OnMapClicked(latLng)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(LocationConfigurationViewState locationConfigurationViewState, long j3, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1140538056, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.Map.<anonymous> (LocationConditionScreen.kt:655)");
            }
            LatLng latLngM = locationConfigurationViewState.m();
            if (latLngM == null) {
                composer.a0(282995102);
                composer.U();
            } else {
                composer.a0(282995103);
                CircleKt.a(latLngM, false, !locationConfigurationViewState.n() ? j3 : Color.f25715b.j(), locationConfigurationViewState.j(), ComposeColorsKt.j(composer, 0).b(), null, 10.0f, null, false, 0.0f, null, composer, 1572864, 0, 1954);
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
    public static final Projection D0(CameraPositionState cameraPositionState) {
        return cameraPositionState.o();
    }

    private static final void E0(final LocationConfigurationViewState locationConfigurationViewState, final Function0 function0, Composer composer, final int i3) {
        int i4;
        final Function0 function02;
        Composer composerK = composer.k(-1066457854);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(locationConfigurationViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        int i5 = i4;
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1066457854, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.MapContent (LocationConditionScreen.kt:468)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(114));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            final LatLng latLngM = locationConfigurationViewState.m();
            if (latLngM == null && (latLngM = locationConfigurationViewState.k()) == null) {
                CameraCenterMoveDTO cameraCenterMoveDTOE = locationConfigurationViewState.e();
                latLngM = cameraCenterMoveDTOE != null ? cameraCenterMoveDTOE.a() : null;
                if (latLngM == null) {
                    latLngM = new LatLng(0.0d, 0.0d);
                }
            }
            String string = latLngM.toString();
            final Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return LocationConditionScreenKt.F0(latLngM, context, (CameraPositionState) obj);
                }
            };
            composerK.F(-1911106014);
            CameraPositionState cameraPositionState = (CameraPositionState) RememberSaveableKt.e(new Object[0], CameraPositionState.f90597h.a(), string, new Function0<CameraPositionState>() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt$MapContent$lambda$0$$inlined$rememberCameraPositionState$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final CameraPositionState invoke() {
                    CameraPositionState cameraPositionState2 = new CameraPositionState(null, 1, null);
                    function1.invoke(cameraPositionState2);
                    return cameraPositionState2;
                }
            }, composerK, 72, 0);
            composerK.Y();
            LatLng latLngM2 = locationConfigurationViewState.m();
            boolean zI = composerK.I(locationConfigurationViewState) | composerK.I(cameraPositionState);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new LocationConditionScreenKt$MapContent$1$1$1(locationConfigurationViewState, cameraPositionState, null);
                composerK.w(objG);
            }
            EffectsKt.g(latLngM2, (Function2) objG, composerK, 0);
            Modifier modifierF2 = SizeKt.f(companion, 0.0f, 1, null);
            MapUiSettings mapUiSettings = new MapUiSettings(false, false, false, false, false, false, false, false, false, false, 2, null);
            int i6 = i5 & 112;
            boolean z2 = i6 == 32;
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.G0(function0, (LatLng) obj);
                    }
                };
                composerK.w(objG2);
            }
            GoogleMapKt.b(modifierF2, cameraPositionState, null, null, null, null, mapUiSettings, null, (Function1) objG2, null, null, null, null, null, null, null, composerK, (CameraPositionState.f90598i << 3) | 6 | (MapUiSettings.f90945k << 18), 0, 65212);
            Modifier modifierF3 = boxScopeInstance.f(companion, companion2.e());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
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
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion3.f());
            IconKt.b(LocationOnKt.a(Icons.f15145a.a()), null, SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composerK, 0).b(), composerK, 432, 0);
            composerK = composerK;
            composerK.y();
            Modifier modifierF5 = SizeKt.f(companion, 0.0f, 1, null);
            boolean z3 = i6 == 32;
            Object objG3 = composerK.G();
            if (z3 || objG3 == Composer.f23746a.a()) {
                function02 = function0;
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationConditionScreenKt.H0(function02);
                    }
                };
                composerK.w(objG3);
            } else {
                function02 = function0;
            }
            BoxKt.a(ClickableKt.f(modifierF5, false, null, null, (Function0) objG3, 7, null), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationConditionScreenKt.I0(locationConfigurationViewState, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(LatLng latLng, Context context, CameraPositionState rememberCameraPositionState) {
        Intrinsics.checkNotNullParameter(rememberCameraPositionState, "$this$rememberCameraPositionState");
        CameraPosition cameraPositionN = CameraPosition.N(latLng, i1(context));
        Intrinsics.checkNotNullExpressionValue(cameraPositionN, "fromLatLngZoom(...)");
        rememberCameraPositionState.y(cameraPositionN);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Function0 function0, LatLng it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(LocationConfigurationViewState locationConfigurationViewState, Function0 function0, int i3, Composer composer, int i4) {
        E0(locationConfigurationViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void J0(final androidx.compose.material.ScaffoldState r25, final cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState r26, boolean r27, boolean r28, java.lang.Float r29, boolean r30, final kotlin.jvm.functions.Function1 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.J0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(final LocationConditionScreenViewState locationConditionScreenViewState, final boolean z2, final boolean z3, final boolean z4, final Float f3, final Function1 function1, final NavHostController navHostController, final ScaffoldState scaffoldState, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(934393045, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.f
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LocationConditionScreenKt.L0(locationConditionScreenViewState, z2, z3, z4, f3, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(LocationConditionScreenNavigation.LocationSelection.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-1380507892, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.q
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return LocationConditionScreenKt.N0(scaffoldState, locationConditionScreenViewState, z2, z4, f3, z3, function1, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(LocationConditionScreenNavigation.TimeCondition.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(LocationConditionScreenViewState locationConditionScreenViewState, boolean z2, boolean z3, boolean z4, Float f3, Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(934393045, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.RootCompose.<anonymous>.<anonymous>.<anonymous> (LocationConditionScreen.kt:330)");
        }
        LocationConditionScreenNavigation.LocationSelection locationSelection = (LocationConditionScreenNavigation.LocationSelection) NavBackStackEntryKt.a(it, Reflection.b(LocationConditionScreenNavigation.LocationSelection.class));
        LocationConfigurationViewState locationConfigurationViewStateC = locationConditionScreenViewState.c();
        boolean zE = locationSelection.e();
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.b0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LocationConditionScreenKt.M0(navHostController);
                }
            };
            composer.w(objG);
        }
        u0(locationConfigurationViewStateC, z2, z3, z4, f3, zE, function1, (Function0) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(NavHostController navHostController) {
        NavController.O(navHostController, LocationConditionScreenNavigation.TimeCondition.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ScaffoldState scaffoldState, LocationConditionScreenViewState locationConditionScreenViewState, boolean z2, boolean z3, Float f3, boolean z4, Function1 function1, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1380507892, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.RootCompose.<anonymous>.<anonymous>.<anonymous> (LocationConditionScreen.kt:346)");
        }
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.m0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return LocationConditionScreenKt.O0(navHostController);
                }
            };
            composer.w(objG);
        }
        Y0(scaffoldState, locationConditionScreenViewState, z2, z3, f3, z4, function1, (Function0) objG, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(NavHostController navHostController) {
        NavController.O(navHostController, new LocationConditionScreenNavigation.LocationSelection(false), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(ScaffoldState scaffoldState, LocationConditionScreenViewState locationConditionScreenViewState, boolean z2, boolean z3, Float f3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        J0(scaffoldState, locationConditionScreenViewState, z2, z3, f3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void Q0(final Modifier modifier, final boolean z2, final LocationConfigurationViewState locationConfigurationViewState, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(249782592);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(locationConfigurationViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(249782592, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.SettingsCard (LocationConditionScreen.kt:778)");
            }
            float f3 = 16;
            CardsKt.k(PaddingKt.m(PaddingKt.k(modifier, Dp.g(f3), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0L, 0.0f, RoundedCornerShapeKt.d(Dp.g(36)), null, ComposableLambdaKt.e(-422951901, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.a0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LocationConditionScreenKt.R0(function1, locationConfigurationViewState, z2, function0, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 22);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationConditionScreenKt.X0(modifier, z2, locationConfigurationViewState, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(final Function1 function1, final LocationConfigurationViewState locationConfigurationViewState, boolean z2, final Function0 function0, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-422951901, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.SettingsCard.<anonymous> (LocationConditionScreen.kt:785)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.S0(function1, (ActivityResult) obj);
                    }
                };
                composer.w(objG);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
            final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierH = SizeKt.h(SizeKt.b(IntrinsicKt.a(companion, IntrinsicSize.f6986a), 0.0f, Dp.g(48), 1, null), 0.0f, 1, null);
            long jV = ComposeColorsKt.j(composer, 0).v();
            boolean zI = composer.I(managedActivityResultLauncherA) | composer.I(context);
            Object objG2 = composer.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationConditionScreenKt.T0(managedActivityResultLauncherA, context);
                    }
                };
                composer.w(objG2);
            }
            CardsKt.j(modifierH, jV, 0.0f, false, null, (Function0) objG2, ComposableLambdaKt.e(317427645, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.h0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LocationConditionScreenKt.U0(locationConfigurationViewState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 28);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c(StringResources_androidKt.b(R.string.wr, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            TextKt.c(StringResources_androidKt.b(R.string.Yh, composer, 0), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierA = SizeKt.A(SizeKt.i(companion, Dp.g(32)), Dp.g(52));
            boolean zN = locationConfigurationViewState.n();
            SwitchColors switchColorsA = SwitchKt.a(composer, 0);
            boolean Z2 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.V0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG3);
            }
            androidx.compose.material3.SwitchKt.a(zN, (Function1) objG3, modifierA, null, false, switchColorsA, null, composer, 384, 88);
            composer.y();
            TextKt.c(StringResources_androidKt.c(R.string.Mj, new Object[]{Integer.valueOf(locationConfigurationViewState.j())}, composer, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65016);
            Object objG4 = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG4 == companion4.a()) {
                Object sliderState = new SliderState(locationConfigurationViewState.j(), 57, null, RangesKt.b(100.0f, 3000.0f), 4, null);
                composer.w(sliderState);
                objG4 = sliderState;
            }
            SliderState sliderState2 = (SliderState) objG4;
            Float fValueOf = Float.valueOf(sliderState2.r());
            boolean Z3 = composer.Z(function1) | composer.I(sliderState2);
            Object objG5 = composer.G();
            if (Z3 || objG5 == companion4.a()) {
                objG5 = new LocationConditionScreenKt$SettingsCard$1$1$4$1(function1, sliderState2, null);
                composer.w(objG5);
            }
            EffectsKt.g(fValueOf, (Function2) objG5, composer, 0);
            SliderColors sliderColorsI = SliderDefaults.f19885a.i(composer, 6);
            long jB = ComposeColorsKt.j(composer, 0).b();
            long jB2 = ComposeColorsKt.j(composer, 0).b();
            long jU = ComposeColorsKt.j(composer, 0).u();
            Color.Companion companion5 = Color.f25715b;
            SliderKt.g(sliderState2, null, false, SliderColors.b(sliderColorsI, jB, jB2, companion5.j(), jU, companion5.j(), 0L, 0L, 0L, 0L, 0L, 992, null), null, null, null, composer, SliderState.f20184q, 118);
            String strB = StringResources_androidKt.b(z2 ? R.string.l8 : R.string.Lt, composer, 0);
            FlatButtonColors flatButtonColors = Intrinsics.areEqual(locationConfigurationViewState.i(), Success.f128020a) ? FlatButtonColors.Primary.f131166a : FlatButtonColors.Disabled.f131162a;
            boolean Z4 = composer.Z(function0);
            Object objG6 = composer.G();
            if (Z4 || objG6 == companion4.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationConditionScreenKt.W0(function0);
                    }
                };
                composer.w(objG6);
            }
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, flatButtonColors, null, strB, null, 0L, null, null, false, false, (Function0) objG6, composer, 0, 0, 8111);
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
    public static final Unit S0(Function1 function1, ActivityResult result) {
        Intent intentC;
        Parcelable parcelable;
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1 && (intentC = result.c()) != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) intentC.getParcelableExtra("PLACE_LAT_LNG", LatLng.class);
            } else {
                Parcelable parcelableExtra = intentC.getParcelableExtra("PLACE_LAT_LNG");
                if (!(parcelableExtra instanceof LatLng)) {
                    parcelableExtra = null;
                }
                parcelable = (LatLng) parcelableExtra;
            }
            LatLng latLng = (LatLng) parcelable;
            if (latLng != null) {
                function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(new SharedLocationConditionViewEvent.OnPlaceByAddressSelected(latLng)));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(ManagedActivityResultLauncher managedActivityResultLauncher, Context context) {
        managedActivityResultLauncher.b(LocationPlacesSelectActivity.f115453t.a(context));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(LocationConfigurationViewState locationConfigurationViewState, ColumnScope BaseCard, Composer composer, int i3) {
        Modifier.Companion companion;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(317427645, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.SettingsCard.<anonymous>.<anonymous>.<anonymous> (LocationConditionScreen.kt:809)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 12;
            Modifier modifierK = PaddingKt.k(SizeKt.f(companion2, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierK);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (locationConfigurationViewState.m() != null) {
                composer2.a0(-1279700679);
                ViewModelState viewModelStateI = locationConfigurationViewState.i();
                if (Intrinsics.areEqual(viewModelStateI, Loading.f127895a)) {
                    composer2.a0(97267917);
                    ComposeLoadingDotsKt.i(composer2, 0);
                    composer2.U();
                    companion = companion2;
                } else if (Intrinsics.areEqual(viewModelStateI, Success.f128020a)) {
                    composer2.a0(-1279560993);
                    companion = companion2;
                    TextKt.c(locationConfigurationViewState.h(), PaddingKt.k(companion2, 0.0f, Dp.g(f3), 1, null), ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 2, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 48, 3120, 55288);
                    composer2 = composer;
                    composer2.U();
                } else {
                    companion = companion2;
                    composer2.a0(-1278958601);
                    TextKt.c(StringResources_androidKt.b(R.string.V, composer2, 0), null, ComposeColorsKt.j(composer2, 0).x(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 0, 0, 65530);
                    composer2 = composer;
                    composer2.U();
                }
            } else {
                companion = companion2;
                composer2.a0(-1312787103);
            }
            composer2.U();
            Modifier.Companion companion4 = companion;
            SpacerKt.a(RowScope.c(rowScopeInstance, companion4, 1.0f, false, 2, null), composer2, 0);
            IconKt.a(PainterResources_androidKt.c(R.drawable.Z4, composer2, 0), null, SizeKt.v(companion4, Dp.g(24)), ComposeColorsKt.j(composer2, 0).s(), composer2, 432, 0);
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
    public static final Unit V0(Function1 function1, boolean z2) {
        function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(new SharedLocationConditionViewEvent.OnSettingsChanged.Inverted(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(Modifier modifier, boolean z2, LocationConfigurationViewState locationConfigurationViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        Q0(modifier, z2, locationConfigurationViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Y(final androidx.compose.ui.Modifier r19, final boolean r20, boolean r21, boolean r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.Y(androidx.compose.ui.Modifier, boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Y0(final androidx.compose.material.ScaffoldState r23, final cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState r24, boolean r25, boolean r26, java.lang.Float r27, boolean r28, final kotlin.jvm.functions.Function1 r29, final kotlin.jvm.functions.Function0 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.Y0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenViewState, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1) {
        function1.invoke(LocationConditionViewEvent.OnCloseClicked.f115450a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function1 function1) {
        function1.invoke(LocationConditionViewEvent.OnCloseClicked.f115450a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(boolean z2, final Function1 function1, RowScope AppBlockToolbar, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(AppBlockToolbar, "$this$AppBlockToolbar");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(AppBlockToolbar) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1475558947, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.Buttons.<anonymous> (LocationConditionScreen.kt:964)");
            }
            if (z2) {
                composer.a0(613725405);
                SpacerKt.a(RowScope.c(AppBlockToolbar, Modifier.b8, 1.0f, false, 2, null), composer, 0);
                int i5 = R.drawable.r3;
                FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.k0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return LocationConditionScreenKt.b0(function1);
                        }
                    };
                    composer.w(objG);
                }
                FlatButtonsKt.K(null, 0.0f, i5, secondary, null, (Function0) objG, composer, 27648, 3);
            } else {
                composer.a0(574702853);
            }
            composer.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Function1 function1) {
        function1.invoke(LocationConditionViewEvent.OnSaveClicked.f115451a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Function1 function1) {
        function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnCurrentPositionClicked.f115490a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(LocationConditionScreenViewState locationConditionScreenViewState, Function0 function0, final Function1 function1, ColumnScope BaseConditionScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseConditionScreen, "$this$BaseConditionScreen");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(859486852, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.TimeConditionScreen.<anonymous> (LocationConditionScreen.kt:388)");
            }
            TimeConditionConfigurationViewState timeConditionConfigurationViewStateD = locationConditionScreenViewState.d();
            r0(locationConditionScreenViewState.c(), function0, composer, 0);
            Configuration configurationF = timeConditionConfigurationViewStateD.f();
            boolean zI = timeConditionConfigurationViewStateD.i();
            boolean zM = timeConditionConfigurationViewStateD.m();
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.b1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationConditionScreenKt.c1(function1);
                    }
                };
                composer.w(objG);
            }
            Function0 function02 = (Function0) objG;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.c1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.d1(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composer.w(objG2);
            }
            Function1 function12 = (Function1) objG2;
            boolean Z3 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.e1(function1, (IntervalDTO) obj);
                    }
                };
                composer.w(objG3);
            }
            Function1 function13 = (Function1) objG3;
            boolean Z4 = composer.Z(function1);
            Object objG4 = composer.G();
            if (Z4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.f1(function1, (IntervalDTO) obj);
                    }
                };
                composer.w(objG4);
            }
            BaseConditionScreenKt.R0(configurationF, zI, zM, function02, function12, function13, (Function1) objG4, composer, 0, 0);
            Configuration configurationF2 = timeConditionConfigurationViewStateD.f();
            boolean zH = timeConditionConfigurationViewStateD.h();
            boolean Z5 = composer.Z(function1);
            Object objG5 = composer.G();
            if (Z5 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.i
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return LocationConditionScreenKt.g1(function1, ((Boolean) obj).booleanValue(), (DayOfWeek) obj2);
                    }
                };
                composer.w(objG5);
            }
            BaseConditionScreenKt.i0(configurationF2, zH, (Function2) objG5, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Modifier modifier, boolean z2, boolean z3, boolean z4, Function1 function1, int i3, int i4, Composer composer, int i5) {
        Y(modifier, z2, z3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(Function1 function1) {
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(TimeConditionViewEvent.OnAddIntervalClicked.f115749a));
        return Unit.f139807a;
    }

    private static final void d0(final ScaffoldState scaffoldState, final CoroutineScope coroutineScope, final boolean z2, final LocationConditionScreenViewModel locationConditionScreenViewModel, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        ScaffoldState scaffoldState2;
        int i4;
        LocationConditionScreenViewModel locationConditionScreenViewModel2;
        Function1 function12;
        Composer composer2;
        Composer composerK = composer.k(-194566309);
        if ((i3 & 6) == 0) {
            scaffoldState2 = scaffoldState;
            i4 = (composerK.Z(scaffoldState2) ? 4 : 2) | i3;
        } else {
            scaffoldState2 = scaffoldState;
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(coroutineScope) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            locationConditionScreenViewModel2 = locationConditionScreenViewModel;
            i4 |= composerK.I(locationConditionScreenViewModel2) ? 2048 : 1024;
        } else {
            locationConditionScreenViewModel2 = locationConditionScreenViewModel;
        }
        if ((i3 & 24576) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function12 = function1;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-194566309, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.CommandProcessor (LocationConditionScreen.kt:285)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            int i6 = 458752 & i5;
            boolean z3 = ((i5 & 896) == 256) | (i6 == 131072);
            Object objG2 = composerK.G();
            if (z3 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationConditionScreenKt.e0(z2, function0);
                    }
                };
                composerK.w(objG2);
            }
            ComposeDialogsKt.H0(mutableState, (Function0) objG2, composerK, 6);
            boolean zI = ((57344 & i5) == 16384) | (i6 == 131072) | ((i5 & 14) == 4) | composerK.I(coroutineScope);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                LocationConditionScreenKt$CommandProcessor$2$1 locationConditionScreenKt$CommandProcessor$2$1 = new LocationConditionScreenKt$CommandProcessor$2$1(function12, function0, mutableState, scaffoldState2, coroutineScope, null);
                composerK.w(locationConditionScreenKt$CommandProcessor$2$1);
                objG3 = locationConditionScreenKt$CommandProcessor$2$1;
            }
            composer2 = composerK;
            FlowExtKt.g(locationConditionScreenViewModel2, null, (Function2) objG3, composer2, (i5 >> 9) & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.u0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationConditionScreenKt.f0(scaffoldState, coroutineScope, z2, locationConditionScreenViewModel, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(Function1 function1, boolean z2) {
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(new TimeConditionViewEvent.OnAllDayLongCheckedChanged(z2)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(boolean z2, Function0 function0) {
        AnswersHelper.f128199a.R4(ProfileType.LOCATION, z2);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalClicked(interval)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(ScaffoldState scaffoldState, CoroutineScope coroutineScope, boolean z2, LocationConditionScreenViewModel locationConditionScreenViewModel, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        d0(scaffoldState, coroutineScope, z2, locationConditionScreenViewModel, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Function1 function1, IntervalDTO interval) {
        Intrinsics.checkNotNullParameter(interval, "interval");
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalRemoveClicked(interval)));
        return Unit.f139807a;
    }

    private static final void g0(final Point point, final int i3, final long j3, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(333248167);
        if ((i4 & 6) == 0) {
            i5 = (composerK.I(point) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.f(j3) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(333248167, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.InvertedOverlay (LocationConditionScreen.kt:927)");
            }
            Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
            boolean zI = ((i5 & 896) == 256) | ((i5 & 112) == 32) | composerK.I(point);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationConditionScreenKt.h0(j3, i3, point, (DrawScope) obj);
                    }
                };
                composerK.w(objG);
            }
            CanvasKt.b(modifierF, (Function1) objG, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationConditionScreenKt.i0(point, i3, j3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(Function1 function1, boolean z2, DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(new TimeConditionViewEvent.OnDayCheckedChanged(z2, dayOfWeek)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(long j3, int i3, Point point, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        Canvas canvasD = AndroidCanvas_androidKt.d(Canvas.Q1().g());
        int iSaveLayer = canvasD.saveLayer(null, null);
        DrawScope.L1(Canvas, j3, 0L, 0L, 0.0f, null, null, 0, 126, null);
        if (i3 > 0) {
            DrawScope.e2(Canvas, Color.f25715b.j(), i3, Offset.e((((long) Float.floatToRawIntBits(point.x)) << 32) | (((long) Float.floatToRawIntBits(point.y)) & 4294967295L)), 0.0f, null, null, BlendMode.f25667b.a(), 56, null);
        }
        canvasD.restoreToCount(iSaveLayer);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(ScaffoldState scaffoldState, LocationConditionScreenViewState locationConditionScreenViewState, boolean z2, boolean z3, Float f3, boolean z4, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        Y0(scaffoldState, locationConditionScreenViewState, z2, z3, f3, z4, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Point point, int i3, long j3, int i4, Composer composer, int i5) {
        g0(point, i3, j3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    private static final float i1(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? 15.0f : 16.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:179:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:184:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j0(final cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO.LocationDTO r27, final java.lang.Long r28, final boolean r29, boolean r30, boolean r31, java.lang.Float r32, boolean r33, final kotlin.jvm.functions.Function1 r34, final kotlin.jvm.functions.Function0 r35, androidx.compose.runtime.Composer r36, final int r37, final int r38) {
        /*
            Method dump skipped, instruction units count: 872
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.j0(cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO$LocationDTO, java.lang.Long, boolean, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LatLng j1(boolean z2, double d3, double d4, double d5, double d6) {
        return !z2 ? new LatLng(d3 - ((d5 / 111320.0d) * d6), d4) : new LatLng(d3, d4 + ((d5 / 111320.0d) * d6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder k0(ConditionDTO.LocationDTO locationDTO, Long l3, boolean z2) {
        return ParametersHolderKt.b(locationDTO, l3, Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnMissingPermissionsChanged.f115492a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function1 function1) {
        function1.invoke(LocationConditionViewEvent.OnCloseClicked.f115450a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(Function1 function1) {
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(TimeConditionViewEvent.OnDismissTimeRangePickerBottomSheet.f115754a));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(Function1 function1, LocationConditionScreenViewState locationConditionScreenViewState, long j3, long j4) {
        function1.invoke(new LocationConditionViewEvent.LocationTimeConditionViewEvent(new TimeConditionViewEvent.OnIntervalSet(locationConditionScreenViewState.d().g(), j3, j4)));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = WhenMappings.f115410a[event.ordinal()];
        if (i3 == 1) {
            function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnResumed.f115495a));
        } else if (i3 == 2) {
            function1.invoke(new LocationConditionViewEvent.OnSharedLocationConditionViewEvent(SharedLocationConditionViewEvent.OnPaused.f115493a));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(ConditionDTO.LocationDTO locationDTO, Long l3, boolean z2, boolean z3, boolean z4, Float f3, boolean z5, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        j0(locationDTO, l3, z2, z3, z4, f3, z5, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void r0(final LocationConfigurationViewState viewState, final Function0 onClick, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(-1703045977);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onClick) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1703045977, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationSelectionContent (LocationConditionScreen.kt:427)");
            }
            CardsKt.k(PaddingKt.k(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, Dp.g(8), 1, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(352823332, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LocationConditionScreenKt.s0(viewState, onClick, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.condition.location.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationConditionScreenKt.t0(viewState, onClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(LocationConfigurationViewState locationConfigurationViewState, Function0 function0, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(352823332, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationSelectionContent.<anonymous> (LocationConditionScreen.kt:434)");
            }
            E0(locationConfigurationViewState, function0, composer, 0);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16));
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
            TextKt.c(locationConfigurationViewState.h(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 2, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 3120, 55290);
            SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer, 6);
            composer.a0(945343547);
            String strC = StringResources_androidKt.c(R.string.Mj, new Object[]{Integer.valueOf(locationConfigurationViewState.j())}, composer, 0);
            if (locationConfigurationViewState.n()) {
                composer.a0(1608155014);
                strC = StringHelperExtKt.p(strC, StringResources_androidKt.b(R.string.Yh, composer, 0), ", ");
                composer.U();
            } else {
                composer.a0(1608157960);
                composer.U();
            }
            composer.U();
            TextKt.c(strC, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
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
    public static final Unit t0(LocationConfigurationViewState locationConfigurationViewState, Function0 function0, int i3, Composer composer, int i4) {
        r0(locationConfigurationViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:162:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03af  */
    /* JADX WARN: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void u0(final cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r31, boolean r32, boolean r33, boolean r34, java.lang.Float r35, boolean r36, final kotlin.jvm.functions.Function1 r37, final kotlin.jvm.functions.Function0 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 960
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.u0(cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState, boolean, boolean, boolean, java.lang.Float, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(LocationConfigurationViewState locationConfigurationViewState, boolean z2, boolean z3, boolean z4, Float f3, boolean z5, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        u0(locationConfigurationViewState, z2, z3, z4, f3, z5, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void w0(final cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState r36, boolean r37, final boolean r38, final kotlin.jvm.functions.Function1 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 888
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionScreenKt.w0(cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(LocationConfigurationViewState locationConfigurationViewState, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w0(locationConfigurationViewState, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(LocationConfigurationViewState locationConfigurationViewState, Context context, CameraPositionState rememberCameraPositionState) {
        Intrinsics.checkNotNullParameter(rememberCameraPositionState, "$this$rememberCameraPositionState");
        LatLng latLngM = locationConfigurationViewState.m();
        if (latLngM == null && (latLngM = locationConfigurationViewState.k()) == null) {
            CameraCenterMoveDTO cameraCenterMoveDTOE = locationConfigurationViewState.e();
            latLngM = cameraCenterMoveDTOE != null ? cameraCenterMoveDTOE.a() : null;
        }
        CameraPosition cameraPositionN = CameraPosition.N(latLngM == null ? new LatLng(0.0d, 0.0d) : latLngM, latLngM != null ? i1(context) : 1.0f);
        Intrinsics.checkNotNullExpressionValue(cameraPositionN, "fromLatLngZoom(...)");
        rememberCameraPositionState.y(cameraPositionN);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(LocationConfigurationViewState locationConfigurationViewState, boolean z2, boolean z3, Function1 function1, int i3, int i4, Composer composer, int i5) {
        w0(locationConfigurationViewState, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
