package ru.noties.markwon.html.jsoup.helper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Validate {
    public static void a(String str) {
        throw new IllegalArgumentException(str);
    }

    public static void b(boolean z2) {
        if (z2) {
            throw new IllegalArgumentException("Must be false");
        }
    }

    public static void c(boolean z2, String str) {
        if (z2) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(boolean z2) {
        if (!z2) {
            throw new IllegalArgumentException("Must be true");
        }
    }

    public static void e(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("String must not be empty");
        }
    }

    public static void f(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object must not be null");
        }
    }
}
