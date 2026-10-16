package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class HtmlCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static Spanned a(String str, int i3) {
            return Html.fromHtml(str, i3);
        }

        static Spanned b(String str, int i3, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
            return Html.fromHtml(str, i3, imageGetter, tagHandler);
        }
    }

    public static Spanned a(String str, int i3) {
        return Api24Impl.a(str, i3);
    }

    public static Spanned b(String str, int i3, Html.ImageGetter imageGetter, Html.TagHandler tagHandler) {
        return Api24Impl.b(str, i3, imageGetter, tagHandler);
    }
}
