package androidx.compose.material;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
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
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class AlertDialogKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Modifier f11607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Modifier f11608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f11609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f11610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f11611e;

    static {
        Modifier.Companion companion = Modifier.b8;
        float f3 = 24;
        f11607a = PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null);
        f11608b = PaddingKt.m(companion, Dp.g(f3), 0.0f, Dp.g(f3), Dp.g(28), 2, null);
        f11609c = TextUnitKt.i(40);
        f11610d = TextUnitKt.i(36);
        f11611e = TextUnitKt.i(38);
    }

    public static final void a(final ColumnScope columnScope, final Function2 function2, final Function2 function22, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-555573207);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(columnScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function22) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-555573207, i4, -1, "androidx.compose.material.AlertDialogBaselineLayout (AlertDialog.kt:97)");
            }
            Modifier modifierA = columnScope.a(Modifier.b8, 1.0f, false);
            AlertDialogKt$AlertDialogBaselineLayout$2 alertDialogKt$AlertDialogBaselineLayout$2 = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2
                /* JADX WARN: Removed duplicated region for block: B:39:0x00ab  */
                /* JADX WARN: Removed duplicated region for block: B:47:0x00c5  */
                /* JADX WARN: Removed duplicated region for block: B:56:0x00e7  */
                @Override // androidx.compose.ui.layout.MeasurePolicy
                /* JADX INFO: renamed from: measure-3p2s80s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final androidx.compose.ui.layout.MeasureResult mo10measure3p2s80s(androidx.compose.ui.layout.MeasureScope r20, java.util.List r21, long r22) {
                    /*
                        Method dump skipped, instruction units count: 318
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$2.mo10measure3p2s80s(androidx.compose.ui.layout.MeasureScope, java.util.List, long):androidx.compose.ui.layout.MeasureResult");
                }
            };
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
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
            Updater.e(composerA, alertDialogKt$AlertDialogBaselineLayout$2, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            if (function2 == null) {
                composerK.a0(1310700478);
            } else {
                composerK.a0(1310700479);
                Modifier modifierB = LayoutIdKt.b(f11607a, "title");
                Alignment.Companion companion2 = Alignment.f25072a;
                Modifier modifierC = columnScope.c(modifierB, companion2.k());
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierC);
                Function0 function0A2 = companion.a();
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
                Updater.e(composerA2, measurePolicyG, companion.e());
                Updater.e(composerA2, compositionLocalMapU2, companion.g());
                Function2 function2B2 = companion.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                function2.invoke(composerK, 0);
                composerK.y();
            }
            composerK.U();
            if (function22 == null) {
                composerK.a0(1310868994);
            } else {
                composerK.a0(1310868995);
                Modifier modifierB2 = LayoutIdKt.b(f11608b, "text");
                Alignment.Companion companion3 = Alignment.f25072a;
                Modifier modifierC2 = columnScope.c(modifierB2, companion3.k());
                MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC2);
                Function0 function0A3 = companion.a();
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
                Updater.e(composerA3, measurePolicyG2, companion.e());
                Updater.e(composerA3, compositionLocalMapU3, companion.g());
                Function2 function2B3 = companion.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion.f());
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
                function22.invoke(composerK, 0);
                composerK.y();
            }
            composerK.U();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogBaselineLayout$3
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
                    AlertDialogKt.a(columnScope, function2, function22, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:130:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.jvm.functions.Function2 r23, androidx.compose.ui.Modifier r24, kotlin.jvm.functions.Function2 r25, kotlin.jvm.functions.Function2 r26, androidx.compose.ui.graphics.Shape r27, long r28, long r30, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 447
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.b(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void c(final float f3, final float f4, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(73434452);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.c(f4) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(73434452, i4, -1, "androidx.compose.material.AlertDialogFlowRow (AlertDialog.kt:193)");
            }
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1
                    private static final boolean a(List list, Ref.IntRef intRef, MeasureScope measureScope, float f5, long j3, Placeable placeable) {
                        return list.isEmpty() || (intRef.f140142a + measureScope.z0(f5)) + placeable.X0() <= Constraints.l(j3);
                    }

                    private static final void b(List list, Ref.IntRef intRef, MeasureScope measureScope, float f5, List list2, List list3, Ref.IntRef intRef2, List list4, Ref.IntRef intRef3, Ref.IntRef intRef4) {
                        if (!list.isEmpty()) {
                            intRef.f140142a += measureScope.z0(f5);
                        }
                        list.add(0, CollectionsKt.toList(list2));
                        list3.add(Integer.valueOf(intRef2.f140142a));
                        list4.add(Integer.valueOf(intRef.f140142a));
                        intRef.f140142a += intRef2.f140142a;
                        intRef3.f140142a = Math.max(intRef3.f140142a, intRef4.f140142a);
                        list2.clear();
                        intRef4.f140142a = 0;
                        intRef2.f140142a = 0;
                    }

                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, List list, long j3) {
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        final ArrayList arrayList3 = new ArrayList();
                        Ref.IntRef intRef = new Ref.IntRef();
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        ArrayList arrayList4 = new ArrayList();
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        Ref.IntRef intRef4 = new Ref.IntRef();
                        int i5 = 0;
                        long jB = ConstraintsKt.b(0, Constraints.l(j3), 0, 0, 13, null);
                        float f5 = f3;
                        float f6 = f4;
                        int size = list.size();
                        while (i5 < size) {
                            ArrayList arrayList5 = arrayList;
                            Placeable placeableN0 = ((Measurable) list.get(i5)).n0(jB);
                            long j4 = jB;
                            float f7 = f6;
                            int i6 = size;
                            int i7 = i5;
                            Ref.IntRef intRef5 = intRef3;
                            intRef3 = intRef5;
                            if (a(arrayList4, intRef5, measureScope, f5, j3, placeableN0)) {
                                arrayList = arrayList5;
                            } else {
                                arrayList = arrayList5;
                                b(arrayList, intRef2, measureScope, f7, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                            }
                            if (!arrayList4.isEmpty()) {
                                intRef3.f140142a += measureScope.z0(f5);
                            }
                            arrayList4.add(placeableN0);
                            intRef3.f140142a += placeableN0.X0();
                            intRef4.f140142a = Math.max(intRef4.f140142a, placeableN0.O0());
                            i5 = i7 + 1;
                            f6 = f7;
                            jB = j4;
                            size = i6;
                        }
                        if (!arrayList4.isEmpty()) {
                            b(arrayList, intRef2, measureScope, f4, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                        }
                        final int iL = Constraints.l(j3) != Integer.MAX_VALUE ? Constraints.l(j3) : Math.max(intRef.f140142a, Constraints.n(j3));
                        int iMax = Math.max(intRef2.f140142a, Constraints.m(j3));
                        final float f8 = f3;
                        final ArrayList arrayList6 = arrayList;
                        return MeasureScope.B0(measureScope, iL, iMax, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$1$1.2
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
                                List list2 = arrayList6;
                                MeasureScope measureScope2 = measureScope;
                                float f9 = f8;
                                int i8 = iL;
                                List list3 = arrayList3;
                                int size2 = list2.size();
                                for (int i9 = 0; i9 < size2; i9++) {
                                    List list4 = (List) list2.get(i9);
                                    int size3 = list4.size();
                                    int[] iArr = new int[size3];
                                    int i10 = 0;
                                    while (i10 < size3) {
                                        iArr[i10] = ((Placeable) list4.get(i10)).X0() + (i10 < CollectionsKt.getLastIndex(list4) ? measureScope2.z0(f9) : 0);
                                        i10++;
                                    }
                                    Arrangement.Vertical verticalA = Arrangement.f6574a.a();
                                    int[] iArr2 = new int[size3];
                                    for (int i11 = 0; i11 < size3; i11++) {
                                        iArr2[i11] = 0;
                                    }
                                    verticalA.b(measureScope2, i8, iArr, iArr2);
                                    int size4 = list4.size();
                                    for (int i12 = 0; i12 < size4; i12++) {
                                        Placeable.PlacementScope.i(placementScope, (Placeable) list4.get(i12), iArr2[i12], ((Number) list3.get(i9)).intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG;
            int i5 = (i4 >> 6) & 14;
            Modifier.Companion companion = Modifier.b8;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            int i6 = ((i5 << 6) & 896) | 6;
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            function2.invoke(composerK, Integer.valueOf((i6 >> 6) & 14));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AlertDialogKt$AlertDialogFlowRow$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    AlertDialogKt.c(f3, f4, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
