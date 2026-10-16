package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbis {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzbis f76259h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbjv f76260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f76261b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[][] f76262c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f76263d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Boolean f76264e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Integer f76265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Integer f76266g;

    static {
        zzbiq zzbiqVar = new zzbiq();
        zzbiqVar.f76253c = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        zzbiqVar.f76254d = Collections.EMPTY_LIST;
        f76259h = new zzbis(zzbiqVar, null);
    }

    /* synthetic */ zzbis(zzbiq zzbiqVar, byte[] bArr) {
        this.f76260a = zzbiqVar.f76251a;
        this.f76261b = zzbiqVar.f76252b;
        this.f76262c = zzbiqVar.f76253c;
        this.f76263d = zzbiqVar.f76254d;
        this.f76264e = zzbiqVar.f76255e;
        this.f76265f = zzbiqVar.f76256f;
        this.f76266g = zzbiqVar.f76257g;
    }

    private static zzbiq p(zzbis zzbisVar) {
        zzbiq zzbiqVar = new zzbiq();
        zzbiqVar.f76251a = zzbisVar.f76260a;
        zzbiqVar.f76252b = zzbisVar.f76261b;
        zzbiqVar.f76253c = zzbisVar.f76262c;
        zzbiqVar.f76254d = zzbisVar.f76263d;
        zzbiqVar.f76255e = zzbisVar.f76264e;
        zzbiqVar.f76256f = zzbisVar.f76265f;
        zzbiqVar.f76257g = zzbisVar.f76266g;
        return zzbiqVar;
    }

    public final zzbis a(zzbjv zzbjvVar) {
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76251a = zzbjvVar;
        return new zzbis(zzbiqVarP, null);
    }

    public final zzbjv b() {
        return this.f76260a;
    }

    public final zzbis c() {
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76255e = Boolean.TRUE;
        return new zzbis(zzbiqVarP, null);
    }

    public final zzbis d() {
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76255e = Boolean.FALSE;
        return new zzbis(zzbiqVarP, null);
    }

    public final zzbis e(Executor executor) {
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76252b = executor;
        return new zzbis(zzbiqVarP, null);
    }

    public final zzbis f(zzbjb zzbjbVar) {
        List list = this.f76263d;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(zzbjbVar);
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76254d = Collections.unmodifiableList(arrayList);
        return new zzbis(zzbiqVarP, null);
    }

    public final List g() {
        return this.f76263d;
    }

    public final zzbis h(zzbir zzbirVar, Object obj) {
        Object[][] objArr;
        int length;
        Preconditions.u(zzbirVar, "key");
        Preconditions.u(obj, "value");
        zzbiq zzbiqVarP = p(this);
        int i3 = 0;
        while (true) {
            objArr = this.f76262c;
            length = objArr.length;
            if (i3 >= length) {
                i3 = -1;
                break;
            }
            if (zzbirVar.equals(objArr[i3][0])) {
                break;
            }
            i3++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, (i3 == -1 ? 1 : 0) + length, 2);
        zzbiqVarP.f76253c = objArr2;
        System.arraycopy(objArr, 0, objArr2, 0, length);
        if (i3 == -1) {
            zzbiqVarP.f76253c[length] = new Object[]{zzbirVar, obj};
        } else {
            zzbiqVarP.f76253c[i3] = new Object[]{zzbirVar, obj};
        }
        return new zzbis(zzbiqVarP, null);
    }

    public final Object i(zzbir zzbirVar) {
        Preconditions.u(zzbirVar, "key");
        int i3 = 0;
        while (true) {
            Object[][] objArr = this.f76262c;
            if (i3 >= objArr.length) {
                return null;
            }
            if (zzbirVar.equals(objArr[i3][0])) {
                return objArr[i3][1];
            }
            i3++;
        }
    }

    public final Executor j() {
        return this.f76261b;
    }

    public final boolean k() {
        return Boolean.TRUE.equals(this.f76264e);
    }

    public final zzbis l(int i3) {
        Preconditions.h(i3 >= 0, "invalid maxsize %s", i3);
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76256f = Integer.valueOf(i3);
        return new zzbis(zzbiqVarP, null);
    }

    public final zzbis m(int i3) {
        Preconditions.h(i3 >= 0, "invalid maxsize %s", i3);
        zzbiq zzbiqVarP = p(this);
        zzbiqVarP.f76257g = Integer.valueOf(i3);
        return new zzbis(zzbiqVarP, null);
    }

    public final Integer n() {
        return this.f76265f;
    }

    public final Integer o() {
        return this.f76266g;
    }

    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperD = MoreObjects.c(this).d("deadline", this.f76260a).d("authority", null).d("callCredentials", null);
        Executor executor = this.f76261b;
        return toStringHelperD.d("executor", executor != null ? executor.getClass() : null).d("compressorName", null).d("customOptions", Arrays.deepToString(this.f76262c)).e("waitForReady", k()).d("maxInboundMessageSize", this.f76265f).d("maxOutboundMessageSize", this.f76266g).d("onReadyThreshold", null).d("streamTracerFactories", this.f76263d).toString();
    }
}
