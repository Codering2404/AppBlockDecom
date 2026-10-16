package com.google.android.gms.common.util;

import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class CollectionUtils {
    public static List a(Object obj) {
        return Collections.singletonList(obj);
    }

    public static List b(Object... objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(objArr)) : Collections.singletonList(objArr[0]) : Collections.EMPTY_LIST;
    }

    public static Map c(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        Map mapH = h(3, false);
        mapH.put(obj, obj2);
        mapH.put(obj3, obj4);
        mapH.put(obj5, obj6);
        return Collections.unmodifiableMap(mapH);
    }

    public static Map d(Object[] objArr, Object[] objArr2) {
        int length = objArr.length;
        int length2 = objArr2.length;
        if (length != length2) {
            StringBuilder sb = new StringBuilder(String.valueOf(length).length() + 44 + String.valueOf(length2).length());
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
        if (length == 0) {
            return Collections.EMPTY_MAP;
        }
        if (length == 1) {
            return Collections.singletonMap(objArr[0], objArr2[0]);
        }
        Map mapH = h(length, false);
        for (int i3 = 0; i3 < objArr.length; i3++) {
            mapH.put(objArr[i3], objArr2[i3]);
        }
        return Collections.unmodifiableMap(mapH);
    }

    public static Set e(Object obj, Object obj2, Object obj3) {
        Set setG = g(3, false);
        setG.add(obj);
        setG.add(obj2);
        setG.add(obj3);
        return Collections.unmodifiableSet(setG);
    }

    public static Set f(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return Collections.EMPTY_SET;
        }
        if (length == 1) {
            return Collections.singleton(objArr[0]);
        }
        if (length == 2) {
            Object obj = objArr[0];
            Object obj2 = objArr[1];
            Set setG = g(2, false);
            setG.add(obj);
            setG.add(obj2);
            return Collections.unmodifiableSet(setG);
        }
        if (length == 3) {
            return e(objArr[0], objArr[1], objArr[2]);
        }
        if (length != 4) {
            Set setG2 = g(length, false);
            Collections.addAll(setG2, objArr);
            return Collections.unmodifiableSet(setG2);
        }
        Object obj3 = objArr[0];
        Object obj4 = objArr[1];
        Object obj5 = objArr[2];
        Object obj6 = objArr[3];
        Set setG3 = g(4, false);
        setG3.add(obj3);
        setG3.add(obj4);
        setG3.add(obj5);
        setG3.add(obj6);
        return Collections.unmodifiableSet(setG3);
    }

    private static Set g(int i3, boolean z2) {
        if (i3 <= (true != z2 ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD)) {
            return new ArraySet(i3);
        }
        return new HashSet(i3, true != z2 ? 1.0f : 0.75f);
    }

    private static Map h(int i3, boolean z2) {
        return i3 <= 256 ? new ArrayMap(i3) : new HashMap(i3, 1.0f);
    }
}
