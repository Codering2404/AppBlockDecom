package com.google.android.libraries.places.internal;

import com.facebook.share.internal.ShareConstants;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zzpx f78430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzpx f78431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzpx f78432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzpx f78433d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzpx f78434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzpx f78435g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzpx f78436h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final /* synthetic */ zzpx[] f78437i;

    static {
        zzpx zzpxVar = new zzpx(ShareConstants.MEDIA, 0);
        f78430a = zzpxVar;
        zzpx zzpxVar2 = new zzpx("ADDRESS", 1);
        f78431b = zzpxVar2;
        zzpx zzpxVar3 = new zzpx("RATING", 2);
        f78432c = zzpxVar3;
        zzpx zzpxVar4 = new zzpx("PRICE", 3);
        f78433d = zzpxVar4;
        zzpx zzpxVar5 = new zzpx("TYPE", 4);
        f78434f = zzpxVar5;
        zzpx zzpxVar6 = new zzpx("ACCESSIBLE_ENTRANCE_ICON", 5);
        f78435g = zzpxVar6;
        zzpx zzpxVar7 = new zzpx("OPEN_NOW_STATUS", 6);
        f78436h = zzpxVar7;
        zzpx[] zzpxVarArr = {zzpxVar, zzpxVar2, zzpxVar3, zzpxVar4, zzpxVar5, zzpxVar6, zzpxVar7};
        f78437i = zzpxVarArr;
        EnumEntriesKt.a(zzpxVarArr);
    }

    private zzpx(String str, int i3) {
    }

    public static zzpx valueOf(String str) {
        return (zzpx) Enum.valueOf(zzpx.class, str);
    }

    public static zzpx[] values() {
        return (zzpx[]) f78437i.clone();
    }
}
