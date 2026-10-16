package cz.mobilesoft.coreblock.view.compose.profileitem;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material3.CheckboxColors;
import androidx.compose.material3.CheckboxKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
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
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDescriptor;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewActivity;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.IconClusterKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
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
public final class ProfileItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        t1(scaffoldState, profileViewDTO, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C1(ColumnScope columnScope, String str, String str2, long j3, int i3, int i4, Composer composer, int i5) {
        B1(columnScope, str, str2, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    private static final void D1(Context context, ProfileViewDTO profileViewDTO) {
        if (profileViewDTO.N()) {
            context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.QuickBlock(false, false, false, false, null, null, 63, null), false, false, 12, null));
            return;
        }
        if (profileViewDTO.z()) {
            context.startActivity(SchedulePreviewActivity.f117350g.a(context, profileViewDTO, true ^ profileViewDTO.y()));
            return;
        }
        if (profileViewDTO.x() && !profileViewDTO.B()) {
            context.startActivity(SchedulePreviewActivity.Companion.b(SchedulePreviewActivity.f117350g, context, profileViewDTO, false, 4, null));
        } else if (profileViewDTO.x()) {
            context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.ScheduleId(profileViewDTO.k(), false), false, false, 12, null));
        } else {
            context.startActivity(SchedulePreviewActivity.f117350g.a(context, profileViewDTO, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(MutableState mutableState, MutableState mutableState2, ProfileViewDTO profileViewDTO, MutableState mutableState3) {
        mutableState.setValue(Boolean.FALSE);
        mutableState2.setValue(profileViewDTO);
        mutableState3.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(MutableState mutableState, Function1 function1) {
        ProfileViewDTO profileViewDTO = (ProfileViewDTO) mutableState.getValue();
        if (profileViewDTO != null) {
            function1.invoke(profileViewDTO);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H0(MutableState mutableState, ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, boolean z2, Function0 function0, Function0 function02, Function0 function03, Function0 function04, Function1 function1, Function0 function05, Function0 function06, int i3, int i4, int i5, Composer composer, int i6) throws XmlPullParserException, IOException {
        y0(mutableState, scaffoldState, profileViewDTO, z2, function0, function02, function03, function04, function1, function05, function06, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void I0(final androidx.compose.material.ScaffoldState r17, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r18, final cz.mobilesoft.coreblock.util.view.AppIconCache r19, java.lang.Boolean r20, boolean r21, kotlin.jvm.functions.Function0 r22, final kotlin.jvm.functions.Function1 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.I0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, cz.mobilesoft.coreblock.util.view.AppIconCache, java.lang.Boolean, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, AppIconCache appIconCache, Boolean bool, boolean z2, Function0 function0, Function1 function1, int i3, int i4, Composer composer, int i5) {
        I0(scaffoldState, profileViewDTO, appIconCache, bool, z2, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void K0(final androidx.compose.material.ScaffoldState r22, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r23, final cz.mobilesoft.coreblock.util.view.AppIconCache r24, java.lang.Boolean r25, final boolean r26, final kotlin.jvm.functions.Function1 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 657
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.K0(androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, cz.mobilesoft.coreblock.util.view.AppIconCache, java.lang.Boolean, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean L0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M0(Function1 function1, ProfileViewDTO profileViewDTO, boolean z2) {
        function1.invoke(new ProfileItemEvent.OnProfileSelected(profileViewDTO, z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(ProfileViewDTO profileViewDTO, Context context) {
        if (profileViewDTO.N()) {
            context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.QuickBlock(false, false, false, false, null, null, 63, null), false, false, 12, null));
        } else {
            context.startActivity(ScheduleActivity.Companion.b(ScheduleActivity.f114377m, context, new ScheduleDescriptor.ScheduleId(profileViewDTO.k(), profileViewDTO.x()), false, false, 12, null));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(Function1 function1, Boolean bool) {
        function1.invoke(Boolean.valueOf(!bool.booleanValue()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P0(ProfileViewDTO profileViewDTO, Boolean bool, final Function1 function1, boolean z2, AppIconCache appIconCache, ScaffoldState scaffoldState, boolean z3, Function1 function12, Composer composer, int i3) throws XmlPullParserException, IOException {
        Modifier.Companion companion;
        char c3;
        int i4;
        char c4;
        Composer composer2;
        Composer composer3;
        RowScopeInstance rowScopeInstance;
        Composer composer4;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1739398016, i3, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemActive.<anonymous> (ProfileItem.kt:598)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierI = PaddingKt.i(companion2, Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composer, 48);
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
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
            if (profileViewDTO.K() || profileViewDTO.D()) {
                composer.a0(1871424467);
                companion = companion2;
                c3 = 6;
                i4 = 1849895432;
                c4 = 24;
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95524i2, composer, 6), StringResources_androidKt.b(profileViewDTO.K() ? R.string.Wn : R.string.lu, composer, 0), SizeKt.v(PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(10), 0.0f, 11, null), Dp.g(24)), null, null, 0.0f, null, composer, 384, 120);
                composer2 = composer;
                composer2.U();
            } else {
                composer.a0(1849895432);
                composer.U();
                c4 = 24;
                c3 = 6;
                composer2 = composer;
                companion = companion2;
                i4 = 1849895432;
            }
            Modifier.Companion companion5 = companion;
            Composer composer5 = composer2;
            e0(profileViewDTO, ComposeColorsKt.j(composer2, 0).p(), RowScope.c(rowScopeInstance2, companion5, 1.0f, false, 2, null), composer5, 0, 0);
            if (!profileViewDTO.E() || bool == null) {
                if (appIconCache != null) {
                    composer5.a0(1872596856);
                    rowScopeInstance = rowScopeInstance2;
                    IconClusterKt.k(null, ExtensionsKt.h(profileViewDTO.d()), ExtensionsKt.h(profileViewDTO.s()), null, profileViewDTO.m(), profileViewDTO.h() == Profile.BlockingMode.Blocklist, false, profileViewDTO.h(), false, false, false, false, composer, 0, 0, 3913);
                    composer3 = composer;
                } else {
                    composer3 = composer5;
                    rowScopeInstance = rowScopeInstance2;
                    composer3.a0(i4);
                }
                composer3.U();
            } else {
                composer5.a0(1872283322);
                boolean zBooleanValue = bool.booleanValue();
                CheckboxColors checkboxColorsH = ComposeColorsKt.h(composer5, 0);
                boolean Z = composer5.Z(function1);
                Object objG = composer5.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ProfileItemKt.Q0(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer5.w(objG);
                }
                CheckboxKt.a(zBooleanValue, (Function1) objG, null, z2, checkboxColorsH, null, composer, 0, 36);
                composer.U();
                composer3 = composer;
                rowScopeInstance = rowScopeInstance2;
            }
            composer3.y();
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion5, 1.0f, false, 2, null), composer3, 0);
            Alignment.Vertical verticalA = companion3.a();
            Modifier modifierM = PaddingKt.m(companion5, 0.0f, 0.0f, Dp.g(7), 0.0f, 11, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), verticalA, composer3, 48);
            int iA3 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU3 = composer3.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer3, modifierM);
            Function0 function0A3 = companion4.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A3);
            } else {
                composer3.v();
            }
            Composer composerA3 = Updater.a(composer3);
            Updater.e(composerA3, measurePolicyB2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            RowScopeInstance rowScopeInstance3 = rowScopeInstance;
            Modifier modifierC = RowScope.c(rowScopeInstance3, rowScopeInstance3.d(companion5, companion3.i()), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.k(), composer3, 0);
            int iA4 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU4 = composer3.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer3, modifierC);
            Function0 function0A4 = companion4.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A4);
            } else {
                composer3.v();
            }
            Composer composerA4 = Updater.a(composer3);
            Updater.e(composerA4, measurePolicyA2, companion4.e());
            Updater.e(composerA4, compositionLocalMapU4, companion4.g());
            Function2 function2B4 = companion4.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion4.f());
            String strR = profileViewDTO.r();
            if (strR == null || strR.length() == 0) {
                composer4 = composer3;
                composer4.a0(-354797634);
                B1(columnScopeInstance, profileViewDTO.o(), profileViewDTO.q(), 0L, composer4, 6, 8);
                composer4.U();
            } else {
                composer3.a0(-354667558);
                m0(columnScopeInstance, profileViewDTO.p(), profileViewDTO.r(), composer3, 6, 0);
                composer4 = composer3;
                composer4.U();
            }
            composer4.y();
            if (!profileViewDTO.E() && profileViewDTO.J() && profileViewDTO.x()) {
                composer4.a0(-1153043176);
                ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A3, composer4, 6), null, PaddingKt.m(rowScopeInstance3.d(SizeKt.v(companion5, Dp.g(24)), companion3.a()), 0.0f, 0.0f, 0.0f, Dp.g(0), 7, null), null, null, 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composer4, 0).b(), 0, 2, null), composer, 48, 56);
                composer4 = composer;
                composer4.U();
            } else {
                if (profileViewDTO.E() || profileViewDTO.L() || profileViewDTO.z()) {
                    composer4.a0(-1177162447);
                } else {
                    composer4.a0(-1152418154);
                    o0(scaffoldState, profileViewDTO, z3, function12, composer, 0);
                    composer4 = composer;
                }
                composer4.U();
            }
            composer4.y();
            composer4.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(Function1 function1, boolean z2) {
        function1.invoke(Boolean.valueOf(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, AppIconCache appIconCache, Boolean bool, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        K0(scaffoldState, profileViewDTO, appIconCache, bool, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void S0(final ScaffoldState scaffoldState, final ProfileViewDTO profileViewDTO, final boolean z2, final Function1 function1, Composer composer, final int i3) {
        int i4;
        final boolean z3;
        Function1 function12;
        Function0 function0;
        Composer composerK = composer.k(-587588117);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(profileViewDTO) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            z3 = z2;
            i4 |= composerK.b(z3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            z3 = z2;
        }
        if ((i3 & 3072) == 0) {
            function12 = function1;
            i4 |= composerK.I(function12) ? 2048 : 1024;
        } else {
            function12 = function1;
        }
        boolean z4 = false;
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-587588117, i4, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemDisabled (ProfileItem.kt:147)");
            }
            if (profileViewDTO.A()) {
                composerK.a0(1449342752);
                final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
                boolean zI = ((i4 & 112) == 32) | composerK.I(context);
                Object objG = composerK.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileItemKt.T0(context, profileViewDTO);
                        }
                    };
                    composerK.w(objG);
                }
                function0 = (Function0) objG;
                composerK.U();
            } else {
                composerK.a0(1449463621);
                Object objG2 = composerK.G();
                if (objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ProfileItemKt.U0();
                        }
                    };
                    composerK.w(objG2);
                }
                function0 = (Function0) objG2;
                composerK.U();
            }
            Function0 function02 = function0;
            if ((!profileViewDTO.E() && !profileViewDTO.L() && !profileViewDTO.z()) || profileViewDTO.z() || (profileViewDTO.B() && !profileViewDTO.L())) {
                z4 = true;
            }
            final Function1 function13 = function12;
            final boolean z5 = z4;
            ComposeCardsKt.m(SizeKt.k(Modifier.b8, Dp.g(120), 0.0f, 2, null), new CardType.Surface(null, null, null, 7, null), function02, ComposableLambdaKt.e(1578556240, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.V0(profileViewDTO, function13, z5, scaffoldState, z3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3078, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.X0(scaffoldState, profileViewDTO, z2, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(Context context, ProfileViewDTO profileViewDTO) {
        D1(context, profileViewDTO);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(final ProfileViewDTO profileViewDTO, final Function1 function1, boolean z2, ScaffoldState scaffoldState, boolean z3, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1578556240, i3, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemDisabled.<anonymous> (ProfileItem.kt:167)");
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
            Alignment.Horizontal horizontalG = companion2.g();
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion, companion2.m()), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            l1(ColumnScopeInstance.f6666a, profileViewDTO, false, false, composer, 6, 6);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(VectorResources_androidKt.b(ImageVector.f26323k, profileViewDTO.D() ? R.drawable.s4 : R.drawable.k4, composer, 6), Color.n(ComposeColorsKt.j(composer, 0).q0()), StringResources_androidKt.b(profileViewDTO.D() ? R.string.bC : R.string.Js, composer, 0), null, false, 24, null);
            ButtonColor premium = profileViewDTO.D() ? new ButtonColor.Premium(false, null, false, null, 15, null) : new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function1) | composer.Z(profileViewDTO);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.W0(function1, profileViewDTO);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, smallRound, premium, (Function0) objG, composer, 0, 1);
            composer.y();
            n1(boxScopeInstance, profileViewDTO, false, composer, 6, 2);
            Modifier modifierF3 = boxScopeInstance.f(companion, companion2.n());
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
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
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            if (profileViewDTO.E() || !profileViewDTO.J()) {
                if (z2) {
                    composer.a0(360741194);
                    o0(scaffoldState, profileViewDTO, z3, function1, composer, 0);
                } else {
                    composer.a0(352317285);
                }
                composer.U();
            } else {
                composer.a0(360627300);
                j1(composer, 0);
                composer.U();
            }
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
    public static final Unit W0(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new ProfileItemEvent.OnProfileActionButtonClicked(profileViewDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        S0(scaffoldState, profileViewDTO, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void Y0(final androidx.compose.material.ScaffoldState r16, kotlin.jvm.functions.Function0 r17, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r18, final boolean r19, final kotlin.jvm.functions.Function1 r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.Y0(androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function0, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Context context, ProfileViewDTO profileViewDTO) {
        D1(context, profileViewDTO);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c1(ScaffoldState scaffoldState, Function0 function0, ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        Y0(scaffoldState, function0, profileViewDTO, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d1(final androidx.compose.ui.graphics.Color r16, final androidx.compose.material.ScaffoldState r17, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r18, final boolean r19, androidx.compose.ui.unit.Dp r20, final boolean r21, final kotlin.jvm.functions.Function1 r22, final kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.d1(androidx.compose.ui.graphics.Color, androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, androidx.compose.ui.unit.Dp, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e0(final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r31, final long r32, androidx.compose.ui.Modifier r34, androidx.compose.runtime.Composer r35, final int r36, final int r37) {
        /*
            Method dump skipped, instruction units count: 412
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.e0(cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, long, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(ProfileViewDTO profileViewDTO, boolean z2, ScaffoldState scaffoldState, boolean z3, Function1 function1, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-57066943, i3, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEnabledContent.<anonymous> (ProfileItem.kt:295)");
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
            Alignment.Horizontal horizontalG = companion2.g();
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion, companion2.m()), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            l1(ColumnScopeInstance.f6666a, profileViewDTO, z2, false, composer, 6, 4);
            composer.y();
            n1(boxScopeInstance, profileViewDTO, false, composer, 6, 2);
            Modifier modifierF3 = boxScopeInstance.f(companion, companion2.n());
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
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
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            if (profileViewDTO.J()) {
                composer.a0(103829293);
                j1(composer, 0);
                composer.U();
            } else {
                if (profileViewDTO.L()) {
                    composer.a0(92187150);
                } else {
                    composer.a0(103953107);
                    o0(scaffoldState, profileViewDTO, z3, function1, composer, 0);
                }
                composer.U();
            }
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

    private static final boolean f0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Color color, ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, boolean z2, Dp dp, boolean z3, Function1 function1, Function0 function0, int i3, int i4, Composer composer, int i5) {
        d1(color, scaffoldState, profileViewDTO, z2, dp, z3, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void g0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    public static final void g1(Modifier modifier, final ProfileViewDTO profile, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Intrinsics.checkNotNullParameter(profile, "profile");
        Composer composerK = composer.k(-1339424864);
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
            i5 |= composerK.Z(profile) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1339424864, i5, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemGrayscaleContent (ProfileItem.kt:339)");
            }
            ComposeCardsKt.m(SizeKt.k(modifier3, Dp.g(120), 0.0f, 2, null), new CardType.Surface(null, null, null, 7, null), null, ComposableLambdaKt.e(-1079458597, true, new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.h1(profile, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3456, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.i1(modifier3, profile, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int h0(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(ProfileViewDTO profileViewDTO, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1079458597, i3, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemGrayscaleContent.<anonymous> (ProfileItem.kt:345)");
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
            Alignment.Horizontal horizontalG = companion2.g();
            Modifier modifierM = PaddingKt.m(boxScopeInstance.f(companion, companion2.m()), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierM);
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
            l1(ColumnScopeInstance.f6666a, profileViewDTO, false, true, composer, 3462, 0);
            composer.y();
            n1(boxScopeInstance, profileViewDTO, true, composer, 390, 0);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final void i0(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(Modifier modifier, ProfileViewDTO profileViewDTO, int i3, int i4, Composer composer, int i5) {
        g1(modifier, profileViewDTO, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier j0(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.k(applyIf, Dp.g(16), 0.0f, 2, null);
    }

    private static final void j1(Composer composer, final int i3) {
        Composer composerK = composer.k(-1234166869);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1234166869, i3, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileLockIcon (ProfileItem.kt:824)");
            }
            float f3 = 16;
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A3, composerK, 6), null, SizeKt.v(PaddingKt.m(Modifier.b8, 0.0f, Dp.g(f3), Dp.g(f3), 0.0f, 9, null), Dp.g(24)), null, null, 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composerK, 0).q(), 0, 2, null), composerK, 432, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.k1(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(MutableState mutableState, MutableIntState mutableIntState, TextLayoutResult textLayoutResult) {
        Intrinsics.checkNotNullParameter(textLayoutResult, "textLayoutResult");
        int iN = textLayoutResult.n();
        if (!f0(mutableState) && h0(mutableIntState) != iN) {
            i0(mutableIntState, iN);
            g0(mutableState, true);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(int i3, Composer composer, int i4) {
        j1(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(ProfileViewDTO profileViewDTO, long j3, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        e0(profileViewDTO, j3, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l1(final androidx.compose.foundation.layout.ColumnScope r23, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r24, boolean r25, boolean r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.l1(androidx.compose.foundation.layout.ColumnScope, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void m0(final androidx.compose.foundation.layout.ColumnScope r30, java.lang.Integer r31, final java.lang.String r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 423
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.m0(androidx.compose.foundation.layout.ColumnScope, java.lang.Integer, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(ColumnScope columnScope, ProfileViewDTO profileViewDTO, boolean z2, boolean z3, int i3, int i4, Composer composer, int i5) {
        l1(columnScope, profileViewDTO, z2, z3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(ColumnScope columnScope, Integer num, String str, int i3, int i4, Composer composer, int i5) {
        m0(columnScope, num, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void n1(final androidx.compose.foundation.layout.BoxScope r25, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r26, boolean r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 444
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.n1(androidx.compose.foundation.layout.BoxScope, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void o0(final ScaffoldState scaffoldState, final ProfileViewDTO profileViewDTO, final boolean z2, final Function1 function1, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(442176);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(profileViewDTO) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(442176, i5, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.MoreButton (ProfileItem.kt:841)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.L3, composerK, 6);
            long jQ = ComposeColorsKt.j(composerK, 0).q();
            Modifier modifierM = PaddingKt.m(companion2, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.h0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.p0(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.q0(modifierM, imageVectorB, null, false, 0.0f, 0.0f, jQ, null, (Function0) objG2, composerK, 100663302, 188);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState2 = (MutableState) objG3;
            ActivateNowTimePickerKt.c(mutableState2, profileViewDTO.k(), function1, composerK, ((i5 >> 3) & 896) | 6);
            int i6 = i5 & 7168;
            int i7 = i5 & 112;
            boolean z3 = (i6 == 2048) | (i7 == 32);
            Object objG4 = composerK.G();
            if (z3 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.i0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.q0(function1, profileViewDTO);
                    }
                };
                composerK.w(objG4);
            }
            Function0 function0 = (Function0) objG4;
            boolean z4 = (i6 == 2048) | (i7 == 32);
            Object objG5 = composerK.G();
            if (z4 || objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.k0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.r0(function1, profileViewDTO);
                    }
                };
                composerK.w(objG5);
            }
            Function0 function02 = (Function0) objG5;
            boolean z5 = (i6 == 2048) | (i7 == 32);
            Object objG6 = composerK.G();
            if (z5 || objG6 == companion.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.l0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.s0(function1, profileViewDTO);
                    }
                };
                composerK.w(objG6);
            }
            Function0 function03 = (Function0) objG6;
            boolean z6 = (i7 == 32) | (i6 == 2048);
            Object objG7 = composerK.G();
            if (z6 || objG7 == companion.a()) {
                objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.m0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.t0(function1, profileViewDTO);
                    }
                };
                composerK.w(objG7);
            }
            Function0 function04 = (Function0) objG7;
            boolean z7 = i6 == 2048;
            Object objG8 = composerK.G();
            if (z7 || objG8 == companion.a()) {
                objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.n0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileItemKt.u0(function1, (ProfileViewDTO) obj);
                    }
                };
                composerK.w(objG8);
            }
            Function1 function12 = (Function1) objG8;
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.v0(mutableState2);
                    }
                };
                composerK.w(objG9);
            }
            Function0 function05 = (Function0) objG9;
            boolean zI = composerK.I(context) | (i7 == 32);
            Object objG10 = composerK.G();
            if (zI || objG10 == companion.a()) {
                objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.p0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.w0(context, profileViewDTO);
                    }
                };
                composerK.w(objG10);
            }
            int i8 = i5 << 3;
            composer2 = composerK;
            y0(mutableState, scaffoldState, profileViewDTO, z2, function0, function02, function03, function04, function12, function05, (Function0) objG10, composer2, (i8 & 7168) | (i8 & 112) | 805306374 | (i8 & 896), 0, 0);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.x0(scaffoldState, profileViewDTO, z2, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(int i3, int i4, ProfileViewDTO profileViewDTO, Composer composer, int i5) {
        if (composer.r((i5 & 3) != 2, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(446754469, i5, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.ProfileStateContent.<anonymous>.<anonymous> (ProfileItem.kt:402)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierC = SizeKt.C(companion, 0.0f, Dp.g(i3), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierC);
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
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, i4, composer, 6), null, SizeKt.v(companion, Dp.g(32)), null, null, 0.0f, null, composer, 432, 120);
            TextKt.c(StringResources_androidKt.b(profileViewDTO.n() ? R.string.A8 : R.string.f95863z, composer, 0), PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(12), 0.0f, 11, null), ComposeColorsKt.j(composer, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 3120, 55288);
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
    public static final Unit p0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(BoxScope boxScope, ProfileViewDTO profileViewDTO, boolean z2, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        n1(boxScope, profileViewDTO, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new ProfileItemEvent.OnProfileStoppedManually(profileViewDTO));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void q1(final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r37, boolean r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.q1(cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r0(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new ProfileItemEvent.OnProfileDuplicate(profileViewDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier r1(Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return PaddingKt.j(applyIf, Dp.g(16), Dp.g(4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new ProfileItemEvent.OnProfileResumed(profileViewDTO.k()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(ProfileViewDTO profileViewDTO, boolean z2, int i3, int i4, Composer composer, int i5) {
        q1(profileViewDTO, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new ProfileItemEvent.OnProfilePauseSelected(profileViewDTO.k()));
        return Unit.f139807a;
    }

    public static final void t1(final ScaffoldState scaffoldState, final ProfileViewDTO profile, final boolean z2, final Function1 onEvent, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(-1822346389);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(scaffoldState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(profile) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onEvent) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1822346389, i4, -1, "cz.mobilesoft.coreblock.view.compose.profileitem.SchedulePreviewMoreButton (ProfileItem.kt:793)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            int i5 = R.drawable.L3;
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            float fG = Dp.g(40);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.u1(mutableState);
                    }
                };
                composerK.w(objG2);
            }
            Function0 function0 = (Function0) objG2;
            int i6 = i4;
            FlatButtonsKt.K(null, fG, i5, secondary, null, function0, composerK, 224304, 1);
            int i7 = i6 & 7168;
            int i8 = i6 & 112;
            boolean z3 = (i8 == 32) | (i7 == 2048);
            Object objG3 = composerK.G();
            if (z3 || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.y
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.v1(onEvent, profile);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function02 = (Function0) objG3;
            boolean z4 = (i8 == 32) | (i7 == 2048);
            Object objG4 = composerK.G();
            if (z4 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.j0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.w1(onEvent, profile);
                    }
                };
                composerK.w(objG4);
            }
            Function0 function03 = (Function0) objG4;
            boolean z5 = i7 == 2048;
            Object objG5 = composerK.G();
            if (z5 || objG5 == companion.a()) {
                objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.u0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.x1(onEvent);
                    }
                };
                composerK.w(objG5);
            }
            Function0 function04 = (Function0) objG5;
            boolean z6 = (i8 == 32) | (i7 == 2048);
            Object objG6 = composerK.G();
            if (z6 || objG6 == companion.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.b1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProfileItemKt.y1(onEvent, profile);
                    }
                };
                composerK.w(objG6);
            }
            Function0 function05 = (Function0) objG6;
            boolean z7 = i7 == 2048;
            Object objG7 = composerK.G();
            if (z7 || objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.c1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProfileItemKt.z1(onEvent, (ProfileViewDTO) obj);
                    }
                };
                composerK.w(objG7);
            }
            int i9 = i6 << 3;
            y0(mutableState, scaffoldState, profile, z2, function02, function03, function04, function05, (Function1) objG7, null, null, composerK, (i9 & 112) | 6 | (i9 & 896) | (i9 & 7168), 0, 1536);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.profileitem.d1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProfileItemKt.A1(scaffoldState, profile, z2, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(Function1 function1, ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new ProfileItemEvent.OnProfileDeleted(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v1(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new SchedulePreviewViewEvent.OnProfileStoppedManually(profileViewDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w0(Context context, ProfileViewDTO profileViewDTO) {
        D1(context, profileViewDTO);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new SchedulePreviewViewEvent.OnProfileDuplicate(profileViewDTO));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x0(ScaffoldState scaffoldState, ProfileViewDTO profileViewDTO, boolean z2, Function1 function1, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        o0(scaffoldState, profileViewDTO, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(Function1 function1) {
        function1.invoke(SchedulePreviewViewEvent.OnProfileResumed.f117403a);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:264:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x056d  */
    /* JADX WARN: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void y0(final androidx.compose.runtime.MutableState r40, androidx.compose.material.ScaffoldState r41, final cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO r42, final boolean r43, final kotlin.jvm.functions.Function0 r44, final kotlin.jvm.functions.Function0 r45, final kotlin.jvm.functions.Function0 r46, final kotlin.jvm.functions.Function0 r47, kotlin.jvm.functions.Function1 r48, kotlin.jvm.functions.Function0 r49, kotlin.jvm.functions.Function0 r50, androidx.compose.runtime.Composer r51, final int r52, final int r53, final int r54) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.y0(androidx.compose.runtime.MutableState, androidx.compose.material.ScaffoldState, cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(Function1 function1, ProfileViewDTO profileViewDTO) {
        function1.invoke(new SchedulePreviewViewEvent.OnProfilePauseSelected(profileViewDTO.k()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(MutableState mutableState, Function0 function0) {
        mutableState.setValue(Boolean.FALSE);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(Function1 function1, ProfileViewDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new SchedulePreviewViewEvent.OnProfileDeleted(it));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void B1(androidx.compose.foundation.layout.ColumnScope r43, java.lang.String r44, java.lang.String r45, long r46, androidx.compose.runtime.Composer r48, final int r49, final int r50) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt.B1(androidx.compose.foundation.layout.ColumnScope, java.lang.String, java.lang.String, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
