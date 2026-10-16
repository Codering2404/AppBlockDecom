package com.google.android.libraries.places.api.model;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzr extends ConsumerAlert {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f75391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConsumerAlertDetails f75392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f75393c;

    zzr(String str, ConsumerAlertDetails consumerAlertDetails, String str2) {
        this.f75391a = str;
        this.f75392b = consumerAlertDetails;
        this.f75393c = str2;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert
    public ConsumerAlertDetails d() {
        return this.f75392b;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert
    public String e() {
        return this.f75393c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConsumerAlert) {
            ConsumerAlert consumerAlert = (ConsumerAlert) obj;
            String str = this.f75391a;
            if (str != null ? str.equals(consumerAlert.f()) : consumerAlert.f() == null) {
                ConsumerAlertDetails consumerAlertDetails = this.f75392b;
                if (consumerAlertDetails != null ? consumerAlertDetails.equals(consumerAlert.d()) : consumerAlert.d() == null) {
                    String str2 = this.f75393c;
                    if (str2 != null ? str2.equals(consumerAlert.e()) : consumerAlert.e() == null) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.api.model.ConsumerAlert
    public String f() {
        return this.f75391a;
    }

    public final int hashCode() {
        String str = this.f75391a;
        int iHashCode = str == null ? 0 : str.hashCode();
        ConsumerAlertDetails consumerAlertDetails = this.f75392b;
        int iHashCode2 = consumerAlertDetails == null ? 0 : consumerAlertDetails.hashCode();
        int i3 = iHashCode ^ 1000003;
        String str2 = this.f75393c;
        return (((i3 * 1000003) ^ iHashCode2) * 1000003) ^ (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.f75392b);
        String str = this.f75391a;
        int length = String.valueOf(str).length();
        int length2 = strValueOf.length();
        String str2 = this.f75393c;
        StringBuilder sb = new StringBuilder(length + 33 + length2 + 15 + String.valueOf(str2).length() + 1);
        sb.append("ConsumerAlert{overview=");
        sb.append(str);
        sb.append(", details=");
        sb.append(strValueOf);
        sb.append(", languageCode=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }
}
