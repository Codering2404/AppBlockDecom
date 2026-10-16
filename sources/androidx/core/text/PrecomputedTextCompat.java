package androidx.core.text;

import android.os.Build;
import android.os.Trace;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PrecomputedTextCompat implements Spannable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object f34266f = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Spannable f34267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Params f34268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f34269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PrecomputedText f34270d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TextPaint f34271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextDirectionHeuristic f34272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34273c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34274d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final PrecomputedText.Params f34275e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {
        }

        public Params(PrecomputedText.Params params) {
            this.f34271a = params.getTextPaint();
            this.f34272b = params.getTextDirection();
            this.f34273c = params.getBreakStrategy();
            this.f34274d = params.getHyphenationFrequency();
            this.f34275e = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        public boolean a(Params params) {
            if (this.f34273c == params.b() && this.f34274d == params.c() && this.f34271a.getTextSize() == params.e().getTextSize() && this.f34271a.getTextScaleX() == params.e().getTextScaleX() && this.f34271a.getTextSkewX() == params.e().getTextSkewX() && this.f34271a.getLetterSpacing() == params.e().getLetterSpacing() && TextUtils.equals(this.f34271a.getFontFeatureSettings(), params.e().getFontFeatureSettings()) && this.f34271a.getFlags() == params.e().getFlags() && this.f34271a.getTextLocales().equals(params.e().getTextLocales())) {
                return this.f34271a.getTypeface() == null ? params.e().getTypeface() == null : this.f34271a.getTypeface().equals(params.e().getTypeface());
            }
            return false;
        }

        public int b() {
            return this.f34273c;
        }

        public int c() {
            return this.f34274d;
        }

        public TextDirectionHeuristic d() {
            return this.f34272b;
        }

        public TextPaint e() {
            return this.f34271a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return a(params) && this.f34272b == params.d();
        }

        public int hashCode() {
            return ObjectsCompat.b(Float.valueOf(this.f34271a.getTextSize()), Float.valueOf(this.f34271a.getTextScaleX()), Float.valueOf(this.f34271a.getTextSkewX()), Float.valueOf(this.f34271a.getLetterSpacing()), Integer.valueOf(this.f34271a.getFlags()), this.f34271a.getTextLocales(), this.f34271a.getTypeface(), Boolean.valueOf(this.f34271a.isElegantTextHeight()), this.f34272b, Integer.valueOf(this.f34273c), Integer.valueOf(this.f34274d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f34271a.getTextSize());
            sb.append(", textScaleX=" + this.f34271a.getTextScaleX());
            sb.append(", textSkewX=" + this.f34271a.getTextSkewX());
            sb.append(", letterSpacing=" + this.f34271a.getLetterSpacing());
            sb.append(", elegantTextHeight=" + this.f34271a.isElegantTextHeight());
            sb.append(", textLocale=" + this.f34271a.getTextLocales());
            sb.append(", typeface=" + this.f34271a.getTypeface());
            sb.append(", variationSettings=" + this.f34271a.getFontVariationSettings());
            sb.append(", textDir=" + this.f34272b);
            sb.append(", breakStrategy=" + this.f34273c);
            sb.append(", hyphenationFrequency=" + this.f34274d);
            sb.append("}");
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class PrecomputedTextFutureTask extends FutureTask<PrecomputedTextCompat> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class PrecomputedTextCallback implements Callable<PrecomputedTextCompat> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Params f34276a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private CharSequence f34277b;

            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public PrecomputedTextCompat call() {
                return PrecomputedTextCompat.a(this.f34277b, this.f34276a);
            }
        }
    }

    private PrecomputedTextCompat(CharSequence charSequence, Params params, int[] iArr) {
        this.f34267a = new SpannableString(charSequence);
        this.f34268b = params;
        this.f34269c = iArr;
        this.f34270d = null;
    }

    public static PrecomputedTextCompat a(CharSequence charSequence, Params params) {
        PrecomputedText.Params params2;
        Preconditions.h(charSequence);
        Preconditions.h(params);
        try {
            Trace.beginSection("PrecomputedText");
            if (Build.VERSION.SDK_INT >= 29 && (params2 = params.f34275e) != null) {
                return new PrecomputedTextCompat(PrecomputedText.create(charSequence, params2), params);
            }
            ArrayList arrayList = new ArrayList();
            int length = charSequence.length();
            int i3 = 0;
            while (i3 < length) {
                int iIndexOf = TextUtils.indexOf(charSequence, '\n', i3, length);
                i3 = iIndexOf < 0 ? length : iIndexOf + 1;
                arrayList.add(Integer.valueOf(i3));
            }
            int[] iArr = new int[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            }
            StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), params.e(), Api.BaseClientBuilder.API_PRIORITY_OTHER).setBreakStrategy(params.b()).setHyphenationFrequency(params.c()).setTextDirection(params.d()).build();
            return new PrecomputedTextCompat(charSequence, params, iArr);
        } finally {
            Trace.endSection();
        }
    }

    public Params b() {
        return this.f34268b;
    }

    public PrecomputedText c() {
        Spannable spannable = this.f34267a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i3) {
        return this.f34267a.charAt(i3);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f34267a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f34267a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f34267a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public Object[] getSpans(int i3, int i4, Class cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.f34270d.getSpans(i3, i4, cls) : this.f34267a.getSpans(i3, i4, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f34267a.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i3, int i4, Class cls) {
        return this.f34267a.nextSpanTransition(i3, i4, cls);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f34270d.removeSpan(obj);
        } else {
            this.f34267a.removeSpan(obj);
        }
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i3, int i4, int i5) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        }
        if (Build.VERSION.SDK_INT >= 29) {
            this.f34270d.setSpan(obj, i3, i4, i5);
        } else {
            this.f34267a.setSpan(obj, i3, i4, i5);
        }
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return this.f34267a.subSequence(i3, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f34267a.toString();
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, Params params) {
        this.f34267a = Api28Impl.a(precomputedText);
        this.f34268b = params;
        this.f34269c = null;
        this.f34270d = Build.VERSION.SDK_INT < 29 ? null : precomputedText;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static Spannable a(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }
}
