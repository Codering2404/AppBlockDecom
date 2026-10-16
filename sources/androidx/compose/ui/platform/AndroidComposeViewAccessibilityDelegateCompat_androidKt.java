package androidx.compose.ui.platform;

import android.content.res.Resources;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidComposeViewAccessibilityDelegateCompat_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Comparator[] f27811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function2 f27812b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27816a;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            try {
                iArr[ToggleableState.f28618a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ToggleableState.f28619b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ToggleableState.f28620c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f27816a = iArr;
        }
    }

    static {
        Comparator[] comparatorArr = new Comparator[2];
        int i3 = 0;
        while (i3 < 2) {
            final Comparator comparator = i3 == 0 ? RtlBoundsComparator.f28197a : LtrBoundsComparator.f28126a;
            final Comparator comparatorB = LayoutNode.T.b();
            final Comparator comparator2 = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$special$$inlined$thenBy$1
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int iCompare = comparator.compare(obj, obj2);
                    return iCompare != 0 ? iCompare : comparatorB.compare(((SemanticsNode) obj).q(), ((SemanticsNode) obj2).q());
                }
            };
            comparatorArr[i3] = new Comparator() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$special$$inlined$thenBy$2
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int iCompare = comparator2.compare(obj, obj2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.d(Integer.valueOf(((SemanticsNode) obj).o()), Integer.valueOf(((SemanticsNode) obj2).o()));
                }
            };
            i3++;
        }
        f27811a = comparatorArr;
        f27812b = new Function2<SemanticsNode, SemanticsNode, Integer>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1
            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Integer invoke(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
                SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
                SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
                return Integer.valueOf(Float.compare(((Number) semanticsConfigurationW.h(semanticsProperties.L(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1.1
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue(), ((Number) semanticsNode2.w().h(semanticsProperties.L(), new Function0<Float>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$UnmergedConfigComparator$1.2
                    @Override // kotlin.jvm.functions.Function0
                    public final Float invoke() {
                        return Float.valueOf(0.0f);
                    }
                })).floatValue()));
            }
        };
    }

    private static final List A(boolean z2, ArrayList arrayList, Resources resources, MutableIntObjectMap mutableIntObjectMap) {
        ArrayList arrayList2 = new ArrayList(arrayList.size() / 2);
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        int size = 0;
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                SemanticsNode semanticsNode = (SemanticsNode) arrayList.get(i3);
                if (i3 == 0 || !x(arrayList2, semanticsNode)) {
                    arrayList2.add(new Pair(semanticsNode.j(), CollectionsKt.mutableListOf(semanticsNode)));
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        CollectionsKt.sortWith(arrayList2, TopBottomBoundsComparator.f28216a);
        ArrayList arrayList3 = new ArrayList();
        Comparator comparator = f27811a[!z2 ? 1 : 0];
        int size2 = arrayList2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            Pair pair = (Pair) arrayList2.get(i4);
            CollectionsKt.sortWith((List) pair.f(), comparator);
            arrayList3.addAll((Collection) pair.f());
        }
        final Function2 function2 = f27812b;
        CollectionsKt.sortWith(arrayList3, new Comparator() { // from class: androidx.compose.ui.platform.j
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return AndroidComposeViewAccessibilityDelegateCompat_androidKt.B(function2, obj, obj2);
            }
        });
        while (size <= CollectionsKt.getLastIndex(arrayList3)) {
            List list = (List) mutableIntObjectMap.b(((SemanticsNode) arrayList3.get(size)).o());
            if (list != null) {
                if (w((SemanticsNode) arrayList3.get(size), resources)) {
                    size++;
                } else {
                    arrayList3.remove(size);
                }
                arrayList3.addAll(size, list);
                size += list.size();
            } else {
                size++;
            }
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int B(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    private static final List C(boolean z2, List list, IntObjectMap intObjectMap, Resources resources) {
        MutableIntObjectMap mutableIntObjectMapC = IntObjectMapKt.c();
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            r((SemanticsNode) list.get(i3), arrayList, mutableIntObjectMapC, intObjectMap, resources);
        }
        return A(z2, arrayList, resources, mutableIntObjectMapC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(AccessibilityAction accessibilityAction, Object obj) {
        if (accessibilityAction == obj) {
            return true;
        }
        if (!(obj instanceof AccessibilityAction)) {
            return false;
        }
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) obj;
        if (!Intrinsics.areEqual(accessibilityAction.b(), accessibilityAction2.b())) {
            return false;
        }
        if (accessibilityAction.a() != null || accessibilityAction2.a() == null) {
            return accessibilityAction.a() == null || accessibilityAction2.a() != null;
        }
        return false;
    }

    private static final String n(SemanticsNode semanticsNode, Resources resources) {
        SemanticsConfiguration semanticsConfigurationN = semanticsNode.a().n();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        Collection collection = (Collection) SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.d());
        if (collection != null && !collection.isEmpty()) {
            return null;
        }
        Collection collection2 = (Collection) SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.H());
        if (collection2 != null && !collection2.isEmpty()) {
            return null;
        }
        CharSequence charSequence = (CharSequence) SemanticsConfigurationKt.a(semanticsConfigurationN, semanticsProperties.g());
        if (charSequence == null || charSequence.length() == 0) {
            return resources.getString(R.string.f25166m);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean o(SemanticsNode semanticsNode) {
        return !semanticsNode.n().d(SemanticsProperties.f28517a.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        if (semanticsConfigurationW.d(semanticsProperties.g()) && !Intrinsics.areEqual(SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.i()), Boolean.TRUE)) {
            return true;
        }
        LayoutNode layoutNodeQ = q(semanticsNode.q(), new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1
            /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Boolean invoke(androidx.compose.ui.node.LayoutNode r3) {
                /*
                    r2 = this;
                    androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.Q()
                    if (r3 == 0) goto L1a
                    boolean r0 = r3.p()
                    r1 = 1
                    if (r0 != r1) goto L1a
                    androidx.compose.ui.semantics.SemanticsProperties r0 = androidx.compose.ui.semantics.SemanticsProperties.f28517a
                    androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.g()
                    boolean r3 = r3.d(r0)
                    if (r3 == 0) goto L1a
                    goto L1b
                L1a:
                    r1 = 0
                L1b:
                    java.lang.Boolean r3 = java.lang.Boolean.valueOf(r1)
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$excludeLineAndPageGranularities$ancestor$1.invoke(androidx.compose.ui.node.LayoutNode):java.lang.Boolean");
            }
        });
        if (layoutNodeQ != null) {
            SemanticsConfiguration semanticsConfigurationQ = layoutNodeQ.Q();
            if (!(semanticsConfigurationQ != null ? Intrinsics.areEqual(SemanticsConfigurationKt.a(semanticsConfigurationQ, semanticsProperties.i()), Boolean.TRUE) : false)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LayoutNode q(LayoutNode layoutNode, Function1 function1) {
        for (LayoutNode layoutNodeB0 = layoutNode.B0(); layoutNodeB0 != null; layoutNodeB0 = layoutNodeB0.B0()) {
            if (((Boolean) function1.invoke(layoutNodeB0)).booleanValue()) {
                return layoutNodeB0;
            }
        }
        return null;
    }

    private static final void r(SemanticsNode semanticsNode, ArrayList arrayList, MutableIntObjectMap mutableIntObjectMap, IntObjectMap intObjectMap, Resources resources) {
        boolean zV = v(semanticsNode);
        boolean zBooleanValue = ((Boolean) semanticsNode.w().h(SemanticsProperties.f28517a.v(), new Function0<Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt$geometryDepthFirstSearch$isTraversalGroup$1
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.FALSE;
            }
        })).booleanValue();
        if ((zBooleanValue || w(semanticsNode, resources)) && intObjectMap.a(semanticsNode.o())) {
            arrayList.add(semanticsNode);
        }
        if (zBooleanValue) {
            mutableIntObjectMap.r(semanticsNode.o(), C(zV, semanticsNode.k(), intObjectMap, resources));
            return;
        }
        List listK = semanticsNode.k();
        int size = listK.size();
        for (int i3 = 0; i3 < size; i3++) {
            r((SemanticsNode) listK.get(i3), arrayList, mutableIntObjectMap, intObjectMap, resources);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean s(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.K());
        Role role = (Role) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.C());
        boolean z2 = toggleableState != null;
        if (((Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.E())) != null) {
            if (!(role != null ? Role.m(role.p(), Role.f28457b.h()) : false)) {
                return true;
            }
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String t(SemanticsNode semanticsNode, Resources resources) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        Object objA = SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.F());
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.K());
        Role role = (Role) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.C());
        if (toggleableState != null) {
            int i3 = WhenMappings.f27816a[toggleableState.ordinal()];
            if (i3 == 1) {
                if ((role == null ? false : Role.m(role.p(), Role.f28457b.g())) && objA == null) {
                    objA = resources.getString(R.string.f25168o);
                }
            } else if (i3 == 2) {
                if ((role == null ? false : Role.m(role.p(), Role.f28457b.g())) && objA == null) {
                    objA = resources.getString(R.string.f25167n);
                }
            } else if (i3 == 3 && objA == null) {
                objA = resources.getString(R.string.f25160g);
            }
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.E());
        if (bool != null) {
            boolean zBooleanValue = bool.booleanValue();
            if (!(role == null ? false : Role.m(role.p(), Role.f28457b.h())) && objA == null) {
                objA = zBooleanValue ? resources.getString(R.string.f25165l) : resources.getString(R.string.f25162i);
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.B());
        if (progressBarRangeInfo != null) {
            if (progressBarRangeInfo != ProgressBarRangeInfo.f28452d.a()) {
                if (objA == null) {
                    ClosedFloatingPointRange closedFloatingPointRangeC = progressBarRangeInfo.c();
                    float fB = ((((Number) closedFloatingPointRangeC.e()).floatValue() - ((Number) closedFloatingPointRangeC.a()).floatValue()) > 0.0f ? 1 : ((((Number) closedFloatingPointRangeC.e()).floatValue() - ((Number) closedFloatingPointRangeC.a()).floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (progressBarRangeInfo.b() - ((Number) closedFloatingPointRangeC.a()).floatValue()) / (((Number) closedFloatingPointRangeC.e()).floatValue() - ((Number) closedFloatingPointRangeC.a()).floatValue());
                    if (fB < 0.0f) {
                        fB = 0.0f;
                    }
                    if (fB > 1.0f) {
                        fB = 1.0f;
                    }
                    if (!(fB == 0.0f)) {
                        iP = (fB == 1.0f ? 1 : 0) != 0 ? 100 : RangesKt.p(Math.round(fB * 100), 1, 99);
                    }
                    objA = resources.getString(R.string.f25171r, Integer.valueOf(iP));
                }
            } else if (objA == null) {
                objA = resources.getString(R.string.f25159f);
            }
        }
        if (semanticsNode.w().d(semanticsProperties.g())) {
            objA = n(semanticsNode, resources);
        }
        return (String) objA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString u(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.g());
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.H());
        return annotatedString == null ? list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null : annotatedString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean v(SemanticsNode semanticsNode) {
        return semanticsNode.p().getLayoutDirection() == LayoutDirection.f30002b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean w(SemanticsNode semanticsNode, Resources resources) {
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f28517a.d());
        return !SemanticsUtils_androidKt.f(semanticsNode) && (semanticsNode.w().p() || (semanticsNode.A() && ((list != null ? (String) CollectionsKt.firstOrNull(list) : null) != null || u(semanticsNode) != null || t(semanticsNode, resources) != null || s(semanticsNode))));
    }

    private static final boolean x(ArrayList arrayList, SemanticsNode semanticsNode) {
        float fR = semanticsNode.j().r();
        float fI = semanticsNode.j().i();
        boolean z2 = fR >= fI;
        int lastIndex = CollectionsKt.getLastIndex(arrayList);
        if (lastIndex >= 0) {
            int i3 = 0;
            while (true) {
                Rect rect = (Rect) ((Pair) arrayList.get(i3)).e();
                boolean z3 = rect.r() >= rect.i();
                if (!z2 && !z3 && Math.max(fR, rect.r()) < Math.min(fI, rect.i())) {
                    arrayList.set(i3, new Pair(rect.w(0.0f, fR, Float.POSITIVE_INFINITY, fI), ((Pair) arrayList.get(i3)).f()));
                    ((List) ((Pair) arrayList.get(i3)).f()).add(semanticsNode);
                    return true;
                }
                if (i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(SemanticsNode semanticsNode, SemanticsConfiguration semanticsConfiguration) {
        Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> it = semanticsConfiguration.iterator();
        while (it.hasNext()) {
            if (!semanticsNode.n().d(it.next().getKey())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(IntObjectMap intObjectMap, MutableIntIntMap mutableIntIntMap, MutableIntIntMap mutableIntIntMap2, Resources resources) {
        mutableIntIntMap.i();
        mutableIntIntMap2.i();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) intObjectMap.b(-1);
        SemanticsNode semanticsNodeB = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.b() : null;
        Intrinsics.checkNotNull(semanticsNodeB);
        List listC = C(v(semanticsNodeB), CollectionsKt.listOf(semanticsNodeB), intObjectMap, resources);
        int lastIndex = CollectionsKt.getLastIndex(listC);
        int i3 = 1;
        if (1 > lastIndex) {
            return;
        }
        while (true) {
            int iO = ((SemanticsNode) listC.get(i3 - 1)).o();
            int iO2 = ((SemanticsNode) listC.get(i3)).o();
            mutableIntIntMap.q(iO, iO2);
            mutableIntIntMap2.q(iO2, iO);
            if (i3 == lastIndex) {
                return;
            } else {
                i3++;
            }
        }
    }
}
