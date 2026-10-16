package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class a extends ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f82948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f82949b;

    a() {
    }

    @Override // com.google.android.play.core.integrity.ap
    final ap a(y yVar) {
        this.f82949b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    final ap b(String str) {
        this.f82948a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.ap
    final aq c() {
        y yVar;
        String str = this.f82948a;
        if (str != null && (yVar = this.f82949b) != null) {
            return new aq(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f82948a == null) {
            sb.append(" token");
        }
        if (this.f82949b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
