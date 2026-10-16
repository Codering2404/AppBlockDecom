package com.google.thirdparty.publicsuffix;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f91553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f91554b;

    PublicSuffixType(char c3, char c4) {
        this.f91553a = c3;
        this.f91554b = c4;
    }

    static PublicSuffixType b(char c3) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.c() == c3 || publicSuffixType.d() == c3) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c3);
    }

    char c() {
        return this.f91553a;
    }

    char d() {
        return this.f91554b;
    }
}
