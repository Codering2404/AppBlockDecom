package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
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
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.material.OutlinedTextFieldKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.accompanist.systemuicontroller.SystemUiController;
import com.google.accompanist.systemuicontroller.SystemUiControllerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.valentinilk.shimmer.Shimmer;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.SchedulesSectionKt;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.condition.BaseConditionScreenKt;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.SubAppRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.ShimmerThemeKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCheckablesKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownKt;
import cz.mobilesoft.coreblock.view.compose.ComposePlaceHoldersKt;
import cz.mobilesoft.coreblock.view.compose.IconClusterKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
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
public final class DetailScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116569a;

        static {
            int[] iArr = new int[ScheduleViewState.DetailBottomSheetType.values().length];
            try {
                iArr[ScheduleViewState.DetailBottomSheetType.AdultContentBottomSheet.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ScheduleViewState.DetailBottomSheetType.CopyBlockingBottomSheet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f116569a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, LockType lockType) {
        function1.invoke(new ScheduleViewEvent.OnLockTypeClicked(lockType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(boolean z2, boolean z3, boolean z4, Function1 function1, int i3, Composer composer, int i4) {
        x0(z2, z3, z4, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void D0(final AppBlockingSettings appBlockingSettings, final Function1 onEvent, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        final Function1 function1;
        Composer composer2;
        Intrinsics.checkNotNullParameter(appBlockingSettings, "appBlockingSettings");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1803980863);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(appBlockingSettings) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1803980863, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.SettingsBottomSheet (DetailScreen.kt:450)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierD = WindowInsetsPaddingKt.d(PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, Dp.g(36), 5, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            float f4 = 24;
            int i5 = i4;
            TextKt.c(StringResources_androidKt.b(R.string.xD, composerK, 0), PaddingKt.k(companion, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 48, 0, 65528);
            TextKt.c(StringResources_androidKt.b(R.string.ar, composerK, 0), PaddingKt.j(companion, Dp.g(f4), Dp.g(f3)), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65528);
            boolean zB = composerK.b(appBlockingSettings.a());
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.j3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DetailScreenKt.E0(appBlockingSettings));
                    }
                });
                composerK.w(objG);
            }
            State state = (State) objG;
            boolean zB2 = composerK.b(appBlockingSettings.b());
            Object objG2 = composerK.G();
            if (zB2 || objG2 == Composer.f23746a.a()) {
                objG2 = SnapshotStateKt.e(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(DetailScreenKt.F0(appBlockingSettings));
                    }
                });
                composerK.w(objG2);
            }
            State state2 = (State) objG2;
            String strB = StringResources_androidKt.b(R.string.FD, composerK, 0);
            ImageVector.Companion companion3 = ImageVector.f26323k;
            ImageVector imageVectorB = VectorResources_androidKt.b(companion3, R.drawable.F0, composerK, 6);
            long jB = ComposeColorsKt.j(composerK, 0).b();
            float f5 = 8;
            Modifier modifierK = PaddingKt.k(companion, Dp.g(f5), 0.0f, 2, null);
            int i6 = i5 & 112;
            boolean z2 = i6 == 32;
            Object objG3 = composerK.G();
            if (z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.f4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailScreenKt.G0(onEvent, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG3);
            }
            ComposeCheckablesKt.l(modifierK, state, false, strB, null, null, 0.0f, imageVectorB, null, jB, false, null, null, false, false, false, null, (Function1) objG3, null, composerK, 6, 0, 392564);
            String strB2 = StringResources_androidKt.b(R.string.GD, composerK, 0);
            ImageVector imageVectorB2 = VectorResources_androidKt.b(companion3, R.drawable.U3, composerK, 6);
            long jB2 = ComposeColorsKt.j(composerK, 0).b();
            Modifier modifierK2 = PaddingKt.k(companion, Dp.g(f5), 0.0f, 2, null);
            boolean z3 = i6 == 32;
            Object objG4 = composerK.G();
            if (z3 || objG4 == Composer.f23746a.a()) {
                function1 = onEvent;
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.q4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailScreenKt.H0(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerK.w(objG4);
            } else {
                function1 = onEvent;
            }
            ComposeCheckablesKt.l(modifierK2, state2, false, strB2, null, null, 0.0f, imageVectorB2, null, jB2, false, null, null, false, false, false, null, (Function1) objG4, null, composerK, 6, 0, 392564);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onEvent;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.r4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.I0(appBlockingSettings, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E0(AppBlockingSettings appBlockingSettings) {
        return appBlockingSettings.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean F0(AppBlockingSettings appBlockingSettings) {
        return appBlockingSettings.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Function1 function1, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnAppBlockingSettingCheckedChanged(AppBlockingSetting.Launch, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Function1 function1, boolean z2) {
        function1.invoke(new ScheduleViewEvent.OnAppBlockingSettingCheckedChanged(AppBlockingSetting.Notifications, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(AppBlockingSettings appBlockingSettings, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        D0(appBlockingSettings, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void J0(final ColumnScope columnScope, ScheduleViewState.DetailViewState detailViewState, final List list, final ScheduleDescriptor scheduleDescriptor, final boolean z2, final boolean z3, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        ScheduleViewState.DetailViewState detailViewState2;
        Composer composer2;
        ScheduleViewState.DetailViewState detailViewState3;
        ScheduleDescriptor scheduleDescriptor2;
        Object obj;
        Composer composer3;
        int i5;
        Modifier.Companion companion;
        int i6;
        int i7;
        int i8;
        Modifier.Companion companion2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f3;
        int i14;
        Composer composer4;
        int i15;
        Function1 function12;
        int i16;
        int i17;
        Composer composerK = composer.k(-370824364);
        if ((i3 & 48) == 0) {
            i4 = (composerK.Z(detailViewState) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(scheduleDescriptor) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.b(z3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.I(function1) ? 1048576 : 524288;
        }
        int i18 = i4;
        if (composerK.r((599185 & i18) != 599184, i18 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-370824364, i18, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.SuccessContent (DetailScreen.kt:761)");
            }
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion3, 0.0f, 1, null);
            Brush.Companion companion4 = Brush.Companion;
            ScheduleEmoji.EmojiColor color = detailViewState.r().getColor();
            Color colorN = Color.n(Color.o(color != null ? Color.r(color.m1358getColor0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null) : Color.f25715b.j()));
            Color.Companion companion5 = Color.f25715b;
            Modifier modifierB = BackgroundKt.b(modifierH, Brush.Companion.m(companion4, CollectionsKt.listOf((Object[]) new Color[]{colorN, Color.n(Color.o(companion5.j()))}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
            ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
            Function0 function0A = companion6.a();
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
            Updater.e(composerA, measurePolicyA, companion6.e());
            Updater.e(composerA, compositionLocalMapU, companion6.g());
            Function2 function2B = companion6.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion6.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            BoxKt.a(BackgroundKt.d(SizeKt.h(SizeKt.i(WindowInsetsPaddingKt.d(companion3, WindowInsets_androidKt.d(WindowInsets.f7172a, composerK, 6)), Dp.g(56)), 0.0f, 1, null), companion5.j(), null, 2, null), composerK, 0);
            if (detailViewState.E()) {
                detailViewState3 = detailViewState;
                scheduleDescriptor2 = scheduleDescriptor;
                obj = null;
                composerK.a0(-711408220);
            } else {
                composerK.a0(-678477974);
                obj = null;
                p0(columnScopeInstance, detailViewState, scheduleDescriptor, function1, composerK, (i18 & 112) | 6 | ((i18 >> 3) & 896) | ((i18 >> 9) & 7168));
                detailViewState3 = detailViewState;
                scheduleDescriptor2 = scheduleDescriptor;
                SpacerKt.a(SizeKt.i(companion3, Dp.g(24)), composerK, 6);
            }
            composerK.U();
            composerK.y();
            if (detailViewState3.E()) {
                composerK.a0(-571096262);
                if (scheduleDescriptor2.b()) {
                    composerK.a0(120126976);
                    i17 = R.string.Vq;
                    i16 = 0;
                } else {
                    i16 = 0;
                    composerK.a0(120128579);
                    i17 = R.string.zD;
                }
                String strB = StringResources_androidKt.b(i17, composerK, i16);
                composerK.U();
                TextStyle textStyleF = ComposeTypographyKt.g(composerK, i16).f();
                int i19 = R.dimen.f95467a;
                Modifier modifierK = PaddingKt.k(companion3, PrimitiveResources_androidKt.a(i19, composerK, i16), 0.0f, 2, obj);
                i6 = 1;
                i5 = i18;
                i7 = 0;
                companion = companion3;
                TextKt.c(strB, modifierK, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65532);
                float f4 = 16;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
                i8 = 16;
                TextKt.c(StringResources_androidKt.b(R.string.Uq, composerK, 0), PaddingKt.k(companion, PrimitiveResources_androidKt.a(i19, composerK, 0), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65532);
                composer3 = composerK;
                SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer3, 6);
                StateInfoRowKt.y(detailViewState3, scheduleDescriptor2, function1, composer3, ((i5 >> 3) & 14) | ((i5 >> 6) & 112) | ((i5 >> 12) & 896));
            } else {
                composer3 = composerK;
                i5 = i18;
                companion = companion3;
                i6 = 1;
                i7 = 0;
                i8 = 16;
                composer3.a0(-604333842);
            }
            composer3.U();
            if (detailViewState3.u()) {
                composer3.a0(-570198781);
                Modifier.Companion companion7 = companion;
                companion2 = companion7;
                QuickBlockTileHintRowKt.d(PaddingKt.m(companion7, 0.0f, Dp.g(8), 0.0f, 0.0f, 13, null), function1, composer3, ((i5 >> 15) & 112) | 6);
                composer3.U();
                i9 = -604333842;
            } else {
                companion2 = companion;
                i9 = -604333842;
                composer3.a0(-604333842);
                composer3.U();
            }
            if (detailViewState3.E()) {
                i10 = i7;
                i11 = i9;
                i12 = i8;
                i13 = i6;
                composer3.a0(i11);
            } else {
                composer3.a0(-570024809);
                i11 = i9;
                i12 = i8;
                i10 = i7;
                i13 = i6;
                ConditionsRowKt.l(detailViewState3, !detailViewState3.F(), null, function1, composer3, ((i5 >> 3) & 14) | ((i5 >> 9) & 7168), 4);
            }
            composer3.U();
            if (detailViewState.i()) {
                composer3.a0(-569798478);
                BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.Qt, composer3, i10), composer3, i10);
            } else {
                composer3.a0(i11);
            }
            composer3.U();
            if (detailViewState.A()) {
                composer3.a0(-569661892);
                BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.Tt, composer3, i10), composer3, i10);
            } else {
                composer3.a0(i11);
            }
            composer3.U();
            if (detailViewState.z()) {
                composer3.a0(-569533893);
                BaseConditionScreenKt.n0(StringResources_androidKt.b(R.string.St, composer3, i10), composer3, i10);
            } else {
                composer3.a0(i11);
            }
            composer3.U();
            float f5 = i12;
            float f6 = i13;
            int i20 = i11;
            int i21 = i13;
            int i22 = i10;
            DividerKt.b(PaddingKt.j(companion2, Dp.g(f5), Dp.g(f5)), Dp.g(f6), ComposeColorsKt.j(composer3, i10).u(), composer3, 48, 0);
            int i23 = i5 >> 3;
            Composer composer5 = composer3;
            BlocklistOrAllowlistRowKt.d0(z3, detailViewState.d(), detailViewState.C(), z2, detailViewState.s(), function1, composer5, ((i5 >> 15) & 14) | (i23 & 7168) | (458752 & i23), 0);
            if (list.isEmpty()) {
                f3 = f6;
                i14 = i23;
                composer4 = composer5;
                i15 = i22;
                function12 = function1;
                composer4.a0(i20);
            } else {
                composer5.a0(-568875267);
                f3 = f6;
                i14 = i23;
                i15 = i22;
                ConflictingSchedulesRowKt.j(null, list, function1, composer5, (i23 & 112) | ((i5 >> 12) & 896), 1);
                function12 = function1;
                composer4 = composer5;
            }
            composer4.U();
            float fG = Dp.g(f5);
            Modifier.Companion companion8 = companion2;
            Composer composer6 = composer4;
            detailViewState2 = detailViewState;
            DividerKt.b(PaddingKt.j(companion2, Dp.g(f5), fG), Dp.g(f3), ComposeColorsKt.j(composer4, i15).u(), composer6, 48, 0);
            int i24 = i14 & 14;
            int i25 = (i5 >> 12) & 896;
            ExtraOptionsRowKt.v(detailViewState2, detailViewState2.d().b() == Profile.BlockingMode.Allowlist ? i21 : i15, function12, composer6, i24 | i25);
            DividerKt.b(PaddingKt.j(companion8, Dp.g(f5), Dp.g(f5)), Dp.g(f3), ComposeColorsKt.j(composer6, i15).u(), composer6, 48, 0);
            SettingsRowKt.h(!detailViewState2.F(), detailViewState2.c(), function12, composer6, i25, 0);
            composer2 = composer6;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            detailViewState2 = detailViewState;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final ScheduleViewState.DetailViewState detailViewState4 = detailViewState2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return DetailScreenKt.K0(columnScope, detailViewState4, list, scheduleDescriptor, z2, z3, function1, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K0(ColumnScope columnScope, ScheduleViewState.DetailViewState detailViewState, List list, ScheduleDescriptor scheduleDescriptor, boolean z2, boolean z3, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        J0(columnScope, detailViewState, list, scheduleDescriptor, z2, z3, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void L0(boolean z2, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        final boolean z4;
        Composer composerK = composer.k(1036279412);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            z4 = i6 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(1036279412, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ToolbarShimmer (DetailScreen.kt:504)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(16));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Shimmer shimmerA = ShimmerThemeKt.a(null, composerK, 0, 1);
            TextStyle textStyleA = ComposeTypographyKt.g(composerK, 0).a();
            Object objG = composerK.G();
            Composer.Companion companion3 = Composer.f23746a;
            if (objG == companion3.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailScreenKt.M0((Modifier) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion3.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailScreenKt.N0(columnScopeInstance, (Modifier) obj);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierS = ComposableExtKt.s(companion, z4, function1, (Function1) objG2);
            int i7 = Shimmer.f93784d;
            ComposePlaceHoldersKt.h(modifierS, null, textStyleA, 0L, shimmerA, composerK, i7 << 12, 10);
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composerK, 6);
            ComposePlaceHoldersKt.h(SizeKt.h(companion, 0.0f, 1, null), null, ComposeTypographyKt.g(composerK, 0).f(), 0L, shimmerA, composerK, (i7 << 12) | 6, 10);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.O0(z4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier M0(Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        return SizeKt.h(applyIfElse, 0.0f, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier N0(ColumnScope columnScope, Modifier applyIfElse) {
        Intrinsics.checkNotNullParameter(applyIfElse, "$this$applyIfElse");
        columnScope.c(applyIfElse, Alignment.f25072a.j());
        SizeKt.A(applyIfElse, Dp.g(96));
        return SizeKt.i(applyIfElse, Dp.g(32));
    }

    private static final void O(final PaddingValues paddingValues, ScheduleViewState scheduleViewState, final boolean z2, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        ScheduleViewState scheduleViewState2;
        boolean z3;
        Composer composerK = composer.k(-1594979224);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            scheduleViewState2 = scheduleViewState;
            i4 |= composerK.Z(scheduleViewState2) ? 32 : 16;
        } else {
            scheduleViewState2 = scheduleViewState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1594979224, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.Content (DetailScreen.kt:714)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion, paddingValues);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Modifier modifierF2 = SizeKt.f(ScrollKt.g(companion, ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (Intrinsics.areEqual(scheduleViewState2.g().w(), Success.f128020a)) {
                composerK.a0(1438224099);
                z3 = false;
                J0(columnScopeInstance, scheduleViewState2.g(), scheduleViewState2.f(), scheduleViewState2.m(), z2, scheduleViewState2.o(), function1, composerK, ((i4 << 9) & 3670016) | ((i4 << 6) & 57344) | 6);
                composerK = composerK;
                composerK.U();
            } else {
                z3 = false;
                composerK.a0(1431882770);
                e0(composerK, 0);
                composerK.U();
            }
            composerK.y();
            x0((scheduleViewState2.g().E() || !scheduleViewState2.g().t() || (scheduleViewState2.m() instanceof ScheduleDescriptor.NewSchedule)) ? z3 : true, (scheduleViewState2.g().E() || !scheduleViewState2.g().v()) ? z3 : true, z2, function1, composerK, i4 & 8064);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final ScheduleViewState scheduleViewState3 = scheduleViewState2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.r3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.P(paddingValues, scheduleViewState3, z2, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(boolean z2, int i3, int i4, Composer composer, int i5) {
        L0(z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(PaddingValues paddingValues, ScheduleViewState scheduleViewState, boolean z2, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        O(paddingValues, scheduleViewState, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void P0(final boolean r17, final kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function3 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt.P0(boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void Q(final ScheduleViewState viewState, Function1 function1, final ModalBottomSheetState bottomSheetState, Composer composer, final int i3) {
        int i4;
        final CoroutineScope coroutineScope;
        Modifier.Companion companion;
        int i5;
        final MutableState mutableState;
        final Function1 onEvent = function1;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Composer composerK = composer.k(155432020);
        int i6 = (i3 & 6) == 0 ? (composerK.Z(viewState) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i6 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i6 |= (i3 & 512) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(155432020, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.CopyBlockingBottomSheet (DetailScreen.kt:300)");
            }
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope2 = (CoroutineScope) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion2.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion2.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState3 = (MutableState) objG3;
            if (R(mutableState2)) {
                composerK.a0(500992611);
                Modifier.Companion companion3 = Modifier.b8;
                float f3 = 24;
                float f4 = 16;
                Modifier modifierD = WindowInsetsPaddingKt.d(PaddingKt.k(PaddingKt.m(companion3, 0.0f, Dp.g(f3), 0.0f, Dp.g(f3), 5, null), Dp.g(f4), 0.0f, 2, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.k(), composerK, 6);
                int iA = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU = composerK.u();
                Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
                Function0 function0A = companion4.a();
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
                Updater.e(composerA, measurePolicyA, companion4.e());
                Updater.e(composerA, compositionLocalMapU, companion4.g());
                Function2 function2B = companion4.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion4.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                String strB = StringResources_androidKt.b(R.string.x8, composerK, 0);
                TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
                long jP = ComposeColorsKt.j(composerK, 0).p();
                TextAlign.Companion companion5 = TextAlign.f29616b;
                TextKt.c(strB, SizeKt.h(companion3, 0.0f, 1, null), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 48, 0, 65016);
                SpacerKt.a(SizeKt.i(companion3, Dp.g(f4)), composerK, 6);
                TextKt.c(StringResources_androidKt.b(R.string.u8, composerK, 0), SizeKt.h(companion3, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65016);
                composerK = composerK;
                SpacerKt.a(SizeKt.i(companion3, Dp.g(f3)), composerK, 6);
                ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.us, composerK, 0), 0.0f, 11, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
                int i7 = i6 & 896;
                boolean zI = composerK.I(coroutineScope2) | ((i6 & 112) == 32) | (i7 == 256 || ((i6 & 512) != 0 && composerK.I(bottomSheetState)));
                Object objG4 = composerK.G();
                if (zI || objG4 == companion2.a()) {
                    i4 = i6;
                    coroutineScope = coroutineScope2;
                    companion = companion3;
                    i5 = 6;
                    onEvent = function1;
                    Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.m3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DetailScreenKt.V(coroutineScope, bottomSheetState, mutableState3, onEvent, mutableState2);
                        }
                    };
                    mutableState = mutableState2;
                    composerK.w(function0);
                    objG4 = function0;
                } else {
                    i4 = i6;
                    companion = companion3;
                    i5 = 6;
                    mutableState = mutableState2;
                    onEvent = function1;
                    coroutineScope = coroutineScope2;
                }
                int i8 = i4;
                ComposeButtonsKt.i0(null, big, accent, (Function0) objG4, composerK, 0, 1);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, i5);
                ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.O4, composerK, 0), 0.0f, 11, null);
                ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, Color.n(ComposeColorsKt.j(composerK, 0).p()), 15, null);
                boolean zI2 = composerK.I(coroutineScope) | (i7 == 256 || ((i8 & 512) != 0 && composerK.I(bottomSheetState)));
                Object objG5 = composerK.G();
                if (zI2 || objG5 == companion2.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.n3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DetailScreenKt.W(coroutineScope, bottomSheetState, mutableState);
                        }
                    };
                    composerK.w(objG5);
                }
                ComposeButtonsKt.i0(null, big2, light, (Function0) objG5, composerK, 0, 1);
                composerK.y();
                composerK.U();
            } else {
                composerK.a0(503220767);
                if (viewState.j().isEmpty()) {
                    composerK.a0(503158209);
                    Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
                    Alignment.Horizontal horizontalG = Alignment.f25072a.g();
                    Modifier.Companion companion6 = Modifier.b8;
                    float f5 = 24;
                    Modifier modifierD2 = WindowInsetsPaddingKt.d(SizeKt.k(PaddingKt.m(companion6, 0.0f, Dp.g(f5), 0.0f, Dp.g(f5), 5, null), Dp.g(320), 0.0f, 2, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
                    MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalB, horizontalG, composerK, 54);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD2);
                    ComposeUiNode.Companion companion7 = ComposeUiNode.f8;
                    Function0 function0A2 = companion7.a();
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
                    Updater.e(composerA2, measurePolicyA2, companion7.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion7.g());
                    Function2 function2B2 = companion7.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion7.f());
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                    TextKt.c(StringResources_androidKt.b(R.string.w8, composerK, 0), PaddingKt.k(SizeKt.h(companion6, 0.0f, 1, null), Dp.g(40), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 48, 0, 65016);
                    composerK = composerK;
                    composerK.y();
                    composerK.U();
                } else {
                    composerK.a0(504108545);
                    Modifier.Companion companion8 = Modifier.b8;
                    float f6 = 24;
                    Modifier modifierD3 = WindowInsetsPaddingKt.d(ScrollKt.g(PaddingKt.m(companion8, 0.0f, Dp.g(f6), 0.0f, Dp.g(f6), 5, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composerK, 6));
                    MeasurePolicy measurePolicyA3 = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.k(), composerK, 6);
                    int iA3 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU3 = composerK.u();
                    Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierD3);
                    ComposeUiNode.Companion companion9 = ComposeUiNode.f8;
                    Function0 function0A3 = companion9.a();
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
                    Updater.e(composerA3, measurePolicyA3, companion9.e());
                    Updater.e(composerA3, compositionLocalMapU3, companion9.g());
                    Function2 function2B3 = companion9.b();
                    if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                        composerA3.w(Integer.valueOf(iA3));
                        composerA3.p(Integer.valueOf(iA3), function2B3);
                    }
                    Updater.e(composerA3, modifierF3, companion9.f());
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.f6666a;
                    TextKt.c(StringResources_androidKt.b(R.string.x8, composerK, 0), PaddingKt.k(companion8, Dp.g(f6), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 48, 0, 65528);
                    float f7 = 16;
                    TextKt.c(StringResources_androidKt.b(R.string.v8, composerK, 0), PaddingKt.j(companion8, Dp.g(f6), Dp.g(f7)), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 48, 0, 65528);
                    composerK = composerK;
                    composerK.a0(229164180);
                    for (final ScheduleViewState.ProfileToCopy profileToCopy : viewState.j()) {
                        CardType.Disabled disabled = new CardType.Disabled(null, null, 3, null);
                        Modifier modifierJ = PaddingKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(f7), Dp.g(4));
                        boolean zI3 = composerK.I(profileToCopy);
                        Object objG6 = composerK.G();
                        if (zI3 || objG6 == Composer.f23746a.a()) {
                            objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.o3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return DetailScreenKt.X(profileToCopy, mutableState3, mutableState2);
                                }
                            };
                            composerK.w(objG6);
                        }
                        ComposeCardsKt.m(modifierJ, disabled, (Function0) objG6, ComposableLambdaKt.e(-207631857, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.p3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return DetailScreenKt.Y(profileToCopy, mutableState3, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerK, 54), composerK, 3078, 0);
                    }
                    composerK.U();
                    composerK.y();
                    composerK.U();
                }
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.q3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.a0(viewState, onEvent, bottomSheetState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnCloseClicked(false, 1, null));
        return Unit.f139807a;
    }

    private static final boolean R(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(Function3 function3, RowScope AppBlockToolbar, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBlockToolbar, "$this$AppBlockToolbar");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(AppBlockToolbar) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-964188921, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.TopToolbarRow.<anonymous> (DetailScreen.kt:704)");
            }
            function3.invoke(AppBlockToolbar, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(boolean z2, Function1 function1, Function3 function3, int i3, int i4, Composer composer, int i5) {
        P0(z2, function1, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ProfileWithConfiguration T(MutableState mutableState) {
        return (ProfileWithConfiguration) mutableState.getValue();
    }

    private static final void U(MutableState mutableState, ProfileWithConfiguration profileWithConfiguration) {
        mutableState.setValue(profileWithConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, MutableState mutableState, Function1 function1, MutableState mutableState2) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DetailScreenKt$CopyBlockingBottomSheet$1$1$1$1(modalBottomSheetState, mutableState, function1, mutableState2, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, MutableState mutableState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DetailScreenKt$CopyBlockingBottomSheet$1$2$1$1(modalBottomSheetState, mutableState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(ScheduleViewState.ProfileToCopy profileToCopy, MutableState mutableState, MutableState mutableState2) {
        U(mutableState, profileToCopy.b());
        S(mutableState2, true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(final ScheduleViewState.ProfileToCopy profileToCopy, final MutableState mutableState, final MutableState mutableState2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-207631857, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.CopyBlockingBottomSheet.<anonymous>.<anonymous>.<anonymous> (DetailScreen.kt:405)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(16)), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.e(), verticalI, composer, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.b(), companion2.k(), composer, 6);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(profileToCopy.b().p().A(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 3120, 55290);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            ImmutableList immutableListA = profileToCopy.a();
            List listQ = profileToCopy.b().q();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listQ, 10));
            Iterator it = listQ.iterator();
            while (it.hasNext()) {
                arrayList.add(((SubAppRelation) it.next()).c());
            }
            ImmutableList immutableListH = ExtensionsKt.h(arrayList);
            List listS = profileToCopy.b().s();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listS, 10));
            Iterator it2 = listS.iterator();
            while (it2.hasNext()) {
                arrayList2.add(WebsiteProfileRelation.BlockingType.Companion.c((WebsiteProfileRelation) it2.next()));
            }
            IconClusterKt.k(null, immutableListA, immutableListH, arrayList2, Category.Companion.c(profileToCopy.b().p().z()), false, false, profileToCopy.b().p().o(), false, false, false, false, composer, 196608, 0, 3905);
            composer.y();
            String strB = StringResources_androidKt.b(R.string.t8, composer, 0);
            long jB = ComposeColorsKt.j(composer, 0).b();
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            boolean zI = composer.I(profileToCopy);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DetailScreenKt.Z(profileToCopy, mutableState, mutableState2);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.c0(strB, null, false, jB, textStyleH, 0.0f, null, (Function0) objG, composer, 0, 102);
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
    public static final Unit Z(ScheduleViewState.ProfileToCopy profileToCopy, MutableState mutableState, MutableState mutableState2) {
        U(mutableState, profileToCopy.b());
        S(mutableState2, true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(ScheduleViewState scheduleViewState, Function1 function1, ModalBottomSheetState modalBottomSheetState, int i3, Composer composer, int i4) {
        Q(scheduleViewState, function1, modalBottomSheetState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void b0(final ScheduleViewState viewState, final ModalBottomSheetState bottomSheetState, final boolean z2, final Function1 onEvent, final Function0 onOnboardingSaveClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(bottomSheetState, "bottomSheetState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onOnboardingSaveClicked, "onOnboardingSaveClicked");
        Composer composerK = composer.k(1526399211);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= (i3 & 64) == 0 ? composerK.Z(bottomSheetState) : composerK.I(bottomSheetState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(onOnboardingSaveClicked) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1526399211, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreen (DetailScreen.kt:171)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            SystemUiController.b(SystemUiControllerKt.e(null, composerK, 0, 1), Color.f25715b.j(), !DarkThemeKt.a(composerK, 0), null, 4, null);
            boolean zI = ((i4 & 112) == 32 || ((i4 & 64) != 0 && composerK.I(bottomSheetState))) | ((i4 & 896) == 256) | composerK.I(coroutineScopeI) | ((i4 & 7168) == 2048);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.o4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DetailScreenKt.c0(z2, bottomSheetState, coroutineScopeI, onEvent);
                    }
                };
                composerK.w(objG2);
            }
            BackHandlerKt.a(false, (Function0) objG2, composerK, 0, 1);
            int i5 = i4 >> 3;
            int i6 = i4 << 3;
            g0(bottomSheetState, viewState, onEvent, coroutineScopeI, z2, onOnboardingSaveClicked, composerK, ((i4 << 6) & 57344) | ModalBottomSheetState.f13222e | (i5 & 14) | (i6 & 112) | (i5 & 896) | (458752 & i6));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.p4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.d0(viewState, bottomSheetState, z2, onEvent, onOnboardingSaveClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(boolean z2, ModalBottomSheetState modalBottomSheetState, CoroutineScope coroutineScope, Function1 function1) {
        if (z2) {
            return Unit.f139807a;
        }
        if (modalBottomSheetState.k()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DetailScreenKt$DetailScreen$1$1$1(modalBottomSheetState, null), 3, null);
        } else {
            function1.invoke(new ScheduleViewEvent.OnCloseClicked(false, 1, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(ScheduleViewState scheduleViewState, ModalBottomSheetState modalBottomSheetState, boolean z2, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        b0(scheduleViewState, modalBottomSheetState, z2, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void e0(Composer composer, final int i3) {
        Composer composerK = composer.k(1164619950);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1164619950, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.EmptyContent (DetailScreen.kt:749)");
            }
            SchedulesSectionKt.D(Dp.g(24), 0, composerK, 6, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.f0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(int i3, Composer composer, int i4) {
        e0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(final ModalBottomSheetState modalBottomSheetState, final ScheduleViewState scheduleViewState, final Function1 function1, final CoroutineScope coroutineScope, final boolean z2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(682496438);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(modalBottomSheetState) : composerK.I(modalBottomSheetState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scheduleViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(coroutineScope) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(682496438, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose (DetailScreen.kt:205)");
            }
            Boolean boolValueOf = Boolean.valueOf(scheduleViewState.q());
            int i5 = i4 & 14;
            boolean zI = ((i4 & 112) == 32) | composerK.I(coroutineScope) | (i5 == 4 || ((i4 & 8) != 0 && composerK.I(modalBottomSheetState)));
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new DetailScreenKt$RootCompose$1$1(scheduleViewState, coroutineScope, modalBottomSheetState, null);
                composerK.w(objG);
            }
            EffectsKt.g(boolValueOf, (Function2) objG, composerK, 0);
            Unit unit = Unit.f139807a;
            boolean z3 = (i5 == 4 || ((i4 & 8) != 0 && composerK.I(modalBottomSheetState))) | ((i4 & 896) == 256);
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new DetailScreenKt$RootCompose$2$1(modalBottomSheetState, function1, null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            ComposeDialogsKt.n1(ComposableLambdaKt.e(-627801682, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DetailScreenKt.h0(modalBottomSheetState, coroutineScope, scheduleViewState, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), null, modalBottomSheetState, null, 0.0f, 0L, 0L, 0L, ComposableLambdaKt.e(1305210406, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.k0(scheduleViewState, z2, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (ModalBottomSheetState.f13222e << 6) | 100663302 | ((i4 << 6) & 896), 250);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.o0(modalBottomSheetState, scheduleViewState, function1, coroutineScope, z2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(final ModalBottomSheetState modalBottomSheetState, final CoroutineScope coroutineScope, final ScheduleViewState scheduleViewState, final Function1 function1, ColumnScope ThemedBottomSheetLayout, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(ThemedBottomSheetLayout, "$this$ThemedBottomSheetLayout");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-627801682, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose.<anonymous> (DetailScreen.kt:227)");
            }
            if (modalBottomSheetState.e() != ModalBottomSheetValue.Hidden) {
                composer.a0(1742796037);
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(-1452382806, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.k3
                    @Override // kotlin.jvm.functions.Function4
                    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                        return DetailScreenKt.i0(scheduleViewState, coroutineScope, function1, modalBottomSheetState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54);
                boolean zI = composer.I(coroutineScope) | composer.I(modalBottomSheetState);
                Object objG = composer.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.l3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DetailScreenKt.j0(coroutineScope, modalBottomSheetState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeBottomSheetsKt.f(null, null, true, composableLambdaE, null, (Function0) objG, composer, 3456, 19);
            } else {
                composer.a0(1733064052);
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
    public static final Unit i0(ScheduleViewState scheduleViewState, CoroutineScope coroutineScope, Function1 function1, ModalBottomSheetState modalBottomSheetState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1452382806, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose.<anonymous>.<anonymous> (DetailScreen.kt:231)");
            }
            int i4 = WhenMappings.f116569a[scheduleViewState.e().ordinal()];
            if (i4 == 1) {
                composer.a0(-435489335);
                AdultContentBottomSheetKt.d(coroutineScope, scheduleViewState, function1, modalBottomSheetState, composer, ModalBottomSheetState.f13222e << 9);
                composer.U();
            } else {
                if (i4 != 2) {
                    composer.a0(124496757);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(-434960568);
                Q(scheduleViewState, function1, modalBottomSheetState, composer, ModalBottomSheetState.f13222e << 6);
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
    public static final Unit j0(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new DetailScreenKt$RootCompose$3$2$1$1(modalBottomSheetState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(final ScheduleViewState scheduleViewState, final boolean z2, final Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1305210406, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose.<anonymous> (DetailScreen.kt:258)");
            }
            ScaffoldKt.a(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), null, null, ComposableLambdaKt.e(-1957827988, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.l0(scheduleViewState, z2, function0, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(-365751196, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DetailScreenKt.n0(scheduleViewState, z2, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12582912, 131062);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(ScheduleViewState scheduleViewState, final boolean z2, final Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1957827988, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose.<anonymous>.<anonymous> (DetailScreen.kt:271)");
            }
            if (Intrinsics.areEqual(scheduleViewState.g().w(), Success.f128020a)) {
                composer.a0(2465471);
                String strN = scheduleViewState.g().n();
                if (strN == null) {
                    composer.a0(2465470);
                    composer.U();
                } else {
                    composer.a0(2465471);
                    if (z2) {
                        composer.a0(-1149824733);
                        strN = StringResources_androidKt.b(R.string.Lt, composer, 0);
                    } else {
                        composer.a0(-1149823640);
                    }
                    composer.U();
                    boolean z3 = !StringsKt.p0(scheduleViewState.g().x());
                    FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
                    boolean zB = composer.b(z2) | composer.Z(function0) | composer.Z(function1);
                    Object objG = composer.G();
                    if (zB || objG == Composer.f23746a.a()) {
                        objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DetailScreenKt.m0(z2, function0, function1);
                            }
                        };
                        composer.w(objG);
                    }
                    FlatButtonsKt.p(primary, z3, strN, false, (Function0) objG, composer, 6, 8);
                    composer.U();
                    Unit unit = Unit.f139807a;
                }
                composer.U();
            } else {
                composer.a0(3314964);
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
    public static final Unit m0(boolean z2, Function0 function0, Function1 function1) {
        if (z2) {
            function0.invoke();
        } else {
            function1.invoke(new ScheduleViewEvent.OnSaveButtonClicked(false, 1, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ScheduleViewState scheduleViewState, boolean z2, Function1 function1, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-365751196, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.RootCompose.<anonymous>.<anonymous> (DetailScreen.kt:263)");
            }
            O(it, scheduleViewState, z2, function1, composer, i3 & 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(ModalBottomSheetState modalBottomSheetState, ScheduleViewState scheduleViewState, Function1 function1, CoroutineScope coroutineScope, boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        g0(modalBottomSheetState, scheduleViewState, function1, coroutineScope, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r6v45 */
    private static final void p0(final ColumnScope columnScope, ScheduleViewState.DetailViewState detailViewState, final ScheduleDescriptor scheduleDescriptor, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        float f3;
        BoxScopeInstance boxScopeInstance;
        Modifier.Companion companion;
        ?? r2;
        int i5;
        final ScheduleViewState.DetailViewState detailViewState2 = detailViewState;
        Composer composerK = composer.k(-473539254);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(detailViewState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scheduleDescriptor) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-473539254, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleHeader (DetailScreen.kt:587)");
            }
            boolean Z = composerK.Z(detailViewState2.x());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(detailViewState2.x(), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            float f4 = 8;
            Modifier modifierM = PaddingKt.m(SizeKt.v(companion2, Dp.g(104)), 0.0f, Dp.g(f4), 0.0f, Dp.g(4), 5, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            Modifier modifierC = columnScope.c(modifierM, companion3.g());
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.n(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierC);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
            Integer iconResId = detailViewState2.r().getIconResId();
            if (iconResId == null) {
                composerK.a0(-2066134376);
                composerK.U();
                i5 = i4;
                companion = companion2;
                boxScopeInstance = boxScopeInstance2;
                f3 = f4;
                r2 = 0;
            } else {
                composerK.a0(-2066134375);
                f3 = f4;
                boxScopeInstance = boxScopeInstance2;
                companion = companion2;
                r2 = 0;
                i5 = i4;
                ImageKt.a(PainterResources_androidKt.c(iconResId.intValue(), composerK, 0), null, SizeKt.v(boxScopeInstance2.f(companion2, companion3.e()), Dp.g(88)), null, null, 0.0f, null, composerK, 48, 120);
                composerK = composerK;
                Unit unit = Unit.f139807a;
                composerK.U();
            }
            Modifier modifierF2 = boxScopeInstance.f(companion, companion3.c());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), r2);
            int iA2 = ComposablesKt.a(composerK, r2);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyG2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion4.f());
            int i6 = R.drawable.W1;
            FlatButtonColors flatButtonColorsB = FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, null, Color.n(ComposeColorsKt.j(composerK, r2).f()), 1, null);
            float fG = Dp.g(32);
            int i7 = i5;
            int i8 = i7 & 7168;
            ?? r10 = i8 == 2048 ? 1 : r2;
            Object objG2 = composerK.G();
            if (r10 != 0 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.g4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DetailScreenKt.s0(function1);
                    }
                };
                composerK.w(objG2);
            }
            FlatButtonsKt.K(null, fG, i6, flatButtonColorsB, "", (Function0) objG2, composerK, 24624, 1);
            composerK.y();
            composerK.y();
            Modifier modifierJ = PaddingKt.j(companion, Dp.g(16), Dp.g(f3));
            MeasurePolicy measurePolicyG3 = BoxKt.g(companion3.o(), r2);
            int iA3 = ComposablesKt.a(composerK, r2);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierJ);
            Function0 function0A3 = companion4.a();
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
            Updater.e(composerA3, measurePolicyG3, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion4.f());
            String strQ0 = q0(mutableState);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composerK, r2));
            Composer composer2 = composerK;
            TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(ComposeColorsKt.j(composerK, r2).p(), 0L, ComposeColorsKt.j(composerK, r2).l0(), 0L, 0L, ComposeColorsKt.j(composerK, r2).b(), Color.f25715b.j(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer2, 1572864, 0, 48, 2097050);
            TextStyle textStyleE = TextStyle.e(ComposeTypographyKt.g(composer2, r2).g(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.f29616b.a(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(KeyboardCapitalization.f29372b.c(), null, 0, 0, null, null, null, 126, null);
            ?? r22 = (composer2.Z(mutableState) ? 1 : 0) | (i8 == 2048 ? 1 : r2);
            Object objG3 = composer2.G();
            if (r22 != 0 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.h4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DetailScreenKt.t0(function1, mutableState, (String) obj);
                    }
                };
                composer2.w(objG3);
            }
            ComposableSingletons$DetailScreenKt composableSingletons$DetailScreenKt = ComposableSingletons$DetailScreenKt.f116520a;
            OutlinedTextFieldKt.c(strQ0, (Function1) objG3, modifierH, false, false, textStyleE, null, composableSingletons$DetailScreenKt.q(), composableSingletons$DetailScreenKt.r(), ComposableLambdaKt.e(978655486, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.i4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.u0(mutableState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer2, 54), false, null, keyboardOptions, null, false, 2, 1, null, roundedCornerShapeD, textFieldColorsO, composer2, 918552960, 1769856, 158808);
            composerK = composer2;
            composerK.y();
            detailViewState2 = detailViewState;
            StateInfoRowKt.y(detailViewState2, scheduleDescriptor, function1, composerK, (i7 >> 3) & 1022);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.j4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.w0(columnScope, detailViewState2, scheduleDescriptor, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String q0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final void r0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnEmojiEditClicked.f114564a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Function1 function1, MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strW = StringHelperExtKt.w(StringHelperExtKt.d(it), 255);
        r0(mutableState, strW);
        function1.invoke(new ScheduleViewEvent.OnTitleChanged(strW));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(final MutableState mutableState, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(978655486, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleHeader.<anonymous>.<anonymous> (DetailScreen.kt:663)");
            }
            if (q0(mutableState).length() > 0) {
                composer.a0(887669041);
                ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
                long jQ = ComposeColorsKt.j(composer, 0).q();
                float fG = Dp.g(16);
                boolean Z = composer.Z(mutableState) | composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.n4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DetailScreenKt.v0(function1, mutableState);
                        }
                    };
                    composer.w(objG);
                }
                ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, fG, jQ, null, (Function0) objG, composer, 196608, 157);
                composer.U();
            } else {
                composer.a0(888182153);
                IconKt.c(PainterResources_androidKt.c(R.drawable.e6, composer, 0), null, SizeKt.v(Modifier.b8, Dp.g(16)), ComposeColorsKt.j(composer, 0).x(), composer, 432, 0);
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
    public static final Unit v0(Function1 function1, MutableState mutableState) {
        r0(mutableState, "");
        function1.invoke(new ScheduleViewEvent.OnTitleChanged(""));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(ColumnScope columnScope, ScheduleViewState.DetailViewState detailViewState, ScheduleDescriptor scheduleDescriptor, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        p0(columnScope, detailViewState, scheduleDescriptor, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void x0(final boolean z2, final boolean z3, boolean z4, final Function1 function1, Composer composer, final int i3) {
        int i4;
        final Function1 function12;
        final boolean z5;
        Composer composerK = composer.k(502849275);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(502849275, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleToolbar (DetailScreen.kt:543)");
            }
            int i5 = i4 >> 6;
            P0(z4, function1, ComposableLambdaKt.e(1190192314, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.y3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return DetailScreenKt.y0(z3, function1, z2, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, (i5 & 14) | 384 | (i5 & 112), 0);
            z5 = z4;
            function12 = function1;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function12 = function1;
            z5 = z4;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DetailScreenKt.C0(z2, z3, z5, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(boolean z2, final Function1 function1, boolean z3, RowScope TopToolbarRow, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(TopToolbarRow, "$this$TopToolbarRow");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1190192314, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleToolbar.<anonymous> (DetailScreen.kt:548)");
            }
            if (z2) {
                composer2.a0(2064254161);
                int i4 = R.drawable.w3;
                float fG = Dp.g(40);
                FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
                String strB = StringResources_androidKt.b(R.string.jF, composer2, 0);
                boolean Z = composer2.Z(function1);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DetailScreenKt.z0(function1);
                        }
                    };
                    composer2.w(objG);
                }
                FlatButtonsKt.K(null, fG, i4, secondary, strB, (Function0) objG, composer2, 3120, 1);
                composer2.U();
            } else {
                if (z3) {
                    composer2.a0(2064647241);
                    Object objG2 = composer2.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG2 == companion.a()) {
                        objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                        composer2.w(objG2);
                    }
                    final MutableState mutableState = (MutableState) objG2;
                    Modifier.Companion companion2 = Modifier.b8;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion2);
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
                    Updater.e(composerA, measurePolicyG, companion3.e());
                    Updater.e(composerA, compositionLocalMapU, companion3.g());
                    Function2 function2B = companion3.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion3.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    int i5 = R.drawable.x3;
                    float fG2 = Dp.g(40);
                    FlatButtonColors.Secondary secondary2 = FlatButtonColors.Secondary.f131167a;
                    String strB2 = StringResources_androidKt.b(R.string.ij, composer2, 0);
                    Object objG3 = composer2.G();
                    if (objG3 == companion.a()) {
                        objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d4
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DetailScreenKt.A0(mutableState);
                            }
                        };
                        composer2.w(objG3);
                    }
                    FlatButtonsKt.K(null, fG2, i5, secondary2, strB2, (Function0) objG3, composer2, 199728, 1);
                    composer2 = composer2;
                    composer2.a0(-514200677);
                    EnumEntries<LockType> entries = LockType.getEntries();
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
                    for (final LockType lockType : entries) {
                        String strB3 = StringResources_androidKt.b(lockType.getTitleRes(), composer2, 0);
                        Color colorN = Color.n(ComposeColorsKt.j(composer2, 0).b());
                        boolean Z2 = composer2.Z(function1) | composer2.e(lockType.ordinal());
                        Object objG4 = composer2.G();
                        if (Z2 || objG4 == Composer.f23746a.a()) {
                            objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.e4
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return DetailScreenKt.B0(function1, lockType);
                                }
                            };
                            composer2.w(objG4);
                        }
                        arrayList.add(new ComposeDropdownItem(strB3, colorN, null, false, null, null, null, null, (Function0) objG4, 252, null));
                    }
                    composer2.U();
                    ComposeDropdownKt.j(mutableState, null, arrayList, composer2, 54);
                    composer2.y();
                } else {
                    composer2.a0(2040428584);
                }
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnUnlocked.f114586a);
        return Unit.f139807a;
    }
}
