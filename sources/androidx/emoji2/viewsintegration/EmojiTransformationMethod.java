package androidx.emoji2.viewsintegration;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class EmojiTransformationMethod implements TransformationMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransformationMethod f37021a;

    EmojiTransformationMethod(TransformationMethod transformationMethod) {
        this.f37021a = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f37021a;
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f37021a;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || EmojiCompat.c().g() != 1) ? charSequence : EmojiCompat.c().r(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z2, int i3, Rect rect) {
        TransformationMethod transformationMethod = this.f37021a;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z2, i3, rect);
        }
    }
}
