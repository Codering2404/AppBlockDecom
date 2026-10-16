package org.commonmark.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class BlockContent {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f145364b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f145363a = new StringBuilder();

    public void a(CharSequence charSequence) {
        if (this.f145364b != 0) {
            this.f145363a.append('\n');
        }
        this.f145363a.append(charSequence);
        this.f145364b++;
    }

    public String b() {
        return this.f145363a.toString();
    }
}
