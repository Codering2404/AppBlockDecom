package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.Enums;
import com.sun.jna.Function;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'f' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public final class PemKeyType {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final PemKeyType f87454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PemKeyType f87455g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PemKeyType f87456h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final PemKeyType f87457i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final PemKeyType f87458j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final PemKeyType f87459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final PemKeyType f87460l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final PemKeyType f87461m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final PemKeyType f87462n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final PemKeyType f87463o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final PemKeyType f87464p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final /* synthetic */ PemKeyType[] f87465q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f87468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Enums.HashType f87469d;

    static {
        Enums.HashType hashType = Enums.HashType.SHA256;
        PemKeyType pemKeyType = new PemKeyType("RSA_PSS_2048_SHA256", 0, "RSA", "RSASSA-PSS", 2048, hashType);
        f87454f = pemKeyType;
        PemKeyType pemKeyType2 = new PemKeyType("RSA_PSS_3072_SHA256", 1, "RSA", "RSASSA-PSS", 3072, hashType);
        f87455g = pemKeyType2;
        PemKeyType pemKeyType3 = new PemKeyType("RSA_PSS_4096_SHA256", 2, "RSA", "RSASSA-PSS", 4096, hashType);
        f87456h = pemKeyType3;
        Enums.HashType hashType2 = Enums.HashType.SHA512;
        PemKeyType pemKeyType4 = new PemKeyType("RSA_PSS_4096_SHA512", 3, "RSA", "RSASSA-PSS", 4096, hashType2);
        f87457i = pemKeyType4;
        PemKeyType pemKeyType5 = new PemKeyType("RSA_SIGN_PKCS1_2048_SHA256", 4, "RSA", "RSASSA-PKCS1-v1_5", 2048, hashType);
        f87458j = pemKeyType5;
        PemKeyType pemKeyType6 = new PemKeyType("RSA_SIGN_PKCS1_3072_SHA256", 5, "RSA", "RSASSA-PKCS1-v1_5", 3072, hashType);
        f87459k = pemKeyType6;
        PemKeyType pemKeyType7 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA256", 6, "RSA", "RSASSA-PKCS1-v1_5", 4096, hashType);
        f87460l = pemKeyType7;
        PemKeyType pemKeyType8 = new PemKeyType("RSA_SIGN_PKCS1_4096_SHA512", 7, "RSA", "RSASSA-PKCS1-v1_5", 4096, hashType2);
        f87461m = pemKeyType8;
        PemKeyType pemKeyType9 = new PemKeyType("ECDSA_P256_SHA256", 8, "EC", "ECDSA", Function.MAX_NARGS, hashType);
        f87462n = pemKeyType9;
        PemKeyType pemKeyType10 = new PemKeyType("ECDSA_P384_SHA384", 9, "EC", "ECDSA", 384, Enums.HashType.SHA384);
        f87463o = pemKeyType10;
        PemKeyType pemKeyType11 = new PemKeyType("ECDSA_P521_SHA512", 10, "EC", "ECDSA", 521, hashType2);
        f87464p = pemKeyType11;
        f87465q = new PemKeyType[]{pemKeyType, pemKeyType2, pemKeyType3, pemKeyType4, pemKeyType5, pemKeyType6, pemKeyType7, pemKeyType8, pemKeyType9, pemKeyType10, pemKeyType11};
    }

    private PemKeyType(String str, int i3, String str2, String str3, int i4, Enums.HashType hashType) {
        this.f87466a = str2;
        this.f87467b = str3;
        this.f87468c = i4;
        this.f87469d = hashType;
    }

    public static PemKeyType valueOf(String str) {
        return (PemKeyType) Enum.valueOf(PemKeyType.class, str);
    }

    public static PemKeyType[] values() {
        return (PemKeyType[]) f87465q.clone();
    }
}
