package org.commonmark.internal;

import java.util.List;
import org.commonmark.node.Text;
import org.commonmark.parser.delimiter.DelimiterRun;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Delimiter implements DelimiterRun {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f145381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f145382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f145383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f145384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f145385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Delimiter f145386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Delimiter f145387g;

    public Delimiter(List list, char c3, boolean z2, boolean z3, Delimiter delimiter) {
        this.f145381a = list;
        this.f145382b = c3;
        this.f145384d = z2;
        this.f145385e = z3;
        this.f145386f = delimiter;
        this.f145383c = list.size();
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Iterable a(int i3) {
        if (i3 >= 1 && i3 <= length()) {
            List list = this.f145381a;
            return list.subList(list.size() - i3, this.f145381a.size());
        }
        throw new IllegalArgumentException("length must be between 1 and " + length() + ", was " + i3);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Text b() {
        return (Text) this.f145381a.get(0);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean c() {
        return this.f145385e;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Text d() {
        return (Text) this.f145381a.get(r0.size() - 1);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public Iterable e(int i3) {
        if (i3 >= 1 && i3 <= length()) {
            return this.f145381a.subList(0, i3);
        }
        throw new IllegalArgumentException("length must be between 1 and " + length() + ", was " + i3);
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int f() {
        return this.f145383c;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public boolean g() {
        return this.f145384d;
    }

    @Override // org.commonmark.parser.delimiter.DelimiterRun
    public int length() {
        return this.f145381a.size();
    }
}
