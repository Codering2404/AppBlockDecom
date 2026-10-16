package androidx.media3.datasource;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f41958a = Pattern.compile("bytes (\\d+)-(\\d+)/(?:\\d+|\\*)");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f41959b = Pattern.compile("bytes (?:(?:\\d+-\\d+)|\\*)/(\\d+)");

    public static String a(long j3, long j4) {
        if (j3 == 0 && j4 == -1) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("bytes=");
        sb.append(j3);
        sb.append("-");
        if (j4 != -1) {
            sb.append((j3 + j4) - 1);
        }
        return sb.toString();
    }

    public static long b(String str, String str2) {
        long j3;
        if (TextUtils.isEmpty(str)) {
            j3 = -1;
        } else {
            try {
                j3 = Long.parseLong(str);
            } catch (NumberFormatException unused) {
                Log.d("HttpUtil", "Unexpected Content-Length [" + str + "]");
                j3 = -1;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return j3;
        }
        Matcher matcher = f41958a.matcher(str2);
        if (!matcher.matches()) {
            return j3;
        }
        try {
            long j4 = (Long.parseLong((String) Assertions.e(matcher.group(2))) - Long.parseLong((String) Assertions.e(matcher.group(1)))) + 1;
            if (j3 < 0) {
                return j4;
            }
            if (j3 == j4) {
                return j3;
            }
            Log.i("HttpUtil", "Inconsistent headers [" + str + "] [" + str2 + "]");
            return Math.max(j3, j4);
        } catch (NumberFormatException unused2) {
            Log.d("HttpUtil", "Unexpected Content-Range [" + str2 + "]");
            return j3;
        }
    }

    public static long c(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Matcher matcher = f41959b.matcher(str);
        if (matcher.matches()) {
            return Long.parseLong((String) Assertions.e(matcher.group(1)));
        }
        return -1L;
    }
}
