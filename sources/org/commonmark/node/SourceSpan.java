package org.commonmark.node;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SourceSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f145543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f145544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f145545c;

    private SourceSpan(int i3, int i4, int i5) {
        this.f145543a = i3;
        this.f145544b = i4;
        this.f145545c = i5;
    }

    public static SourceSpan d(int i3, int i4, int i5) {
        return new SourceSpan(i3, i4, i5);
    }

    public int a() {
        return this.f145544b;
    }

    public int b() {
        return this.f145545c;
    }

    public int c() {
        return this.f145543a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SourceSpan sourceSpan = (SourceSpan) obj;
            if (this.f145543a == sourceSpan.f145543a && this.f145544b == sourceSpan.f145544b && this.f145545c == sourceSpan.f145545c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.f145543a), Integer.valueOf(this.f145544b), Integer.valueOf(this.f145545c));
    }

    public String toString() {
        return "SourceSpan{line=" + this.f145543a + ", column=" + this.f145544b + ", length=" + this.f145545c + "}";
    }
}
