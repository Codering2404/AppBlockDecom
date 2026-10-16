package kotlin.text;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
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
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static /* synthetic */ String A0(String str, int i3, char c3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            c3 = ' ';
        }
        return z0(str, i3, c3);
    }

    public static final CharSequence B0(CharSequence charSequence, int i3, char c3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException("Desired length " + i3 + " is less than zero.");
        }
        if (i3 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i3);
        int length = i3 - charSequence.length();
        int i4 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c3);
                if (i4 == length) {
                    break;
                }
                i4++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String C0(String str, int i3, char c3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return B0(str, i3, c3).toString();
    }

    private static final Sequence D0(CharSequence charSequence, final char[] cArr, int i3, final boolean z2, int i4) {
        Q0(i4);
        return new DelimitedRangesSequence(charSequence, i3, i4, new Function2() { // from class: kotlin.text.g
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.H0(cArr, z2, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    private static final Sequence E0(CharSequence charSequence, String[] strArr, int i3, final boolean z2, int i4) {
        Q0(i4);
        final List listAsList = ArraysKt.asList(strArr);
        return new DelimitedRangesSequence(charSequence, i3, i4, new Function2() { // from class: kotlin.text.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StringsKt__StringsKt.I0(listAsList, z2, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    static /* synthetic */ Sequence F0(CharSequence charSequence, char[] cArr, int i3, boolean z2, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return D0(charSequence, cArr, i3, z2, i4);
    }

    static /* synthetic */ Sequence G0(CharSequence charSequence, String[] strArr, int i3, boolean z2, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i3 = 0;
        }
        if ((i5 & 4) != 0) {
            z2 = false;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return E0(charSequence, strArr, i3, z2, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair H0(char[] cArr, boolean z2, CharSequence DelimitedRangesSequence, int i3) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iO0 = o0(DelimitedRangesSequence, cArr, i3, z2);
        if (iO0 < 0) {
            return null;
        }
        return TuplesKt.a(Integer.valueOf(iO0), 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair I0(List list, boolean z2, CharSequence DelimitedRangesSequence, int i3) {
        Intrinsics.checkNotNullParameter(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        Pair pairG0 = g0(DelimitedRangesSequence, list, i3, z2, false);
        if (pairG0 != null) {
            return TuplesKt.a(pairG0.e(), Integer.valueOf(((String) pairG0.f()).length()));
        }
        return null;
    }

    public static final boolean J0(CharSequence charSequence, int i3, CharSequence other, int i4, int i5, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i4 < 0 || i3 < 0 || i3 > charSequence.length() - i5 || i4 > other.length() - i5) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!CharsKt__CharKt.g(charSequence.charAt(i3 + i6), other.charAt(i4 + i6), z2)) {
                return false;
            }
        }
        return true;
    }

    public static String K0(String str, CharSequence prefix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        if (!Z0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String M0(String str, CharSequence delimiter) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        return N0(str, delimiter, delimiter);
    }

    public static final String N0(String str, CharSequence prefix, CharSequence suffix) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        if (str.length() < prefix.length() + suffix.length() || !Z0(str, prefix, false, 2, null) || !f0(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length(), str.length() - suffix.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static CharSequence O0(CharSequence charSequence, int i3, int i4, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        if (i4 >= i3) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i3);
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            sb.append(replacement);
            sb.append(charSequence, i4, charSequence.length());
            Intrinsics.checkNotNullExpressionValue(sb, "append(...)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i4 + ") is less than start index (" + i3 + ").");
    }

    public static CharSequence P0(CharSequence charSequence, IntRange range, CharSequence replacement) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(replacement, "replacement");
        return O0(charSequence, range.a().intValue(), range.e().intValue() + 1, replacement);
    }

    public static final void Q0(int i3) {
        if (i3 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3).toString());
    }

    public static final List R0(CharSequence charSequence, char[] delimiters, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return T0(charSequence, String.valueOf(delimiters[0]), z2, i3);
        }
        Iterable iterableQ = SequencesKt.q(F0(charSequence, delimiters, 0, z2, i3, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableQ, 10));
        Iterator it = iterableQ.iterator();
        while (it.hasNext()) {
            arrayList.add(a1(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    public static List S0(CharSequence charSequence, String[] delimiters, boolean z2, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return T0(charSequence, str, z2, i3);
            }
        }
        Iterable iterableQ = SequencesKt.q(G0(charSequence, delimiters, 0, z2, i3, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterableQ, 10));
        Iterator it = iterableQ.iterator();
        while (it.hasNext()) {
            arrayList.add(a1(charSequence, (IntRange) it.next()));
        }
        return arrayList;
    }

    private static final List T0(CharSequence charSequence, String str, boolean z2, int i3) {
        Q0(i3);
        int length = 0;
        int iJ0 = j0(charSequence, str, 0, z2);
        if (iJ0 == -1 || i3 == 1) {
            return CollectionsKt.listOf(charSequence.toString());
        }
        boolean z3 = i3 > 0;
        ArrayList arrayList = new ArrayList(z3 ? RangesKt.k(i3, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iJ0).toString());
            length = str.length() + iJ0;
            if (z3 && arrayList.size() == i3 - 1) {
                break;
            }
            iJ0 = j0(charSequence, str, length, z2);
        } while (iJ0 != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List U0(CharSequence charSequence, char[] cArr, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return R0(charSequence, cArr, z2, i3);
    }

    public static /* synthetic */ List V0(CharSequence charSequence, String[] strArr, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z2 = false;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return S0(charSequence, strArr, z2, i3);
    }

    public static final boolean W0(CharSequence charSequence, char c3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.g(charSequence.charAt(0), c3, z2);
    }

    public static final boolean X(CharSequence charSequence, char c3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return m0(charSequence, c3, 0, z2, 2, null) >= 0;
    }

    public static final boolean X0(CharSequence charSequence, CharSequence prefix, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return (!z2 && (charSequence instanceof String) && (prefix instanceof String)) ? StringsKt__StringsJVMKt.U((String) charSequence, (String) prefix, false, 2, null) : J0(charSequence, 0, prefix, 0, prefix.length(), z2);
    }

    public static boolean Y(CharSequence charSequence, CharSequence other, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return other instanceof String ? n0(charSequence, (String) other, 0, z2, 2, null) >= 0 : l0(charSequence, other, 0, charSequence.length(), z2, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean Y0(CharSequence charSequence, char c3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return W0(charSequence, c3, z2);
    }

    public static /* synthetic */ boolean Z(CharSequence charSequence, char c3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return X(charSequence, c3, z2);
    }

    public static /* synthetic */ boolean Z0(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return X0(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ boolean a0(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return Y(charSequence, charSequence2, z2);
    }

    public static final String a1(CharSequence charSequence, IntRange range) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.e().intValue() + 1).toString();
    }

    public static final boolean b0(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.areEqual(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (charSequence.charAt(i3) != charSequence2.charAt(i3)) {
                return false;
            }
        }
        return true;
    }

    public static String b1(String str, IntRange range) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(range, "range");
        String strSubstring = str.substring(range.a().intValue(), range.e().intValue() + 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean c0(CharSequence charSequence, char c3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() > 0 && CharsKt__CharKt.g(charSequence.charAt(h0(charSequence)), c3, z2);
    }

    public static final boolean d0(CharSequence charSequence, CharSequence suffix, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return (!z2 && (charSequence instanceof String) && (suffix instanceof String)) ? StringsKt__StringsJVMKt.E((String) charSequence, (String) suffix, false, 2, null) : J0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z2);
    }

    public static String d1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iN0 = n0(str, delimiter, 0, false, 6, null);
        if (iN0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iN0 + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean e0(CharSequence charSequence, char c3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return c0(charSequence, c3, z2);
    }

    public static /* synthetic */ String e1(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return c1(str, c3, str2);
    }

    public static /* synthetic */ boolean f0(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return d0(charSequence, charSequence2, z2);
    }

    public static /* synthetic */ String f1(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return d1(str, str2, str3);
    }

    private static final Pair g0(CharSequence charSequence, Collection collection, int i3, boolean z2, boolean z3) {
        CharSequence charSequence2;
        Object next;
        boolean z4;
        Object next2;
        if (!z2 && collection.size() == 1) {
            String str = (String) CollectionsKt.single(collection);
            int iN0 = !z3 ? n0(charSequence, str, i3, false, 4, null) : u0(charSequence, str, i3, false, 4, null);
            if (iN0 < 0) {
                return null;
            }
            return TuplesKt.a(Integer.valueOf(iN0), str);
        }
        CharSequence charSequence3 = charSequence;
        IntProgression intRange = !z3 ? new IntRange(RangesKt.f(i3, 0), charSequence3.length()) : RangesKt.v(RangesKt.k(i3, h0(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iG = intRange.g();
            int iH = intRange.h();
            int iL = intRange.l();
            if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
                int i4 = iG;
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z4 = z2;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z4 = z2;
                        if (StringsKt__StringsJVMKt.I(str2, 0, (String) charSequence3, i4, str2.length(), z4)) {
                            break;
                        }
                        z2 = z4;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i4 == iH) {
                            break;
                        }
                        i4 += iL;
                        z2 = z4;
                    } else {
                        return TuplesKt.a(Integer.valueOf(i4), str3);
                    }
                }
            }
        } else {
            boolean z5 = z2;
            int iG2 = intRange.g();
            int iH2 = intRange.h();
            int iL2 = intRange.l();
            if ((iL2 > 0 && iG2 <= iH2) || (iL2 < 0 && iH2 <= iG2)) {
                int i5 = iG2;
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z6 = z5;
                        charSequence2 = charSequence3;
                        z5 = z6;
                        if (J0(str4, 0, charSequence2, i5, str4.length(), z6)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i5 == iH2) {
                            break;
                        }
                        i5 += iL2;
                        charSequence3 = charSequence2;
                    } else {
                        return TuplesKt.a(Integer.valueOf(i5), str5);
                    }
                }
            }
        }
        return null;
    }

    public static String g1(String str, char c3, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iT0 = t0(str, c3, 0, false, 6, null);
        if (iT0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iT0 + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int h0(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static String h1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(str, delimiter, 0, false, 6, null);
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iU0 + delimiter.length(), str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int i0(CharSequence charSequence, char c3, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? o0(charSequence, new char[]{c3}, i3, z2) : ((String) charSequence).indexOf(c3, i3);
    }

    public static /* synthetic */ String i1(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return g1(str, c3, str2);
    }

    public static final int j0(CharSequence charSequence, String string, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return (z2 || !(charSequence instanceof String)) ? l0(charSequence, string, i3, charSequence.length(), z2, false, 16, null) : ((String) charSequence).indexOf(string, i3);
    }

    public static /* synthetic */ String j1(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return h1(str, str2, str3);
    }

    private static final int k0(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z2, boolean z3) {
        IntProgression intRange = !z3 ? new IntRange(RangesKt.f(i3, 0), RangesKt.k(i4, charSequence.length())) : RangesKt.v(RangesKt.k(i3, h0(charSequence)), RangesKt.f(i4, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iG = intRange.g();
            int iH = intRange.h();
            int iL = intRange.l();
            if ((iL <= 0 || iG > iH) && (iL >= 0 || iH > iG)) {
                return -1;
            }
            int i5 = iG;
            while (true) {
                String str = (String) charSequence2;
                boolean z4 = z2;
                if (StringsKt__StringsJVMKt.I(str, 0, (String) charSequence, i5, str.length(), z4)) {
                    return i5;
                }
                if (i5 == iH) {
                    return -1;
                }
                i5 += iL;
                z2 = z4;
            }
        } else {
            boolean z5 = z2;
            int iG2 = intRange.g();
            int iH2 = intRange.h();
            int iL2 = intRange.l();
            if ((iL2 <= 0 || iG2 > iH2) && (iL2 >= 0 || iH2 > iG2)) {
                return -1;
            }
            int i6 = iG2;
            while (true) {
                boolean z6 = z5;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z5 = z6;
                if (J0(charSequence4, 0, charSequence3, i6, charSequence2.length(), z6)) {
                    return i6;
                }
                if (i6 == iH2) {
                    return -1;
                }
                i6 += iL2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static final String k1(String str, char c3, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iM0 = m0(str, c3, 0, false, 6, null);
        if (iM0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iM0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    static /* synthetic */ int l0(CharSequence charSequence, CharSequence charSequence2, int i3, int i4, boolean z2, boolean z3, int i5, Object obj) {
        if ((i5 & 16) != 0) {
            z3 = false;
        }
        return k0(charSequence, charSequence2, i3, i4, z2, z3);
    }

    public static final String l1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iN0 = n0(str, delimiter, 0, false, 6, null);
        if (iN0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iN0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ int m0(CharSequence charSequence, char c3, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return i0(charSequence, c3, i3, z2);
    }

    public static /* synthetic */ String m1(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return k1(str, c3, str2);
    }

    public static /* synthetic */ int n0(CharSequence charSequence, String str, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return j0(charSequence, str, i3, z2);
    }

    public static /* synthetic */ String n1(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return l1(str, str2, str3);
    }

    public static final int o0(CharSequence charSequence, char[] chars, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.single(chars), i3);
        }
        int iF = RangesKt.f(i3, 0);
        int iH0 = h0(charSequence);
        if (iF > iH0) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iF);
            for (char c3 : chars) {
                if (CharsKt__CharKt.g(c3, cCharAt, z2)) {
                    return iF;
                }
            }
            if (iF == iH0) {
                return -1;
            }
            iF++;
        }
    }

    public static final String o1(String str, char c3, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iT0 = t0(str, c3, 0, false, 6, null);
        if (iT0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iT0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static boolean p0(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        for (int i3 = 0; i3 < charSequence.length(); i3++) {
            if (!CharsKt__CharJVMKt.b(charSequence.charAt(i3))) {
                return false;
            }
        }
        return true;
    }

    public static final String p1(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(delimiter, "delimiter");
        Intrinsics.checkNotNullParameter(missingDelimiterValue, "missingDelimiterValue");
        int iU0 = u0(str, delimiter, 0, false, 6, null);
        if (iU0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iU0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final CharIterator q0(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f140600a;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f140600a < charSequence.length();
            }

            @Override // kotlin.collections.CharIterator
            public char nextChar() {
                CharSequence charSequence2 = charSequence;
                int i3 = this.f140600a;
                this.f140600a = i3 + 1;
                return charSequence2.charAt(i3);
            }
        };
    }

    public static /* synthetic */ String q1(String str, char c3, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = str;
        }
        return o1(str, c3, str2);
    }

    public static final int r0(CharSequence charSequence, char c3, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return (z2 || !(charSequence instanceof String)) ? v0(charSequence, new char[]{c3}, i3, z2) : ((String) charSequence).lastIndexOf(c3, i3);
    }

    public static /* synthetic */ String r1(String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str3 = str;
        }
        return p1(str, str2, str3);
    }

    public static final int s0(CharSequence charSequence, String string, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(string, "string");
        return (z2 || !(charSequence instanceof String)) ? k0(charSequence, string, i3, 0, z2, true) : ((String) charSequence).lastIndexOf(string, i3);
    }

    public static Boolean s1(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (Intrinsics.areEqual(str, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return Boolean.TRUE;
        }
        if (Intrinsics.areEqual(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int t0(CharSequence charSequence, char c3, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = h0(charSequence);
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return r0(charSequence, c3, i3, z2);
    }

    public static CharSequence t1(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            boolean zB = CharsKt__CharJVMKt.b(charSequence.charAt(!z2 ? i3 : length));
            if (z2) {
                if (!zB) {
                    break;
                }
                length--;
            } else if (zB) {
                i3++;
            } else {
                z2 = true;
            }
        }
        return charSequence.subSequence(i3, length + 1);
    }

    public static /* synthetic */ int u0(CharSequence charSequence, String str, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = h0(charSequence);
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return s0(charSequence, str, i3, z2);
    }

    public static String u1(String str, char... chars) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        int i3 = 0;
        boolean z2 = false;
        while (i3 <= length) {
            boolean zContains = ArraysKt.contains(chars, str.charAt(!z2 ? i3 : length));
            if (z2) {
                if (!zContains) {
                    break;
                }
                length--;
            } else if (zContains) {
                i3++;
            } else {
                z2 = true;
            }
        }
        return str.subSequence(i3, length + 1).toString();
    }

    public static final int v0(CharSequence charSequence, char[] chars, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        if (!z2 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.single(chars), i3);
        }
        for (int iK = RangesKt.k(i3, h0(charSequence)); -1 < iK; iK--) {
            char cCharAt = charSequence.charAt(iK);
            for (char c3 : chars) {
                if (CharsKt__CharKt.g(c3, cCharAt, z2)) {
                    return iK;
                }
            }
        }
        return -1;
    }

    public static String v1(String str, char... chars) {
        CharSequence charSequenceSubSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(chars, "chars");
        int length = str.length() - 1;
        if (length >= 0) {
            while (true) {
                int i3 = length - 1;
                if (!ArraysKt.contains(chars, str.charAt(length))) {
                    charSequenceSubSequence = str.subSequence(0, length + 1);
                    break;
                }
                if (i3 < 0) {
                    break;
                }
                length = i3;
            }
            charSequenceSubSequence = "";
        } else {
            charSequenceSubSequence = "";
        }
        return charSequenceSubSequence.toString();
    }

    public static final Sequence w0(final CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return new Sequence<String>() { // from class: kotlin.text.StringsKt__StringsKt$lineSequence$$inlined$Sequence$1
            @Override // kotlin.sequences.Sequence
            public Iterator iterator() {
                return new LinesIterator(charSequence);
            }
        };
    }

    public static List x0(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return SequencesKt.S(w0(charSequence));
    }

    public static final CharSequence y0(CharSequence charSequence, int i3, char c3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException("Desired length " + i3 + " is less than zero.");
        }
        if (i3 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i3);
        sb.append(charSequence);
        int length = i3 - charSequence.length();
        int i4 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c3);
                if (i4 == length) {
                    break;
                }
                i4++;
            }
        }
        return sb;
    }

    public static final String z0(String str, int i3, char c3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return y0(str, i3, c3).toString();
    }

    public static String L0(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, SbbqvQlxi.kGvHuxfiiees);
        if (!f0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String c1(String str, char c3, String str2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, cJfnYMIyomoWf.mlnUNT);
        int iM0 = m0(str, c3, 0, false, 6, null);
        if (iM0 == -1) {
            return str2;
        }
        String strSubstring = str.substring(iM0 + 1, str.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }
}
