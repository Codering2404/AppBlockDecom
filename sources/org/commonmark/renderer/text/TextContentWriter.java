package org.commonmark.renderer.text;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class TextContentWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Appendable f145589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char f145590b;

    private void a(char c3) {
        try {
            this.f145589a.append(c3);
            this.f145590b = c3;
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    private void b(String str) {
        try {
            this.f145589a.append(str);
            int length = str.length();
            if (length != 0) {
                this.f145590b = str.charAt(length - 1);
            }
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void c() {
        char c3 = this.f145590b;
        if (c3 == 0 || c3 == ':') {
            return;
        }
        a(':');
    }

    public void d() {
        char c3 = this.f145590b;
        if (c3 == 0 || c3 == '\n') {
            return;
        }
        a('\n');
    }

    public void e() {
        char c3 = this.f145590b;
        if (c3 == 0 || c3 == ' ') {
            return;
        }
        a(' ');
    }

    public void f(char c3) {
        a(c3);
    }

    public void g(String str) {
        b(str);
    }

    public void h(String str) {
        b(str.replaceAll("[\\r\\n\\s]+", " "));
    }
}
