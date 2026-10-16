package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbi extends PlusCode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f75260b;

    zzbi(String str, String str2) {
        this.f75259a = str;
        this.f75260b = str2;
    }

    @Override // com.google.android.libraries.places.api.model.PlusCode
    public final String d() {
        return this.f75259a;
    }

    @Override // com.google.android.libraries.places.api.model.PlusCode
    public final String e() {
        return this.f75260b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlusCode) {
            PlusCode plusCode = (PlusCode) obj;
            String str = this.f75259a;
            if (str != null ? str.equals(plusCode.d()) : plusCode.d() == null) {
                String str2 = this.f75260b;
                if (str2 != null ? str2.equals(plusCode.e()) : plusCode.e() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f75259a;
        int iHashCode = str == null ? 0 : str.hashCode();
        String str2 = this.f75260b;
        return ((iHashCode ^ 1000003) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String str = this.f75259a;
        int length = String.valueOf(str).length();
        String str2 = this.f75260b;
        StringBuilder sb = new StringBuilder(length + 35 + String.valueOf(str2).length() + 1);
        sb.append("PlusCode{compoundCode=");
        sb.append(str);
        sb.append(", globalCode=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
