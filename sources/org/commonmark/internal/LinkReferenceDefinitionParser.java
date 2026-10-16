package org.commonmark.internal;

import java.util.ArrayList;
import java.util.List;
import org.commonmark.internal.inline.Position;
import org.commonmark.internal.inline.Scanner;
import org.commonmark.internal.util.Escaping;
import org.commonmark.internal.util.LinkScanner;
import org.commonmark.node.LinkReferenceDefinition;
import org.commonmark.node.SourceSpan;
import org.commonmark.parser.SourceLine;
import org.commonmark.parser.SourceLines;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkReferenceDefinitionParser {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private StringBuilder f145441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f145442f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private char f145443g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private StringBuilder f145444h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private State f145437a = State.START_DEFINITION;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f145438b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f145439c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f145440d = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f145445i = false;

    /* JADX INFO: renamed from: org.commonmark.internal.LinkReferenceDefinitionParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f145446a;

        static {
            int[] iArr = new int[State.values().length];
            f145446a = iArr;
            try {
                iArr[State.START_DEFINITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f145446a[State.LABEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f145446a[State.DESTINATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f145446a[State.START_TITLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f145446a[State.TITLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum State {
        START_DEFINITION,
        LABEL,
        DESTINATION,
        START_TITLE,
        TITLE,
        PARAGRAPH
    }

    private boolean b(Scanner scanner) {
        scanner.r();
        Position positionO = scanner.o();
        if (!LinkScanner.a(scanner)) {
            return false;
        }
        String strC = scanner.d(positionO, scanner.o()).c();
        if (strC.startsWith("<")) {
            strC = strC.substring(1, strC.length() - 1);
        }
        this.f145442f = strC;
        int iR = scanner.r();
        if (!scanner.e()) {
            this.f145445i = true;
            this.f145438b.clear();
        } else if (iR == 0) {
            return false;
        }
        this.f145437a = State.START_TITLE;
        return true;
    }

    private void c() {
        if (this.f145445i) {
            String strF = Escaping.f(this.f145442f);
            StringBuilder sb = this.f145444h;
            LinkReferenceDefinition linkReferenceDefinition = new LinkReferenceDefinition(this.f145441e.toString(), strF, sb != null ? Escaping.f(sb.toString()) : null);
            linkReferenceDefinition.l(this.f145440d);
            this.f145440d.clear();
            this.f145439c.add(linkReferenceDefinition);
            this.f145441e = null;
            this.f145445i = false;
            this.f145442f = null;
            this.f145444h = null;
        }
    }

    private boolean g(Scanner scanner) {
        Position positionO = scanner.o();
        if (!LinkScanner.c(scanner)) {
            return false;
        }
        this.f145441e.append(scanner.d(positionO, scanner.o()).c());
        if (!scanner.e()) {
            this.f145441e.append('\n');
            return true;
        }
        if (!scanner.i(']') || !scanner.i(':') || this.f145441e.length() > 999 || Escaping.c(this.f145441e.toString()).isEmpty()) {
            return false;
        }
        this.f145437a = State.DESTINATION;
        scanner.r();
        return true;
    }

    private boolean i(Scanner scanner) {
        scanner.r();
        if (!scanner.i('[')) {
            return false;
        }
        this.f145437a = State.LABEL;
        this.f145441e = new StringBuilder();
        if (scanner.e()) {
            return true;
        }
        this.f145441e.append('\n');
        return true;
    }

    private boolean j(Scanner scanner) {
        scanner.r();
        if (!scanner.e()) {
            this.f145437a = State.START_DEFINITION;
            return true;
        }
        this.f145443g = (char) 0;
        char cL = scanner.l();
        if (cL == '\"' || cL == '\'') {
            this.f145443g = cL;
        } else if (cL == '(') {
            this.f145443g = ')';
        }
        if (this.f145443g != 0) {
            this.f145437a = State.TITLE;
            this.f145444h = new StringBuilder();
            scanner.h();
            if (!scanner.e()) {
                this.f145444h.append('\n');
            }
        } else {
            c();
            this.f145437a = State.START_DEFINITION;
        }
        return true;
    }

    private boolean k(Scanner scanner) {
        Position positionO = scanner.o();
        if (!LinkScanner.e(scanner, this.f145443g)) {
            return false;
        }
        this.f145444h.append(scanner.d(positionO, scanner.o()).c());
        if (!scanner.e()) {
            this.f145444h.append('\n');
            return true;
        }
        scanner.h();
        scanner.r();
        if (scanner.e()) {
            return false;
        }
        this.f145445i = true;
        c();
        this.f145438b.clear();
        this.f145437a = State.START_DEFINITION;
        return true;
    }

    public void a(SourceSpan sourceSpan) {
        this.f145440d.add(sourceSpan);
    }

    List d() {
        c();
        return this.f145439c;
    }

    SourceLines e() {
        return SourceLines.g(this.f145438b);
    }

    List f() {
        return this.f145440d;
    }

    public void h(SourceLine sourceLine) {
        boolean zI;
        this.f145438b.add(sourceLine);
        if (this.f145437a == State.PARAGRAPH) {
            return;
        }
        Scanner scannerK = Scanner.k(SourceLines.h(sourceLine));
        while (scannerK.e()) {
            int i3 = AnonymousClass1.f145446a[this.f145437a.ordinal()];
            if (i3 == 1) {
                zI = i(scannerK);
            } else if (i3 == 2) {
                zI = g(scannerK);
            } else if (i3 == 3) {
                zI = b(scannerK);
            } else if (i3 == 4) {
                zI = j(scannerK);
            } else {
                if (i3 != 5) {
                    throw new IllegalStateException("Unknown parsing state: " + this.f145437a);
                }
                zI = k(scannerK);
            }
            if (!zI) {
                this.f145437a = State.PARAGRAPH;
                return;
            }
        }
    }
}
