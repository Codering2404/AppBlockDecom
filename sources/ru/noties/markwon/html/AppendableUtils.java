package ru.noties.markwon.html;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
abstract class AppendableUtils {
    static void a(Appendable appendable, char c3) {
        try {
            appendable.append(c3);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    static void b(Appendable appendable, CharSequence charSequence) {
        try {
            appendable.append(charSequence);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }
}
