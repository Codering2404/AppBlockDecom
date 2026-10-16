package androidx.compose.material3;

import androidx.compose.material3.ListItemType;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.AlignmentLineKt;
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
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicHeight$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f18100a = new AnonymousClass1();

        AnonymousClass1() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicHeight", "maxIntrinsicHeight(I)I", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return q((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer q(IntrinsicMeasurable intrinsicMeasurable, int i3) {
            return Integer.valueOf(intrinsicMeasurable.I(i3));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$maxIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C03291 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C03291 f18101a = new C03291();

        C03291() {
            super(2, IntrinsicMeasurable.class, "maxIntrinsicWidth", "maxIntrinsicWidth(I)I", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return q((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer q(IntrinsicMeasurable intrinsicMeasurable, int i3) {
            return Integer.valueOf(intrinsicMeasurable.l0(i3));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicHeight$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C03301 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C03301 f18102a = new C03301();

        C03301() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicHeight", "minIntrinsicHeight(I)I", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return q((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer q(IntrinsicMeasurable intrinsicMeasurable, int i3) {
            return Integer.valueOf(intrinsicMeasurable.d0(i3));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material3.ListItemMeasurePolicy$minIntrinsicWidth$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    /* synthetic */ class C03311 extends FunctionReferenceImpl implements Function2<IntrinsicMeasurable, Integer, Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C03311 f18103a = new C03311();

        C03311() {
            super(2, IntrinsicMeasurable.class, "minIntrinsicWidth", "minIntrinsicWidth(I)I", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return q((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
        }

        public final Integer q(IntrinsicMeasurable intrinsicMeasurable, int i3) {
            return Integer.valueOf(intrinsicMeasurable.k0(i3));
        }
    }

    private final int a(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        int iIntValue;
        int iIntValue2;
        List list2 = (List) list.get(0);
        List list3 = (List) list.get(1);
        List list4 = (List) list.get(2);
        List list5 = (List) list.get(3);
        List list6 = (List) list.get(4);
        int iT = ListItemKt.t(i3, intrinsicMeasureScope.z0(Dp.g(ListItemKt.p() + ListItemKt.o())));
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list5);
        if (intrinsicMeasurable != null) {
            iIntValue = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(iT))).intValue();
            iT = ListItemKt.t(iT, intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
        } else {
            iIntValue = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list6);
        if (intrinsicMeasurable2 != null) {
            iIntValue2 = ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(iT))).intValue();
            iT = ListItemKt.t(iT, intrinsicMeasurable2.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
        } else {
            iIntValue2 = 0;
        }
        Object obj = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        int iIntValue3 = obj != null ? ((Number) function2.invoke(obj, Integer.valueOf(iT))).intValue() : 0;
        Object obj2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list4);
        int iIntValue4 = obj2 != null ? ((Number) function2.invoke(obj2, Integer.valueOf(iT))).intValue() : 0;
        int iD = ListItemType.f18104b.d(iIntValue3 > 0, iIntValue4 > 0, ListItemKt.r(intrinsicMeasureScope, iIntValue4));
        Object obj3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2);
        return ListItemKt.l(intrinsicMeasureScope, iIntValue, iIntValue2, obj3 != null ? ((Number) function2.invoke(obj3, Integer.valueOf(i3))).intValue() : 0, iIntValue3, iIntValue4, iD, intrinsicMeasureScope.z0(Dp.g(ListItemKt.u(iD) * 2)), ConstraintsKt.b(0, 0, 0, 0, 15, null));
    }

    private final int b(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        List list2 = (List) list.get(0);
        List list3 = (List) list.get(1);
        List list4 = (List) list.get(2);
        List list5 = (List) list.get(3);
        List list6 = (List) list.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list5);
        int iIntValue = intrinsicMeasurable != null ? ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i3))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list6);
        int iIntValue2 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i3))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list2);
        int iIntValue3 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i3))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list3);
        int iIntValue4 = intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i3))).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull(list4);
        return ListItemKt.m(intrinsicMeasureScope, iIntValue, iIntValue2, iIntValue3, iIntValue4, intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i3))).intValue() : 0, intrinsicMeasureScope.z0(Dp.g(ListItemKt.p() + ListItemKt.o())), ConstraintsKt.b(0, 0, 0, 0, 15, null));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return a(intrinsicMeasureScope, list, i3, AnonymousClass1.f18100a);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return b(intrinsicMeasureScope, list, i3, C03291.f18101a);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo47measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        long j4;
        Placeable placeableN0;
        float f3;
        List list2;
        long j5;
        Placeable placeableN02;
        int i3;
        Placeable placeableN03;
        List list3 = (List) list.get(0);
        List list4 = (List) list.get(1);
        List list5 = (List) list.get(2);
        List list6 = (List) list.get(3);
        List list7 = (List) list.get(4);
        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
        float fP = ListItemKt.p();
        float fO = ListItemKt.o();
        int iZ0 = measureScope.z0(Dp.g(fP + fO));
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull(list6);
        int iK0 = measurable != null ? measurable.k0(Constraints.k(j3)) : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull(list7);
        int iT = ListItemKt.t(Constraints.l(jD), iK0 + (measurable2 != null ? measurable2.k0(Constraints.k(j3)) : 0) + iZ0);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull(list5);
        boolean zR = ListItemKt.r(measureScope, measurable3 != null ? measurable3.d0(iT) : 0);
        ListItemType.Companion companion = ListItemType.f18104b;
        float f4 = 2;
        long jI = ConstraintsKt.i(jD, -iZ0, -measureScope.z0(Dp.g(ListItemKt.u(companion.d(CollectionsKt.firstOrNull(list4) != null, CollectionsKt.firstOrNull(list5) != null, zR)) * f4)));
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull(list6);
        Placeable placeableN04 = measurable4 != null ? measurable4.n0(jI) : null;
        int iV = TextFieldImplKt.v(placeableN04);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull(list7);
        if (measurable5 != null) {
            j4 = jI;
            placeableN0 = measurable5.n0(ConstraintsKt.j(j4, -iV, 0, 2, null));
        } else {
            j4 = jI;
            placeableN0 = null;
        }
        int iV2 = iV + TextFieldImplKt.v(placeableN0);
        Measurable measurable6 = (Measurable) CollectionsKt.firstOrNull(list3);
        if (measurable6 != null) {
            list2 = list5;
            f3 = f4;
            j5 = j4;
            placeableN02 = measurable6.n0(ConstraintsKt.j(j4, -iV2, 0, 2, null));
        } else {
            f3 = f4;
            list2 = list5;
            j5 = j4;
            placeableN02 = null;
        }
        int iT2 = TextFieldImplKt.t(placeableN02);
        Measurable measurable7 = (Measurable) CollectionsKt.firstOrNull(list2);
        if (measurable7 != null) {
            i3 = iT2;
            placeableN03 = measurable7.n0(ConstraintsKt.i(j5, -iV2, -iT2));
        } else {
            i3 = iT2;
            placeableN03 = null;
        }
        int iT3 = i3 + TextFieldImplKt.t(placeableN03);
        boolean z2 = (placeableN03 == null || placeableN03.p0(AlignmentLineKt.a()) == placeableN03.p0(AlignmentLineKt.b())) ? false : true;
        Measurable measurable8 = (Measurable) CollectionsKt.firstOrNull(list4);
        Placeable placeableN05 = measurable8 != null ? measurable8.n0(ConstraintsKt.i(j5, -iV2, -iT3)) : null;
        int iD = companion.d(placeableN05 != null, placeableN03 != null, z2);
        float fU = ListItemKt.u(iD);
        return ListItemKt.s(measureScope, ListItemKt.m(measureScope, TextFieldImplKt.v(placeableN04), TextFieldImplKt.v(placeableN0), TextFieldImplKt.v(placeableN02), TextFieldImplKt.v(placeableN05), TextFieldImplKt.v(placeableN03), iZ0, j3), ListItemKt.l(measureScope, TextFieldImplKt.t(placeableN04), TextFieldImplKt.t(placeableN0), TextFieldImplKt.t(placeableN02), TextFieldImplKt.t(placeableN05), TextFieldImplKt.t(placeableN03), iD, measureScope.z0(Dp.g(fU * f3)), j3), placeableN04, placeableN0, placeableN02, placeableN05, placeableN03, ListItemType.h(iD, companion.b()), measureScope.z0(fP), measureScope.z0(fO), measureScope.z0(fU));
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return a(intrinsicMeasureScope, list, i3, C03301.f18102a);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return b(intrinsicMeasureScope, list, i3, C03311.f18103a);
    }
}
