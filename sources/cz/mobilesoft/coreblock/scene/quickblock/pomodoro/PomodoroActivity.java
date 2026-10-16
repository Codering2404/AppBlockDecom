package cz.mobilesoft.coreblock.scene.quickblock.pomodoro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
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
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.dashboard.card.QuickBlockCardKt;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewModel;
import cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroViewState;
import cz.mobilesoft.coreblock.storage.room.entity.core.PomodoroHistory;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PomodoroActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f114048f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f114049g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, boolean z2, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                z2 = false;
            }
            return companion.a(context, z2);
        }

        public final Intent a(Context context, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent(context, (Class<?>) PomodoroActivity.class);
            intent.putExtra("IS_NEW_PROFILE", z2);
            return intent;
        }

        private Companion() {
        }
    }

    private final void N0(final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Function1 function12;
        Composer composer2;
        Composer composer3;
        int i5;
        int i6;
        boolean z2;
        int i7;
        int i8;
        int i9;
        Composer composer4;
        int i10;
        Composer composerK = composer.k(371260133);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(mutableState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(mutableState3) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(timePickerViewModel) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(timePickerViewState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            function12 = function1;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(this) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(371260133, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.BottomSheetContent (PomodoroActivity.kt:336)");
            }
            if (((Boolean) mutableState3.getValue()).booleanValue()) {
                composerK.a0(670276290);
                i5 = 655590877;
                final Function1 function13 = function12;
                i6 = 54;
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(-935529623, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.b
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return PomodoroActivity.O0(this.f114151a, timePickerViewModel, timePickerViewState, mutableState3, function13, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composerK, 54);
                boolean z3 = (i4 & 896) == 256;
                Object objG = composerK.G();
                if (z3 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.c
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PomodoroActivity.Q0(mutableState3);
                        }
                    };
                    composerK.w(objG);
                }
                Function0 function0 = (Function0) objG;
                z2 = true;
                i7 = 32;
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, function0, composerK, 3456, 19);
                composer3 = composerK;
            } else {
                composer3 = composerK;
                i5 = 655590877;
                i6 = 54;
                z2 = true;
                i7 = 32;
                composer3.a0(655590877);
            }
            composer3.U();
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composer3.a0(671177553);
                int i11 = i5;
                i9 = i4;
                int i12 = i6;
                ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(1659033746, z2, new Function4() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.d
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return PomodoroActivity.R0(this.f114159a, timePickerViewModel, timePickerViewState, mutableState, function1, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer3, i12);
                boolean z4 = (i9 & 14) == 4 ? z2 : false;
                Object objG2 = composer3.G();
                if (z4 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PomodoroActivity.T0(mutableState);
                        }
                    };
                    composer3.w(objG2);
                }
                i8 = i11;
                Composer composer5 = composer3;
                i10 = i12;
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE2, null, (Function0) objG2, composer5, 3456, 19);
                composer4 = composer5;
            } else {
                i8 = i5;
                i9 = i4;
                composer4 = composer3;
                i10 = i6;
                composer4.a0(i8);
            }
            composer4.U();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composer4.a0(672064401);
                ComposableLambda composableLambdaE3 = ComposableLambdaKt.e(770996209, z2, new Function4() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.f
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return PomodoroActivity.U0(this.f114167a, timePickerViewModel, timePickerViewState, mutableState2, function1, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer4, i10);
                boolean z5 = (i9 & 112) == i7 ? z2 : false;
                Object objG3 = composer4.G();
                if (z5 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PomodoroActivity.W0(mutableState2);
                        }
                    };
                    composer4.w(objG3);
                }
                composer2 = composer4;
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE3, null, (Function0) objG3, composer2, 3456, 19);
            } else {
                composer2 = composer4;
                composer2.a0(i8);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.X0(this.f114175a, mutableState, mutableState2, mutableState3, timePickerViewModel, timePickerViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(PomodoroActivity pomodoroActivity, TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, MutableState mutableState, final Function1 function1, ColumnScope AppBottomSheet, SheetState unused$var$, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-935529623, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.BottomSheetContent.<anonymous> (PomodoroActivity.kt:341)");
            }
            String strB = StringResources_androidKt.b(R.string.uo, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.P0(function1, timePickerViewState);
                    }
                };
                composer.w(objG);
            }
            pomodoroActivity.r1(strB, timePickerViewModel, timePickerViewState, mutableState, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new PomodoroViewEvent.SetPomodoroSessions(timePickerViewState.k() + 2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(PomodoroActivity pomodoroActivity, TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, MutableState mutableState, final Function1 function1, ColumnScope AppBottomSheet, SheetState unused$var$, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1659033746, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.BottomSheetContent.<anonymous> (PomodoroActivity.kt:361)");
            }
            String strB = StringResources_androidKt.b(R.string.no, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.o
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.S0(function1, timePickerViewState);
                    }
                };
                composer.w(objG);
            }
            pomodoroActivity.r1(strB, timePickerViewModel, timePickerViewState, mutableState, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new PomodoroViewEvent.SetPomodoroFocus(timePickerViewState.o()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(PomodoroActivity pomodoroActivity, TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, MutableState mutableState, final Function1 function1, ColumnScope AppBottomSheet, SheetState unused$var$, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(unused$var$, "$unused$var$");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(770996209, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.BottomSheetContent.<anonymous> (PomodoroActivity.kt:381)");
            }
            String strB = StringResources_androidKt.b(R.string.ko, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.V0(function1, timePickerViewState);
                    }
                };
                composer.w(objG);
            }
            pomodoroActivity.r1(strB, timePickerViewModel, timePickerViewState, mutableState, (Function0) objG, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new PomodoroViewEvent.SetPomodoroBreak(timePickerViewState.o()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(PomodoroActivity pomodoroActivity, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, Function1 function1, int i3, Composer composer, int i4) {
        pomodoroActivity.N0(mutableState, mutableState2, mutableState3, timePickerViewModel, timePickerViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void Y0(final PomodoroViewModel pomodoroViewModel, final Function1 function1, final MutableState mutableState, final boolean z2, Composer composer, final int i3) {
        int i4;
        MutableState mutableState2;
        Composer composer2;
        Composer composerK = composer.k(1717529078);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(pomodoroViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            mutableState2 = mutableState;
            i4 |= composerK.Z(mutableState2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            mutableState2 = mutableState;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(this) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        int i5 = i4;
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1717529078, i5, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.CommandProcessor (PomodoroActivity.kt:130)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            PomodoroViewModel.PomodoroDto pomodoroDto = new PomodoroViewModel.PomodoroDto(0L, 0L, 0);
            boolean z3 = (i5 & 112) == 32;
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.z
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PomodoroActivity.Z0(function1, (ActivityResult) obj, (PomodoroViewModel.PomodoroDto) obj2);
                    }
                };
                composerK.w(objG);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(pomodoroDto, (Function2) objG, composerK, 0);
            boolean zI = composerK.I(context) | composerK.I(this) | ((i5 & 896) == 256) | composerK.I(activityLauncherP) | ((i5 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                PomodoroActivity$CommandProcessor$1$1 pomodoroActivity$CommandProcessor$1$1 = new PomodoroActivity$CommandProcessor$1$1(context, this, mutableState2, activityLauncherP, z2, null);
                composerK.w(pomodoroActivity$CommandProcessor$1$1);
                objG2 = pomodoroActivity$CommandProcessor$1$1;
            }
            composer2 = composerK;
            FlowExtKt.j(pomodoroViewModel, null, (Function2) objG2, composer2, i5 & 14, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.a0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.a1(this.f114145a, pomodoroViewModel, function1, mutableState, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function1 function1, ActivityResult result, PomodoroViewModel.PomodoroDto value) {
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(value, "value");
        if (result.d() == -1) {
            function1.invoke(new PomodoroViewEvent.OnPermissionsGranted(value));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(PomodoroActivity pomodoroActivity, PomodoroViewModel pomodoroViewModel, Function1 function1, MutableState mutableState, boolean z2, int i3, Composer composer, int i4) {
        pomodoroActivity.Y0(pomodoroViewModel, function1, mutableState, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void b1(final Context context, final PomodoroViewState pomodoroViewState, final Function1 function1, final TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, Composer composer, final int i3) {
        int i4;
        PomodoroViewState pomodoroViewState2;
        TimePickerViewModel timePickerViewModel2;
        PomodoroActivity pomodoroActivity;
        Composer composer2;
        Composer composerK = composer.k(1839411420);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            pomodoroViewState2 = pomodoroViewState;
            i4 |= composerK.Z(pomodoroViewState2) ? 32 : 16;
        } else {
            pomodoroViewState2 = pomodoroViewState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            timePickerViewModel2 = timePickerViewModel;
            i4 |= composerK.I(timePickerViewModel2) ? 2048 : 1024;
        } else {
            timePickerViewModel2 = timePickerViewModel;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(timePickerViewState) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            pomodoroActivity = this;
            i4 |= composerK.I(pomodoroActivity) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            pomodoroActivity = this;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1839411420, i5, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content (PomodoroActivity.kt:166)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState3 = (MutableState) objG3;
            final PomodoroViewState pomodoroViewState3 = pomodoroViewState2;
            final PomodoroActivity pomodoroActivity2 = pomodoroActivity;
            final TimePickerViewModel timePickerViewModel3 = timePickerViewModel2;
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(1257770679, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.c1(context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(220760278, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.e1(function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(271393758, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.x
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PomodoroActivity.g1(pomodoroViewState3, timePickerViewModel3, context, pomodoroActivity2, function1, mutableState, mutableState2, mutableState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3456, 12582912, 131059);
            N0(mutableState, mutableState2, mutableState3, timePickerViewModel, timePickerViewState, function1, composer2, ((i5 << 3) & 3670016) | (i5 & 7168) | 438 | (57344 & i5) | ((i5 << 9) & 458752));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.k1(this.f114226a, context, pomodoroViewState, function1, timePickerViewModel, timePickerViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(final Context context, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1257770679, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content.<anonymous> (PomodoroActivity.kt:173)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.h());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            boolean zI = composer.I(context);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.b0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.d1(context);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 252);
            TextKt.c(StringResources_androidKt.b(R.string.zD, composer, 0), boxScopeInstance.f(companion, companion2.e()), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65528);
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
    public static final Unit d1(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(220760278, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content.<anonymous> (PomodoroActivity.kt:192)");
            }
            String strB = StringResources_androidKt.b(R.string.bA, composer, 0);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.f1(function1);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composer, 0, 29);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Function1 function1) {
        function1.invoke(PomodoroViewEvent.StartPomodoro.f114067a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(PomodoroViewState pomodoroViewState, final TimePickerViewModel timePickerViewModel, final Context context, final PomodoroActivity pomodoroActivity, Function1 function1, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, PaddingValues innerPadding, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(innerPadding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(271393758, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content.<anonymous> (PomodoroActivity.kt:200)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(PaddingKt.h(companion, innerPadding), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.jo, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65530);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.mo, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.f95845t, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            List listListOf = CollectionsKt.listOf((Object[]) new PomodoroViewState.PomodoroConfiguration[]{pomodoroViewState.e(), pomodoroViewState.d(), pomodoroViewState.g()});
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PomodoroActivity.h1(this.f114183a, (PomodoroViewState.PomodoroConfiguration) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PomodoroActivity.i1(context, (PomodoroViewState.PomodoroConfiguration) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            long jL = ComposeColorsKt.j(composer, 0).L();
            Color colorN = Color.n(ComposeColorsKt.j(composer, 0).q());
            long jQ = ComposeColorsKt.j(composer, 0).q();
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            boolean zI = composer.I(timePickerViewModel);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PomodoroActivity.j1(timePickerViewModel, mutableState, mutableState2, mutableState3, (PomodoroViewState.PomodoroConfiguration) obj, ((Integer) obj2).intValue());
                    }
                };
                composer.w(objG);
            }
            SectionedItemKt.f0(listListOf, function3, function32, null, null, null, null, null, null, null, null, null, null, false, true, false, jL, colorN, null, jQ, textStyleH, textStyleI, 0L, null, null, (Function2) objG, composer, 0, 24576, 0, 14835708);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.c(R.string.qo, new Object[]{pomodoroViewState.i(context), pomodoroViewState.c(context)}, composer, 0), SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).M(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.b()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            pomodoroActivity.l1(context, pomodoroViewState, function1, composer, 0);
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
    public static final String h1(PomodoroActivity pomodoroActivity, PomodoroViewState.PomodoroConfiguration it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(948599470);
        if (ComposerKt.M()) {
            ComposerKt.U(948599470, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content.<anonymous>.<anonymous>.<anonymous> (PomodoroActivity.kt:237)");
        }
        String string = pomodoroActivity.getString(it.b());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String i1(Context context, PomodoroViewState.PomodoroConfiguration it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(194575181);
        if (ComposerKt.M()) {
            ComposerKt.U(194575181, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.Content.<anonymous>.<anonymous>.<anonymous> (PomodoroActivity.kt:238)");
        }
        String strA = it.a(context);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(TimePickerViewModel timePickerViewModel, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, PomodoroViewState.PomodoroConfiguration item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        if (item instanceof PomodoroViewState.PomodoroConfiguration.Focus) {
            TimePickerViewModel.p1(timePickerViewModel, new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(5L, 90L, 5L), null, null, false, null, false, 62, null), Long.valueOf(((PomodoroViewState.PomodoroConfiguration.Focus) item).d()), null, false, 12, null);
            mutableState.setValue(Boolean.TRUE);
        } else if (item instanceof PomodoroViewState.PomodoroConfiguration.Break) {
            TimePickerViewModel.p1(timePickerViewModel, new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(5L, 90L, 5L), null, null, false, null, false, 62, null), Long.valueOf(((PomodoroViewState.PomodoroConfiguration.Break) item).d()), null, false, 12, null);
            mutableState2.setValue(Boolean.TRUE);
        } else {
            if (!(item instanceof PomodoroViewState.PomodoroConfiguration.Sessions)) {
                throw new NoWhenBranchMatchedException();
            }
            TimePickerViewModel.p1(timePickerViewModel, new TimePickerConfig(null, null, null, false, new TimePickerConfig.TimePickerType.Custom(2L, 10L, ((PomodoroViewState.PomodoroConfiguration.Sessions) item).d() - 2), false, 47, null), null, null, false, 14, null);
            mutableState3.setValue(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(PomodoroActivity pomodoroActivity, Context context, PomodoroViewState pomodoroViewState, Function1 function1, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, int i3, Composer composer, int i4) {
        pomodoroActivity.b1(context, pomodoroViewState, function1, timePickerViewModel, timePickerViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void l1(final Context context, final PomodoroViewState pomodoroViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        PomodoroViewState pomodoroViewState2;
        final Function1 function12 = function1;
        Composer composerK = composer.k(1078218518);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            pomodoroViewState2 = pomodoroViewState;
            i4 |= composerK.Z(pomodoroViewState2) ? 32 : 16;
        } else {
            pomodoroViewState2 = pomodoroViewState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function12) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1078218518, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.HistoryContent (PomodoroActivity.kt:432)");
            }
            if (pomodoroViewState2.f().isEmpty()) {
                composerK.a0(-870675764);
            } else {
                composerK.a0(-852270537);
                TextKt.c(StringResources_androidKt.b(R.string.Hf, composerK, 0), null, ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65530);
                composerK = composerK;
                Modifier.Companion companion = Modifier.b8;
                float f3 = 0.0f;
                Object obj = null;
                Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(12)), Alignment.f25072a.k(), composerK, 6);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
                SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composerK, 6);
                composerK.a0(280933025);
                Iterator it = pomodoroViewState.f().iterator();
                while (it.hasNext()) {
                    final PomodoroHistory pomodoroHistory = (PomodoroHistory) it.next();
                    Modifier.Companion companion3 = Modifier.b8;
                    float f4 = 16;
                    Modifier modifierA = ClipKt.a(BackgroundKt.c(SizeKt.i(SizeKt.h(companion3, f3, 1, obj), Dp.g(72)), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f4))), RoundedCornerShapeKt.d(Dp.g(f4)));
                    boolean Z = composerK.Z(pomodoroHistory) | ((i4 & 896) == 256);
                    Object objG = composerK.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.q
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return PomodoroActivity.m1(function12, pomodoroHistory);
                            }
                        };
                        composerK.w(objG);
                    }
                    Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), Dp.g(f4), f3, 2, obj);
                    Arrangement arrangement = Arrangement.f6574a;
                    Arrangement.Horizontal horizontalG = arrangement.g();
                    Alignment.Companion companion4 = Alignment.f25072a;
                    MeasurePolicy measurePolicyB = RowKt.b(horizontalG, companion4.l(), composerK, 0);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierK);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                    Function0 function0A2 = companion5.a();
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
                    Updater.e(composerA2, measurePolicyB, companion5.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                    Function2 function2B2 = companion5.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion5.f());
                    RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                    Modifier modifierD = rowScopeInstance.d(RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), companion4.i());
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion4.k(), composerK, 0);
                    int iA3 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU3 = composerK.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD);
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
                    Updater.e(composerA3, measurePolicyA2, companion5.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                    Function2 function2B3 = companion5.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion5.f());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                    String strL = DateHelper.l(context, pomodoroHistory.d(), false);
                    Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
                    Composer composer2 = composerK;
                    TextKt.c(strL, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, 0, 0, 65530);
                    int i5 = R.string.oo;
                    Integer numValueOf = Integer.valueOf(pomodoroHistory.f());
                    String strL2 = DateHelper.l(context, pomodoroHistory.c(), false);
                    Intrinsics.checkNotNullExpressionValue(strL2, "getRemainingTimeString(...)");
                    TextKt.c(StringResources_androidKt.c(i5, new Object[]{numValueOf, strL2}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 0, 0, 65530);
                    composerK = composer2;
                    composerK.y();
                    ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C5, composerK, 6), null, rowScopeInstance.d(SizeKt.v(companion3, Dp.g(32)), companion4.i()), null, null, 0.0f, null, composerK, 48, 120);
                    composerK.y();
                    i4 = i4;
                    f3 = 0.0f;
                    obj = null;
                    it = it;
                    function12 = function1;
                }
                composerK.U();
                composerK.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return PomodoroActivity.n1(this.f114199a, context, pomodoroViewState, function1, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Function1 function1, PomodoroHistory pomodoroHistory) {
        function1.invoke(new PomodoroViewEvent.OnHistorySelected(pomodoroHistory));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(PomodoroActivity pomodoroActivity, Context context, PomodoroViewState pomodoroViewState, Function1 function1, int i3, Composer composer, int i4) {
        pomodoroActivity.l1(context, pomodoroViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder o1() {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), null, null, false, null, false, 62, null), 0L, null, false, null, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(Function1 function1) {
        function1.invoke(PomodoroViewEvent.OnStrictModeConfirmedClicked.f114063a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q1(PomodoroActivity pomodoroActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        pomodoroActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void r1(final String str, final TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, final MutableState mutableState, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1830140938);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(timePickerViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(timePickerViewState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(mutableState) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1830140938, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.TimePickerSheet (PomodoroActivity.kt:405)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            TextKt.c(str, PaddingKt.i(companion, Dp.g(f3)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).h(), composerK, (i4 & 14) | 48, 0, 65532);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            ComposeSwipeableTimePickerKt.W(timePickerViewState, null, FlowExtKt.n(timePickerViewModel, composerK, (i4 >> 3) & 14), composerK, (i4 >> 6) & 14, 2);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composerK, 6);
            String strB = StringResources_androidKt.b(R.string.d8, composerK, 0);
            boolean z2 = ((i4 & 7168) == 2048) | ((57344 & i4) == 16384);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.s1(mutableState, function0);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG, composerK, 0, 29);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.t1(this.f114206a, str, timePickerViewModel, timePickerViewState, mutableState, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(PomodoroActivity pomodoroActivity, String str, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, MutableState mutableState, Function0 function0, int i3, Composer composer, int i4) {
        pomodoroActivity.r1(str, timePickerViewModel, timePickerViewState, mutableState, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
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
    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final PomodoroActivity pomodoroActivity;
        Bundle bundleB;
        Bundle bundleB2;
        PomodoroActivity pomodoroActivity2 = this;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-843438745);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(pomodoroActivity2) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-843438745, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.pomodoro.PomodoroActivity.RootCompose (PomodoroActivity.kt:78)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean booleanExtra = pomodoroActivity2.getIntent().getBooleanExtra("IS_NEW_PROFILE", false);
            composerK.F(-101221098);
            LocalViewModelStoreOwner localViewModelStoreOwner = LocalViewModelStoreOwner.f40240a;
            ViewModelStoreOwner viewModelStoreOwnerC = localViewModelStoreOwner.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            GlobalContext globalContext = GlobalContext.f145907a;
            Scope scopeD = globalContext.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB2 = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB2, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(PomodoroViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            PomodoroViewModel pomodoroViewModel = (PomodoroViewModel) viewModelA;
            PomodoroViewState pomodoroViewState = (PomodoroViewState) FlowExtKt.m(pomodoroViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(pomodoroViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.o1();
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC2 = localViewModelStoreOwner.c(composerK, 8);
            if (viewModelStoreOwnerC2 == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA3 = ViewModelComposeExtKt.a(viewModelStoreOwnerC2, composerK, 8);
            Scope scopeD2 = globalContext.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry2 = viewModelStoreOwnerC2 instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC2 : null;
            CreationExtras creationExtrasA4 = (navBackStackEntry2 == null || (bundleB = navBackStackEntry2.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC2);
            KClass kClassB2 = Reflection.b(TimePickerViewModel.class);
            ViewModelStore viewModelStore2 = viewModelStoreOwnerC2.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore2, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA2 = GetViewModelKt.a(kClassB2, viewModelStore2, null, creationExtrasA4 == null ? creationExtrasA3 : creationExtrasA4, null, scopeD2, function0);
            composerK.Y();
            composerK.Y();
            TimePickerViewModel timePickerViewModel = (TimePickerViewModel) viewModelA2;
            TimePickerViewState timePickerViewState = (TimePickerViewState) FlowExtKt.m(timePickerViewModel, composerK, 0);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState = (MutableState) objG2;
            pomodoroActivity2.Y0(pomodoroViewModel, function1N, mutableState, booleanExtra, composerK, ((i4 << 9) & 57344) | 384);
            PomodoroActivity pomodoroActivity3 = this;
            pomodoroActivity3.b1(context, pomodoroViewState, function1N, timePickerViewModel, timePickerViewState, composerK, (i4 << 12) & 458752);
            Composer composer3 = composerK;
            boolean Z = composer3.Z(function1N);
            Object objG3 = composer3.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PomodoroActivity.p1(function1N);
                    }
                };
                composer3.w(objG3);
            }
            QuickBlockCardKt.D1(mutableState, (Function0) objG3, composer3, 6);
            pomodoroActivity = pomodoroActivity3;
            composer2 = composer3;
            if (ComposerKt.M()) {
                ComposerKt.T();
                pomodoroActivity = pomodoroActivity3;
                composer2 = composer3;
            }
        } else {
            composerK.Q();
            pomodoroActivity = pomodoroActivity2;
            composer2 = composerK;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.pomodoro.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PomodoroActivity.q1(this.f114213a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
