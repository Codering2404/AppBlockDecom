package com.google.common.base;

import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class CharMatcher implements Predicate<Character> {

    /* JADX INFO: renamed from: com.google.common.base.CharMatcher$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends NegatedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f83231b;

        @Override // com.google.common.base.CharMatcher.Negated, com.google.common.base.CharMatcher
        public String toString() {
            return this.f83231b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class And extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f83232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f83233b;

        And(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f83232a = (CharMatcher) Preconditions.t(charMatcher);
            this.f83233b = (CharMatcher) Preconditions.t(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return this.f83232a.o(c3) && this.f83233b.o(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.and(" + this.f83232a + ", " + this.f83233b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Any extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final CharMatcher f83234b = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.t(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher
        public int g(CharSequence charSequence) {
            return charSequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public int i(CharSequence charSequence) {
            return charSequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int j(CharSequence charSequence, int i3) {
            int length = charSequence.length();
            Preconditions.w(i3, length);
            if (i3 == length) {
                return -1;
            }
            return i3;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean p(CharSequence charSequence) {
            Preconditions.t(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean q(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher r() {
            return CharMatcher.s();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher u(CharMatcher charMatcher) {
            Preconditions.t(charMatcher);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AnyOf extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char[] f83235a;

        public AnyOf(CharSequence charSequence) {
            char[] charArray = charSequence.toString().toCharArray();
            this.f83235a = charArray;
            Arrays.sort(charArray);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Arrays.binarySearch(this.f83235a, c3) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            StringBuilder sb = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c3 : this.f83235a) {
                sb.append(CharMatcher.v(c3));
            }
            sb.append("\")");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Ascii extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final CharMatcher f83236b = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return c3 <= 127;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BitSetMatcher extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BitSet f83237b;

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return this.f83237b.get(c3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class BreakingWhitespace extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83238a = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
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

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Digit extends RangesMatcher {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final CharMatcher f83239d = new Digit();

        private Digit() {
            super("CharMatcher.digit()", y(), x());
        }

        private static char[] x() {
            char[] cArr = new char[37];
            for (int i3 = 0; i3 < 37; i3++) {
                cArr[i3] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".charAt(i3) + '\t');
            }
            return cArr;
        }

        private static char[] y() {
            return "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０".toCharArray();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher r() {
            return new NegatedFastMatcher(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ForPredicate extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Predicate f83240a;

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean apply(Character ch) {
            return this.f83240a.apply(Preconditions.t(ch));
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return this.f83240a.apply(Character.valueOf(c3));
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.forPredicate(" + this.f83240a + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InRange extends FastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f83241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f83242b;

        InRange(char c3, char c4) {
            Preconditions.d(c4 >= c3);
            this.f83241a = c3;
            this.f83242b = c4;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return this.f83241a <= c3 && c3 <= this.f83242b;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.v(this.f83241a) + "', '" + CharMatcher.v(this.f83242b) + "')";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Invisible extends RangesMatcher {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final CharMatcher f83243d = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u0890\u08e2\u1680\u180e\u2000\u2028\u205f\u2066\u3000\ud800\ufeff\ufff9".toCharArray(), "  \u00ad\u0605\u061c\u06dd\u070f\u0891\u08e2\u1680\u180e\u200f \u2064\u206f\u3000\uf8ff\ufeff\ufffb".toCharArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Is extends FastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f83244a;

        Is(char c3) {
            this.f83244a = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.o(this.f83244a) ? this : CharMatcher.s();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return c3 == this.f83244a;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher r() {
            return CharMatcher.m(this.f83244a);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.v(this.f83244a) + "')";
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher u(CharMatcher charMatcher) {
            return charMatcher.o(this.f83244a) ? charMatcher : super.u(charMatcher);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IsEither extends FastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f83245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char f83246b;

        IsEither(char c3, char c4) {
            this.f83245a = c3;
            this.f83246b = c4;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return c3 == this.f83245a || c3 == this.f83246b;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.v(this.f83245a) + CharMatcher.v(this.f83246b) + "\")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IsNot extends FastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final char f83247a;

        IsNot(char c3) {
            this.f83247a = c3;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            return charMatcher.o(this.f83247a) ? super.b(charMatcher) : charMatcher;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return c3 != this.f83247a;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher r() {
            return CharMatcher.k(this.f83247a);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.v(this.f83247a) + "')";
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher u(CharMatcher charMatcher) {
            return charMatcher.o(this.f83247a) ? CharMatcher.c() : this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaDigit extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83248a = new JavaDigit();

        private JavaDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Character.isDigit(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaIsoControl extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final CharMatcher f83249b = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            if (c3 > 31) {
                return c3 >= 127 && c3 <= 159;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaLetter extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83250a = new JavaLetter();

        private JavaLetter() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Character.isLetter(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaLetterOrDigit extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83251a = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Character.isLetterOrDigit(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaLowerCase extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83252a = new JavaLowerCase();

        private JavaLowerCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Character.isLowerCase(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class JavaUpperCase extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final CharMatcher f83253a = new JavaUpperCase();

        private JavaUpperCase() {
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return Character.isUpperCase(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class NamedFastMatcher extends FastMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f83254a;

        NamedFastMatcher(String str) {
            this.f83254a = (String) Preconditions.t(str);
        }

        @Override // com.google.common.base.CharMatcher
        public final String toString() {
            return this.f83254a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Negated extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f83255a;

        Negated(CharMatcher charMatcher) {
            this.f83255a = (CharMatcher) Preconditions.t(charMatcher);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public int g(CharSequence charSequence) {
            return charSequence.length() - this.f83255a.g(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return !this.f83255a.o(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean p(CharSequence charSequence) {
            return this.f83255a.q(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean q(CharSequence charSequence) {
            return this.f83255a.p(charSequence);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher r() {
            return this.f83255a;
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f83255a + ".negate()";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class NegatedFastMatcher extends Negated {
        NegatedFastMatcher(CharMatcher charMatcher) {
            super(charMatcher);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class None extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final CharMatcher f83256b = new None();

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher b(CharMatcher charMatcher) {
            Preconditions.t(charMatcher);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        public int g(CharSequence charSequence) {
            Preconditions.t(charSequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int i(CharSequence charSequence) {
            Preconditions.t(charSequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int j(CharSequence charSequence, int i3) {
            Preconditions.w(i3, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean p(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean q(CharSequence charSequence) {
            Preconditions.t(charSequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher
        public CharMatcher r() {
            return CharMatcher.c();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher u(CharMatcher charMatcher) {
            return (CharMatcher) Preconditions.t(charMatcher);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Or extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final CharMatcher f83257a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final CharMatcher f83258b;

        Or(CharMatcher charMatcher, CharMatcher charMatcher2) {
            this.f83257a = (CharMatcher) Preconditions.t(charMatcher);
            this.f83258b = (CharMatcher) Preconditions.t(charMatcher2);
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return this.f83257a.o(c3) || this.f83258b.o(c3);
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return "CharMatcher.or(" + this.f83257a + ", " + this.f83258b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class RangesMatcher extends CharMatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f83259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final char[] f83260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final char[] f83261c;

        RangesMatcher(String str, char[] cArr, char[] cArr2) {
            this.f83259a = str;
            this.f83260b = cArr;
            this.f83261c = cArr2;
            Preconditions.d(cArr.length == cArr2.length);
            int i3 = 0;
            while (i3 < cArr.length) {
                Preconditions.d(cArr[i3] <= cArr2[i3]);
                int i4 = i3 + 1;
                if (i4 < cArr.length) {
                    Preconditions.d(cArr2[i3] < cArr[i4]);
                }
                i3 = i4;
            }
        }

        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.apply((Character) obj);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            int iBinarySearch = Arrays.binarySearch(this.f83260b, c3);
            if (iBinarySearch >= 0) {
                return true;
            }
            int i3 = (~iBinarySearch) - 1;
            return i3 >= 0 && c3 <= this.f83261c[i3];
        }

        @Override // com.google.common.base.CharMatcher
        public String toString() {
            return this.f83259a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SingleWidth extends RangesMatcher {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        static final CharMatcher f83262d = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Whitespace extends NamedFastMatcher {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final int f83263b = Integer.numberOfLeadingZeros(31);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final CharMatcher f83264c = new Whitespace();

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean o(char c3) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c3) >>> f83263b) == c3;
        }
    }

    protected CharMatcher() {
    }

    public static CharMatcher c() {
        return Any.f83234b;
    }

    public static CharMatcher d(CharSequence charSequence) {
        int length = charSequence.length();
        return length != 0 ? length != 1 ? length != 2 ? new AnyOf(charSequence) : l(charSequence.charAt(0), charSequence.charAt(1)) : k(charSequence.charAt(0)) : s();
    }

    public static CharMatcher f() {
        return Ascii.f83236b;
    }

    public static CharMatcher h(char c3, char c4) {
        return new InRange(c3, c4);
    }

    public static CharMatcher k(char c3) {
        return new Is(c3);
    }

    private static IsEither l(char c3, char c4) {
        return new IsEither(c3, c4);
    }

    public static CharMatcher m(char c3) {
        return new IsNot(c3);
    }

    public static CharMatcher n() {
        return JavaIsoControl.f83249b;
    }

    public static CharMatcher s() {
        return None.f83256b;
    }

    public static CharMatcher t(CharSequence charSequence) {
        return d(charSequence).r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String v(char c3) {
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

    public static CharMatcher w() {
        return Whitespace.f83264c;
    }

    public CharMatcher b(CharMatcher charMatcher) {
        return new And(this, charMatcher);
    }

    @Override // com.google.common.base.Predicate
    /* JADX INFO: renamed from: e */
    public boolean apply(Character ch) {
        return o(ch.charValue());
    }

    public int g(CharSequence charSequence) {
        int i3 = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (o(charSequence.charAt(i4))) {
                i3++;
            }
        }
        return i3;
    }

    public int i(CharSequence charSequence) {
        return j(charSequence, 0);
    }

    public int j(CharSequence charSequence, int i3) {
        int length = charSequence.length();
        Preconditions.w(i3, length);
        while (i3 < length) {
            if (o(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public abstract boolean o(char c3);

    public boolean p(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!o(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public boolean q(CharSequence charSequence) {
        return i(charSequence) == -1;
    }

    public CharMatcher r() {
        return new Negated(this);
    }

    public String toString() {
        return super.toString();
    }

    public CharMatcher u(CharMatcher charMatcher) {
        return new Or(this, charMatcher);
    }
}
