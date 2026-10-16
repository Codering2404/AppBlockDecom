package com.google.android.libraries.places.widget.internal.placedetails;

import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzab f79142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzab f79143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzab f79144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ zzab[] f79145d;

    static {
        zzab zzabVar = new zzab("PLACE_DETAILS_COMPACT", 0);
        f79142a = zzabVar;
        zzab zzabVar2 = new zzab("PLACE_DETAILS_FULL", 1);
        f79143b = zzabVar2;
        zzab zzabVar3 = new zzab("PLACE_SEARCH", 2);
        f79144c = zzabVar3;
        zzab[] zzabVarArr = {zzabVar, zzabVar2, zzabVar3};
        f79145d = zzabVarArr;
        EnumEntriesKt.a(zzabVarArr);
    }

    private zzab(String str, int i3) {
    }

    public static zzab valueOf(String str) {
        return (zzab) Enum.valueOf(zzab.class, str);
    }

    public static zzab[] values() {
        return (zzab[]) f79145d.clone();
    }
}
