package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f144082b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f144083a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f144084a = new ArrayList(20);

        public final Builder a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.f144082b;
            companion.d(name);
            companion.e(value, name);
            d(name, value);
            return this;
        }

        public final Builder b(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            int size = headers.size();
            for (int i3 = 0; i3 < size; i3++) {
                d(headers.d(i3), headers.h(i3));
            }
            return this;
        }

        public final Builder c(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            int iM0 = StringsKt.m0(line, ':', 1, false, 4, null);
            if (iM0 != -1) {
                String strSubstring = line.substring(0, iM0);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                String strSubstring2 = line.substring(iM0 + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                d(strSubstring, strSubstring2);
                return this;
            }
            if (line.charAt(0) != ':') {
                d("", line);
                return this;
            }
            String strSubstring3 = line.substring(1);
            Intrinsics.checkNotNullExpressionValue(strSubstring3, "this as java.lang.String).substring(startIndex)");
            d("", strSubstring3);
            return this;
        }

        public final Builder d(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            h().add(name);
            h().add(StringsKt.t1(value).toString());
            return this;
        }

        public final Builder e(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Headers.f144082b.d(name);
            d(name, value);
            return this;
        }

        public final Headers f() {
            Object[] array = this.f144084a.toArray(new String[0]);
            if (array != null) {
                return new Headers((String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        public final String g(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int size = this.f144084a.size() - 2;
            int iC = ProgressionUtilKt.c(size, 0, -2);
            if (iC > size) {
                return null;
            }
            while (true) {
                int i3 = size - 2;
                if (StringsKt.F(name, (String) this.f144084a.get(size), true)) {
                    return (String) this.f144084a.get(size + 1);
                }
                if (size == iC) {
                    return null;
                }
                size = i3;
            }
        }

        public final List h() {
            return this.f144084a;
        }

        public final Builder i(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            int i3 = 0;
            while (i3 < h().size()) {
                if (StringsKt.F(name, (String) h().get(i3), true)) {
                    h().remove(i3);
                    h().remove(i3);
                    i3 -= 2;
                }
                i3 += 2;
            }
            return this;
        }

        public final Builder j(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Companion companion = Headers.f144082b;
            companion.d(name);
            companion.e(value, name);
            i(name);
            d(name, value);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (str.length() <= 0) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                char cCharAt = str.charAt(i3);
                if ('!' > cCharAt || cCharAt >= 127) {
                    throw new IllegalArgumentException(Util.t("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i3), str).toString());
                }
                i3 = i4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str, String str2) {
            int length = str.length();
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && (' ' > cCharAt || cCharAt >= 127)) {
                    throw new IllegalArgumentException(Intrinsics.stringPlus(Util.t("Unexpected char %#04x at %d in %s value", Integer.valueOf(cCharAt), Integer.valueOf(i3), str2), Util.H(str2) ? "" : Intrinsics.stringPlus(": ", str)).toString());
                }
                i3 = i4;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(String[] strArr, String str) {
            int length = strArr.length - 2;
            int iC = ProgressionUtilKt.c(length, 0, -2);
            if (iC > length) {
                return null;
            }
            while (true) {
                int i3 = length - 2;
                if (StringsKt.F(str, strArr[length], true)) {
                    return strArr[length + 1];
                }
                if (length == iC) {
                    return null;
                }
                length = i3;
            }
        }

        public final Headers g(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            if (namesAndValues.length % 2 != 0) {
                throw new IllegalArgumentException("Expected alternating header names and values");
            }
            String[] strArr = (String[]) namesAndValues.clone();
            int length = strArr.length;
            int i3 = 0;
            int i4 = 0;
            while (i4 < length) {
                int i5 = i4 + 1;
                String str = strArr[i4];
                if (str == null) {
                    throw new IllegalArgumentException("Headers cannot be null");
                }
                strArr[i4] = StringsKt.t1(str).toString();
                i4 = i5;
            }
            int iC = ProgressionUtilKt.c(0, strArr.length - 1, 2);
            if (iC >= 0) {
                while (true) {
                    int i6 = i3 + 2;
                    String str2 = strArr[i3];
                    String str3 = strArr[i3 + 1];
                    d(str2);
                    e(str3, str2);
                    if (i3 == iC) {
                        break;
                    }
                    i3 = i6;
                }
            }
            return new Headers(strArr, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Headers(String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(strArr);
    }

    public static final Headers g(String... strArr) {
        return f144082b.g(strArr);
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return f144082b.f(this.f144083a, name);
    }

    public final Date b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String strA = a(name);
        if (strA == null) {
            return null;
        }
        return DatesKt.a(strA);
    }

    public final String d(int i3) {
        return this.f144083a[i3 * 2];
    }

    public final Set e() {
        TreeSet treeSet = new TreeSet(StringsKt.H(StringCompanionObject.f140150a));
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            treeSet.add(d(i3));
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(treeSet);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Headers) && Arrays.equals(this.f144083a, ((Headers) obj).f144083a);
    }

    public final Builder f() {
        Builder builder = new Builder();
        CollectionsKt.addAll(builder.h(), this.f144083a);
        return builder;
    }

    public final String h(int i3) {
        return this.f144083a[(i3 * 2) + 1];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f144083a);
    }

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int size = size();
        Pair[] pairArr = new Pair[size];
        for (int i3 = 0; i3 < size; i3++) {
            pairArr[i3] = TuplesKt.a(d(i3), h(i3));
        }
        return ArrayIteratorKt.a(pairArr);
    }

    public final List l(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int size = size();
        ArrayList arrayList = null;
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            if (StringsKt.F(name, d(i3), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(h(i3));
            }
            i3 = i4;
        }
        if (arrayList == null) {
            return CollectionsKt.emptyList();
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "{\n      Collections.unmodifiableList(result)\n    }");
        return listUnmodifiableList;
    }

    public final int size() {
        return this.f144083a.length / 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            String strD = d(i3);
            String strH = h(i3);
            sb.append(strD);
            sb.append(": ");
            if (Util.H(strD)) {
                strH = "██";
            }
            sb.append(strH);
            sb.append("\n");
            i3 = i4;
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    private Headers(String[] strArr) {
        this.f144083a = strArr;
    }
}
