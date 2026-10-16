package com.google.android.libraries.places.internal;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcaf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzblu f77326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzblu f77327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final zzblu f77328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzblv f77329e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbmo f77330a;

    static {
        zzbmn zzbmnVarA = zzbmn.a();
        f77326b = zzbmnVarA.c("grpc.subchannel.disconnections", "EXPERIMENTAL. Number of times the selected subchannel becomes disconnected", "{disconnection}", Lists.l("grpc.target"), Lists.l("grpc.lb.backend_service", "grpc.lb.locality", "grpc.disconnect_error"), false);
        f77327c = zzbmnVarA.c("grpc.subchannel.connection_attempts_succeeded", "EXPERIMENTAL. Number of successful connection attempts", "{attempt}", Lists.l("grpc.target"), Lists.l("grpc.lb.backend_service", "grpc.lb.locality"), false);
        f77328d = zzbmnVarA.c("grpc.subchannel.connection_attempts_failed", "EXPERIMENTAL. Number of failed connection attempts", "{attempt}", Lists.l("grpc.target"), Lists.l("grpc.lb.backend_service", "grpc.lb.locality"), false);
        f77329e = zzbmnVarA.d("grpc.subchannel.open_connections", "EXPERIMENTAL. Number of open connections.", "{connection}", Lists.l("grpc.target"), Lists.l("grpc.security_level", "grpc.lb.backend_service", "grpc.lb.locality"), false);
    }

    public zzcaf(zzbmo zzbmoVar) {
        this.f77330a = zzbmoVar;
    }

    public final void a(String str, String str2, String str3, String str4) {
        zzbmo zzbmoVar = this.f77330a;
        zzbmoVar.a(f77327c, 1L, ImmutableList.z(str), ImmutableList.A(str2, str3));
        zzbmoVar.b(f77329e, 1L, ImmutableList.z(str), ImmutableList.B(str4, str2, str3));
    }

    public final void b(String str, String str2, String str3) {
        this.f77330a.a(f77328d, 1L, ImmutableList.z(str), ImmutableList.A(str2, str3));
    }

    public final void c(String str, String str2, String str3, String str4, String str5) {
        zzbmo zzbmoVar = this.f77330a;
        zzbmoVar.a(f77326b, 1L, ImmutableList.z(str), ImmutableList.B(str2, str3, str4));
        zzbmoVar.b(f77329e, -1L, ImmutableList.z(str), ImmutableList.B(str5, str2, str3));
    }
}
