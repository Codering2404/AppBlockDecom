package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class IconClusterKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f130479a;

        static {
            int[] iArr = new int[Profile.BlockingMode.values().length];
            try {
                iArr[Profile.BlockingMode.Allowlist.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Profile.BlockingMode.Blocklist.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f130479a = iArr;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(final java.lang.Object r22, boolean r23, boolean r24, boolean r25, androidx.compose.ui.Modifier r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 639
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.IconClusterKt.g(java.lang.Object, boolean, boolean, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Object obj, boolean z2, boolean z3, boolean z4, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        g(obj, z2, z3, z4, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void i(final RowScope rowScope, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(rowScope, "rowScope");
        Composer composerK = composer.k(235274259);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(rowScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(235274259, i4, -1, "cz.mobilesoft.coreblock.view.compose.DotDivider (IconCluster.kt:309)");
            }
            composer2 = composerK;
            androidx.compose.material.TextKt.c("•", rowScope.d(PaddingKt.k(Modifier.b8, Dp.g(2), 0.0f, 2, null), Alignment.f25072a.i()), ComposeColorsKt.j(composerK, 0).u(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).d(), 0L, TextUnitKt.i(10), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composer2, 6, 0, 65016);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.a9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IconClusterKt.j(rowScope, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(RowScope rowScope, int i3, Composer composer, int i4) {
        i(rowScope, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:161:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0130  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(androidx.compose.ui.Modifier r27, final kotlinx.collections.immutable.ImmutableList r28, final kotlinx.collections.immutable.ImmutableList r29, java.util.List r30, final java.util.List r31, boolean r32, boolean r33, final cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile.BlockingMode r34, boolean r35, boolean r36, boolean r37, boolean r38, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.IconClusterKt.k(androidx.compose.ui.Modifier, kotlinx.collections.immutable.ImmutableList, kotlinx.collections.immutable.ImmutableList, java.util.List, java.util.List, boolean, boolean, cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile$BlockingMode, boolean, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, ImmutableList immutableList, ImmutableList immutableList2, List list, List list2, boolean z2, boolean z3, Profile.BlockingMode blockingMode, boolean z4, boolean z5, boolean z6, boolean z7, int i3, int i4, int i5, Composer composer, int i6) {
        k(modifier, immutableList, immutableList2, list, list2, z2, z3, blockingMode, z4, z5, z6, z7, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(final androidx.compose.ui.graphics.painter.Painter r37, java.lang.Integer r38, long r39, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 494
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.IconClusterKt.m(androidx.compose.ui.graphics.painter.Painter, java.lang.Integer, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Painter painter, Integer num, long j3, int i3, int i4, Composer composer, int i5) {
        m(painter, num, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void o(Modifier modifier, final int i3, final List list, final List list2, final boolean z2, final boolean z3, final Profile.BlockingMode blockingMode, final boolean z4, final boolean z5, final boolean z6, final boolean z7, Composer composer, final int i4, final int i5, final int i6) {
        int i7;
        Composer composer2;
        final Modifier modifier2;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Painter painterC;
        Composer composer3;
        int i8;
        Composer composerK = composer.k(-1529845429);
        int iA = composerK.a();
        int i9 = i6 & 1;
        if (i9 != 0) {
            i7 = i4 | 6;
        } else if ((i4 & 6) == 0) {
            i7 = i4 | (composerK.Z(modifier) ? 4 : 2);
        } else {
            i7 = i4;
        }
        if ((i4 & 48) == 0) {
            i7 |= composerK.e(i3) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i7 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i7 |= composerK.I(list2) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i7 |= composerK.b(z2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i7 |= composerK.b(z3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i7 |= composerK.e(blockingMode.ordinal()) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i7 |= composerK.b(z4) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            i7 |= composerK.b(z5) ? 67108864 : 33554432;
        }
        if ((805306368 & i4) == 0) {
            i7 |= composerK.b(z6) ? 536870912 : 268435456;
        }
        int i10 = i7;
        int i11 = (i5 & 6) == 0 ? i5 | (composerK.b(z7) ? 4 : 2) : i5;
        if (composerK.r(((i10 & 306783379) == 306783378 && (i11 & 3) == 2) ? false : true, i10 & 1)) {
            Modifier modifier3 = i9 != 0 ? Modifier.b8 : modifier;
            if (ComposerKt.M()) {
                ComposerKt.U(-1529845429, i10, i11, "cz.mobilesoft.coreblock.view.compose.RootCompose (IconCluster.kt:143)");
            }
            int size = i3 + list.size() + list2.size();
            List list3 = list;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list3) {
                int i12 = i10;
                int i13 = size;
                if (((WebsiteDTO) obj).c() == WebsiteProfileRelation.BlockingType.KEYWORD) {
                    arrayList.add(obj);
                }
                size = i13;
                i10 = i12;
            }
            int i14 = i10;
            int i15 = size;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                Iterator it2 = it;
                if (((WebsiteDTO) next).c() == WebsiteProfileRelation.BlockingType.DOMAIN) {
                    arrayList2.add(next);
                }
                it = it2;
            }
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifier3);
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
            final Modifier modifier4 = modifier3;
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA2))) {
                composerA.w(Integer.valueOf(iA2));
                composerA.p(Integer.valueOf(iA2), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            composerK.a0(-77404173);
            if (i15 == 0 && !z4 && !z5 && !z6 && !z7) {
                composerK.a0(-77362169);
                int i16 = WhenMappings.f130479a[blockingMode.ordinal()];
                if (i16 == 1) {
                    composer3 = composerK;
                    i8 = iA;
                    composer3.a0(-77300696);
                    m(PainterResources_androidKt.c(R.drawable.U0, composer3, 0), 0, 0L, composer3, 48, 4);
                    composer3.U();
                    Unit unit = Unit.f139807a;
                } else {
                    if (i16 != 2) {
                        composerK.a0(967336176);
                        composerK.U();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerK.a0(-77038684);
                    if (z2) {
                        composerK.a0(-77006537);
                        i8 = iA;
                        m(PainterResources_androidKt.c(R.drawable.X0, composerK, 0), 0, ComposeColorsKt.j(composerK, 0).k(), composerK, 48, 0);
                        composer3 = composerK;
                        composer3.U();
                    } else {
                        composer3 = composerK;
                        i8 = iA;
                        if (z3) {
                            composer3.a0(-76702892);
                            m(PainterResources_androidKt.c(R.drawable.X0, composer3, 0), 0, 0L, composer3, 48, 4);
                        } else {
                            composer3.a0(-83102191);
                        }
                        composer3.U();
                    }
                    composer3.U();
                    Unit unit2 = Unit.f139807a;
                }
                composer3.s(i8);
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composer3.n();
                if (scopeUpdateScopeN != null) {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.y8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            return IconClusterKt.p(modifier4, i3, list, list2, z2, z3, blockingMode, z4, z5, z6, z7, i4, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    scopeUpdateScopeN.a(function2);
                }
                return;
            }
            modifier2 = modifier4;
            composerK.a0(-83102191);
            composerK.U();
            Alignment.Vertical verticalI = companion.i();
            Modifier.Companion companion3 = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, companion3);
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
            Updater.e(composerA2, measurePolicyB, companion2.e());
            Updater.e(composerA2, compositionLocalMapU2, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA3))) {
                composerA2.w(Integer.valueOf(iA3));
                composerA2.p(Integer.valueOf(iA3), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            int i17 = WhenMappings.f130479a[blockingMode.ordinal()];
            if (i17 == 1) {
                composerK.a0(619968715);
                painterC = PainterResources_androidKt.c(R.drawable.U0, composerK, 0);
                composerK.U();
            } else {
                if (i17 != 2) {
                    composerK.a0(619966370);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                }
                composerK.a0(619972331);
                painterC = PainterResources_androidKt.c(R.drawable.X0, composerK, 0);
                composerK.U();
            }
            composer2 = composerK;
            m(painterC, null, 0L, composer2, 0, 6);
            if (list2.isEmpty()) {
                composer2.a0(2032289709);
            } else {
                composer2.a0(2039415617);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.Y0, composer2, 0), Integer.valueOf(list2.size()), 0L, composer2, 0, 4);
            }
            composer2.U();
            if (i3 > 0) {
                composer2.a0(2039616590);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.W0, composer2, 0), Integer.valueOf(i3), 0L, composer2, i14 & 112, 4);
            } else {
                composer2.a0(2032289709);
            }
            composer2.U();
            if (arrayList2.isEmpty()) {
                composer2.a0(2032289709);
            } else {
                composer2.a0(2039813905);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.f95503d1, composer2, 0), Integer.valueOf(arrayList2.size()), 0L, composer2, 0, 4);
            }
            composer2.U();
            if (arrayList.isEmpty()) {
                composer2.a0(2032289709);
            } else {
                composer2.a0(2040008461);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.f95491a1, composer2, 0), Integer.valueOf(arrayList.size()), 0L, composer2, 0, 4);
            }
            composer2.U();
            if (z4) {
                composer2.a0(2040195081);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.V0, composer2, 0), null, 0L, composer2, 0, 6);
            } else {
                composer2.a0(2032289709);
            }
            composer2.U();
            if (z5) {
                composer2.a0(2040369177);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.f95499c1, composer2, 0), null, 0L, composer2, 0, 6);
            } else {
                composer2.a0(2032289709);
            }
            composer2.U();
            if (z6) {
                composer2.a0(2040551798);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.T0, composer2, 0), null, 0L, composer2, 0, 6);
            } else {
                composer2.a0(2032289709);
            }
            composer2.U();
            if (z7) {
                composer2.a0(2040738759);
                i(rowScopeInstance, composer2, 6);
                m(PainterResources_androidKt.c(R.drawable.K2, composer2, 0), null, 0L, composer2, 0, 6);
            } else {
                composer2.a0(2032289709);
            }
            composer2.U();
            composer2.y();
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier2 = modifier;
        }
        scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.z8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return IconClusterKt.q(modifier2, i3, list, list2, z2, z3, blockingMode, z4, z5, z6, z7, i4, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, int i3, List list, List list2, boolean z2, boolean z3, Profile.BlockingMode blockingMode, boolean z4, boolean z5, boolean z6, boolean z7, int i4, int i5, int i6, Composer composer, int i7) {
        o(modifier, i3, list, list2, z2, z3, blockingMode, z4, z5, z6, z7, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Modifier modifier, int i3, List list, List list2, boolean z2, boolean z3, Profile.BlockingMode blockingMode, boolean z4, boolean z5, boolean z6, boolean z7, int i4, int i5, int i6, Composer composer, int i7) {
        o(modifier, i3, list, list2, z2, z3, blockingMode, z4, z5, z6, z7, composer, RecomposeScopeImplKt.a(i4 | 1), RecomposeScopeImplKt.a(i5), i6);
        return Unit.f139807a;
    }
}
