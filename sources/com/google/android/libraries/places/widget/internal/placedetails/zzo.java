package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzamd;
import com.google.android.libraries.places.internal.zzamg;
import com.google.android.libraries.places.internal.zzamj;
import com.google.android.libraries.places.internal.zzaml;
import com.google.android.libraries.places.internal.zzamm;
import com.google.android.libraries.places.internal.zzox;
import com.google.android.libraries.places.internal.zzpu;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzo implements Parcelable {
    public static final Parcelable.Creator<zzo> CREATOR = new zzn();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzaml f79346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzamj f79347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f79348c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f79349d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzpu f79350f;

    public zzo(zzaml variant, zzamj orientation, List content, int i3) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(content, "content");
        this.f79346a = variant;
        this.f79347b = orientation;
        this.f79348c = content;
        this.f79349d = i3;
    }

    private final zzamd m(Context context) {
        zzamd zzamdVarG = zzamm.G();
        zzamdVarG.y(this.f79346a);
        zzamdVarG.z(this.f79347b);
        zzamdVarG.A(this.f79348c);
        zzamdVarG.D(zzox.a(context, this.f79349d));
        Intrinsics.checkNotNullExpressionValue(zzamdVarG, "setPlacesMaterialThemeCustomization(...)");
        return zzamdVarG;
    }

    private final void n(zzamd zzamdVar) {
        zzpu zzpuVar = this.f79350f;
        if (zzpuVar != null) {
            zzpuVar.a((zzamm) zzamdVar.zzG());
        }
    }

    private final void o(Context context, int i3) {
        zzamd zzamdVarM = m(context);
        q(zzamdVarM, i3);
        n(zzamdVarM);
    }

    private final void p(Context context, int i3, Integer num) {
        zzamd zzamdVarM = m(context);
        q(zzamdVarM, 12);
        zzamdVarM.F(i3);
        Intrinsics.checkNotNullExpressionValue(zzamdVarM, "setLightboxEventType(...)");
        if (num != null) {
            zzamdVarM.B(num.intValue());
        }
        n(zzamdVarM);
    }

    private static final zzamd q(zzamd zzamdVar, int i3) {
        zzamdVar.E(i3);
        Intrinsics.checkNotNullExpressionValue(zzamdVar, "setEventType(...)");
        return zzamdVar;
    }

    public final void a(zzpu zzpuVar) {
        this.f79350f = zzpuVar;
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o(context, 2);
    }

    public final void d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o(context, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o(context, 4);
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o(context, 5);
    }

    public final void g(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        o(context, 7);
    }

    public final void h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        p(context, 2, null);
    }

    public final void i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        p(context, 3, null);
    }

    public final void j(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        p(context, 4, null);
    }

    public final void k(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        p(context, 5, Integer.valueOf(i3));
    }

    public final void l(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        p(context, 6, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.f79346a.name());
        dest.writeString(this.f79347b.name());
        List list = this.f79348c;
        dest.writeInt(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            dest.writeString(((zzamg) it.next()).name());
        }
        dest.writeInt(this.f79349d);
    }
}
