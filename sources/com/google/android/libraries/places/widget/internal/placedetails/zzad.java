package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.AccessibilityOptions;
import com.google.android.libraries.places.api.model.Money;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.zzgf;
import com.google.android.libraries.places.internal.zzef;
import com.google.android.libraries.places.internal.zzop;
import com.google.android.libraries.places.internal.zzpl;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f79149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f79150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f79151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzef f79152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzab f79153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f79154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final View f79155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LinearLayout f79156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TextView f79157i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final TextView f79158j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final TextView f79159k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ImageView f79160l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final TextView f79161m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final TextView f79162n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final TextView f79163o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final TextView f79164p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final TextView f79165q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final TextView f79166r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final View f79167s;

    public zzad(View view, Context context, int i3, zzef zzefVar, zzab widget) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(widget, "widget");
        this.f79149a = view;
        this.f79150b = context;
        this.f79151c = i3;
        this.f79152d = zzefVar;
        this.f79153e = widget;
        View viewFindViewById = view.findViewById(R.id.S0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.f79154f = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(R.id.M1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.f79155g = viewFindViewById2;
        View viewFindViewById3 = view.findViewById(R.id.T0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
        this.f79156h = (LinearLayout) viewFindViewById3;
        View viewFindViewById4 = view.findViewById(R.id.U0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
        this.f79157i = (TextView) viewFindViewById4;
        View viewFindViewById5 = view.findViewById(R.id.f74725h1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById5, "findViewById(...)");
        this.f79158j = (TextView) viewFindViewById5;
        View viewFindViewById6 = view.findViewById(R.id.Q0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById6, "findViewById(...)");
        this.f79159k = (TextView) viewFindViewById6;
        View viewFindViewById7 = view.findViewById(R.id.w2);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById7, "findViewById(...)");
        this.f79160l = (ImageView) viewFindViewById7;
        View viewFindViewById8 = view.findViewById(R.id.f74733j1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById8, "findViewById(...)");
        this.f79161m = (TextView) viewFindViewById8;
        View viewFindViewById9 = view.findViewById(R.id.f74729i1);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById9, "findViewById(...)");
        this.f79162n = (TextView) viewFindViewById9;
        View viewFindViewById10 = view.findViewById(R.id.R0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById10, "findViewById(...)");
        this.f79163o = (TextView) viewFindViewById10;
        View viewFindViewById11 = view.findViewById(R.id.O0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById11, "findViewById(...)");
        this.f79164p = (TextView) viewFindViewById11;
        View viewFindViewById12 = view.findViewById(R.id.P0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById12, "findViewById(...)");
        this.f79165q = (TextView) viewFindViewById12;
        View viewFindViewById13 = view.findViewById(R.id.N0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById13, "findViewById(...)");
        this.f79166r = (TextView) viewFindViewById13;
        View viewFindViewById14 = view.findViewById(R.id.f74748n0);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById14, "findViewById(...)");
        this.f79167s = viewFindViewById14;
    }

    static /* synthetic */ void g(zzad zzadVar, Place place, zzo zzoVar, View view) {
        zzadVar.h(i(place));
        if (zzoVar != null) {
            zzoVar.f(zzadVar.f79150b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(Intent intent) {
        try {
            this.f79150b.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            new zzpl(this.f79150b, this.f79151c).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Intent i(Place place) {
        Uri uriD = place.D();
        if (uriD == null) {
            String strV = place.v();
            String strG = place.G();
            StringBuilder sb = new StringBuilder(String.valueOf(strV).length() + 64 + String.valueOf(strG).length());
            sb.append("https://www.google.com/maps/search/?api=1&query=");
            sb.append(strV);
            sb.append("&query_place_id=");
            sb.append(strG);
            uriD = Uri.parse(sb.toString());
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uriD);
        return intent;
    }

    private static final void j(View view, CharSequence charSequence, boolean z2) {
        if (!z2 || charSequence == null || StringsKt.p0(charSequence)) {
            view.setVisibility(8);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        view.setVisibility(0);
    }

    public final void a(Place place, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzo zzoVar) {
        Integer numU0;
        String string;
        String strC;
        String string2;
        zzab zzabVar;
        Intrinsics.checkNotNullParameter(place, "place");
        if (place.j() == null || !((zzabVar = this.f79153e) == zzab.f79142a || zzabVar == zzab.f79144c)) {
            Double dA0 = place.a0();
            if (dA0 == null || place.u0() == null || ((numU0 = place.u0()) != null && numU0.intValue() == 0)) {
                TextView textView = this.f79154f;
                Context context = this.f79150b;
                int i3 = R.string.f74832d0;
                j(textView, context.getString(i3), z2);
                this.f79155g.setVisibility(8);
                this.f79157i.setVisibility(8);
                this.f79156h.setContentDescription(context.getResources().getString(i3));
            } else {
                TextView textView2 = this.f79154f;
                j(textView2, dA0.toString(), z2);
                View view = this.f79155g;
                if (view instanceof RatingStarsView) {
                    RatingStarsView ratingStarsView = (RatingStarsView) view;
                    ratingStarsView.getLayoutParams().height = textView2.getLineHeight();
                    ratingStarsView.a(dA0.doubleValue());
                } else {
                    view.getLayoutParams().height = textView2.getLineHeight();
                    view.getLayoutParams().width = textView2.getLineHeight();
                }
                j(view, dA0.toString(), z2);
                int iDoubleValue = Intrinsics.areEqual(dA0, 1.0d) ? (int) dA0.doubleValue() : 5;
                LinearLayout linearLayout = this.f79156h;
                Context context2 = this.f79150b;
                linearLayout.setContentDescription(context2.getResources().getQuantityString(R.plurals.f74820b, iDoubleValue, dA0.toString()));
                Integer numU02 = place.u0();
                if (numU02 != null) {
                    string = context2.getString(R.string.N0, NumberFormat.getNumberInstance(Locale.getDefault()).format(numU02));
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                } else {
                    string = null;
                }
                SpannableString spannableString = new SpannableString(string);
                spannableString.setSpan(new zzac(this, place, zzoVar), 1, spannableString.length() - 1, 33);
                TextView textView3 = this.f79157i;
                j(textView3, spannableString, z2);
                textView3.setMovementMethod(new LinkMovementMethod());
                Resources resources = context2.getResources();
                int i4 = R.plurals.f74821c;
                Integer numU03 = place.u0();
                textView3.setContentDescription(resources.getQuantityString(i4, numU03 != null ? numU03.intValue() : 0, place.u0()));
            }
        } else {
            this.f79154f.setVisibility(8);
            this.f79155g.setVisibility(8);
            this.f79157i.setVisibility(8);
        }
        TextView textView4 = this.f79158j;
        j(textView4, place.X(), z3);
        TextView textView5 = this.f79159k;
        Context context3 = this.f79150b;
        Intrinsics.checkNotNullParameter(place, "<this>");
        Intrinsics.checkNotNullParameter(context3, "context");
        zzgf zzgfVarY0 = place.y0();
        Money moneyC = zzgfVarY0 != null ? zzgfVarY0.c() : null;
        zzgf zzgfVarY02 = place.y0();
        Money moneyD = zzgfVarY02 != null ? zzgfVarY02.d() : null;
        if (moneyC == null || (strC = moneyC.c()) == null) {
            strC = moneyD != null ? moneyD.c() : null;
        }
        if (place.y0() == null || strC == null || moneyC == null) {
            string2 = null;
        } else {
            Currency currency = Currency.getInstance(strC);
            Intrinsics.checkNotNullExpressionValue(currency, "getInstance(...)");
            String symbol = currency.getSymbol(Locale.getDefault());
            Intrinsics.checkNotNullExpressionValue(symbol, "getSymbol(...)");
            string2 = moneyD != null ? context3.getString(R.string.L0, symbol, moneyC.e(), moneyD.e()) : context3.getString(R.string.M0, symbol, moneyC.e());
        }
        if (string2 == null) {
            Integer numU = place.U();
            string2 = (numU != null && numU.intValue() == 1) ? context3.getString(R.string.H0) : (numU != null && numU.intValue() == 2) ? context3.getString(R.string.I0) : (numU != null && numU.intValue() == 3) ? context3.getString(R.string.J0) : (numU != null && numU.intValue() == 4) ? context3.getString(R.string.K0) : null;
        }
        j(textView5, string2, z4);
        AccessibilityOptions accessibilityOptionsD = place.d();
        if ((accessibilityOptionsD != null ? accessibilityOptionsD.d() : null) == Place.BooleanPlaceAttributeValue.TRUE && z5) {
            ImageView imageView = this.f79160l;
            imageView.setVisibility(0);
            TextView textView6 = this.f79161m;
            imageView.getLayoutParams().height = textView6.getLineHeight();
            imageView.getLayoutParams().width = textView6.getLineHeight();
            if (textView4.getVisibility() == 8 && textView5.getVisibility() == 8) {
                textView6.setVisibility(0);
            } else {
                textView6.setVisibility(8);
            }
        } else {
            this.f79160l.setVisibility(8);
            this.f79161m.setVisibility(8);
        }
        TextView textView7 = this.f79164p;
        j(textView7, zzag.c(place, context3), z6);
        textView7.setTextColor(zzag.a(place, context3, this.f79151c));
        TextView textView8 = this.f79166r;
        zzef zzefVar = this.f79152d;
        j(textView8, zzag.b(place, zzefVar != null ? zzefVar.zza() : null, context3), z6);
        if (textView4.getVisibility() == 0 && (textView5.getVisibility() == 0 || this.f79160l.getVisibility() == 0)) {
            this.f79162n.setVisibility(0);
        } else {
            this.f79162n.setVisibility(8);
        }
        if (textView5.getVisibility() == 0 && this.f79160l.getVisibility() == 0) {
            this.f79163o.setVisibility(0);
        } else {
            this.f79163o.setVisibility(8);
        }
        if (textView7.getVisibility() == 0 && textView8.getVisibility() == 0) {
            this.f79165q.setVisibility(0);
        } else {
            this.f79165q.setVisibility(8);
        }
    }

    public final void b(final Place place, final zzo zzoVar) {
        Intrinsics.checkNotNullParameter(place, "place");
        View view = this.f79167s;
        view.setVisibility(0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzaa
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view2) {
                zzad.g(this.f79139a, place, zzoVar, view2);
            }
        });
        zzop.a(view, this.f79149a, this.f79150b, 48, 48);
    }

    public final void c() {
        this.f79154f.setVisibility(8);
        this.f79155g.setVisibility(8);
        this.f79157i.setVisibility(8);
        this.f79158j.setVisibility(8);
        this.f79159k.setVisibility(8);
        this.f79160l.setVisibility(8);
        this.f79161m.setVisibility(8);
        this.f79162n.setVisibility(8);
        this.f79163o.setVisibility(8);
        this.f79164p.setVisibility(8);
        this.f79165q.setVisibility(8);
        this.f79166r.setVisibility(8);
        this.f79167s.setVisibility(8);
    }
}
