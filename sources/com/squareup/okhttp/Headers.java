package com.squareup.okhttp;

import com.revenuecat.purchases.common.Constants;
import com.squareup.okhttp.internal.http.HttpDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Headers {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f92918a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f92919a = new ArrayList(20);

        private void f(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char cCharAt = str.charAt(i3);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i3), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                char cCharAt2 = str2.charAt(i4);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i4), str2));
                }
            }
        }

        public Builder b(String str, String str2) {
            f(str, str2);
            return d(str, str2);
        }

        Builder c(String str) {
            int iIndexOf = str.indexOf(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 1);
            return iIndexOf != -1 ? d(str.substring(0, iIndexOf), str.substring(iIndexOf + 1)) : str.startsWith(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR) ? d("", str.substring(1)) : d("", str);
        }

        Builder d(String str, String str2) {
            this.f92919a.add(str);
            this.f92919a.add(str2.trim());
            return this;
        }

        public Headers e() {
            return new Headers(this);
        }

        public Builder g(String str) {
            int i3 = 0;
            while (i3 < this.f92919a.size()) {
                if (str.equalsIgnoreCase((String) this.f92919a.get(i3))) {
                    this.f92919a.remove(i3);
                    this.f92919a.remove(i3);
                    i3 -= 2;
                }
                i3 += 2;
            }
            return this;
        }

        public Builder h(String str, String str2) {
            f(str, str2);
            g(str);
            d(str, str2);
            return this;
        }
    }

    private static String b(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public String a(String str) {
        return b(this.f92918a, str);
    }

    public Date c(String str) {
        String strA = a(str);
        if (strA != null) {
            return HttpDate.b(strA);
        }
        return null;
    }

    public String d(int i3) {
        int i4 = i3 * 2;
        if (i4 < 0) {
            return null;
        }
        String[] strArr = this.f92918a;
        if (i4 >= strArr.length) {
            return null;
        }
        return strArr[i4];
    }

    public Builder e() {
        Builder builder = new Builder();
        Collections.addAll(builder.f92919a, this.f92918a);
        return builder;
    }

    public int f() {
        return this.f92918a.length / 2;
    }

    public String g(int i3) {
        int i4 = (i3 * 2) + 1;
        if (i4 < 0) {
            return null;
        }
        String[] strArr = this.f92918a;
        if (i4 >= strArr.length) {
            return null;
        }
        return strArr[i4];
    }

    public List h(String str) {
        int iF = f();
        ArrayList arrayList = null;
        for (int i3 = 0; i3 < iF; i3++) {
            if (str.equalsIgnoreCase(d(i3))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(g(i3));
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.EMPTY_LIST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iF = f();
        for (int i3 = 0; i3 < iF; i3++) {
            sb.append(d(i3));
            sb.append(": ");
            sb.append(g(i3));
            sb.append("\n");
        }
        return sb.toString();
    }

    private Headers(Builder builder) {
        this.f92918a = (String[]) builder.f92919a.toArray(new String[builder.f92919a.size()]);
    }
}
