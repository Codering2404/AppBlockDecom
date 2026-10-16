package com.google.android.libraries.places.internal;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzui extends zzww implements zzws {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Object[] f78627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final StringBuilder f78628e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f78629f;

    protected zzui(zzvp zzvpVar, Object[] objArr, StringBuilder sb) {
        super(zzvpVar);
        this.f78629f = 0;
        this.f78627d = objArr;
        this.f78628e = sb;
    }

    public static StringBuilder j(zzun zzunVar, StringBuilder sb) {
        if (zzunVar.zzh() == null) {
            sb.append(zzur.a(zzunVar.zzj()));
            return sb;
        }
        zzui zzuiVar = new zzui(zzunVar.zzh(), zzunVar.zzi(), sb);
        StringBuilder sb2 = (StringBuilder) zzuiVar.i();
        zzunVar.zzi();
        if (zzuiVar.g() <= 0) {
            sb2.append(" [ERROR: UNUSED LOG ARGUMENTS]");
        }
        return sb2;
    }

    private static void k(StringBuilder sb, Object obj, String str) {
        sb.append("[INVALID: format=");
        sb.append(str);
        sb.append(", type=");
        sb.append(obj.getClass().getCanonicalName());
        sb.append(", value=");
        sb.append(zzur.a(obj));
        sb.append("]");
    }

    @Override // com.google.android.libraries.places.internal.zzws
    public final void a(Object obj, zzwp zzwpVar, zzuk zzukVar) {
        if ((obj instanceof Date) || (obj instanceof Calendar) || (obj instanceof Long)) {
            StringBuilder sb = new StringBuilder("%");
            zzukVar.l(sb);
            sb.append(true != zzukVar.k() ? 't' : 'T');
            sb.append(zzwpVar.b());
            this.f78628e.append(String.format(zzur.f78663a, sb.toString(), obj));
            return;
        }
        StringBuilder sb2 = this.f78628e;
        char cB = zzwpVar.b();
        StringBuilder sb3 = new StringBuilder(String.valueOf(cB).length() + 2);
        sb3.append("%t");
        sb3.append(cB);
        k(sb2, obj, sb3.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b3  */
    @Override // com.google.android.libraries.places.internal.zzws
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(java.lang.Object r7, com.google.android.libraries.places.internal.zzuj r8, com.google.android.libraries.places.internal.zzuk r9) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzui.b(java.lang.Object, com.google.android.libraries.places.internal.zzuj, com.google.android.libraries.places.internal.zzuk):void");
    }

    @Override // com.google.android.libraries.places.internal.zzww
    public final void c(int i3, int i4, zzwr zzwrVar) {
        e().b(this.f78628e, f(), this.f78629f, i3);
        zzwrVar.d(this, this.f78627d);
        this.f78629f = i4;
    }

    @Override // com.google.android.libraries.places.internal.zzww
    public final /* bridge */ /* synthetic */ Object d() {
        zzwx zzwxVarE = e();
        String strF = f();
        int i3 = this.f78629f;
        int length = f().length();
        StringBuilder sb = this.f78628e;
        zzwxVarE.b(sb, strF, i3, length);
        return sb;
    }

    @Override // com.google.android.libraries.places.internal.zzws
    public final void zze() {
        this.f78628e.append("[ERROR: MISSING LOG ARGUMENT]");
    }

    @Override // com.google.android.libraries.places.internal.zzws
    public final void zzf() {
        this.f78628e.append("null");
    }
}
