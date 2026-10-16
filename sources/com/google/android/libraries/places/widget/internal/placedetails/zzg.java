package com.google.android.libraries.places.widget.internal.placedetails;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzg extends zzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f79341a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzg(String name) {
        super(null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.f79341a = name;
    }

    public final String a() {
        return this.f79341a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzg) && Intrinsics.areEqual(this.f79341a, ((zzg) obj).f79341a);
    }

    public final int hashCode() {
        return this.f79341a.hashCode();
    }

    public final String toString() {
        String str = this.f79341a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 14);
        sb.append("Feature(name=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }
}
