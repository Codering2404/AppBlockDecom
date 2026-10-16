package org.commonmark.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.commonmark.internal.inline.AsteriskDelimiterProcessor;
import org.commonmark.internal.inline.AutolinkInlineParser;
import org.commonmark.internal.inline.BackslashInlineParser;
import org.commonmark.internal.inline.BackticksInlineParser;
import org.commonmark.internal.inline.EntityInlineParser;
import org.commonmark.internal.inline.HtmlInlineParser;
import org.commonmark.internal.inline.InlineContentParser;
import org.commonmark.internal.inline.InlineParserState;
import org.commonmark.internal.inline.ParsedInline;
import org.commonmark.internal.inline.ParsedInlineImpl;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.inline.UnderscoreDelimiterProcessor;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.internal.util.Parsing;
import org.commonmark.node.HardLineBreak;
import org.commonmark.node.Image;
import org.commonmark.node.Link;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.Node;
import org.commonmark.node.SoftLineBreak;
import org.commonmark.node.SourceSpans;
import org.commonmark.node.Text;
import org.commonmark.parser.InlineParser;
import org.commonmark.parser.InlineParserContext;
import org.commonmark.parser.SourceLines;
import org.commonmark.parser.delimiter.DelimiterProcessor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class InlineParserImpl implements InlineParser, InlineParserState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BitSet f145425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f145426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InlineParserContext f145427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f145428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Scanner f145429e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f145430f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f145431g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Delimiter f145432h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bracket f145433i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DelimiterData {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final List f145434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f145435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f145436c;

        DelimiterData(List list, boolean z2, boolean z3) {
            this.f145434a = list;
            this.f145436c = z2;
            this.f145435b = z3;
        }
    }

    public InlineParserImpl(InlineParserContext inlineParserContext) {
        Map mapF = f(inlineParserContext.b());
        this.f145426b = mapF;
        this.f145427c = inlineParserContext;
        HashMap map = new HashMap();
        this.f145428d = map;
        map.put('\\', Collections.singletonList(new BackslashInlineParser()));
        map.put('`', Collections.singletonList(new BackticksInlineParser()));
        map.put('&', Collections.singletonList(new EntityInlineParser()));
        map.put('<', Arrays.asList(new AutolinkInlineParser(), new HtmlInlineParser()));
        this.f145425a = g(mapF.keySet(), map.keySet());
    }

    private DelimiterData B(DelimiterProcessor delimiterProcessor, char c3) {
        boolean z2;
        int iN = this.f145429e.n();
        Position positionO = this.f145429e.o();
        if (this.f145429e.g(c3) < delimiterProcessor.b()) {
            this.f145429e.q(positionO);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        this.f145429e.q(positionO);
        while (this.f145429e.i(c3)) {
            Scanner scanner = this.f145429e;
            arrayList.add(C(scanner.d(positionO, scanner.o())));
            positionO = this.f145429e.o();
        }
        int iM = this.f145429e.m();
        boolean z3 = iN == 0 || Parsing.i(iN);
        boolean z4 = iN == 0 || Parsing.k(iN);
        boolean z5 = iM == 0 || Parsing.i(iM);
        boolean z6 = iM == 0 || Parsing.k(iM);
        boolean z7 = !z6 && (!z5 || z4 || z3);
        boolean z8 = !z4 && (!z3 || z6 || z5);
        if (c3 == '_') {
            z2 = z7 && (!z8 || z3);
            if (!z8 || (z7 && !z5)) {
                z = false;
            }
        } else {
            boolean z9 = z7 && c3 == delimiterProcessor.c();
            z = z8 && c3 == delimiterProcessor.a();
            z2 = z9;
        }
        return new DelimiterData(arrayList, z2, z);
    }

    private Text C(SourceLines sourceLines) {
        Text text = new Text(sourceLines.c());
        text.l(sourceLines.e());
        return text;
    }

    private void c(Bracket bracket) {
        Bracket bracket2 = this.f145433i;
        if (bracket2 != null) {
            bracket2.f145380h = true;
        }
        this.f145433i = bracket;
    }

    private static void d(char c3, DelimiterProcessor delimiterProcessor, Map map) {
        if (((DelimiterProcessor) map.put(Character.valueOf(c3), delimiterProcessor)) == null) {
            return;
        }
        throw new IllegalArgumentException("Delimiter processor conflict with delimiter char '" + c3 + "'");
    }

    private static void e(Iterable iterable, Map map) {
        StaggeredDelimiterProcessor staggeredDelimiterProcessor;
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            DelimiterProcessor delimiterProcessor = (DelimiterProcessor) it.next();
            char c3 = delimiterProcessor.c();
            char cA = delimiterProcessor.a();
            if (c3 == cA) {
                DelimiterProcessor delimiterProcessor2 = (DelimiterProcessor) map.get(Character.valueOf(c3));
                if (delimiterProcessor2 == null || delimiterProcessor2.c() != delimiterProcessor2.a()) {
                    d(c3, delimiterProcessor, map);
                } else {
                    if (delimiterProcessor2 instanceof StaggeredDelimiterProcessor) {
                        staggeredDelimiterProcessor = (StaggeredDelimiterProcessor) delimiterProcessor2;
                    } else {
                        StaggeredDelimiterProcessor staggeredDelimiterProcessor2 = new StaggeredDelimiterProcessor(c3);
                        staggeredDelimiterProcessor2.e(delimiterProcessor2);
                        staggeredDelimiterProcessor = staggeredDelimiterProcessor2;
                    }
                    staggeredDelimiterProcessor.e(delimiterProcessor);
                    map.put(Character.valueOf(c3), staggeredDelimiterProcessor);
                }
            } else {
                d(c3, delimiterProcessor, map);
                d(cA, delimiterProcessor, map);
            }
        }
    }

    public static Map f(List list) {
        HashMap map = new HashMap();
        e(Arrays.asList(new AsteriskDelimiterProcessor(), new UnderscoreDelimiterProcessor()), map);
        e(list, map);
        return map;
    }

    public static BitSet g(Set set, Set set2) {
        BitSet bitSet = new BitSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            bitSet.set(((Character) it.next()).charValue());
        }
        Iterator it2 = set2.iterator();
        while (it2.hasNext()) {
            bitSet.set(((Character) it2.next()).charValue());
        }
        bitSet.set(91);
        bitSet.set(93);
        bitSet.set(33);
        bitSet.set(10);
        return bitSet;
    }

    private void h(Node node) {
        if (node.d() == null) {
            return;
        }
        j(node.d(), node.e());
    }

    private void i(Text text, Text text2, int i3) {
        SourceSpans sourceSpans;
        if (text == null || text2 == null || text == text2) {
            return;
        }
        StringBuilder sb = new StringBuilder(i3);
        sb.append(text.o());
        if (this.f145430f) {
            sourceSpans = new SourceSpans();
            sourceSpans.a(text.h());
        } else {
            sourceSpans = null;
        }
        Node nodeF = text.f();
        Node nodeF2 = text2.f();
        while (nodeF != nodeF2) {
            sb.append(((Text) nodeF).o());
            if (sourceSpans != null) {
                sourceSpans.a(nodeF.h());
            }
            Node nodeF3 = nodeF.f();
            nodeF.n();
            nodeF = nodeF3;
        }
        text.p(sb.toString());
        if (sourceSpans != null) {
            text.l(sourceSpans.d());
        }
    }

    private void j(Node node, Node node2) {
        Text text = null;
        Text text2 = null;
        int length = 0;
        while (node != null) {
            if (node instanceof Text) {
                text2 = (Text) node;
                if (text == null) {
                    text = text2;
                }
                length += text2.o().length();
            } else {
                i(text, text2, length);
                h(node);
                text = null;
                text2 = null;
                length = 0;
            }
            if (node == node2) {
                break;
            } else {
                node = node.f();
            }
        }
        i(text, text2, length);
    }

    private Node k() {
        Position positionO = this.f145429e.o();
        this.f145429e.h();
        if (!this.f145429e.i('[')) {
            Scanner scanner = this.f145429e;
            return C(scanner.d(positionO, scanner.o()));
        }
        Position positionO2 = this.f145429e.o();
        Text textC = C(this.f145429e.d(positionO, positionO2));
        c(Bracket.a(textC, positionO, positionO2, this.f145433i, this.f145432h));
        return textC;
    }

    private Node l() {
        String strQ;
        LinkReferenceDefinition linkReferenceDefinitionA;
        Position positionO = this.f145429e.o();
        this.f145429e.h();
        Position positionO2 = this.f145429e.o();
        Bracket bracket = this.f145433i;
        if (bracket == null) {
            return C(this.f145429e.d(positionO, positionO2));
        }
        if (!bracket.f145379g) {
            z();
            return C(this.f145429e.d(positionO, positionO2));
        }
        String strO = null;
        if (this.f145429e.i('(')) {
            this.f145429e.r();
            String strP = p(this.f145429e);
            if (strP == null) {
                this.f145429e.q(positionO2);
                strQ = null;
            } else {
                if (this.f145429e.r() >= 1) {
                    strQ = r(this.f145429e);
                    this.f145429e.r();
                } else {
                    strQ = null;
                }
                if (!this.f145429e.i(')')) {
                    this.f145429e.q(positionO2);
                    strQ = null;
                }
            }
            strO = strP;
        } else {
            strQ = null;
        }
        if (strO == null) {
            String strQ2 = q(this.f145429e);
            if (strQ2 == null) {
                this.f145429e.q(positionO2);
            }
            if ((strQ2 == null || strQ2.isEmpty()) && !bracket.f145380h) {
                strQ2 = this.f145429e.d(bracket.f145375c, positionO).c();
            }
            if (strQ2 != null && (linkReferenceDefinitionA = this.f145427c.a(strQ2)) != null) {
                strO = linkReferenceDefinitionA.o();
                strQ = linkReferenceDefinitionA.q();
            }
        }
        if (strO == null) {
            z();
            this.f145429e.q(positionO2);
            return C(this.f145429e.d(positionO, positionO2));
        }
        Node image = bracket.f145376d ? new Image(strO, strQ) : new Link(strO, strQ);
        Node nodeF = bracket.f145373a.f();
        while (nodeF != null) {
            Node nodeF2 = nodeF.f();
            image.c(nodeF);
            nodeF = nodeF2;
        }
        if (this.f145430f) {
            Scanner scanner = this.f145429e;
            image.l(scanner.d(bracket.f145374b, scanner.o()).e());
        }
        u(bracket.f145378f);
        h(image);
        bracket.f145373a.n();
        z();
        if (!bracket.f145376d) {
            for (Bracket bracket2 = this.f145433i; bracket2 != null; bracket2 = bracket2.f145377e) {
                if (!bracket2.f145376d) {
                    bracket2.f145379g = false;
                }
            }
        }
        return image;
    }

    private List m(DelimiterProcessor delimiterProcessor, char c3) {
        DelimiterData delimiterDataB = B(delimiterProcessor, c3);
        if (delimiterDataB == null) {
            return null;
        }
        List list = delimiterDataB.f145434a;
        Delimiter delimiter = new Delimiter(list, c3, delimiterDataB.f145436c, delimiterDataB.f145435b, this.f145432h);
        this.f145432h = delimiter;
        Delimiter delimiter2 = delimiter.f145386f;
        if (delimiter2 != null) {
            delimiter2.f145387g = delimiter;
        }
        return list;
    }

    private List n() {
        List listM;
        char cL = this.f145429e.l();
        if (cL == 0) {
            return null;
        }
        if (cL == '\n') {
            return Collections.singletonList(o());
        }
        if (cL == '!') {
            return Collections.singletonList(k());
        }
        if (cL == '[') {
            return Collections.singletonList(s());
        }
        if (cL == ']') {
            return Collections.singletonList(l());
        }
        if (!this.f145425a.get(cL)) {
            return Collections.singletonList(t());
        }
        List list = (List) this.f145428d.get(Character.valueOf(cL));
        if (list != null) {
            Position positionO = this.f145429e.o();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ParsedInline parsedInlineA = ((InlineContentParser) it.next()).a(this);
                if (parsedInlineA instanceof ParsedInlineImpl) {
                    ParsedInlineImpl parsedInlineImpl = (ParsedInlineImpl) parsedInlineA;
                    Node nodeC = parsedInlineImpl.c();
                    this.f145429e.q(parsedInlineImpl.d());
                    if (this.f145430f && nodeC.h().isEmpty()) {
                        Scanner scanner = this.f145429e;
                        nodeC.l(scanner.d(positionO, scanner.o()).e());
                    }
                    return Collections.singletonList(nodeC);
                }
                this.f145429e.q(positionO);
            }
        }
        DelimiterProcessor delimiterProcessor = (DelimiterProcessor) this.f145426b.get(Character.valueOf(cL));
        return (delimiterProcessor == null || (listM = m(delimiterProcessor, cL)) == null) ? Collections.singletonList(t()) : listM;
    }

    private Node o() {
        this.f145429e.h();
        return this.f145431g >= 2 ? new HardLineBreak() : new SoftLineBreak();
    }

    private String p(Scanner scanner) {
        String strC;
        char cL = scanner.l();
        Position positionO = scanner.o();
        if (!LinkScanner.a(scanner)) {
            return null;
        }
        if (cL == '<') {
            String strC2 = scanner.d(positionO, scanner.o()).c();
            strC = strC2.substring(1, strC2.length() - 1);
        } else {
            strC = scanner.d(positionO, scanner.o()).c();
        }
        return Escaping.f(strC);
    }

    private String r(Scanner scanner) {
        Position positionO = scanner.o();
        if (!LinkScanner.d(scanner)) {
            return null;
        }
        String strC = scanner.d(positionO, scanner.o()).c();
        return Escaping.f(strC.substring(1, strC.length() - 1));
    }

    private Node s() {
        Position positionO = this.f145429e.o();
        this.f145429e.h();
        Position positionO2 = this.f145429e.o();
        Text textC = C(this.f145429e.d(positionO, positionO2));
        c(Bracket.b(textC, positionO, positionO2, this.f145433i, this.f145432h));
        return textC;
    }

    private Node t() {
        char cL;
        Position positionO = this.f145429e.o();
        this.f145429e.h();
        while (true) {
            cL = this.f145429e.l();
            if (cL == 0 || this.f145425a.get(cL)) {
                break;
            }
            this.f145429e.h();
        }
        Scanner scanner = this.f145429e;
        SourceLines sourceLinesD = scanner.d(positionO, scanner.o());
        String strC = sourceLinesD.c();
        if (cL == '\n') {
            int iN = Parsing.n(' ', strC, strC.length() - 1, 0) + 1;
            this.f145431g = strC.length() - iN;
            strC = strC.substring(0, iN);
        } else if (cL == 0) {
            strC = strC.substring(0, Parsing.p(strC, strC.length() - 1, 0) + 1);
        }
        Text text = new Text(strC);
        text.l(sourceLinesD.e());
        return text;
    }

    private void u(Delimiter delimiter) {
        boolean z2;
        HashMap map = new HashMap();
        Delimiter delimiter2 = this.f145432h;
        while (delimiter2 != null) {
            Delimiter delimiter3 = delimiter2.f145386f;
            if (delimiter3 == delimiter) {
                break;
            } else {
                delimiter2 = delimiter3;
            }
        }
        while (delimiter2 != null) {
            char c3 = delimiter2.f145382b;
            DelimiterProcessor delimiterProcessor = (DelimiterProcessor) this.f145426b.get(Character.valueOf(c3));
            if (!delimiter2.c() || delimiterProcessor == null) {
                delimiter2 = delimiter2.f145387g;
            } else {
                char c4 = delimiterProcessor.c();
                Delimiter delimiter4 = delimiter2.f145386f;
                int iD = 0;
                boolean z3 = false;
                while (delimiter4 != null && delimiter4 != delimiter && delimiter4 != map.get(Character.valueOf(c3))) {
                    if (delimiter4.g() && delimiter4.f145382b == c4) {
                        iD = delimiterProcessor.d(delimiter4, delimiter2);
                        if (iD > 0) {
                            z2 = true;
                            z3 = true;
                            break;
                        }
                        z3 = true;
                    }
                    delimiter4 = delimiter4.f145386f;
                }
                z2 = false;
                if (z2) {
                    for (int i3 = 0; i3 < iD; i3++) {
                        List list = delimiter4.f145381a;
                        ((Text) list.remove(list.size() - 1)).n();
                    }
                    for (int i4 = 0; i4 < iD; i4++) {
                        ((Text) delimiter2.f145381a.remove(0)).n();
                    }
                    y(delimiter4, delimiter2);
                    if (delimiter4.length() == 0) {
                        w(delimiter4);
                    }
                    if (delimiter2.length() == 0) {
                        Delimiter delimiter5 = delimiter2.f145387g;
                        w(delimiter2);
                        delimiter2 = delimiter5;
                    }
                } else {
                    if (!z3) {
                        map.put(Character.valueOf(c3), delimiter2.f145386f);
                        if (!delimiter2.g()) {
                            x(delimiter2);
                        }
                    }
                    delimiter2 = delimiter2.f145387g;
                }
            }
        }
        while (true) {
            Delimiter delimiter6 = this.f145432h;
            if (delimiter6 == null || delimiter6 == delimiter) {
                return;
            } else {
                x(delimiter6);
            }
        }
    }

    private void v(Delimiter delimiter) {
        Delimiter delimiter2 = delimiter.f145386f;
        if (delimiter2 != null) {
            delimiter2.f145387g = delimiter.f145387g;
        }
        Delimiter delimiter3 = delimiter.f145387g;
        if (delimiter3 == null) {
            this.f145432h = delimiter2;
        } else {
            delimiter3.f145386f = delimiter2;
        }
    }

    private void w(Delimiter delimiter) {
        v(delimiter);
    }

    private void x(Delimiter delimiter) {
        v(delimiter);
    }

    private void y(Delimiter delimiter, Delimiter delimiter2) {
        Delimiter delimiter3 = delimiter2.f145386f;
        while (delimiter3 != null && delimiter3 != delimiter) {
            Delimiter delimiter4 = delimiter3.f145386f;
            x(delimiter3);
            delimiter3 = delimiter4;
        }
    }

    private void z() {
        this.f145433i = this.f145433i.f145377e;
    }

    void A(SourceLines sourceLines) {
        this.f145429e = Scanner.k(sourceLines);
        this.f145430f = !sourceLines.e().isEmpty();
        this.f145431g = 0;
        this.f145432h = null;
        this.f145433i = null;
    }

    @Override // org.commonmark.parser.InlineParser
    public void a(SourceLines sourceLines, Node node) {
        A(sourceLines);
        while (true) {
            List listN = n();
            if (listN == null) {
                u(null);
                h(node);
                return;
            } else {
                Iterator it = listN.iterator();
                while (it.hasNext()) {
                    node.c((Node) it.next());
                }
            }
        }
    }

    @Override // org.commonmark.internal.inline.InlineParserState
    public Scanner b() {
        return this.f145429e;
    }

    String q(Scanner scanner) {
        if (!scanner.i('[')) {
            return null;
        }
        Position positionO = scanner.o();
        if (!LinkScanner.c(scanner)) {
            return null;
        }
        Position positionO2 = scanner.o();
        if (!scanner.i(']')) {
            return null;
        }
        String strC = scanner.d(positionO, positionO2).c();
        if (strC.length() > 999) {
            return null;
        }
        return strC;
    }
}
