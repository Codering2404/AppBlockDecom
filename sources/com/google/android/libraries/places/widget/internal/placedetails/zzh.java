package com.google.android.libraries.places.widget.internal.placedetails;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzh extends zzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f79342a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzh(String title) {
        super(null);
        Intrinsics.checkNotNullParameter(title, "title");
        this.f79342a = title;
    }

    public final String a() {
        return this.f79342a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof zzh) && Intrinsics.areEqual(this.f79342a, ((zzh) obj).f79342a);
    }

    public final int hashCode() {
        return this.f79342a.hashCode();
    }

    public final String toString() {
        String str = this.f79342a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20);
        sb.append("SectionTitle(title=");
        sb.append(str);
        sb.append(")");
        return sb.toString();
    }
}
