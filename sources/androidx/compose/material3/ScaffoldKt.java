package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.FabPosition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final class ScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f19393a = Dp.g(16);

    /* JADX WARN: Removed duplicated region for block: B:100:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r28, kotlin.jvm.functions.Function2 r29, kotlin.jvm.functions.Function2 r30, kotlin.jvm.functions.Function2 r31, kotlin.jvm.functions.Function2 r32, int r33, long r34, long r36, androidx.compose.foundation.layout.WindowInsets r38, final kotlin.jvm.functions.Function3 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ScaffoldKt.a(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, int, long, long, androidx.compose.foundation.layout.WindowInsets, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final int i3, final Function2 function2, final Function3 function3, final Function2 function22, final Function2 function23, final WindowInsets windowInsets, final Function2 function24, Composer composer, final int i4) {
        int i5;
        Function3 function32;
        Function2 function25;
        final WindowInsets windowInsets2;
        int i6;
        Composer composerK = composer.k(-975511942);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            function32 = function3;
            i5 |= composerK.I(function32) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function32 = function3;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function22) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            function25 = function23;
            i5 |= composerK.I(function25) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function25 = function23;
        }
        if ((196608 & i4) == 0) {
            windowInsets2 = windowInsets;
            i5 |= composerK.Z(windowInsets2) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        } else {
            windowInsets2 = windowInsets;
        }
        if ((i4 & 1572864) == 0) {
            i5 |= composerK.I(function24) ? 1048576 : 524288;
        }
        if ((i5 & 599187) == 599186 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-975511942, i5, -1, "androidx.compose.material3.ScaffoldLayout (Scaffold.kt:138)");
            }
            boolean z2 = ((i5 & 112) == 32) | ((i5 & 7168) == 2048) | ((458752 & i5) == 131072) | ((57344 & i5) == 16384) | ((i5 & 14) == 4) | ((3670016 & i5) == 1048576) | ((i5 & 896) == 256);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                final Function3 function33 = function32;
                i6 = 1;
                final Function2 function26 = function25;
                Function2<SubcomposeMeasureScope, Constraints, MeasureResult> function27 = new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        return m176invoke0kLqBqw((SubcomposeMeasureScope) obj, ((Constraints) obj2).r());
                    }

                    /* JADX INFO: renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m176invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j3) {
                        Object obj;
                        Object obj2;
                        Object obj3;
                        int i7;
                        FabPlacement fabPlacement;
                        Object obj4;
                        Integer numValueOf;
                        int iA;
                        int iC;
                        Object obj5;
                        Object obj6;
                        int iZ0;
                        int iZ02;
                        final int iL = Constraints.l(j3);
                        final int iK = Constraints.k(j3);
                        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
                        List listV = subcomposeMeasureScope.V(ScaffoldLayoutContent.TopBar, function2);
                        ArrayList arrayList = new ArrayList(listV.size());
                        int size = listV.size();
                        for (int i8 = 0; i8 < size; i8++) {
                            arrayList.add(((Measurable) listV.get(i8)).n0(jD));
                        }
                        if (arrayList.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList.get(0);
                            int iO0 = ((Placeable) obj).O0();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList);
                            if (1 <= lastIndex) {
                                int i9 = 1;
                                while (true) {
                                    Object obj7 = arrayList.get(i9);
                                    int iO02 = ((Placeable) obj7).O0();
                                    if (iO0 < iO02) {
                                        obj = obj7;
                                        iO0 = iO02;
                                    }
                                    if (i9 == lastIndex) {
                                        break;
                                    }
                                    i9++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        int iO03 = placeable != null ? placeable.O0() : 0;
                        List listV2 = subcomposeMeasureScope.V(ScaffoldLayoutContent.Snackbar, function22);
                        WindowInsets windowInsets3 = windowInsets2;
                        final ArrayList arrayList2 = new ArrayList(listV2.size());
                        int size2 = listV2.size();
                        int i10 = 0;
                        while (i10 < size2) {
                            arrayList2.add(((Measurable) listV2.get(i10)).n0(ConstraintsKt.i(jD, (-windowInsets3.d(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets3.b(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets3.c(subcomposeMeasureScope))));
                            i10++;
                            arrayList = arrayList;
                            listV2 = listV2;
                        }
                        final ArrayList arrayList3 = arrayList;
                        if (arrayList2.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList2.get(0);
                            int iO04 = ((Placeable) obj2).O0();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex2) {
                                Object obj8 = obj2;
                                int i11 = iO04;
                                int i12 = 1;
                                while (true) {
                                    Object obj9 = arrayList2.get(i12);
                                    int iO05 = ((Placeable) obj9).O0();
                                    if (i11 < iO05) {
                                        obj8 = obj9;
                                        i11 = iO05;
                                    }
                                    if (i12 == lastIndex2) {
                                        break;
                                    }
                                    i12++;
                                }
                                obj2 = obj8;
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int iO06 = placeable2 != null ? placeable2.O0() : 0;
                        if (arrayList2.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList2.get(0);
                            int iX0 = ((Placeable) obj3).X0();
                            int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex3) {
                                Object obj10 = obj3;
                                int i13 = iX0;
                                int i14 = 1;
                                while (true) {
                                    Object obj11 = arrayList2.get(i14);
                                    int iX02 = ((Placeable) obj11).X0();
                                    if (i13 < iX02) {
                                        obj10 = obj11;
                                        i13 = iX02;
                                    }
                                    if (i14 == lastIndex3) {
                                        break;
                                    }
                                    i14++;
                                }
                                obj3 = obj10;
                            }
                        }
                        Placeable placeable3 = (Placeable) obj3;
                        int iX03 = placeable3 != null ? placeable3.X0() : 0;
                        List listV3 = subcomposeMeasureScope.V(ScaffoldLayoutContent.Fab, function26);
                        WindowInsets windowInsets4 = windowInsets2;
                        final int i15 = iX03;
                        final ArrayList arrayList4 = new ArrayList(listV3.size());
                        int size3 = listV3.size();
                        int i16 = 0;
                        while (i16 < size3) {
                            int i17 = iO06;
                            List list = listV3;
                            Placeable placeableN0 = ((Measurable) listV3.get(i16)).n0(ConstraintsKt.i(jD, (-windowInsets4.d(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection())) - windowInsets4.b(subcomposeMeasureScope, subcomposeMeasureScope.getLayoutDirection()), -windowInsets4.c(subcomposeMeasureScope)));
                            if (placeableN0.O0() == 0 || placeableN0.X0() == 0) {
                                placeableN0 = null;
                            }
                            if (placeableN0 != null) {
                                arrayList4.add(placeableN0);
                            }
                            i16++;
                            iO06 = i17;
                            listV3 = list;
                        }
                        int i18 = iO06;
                        if (arrayList4.isEmpty()) {
                            i7 = iO03;
                            fabPlacement = null;
                        } else {
                            if (arrayList4.isEmpty()) {
                                obj5 = null;
                            } else {
                                obj5 = arrayList4.get(0);
                                int iX04 = ((Placeable) obj5).X0();
                                int lastIndex4 = CollectionsKt.getLastIndex(arrayList4);
                                if (1 <= lastIndex4) {
                                    Object obj12 = obj5;
                                    int i19 = iX04;
                                    int i20 = 1;
                                    while (true) {
                                        Object obj13 = arrayList4.get(i20);
                                        int iX05 = ((Placeable) obj13).X0();
                                        if (i19 < iX05) {
                                            obj12 = obj13;
                                            i19 = iX05;
                                        }
                                        if (i20 == lastIndex4) {
                                            break;
                                        }
                                        i20++;
                                    }
                                    obj5 = obj12;
                                }
                            }
                            Intrinsics.checkNotNull(obj5);
                            int iX06 = ((Placeable) obj5).X0();
                            if (arrayList4.isEmpty()) {
                                i7 = iO03;
                                obj6 = null;
                            } else {
                                obj6 = arrayList4.get(0);
                                int iO07 = ((Placeable) obj6).O0();
                                int lastIndex5 = CollectionsKt.getLastIndex(arrayList4);
                                if (1 <= lastIndex5) {
                                    Object obj14 = obj6;
                                    int i21 = iO07;
                                    int i22 = 1;
                                    while (true) {
                                        Object obj15 = arrayList4.get(i22);
                                        i7 = iO03;
                                        int iO08 = ((Placeable) obj15).O0();
                                        if (i21 < iO08) {
                                            i21 = iO08;
                                            obj14 = obj15;
                                        }
                                        if (i22 == lastIndex5) {
                                            break;
                                        }
                                        i22++;
                                        iO03 = i7;
                                    }
                                    obj6 = obj14;
                                } else {
                                    i7 = iO03;
                                }
                            }
                            Intrinsics.checkNotNull(obj6);
                            int iO09 = ((Placeable) obj6).O0();
                            int i23 = i3;
                            FabPosition.Companion companion = FabPosition.f17745b;
                            if (!FabPosition.f(i23, companion.c())) {
                                if (!(FabPosition.f(i23, companion.a()) ? true : FabPosition.f(i23, companion.b()))) {
                                    iZ0 = (iL - iX06) / 2;
                                } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.f30001a) {
                                    iZ02 = subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                                    iZ0 = (iL - iZ02) - iX06;
                                } else {
                                    iZ0 = subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                                }
                                fabPlacement = new FabPlacement(iZ0, iX06, iO09);
                            } else if (subcomposeMeasureScope.getLayoutDirection() == LayoutDirection.f30001a) {
                                iZ0 = subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                                fabPlacement = new FabPlacement(iZ0, iX06, iO09);
                            } else {
                                iZ02 = subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                                iZ0 = (iL - iZ02) - iX06;
                                fabPlacement = new FabPlacement(iZ0, iX06, iO09);
                            }
                        }
                        ScaffoldLayoutContent scaffoldLayoutContent = ScaffoldLayoutContent.BottomBar;
                        final Function2 function28 = function24;
                        List listV4 = subcomposeMeasureScope.V(scaffoldLayoutContent, ComposableLambdaKt.c(-2146438447, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bottomBarPlaceables$1
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj16, Object obj17) {
                                invoke((Composer) obj16, ((Number) obj17).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer2, int i24) {
                                if ((i24 & 3) == 2 && composer2.l()) {
                                    composer2.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-2146438447, i24, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:209)");
                                }
                                function28.invoke(composer2, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }));
                        final ArrayList arrayList5 = new ArrayList(listV4.size());
                        int size4 = listV4.size();
                        for (int i24 = 0; i24 < size4; i24++) {
                            arrayList5.add(((Measurable) listV4.get(i24)).n0(jD));
                        }
                        if (arrayList5.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList5.get(0);
                            int iO010 = ((Placeable) obj4).O0();
                            int lastIndex6 = CollectionsKt.getLastIndex(arrayList5);
                            if (1 <= lastIndex6) {
                                int i25 = 1;
                                while (true) {
                                    Object obj16 = arrayList5.get(i25);
                                    int iO011 = ((Placeable) obj16).O0();
                                    if (iO010 < iO011) {
                                        iO010 = iO011;
                                        obj4 = obj16;
                                    }
                                    if (i25 == lastIndex6) {
                                        break;
                                    }
                                    i25++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj4;
                        final Integer numValueOf2 = placeable4 != null ? Integer.valueOf(placeable4.O0()) : null;
                        if (fabPlacement != null) {
                            int i26 = i3;
                            WindowInsets windowInsets5 = windowInsets2;
                            if (numValueOf2 == null || FabPosition.f(i26, FabPosition.f17745b.b())) {
                                iA = fabPlacement.a() + subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                                iC = windowInsets5.c(subcomposeMeasureScope);
                            } else {
                                iA = numValueOf2.intValue() + fabPlacement.a();
                                iC = subcomposeMeasureScope.z0(ScaffoldKt.f19393a);
                            }
                            numValueOf = Integer.valueOf(iA + iC);
                        } else {
                            numValueOf = null;
                        }
                        int iIntValue = i18 != 0 ? i18 + (numValueOf != null ? numValueOf.intValue() : numValueOf2 != null ? numValueOf2.intValue() : windowInsets2.c(subcomposeMeasureScope)) : 0;
                        ScaffoldLayoutContent scaffoldLayoutContent2 = ScaffoldLayoutContent.MainContent;
                        final WindowInsets windowInsets6 = windowInsets2;
                        final Function3 function34 = function33;
                        final int i27 = i7;
                        List listV5 = subcomposeMeasureScope.V(scaffoldLayoutContent2, ComposableLambdaKt.c(-1213360416, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1$bodyContentPlaceables$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj17, Object obj18) {
                                invoke((Composer) obj17, ((Number) obj18).intValue());
                                return Unit.f139807a;
                            }

                            public final void invoke(Composer composer2, int i28) {
                                Integer num;
                                if ((i28 & 3) == 2 && composer2.l()) {
                                    composer2.Q();
                                    return;
                                }
                                if (ComposerKt.M()) {
                                    ComposerKt.U(-1213360416, i28, -1, "androidx.compose.material3.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:238)");
                                }
                                PaddingValues paddingValuesG = WindowInsetsKt.g(windowInsets6, subcomposeMeasureScope);
                                function34.invoke(PaddingKt.d(PaddingKt.g(paddingValuesG, subcomposeMeasureScope.getLayoutDirection()), arrayList3.isEmpty() ? paddingValuesG.d() : subcomposeMeasureScope.F(i27), PaddingKt.f(paddingValuesG, subcomposeMeasureScope.getLayoutDirection()), (arrayList5.isEmpty() || (num = numValueOf2) == null) ? paddingValuesG.a() : subcomposeMeasureScope.F(num.intValue())), composer2, 0);
                                if (ComposerKt.M()) {
                                    ComposerKt.T();
                                }
                            }
                        }));
                        final ArrayList arrayList6 = new ArrayList(listV5.size());
                        int size5 = listV5.size();
                        for (int i28 = 0; i28 < size5; i28++) {
                            arrayList6.add(((Measurable) listV5.get(i28)).n0(jD));
                        }
                        final Integer num = numValueOf2;
                        final WindowInsets windowInsets7 = windowInsets2;
                        final Integer num2 = numValueOf;
                        final int i29 = iIntValue;
                        final FabPlacement fabPlacement2 = fabPlacement;
                        return MeasureScope.B0(subcomposeMeasureScope, iL, iK, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj17) {
                                invoke((Placeable.PlacementScope) obj17);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                List list2 = arrayList6;
                                int size6 = list2.size();
                                for (int i30 = 0; i30 < size6; i30++) {
                                    Placeable.PlacementScope.i(placementScope, (Placeable) list2.get(i30), 0, 0, 0.0f, 4, null);
                                }
                                List list3 = arrayList3;
                                int size7 = list3.size();
                                for (int i31 = 0; i31 < size7; i31++) {
                                    Placeable.PlacementScope.i(placementScope, (Placeable) list3.get(i31), 0, 0, 0.0f, 4, null);
                                }
                                List list4 = arrayList2;
                                int i32 = iL;
                                int i33 = i15;
                                WindowInsets windowInsets8 = windowInsets7;
                                SubcomposeMeasureScope subcomposeMeasureScope2 = subcomposeMeasureScope;
                                int i34 = iK;
                                int i35 = i29;
                                int size8 = list4.size();
                                for (int i36 = 0; i36 < size8; i36++) {
                                    Placeable.PlacementScope.i(placementScope, (Placeable) list4.get(i36), ((i32 - i33) / 2) + windowInsets8.d(subcomposeMeasureScope2, subcomposeMeasureScope2.getLayoutDirection()), i34 - i35, 0.0f, 4, null);
                                }
                                List list5 = arrayList5;
                                int i37 = iK;
                                Integer num3 = num;
                                int size9 = list5.size();
                                for (int i38 = 0; i38 < size9; i38++) {
                                    Placeable.PlacementScope.i(placementScope, (Placeable) list5.get(i38), 0, i37 - (num3 != null ? num3.intValue() : 0), 0.0f, 4, null);
                                }
                                FabPlacement fabPlacement3 = fabPlacement2;
                                if (fabPlacement3 != null) {
                                    List list6 = arrayList4;
                                    int i39 = iK;
                                    Integer num4 = num2;
                                    int size10 = list6.size();
                                    for (int i40 = 0; i40 < size10; i40++) {
                                        Placeable placeable5 = (Placeable) list6.get(i40);
                                        int iB = fabPlacement3.b();
                                        Intrinsics.checkNotNull(num4);
                                        Placeable.PlacementScope.i(placementScope, placeable5, iB, i39 - num4.intValue(), 0.0f, 4, null);
                                    }
                                }
                            }
                        }, 4, null);
                    }
                };
                composerK.w(function27);
                objG = function27;
            } else {
                i6 = 1;
            }
            SubcomposeLayoutKt.a(null, (Function2) objG, composerK, 0, i6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.ScaffoldKt$ScaffoldLayout$2
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
                    ScaffoldKt.b(i3, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }
}
