package androidx.media3.extractor.text.subrip;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import com.google.common.collect.ImmutableList;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SubripParser implements SubtitleParser {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f47178d = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d{3}))?)\\s*");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Pattern f47179e = Pattern.compile("\\{\\\\.*?\\}");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f47180a = new StringBuilder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayList f47181b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47182c = new ParsableByteArray();

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private androidx.media3.common.text.Cue d(android.text.Spanned r14, java.lang.String r15) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.text.subrip.SubripParser.d(android.text.Spanned, java.lang.String):androidx.media3.common.text.Cue");
    }

    private Charset e(ParsableByteArray parsableByteArray) {
        Charset charsetR = parsableByteArray.R();
        return charsetR != null ? charsetR : StandardCharsets.UTF_8;
    }

    public static float f(int i3) {
        if (i3 == 0) {
            return 0.08f;
        }
        if (i3 == 1) {
            return 0.5f;
        }
        if (i3 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    private static long g(Matcher matcher, int i3) {
        String strGroup = matcher.group(i3 + 1);
        long j3 = (strGroup != null ? Long.parseLong(strGroup) * 3600000 : 0L) + (Long.parseLong((String) Assertions.e(matcher.group(i3 + 2))) * 60000) + (Long.parseLong((String) Assertions.e(matcher.group(i3 + 3))) * 1000);
        String strGroup2 = matcher.group(i3 + 4);
        if (strGroup2 != null) {
            j3 += Long.parseLong(strGroup2);
        }
        return j3 * 1000;
    }

    private String h(String str, ArrayList arrayList) {
        String strTrim = str.trim();
        StringBuilder sb = new StringBuilder(strTrim);
        Matcher matcher = f47179e.matcher(strTrim);
        int i3 = 0;
        while (matcher.find()) {
            String strGroup = matcher.group();
            arrayList.add(strGroup);
            int iStart = matcher.start() - i3;
            int length = strGroup.length();
            sb.replace(iStart, iStart + length, "");
            i3 += length;
        }
        return sb.toString();
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        int i5;
        long j3;
        String strT;
        String str;
        this.f47182c.U(bArr, i3 + i4);
        this.f47182c.W(i3);
        Charset charsetE = e(this.f47182c);
        long j4 = -9223372036854775807L;
        ArrayList arrayList = (outputOptions.f46961a == -9223372036854775807L || !outputOptions.f46962b) ? null : new ArrayList();
        while (true) {
            String strT2 = this.f47182c.t(charsetE);
            i5 = 0;
            if (strT2 == null) {
                break;
            }
            if (strT2.length() != 0) {
                try {
                    Integer.parseInt(strT2);
                    strT = this.f47182c.t(charsetE);
                } catch (NumberFormatException unused) {
                    j3 = j4;
                    Log.i("SubripParser", "Skipping invalid index: " + strT2);
                }
                if (strT == null) {
                    Log.i("SubripParser", "Unexpected end");
                    break;
                }
                Matcher matcher = f47178d.matcher(strT);
                if (matcher.matches()) {
                    long jG = g(matcher, 1);
                    long jG2 = g(matcher, 6);
                    this.f47180a.setLength(0);
                    this.f47181b.clear();
                    String strT3 = this.f47182c.t(charsetE);
                    while (!TextUtils.isEmpty(strT3)) {
                        if (this.f47180a.length() > 0) {
                            this.f47180a.append("<br>");
                        }
                        this.f47180a.append(h(strT3, this.f47181b));
                        strT3 = this.f47182c.t(charsetE);
                    }
                    Spanned spannedFromHtml = Html.fromHtml(this.f47180a.toString());
                    while (true) {
                        if (i5 >= this.f47181b.size()) {
                            str = null;
                            break;
                        }
                        str = (String) this.f47181b.get(i5);
                        if (str.matches("\\{\\\\an[1-9]\\}")) {
                            break;
                        } else {
                            i5++;
                        }
                    }
                    j3 = j4;
                    long j5 = outputOptions.f46961a;
                    if (j5 == j3 || jG >= j5) {
                        consumer.accept(new CuesWithTiming(ImmutableList.z(d(spannedFromHtml, str)), jG, jG2 - jG));
                    } else if (arrayList != null) {
                        arrayList.add(new CuesWithTiming(ImmutableList.z(d(spannedFromHtml, str)), jG, jG2 - jG));
                    }
                } else {
                    j3 = j4;
                    Log.i("SubripParser", "Skipping invalid timing: " + strT);
                }
                j4 = j3;
            }
        }
        if (arrayList != null) {
            int size = arrayList.size();
            while (i5 < size) {
                Object obj = arrayList.get(i5);
                i5++;
                consumer.accept((CuesWithTiming) obj);
            }
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public int c() {
        return 1;
    }
}
