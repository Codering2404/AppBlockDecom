package com.google.android.libraries.places.widget.internal.placedetails;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f79246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f79247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f79248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f79249d;

    public final boolean a() {
        return this.f79246a;
    }

    public final List b() {
        return this.f79247b;
    }

    public final int c() {
        return this.f79248c;
    }

    public final int d() {
        return this.f79249d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return this.f79246a == zzbdVar.f79246a && Intrinsics.areEqual(this.f79247b, zzbdVar.f79247b) && this.f79248c == zzbdVar.f79248c && this.f79249d == zzbdVar.f79249d;
    }

    public final int hashCode() {
        return (((((Boolean.hashCode(this.f79246a) * 31) + this.f79247b.hashCode()) * 31) + Integer.hashCode(this.f79248c)) * 31) + Integer.hashCode(this.f79249d);
    }

    public final String toString() {
        boolean z2 = this.f79246a;
        int length = String.valueOf(z2).length();
        List list = this.f79247b;
        int length2 = String.valueOf(list).length();
        int i3 = this.f79248c;
        int length3 = String.valueOf(i3).length();
        int i4 = this.f79249d;
        StringBuilder sb = new StringBuilder(length + 51 + length2 + 29 + length3 + 29 + String.valueOf(i4).length() + 1);
        sb.append("RequestConfiguration(mediaRequested=");
        sb.append(z2);
        sb.append(", fieldsToLoad=");
        sb.append(list);
        sb.append(", thumbSizeDimensionInPixels=");
        sb.append(i3);
        sb.append(", screenMaxDimensionInPixels=");
        sb.append(i4);
        sb.append(")");
        return sb.toString();
    }
}
