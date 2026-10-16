package ru.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class CodeSpan extends MetricAffectingSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147163a;

    public CodeSpan(MarkwonTheme markwonTheme) {
        this.f147163a = markwonTheme;
    }

    private void a(TextPaint textPaint) {
        this.f147163a.c(textPaint);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        a(textPaint);
        textPaint.bgColor = this.f147163a.n(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
