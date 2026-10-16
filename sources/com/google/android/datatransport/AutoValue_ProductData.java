package com.google.android.datatransport;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ProductData extends ProductData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f69055a;

    AutoValue_ProductData(Integer num) {
        this.f69055a = num;
    }

    @Override // com.google.android.datatransport.ProductData
    public Integer a() {
        return this.f69055a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ProductData)) {
            return false;
        }
        Integer num = this.f69055a;
        Integer numA = ((ProductData) obj).a();
        return num == null ? numA == null : num.equals(numA);
    }

    public int hashCode() {
        Integer num = this.f69055a;
        return (num == null ? 0 : num.hashCode()) ^ 1000003;
    }

    public String toString() {
        return "ProductData{productId=" + this.f69055a + "}";
    }
}
