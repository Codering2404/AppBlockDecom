package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TextDrawableHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f81287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f81288d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextAppearance f81291g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextPaint f81285a = new TextPaint(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TextAppearanceFontCallback f81286b = new TextAppearanceFontCallback() { // from class: com.google.android.material.internal.TextDrawableHelper.1
        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void a(int i3) {
            TextDrawableHelper.this.f81289e = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f81290f.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }

        @Override // com.google.android.material.resources.TextAppearanceFontCallback
        public void b(Typeface typeface, boolean z2) {
            if (z2) {
                return;
            }
            TextDrawableHelper.this.f81289e = true;
            TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) TextDrawableHelper.this.f81290f.get();
            if (textDrawableDelegate != null) {
                textDrawableDelegate.a();
            }
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f81289e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private WeakReference f81290f = new WeakReference(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface TextDrawableDelegate {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public TextDrawableHelper(TextDrawableDelegate textDrawableDelegate) {
        j(textDrawableDelegate);
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f81285a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f81285a.measureText(charSequence, 0, charSequence.length());
    }

    private void i(String str) {
        this.f81287c = d(str);
        this.f81288d = c(str);
        this.f81289e = false;
    }

    public TextAppearance e() {
        return this.f81291g;
    }

    public float f(String str) {
        if (!this.f81289e) {
            return this.f81288d;
        }
        i(str);
        return this.f81288d;
    }

    public TextPaint g() {
        return this.f81285a;
    }

    public float h(String str) {
        if (!this.f81289e) {
            return this.f81287c;
        }
        i(str);
        return this.f81287c;
    }

    public void j(TextDrawableDelegate textDrawableDelegate) {
        this.f81290f = new WeakReference(textDrawableDelegate);
    }

    public void k(TextAppearance textAppearance, Context context) {
        if (this.f81291g != textAppearance) {
            this.f81291g = textAppearance;
            if (textAppearance != null) {
                textAppearance.o(context, this.f81285a, this.f81286b);
                TextDrawableDelegate textDrawableDelegate = (TextDrawableDelegate) this.f81290f.get();
                if (textDrawableDelegate != null) {
                    this.f81285a.drawableState = textDrawableDelegate.getState();
                }
                textAppearance.n(context, this.f81285a, this.f81286b);
                this.f81289e = true;
            }
            TextDrawableDelegate textDrawableDelegate2 = (TextDrawableDelegate) this.f81290f.get();
            if (textDrawableDelegate2 != null) {
                textDrawableDelegate2.a();
                textDrawableDelegate2.onStateChange(textDrawableDelegate2.getState());
            }
        }
    }

    public void l(boolean z2) {
        this.f81289e = z2;
    }

    public void m(boolean z2) {
        this.f81289e = z2;
    }

    public void n(Context context) {
        this.f81291g.n(context, this.f81285a, this.f81286b);
    }
}
