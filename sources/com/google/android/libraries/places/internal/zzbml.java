package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbml {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmj f76414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f76415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f76416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbmi f76417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbmi f76418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f76419f;

    /* synthetic */ zzbml(zzbmj zzbmjVar, String str, zzbmi zzbmiVar, zzbmi zzbmiVar2, Object obj, boolean z2, boolean z3, boolean z4, byte[] bArr) {
        new AtomicReferenceArray(2);
        this.f76414a = (zzbmj) Preconditions.u(zzbmjVar, "type");
        this.f76415b = (String) Preconditions.u(str, "fullMethodName");
        int iLastIndexOf = ((String) Preconditions.u(str, "fullMethodName")).lastIndexOf(47);
        this.f76416c = iLastIndexOf == -1 ? null : str.substring(0, iLastIndexOf);
        this.f76417d = (zzbmi) Preconditions.u(zzbmiVar, "requestMarshaller");
        this.f76418e = (zzbmi) Preconditions.u(zzbmiVar2, "responseMarshaller");
        this.f76419f = z4;
    }

    public static String h(String str, String str2) {
        String str3 = (String) Preconditions.u(str, "fullServiceName");
        String str4 = (String) Preconditions.u(str2, "methodName");
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str4).length());
        sb.append(str3);
        sb.append("/");
        sb.append(str4);
        return sb.toString();
    }

    public static zzbmh i(zzbmi zzbmiVar, zzbmi zzbmiVar2) {
        zzbmh zzbmhVar = new zzbmh(null);
        zzbmhVar.a(null);
        zzbmhVar.b(null);
        return zzbmhVar;
    }

    public final zzbmj a() {
        return this.f76414a;
    }

    public final String b() {
        return this.f76415b;
    }

    public final String c() {
        return this.f76416c;
    }

    public final Object d(InputStream inputStream) {
        return this.f76418e.zzb(inputStream);
    }

    public final InputStream e(Object obj) {
        return this.f76417d.zza(obj);
    }

    public final zzbmi f() {
        return this.f76417d;
    }

    public final zzbmi g() {
        return this.f76418e;
    }

    public final String toString() {
        return MoreObjects.c(this).d("fullMethodName", this.f76415b).d("type", this.f76414a).e("idempotent", false).e("safe", false).e("sampledToLocalTracing", this.f76419f).d("requestMarshaller", this.f76417d).d("responseMarshaller", this.f76418e).d("schemaDescriptor", null).m().toString();
    }
}
