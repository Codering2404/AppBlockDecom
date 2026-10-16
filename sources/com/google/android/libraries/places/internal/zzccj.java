package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzccj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f77561a = new ArrayList(20);

    public final zzccj a(String str, String str2) {
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (cCharAt <= 31 || cCharAt >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i4), str));
            }
        }
        if (str2 == null) {
            throw new IllegalArgumentException("value == null");
        }
        for (int i5 = 0; i5 < str2.length(); i5++) {
            char cCharAt2 = str2.charAt(i5);
            if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i5), str2));
            }
        }
        while (true) {
            List list = this.f77561a;
            if (i3 >= list.size()) {
                list.add(str);
                list.add(str2.trim());
                return this;
            }
            if (str.equalsIgnoreCase((String) list.get(i3))) {
                list.remove(i3);
                list.remove(i3);
                i3 -= 2;
            }
            i3 += 2;
        }
    }

    public final zzcck b() {
        return new zzcck(this, null);
    }

    final /* synthetic */ List c() {
        return this.f77561a;
    }
}
