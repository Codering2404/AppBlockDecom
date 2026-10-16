package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.errorprone.annotations.Immutable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Immutable
@ElementTypesAreNonnullByDefault
public final class InternetDomainName {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CharMatcher f85344b = CharMatcher.d(".。．｡");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Splitter f85345c = Splitter.f('.');

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Joiner f85346d = Joiner.h('.');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final CharMatcher f85347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CharMatcher f85348f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final CharMatcher f85349g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final CharMatcher f85350h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f85351a;

    static {
        CharMatcher charMatcherD = CharMatcher.d("-_");
        f85347e = charMatcherD;
        CharMatcher charMatcherH = CharMatcher.h('0', '9');
        f85348f = charMatcherH;
        CharMatcher charMatcherU = CharMatcher.h('a', 'z').u(CharMatcher.h('A', 'Z'));
        f85349g = charMatcherU;
        f85350h = charMatcherH.u(charMatcherU).u(charMatcherD);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InternetDomainName) {
            return this.f85351a.equals(((InternetDomainName) obj).f85351a);
        }
        return false;
    }

    public int hashCode() {
        return this.f85351a.hashCode();
    }

    public String toString() {
        return this.f85351a;
    }
}
