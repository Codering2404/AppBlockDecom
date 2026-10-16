package androidx.media3.extractor.text.webvtt;

import android.text.TextUtils;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ColorParser;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class WebvttCssParser {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f47277c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f47278d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ParsableByteArray f47279a = new ParsableByteArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f47280b = new StringBuilder();

    private void a(WebvttCssStyle webvttCssStyle, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f47277c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                webvttCssStyle.z((String) Assertions.e(matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrH1 = Util.h1(str, "\\.");
        String str2 = strArrH1[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            webvttCssStyle.y(str2.substring(0, iIndexOf2));
            webvttCssStyle.x(str2.substring(iIndexOf2 + 1));
        } else {
            webvttCssStyle.y(str2);
        }
        if (strArrH1.length > 1) {
            webvttCssStyle.w((String[]) Util.V0(strArrH1, 1, strArrH1.length));
        }
    }

    private static boolean b(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        byte[] bArrE = parsableByteArray.e();
        if (iF + 2 > iG) {
            return false;
        }
        int i3 = iF + 1;
        if (bArrE[iF] != 47) {
            return false;
        }
        int i4 = iF + 2;
        if (bArrE[i3] != 42) {
            return false;
        }
        while (true) {
            int i5 = i4 + 1;
            if (i5 >= iG) {
                parsableByteArray.X(iG - parsableByteArray.f());
                return true;
            }
            if (((char) bArrE[i4]) == '*' && ((char) bArrE[i5]) == '/') {
                i4 += 2;
                iG = i4;
            } else {
                i4 = i5;
            }
        }
    }

    private static boolean c(ParsableByteArray parsableByteArray) {
        char cK = k(parsableByteArray, parsableByteArray.f());
        if (cK != '\t' && cK != '\n' && cK != '\f' && cK != '\r' && cK != ' ') {
            return false;
        }
        parsableByteArray.X(1);
        return true;
    }

    private static void e(String str, WebvttCssStyle webvttCssStyle) {
        Matcher matcher = f47278d.matcher(Ascii.e(str));
        if (!matcher.matches()) {
            Log.i("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) Assertions.e(matcher.group(2));
        str2.getClass();
        switch (str2) {
            case "%":
                webvttCssStyle.t(3);
                break;
            case "em":
                webvttCssStyle.t(2);
                break;
            case "px":
                webvttCssStyle.t(1);
                break;
            default:
                throw new IllegalStateException();
        }
        webvttCssStyle.s(Float.parseFloat((String) Assertions.e(matcher.group(1))));
    }

    private static String f(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        while (iF < iG && !z2) {
            char c3 = (char) parsableByteArray.e()[iF];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z2 = true;
            } else {
                iF++;
                sb.append(c3);
            }
        }
        parsableByteArray.X(iF - parsableByteArray.f());
        return sb.toString();
    }

    static String g(ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() == 0) {
            return null;
        }
        String strF = f(parsableByteArray, sb);
        if (!"".equals(strF)) {
            return strF;
        }
        return "" + ((char) parsableByteArray.H());
    }

    private static String h(ParsableByteArray parsableByteArray, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int iF = parsableByteArray.f();
            String strG = g(parsableByteArray, sb);
            if (strG == null) {
                return null;
            }
            if ("}".equals(strG) || ";".equals(strG)) {
                parsableByteArray.W(iF);
                z2 = true;
            } else {
                sb2.append(strG);
            }
        }
        return sb2.toString();
    }

    private static String i(ParsableByteArray parsableByteArray, StringBuilder sb) {
        n(parsableByteArray);
        if (parsableByteArray.a() < 5 || !"::cue".equals(parsableByteArray.E(5))) {
            return null;
        }
        int iF = parsableByteArray.f();
        String strG = g(parsableByteArray, sb);
        if (strG == null) {
            return null;
        }
        if ("{".equals(strG)) {
            parsableByteArray.W(iF);
            return "";
        }
        String strL = "(".equals(strG) ? l(parsableByteArray) : null;
        if (")".equals(g(parsableByteArray, sb))) {
            return strL;
        }
        return null;
    }

    private static void j(ParsableByteArray parsableByteArray, WebvttCssStyle webvttCssStyle, StringBuilder sb) {
        n(parsableByteArray);
        String strF = f(parsableByteArray, sb);
        if (!"".equals(strF) && Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR.equals(g(parsableByteArray, sb))) {
            n(parsableByteArray);
            String strH = h(parsableByteArray, sb);
            if (strH == null || "".equals(strH)) {
                return;
            }
            int iF = parsableByteArray.f();
            String strG = g(parsableByteArray, sb);
            if (!";".equals(strG)) {
                if (!"}".equals(strG)) {
                    return;
                } else {
                    parsableByteArray.W(iF);
                }
            }
            if ("color".equals(strF)) {
                webvttCssStyle.q(ColorParser.b(strH));
                return;
            }
            if ("background-color".equals(strF)) {
                webvttCssStyle.n(ColorParser.b(strH));
                return;
            }
            boolean z2 = true;
            if ("ruby-position".equals(strF)) {
                if ("over".equals(strH)) {
                    webvttCssStyle.v(1);
                    return;
                } else {
                    if ("under".equals(strH)) {
                        webvttCssStyle.v(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strF)) {
                if (!"all".equals(strH) && !strH.startsWith("digits")) {
                    z2 = false;
                }
                webvttCssStyle.p(z2);
                return;
            }
            if ("text-decoration".equals(strF)) {
                if ("underline".equals(strH)) {
                    webvttCssStyle.A(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strF)) {
                webvttCssStyle.r(strH);
                return;
            }
            if ("font-weight".equals(strF)) {
                if ("bold".equals(strH)) {
                    webvttCssStyle.o(true);
                }
            } else if ("font-style".equals(strF)) {
                if ("italic".equals(strH)) {
                    webvttCssStyle.u(true);
                }
            } else if ("font-size".equals(strF)) {
                e(strH, webvttCssStyle);
            }
        }
    }

    private static char k(ParsableByteArray parsableByteArray, int i3) {
        return (char) parsableByteArray.e()[i3];
    }

    private static String l(ParsableByteArray parsableByteArray) {
        int iF = parsableByteArray.f();
        int iG = parsableByteArray.g();
        boolean z2 = false;
        while (iF < iG && !z2) {
            int i3 = iF + 1;
            z2 = ((char) parsableByteArray.e()[iF]) == ')';
            iF = i3;
        }
        return parsableByteArray.E((iF - 1) - parsableByteArray.f()).trim();
    }

    static void m(ParsableByteArray parsableByteArray) {
        while (!TextUtils.isEmpty(parsableByteArray.s())) {
        }
    }

    static void n(ParsableByteArray parsableByteArray) {
        while (true) {
            for (boolean z2 = true; parsableByteArray.a() > 0 && z2; z2 = false) {
                if (c(parsableByteArray) || b(parsableByteArray)) {
                    break;
                }
            }
            return;
        }
    }

    public List d(ParsableByteArray parsableByteArray) {
        this.f47280b.setLength(0);
        int iF = parsableByteArray.f();
        m(parsableByteArray);
        this.f47279a.U(parsableByteArray.e(), parsableByteArray.f());
        this.f47279a.W(iF);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strI = i(this.f47279a, this.f47280b);
            if (strI == null || !"{".equals(g(this.f47279a, this.f47280b))) {
                break;
            }
            WebvttCssStyle webvttCssStyle = new WebvttCssStyle();
            a(webvttCssStyle, strI);
            String str = null;
            boolean z2 = false;
            while (!z2) {
                int iF2 = this.f47279a.f();
                String strG = g(this.f47279a, this.f47280b);
                boolean z3 = strG == null || "}".equals(strG);
                if (!z3) {
                    this.f47279a.W(iF2);
                    j(this.f47279a, webvttCssStyle, this.f47280b);
                }
                str = strG;
                z2 = z3;
            }
            if ("}".equals(str)) {
                arrayList.add(webvttCssStyle);
            }
        }
        return arrayList;
    }
}
