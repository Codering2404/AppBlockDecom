package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
final class FlowMeasurePolicy implements MultiContentMeasurePolicy, FlowLineMeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f6926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Arrangement.Horizontal f6927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Arrangement.Vertical f6928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f6929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CrossAxisAlignment f6930e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f6931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FlowLayoutOverflowState f6934i;

    public /* synthetic */ FlowMeasurePolicy(boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f3, CrossAxisAlignment crossAxisAlignment, float f4, int i3, int i4, FlowLayoutOverflowState flowLayoutOverflowState, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, horizontal, vertical, f3, crossAxisAlignment, f4, i3, i4, flowLayoutOverflowState);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public boolean b() {
        return this.f6926a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowMeasurePolicy)) {
            return false;
        }
        FlowMeasurePolicy flowMeasurePolicy = (FlowMeasurePolicy) obj;
        return this.f6926a == flowMeasurePolicy.f6926a && Intrinsics.areEqual(this.f6927b, flowMeasurePolicy.f6927b) && Intrinsics.areEqual(this.f6928c, flowMeasurePolicy.f6928c) && Dp.i(this.f6929d, flowMeasurePolicy.f6929d) && Intrinsics.areEqual(this.f6930e, flowMeasurePolicy.f6930e) && Dp.i(this.f6931f, flowMeasurePolicy.f6931f) && this.f6932g == flowMeasurePolicy.f6932g && this.f6933h == flowMeasurePolicy.f6933h && Intrinsics.areEqual(this.f6934i, flowMeasurePolicy.f6934i);
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public CrossAxisAlignment g() {
        return this.f6930e;
    }

    public int hashCode() {
        return (((((((((((((((Boolean.hashCode(this.f6926a) * 31) + this.f6927b.hashCode()) * 31) + this.f6928c.hashCode()) * 31) + Dp.j(this.f6929d)) * 31) + this.f6930e.hashCode()) * 31) + Dp.j(this.f6931f)) * 31) + Integer.hashCode(this.f6932g)) * 31) + Integer.hashCode(this.f6933h)) * 31) + this.f6934i.hashCode();
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Horizontal i() {
        return this.f6927b;
    }

    @Override // androidx.compose.foundation.layout.FlowLineMeasurePolicy
    public Arrangement.Vertical j() {
        return this.f6928c;
    }

    public final int l(List list, int i3, int i4, int i5, int i6, int i7, FlowLayoutOverflowState flowLayoutOverflowState) {
        long jB;
        int i8 = 0;
        if (list.isEmpty()) {
            jB = IntIntPair.b(0, 0);
        } else {
            FlowLayoutBuildingBlocks flowLayoutBuildingBlocks = new FlowLayoutBuildingBlocks(i6, flowLayoutOverflowState, OrientationIndependentConstraints.a(0, i3, 0, Api.BaseClientBuilder.API_PRIORITY_OTHER), i7, i4, i5, null);
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, 0);
            int iO = intrinsicMeasurable != null ? o(intrinsicMeasurable, i3) : 0;
            int iQ = intrinsicMeasurable != null ? q(intrinsicMeasurable, iO) : 0;
            int i9 = 0;
            if (flowLayoutBuildingBlocks.b(list.size() > 1, 0, IntIntPair.b(i3, Api.BaseClientBuilder.API_PRIORITY_OTHER), intrinsicMeasurable == null ? null : IntIntPair.a(IntIntPair.b(iQ, iO)), 0, 0, 0, false, false).a()) {
                IntIntPair intIntPairF = flowLayoutOverflowState.f(intrinsicMeasurable != null, 0, 0);
                jB = IntIntPair.b(intIntPairF != null ? IntIntPair.f(intIntPairF.i()) : 0, 0);
            } else {
                int size = list.size();
                int i10 = i3;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    int i16 = i10 - iQ;
                    int i17 = i11 + 1;
                    int iMax = Math.max(i15, iO);
                    IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.getOrNull(list, i17);
                    int iO2 = intrinsicMeasurable2 != null ? o(intrinsicMeasurable2, i3) : i8;
                    int iQ2 = intrinsicMeasurable2 != null ? q(intrinsicMeasurable2, iO2) + i4 : i8;
                    boolean z2 = i11 + 2 < list.size();
                    int i18 = i17 - i13;
                    int i19 = i14;
                    int i20 = iQ2;
                    int i21 = iO2;
                    FlowLayoutBuildingBlocks.WrapInfo wrapInfoB = flowLayoutBuildingBlocks.b(z2, i18, IntIntPair.b(i16, Api.BaseClientBuilder.API_PRIORITY_OTHER), intrinsicMeasurable2 == null ? null : IntIntPair.a(IntIntPair.b(iQ2, iO2)), i19, i9, iMax, false, false);
                    if (wrapInfoB.b()) {
                        int iF = i9 + iMax + i5;
                        FlowLayoutBuildingBlocks.WrapEllipsisInfo wrapEllipsisInfoA = flowLayoutBuildingBlocks.a(wrapInfoB, intrinsicMeasurable2 != null, i19, iF, i16, i18);
                        int i22 = i20 - i4;
                        i14 = i19 + 1;
                        if (wrapInfoB.a()) {
                            if (wrapEllipsisInfoA != null) {
                                long jB2 = wrapEllipsisInfoA.b();
                                if (!wrapEllipsisInfoA.c()) {
                                    iF += IntIntPair.f(jB2) + i5;
                                }
                            }
                            i9 = iF;
                            i12 = i17;
                        } else {
                            i9 = iF;
                            iQ = i22;
                            i13 = i17;
                            i15 = 0;
                            i10 = i3;
                        }
                    } else {
                        i10 = i16;
                        i14 = i19;
                        i15 = iMax;
                        iQ = i20;
                    }
                    iO = i21;
                    i11 = i17;
                    i12 = i11;
                    i8 = 0;
                }
                jB = IntIntPair.b(i9 - i5, i12);
            }
        }
        return IntIntPair.e(jB);
    }

    public final int m(List list, int i3, int i4) {
        int i5 = this.f6932g;
        int size = list.size();
        int i6 = 0;
        int iMax = 0;
        int i7 = 0;
        int i8 = 0;
        while (i6 < size) {
            int iN = n((IntrinsicMeasurable) list.get(i6), i3) + i4;
            int i9 = i6 + 1;
            if (i9 - i7 == i5 || i9 == list.size()) {
                iMax = Math.max(iMax, (i8 + iN) - i4);
                i8 = 0;
                i7 = i6;
            } else {
                i8 += iN;
            }
            i6 = i9;
        }
        return iMax;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.f6934i;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.p(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, b(), ConstraintsKt.b(0, i3, 0, 0, 13, null));
        if (b()) {
            List listEmptyList = (List) CollectionsKt.firstOrNull(list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return l(listEmptyList, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
        }
        List listEmptyList2 = (List) CollectionsKt.firstOrNull(list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return m(listEmptyList2, i3, intrinsicMeasureScope.z0(this.f6929d));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.f6934i;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.p(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, b(), ConstraintsKt.b(0, 0, 0, i3, 7, null));
        if (b()) {
            List listEmptyList = (List) CollectionsKt.firstOrNull(list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return m(listEmptyList, i3, intrinsicMeasureScope.z0(this.f6929d));
        }
        List listEmptyList2 = (List) CollectionsKt.firstOrNull(list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return l(listEmptyList2, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo47measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        if (this.f6933h == 0 || this.f6932g == 0 || list.isEmpty() || (Constraints.k(j3) == 0 && this.f6934i.l() != FlowLayoutOverflow.OverflowType.f6866a)) {
            return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$1
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        List list2 = (List) CollectionsKt.first(list);
        if (list2.isEmpty()) {
            return MeasureScope.B0(measureScope, 0, 0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FlowMeasurePolicy$measure$2
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }, 4, null);
        }
        List list3 = (List) CollectionsKt.getOrNull(list, 1);
        Measurable measurable = list3 != null ? (Measurable) CollectionsKt.firstOrNull(list3) : null;
        List list4 = (List) CollectionsKt.getOrNull(list, 2);
        Measurable measurable2 = list4 != null ? (Measurable) CollectionsKt.firstOrNull(list4) : null;
        this.f6934i.m(list2.size());
        this.f6934i.o(this, measurable, measurable2, j3);
        return FlowLayoutKt.f(measureScope, this, list2.iterator(), this.f6929d, this.f6931f, OrientationIndependentConstraints.c(j3, b() ? LayoutOrientation.f6996a : LayoutOrientation.f6997b), this.f6932g, this.f6933h, this.f6934i);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.f6934i;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.p(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, b(), ConstraintsKt.b(0, i3, 0, 0, 13, null));
        if (b()) {
            List listEmptyList = (List) CollectionsKt.firstOrNull(list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return l(listEmptyList, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
        }
        List listEmptyList2 = (List) CollectionsKt.firstOrNull(list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return p(listEmptyList2, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        FlowLayoutOverflowState flowLayoutOverflowState = this.f6934i;
        List list2 = (List) CollectionsKt.getOrNull(list, 1);
        IntrinsicMeasurable intrinsicMeasurable = list2 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2) : null;
        List list3 = (List) CollectionsKt.getOrNull(list, 2);
        flowLayoutOverflowState.p(intrinsicMeasurable, list3 != null ? (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3) : null, b(), ConstraintsKt.b(0, 0, 0, i3, 7, null));
        if (b()) {
            List listEmptyList = (List) CollectionsKt.firstOrNull(list);
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            return p(listEmptyList, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
        }
        List listEmptyList2 = (List) CollectionsKt.firstOrNull(list);
        if (listEmptyList2 == null) {
            listEmptyList2 = CollectionsKt.emptyList();
        }
        return l(listEmptyList2, i3, intrinsicMeasureScope.z0(this.f6929d), intrinsicMeasureScope.z0(this.f6931f), this.f6932g, this.f6933h, this.f6934i);
    }

    public final int n(IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return b() ? intrinsicMeasurable.l0(i3) : intrinsicMeasurable.I(i3);
    }

    public final int o(IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return b() ? intrinsicMeasurable.d0(i3) : intrinsicMeasurable.k0(i3);
    }

    public final int p(List list, int i3, int i4, int i5, int i6, int i7, FlowLayoutOverflowState flowLayoutOverflowState) {
        List list2 = list;
        int i8 = i6;
        int i9 = i7;
        if (list2.isEmpty()) {
            return 0;
        }
        int size = list2.size();
        int[] iArr = new int[size];
        int size2 = list2.size();
        int[] iArr2 = new int[size2];
        int size3 = list2.size();
        for (int i10 = 0; i10 < size3; i10++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list2.get(i10);
            int iQ = q(intrinsicMeasurable, i3);
            iArr[i10] = iQ;
            iArr2[i10] = o(intrinsicMeasurable, iQ);
        }
        int i11 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i9 != Integer.MAX_VALUE && i8 != Integer.MAX_VALUE) {
            i11 = i8 * i9;
        }
        int iMin = Math.min(i11 - (((i11 >= list2.size() || !(flowLayoutOverflowState.l() == FlowLayoutOverflow.OverflowType.f6868c || flowLayoutOverflowState.l() == FlowLayoutOverflow.OverflowType.f6869d)) && (i11 < list2.size() || i9 < flowLayoutOverflowState.i() || flowLayoutOverflowState.l() != FlowLayoutOverflow.OverflowType.f6869d)) ? 0 : 1), list2.size());
        int iSum = ArraysKt.sum(iArr) + ((list2.size() - 1) * i4);
        if (size2 == 0) {
            throw new NoSuchElementException();
        }
        int iE = iArr2[0];
        IntIterator it = new IntRange(1, ArraysKt.getLastIndex(iArr2)).iterator();
        while (it.hasNext()) {
            int i12 = iArr2[it.nextInt()];
            if (iE < i12) {
                iE = i12;
            }
        }
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int i13 = iArr[0];
        IntIterator it2 = new IntRange(1, ArraysKt.getLastIndex(iArr)).iterator();
        while (it2.hasNext()) {
            int i14 = iArr[it2.nextInt()];
            if (i13 < i14) {
                i13 = i14;
            }
        }
        int i15 = i13;
        int i16 = iSum;
        while (i15 <= i16 && iE != i3) {
            int i17 = (i15 + i16) / 2;
            long jI = FlowLayoutKt.i(list2, iArr, iArr2, i17, i4, i5, i8, i9, flowLayoutOverflowState);
            iE = IntIntPair.e(jI);
            int iF = IntIntPair.f(jI);
            if (iE > i3 || iF < iMin) {
                i15 = i17 + 1;
                if (i15 > i16) {
                    return i15;
                }
            } else {
                if (iE >= i3) {
                    return i17;
                }
                i16 = i17 - 1;
            }
            list2 = list;
            i8 = i6;
            i9 = i7;
            iSum = i17;
        }
        return iSum;
    }

    public final int q(IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return b() ? intrinsicMeasurable.k0(i3) : intrinsicMeasurable.d0(i3);
    }

    public String toString() {
        return "FlowMeasurePolicy(isHorizontal=" + this.f6926a + ", horizontalArrangement=" + this.f6927b + ", verticalArrangement=" + this.f6928c + ", mainAxisSpacing=" + ((Object) Dp.k(this.f6929d)) + ", crossAxisAlignment=" + this.f6930e + ", crossAxisArrangementSpacing=" + ((Object) Dp.k(this.f6931f)) + ", maxItemsInMainAxis=" + this.f6932g + ", maxLines=" + this.f6933h + ", overflow=" + this.f6934i + ')';
    }

    private FlowMeasurePolicy(boolean z2, Arrangement.Horizontal horizontal, Arrangement.Vertical vertical, float f3, CrossAxisAlignment crossAxisAlignment, float f4, int i3, int i4, FlowLayoutOverflowState flowLayoutOverflowState) {
        this.f6926a = z2;
        this.f6927b = horizontal;
        this.f6928c = vertical;
        this.f6929d = f3;
        this.f6930e = crossAxisAlignment;
        this.f6931f = f4;
        this.f6932g = i3;
        this.f6933h = i4;
        this.f6934i = flowLayoutOverflowState;
    }
}
