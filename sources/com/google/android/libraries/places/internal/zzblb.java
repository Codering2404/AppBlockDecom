package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzblb {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object[][] f76360d = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List f76361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76362b = zzbio.f76249c;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[][] f76363c = f76360d;

    zzblb() {
    }

    public final zzblb a(zzblc zzblcVar, Object obj) {
        Preconditions.u(zzblcVar, "key");
        Preconditions.u(obj, "value");
        int length = 0;
        while (true) {
            Object[][] objArr = this.f76363c;
            if (length >= objArr.length) {
                length = -1;
                break;
            }
            if (zzblcVar.equals(objArr[length][0])) {
                break;
            }
            length++;
        }
        if (length == -1) {
            Object[][] objArr2 = this.f76363c;
            int length2 = objArr2.length;
            Object[][] objArr3 = (Object[][]) Array.newInstance((Class<?>) Object.class, length2 + 1, 2);
            System.arraycopy(objArr2, 0, objArr3, 0, length2);
            this.f76363c = objArr3;
            length = objArr3.length - 1;
        }
        this.f76363c[length] = new Object[]{zzblcVar, obj};
        return this;
    }

    public final zzblb b(List list) {
        Preconditions.e(!list.isEmpty(), "addrs is empty");
        this.f76361a = Collections.unmodifiableList(new ArrayList(list));
        return this;
    }

    public final zzbld c() {
        return new zzbld(this.f76361a, this.f76362b, this.f76363c, null);
    }
}
