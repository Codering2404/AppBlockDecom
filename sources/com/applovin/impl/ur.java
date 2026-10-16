package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ur {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f64341c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Pattern f64342d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ah f64343a = new ah();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final StringBuilder f64344b = new StringBuilder();

    private static boolean a(ah ahVar) {
        int iD = ahVar.d();
        int iE = ahVar.e();
        byte[] bArrC = ahVar.c();
        int i3 = iD + 2;
        if (i3 > iE) {
            return false;
        }
        int i4 = iD + 1;
        if (bArrC[iD] != 47 || bArrC[i4] != 42) {
            return false;
        }
        while (true) {
            int i5 = i3 + 1;
            if (i5 >= iE) {
                ahVar.g(iE - ahVar.d());
                return true;
            }
            if (((char) bArrC[i3]) == '*' && ((char) bArrC[i5]) == '/') {
                i3 += 2;
                iE = i3;
            } else {
                i3 = i5;
            }
        }
    }

    private static boolean b(ah ahVar) {
        char cA = a(ahVar, ahVar.d());
        if (cA != '\t' && cA != '\n' && cA != '\f' && cA != '\r' && cA != ' ') {
            return false;
        }
        ahVar.g(1);
        return true;
    }

    private static String d(ah ahVar, StringBuilder sb) {
        f(ahVar);
        if (ahVar.a() < 5 || !"::cue".equals(ahVar.c(5))) {
            return null;
        }
        int iD = ahVar.d();
        String strB = b(ahVar, sb);
        if (strB == null) {
            return null;
        }
        if ("{".equals(strB)) {
            ahVar.f(iD);
            return "";
        }
        String strD = "(".equals(strB) ? d(ahVar) : null;
        if (")".equals(b(ahVar, sb))) {
            return strD;
        }
        return null;
    }

    static void e(ah ahVar) {
        while (!TextUtils.isEmpty(ahVar.l())) {
        }
    }

    static void f(ah ahVar) {
        while (true) {
            for (boolean z2 = true; ahVar.a() > 0 && z2; z2 = false) {
                if (b(ahVar) || a(ahVar)) {
                    break;
                }
            }
            return;
        }
    }

    public List c(ah ahVar) {
        this.f64344b.setLength(0);
        int iD = ahVar.d();
        e(ahVar);
        this.f64343a.a(ahVar.c(), ahVar.d());
        this.f64343a.f(iD);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String strD = d(this.f64343a, this.f64344b);
            if (strD == null || !"{".equals(b(this.f64343a, this.f64344b))) {
                break;
            }
            vr vrVar = new vr();
            a(vrVar, strD);
            String str = null;
            boolean z2 = false;
            while (!z2) {
                int iD2 = this.f64343a.d();
                String strB = b(this.f64343a, this.f64344b);
                boolean z3 = strB == null || "}".equals(strB);
                if (!z3) {
                    this.f64343a.f(iD2);
                    a(this.f64343a, vrVar, this.f64344b);
                }
                str = strB;
                z2 = z3;
            }
            if ("}".equals(str)) {
                arrayList.add(vrVar);
            }
        }
        return arrayList;
    }

    static String b(ah ahVar, StringBuilder sb) {
        f(ahVar);
        if (ahVar.a() == 0) {
            return null;
        }
        String strA = a(ahVar, sb);
        if (!"".equals(strA)) {
            return strA;
        }
        return "" + ((char) ahVar.w());
    }

    private static String a(ah ahVar, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int iD = ahVar.d();
        int iE = ahVar.e();
        while (iD < iE && !z2) {
            char c3 = (char) ahVar.c()[iD];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z2 = true;
            } else {
                iD++;
                sb.append(c3);
            }
        }
        ahVar.g(iD - ahVar.d());
        return sb.toString();
    }

    private static String d(ah ahVar) {
        int iD = ahVar.d();
        int iE = ahVar.e();
        boolean z2 = false;
        while (iD < iE && !z2) {
            int i3 = iD + 1;
            z2 = ((char) ahVar.c()[iD]) == ')';
            iD = i3;
        }
        return ahVar.c((iD - 1) - ahVar.d()).trim();
    }

    private static void a(ah ahVar, vr vrVar, StringBuilder sb) {
        f(ahVar);
        String strA = a(ahVar, sb);
        if (!"".equals(strA) && Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR.equals(b(ahVar, sb))) {
            f(ahVar);
            String strC = c(ahVar, sb);
            if (strC == null || "".equals(strC)) {
                return;
            }
            int iD = ahVar.d();
            String strB = b(ahVar, sb);
            if (!";".equals(strB)) {
                if (!"}".equals(strB)) {
                    return;
                } else {
                    ahVar.f(iD);
                }
            }
            if ("color".equals(strA)) {
                vrVar.b(s3.a(strC));
                return;
            }
            if ("background-color".equals(strA)) {
                vrVar.a(s3.a(strC));
                return;
            }
            boolean z2 = true;
            if ("ruby-position".equals(strA)) {
                if ("over".equals(strC)) {
                    vrVar.d(1);
                    return;
                } else {
                    if ("under".equals(strC)) {
                        vrVar.d(2);
                        return;
                    }
                    return;
                }
            }
            if ("text-combine-upright".equals(strA)) {
                if (!"all".equals(strC) && !strC.startsWith("digits")) {
                    z2 = false;
                }
                vrVar.b(z2);
                return;
            }
            if ("text-decoration".equals(strA)) {
                if ("underline".equals(strC)) {
                    vrVar.d(true);
                    return;
                }
                return;
            }
            if ("font-family".equals(strA)) {
                vrVar.a(strC);
                return;
            }
            if ("font-weight".equals(strA)) {
                if ("bold".equals(strC)) {
                    vrVar.a(true);
                }
            } else if ("font-style".equals(strA)) {
                if ("italic".equals(strC)) {
                    vrVar.c(true);
                }
            } else if ("font-size".equals(strA)) {
                a(strC, vrVar);
            }
        }
    }

    private static String c(ah ahVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int iD = ahVar.d();
            String strB = b(ahVar, sb);
            if (strB == null) {
                return null;
            }
            if (!"}".equals(strB) && !";".equals(strB)) {
                sb2.append(strB);
            } else {
                ahVar.f(iD);
                z2 = true;
            }
        }
        return sb2.toString();
    }

    private static char a(ah ahVar, int i3) {
        return (char) ahVar.c()[i3];
    }

    private static void a(String str, vr vrVar) {
        Matcher matcher = f64342d.matcher(Ascii.toLowerCase(str));
        if (!matcher.matches()) {
            oc.d("WebvttCssParser", "Invalid font-size: '" + str + "'.");
            return;
        }
        String str2 = (String) b1.a((Object) matcher.group(2));
        str2.getClass();
        switch (str2) {
            case "%":
                vrVar.c(3);
                break;
            case "em":
                vrVar.c(2);
                break;
            case "px":
                vrVar.c(1);
                break;
            default:
                throw new IllegalStateException();
        }
        vrVar.a(Float.parseFloat((String) b1.a((Object) matcher.group(1))));
    }

    private void a(vr vrVar, String str) {
        if ("".equals(str)) {
            return;
        }
        int iIndexOf = str.indexOf(91);
        if (iIndexOf != -1) {
            Matcher matcher = f64341c.matcher(str.substring(iIndexOf));
            if (matcher.matches()) {
                vrVar.d((String) b1.a((Object) matcher.group(1)));
            }
            str = str.substring(0, iIndexOf);
        }
        String[] strArrA = xp.a(str, "\\.");
        String str2 = strArrA[0];
        int iIndexOf2 = str2.indexOf(35);
        if (iIndexOf2 != -1) {
            vrVar.c(str2.substring(0, iIndexOf2));
            vrVar.b(str2.substring(iIndexOf2 + 1));
        } else {
            vrVar.c(str2);
        }
        if (strArrA.length > 1) {
            vrVar.a((String[]) xp.a(strArrA, 1, strArrA.length));
        }
    }
}
