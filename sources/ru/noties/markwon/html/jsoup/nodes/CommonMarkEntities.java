package ru.noties.markwon.html.jsoup.nodes;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Map;
import org.commonmark.internal.util.Html5Entities;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class CommonMarkEntities {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f147225a;

    static {
        Map map;
        try {
            Field declaredField = Html5Entities.class.getDeclaredField("a");
            declaredField.setAccessible(true);
            map = (Map) declaredField.get(null);
        } catch (Throwable th) {
            Map map2 = Collections.EMPTY_MAP;
            th.printStackTrace();
            map = map2;
        }
        f147225a = map;
    }

    public static int a(String str, int[] iArr) {
        String str2 = (String) f147225a.get(str);
        if (str2 == null) {
            return 0;
        }
        int length = str2.length();
        if (length == 1) {
            iArr[0] = str2.charAt(0);
            return length;
        }
        iArr[0] = str2.charAt(0);
        iArr[1] = str2.charAt(1);
        return length;
    }

    public static boolean b(String str) {
        return f147225a.containsKey(str);
    }
}
