package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzwr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f78780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzuk f78781b;

    protected zzwr(zzuk zzukVar, int i3) {
        if (zzukVar == null) {
            throw new IllegalArgumentException("format options cannot be null");
        }
        if (i3 >= 0) {
            this.f78780a = i3;
            this.f78781b = zzukVar;
        } else {
            StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 15);
            sb.append("invalid index: ");
            sb.append(i3);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    protected abstract void a(zzws zzwsVar, Object obj);

    public final int b() {
        return this.f78780a;
    }

    protected final zzuk c() {
        return this.f78781b;
    }

    public final void d(zzws zzwsVar, Object[] objArr) {
        if (this.f78780a > 0) {
            zzwsVar.zze();
            return;
        }
        Object obj = objArr[0];
        if (obj != null) {
            a(zzwsVar, obj);
        } else {
            zzwsVar.zzf();
        }
    }
}
