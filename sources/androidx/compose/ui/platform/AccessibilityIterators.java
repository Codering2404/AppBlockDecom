package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AccessibilityIterators {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class AbstractTextSegmentIterator implements TextSegmentIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected String f27648a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f27649b = new int[2];

        protected final int[] c(int i3, int i4) {
            if (i3 < 0 || i4 < 0 || i3 == i4) {
                return null;
            }
            int[] iArr = this.f27649b;
            iArr[0] = i3;
            iArr[1] = i4;
            return iArr;
        }

        protected final String d() {
            String str = this.f27648a;
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("text");
            return null;
        }

        public void e(String str) {
            f(str);
        }

        protected final void f(String str) {
            this.f27648a = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class CharacterTextSegmentIterator extends AbstractTextSegmentIterator {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f27650d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f27651e = 8;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static CharacterTextSegmentIterator f27652f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BreakIterator f27653c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final CharacterTextSegmentIterator a(Locale locale) {
                if (CharacterTextSegmentIterator.f27652f == null) {
                    CharacterTextSegmentIterator.f27652f = new CharacterTextSegmentIterator(locale, null);
                }
                CharacterTextSegmentIterator characterTextSegmentIterator = CharacterTextSegmentIterator.f27652f;
                Intrinsics.checkNotNull(characterTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
                return characterTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        private final void i(Locale locale) {
            this.f27653c = BreakIterator.getCharacterInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] a(int i3) {
            int length = d().length();
            if (length <= 0 || i3 >= length) {
                return null;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            do {
                BreakIterator breakIterator = this.f27653c;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i3)) {
                    BreakIterator breakIterator2 = this.f27653c;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    int iFollowing = breakIterator2.following(i3);
                    if (iFollowing == -1) {
                        return null;
                    }
                    return c(i3, iFollowing);
                }
                BreakIterator breakIterator3 = this.f27653c;
                if (breakIterator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator3 = null;
                }
                i3 = breakIterator3.following(i3);
            } while (i3 != -1);
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] b(int i3) {
            int length = d().length();
            if (length <= 0 || i3 <= 0) {
                return null;
            }
            if (i3 > length) {
                i3 = length;
            }
            do {
                BreakIterator breakIterator = this.f27653c;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i3)) {
                    BreakIterator breakIterator2 = this.f27653c;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    int iPreceding = breakIterator2.preceding(i3);
                    if (iPreceding == -1) {
                        return null;
                    }
                    return c(iPreceding, i3);
                }
                BreakIterator breakIterator3 = this.f27653c;
                if (breakIterator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator3 = null;
                }
                i3 = breakIterator3.preceding(i3);
            } while (i3 != -1);
            return null;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void e(String str) {
            super.e(str);
            BreakIterator breakIterator = this.f27653c;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        private CharacterTextSegmentIterator(Locale locale) {
            i(locale);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class LineTextSegmentIterator extends AbstractTextSegmentIterator {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static LineTextSegmentIterator f27656f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextLayoutResult f27659c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f27654d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f27655e = 8;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final ResolvedTextDirection f27657g = ResolvedTextDirection.f29613b;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final ResolvedTextDirection f27658h = ResolvedTextDirection.f29612a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final LineTextSegmentIterator a() {
                if (LineTextSegmentIterator.f27656f == null) {
                    LineTextSegmentIterator.f27656f = new LineTextSegmentIterator(null);
                }
                LineTextSegmentIterator lineTextSegmentIterator = LineTextSegmentIterator.f27656f;
                Intrinsics.checkNotNull(lineTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
                return lineTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ LineTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int i(int i3, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.f27659c;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int iU = textLayoutResult.u(i3);
            TextLayoutResult textLayoutResult3 = this.f27659c;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.y(iU)) {
                TextLayoutResult textLayoutResult4 = this.f27659c;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.u(i3);
            }
            TextLayoutResult textLayoutResult5 = this.f27659c;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.p(textLayoutResult5, i3, false, 2, null) - 1;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] a(int i3) {
            int iQ;
            if (d().length() <= 0 || i3 >= d().length()) {
                return null;
            }
            if (i3 < 0) {
                TextLayoutResult textLayoutResult = this.f27659c;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                iQ = textLayoutResult.q(0);
            } else {
                TextLayoutResult textLayoutResult2 = this.f27659c;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int iQ2 = textLayoutResult2.q(i3);
                iQ = i(iQ2, f27657g) == i3 ? iQ2 : iQ2 + 1;
            }
            TextLayoutResult textLayoutResult3 = this.f27659c;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (iQ >= textLayoutResult3.n()) {
                return null;
            }
            return c(i(iQ, f27657g), i(iQ, f27658h) + 1);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] b(int i3) {
            int iQ;
            if (d().length() <= 0 || i3 <= 0) {
                return null;
            }
            if (i3 > d().length()) {
                TextLayoutResult textLayoutResult = this.f27659c;
                if (textLayoutResult == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult = null;
                }
                iQ = textLayoutResult.q(d().length());
            } else {
                TextLayoutResult textLayoutResult2 = this.f27659c;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int iQ2 = textLayoutResult2.q(i3);
                iQ = i(iQ2, f27658h) + 1 == i3 ? iQ2 : iQ2 - 1;
            }
            if (iQ < 0) {
                return null;
            }
            return c(i(iQ, f27657g), i(iQ, f27658h) + 1);
        }

        public final void j(String str, TextLayoutResult textLayoutResult) {
            f(str);
            this.f27659c = textLayoutResult;
        }

        private LineTextSegmentIterator() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PageTextSegmentIterator extends AbstractTextSegmentIterator {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static PageTextSegmentIterator f27662h;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private TextLayoutResult f27665c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private SemanticsNode f27666d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Rect f27667e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f27660f = new Companion(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f27661g = 8;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final ResolvedTextDirection f27663i = ResolvedTextDirection.f29613b;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final ResolvedTextDirection f27664j = ResolvedTextDirection.f29612a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final PageTextSegmentIterator a() {
                if (PageTextSegmentIterator.f27662h == null) {
                    PageTextSegmentIterator.f27662h = new PageTextSegmentIterator(null);
                }
                PageTextSegmentIterator pageTextSegmentIterator = PageTextSegmentIterator.f27662h;
                Intrinsics.checkNotNull(pageTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
                return pageTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ PageTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int i(int i3, ResolvedTextDirection resolvedTextDirection) {
            TextLayoutResult textLayoutResult = this.f27665c;
            TextLayoutResult textLayoutResult2 = null;
            if (textLayoutResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult = null;
            }
            int iU = textLayoutResult.u(i3);
            TextLayoutResult textLayoutResult3 = this.f27665c;
            if (textLayoutResult3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult3 = null;
            }
            if (resolvedTextDirection != textLayoutResult3.y(iU)) {
                TextLayoutResult textLayoutResult4 = this.f27665c;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                } else {
                    textLayoutResult2 = textLayoutResult4;
                }
                return textLayoutResult2.u(i3);
            }
            TextLayoutResult textLayoutResult5 = this.f27665c;
            if (textLayoutResult5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                textLayoutResult5 = null;
            }
            return TextLayoutResult.p(textLayoutResult5, i3, false, 2, null) - 1;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] a(int i3) {
            int iN;
            TextLayoutResult textLayoutResult = null;
            if (d().length() <= 0 || i3 >= d().length()) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.f27666d;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                androidx.compose.ui.geometry.Rect rectI = semanticsNode.i();
                int iRound = Math.round(rectI.i() - rectI.r());
                int iF = RangesKt.f(0, i3);
                TextLayoutResult textLayoutResult2 = this.f27665c;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int iQ = textLayoutResult2.q(iF);
                TextLayoutResult textLayoutResult3 = this.f27665c;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float fV = textLayoutResult3.v(iQ) + iRound;
                TextLayoutResult textLayoutResult4 = this.f27665c;
                if (textLayoutResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult4 = null;
                }
                TextLayoutResult textLayoutResult5 = this.f27665c;
                if (textLayoutResult5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult5 = null;
                }
                if (fV < textLayoutResult4.v(textLayoutResult5.n() - 1)) {
                    TextLayoutResult textLayoutResult6 = this.f27665c;
                    if (textLayoutResult6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult6;
                    }
                    iN = textLayoutResult.r(fV);
                } else {
                    TextLayoutResult textLayoutResult7 = this.f27665c;
                    if (textLayoutResult7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult7;
                    }
                    iN = textLayoutResult.n();
                }
                return c(iF, i(iN - 1, f27664j) + 1);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] b(int i3) {
            int iR;
            TextLayoutResult textLayoutResult = null;
            if (d().length() <= 0 || i3 <= 0) {
                return null;
            }
            try {
                SemanticsNode semanticsNode = this.f27666d;
                if (semanticsNode == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("node");
                    semanticsNode = null;
                }
                androidx.compose.ui.geometry.Rect rectI = semanticsNode.i();
                int iRound = Math.round(rectI.i() - rectI.r());
                int iK = RangesKt.k(d().length(), i3);
                TextLayoutResult textLayoutResult2 = this.f27665c;
                if (textLayoutResult2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult2 = null;
                }
                int iQ = textLayoutResult2.q(iK);
                TextLayoutResult textLayoutResult3 = this.f27665c;
                if (textLayoutResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    textLayoutResult3 = null;
                }
                float fV = textLayoutResult3.v(iQ) - iRound;
                if (fV > 0.0f) {
                    TextLayoutResult textLayoutResult4 = this.f27665c;
                    if (textLayoutResult4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("layoutResult");
                    } else {
                        textLayoutResult = textLayoutResult4;
                    }
                    iR = textLayoutResult.r(fV);
                } else {
                    iR = 0;
                }
                if (iK == d().length() && iR < iQ) {
                    iR++;
                }
                return c(i(iR, f27663i), iK);
            } catch (IllegalStateException unused) {
                return null;
            }
        }

        public final void j(String str, TextLayoutResult textLayoutResult, SemanticsNode semanticsNode) {
            f(str);
            this.f27665c = textLayoutResult;
            this.f27666d = semanticsNode;
        }

        private PageTextSegmentIterator() {
            this.f27667e = new Rect();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ParagraphTextSegmentIterator extends AbstractTextSegmentIterator {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f27668c = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static ParagraphTextSegmentIterator f27669d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final ParagraphTextSegmentIterator a() {
                if (ParagraphTextSegmentIterator.f27669d == null) {
                    ParagraphTextSegmentIterator.f27669d = new ParagraphTextSegmentIterator(null);
                }
                ParagraphTextSegmentIterator paragraphTextSegmentIterator = ParagraphTextSegmentIterator.f27669d;
                Intrinsics.checkNotNull(paragraphTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.ParagraphTextSegmentIterator");
                return paragraphTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ ParagraphTextSegmentIterator(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean i(int i3) {
            if (i3 <= 0 || d().charAt(i3 - 1) == '\n') {
                return false;
            }
            return i3 == d().length() || d().charAt(i3) == '\n';
        }

        private final boolean j(int i3) {
            if (d().charAt(i3) != '\n') {
                return i3 == 0 || d().charAt(i3 - 1) == '\n';
            }
            return false;
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] a(int i3) {
            int length = d().length();
            if (length <= 0 || i3 >= length) {
                return null;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            while (i3 < length && d().charAt(i3) == '\n' && !j(i3)) {
                i3++;
            }
            if (i3 >= length) {
                return null;
            }
            int i4 = i3 + 1;
            while (i4 < length && !i(i4)) {
                i4++;
            }
            return c(i3, i4);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] b(int i3) {
            int length = d().length();
            if (length <= 0 || i3 <= 0) {
                return null;
            }
            if (i3 > length) {
                i3 = length;
            }
            while (i3 > 0 && d().charAt(i3 - 1) == '\n' && !i(i3)) {
                i3--;
            }
            if (i3 <= 0) {
                return null;
            }
            int i4 = i3 - 1;
            while (i4 > 0 && !j(i4)) {
                i4--;
            }
            return c(i4, i3);
        }

        private ParagraphTextSegmentIterator() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface TextSegmentIterator {
        int[] a(int i3);

        int[] b(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class WordTextSegmentIterator extends AbstractTextSegmentIterator {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f27670d = new Companion(null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f27671e = 8;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static WordTextSegmentIterator f27672f;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private BreakIterator f27673c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final WordTextSegmentIterator a(Locale locale) {
                if (WordTextSegmentIterator.f27672f == null) {
                    WordTextSegmentIterator.f27672f = new WordTextSegmentIterator(locale, null);
                }
                WordTextSegmentIterator wordTextSegmentIterator = WordTextSegmentIterator.f27672f;
                Intrinsics.checkNotNull(wordTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
                return wordTextSegmentIterator;
            }

            private Companion() {
            }
        }

        public /* synthetic */ WordTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
            this(locale);
        }

        private final boolean i(int i3) {
            if (i3 <= 0 || !j(i3 - 1)) {
                return false;
            }
            return i3 == d().length() || !j(i3);
        }

        private final boolean j(int i3) {
            if (i3 < 0 || i3 >= d().length()) {
                return false;
            }
            return Character.isLetterOrDigit(d().codePointAt(i3));
        }

        private final boolean k(int i3) {
            if (j(i3)) {
                return i3 == 0 || !j(i3 - 1);
            }
            return false;
        }

        private final void l(Locale locale) {
            this.f27673c = BreakIterator.getWordInstance(locale);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] a(int i3) {
            if (d().length() <= 0 || i3 >= d().length()) {
                return null;
            }
            if (i3 < 0) {
                i3 = 0;
            }
            while (!j(i3) && !k(i3)) {
                BreakIterator breakIterator = this.f27673c;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i3 = breakIterator.following(i3);
                if (i3 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.f27673c;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int iFollowing = breakIterator2.following(i3);
            if (iFollowing == -1 || !i(iFollowing)) {
                return null;
            }
            return c(i3, iFollowing);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.TextSegmentIterator
        public int[] b(int i3) {
            int length = d().length();
            if (length <= 0 || i3 <= 0) {
                return null;
            }
            if (i3 > length) {
                i3 = length;
            }
            while (i3 > 0 && !j(i3 - 1) && !i(i3)) {
                BreakIterator breakIterator = this.f27673c;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                i3 = breakIterator.preceding(i3);
                if (i3 == -1) {
                    return null;
                }
            }
            BreakIterator breakIterator2 = this.f27673c;
            if (breakIterator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator2 = null;
            }
            int iPreceding = breakIterator2.preceding(i3);
            if (iPreceding == -1 || !k(iPreceding)) {
                return null;
            }
            return c(iPreceding, i3);
        }

        @Override // androidx.compose.ui.platform.AccessibilityIterators.AbstractTextSegmentIterator
        public void e(String str) {
            super.e(str);
            BreakIterator breakIterator = this.f27673c;
            if (breakIterator == null) {
                Intrinsics.throwUninitializedPropertyAccessException("impl");
                breakIterator = null;
            }
            breakIterator.setText(str);
        }

        private WordTextSegmentIterator(Locale locale) {
            l(locale);
        }
    }
}
