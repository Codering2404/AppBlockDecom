package com.google.android.libraries.places.internal;

import android.content.Context;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzane f78421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f78422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f78423c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f78424d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzamz f78425e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzanj f78426f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzpu f78427g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzapa f78428h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private zzang f78429i;

    public zzpw(zzane orientation, List content, boolean z2, boolean z3, zzamz mediaSize, zzanj attributionPosition, Context context, int i3) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(mediaSize, "mediaSize");
        Intrinsics.checkNotNullParameter(attributionPosition, "attributionPosition");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f78421a = orientation;
        this.f78422b = content;
        this.f78423c = z2;
        this.f78424d = z3;
        this.f78425e = mediaSize;
        this.f78426f = attributionPosition;
        this.f78428h = zzox.a(context, i3);
        this.f78429i = zzang.UNDEFINED;
    }

    private final void f(int i3) {
        zzamx zzamxVarG = zzanh.G();
        zzamxVarG.H(i3);
        zzamxVarG.y(this.f78421a);
        zzamxVarG.z(this.f78422b);
        zzamxVarG.A(this.f78429i);
        zzamxVarG.B(this.f78423c);
        zzamxVarG.D(this.f78424d);
        zzamxVarG.E(this.f78425e);
        zzamxVarG.F(this.f78426f);
        zzamxVarG.G(this.f78428h);
        zzbdq zzbdqVarZzG = zzamxVarG.zzG();
        Intrinsics.checkNotNullExpressionValue(zzbdqVarZzG, "build(...)");
        zzanh zzanhVar = (zzanh) zzbdqVarZzG;
        zzpu zzpuVar = this.f78427g;
        if (zzpuVar != null) {
            zzpuVar.b(zzanhVar);
        }
    }

    public final void a(zzpu zzpuVar) {
        this.f78427g = zzpuVar;
    }

    public final void b() {
        f(2);
    }

    public final void c() {
        f(3);
    }

    public final void d() {
        f(4);
    }

    public final void e() {
        f(5);
    }
}
