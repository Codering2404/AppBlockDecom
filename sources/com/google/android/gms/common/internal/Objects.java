package com.google.android.gms.common.internal;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Objects {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ToStringHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f72010a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f72011b;

        /* synthetic */ ToStringHelper(Object obj, byte[] bArr) {
            Preconditions.m(obj);
            this.f72011b = obj;
            this.f72010a = new ArrayList();
        }

        public ToStringHelper a(String str, Object obj) {
            Preconditions.m(str);
            int length = str.length();
            String strValueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(length + 1 + strValueOf.length());
            sb.append(str);
            sb.append("=");
            sb.append(strValueOf);
            this.f72010a.add(sb.toString());
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.f72011b.getClass().getSimpleName());
            sb.append('{');
            List list = this.f72010a;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                sb.append((String) list.get(i3));
                if (i3 < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }
    }

    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return bundle == bundle2;
        }
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        Set<String> setKeySet = bundle.keySet();
        if (!setKeySet.containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : setKeySet) {
            if (!b(bundle.get(str), bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int c(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper d(Object obj) {
        return new ToStringHelper(obj, null);
    }
}
