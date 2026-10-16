package org.commonmark.renderer.html;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Escaping;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HtmlWriter {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Map f145580c = Collections.EMPTY_MAP;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Appendable f145581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char f145582b;

    protected void a(String str) {
        try {
            this.f145581a.append(str);
            int length = str.length();
            if (length != 0) {
                this.f145582b = str.charAt(length - 1);
            }
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void b() {
        char c3 = this.f145582b;
        if (c3 == 0 || c3 == '\n') {
            return;
        }
        a("\n");
    }

    public void c(String str) {
        a(str);
    }

    public void d(String str) {
        e(str, f145580c);
    }

    public void e(String str, Map map) {
        f(str, map, false);
    }

    public void f(String str, Map map, boolean z2) {
        a("<");
        a(str);
        if (map != null && !map.isEmpty()) {
            for (Map.Entry entry : map.entrySet()) {
                a(" ");
                a(Escaping.b((String) entry.getKey()));
                a("=\"");
                a(Escaping.b((String) entry.getValue()));
                a("\"");
            }
        }
        if (z2) {
            a(" /");
        }
        a(">");
    }

    public void g(String str) {
        a(Escaping.b(str));
    }
}
