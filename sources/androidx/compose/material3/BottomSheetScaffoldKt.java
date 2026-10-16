package androidx.compose.material3;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.material3.internal.DraggableAnchors;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
    /* JADX WARN: Removed duplicated region for block: B:101:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:286:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function3 r34, androidx.compose.ui.Modifier r35, androidx.compose.material3.BottomSheetScaffoldState r36, float r37, float r38, androidx.compose.ui.graphics.Shape r39, long r40, long r42, float r44, float r45, kotlin.jvm.functions.Function2 r46, boolean r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function3 r49, long r50, long r52, final kotlin.jvm.functions.Function3 r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instruction units count: 1144
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt.a(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material3.BottomSheetScaffoldState, float, float, androidx.compose.ui.graphics.Shape, long, long, float, float, kotlin.jvm.functions.Function2, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final Modifier modifier, final Function2 function2, final Function2 function22, final Function2 function23, final Function2 function24, final Function0 function0, final SheetState sheetState, final long j3, final long j4, Composer composer, final int i3) {
        int i4;
        Function2 function25;
        char c3;
        Composer composerK = composer.k(-1651214892);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            function25 = function22;
            i4 |= composerK.I(function25) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            function25 = function22;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function23) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function24) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.I(function0) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(sheetState) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.f(j3) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            c3 = 2;
            i4 |= composerK.f(j4) ? 67108864 : 33554432;
        } else {
            c3 = 2;
        }
        char c4 = c3;
        if ((i4 & 38347923) == 38347922 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1651214892, i4, -1, "androidx.compose.material3.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:354)");
            }
            Function2 function2C = function2 == null ? ComposableSingletons$BottomSheetScaffoldKt.f16710a.c() : function2;
            final Function2 function26 = function25;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(398963586, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1
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
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(398963586, i5, -1, "androidx.compose.material3.BottomSheetScaffoldLayout.<anonymous> (BottomSheetScaffold.kt:360)");
                    }
                    SurfaceKt.a(modifier, null, j3, j4, 0.0f, 0.0f, null, function26, composer2, 0, 114);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54);
            Function2[] function2Arr = new Function2[4];
            function2Arr[0] = function2C;
            function2Arr[1] = composableLambdaE;
            function2Arr[c4] = function23;
            function2Arr[3] = function24;
            List listListOf = CollectionsKt.listOf((Object[]) function2Arr);
            boolean z2 = ((3670016 & i4) == 1048576) | ((i4 & 458752) == 131072);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MultiContentMeasurePolicy() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1
                    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
                    /* JADX INFO: renamed from: measure-3p2s80s */
                    public final MeasureResult mo47measure3p2s80s(MeasureScope measureScope, List list, long j5) {
                        Integer numValueOf;
                        List list2 = (List) list.get(0);
                        int i5 = 1;
                        List list3 = (List) list.get(1);
                        List list4 = (List) list.get(2);
                        List list5 = (List) list.get(3);
                        final int iL = Constraints.l(j5);
                        final int iK = Constraints.k(j5);
                        long jD = Constraints.d(j5, 0, 0, 0, 0, 10, null);
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
                            numValueOf = null;
                        } else {
                            numValueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).O0());
                            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
                            if (1 <= lastIndex) {
                                while (true) {
                                    Integer numValueOf2 = Integer.valueOf(((Placeable) arrayList2.get(i5)).O0());
                                    if (numValueOf2.compareTo(numValueOf) > 0) {
                                        numValueOf = numValueOf2;
                                    }
                                    if (i5 == lastIndex) {
                                        break;
                                    }
                                    i5++;
                                }
                            }
                        }
                        final int iIntValue = numValueOf != null ? numValueOf.intValue() : 0;
                        long jD2 = Constraints.d(jD, 0, 0, 0, iK - iIntValue, 7, null);
                        final ArrayList arrayList3 = new ArrayList(list3.size());
                        int size3 = list3.size();
                        for (int i8 = 0; i8 < size3; i8++) {
                            arrayList3.add(((Measurable) list3.get(i8)).n0(jD2));
                        }
                        final ArrayList arrayList4 = new ArrayList(list5.size());
                        int size4 = list5.size();
                        for (int i9 = 0; i9 < size4; i9++) {
                            arrayList4.add(((Measurable) list5.get(i9)).n0(jD));
                        }
                        final SheetState sheetState2 = sheetState;
                        final Function0 function02 = function0;
                        return MeasureScope.B0(measureScope, iL, iK, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1.1

                            /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2$1$1$WhenMappings */
                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                            @Metadata
                            public /* synthetic */ class WhenMappings {

                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                public static final /* synthetic */ int[] f16011a;

                                static {
                                    int[] iArr = new int[SheetValue.values().length];
                                    try {
                                        iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
                                    } catch (NoSuchFieldError unused) {
                                    }
                                    try {
                                        iArr[SheetValue.Expanded.ordinal()] = 2;
                                    } catch (NoSuchFieldError unused2) {
                                    }
                                    try {
                                        iArr[SheetValue.Hidden.ordinal()] = 3;
                                    } catch (NoSuchFieldError unused3) {
                                    }
                                    f16011a = iArr;
                                }
                            }

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
                                Integer numValueOf3;
                                Integer numValueOf4;
                                int iD;
                                List list6 = arrayList;
                                Integer numValueOf5 = null;
                                if (list6.isEmpty()) {
                                    numValueOf3 = null;
                                } else {
                                    numValueOf3 = Integer.valueOf(((Placeable) list6.get(0)).X0());
                                    int lastIndex2 = CollectionsKt.getLastIndex(list6);
                                    if (1 <= lastIndex2) {
                                        int i10 = 1;
                                        while (true) {
                                            Integer numValueOf6 = Integer.valueOf(((Placeable) list6.get(i10)).X0());
                                            if (numValueOf6.compareTo(numValueOf3) > 0) {
                                                numValueOf3 = numValueOf6;
                                            }
                                            if (i10 == lastIndex2) {
                                                break;
                                            } else {
                                                i10++;
                                            }
                                        }
                                    }
                                }
                                int iMax = Integer.max(0, (iL - (numValueOf3 != null ? numValueOf3.intValue() : 0)) / 2);
                                List list7 = arrayList4;
                                if (list7.isEmpty()) {
                                    numValueOf4 = null;
                                } else {
                                    numValueOf4 = Integer.valueOf(((Placeable) list7.get(0)).X0());
                                    int lastIndex3 = CollectionsKt.getLastIndex(list7);
                                    if (1 <= lastIndex3) {
                                        int i11 = 1;
                                        while (true) {
                                            Integer numValueOf7 = Integer.valueOf(((Placeable) list7.get(i11)).X0());
                                            if (numValueOf7.compareTo(numValueOf4) > 0) {
                                                numValueOf4 = numValueOf7;
                                            }
                                            if (i11 == lastIndex3) {
                                                break;
                                            } else {
                                                i11++;
                                            }
                                        }
                                    }
                                }
                                int iIntValue2 = numValueOf4 != null ? numValueOf4.intValue() : 0;
                                List list8 = arrayList4;
                                if (!list8.isEmpty()) {
                                    numValueOf5 = Integer.valueOf(((Placeable) list8.get(0)).O0());
                                    int lastIndex4 = CollectionsKt.getLastIndex(list8);
                                    if (1 <= lastIndex4) {
                                        int i12 = 1;
                                        while (true) {
                                            Integer numValueOf8 = Integer.valueOf(((Placeable) list8.get(i12)).O0());
                                            if (numValueOf8.compareTo(numValueOf5) > 0) {
                                                numValueOf5 = numValueOf8;
                                            }
                                            if (i12 == lastIndex4) {
                                                break;
                                            } else {
                                                i12++;
                                            }
                                        }
                                    }
                                }
                                int iIntValue3 = numValueOf5 != null ? numValueOf5.intValue() : 0;
                                int i13 = (iL - iIntValue2) / 2;
                                int i14 = WhenMappings.f16011a[sheetState2.e().ordinal()];
                                if (i14 == 1) {
                                    iD = MathKt.d(((Number) function02.invoke()).floatValue());
                                } else {
                                    if (i14 != 2 && i14 != 3) {
                                        throw new NoWhenBranchMatchedException();
                                    }
                                    iD = iK;
                                }
                                int i15 = iD - iIntValue3;
                                List list9 = arrayList3;
                                int i16 = iIntValue;
                                int size5 = list9.size();
                                for (int i17 = 0; i17 < size5; i17++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list9.get(i17), 0, i16, 0.0f, 4, null);
                                }
                                List list10 = arrayList2;
                                int size6 = list10.size();
                                for (int i18 = 0; i18 < size6; i18++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list10.get(i18), 0, 0, 0.0f, 4, null);
                                }
                                List list11 = arrayList;
                                int size7 = list11.size();
                                for (int i19 = 0; i19 < size7; i19++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list11.get(i19), iMax, 0, 0.0f, 4, null);
                                }
                                List list12 = arrayList4;
                                int size8 = list12.size();
                                for (int i20 = 0; i20 < size8; i20++) {
                                    Placeable.PlacementScope.m(placementScope, (Placeable) list12.get(i20), i13, i15, 0.0f, 4, null);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$3
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
                    BottomSheetScaffoldKt.b(modifier, function2, function22, function23, function24, function0, sheetState, j3, j4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(final SheetState sheetState, final float f3, final float f4, final boolean z2, final Shape shape, final long j3, final long j4, final float f5, final float f6, final Function2 function2, final Function3 function3, Composer composer, final int i3, final int i4) {
        int i5;
        int i6;
        CoroutineScope coroutineScope;
        int i7;
        Object obj;
        Modifier modifierB;
        Composer composer2;
        Composer composerK = composer.k(721467526);
        if ((i3 & 6) == 0) {
            i5 = (composerK.Z(sheetState) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.c(f3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerK.Z(shape) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i5 |= composerK.f(j3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i5 |= composerK.f(j4) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.c(f5) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.c(f6) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= composerK.I(function2) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.I(function3) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i5 & 306783379) == 306783378 && (i6 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(721467526, i5, i6, "androidx.compose.material3.StandardBottomSheet (BottomSheetScaffold.kt:224)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.l(EmptyCoroutineContext.f139889a, composerK));
                composerK.w(compositionScopedCoroutineScopeCanceller);
                objG = compositionScopedCoroutineScopeCanceller;
            }
            final CoroutineScope coroutineScopeA = ((CompositionScopedCoroutineScopeCanceller) objG).a();
            Orientation orientation = Orientation.f6031a;
            final float fM1 = ((Density) composerK.q(CompositionLocalsKt.f())).M1(f3);
            composerK.a0(-1831611516);
            if (z2) {
                Modifier.Companion companion2 = Modifier.b8;
                boolean Z = composerK.Z(sheetState.d());
                Object objG2 = composerK.G();
                if (Z) {
                    i7 = i5;
                } else {
                    i7 = i5;
                    if (objG2 == companion.a()) {
                    }
                    coroutineScope = coroutineScopeA;
                    obj = null;
                    modifierB = NestedScrollModifierKt.b(companion2, (NestedScrollConnection) objG2, null, 2, null);
                }
                objG2 = SheetDefaultsKt.a(sheetState, orientation, new Function1<Float, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1

                    /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$nestedScroll$1$1$1", f = "BottomSheetScaffold.kt", l = {236}, m = "invokeSuspend")
                    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        int f16067a;

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ SheetState f16068b;

                        /* JADX INFO: renamed from: c, reason: collision with root package name */
                        final /* synthetic */ float f16069c;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        AnonymousClass1(SheetState sheetState, float f3, Continuation continuation) {
                            super(2, continuation);
                            this.f16068b = sheetState;
                            this.f16069c = f3;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation create(Object obj, Continuation continuation) {
                            return new AnonymousClass1(this.f16068b, this.f16069c, continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            Object objF = IntrinsicsKt.f();
                            int i3 = this.f16067a;
                            if (i3 == 0) {
                                ResultKt.b(obj);
                                SheetState sheetState = this.f16068b;
                                float f3 = this.f16069c;
                                this.f16067a = 1;
                                if (sheetState.o(f3, this) == objF) {
                                    return objF;
                                }
                            } else {
                                if (i3 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                ResultKt.b(obj);
                            }
                            return Unit.f139807a;
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final void c(float f7) {
                        BuildersKt__Builders_commonKt.d(coroutineScopeA, null, null, new AnonymousClass1(sheetState, f7, null), 3, null);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                        c(((Number) obj2).floatValue());
                        return Unit.f139807a;
                    }
                });
                composerK.w(objG2);
                coroutineScope = coroutineScopeA;
                obj = null;
                modifierB = NestedScrollModifierKt.b(companion2, (NestedScrollConnection) objG2, null, 2, null);
            } else {
                coroutineScope = coroutineScopeA;
                i7 = i5;
                obj = null;
                modifierB = Modifier.b8;
            }
            composerK.U();
            Modifier modifierThen = SizeKt.n(SizeKt.h(SizeKt.C(Modifier.b8, 0.0f, f4, 1, obj), 0.0f, 1, obj), f3, 0.0f, 2, obj).then(modifierB);
            AnchoredDraggableState anchoredDraggableStateD = sheetState.d();
            boolean zC = ((i7 & 14) == 4) | composerK.c(fM1);
            Object objG3 = composerK.G();
            if (zC || objG3 == companion.a()) {
                objG3 = new Function2<IntSize, Constraints, Pair<? extends DraggableAnchors<SheetValue>, ? extends SheetValue>>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1

                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    public /* synthetic */ class WhenMappings {

                        /* JADX INFO: renamed from: a, reason: collision with root package name */
                        public static final /* synthetic */ int[] f16024a;

                        static {
                            int[] iArr = new int[SheetValue.values().length];
                            try {
                                iArr[SheetValue.Hidden.ordinal()] = 1;
                            } catch (NoSuchFieldError unused) {
                            }
                            try {
                                iArr[SheetValue.PartiallyExpanded.ordinal()] = 2;
                            } catch (NoSuchFieldError unused2) {
                            }
                            try {
                                iArr[SheetValue.Expanded.ordinal()] = 3;
                            } catch (NoSuchFieldError unused3) {
                            }
                            f16024a = iArr;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x003c A[PHI: r4
                      0x003c: PHI (r4v6 androidx.compose.material3.SheetValue) = 
                      (r4v5 androidx.compose.material3.SheetValue)
                      (r4v7 androidx.compose.material3.SheetValue)
                      (r4v8 androidx.compose.material3.SheetValue)
                      (r4v9 androidx.compose.material3.SheetValue)
                      (r4v10 androidx.compose.material3.SheetValue)
                      (r4v11 androidx.compose.material3.SheetValue)
                      (r4v12 androidx.compose.material3.SheetValue)
                     binds: [B:29:0x0077, B:20:0x005c, B:23:0x0065, B:26:0x006e, B:9:0x003a, B:12:0x0044, B:15:0x004d] A[DONT_GENERATE, DONT_INLINE]] */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public final kotlin.Pair c(long r2, long r4) {
                        /*
                            r1 = this;
                            int r4 = androidx.compose.ui.unit.Constraints.k(r4)
                            float r4 = (float) r4
                            int r2 = androidx.compose.ui.unit.IntSize.f(r2)
                            float r2 = (float) r2
                            androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1 r3 = new androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1$newAnchors$1
                            androidx.compose.material3.SheetState r5 = r1
                            float r0 = r2
                            r3.<init>()
                            androidx.compose.material3.internal.DraggableAnchors r2 = androidx.compose.material3.internal.AnchoredDraggableKt.a(r3)
                            androidx.compose.material3.SheetState r3 = r1
                            androidx.compose.material3.internal.AnchoredDraggableState r3 = r3.d()
                            java.lang.Object r3 = r3.x()
                            androidx.compose.material3.SheetValue r3 = (androidx.compose.material3.SheetValue) r3
                            int[] r4 = androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1.WhenMappings.f16024a
                            int r5 = r3.ordinal()
                            r4 = r4[r5]
                            r5 = 1
                            if (r4 == r5) goto L71
                            r5 = 2
                            if (r4 == r5) goto L56
                            r5 = 3
                            if (r4 != r5) goto L50
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.Expanded
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L3e
                        L3c:
                            r3 = r4
                            goto L7a
                        L3e:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.PartiallyExpanded
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L47
                            goto L3c
                        L47:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.Hidden
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L7a
                            goto L3c
                        L50:
                            kotlin.NoWhenBranchMatchedException r2 = new kotlin.NoWhenBranchMatchedException
                            r2.<init>()
                            throw r2
                        L56:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.PartiallyExpanded
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L5f
                            goto L3c
                        L5f:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.Expanded
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L68
                            goto L3c
                        L68:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.Hidden
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L7a
                            goto L3c
                        L71:
                            androidx.compose.material3.SheetValue r4 = androidx.compose.material3.SheetValue.Hidden
                            boolean r5 = r2.d(r4)
                            if (r5 == 0) goto L7a
                            goto L3c
                        L7a:
                            kotlin.Pair r2 = kotlin.TuplesKt.a(r2, r3)
                            return r2
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$1$1.c(long, long):kotlin.Pair");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                        return c(((IntSize) obj2).j(), ((Constraints) obj3).r());
                    }
                };
                composerK.w(objG3);
            }
            final CoroutineScope coroutineScope2 = coroutineScope;
            int i8 = i7 >> 9;
            composer2 = composerK;
            SurfaceKt.a(AnchoredDraggableKt.e(AnchoredDraggableKt.h(modifierThen, anchoredDraggableStateD, orientation, (Function2) objG3), sheetState.d(), orientation, z2, false, null, 24, null), shape, j3, j4, f5, f6, null, ComposableLambdaKt.e(390720907, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
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
                public final void invoke(Composer composer3, int i9) {
                    if ((i9 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(390720907, i9, -1, "androidx.compose.material3.StandardBottomSheet.<anonymous> (BottomSheetScaffold.kt:295)");
                    }
                    Modifier.Companion companion3 = Modifier.b8;
                    Modifier modifierH = SizeKt.h(companion3, 0.0f, 1, null);
                    Function2 function22 = function2;
                    final SheetState sheetState2 = sheetState;
                    final boolean z3 = z2;
                    final CoroutineScope coroutineScope3 = coroutineScope2;
                    Function3 function32 = function3;
                    Arrangement.Vertical verticalH = Arrangement.f6574a.h();
                    Alignment.Companion companion4 = Alignment.f25072a;
                    MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion4.k(), composer3, 0);
                    int iA = ComposablesKt.a(composer3, 0);
                    CompositionLocalMap compositionLocalMapU = composer3.u();
                    Modifier modifierF = ComposedModifierKt.f(composer3, modifierH);
                    ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                    Function0 function0A = companion5.a();
                    if (composer3.m() == null) {
                        ComposablesKt.c();
                    }
                    composer3.L();
                    if (composer3.i()) {
                        composer3.P(function0A);
                    } else {
                        composer3.v();
                    }
                    Composer composerA = Updater.a(composer3);
                    Updater.e(composerA, measurePolicyA, companion5.e());
                    Updater.e(composerA, compositionLocalMapU, companion5.g());
                    Function2 function2B = companion5.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion5.f());
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                    composer3.a0(-1168080147);
                    if (function22 != null) {
                        Strings.Companion companion6 = Strings.f22102b;
                        final String strA = Strings_androidKt.a(Strings.a(R.string.f19295a), composer3, 0);
                        final String strA2 = Strings_androidKt.a(Strings.a(R.string.f19297b), composer3, 0);
                        final String strA3 = Strings_androidKt.a(Strings.a(R.string.f19301d), composer3, 0);
                        Modifier modifierC = columnScopeInstance.c(companion3, companion4.g());
                        boolean Z2 = composer3.Z(sheetState2) | composer3.b(z3) | composer3.Z(strA3) | composer3.I(coroutineScope3) | composer3.Z(strA) | composer3.Z(strA2);
                        Object objG4 = composer3.G();
                        if (Z2 || objG4 == Composer.f23746a.a()) {
                            objG4 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                    invoke((SemanticsPropertyReceiver) obj2);
                                    return Unit.f139807a;
                                }

                                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                    final SheetState sheetState3 = sheetState2;
                                    boolean z4 = z3;
                                    String str = strA3;
                                    String str2 = strA;
                                    String str3 = strA2;
                                    final CoroutineScope coroutineScope4 = coroutineScope3;
                                    if (sheetState3.d().o().getSize() <= 1 || !z4) {
                                        return;
                                    }
                                    SheetValue sheetValueE = sheetState3.e();
                                    SheetValue sheetValue = SheetValue.PartiallyExpanded;
                                    if (sheetValueE == sheetValue) {
                                        if (((Boolean) sheetState3.d().r().invoke(SheetValue.Expanded)).booleanValue()) {
                                            SemanticsPropertiesKt.p(semanticsPropertyReceiver, str, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1

                                                /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1$1, reason: invalid class name */
                                                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                                                @Metadata
                                                @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$1$1", f = "BottomSheetScaffold.kt", l = {311}, m = "invokeSuspend")
                                                static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                                                    int f16042a;

                                                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                                                    final /* synthetic */ SheetState f16043b;

                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    AnonymousClass1(SheetState sheetState, Continuation continuation) {
                                                        super(2, continuation);
                                                        this.f16043b = sheetState;
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Continuation create(Object obj, Continuation continuation) {
                                                        return new AnonymousClass1(this.f16043b, continuation);
                                                    }

                                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                    public final Object invokeSuspend(Object obj) throws Throwable {
                                                        Object objF = IntrinsicsKt.f();
                                                        int i3 = this.f16042a;
                                                        if (i3 == 0) {
                                                            ResultKt.b(obj);
                                                            SheetState sheetState = this.f16043b;
                                                            this.f16042a = 1;
                                                            if (sheetState.c(this) == objF) {
                                                                return objF;
                                                            }
                                                        } else {
                                                            if (i3 != 1) {
                                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                            }
                                                            ResultKt.b(obj);
                                                        }
                                                        return Unit.f139807a;
                                                    }

                                                    @Override // kotlin.jvm.functions.Function2
                                                    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                                    }
                                                }

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Boolean invoke() {
                                                    BuildersKt__Builders_commonKt.d(coroutineScope4, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                                    return Boolean.TRUE;
                                                }
                                            });
                                        }
                                    } else if (((Boolean) sheetState3.d().r().invoke(sheetValue)).booleanValue()) {
                                        SemanticsPropertiesKt.e(semanticsPropertyReceiver, str2, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2

                                            /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2$1, reason: invalid class name */
                                            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                                            @Metadata
                                            @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$2$1", f = "BottomSheetScaffold.kt", l = {320}, m = "invokeSuspend")
                                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                                /* JADX INFO: renamed from: a, reason: collision with root package name */
                                                int f16046a;

                                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                                final /* synthetic */ SheetState f16047b;

                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                AnonymousClass1(SheetState sheetState, Continuation continuation) {
                                                    super(2, continuation);
                                                    this.f16047b = sheetState;
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Continuation create(Object obj, Continuation continuation) {
                                                    return new AnonymousClass1(this.f16047b, continuation);
                                                }

                                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                                public final Object invokeSuspend(Object obj) throws Throwable {
                                                    Object objF = IntrinsicsKt.f();
                                                    int i3 = this.f16046a;
                                                    if (i3 == 0) {
                                                        ResultKt.b(obj);
                                                        SheetState sheetState = this.f16047b;
                                                        this.f16046a = 1;
                                                        if (sheetState.m(this) == objF) {
                                                            return objF;
                                                        }
                                                    } else {
                                                        if (i3 != 1) {
                                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                        }
                                                        ResultKt.b(obj);
                                                    }
                                                    return Unit.f139807a;
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                                }
                                            }

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(0);
                                            }

                                            @Override // kotlin.jvm.functions.Function0
                                            public final Boolean invoke() {
                                                BuildersKt__Builders_commonKt.d(coroutineScope4, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                                return Boolean.TRUE;
                                            }
                                        });
                                    }
                                    if (sheetState3.h()) {
                                        return;
                                    }
                                    SemanticsPropertiesKt.m(semanticsPropertyReceiver, str3, new Function0<Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3

                                        /* JADX INFO: renamed from: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3$1, reason: invalid class name */
                                        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                                        @Metadata
                                        @DebugMetadata(c = "androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$2$1$1$1$1$3$1", f = "BottomSheetScaffold.kt", l = {327}, m = "invokeSuspend")
                                        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

                                            /* JADX INFO: renamed from: a, reason: collision with root package name */
                                            int f16050a;

                                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                                            final /* synthetic */ SheetState f16051b;

                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            AnonymousClass1(SheetState sheetState, Continuation continuation) {
                                                super(2, continuation);
                                                this.f16051b = sheetState;
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Continuation create(Object obj, Continuation continuation) {
                                                return new AnonymousClass1(this.f16051b, continuation);
                                            }

                                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                            public final Object invokeSuspend(Object obj) throws Throwable {
                                                Object objF = IntrinsicsKt.f();
                                                int i3 = this.f16050a;
                                                if (i3 == 0) {
                                                    ResultKt.b(obj);
                                                    SheetState sheetState = this.f16051b;
                                                    this.f16050a = 1;
                                                    if (sheetState.k(this) == objF) {
                                                        return objF;
                                                    }
                                                } else {
                                                    if (i3 != 1) {
                                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                    }
                                                    ResultKt.b(obj);
                                                }
                                                return Unit.f139807a;
                                            }

                                            @Override // kotlin.jvm.functions.Function2
                                            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                                                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                                            }
                                        }

                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Boolean invoke() {
                                            BuildersKt__Builders_commonKt.d(coroutineScope4, null, null, new AnonymousClass1(sheetState3, null), 3, null);
                                            return Boolean.TRUE;
                                        }
                                    });
                                }
                            };
                            composer3.w(objG4);
                        }
                        Modifier modifierE = SemanticsModifierKt.e(modifierC, true, (Function1) objG4);
                        MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), false);
                        int iA2 = ComposablesKt.a(composer3, 0);
                        CompositionLocalMap compositionLocalMapU2 = composer3.u();
                        Modifier modifierF2 = ComposedModifierKt.f(composer3, modifierE);
                        Function0 function0A2 = companion5.a();
                        if (composer3.m() == null) {
                            ComposablesKt.c();
                        }
                        composer3.L();
                        if (composer3.i()) {
                            composer3.P(function0A2);
                        } else {
                            composer3.v();
                        }
                        Composer composerA2 = Updater.a(composer3);
                        Updater.e(composerA2, measurePolicyG, companion5.e());
                        Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                        Function2 function2B2 = companion5.b();
                        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                            composerA2.w(Integer.valueOf(iA2));
                            composerA2.p(Integer.valueOf(iA2), function2B2);
                        }
                        Updater.e(composerA2, modifierF2, companion5.f());
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                        function22.invoke(composer3, 0);
                        composer3.y();
                    }
                    composer3.U();
                    function32.invoke(columnScopeInstance, composer3, 6);
                    composer3.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composer2, (i8 & 112) | 12582912 | (i8 & 896) | (i8 & 7168) | (57344 & i8) | (i8 & 458752), 64);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$StandardBottomSheet$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i9) {
                    BottomSheetScaffoldKt.c(sheetState, f3, f4, z2, shape, j3, j4, f5, f6, function2, function3, composer3, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    public static final BottomSheetScaffoldState f(SheetState sheetState, SnackbarHostState snackbarHostState, Composer composer, int i3, int i4) {
        Composer composer2;
        if ((i4 & 1) != 0) {
            composer2 = composer;
            sheetState = g(null, null, false, composer2, 0, 7);
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
            ComposerKt.U(-1474606134, i3, -1, "androidx.compose.material3.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:180)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer2.Z(sheetState)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer2.Z(snackbarHostState)) || (i3 & 48) == 32);
        Object objG2 = composer2.G();
        if (z2 || objG2 == Composer.f23746a.a()) {
            objG2 = new BottomSheetScaffoldState(sheetState, snackbarHostState);
            composer2.w(objG2);
        }
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objG2;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return bottomSheetScaffoldState;
    }

    public static final SheetState g(SheetValue sheetValue, Function1 function1, boolean z2, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            sheetValue = SheetValue.PartiallyExpanded;
        }
        SheetValue sheetValue2 = sheetValue;
        if ((i4 & 2) != 0) {
            function1 = new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$rememberStandardBottomSheetState$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(SheetValue sheetValue3) {
                    return Boolean.TRUE;
                }
            };
        }
        Function1 function12 = function1;
        if ((i4 & 4) != 0) {
            z2 = true;
        }
        boolean z3 = z2;
        if (ComposerKt.M()) {
            ComposerKt.U(678511581, i3, -1, "androidx.compose.material3.rememberStandardBottomSheetState (BottomSheetScaffold.kt:204)");
        }
        SheetState sheetStateD = SheetDefaultsKt.d(false, function12, sheetValue2, z3, composer, (i3 & 112) | ((i3 << 6) & 896) | ((i3 << 3) & 7168), 1);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return sheetStateD;
    }
}
