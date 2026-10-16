package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
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
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.facebook.FacebookSdk;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeThemesKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;
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
public final class BlocklistOrAllowlistRowKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f116500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f116501b = Dp.g(42);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f116502c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f116503a;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f116503a = iArr;
        }
    }

    static {
        float f3 = 16;
        f116500a = Dp.g(f3);
        f116502c = Dp.g(f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(final boolean z2, final Function0 function0, final boolean z3, final Function0 function02, final MutableState mutableState, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, final Function1 function1, ColumnScope BaseCard, Composer composer, int i3) throws XmlPullParserException, IOException {
        long jP;
        Modifier.Companion companion;
        int i4;
        long jQ;
        int i5;
        long jQ2;
        final MutableState mutableState2;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1085900626, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebBrowsingRowCard.<anonymous> (BlocklistOrAllowlistRow.kt:571)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(16), Dp.g(20));
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Alignment.Vertical verticalI = companion3.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
            Function0 function0A2 = companion4.a();
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
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion2, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion3.k(), composer, 0);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A3 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyA, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.eG, composer, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            if (z2) {
                composer.a0(629143707);
                jP = ComposeColorsKt.j(composer, 0).s();
            } else {
                composer.a0(629144538);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            TextKt.c(strB, null, jP, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleH, composer, 0, 0, 65530);
            composer.y();
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, companion2);
            Function0 function0A4 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A4);
            } else {
                composer.v();
            }
            Composer composerA4 = Updater.a(composer);
            Updater.e(composerA4, measurePolicyG2, companion4.e());
            Updater.e(composerA4, compositionLocalMapU4, companion4.g());
            Function2 function2B4 = companion4.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion4.f());
            boolean zB = composer.b(z2) | composer.Z(function0) | composer.b(z3) | composer.Z(function02);
            Object objG = composer.G();
            if (zB || objG == Composer.f23746a.a()) {
                companion = companion2;
                i4 = 0;
                Function0 function03 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlocklistOrAllowlistRowKt.B0(z2, function0, z3, function02, mutableState);
                    }
                };
                composer.w(function03);
                objG = function03;
            } else {
                companion = companion2;
                i4 = 0;
            }
            Modifier modifierF5 = ClickableKt.f(companion, false, null, null, (Function0) objG, 7, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion3.i(), composer, 48);
            int iA5 = ComposablesKt.a(composer, i4);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF6 = ComposedModifierKt.f(composer, modifierF5);
            Function0 function0A5 = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A5);
            } else {
                composer.v();
            }
            Composer composerA5 = Updater.a(composer);
            Updater.e(composerA5, measurePolicyB2, companion4.e());
            Updater.e(composerA5, compositionLocalMapU5, companion4.g());
            Function2 function2B5 = companion4.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF6, companion4.f());
            String strB2 = StringResources_androidKt.b(allowlistWebBrowsingMode.getLabel(), composer, i4);
            TextStyle textStyleJ = ComposeTypographyKt.g(composer, i4).j();
            if (z2) {
                composer.a0(-193651161);
                jQ = ComposeColorsKt.j(composer, i4).s();
            } else {
                composer.a0(-193650329);
                jQ = ComposeColorsKt.j(composer, i4).q();
            }
            composer.U();
            TextKt.c(strB2, null, jQ, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleJ, composer, 0, 0, 65530);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95574w1, composer, 6);
            if (z2) {
                composer.a0(-193642553);
                i5 = 0;
                jQ2 = ComposeColorsKt.j(composer, 0).s();
            } else {
                i5 = 0;
                composer.a0(-193641721);
                jQ2 = ComposeColorsKt.j(composer, 0).q();
            }
            composer.U();
            IconKt.d(imageVectorB, null, null, jQ2, composer, 48, 4);
            composer.y();
            boolean zY0 = y0(mutableState);
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                mutableState2 = mutableState;
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.b0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlocklistOrAllowlistRowKt.C0(mutableState2);
                    }
                };
                composer.w(objG2);
            } else {
                mutableState2 = mutableState;
            }
            AndroidMenu_androidKt.c(zY0, (Function0) objG2, null, 0L, null, null, RoundedCornerShapeKt.d(Dp.g(8)), ComposeColorsKt.j(composer, i5).X(), 0.0f, 0.0f, null, ComposableLambdaKt.e(399484345, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlocklistOrAllowlistRowKt.D0(function1, mutableState2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 48, 48, 1852);
            composer.y();
            composer.y();
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
    public static final Unit B0(boolean z2, Function0 function0, boolean z3, Function0 function02, MutableState mutableState) {
        if (z2) {
            function0.invoke();
        } else if (z3) {
            function02.invoke();
        } else {
            z0(mutableState, true);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(MutableState mutableState) {
        z0(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(final Function1 function1, final MutableState mutableState, ColumnScope DropdownMenu, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(399484345, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebBrowsingRowCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlocklistOrAllowlistRow.kt:612)");
            }
            for (final Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode : Profile.AllowlistWebBrowsingMode.getEntries()) {
                ComposableLambda composableLambdaE = ComposableLambdaKt.e(-420657409, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BlocklistOrAllowlistRowKt.E0(allowlistWebBrowsingMode, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                boolean Z = composer2.Z(function1) | composer2.e(allowlistWebBrowsingMode.ordinal());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.e0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BlocklistOrAllowlistRowKt.F0(function1, allowlistWebBrowsingMode, mutableState);
                        }
                    };
                    composer2.w(objG);
                }
                AndroidMenu_androidKt.d(composableLambdaE, (Function0) objG, null, null, null, false, null, null, null, composer2, 6, 508);
                composer2 = composer;
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
    public static final Unit E0(Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-420657409, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebBrowsingRowCard.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (BlocklistOrAllowlistRow.kt:615)");
            }
            TextKt.c(StringResources_androidKt.b(allowlistWebBrowsingMode.getLabel(), composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Function1 function1, Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, MutableState mutableState) {
        z0(mutableState, false);
        function1.invoke(allowlistWebBrowsingMode);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(Profile.AllowlistWebBrowsingMode allowlistWebBrowsingMode, float f3, float f4, boolean z2, boolean z3, Function0 function0, Function0 function02, Function1 function1, int i3, int i4, Composer composer, int i5) {
        v0(allowlistWebBrowsingMode, f3, f4, z2, z3, function0, function02, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void H0(final String label, final long j3, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(label, "label");
        Composer composerK = composer.k(1678114518);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(label) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1678114518, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebKeywordItem (BlocklistOrAllowlistRow.kt:720)");
            }
            SurfaceKt.a(null, RoundedCornerShapeKt.g(), 0L, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.e(-1723535461, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.I0(j3, label, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 12582912, 125);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.j0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.J0(label, j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(long j3, String str, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1723535461, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebKeywordItem.<anonymous> (BlocklistOrAllowlistRow.kt:724)");
            }
            Alignment alignmentE = Alignment.f25072a.e();
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(Modifier.b8, ColorKt.h(ComposeColorsKt.j(composer, 0).v(), j3), null, 2, null), Dp.g(10), Dp.g(6));
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
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
    public static final Unit J0(String str, long j3, int i3, Composer composer, int i4) {
        H0(str, j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void K0(Modifier modifier, final ImmutableList labels, final long j3, final float f3, final float f4, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Modifier modifier3;
        Intrinsics.checkNotNullParameter(labels, "labels");
        Composer composerK = composer.k(-598237367);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(labels) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.f(j3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.c(f3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.c(f4) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i5 & 9363) != 9362, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-598237367, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebsKeywordsRow (BlocklistOrAllowlistRow.kt:691)");
            }
            if (labels.isEmpty()) {
                modifier3 = modifier4;
                composerK.a0(2025915799);
                SpacerKt.a(SizeKt.i(modifier3, Dp.g(16)), composerK, 0);
                composerK.U();
            } else {
                composerK.a0(2025137079);
                LazyListState lazyListStateB = LazyListStateKt.b(0, 0, composerK, 0, 3);
                Alignment.Vertical verticalI = Alignment.f25072a.i();
                float f5 = 8;
                Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(f5));
                PaddingValues paddingValuesD = PaddingKt.d(f3, Dp.g(f5), f4, Dp.g(16));
                FlingBehavior flingBehaviorE = LazyListSnapLayoutInfoProviderKt.e(lazyListStateB, null, composerK, 0, 2);
                Modifier modifierH = SizeKt.h(modifier4, 0.0f, 1, null);
                boolean z2 = ((i5 & 112) == 32) | ((i5 & 896) == 256);
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.f0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BlocklistOrAllowlistRowKt.O0(labels, j3, (LazyListScope) obj);
                        }
                    };
                    composerK.w(objG);
                }
                modifier3 = modifier4;
                LazyDslKt.e(modifierH, lazyListStateB, paddingValuesD, false, horizontalOrVerticalO, verticalI, flingBehaviorE, false, null, (Function1) objG, composerK, 221184, 392);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier3;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Modifier modifier5 = modifier2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.g0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.Q0(modifier5, labels, j3, f3, f4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void L0(final int i3, final ImmutableList immutableList, final float f3, final float f4, final boolean z2, final int i4, final Function0 function0, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer composerK = composer.k(1889462967);
        if ((i5 & 6) == 0) {
            i6 = (composerK.e(i3) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composerK.Z(immutableList) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i5 & 3072) == 0) {
            i6 |= composerK.c(f4) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i5) == 0) {
            i6 |= composerK.e(i4) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i5) == 0) {
            i6 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i6) != 599186, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1889462967, i6, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebsKeywordsRowCard (BlocklistOrAllowlistRow.kt:531)");
            }
            composer2 = composerK;
            CardsKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0L, 0.0f, false, RoundedCornerShapeKt.e(f3, f3, f4, f4), function0, ComposableLambdaKt.e(-332657901, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.t
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlocklistOrAllowlistRowKt.M0(i3, immutableList, z2, i4, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i6 >> 3) & 458752) | 1572870, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.N0(i3, immutableList, f3, f4, z2, i4, function0, i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(int i3, ImmutableList immutableList, boolean z2, int i4, ColumnScope BaseCard, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i5 & 17) != 16, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-332657901, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebsKeywordsRowCard.<anonymous> (BlocklistOrAllowlistRow.kt:538)");
            }
            Modifier modifierJ = PaddingKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16), Dp.g(20));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            t0(i3, immutableList.size(), z2, false, null, i4, composer, 0, 24);
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
    public static final Unit N0(int i3, ImmutableList immutableList, float f3, float f4, boolean z2, int i4, Function0 function0, int i5, Composer composer, int i6) {
        L0(i3, immutableList, f3, f4, z2, i4, function0, composer, RecomposeScopeImplKt.a(i5 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(577311073);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(577311073, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AllowlistPreview (BlocklistOrAllowlistRow.kt:134)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(1147555154, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.P(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.R(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(final ImmutableList immutableList, final long j3, LazyListScope LazyRow) {
        Intrinsics.checkNotNullParameter(LazyRow, "$this$LazyRow");
        LazyListScope.b(LazyRow, immutableList.size(), null, null, ComposableLambdaKt.c(-1857862536, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.h0
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return BlocklistOrAllowlistRowKt.P0(immutableList, j3, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(boolean z2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1147555154, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AllowlistPreview.<anonymous> (BlocklistOrAllowlistRow.kt:136)");
            }
            Modifier modifierK = PaddingKt.k(Modifier.b8, 0.0f, Dp.g(16), 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Profile.BlockingMode blockingMode = Profile.BlockingMode.Allowlist;
            Category category = Category.NEWS;
            Blocking blocking = new Blocking(blockingMode, Profile.AllowlistWebBrowsingMode.SelectedSites, z2, ExtensionsKt.b(new App("app1", "App 1", ExtensionsKt.b(category)), new App("app2", "App 2", ExtensionsKt.b(category))), ExtensionsKt.b(new WebOrKeyword("youtube.com"), new WebOrKeyword("github.com")), null, null, null, 224, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlocklistOrAllowlistRowKt.Q((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            d0(false, blocking, false, false, false, (Function1) objG, composer, 196614, 28);
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
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit P0(ImmutableList immutableList, long j3, LazyItemScope items, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(items, "$this$items");
        if ((i4 & 48) == 0) {
            i4 |= composer.e(i3) ? 32 : 16;
        }
        if (composer.r((i4 & 145) != 144, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1857862536, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.WebsKeywordsRow.<anonymous>.<anonymous>.<anonymous> (BlocklistOrAllowlistRow.kt:704)");
            }
            H0(((WebOrKeyword) immutableList.get(i3)).a(), j3, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Modifier modifier, ImmutableList immutableList, long j3, float f3, float f4, int i3, int i4, Composer composer, int i5) {
        K0(modifier, immutableList, j3, f3, f4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(boolean z2, int i3, Composer composer, int i4) {
        O(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void S(final ImmutableList immutableList, final float f3, final float f4, final boolean z2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-807272713);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-807272713, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AllowlistWebsitesRowCard (BlocklistOrAllowlistRow.kt:641)");
            }
            CardsKt.j(SizeKt.h(Modifier.b8, 0.0f, 1, null), 0L, 0.0f, false, RoundedCornerShapeKt.e(f3, f3, f4, f4), function0, ComposableLambdaKt.e(-1269556197, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlocklistOrAllowlistRowKt.T(immutableList, z2, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 << 3) & 458752) | 1572870, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.U(immutableList, f3, f4, z2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(ImmutableList immutableList, boolean z2, ColumnScope BaseCard, Composer composer, int i3) {
        long jQ;
        long jQ2;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1269556197, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AllowlistWebsitesRowCard.<anonymous> (BlocklistOrAllowlistRow.kt:647)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(20));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            t0(R.string.hG, immutableList.size(), z2, false, null, R.drawable.f95503d1, composer, 0, 24);
            float f4 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Painter painterC = PainterResources_androidKt.c(R.drawable.f95527j1, composer, 0);
            if (z2) {
                composer.a0(-1582211934);
                jQ = ComposeColorsKt.j(composer, 0).s();
            } else {
                composer.a0(-1582211102);
                jQ = ComposeColorsKt.j(composer, 0).q();
            }
            composer.U();
            IconKt.c(painterC, null, SizeKt.v(companion, Dp.g(f3)), jQ, composer, 432, 0);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f4)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.Ov, composer, 0);
            TextStyle textStyleD = ComposeTypographyKt.g(composer, 0).d();
            if (z2) {
                composer.a0(-1582199550);
                jQ2 = ComposeColorsKt.j(composer, 0).s();
            } else {
                composer.a0(-1582198718);
                jQ2 = ComposeColorsKt.j(composer, 0).q();
            }
            composer.U();
            TextKt.c(strB, null, jQ2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composer, 0, 0, 65530);
            composer.y();
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
    public static final Unit U(ImmutableList immutableList, float f3, float f4, boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        S(immutableList, f3, f4, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02dd  */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void V(final kotlinx.collections.immutable.ImmutableList r25, final boolean r26, long r27, androidx.compose.runtime.Composer r29, final int r30, final int r31) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 764
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt.V(kotlinx.collections.immutable.ImmutableList, boolean, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(ImmutableList immutableList, boolean z2, long j3, int i3, int i4, Composer composer, int i5) throws Exception {
        V(immutableList, z2, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void X(final ImmutableList immutableList, final float f3, final float f4, final boolean z2, final boolean z3, final List list, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1984403060);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.b(z3) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(list) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i4 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if (composerK.r((599187 & i4) != 599186, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1984403060, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AppsRowCard (BlocklistOrAllowlistRow.kt:365)");
            }
            composer2 = composerK;
            CardsKt.j(null, 0L, 0.0f, false, RoundedCornerShapeKt.e(f3, f3, f4, f4), function0, ComposableLambdaKt.e(1522119576, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BlocklistOrAllowlistRowKt.Y(immutableList, z2, z3, list, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, ((i4 >> 3) & 458752) | 1572864, 15);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.Z(immutableList, f3, f4, z2, z3, list, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(ImmutableList immutableList, boolean z2, boolean z3, List list, ColumnScope BaseCard, Composer composer, int i3) throws Exception {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1522119576, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.AppsRowCard.<anonymous> (BlocklistOrAllowlistRow.kt:370)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(16), Dp.g(20));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            t0(R.string.M1, immutableList.size(), z2, z3, list, R.drawable.W0, composer, 0, 0);
            if (immutableList.isEmpty()) {
                composer.a0(-945144012);
            } else {
                composer.a0(-930327624);
                SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composer, 6);
                V(immutableList, z2, ComposeColorsKt.j(composer, 0).l0(), composer, 0, 0);
            }
            composer.U();
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
    public static final Unit Z(ImmutableList immutableList, float f3, float f4, boolean z2, boolean z3, List list, Function0 function0, int i3, Composer composer, int i4) {
        X(immutableList, f3, f4, z2, z3, list, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void a0(final Blocking blocking, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        int i5;
        Intrinsics.checkNotNullParameter(blocking, "blocking");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-552532885);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(blocking) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-552532885, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistHeading (BlocklistOrAllowlistRow.kt:743)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierJ = PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            int i6 = i4;
            TextKt.c(StringResources_androidKt.b(R.string.x4, composerK, 0), RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).g(), composerK, 0, 0, 65532);
            String strB = StringResources_androidKt.b(blocking.b().getTitleRes(), composerK, 0);
            int iconRes = blocking.b().getIconRes();
            boolean z2 = ((i6 & 112) == 32) | ((i6 & 14) == 4);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BlocklistOrAllowlistRowKt.b0(blocking, onEvent);
                    }
                };
                composerK.w(objG);
            }
            ConditionsRowKt.q(null, strB, iconRes, false, (Function0) objG, composerK, 0, 9);
            composerK.y();
            int i7 = WhenMappings.f116503a[blocking.b().ordinal()];
            if (i7 == 1) {
                i5 = R.string.B4;
            } else {
                if (i7 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i5 = R.string.B0;
            }
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(i5, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.c0(blocking, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(Blocking blocking, Function1 function1) {
        if (blocking.i()) {
            function1.invoke(ScheduleViewEvent.OnLockedActionClicked.f114571a);
        } else {
            function1.invoke(ScheduleViewEvent.OnBlockingModeSettingsClicked.f114551a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Blocking blocking, Function1 function1, int i3, Composer composer, int i4) {
        a0(blocking, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:186:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d0(final boolean r22, final cz.mobilesoft.coreblock.scene.schedule.detail.Blocking r23, boolean r24, boolean r25, boolean r26, final kotlin.jvm.functions.Function1 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt.d0(boolean, cz.mobilesoft.coreblock.scene.schedule.detail.Blocking, boolean, boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e0(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnBlockingCardClicked(TabItem.Apps));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnBlockingCardClicked(TabItem.Webs));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnBlockingCardClicked(TabItem.Keywords));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h0(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnLockedActionClicked.f114571a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnStrictModeActionBlocked.f114583a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(Function1 function1, Profile.AllowlistWebBrowsingMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        function1.invoke(new ScheduleViewEvent.OnWebBrowsingModeChanged(mode));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(Function1 function1) {
        function1.invoke(new ScheduleViewEvent.OnBlockingCardClicked(TabItem.Webs));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(Function1 function1) {
        AnswersHelper.f128199a.U4();
        function1.invoke(ScheduleViewEvent.OnCopyClicked.f114561a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(boolean z2, Blocking blocking, boolean z3, boolean z4, boolean z5, Function1 function1, int i3, int i4, Composer composer, int i5) {
        d0(z2, blocking, z3, z4, z5, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1411071397);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1411071397, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistPreview (BlocklistOrAllowlistRow.kt:161)");
            }
            ComposeThemesKt.b(null, ComposableLambdaKt.e(1981315478, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.o0(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 48, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BlocklistOrAllowlistRowKt.q0(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(boolean z2, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1981315478, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistPreview.<anonymous> (BlocklistOrAllowlistRow.kt:163)");
            }
            Modifier modifierK = PaddingKt.k(Modifier.b8, 0.0f, Dp.g(16), 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Category category = Category.NEWS;
            Blocking blocking = new Blocking(null, null, z2, ExtensionsKt.b(new App("app1", "App 1", ExtensionsKt.b(category)), new App("app2", "App 2", ExtensionsKt.b(category))), ExtensionsKt.b(new WebOrKeyword(FacebookSdk.FACEBOOK_COM), new WebOrKeyword(FacebookSdk.INSTAGRAM_COM)), null, null, ExtensionsKt.b(category, Category.CREATIVITY), 99, null);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return BlocklistOrAllowlistRowKt.p0((ScheduleViewEvent) obj);
                    }
                };
                composer.w(objG);
            }
            d0(true, blocking, false, false, false, (Function1) objG, composer, 196614, 28);
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
    public static final Unit p0(ScheduleViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(boolean z2, int i3, Composer composer, int i4) {
        n0(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void r0(androidx.compose.ui.Modifier r16, boolean r17, final kotlin.jvm.functions.Function0 r18, androidx.compose.runtime.Composer r19, final int r20, final int r21) {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt.r0(androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Modifier modifier, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        r0(modifier, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:147:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t0(final int r42, final int r43, final boolean r44, boolean r45, java.util.List r46, final int r47, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 1183
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt.t0(int, int, boolean, boolean, java.util.List, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(int i3, int i4, boolean z2, boolean z3, List list, int i5, int i6, int i7, Composer composer, int i8) {
        t0(i3, i4, z2, z3, list, i5, composer, RecomposeScopeImplKt.a(i6 | 1), i7);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void v0(final cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.AllowlistWebBrowsingMode r21, final float r22, final float r23, final boolean r24, boolean r25, kotlin.jvm.functions.Function0 r26, kotlin.jvm.functions.Function0 r27, final kotlin.jvm.functions.Function1 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.BlocklistOrAllowlistRowKt.v0(cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$AllowlistWebBrowsingMode, float, float, boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0() {
        return Unit.f139807a;
    }

    private static final boolean y0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void z0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(ScheduleViewEvent scheduleViewEvent) {
        Intrinsics.checkNotNullParameter(scheduleViewEvent, jTYhJgqLBN.qPnJ);
        return Unit.f139807a;
    }
}
