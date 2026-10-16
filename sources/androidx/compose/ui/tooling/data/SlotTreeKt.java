package androidx.compose.ui.tooling.data;

import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.unit.IntRect;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SlotTreeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final IntRect f29936a = new IntRect(0, 0, 0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f29937b = new Regex("(\\d+)|([,])|([*])|([:])|L|(P\\([^)]*\\))|(C(\\(([^)]*)\\))?)|@");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Regex f29938c = new Regex("(\\d+)|,|[!P()]|:([^,!)]+)");

    private static final String A(String str, String str2, String str3) {
        if (!StringsKt.U(str, str2, false, 2, null)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str3);
        String strSubstring = str.substring(str2.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.ui.tooling.data.SourceInformationContext B(java.lang.String r14, androidx.compose.ui.tooling.data.SourceInformationContext r15) throws androidx.compose.ui.tooling.data.ParseError {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.data.SlotTreeKt.B(java.lang.String, androidx.compose.ui.tooling.data.SourceInformationContext):androidx.compose.ui.tooling.data.SourceInformationContext");
    }

    private static final MatchResult C(Ref.ObjectRef objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        if (matchResult != null) {
            objectRef.f140144a = matchResult.next();
        }
        return (MatchResult) objectRef.f140144a;
    }

    private static final SourceLocationInfo D(Ref.ObjectRef objectRef) {
        Integer numValueOf;
        Integer numValueOf2;
        Integer numValueOf3;
        try {
            MatchResult matchResultC = (MatchResult) objectRef.f140144a;
            if (matchResultC == null || !n(matchResultC)) {
                numValueOf = null;
            } else {
                numValueOf = Integer.valueOf(p(matchResultC) + 1);
                matchResultC = C(objectRef);
            }
            if (matchResultC != null && k(matchResultC, "@")) {
                MatchResult matchResultC2 = C(objectRef);
                if (matchResultC2 != null && n(matchResultC2)) {
                    numValueOf3 = Integer.valueOf(p(matchResultC2));
                    MatchResult matchResultC3 = C(objectRef);
                    if (matchResultC3 != null && k(matchResultC3, "L")) {
                        MatchResult matchResultC4 = C(objectRef);
                        if (matchResultC4 != null && n(matchResultC4)) {
                            numValueOf2 = Integer.valueOf(p(matchResultC4));
                        }
                        return null;
                    }
                    numValueOf2 = null;
                }
                return null;
            }
            numValueOf2 = null;
            numValueOf3 = null;
            if (numValueOf != null && numValueOf3 != null && numValueOf2 != null) {
                return new SourceLocationInfo(numValueOf, numValueOf3, numValueOf2);
            }
        } catch (ParseError unused) {
        }
        return null;
    }

    public static final IntRect E(IntRect intRect, IntRect intRect2) {
        IntRect intRect3 = f29936a;
        if (Intrinsics.areEqual(intRect, intRect3)) {
            return intRect2;
        }
        if (Intrinsics.areEqual(intRect2, intRect3)) {
            return intRect;
        }
        return new IntRect(Math.min(intRect.g(), intRect2.g()), Math.min(intRect.j(), intRect2.j()), Math.max(intRect.h(), intRect2.h()), Math.max(intRect.d(), intRect2.d()));
    }

    private static final Field a(Class cls, String str) {
        Field field;
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                field = null;
                break;
            }
            field = declaredFields[i3];
            if (Intrinsics.areEqual(field.getName(), str)) {
                break;
            }
            i3++;
        }
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        return field;
    }

    public static final Group b(CompositionData compositionData) {
        Group groupG;
        CompositionGroup compositionGroup = (CompositionGroup) CollectionsKt.firstOrNull(compositionData.b());
        return (compositionGroup == null || (groupG = g(compositionGroup, null)) == null) ? EmptyGroup.f29914i : groupG;
    }

    private static final IntRect c(LayoutInfo layoutInfo) {
        LayoutCoordinates layoutCoordinatesX = layoutInfo.x();
        if (!layoutInfo.m() || !layoutCoordinatesX.m()) {
            return new IntRect(0, 0, layoutInfo.getWidth(), layoutInfo.getHeight());
        }
        long jG = LayoutCoordinatesKt.g(layoutCoordinatesX);
        long jA = layoutCoordinatesX.a();
        int iD = MathKt.d(Float.intBitsToFloat((int) (jG >> 32)));
        int iD2 = MathKt.d(Float.intBitsToFloat((int) (jG & 4294967295L)));
        return new IntRect(iD, iD2, ((int) (jA >> 32)) + iD, ((int) (jA & 4294967295L)) + iD2);
    }

    private static final String d(MatchResult matchResult) {
        return (String) matchResult.b().get(8);
    }

    private static final List e(List list, SourceInformationContext sourceInformationContext) {
        int i3;
        Object next;
        Object obj;
        int iIntValue;
        int iIntValue2;
        List listEmptyList;
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (true) {
                i3 = 2;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next != null && StringsKt.E(next.getClass().getName(), ".RecomposeScopeImpl", false, 2, null)) {
                    break;
                }
            }
            if (next != null) {
                try {
                    Field fieldA = a(next.getClass(), "block");
                    if (fieldA != null && (obj = fieldA.get(next)) != null) {
                        Class<?> cls = obj.getClass();
                        Field fieldA2 = a(cls, "$$default");
                        Field fieldA3 = a(cls, "$$changed");
                        if (fieldA2 != null) {
                            Object obj2 = fieldA2.get(obj);
                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
                            iIntValue = ((Integer) obj2).intValue();
                        } else {
                            iIntValue = 0;
                        }
                        if (fieldA3 != null) {
                            Object obj3 = fieldA3.get(obj);
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Int");
                            iIntValue2 = ((Integer) obj3).intValue();
                        } else {
                            iIntValue2 = 0;
                        }
                        Field[] declaredFields = cls.getDeclaredFields();
                        ArrayList arrayList = new ArrayList();
                        for (Field field : declaredFields) {
                            if (StringsKt.U(field.getName(), "$", false, 2, null) && !StringsKt.U(field.getName(), "$$", false, 2, null) && !StringsKt.U(field.getName(), "$jacoco", false, 2, null)) {
                                arrayList.add(field);
                            }
                        }
                        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: androidx.compose.ui.tooling.data.SlotTreeKt$extractParameterInfo$$inlined$sortedBy$1
                            @Override // java.util.Comparator
                            public final int compare(Object obj4, Object obj5) {
                                return ComparisonsKt.d(((Field) obj4).getName(), ((Field) obj5).getName());
                            }
                        });
                        ArrayList arrayList2 = new ArrayList();
                        if (sourceInformationContext == null || (listEmptyList = sourceInformationContext.c()) == null) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        int size = listSortedWith.size();
                        int i4 = 0;
                        while (i4 < size) {
                            Parameter parameter = i4 < listEmptyList.size() ? (Parameter) listEmptyList.get(i4) : new Parameter(i4, null, i3, null);
                            if (parameter.b() < listSortedWith.size()) {
                                Field field2 = (Field) listSortedWith.get(parameter.b());
                                field2.setAccessible(true);
                                Object obj4 = field2.get(obj);
                                boolean z2 = ((1 << i4) & iIntValue) != 0;
                                int i5 = (i4 * 3) + 1;
                                int i6 = ((7 << i5) & iIntValue2) >> i5;
                                int i7 = i6 & 3;
                                boolean z3 = i7 == 3;
                                boolean z4 = i7 == 0;
                                boolean z5 = (i6 & 4) == 0;
                                String strSubstring = field2.getName().substring(1);
                                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                                arrayList2.add(new ParameterInformation(strSubstring, obj4, z2, z3, z4 && !z2, parameter.a(), z5));
                            }
                            i4++;
                            i3 = 2;
                        }
                        return arrayList2;
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    public static final IntRect f() {
        return f29936a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.String] */
    private static final Group g(CompositionGroup compositionGroup, SourceInformationContext sourceInformationContext) throws ParseError {
        SourceInformationContext sourceInformationContextB;
        SourceLocation sourceLocation;
        IntRect intRectC;
        Object key = compositionGroup.getKey();
        String strA = compositionGroup.a();
        if (strA != null) {
            sourceInformationContextB = B(strA, sourceInformationContext);
            sourceLocation = null;
        } else {
            sourceInformationContextB = null;
            sourceLocation = null;
        }
        Object node = compositionGroup.getNode();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        CollectionsKt.addAll(arrayList, compositionGroup.getData());
        Iterator it = compositionGroup.b().iterator();
        while (it.hasNext()) {
            arrayList2.add(g((CompositionGroup) it.next(), sourceInformationContextB));
        }
        boolean z2 = node instanceof LayoutInfo;
        List listW = z2 ? ((LayoutInfo) node).w() : CollectionsKt.emptyList();
        if (z2) {
            intRectC = c((LayoutInfo) node);
        } else if (arrayList2.isEmpty()) {
            intRectC = f29936a;
        } else {
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            int size = arrayList2.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList2.get(i3);
                i3++;
                arrayList3.add(((Group) obj).a());
            }
            Iterator it2 = arrayList3.iterator();
            if (!it2.hasNext()) {
                throw new UnsupportedOperationException("Empty collection can't be reduced.");
            }
            Object next = it2.next();
            while (it2.hasNext()) {
                next = E((IntRect) it2.next(), (IntRect) next);
            }
            intRectC = (IntRect) next;
        }
        SourceLocation sourceLocationG = (sourceInformationContextB == null || !sourceInformationContextB.e() || sourceInformationContext == null) ? sourceLocation : sourceInformationContext.g();
        if (node != null) {
            return new NodeGroup(key, node, intRectC, arrayList, listW, arrayList2);
        }
        Object objD = sourceLocation;
        IntRect intRect = intRectC;
        SourceInformationContext sourceInformationContext2 = sourceInformationContextB;
        Object objA = sourceInformationContext2 != null ? sourceInformationContext2.a() : objD;
        ?? A = sourceInformationContext2 != null ? sourceInformationContext2.a() : objD;
        if (A != 0 && A.length() != 0 && (intRect.d() - intRect.j() > 0 || intRect.h() - intRect.g() > 0)) {
            objD = compositionGroup.d();
        }
        return new CallGroup(key, objA, intRect, sourceLocationG, objD, e(arrayList, sourceInformationContext2), arrayList, arrayList2, sourceInformationContext2 != null && sourceInformationContext2.f());
    }

    private static final String h(MatchResult matchResult) {
        return (String) matchResult.b().get(0);
    }

    private static final boolean i(MatchResult matchResult) {
        return matchResult.d().get(1) != null;
    }

    private static final boolean j(MatchResult matchResult) {
        return matchResult.d().get(6) != null;
    }

    private static final boolean k(MatchResult matchResult, String str) {
        return Intrinsics.areEqual(h(matchResult), str);
    }

    private static final boolean l(MatchResult matchResult) {
        return matchResult.d().get(2) != null;
    }

    private static final boolean m(MatchResult matchResult) {
        return matchResult.d().get(4) != null;
    }

    private static final boolean n(MatchResult matchResult) {
        return matchResult.d().get(1) != null;
    }

    private static final boolean o(MatchResult matchResult) {
        return matchResult.d().get(5) != null;
    }

    private static final int p(MatchResult matchResult) {
        return y((String) matchResult.b().get(1));
    }

    private static final List q(String str) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = Regex.e(f29938c, str, 0, 2, null);
        List listMutableListOf = CollectionsKt.mutableListOf(0, 1, 2, 3);
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = listMutableListOf.size() - 1;
        ArrayList arrayList = new ArrayList();
        try {
            s(objectRef, "P");
            s(objectRef, "(");
            while (!v(objectRef, ")")) {
                if (v(objectRef, "!")) {
                    x(objectRef);
                    int iU = u(objectRef);
                    r(intRef, listMutableListOf, arrayList.size() + iU);
                    for (int i3 = 0; i3 < iU; i3++) {
                        arrayList.add(new Parameter(((Number) CollectionsKt.first(listMutableListOf)).intValue(), null, 2, null));
                        listMutableListOf.remove(0);
                    }
                } else if (v(objectRef, ",")) {
                    x(objectRef);
                } else {
                    int iU2 = u(objectRef);
                    arrayList.add(new Parameter(iU2, w(objectRef) ? t(objectRef) : null));
                    r(intRef, listMutableListOf, iU2);
                    listMutableListOf.remove(Integer.valueOf(iU2));
                }
            }
            s(objectRef, ")");
            while (listMutableListOf.size() > 0) {
                arrayList.add(new Parameter(((Number) CollectionsKt.first(listMutableListOf)).intValue(), null, 2, null));
                listMutableListOf.remove(0);
            }
            return arrayList;
        } catch (ParseError unused) {
            return CollectionsKt.emptyList();
        } catch (NumberFormatException unused2) {
            return CollectionsKt.emptyList();
        }
    }

    private static final void r(Ref.IntRef intRef, List list, int i3) {
        int i4 = i3 - intRef.f140142a;
        if (i4 > 0) {
            if (i4 < 4) {
                i4 = 4;
            }
            for (int i5 = 0; i5 < i4; i5++) {
                list.add(Integer.valueOf(intRef.f140142a + i5 + 1));
            }
            intRef.f140142a += i4;
        }
    }

    private static final void s(Ref.ObjectRef objectRef, String str) throws ParseError {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        if (matchResult == null || !Intrinsics.areEqual(h(matchResult), str)) {
            throw new ParseError();
        }
        x(objectRef);
    }

    private static final String t(Ref.ObjectRef objectRef) throws ParseError {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        if (matchResult == null || !l(matchResult)) {
            throw new ParseError();
        }
        x(objectRef);
        String strSubstring = h(matchResult).substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return A(strSubstring, "c#", "androidx.compose.");
    }

    private static final int u(Ref.ObjectRef objectRef) throws ParseError {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        if (matchResult == null || !i(matchResult)) {
            throw new ParseError();
        }
        x(objectRef);
        return y(h(matchResult));
    }

    private static final boolean v(Ref.ObjectRef objectRef, String str) {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        return matchResult == null || Intrinsics.areEqual(h(matchResult), str);
    }

    private static final boolean w(Ref.ObjectRef objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        return matchResult != null && l(matchResult);
    }

    private static final MatchResult x(Ref.ObjectRef objectRef) {
        MatchResult matchResult = (MatchResult) objectRef.f140144a;
        if (matchResult != null) {
            objectRef.f140144a = matchResult.next();
        }
        return (MatchResult) objectRef.f140144a;
    }

    private static final int y(String str) throws ParseError {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }

    private static final int z(String str, int i3) throws ParseError {
        try {
            return Integer.parseInt(str, CharsKt.checkRadix(i3));
        } catch (NumberFormatException unused) {
            throw new ParseError();
        }
    }
}
