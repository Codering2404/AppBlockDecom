package cz.mobilesoft.coreblock.scene.quickblock.timer;

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
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
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
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewEvent;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewState;
import cz.mobilesoft.coreblock.storage.room.entity.core.QuickBlockTimerHistory;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelper;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ChipKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewState;
import cz.mobilesoft.coreblock.view.timepicker.config.TimePickerConfiguration;
import java.io.IOException;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
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
public final class QuickBlockTimeSelectActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f114243g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f114244h = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TimePickerConfig f114245f = new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0, 0, 3, null), new TimePickerConfig.TimePickerType.Hours(0, 99, 1, null), null, false, null, false, 60, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Intent b(Companion companion, Context context, List list, boolean z2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            return companion.a(context, list, z2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v3, types: [java.io.Serializable, java.lang.Object[]] */
        public final Intent a(Context context, List history, boolean z2) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(history, "history");
            Intent intent = new Intent(context, (Class<?>) QuickBlockTimeSelectActivity.class);
            intent.putExtra("QUICK_BLOCK_HISTORY", (Serializable) history.toArray(new QuickBlockTimerHistory[0]));
            intent.putExtra("IS_NEW_PROFILE", z2);
            return intent;
        }

        private Companion() {
        }
    }

    private final void C0(final QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel, final TimePickerViewModel timePickerViewModel, final Function1 function1, final MutableState mutableState, final boolean z2, Composer composer, final int i3) {
        int i4;
        MutableState mutableState2;
        boolean z3;
        Composer composerK = composer.k(-1952362759);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(quickBlockTimeSelectViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(timePickerViewModel) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            mutableState2 = mutableState;
            i4 |= composerK.Z(mutableState2) ? 2048 : 1024;
        } else {
            mutableState2 = mutableState;
        }
        if ((i3 & 24576) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            z3 = z2;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(this) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        int i5 = i4;
        if (composerK.r((74899 & i5) != 74898, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1952362759, i5, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.CommandProcessor (QuickBlockTimeSelectActivity.kt:143)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            int i6 = i5 & 896;
            boolean z4 = i6 == 256;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.p
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockTimeSelectActivity.D0(function1, (ActivityResult) obj, ((Long) obj2).longValue());
                    }
                };
                composerK.w(objG);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(0L, (Function2) objG, composerK, 6);
            boolean zI = ((i5 & 7168) == 2048) | composerK.I(timePickerViewModel) | composerK.I(this) | composerK.I(context) | composerK.I(activityLauncherP) | ((57344 & i5) == 16384);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                QuickBlockTimeSelectActivity$CommandProcessor$1$1 quickBlockTimeSelectActivity$CommandProcessor$1$1 = new QuickBlockTimeSelectActivity$CommandProcessor$1$1(timePickerViewModel, this, context, mutableState2, activityLauncherP, z3, null);
                composerK.w(quickBlockTimeSelectActivity$CommandProcessor$1$1);
                objG2 = quickBlockTimeSelectActivity$CommandProcessor$1$1;
            }
            FlowExtKt.j(quickBlockTimeSelectViewModel, null, (Function2) objG2, composerK, i5 & 14, 1);
            boolean z5 = i6 == 256;
            Object objG3 = composerK.G();
            if (z5 || objG3 == Composer.f23746a.a()) {
                objG3 = new QuickBlockTimeSelectActivity$CommandProcessor$2$1(function1, null);
                composerK.w(objG3);
            }
            FlowExtKt.j(timePickerViewModel, null, (Function2) objG3, composerK, (i5 >> 3) & 14, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.E0(this.f114358a, quickBlockTimeSelectViewModel, timePickerViewModel, function1, mutableState, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(Function1 function1, ActivityResult result, long j3) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            function1.invoke(new QuickBlockTimeSelectViewEvent.OnPermissionsGranted(j3));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel, TimePickerViewModel timePickerViewModel, Function1 function1, MutableState mutableState, boolean z2, int i3, Composer composer, int i4) {
        quickBlockTimeSelectActivity.C0(quickBlockTimeSelectViewModel, timePickerViewModel, function1, mutableState, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void F0(final Context context, final QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, final Function1 function1, final TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, Composer composer, final int i3) {
        int i4;
        final QuickBlockTimeSelectViewState quickBlockTimeSelectViewState2;
        final TimePickerViewModel timePickerViewModel2;
        QuickBlockTimeSelectActivity quickBlockTimeSelectActivity;
        Composer composer2;
        Composer composerK = composer.k(-1380153296);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            quickBlockTimeSelectViewState2 = quickBlockTimeSelectViewState;
            i4 |= composerK.Z(quickBlockTimeSelectViewState2) ? 32 : 16;
        } else {
            quickBlockTimeSelectViewState2 = quickBlockTimeSelectViewState;
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
            quickBlockTimeSelectActivity = this;
            i4 |= composerK.I(quickBlockTimeSelectActivity) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            quickBlockTimeSelectActivity = this;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1380153296, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.Content (QuickBlockTimeSelectActivity.kt:196)");
            }
            final QuickBlockTimeSelectActivity quickBlockTimeSelectActivity2 = quickBlockTimeSelectActivity;
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(-2124148299, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.G0(context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), ComposableLambdaKt.e(1334024054, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.I0(timePickerViewState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-507740818, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QuickBlockTimeSelectActivity.K0(this.f114344a, context, quickBlockTimeSelectViewState2, function1, timePickerViewModel2, timePickerViewState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 3456, 12582912, 131059);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.N0(this.f114350a, context, quickBlockTimeSelectViewState, function1, timePickerViewModel, timePickerViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(final Context context, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2124148299, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.Content.<anonymous> (QuickBlockTimeSelectActivity.kt:200)");
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
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockTimeSelectActivity.H0(context);
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
    public static final Unit H0(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(final TimePickerViewState timePickerViewState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1334024054, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.Content.<anonymous> (QuickBlockTimeSelectActivity.kt:219)");
            }
            boolean z2 = timePickerViewState.o() > 0;
            String strB = StringResources_androidKt.b(R.string.bA, composer, 0);
            boolean Z = composer.Z(function1) | composer.Z(timePickerViewState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockTimeSelectActivity.J0(function1, timePickerViewState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.J(null, strB, z2, false, null, (Function0) objG, composer, 0, 25);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new QuickBlockTimeSelectViewEvent.OnConfirmClicked(timePickerViewState.o()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, final Context context, QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, final Function1 function1, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, PaddingValues innerPadding, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(innerPadding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-507740818, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.Content.<anonymous> (QuickBlockTimeSelectActivity.kt:228)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(PaddingKt.h(companion, innerPadding), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.rD, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).f(), composer, 0, 0, 65530);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.ur, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            float f5 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Hc, composer, 0), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            Modifier modifierC = BackgroundKt.c(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f3)));
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierC);
            Function0 function0A2 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A2);
            } else {
                composer2.v();
            }
            Composer composerA2 = Updater.a(composer2);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer2, 0);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierI);
            Function0 function0A3 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A3);
            } else {
                composer2.v();
            }
            Composer composerA3 = Updater.a(composer2);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            EnumEntries<QuickBlockTimeSelectViewState.TimePickerType> entries = QuickBlockTimeSelectViewState.TimePickerType.getEntries();
            int iOrdinal = quickBlockTimeSelectViewState.d().ordinal();
            boolean Z = composer2.Z(function1);
            Object objG = composer2.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.c
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return QuickBlockTimeSelectActivity.L0(function1, ((Integer) obj).intValue(), (QuickBlockTimeSelectViewState.TimePickerType) obj2);
                    }
                };
                composer2.w(objG);
            }
            ChipKt.o(null, false, 0.0f, entries, iOrdinal, 0L, (Function2) objG, null, new Function3() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.d
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return QuickBlockTimeSelectActivity.M0(context, (QuickBlockTimeSelectViewState.TimePickerType) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 0, 167);
            quickBlockTimeSelectActivity.V0(timePickerViewModel, timePickerViewState, composer2, 0);
            composer2.y();
            composer2.y();
            Modifier modifierI2 = SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f5));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA4 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU4 = composer2.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierI2);
            Function0 function0A4 = companion3.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A4);
            } else {
                composer2.v();
            }
            Composer composerA4 = Updater.a(composer2);
            Updater.e(composerA4, measurePolicyG2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            if (StringsKt.p0(timePickerViewState.e()) || !timePickerViewState.r()) {
                composer2.a0(-463476095);
            } else {
                composer2.a0(-450768513);
                SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer2, 6);
                TextKt.c(StringResources_androidKt.c(R.string.sD, new Object[]{timePickerViewState.e()}, composer2, 0), boxScopeInstance.f(SizeKt.h(companion, 0.0f, 1, null), companion2.f()), ComposeColorsKt.j(composer2, 0).M(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.b()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 0, 0, 65016);
                composer2 = composer;
            }
            composer2.U();
            composer2.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer2, 6);
            quickBlockTimeSelectActivity.O0(context, quickBlockTimeSelectViewState, function1, composer2, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer2, 6);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L0(Function1 function1, int i3, QuickBlockTimeSelectViewState.TimePickerType timePickerType) {
        Intrinsics.checkNotNullParameter(timePickerType, "timePickerType");
        function1.invoke(new QuickBlockTimeSelectViewEvent.TimePickerTypeSelected(timePickerType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String M0(Context context, QuickBlockTimeSelectViewState.TimePickerType SelectableChipRow, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(SelectableChipRow, "$this$SelectableChipRow");
        composer.a0(-1889316107);
        if (ComposerKt.M()) {
            ComposerKt.U(-1889316107, i3, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.Content.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (QuickBlockTimeSelectActivity.kt:279)");
        }
        String text = SelectableChipRow.getText(context);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return text;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, Context context, QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, Function1 function1, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, int i3, Composer composer, int i4) {
        quickBlockTimeSelectActivity.F0(context, quickBlockTimeSelectViewState, function1, timePickerViewModel, timePickerViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void O0(final Context context, final QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        QuickBlockTimeSelectViewState quickBlockTimeSelectViewState2;
        Composer composerK = composer.k(493688374);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            quickBlockTimeSelectViewState2 = quickBlockTimeSelectViewState;
            i4 |= composerK.Z(quickBlockTimeSelectViewState2) ? 32 : 16;
        } else {
            quickBlockTimeSelectViewState2 = quickBlockTimeSelectViewState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(493688374, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.HistoryContent (QuickBlockTimeSelectActivity.kt:330)");
            }
            if (quickBlockTimeSelectViewState2.c().isEmpty()) {
                composerK.a0(1488539532);
            } else {
                composerK.a0(1502594188);
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
                composerK.a0(-2020593885);
                Iterator it = quickBlockTimeSelectViewState.c().iterator();
                while (it.hasNext()) {
                    final QuickBlockTimerHistory quickBlockTimerHistory = (QuickBlockTimerHistory) it.next();
                    Modifier.Companion companion3 = Modifier.b8;
                    float f4 = 16;
                    Modifier modifierA = ClipKt.a(BackgroundKt.c(SizeKt.i(SizeKt.h(companion3, f3, 1, obj), Dp.g(72)), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f4))), RoundedCornerShapeKt.d(Dp.g(f4)));
                    boolean Z = composerK.Z(quickBlockTimerHistory) | ((i4 & 896) == 256);
                    Object objG = composerK.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return QuickBlockTimeSelectActivity.P0(function1, quickBlockTimerHistory);
                            }
                        };
                        composerK.w(objG);
                    }
                    Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), Dp.g(f4), f3, 2, obj);
                    Arrangement.Horizontal horizontalG = Arrangement.f6574a.g();
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
                    String strL = DateHelper.l(context, quickBlockTimerHistory.d(), false);
                    Intrinsics.checkNotNullExpressionValue(strL, "getRemainingTimeString(...)");
                    Composer composer2 = composerK;
                    TextKt.c(strL, rowScopeInstance.d(RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null), companion4.i()), ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, 0, 0, 65528);
                    composerK = composer2;
                    ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C5, composerK, 6), null, rowScopeInstance.d(SizeKt.v(companion3, Dp.g(32)), companion4.i()), null, null, 0.0f, null, composerK, 48, 120);
                    composerK.y();
                    it = it;
                    f3 = 0.0f;
                    obj = null;
                    i4 = i4;
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return QuickBlockTimeSelectActivity.Q0(this.f114325a, context, quickBlockTimeSelectViewState, function1, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(Function1 function1, QuickBlockTimerHistory quickBlockTimerHistory) {
        function1.invoke(new QuickBlockTimeSelectViewEvent.OnConfirmClicked(quickBlockTimerHistory.d()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, Context context, QuickBlockTimeSelectViewState quickBlockTimeSelectViewState, Function1 function1, int i3, Composer composer, int i4) {
        quickBlockTimeSelectActivity.O0(context, quickBlockTimeSelectViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder R0(QuickBlockTimerHistory[] quickBlockTimerHistoryArr) {
        List listEmptyList;
        if (quickBlockTimerHistoryArr == null || (listEmptyList = ArraysKt.toList(quickBlockTimerHistoryArr)) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        return ParametersHolderKt.b(listEmptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder S0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, QuickBlockTimerHistory quickBlockTimerHistory) {
        return ParametersHolderKt.b(new TimePickerViewModel.Params(quickBlockTimeSelectActivity.f114245f, quickBlockTimerHistory != null ? quickBlockTimerHistory.d() : TimeUnit.HOURS.toMillis(1L), null, true, null, 16, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Function1 function1, TimePickerViewState timePickerViewState) {
        function1.invoke(new QuickBlockTimeSelectViewEvent.OnStrictModeConfirmedClicked(timePickerViewState.o()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        quickBlockTimeSelectActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void V0(final TimePickerViewModel timePickerViewModel, final TimePickerViewState timePickerViewState, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-703491545);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(timePickerViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(timePickerViewState) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-703491545, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.TimePicker (QuickBlockTimeSelectActivity.kt:386)");
            }
            ComposeSwipeableTimePickerKt.W(timePickerViewState, TimePickerConfiguration.b(TimePickerConfiguration.f133137r.a(composerK, 6), 0, Color.f25715b.j(), null, Dp.g(0), 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, 0L, 0L, 0.0f, null, null, null, null, 131061, null), FlowExtKt.n(timePickerViewModel, composerK, i4 & 14), composerK, (i4 >> 3) & 14, 0);
            SpacerKt.a(SizeKt.v(Modifier.b8, Dp.g(16)), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.W0(this.f114330a, timePickerViewModel, timePickerViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, TimePickerViewModel timePickerViewModel, TimePickerViewState timePickerViewState, int i3, Composer composer, int i4) {
        quickBlockTimeSelectActivity.V0(timePickerViewModel, timePickerViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
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
        Bundle bundleB;
        Bundle bundleB2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(40768261);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(40768261, i4, -1, "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity.RootCompose (QuickBlockTimeSelectActivity.kt:87)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object serializableExtra = getIntent().getSerializableExtra("QUICK_BLOCK_HISTORY");
            final QuickBlockTimerHistory[] quickBlockTimerHistoryArr = serializableExtra instanceof QuickBlockTimerHistory[] ? (QuickBlockTimerHistory[]) serializableExtra : null;
            boolean booleanExtra = getIntent().getBooleanExtra("IS_NEW_PROFILE", false);
            boolean zI = composerK.I(quickBlockTimerHistoryArr);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockTimeSelectActivity.R0(quickBlockTimerHistoryArr);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
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
            KClass kClassB = Reflection.b(QuickBlockTimeSelectViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            if (creationExtrasA2 != null) {
                creationExtrasA = creationExtrasA2;
            }
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel = (QuickBlockTimeSelectViewModel) viewModelA;
            QuickBlockTimeSelectViewState quickBlockTimeSelectViewState = (QuickBlockTimeSelectViewState) FlowExtKt.m(quickBlockTimeSelectViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(quickBlockTimeSelectViewModel, composerK, 0);
            final QuickBlockTimerHistory quickBlockTimerHistory = quickBlockTimerHistoryArr != null ? (QuickBlockTimerHistory) ArraysKt.firstOrNull(quickBlockTimerHistoryArr) : null;
            boolean zI2 = composerK.I(this) | composerK.Z(quickBlockTimerHistory);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockTimeSelectActivity.S0(this.f114334a, quickBlockTimerHistory);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function02 = (Function0) objG2;
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
            ViewModel viewModelA2 = GetViewModelKt.a(kClassB2, viewModelStore2, null, creationExtrasA4 == null ? creationExtrasA3 : creationExtrasA4, null, scopeD2, function02);
            composerK.Y();
            composerK.Y();
            TimePickerViewModel timePickerViewModel = (TimePickerViewModel) viewModelA2;
            final TimePickerViewState timePickerViewState = (TimePickerViewState) FlowExtKt.m(timePickerViewModel, composerK, 0);
            Object objG3 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState = (MutableState) objG3;
            int i5 = (i4 << 12) & 458752;
            C0(quickBlockTimeSelectViewModel, timePickerViewModel, function1N, mutableState, booleanExtra, composerK, i5 | 3072);
            F0(context, quickBlockTimeSelectViewState, function1N, timePickerViewModel, timePickerViewState, composerK, i5);
            boolean Z = composerK.Z(function1N) | composerK.Z(timePickerViewState);
            Object objG4 = composerK.G();
            if (Z || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return QuickBlockTimeSelectActivity.T0(function1N, timePickerViewState);
                    }
                };
                composerK.w(objG4);
            }
            QuickBlockCardKt.D1(mutableState, (Function0) objG4, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.quickblock.timer.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return QuickBlockTimeSelectActivity.U0(this.f114338a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
