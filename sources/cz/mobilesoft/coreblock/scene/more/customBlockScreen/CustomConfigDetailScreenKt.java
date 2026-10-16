package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.content.Context;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.LockScreenColor;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
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
public final class CustomConfigDetailScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void F(final cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState r31, final kotlin.jvm.functions.Function0 r32, final java.lang.String r33, kotlin.jvm.functions.Function1 r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 509
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreenKt.F(cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState, kotlin.jvm.functions.Function0, java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(CustomBlockingScreenConfigEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomBlockingScreenConfigEntity H(MutableState mutableState) {
        return (CustomBlockingScreenConfigEntity) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(MutableState mutableState, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        mutableState.setValue(customBlockingScreenConfigEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(final MutableState mutableState, final Ref.ObjectRef objectRef, final MutableState mutableState2, final Function0 function0, final String str, final Function1 function1, final NavHostController navHostController, final Context context, final CustomBlockingViewState customBlockingViewState, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(-1379642621, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.b1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomConfigDetailScreenKt.L(mutableState, objectRef, mutableState2, function0, str, function1, navHostController, context, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCustomConfigOverview.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(619616044, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.c1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomConfigDetailScreenKt.Y(mutableState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCustomEmojiPicker.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(1571447883, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.d1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomConfigDetailScreenKt.b0(mutableState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavColorPicker.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        ComposableLambda composableLambdaC4 = ComposableLambdaKt.c(-1771687574, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.e1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomConfigDetailScreenKt.e0(mutableState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavTextPreferencesScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC4);
        ComposableLambda composableLambdaC5 = ComposableLambdaKt.c(-819855735, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.f1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomConfigDetailScreenKt.h0(mutableState, customBlockingViewState, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavPreferencesScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(final MutableState mutableState, final Ref.ObjectRef objectRef, final MutableState mutableState2, final Function0 function0, final String str, final Function1 function1, final NavHostController navHostController, final Context context, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1379642621, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:122)");
        }
        final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
        if (customBlockingScreenConfigEntityH == null) {
            composer.a0(1903925570);
            composer.U();
        } else {
            composer.a0(1903925571);
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(584969952, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomConfigDetailScreenKt.M(objectRef, mutableState2, function0, mutableState, str, function1, customBlockingScreenConfigEntityH, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(-2421791, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.k1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomConfigDetailScreenKt.R(navHostController, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-1451739175, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.l1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CustomConfigDetailScreenKt.W(customBlockingScreenConfigEntityH, context, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3456, 12582912, 131059);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(final Ref.ObjectRef objectRef, final MutableState mutableState, final Function0 function0, final MutableState mutableState2, final String str, final Function1 function1, final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(584969952, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:125)");
            }
            AppBarKt.g(ComposableSingletons$CustomConfigDetailScreenKt.f107057a.b(), null, ComposableLambdaKt.e(1073674586, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomConfigDetailScreenKt.N(objectRef, mutableState, function0, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.e(-968021743, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.v1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CustomConfigDetailScreenKt.P(str, function1, customBlockingScreenConfigEntity, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), ComposeColorsKt.j(composer, 0).e(), 0L, Dp.g(0), composer, 1576326, 34);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(final Ref.ObjectRef objectRef, final MutableState mutableState, final Function0 function0, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1073674586, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:133)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composer, 0).b(), StringResources_androidKt.b(R.string.N7, composer, 0), new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.x1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomConfigDetailScreenKt.O(objectRef, mutableState, function0, mutableState2);
                }
            }, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Ref.ObjectRef objectRef, MutableState mutableState, Function0 function0, MutableState mutableState2) {
        if (Intrinsics.areEqual(H(mutableState2), objectRef.f140144a)) {
            function0.invoke();
        } else {
            mutableState.setValue(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(String str, final Function1 function1, final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, RowScope TopAppBar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-968021743, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:147)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            String strB = StringResources_androidKt.b(str == null ? R.string.B8 : R.string.Lt, composer, 0);
            long jB = ComposeColorsKt.j(composer, 0).b();
            boolean Z = composer.Z(function1) | composer.Z(customBlockingScreenConfigEntity);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.y1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.Q(function1, customBlockingScreenConfigEntity);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.c0(strB, null, false, jB, null, 0.0f, null, (Function0) objG, composer, 0, 118);
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
    public static final Unit Q(Function1 function1, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        function1.invoke(customBlockingScreenConfigEntity);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(final NavHostController navHostController, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2421791, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:189)");
            }
            Arrangement.HorizontalOrVertical horizontalOrVerticalD = Arrangement.f6574a.d();
            Modifier modifierI = PaddingKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16));
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalD, Alignment.f25072a.l(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyB, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ImageVector.Companion companion2 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion2, R.drawable.Y1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Yf, composer, 0);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.S(navHostController);
                    }
                };
                composer.w(objG);
            }
            l0(imageVectorB, strB, (Function0) objG, composer, 0);
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion2, R.drawable.E1, composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.U7, composer, 0);
            boolean zI2 = composer.I(navHostController);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.g1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.T(navHostController);
                    }
                };
                composer.w(objG2);
            }
            l0(imageVectorB2, strB2, (Function0) objG2, composer, 0);
            ImageVector imageVectorB3 = VectorResources_androidKt.b(companion2, R.drawable.k6, composer, 6);
            String strB3 = StringResources_androidKt.b(R.string.CC, composer, 0);
            boolean zI3 = composer.I(navHostController);
            Object objG3 = composer.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.U(navHostController);
                    }
                };
                composer.w(objG3);
            }
            l0(imageVectorB3, strB3, (Function0) objG3, composer, 0);
            ImageVector imageVectorB4 = VectorResources_androidKt.b(companion2, R.drawable.g5, composer, 6);
            String strB4 = StringResources_androidKt.b(R.string.dp, composer, 0);
            boolean zI4 = composer.I(navHostController);
            Object objG4 = composer.G();
            if (zI4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.t1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.V(navHostController);
                    }
                };
                composer.w(objG4);
            }
            l0(imageVectorB4, strB4, (Function0) objG4, composer, 0);
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
    public static final Unit S(NavHostController navHostController) {
        NavController.O(navHostController, NavCustomEmojiPicker.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(NavHostController navHostController) {
        NavController.O(navHostController, NavColorPicker.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(NavHostController navHostController) {
        NavController.O(navHostController, NavTextPreferencesScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(NavHostController navHostController) {
        NavController.O(navHostController, NavPreferencesScreen.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, Context context, MutableState mutableState, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1451739175, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:164)");
            }
            Modifier modifierD = BackgroundKt.d(PaddingKt.j(PaddingKt.h(Modifier.b8, it), Dp.g(32), Dp.g(8)), Color.f25715b.j(), null, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            String strC = StringResources_androidKt.c(R.string.Kt, new Object[]{"Instagram"}, composer, 0);
            String string = StringHelper.h(StringResources_androidKt.c(R.string.Y3, new Object[]{StringResources_androidKt.b(R.string.Y4, composer, 0)}, composer, 0)).toString();
            String strB = StringResources_androidKt.b(R.string.M0, composer, 0);
            CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
            LockViewState lockViewState = new LockViewState(null, strC, 0, 0, false, 0, false, false, false, false, true, false, false, null, false, string, strB, StringResources_androidKt.c(R.string.d4, new Object[]{2, 23}, composer, 0), null, null, null, null, false, null, ContextCompat.getDrawable(context, R.drawable.O2), customBlockingScreenConfigEntity.l() > 0, customBlockingScreenConfigEntity.l() > 0 ? String.valueOf(customBlockingScreenConfigEntity.l()) : "", 0.0f, false, false, false, customBlockingScreenConfigEntityH, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, 2029812733, 7, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.w1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomConfigDetailScreenKt.X((LockViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            LockScreenKt.D(lockViewState, (Function1) objG, true, false, null, composer, 432, 24);
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
    public static final Unit X(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(final MutableState mutableState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(619616044, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:230)");
        }
        final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
        if (customBlockingScreenConfigEntityH == null) {
            composer.a0(-787828499);
            composer.U();
        } else {
            composer.a0(-787828498);
            String strB = StringResources_androidKt.b(R.string.Kv, composer, 0);
            ScheduleEmoji.Companion companion = ScheduleEmoji.Companion;
            Map mapC = companion.c();
            ScheduleEmoji scheduleEmojiD = companion.d(customBlockingScreenConfigEntityH.h());
            if (scheduleEmojiD == null) {
                scheduleEmojiD = ScheduleEmoji.CustomBlockingAppIcon;
            }
            ScheduleEmoji scheduleEmoji = scheduleEmojiD;
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.m1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.Z(navHostController);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean Z = composer.Z(customBlockingScreenConfigEntityH) | composer.I(navHostController);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.n1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomConfigDetailScreenKt.a0(customBlockingScreenConfigEntityH, navHostController, mutableState, (ScheduleEmoji) obj);
                    }
                };
                composer.w(objG2);
            }
            IconPickerScreenKt.J(strB, mapC, scheduleEmoji, function0, (Function1) objG2, false, composer, 0, 32);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, NavHostController navHostController, MutableState mutableState, ScheduleEmoji emoji) {
        Intrinsics.checkNotNullParameter(emoji, "emoji");
        I(mutableState, CustomBlockingScreenConfigEntity.b(customBlockingScreenConfigEntity, null, null, null, false, 0, false, emoji.getId(), null, null, null, null, 1983, null));
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(final MutableState mutableState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(1571447883, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:247)");
        }
        final CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
        if (customBlockingScreenConfigEntityH == null) {
            composer.a0(-139600608);
            composer.U();
        } else {
            composer.a0(-139600607);
            String strB = StringResources_androidKt.b(R.string.Jv, composer, 0);
            LockScreenColor.Companion companion = LockScreenColor.Companion;
            Map mapB = companion.b();
            LockScreenColor lockScreenColorA = companion.a(customBlockingScreenConfigEntityH.d());
            if (lockScreenColorA == null) {
                lockScreenColorA = LockScreenColor.BrandBlue;
            }
            LockScreenColor lockScreenColor = lockScreenColorA;
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.q1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.c0(navHostController);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean Z = composer.Z(customBlockingScreenConfigEntityH) | composer.I(navHostController);
            Object objG2 = composer.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.s1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomConfigDetailScreenKt.d0(customBlockingScreenConfigEntityH, navHostController, mutableState, (LockScreenColor) obj);
                    }
                };
                composer.w(objG2);
            }
            IconPickerScreenKt.J(strB, mapB, lockScreenColor, function0, (Function1) objG2, false, composer, 0, 32);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity, NavHostController navHostController, MutableState mutableState, LockScreenColor color) {
        Intrinsics.checkNotNullParameter(color, "color");
        I(mutableState, CustomBlockingScreenConfigEntity.b(customBlockingScreenConfigEntity, null, null, null, false, 0, false, 0, null, null, null, color.getHex(), 1023, null));
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(final MutableState mutableState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1771687574, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:264)");
        }
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
        if (customBlockingScreenConfigEntityH == null) {
            composer.a0(508619564);
        } else {
            composer.a0(508619565);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.h1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.f0(navHostController);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            boolean zI2 = composer.I(navHostController);
            Object objG2 = composer.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.i1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomConfigDetailScreenKt.g0(navHostController, mutableState, (CustomBlockingScreenConfigEntity) obj);
                    }
                };
                composer.w(objG2);
            }
            TextPreferencesScreenKt.u(customBlockingScreenConfigEntityH, function0, (Function1) objG2, composer, 0);
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(NavHostController navHostController, MutableState mutableState, CustomBlockingScreenConfigEntity updatedConfig) {
        Intrinsics.checkNotNullParameter(updatedConfig, "updatedConfig");
        I(mutableState, updatedConfig);
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(final MutableState mutableState, CustomBlockingViewState customBlockingViewState, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-819855735, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomConfigDetailScreen.<anonymous>.<anonymous> (CustomConfigDetailScreen.kt:279)");
        }
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityH = H(mutableState);
        if (customBlockingScreenConfigEntityH == null) {
            composer.a0(1156847455);
            composer.U();
        } else {
            composer.a0(1156847456);
            boolean zI = composer.I(navHostController);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.o1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.i0(navHostController);
                    }
                };
                composer.w(objG);
            }
            Function0 function0 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.p1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomConfigDetailScreenKt.j0(mutableState, (CustomBlockingScreenConfigEntity) obj);
                    }
                };
                composer.w(objG2);
            }
            PreferencesScreenKt.q(customBlockingViewState, function0, (Function1) objG2, customBlockingScreenConfigEntityH.i(), customBlockingScreenConfigEntityH, composer, 384, 0);
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(MutableState mutableState, CustomBlockingScreenConfigEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        I(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(CustomBlockingViewState customBlockingViewState, Function0 function0, String str, Function1 function1, int i3, int i4, Composer composer, int i5) {
        F(customBlockingViewState, function0, str, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void l0(final ImageVector imageVector, String str, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final String str2 = str;
        Composer composerK = composer.k(-1097967545);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(imageVector) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1097967545, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.NavigationButton (CustomConfigDetailScreen.kt:301)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
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
            int i5 = i4 << 18;
            int i6 = i4;
            ComposeButtonsKt.q0(null, imageVector, null, false, 0.0f, Dp.g(32), ComposeColorsKt.j(composerK, 0).L(), str, function0, composerK, ((i4 << 3) & 112) | 196608 | (29360128 & i5) | (i5 & 234881024), 29);
            long jI = TextUnitKt.i(12);
            FontWeight fontWeightK = FontWeight.f29233b.k();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            Modifier modifierK = PaddingKt.k(companion, Dp.g(8), 0.0f, 2, null);
            boolean z2 = (i6 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.z1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return CustomConfigDetailScreenKt.m0(function0);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            str2 = str;
            TextKt.c(str2, ClickableKt.f(modifierK, false, null, null, (Function0) objG, 7, null), jL, jI, null, fontWeightK, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, ((i6 >> 3) & 14) | 199680, 0, 131024);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.w0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomConfigDetailScreenKt.n0(imageVector, str2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ImageVector imageVector, String str, Function0 function0, int i3, Composer composer, int i4) {
        l0(imageVector, str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
