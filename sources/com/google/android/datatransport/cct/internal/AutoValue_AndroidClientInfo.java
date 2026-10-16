package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AndroidClientInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_AndroidClientInfo extends AndroidClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f69133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f69134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f69135c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f69136d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f69137e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f69138f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f69139g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f69140h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f69141i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f69142j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f69143k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f69144l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends AndroidClientInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Integer f69145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f69146b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f69147c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f69148d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f69149e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f69150f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f69151g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f69152h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f69153i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f69154j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f69155k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private String f69156l;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo a() {
            return new AutoValue_AndroidClientInfo(this.f69145a, this.f69146b, this.f69147c, this.f69148d, this.f69149e, this.f69150f, this.f69151g, this.f69152h, this.f69153i, this.f69154j, this.f69155k, this.f69156l);
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder b(String str) {
            this.f69156l = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder c(String str) {
            this.f69154j = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder d(String str) {
            this.f69148d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder e(String str) {
            this.f69152h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder f(String str) {
            this.f69147c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder g(String str) {
            this.f69153i = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder h(String str) {
            this.f69151g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder i(String str) {
            this.f69155k = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder j(String str) {
            this.f69146b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder k(String str) {
            this.f69150f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder l(String str) {
            this.f69149e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo.Builder
        public AndroidClientInfo.Builder m(Integer num) {
            this.f69145a = num;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String b() {
        return this.f69144l;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String c() {
        return this.f69142j;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String d() {
        return this.f69136d;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String e() {
        return this.f69140h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AndroidClientInfo) {
            AndroidClientInfo androidClientInfo = (AndroidClientInfo) obj;
            Integer num = this.f69133a;
            if (num != null ? num.equals(androidClientInfo.m()) : androidClientInfo.m() == null) {
                String str = this.f69134b;
                if (str != null ? str.equals(androidClientInfo.j()) : androidClientInfo.j() == null) {
                    String str2 = this.f69135c;
                    if (str2 != null ? str2.equals(androidClientInfo.f()) : androidClientInfo.f() == null) {
                        String str3 = this.f69136d;
                        if (str3 != null ? str3.equals(androidClientInfo.d()) : androidClientInfo.d() == null) {
                            String str4 = this.f69137e;
                            if (str4 != null ? str4.equals(androidClientInfo.l()) : androidClientInfo.l() == null) {
                                String str5 = this.f69138f;
                                if (str5 != null ? str5.equals(androidClientInfo.k()) : androidClientInfo.k() == null) {
                                    String str6 = this.f69139g;
                                    if (str6 != null ? str6.equals(androidClientInfo.h()) : androidClientInfo.h() == null) {
                                        String str7 = this.f69140h;
                                        if (str7 != null ? str7.equals(androidClientInfo.e()) : androidClientInfo.e() == null) {
                                            String str8 = this.f69141i;
                                            if (str8 != null ? str8.equals(androidClientInfo.g()) : androidClientInfo.g() == null) {
                                                String str9 = this.f69142j;
                                                if (str9 != null ? str9.equals(androidClientInfo.c()) : androidClientInfo.c() == null) {
                                                    String str10 = this.f69143k;
                                                    if (str10 != null ? str10.equals(androidClientInfo.i()) : androidClientInfo.i() == null) {
                                                        String str11 = this.f69144l;
                                                        if (str11 != null ? str11.equals(androidClientInfo.b()) : androidClientInfo.b() == null) {
                                                            return true;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String f() {
        return this.f69135c;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String g() {
        return this.f69141i;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String h() {
        return this.f69139g;
    }

    public int hashCode() {
        Integer num = this.f69133a;
        int iHashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f69134b;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f69135c;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f69136d;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f69137e;
        int iHashCode5 = (iHashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f69138f;
        int iHashCode6 = (iHashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f69139g;
        int iHashCode7 = (iHashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f69140h;
        int iHashCode8 = (iHashCode7 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
        String str8 = this.f69141i;
        int iHashCode9 = (iHashCode8 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
        String str9 = this.f69142j;
        int iHashCode10 = (iHashCode9 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
        String str10 = this.f69143k;
        int iHashCode11 = (iHashCode10 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
        String str11 = this.f69144l;
        return iHashCode11 ^ (str11 != null ? str11.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String i() {
        return this.f69143k;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String j() {
        return this.f69134b;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String k() {
        return this.f69138f;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public String l() {
        return this.f69137e;
    }

    @Override // com.google.android.datatransport.cct.internal.AndroidClientInfo
    public Integer m() {
        return this.f69133a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.f69133a + ", model=" + this.f69134b + ", hardware=" + this.f69135c + ", device=" + this.f69136d + ", product=" + this.f69137e + ", osBuild=" + this.f69138f + ", manufacturer=" + this.f69139g + ", fingerprint=" + this.f69140h + ", locale=" + this.f69141i + ", country=" + this.f69142j + ", mccMnc=" + this.f69143k + ", applicationBuild=" + this.f69144l + "}";
    }

    private AutoValue_AndroidClientInfo(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        this.f69133a = num;
        this.f69134b = str;
        this.f69135c = str2;
        this.f69136d = str3;
        this.f69137e = str4;
        this.f69138f = str5;
        this.f69139g = str6;
        this.f69140h = str7;
        this.f69141i = str8;
        this.f69142j = str9;
        this.f69143k = str10;
        this.f69144l = str11;
    }
}
