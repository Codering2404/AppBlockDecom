package com.google.android.play.core.integrity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class b extends bq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f83001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f83002b;

    b() {
    }

    @Override // com.google.android.play.core.integrity.bq
    final bq a(y yVar) {
        this.f83002b = yVar;
        return this;
    }

    @Override // com.google.android.play.core.integrity.bq
    final bq b(String str) {
        if (str == null) {
            throw new NullPointerException("Null token");
        }
        this.f83001a = str;
        return this;
    }

    @Override // com.google.android.play.core.integrity.bq
    final br c() {
        y yVar;
        String str = this.f83001a;
        if (str != null && (yVar = this.f83002b) != null) {
            return new br(str, yVar);
        }
        StringBuilder sb = new StringBuilder();
        if (this.f83001a == null) {
            sb.append(" token");
        }
        if (this.f83002b == null) {
            sb.append(" integrityDialogWrapper");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
