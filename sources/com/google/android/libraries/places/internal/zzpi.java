package com.google.android.libraries.places.internal;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzpi f78393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzpi f78394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzpi f78395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzpi f78396d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ zzpi[] f78397f;

    static {
        zzpi zzpiVar = new zzpi("REVIEWS_ARENT_VERIFIED", 0);
        f78393a = zzpiVar;
        zzpi zzpiVar2 = new zzpi("ABOUT_RESULTS", 1);
        f78394b = zzpiVar2;
        zzpi zzpiVar3 = new zzpi("REVIEW_ORDERING", 2);
        f78395c = zzpiVar3;
        zzpi zzpiVar4 = new zzpi("REPORT_BUSINESS_CONDUCT", 3);
        f78396d = zzpiVar4;
        zzpi[] zzpiVarArr = {zzpiVar, zzpiVar2, zzpiVar3, zzpiVar4};
        f78397f = zzpiVarArr;
        EnumEntriesKt.a(zzpiVarArr);
    }

    private zzpi(String str, int i3) {
    }

    public static zzpi valueOf(String str) {
        return (zzpi) Enum.valueOf(zzpi.class, str);
    }

    public static zzpi[] values() {
        return (zzpi[]) f78397f.clone();
    }
}
