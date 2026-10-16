package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.ConsumerAlert;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzpb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f79354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f79355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View f79356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextView f79357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f79358e;

    public zzr(Context context, int i3, View view) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(view, "view");
        this.f79354a = context;
        this.f79355b = i3;
        View viewFindViewById = view.findViewById(R.id.G);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79356c = viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.I);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79357d = (TextView) viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.H);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79358e = (TextView) viewFindViewById3;
    }

    static /* synthetic */ void b(zzr zzrVar) {
        TextView textView = zzrVar.f79358e;
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        Intrinsics.checkNotNullExpressionValue(compoundDrawablesRelative, "getCompoundDrawablesRelative(...)");
        Drawable drawable = compoundDrawablesRelative[2];
        if (drawable != null) {
            int lineHeight = textView.getLineHeight();
            drawable.setBounds(0, 0, lineHeight, lineHeight);
            textView.setCompoundDrawablesRelative(null, null, drawable, null);
        }
    }

    public final void a(Place place) {
        Intrinsics.checkNotNullParameter(place, "place");
        final ConsumerAlert consumerAlertJ = place.j();
        if (consumerAlertJ == null) {
            this.f79356c.setVisibility(8);
            return;
        }
        this.f79356c.setVisibility(0);
        this.f79357d.setText(consumerAlertJ.f());
        TextView textView = this.f79358e;
        textView.post(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzr.b(this.f79353a);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzp
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                zzr zzrVar = this.f79351a;
                new zzpb(zzrVar.f79354a, zzrVar.f79355b, consumerAlertJ).show();
            }
        });
    }
}
