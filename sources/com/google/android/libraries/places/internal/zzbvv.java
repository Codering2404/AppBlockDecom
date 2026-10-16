package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final URI f77014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzbmz f77015b;

    public zzbvv(URI uri, zzbmz zzbmzVar) {
        this.f77014a = (URI) Preconditions.u(uri, "targetUri");
        this.f77015b = (zzbmz) Preconditions.u(zzbmzVar, "provider");
    }
}
