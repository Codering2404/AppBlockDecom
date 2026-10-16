package androidx.compose.ui.text;

import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.compose.ui.text.style.TextIndent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class AnnotatedString implements CharSequence {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f28632f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Saver f28633g = SaversKt.h();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f28634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f28635b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f28636c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f28637d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Annotation {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ExhaustiveAnnotation implements Annotation {
    }

    public AnnotatedString(List list, String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        this.f28634a = list;
        this.f28635b = str;
        if (list != null) {
            int size = list.size();
            arrayList = null;
            arrayList2 = null;
            for (int i3 = 0; i3 < size; i3++) {
                Range range = (Range) list.get(i3);
                if (range.g() instanceof SpanStyle) {
                    arrayList = arrayList == null ? new ArrayList() : arrayList;
                    Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                    arrayList.add(range);
                } else if (range.g() instanceof ParagraphStyle) {
                    arrayList2 = arrayList2 == null ? new ArrayList() : arrayList2;
                    Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.ParagraphStyle>");
                    arrayList2.add(range);
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
        }
        this.f28636c = arrayList;
        this.f28637d = arrayList2;
        List listSortedWith = arrayList2 != null ? CollectionsKt.sortedWith(arrayList2, new Comparator() { // from class: androidx.compose.ui.text.AnnotatedString$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(Integer.valueOf(((AnnotatedString.Range) obj).h()), Integer.valueOf(((AnnotatedString.Range) obj2).h()));
            }
        }) : null;
        List list2 = listSortedWith;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        MutableIntList mutableIntListE = IntListKt.e(((Range) CollectionsKt.first(listSortedWith)).f());
        int size2 = listSortedWith.size();
        for (int i4 = 1; i4 < size2; i4++) {
            Range range2 = (Range) listSortedWith.get(i4);
            while (true) {
                if (mutableIntListE.f2877b == 0) {
                    break;
                }
                int iJ = mutableIntListE.j();
                if (range2.h() >= iJ) {
                    mutableIntListE.p(mutableIntListE.f2877b - 1);
                } else if (!(range2.f() <= iJ)) {
                    InlineClassHelperKt.a("Paragraph overlap not allowed, end " + range2.f() + " should be less than or equal to " + iJ);
                }
            }
            mutableIntListE.l(range2.f());
        }
    }

    public final AnnotatedString a(Function1 function1) {
        Builder builder = new Builder(this);
        builder.m(function1);
        return builder.t();
    }

    public char b(int i3) {
        return this.f28635b.charAt(i3);
    }

    public final List c() {
        return this.f28634a;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return b(i3);
    }

    public int d() {
        return this.f28635b.length();
    }

    public final List e(int i3, int i4) {
        List listEmptyList;
        List list = this.f28634a;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = list.get(i5);
                Range range = (Range) obj;
                if ((range.g() instanceof LinkAnnotation) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.LinkAnnotation>>");
        return listEmptyList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AnnotatedString)) {
            return false;
        }
        AnnotatedString annotatedString = (AnnotatedString) obj;
        return Intrinsics.areEqual(this.f28635b, annotatedString.f28635b) && Intrinsics.areEqual(this.f28634a, annotatedString.f28634a);
    }

    public final List f() {
        return this.f28637d;
    }

    public final List g() {
        List list = this.f28636c;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final List h() {
        return this.f28636c;
    }

    public int hashCode() {
        int iHashCode = this.f28635b.hashCode() * 31;
        List list = this.f28634a;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final List i(int i3, int i4) {
        List list = this.f28634a;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Range range = (Range) list.get(i5);
            if ((range.g() instanceof StringAnnotation) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                arrayList.add(StringAnnotationKt.a(range));
            }
        }
        return arrayList;
    }

    public final List j(String str, int i3, int i4) {
        List list = this.f28634a;
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Range range = (Range) list.get(i5);
            if ((range.g() instanceof StringAnnotation) && Intrinsics.areEqual(str, range.i()) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                arrayList.add(StringAnnotationKt.a(range));
            }
        }
        return arrayList;
    }

    public final String k() {
        return this.f28635b;
    }

    public final List l(int i3, int i4) {
        List listEmptyList;
        List list = this.f28634a;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = list.get(i5);
                Range range = (Range) obj;
                if ((range.g() instanceof TtsAnnotation) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.TtsAnnotation>>");
        return listEmptyList;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return d();
    }

    public final List m(int i3, int i4) {
        List listEmptyList;
        List list = this.f28634a;
        if (list != null) {
            listEmptyList = new ArrayList(list.size());
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = list.get(i5);
                Range range = (Range) obj;
                if ((range.g() instanceof UrlAnnotation) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                    listEmptyList.add(obj);
                }
            }
        } else {
            listEmptyList = CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNull(listEmptyList, "null cannot be cast to non-null type kotlin.collections.List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.UrlAnnotation>>");
        return listEmptyList;
    }

    public final boolean n(AnnotatedString annotatedString) {
        return Intrinsics.areEqual(this.f28634a, annotatedString.f28634a);
    }

    public final boolean o(int i3, int i4) {
        List list = this.f28634a;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range range = (Range) list.get(i5);
                if ((range.g() instanceof LinkAnnotation) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean p(String str, int i3, int i4) {
        List list = this.f28634a;
        if (list != null) {
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Range range = (Range) list.get(i5);
                if ((range.g() instanceof StringAnnotation) && Intrinsics.areEqual(str, range.i()) && AnnotatedStringKt.i(i3, i4, range.h(), range.f())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final AnnotatedString q(Function1 function1) {
        Builder builder = new Builder(this);
        builder.o(function1);
        return builder.t();
    }

    public final AnnotatedString r(AnnotatedString annotatedString) {
        Builder builder = new Builder(this);
        builder.j(annotatedString);
        return builder.t();
    }

    @Override // java.lang.CharSequence
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public AnnotatedString subSequence(int i3, int i4) {
        if (!(i3 <= i4)) {
            InlineClassHelperKt.a("start (" + i3 + ") should be less or equal to end (" + i4 + ')');
        }
        if (i3 == 0 && i4 == this.f28635b.length()) {
            return this;
        }
        String strSubstring = this.f28635b.substring(i3, i4);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return new AnnotatedString(AnnotatedStringKt.f(this.f28634a, i3, i4), strSubstring);
    }

    public final AnnotatedString t(long j3) {
        return subSequence(TextRange.l(j3), TextRange.k(j3));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f28635b;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final StringBuilder f28638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f28639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final List f28640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final BulletScope f28641d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BulletScope {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Builder f28642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final List f28643b = new ArrayList();

            public BulletScope(Builder builder) {
                this.f28642a = builder;
            }
        }

        public Builder(int i3) {
            this.f28638a = new StringBuilder(i3);
            this.f28639b = new ArrayList();
            this.f28640c = new ArrayList();
            this.f28641d = new BulletScope(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void a(Bullet bullet, long j3, int i3, int i4) {
            Object[] objArr = 0 == true ? 1 : 0;
            this.f28640c.add(new MutableRange(new ParagraphStyle(0, 0, 0L, new TextIndent(j3, j3, null), objArr, null, 0, 0, null, 503, null), i3, i4, null, 8, 0 == true ? 1 : 0));
            this.f28640c.add(new MutableRange(bullet, i3, i4, 0 == true ? 1 : 0, 8, null));
        }

        public final void b(LinkAnnotation.Clickable clickable, int i3, int i4) {
            this.f28640c.add(new MutableRange(clickable, i3, i4, null, 8, null));
        }

        public final void c(LinkAnnotation.Url url, int i3, int i4) {
            this.f28640c.add(new MutableRange(url, i3, i4, null, 8, null));
        }

        public final void d(String str, String str2, int i3, int i4) {
            this.f28640c.add(new MutableRange(StringAnnotation.a(StringAnnotation.b(str2)), i3, i4, str));
        }

        public final void e(ParagraphStyle paragraphStyle, int i3, int i4) {
            this.f28640c.add(new MutableRange(paragraphStyle, i3, i4, null, 8, null));
        }

        public final void f(SpanStyle spanStyle, int i3, int i4) {
            this.f28640c.add(new MutableRange(spanStyle, i3, i4, null, 8, null));
        }

        @Override // java.lang.Appendable
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Builder append(char c3) {
            this.f28638a.append(c3);
            return this;
        }

        @Override // java.lang.Appendable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Builder append(CharSequence charSequence) {
            if (charSequence instanceof AnnotatedString) {
                j((AnnotatedString) charSequence);
                return this;
            }
            this.f28638a.append(charSequence);
            return this;
        }

        @Override // java.lang.Appendable
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Builder append(CharSequence charSequence, int i3, int i4) {
            if (charSequence instanceof AnnotatedString) {
                k((AnnotatedString) charSequence, i3, i4);
                return this;
            }
            this.f28638a.append(charSequence, i3, i4);
            return this;
        }

        public final void j(AnnotatedString annotatedString) {
            int length = this.f28638a.length();
            this.f28638a.append(annotatedString.k());
            List listC = annotatedString.c();
            if (listC != null) {
                int size = listC.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Range range = (Range) listC.get(i3);
                    this.f28640c.add(new MutableRange(range.g(), range.h() + length, range.f() + length, range.i()));
                }
            }
        }

        public final void k(AnnotatedString annotatedString, int i3, int i4) {
            int length = this.f28638a.length();
            this.f28638a.append((CharSequence) annotatedString.k(), i3, i4);
            List listH = AnnotatedStringKt.h(annotatedString, i3, i4, null, 4, null);
            if (listH != null) {
                int size = listH.size();
                for (int i5 = 0; i5 < size; i5++) {
                    Range range = (Range) listH.get(i5);
                    this.f28640c.add(new MutableRange(range.g(), range.h() + length, range.f() + length, range.i()));
                }
            }
        }

        public final void l(String str) {
            this.f28638a.append(str);
        }

        public final void m(Function1 function1) {
            List list = this.f28640c;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                List list2 = (List) function1.invoke(MutableRange.c((MutableRange) list.get(i3), 0, 1, null));
                ArrayList arrayList2 = new ArrayList(list2.size());
                int size2 = list2.size();
                for (int i4 = 0; i4 < size2; i4++) {
                    arrayList2.add(MutableRange.f28644e.a((Range) list2.get(i4)));
                }
                CollectionsKt.addAll(arrayList, arrayList2);
            }
            this.f28640c.clear();
            this.f28640c.addAll(arrayList);
        }

        public final int n() {
            return this.f28638a.length();
        }

        public final void o(Function1 function1) {
            int size = this.f28640c.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.f28640c.set(i3, MutableRange.f28644e.a((Range) function1.invoke(MutableRange.c((MutableRange) this.f28640c.get(i3), 0, 1, null))));
            }
        }

        public final void p() {
            if (this.f28639b.isEmpty()) {
                InlineClassHelperKt.c("Nothing to pop.");
            }
            ((MutableRange) this.f28639b.remove(r0.size() - 1)).a(this.f28638a.length());
        }

        public final void q(int i3) {
            if (!(i3 < this.f28639b.size())) {
                InlineClassHelperKt.c(i3 + " should be less than " + this.f28639b.size());
            }
            while (this.f28639b.size() - 1 >= i3) {
                p();
            }
        }

        public final int r(LinkAnnotation linkAnnotation) {
            MutableRange mutableRange = new MutableRange(linkAnnotation, this.f28638a.length(), 0, null, 12, null);
            this.f28639b.add(mutableRange);
            this.f28640c.add(mutableRange);
            return this.f28639b.size() - 1;
        }

        public final int s(SpanStyle spanStyle) {
            MutableRange mutableRange = new MutableRange(spanStyle, this.f28638a.length(), 0, null, 12, null);
            this.f28639b.add(mutableRange);
            this.f28640c.add(mutableRange);
            return this.f28639b.size() - 1;
        }

        public final AnnotatedString t() {
            String string = this.f28638a.toString();
            List list = this.f28640c;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                arrayList.add(((MutableRange) list.get(i3)).b(this.f28638a.length()));
            }
            return new AnnotatedString(string, arrayList);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class MutableRange<T> {

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final Companion f28644e = new Companion(null);

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f28645a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f28646b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f28647c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final String f28648d;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                public final MutableRange a(Range range) {
                    return new MutableRange(range.g(), range.h(), range.f(), range.i());
                }

                private Companion() {
                }
            }

            public MutableRange(Object obj, int i3, int i4, String str) {
                this.f28645a = obj;
                this.f28646b = i3;
                this.f28647c = i4;
                this.f28648d = str;
            }

            public static /* synthetic */ Range c(MutableRange mutableRange, int i3, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return mutableRange.b(i3);
            }

            public final void a(int i3) {
                this.f28647c = i3;
            }

            public final Range b(int i3) {
                int i4 = this.f28647c;
                if (i4 != Integer.MIN_VALUE) {
                    i3 = i4;
                }
                if (!(i3 != Integer.MIN_VALUE)) {
                    InlineClassHelperKt.c("Item.end should be set first");
                }
                return new Range(this.f28645a, this.f28646b, i3, this.f28648d);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MutableRange)) {
                    return false;
                }
                MutableRange mutableRange = (MutableRange) obj;
                return Intrinsics.areEqual(this.f28645a, mutableRange.f28645a) && this.f28646b == mutableRange.f28646b && this.f28647c == mutableRange.f28647c && Intrinsics.areEqual(this.f28648d, mutableRange.f28648d);
            }

            public int hashCode() {
                Object obj = this.f28645a;
                return ((((((obj == null ? 0 : obj.hashCode()) * 31) + Integer.hashCode(this.f28646b)) * 31) + Integer.hashCode(this.f28647c)) * 31) + this.f28648d.hashCode();
            }

            public String toString() {
                return "MutableRange(item=" + this.f28645a + ", start=" + this.f28646b + ", end=" + this.f28647c + ", tag=" + this.f28648d + ')';
            }

            public /* synthetic */ MutableRange(Object obj, int i3, int i4, String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
                this(obj, i3, (i5 & 4) != 0 ? Integer.MIN_VALUE : i4, (i5 & 8) != 0 ? "" : str);
            }
        }

        public /* synthetic */ Builder(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 16 : i3);
        }

        public Builder(String str) {
            this(0, 1, null);
            l(str);
        }

        public Builder(AnnotatedString annotatedString) {
            this(0, 1, null);
            j(annotatedString);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Range<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f28649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f28650b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f28651c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f28652d;

        public Range(Object obj, int i3, int i4, String str) {
            this.f28649a = obj;
            this.f28650b = i3;
            this.f28651c = i4;
            this.f28652d = str;
            if (i3 <= i4) {
                return;
            }
            InlineClassHelperKt.a("Reversed range is not supported");
        }

        public static /* synthetic */ Range e(Range range, Object obj, int i3, int i4, String str, int i5, Object obj2) {
            if ((i5 & 1) != 0) {
                obj = range.f28649a;
            }
            if ((i5 & 2) != 0) {
                i3 = range.f28650b;
            }
            if ((i5 & 4) != 0) {
                i4 = range.f28651c;
            }
            if ((i5 & 8) != 0) {
                str = range.f28652d;
            }
            return range.d(obj, i3, i4, str);
        }

        public final Object a() {
            return this.f28649a;
        }

        public final int b() {
            return this.f28650b;
        }

        public final int c() {
            return this.f28651c;
        }

        public final Range d(Object obj, int i3, int i4, String str) {
            return new Range(obj, i3, i4, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Range)) {
                return false;
            }
            Range range = (Range) obj;
            return Intrinsics.areEqual(this.f28649a, range.f28649a) && this.f28650b == range.f28650b && this.f28651c == range.f28651c && Intrinsics.areEqual(this.f28652d, range.f28652d);
        }

        public final int f() {
            return this.f28651c;
        }

        public final Object g() {
            return this.f28649a;
        }

        public final int h() {
            return this.f28650b;
        }

        public int hashCode() {
            Object obj = this.f28649a;
            return ((((((obj == null ? 0 : obj.hashCode()) * 31) + Integer.hashCode(this.f28650b)) * 31) + Integer.hashCode(this.f28651c)) * 31) + this.f28652d.hashCode();
        }

        public final String i() {
            return this.f28652d;
        }

        public String toString() {
            return "Range(item=" + this.f28649a + ", start=" + this.f28650b + ", end=" + this.f28651c + ", tag=" + this.f28652d + ')';
        }

        public Range(Object obj, int i3, int i4) {
            this(obj, i3, i4, "");
        }
    }

    public /* synthetic */ AnnotatedString(String str, List list, List list2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list2);
    }

    public AnnotatedString(String str, List list, List list2) {
        this(AnnotatedStringKt.d(list, list2), str);
    }

    public /* synthetic */ AnnotatedString(String str, List list, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AnnotatedString(String str, List list) {
        List list2 = list;
        this(list2.isEmpty() ? null : list2, str);
    }
}
