package com.google.android.libraries.places.widget.internal.placedetails;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocalDate;
import com.google.android.libraries.places.api.model.Review;
import com.google.android.libraries.places.internal.zzop;
import com.google.android.libraries.places.internal.zzpl;
import com.google.android.libraries.places.internal.zzpm;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzci extends RecyclerView.Adapter {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Lazy f79324n = LazyKt.b(zzcd.f79301a);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f79325o = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f79326i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CoroutineScope f79327j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f79328k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Function0 f79329l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final zzpm f79330m;

    public zzci(List reviews, zzpm zzpmVar, CoroutineScope scope, int i3, Function0 onReviewContentUpdated) {
        Intrinsics.checkNotNullParameter(reviews, "reviews");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(onReviewContentUpdated, "onReviewContentUpdated");
        this.f79326i = reviews;
        this.f79330m = zzpmVar;
        this.f79327j = scope;
        this.f79328k = i3;
        this.f79329l = onReviewContentUpdated;
    }

    static /* synthetic */ void h(zzcf zzcfVar, zzci zzciVar, Review review, View view) {
        zzcfVar.j().setVisibility(8);
        zzcfVar.k().setVisibility(8);
        zzcfVar.l().setVisibility(0);
        TextView textViewG = zzcfVar.g();
        String strF = review.f();
        if (strF == null) {
            strF = "";
        }
        o(textViewG, strF);
        zzciVar.f79329l.invoke();
    }

    static /* synthetic */ void i(zzcf zzcfVar, zzci zzciVar, Review review, View view) {
        zzcfVar.j().setVisibility(0);
        zzcfVar.k().setVisibility(0);
        zzcfVar.l().setVisibility(8);
        TextView textViewG = zzcfVar.g();
        String strK = review.k();
        if (strK == null) {
            strK = "";
        }
        o(textViewG, strK);
        zzciVar.f79329l.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean m(Context context, zzci zzciVar, Review review, MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.S1) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(review.e());
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            Intrinsics.checkNotNull(context);
            new zzpl(context, zzciVar.f79328k).show();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(Context context, zzci zzciVar, Review review, View view) {
        Intent intent = new Intent("android.intent.action.VIEW");
        String strD = review.d().d();
        intent.setData(strD != null ? Uri.parse(strD) : null);
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Intrinsics.checkNotNull(context);
            new zzpl(context, zzciVar.f79328k).show();
        }
    }

    private static final void o(View view, CharSequence charSequence) {
        if (charSequence == null || StringsKt.p0(charSequence)) {
            view.setVisibility(8);
            return;
        }
        if (view instanceof TextView) {
            ((TextView) view).setText(charSequence);
        }
        view.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(zzcf viewHolder, int i3) {
        final zzcf zzcfVar;
        String string;
        String strL;
        String strG;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        final Review review = (Review) this.f79326i.get(i3);
        final Context context = viewHolder.itemView.getContext();
        String strC = review.d().c();
        Drawable drawable = context.getDrawable(R.drawable.f74694j);
        viewHolder.c().setImageDrawable(drawable);
        if (strC != null) {
            zzcfVar = viewHolder;
            BuildersKt__Builders_commonKt.d(this.f79327j, null, null, new zzch(this, strC, zzcfVar, drawable, null), 3, null);
        } else {
            zzcfVar = viewHolder;
        }
        o(zzcfVar.d(), review.d().getName());
        o(zzcfVar.e(), review.j());
        RatingStarsView ratingStarsViewF = zzcfVar.f();
        Double dI = review.i();
        Intrinsics.checkNotNullExpressionValue(dI, "getRating(...)");
        ratingStarsViewF.a(dI.doubleValue());
        TextView textViewG = zzcfVar.g();
        String strK = review.k();
        if (strK == null) {
            strK = "";
        }
        o(textViewG, strK);
        if (Intrinsics.areEqual(review.l(), review.g()) || (strL = review.l()) == null || StringsKt.p0(strL) || (strG = review.g()) == null || StringsKt.p0(strG)) {
            zzcfVar.m().setVisibility(8);
            zzcfVar.j().setVisibility(8);
            zzcfVar.k().setVisibility(8);
            zzcfVar.l().setVisibility(8);
        } else {
            String strG2 = review.g();
            Intrinsics.checkNotNull(strG2, "null cannot be cast to non-null type kotlin.String");
            String displayName = Locale.forLanguageTag(strG2).getDisplayName();
            Intrinsics.checkNotNullExpressionValue(displayName, "getDisplayName(...)");
            String string2 = context.getString(R.string.P0, displayName);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            o(zzcfVar.k(), string2);
            zzcfVar.k().setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzce
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    zzci.h(zzcfVar, this, review, view);
                }
            });
            zzcfVar.l().setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzbz
                @Override // android.view.View.OnClickListener
                public final /* synthetic */ void onClick(View view) {
                    zzci.i(zzcfVar, this, review, view);
                }
            });
            zzcfVar.m().setVisibility(0);
            zzcfVar.j().setVisibility(0);
            zzcfVar.l().setVisibility(8);
        }
        LocalDate localDateM = review.m();
        if (localDateM != null) {
            Calendar calendar = Calendar.getInstance();
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
            calendar.clear();
            calendar.set(localDateM.e(), localDateM.d() - 1, localDateM.c());
            string = context.getString(R.string.V0, ((SimpleDateFormat) f79324n.getValue()).format(calendar.getTime()));
        } else {
            string = null;
        }
        o(zzcfVar.h(), string);
        zzcfVar.i().setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzca
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                final Context context2 = context;
                PopupMenu popupMenu = new PopupMenu(context2, view);
                popupMenu.inflate(R.menu.f74818c);
                final zzci zzciVar = this;
                final Review review2 = review;
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzcc
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final /* synthetic */ boolean onMenuItemClick(MenuItem menuItem) {
                        return zzci.m(context2, zzciVar, review2, menuItem);
                    }
                });
                popupMenu.show();
            }
        });
        zzcfVar.b().setOnClickListener(new View.OnClickListener() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzcb
            @Override // android.view.View.OnClickListener
            public final /* synthetic */ void onClick(View view) {
                zzci.n(context, this, review, view);
            }
        });
        ConstraintLayout constraintLayoutB = zzcfVar.b();
        View itemView = zzcfVar.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        Intrinsics.checkNotNull(context);
        zzop.a(constraintLayoutB, itemView, context, 48, 48);
        zzcfVar.b().setContentDescription(context.getString(R.string.U0, review.d().getName()));
        zzop.b(zzcfVar.b());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f79326i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f74808s, viewGroup, false);
        Intrinsics.checkNotNull(viewInflate);
        return new zzcf(viewInflate);
    }
}
