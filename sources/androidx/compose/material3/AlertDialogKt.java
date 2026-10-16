package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.DialogProperties;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
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
    private static final float f15450a = Dp.g(280);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15451b = Dp.g(560);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f15452c = Dp.g(8);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f15453d = Dp.g(12);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final PaddingValues f15454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PaddingValues f15455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final PaddingValues f15456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final PaddingValues f15457h;

    static {
        float f3 = 24;
        f15454e = PaddingKt.a(Dp.g(f3));
        float f4 = 16;
        f15455f = PaddingKt.e(0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
        f15456g = PaddingKt.e(0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null);
        f15457h = PaddingKt.e(0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(final kotlin.jvm.functions.Function0 r17, androidx.compose.ui.Modifier r18, androidx.compose.ui.window.DialogProperties r19, final kotlin.jvm.functions.Function2 r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 215
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.a(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(final kotlin.jvm.functions.Function2 r29, androidx.compose.ui.Modifier r30, final kotlin.jvm.functions.Function2 r31, final kotlin.jvm.functions.Function2 r32, final kotlin.jvm.functions.Function2 r33, final androidx.compose.ui.graphics.Shape r34, final long r35, final float r37, final long r38, final long r40, final long r42, final long r44, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.b(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, float, long, long, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void c(final float f3, final float f4, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(586821353);
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
                ComposerKt.U(586821353, i4, -1, "androidx.compose.material3.AlertDialogFlowRow (AlertDialog.kt:364)");
            }
            boolean z2 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new MeasurePolicy() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1
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
                        float f5 = f3;
                        float f6 = f4;
                        int size = list.size();
                        int i5 = 0;
                        while (i5 < size) {
                            ArrayList arrayList5 = arrayList;
                            Ref.IntRef intRef5 = intRef2;
                            Placeable placeableN0 = ((Measurable) list.get(i5)).n0(j3);
                            int i6 = i5;
                            Ref.IntRef intRef6 = intRef3;
                            intRef3 = intRef6;
                            int i7 = size;
                            if (a(arrayList4, intRef6, measureScope, f5, j3, placeableN0)) {
                                arrayList = arrayList5;
                                intRef2 = intRef5;
                            } else {
                                arrayList = arrayList5;
                                intRef2 = intRef5;
                                b(arrayList, intRef2, measureScope, f6, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                            }
                            if (!arrayList4.isEmpty()) {
                                intRef3.f140142a += measureScope.z0(f5);
                            }
                            arrayList4.add(placeableN0);
                            intRef3.f140142a += placeableN0.X0();
                            intRef4.f140142a = Math.max(intRef4.f140142a, placeableN0.O0());
                            i5 = i6 + 1;
                            size = i7;
                        }
                        if (!arrayList4.isEmpty()) {
                            b(arrayList, intRef2, measureScope, f4, arrayList4, arrayList2, intRef4, arrayList3, intRef, intRef3);
                        }
                        final int iMax = Math.max(intRef.f140142a, Constraints.n(j3));
                        int iMax2 = Math.max(intRef2.f140142a, Constraints.m(j3));
                        final float f7 = f3;
                        final ArrayList arrayList6 = arrayList;
                        return MeasureScope.B0(measureScope, iMax, iMax2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$1$1.2
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
                                float f8 = f7;
                                int i8 = iMax;
                                List list3 = arrayList3;
                                int size2 = list2.size();
                                for (int i9 = 0; i9 < size2; i9++) {
                                    List list4 = (List) list2.get(i9);
                                    int size3 = list4.size();
                                    int[] iArr = new int[size3];
                                    int i10 = 0;
                                    while (i10 < size3) {
                                        iArr[i10] = ((Placeable) list4.get(i10)).X0() + (i10 < CollectionsKt.getLastIndex(list4) ? measureScope2.z0(f8) : 0);
                                        i10++;
                                    }
                                    Arrangement.Horizontal horizontalC = Arrangement.f6574a.c();
                                    int[] iArr2 = new int[size3];
                                    for (int i11 = 0; i11 < size3; i11++) {
                                        iArr2[i11] = 0;
                                    }
                                    horizontalC.c(measureScope2, i8, iArr, measureScope2.getLayoutDirection(), iArr2);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogFlowRow$2
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

    public static final void d(final Function0 function0, final Function2 function2, final Modifier modifier, final Function2 function22, final Function2 function23, final Function2 function24, final Function2 function25, final Shape shape, final long j3, final long j4, final long j5, final long j6, final float f3, final DialogProperties dialogProperties, Composer composer, final int i3, final int i4) {
        int i5;
        Function2 function26;
        Function2 function27;
        Function2 function28;
        int i6;
        float f4;
        Composer composerK = composer.k(-919826268);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(function0) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            function26 = function2;
            i5 |= composerK.I(function26) ? 32 : 16;
        } else {
            function26 = function2;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.Z(modifier) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            function27 = function22;
            i5 |= composerK.I(function27) ? 2048 : 1024;
        } else {
            function27 = function22;
        }
        if ((i3 & 24576) == 0) {
            function28 = function23;
            i5 |= composerK.I(function28) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        } else {
            function28 = function23;
        }
        if ((i3 & 196608) == 0) {
            i5 |= composerK.I(function24) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= composerK.I(function25) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= composerK.Z(shape) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= composerK.f(j3) ? 67108864 : 33554432;
        }
        if ((i3 & 805306368) == 0) {
            i5 |= composerK.f(j4) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = i4 | (composerK.f(j5) ? 4 : 2);
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= composerK.f(j6) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            f4 = f3;
            i6 |= composerK.c(f4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        } else {
            f4 = f3;
        }
        if ((i4 & 3072) == 0) {
            i6 |= composerK.Z(dialogProperties) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i5 & 306783379) == 306783378 && (i7 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-919826268, i5, i7, "androidx.compose.material3.AlertDialogImpl (AlertDialog.kt:247)");
            }
            final Function2 function29 = function26;
            final Function2 function210 = function27;
            final float f5 = f4;
            final Function2 function211 = function28;
            e(function0, modifier, dialogProperties, ComposableLambdaKt.e(-1852840226, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    if ((i8 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1852840226, i8, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous> (AlertDialog.kt:252)");
                    }
                    final Function2 function212 = function210;
                    final Function2 function213 = function29;
                    AlertDialogKt.b(ComposableLambdaKt.e(1163543932, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer3, int i9) {
                            if ((i9 & 3) == 2 && composer3.l()) {
                                composer3.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(1163543932, i9, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous> (AlertDialog.kt:254)");
                            }
                            float f6 = AlertDialogKt.f15452c;
                            float f7 = AlertDialogKt.f15453d;
                            final Function2 function214 = function212;
                            final Function2 function215 = function213;
                            AlertDialogKt.c(f6, f7, ComposableLambdaKt.e(1887135077, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt.AlertDialogImpl.1.1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.f139807a;
                                }

                                public final void invoke(Composer composer4, int i10) {
                                    if ((i10 & 3) == 2 && composer4.l()) {
                                        composer4.Q();
                                        return;
                                    }
                                    if (ComposerKt.M()) {
                                        ComposerKt.U(1887135077, i10, -1, "androidx.compose.material3.AlertDialogImpl.<anonymous>.<anonymous>.<anonymous> (AlertDialog.kt:258)");
                                    }
                                    Function2 function216 = function214;
                                    composer4.a0(1497073862);
                                    if (function216 != null) {
                                        function216.invoke(composer4, 0);
                                        Unit unit = Unit.f139807a;
                                    }
                                    composer4.U();
                                    function215.invoke(composer4, 0);
                                    if (ComposerKt.M()) {
                                        ComposerKt.T();
                                    }
                                }
                            }, composer3, 54), composer3, 438);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer2, 54), null, function211, function24, function25, shape, j3, f5, ColorSchemeKt.i(DialogTokens.f22476a.a(), composer2, 6), j4, j5, j6, composer2, 6, 0, 2);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, (i5 & 14) | 3072 | ((i5 >> 3) & 112) | ((i7 >> 3) & 896), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material3.AlertDialogKt$AlertDialogImpl$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    AlertDialogKt.d(function0, function2, modifier, function22, function23, function24, function25, shape, j3, j4, j5, j6, f3, dialogProperties, composer2, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void e(final kotlin.jvm.functions.Function0 r16, androidx.compose.ui.Modifier r17, androidx.compose.ui.window.DialogProperties r18, final kotlin.jvm.functions.Function2 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.AlertDialogKt.e(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.window.DialogProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float l() {
        return f15451b;
    }

    public static final float m() {
        return f15450a;
    }
}
