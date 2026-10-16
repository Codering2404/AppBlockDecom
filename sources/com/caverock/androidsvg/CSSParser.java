package com.caverock.androidsvg;

import android.util.Log;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParser;
import com.facebook.share.internal.ShareConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class CSSParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediaType f67307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Source f67308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f67309c;

    /* JADX INFO: renamed from: com.caverock.androidsvg.CSSParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f67310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f67311b;

        static {
            int[] iArr = new int[PseudoClassIdents.values().length];
            f67311b = iArr;
            try {
                iArr[PseudoClassIdents.first_child.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67311b[PseudoClassIdents.last_child.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67311b[PseudoClassIdents.only_child.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67311b[PseudoClassIdents.first_of_type.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67311b[PseudoClassIdents.last_of_type.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f67311b[PseudoClassIdents.only_of_type.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f67311b[PseudoClassIdents.root.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f67311b[PseudoClassIdents.empty.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f67311b[PseudoClassIdents.nth_child.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f67311b[PseudoClassIdents.nth_last_child.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f67311b[PseudoClassIdents.nth_of_type.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f67311b[PseudoClassIdents.nth_last_of_type.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f67311b[PseudoClassIdents.not.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f67311b[PseudoClassIdents.target.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f67311b[PseudoClassIdents.lang.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f67311b[PseudoClassIdents.link.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f67311b[PseudoClassIdents.visited.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f67311b[PseudoClassIdents.hover.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f67311b[PseudoClassIdents.active.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f67311b[PseudoClassIdents.focus.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f67311b[PseudoClassIdents.enabled.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f67311b[PseudoClassIdents.disabled.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f67311b[PseudoClassIdents.checked.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f67311b[PseudoClassIdents.indeterminate.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr2 = new int[AttribOp.values().length];
            f67310a = iArr2;
            try {
                iArr2[AttribOp.EQUALS.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f67310a[AttribOp.INCLUDES.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f67310a[AttribOp.DASHMATCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Attrib {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f67312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AttribOp f67313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f67314c;

        Attrib(String str, AttribOp attribOp, String str2) {
            this.f67312a = str;
            this.f67313b = attribOp;
            this.f67314c = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum AttribOp {
        EXISTS,
        EQUALS,
        INCLUDES,
        DASHMATCH
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CSSTextScanner extends SVGParser.TextScanner {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class AnPlusB {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f67320a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f67321b;

            AnPlusB(int i3, int i4) {
                this.f67320a = i3;
                this.f67321b = i4;
            }
        }

        CSSTextScanner(String str) {
            super(str.replaceAll("(?s)/\\*.*?\\*/", ""));
        }

        private int C(int i3) {
            if (i3 >= 48 && i3 <= 57) {
                return i3 - 48;
            }
            if (i3 >= 65 && i3 <= 70) {
                return i3 - 55;
            }
            if (i3 < 97 || i3 > 102) {
                return -1;
            }
            return i3 - 87;
        }

        private AnPlusB D() {
            IntegerParser integerParserC;
            AnPlusB anPlusB;
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            if (!f('(')) {
                return null;
            }
            A();
            int i4 = 1;
            if (g("odd")) {
                anPlusB = new AnPlusB(2, 1);
            } else {
                if (g("even")) {
                    anPlusB = new AnPlusB(2, 0);
                } else {
                    int i5 = (!f('+') && f('-')) ? -1 : 1;
                    IntegerParser integerParserC2 = IntegerParser.c(this.f67793a, this.f67794b, this.f67795c, false);
                    if (integerParserC2 != null) {
                        this.f67794b = integerParserC2.a();
                    }
                    if (f('n') || f('N')) {
                        if (integerParserC2 == null) {
                            integerParserC2 = new IntegerParser(1L, this.f67794b);
                        }
                        A();
                        boolean zF = f('+');
                        if (!zF && (zF = f('-'))) {
                            i4 = -1;
                        }
                        if (zF) {
                            A();
                            integerParserC = IntegerParser.c(this.f67793a, this.f67794b, this.f67795c, false);
                            if (integerParserC == null) {
                                this.f67794b = i3;
                                return null;
                            }
                            this.f67794b = integerParserC.a();
                            int i6 = i4;
                            i4 = i5;
                            i5 = i6;
                        } else {
                            int i7 = i4;
                            i4 = i5;
                            i5 = i7;
                            integerParserC = null;
                        }
                    } else {
                        integerParserC = integerParserC2;
                        integerParserC2 = null;
                    }
                    anPlusB = new AnPlusB(integerParserC2 == null ? 0 : i4 * integerParserC2.d(), integerParserC != null ? i5 * integerParserC.d() : 0);
                }
            }
            A();
            if (f(')')) {
                return anPlusB;
            }
            this.f67794b = i3;
            return null;
        }

        private String E() {
            if (h()) {
                return null;
            }
            String strQ = q();
            return strQ != null ? strQ : H();
        }

        private List G() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            if (!f('(')) {
                return null;
            }
            A();
            ArrayList arrayList = null;
            do {
                String strH = H();
                if (strH == null) {
                    this.f67794b = i3;
                    return null;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strH);
                A();
            } while (z());
            if (f(')')) {
                return arrayList;
            }
            this.f67794b = i3;
            return null;
        }

        private List K() {
            List list;
            List list2;
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            if (!f('(')) {
                return null;
            }
            A();
            List listL = L();
            if (listL == null) {
                this.f67794b = i3;
                return null;
            }
            if (!f(')')) {
                this.f67794b = i3;
                return null;
            }
            Iterator it = listL.iterator();
            while (it.hasNext() && (list = ((Selector) it.next()).f67377a) != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext() && (list2 = ((SimpleSelector) it2.next()).f67382d) != null) {
                    Iterator it3 = list2.iterator();
                    while (it3.hasNext()) {
                        if (((PseudoClass) it3.next()) instanceof PseudoClassNot) {
                            return null;
                        }
                    }
                }
            }
            return listL;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List L() {
            AnonymousClass1 anonymousClass1 = null;
            if (h()) {
                return null;
            }
            ArrayList arrayList = new ArrayList(1);
            Selector selector = new Selector(anonymousClass1);
            while (!h() && M(selector)) {
                if (z()) {
                    arrayList.add(selector);
                    selector = new Selector(anonymousClass1);
                }
            }
            if (!selector.f()) {
                arrayList.add(selector);
            }
            return arrayList;
        }

        private void O(Selector selector, SimpleSelector simpleSelector) throws CSSParseException {
            PseudoClass pseudoClass;
            PseudoClass pseudoClassAnPlusB;
            PseudoClass pseudoClass2;
            String strH = H();
            if (strH == null) {
                throw new CSSParseException("Invalid pseudo class");
            }
            PseudoClassIdents pseudoClassIdentsA = PseudoClassIdents.a(strH);
            AnonymousClass1 anonymousClass1 = null;
            switch (AnonymousClass1.f67311b[pseudoClassIdentsA.ordinal()]) {
                case 1:
                    PseudoClass pseudoClassAnPlusB2 = new PseudoClassAnPlusB(0, 1, true, false, null);
                    selector.b();
                    pseudoClass2 = pseudoClassAnPlusB2;
                    pseudoClass = pseudoClass2;
                    simpleSelector.b(pseudoClass);
                    return;
                case 2:
                    PseudoClass pseudoClassAnPlusB3 = new PseudoClassAnPlusB(0, 1, false, false, null);
                    selector.b();
                    pseudoClass = pseudoClassAnPlusB3;
                    simpleSelector.b(pseudoClass);
                    return;
                case 3:
                    PseudoClass pseudoClassOnlyChild = new PseudoClassOnlyChild(false, null);
                    selector.b();
                    pseudoClass = pseudoClassOnlyChild;
                    simpleSelector.b(pseudoClass);
                    return;
                case 4:
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(0, 1, true, true, simpleSelector.f67380b);
                    selector.b();
                    pseudoClass = pseudoClassAnPlusB;
                    simpleSelector.b(pseudoClass);
                    return;
                case 5:
                    PseudoClass pseudoClassAnPlusB4 = new PseudoClassAnPlusB(0, 1, false, true, simpleSelector.f67380b);
                    selector.b();
                    pseudoClass = pseudoClassAnPlusB4;
                    simpleSelector.b(pseudoClass);
                    return;
                case 6:
                    PseudoClass pseudoClassOnlyChild2 = new PseudoClassOnlyChild(true, simpleSelector.f67380b);
                    selector.b();
                    pseudoClass = pseudoClassOnlyChild2;
                    simpleSelector.b(pseudoClass);
                    return;
                case 7:
                    PseudoClass pseudoClassRoot = new PseudoClassRoot(anonymousClass1);
                    selector.b();
                    pseudoClass = pseudoClassRoot;
                    simpleSelector.b(pseudoClass);
                    return;
                case 8:
                    PseudoClass pseudoClassEmpty = new PseudoClassEmpty(anonymousClass1);
                    selector.b();
                    pseudoClass = pseudoClassEmpty;
                    simpleSelector.b(pseudoClass);
                    return;
                case 9:
                case 10:
                case 11:
                case 12:
                    boolean z2 = pseudoClassIdentsA == PseudoClassIdents.nth_child || pseudoClassIdentsA == PseudoClassIdents.nth_of_type;
                    boolean z3 = pseudoClassIdentsA == PseudoClassIdents.nth_of_type || pseudoClassIdentsA == PseudoClassIdents.nth_last_of_type;
                    AnPlusB anPlusBD = D();
                    if (anPlusBD == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + strH);
                    }
                    pseudoClassAnPlusB = new PseudoClassAnPlusB(anPlusBD.f67320a, anPlusBD.f67321b, z2, z3, simpleSelector.f67380b);
                    selector.b();
                    pseudoClass = pseudoClassAnPlusB;
                    simpleSelector.b(pseudoClass);
                    return;
                case 13:
                    List listK = K();
                    if (listK == null) {
                        throw new CSSParseException("Invalid or missing parameter section for pseudo class: " + strH);
                    }
                    PseudoClassNot pseudoClassNot = new PseudoClassNot(listK);
                    selector.f67378b = pseudoClassNot.b();
                    pseudoClass2 = pseudoClassNot;
                    pseudoClass = pseudoClass2;
                    simpleSelector.b(pseudoClass);
                    return;
                case 14:
                    PseudoClass pseudoClassTarget = new PseudoClassTarget(anonymousClass1);
                    selector.b();
                    pseudoClass = pseudoClassTarget;
                    simpleSelector.b(pseudoClass);
                    return;
                case 15:
                    G();
                    PseudoClass pseudoClassNotSupported = new PseudoClassNotSupported(strH);
                    selector.b();
                    pseudoClass = pseudoClassNotSupported;
                    simpleSelector.b(pseudoClass);
                    return;
                case 16:
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    PseudoClass pseudoClassNotSupported2 = new PseudoClassNotSupported(strH);
                    selector.b();
                    pseudoClass = pseudoClassNotSupported2;
                    simpleSelector.b(pseudoClass);
                    return;
                default:
                    throw new CSSParseException("Unsupported pseudo class: " + strH);
            }
        }

        private int P() {
            int i3;
            if (h()) {
                return this.f67794b;
            }
            int i4 = this.f67794b;
            int iCharAt = this.f67793a.charAt(i4);
            if (iCharAt == 45) {
                iCharAt = a();
            }
            if ((iCharAt < 65 || iCharAt > 90) && ((iCharAt < 97 || iCharAt > 122) && iCharAt != 95)) {
                i3 = i4;
            } else {
                int iA = a();
                while (true) {
                    if ((iA < 65 || iA > 90) && ((iA < 97 || iA > 122) && !((iA >= 48 && iA <= 57) || iA == 45 || iA == 95))) {
                        break;
                    }
                    iA = a();
                }
                i3 = this.f67794b;
            }
            this.f67794b = i4;
            return i3;
        }

        String F() {
            int iC;
            if (h()) {
                return null;
            }
            char cCharAt = this.f67793a.charAt(this.f67794b);
            if (cCharAt != '\'' && cCharAt != '\"') {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            this.f67794b++;
            int iIntValue = l().intValue();
            while (iIntValue != -1 && iIntValue != cCharAt) {
                if (iIntValue == 92) {
                    iIntValue = l().intValue();
                    if (iIntValue != -1) {
                        if (iIntValue == 10 || iIntValue == 13 || iIntValue == 12) {
                            iIntValue = l().intValue();
                        } else {
                            int iC2 = C(iIntValue);
                            if (iC2 != -1) {
                                for (int i3 = 1; i3 <= 5 && (iC = C((iIntValue = l().intValue()))) != -1; i3++) {
                                    iC2 = (iC2 * 16) + iC;
                                }
                                sb.append((char) iC2);
                            }
                        }
                    }
                }
                sb.append((char) iIntValue);
                iIntValue = l().intValue();
            }
            return sb.toString();
        }

        String H() {
            int iP = P();
            int i3 = this.f67794b;
            if (iP == i3) {
                return null;
            }
            String strSubstring = this.f67793a.substring(i3, iP);
            this.f67794b = iP;
            return strSubstring;
        }

        String I() {
            char cCharAt;
            int iC;
            StringBuilder sb = new StringBuilder();
            while (!h() && (cCharAt = this.f67793a.charAt(this.f67794b)) != '\'' && cCharAt != '\"' && cCharAt != '(' && cCharAt != ')' && !k(cCharAt) && !Character.isISOControl((int) cCharAt)) {
                this.f67794b++;
                if (cCharAt == '\\') {
                    if (!h()) {
                        String str = this.f67793a;
                        int i3 = this.f67794b;
                        this.f67794b = i3 + 1;
                        cCharAt = str.charAt(i3);
                        if (cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\f') {
                            int iC2 = C(cCharAt);
                            if (iC2 != -1) {
                                for (int i4 = 1; i4 <= 5 && !h() && (iC = C(this.f67793a.charAt(this.f67794b))) != -1; i4++) {
                                    this.f67794b++;
                                    iC2 = (iC2 * 16) + iC;
                                }
                                sb.append((char) iC2);
                            }
                        }
                    }
                }
                sb.append(cCharAt);
            }
            if (sb.length() == 0) {
                return null;
            }
            return sb.toString();
        }

        String J() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            int iCharAt = this.f67793a.charAt(i3);
            int i4 = i3;
            while (iCharAt != -1 && iCharAt != 59 && iCharAt != 125 && iCharAt != 33 && !j(iCharAt)) {
                if (!k(iCharAt)) {
                    i4 = this.f67794b + 1;
                }
                iCharAt = a();
            }
            if (this.f67794b > i3) {
                return this.f67793a.substring(i3, i4);
            }
            this.f67794b = i3;
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean M(com.caverock.androidsvg.CSSParser.Selector r11) throws com.caverock.androidsvg.CSSParseException {
            /*
                Method dump skipped, instruction units count: 310
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.caverock.androidsvg.CSSParser.CSSTextScanner.M(com.caverock.androidsvg.CSSParser$Selector):boolean");
        }

        String N() {
            if (h()) {
                return null;
            }
            int i3 = this.f67794b;
            if (!g("url(")) {
                return null;
            }
            A();
            String strF = F();
            if (strF == null) {
                strF = I();
            }
            if (strF == null) {
                this.f67794b = i3;
                return null;
            }
            A();
            if (h() || g(")")) {
                return strF;
            }
            this.f67794b = i3;
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Combinator {
        DESCENDANT,
        CHILD,
        FOLLOWS
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum MediaType {
        all,
        aural,
        braille,
        embossed,
        handheld,
        print,
        projection,
        screen,
        speech,
        tty,
        tv
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface PseudoClass {
        boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassAnPlusB implements PseudoClass {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f67338a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f67339b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f67340c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f67341d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f67342e;

        PseudoClassAnPlusB(int i3, int i4, boolean z2, boolean z3, String str) {
            this.f67338a = i3;
            this.f67339b = i4;
            this.f67340c = z2;
            this.f67341d = z3;
            this.f67342e = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i3;
            int i4;
            String strN = (this.f67341d && this.f67342e == null) ? svgElementBase.n() : this.f67342e;
            SVG.SvgContainer svgContainer = svgElementBase.f67602b;
            if (svgContainer != null) {
                Iterator it = svgContainer.getChildren().iterator();
                i3 = 0;
                i4 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) ((SVG.SvgObject) it.next());
                    if (svgElementBase2 == svgElementBase) {
                        i3 = i4;
                    }
                    if (strN == null || svgElementBase2.n().equals(strN)) {
                        i4++;
                    }
                }
            } else {
                i3 = 0;
                i4 = 1;
            }
            int i5 = this.f67340c ? i3 + 1 : i4 - i3;
            int i6 = this.f67338a;
            if (i6 == 0) {
                return i5 == this.f67339b;
            }
            int i7 = this.f67339b;
            return (i5 - i7) % i6 == 0 && (Integer.signum(i5 - i7) == 0 || Integer.signum(i5 - this.f67339b) == Integer.signum(this.f67338a));
        }

        public String toString() {
            String str = this.f67340c ? "" : "last-";
            return this.f67341d ? String.format("nth-%schild(%dn%+d of type <%s>)", str, Integer.valueOf(this.f67338a), Integer.valueOf(this.f67339b), this.f67342e) : String.format("nth-%schild(%dn%+d)", str, Integer.valueOf(this.f67338a), Integer.valueOf(this.f67339b));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassEmpty implements PseudoClass {
        private PseudoClassEmpty() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return !(svgElementBase instanceof SVG.SvgContainer) || ((SVG.SvgContainer) svgElementBase).getChildren().size() == 0;
        }

        public String toString() {
            return "empty";
        }

        /* synthetic */ PseudoClassEmpty(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum PseudoClassIdents {
        target,
        root,
        nth_child,
        nth_last_child,
        nth_of_type,
        nth_last_of_type,
        first_child,
        last_child,
        first_of_type,
        last_of_type,
        only_child,
        only_of_type,
        empty,
        not,
        lang,
        link,
        visited,
        hover,
        active,
        focus,
        enabled,
        disabled,
        checked,
        indeterminate,
        UNSUPPORTED;

        private static final Map A = new HashMap();

        static {
            for (PseudoClassIdents pseudoClassIdents : values()) {
                if (pseudoClassIdents != UNSUPPORTED) {
                    A.put(pseudoClassIdents.name().replace('_', '-'), pseudoClassIdents);
                }
            }
        }

        public static PseudoClassIdents a(String str) {
            PseudoClassIdents pseudoClassIdents = (PseudoClassIdents) A.get(str);
            return pseudoClassIdents != null ? pseudoClassIdents : UNSUPPORTED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassNot implements PseudoClass {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f67368a;

        PseudoClassNot(List list) {
            this.f67368a = list;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            Iterator it = this.f67368a.iterator();
            while (it.hasNext()) {
                if (CSSParser.l(ruleMatchContext, (Selector) it.next(), svgElementBase)) {
                    return false;
                }
            }
            return true;
        }

        int b() {
            Iterator it = this.f67368a.iterator();
            int i3 = Integer.MIN_VALUE;
            while (it.hasNext()) {
                int i4 = ((Selector) it.next()).f67378b;
                if (i4 > i3) {
                    i3 = i4;
                }
            }
            return i3;
        }

        public String toString() {
            return "not(" + this.f67368a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassNotSupported implements PseudoClass {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f67369a;

        PseudoClassNotSupported(String str) {
            this.f67369a = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return false;
        }

        public String toString() {
            return this.f67369a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassOnlyChild implements PseudoClass {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f67370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f67371b;

        public PseudoClassOnlyChild(boolean z2, String str) {
            this.f67370a = z2;
            this.f67371b = str;
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            int i3;
            String strN = (this.f67370a && this.f67371b == null) ? svgElementBase.n() : this.f67371b;
            SVG.SvgContainer svgContainer = svgElementBase.f67602b;
            if (svgContainer != null) {
                Iterator it = svgContainer.getChildren().iterator();
                i3 = 0;
                while (it.hasNext()) {
                    SVG.SvgElementBase svgElementBase2 = (SVG.SvgElementBase) ((SVG.SvgObject) it.next());
                    if (strN == null || svgElementBase2.n().equals(strN)) {
                        i3++;
                    }
                }
            } else {
                i3 = 1;
            }
            return i3 == 1;
        }

        public String toString() {
            return this.f67370a ? String.format("only-of-type <%s>", this.f67371b) : String.format("only-child", new Object[0]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassRoot implements PseudoClass {
        private PseudoClassRoot() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return svgElementBase.f67602b == null;
        }

        public String toString() {
            return "root";
        }

        /* synthetic */ PseudoClassRoot(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PseudoClassTarget implements PseudoClass {
        private PseudoClassTarget() {
        }

        @Override // com.caverock.androidsvg.CSSParser.PseudoClass
        public boolean a(RuleMatchContext ruleMatchContext, SVG.SvgElementBase svgElementBase) {
            return ruleMatchContext != null && svgElementBase == ruleMatchContext.f67375a;
        }

        public String toString() {
            return "target";
        }

        /* synthetic */ PseudoClassTarget(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Rule {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Selector f67372a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        SVG.Style f67373b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Source f67374c;

        Rule(Selector selector, SVG.Style style, Source source) {
            this.f67372a = selector;
            this.f67373b = style;
            this.f67374c = source;
        }

        public String toString() {
            return String.valueOf(this.f67372a) + " {...} (src=" + this.f67374c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RuleMatchContext {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SVG.SvgElementBase f67375a;

        RuleMatchContext() {
        }

        public String toString() {
            SVG.SvgElementBase svgElementBase = this.f67375a;
            return svgElementBase != null ? String.format("<%s id=\"%s\">", svgElementBase.n(), this.f67375a.f67592c) : "";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Ruleset {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private List f67376a = null;

        Ruleset() {
        }

        void a(Rule rule) {
            if (this.f67376a == null) {
                this.f67376a = new ArrayList();
            }
            for (int i3 = 0; i3 < this.f67376a.size(); i3++) {
                if (((Rule) this.f67376a.get(i3)).f67372a.f67378b > rule.f67372a.f67378b) {
                    this.f67376a.add(i3, rule);
                    return;
                }
            }
            this.f67376a.add(rule);
        }

        void b(Ruleset ruleset) {
            if (ruleset.f67376a == null) {
                return;
            }
            if (this.f67376a == null) {
                this.f67376a = new ArrayList(ruleset.f67376a.size());
            }
            Iterator it = ruleset.f67376a.iterator();
            while (it.hasNext()) {
                a((Rule) it.next());
            }
        }

        List c() {
            return this.f67376a;
        }

        boolean d() {
            List list = this.f67376a;
            return list == null || list.isEmpty();
        }

        void e(Source source) {
            List list = this.f67376a;
            if (list == null) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((Rule) it.next()).f67374c == source) {
                    it.remove();
                }
            }
        }

        int f() {
            List list = this.f67376a;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public String toString() {
            if (this.f67376a == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Iterator it = this.f67376a.iterator();
            while (it.hasNext()) {
                sb.append(((Rule) it.next()).toString());
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SimpleSelector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Combinator f67379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f67380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List f67381c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        List f67382d = null;

        SimpleSelector(Combinator combinator, String str) {
            this.f67379a = null;
            this.f67380b = null;
            this.f67379a = combinator == null ? Combinator.DESCENDANT : combinator;
            this.f67380b = str;
        }

        void a(String str, AttribOp attribOp, String str2) {
            if (this.f67381c == null) {
                this.f67381c = new ArrayList();
            }
            this.f67381c.add(new Attrib(str, attribOp, str2));
        }

        void b(PseudoClass pseudoClass) {
            if (this.f67382d == null) {
                this.f67382d = new ArrayList();
            }
            this.f67382d.add(pseudoClass);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Combinator combinator = this.f67379a;
            if (combinator == Combinator.CHILD) {
                sb.append("> ");
            } else if (combinator == Combinator.FOLLOWS) {
                sb.append("+ ");
            }
            String str = this.f67380b;
            if (str == null) {
                str = "*";
            }
            sb.append(str);
            List<Attrib> list = this.f67381c;
            if (list != null) {
                for (Attrib attrib : list) {
                    sb.append('[');
                    sb.append(attrib.f67312a);
                    int i3 = AnonymousClass1.f67310a[attrib.f67313b.ordinal()];
                    if (i3 == 1) {
                        sb.append('=');
                        sb.append(attrib.f67314c);
                    } else if (i3 == 2) {
                        sb.append("~=");
                        sb.append(attrib.f67314c);
                    } else if (i3 == 3) {
                        sb.append("|=");
                        sb.append(attrib.f67314c);
                    }
                    sb.append(']');
                }
            }
            List<PseudoClass> list2 = this.f67382d;
            if (list2 != null) {
                for (PseudoClass pseudoClass : list2) {
                    sb.append(':');
                    sb.append(pseudoClass);
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Source {
        Document,
        RenderOptions
    }

    CSSParser(Source source) {
        this(MediaType.screen, source);
    }

    private static int a(List list, int i3, SVG.SvgElementBase svgElementBase) {
        int i4 = 0;
        if (i3 < 0) {
            return 0;
        }
        Object obj = list.get(i3);
        SVG.SvgContainer svgContainer = svgElementBase.f67602b;
        if (obj != svgContainer) {
            return -1;
        }
        Iterator it = svgContainer.getChildren().iterator();
        while (it.hasNext()) {
            if (((SVG.SvgObject) it.next()) == svgElementBase) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    static boolean b(String str, MediaType mediaType) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.A();
        return c(h(cSSTextScanner), mediaType);
    }

    private static boolean c(List list, MediaType mediaType) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MediaType mediaType2 = (MediaType) it.next();
            if (mediaType2 == MediaType.all || mediaType2 == mediaType) {
                return true;
            }
        }
        return false;
    }

    private void e(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        String strH = cSSTextScanner.H();
        cSSTextScanner.A();
        if (strH == null) {
            throw new CSSParseException("Invalid '@' rule");
        }
        if (!this.f67309c && strH.equals(ShareConstants.WEB_DIALOG_PARAM_MEDIA)) {
            List listH = h(cSSTextScanner);
            if (!cSSTextScanner.f('{')) {
                throw new CSSParseException("Invalid @media rule: missing rule set");
            }
            cSSTextScanner.A();
            if (c(listH, this.f67307a)) {
                this.f67309c = true;
                ruleset.b(j(cSSTextScanner));
                this.f67309c = false;
            } else {
                j(cSSTextScanner);
            }
            if (!cSSTextScanner.h() && !cSSTextScanner.f('}')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
        } else if (this.f67309c || !strH.equals("import")) {
            p("Ignoring @%s rule", strH);
            o(cSSTextScanner);
        } else {
            String strN = cSSTextScanner.N();
            if (strN == null) {
                strN = cSSTextScanner.F();
            }
            if (strN == null) {
                throw new CSSParseException("Invalid @import rule: expected string or url()");
            }
            cSSTextScanner.A();
            List listH2 = h(cSSTextScanner);
            if (!cSSTextScanner.h() && !cSSTextScanner.f(';')) {
                throw new CSSParseException("Invalid @media rule: expected '}' at end of rule set");
            }
            if (SVG.k() != null && c(listH2, this.f67307a)) {
                String strB = SVG.k().b(strN);
                if (strB == null) {
                    return;
                } else {
                    ruleset.b(d(strB));
                }
            }
        }
        cSSTextScanner.A();
    }

    public static List f(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        ArrayList arrayList = null;
        while (!cSSTextScanner.h()) {
            String strR = cSSTextScanner.r();
            if (strR != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(strR);
                cSSTextScanner.A();
            }
        }
        return arrayList;
    }

    private SVG.Style g(CSSTextScanner cSSTextScanner) throws CSSParseException {
        SVG.Style style = new SVG.Style();
        do {
            String strH = cSSTextScanner.H();
            cSSTextScanner.A();
            if (!cSSTextScanner.f(':')) {
                throw new CSSParseException("Expected ':'");
            }
            cSSTextScanner.A();
            String strJ = cSSTextScanner.J();
            if (strJ == null) {
                throw new CSSParseException("Expected property value");
            }
            cSSTextScanner.A();
            if (cSSTextScanner.f('!')) {
                cSSTextScanner.A();
                if (!cSSTextScanner.g("important")) {
                    throw new CSSParseException("Malformed rule set: found unexpected '!'");
                }
                cSSTextScanner.A();
            }
            cSSTextScanner.f(';');
            SVGParser.S0(style, strH, strJ);
            cSSTextScanner.A();
            if (cSSTextScanner.h()) {
                break;
            }
        } while (!cSSTextScanner.f('}'));
        return style;
    }

    private static List h(CSSTextScanner cSSTextScanner) {
        String strW;
        ArrayList arrayList = new ArrayList();
        while (!cSSTextScanner.h() && (strW = cSSTextScanner.w()) != null) {
            try {
                arrayList.add(MediaType.valueOf(strW));
            } catch (IllegalArgumentException unused) {
            }
            if (!cSSTextScanner.z()) {
                break;
            }
        }
        return arrayList;
    }

    private boolean i(Ruleset ruleset, CSSTextScanner cSSTextScanner) throws CSSParseException {
        List listL = cSSTextScanner.L();
        if (listL == null || listL.isEmpty()) {
            return false;
        }
        if (!cSSTextScanner.f('{')) {
            throw new CSSParseException("Malformed rule block: expected '{'");
        }
        cSSTextScanner.A();
        SVG.Style styleG = g(cSSTextScanner);
        cSSTextScanner.A();
        Iterator it = listL.iterator();
        while (it.hasNext()) {
            ruleset.a(new Rule((Selector) it.next(), styleG, this.f67308b));
        }
        return true;
    }

    private Ruleset j(CSSTextScanner cSSTextScanner) {
        Ruleset ruleset = new Ruleset();
        while (!cSSTextScanner.h()) {
            try {
                if (!cSSTextScanner.g("<!--") && !cSSTextScanner.g("-->")) {
                    if (!cSSTextScanner.f('@')) {
                        if (!i(ruleset, cSSTextScanner)) {
                            break;
                        }
                    } else {
                        e(ruleset, cSSTextScanner);
                    }
                }
            } catch (CSSParseException e3) {
                Log.e("CSSParser", "CSS parser terminated early due to error: " + e3.getMessage());
                return ruleset;
            }
        }
        return ruleset;
    }

    private static boolean k(RuleMatchContext ruleMatchContext, Selector selector, int i3, List list, int i4, SVG.SvgElementBase svgElementBase) {
        SimpleSelector simpleSelectorE = selector.e(i3);
        if (!n(ruleMatchContext, simpleSelectorE, list, i4, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelectorE.f67379a;
        if (combinator == Combinator.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i4 >= 0) {
                if (m(ruleMatchContext, selector, i3 - 1, list, i4)) {
                    return true;
                }
                i4--;
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return m(ruleMatchContext, selector, i3 - 1, list, i4);
        }
        int iA = a(list, i4, svgElementBase);
        if (iA <= 0) {
            return false;
        }
        return k(ruleMatchContext, selector, i3 - 1, list, i4, (SVG.SvgElementBase) svgElementBase.f67602b.getChildren().get(iA - 1));
    }

    static boolean l(RuleMatchContext ruleMatchContext, Selector selector, SVG.SvgElementBase svgElementBase) {
        ArrayList arrayList = new ArrayList();
        for (Object obj = svgElementBase.f67602b; obj != null; obj = ((SVG.SvgObject) obj).f67602b) {
            arrayList.add(0, obj);
        }
        int size = arrayList.size() - 1;
        return selector.g() == 1 ? n(ruleMatchContext, selector.e(0), arrayList, size, svgElementBase) : k(ruleMatchContext, selector, selector.g() - 1, arrayList, size, svgElementBase);
    }

    private static boolean m(RuleMatchContext ruleMatchContext, Selector selector, int i3, List list, int i4) {
        SimpleSelector simpleSelectorE = selector.e(i3);
        SVG.SvgElementBase svgElementBase = (SVG.SvgElementBase) list.get(i4);
        if (!n(ruleMatchContext, simpleSelectorE, list, i4, svgElementBase)) {
            return false;
        }
        Combinator combinator = simpleSelectorE.f67379a;
        if (combinator == Combinator.DESCENDANT) {
            if (i3 == 0) {
                return true;
            }
            while (i4 > 0) {
                i4--;
                if (m(ruleMatchContext, selector, i3 - 1, list, i4)) {
                    return true;
                }
            }
            return false;
        }
        if (combinator == Combinator.CHILD) {
            return m(ruleMatchContext, selector, i3 - 1, list, i4 - 1);
        }
        int iA = a(list, i4, svgElementBase);
        if (iA <= 0) {
            return false;
        }
        return k(ruleMatchContext, selector, i3 - 1, list, i4, (SVG.SvgElementBase) svgElementBase.f67602b.getChildren().get(iA - 1));
    }

    private static boolean n(RuleMatchContext ruleMatchContext, SimpleSelector simpleSelector, List list, int i3, SVG.SvgElementBase svgElementBase) {
        List list2;
        String str = simpleSelector.f67380b;
        if (str != null && !str.equals(svgElementBase.n().toLowerCase(Locale.US))) {
            return false;
        }
        List<Attrib> list3 = simpleSelector.f67381c;
        if (list3 != null) {
            for (Attrib attrib : list3) {
                String str2 = attrib.f67312a;
                str2.getClass();
                if (str2.equals("id")) {
                    if (!attrib.f67314c.equals(svgElementBase.f67592c)) {
                        return false;
                    }
                } else if (!str2.equals("class") || (list2 = svgElementBase.f67596g) == null || !list2.contains(attrib.f67314c)) {
                    return false;
                }
            }
        }
        List list4 = simpleSelector.f67382d;
        if (list4 == null) {
            return true;
        }
        Iterator it = list4.iterator();
        while (it.hasNext()) {
            if (!((PseudoClass) it.next()).a(ruleMatchContext, svgElementBase)) {
                return false;
            }
        }
        return true;
    }

    private void o(CSSTextScanner cSSTextScanner) {
        int i3 = 0;
        while (!cSSTextScanner.h()) {
            int iIntValue = cSSTextScanner.l().intValue();
            if (iIntValue == 59 && i3 == 0) {
                return;
            }
            if (iIntValue == 123) {
                i3++;
            } else if (iIntValue == 125 && i3 > 0 && i3 - 1 == 0) {
                return;
            }
        }
    }

    private static void p(String str, Object... objArr) {
        Log.w("CSSParser", String.format(str, objArr));
    }

    Ruleset d(String str) {
        CSSTextScanner cSSTextScanner = new CSSTextScanner(str);
        cSSTextScanner.A();
        return j(cSSTextScanner);
    }

    CSSParser(MediaType mediaType, Source source) {
        this.f67309c = false;
        this.f67307a = mediaType;
        this.f67308b = source;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Selector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List f67377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f67378b;

        private Selector() {
            this.f67377a = null;
            this.f67378b = 0;
        }

        void a(SimpleSelector simpleSelector) {
            if (this.f67377a == null) {
                this.f67377a = new ArrayList();
            }
            this.f67377a.add(simpleSelector);
        }

        void b() {
            this.f67378b += 1000;
        }

        void c() {
            this.f67378b++;
        }

        void d() {
            this.f67378b += 1000000;
        }

        SimpleSelector e(int i3) {
            return (SimpleSelector) this.f67377a.get(i3);
        }

        boolean f() {
            List list = this.f67377a;
            return list == null || list.isEmpty();
        }

        int g() {
            List list = this.f67377a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.f67377a.iterator();
            while (it.hasNext()) {
                sb.append((SimpleSelector) it.next());
                sb.append(' ');
            }
            sb.append('[');
            sb.append(this.f67378b);
            sb.append(']');
            return sb.toString();
        }

        /* synthetic */ Selector(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
