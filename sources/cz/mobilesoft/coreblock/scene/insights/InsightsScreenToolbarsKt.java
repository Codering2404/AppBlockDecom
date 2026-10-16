package cz.mobilesoft.coreblock.scene.insights;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DoneKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import coil.compose.SingletonAsyncImageKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewEvent;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.scene.insights.settings.InsightsSettingsActivity;
import cz.mobilesoft.coreblock.scene.sharing.SocialsSharingActivity;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayloadMappersKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ContextExtKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownItem;
import cz.mobilesoft.coreblock.view.compose.ComposeDropdownKt;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InsightsScreenToolbarsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f102659a;

        static {
            int[] iArr = new int[InsightsViewState.InsightsPeriodType.values().length];
            try {
                iArr[InsightsViewState.InsightsPeriodType.Day.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Week.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InsightsViewState.InsightsPeriodType.Trend.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f102659a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(InsightsViewState insightsViewState, Context context) {
        String str;
        SocialsSharePayload socialsSharePayloadA = SocialsSharePayloadMappersKt.a(insightsViewState);
        int i3 = WhenMappings.f102659a[insightsViewState.a0().ordinal()];
        if (i3 == 1) {
            str = "insights_daily";
        } else if (i3 == 2) {
            str = "insights_weekly";
        } else {
            if (i3 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            str = "insights_trend";
        }
        AnswersHelper.f128199a.B6(str);
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.startActivity(SocialsSharingActivity.f119356f.a(context, socialsSharePayloadA));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        y(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void m(final InsightsViewState insightsViewState, final PackageManager packageManager, final String str, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Composer composerK = composer.k(-1658141663);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(insightsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(packageManager) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(str) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1658141663, i4, -1, "cz.mobilesoft.coreblock.scene.insights.AppDetailToolbar (InsightsScreenToolbars.kt:161)");
            }
            if (str == null) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.t6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return InsightsScreenToolbarsKt.n(insightsViewState, packageManager, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            boolean z2 = (i4 & 896) == 256;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = insightsViewState.g(packageManager, str);
                composerK.w(objG);
            }
            Pair pair = (Pair) objG;
            String str2 = (String) pair.a();
            Drawable drawable = (Drawable) pair.b();
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            float f3 = 56;
            float f4 = 8;
            Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), Dp.g(f4), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.h());
            boolean zI = composerK.I(context);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.u6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenToolbarsKt.o(context);
                    }
                };
                composerK.w(objG2);
            }
            IconButtonKt.a((Function0) objG2, modifierF2, false, null, ComposableSingletons$InsightsScreenToolbarsKt.f102584a.d(), composerK, 24576, 12);
            Modifier modifierF3 = boxScopeInstance.f(PaddingKt.k(SizeKt.i(companion, Dp.g(f3)), Dp.g(f4), 0.0f, 2, null), companion2.e());
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 48);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            SingletonAsyncImageKt.b(drawable, null, SizeKt.v(companion, Dp.g(32)), null, null, PainterResources_androidKt.c(R.drawable.H6, composerK, 0), null, null, null, null, null, 0.0f, null, 0, composerK, 432, 0, 16344);
            TextKt.c(str2, PaddingKt.m(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65532);
            composerK = composerK;
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.v6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenToolbarsKt.p(insightsViewState, packageManager, str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(InsightsViewState insightsViewState, PackageManager packageManager, String str, int i3, Composer composer, int i4) {
        m(insightsViewState, packageManager, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.finish();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(InsightsViewState insightsViewState, PackageManager packageManager, String str, int i3, Composer composer, int i4) {
        m(insightsViewState, packageManager, str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void q(final InsightsViewState insightsViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1165787825);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(insightsViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1165787825, i4, -1, "cz.mobilesoft.coreblock.scene.insights.AppTypeIcon (InsightsScreenToolbars.kt:219)");
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
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.z6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenToolbarsKt.r(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            IconButtonKt.a((Function0) objG2, null, false, null, ComposableLambdaKt.e(-1504158157, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.a7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenToolbarsKt.s(insightsViewState, mutableState, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 24582, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.b7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenToolbarsKt.v(insightsViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(InsightsViewState insightsViewState, final MutableState mutableState, final Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        Unit unit;
        ImageVector imageVectorB;
        ImageVector imageVectorB2;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1504158157, i3, -1, "cz.mobilesoft.coreblock.scene.insights.AppTypeIcon.<anonymous> (InsightsScreenToolbars.kt:229)");
            }
            AppDistractionType appDistractionTypeF = insightsViewState.f();
            if (appDistractionTypeF == null) {
                composer.a0(-981789368);
                composer.U();
                unit = null;
            } else {
                composer.a0(-981789367);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierC = BackgroundKt.c(SizeKt.v(companion, Dp.g(24)), appDistractionTypeF.m1357getColor0d7_KjU(), RoundedCornerShapeKt.a(50));
                Alignment.Companion companion2 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierC);
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
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.U1, composer, 6), null, BoxScopeInstance.f6642a.f(companion, companion2.e()), Color.f25715b.k(), composer, 3120, 0);
                composer.y();
                composer.U();
                unit = Unit.f139807a;
            }
            if (unit == null) {
                composer.a0(-981124107);
                IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95579y0, composer, 6), null, SizeKt.v(Modifier.b8, Dp.g(24)), Color.f25715b.k(), composer, 3504, 0);
                composer.U();
            } else {
                composer.a0(1907991227);
                composer.U();
            }
            composer.a0(1908026153);
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            String strC = StringHelperExtKt.c(StringResources_androidKt.b(R.string.f95822n0, composer, 0));
            boolean z2 = insightsViewState.f() == null;
            long jP = ComposeColorsKt.j(composer, 0).p();
            if (z2) {
                composer.a0(14752604);
                composer.U();
                imageVectorB = DoneKt.a(Icons.f15145a.a());
            } else {
                composer.a0(14840892);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T1, composer, 6);
                composer.U();
            }
            ImageVector imageVector = imageVectorB;
            Color colorN = Color.n(jP);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.r6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InsightsScreenToolbarsKt.t(mutableState, function1);
                    }
                };
                composer.w(objG);
            }
            listCreateListBuilder.add(new ComposeDropdownItem(strC, colorN, null, false, null, null, imageVector, null, (Function0) objG, 184, null));
            composer.a0(1908054601);
            Iterator<AppDistractionType> it = AppDistractionType.getEntries().iterator();
            while (it.hasNext()) {
                final AppDistractionType next = it.next();
                boolean z3 = insightsViewState.f() == next;
                String strB = StringResources_androidKt.b(next.getNameRes(), composer, 0);
                long jP2 = ComposeColorsKt.j(composer, 0).p();
                if (z3) {
                    composer.a0(1912667034);
                    composer.U();
                    imageVectorB2 = DoneKt.a(Icons.f15145a.a());
                } else {
                    composer.a0(1912763258);
                    imageVectorB2 = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.T1, composer, 6);
                    composer.U();
                }
                ImageVector imageVector2 = imageVectorB2;
                Color colorN2 = !z3 ? Color.n(next.m1357getColor0d7_KjU()) : null;
                Color colorN3 = Color.n(jP2);
                boolean Z2 = composer.Z(function1) | composer.e(next.ordinal());
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.s6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenToolbarsKt.u(mutableState, function1, next);
                        }
                    };
                    composer.w(objG2);
                }
                listCreateListBuilder.add(new ComposeDropdownItem(strB, colorN3, colorN2, false, null, null, imageVector2, null, (Function0) objG2, 184, null));
            }
            composer.U();
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            composer.U();
            ComposeDropdownKt.j(mutableState, null, listBuild, composer, 54);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, Function1 function1) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(new InsightsViewEvent.OnAppTypeSelected("All"));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, Function1 function1, AppDistractionType appDistractionType) {
        mutableState.setValue(Boolean.FALSE);
        function1.invoke(new InsightsViewEvent.OnAppTypeSelected(appDistractionType.name()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        q(insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(PackageManager packageManager, InsightsViewState insightsViewState, Function1 function1, int i3, Composer composer, int i4) {
        w(packageManager, insightsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void y(InsightsViewState insightsViewState, Function1 function1, Composer composer, final int i3) {
        int i4;
        final InsightsViewState insightsViewState2;
        final Function1 function12 = function1;
        Composer composerK = composer.k(-462202399);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(insightsViewState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function12) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-462202399, i4, -1, "cz.mobilesoft.coreblock.scene.insights.OverviewToolbar (InsightsScreenToolbars.kt:83)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(56)), Dp.g(8), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            int i5 = i4;
            TextKt.c(StringResources_androidKt.b(R.string.zh, composerK, 0), boxScopeInstance.f(companion, companion2.e()), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65020);
            composerK = composerK;
            if (insightsViewState.R()) {
                insightsViewState2 = insightsViewState;
                function12 = function1;
                composerK.a0(678572039);
            } else {
                composerK.a0(682369570);
                Modifier modifierF2 = boxScopeInstance.f(companion, companion2.h());
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), companion2.i(), composerK, 48);
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
                Updater.e(composerA2, measurePolicyB, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion3.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                boolean zI = composerK.I(context);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.w6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InsightsScreenToolbarsKt.z(context);
                        }
                    };
                    composerK.w(objG);
                }
                ComposableSingletons$InsightsScreenToolbarsKt composableSingletons$InsightsScreenToolbarsKt = ComposableSingletons$InsightsScreenToolbarsKt.f102584a;
                IconButtonKt.a((Function0) objG, null, false, null, composableSingletons$InsightsScreenToolbarsKt.e(), composerK, 24576, 14);
                if (insightsViewState.q()) {
                    composerK.a0(-2050004388);
                    boolean zI2 = composerK.I(context) | ((i5 & 14) == 4);
                    Object objG2 = composerK.G();
                    if (zI2 || objG2 == Composer.f23746a.a()) {
                        insightsViewState2 = insightsViewState;
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.insights.x6
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return InsightsScreenToolbarsKt.A(insightsViewState2, context);
                            }
                        };
                        composerK.w(objG2);
                    } else {
                        insightsViewState2 = insightsViewState;
                    }
                    IconButtonKt.a((Function0) objG2, null, false, null, composableSingletons$InsightsScreenToolbarsKt.f(), composerK, 24576, 14);
                } else {
                    insightsViewState2 = insightsViewState;
                    composerK.a0(-2054542106);
                }
                composerK.U();
                composerK.y();
                Modifier modifierF4 = boxScopeInstance.f(companion, companion2.f());
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
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
                Updater.e(composerA3, measurePolicyG2, companion3.e());
                Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                Function2 function2B3 = companion3.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF5, companion3.f());
                function12 = function1;
                q(insightsViewState2, function12, composerK, i5 & 126);
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            insightsViewState2 = insightsViewState;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.y6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenToolbarsKt.B(insightsViewState2, function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Context context) {
        Activity activityB = ContextExtKt.b(context);
        if (activityB != null) {
            activityB.startActivity(new Intent(context, (Class<?>) InsightsSettingsActivity.class));
        }
        return Unit.f139807a;
    }

    public static final void w(final PackageManager packageManager, final InsightsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(packageManager, bfIdKSjLOVjG.AVwpwxzmvMPPZ);
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(1823655612);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(packageManager) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1823655612, i4, -1, "cz.mobilesoft.coreblock.scene.insights.InsightsToolbar (InsightsScreenToolbars.kt:55)");
            }
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ComposeCommonsKt.l(Color.f25715b.j(), composerK, 6, 0);
            if (viewState.p0()) {
                composerK.a0(-1405257983);
                m(viewState, packageManager, viewState.V(), composerK, ((i4 << 3) & 112) | ((i4 >> 3) & 14));
                composerK.U();
            } else {
                composerK.a0(-1405048919);
                y(viewState, onEvent, composerK, (i4 >> 3) & 126);
                composerK.U();
            }
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.insights.q6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InsightsScreenToolbarsKt.x(packageManager, viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
