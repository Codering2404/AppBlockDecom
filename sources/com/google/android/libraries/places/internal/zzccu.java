package com.google.android.libraries.places.internal;

import com.facebook.stetho.common.Utf8Charset;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f77600a = new String[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f77601b = Charset.forName(Utf8Charset.NAME);

    public static List a(Object[] objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static Object[] b(Class cls, Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            int length = objArr2.length;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    Object obj2 = objArr2[i3];
                    if (obj.equals(obj2)) {
                        arrayList.add(obj2);
                        break;
                    }
                    i3++;
                }
            }
        }
        return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, arrayList.size()));
    }
}
