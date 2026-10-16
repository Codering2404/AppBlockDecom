package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiTextViewHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class AppCompatEmojiTextHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextView f1799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final EmojiTextViewHelper f1800b;

    AppCompatEmojiTextHelper(TextView textView) {
        this.f1799a = textView;
        this.f1800b = new EmojiTextViewHelper(textView, false);
    }

    InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f1800b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f1800b.b();
    }

    void c(AttributeSet attributeSet, int i3) {
        TypedArray typedArrayObtainStyledAttributes = this.f1799a.getContext().obtainStyledAttributes(attributeSet, R.styleable.f838i0, i3, 0);
        try {
            int i4 = R.styleable.f889w0;
            boolean z2 = typedArrayObtainStyledAttributes.hasValue(i4) ? typedArrayObtainStyledAttributes.getBoolean(i4, true) : true;
            typedArrayObtainStyledAttributes.recycle();
            e(z2);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    void d(boolean z2) {
        this.f1800b.c(z2);
    }

    void e(boolean z2) {
        this.f1800b.d(z2);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f1800b.e(transformationMethod);
    }
}
