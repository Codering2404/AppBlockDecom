package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwq extends zzwr {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzwp f78779c;

    private zzwq(zzuk zzukVar, int i3, zzwp zzwpVar) {
        super(zzukVar, i3);
        this.f78779c = zzwpVar;
        StringBuilder sb = new StringBuilder("%");
        zzukVar.l(sb);
        sb.append(true != zzukVar.k() ? 't' : 'T');
        sb.append(zzwpVar.b());
    }

    public static zzwr e(zzwp zzwpVar, zzuk zzukVar, int i3) {
        return new zzwq(zzukVar, i3, zzwpVar);
    }

    @Override // com.google.android.libraries.places.internal.zzwr
    protected final void a(zzws zzwsVar, Object obj) {
        zzwsVar.a(obj, this.f78779c, c());
    }
}
