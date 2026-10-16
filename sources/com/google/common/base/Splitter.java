package com.google.common.base;

import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Splitter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharMatcher f83355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f83356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Strategy f83357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f83358d;

    /* JADX INFO: renamed from: com.google.common.base.Splitter$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass4 implements Strategy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f83366a;

        @Override // com.google.common.base.Splitter.Strategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
            return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.4.1
                @Override // com.google.common.base.Splitter.SplittingIterator
                public int f(int i3) {
                    int i4 = i3 + AnonymousClass4.this.f83366a;
                    if (i4 < this.f83370c.length()) {
                        return i4;
                    }
                    return -1;
                }

                @Override // com.google.common.base.Splitter.SplittingIterator
                public int e(int i3) {
                    return i3;
                }
            };
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class MapSplitter {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class SplittingIterator extends AbstractIterator<String> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f83370c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final CharMatcher f83371d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f83372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f83373g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f83374h;

        protected SplittingIterator(Splitter splitter, CharSequence charSequence) {
            this.f83371d = splitter.f83355a;
            this.f83372f = splitter.f83356b;
            this.f83374h = splitter.f83358d;
            this.f83370c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iF;
            int i3 = this.f83373g;
            while (true) {
                int i4 = this.f83373g;
                if (i4 == -1) {
                    return (String) b();
                }
                iF = f(i4);
                if (iF == -1) {
                    iF = this.f83370c.length();
                    this.f83373g = -1;
                } else {
                    this.f83373g = e(iF);
                }
                int i5 = this.f83373g;
                if (i5 == i3) {
                    int i6 = i5 + 1;
                    this.f83373g = i6;
                    if (i6 > this.f83370c.length()) {
                        this.f83373g = -1;
                    }
                } else {
                    while (i3 < iF && this.f83371d.o(this.f83370c.charAt(i3))) {
                        i3++;
                    }
                    while (iF > i3 && this.f83371d.o(this.f83370c.charAt(iF - 1))) {
                        iF--;
                    }
                    if (!this.f83372f || i3 != iF) {
                        break;
                    }
                    i3 = this.f83373g;
                }
            }
            int i7 = this.f83374h;
            if (i7 == 1) {
                iF = this.f83370c.length();
                this.f83373g = -1;
                while (iF > i3 && this.f83371d.o(this.f83370c.charAt(iF - 1))) {
                    iF--;
                }
            } else {
                this.f83374h = i7 - 1;
            }
            return this.f83370c.subSequence(i3, iF).toString();
        }

        abstract int e(int i3);

        abstract int f(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface Strategy {
        Iterator a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(Strategy strategy) {
        this(strategy, false, CharMatcher.s(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static Splitter f(char c3) {
        return g(CharMatcher.k(c3));
    }

    public static Splitter g(final CharMatcher charMatcher) {
        Preconditions.t(charMatcher);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.1
            @Override // com.google.common.base.Splitter.Strategy
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.1.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int e(int i3) {
                        return i3 + 1;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    int f(int i3) {
                        return charMatcher.j(this.f83370c, i3);
                    }
                };
            }
        });
    }

    public static Splitter i(String str) {
        return j(Platform.a(str));
    }

    static Splitter j(final CommonPattern commonPattern) {
        Preconditions.m(!commonPattern.b("").d(), "The pattern may not match the empty string: %s", commonPattern);
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.3
            @Override // com.google.common.base.Splitter.Strategy
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                final CommonMatcher commonMatcherB = commonPattern.b(charSequence);
                return new SplittingIterator(this, splitter, charSequence) { // from class: com.google.common.base.Splitter.3.1

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    final /* synthetic */ AnonymousClass3 f83365j;

                    {
                        this.f83365j = this;
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int e(int i3) {
                        return commonMatcherB.a();
                    }

                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int f(int i3) {
                        if (commonMatcherB.c(i3)) {
                            return commonMatcherB.e();
                        }
                        return -1;
                    }
                };
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator m(CharSequence charSequence) {
        return this.f83357c.a(this, charSequence);
    }

    public Splitter e() {
        return new Splitter(this.f83357c, true, this.f83355a, this.f83358d);
    }

    public Iterable k(final CharSequence charSequence) {
        Preconditions.t(charSequence);
        return new Iterable<String>(this) { // from class: com.google.common.base.Splitter.5

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Splitter f83369b;

            {
                this.f83369b = this;
            }

            @Override // java.lang.Iterable
            public Iterator<String> iterator() {
                return this.f83369b.m(charSequence);
            }

            public String toString() {
                Joiner joinerI = Joiner.i(", ");
                StringBuilder sb = new StringBuilder();
                sb.append('[');
                StringBuilder sbC = joinerI.c(sb, this);
                sbC.append(']');
                return sbC.toString();
            }
        };
    }

    public List l(CharSequence charSequence) {
        Preconditions.t(charSequence);
        Iterator itM = m(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itM.hasNext()) {
            arrayList.add((String) itM.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter n() {
        return o(CharMatcher.w());
    }

    public Splitter o(CharMatcher charMatcher) {
        Preconditions.t(charMatcher);
        return new Splitter(this.f83357c, this.f83356b, charMatcher, this.f83358d);
    }

    private Splitter(Strategy strategy, boolean z2, CharMatcher charMatcher, int i3) {
        this.f83357c = strategy;
        this.f83356b = z2;
        this.f83355a = charMatcher;
        this.f83358d = i3;
    }

    public static Splitter h(final String str) {
        boolean z2;
        if (str.length() != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Preconditions.e(z2, qRMDmh.hMKfKloKxQ);
        if (str.length() == 1) {
            return f(str.charAt(0));
        }
        return new Splitter(new Strategy() { // from class: com.google.common.base.Splitter.2
            @Override // com.google.common.base.Splitter.Strategy
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SplittingIterator a(Splitter splitter, CharSequence charSequence) {
                return new SplittingIterator(splitter, charSequence) { // from class: com.google.common.base.Splitter.2.1
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    public int e(int i3) {
                        return i3 + str.length();
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
                    
                        r6 = r6 + 1;
                     */
                    @Override // com.google.common.base.Splitter.SplittingIterator
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public int f(int r6) {
                        /*
                            r5 = this;
                            com.google.common.base.Splitter$2 r0 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r0 = r1
                            int r0 = r0.length()
                            java.lang.CharSequence r1 = r5.f83370c
                            int r1 = r1.length()
                            int r1 = r1 - r0
                        Lf:
                            if (r6 > r1) goto L2d
                            r2 = 0
                        L12:
                            if (r2 >= r0) goto L2c
                            java.lang.CharSequence r3 = r5.f83370c
                            int r4 = r2 + r6
                            char r3 = r3.charAt(r4)
                            com.google.common.base.Splitter$2 r4 = com.google.common.base.Splitter.AnonymousClass2.this
                            java.lang.String r4 = r1
                            char r4 = r4.charAt(r2)
                            if (r3 == r4) goto L29
                            int r6 = r6 + 1
                            goto Lf
                        L29:
                            int r2 = r2 + 1
                            goto L12
                        L2c:
                            return r6
                        L2d:
                            r6 = -1
                            return r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.Splitter.AnonymousClass2.AnonymousClass1.f(int):int");
                    }
                };
            }
        });
    }
}
