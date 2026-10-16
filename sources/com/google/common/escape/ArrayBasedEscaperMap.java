package com.google.common.escape;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ArrayBasedEscaperMap {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[][] f84875b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[][] f84876a;

    private ArrayBasedEscaperMap(char[][] cArr) {
        this.f84876a = cArr;
    }

    public static ArrayBasedEscaperMap a(Map map) {
        return new ArrayBasedEscaperMap(b(map));
    }

    static char[][] b(Map map) {
        Preconditions.t(map);
        if (map.isEmpty()) {
            return f84875b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
        for (Character ch : map.keySet()) {
            cArr[ch.charValue()] = ((String) map.get(ch)).toCharArray();
        }
        return cArr;
    }

    char[][] c() {
        return this.f84876a;
    }
}
