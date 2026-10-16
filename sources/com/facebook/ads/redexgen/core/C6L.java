package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6L, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C6L {
    public static String[] A05 = {"kbrCq6pMhmUkuvpwyFR35DcipjG4S8CW", "oaW9l9tdb", "0TRcVMdqb51VWoFscAzJe", "b9KyZslhVmWVmt6Bq2rIk", "ASY6aJ5KLIO5E4dZs7qVgEBqztuPzXSE", "", "9Pc37QLTRQIuoUm", "qelQYpgVCE3t9Ri2JAAORJatu68jVLQj"};
    public final int A00;
    public final int A01;
    public final C2208qI A02;
    public final C2208qI A03;
    public final String A04;

    public C6L(String str, C2208qI c2208qI, C2208qI c2208qI2, int i3, int i4) {
        AbstractC04323y.A07(i3 == 0 || i4 == 0);
        this.A04 = AbstractC04323y.A05(str);
        this.A03 = (C2208qI) AbstractC04323y.A01(c2208qI);
        this.A02 = (C2208qI) AbstractC04323y.A01(c2208qI2);
        this.A01 = i3;
        this.A00 = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C6L c6l = (C6L) obj;
        if (this.A01 == c6l.A01 && this.A00 == c6l.A00 && this.A04.equals(c6l.A04)) {
            boolean zEquals = this.A03.equals(c6l.A03);
            String[] strArr = A05;
            if (strArr[5].length() == strArr[2].length()) {
                throw new RuntimeException();
            }
            A05[6] = "94n8VTHvI2C2zF2";
            if (zEquals && this.A02.equals(c6l.A02)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.A01;
        int hashCode2 = ((((17 * 31) + hashCode) * 31) + this.A00) * 31;
        int hashCode3 = this.A04.hashCode();
        int hashCode4 = (((hashCode2 + hashCode3) * 31) + this.A03.hashCode()) * 31;
        int hashCode5 = this.A02.hashCode();
        return hashCode4 + hashCode5;
    }
}
