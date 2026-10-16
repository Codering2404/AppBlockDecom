package com.google.android.libraries.places.internal;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'i' uses external variables
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
public final class zzuj {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzuj f78630f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzuj f78631g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzuj f78632h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzuj f78633i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final zzuj f78634j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final zzuj f78635k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final zzuj f78636l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final zzuj f78637m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final zzuj f78638n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final zzuj f78639o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final zzuj[] f78640p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final /* synthetic */ zzuj[] f78641q;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char f78642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzul f78643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f78644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f78645d;

    static {
        zzuj zzujVar = new zzuj("STRING", 0, 's', zzul.GENERAL, "-#", true);
        f78630f = zzujVar;
        zzuj zzujVar2 = new zzuj("BOOLEAN", 1, 'b', zzul.BOOLEAN, "-", true);
        f78631g = zzujVar2;
        zzuj zzujVar3 = new zzuj("CHAR", 2, 'c', zzul.CHARACTER, "-", true);
        f78632h = zzujVar3;
        zzul zzulVar = zzul.INTEGRAL;
        zzuj zzujVar4 = new zzuj("DECIMAL", 3, 'd', zzulVar, "-0+ ,(", false);
        f78633i = zzujVar4;
        zzuj zzujVar5 = new zzuj("OCTAL", 4, 'o', zzulVar, "-#0(", false);
        f78634j = zzujVar5;
        zzuj zzujVar6 = new zzuj("HEX", 5, 'x', zzulVar, "-#0(", true);
        f78635k = zzujVar6;
        zzul zzulVar2 = zzul.FLOAT;
        zzuj zzujVar7 = new zzuj("FLOAT", 6, 'f', zzulVar2, "-#0+ ,(", false);
        f78636l = zzujVar7;
        zzuj zzujVar8 = new zzuj("EXPONENT", 7, 'e', zzulVar2, "-#0+ (", true);
        f78637m = zzujVar8;
        zzuj zzujVar9 = new zzuj("GENERAL", 8, 'g', zzulVar2, "-0+ ,(", true);
        f78638n = zzujVar9;
        zzuj zzujVar10 = new zzuj("EXPONENT_HEX", 9, 'a', zzulVar2, "-#0+ ", true);
        f78639o = zzujVar10;
        f78641q = new zzuj[]{zzujVar, zzujVar2, zzujVar3, zzujVar4, zzujVar5, zzujVar6, zzujVar7, zzujVar8, zzujVar9, zzujVar10};
        f78640p = new zzuj[26];
        for (zzuj zzujVar11 : values()) {
            f78640p[f(zzujVar11.f78642a)] = zzujVar11;
        }
    }

    private zzuj(String str, int i3, char c3, zzul zzulVar, String str2, boolean z2) {
        this.f78642a = c3;
        this.f78643b = zzulVar;
        this.f78644c = zzuk.c(str2, z2);
        StringBuilder sb = new StringBuilder(String.valueOf(c3).length() + 1);
        sb.append("%");
        sb.append(c3);
        this.f78645d = sb.toString();
    }

    public static zzuj a(char c3) {
        zzuj zzujVar = f78640p[f(c3)];
        if ((c3 & ' ') != 0) {
            return zzujVar;
        }
        if (zzujVar == null || (zzujVar.f78644c & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 0) {
            return null;
        }
        return zzujVar;
    }

    private static int f(char c3) {
        return (c3 | ' ') - 97;
    }

    public static zzuj[] values() {
        return (zzuj[]) f78641q.clone();
    }

    public final char b() {
        return this.f78642a;
    }

    public final zzul c() {
        return this.f78643b;
    }

    final int d() {
        return this.f78644c;
    }

    public final String e() {
        return this.f78645d;
    }
}
