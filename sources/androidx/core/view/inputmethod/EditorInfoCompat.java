package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.os.BuildCompat;
import androidx.core.util.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EditorInfoCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f34604a = new String[0];

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static void a(EditorInfo editorInfo, CharSequence charSequence, int i3) {
            editorInfo.setInitialSurroundingSubText(charSequence, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api35Impl {
        static void a(EditorInfo editorInfo, boolean z2) {
            editorInfo.setStylusHandwritingEnabled(z2);
        }
    }

    private static boolean a(CharSequence charSequence, int i3, int i4) {
        if (i4 == 0) {
            return Character.isLowSurrogate(charSequence.charAt(i3));
        }
        if (i4 != 1) {
            return false;
        }
        return Character.isHighSurrogate(charSequence.charAt(i3));
    }

    private static boolean b(int i3) {
        int i4 = i3 & 4095;
        return i4 == 129 || i4 == 225 || i4 == 18;
    }

    public static void c(EditorInfo editorInfo, String[] strArr) {
        editorInfo.contentMimeTypes = strArr;
    }

    public static void d(EditorInfo editorInfo, CharSequence charSequence, int i3) {
        Preconditions.h(charSequence);
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(editorInfo, charSequence, i3);
            return;
        }
        int i4 = editorInfo.initialSelStart;
        int i5 = editorInfo.initialSelEnd;
        int i6 = i4 > i5 ? i5 - i3 : i4 - i3;
        int i7 = i4 > i5 ? i4 - i3 : i5 - i3;
        int length = charSequence.length();
        if (i3 < 0 || i6 < 0 || i7 > length) {
            g(editorInfo, null, 0, 0);
            return;
        }
        if (b(editorInfo.inputType)) {
            g(editorInfo, null, 0, 0);
        } else if (length <= 2048) {
            g(editorInfo, charSequence, i6, i7);
        } else {
            h(editorInfo, charSequence, i6, i7);
        }
    }

    public static void e(EditorInfo editorInfo, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(editorInfo, charSequence, 0);
        } else {
            d(editorInfo, charSequence, 0);
        }
    }

    public static void f(EditorInfo editorInfo, boolean z2) {
        if (BuildCompat.d()) {
            Api35Impl.a(editorInfo, z2);
        }
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putBoolean("androidx.core.view.inputmethod.EditorInfoCompat.STYLUS_HANDWRITING_ENABLED", z2);
    }

    private static void g(EditorInfo editorInfo, CharSequence charSequence, int i3, int i4) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i3);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i4);
    }

    private static void h(EditorInfo editorInfo, CharSequence charSequence, int i3, int i4) {
        int i5 = i4 - i3;
        int i6 = i5 > 1024 ? 0 : i5;
        int i7 = 2048 - i6;
        int iMin = Math.min(charSequence.length() - i4, i7 - Math.min(i3, (int) (((double) i7) * 0.8d)));
        int iMin2 = Math.min(i3, i7 - iMin);
        int i8 = i3 - iMin2;
        if (a(charSequence, i8, 0)) {
            i8++;
            iMin2--;
        }
        if (a(charSequence, (i4 + iMin) - 1, 1)) {
            iMin--;
        }
        g(editorInfo, i6 != i5 ? TextUtils.concat(charSequence.subSequence(i8, i8 + iMin2), charSequence.subSequence(i4, iMin + i4)) : charSequence.subSequence(i8, iMin2 + i6 + iMin + i8), iMin2, i6 + iMin2);
    }
}
