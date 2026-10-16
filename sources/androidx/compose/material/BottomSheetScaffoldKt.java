package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.material.FabPosition;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.MultiContentMeasurePolicyKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class BottomSheetScaffoldKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f12186a = Dp.g(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f12187b = Dp.g(56);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12188c = Dp.g(125);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x010e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final androidx.compose.material.BottomSheetState r26, final boolean r27, final androidx.compose.ui.graphics.Shape r28, final float r29, final long r30, final long r32, final float r34, androidx.compose.ui.Modifier r35, final kotlin.jvm.functions.Function3 r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instruction units count: 552
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.a(androidx.compose.material.BottomSheetState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.jvm.functions.Function3 r37, androidx.compose.ui.Modifier r38, androidx.compose.material.BottomSheetScaffoldState r39, kotlin.jvm.functions.Function2 r40, kotlin.jvm.functions.Function3 r41, kotlin.jvm.functions.Function2 r42, int r43, boolean r44, androidx.compose.ui.graphics.Shape r45, float r46, long r47, long r49, float r51, long r52, long r54, final kotlin.jvm.functions.Function3 r56, androidx.compose.runtime.Composer r57, final int r58, final int r59, final int r60) {
        /*
            Method dump skipped, instruction units count: 1014
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.b(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, final float f3, final Function0 function0, final int i3, final BottomSheetState bottomSheetState, Composer composer, final int i4) {
        int i5;
        Composer composerK = composer.k(1411837005);
        if ((i4 & 6) == 0) {
            i5 = (composerK.I(function2) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(function22) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(function23) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function24) ? 2048 : 1024;
        }
        if ((i4 & 24576) == 0) {
            i5 |= composerK.I(function25) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i4) == 0) {
            i5 |= composerK.c(f3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i4) == 0) {
            i5 |= composerK.I(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i4) == 0) {
            i5 |= composerK.e(i3) ? 8388608 : 4194304;
        }
        if ((100663296 & i4) == 0) {
            i5 |= composerK.Z(bottomSheetState) ? 67108864 : 33554432;
        }
        if ((38347923 & i5) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1411837005, i5, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:501)");
            }
            List listListOf = CollectionsKt.listOf((Object[]) new Function2[]{function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.f12497a.b() : function2, function22, function23, function24 == null ? ComposableSingletons$BottomSheetScaffoldKt.f12497a.c() : function24, function25});
            boolean z2 = ((3670016 & i5) == 1048576) | ((29360128 & i5) == 8388608) | ((458752 & i5) == 131072) | ((i5 & 234881024) == 67108864);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MultiContentMeasurePolicy() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo47measure3p2s80s(final MeasureScope measureScope, List list, long j3) {
                        Object obj;
                        Object obj2;
                        Object obj3;
                        Object obj4;
                        int iO0;
                        Object obj5;
                        List list2 = (List) list.get(0);
                        List list3 = (List) list.get(1);
                        List list4 = (List) list.get(2);
                        List list5 = (List) list.get(3);
                        List list6 = (List) list.get(4);
                        final int iL = Constraints.l(j3);
                        final int iK = Constraints.k(j3);
                        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
                        final ArrayList arrayList = new ArrayList(list4.size());
                        int size = list4.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            arrayList.add(((Measurable) list4.get(i6)).n0(jD));
                        }
                        final ArrayList arrayList2 = new ArrayList(list2.size());
                        int size2 = list2.size();
                        for (int i7 = 0; i7 < size2; i7++) {
                            arrayList2.add(((Measurable) list2.get(i7)).n0(jD));
                        }
                        if (arrayList2.isEmpty()) {
                            obj = null;
                        } else {
                            obj = arrayList2.get(0);
                            int iO02 = ((Placeable) obj).O0();
                            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex) {
                                int i8 = 1;
                                while (true) {
                                    Object obj6 = arrayList2.get(i8);
                                    int iO03 = ((Placeable) obj6).O0();
                                    if (iO02 < iO03) {
                                        iO02 = iO03;
                                        obj = obj6;
                                    }
                                    if (i8 == lastIndex) {
                                        break;
                                    }
                                    i8++;
                                }
                            }
                        }
                        Placeable placeable = (Placeable) obj;
                        final int iO04 = placeable != null ? placeable.O0() : 0;
                        long jD2 = Constraints.d(jD, 0, 0, 0, iK - iO04, 7, null);
                        final ArrayList arrayList3 = new ArrayList(list3.size());
                        int size3 = list3.size();
                        for (int i9 = 0; i9 < size3; i9++) {
                            arrayList3.add(((Measurable) list3.get(i9)).n0(jD2));
                        }
                        final ArrayList arrayList4 = new ArrayList(list5.size());
                        int size4 = list5.size();
                        for (int i10 = 0; i10 < size4; i10++) {
                            arrayList4.add(((Measurable) list5.get(i10)).n0(jD));
                        }
                        if (arrayList4.isEmpty()) {
                            obj2 = null;
                        } else {
                            obj2 = arrayList4.get(0);
                            int iX0 = ((Placeable) obj2).X0();
                            int lastIndex2 = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex2) {
                                int i11 = 1;
                                while (true) {
                                    Object obj7 = arrayList4.get(i11);
                                    int iX02 = ((Placeable) obj7).X0();
                                    if (iX0 < iX02) {
                                        obj2 = obj7;
                                        iX0 = iX02;
                                    }
                                    if (i11 == lastIndex2) {
                                        break;
                                    }
                                    i11++;
                                }
                            }
                        }
                        Placeable placeable2 = (Placeable) obj2;
                        int iX03 = placeable2 != null ? placeable2.X0() : 0;
                        if (arrayList4.isEmpty()) {
                            obj3 = null;
                        } else {
                            obj3 = arrayList4.get(0);
                            int iO05 = ((Placeable) obj3).O0();
                            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
                            if (1 <= lastIndex3) {
                                int i12 = 1;
                                while (true) {
                                    Object obj8 = arrayList4.get(i12);
                                    int iO06 = ((Placeable) obj8).O0();
                                    if (iO05 < iO06) {
                                        iO05 = iO06;
                                        obj3 = obj8;
                                    }
                                    if (i12 == lastIndex3) {
                                        break;
                                    }
                                    i12++;
                                }
                            }
                        }
                        Placeable placeable3 = (Placeable) obj3;
                        final int iO07 = placeable3 != null ? placeable3.O0() : 0;
                        final ArrayList arrayList5 = new ArrayList(list6.size());
                        int size5 = list6.size();
                        for (int i13 = 0; i13 < size5; i13++) {
                            arrayList5.add(((Measurable) list6.get(i13)).n0(jD));
                        }
                        if (arrayList5.isEmpty()) {
                            obj4 = null;
                        } else {
                            obj4 = arrayList5.get(0);
                            int iX04 = ((Placeable) obj4).X0();
                            int lastIndex4 = CollectionsKt.getLastIndex(arrayList5);
                            if (1 <= lastIndex4) {
                                int i14 = 1;
                                while (true) {
                                    Object obj9 = arrayList5.get(i14);
                                    int iX05 = ((Placeable) obj9).X0();
                                    if (iX04 < iX05) {
                                        obj4 = obj9;
                                        iX04 = iX05;
                                    }
                                    if (i14 == lastIndex4) {
                                        break;
                                    }
                                    i14++;
                                }
                            }
                        }
                        Placeable placeable4 = (Placeable) obj4;
                        final int iX06 = placeable4 != null ? placeable4.X0() : 0;
                        if (arrayList5.isEmpty()) {
                            iO0 = 0;
                            obj5 = null;
                        } else {
                            iO0 = 0;
                            Object obj10 = arrayList5.get(0);
                            int iO08 = ((Placeable) obj10).O0();
                            int lastIndex5 = CollectionsKt.getLastIndex(arrayList5);
                            int i15 = 1;
                            if (1 <= lastIndex5) {
                                while (true) {
                                    Object obj11 = arrayList5.get(i15);
                                    int iO09 = ((Placeable) obj11).O0();
                                    if (iO08 < iO09) {
                                        obj10 = obj11;
                                        iO08 = iO09;
                                    }
                                    if (i15 == lastIndex5) {
                                        break;
                                    }
                                    i15++;
                                }
                            }
                            obj5 = obj10;
                        }
                        Placeable placeable5 = (Placeable) obj5;
                        if (placeable5 != null) {
                            iO0 = placeable5.O0();
                        }
                        final int i16 = iO0;
                        final Function0 function02 = function0;
                        final int i17 = i3;
                        final float f4 = f3;
                        final BottomSheetState bottomSheetState2 = bottomSheetState;
                        final int i18 = iX03;
                        return MeasureScope.B0(measureScope, iL, iK, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.1

                            /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$1$WhenMappings */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            public /* synthetic */ class WhenMappings {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                public static final /* synthetic */ int[] f12283a;

                                static {
                                    int[] iArr = new int[BottomSheetValue.values().length];
                                    try {
                                        iArr[BottomSheetValue.Collapsed.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[BottomSheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    f12283a = iArr;
                                }
                            }

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj12) {
                                invoke((Placeable.PlacementScope) obj12);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                int i19;
                                int iD = MathKt.d(((Number) function02.invoke()).floatValue());
                                int i20 = i17;
                                FabPosition.Companion companion = FabPosition.f12940b;
                                int iZ0 = FabPosition.f(i20, companion.c()) ? measureScope.z0(BottomSheetScaffoldKt.f12186a) : FabPosition.f(i20, companion.a()) ? (iL - i18) / 2 : (iL - i18) - measureScope.z0(BottomSheetScaffoldKt.f12186a);
                                float fM1 = measureScope.M1(f4);
                                int i21 = iO07;
                                int iZ02 = fM1 < ((float) (i21 / 2)) ? (iD - i21) - measureScope.z0(BottomSheetScaffoldKt.f12186a) : iD - (i21 / 2);
                                int i22 = (iL - iX06) / 2;
                                int i23 = WhenMappings.f12283a[bottomSheetState2.d().ordinal()];
                                if (i23 == 1) {
                                    i19 = iZ02 - i16;
                                } else {
                                    if (i23 != 2) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    i19 = iK - i16;
                                }
                                int i24 = i19;
                                List list7 = arrayList3;
                                int i25 = iO04;
                                int size6 = list7.size();
                                for (int i26 = 0; i26 < size6; i26++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list7.get(i26), 0, i25, 0.0f, 4, null);
                                }
                                List list8 = arrayList2;
                                int size7 = list8.size();
                                for (int i27 = 0; i27 < size7; i27++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list8.get(i27), 0, 0, 0.0f, 4, null);
                                }
                                List list9 = arrayList;
                                int size8 = list9.size();
                                for (int i28 = 0; i28 < size8; i28++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list9.get(i28), 0, 0, 0.0f, 4, null);
                                }
                                List list10 = arrayList4;
                                int size9 = list10.size();
                                for (int i29 = 0; i29 < size9; i29++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list10.get(i29), iZ0, iZ02, 0.0f, 4, null);
                                }
                                List list11 = arrayList5;
                                int size10 = list11.size();
                                for (int i30 = 0; i30 < size10; i30++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list11.get(i30), i22, i24, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerK.w(objG);
            }
            MultiContentMeasurePolicy multiContentMeasurePolicy = (MultiContentMeasurePolicy) objG;
            Modifier.Companion companion = Modifier.b8;
            Function2 function2B = LayoutKt.b(listListOf);
            boolean Z = composerK.Z(multiContentMeasurePolicy);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = MultiContentMeasurePolicyKt.a(multiContentMeasurePolicy);
                composerK.w(objG2);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) objG2;
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
            Updater.e(composerA, measurePolicy, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B2 = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B2);
            }
            Updater.e(composerA, modifierF, companion2.f());
            function2B.invoke(composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    BottomSheetScaffoldKt.c(function2, function22, function23, function24, function25, f3, function0, i3, bottomSheetState, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection d(AnchoredDraggableState anchoredDraggableState, Orientation orientation) {
        return new BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1(anchoredDraggableState, orientation);
    }

    public static final BottomSheetScaffoldState k(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i3, int i4) {
        Composer composer2;
        if ((i4 & 1) != 0) {
            composer2 = composer;
            bottomSheetState = l(BottomSheetValue.Collapsed, null, null, composer2, 6, 6);
        } else {
            composer2 = composer;
        }
        if ((i4 & 2) != 0) {
            Object objG = composer2.G();
            if (objG == Composer.f23746a.a()) {
                objG = new SnackbarHostState();
                composer2.w(objG);
            }
            snackbarHostState = (SnackbarHostState) objG;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1022285988, i3, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:277)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer2.Z(bottomSheetState)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer2.Z(snackbarHostState)) || (i3 & 48) == 32);
        Object objG2 = composer2.G();
        if (z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            composer2.w(objG2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return bottomSheetScaffoldState;
    }

    public static final BottomSheetState l(final BottomSheetValue bottomSheetValue, final AnimationSpec animationSpec, final Function1 function1, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = BottomSheetScaffoldDefaults.f12181a.a();
        }
        if ((i4 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(BottomSheetValue bottomSheetValue2) {
                    return Boolean.TRUE;
                }
            };
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1808153344, i3, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:236)");
        }
        final Density density = (Density) composer.q(CompositionLocalsKt.f());
        Object[] objArr = {animationSpec};
        Saver saverA = BottomSheetState.f12311b.a(animationSpec, function1, density);
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(bottomSheetValue)) || (i3 & 6) == 4) | composer.Z(density) | composer.I(animationSpec) | ((((i3 & 896) ^ 384) > 256 && composer.Z(function1)) || (i3 & 384) == 256);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$rememberBottomSheetState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final BottomSheetState invoke() {
                    return new BottomSheetState(bottomSheetValue, density, animationSpec, function1);
                }
            };
            composer.w(objG);
        }
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.e(objArr, saverA, null, (Function0) objG, composer, 0, 4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return bottomSheetState;
    }
}
