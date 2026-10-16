package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntList;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.CrossAxisAlignment;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
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
public final class FlowLayoutKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CrossAxisAlignment f6814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CrossAxisAlignment f6815b;

    static {
        CrossAxisAlignment.Companion companion = CrossAxisAlignment.f6736a;
        Alignment.Companion companion2 = Alignment.f25072a;
        f6814a = companion.c(companion2.l());
        f6815b = companion.b(companion2.k());
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void a(androidx.compose.ui.Modifier r24, androidx.compose.foundation.layout.Arrangement.Vertical r25, androidx.compose.foundation.layout.Arrangement.Horizontal r26, androidx.compose.ui.Alignment.Horizontal r27, int r28, int r29, androidx.compose.foundation.layout.FlowColumnOverflow r30, final kotlin.jvm.functions.Function3 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.a(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, androidx.compose.foundation.layout.FlowColumnOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(androidx.compose.ui.Modifier r21, androidx.compose.foundation.layout.Arrangement.Vertical r22, androidx.compose.foundation.layout.Arrangement.Horizontal r23, androidx.compose.ui.Alignment.Horizontal r24, int r25, int r26, final kotlin.jvm.functions.Function3 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.b(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.ui.Alignment$Horizontal, int, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:142:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0109  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void c(androidx.compose.ui.Modifier r24, androidx.compose.foundation.layout.Arrangement.Horizontal r25, androidx.compose.foundation.layout.Arrangement.Vertical r26, androidx.compose.ui.Alignment.Vertical r27, int r28, int r29, androidx.compose.foundation.layout.FlowRowOverflow r30, final kotlin.jvm.functions.Function3 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 685
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.c(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, androidx.compose.foundation.layout.FlowRowOverflow, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00e6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void d(androidx.compose.ui.Modifier r21, androidx.compose.foundation.layout.Arrangement.Horizontal r22, androidx.compose.foundation.layout.Arrangement.Vertical r23, androidx.compose.ui.Alignment.Vertical r24, int r25, int r26, final kotlin.jvm.functions.Function3 r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.FlowLayoutKt.d(androidx.compose.ui.Modifier, androidx.compose.foundation.layout.Arrangement$Horizontal, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.ui.Alignment$Vertical, int, int, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.compose.ui.layout.Placeable[]] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r8v16, types: [androidx.compose.ui.layout.Placeable[]] */
    public static final MeasureResult f(MeasureScope measureScope, FlowLineMeasurePolicy flowLineMeasurePolicy, Iterator it, float f3, float f4, long j3, int i3, int i4, FlowLayoutOverflowState flowLayoutOverflowState) {
        int i5;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfoA;
        MutableIntObjectMap mutableIntObjectMap;
        int i6;
        int i7;
        MeasureScope measureScope2;
        FlowLineMeasurePolicy flowLineMeasurePolicy2;
        int[] iArr;
        int[] iArr2;
        long j4;
        int height;
        int width;
        int i8;
        MutableIntObjectMap mutableIntObjectMap2;
        IntIntPair intIntPairA;
        MutableIntList mutableIntList;
        MutableIntList mutableIntList2;
        int i9;
        int i10;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo;
        int i11;
        int i12;
        int i13;
        MeasureScope measureScope3 = measureScope;
        FlowLineMeasurePolicy flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        Iterator it2 = it;
        MutableVector mutableVector = new MutableVector(new MeasureResult[16], 0);
        int iL = Constraints.l(j3);
        int iN = Constraints.n(j3);
        int iK = Constraints.k(j3);
        MutableIntObjectMap mutableIntObjectMapC = IntObjectMapKt.c();
        ArrayList arrayList = new ArrayList();
        int iCeil = (int) Math.ceil(measureScope3.M1(f3));
        int iCeil2 = (int) Math.ceil(measureScope3.M1(f4));
        long jA = OrientationIndependentConstraints.a(0, iL, 0, iK);
        long jH = OrientationIndependentConstraints.h(OrientationIndependentConstraints.e(jA, 0, 0, 0, 0, 14, null), flowLineMeasurePolicy3.b() ? LayoutOrientation.f6996a : LayoutOrientation.f6997b);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        FlowLineInfo flowLineInfo = it2 instanceof ContextualFlowItemIterator ? new FlowLineInfo(0, 0, measureScope3.F(iL), measureScope3.F(iK), null) : null;
        Measurable measurableN = !it2.hasNext() ? null : n(it2, flowLineInfo);
        IntIntPair intIntPairA2 = measurableN != null ? IntIntPair.a(k(measurableN, flowLineMeasurePolicy3, jH, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$nextSize$1$1
            {
                super(1);
            }

            public final void c(Placeable placeable) {
                objectRef.f140144a = placeable;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((Placeable) obj);
                return Unit.f139807a;
            }
        })) : null;
        Integer numValueOf = intIntPairA2 != null ? Integer.valueOf(IntIntPair.e(intIntPairA2.i())) : null;
        Integer numValueOf2 = intIntPairA2 != null ? Integer.valueOf(IntIntPair.f(intIntPairA2.i())) : null;
        Integer num = numValueOf;
        Measurable measurable = measurableN;
        MutableIntList mutableIntList3 = new MutableIntList(0, 1, null);
        MutableIntList mutableIntList4 = new MutableIntList(0, 1, null);
        FlowLineInfo flowLineInfo2 = flowLineInfo;
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i3, flowLayoutOverflowState, j3, i4, iCeil, iCeil2, null);
        int i14 = iCeil;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfoB = flowLayoutBuildingBlocks.b(it2.hasNext(), 0, IntIntPair.b(iL, iK), intIntPairA2, 0, 0, 0, false, false);
        if (wrapInfoB.a()) {
            wrapEllipsisInfoA = flowLayoutBuildingBlocks.a(wrapInfoB, intIntPairA2 != null, -1, 0, iL, 0);
            i5 = iL;
        } else {
            i5 = iL;
            wrapEllipsisInfoA = null;
        }
        Integer numValueOf3 = num;
        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfo2 = wrapEllipsisInfoA;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        FlowLayoutBuildingBlocks.WrapInfo wrapInfo = wrapInfoB;
        int i19 = 0;
        int i20 = iN;
        MutableIntList mutableIntList5 = mutableIntList3;
        int i21 = iK;
        int i22 = 0;
        int i23 = i5;
        Measurable measurableN2 = measurable;
        while (!wrapInfo.a() && measurableN2 != null) {
            Intrinsics.checkNotNull(numValueOf3);
            int iIntValue = numValueOf3.intValue();
            Intrinsics.checkNotNull(numValueOf2);
            MutableIntList mutableIntList6 = mutableIntList4;
            int i24 = i5;
            int i25 = i16 + iIntValue;
            int iMax = Math.max(i15, numValueOf2.intValue());
            int i26 = i23 - iIntValue;
            int i27 = i22 + 1;
            int i28 = i20;
            flowLayoutOverflowState.n(i27);
            arrayList.add(measurableN2);
            mutableIntObjectMapC.r(i22, objectRef.f140144a);
            int i29 = i27 - i17;
            boolean z2 = i29 < i3;
            if (flowLineInfo2 != null) {
                if (z2) {
                    i8 = i29;
                    i11 = i19;
                } else {
                    i8 = i29;
                    i11 = i19 + 1;
                }
                int i30 = z2 ? i8 : 0;
                if (z2) {
                    int i31 = i26 - i14;
                    i12 = i31 < 0 ? 0 : i31;
                } else {
                    i12 = i24;
                }
                float F = measureScope3.F(i12);
                if (z2) {
                    mutableIntObjectMap2 = mutableIntObjectMapC;
                    i13 = i21;
                } else {
                    int i32 = (i21 - iMax) - iCeil2;
                    mutableIntObjectMap2 = mutableIntObjectMapC;
                    i13 = i32 < 0 ? 0 : i32;
                }
                flowLineInfo2.e(i11, i30, F, measureScope3.F(i13));
            } else {
                i8 = i29;
                mutableIntObjectMap2 = mutableIntObjectMapC;
            }
            measurableN2 = !it2.hasNext() ? null : n(it2, flowLineInfo2);
            objectRef.f140144a = null;
            IntIntPair intIntPairA3 = measurableN2 != null ? IntIntPair.a(k(measurableN2, flowLineMeasurePolicy3, jH, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$breakDownItems$1$1
                {
                    super(1);
                }

                public final void c(Placeable placeable) {
                    objectRef.f140144a = placeable;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Placeable) obj);
                    return Unit.f139807a;
                }
            })) : null;
            Integer numValueOf4 = intIntPairA3 != null ? Integer.valueOf(IntIntPair.e(intIntPairA3.i()) + i14) : null;
            numValueOf2 = intIntPairA3 != null ? Integer.valueOf(IntIntPair.f(intIntPairA3.i())) : null;
            boolean zHasNext = it2.hasNext();
            int i33 = i19;
            long jB = IntIntPair.b(i26, i21);
            if (intIntPairA3 == null) {
                intIntPairA = null;
            } else {
                Intrinsics.checkNotNull(numValueOf4);
                int iIntValue2 = numValueOf4.intValue();
                Intrinsics.checkNotNull(numValueOf2);
                intIntPairA = IntIntPair.a(IntIntPair.b(iIntValue2, numValueOf2.intValue()));
            }
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoB2 = flowLayoutBuildingBlocks.b(zHasNext, i8, jB, intIntPairA, i33, i18, iMax, false, false);
            if (wrapInfoB2.b()) {
                int iMin = Math.min(Math.max(i28, i25), i24);
                int i34 = i18 + iMax;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfoA2 = flowLayoutBuildingBlocks.a(wrapInfoB2, intIntPairA3 != null, i33, i34, i26, i8);
                mutableIntList = mutableIntList6;
                mutableIntList.l(iMax);
                int i35 = (iK - i34) - iCeil2;
                MutableIntList mutableIntList7 = mutableIntList5;
                mutableIntList7.l(i27);
                i19 = i33 + 1;
                i18 = i34 + iCeil2;
                i23 = i24;
                i24 = i23;
                numValueOf3 = numValueOf4 != null ? Integer.valueOf(numValueOf4.intValue() - i14) : null;
                i17 = i27;
                i9 = i35;
                wrapEllipsisInfo = wrapEllipsisInfoA2;
                i20 = iMin;
                mutableIntList2 = mutableIntList7;
                i10 = 0;
                i25 = 0;
            } else {
                mutableIntList = mutableIntList6;
                mutableIntList2 = mutableIntList5;
                numValueOf3 = numValueOf4;
                i23 = i26;
                i19 = i33;
                i20 = i28;
                i9 = i21;
                i10 = iMax;
                wrapEllipsisInfo = wrapEllipsisInfo2;
            }
            wrapEllipsisInfo2 = wrapEllipsisInfo;
            mutableIntList5 = mutableIntList2;
            i15 = i10;
            i21 = i9;
            i22 = i27;
            wrapInfo = wrapInfoB2;
            it2 = it;
            mutableIntList4 = mutableIntList;
            mutableIntObjectMapC = mutableIntObjectMap2;
            i16 = i25;
            i5 = i24;
        }
        MutableIntObjectMap mutableIntObjectMap3 = mutableIntObjectMapC;
        int i36 = i20;
        MutableIntList mutableIntList8 = mutableIntList4;
        MutableIntList mutableIntList9 = mutableIntList5;
        if (wrapEllipsisInfo2 != null) {
            arrayList.add(wrapEllipsisInfo2.a());
            mutableIntObjectMap = mutableIntObjectMap3;
            mutableIntObjectMap.r(arrayList.size() - 1, wrapEllipsisInfo2.d());
            int i37 = mutableIntList9.f2877b - 1;
            if (wrapEllipsisInfo2.c()) {
                int i38 = mutableIntList9.f2877b - 1;
                mutableIntList8.q(i37, Math.max(mutableIntList8.e(i37), IntIntPair.f(wrapEllipsisInfo2.b())));
                mutableIntList9.q(i38, mutableIntList9.j() + 1);
            } else {
                mutableIntList8.l(IntIntPair.f(wrapEllipsisInfo2.b()));
                mutableIntList9.l(mutableIntList9.j() + 1);
            }
        } else {
            mutableIntObjectMap = mutableIntObjectMap3;
        }
        int size = arrayList.size();
        ?? r2 = new Placeable[size];
        for (int i39 = 0; i39 < size; i39++) {
            r2[i39] = mutableIntObjectMap.b(i39);
        }
        int i40 = mutableIntList9.f2877b;
        int[] iArr3 = new int[i40];
        int[] iArr4 = new int[i40];
        int[] iArr5 = mutableIntList9.f2876a;
        int iMax2 = i36;
        int i41 = 0;
        int i42 = 0;
        int i43 = 0;
        ?? r22 = r2;
        while (i42 < i40) {
            int i44 = iArr5[i42];
            MutableIntList mutableIntList10 = mutableIntList8;
            int iE = mutableIntList10.e(i42);
            int[] iArr6 = iArr3;
            ?? r8 = r22;
            FlowLineMeasurePolicy flowLineMeasurePolicy4 = flowLineMeasurePolicy3;
            ArrayList arrayList2 = arrayList;
            int i45 = i14;
            MeasureResult measureResultA = RowColumnMeasurePolicyKt.a(flowLineMeasurePolicy4, iMax2, Constraints.m(jA), Constraints.l(jA), iE, i45, measureScope3, arrayList2, r8, i41, i44, iArr6, i42);
            if (flowLineMeasurePolicy.b()) {
                height = measureResultA.getWidth();
                width = measureResultA.getHeight();
            } else {
                height = measureResultA.getHeight();
                width = measureResultA.getWidth();
            }
            iArr4[i42] = width;
            i43 += width;
            iMax2 = Math.max(iMax2, height);
            mutableVector.b(measureResultA);
            i42++;
            arrayList = arrayList2;
            r22 = r8;
            i41 = i44;
            iArr3 = iArr6;
            mutableIntList8 = mutableIntList10;
            i14 = i45;
            measureScope3 = measureScope;
            flowLineMeasurePolicy3 = flowLineMeasurePolicy;
        }
        int[] iArr7 = iArr3;
        if (mutableVector.o() == 0) {
            i6 = 0;
            i7 = 0;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            j4 = j3;
            iArr = iArr7;
            iArr2 = iArr4;
        } else {
            i6 = iMax2;
            i7 = i43;
            measureScope2 = measureScope;
            flowLineMeasurePolicy2 = flowLineMeasurePolicy;
            iArr = iArr7;
            iArr2 = iArr4;
            j4 = j3;
        }
        return l(measureScope2, j4, i6, i7, iArr2, mutableVector, flowLineMeasurePolicy2, iArr);
    }

    public static final MultiContentMeasurePolicy g(Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, Alignment.Horizontal horizontal2, int i3, int i4, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i5) {
        if (ComposerKt.M()) {
            ComposerKt.U(-308635847, i5, -1, "androidx.compose.foundation.layout.columnMeasurementMultiContentHelper (FlowLayout.kt:546)");
        }
        boolean Z = ((((i5 & 14) ^ 6) > 4 && composer.Z(vertical)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.Z(horizontal)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.Z(horizontal2)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.e(i3)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && composer.e(i4)) || (i5 & 24576) == 16384) | composer.Z(flowLayoutOverflowState);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(false, horizontal, vertical, vertical.a(), CrossAxisAlignment.f6736a.b(horizontal2), horizontal.a(), i3, i4, flowLayoutOverflowState, null);
            composer.w(flowMeasurePolicy);
            objG = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return flowMeasurePolicy2;
    }

    public static final int h(IntrinsicMeasurable intrinsicMeasurable, boolean z2, int i3) {
        return z2 ? intrinsicMeasurable.d0(i3) : intrinsicMeasurable.k0(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long i(List list, int[] iArr, int[] iArr2, int i3, int i4, int i5, int i6, int i7, FlowLayoutOverflowState flowLayoutOverflowState) {
        if (list.isEmpty()) {
            return IntIntPair.b(0, 0);
        }
        FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i6, flowLayoutOverflowState, OrientationIndependentConstraints.a(0, i3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER), i7, i4, i5, null);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
        int i8 = intrinsicMeasurable != null ? iArr2[0] : 0;
        int i9 = intrinsicMeasurable != null ? iArr[0] : 0;
        int i10 = 0;
        if (flowLayoutBuildingBlocks.b(list.size() > 1, 0, IntIntPair.b(i3, Api.BaseClientBuilder.API_PRIORITY_OTHER), intrinsicMeasurable == null ? null : IntIntPair.a(IntIntPair.b(i9, i8)), 0, 0, 0, false, false).a()) {
            IntIntPair intIntPairF = flowLayoutOverflowState.f(intrinsicMeasurable != null, 0, 0);
            return IntIntPair.b(intIntPairF != null ? IntIntPair.f(intIntPairF.i()) : 0, 0);
        }
        int size = list.size();
        int i11 = i3;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            int i17 = i11 - i9;
            int i18 = i12 + 1;
            int iMax = Math.max(i16, i8);
            IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i18);
            int i19 = intrinsicMeasurable2 != null ? iArr2[i18] : 0;
            int i20 = intrinsicMeasurable2 != null ? iArr[i18] + i4 : 0;
            int i21 = i18 - i14;
            int i22 = i15;
            int i23 = i19;
            int i24 = i20;
            FlowLayoutBuildingBlocks.WrapInfo wrapInfoB = flowLayoutBuildingBlocks.b(i12 + 2 < list.size(), i21, IntIntPair.b(i17, Api.BaseClientBuilder.API_PRIORITY_OTHER), intrinsicMeasurable2 == null ? null : IntIntPair.a(IntIntPair.b(i20, i19)), i22, i10, iMax, false, false);
            if (wrapInfoB.b()) {
                int iF = i10 + iMax + i5;
                FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfoA = flowLayoutBuildingBlocks.a(wrapInfoB, intrinsicMeasurable2 != null, i22, iF, i17, i21);
                int i25 = i24 - i4;
                i15 = i22 + 1;
                if (wrapInfoB.a()) {
                    if (wrapEllipsisInfoA != null) {
                        long jB = wrapEllipsisInfoA.b();
                        if (!wrapEllipsisInfoA.c()) {
                            iF += IntIntPair.f(jB) + i5;
                        }
                    }
                    i10 = iF;
                    i13 = i18;
                } else {
                    i16 = 0;
                    i10 = iF;
                    i9 = i25;
                    i14 = i18;
                    i11 = i3;
                }
            } else {
                i11 = i17;
                i15 = i22;
                i16 = iMax;
                i9 = i24;
            }
            i12 = i18;
            i13 = i12;
            i8 = i23;
        }
        return IntIntPair.b(i10 - i5, i13);
    }

    public static final int j(IntrinsicMeasurable intrinsicMeasurable, boolean z2, int i3) {
        return z2 ? intrinsicMeasurable.k0(i3) : intrinsicMeasurable.d0(i3);
    }

    public static final long k(Measurable measurable, FlowLineMeasurePolicy flowLineMeasurePolicy, long j3, Function1 function1) {
        FlowLayoutData flowLayoutDataC;
        if (RowColumnImplKt.e(RowColumnImplKt.c(measurable)) == 0.0f) {
            RowColumnParentData rowColumnParentDataC = RowColumnImplKt.c(measurable);
            if (((rowColumnParentDataC == null || (flowLayoutDataC = rowColumnParentDataC.c()) == null) ? null : Float.valueOf(flowLayoutDataC.a())) == null) {
                Placeable placeableN0 = measurable.n0(j3);
                function1.invoke(placeableN0);
                return IntIntPair.b(flowLineMeasurePolicy.e(placeableN0), flowLineMeasurePolicy.f(placeableN0));
            }
        }
        int iJ = j(measurable, flowLineMeasurePolicy.b(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
        return IntIntPair.b(iJ, h(measurable, flowLineMeasurePolicy.b(), iJ));
    }

    public static final MeasureResult l(MeasureScope measureScope, long j3, int i3, int i4, int[] iArr, final MutableVector mutableVector, FlowLineMeasurePolicy flowLineMeasurePolicy, int[] iArr2) {
        int iK;
        int i5;
        int i6;
        boolean zB = flowLineMeasurePolicy.b();
        Arrangement.Vertical verticalJ = flowLineMeasurePolicy.j();
        Arrangement.Horizontal horizontalI = flowLineMeasurePolicy.i();
        if (zB) {
            int iZ0 = i4 + (measureScope.z0(verticalJ.a()) * (mutableVector.o() - 1));
            int iM = Constraints.m(j3);
            iK = Constraints.k(j3);
            if (iZ0 < iM) {
                iZ0 = iM;
            }
            if (iZ0 <= iK) {
                iK = iZ0;
            }
            verticalJ.b(measureScope, iK, iArr, iArr2);
        } else {
            int iZ02 = i4 + (measureScope.z0(horizontalI.a()) * (mutableVector.o() - 1));
            int iM2 = Constraints.m(j3);
            int iK2 = Constraints.k(j3);
            if (iZ02 < iM2) {
                iZ02 = iM2;
            }
            int i7 = iZ02 > iK2 ? iK2 : iZ02;
            horizontalI.c(measureScope, i7, iArr, measureScope.getLayoutDirection(), iArr2);
            iK = i7;
        }
        int iN = Constraints.n(j3);
        int iL = Constraints.l(j3);
        if (i3 < iN) {
            i3 = iN;
        }
        if (i3 <= iL) {
            iL = i3;
        }
        if (zB) {
            i6 = iL;
            i5 = iK;
        } else {
            i5 = iL;
            i6 = iK;
        }
        return MeasureScope.B0(measureScope, i6, i5, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutKt$placeHelper$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                MutableVector mutableVector2 = mutableVector;
                Object[] objArr = mutableVector2.f24389a;
                int iO = mutableVector2.o();
                for (int i8 = 0; i8 < iO; i8++) {
                    ((MeasureResult) objArr[i8]).A();
                }
            }
        }, 4, null);
    }

    public static final MultiContentMeasurePolicy m(Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, Alignment.Vertical vertical2, int i3, int i4, FlowLayoutOverflowState flowLayoutOverflowState, Composer composer, int i5) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2010142641, i5, -1, "androidx.compose.foundation.layout.rowMeasurementMultiContentHelper (FlowLayout.kt:484)");
        }
        boolean Z = ((((i5 & 14) ^ 6) > 4 && composer.Z(horizontal)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.Z(vertical)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.Z(vertical2)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.e(i3)) || (i5 & 3072) == 2048) | ((((57344 & i5) ^ 24576) > 16384 && composer.e(i4)) || (i5 & 24576) == 16384) | composer.Z(flowLayoutOverflowState);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            FlowMeasurePolicy flowMeasurePolicy = new FlowMeasurePolicy(true, horizontal, vertical, horizontal.a(), CrossAxisAlignment.f6736a.c(vertical2), vertical.a(), i3, i4, flowLayoutOverflowState, null);
            composer.w(flowMeasurePolicy);
            objG = flowMeasurePolicy;
        }
        FlowMeasurePolicy flowMeasurePolicy2 = (FlowMeasurePolicy) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return flowMeasurePolicy2;
    }

    private static final Measurable n(Iterator it, FlowLineInfo flowLineInfo) {
        try {
            if (!(it instanceof ContextualFlowItemIterator)) {
                return (Measurable) it.next();
            }
            Intrinsics.checkNotNull(flowLineInfo);
            return ((ContextualFlowItemIterator) it).b(flowLineInfo);
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }
}
