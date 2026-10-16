package cz.mobilesoft.coreblock.scene.app_feel.screens;

import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.google.accompanist.drawablepainter.DrawablePainterKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.DateHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.statistics.model.AggregatedItemRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppFeelLabelingScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f98719a;

        static {
            int[] iArr = new int[AppDistractionType.values().length];
            try {
                iArr[AppDistractionType.Productive.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AppDistractionType.Distractive.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f98719a = iArr;
        }
    }

    private static final void A0(final String str, final String str2, final Function1 function1, Function0 function0, Composer composer, final int i3) {
        int i4;
        final Function0 function02 = function0;
        Composer composerK = composer.k(-162836548);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function02) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-162836548, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.ExcludeAppBottomSheetContent (AppFeelLabelingScreen.kt:637)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 32;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.g(), composerK, 48);
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strC = StringResources_androidKt.c(R.string.U0, new Object[]{str2}, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strC, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65018);
            float f4 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.V0, composerK, 0), null, ComposeColorsKt.j(composerK, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).b(), composerK, 0, 0, 65018);
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Td, composerK, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.g0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelLabelingScreenKt.B0(function1, str);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composerK, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.di, composerK, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, null, 31, null);
            boolean z3 = (i4 & 7168) == 2048;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                function02 = function0;
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelLabelingScreenKt.C0(function02);
                    }
                };
                composerK.w(objG2);
            } else {
                function02 = function0;
            }
            ComposeButtonsKt.i0(null, big2, light, (Function0) objG2, composerK, 0, 1);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelLabelingScreenKt.D0(str, str2, function1, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(String str, String str2, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        A0(str, str2, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void E0(final androidx.compose.ui.Modifier r22, final cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState r23, final boolean r24, final kotlin.jvm.functions.Function0 r25, final kotlin.jvm.functions.Function0 r26, kotlin.jvm.functions.Function0 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 456
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt.E0(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.scene.app_feel.screens.SwipeCardState, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(SwipeCardState swipeCardState, float f3, float f4, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (swipeCardState.d() == 0.0f) {
            long jE = Offset.e((Float.floatToRawIntBits(f3 / 2.0f) << 32) | (((long) Float.floatToRawIntBits(f4 * 2)) & 4294967295L));
            float fIntBitsToFloat = Float.intBitsToFloat((int) (jE & 4294967295L)) - (Float.intBitsToFloat((int) (LayoutCoordinatesKt.e(it) & 4294967295L)) + (((int) (it.a() & 4294967295L)) / 2));
            swipeCardState.h(jE);
            swipeCardState.i(fIntBitsToFloat);
            if (fIntBitsToFloat > 0.0f) {
                swipeCardState.j((float) Math.asin((f3 / 3.0f) / fIntBitsToFloat));
                swipeCardState.g((float) Math.asin(f3 / fIntBitsToFloat));
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(Modifier modifier, SwipeCardState swipeCardState, boolean z2, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        E0(modifier, swipeCardState, z2, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float K(SwipeCardState swipeCardState) {
        if (swipeCardState.f() == 0.0f) {
            return 0.0f;
        }
        return RangesKt.o(((Number) swipeCardState.b().n()).floatValue() / swipeCardState.f(), -1.0f, 1.0f);
    }

    private static final float L(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(List list, Function0 function0, MutableIntState mutableIntState, MutableState mutableState) {
        p0(mutableIntState, o0(mutableIntState) + 1);
        if (o0(mutableIntState) >= list.size()) {
            function0.invoke();
        }
        t0(mutableState, false);
        return Unit.f139807a;
    }

    public static final SwipeCardState M0(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1888063256, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.rememberSwipeCardState (AppFeelLabelingScreen.kt:751)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer);
            composer.w(objG);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objG;
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new SwipeCardState(coroutineScope);
            composer.w(objG2);
        }
        SwipeCardState swipeCardState = (SwipeCardState) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return swipeCardState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(List list, Function2 function2, int i3, AppDistractionType appDistractionType) {
        String strE;
        Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
        AggregatedItemRecord aggregatedItemRecord = (AggregatedItemRecord) CollectionsKt.getOrNull(list, i3);
        if (aggregatedItemRecord != null && (strE = aggregatedItemRecord.e()) != null) {
            function2.invoke(strE, appDistractionType);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function2 function2, Function0 function0, MutableIntState mutableIntState) {
        function2.invoke(Integer.valueOf(o0(mutableIntState)), AppDistractionType.Productive);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function2 function2, Function0 function0, MutableIntState mutableIntState) {
        function2.invoke(Integer.valueOf(o0(mutableIntState)), AppDistractionType.Distractive);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(AppFeelViewState appFeelViewState, PackageManager packageManager, AggregatedItemRecord aggregatedItemRecord, final Function1 function1, final SwipeCardState swipeCardState, final CoroutineScope coroutineScope, final Function0 function0, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-690579138, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreen.<anonymous>.<anonymous> (AppFeelLabelingScreen.kt:160)");
            }
            Intrinsics.checkNotNull(packageManager);
            String str = (String) appFeelViewState.c(packageManager, aggregatedItemRecord.e()).e();
            String strE = aggregatedItemRecord.e();
            boolean Z = composer.Z(function1) | composer.I(swipeCardState) | composer.I(coroutineScope) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                Function1 function12 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelLabelingScreenKt.R(function1, swipeCardState, mutableState, coroutineScope, function0, (String) obj);
                    }
                };
                composer.w(function12);
                objG = function12;
            }
            Function1 function13 = (Function1) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.c0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelLabelingScreenKt.T(mutableState);
                    }
                };
                composer.w(objG2);
            }
            A0(strE, str, function13, (Function0) objG2, composer, 3072);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1, final SwipeCardState swipeCardState, MutableState mutableState, final CoroutineScope coroutineScope, final Function0 function0, String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        function1.invoke(packageName);
        swipeCardState.a(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.f0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppFeelLabelingScreenKt.S(coroutineScope, swipeCardState, function0);
            }
        });
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$1$1$1$1$1$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(AppFeelViewState appFeelViewState, PackageManager packageManager, AggregatedItemRecord record, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(record, "record");
        if (ComposerKt.M()) {
            ComposerKt.U(144886302, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AppFeelLabelingScreen.kt:223)");
        }
        Intrinsics.checkNotNull(packageManager);
        y0(appFeelViewState.c(packageManager, record.e()), record, composer, (i3 << 3) & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    private static final float W(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float X(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float Y(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final long Z(State state) {
        return ((Color) state.getValue()).B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(boolean z2, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        if (!z2) {
            drawWithContent.i2();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(boolean z2, SwipeCardState swipeCardState, State state, State state2, State state3, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.c(W(state));
        graphicsLayer.e(X(state2));
        graphicsLayer.k(X(state2));
        graphicsLayer.d(Y(state3));
        if (z2) {
            float fFloatValue = ((Number) swipeCardState.b().n()).floatValue();
            float fD = swipeCardState.d();
            if (fD > 0.0f) {
                graphicsLayer.d(graphicsLayer.J() + fD);
                double d3 = fFloatValue;
                graphicsLayer.j((float) Math.toDegrees(d3));
                graphicsLayer.d(graphicsLayer.J() - (((float) Math.cos(d3)) * fD));
                graphicsLayer.l(fD * ((float) Math.sin(d3)));
            }
            graphicsLayer.A0(TransformOrigin.f25955b.a());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Function3 function3, AggregatedItemRecord aggregatedItemRecord, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(883124038, i3, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (AppFeelLabelingScreen.kt:315)");
            }
            function3.invoke(aggregatedItemRecord, composer, 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(final SwipeCardState swipeCardState, final CoroutineScope coroutineScope, final Function0 function0) {
        swipeCardState.k(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppFeelLabelingScreenKt.e0(coroutineScope, swipeCardState, function0);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$2$1$1$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(final SwipeCardState swipeCardState, final CoroutineScope coroutineScope, final Function0 function0) {
        swipeCardState.l(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return AppFeelLabelingScreenKt.g0(coroutineScope, swipeCardState, function0);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$1$2$3$3$1$1$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(List list, AppDistractionType appDistractionType, final Function2 function2, final SwipeCardState swipeCardState, MutableState mutableState, final MutableIntState mutableIntState, final CoroutineScope coroutineScope, final Function0 function0, final Function0 function02, final Function0 function03) {
        if (s0(mutableState) || o0(mutableIntState) >= list.size()) {
            return Unit.f139807a;
        }
        t0(mutableState, true);
        int i3 = WhenMappings.f98719a[appDistractionType.ordinal()];
        if (i3 == 1) {
            function2.invoke(Integer.valueOf(o0(mutableIntState)), AppDistractionType.Productive);
            swipeCardState.l(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.z
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelLabelingScreenKt.j0(coroutineScope, swipeCardState, function02);
                }
            });
        } else if (i3 != 2) {
            swipeCardState.a(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.a0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelLabelingScreenKt.k0(coroutineScope, swipeCardState, function2, function03, mutableIntState);
                }
            });
        } else {
            function2.invoke(Integer.valueOf(o0(mutableIntState)), AppDistractionType.Distractive);
            swipeCardState.k(new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.y
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppFeelLabelingScreenKt.i0(coroutineScope, swipeCardState, function0);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$1$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function0 function0) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$2$1(swipeCardState, function0, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(CoroutineScope coroutineScope, SwipeCardState swipeCardState, Function2 function2, Function0 function0, MutableIntState mutableIntState) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AppFeelLabelingScreenKt$AppFeelLabelingScreen$2$2$1$1$1$3$1(swipeCardState, function2, function0, mutableIntState, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(AppFeelViewState appFeelViewState, Function1 function1, Function2 function2, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        J(appFeelViewState, function1, function2, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o0(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    private static final void p0(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean q0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean s0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void t0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final void u0(final AppDistractionType appDistractionType, final float f3, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1748429691);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(appDistractionType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1748429691, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppTypeButton (AppFeelLabelingScreen.kt:516)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = InteractionSourceKt.a();
                composerK.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierG = SizeKt.G(PaddingKt.k(companion2, 0.0f, 0.0f, 3, null), null, false, 3, null);
            boolean z2 = (i4 & 896) == 256;
            Object objG2 = composerK.G();
            if (z2 || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.v
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppFeelLabelingScreenKt.v0(function0);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierG, mutableInteractionSource, null, false, null, null, (Function0) objG2, 28, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(8)), companion3.g(), composerK, 54);
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
            boolean z3 = (i4 & 112) == 32;
            Object objG3 = composerK.G();
            if (z3 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelLabelingScreenKt.w0(f3, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierA = ClipKt.a(BackgroundKt.c(SizeKt.v(GraphicsLayerModifierKt.a(companion2, (Function1) objG3), Dp.g(56)), appDistractionType.m1357getColor0d7_KjU(), RoundedCornerShapeKt.g()), RoundedCornerShapeKt.g());
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierA);
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
            Updater.e(composerA2, measurePolicyG, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, appDistractionType.getIconRes(), composerK, 6), null, BoxScopeInstance.f6642a.f(companion2, companion3.e()), ComposeColorsKt.j(composerK, 0).q0(), composerK, 48, 0);
            BoxKt.a(IndicationKt.b(SizeKt.f(companion2, 0.0f, 1, null), mutableInteractionSource, (Indication) composerK.q(IndicationKt.a())), composerK, 0);
            composerK.y();
            TextKt.c(StringResources_androidKt.b(appDistractionType.getNameRes(), composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65018);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelLabelingScreenKt.x0(appDistractionType, f3, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(float f3, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.e(f3);
        graphicsLayer.k(f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(AppDistractionType appDistractionType, float f3, Function0 function0, int i3, Composer composer, int i4) {
        u0(appDistractionType, f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(final Pair pair, final AggregatedItemRecord aggregatedItemRecord, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1100574829);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(pair) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(aggregatedItemRecord) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1100574829, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.CardContent (AppFeelLabelingScreen.kt:474)");
            }
            boolean Z = composerK.Z(aggregatedItemRecord.e());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                composerK.w(pair);
                objG = pair;
            }
            Pair pair2 = (Pair) objG;
            String str = (String) pair2.a();
            Drawable drawable = (Drawable) pair2.b();
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
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
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), companion2.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ImageKt.a(DrawablePainterKt.e(drawable, composerK, 0), null, SizeKt.v(companion, Dp.g(72)), null, null, 0.0f, null, composerK, 432, 120);
            SpacerKt.a(SizeKt.i(companion, Dp.g(40)), composerK, 6);
            TextStyle textStyleG = ComposeTypographyKt.g(composerK, 0).g();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleG, composer2, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            TextKt.c(StringResources_androidKt.c(R.string.L, new Object[]{DateHelperExtKt.f(Math.abs(aggregatedItemRecord.c()), false, false, false, 14, null)}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer2, 0, 0, 65018);
            composer2.y();
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelLabelingScreenKt.z0(pair, aggregatedItemRecord, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(Pair pair, AggregatedItemRecord aggregatedItemRecord, int i3, Composer composer, int i4) {
        y0(pair, aggregatedItemRecord, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:173:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x059c  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x05e4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05e7  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x063a  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x06b6  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x072b  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void J(final cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState r58, final kotlin.jvm.functions.Function1 r59, final kotlin.jvm.functions.Function2 r60, final kotlin.jvm.functions.Function0 r61, final kotlin.jvm.functions.Function0 r62, androidx.compose.runtime.Composer r63, final int r64) {
        /*
            Method dump skipped, instruction units count: 2582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelLabelingScreenKt.J(cz.mobilesoft.coreblock.scene.app_feel.AppFeelViewState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }
}
