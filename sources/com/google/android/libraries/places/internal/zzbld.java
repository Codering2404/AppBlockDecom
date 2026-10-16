package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbld {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbio f76367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[][] f76368c;

    /* synthetic */ zzbld(List list, zzbio zzbioVar, Object[][] objArr, byte[] bArr) {
        this.f76366a = (List) Preconditions.u(list, "addresses are not set");
        this.f76367b = (zzbio) Preconditions.u(zzbioVar, "attrs");
        this.f76368c = (Object[][]) Preconditions.u(objArr, "customOptions");
    }

    public static zzblb d() {
        return new zzblb();
    }

    public final List a() {
        return this.f76366a;
    }

    public final zzbio b() {
        return this.f76367b;
    }

    public final Object c(zzblc zzblcVar) {
        Preconditions.u(zzblcVar, "key");
        int i3 = 0;
        while (true) {
            Object[][] objArr = this.f76368c;
            if (i3 >= objArr.length) {
                return zzblcVar.c();
            }
            if (zzblcVar.equals(objArr[i3][0])) {
                return objArr[i3][1];
            }
            i3++;
        }
    }

    public final String toString() {
        return MoreObjects.c(this).d("addrs", this.f76366a).d("attrs", this.f76367b).d("customOptions", Arrays.deepToString(this.f76368c)).toString();
    }
}
