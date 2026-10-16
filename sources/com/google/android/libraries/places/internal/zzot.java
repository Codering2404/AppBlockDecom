package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.R;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzot {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzot f78364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzot f78365d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzot f78366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ zzot[] f78367g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f78368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f78369b;

    static {
        zzot zzotVar = new zzot("WHITE", 0, 0, R.color.f74666c);
        f78364c = zzotVar;
        zzot zzotVar2 = new zzot("GRAY", 1, 1, R.color.f74665b);
        f78365d = zzotVar2;
        zzot zzotVar3 = new zzot("BLACK", 2, 2, R.color.f74664a);
        f78366f = zzotVar3;
        zzot[] zzotVarArr = {zzotVar, zzotVar2, zzotVar3};
        f78367g = zzotVarArr;
        EnumEntriesKt.a(zzotVarArr);
    }

    private zzot(String str, int i3, int i4, int i5) {
        this.f78368a = i4;
        this.f78369b = i5;
    }

    public static zzot valueOf(String str) {
        return (zzot) Enum.valueOf(zzot.class, str);
    }

    public static zzot[] values() {
        return (zzot[]) f78367g.clone();
    }

    public final int a() {
        return this.f78369b;
    }

    public final int zza() {
        return this.f78368a;
    }
}
