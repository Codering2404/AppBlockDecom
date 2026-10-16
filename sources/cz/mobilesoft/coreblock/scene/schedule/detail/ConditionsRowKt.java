package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class ConditionsRowKt {
    /* JADX WARN: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(final java.lang.String r16, final java.lang.String r17, final java.lang.String r18, kotlinx.collections.immutable.ImmutableList r19, final int r20, final int r21, final boolean r22, final kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ConditionsRowKt.i(java.lang.String, java.lang.String, java.lang.String, kotlinx.collections.immutable.ImmutableList, int, int, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(boolean z2, int i3, int i4, String str, String str2, ImmutableList immutableList, String str3, ColumnScope BaseCard, Composer composer, int i5) {
        long jP;
        long jP2;
        long jP3;
        long jQ;
        long jP4;
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i5 & 17) != 16, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1439898901, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConditionCard.<anonymous> (ConditionsRow.kt:183)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ImageKt.a(PainterResources_androidKt.c(z2 ? i3 : i4, composer, 0), null, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), null, null, 0.0f, null, composer, 432, 120);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(4)), companion2.k(), composer, 6);
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
            TextStyle textStyleH = ComposeTypographyKt.g(composer, 0).h();
            if (z2) {
                composer.a0(-754049028);
                jP = ComposeColorsKt.j(composer, 0).q();
            } else {
                composer.a0(-754048197);
                jP = ComposeColorsKt.j(composer, 0).p();
            }
            composer.U();
            TextKt.c(str, null, jP, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, textStyleH, composer, 0, 3072, 57338);
            Composer composer2 = composer;
            if (str2 == null) {
                composer2.a0(-1900548785);
            } else {
                composer2.a0(-1900548784);
                TextStyle textStyleB = ComposeTypographyKt.g(composer2, 0).b();
                if (z2) {
                    composer2.a0(-1540236578);
                    jP2 = ComposeColorsKt.j(composer2, 0).q();
                } else {
                    composer2.a0(-1540235747);
                    jP2 = ComposeColorsKt.j(composer2, 0).p();
                }
                composer2.U();
                TextKt.c(str2, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), jP2, 0L, null, null, null, 0L, null, null, 0L, 0, false, 2, 0, null, textStyleB, composer, 48, 3072, 57336);
                composer2 = composer;
                Unit unit = Unit.f139807a;
            }
            composer2.U();
            if (immutableList.isEmpty()) {
                composer2.a0(-1899544229);
                TextStyle textStyleB2 = ComposeTypographyKt.g(composer2, 0).b();
                if (z2) {
                    composer2.a0(-754007108);
                    jP3 = ComposeColorsKt.j(composer2, 0).q();
                } else {
                    composer2.a0(-754006277);
                    jP3 = ComposeColorsKt.j(composer2, 0).p();
                }
                composer2.U();
                TextKt.c(str3, PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), jP3, 0L, null, null, null, 0L, null, null, 0L, 0, false, 2, 0, null, textStyleB2, composer, 48, 3072, 57336);
                composer2 = composer;
                composer2.U();
            } else {
                composer2.a0(-1900109297);
                Iterator<E> it = immutableList.iterator();
                while (it.hasNext()) {
                    String str4 = (String) it.next();
                    TextStyle textStyleB3 = ComposeTypographyKt.g(composer2, 0).b();
                    if (z2) {
                        composer2.a0(850821607);
                        jP4 = ComposeColorsKt.j(composer2, 0).q();
                    } else {
                        composer2.a0(850822438);
                        jP4 = ComposeColorsKt.j(composer2, 0).p();
                    }
                    composer2.U();
                    TextKt.c(str4, PaddingKt.m(Modifier.b8, 0.0f, 0.0f, Dp.g(f3), 0.0f, 11, null), jP4, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.f29661b.b(), false, 1, 0, null, textStyleB3, composer, 48, 3120, 55288);
                    composer2 = composer;
                }
                composer2.U();
            }
            composer2.y();
            Painter painterC = PainterResources_androidKt.c(R.drawable.f95580y1, composer2, 0);
            if (z2) {
                composer2.a0(-1695009881);
                jQ = ComposeColorsKt.j(composer2, 0).m();
            } else {
                composer2.a0(-1695009018);
                jQ = ComposeColorsKt.j(composer2, 0).q();
            }
            composer2.U();
            IconKt.c(painterC, null, null, jQ, composer2, 48, 4);
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
    public static final Unit k(String str, String str2, String str3, ImmutableList immutableList, int i3, int i4, boolean z2, Function0 function0, int i5, int i6, Composer composer, int i7) {
        i(str, str2, str3, immutableList, i3, i4, z2, function0, composer, RecomposeScopeImplKt.a(i5 | 1), i6);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x0366  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void l(final cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState.DetailViewState r36, final boolean r37, androidx.compose.ui.Modifier r38, final kotlin.jvm.functions.Function1 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 893
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ConditionsRowKt.l(cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState$DetailViewState, boolean, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(ScheduleViewEvent.OnConditionSelectClicked.f114556a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ScheduleViewState.DetailViewState.ConditionCardContent conditionCardContent, Function1 function1) {
        conditionCardContent.c();
        function1.invoke(new ScheduleViewEvent.OnConditionSelected(conditionCardContent.d()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ScheduleViewState.DetailViewState detailViewState, boolean z2, Modifier modifier, Function1 function1, int i3, int i4, Composer composer, int i5) {
        l(detailViewState, z2, modifier, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(androidx.compose.ui.Modifier r59, final java.lang.String r60, final int r61, boolean r62, kotlin.jvm.functions.Function0 r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instruction units count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ConditionsRowKt.q(androidx.compose.ui.Modifier, java.lang.String, int, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Modifier modifier, ProfileType profileType, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        p(modifier, profileType, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(Modifier modifier, String str, int i3, boolean z2, Function0 function0, int i4, int i5, Composer composer, int i6) {
        q(modifier, str, i3, z2, function0, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p(androidx.compose.ui.Modifier r14, cz.mobilesoft.coreblock.enums.ProfileType r15, boolean r16, final kotlin.jvm.functions.Function0 r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ConditionsRowKt.p(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.enums.ProfileType, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
