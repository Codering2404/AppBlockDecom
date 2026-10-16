package ru.noties.markwon.html;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class TrimmingAppender {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl extends TrimmingAppender {
        Impl() {
        }

        @Override // ru.noties.markwon.html.TrimmingAppender
        void a(Appendable appendable, String str) {
            int length;
            CharSequence charSequence = (CharSequence) appendable;
            int length2 = charSequence.length();
            int length3 = str.length();
            boolean z2 = false;
            for (int i3 = 0; i3 < length3; i3++) {
                char cCharAt = str.charAt(i3);
                if (Character.isWhitespace(cCharAt)) {
                    z2 = true;
                } else {
                    if (z2 && (length = charSequence.length()) > 0 && !Character.isWhitespace(charSequence.charAt(length - 1))) {
                        AppendableUtils.a(appendable, ' ');
                    }
                    AppendableUtils.a(appendable, cCharAt);
                    z2 = false;
                }
            }
            if (!z2 || length2 >= charSequence.length()) {
                return;
            }
            AppendableUtils.a(appendable, ' ');
        }
    }

    TrimmingAppender() {
    }

    static TrimmingAppender b() {
        return new Impl();
    }

    abstract void a(Appendable appendable, String str);
}
