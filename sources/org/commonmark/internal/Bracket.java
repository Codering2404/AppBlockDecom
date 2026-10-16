package org.commonmark.internal;

import org.commonmark.internal.inline.Position;
import org.commonmark.node.Text;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class Bracket {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Text f145373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Position f145374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Position f145375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f145376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bracket f145377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Delimiter f145378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f145379g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f145380h = false;

    private Bracket(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter, boolean z2) {
        this.f145373a = text;
        this.f145374b = position;
        this.f145375c = position2;
        this.f145376d = z2;
        this.f145377e = bracket;
        this.f145378f = delimiter;
    }

    public static Bracket a(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, position, position2, bracket, delimiter, true);
    }

    public static Bracket b(Text text, Position position, Position position2, Bracket bracket, Delimiter delimiter) {
        return new Bracket(text, position, position2, bracket, delimiter, false);
    }
}
