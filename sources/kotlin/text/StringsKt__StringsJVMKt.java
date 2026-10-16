package kotlin.text;

import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;

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
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static boolean A(CharSequence charSequence, CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? StringsKt__StringsKt.b0(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    public static String B(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return new String(bArr, Charsets.f140510b);
    }

    public static byte[] C(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.f140510b);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes;
    }

    public static boolean D(String str, String suffix, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return !z2 ? str.endsWith(suffix) : I(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    public static /* synthetic */ boolean E(String str, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return D(str, str2, z2);
    }

    public static boolean F(String str, String str2, boolean z2) {
        return str == null ? str2 == null : !z2 ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean G(String str, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return F(str, str2, z2);
    }

    public static Comparator H(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        Comparator CASE_INSENSITIVE_ORDER = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(CASE_INSENSITIVE_ORDER, "CASE_INSENSITIVE_ORDER");
        return CASE_INSENSITIVE_ORDER;
    }

    public static boolean I(String str, int i3, String other, int i4, int i5, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return !z2 ? str.regionMatches(i3, other, i4, i5) : str.regionMatches(z2, i3, other, i4, i5);
    }

    public static /* synthetic */ boolean J(String str, int i3, String str2, int i4, int i5, boolean z2, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            z2 = false;
        }
        return I(str, i3, str2, i4, i5, z2);
    }

    public static String K(CharSequence charSequence, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (i3 < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i3 + '.').toString());
        }
        if (i3 == 0) {
            return "";
        }
        int i4 = 1;
        if (i3 == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i3];
            for (int i5 = 0; i5 < i3; i5++) {
                cArr[i5] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i3);
        if (1 <= i3) {
            while (true) {
                sb.append(charSequence);
                if (i4 == i3) {
                    break;
                }
                i4++;
            }
        }
        String string = sb.toString();
        Intrinsics.checkNotNull(string);
        return string;
    }

    public static final String L(String str, char c3, char c4, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!z2) {
            String strReplace = str.replace(c3, c4);
            Intrinsics.checkNotNullExpressionValue(strReplace, "replace(...)");
            return strReplace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        for (int i3 = 0; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (CharsKt__CharKt.g(cCharAt, c3, z2)) {
                cCharAt = c4;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    public static /* synthetic */ String N(String str, char c3, char c4, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return L(str, c3, c4, z2);
    }

    public static /* synthetic */ String O(String str, String str2, String str3, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return M(str, str2, str3, z2);
    }

    public static final String P(String str, String oldValue, String newValue, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int iN0 = StringsKt__StringsKt.n0(str, oldValue, 0, z2, 2, null);
        return iN0 < 0 ? str : StringsKt__StringsKt.O0(str, iN0, oldValue.length() + iN0, newValue).toString();
    }

    public static /* synthetic */ String Q(String str, String str2, String str3, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return P(str, str2, str3, z2);
    }

    public static boolean R(String str, String prefix, int i3, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z2 ? str.startsWith(prefix, i3) : I(str, i3, prefix, 0, prefix.length(), z2);
    }

    public static boolean S(String str, String prefix, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        return !z2 ? str.startsWith(prefix) : I(str, 0, prefix, 0, prefix.length(), z2);
    }

    public static /* synthetic */ boolean T(String str, String str2, int i3, boolean z2, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        return R(str, str2, i3, z2);
    }

    public static /* synthetic */ boolean U(String str, String str2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        return S(str, str2, z2);
    }

    public static String y(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        return new String(cArr);
    }

    public static String z(char[] cArr, int i3, int i4) {
        Intrinsics.checkNotNullParameter(cArr, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(i3, i4, cArr.length);
        return new String(cArr, i3, i4 - i3);
    }

    public static final String M(String str, String oldValue, String newValue, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        int i3 = 0;
        int iJ0 = StringsKt__StringsKt.j0(str, oldValue, 0, z2);
        if (iJ0 < 0) {
            return str;
        }
        int length = oldValue.length();
        int iF = RangesKt.f(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i3, iJ0);
            sb.append(newValue);
            i3 = iJ0 + length;
            if (iJ0 >= str.length()) {
                break;
            }
            iJ0 = StringsKt__StringsKt.j0(str, oldValue, iJ0 + iF, z2);
        } while (iJ0 > 0);
        sb.append((CharSequence) str, i3, str.length());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, cJfnYMIyomoWf.ehzaFXKuNNL);
        return string;
    }
}
