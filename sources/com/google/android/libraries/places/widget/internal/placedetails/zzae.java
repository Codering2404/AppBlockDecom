package com.google.android.libraries.places.widget.internal.placedetails;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzae f79168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzae f79169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzae f79170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzae f79171d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzae f79172f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzae f79173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ zzae[] f79174h;

    static {
        zzae zzaeVar = new zzae("UNKNOWN", 0);
        f79168a = zzaeVar;
        zzae zzaeVar2 = new zzae("OPEN_NOW", 1);
        f79169b = zzaeVar2;
        zzae zzaeVar3 = new zzae("OPEN_24_HOURS", 2);
        f79170c = zzaeVar3;
        zzae zzaeVar4 = new zzae("CLOSED", 3);
        f79171d = zzaeVar4;
        zzae zzaeVar5 = new zzae("TEMPORARILY_CLOSED", 4);
        f79172f = zzaeVar5;
        zzae zzaeVar6 = new zzae("PERMANENTLY_CLOSED", 5);
        f79173g = zzaeVar6;
        zzae[] zzaeVarArr = {zzaeVar, zzaeVar2, zzaeVar3, zzaeVar4, zzaeVar5, zzaeVar6};
        f79174h = zzaeVarArr;
        EnumEntriesKt.a(zzaeVarArr);
    }

    private zzae(String str, int i3) {
    }

    public static zzae valueOf(String str) {
        return (zzae) Enum.valueOf(zzae.class, str);
    }

    public static zzae[] values() {
        return (zzae[]) f79174h.clone();
    }
}
