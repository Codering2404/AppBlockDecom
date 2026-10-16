package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BlockingModeSettingsScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(BlockingModeSettingsViewState blockingModeSettingsViewState, Function0 function0, int i3, Composer composer, int i4) {
        s(blockingModeSettingsViewState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void B(final int r25, final int r26, final int r27, java.lang.String r28, boolean r29, final boolean r30, boolean r31, final kotlin.jvm.functions.Function0 r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 519
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreenKt.B(int, int, int, java.lang.String, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(int i3, int i4, int i5, String str, boolean z2, ColumnScope DashedBorderCard, Composer composer, int i6) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(DashedBorderCard, "$this$DashedBorderCard");
        if (composer.r((i6 & 17) != 16, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1081269034, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeCard.<anonymous> (BlockingModeSettingsScreen.kt:450)");
            }
            F(i3, i4, i5, str, true, z2, composer, 24576, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(int i3, int i4, int i5, String str, boolean z2, ColumnScope BorderedCard, Composer composer, int i6) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(BorderedCard, "$this$BorderedCard");
        if (composer.r((i6 & 17) != 16, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1714240211, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeCard.<anonymous> (BlockingModeSettingsScreen.kt:466)");
            }
            F(i3, i4, i5, str, false, z2, composer, 24576, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(int i3, int i4, int i5, String str, boolean z2, boolean z3, boolean z4, Function0 function0, int i6, int i7, Composer composer, int i8) {
        B(i3, i4, i5, str, z2, z3, z4, function0, composer, RecomposeScopeImplKt.a(i6 | 1), i7);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void F(final int r39, final int r40, final int r41, java.lang.String r42, boolean r43, boolean r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 925
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreenKt.F(int, int, int, java.lang.String, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(int i3, int i4, int i5, String str, boolean z2, boolean z3, int i6, int i7, Composer composer, int i8) throws XmlPullParserException, IOException {
        F(i3, i4, i5, str, z2, z3, composer, RecomposeScopeImplKt.a(i6 | 1), i7);
        return Unit.f139807a;
    }

    public static final void H(boolean z2, Profile.BlockingMode blockingMode, final ProfileType profileType, final Function1 onContinueClicked, final Function0 onCloseClicked, final Function0 onAllowListPremiumClicked, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        Composer composer2;
        final Profile.BlockingMode blockingMode2;
        final boolean z4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onAllowListPremiumClicked, "onAllowListPremiumClicked");
        Composer composerK = composer.k(-89136326);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        int i7 = i4 & 2;
        if (i7 != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.e(blockingMode == null ? -1 : blockingMode.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.e(profileType == null ? -1 : profileType.ordinal()) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onContinueClicked) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.I(onCloseClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.I(onAllowListPremiumClicked) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            final boolean z5 = i6 != 0 ? true : z3;
            final Profile.BlockingMode blockingMode3 = i7 != 0 ? Profile.BlockingMode.Blocklist : blockingMode;
            if (ComposerKt.M()) {
                ComposerKt.U(-89136326, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreen (BlockingModeSettingsScreen.kt:122)");
            }
            boolean z6 = ((i5 & 896) == 256) | ((i5 & 14) == 4) | ((i5 & 112) == 32);
            Object objG = composerK.G();
            if (z6 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingModeSettingsScreenKt.I(profileType, z5, blockingMode3);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
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
            KClass kClassB = Reflection.b(BlockingModeSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            BlockingModeSettingsViewModel blockingModeSettingsViewModel = (BlockingModeSettingsViewModel) viewModelA;
            final BlockingModeSettingsViewState blockingModeSettingsViewState = (BlockingModeSettingsViewState) FlowExtKt.m(blockingModeSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(blockingModeSettingsViewModel, composerK, 0);
            N(blockingModeSettingsViewModel, onContinueClicked, onAllowListPremiumClicked, composerK, ((i5 >> 9) & 896) | ((i5 >> 6) & 112));
            Profile.BlockingMode blockingMode4 = blockingMode3;
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6)), null, null, ComposableLambdaKt.e(-438438144, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingModeSettingsScreenKt.J(function1N, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(798398200, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.f
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlockingModeSettingsScreenKt.L(blockingModeSettingsViewState, onCloseClicked, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3072, 12582912, 131062);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            z4 = z5;
            blockingMode2 = blockingMode4;
        } else {
            composer2 = composerK;
            composer2.Q();
            blockingMode2 = blockingMode;
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingModeSettingsScreenKt.M(z4, blockingMode2, profileType, onContinueClicked, onCloseClicked, onAllowListPremiumClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder I(ProfileType profileType, boolean z2, Profile.BlockingMode blockingMode) {
        return ParametersHolderKt.b(profileType, Boolean.valueOf(z2), blockingMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-438438144, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreen.<anonymous> (BlockingModeSettingsScreen.kt:145)");
            }
            String strB = StringResources_androidKt.b(R.string.l8, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingModeSettingsScreenKt.K(function1);
                    }
                };
                composer.w(objG);
            }
            FlatButtonsKt.p(null, false, strB, false, (Function0) objG, composer, 0, 11);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Function1 function1) {
        function1.invoke(BlockingModeSettingsViewEvent.OnContinueClicked.f115060a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(BlockingModeSettingsViewState blockingModeSettingsViewState, Function0 function0, Function1 function1, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(798398200, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockingModeSettingsScreen.<anonymous> (BlockingModeSettingsScreen.kt:137)");
            }
            P(it, blockingModeSettingsViewState, function0, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(boolean z2, Profile.BlockingMode blockingMode, ProfileType profileType, Function1 function1, Function0 function0, Function0 function02, int i3, int i4, Composer composer, int i5) {
        H(z2, blockingMode, profileType, function1, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void N(final BlockingModeSettingsViewModel blockingModeSettingsViewModel, final Function1 function1, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-2094819682);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(blockingModeSettingsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2094819682, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.CommandProcessor (BlockingModeSettingsScreen.kt:158)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            ComposeDialogsKt.R0(mutableState, StringResources_androidKt.b(R.string.C0, composerK, 0), null, null, null, null, composerK, 6, 60);
            boolean z2 = ((i4 & 112) == 32) | ((i4 & 896) == 256);
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new BlockingModeSettingsScreenKt$CommandProcessor$1$1(function1, mutableState, function0, null);
                composerK.w(objG2);
            }
            FlowExtKt.g(blockingModeSettingsViewModel, null, (Function2) objG2, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingModeSettingsScreenKt.O(blockingModeSettingsViewModel, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(BlockingModeSettingsViewModel blockingModeSettingsViewModel, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        N(blockingModeSettingsViewModel, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(final PaddingValues paddingValues, final BlockingModeSettingsViewState blockingModeSettingsViewState, final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        String str;
        Composer composerK = composer.k(916296547);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(blockingModeSettingsViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(916296547, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.Content (BlockingModeSettingsScreen.kt:186)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = ScrollKt.g(SizeKt.d(PaddingKt.h(companion, paddingValues), 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
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
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.f(companion, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
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
            s(blockingModeSettingsViewState, function0, composerK, (i4 >> 3) & 126);
            String strB = StringResources_androidKt.b(R.string.f4, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f3 = 8;
            int i5 = i4;
            boolean z2 = false;
            TextKt.c(strB, boxScopeInstance.f(SizeKt.h(PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null), 0.0f, 1, null), companion2.b()), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65016);
            composerK.y();
            float f4 = 16;
            Modifier modifierC = columnScopeInstance.c(PaddingKt.m(PaddingKt.k(BackgroundKt.d(companion, ComposeColorsKt.j(composerK, 0).e(), null, 2, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), companion2.g());
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC);
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
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            TextKt.c(StringResources_androidKt.b(R.string.C7, composerK, 0), SizeKt.h(PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(22), 2, null), 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
            composerK = composerK;
            int i6 = R.drawable.f95511f1;
            int i7 = R.string.A4;
            int i8 = R.string.B4;
            boolean z3 = blockingModeSettingsViewState.e() == Profile.BlockingMode.Blocklist;
            int i9 = i5 & 7168;
            boolean z4 = i9 == 2048;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingModeSettingsScreenKt.Q(function1);
                    }
                };
                composerK.w(objG);
            }
            B(i6, i7, i8, null, false, z3, false, (Function0) objG, composerK, 0, 88);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            int i10 = R.drawable.A5;
            int i11 = R.string.A0;
            boolean zC = blockingModeSettingsViewState.c();
            int i12 = R.string.B0;
            ProfileType profileTypeG = blockingModeSettingsViewState.g();
            Integer notAvailableWithTextResId = profileTypeG != null ? profileTypeG.getNotAvailableWithTextResId() : null;
            if (notAvailableWithTextResId == null) {
                composerK.a0(1092491800);
                composerK.U();
                str = null;
            } else {
                composerK.a0(1092491801);
                String strB2 = StringResources_androidKt.b(notAvailableWithTextResId.intValue(), composerK, 0);
                composerK.U();
                str = strB2;
            }
            boolean z5 = !blockingModeSettingsViewState.f().g();
            boolean z6 = blockingModeSettingsViewState.e() == Profile.BlockingMode.Allowlist;
            if (i9 == 2048) {
                z2 = true;
            }
            Object objG2 = composerK.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingModeSettingsScreenKt.R(function1);
                    }
                };
                composerK.w(objG2);
            }
            B(i10, i11, i12, str, z5, z6, zC, (Function0) objG2, composerK, 0, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlockingModeSettingsScreenKt.S(paddingValues, blockingModeSettingsViewState, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function1 function1) {
        function1.invoke(new BlockingModeSettingsViewEvent.OnBlockingModeClicked(Profile.BlockingMode.Blocklist));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1) {
        function1.invoke(new BlockingModeSettingsViewEvent.OnBlockingModeClicked(Profile.BlockingMode.Allowlist));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(PaddingValues paddingValues, BlockingModeSettingsViewState blockingModeSettingsViewState, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        P(paddingValues, blockingModeSettingsViewState, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v7 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v27 */
    public static final void s(final BlockingModeSettingsViewState viewState, Function0 function0, Composer composer, final int i3) {
        int i4;
        final BlockingModeSettingsViewState blockingModeSettingsViewState;
        Composer composer2;
        long jA;
        long jA2;
        Object obj;
        ?? r11;
        final MutableState mutableState;
        int i5;
        long j3;
        int i6;
        final Function0 onCloseClicked = function0;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(-362424794);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(viewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-362424794, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockListAllowListCanvas (BlockingModeSettingsScreen.kt:261)");
            }
            Brush.Companion companion = Brush.Companion;
            Profile.BlockingMode blockingModeE = viewState.e();
            Profile.BlockingMode blockingMode = Profile.BlockingMode.Blocklist;
            if (blockingModeE == blockingMode) {
                composerK.a0(-397868564);
                jA = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(-397867957);
                jA = ComposeColorsKt.j(composerK, 0).A();
            }
            composerK.U();
            final Brush brushM = Brush.Companion.m(companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(jA), Color.n(ComposeColorsKt.j(composerK, 0).e())}), 0.0f, 0.0f, 0, 14, null);
            final long jR = Color.r(ComposeColorsKt.j(composerK, 0).q0(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null);
            if (viewState.e() == blockingMode) {
                composerK.a0(-397862516);
                jA2 = ComposeColorsKt.j(composerK, 0).b();
            } else {
                composerK.a0(-397861909);
                jA2 = ComposeColorsKt.j(composerK, 0).A();
            }
            composerK.U();
            final long j4 = jA2;
            final Painter painterC = PainterResources_androidKt.c(viewState.e() == blockingMode ? R.drawable.f95511f1 : R.drawable.U0, composerK, 0);
            final Painter painterC2 = PainterResources_androidKt.c(R.drawable.f95511f1, composerK, 0);
            final Painter painterC3 = PainterResources_androidKt.c(R.drawable.f95559r1, composerK, 0);
            composerK.a0(-397850436);
            int iZ0 = ((Density) composerK.q(CompositionLocalsKt.f())).z0(Dp.g(((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).screenWidthDp));
            composerK.U();
            double d3 = ((double) iZ0) * 0.32d;
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            int i7 = i4;
            if (objG == companion2.a()) {
                MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(mutableStateE);
                objG = mutableStateE;
            }
            MutableState mutableState2 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion2.a()) {
                double d4 = 50;
                double d5 = d3 - d4;
                List listListOf = CollectionsKt.listOf((Object[]) new Size[]{Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L))), Size.c(Size.d((((long) Float.floatToRawIntBits((float) (d4 + (Math.random() * d5)))) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L)))});
                obj = null;
                objG2 = SnapshotStateKt__SnapshotStateKt.e(listListOf, null, 2, null);
                composerK.w(objG2);
            } else {
                obj = null;
            }
            final MutableState mutableState3 = (MutableState) objG2;
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion3, 0.0f, 1, obj);
            boolean Z = ((i7 & 14) == 4) | composerK.Z(brushM) | composerK.f(j4) | composerK.f(jR) | composerK.I(painterC) | composerK.I(painterC3);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion2.a()) {
                r11 = 0;
                mutableState = mutableState2;
                i5 = i7;
                Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return BlockingModeSettingsScreenKt.w(brushM, viewState, j4, mutableState, jR, painterC, painterC3, mutableState3, (DrawScope) obj2);
                    }
                };
                blockingModeSettingsViewState = viewState;
                j3 = j4;
                i6 = 2;
                composerK.w(function1);
                objG3 = function1;
            } else {
                mutableState = mutableState2;
                j3 = j4;
                i6 = 2;
                r11 = 0;
                blockingModeSettingsViewState = viewState;
                i5 = i7;
            }
            CanvasKt.b(modifierF, (Function1) objG3, composerK, 6);
            if (t(mutableState)) {
                composerK.a0(555607806);
                int i8 = i6;
                AnimatedVisibilityKt.j(blockingModeSettingsViewState.d(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, r11, null, 6, null), 0.0f, i8, null), EnterExitTransitionKt.q(AnimationSpecKt.n(1500, r11, null, 6, null), 0.0f, i8, null), null, ComposableLambdaKt.e(-1081501037, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.m
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return BlockingModeSettingsScreenKt.x(blockingModeSettingsViewState, painterC2, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerK, 54), composerK, 200064, 18);
                composer2 = composerK;
            } else {
                composer2 = composerK;
                composer2.a0(540671324);
            }
            composer2.U();
            BoxKt.a(BackgroundKt.b(SizeKt.f(companion3, 0.0f, 1, null), Brush.Companion.m(companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.f25715b.j()), Color.n(Color.r(j3, 0.2f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(ComposeColorsKt.j(composer2, r11).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer2, r11);
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(PaddingKt.i(companion3, Dp.g(f3)), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null);
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), r11);
            int iA = ComposablesKt.a(composer2, r11);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierM);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyG, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion5.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Painter painterC4 = PainterResources_androidKt.c(R.drawable.C1, composer2, r11);
            long jQ0 = ComposeColorsKt.j(composer2, r11).q0();
            Modifier modifierA = ClipKt.a(companion3, RoundedCornerShapeKt.d(Dp.g(f3)));
            ?? r7 = (i5 & 112) == 32 ? 1 : r11;
            Object objG4 = composer2.G();
            if (r7 != 0 || objG4 == companion2.a()) {
                onCloseClicked = function0;
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlockingModeSettingsScreenKt.z(onCloseClicked);
                    }
                };
                composer2.w(objG4);
            } else {
                onCloseClicked = function0;
            }
            IconKt.c(painterC4, null, boxScopeInstance.f(ClickableKt.f(modifierA, false, null, null, (Function0) objG4, 7, null), companion4.e()), jQ0, composer2, 48, 0);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            blockingModeSettingsViewState = viewState;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return BlockingModeSettingsScreenKt.A(blockingModeSettingsViewState, onCloseClicked, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final boolean t(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void u(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final List v(MutableState mutableState) {
        return (List) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Brush brush, BlockingModeSettingsViewState blockingModeSettingsViewState, long j3, MutableState mutableState, long j4, Painter painter, Painter painter2, MutableState mutableState2, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        DrawScope.k1(Canvas, brush, 0L, 0L, 0.0f, null, null, 0, 126, null);
        int i3 = 0;
        u(mutableState, Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) > 800.0f);
        if (t(mutableState)) {
            float f3 = 12;
            float f4 = 2;
            DrawScope drawScope = Canvas;
            int i4 = 32;
            DrawScope.f2(drawScope, Color.f25715b.a(), Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) / f3)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() >> 32)) / 7.5f)) << 32)), Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * f4)) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (Canvas.b() >> 32)) / 1.35f)) << 32)), CornerRadius.b((((long) Float.floatToRawIntBits(100.0f)) << 32) | (((long) Float.floatToRawIntBits(100.0f)) & 4294967295L)), null, 0.0f, null, 0, 240, null);
            int i5 = 7;
            int i6 = 3;
            if (blockingModeSettingsViewState.i()) {
                Iterator it = blockingModeSettingsViewState.h().iterator();
                while (true) {
                    int i7 = i3;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    i3 = i7 + 1;
                    if (i7 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    boolean zBooleanValue = ((Boolean) next).booleanValue();
                    float f5 = i4;
                    long jD = Size.d((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f5)))) & 4294967295L) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f5)))) << i4));
                    float f6 = i6;
                    float f7 = i5;
                    float f8 = i7;
                    long jE = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.b() >> i4)) / f6)) << i4) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / f7) + (Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) * f8 * 0.11f))) & 4294967295L));
                    float f9 = 8;
                    float fM1 = drawScope.M1(Dp.g(f9));
                    float fM12 = drawScope.M1(Dp.g(f9));
                    int i8 = i4;
                    drawScope = Canvas;
                    DrawScope.f2(drawScope, j3, jE, jD, CornerRadius.b((((long) Float.floatToRawIntBits(fM1)) << i8) | (((long) Float.floatToRawIntBits(fM12)) & 4294967295L)), null, 0.0f, null, 0, 240, null);
                    Stroke stroke = new Stroke(drawScope.M1(Dp.g(10)), 0.0f, 0, 0, null, 30, null);
                    long jM = ((Size) v(mutableState2).get(i7)).m();
                    float f10 = 16;
                    DrawScope.f2(drawScope, j4, Offset.e((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / f7) + (f8 * Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) * 0.11f) + drawScope.M1(Dp.g(f10)))) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() >> i8)) / f4) - drawScope.M1(Dp.g(f3)))) << i8)), jM, CornerRadius.b((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f9)))) & 4294967295L) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f9)))) << i8)), stroke, 0.0f, null, 0, 224, null);
                    if (zBooleanValue) {
                        float fIntBitsToFloat = (Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / f7) + (f8 * Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) * 0.11f);
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.b() >> i8)) / f6;
                        drawScope.Q1().e().e(fIntBitsToFloat2, fIntBitsToFloat);
                        try {
                            Painter.k(painter, drawScope, Size.d((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f5)))) & 4294967295L) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f5)))) << i8)), 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, Color.r(Color.f25715b.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null), 2, null);
                            drawScope.Q1().e().e(-fIntBitsToFloat2, -fIntBitsToFloat);
                            Unit unit = Unit.f139807a;
                            float f11 = 4;
                            float fIntBitsToFloat3 = ((Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / f7) + ((f8 * Float.intBitsToFloat((int) (drawScope.b() & 4294967295L))) * 0.11f)) - drawScope.M1(Dp.g(f11));
                            float fIntBitsToFloat4 = (Float.intBitsToFloat((int) (drawScope.b() >> i8)) / f11) - drawScope.M1(Dp.g(20));
                            drawScope.Q1().e().e(fIntBitsToFloat4, fIntBitsToFloat3);
                            float f12 = 40;
                            try {
                                Painter.k(painter2, drawScope, Size.d((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f12)))) << i8) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f12)))) & 4294967295L)), 0.0f, null, 6, null);
                            } finally {
                                drawScope.Q1().e().e(-fIntBitsToFloat4, -fIntBitsToFloat3);
                            }
                        } catch (Throwable th) {
                            drawScope.Q1().e().e(-fIntBitsToFloat2, -fIntBitsToFloat);
                            throw th;
                        }
                    } else {
                        Stroke stroke2 = new Stroke(drawScope.M1(Dp.g(f4)), 0.0f, 0, 0, null, 30, null);
                        DrawScope.e2(drawScope, j4, drawScope.M1(Dp.g(f10)), Offset.e((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / f7) + (Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) * f8 * 0.11f) + drawScope.M1(Dp.g(f10)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawScope.b() >> i8)) / 4)) << i8)), 0.0f, stroke2, null, 0, 104, null);
                    }
                    i4 = i8;
                    i5 = 7;
                    i6 = 3;
                }
            } else {
                int i9 = 10;
                int i10 = 4;
                int i11 = 0;
                while (i11 < i10) {
                    int i12 = 0;
                    for (int i13 = 3; i12 < i13; i13 = 3) {
                        float f13 = 64;
                        long jD2 = Size.d((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f13)))) << 32) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f13)))) & 4294967295L));
                        float f14 = i9;
                        DrawScope.f2(drawScope, j3, Offset.e((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) / 7) + (i11 * Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) * 0.19f) + drawScope.M1(Dp.g(i10)))) & 4294967295L) | (((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (drawScope.b() >> 32)) / 5) + ((i12 * Float.intBitsToFloat((int) (drawScope.b() >> 32))) * 0.22f))) << 32)), jD2, CornerRadius.b((((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f14)))) & 4294967295L) | (((long) Float.floatToRawIntBits(drawScope.M1(Dp.g(f14)))) << 32)), null, 0.0f, null, 0, 240, null);
                        i12++;
                        drawScope = Canvas;
                        i9 = i9;
                        i10 = i10;
                    }
                    i11++;
                    drawScope = Canvas;
                }
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(final BlockingModeSettingsViewState blockingModeSettingsViewState, final Painter painter, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1081501037, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.blockingmode.BlockListAllowListCanvas.<anonymous> (BlockingModeSettingsScreen.kt:350)");
        }
        Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
        boolean Z = composer.Z(blockingModeSettingsViewState) | composer.I(painter);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.blockingmode.b
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BlockingModeSettingsScreenKt.y(blockingModeSettingsViewState, painter, (DrawScope) obj);
                }
            };
            composer.w(objG);
        }
        CanvasKt.b(modifierF, (Function1) objG, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(BlockingModeSettingsViewState blockingModeSettingsViewState, Painter painter, DrawScope drawScope) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        DrawScope Canvas = drawScope;
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        int i8 = 10;
        int i9 = 7;
        int i10 = 5;
        int i11 = 64;
        int i12 = 3;
        int i13 = 4;
        if (blockingModeSettingsViewState.e() == Profile.BlockingMode.Blocklist) {
            int i14 = 0;
            int i15 = 0;
            while (i14 < 2) {
                int i16 = 0;
                while (i16 < i12) {
                    if (i15 == i13) {
                        return Unit.f139807a;
                    }
                    int i17 = i15 + 1;
                    Color.Companion companion = Color.f25715b;
                    long jR = Color.r(companion.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                    float f3 = i11;
                    float fM1 = Canvas.M1(Dp.g(f3));
                    long jD = Size.d((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f3)))) & 4294967295L) | (Float.floatToRawIntBits(fM1) << 32));
                    float f4 = i10;
                    float f5 = i16;
                    float fIntBitsToFloat = (Float.intBitsToFloat((int) (Canvas.b() >> 32)) / f4) + (Float.intBitsToFloat((int) (Canvas.b() >> 32)) * f5 * 0.22f);
                    float f6 = i9;
                    int i18 = i16;
                    float f7 = i14;
                    long jE = Offset.e((((long) Float.floatToRawIntBits((Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) / f6) + (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * f7 * 0.19f) + Canvas.M1(Dp.g(i13)))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
                    float f8 = i8;
                    int i19 = i14;
                    DrawScope.f2(Canvas, jR, jE, jD, CornerRadius.b((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f8)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f8)))) & 4294967295L)), null, 0.0f, null, 0, 240, null);
                    float fIntBitsToFloat2 = (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) / f6) + (f7 * Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * 0.19f) + Canvas.M1(Dp.g(f8));
                    float fIntBitsToFloat3 = (Float.intBitsToFloat((int) (Canvas.b() >> 32)) / f4) + (f5 * Float.intBitsToFloat((int) (Canvas.b() >> 32)) * 0.22f) + Canvas.M1(Dp.g(6));
                    Canvas.Q1().e().e(fIntBitsToFloat3, fIntBitsToFloat2);
                    float f9 = 52;
                    try {
                        Painter.k(painter, Canvas, Size.d((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f9)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f9)))) & 4294967295L)), 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, Color.r(companion.l(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null), 2, null);
                        Canvas.Q1().e().e(-fIntBitsToFloat3, -fIntBitsToFloat2);
                        i16 = i18 + 1;
                        i15 = i17;
                        i14 = i19;
                        i8 = 10;
                        i9 = 7;
                        i10 = 5;
                        i11 = 64;
                        i12 = 3;
                        i13 = 4;
                    } catch (Throwable th) {
                        Canvas.Q1().e().e(-fIntBitsToFloat3, -fIntBitsToFloat2);
                        throw th;
                    }
                }
                i14++;
                i8 = 10;
                i9 = 7;
                i10 = 5;
                i11 = 64;
                i12 = 3;
                i13 = 4;
            }
        } else {
            int i20 = 6;
            int i21 = 0;
            int i22 = 0;
            int i23 = 4;
            while (i21 < i23) {
                int i24 = 0;
                int i25 = 3;
                while (i24 < i25) {
                    int i26 = i22 + 1;
                    if (i26 > i23) {
                        Color.Companion companion2 = Color.f25715b;
                        long jR2 = Color.r(companion2.a(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null);
                        float f10 = 64;
                        long jD2 = Size.d((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f10)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f10)))) & 4294967295L));
                        float f11 = 5;
                        float f12 = i24;
                        float fIntBitsToFloat4 = (Float.intBitsToFloat((int) (Canvas.b() >> 32)) / f11) + (Float.intBitsToFloat((int) (Canvas.b() >> 32)) * f12 * 0.22f);
                        float f13 = 7;
                        float f14 = i21;
                        float fIntBitsToFloat5 = (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) / f13) + (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * f14 * 0.19f) + Canvas.M1(Dp.g(i23));
                        long jFloatToRawIntBits = Float.floatToRawIntBits(fIntBitsToFloat4);
                        int i27 = i24;
                        long jE2 = Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat5)) & 4294967295L) | (jFloatToRawIntBits << 32));
                        float f15 = 10;
                        i6 = i27;
                        i5 = 4;
                        i7 = 3;
                        i3 = i21;
                        int i28 = i20;
                        i4 = i26;
                        DrawScope.f2(Canvas, jR2, jE2, jD2, CornerRadius.b((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f15)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f15)))) & 4294967295L)), null, 0.0f, null, 0, 240, null);
                        float fIntBitsToFloat6 = (Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) / f13) + (f14 * Float.intBitsToFloat((int) (Canvas.b() & 4294967295L)) * 0.19f) + Canvas.M1(Dp.g(f15));
                        float fIntBitsToFloat7 = (Float.intBitsToFloat((int) (Canvas.b() >> 32)) / f11) + (f12 * Float.intBitsToFloat((int) (Canvas.b() >> 32)) * 0.22f) + Canvas.M1(Dp.g(i28));
                        Canvas.Q1().e().e(fIntBitsToFloat7, fIntBitsToFloat6);
                        float f16 = 52;
                        try {
                            i20 = i28;
                            Painter.k(painter, Canvas, Size.d((((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f16)))) << 32) | (((long) Float.floatToRawIntBits(Canvas.M1(Dp.g(f16)))) & 4294967295L)), 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, Color.r(companion2.l(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null), 2, null);
                        } finally {
                            drawScope.Q1().e().e(-fIntBitsToFloat7, -fIntBitsToFloat6);
                        }
                    } else {
                        i3 = i21;
                        i4 = i26;
                        i5 = i23;
                        i6 = i24;
                        i7 = i25;
                    }
                    i24 = i6 + 1;
                    Canvas = drawScope;
                    i22 = i4;
                    i21 = i3;
                    i23 = i5;
                    i25 = i7;
                }
                i21++;
                Canvas = drawScope;
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }
}
