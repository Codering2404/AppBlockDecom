package ru.noties.markwon.core.spans;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import ru.noties.markwon.core.MarkwonTheme;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkSpan extends URLSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MarkwonTheme f147169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f147170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Resolver f147171c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Resolver {
        void a(View view, String str);
    }

    public LinkSpan(MarkwonTheme markwonTheme, String str, Resolver resolver) {
        super(str);
        this.f147169a = markwonTheme;
        this.f147170b = str;
        this.f147171c = resolver;
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View view) {
        this.f147171c.a(view, this.f147170b);
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        this.f147169a.g(textPaint);
    }
}
