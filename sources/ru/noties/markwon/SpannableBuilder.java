package ru.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class SpannableBuilder implements Appendable, CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f147092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Deque f147093b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Span {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f147094a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f147095b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f147096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f147097d;

        Span(Object obj, int i3, int i4, int i5) {
            this.f147094a = obj;
            this.f147095b = i3;
            this.f147096c = i4;
            this.f147097d = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SpannableStringBuilderReversed extends SpannableStringBuilder {
        SpannableStringBuilderReversed(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public SpannableBuilder() {
        this("");
    }

    private void e(int i3, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z2 = spanned instanceof SpannableStringBuilderReversed;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z2) {
                    for (int i4 = 0; i4 < length; i4++) {
                        Object obj = spans[i4];
                        i(obj, spanned.getSpanStart(obj) + i3, spanned.getSpanEnd(obj) + i3, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i5 = length - 1; i5 >= 0; i5--) {
                    Object obj2 = spans[i5];
                    i(obj2, spanned.getSpanStart(obj2) + i3, spanned.getSpanEnd(obj2) + i3, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    static boolean g(int i3, int i4, int i5) {
        return i5 > i4 && i4 >= 0 && i5 <= i3;
    }

    public static void j(SpannableBuilder spannableBuilder, Object obj, int i3, int i4) {
        if (obj == null || !g(spannableBuilder.length(), i3, i4)) {
            return;
        }
        if (!obj.getClass().isArray()) {
            spannableBuilder.i(obj, i3, i4, 33);
            return;
        }
        for (Object obj2 : (Object[]) obj) {
            spannableBuilder.i(obj2, i3, i4, 33);
        }
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SpannableBuilder append(char c3) {
        this.f147092a.append(c3);
        return this;
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SpannableBuilder append(CharSequence charSequence) {
        e(length(), charSequence);
        this.f147092a.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SpannableBuilder append(CharSequence charSequence, int i3, int i4) {
        CharSequence charSequenceSubSequence = charSequence.subSequence(i3, i4);
        e(length(), charSequenceSubSequence);
        this.f147092a.append(charSequenceSubSequence);
        return this;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f147092a.charAt(i3);
    }

    public void clear() {
        this.f147092a.setLength(0);
        this.f147093b.clear();
    }

    public SpannableBuilder d(String str) {
        this.f147092a.append(str);
        return this;
    }

    public List f(int i3, int i4) {
        int i5;
        int length = length();
        if (!g(length, i3, i4)) {
            return Collections.EMPTY_LIST;
        }
        if (i3 == 0 && length == i4) {
            ArrayList arrayList = new ArrayList(this.f147093b);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator itDescendingIterator = this.f147093b.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            Span span = (Span) itDescendingIterator.next();
            int i6 = span.f147095b;
            if ((i6 >= i3 && i6 < i4) || (((i5 = span.f147096c) <= i4 && i5 > i3) || (i6 < i3 && i5 > i4))) {
                arrayList2.add(span);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char h() {
        return this.f147092a.charAt(length() - 1);
    }

    public SpannableBuilder i(Object obj, int i3, int i4, int i5) {
        this.f147093b.push(new Span(obj, i3, i4, i5));
        return this;
    }

    public SpannableStringBuilder k() {
        SpannableStringBuilderReversed spannableStringBuilderReversed = new SpannableStringBuilderReversed(this.f147092a);
        for (Span span : this.f147093b) {
            spannableStringBuilderReversed.setSpan(span.f147094a, span.f147095b, span.f147096c, span.f147097d);
        }
        return spannableStringBuilderReversed;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f147092a.length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        List<Span> listF = f(i3, i4);
        if (listF.isEmpty()) {
            return this.f147092a.subSequence(i3, i4);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f147092a.subSequence(i3, i4));
        int length = spannableStringBuilder.length();
        for (Span span : listF) {
            int iMax = Math.max(0, span.f147095b - i3);
            spannableStringBuilder.setSpan(span.f147094a, iMax, Math.max(length, (span.f147096c - span.f147095b) + iMax), span.f147097d);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f147092a.toString();
    }

    public SpannableBuilder(CharSequence charSequence) {
        this.f147093b = new ArrayDeque(8);
        this.f147092a = new StringBuilder(charSequence);
        e(0, charSequence);
    }
}
