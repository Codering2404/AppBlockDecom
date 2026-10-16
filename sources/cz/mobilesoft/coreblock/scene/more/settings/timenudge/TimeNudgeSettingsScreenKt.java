package cz.mobilesoft.coreblock.scene.more.settings.timenudge;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.legacy.content.Werj.QgXempTBEfV;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.share.HKJ.pnxuebdT;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.card.PermissionsCardKt;
import cz.mobilesoft.coreblock.scene.more.settings.compose.PreferenceShimmerKt;
import cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposableExtKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.AppIconsWithCountKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
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
public final class TimeNudgeSettingsScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f110277a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f110277a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void A(final cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewState r32, final kotlin.jvm.functions.Function1 r33, androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            r1 = r32
            r2 = r33
            r4 = r36
            r0 = 438803647(0x1a279cbf, float:3.466141E-23)
            r3 = r35
            androidx.compose.runtime.Composer r3 = r3.k(r0)
            r5 = r4 & 6
            if (r5 != 0) goto L1e
            boolean r5 = r3.Z(r1)
            if (r5 == 0) goto L1b
            r5 = 4
            goto L1c
        L1b:
            r5 = 2
        L1c:
            r5 = r5 | r4
            goto L1f
        L1e:
            r5 = r4
        L1f:
            r6 = r4 & 48
            if (r6 != 0) goto L2f
            boolean r6 = r3.I(r2)
            if (r6 == 0) goto L2c
            r6 = 32
            goto L2e
        L2c:
            r6 = 16
        L2e:
            r5 = r5 | r6
        L2f:
            r6 = r37 & 4
            if (r6 == 0) goto L38
            r5 = r5 | 384(0x180, float:5.38E-43)
        L35:
            r7 = r34
            goto L4a
        L38:
            r7 = r4 & 384(0x180, float:5.38E-43)
            if (r7 != 0) goto L35
            r7 = r34
            boolean r8 = r3.Z(r7)
            if (r8 == 0) goto L47
            r8 = 256(0x100, float:3.59E-43)
            goto L49
        L47:
            r8 = 128(0x80, float:1.8E-43)
        L49:
            r5 = r5 | r8
        L4a:
            r8 = r5 & 147(0x93, float:2.06E-43)
            r9 = 146(0x92, float:2.05E-43)
            r10 = 1
            if (r8 == r9) goto L53
            r8 = r10
            goto L54
        L53:
            r8 = 0
        L54:
            r9 = r5 & 1
            boolean r8 = r3.r(r8, r9)
            if (r8 == 0) goto Lac
            if (r6 == 0) goto L61
            androidx.compose.ui.Modifier$Companion r6 = androidx.compose.ui.Modifier.b8
            goto L62
        L61:
            r6 = r7
        L62:
            boolean r7 = androidx.compose.runtime.ComposerKt.M()
            if (r7 == 0) goto L6e
            r7 = -1
            java.lang.String r8 = "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsContent (TimeNudgeSettingsScreen.kt:105)"
            androidx.compose.runtime.ComposerKt.U(r0, r5, r7, r8)
        L6e:
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.p r0 = new cz.mobilesoft.coreblock.scene.more.settings.timenudge.p
            r0.<init>()
            r7 = 54
            r8 = 540220285(0x20331b7d, float:1.5170985E-19)
            androidx.compose.runtime.internal.ComposableLambda r27 = androidx.compose.runtime.internal.ComposableLambdaKt.e(r8, r10, r0, r3, r7)
            int r0 = r5 >> 6
            r29 = r0 & 14
            r30 = 12582912(0xc00000, float:1.7632415E-38)
            r31 = 131070(0x1fffe, float:1.83668E-40)
            r5 = r6
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r28 = r3
            androidx.compose.material.ScaffoldKt.a(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r23, r25, r27, r28, r29, r30, r31)
            boolean r0 = androidx.compose.runtime.ComposerKt.M()
            if (r0 == 0) goto Laa
            androidx.compose.runtime.ComposerKt.T()
        Laa:
            r3 = r5
            goto Lb2
        Lac:
            r28 = r3
            r28.Q()
            r3 = r7
        Lb2:
            androidx.compose.runtime.ScopeUpdateScope r6 = r28.n()
            if (r6 == 0) goto Lc2
            cz.mobilesoft.coreblock.scene.more.settings.timenudge.q r0 = new cz.mobilesoft.coreblock.scene.more.settings.timenudge.q
            r5 = r37
            r0.<init>()
            r6.a(r0)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsScreenKt.A(cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsViewState, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(final TimeNudgeSettingsViewState timeNudgeSettingsViewState, final Function1 function1, PaddingValues padding, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Modifier.Companion companion;
        boolean z2;
        int i5;
        Modifier.Companion companion2;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(540220285, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsContent.<anonymous> (TimeNudgeSettingsScreen.kt:109)");
            }
            List listC = timeNudgeSettingsViewState.c();
            if (listC == null) {
                composer.a0(460187113);
                Modifier modifierH = PaddingKt.h(Modifier.b8, padding);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
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
                Updater.e(composerA, measurePolicyA, companion3.e());
                Updater.e(composerA, compositionLocalMapU, companion3.g());
                Function2 function2B = companion3.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                PreferenceShimmerKt.b(0.0f, 0, composer, 0, 3);
                composer.y();
                composer.U();
            } else {
                composer.a0(460500120);
                Modifier.Companion companion4 = Modifier.b8;
                Modifier modifierH2 = PaddingKt.h(ScrollKt.g(companion4, ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), padding);
                Arrangement arrangement = Arrangement.f6574a;
                Arrangement.Vertical verticalH = arrangement.h();
                Alignment.Companion companion5 = Alignment.f25072a;
                MeasurePolicy measurePolicyA2 = ColumnKt.a(verticalH, companion5.k(), composer, 0);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH2);
                ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                Function0 function0A2 = companion6.a();
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
                Updater.e(composerA2, measurePolicyA2, companion6.e());
                Updater.e(composerA2, compositionLocalMapU2, companion6.g());
                Function2 function2B2 = companion6.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion6.f());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                w(null, composer, 0, 1);
                float f3 = 24;
                SpacerKt.a(SizeKt.v(companion4, Dp.g(f3)), composer, 6);
                int i8 = R.string.pD;
                String strB = StringResources_androidKt.b(i8, composer, 0);
                TextStyle textStyleE = ComposeTypographyKt.g(composer, 0).e();
                long jL = ComposeColorsKt.j(composer, 0).L();
                TextAlign.Companion companion7 = TextAlign.f29616b;
                float f4 = 16;
                TextKt.c(strB, PaddingKt.k(SizeKt.h(companion4, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null), jL, 0L, null, null, null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 48, 0, 65016);
                SpacerKt.a(SizeKt.v(companion4, Dp.g(8)), composer, 6);
                TextKt.c(StringResources_androidKt.b(R.string.TC, composer, 0), PaddingKt.k(SizeKt.h(companion4, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
                Composer composer2 = composer;
                SpacerKt.a(SizeKt.v(companion4, Dp.g(f3)), composer2, 6);
                Modifier modifierK = PaddingKt.k(companion4, Dp.g(f4), 0.0f, 2, null);
                MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion5.k(), composer2, 0);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierK);
                Function0 function0A3 = companion6.a();
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
                Updater.e(composerA3, measurePolicyA3, companion6.e());
                Updater.e(composerA3, compositionLocalMapU3, companion6.g());
                Function2 function2B3 = companion6.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion6.f());
                List list = listC;
                if (list.isEmpty() || !timeNudgeSettingsViewState.f()) {
                    companion = companion4;
                    z2 = false;
                    i5 = 1520118869;
                    composer2.a0(1520118869);
                } else {
                    composer2.a0(1526415279);
                    Modifier modifierM = PaddingKt.m(companion4, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
                    companion = companion4;
                    MeasurePolicy measurePolicyG = BoxKt.g(companion5.o(), false);
                    int iA4 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU4 = composer2.u();
                    Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierM);
                    Function0 function0A4 = companion6.a();
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
                    Updater.e(composerA4, measurePolicyG, companion6.e());
                    Updater.e(composerA4, compositionLocalMapU4, companion6.g());
                    Function2 function2B4 = companion6.b();
                    if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                        composerA4.w(Integer.valueOf(iA4));
                        composerA4.p(Integer.valueOf(iA4), function2B4);
                    }
                    Updater.e(composerA4, modifierF4, companion6.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    i5 = 1520118869;
                    z2 = false;
                    PermissionsCardKt.d(StringResources_androidKt.b(R.string.kD, composer2, 0), list, false, null, R.string.iD, Integer.valueOf(R.string.jD), composer, 384, 8);
                    composer2 = composer;
                    composer2.y();
                }
                composer2.U();
                if (timeNudgeSettingsViewState.e()) {
                    composer2.a0(1527630510);
                    companion2 = companion;
                    Modifier modifierM2 = PaddingKt.m(companion2, 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion5.o(), false);
                    int iA5 = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU5 = composer2.u();
                    Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierM2);
                    Function0 function0A5 = companion6.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A5);
                    } else {
                        composer2.v();
                    }
                    Composer composerA5 = Updater.a(composer2);
                    Updater.e(composerA5, measurePolicyG2, companion6.e());
                    Updater.e(composerA5, compositionLocalMapU5, companion6.g());
                    Function2 function2B5 = companion6.b();
                    if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                        composerA5.w(Integer.valueOf(iA5));
                        composerA5.p(Integer.valueOf(iA5), function2B5);
                    }
                    Updater.e(composerA5, modifierF5, companion6.f());
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                    i6 = 0;
                    u(StringResources_androidKt.b(R.string.oD, composer2, 0), composer2, 0);
                    composer2.y();
                } else {
                    companion2 = companion;
                    i6 = 0;
                    composer2.a0(i5);
                }
                composer2.U();
                String strB2 = StringResources_androidKt.b(i8, composer2, i6);
                boolean Z = composer2.Z(function1);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.s
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TimeNudgeSettingsScreenKt.C(function1);
                        }
                    };
                    composer2.w(objG);
                }
                Modifier.Companion companion8 = companion2;
                SectionedItemKt.P(null, strB2, null, null, null, null, 0L, 0L, 0L, null, null, (Function0) objG, Boolean.valueOf(timeNudgeSettingsViewState.f()), false, composer, 0, 0, 10237);
                if (timeNudgeSettingsViewState.f()) {
                    i7 = 0;
                    composer.a0(1520118869);
                } else {
                    composer.a0(1528353337);
                    SpacerKt.a(SizeKt.v(companion8, Dp.g(12)), composer, 6);
                    i7 = 0;
                    s(composer, 0);
                }
                composer.U();
                SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer, 6);
                DividerKt.b(SizeKt.h(companion8, 0.0f, 1, null), 0.0f, ComposeColorsKt.j(composer, i7).m0(), composer, 6, 2);
                SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer, 6);
                List listD = timeNudgeSettingsViewState.d();
                boolean zF = timeNudgeSettingsViewState.f();
                boolean Z2 = composer.Z(timeNudgeSettingsViewState) | composer.Z(function1);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TimeNudgeSettingsScreenKt.D(timeNudgeSettingsViewState, function1);
                        }
                    };
                    composer.w(objG2);
                }
                n(listD, zF, (Function0) objG2, composer, 0);
                if (timeNudgeSettingsViewState.f() && timeNudgeSettingsViewState.d().isEmpty()) {
                    composer.a0(1529445250);
                    SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer, 6);
                    u(StringResources_androidKt.b(R.string.ZC, composer, 0), composer, 0);
                } else {
                    composer.a0(1520118869);
                }
                composer.U();
                SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer, 6);
                composer.y();
                composer.y();
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
    public static final Unit C(Function1 function1) {
        function1.invoke(TimeNudgeSettingsViewEvent.OnEnabledClick.f110281a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(TimeNudgeSettingsViewState timeNudgeSettingsViewState, Function1 function1) {
        if (timeNudgeSettingsViewState.f()) {
            function1.invoke(TimeNudgeSettingsViewEvent.OnAppsClick.f110280a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(TimeNudgeSettingsViewState timeNudgeSettingsViewState, Function1 function1, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        A(timeNudgeSettingsViewState, function1, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
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
    public static final void F(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Bundle bundleB;
        Composer composerK = composer.k(-1382259368);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                modifier2 = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1382259368, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeSettingsScreen (TimeNudgeSettingsScreen.kt:70)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(TimeNudgeSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            TimeNudgeSettingsViewModel timeNudgeSettingsViewModel = (TimeNudgeSettingsViewModel) viewModelA;
            TimeNudgeSettingsViewState timeNudgeSettingsViewState = (TimeNudgeSettingsViewState) FlowExtKt.m(timeNudgeSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(timeNudgeSettingsViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = composerK.I(coroutineScope) | composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.k
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TimeNudgeSettingsScreenKt.G(coroutineScope, function1N, (LifecycleOwner) obj, (Lifecycle.Event) obj2);
                    }
                };
                composerK.w(objG2);
            }
            ComposableExtKt.j(null, (Function2) objG2, composerK, 0, 1);
            q(timeNudgeSettingsViewModel, composerK, 0);
            A(timeNudgeSettingsViewState, function1N, modifier2, composerK, (i5 << 6) & 896, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.H(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(CoroutineScope coroutineScope, Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f110277a[event.ordinal()] == 1) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new TimeNudgeSettingsScreenKt$TimeNudgeSettingsScreen$1$1$1(function1, null), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        F(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(List list, boolean z2, Function0 function0, int i3, Composer composer, int i4) {
        n(list, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void q(TimeNudgeSettingsViewModel timeNudgeSettingsViewModel, Composer composer, final int i3) {
        int i4;
        final TimeNudgeSettingsViewModel timeNudgeSettingsViewModel2;
        Composer composerK = composer.k(-1710457406);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(timeNudgeSettingsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1710457406, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.CommandProcessor (TimeNudgeSettingsScreen.kt:219)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(context);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new TimeNudgeSettingsScreenKt$CommandProcessor$1$1(context, null);
                composerK.w(objG);
            }
            timeNudgeSettingsViewModel2 = timeNudgeSettingsViewModel;
            FlowExtKt.g(timeNudgeSettingsViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            timeNudgeSettingsViewModel2 = timeNudgeSettingsViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.r(timeNudgeSettingsViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(TimeNudgeSettingsViewModel timeNudgeSettingsViewModel, int i3, Composer composer, int i4) {
        q(timeNudgeSettingsViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void s(Composer composer, final int i3) {
        Composer composerK = composer.k(-1892894808);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1892894808, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.DisabledWarningRow (TimeNudgeSettingsScreen.kt:333)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.b(), Alignment.f25072a.i(), composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.p6, composerK, 6), null, SizeKt.v(companion, Dp.g(20)), Color.f25715b.k(), composerK, 3504, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(8)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.YC, composerK, 0), null, ComposeColorsKt.j(composerK, 0).c0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.t(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(int i3, Composer composer, int i4) {
        s(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void u(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-792169139);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-792169139, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.InfoRow (TimeNudgeSettingsScreen.kt:415)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.N2, composerK, 0), null, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), ComposeColorsKt.j(composerK, 0).V(), composerK, 432, 0);
            composer2 = composerK;
            TextKt.c(str, null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, i4 & 14, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.v(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, int i3, Composer composer, int i4) {
        u(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void w(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composerK = composer.k(-1615874198);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1615874198, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeHeroImage (TimeNudgeSettingsScreen.kt:252)");
            }
            Modifier modifierB = AspectRatioKt.b(SizeKt.h(modifier3, 0.0f, 1, null), 1.7142857f, false, 2, null);
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Painter painterC = PainterResources_androidKt.c(R.drawable.e8, composerK, 0);
            ContentScale contentScaleB = ContentScale.f27054a.b();
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifier4 = modifier3;
            ImageKt.a(painterC, null, SizeKt.f(companion3, 0.0f, 1, null), null, contentScaleB, 0.0f, null, composerK, 25008, 104);
            Modifier modifierF2 = SizeKt.f(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion.g(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyA, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(SizeKt.c(companion3, 0.35f), composerK, 6);
            y(SizeKt.g(companion3, 0.72f), composerK, 6, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.x(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        w(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void y(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Composer composer2;
        Composer composerK = composer.k(1642686528);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1642686528, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.timenudge.TimeNudgeNotificationBubble (TimeNudgeSettingsScreen.kt:281)");
            }
            float f3 = 20;
            float f4 = 10;
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(ClipKt.a(modifier3, RoundedCornerShapeKt.d(Dp.g(f3))), ColorKt.d(DarkThemeKt.a(composerK, 0) ? 4282337111L : 4288793070L), null, 2, null), Dp.g(12), Dp.g(f4));
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Vertical verticalI = companion.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(ClipKt.a(SizeKt.v(companion3, Dp.g(36)), RoundedCornerShapeKt.g()), ComposeColorsKt.j(composerK, 0).b(), null, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
            Function0 function0A2 = companion2.a();
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
            Updater.e(composerA2, measurePolicyG, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            IconKt.a(PainterResources_androidKt.c(R.drawable.C0, composerK, 0), null, SizeKt.v(companion3, Dp.g(f3)), ComposeColorsKt.j(composerK, 0).q0(), composerK, 432, 0);
            composerK.y();
            SpacerKt.a(SizeKt.v(companion3, Dp.g(f4)), composerK, 6);
            Modifier modifierA = rowScopeInstance.a(companion3, 1.0f, false);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierA);
            Function0 function0A3 = companion2.a();
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
            Updater.e(composerA3, measurePolicyA, companion2.e());
            Updater.e(composerA3, compositionLocalMapU3, companion2.g());
            Function2 function2B3 = companion2.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer2 = composerK;
            Modifier modifier4 = modifier3;
            TextKt.c(StringResources_androidKt.b(R.string.hD, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, 0, 3072, 57338);
            TextKt.c(StringResources_androidKt.b(R.string.gD, composer2, 0), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 2, 0, null, TextStyle.e(ComposeTypographyKt.g(composer2, 0).b(), 0L, TextUnitKt.i(14), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, TextUnitKt.i(18), null, null, null, 0, 0, null, 16646141, null), composer2, 0, 3072, 57338);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.z(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        y(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void n(final List list, final boolean z2, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1275985322);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1275985322, i4, -1, QgXempTBEfV.GPMzcMb);
            }
            ComposeCardsKt.m(SizeKt.h(Modifier.b8, 0.0f, 1, null), new CardType.Surface(null, null, null, 7, null), function0, ComposableLambdaKt.e(454081103, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.o(z2, list, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, (i4 & 896) | 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.timenudge.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TimeNudgeSettingsScreenKt.p(list, z2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, List list, Composer composer, int i3) throws Exception {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(454081103, i3, -1, pnxuebdT.ZmUyBgxT);
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierA = AlphaKt.a(PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), z2 ? 1.0f : 0.4f);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
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
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            TextKt.c(StringResources_androidKt.b(R.string.G1, composer, 0), RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65528);
            AppIconsWithCountKt.c(list, null, 3, 0.0f, 0L, null, 0L, composer, 384, 122);
            float f4 = 8;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            ImageVector.Companion companion4 = ImageVector.f26323k;
            IconKt.b(VectorResources_androidKt.b(companion4, R.drawable.f95580y1, composer, 6), StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.v(companion, Dp.g(24)), ComposeColorsKt.j(composer, 0).M(), composer, 384, 0);
            composer.y();
            SpacerKt.a(SizeKt.v(companion, Dp.g(12)), composer, 6);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, companion);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyB2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            IconKt.b(VectorResources_androidKt.b(companion4, R.drawable.f95527j1, composer, 6), null, SizeKt.v(companion, Dp.g(f3)), ComposeColorsKt.j(composer, 0).O(), composer, 432, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.XC, composer, 0), null, ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
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
}
