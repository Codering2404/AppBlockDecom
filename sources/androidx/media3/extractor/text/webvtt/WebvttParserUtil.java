package androidx.media3.extractor.text.webvtt;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.revenuecat.purchases.common.Constants;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttParserUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f47327a = Pattern.compile("^NOTE([ \t].*)?$");

    public static boolean a(ParsableByteArray parsableByteArray) {
        String strS = parsableByteArray.s();
        return strS != null && strS.startsWith("WEBVTT");
    }

    public static float b(String str) {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static long c(String str) {
        String[] strArrI1 = Util.i1(str, "\\.");
        long j3 = 0;
        for (String str2 : Util.h1(strArrI1[0], Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            j3 = (j3 * 60) + Long.parseLong(str2);
        }
        long j4 = j3 * 1000;
        if (strArrI1.length == 2) {
            String strTrim = strArrI1[1].trim();
            if (strTrim.length() != 3) {
                throw new IllegalArgumentException("Expected 3 decimal places, got: " + strTrim);
            }
            j4 += Long.parseLong(strTrim);
        }
        return j4 * 1000;
    }

    public static void d(ParsableByteArray parsableByteArray) throws ParserException {
        int iF = parsableByteArray.f();
        if (a(parsableByteArray)) {
            return;
        }
        parsableByteArray.W(iF);
        throw ParserException.a("Expected WEBVTT. Got " + parsableByteArray.s(), null);
    }
}
