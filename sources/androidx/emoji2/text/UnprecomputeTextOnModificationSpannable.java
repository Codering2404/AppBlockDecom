package androidx.emoji2.text;

import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import androidx.core.text.PrecomputedTextCompat;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f36946a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Spannable f36947b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class CharSequenceHelper_API24 {
        static IntStream a(CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream b(CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PrecomputedTextDetector {
        PrecomputedTextDetector() {
        }

        boolean a(CharSequence charSequence) {
            return charSequence instanceof PrecomputedTextCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PrecomputedTextDetector_28 extends PrecomputedTextDetector {
        PrecomputedTextDetector_28() {
        }

        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector
        boolean a(CharSequence charSequence) {
            return (charSequence instanceof PrecomputedText) || (charSequence instanceof PrecomputedTextCompat);
        }
    }

    UnprecomputeTextOnModificationSpannable(Spannable spannable) {
        this.f36947b = spannable;
    }

    private void a() {
        Spannable spannable = this.f36947b;
        if (!this.f36946a && c().a(spannable)) {
            this.f36947b = new SpannableString(spannable);
        }
        this.f36946a = true;
    }

    static PrecomputedTextDetector c() {
        return new PrecomputedTextDetector_28();
    }

    Spannable b() {
        return this.f36947b;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f36947b.charAt(i3);
    }

    @Override // java.lang.CharSequence
    public IntStream chars() {
        return CharSequenceHelper_API24.a(this.f36947b);
    }

    @Override // java.lang.CharSequence
    public IntStream codePoints() {
        return CharSequenceHelper_API24.b(this.f36947b);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f36947b.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f36947b.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f36947b.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        return this.f36947b.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f36947b.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f36947b.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        a();
        this.f36947b.removeSpan(obj);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        a();
        this.f36947b.setSpan(obj, i3, i4, i5);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f36947b.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f36947b.toString();
    }

    UnprecomputeTextOnModificationSpannable(CharSequence charSequence) {
        this.f36947b = new SpannableString(charSequence);
    }
}
