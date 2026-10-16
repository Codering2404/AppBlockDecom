package androidx.media3.extractor.text.ssa;

import android.graphics.PointF;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.CuesWithTiming;
import androidx.media3.extractor.text.SubtitleParser;
import androidx.media3.extractor.text.ssa.SsaStyle;
import com.google.common.base.Ascii;
import com.revenuecat.purchases.common.Constants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SsaParser implements SubtitleParser {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Pattern f47144g = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f47145a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SsaDialogueFormat f47146b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f47148d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f47149e = -3.4028235E38f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f47150f = -3.4028235E38f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ParsableByteArray f47147c = new ParsableByteArray();

    public SsaParser(List list) {
        if (list == null || list.isEmpty()) {
            this.f47145a = false;
            this.f47146b = null;
            return;
        }
        this.f47145a = true;
        String strK = Util.K((byte[]) list.get(0));
        Assertions.a(strK.startsWith("Format:"));
        this.f47146b = (SsaDialogueFormat) Assertions.e(SsaDialogueFormat.a(strK));
        j(new ParsableByteArray((byte[]) list.get(1)), StandardCharsets.UTF_8);
    }

    private static int d(long j3, List list, List list2) {
        int i3;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i3 = 0;
                break;
            }
            if (((Long) list.get(size)).longValue() == j3) {
                return size;
            }
            if (((Long) list.get(size)).longValue() < j3) {
                i3 = size + 1;
                break;
            }
            size--;
        }
        list.add(i3, Long.valueOf(j3));
        list2.add(i3, i3 == 0 ? new ArrayList() : new ArrayList((Collection) list2.get(i3 - 1)));
        return i3;
    }

    private static float e(int i3) {
        if (i3 == 0) {
            return 0.05f;
        }
        if (i3 != 1) {
            return i3 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    private static Cue f(String str, SsaStyle ssaStyle, SsaStyle.Overrides overrides, float f3, float f4) {
        SpannableString spannableString = new SpannableString(str);
        Cue.Builder builderO = new Cue.Builder().o(spannableString);
        if (ssaStyle != null) {
            if (ssaStyle.f47153c != null) {
                spannableString.setSpan(new ForegroundColorSpan(ssaStyle.f47153c.intValue()), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f47160j == 3 && ssaStyle.f47154d != null) {
                spannableString.setSpan(new BackgroundColorSpan(ssaStyle.f47154d.intValue()), 0, spannableString.length(), 33);
            }
            float f5 = ssaStyle.f47155e;
            if (f5 != -3.4028235E38f && f4 != -3.4028235E38f) {
                builderO.q(f5 / f4, 1);
            }
            boolean z2 = ssaStyle.f47156f;
            if (z2 && ssaStyle.f47157g) {
                spannableString.setSpan(new StyleSpan(3), 0, spannableString.length(), 33);
            } else if (z2) {
                spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
            } else if (ssaStyle.f47157g) {
                spannableString.setSpan(new StyleSpan(2), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f47158h) {
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
            }
            if (ssaStyle.f47159i) {
                spannableString.setSpan(new StrikethroughSpan(), 0, spannableString.length(), 33);
            }
        }
        int i3 = overrides.f47176a;
        if (i3 == -1) {
            i3 = ssaStyle != null ? ssaStyle.f47152b : -1;
        }
        builderO.p(p(i3)).l(o(i3)).i(n(i3));
        PointF pointF = overrides.f47177b;
        if (pointF == null || f4 == -3.4028235E38f || f3 == -3.4028235E38f) {
            builderO.k(e(builderO.d()));
            builderO.h(e(builderO.c()), 0);
        } else {
            builderO.k(pointF.x / f3);
            builderO.h(overrides.f47177b.y / f4, 0);
        }
        return builderO.a();
    }

    private Charset g(ParsableByteArray parsableByteArray) {
        Charset charsetR = parsableByteArray.R();
        return charsetR != null ? charsetR : StandardCharsets.UTF_8;
    }

    private void h(String str, SsaDialogueFormat ssaDialogueFormat, List list, List list2) {
        int i3;
        Assertions.a(str.startsWith("Dialogue:"));
        String[] strArrSplit = str.substring(9).split(",", ssaDialogueFormat.f47143e);
        if (strArrSplit.length != ssaDialogueFormat.f47143e) {
            Log.i("SsaParser", "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long jM = m(strArrSplit[ssaDialogueFormat.f47139a]);
        if (jM == -9223372036854775807L) {
            Log.i("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        long jM2 = m(strArrSplit[ssaDialogueFormat.f47140b]);
        if (jM2 == -9223372036854775807L || jM2 <= jM) {
            Log.i("SsaParser", "Skipping invalid timing: " + str);
            return;
        }
        Map map = this.f47148d;
        SsaStyle ssaStyle = (map == null || (i3 = ssaDialogueFormat.f47141c) == -1) ? null : (SsaStyle) map.get(strArrSplit[i3].trim());
        String str2 = strArrSplit[ssaDialogueFormat.f47142d];
        Cue cueF = f(SsaStyle.Overrides.d(str2).replace("\\N", "\n").replace("\\n", "\n").replace("\\h", " "), ssaStyle, SsaStyle.Overrides.b(str2), this.f47149e, this.f47150f);
        int iD = d(jM2, list2, list);
        for (int iD2 = d(jM, list2, list); iD2 < iD; iD2++) {
            ((List) list.get(iD2)).add(cueF);
        }
    }

    private void i(ParsableByteArray parsableByteArray, List list, List list2, Charset charset) {
        SsaDialogueFormat ssaDialogueFormatA = this.f47145a ? this.f47146b : null;
        while (true) {
            String strT = parsableByteArray.t(charset);
            if (strT == null) {
                return;
            }
            if (strT.startsWith("Format:")) {
                ssaDialogueFormatA = SsaDialogueFormat.a(strT);
            } else if (strT.startsWith("Dialogue:")) {
                if (ssaDialogueFormatA == null) {
                    Log.i("SsaParser", "Skipping dialogue line before complete format: " + strT);
                } else {
                    h(strT, ssaDialogueFormatA, list, list2);
                }
            }
        }
    }

    private void j(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String strT = parsableByteArray.t(charset);
            if (strT == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(strT)) {
                k(parsableByteArray, charset);
            } else if ("[V4+ Styles]".equalsIgnoreCase(strT)) {
                this.f47148d = l(parsableByteArray, charset);
            } else if ("[V4 Styles]".equalsIgnoreCase(strT)) {
                Log.g("SsaParser", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(strT)) {
                return;
            }
        }
    }

    private void k(ParsableByteArray parsableByteArray, Charset charset) {
        while (true) {
            String strT = parsableByteArray.t(charset);
            if (strT == null) {
                return;
            }
            if (parsableByteArray.a() != 0 && parsableByteArray.h(charset) == '[') {
                return;
            }
            String[] strArrSplit = strT.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            if (strArrSplit.length == 2) {
                String strE = Ascii.e(strArrSplit[0].trim());
                strE.getClass();
                if (strE.equals("playresx")) {
                    this.f47149e = Float.parseFloat(strArrSplit[1].trim());
                } else if (strE.equals("playresy")) {
                    try {
                        this.f47150f = Float.parseFloat(strArrSplit[1].trim());
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
    }

    private static Map l(ParsableByteArray parsableByteArray, Charset charset) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        SsaStyle.Format formatA = null;
        while (true) {
            String strT = parsableByteArray.t(charset);
            if (strT == null || (parsableByteArray.a() != 0 && parsableByteArray.h(charset) == '[')) {
                break;
            }
            if (strT.startsWith("Format:")) {
                formatA = SsaStyle.Format.a(strT);
            } else if (strT.startsWith("Style:")) {
                if (formatA == null) {
                    Log.i("SsaParser", "Skipping 'Style:' line before 'Format:' line: " + strT);
                } else {
                    SsaStyle ssaStyleB = SsaStyle.b(strT, formatA);
                    if (ssaStyleB != null) {
                        linkedHashMap.put(ssaStyleB.f47151a, ssaStyleB);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static long m(String str) {
        Matcher matcher = f47144g.matcher(str.trim());
        if (matcher.matches()) {
            return (Long.parseLong((String) Util.k(matcher.group(1))) * 3600000000L) + (Long.parseLong((String) Util.k(matcher.group(2))) * 60000000) + (Long.parseLong((String) Util.k(matcher.group(3))) * 1000000) + (Long.parseLong((String) Util.k(matcher.group(4))) * 10000);
        }
        return -9223372036854775807L;
    }

    private static int n(int i3) {
        switch (i3) {
            case -1:
                break;
            case 0:
            default:
                Log.i("SsaParser", "Unknown alignment: " + i3);
                break;
            case 1:
            case 2:
            case 3:
                break;
            case 4:
            case 5:
            case 6:
                break;
            case 7:
            case 8:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static int o(int i3) {
        switch (i3) {
            case -1:
                break;
            case 0:
            default:
                Log.i("SsaParser", "Unknown alignment: " + i3);
                break;
            case 1:
            case 4:
            case 7:
                break;
            case 2:
            case 5:
            case 8:
                break;
            case 3:
            case 6:
            case 9:
                break;
        }
        return Integer.MIN_VALUE;
    }

    private static Layout.Alignment p(int i3) {
        switch (i3) {
            case -1:
                return null;
            case 0:
            default:
                Log.i("SsaParser", "Unknown alignment: " + i3);
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // androidx.media3.extractor.text.SubtitleParser
    public void a(byte[] bArr, int i3, int i4, SubtitleParser.OutputOptions outputOptions, Consumer consumer) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f47147c.U(bArr, i3 + i4);
        this.f47147c.W(i3);
        Charset charsetG = g(this.f47147c);
        if (!this.f47145a) {
            j(this.f47147c, charsetG);
        }
        i(this.f47147c, arrayList, arrayList2, charsetG);
        ArrayList arrayList3 = (outputOptions.f46961a == -9223372036854775807L || !outputOptions.f46962b) ? null : new ArrayList();
        int i5 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            List list = (List) arrayList.get(i6);
            if (!list.isEmpty() || i6 == 0) {
                if (i6 == arrayList.size() - 1) {
                    throw new IllegalStateException();
                }
                long jLongValue = ((Long) arrayList2.get(i6)).longValue();
                long jLongValue2 = ((Long) arrayList2.get(i6 + 1)).longValue() - ((Long) arrayList2.get(i6)).longValue();
                long j3 = outputOptions.f46961a;
                if (j3 == -9223372036854775807L || jLongValue >= j3) {
                    consumer.accept(new CuesWithTiming(list, jLongValue, jLongValue2));
                } else if (arrayList3 != null) {
                    arrayList3.add(new CuesWithTiming(list, jLongValue, jLongValue2));
                }
            }
        }
        if (arrayList3 != null) {
            int size = arrayList3.size();
            while (i5 < size) {
                Object obj = arrayList3.get(i5);
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
