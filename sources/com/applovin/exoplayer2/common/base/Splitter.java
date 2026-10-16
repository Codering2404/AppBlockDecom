package com.applovin.exoplayer2.common.base;

import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Splitter {
    private final int limit;
    private final boolean omitEmptyStrings;
    private final e strategy;
    private final CharMatcher trimmer;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharMatcher f57950a;

        /* JADX INFO: renamed from: com.applovin.exoplayer2.common.base.Splitter$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0094a extends d {
            C0094a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            int a(int i3) {
                return i3 + 1;
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            int b(int i3) {
                return a.this.f57950a.indexIn(this.f57956c, i3);
            }
        }

        a(CharMatcher charMatcher) {
            this.f57950a = charMatcher;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new C0094a(splitter, charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f57952a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends d {
            a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int a(int i3) {
                return i3 + b.this.f57952a.length();
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
            
                r6 = r6 + 1;
             */
            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public int b(int r6) {
                /*
                    r5 = this;
                    com.applovin.exoplayer2.common.base.Splitter$b r0 = com.applovin.exoplayer2.common.base.Splitter.b.this
                    java.lang.String r0 = r0.f57952a
                    int r0 = r0.length()
                    java.lang.CharSequence r1 = r5.f57956c
                    int r1 = r1.length()
                    int r1 = r1 - r0
                Lf:
                    if (r6 > r1) goto L2d
                    r2 = 0
                L12:
                    if (r2 >= r0) goto L2c
                    java.lang.CharSequence r3 = r5.f57956c
                    int r4 = r2 + r6
                    char r3 = r3.charAt(r4)
                    com.applovin.exoplayer2.common.base.Splitter$b r4 = com.applovin.exoplayer2.common.base.Splitter.b.this
                    java.lang.String r4 = r4.f57952a
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
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.common.base.Splitter.b.a.b(int):int");
            }
        }

        b(String str) {
            this.f57952a = str;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class d extends com.applovin.exoplayer2.common.base.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final CharSequence f57956c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final CharMatcher f57957d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f57958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f57959g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f57960h;

        protected d(Splitter splitter, CharSequence charSequence) {
            this.f57957d = splitter.trimmer;
            this.f57958f = splitter.omitEmptyStrings;
            this.f57960h = splitter.limit;
            this.f57956c = charSequence;
        }

        abstract int a(int i3);

        abstract int b(int i3);

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.applovin.exoplayer2.common.base.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int iB;
            int i3 = this.f57959g;
            while (true) {
                int i4 = this.f57959g;
                if (i4 == -1) {
                    return (String) b();
                }
                iB = b(i4);
                if (iB == -1) {
                    iB = this.f57956c.length();
                    this.f57959g = -1;
                } else {
                    this.f57959g = a(iB);
                }
                int i5 = this.f57959g;
                if (i5 == i3) {
                    int i6 = i5 + 1;
                    this.f57959g = i6;
                    if (i6 > this.f57956c.length()) {
                        this.f57959g = -1;
                    }
                } else {
                    while (i3 < iB && this.f57957d.matches(this.f57956c.charAt(i3))) {
                        i3++;
                    }
                    while (iB > i3 && this.f57957d.matches(this.f57956c.charAt(iB - 1))) {
                        iB--;
                    }
                    if (!this.f57958f || i3 != iB) {
                        break;
                    }
                    i3 = this.f57959g;
                }
            }
            int i7 = this.f57960h;
            if (i7 == 1) {
                iB = this.f57956c.length();
                this.f57959g = -1;
                while (iB > i3 && this.f57957d.matches(this.f57956c.charAt(iB - 1))) {
                    iB--;
                }
            } else {
                this.f57960h = i7 - 1;
            }
            return this.f57956c.subSequence(i3, iB).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface e {
        Iterator a(Splitter splitter, CharSequence charSequence);
    }

    private Splitter(e eVar) {
        this(eVar, false, CharMatcher.none(), Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static Splitter fixedLength(int i3) {
        Preconditions.checkArgument(i3 > 0, "The length may not be less than 1");
        return new Splitter(new c(i3));
    }

    public static Splitter on(char c3) {
        return on(CharMatcher.is(c3));
    }

    private Iterator<String> splittingIterator(CharSequence charSequence) {
        return this.strategy.a(this, charSequence);
    }

    public Splitter limit(int i3) {
        Preconditions.checkArgument(i3 > 0, "must be greater than zero: %s", i3);
        return new Splitter(this.strategy, this.omitEmptyStrings, this.trimmer, i3);
    }

    public Splitter omitEmptyStrings() {
        return new Splitter(this.strategy, true, this.trimmer, this.limit);
    }

    public List<String> splitToList(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        Iterator<String> itSplittingIterator = splittingIterator(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itSplittingIterator.hasNext()) {
            arrayList.add(itSplittingIterator.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Splitter trimResults() {
        return trimResults(CharMatcher.whitespace());
    }

    private Splitter(e eVar, boolean z2, CharMatcher charMatcher, int i3) {
        this.strategy = eVar;
        this.omitEmptyStrings = z2;
        this.trimmer = charMatcher;
        this.limit = i3;
    }

    public static Splitter on(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(new a(charMatcher));
    }

    public Splitter trimResults(CharMatcher charMatcher) {
        Preconditions.checkNotNull(charMatcher);
        return new Splitter(this.strategy, this.omitEmptyStrings, charMatcher, this.limit);
    }

    public static Splitter on(String str) {
        Preconditions.checkArgument(str.length() != 0, "The separator may not be the empty string.");
        if (str.length() == 1) {
            return on(str.charAt(0));
        }
        return new Splitter(new b(str));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f57954a;

        c(int i3) {
            this.f57954a = i3;
        }

        @Override // com.applovin.exoplayer2.common.base.Splitter.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Splitter splitter, CharSequence charSequence) {
            return new a(splitter, charSequence);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends d {
            a(Splitter splitter, CharSequence charSequence) {
                super(splitter, charSequence);
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int b(int i3) {
                int i4 = i3 + c.this.f57954a;
                if (i4 < this.f57956c.length()) {
                    return i4;
                }
                return -1;
            }

            @Override // com.applovin.exoplayer2.common.base.Splitter.d
            public int a(int i3) {
                return i3;
            }
        }
    }
}
