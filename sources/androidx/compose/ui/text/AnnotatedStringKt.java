package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class AnnotatedStringKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AnnotatedString f28653a = new AnnotatedString("", null, 2, 0 == true ? 1 : 0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final List d(List list, List list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        if (list2.isEmpty()) {
            return list;
        }
        if (list.isEmpty()) {
            return list2;
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.add((AnnotatedString.Range) list.get(i3));
        }
        int size2 = list2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList.add((AnnotatedString.Range) list2.get(i4));
        }
        return arrayList;
    }

    public static final AnnotatedString e() {
        return f28653a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List f(List list, int i3, int i4) {
        if (!(i3 <= i4)) {
            InlineClassHelperKt.a("start (" + i3 + ") should be less than or equal to end (" + i4 + ')');
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            AnnotatedString.Range range = (AnnotatedString.Range) list.get(i5);
            if (i(i3, i4, range.h(), range.f())) {
                arrayList.add(new AnnotatedString.Range(range.g(), Math.max(i3, range.h()) - i3, Math.min(i4, range.f()) - i3, range.i()));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static final List g(AnnotatedString annotatedString, int i3, int i4, Function1 function1) {
        List listC;
        if (i3 == i4 || (listC = annotatedString.c()) == null) {
            return null;
        }
        if (i3 != 0 || i4 < annotatedString.k().length()) {
            ArrayList arrayList = new ArrayList(listC.size());
            int size = listC.size();
            for (int i5 = 0; i5 < size; i5++) {
                AnnotatedString.Range range = (AnnotatedString.Range) listC.get(i5);
                if ((function1 != null ? ((Boolean) function1.invoke(range.g())).booleanValue() : true) && i(i3, i4, range.h(), range.f())) {
                    arrayList.add(new AnnotatedString.Range((AnnotatedString.Annotation) range.g(), RangesKt.p(range.h(), i3, i4) - i3, RangesKt.p(range.f(), i3, i4) - i3, range.i()));
                }
            }
            return arrayList;
        }
        if (function1 == null) {
            return listC;
        }
        ArrayList arrayList2 = new ArrayList(listC.size());
        int size2 = listC.size();
        for (int i6 = 0; i6 < size2; i6++) {
            Object obj = listC.get(i6);
            if (((Boolean) function1.invoke(((AnnotatedString.Range) obj).g())).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    static /* synthetic */ List h(AnnotatedString annotatedString, int i3, int i4, Function1 function1, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            function1 = null;
        }
        return g(annotatedString, i3, i4, function1);
    }

    public static final boolean i(int i3, int i4, int i5, int i6) {
        return ((i3 < i6) & (i5 < i4)) | (((i3 == i4) | (i5 == i6)) & (i3 == i5));
    }

    public static final List j(AnnotatedString annotatedString, ParagraphStyle paragraphStyle) {
        List listEmptyList;
        List listF = annotatedString.f();
        if (listF == null || (listEmptyList = CollectionsKt.sortedWith(listF, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedStringKt$normalizedParagraphStyles$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Integer.valueOf(((AnnotatedString.Range) obj).h()), Integer.valueOf(((AnnotatedString.Range) obj2).h()));
            }
        })) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayDeque arrayDeque = new ArrayDeque();
        int size = listEmptyList.size();
        int iF = 0;
        for (int i3 = 0; i3 < size; i3++) {
            AnnotatedString.Range range = (AnnotatedString.Range) listEmptyList.get(i3);
            AnnotatedString.Range rangeE = AnnotatedString.Range.e(range, paragraphStyle.l((ParagraphStyle) range.g()), 0, 0, null, 14, null);
            while (iF < rangeE.h() && !arrayDeque.isEmpty()) {
                AnnotatedString.Range range2 = (AnnotatedString.Range) arrayDeque.last();
                if (rangeE.h() < range2.f()) {
                    arrayList.add(new AnnotatedString.Range(range2.g(), iF, rangeE.h()));
                    iF = rangeE.h();
                } else {
                    arrayList.add(new AnnotatedString.Range(range2.g(), iF, range2.f()));
                    iF = range2.f();
                    while (!arrayDeque.isEmpty() && iF == ((AnnotatedString.Range) arrayDeque.last()).f()) {
                        arrayDeque.removeLast();
                    }
                }
            }
            if (iF < rangeE.h()) {
                arrayList.add(new AnnotatedString.Range(paragraphStyle, iF, rangeE.h()));
                iF = rangeE.h();
            }
            AnnotatedString.Range range3 = (AnnotatedString.Range) arrayDeque.lastOrNull();
            if (range3 == null) {
                arrayDeque.add(new AnnotatedString.Range(rangeE.g(), rangeE.h(), rangeE.f()));
            } else if (range3.h() == rangeE.h() && range3.f() == rangeE.f()) {
                arrayDeque.removeLast();
                arrayDeque.add(new AnnotatedString.Range(((ParagraphStyle) range3.g()).l((ParagraphStyle) rangeE.g()), rangeE.h(), rangeE.f()));
            } else if (range3.h() == range3.f()) {
                arrayList.add(new AnnotatedString.Range(range3.g(), range3.h(), range3.f()));
                arrayDeque.removeLast();
                arrayDeque.add(new AnnotatedString.Range(rangeE.g(), rangeE.h(), rangeE.f()));
            } else {
                if (range3.f() < rangeE.f()) {
                    throw new IllegalArgumentException();
                }
                arrayDeque.add(new AnnotatedString.Range(((ParagraphStyle) range3.g()).l((ParagraphStyle) rangeE.g()), rangeE.h(), rangeE.f()));
            }
        }
        while (iF <= annotatedString.k().length() && !arrayDeque.isEmpty()) {
            AnnotatedString.Range range4 = (AnnotatedString.Range) arrayDeque.last();
            arrayList.add(new AnnotatedString.Range(range4.g(), iF, range4.f()));
            iF = range4.f();
            while (!arrayDeque.isEmpty() && iF == ((AnnotatedString.Range) arrayDeque.last()).f()) {
                arrayDeque.removeLast();
            }
        }
        if (iF < annotatedString.k().length()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, iF, annotatedString.k().length()));
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new AnnotatedString.Range(paragraphStyle, 0, 0));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString k(AnnotatedString annotatedString, int i3, int i4) {
        String strSubstring;
        if (i3 != i4) {
            strSubstring = annotatedString.k().substring(i3, i4);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        } else {
            strSubstring = "";
        }
        List listG = g(annotatedString, i3, i4, new Function1<AnnotatedString.Annotation, Boolean>() { // from class: androidx.compose.ui.text.AnnotatedStringKt$substringWithoutParagraphStyles$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(AnnotatedString.Annotation annotation) {
                return Boolean.valueOf(!(annotation instanceof ParagraphStyle));
            }
        });
        if (listG == null) {
            listG = CollectionsKt.emptyList();
        }
        return new AnnotatedString(strSubstring, listG);
    }
}
