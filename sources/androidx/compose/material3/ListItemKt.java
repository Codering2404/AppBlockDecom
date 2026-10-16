package androidx.compose.material3;

import androidx.compose.material3.ListItemType;
import androidx.compose.material3.internal.ProvideContentColorTextStyleKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
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
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ListItemKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f18046a = Dp.g(8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18047b = Dp.g(12);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f18049d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f18050e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f18051f;

    static {
        float f3 = 16;
        f18048c = Dp.g(f3);
        f18049d = Dp.g(f3);
        f18050e = Dp.g(f3);
        f18051f = Dp.g(f3);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:165:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function2 r36, androidx.compose.ui.Modifier r37, kotlin.jvm.functions.Function2 r38, kotlin.jvm.functions.Function2 r39, kotlin.jvm.functions.Function2 r40, kotlin.jvm.functions.Function2 r41, androidx.compose.material3.ListItemColors r42, float r43, float r44, androidx.compose.runtime.Composer r45, final int r46, final int r47) {
        /*
            Method dump skipped, instruction units count: 713
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ListItemKt.a(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.ListItemColors, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(2052297037);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function22) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function23) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function24) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function25) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2052297037, i4, -1, "androidx.compose.material3.ListItemLayout (ListItem.kt:180)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new ListItemMeasurePolicy();
                composerK.w(objG);
            }
            ListItemMeasurePolicy listItemMeasurePolicy = (ListItemMeasurePolicy) objG;
            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function23, function24 == null ? ComposableSingletons$ListItemKt.f16729a.a() : function24, function25 == null ? ComposableSingletons$ListItemKt.f16729a.b() : function25, function2 == null ? ComposableSingletons$ListItemKt.f16729a.c() : function2, function22 == null ? ComposableSingletons$ListItemKt.f16729a.d() : function22});
            Modifier.Companion companion2 = Modifier.b8;
            Function2 function2B = LayoutKt.b(listListOf);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = MultiContentMeasurePolicyKt.a(listItemMeasurePolicy);
                composerK.w(objG2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG2;
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
            Updater.e(composerA, measurePolicy, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B2);
            }
            Updater.e(composerA, modifierF, companion3.f());
            function2B.invoke(composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ListItemLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ListItemKt.b(function2, function22, function23, function24, function25, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(long j3, final TypographyKeyTokens typographyKeyTokens, Function2 function2, Composer composer, final int i3) {
        int i4;
        long j4;
        final Function2 function22;
        Composer composerK = composer.k(1133967795);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(typographyKeyTokens) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            j4 = j3;
            function22 = function2;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1133967795, i4, -1, "androidx.compose.material3.ProvideTextStyleFromToken (ListItem.kt:657)");
            }
            j4 = j3;
            ProvideContentColorTextStyleKt.a(j4, TypographyKt.c(typographyKeyTokens, composerK, (i4 >> 3) & 14), function2, composerK, i4 & 910);
            function22 = function2;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final long j5 = j4;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ListItemKt$ProvideTextStyleFromToken$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ListItemKt.c(j5, typographyKeyTokens, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(IntrinsicMeasureScope intrinsicMeasureScope, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j3) {
        ListItemType.Companion companion = ListItemType.f18104b;
        return RangesKt.k(Math.max(Math.max(Constraints.m(j3), intrinsicMeasureScope.z0(ListItemType.h(i8, companion.a()) ? ListTokens.f22906a.n() : ListItemType.h(i8, companion.c()) ? ListTokens.f22906a.w() : ListTokens.f22906a.s())), i9 + Math.max(i3, Math.max(i5 + i6 + i7, i4))), Constraints.k(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(IntrinsicMeasureScope intrinsicMeasureScope, int i3, int i4, int i5, int i6, int i7, int i8, long j3) {
        if (Constraints.h(j3)) {
            return Constraints.l(j3);
        }
        return i8 + i3 + Math.max(i5, Math.max(i6, i7)) + i4;
    }

    public static final float n() {
        return f18050e;
    }

    public static final float o() {
        return f18049d;
    }

    public static final float p() {
        return f18048c;
    }

    public static final float q() {
        return f18051f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean r(Density density, int i3) {
        return i3 > density.T1(TextUnitKt.i(30));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult s(MeasureScope measureScope, final int i3, final int i4, final Placeable placeable, final Placeable placeable2, final Placeable placeable3, final Placeable placeable4, final Placeable placeable5, final boolean z2, final int i5, final int i6, final int i7) {
        return MeasureScope.B0(measureScope, i3, i4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ListItemKt$place$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope placementScope2;
                int iA;
                Placeable placeable6 = placeable;
                if (placeable6 != null) {
                    int i8 = i5;
                    boolean z3 = z2;
                    int iA2 = i7;
                    int i9 = i4;
                    if (!z3) {
                        iA2 = Alignment.f25072a.i().a(placeable6.O0(), i9);
                    }
                    Placeable.PlacementScope.m(placementScope, placeable6, i8, iA2, 0.0f, 4, null);
                    placementScope2 = placementScope;
                } else {
                    placementScope2 = placementScope;
                }
                Placeable placeable7 = placeable2;
                if (placeable7 != null) {
                    int i10 = i3;
                    int i11 = i6;
                    boolean z4 = z2;
                    int iA3 = i7;
                    int i12 = i4;
                    int iX0 = (i10 - i11) - placeable7.X0();
                    if (!z4) {
                        iA3 = Alignment.f25072a.i().a(placeable7.O0(), i12);
                    }
                    Placeable.PlacementScope.m(placementScope2, placeable7, iX0, iA3, 0.0f, 4, null);
                }
                int iV = i5 + TextFieldImplKt.v(placeable);
                if (z2) {
                    iA = i7;
                } else {
                    iA = Alignment.f25072a.i().a(TextFieldImplKt.t(placeable3) + TextFieldImplKt.t(placeable4) + TextFieldImplKt.t(placeable5), i4);
                }
                int i13 = iA;
                Placeable placeable8 = placeable4;
                if (placeable8 != null) {
                    Placeable.PlacementScope.m(placementScope2, placeable8, iV, i13, 0.0f, 4, null);
                }
                int iT = i13 + TextFieldImplKt.t(placeable4);
                Placeable placeable9 = placeable3;
                if (placeable9 != null) {
                    Placeable.PlacementScope.m(placementScope2, placeable9, iV, iT, 0.0f, 4, null);
                }
                int iT2 = iT + TextFieldImplKt.t(placeable3);
                Placeable placeable10 = placeable5;
                if (placeable10 != null) {
                    Placeable.PlacementScope.m(placementScope2, placeable10, iV, iT2, 0.0f, 4, null);
                }
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(int i3, int i4) {
        return i3 == Integer.MAX_VALUE ? i3 : i3 - i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float u(int i3) {
        return ListItemType.h(i3, ListItemType.f18104b.b()) ? f18047b : f18046a;
    }
}
