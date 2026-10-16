package cz.mobilesoft.coreblock.util.helperextension;

import android.content.Context;
import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.core.text.HtmlCompat;
import androidx.glance.session.ecY.lisODU;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.common.Utf8Charset;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.AddressHolder;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.format.TextStyle;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StringHelperExtKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f128660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Regex f128661b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128662a;

        static {
            int[] iArr = new int[DayOfWeek.values().length];
            try {
                iArr[DayOfWeek.MONDAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DayOfWeek.TUESDAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DayOfWeek.WEDNESDAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DayOfWeek.THURSDAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DayOfWeek.FRIDAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DayOfWeek.SATURDAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DayOfWeek.SUNDAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f128662a = iArr;
        }
    }

    static {
        char[] charArray = "0123456789abcdef".toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
        f128660a = charArray;
        f128661b = new Regex("\\R+");
    }

    public static final String b(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        char[] cArr = new char[bytes.length * 2];
        int length = bytes.length;
        for (int i3 = 0; i3 < length; i3++) {
            byte b3 = bytes[i3];
            int i4 = i3 * 2;
            char[] cArr2 = f128660a;
            cArr[i4] = cArr2[(b3 & 255) >>> 4];
            cArr[i4 + 1] = cArr2[b3 & Ascii.SI];
        }
        return new String(cArr);
    }

    public static final String c(String str) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isLowerCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            strValueOf = CharsKt.d(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }

    public static final CharSequence f(String str, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned spannedH = StringHelper.h(str);
        return z2 ? z(spannedH) : spannedH;
    }

    public static final String g(AddressHolder addressHolder) {
        Intrinsics.checkNotNullParameter(addressHolder, "<this>");
        Pair pairH = h(addressHolder);
        return r(CollectionsKt.listOfNotNull((Object[]) new String[]{(String) pairH.b(), (String) pairH.a()}), ", ", null);
    }

    public static final Pair h(AddressHolder addressHolder) {
        List listV0;
        Pair pairA;
        Intrinsics.checkNotNullParameter(addressHolder, "<this>");
        List listListOfNotNull = CollectionsKt.listOfNotNull((Object[]) new String[]{addressHolder.j(), addressHolder.d()});
        if (listListOfNotNull.isEmpty()) {
            listListOfNotNull = null;
        }
        if (listListOfNotNull != null && (pairA = TuplesKt.a(r(listListOfNotNull, " ", null), (String) CollectionsKt.firstOrNull(CollectionsKt.listOfNotNull((Object[]) new String[]{addressHolder.g(), addressHolder.c(), addressHolder.e()})))) != null) {
            return pairA;
        }
        String strH = addressHolder.h();
        if (strH != null && (listV0 = StringsKt.V0(strH, new String[]{","}, false, 0, 6, null)) != null) {
            Pair pairA2 = TuplesKt.a(StringsKt.t1((String) (listV0.size() > 0 ? listV0.get(0) : "")).toString(), StringsKt.t1((String) (1 < listV0.size() ? listV0.get(1) : "")).toString());
            if (pairA2 != null) {
                return pairA2;
            }
        }
        return TuplesKt.a("", null);
    }

    public static final AnnotatedString i(String string, long j3) {
        Intrinsics.checkNotNullParameter(string, "string");
        int i3 = 0;
        Spanned spannedA = HtmlCompat.a(string, 0);
        Intrinsics.checkNotNullExpressionValue(spannedA, "fromHtml(...)");
        AnnotatedString.Builder builder = new AnnotatedString.Builder(i3, 1, null);
        Object[] spans = spannedA.getSpans(0, spannedA.length(), StyleSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        int length = spans.length;
        int i4 = 0;
        while (i3 < length) {
            StyleSpan styleSpan = (StyleSpan) spans[i3];
            int spanStart = spannedA.getSpanStart(styleSpan);
            int spanEnd = spannedA.getSpanEnd(styleSpan);
            String string2 = spannedA.subSequence(spanStart, spanEnd).toString();
            if (i4 < spanStart) {
                builder.l(spannedA.subSequence(i4, spanStart).toString());
            }
            int iS = builder.s(new SpanStyle(j3, 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null));
            try {
                builder.l(string2);
                Unit unit = Unit.f139807a;
                builder.q(iS);
                i3++;
                i4 = spanEnd;
            } catch (Throwable th) {
                builder.q(iS);
                throw th;
            }
        }
        if (i4 < spannedA.length()) {
            builder.l(spannedA.subSequence(i4, spannedA.length()).toString());
        }
        return builder.t();
    }

    public static final AnnotatedString j(Context context, int i3, long j3, String[] texts) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(texts, "texts");
        String string = context.getString(i3, Arrays.copyOf(texts, texts.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ArrayList arrayList = new ArrayList(texts.length);
        int i4 = 0;
        for (String str : texts) {
            int iN0 = StringsKt.n0(string, str, 0, false, 6, null);
            arrayList.add(TuplesKt.a(Integer.valueOf(iN0), Integer.valueOf(str.length() + iN0)));
        }
        AnnotatedString.Builder builder = new AnnotatedString.Builder(i4, 1, null);
        int size = arrayList.size();
        int i5 = 0;
        int i6 = 0;
        while (i6 < size) {
            Object obj = arrayList.get(i6);
            i6++;
            int i7 = i5 + 1;
            if (i5 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = (Pair) obj;
            int iIntValue = ((Number) pair.a()).intValue();
            int iIntValue2 = ((Number) pair.b()).intValue();
            String strSubstring = string.substring(i4, iIntValue);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            builder.l(strSubstring);
            String str2 = (String) ArraysKt.getOrNull(texts, i5);
            if (str2 != null) {
                int iS = builder.s(new SpanStyle(j3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
                try {
                    builder.l(str2);
                    Unit unit = Unit.f139807a;
                } finally {
                    builder.q(iS);
                }
            }
            i4 = iIntValue2;
            i5 = i7;
        }
        String strSubstring2 = string.substring(i4);
        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
        builder.l(strSubstring2);
        return builder.t();
    }

    public static final AnnotatedString k(Context context, int i3, String text, long j3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(text, "text");
        String string = context.getString(i3, text);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        int iN0 = StringsKt.n0(string, text, 0, false, 6, null);
        int length = text.length() + iN0;
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
        String strSubstring = string.substring(0, iN0);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        builder.l(strSubstring);
        int iS = builder.s(new SpanStyle(j3, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65534, (DefaultConstructorMarker) null));
        try {
            builder.l(text);
            Unit unit = Unit.f139807a;
            builder.q(iS);
            String strSubstring2 = string.substring(length);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            builder.l(strSubstring2);
            return builder.t();
        } catch (Throwable th) {
            builder.q(iS);
            throw th;
        }
    }

    public static final String l(Context context, Collection daysOfWeek) {
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(daysOfWeek, "daysOfWeek");
        DayOfWeek dayOfWeek = (DayOfWeek) CollectionsKt.singleOrNull(daysOfWeek);
        if (dayOfWeek != null) {
            switch (WhenMappings.f128662a[dayOfWeek.ordinal()]) {
                case 1:
                    i3 = R.string.Jd;
                    break;
                case 2:
                    i3 = R.string.Nd;
                    break;
                case 3:
                    i3 = R.string.Od;
                    break;
                case 4:
                    i3 = R.string.Md;
                    break;
                case 5:
                    i3 = R.string.Id;
                    break;
                case 6:
                    i3 = R.string.Kd;
                    break;
                case 7:
                    i3 = R.string.Ld;
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String string = context.getString(i3);
            if (string != null) {
                return string;
            }
        }
        if (daysOfWeek.isEmpty()) {
            return "";
        }
        if (daysOfWeek.size() == 7) {
            String string2 = context.getString(R.string.Gd);
            Intrinsics.checkNotNull(string2);
            return string2;
        }
        if (daysOfWeek.size() == 2 && daysOfWeek.containsAll(SetsKt.setOf((Object[]) new DayOfWeek[]{DayOfWeek.SATURDAY, DayOfWeek.SUNDAY}))) {
            String string3 = context.getString(R.string.Pd);
            Intrinsics.checkNotNull(string3);
            return string3;
        }
        if (daysOfWeek.size() == 5 && daysOfWeek.containsAll(SetsKt.setOf((Object[]) new DayOfWeek[]{DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY}))) {
            String string4 = context.getString(R.string.Qd);
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        String string5 = context.getString(R.string.Hd, r(daysOfWeek, ", ", new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.e0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return StringHelperExtKt.m((DayOfWeek) obj);
            }
        }));
        Intrinsics.checkNotNull(string5);
        return string5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence m(DayOfWeek it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String strF = it.f(TextStyle.SHORT_STANDALONE, Locale.getDefault());
        Intrinsics.checkNotNullExpressionValue(strF, "getDisplayName(...)");
        return StringsKt.B1(strF, 2);
    }

    public static final String n(String str, String imageId) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(imageId, "imageId");
        if (!StringsKt.U(imageId, "/", false, 2, null)) {
            return str + imageId;
        }
        String strSubstring = imageId.substring(1, imageId.length());
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return str + strSubstring;
    }

    public static final boolean o(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return str.equals(LockieApplication.f95360f);
    }

    public static final String p(String str, String second, CharSequence separator) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(separator, "separator");
        String str2 = MessageFormat.format("{0}{1}{2}", str, separator, second);
        Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
        return str2;
    }

    public static /* synthetic */ String q(String str, String str2, CharSequence charSequence, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            charSequence = " ";
        }
        return p(str, str2, charSequence);
    }

    public static final String r(Iterable iterable, CharSequence separator, Function1 function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(separator, "separator");
        return CollectionsKt.joinToString$default(iterable, separator, "", null, 0, null, function1, 28, null);
    }

    public static /* synthetic */ String s(Iterable iterable, CharSequence charSequence, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charSequence = ", ";
        }
        if ((i3 & 2) != 0) {
            function1 = null;
        }
        return r(iterable, charSequence, function1);
    }

    public static final String t(Context context, String str, String defaultText) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(defaultText, "defaultText");
        String language = context.getResources().getConfiguration().getLocales().get(0).getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return (!StringsKt.U(language, "en", false, 2, null) || str == null || StringsKt.p0(str)) ? defaultText : str;
    }

    public static final String u(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Regex regex = new Regex("\\p{InCombiningDiacriticalMarks}+");
        String strNormalize = Normalizer.normalize(str, Normalizer.Form.NFD);
        Intrinsics.checkNotNull(strNormalize);
        return regex.replace(strNormalize, "");
    }

    public static final String v(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return w(StringsKt.t1(d(str)).toString(), 255);
    }

    public static final String w(String str, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (i3 <= 0) {
            return "";
        }
        if (str.length() <= i3) {
            return str;
        }
        if (Character.isHighSurrogate(str.charAt(i3 - 1))) {
            i3--;
        }
        String strSubstring = str.substring(0, i3);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String x(int i3) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.getDefault(), "%d%%", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String y(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            Intrinsics.checkNotNullExpressionValue(messageDigest, "getInstance(...)");
            Charset charsetForName = Charset.forName(Utf8Charset.NAME);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = str.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            messageDigest.update(bytes, 0, bytes.length);
            byte[] bArrDigest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(bArrDigest, "digest(...)");
            return b(bArrDigest);
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return str;
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
            return str;
        }
    }

    public static final CharSequence z(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        return charSequence.subSequence(0, StringsKt.t1(charSequence.toString()).toString().length());
    }

    public static final String d(String str) {
        Intrinsics.checkNotNullParameter(str, lisODU.cGr);
        return f128661b.replace(str, " ");
    }

    public static final String e(String str) {
        String strValueOf;
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        if (Character.isUpperCase(cCharAt)) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, wgbAZXYjrv.YTDFfMoBb);
            strValueOf = CharsKt.c(cCharAt, locale);
        } else {
            strValueOf = String.valueOf(cCharAt);
        }
        sb.append((Object) strValueOf);
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        sb.append(strSubstring);
        return sb.toString();
    }
}
