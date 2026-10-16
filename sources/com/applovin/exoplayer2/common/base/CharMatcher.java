package com.applovin.exoplayer2.common.base;

import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class CharMatcher implements Predicate<Character> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f57884a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f57885b;

        a(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f57884a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f57885b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return this.f57884a.matches(c3) && this.f57885b.matches(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f57884a.setBits(bitSet2);
            BitSet bitSet3 = new BitSet();
            this.f57885b.setBits(bitSet3);
            bitSet2.and(bitSet3);
            bitSet.or(bitSet2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.f57884a + ", " + this.f57885b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class a0 extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f57886b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final a0 f57887c = new a0();

        a0() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c3) >>> f57886b) == c3;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            for (int i3 = 0; i3 < 32; i3++) {
                bitSet.set("\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt(i3));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b f57888b = new b();

        private b() {
            super("CharMatcher.any()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c3) {
            return charSequence.length() == 0 ? "" : String.valueOf(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            return charSequence.length() - 1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.none();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c3) {
            char[] cArr = new char[charSequence.length()];
            Arrays.fill(cArr, c3);
            return new String(cArr);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return "";
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i3) {
            int length = charSequence.length();
            Preconditions.checkPositionIndex(i3, length);
            if (i3 == length) {
                return -1;
            }
            return i3;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            StringBuilder sb = new StringBuilder(charSequence.length() * charSequence2.length());
            for (int i3 = 0; i3 < charSequence.length(); i3++) {
                sb.append(charSequence2);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char[] f57889a;

        public c(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f57889a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Arrays.binarySearch(this.f57889a, c3) >= 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            for (char c3 : this.f57889a) {
                bitSet.set(c3);
            }
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c3 : this.f57889a) {
                sb.append(CharMatcher.showCharacter(c3));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class d extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final d f57890b = new d();

        d() {
            super("CharMatcher.ascii()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return c3 <= 127;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class e extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f57891a = new e();

        private e() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            if (c3 != ' ' && c3 != 133 && c3 != 5760) {
                if (c3 != 8199) {
                    if (c3 != 8287 && c3 != 12288 && c3 != 8232 && c3 != 8233) {
                        switch (c3) {
                            case '\t':
                            case '\n':
                            case 11:
                            case '\f':
                            case '\r':
                                break;
                            default:
                                if (c3 >= 8192 && c3 <= 8202) {
                                    return true;
                                }
                                break;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class f extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final f f57892d = new f();

        private f() {
            super("CharMatcher.digit()", b(), a());
        }

        private static char[] a() {
            char[] cArr = new char[37];
            for (int i3 = 0; i3 < 37; i3++) {
                cArr[i3] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i3) + '\t');
            }
            return cArr;
        }

        private static char[] b() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class g extends CharMatcher {
        g() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return new v(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class h extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Predicate f57893a;

        h(Predicate predicate) {
            this.f57893a = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return this.f57893a.apply(Character.valueOf(c3));
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f57893a + ")";
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public boolean apply(Character ch) {
            return this.f57893a.apply(Preconditions.checkNotNull(ch));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class i extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f57894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f57895b;

        i(char c3, char c4) {
            Preconditions.checkArgument(c4 >= c3);
            this.f57894a = c3;
            this.f57895b = c4;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return this.f57894a <= c3 && c3 <= this.f57895b;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            bitSet.set(this.f57894a, this.f57895b + 1);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.f57894a) + "', '" + CharMatcher.showCharacter(this.f57895b) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class j extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final j f57896d = new j();

        private j() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class k extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f57897a;

        k(char c3) {
            this.f57897a = c3;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.f57897a) ? this : CharMatcher.none();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return c3 == this.f57897a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.isNot(this.f57897a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.f57897a) ? charMatcher : super.or(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c3) {
            return charSequence.toString().replace(this.f57897a, c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            bitSet.set(this.f57897a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.f57897a) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class l extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f57898a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f57899b;

        l(char c3, char c4) {
            this.f57898a = c3;
            this.f57899b = c4;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return c3 == this.f57898a || c3 == this.f57899b;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            bitSet.set(this.f57898a);
            bitSet.set(this.f57899b);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.f57898a) + CharMatcher.showCharacter(this.f57899b) + "\")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class m extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f57900a;

        m(char c3) {
            this.f57900a = c3;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            return charMatcher.matches(this.f57900a) ? super.and(charMatcher) : charMatcher;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return c3 != this.f57900a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.is(this.f57900a);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return charMatcher.matches(this.f57900a) ? CharMatcher.any() : this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            bitSet.set(0, this.f57900a);
            bitSet.set(this.f57900a + 1, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.f57900a) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class n extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final n f57901a = new n();

        private n() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Character.isDigit(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class o extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final o f57902b = new o();

        private o() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            if (c3 > 31) {
                return c3 >= 127 && c3 <= 159;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class p extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final p f57903a = new p();

        private p() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Character.isLetter(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class q extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final q f57904a = new q();

        private q() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Character.isLetterOrDigit(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class r extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final r f57905a = new r();

        private r() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Character.isLowerCase(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class s extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final s f57906a = new s();

        private s() {
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return Character.isUpperCase(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class t extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57907a;

        t(String str) {
            this.f57907a = (String) Preconditions.checkNotNull(str);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public final String toString() {
            return this.f57907a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class u extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f57908a;

        u(CharMatcher charMatcher) {
            this.f57908a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            return charSequence.length() - this.f57908a.countIn(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return !this.f57908a.matches(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return this.f57908a.matchesNoneOf(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            return this.f57908a.matchesAllOf(charSequence);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return this.f57908a;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            BitSet bitSet2 = new BitSet();
            this.f57908a.setBits(bitSet2);
            bitSet2.flip(0, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            bitSet.or(bitSet2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return this.f57908a + ".negate()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class v extends u {
        v(CharMatcher charMatcher) {
            super(charMatcher);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class w extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final w f57909b = new w();

        private w() {
            super("CharMatcher.none()");
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher and(CharMatcher charMatcher) {
            Preconditions.checkNotNull(charMatcher);
            return this;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String collapseFrom(CharSequence charSequence, char c3) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int countIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int lastIndexIn(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return false;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return true;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher.g, com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher negate() {
            return CharMatcher.any();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public CharMatcher or(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.checkNotNull(charMatcher);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String removeFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, char c3) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence charSequence) {
            return charSequence.toString();
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public int indexIn(CharSequence charSequence, int i3) {
            Preconditions.checkPositionIndex(i3, charSequence.length());
            return -1;
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
            Preconditions.checkNotNull(charSequence2);
            return charSequence.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class x extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f57910a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f57911b;

        x(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f57910a = (CharMatcher) Preconditions.checkNotNull(charMatcher);
            this.f57911b = (CharMatcher) Preconditions.checkNotNull(charMatcher2);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            return this.f57910a.matches(c3) || this.f57911b.matches(c3);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            this.f57910a.setBits(bitSet);
            this.f57911b.setBits(bitSet);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.f57910a + ", " + this.f57911b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class y extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f57912a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f57913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char[] f57914c;

        y(String str, char[] cArr, char[] cArr2) {
            this.f57912a = str;
            this.f57913b = cArr;
            this.f57914c = cArr2;
            Preconditions.checkArgument(cArr.length == cArr2.length);
            int i3 = 0;
            while (i3 < cArr.length) {
                Preconditions.checkArgument(cArr[i3] <= cArr2[i3]);
                int i4 = i3 + 1;
                if (i4 < cArr.length) {
                    Preconditions.checkArgument(cArr2[i3] < cArr[i4]);
                }
                i3 = i4;
            }
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher, com.applovin.exoplayer2.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.apply(ch);
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public boolean matches(char c3) {
            int iBinarySearch = Arrays.binarySearch(this.f57913b, c3);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i3 = (~iBinarySearch) - 1;
            return i3 >= 0 && c3 <= this.f57914c[i3];
        }

        @Override // com.applovin.exoplayer2.common.base.CharMatcher
        public String toString() {
            return this.f57912a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class z extends y {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final z f57915d = new z();

        private z() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    protected CharMatcher() {
    }

    public static CharMatcher any() {
        return b.f57888b;
    }

    public static CharMatcher anyOf(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new c(charSequence) : isEither(charSequence.charAt(0), charSequence.charAt(1)) : is(charSequence.charAt(0)) : none();
    }

    public static CharMatcher ascii() {
        return d.f57890b;
    }

    public static CharMatcher breakingWhitespace() {
        return e.f57891a;
    }

    @Deprecated
    public static CharMatcher digit() {
        return f.f57892d;
    }

    private String finishCollapseFrom(CharSequence charSequence, int i3, int i4, char c3, StringBuilder sb, boolean z2) {
        while (i3 < i4) {
            char cCharAt = charSequence.charAt(i3);
            if (!matches(cCharAt)) {
                sb.append(cCharAt);
                z2 = false;
            } else if (!z2) {
                sb.append(c3);
                z2 = true;
            }
            i3++;
        }
        return sb.toString();
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new h(predicate);
    }

    public static CharMatcher inRange(char c3, char c4) {
        return new i(c3, c4);
    }

    @Deprecated
    public static CharMatcher invisible() {
        return j.f57896d;
    }

    public static CharMatcher is(char c3) {
        return new k(c3);
    }

    private static l isEither(char c3, char c4) {
        return new l(c3, c4);
    }

    public static CharMatcher isNot(char c3) {
        return new m(c3);
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return n.f57901a;
    }

    public static CharMatcher javaIsoControl() {
        return o.f57902b;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return p.f57903a;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return q.f57904a;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return r.f57905a;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return s.f57906a;
    }

    public static CharMatcher none() {
        return w.f57909b;
    }

    public static CharMatcher noneOf(CharSequence charSequence) {
        return anyOf(charSequence).negate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String showCharacter(char c3) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            cArr[5 - i3] = "0123456789ABCDEF".charAt(c3 & 15);
            c3 = (char) (c3 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return z.f57915d;
    }

    public static CharMatcher whitespace() {
        return a0.f57887c;
    }

    public CharMatcher and(CharMatcher charMatcher) {
        return new a(this, charMatcher);
    }

    public String collapseFrom(CharSequence charSequence, char c3) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length) {
            char cCharAt = charSequence.charAt(i3);
            if (matches(cCharAt)) {
                if (cCharAt != c3 || (i3 != length - 1 && matches(charSequence.charAt(i3 + 1)))) {
                    StringBuilder sb = new StringBuilder(length);
                    sb.append(charSequence, 0, i3);
                    sb.append(c3);
                    return finishCollapseFrom(charSequence, i3 + 1, length, c3, sb, true);
                }
                i3++;
            }
            i3++;
            c3 = c3;
        }
        return charSequence.toString();
    }

    public int countIn(CharSequence charSequence) {
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (matches(charSequence.charAt(i4))) {
                i3++;
            }
        }
        return i3;
    }

    public int indexIn(CharSequence charSequence) {
        return indexIn(charSequence, 0);
    }

    public int lastIndexIn(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (matches(charSequence.charAt(length))) {
                return length;
            }
        }
        return -1;
    }

    public abstract boolean matches(char c3);

    public boolean matchesAllOf(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesAnyOf(CharSequence charSequence) {
        return !matchesNoneOf(charSequence);
    }

    public boolean matchesNoneOf(CharSequence charSequence) {
        return indexIn(charSequence) == -1;
    }

    public CharMatcher negate() {
        return new u(this);
    }

    public CharMatcher or(CharMatcher charMatcher) {
        return new x(this, charMatcher);
    }

    public String removeFrom(CharSequence charSequence) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        int i3 = 1;
        while (true) {
            iIndexIn++;
            while (iIndexIn != charArray.length) {
                if (matches(charArray[iIndexIn])) {
                    break;
                }
                charArray[iIndexIn - i3] = charArray[iIndexIn];
                iIndexIn++;
            }
            return new String(charArray, 0, iIndexIn - i3);
            i3++;
        }
    }

    public String replaceFrom(CharSequence charSequence, char c3) {
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        char[] charArray = string.toCharArray();
        charArray[iIndexIn] = c3;
        while (true) {
            iIndexIn++;
            if (iIndexIn >= charArray.length) {
                return new String(charArray);
            }
            if (matches(charArray[iIndexIn])) {
                charArray[iIndexIn] = c3;
            }
        }
    }

    public String retainFrom(CharSequence charSequence) {
        return negate().removeFrom(charSequence);
    }

    void setBits(BitSet bitSet) {
        for (int i3 = 65535; i3 >= 0; i3--) {
            if (matches((char) i3)) {
                bitSet.set(i3);
            }
        }
    }

    public String toString() {
        return super.toString();
    }

    public String trimAndCollapseFrom(CharSequence charSequence, char c3) {
        int length = charSequence.length();
        int i3 = length - 1;
        int i4 = 0;
        while (i4 < length && matches(charSequence.charAt(i4))) {
            i4++;
        }
        int i5 = i3;
        while (i5 > i4 && matches(charSequence.charAt(i5))) {
            i5--;
        }
        if (i4 == 0 && i5 == i3) {
            return collapseFrom(charSequence, c3);
        }
        int i6 = i5 + 1;
        return finishCollapseFrom(charSequence, i4, i6, c3, new StringBuilder(i6 - i4), false);
    }

    public String trimFrom(CharSequence charSequence) {
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && matches(charSequence.charAt(i3))) {
            i3++;
        }
        int i4 = length - 1;
        while (i4 > i3 && matches(charSequence.charAt(i4))) {
            i4--;
        }
        return charSequence.subSequence(i3, i4 + 1).toString();
    }

    public String trimLeadingFrom(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!matches(charSequence.charAt(i3))) {
                return charSequence.subSequence(i3, length).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!matches(charSequence.charAt(length))) {
                return charSequence.subSequence(0, length + 1).toString();
            }
        }
        return "";
    }

    @Override // com.applovin.exoplayer2.common.base.Predicate
    @Deprecated
    public boolean apply(Character ch) {
        return matches(ch.charValue());
    }

    public int indexIn(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        Preconditions.checkPositionIndex(i3, length);
        while (i3 < length) {
            if (matches(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public String replaceFrom(CharSequence charSequence, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (length == 0) {
            return removeFrom(charSequence);
        }
        int i3 = 0;
        if (length == 1) {
            return replaceFrom(charSequence, charSequence2.charAt(0));
        }
        String string = charSequence.toString();
        int iIndexIn = indexIn(string);
        if (iIndexIn == -1) {
            return string;
        }
        int length2 = string.length();
        StringBuilder sb = new StringBuilder(((length2 * 3) / 2) + 16);
        do {
            sb.append((CharSequence) string, i3, iIndexIn);
            sb.append(charSequence2);
            i3 = iIndexIn + 1;
            iIndexIn = indexIn(string, i3);
        } while (iIndexIn != -1);
        sb.append((CharSequence) string, i3, length2);
        return sb.toString();
    }
}
