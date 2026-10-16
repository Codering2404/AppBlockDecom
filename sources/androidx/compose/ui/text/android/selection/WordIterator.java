package androidx.compose.ui.text.android.selection;

import androidx.compose.ui.text.android.CharSequenceCharacterIterator;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import androidx.emoji2.text.EmojiCompat;
import java.lang.Character;
import java.text.BreakIterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class WordIterator {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f29036e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f29037f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharSequence f29038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BreakIterator f29041d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(int i3) {
            int type = Character.getType(i3);
            return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
        }

        private Companion() {
        }
    }

    public WordIterator(CharSequence charSequence, int i3, int i4, Locale locale) {
        this.f29038a = charSequence;
        if (!(i3 >= 0 && i3 <= charSequence.length())) {
            InlineClassHelperKt.a("input start index is outside the CharSequence");
        }
        if (!(i4 >= 0 && i4 <= charSequence.length())) {
            InlineClassHelperKt.a("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.f29041d = wordInstance;
        this.f29039b = Math.max(0, i3 - 50);
        this.f29040c = Math.min(charSequence.length(), i4 + 50);
        wordInstance.setText(new CharSequenceCharacterIterator(charSequence, i3, i4));
    }

    private final void a(int i3) {
        int i4 = this.f29039b;
        boolean z2 = false;
        if (i3 <= this.f29040c && i4 <= i3) {
            z2 = true;
        }
        if (z2) {
            return;
        }
        InlineClassHelperKt.a("Invalid offset: " + i3 + ". Valid range is [" + this.f29039b + " , " + this.f29040c + ']');
    }

    private final int b(int i3, boolean z2) {
        a(i3);
        if (l(i3)) {
            return (!j(i3) || (h(i3) && z2)) ? q(i3) : i3;
        }
        if (h(i3)) {
            return q(i3);
        }
        return -1;
    }

    private final int c(int i3, boolean z2) {
        a(i3);
        if (h(i3)) {
            return (!j(i3) || (l(i3) && z2)) ? p(i3) : i3;
        }
        if (l(i3)) {
            return p(i3);
        }
        return -1;
    }

    private final boolean h(int i3) {
        int i4 = this.f29039b + 1;
        if (i3 > this.f29040c || i4 > i3) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointBefore(this.f29038a, i3))) {
            return true;
        }
        int i5 = i3 - 1;
        if (Character.isSurrogate(this.f29038a.charAt(i5))) {
            return true;
        }
        if (!EmojiCompat.k()) {
            return false;
        }
        EmojiCompat emojiCompatC = EmojiCompat.c();
        return emojiCompatC.g() == 1 && emojiCompatC.f(this.f29038a, i5) != -1;
    }

    private final boolean j(int i3) {
        a(i3);
        if (!this.f29041d.isBoundary(i3)) {
            return false;
        }
        if (l(i3) && l(i3 - 1) && l(i3 + 1)) {
            return false;
        }
        return i3 <= 0 || i3 >= this.f29038a.length() - 1 || !(k(i3) || k(i3 + 1));
    }

    private final boolean k(int i3) {
        int i4 = i3 - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(this.f29038a.charAt(i4));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (Intrinsics.areEqual(unicodeBlockOf, unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(this.f29038a.charAt(i3)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return Intrinsics.areEqual(Character.UnicodeBlock.of(this.f29038a.charAt(i3)), unicodeBlock) && Intrinsics.areEqual(Character.UnicodeBlock.of(this.f29038a.charAt(i4)), Character.UnicodeBlock.KATAKANA);
    }

    private final boolean l(int i3) {
        int i4 = this.f29039b;
        if (i3 >= this.f29040c || i4 > i3) {
            return false;
        }
        if (Character.isLetterOrDigit(Character.codePointAt(this.f29038a, i3)) || Character.isSurrogate(this.f29038a.charAt(i3))) {
            return true;
        }
        if (!EmojiCompat.k()) {
            return false;
        }
        EmojiCompat emojiCompatC = EmojiCompat.c();
        return emojiCompatC.g() == 1 && emojiCompatC.f(this.f29038a, i3) != -1;
    }

    private final boolean n(int i3) {
        return !m(i3) && i(i3);
    }

    private final boolean o(int i3) {
        return m(i3) && !i(i3);
    }

    public final int d(int i3) {
        return c(i3, true);
    }

    public final int e(int i3) {
        return b(i3, true);
    }

    public final int f(int i3) {
        a(i3);
        while (i3 != -1 && !o(i3)) {
            i3 = q(i3);
        }
        return i3;
    }

    public final int g(int i3) {
        a(i3);
        while (i3 != -1 && !n(i3)) {
            i3 = p(i3);
        }
        return i3;
    }

    public final boolean i(int i3) {
        int i4 = this.f29039b + 1;
        if (i3 > this.f29040c || i4 > i3) {
            return false;
        }
        return f29036e.a(Character.codePointBefore(this.f29038a, i3));
    }

    public final boolean m(int i3) {
        int i4 = this.f29039b;
        if (i3 >= this.f29040c || i4 > i3) {
            return false;
        }
        return f29036e.a(Character.codePointAt(this.f29038a, i3));
    }

    public final int p(int i3) {
        a(i3);
        int iFollowing = this.f29041d.following(i3);
        return (l(iFollowing + (-1)) && l(iFollowing) && !k(iFollowing)) ? p(iFollowing) : iFollowing;
    }

    public final int q(int i3) {
        a(i3);
        int iPreceding = this.f29041d.preceding(i3);
        return (l(iPreceding) && h(iPreceding) && !k(iPreceding)) ? q(iPreceding) : iPreceding;
    }
}
