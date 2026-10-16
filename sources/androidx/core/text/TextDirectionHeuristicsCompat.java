package androidx.core.text;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TextDirectionHeuristicsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34278a = new TextDirectionHeuristicInternal(null, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34279b = new TextDirectionHeuristicInternal(null, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TextDirectionHeuristicCompat f34283f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class AnyStrong implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final AnyStrong f34284b = new AnyStrong(true);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f34285a;

        private AnyStrong(boolean z2) {
            this.f34285a = z2;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            boolean z2 = false;
            while (i3 < i5) {
                int iA = TextDirectionHeuristicsCompat.a(Character.getDirectionality(charSequence.charAt(i3)));
                if (iA != 0) {
                    if (iA != 1) {
                        continue;
                        i3++;
                        z2 = z2;
                    } else if (!this.f34285a) {
                        return 1;
                    }
                } else if (this.f34285a) {
                    return 0;
                }
                z2 = true;
                i3++;
                z2 = z2;
            }
            if (z2) {
                return this.f34285a ? 1 : 0;
            }
            return 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class FirstStrong implements TextDirectionAlgorithm {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final FirstStrong f34286a = new FirstStrong();

        private FirstStrong() {
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionAlgorithm
        public int a(CharSequence charSequence, int i3, int i4) {
            int i5 = i4 + i3;
            int iB = 2;
            while (i3 < i5 && iB == 2) {
                iB = TextDirectionHeuristicsCompat.b(Character.getDirectionality(charSequence.charAt(i3)));
                i3++;
            }
            return iB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface TextDirectionAlgorithm {
        int a(CharSequence charSequence, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class TextDirectionHeuristicImpl implements TextDirectionHeuristicCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextDirectionAlgorithm f34287a;

        TextDirectionHeuristicImpl(TextDirectionAlgorithm textDirectionAlgorithm) {
            this.f34287a = textDirectionAlgorithm;
        }

        private boolean b(CharSequence charSequence, int i3, int i4) {
            int iA = this.f34287a.a(charSequence, i3, i4);
            if (iA == 0) {
                return true;
            }
            if (iA != 1) {
                return a();
            }
            return false;
        }

        protected abstract boolean a();

        @Override // androidx.core.text.TextDirectionHeuristicCompat
        public boolean isRtl(CharSequence charSequence, int i3, int i4) {
            if (charSequence == null || i3 < 0 || i4 < 0 || charSequence.length() - i4 < i3) {
                throw new IllegalArgumentException();
            }
            return this.f34287a == null ? a() : b(charSequence, i3, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TextDirectionHeuristicInternal extends TextDirectionHeuristicImpl {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f34288b;

        TextDirectionHeuristicInternal(TextDirectionAlgorithm textDirectionAlgorithm, boolean z2) {
            super(textDirectionAlgorithm);
            this.f34288b = z2;
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean a() {
            return this.f34288b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class TextDirectionHeuristicLocale extends TextDirectionHeuristicImpl {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final TextDirectionHeuristicLocale f34289b = new TextDirectionHeuristicLocale();

        TextDirectionHeuristicLocale() {
            super(null);
        }

        @Override // androidx.core.text.TextDirectionHeuristicsCompat.TextDirectionHeuristicImpl
        protected boolean a() {
            return TextUtilsCompat.a(Locale.getDefault()) == 1;
        }
    }

    static {
        FirstStrong firstStrong = FirstStrong.f34286a;
        f34280c = new TextDirectionHeuristicInternal(firstStrong, false);
        f34281d = new TextDirectionHeuristicInternal(firstStrong, true);
        f34282e = new TextDirectionHeuristicInternal(AnyStrong.f34284b, false);
        f34283f = TextDirectionHeuristicLocale.f34289b;
    }

    static int a(int i3) {
        if (i3 != 0) {
            return (i3 == 1 || i3 == 2) ? 0 : 2;
        }
        return 1;
    }

    static int b(int i3) {
        if (i3 != 0) {
            if (i3 == 1 || i3 == 2) {
                return 0;
            }
            switch (i3) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
