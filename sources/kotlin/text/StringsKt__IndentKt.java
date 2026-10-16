package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.xn.YvFRmou;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    private static final Function1 e(final String str) {
        return str.length() == 0 ? new Function1() { // from class: kotlin.text.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__IndentKt.f((String) obj);
            }
        } : new Function1() { // from class: kotlin.text.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__IndentKt.g(str, (String) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return line;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(String str, String line) {
        Intrinsics.checkNotNullParameter(line, "line");
        return str + line;
    }

    private static final int h(String str) {
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (!CharsKt__CharJVMKt.b(str.charAt(i3))) {
                break;
            }
            i3++;
        }
        return i3 == -1 ? str.length() : i3;
    }

    public static String i(String str, final String indent) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(indent, "indent");
        return SequencesKt.K(SequencesKt.M(StringsKt__StringsKt.w0(str), new Function1() { // from class: kotlin.text.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringsKt__IndentKt.k(indent, (String) obj);
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String k(String str, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (StringsKt__StringsKt.p0(it)) {
            return it.length() < str.length() ? str : it;
        }
        return str + it;
    }

    public static final String l(String str, String newIndent) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        List listX0 = StringsKt__StringsKt.x0(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listX0) {
            if (!StringsKt__StringsKt.p0((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Object obj2 = arrayList.get(i4);
            i4++;
            arrayList2.add(Integer.valueOf(h((String) obj2)));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) arrayList2);
        int iIntValue = num != null ? num.intValue() : 0;
        int length = str.length() + (newIndent.length() * listX0.size());
        Function1 function1E = e(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(listX0);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : listX0) {
            int i5 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj3;
            if ((i3 == 0 || i3 == lastIndex) && StringsKt__StringsKt.p0(str3)) {
                str3 = null;
            } else {
                String strW1 = StringsKt___StringsKt.w1(str3, iIntValue);
                if (strW1 != null && (str2 = (String) function1E.invoke(strW1)) != null) {
                    str3 = str2;
                }
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i3 = i5;
        }
        return ((StringBuilder) CollectionsKt___CollectionsKt.joinTo(arrayList3, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }

    public static String n(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return l(str, "");
    }

    public static final String o(String str, String marginPrefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        return m(str, "", marginPrefix);
    }

    public static /* synthetic */ String p(String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }

    public static final String m(String str, String newIndent, String marginPrefix) {
        String str2;
        String str3;
        Intrinsics.checkNotNullParameter(str, YvFRmou.hgcHJydstfnR);
        Intrinsics.checkNotNullParameter(newIndent, "newIndent");
        Intrinsics.checkNotNullParameter(marginPrefix, "marginPrefix");
        if (StringsKt__StringsKt.p0(marginPrefix)) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        List listX0 = StringsKt__StringsKt.x0(str);
        int length = str.length() + (newIndent.length() * listX0.size());
        Function1 function1E = e(newIndent);
        int lastIndex = CollectionsKt.getLastIndex(listX0);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : listX0) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str4 = (String) obj;
            String strSubstring = null;
            if ((i3 == 0 || i3 == lastIndex) && StringsKt__StringsKt.p0(str4)) {
                str2 = marginPrefix;
                str4 = null;
            } else {
                int length2 = str4.length();
                int i5 = 0;
                while (true) {
                    if (i5 >= length2) {
                        i5 = -1;
                        break;
                    }
                    if (!CharsKt__CharJVMKt.b(str4.charAt(i5))) {
                        break;
                    }
                    i5++;
                }
                if (i5 == -1) {
                    str2 = marginPrefix;
                } else {
                    int i6 = i5;
                    str2 = marginPrefix;
                    if (StringsKt__StringsJVMKt.T(str4, str2, i6, false, 4, null)) {
                        int length3 = str2.length() + i6;
                        Intrinsics.checkNotNull(str4, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str4.substring(length3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                }
                if (strSubstring != null && (str3 = (String) function1E.invoke(strSubstring)) != null) {
                    str4 = str3;
                }
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i3 = i4;
            marginPrefix = str2;
        }
        return ((StringBuilder) CollectionsKt___CollectionsKt.joinTo(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
    }
}
