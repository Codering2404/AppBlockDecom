package com.google.android.libraries.places.widget.internal.placedetails;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.share.HKJ.pnxuebdT;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.internal.zzpt;
import com.google.android.libraries.places.widget.model.Orientation;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzas {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f79224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzpt f79225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f79226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f79227d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Orientation f79228e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f79229f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TextView f79230g;

    static /* synthetic */ void g(zzas zzasVar, boolean z2, boolean z3, zzbq zzbqVar, int i3, boolean z4) {
        View view = zzasVar.f79224a;
        view.findViewById(R.id.Z).setVisibility(8);
        if (z2 && z3) {
            ImageView imageView = (ImageView) view.findViewById(R.id.E0);
            View viewFindViewById = view.findViewById(R.id.L0);
            imageView.setVisibility(0);
            viewFindViewById.setVisibility(0);
            if (zzbqVar instanceof zzbm) {
                BuildersKt__Builders_commonKt.d(zzasVar.f79226c, null, null, new zzar(zzasVar, z4, i3, zzbqVar, imageView, null), 3, null);
                return;
            }
            if (zzbqVar instanceof zzbn) {
                zzasVar.h(false, i3);
                imageView.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.f74688d, new ContextThemeWrapper(view.getContext(), zzasVar.f79227d).getTheme()));
            } else {
                if (zzbqVar instanceof zzbo) {
                    return;
                }
                if (zzbqVar instanceof zzbp) {
                    imageView.setImageDrawable(view.getContext().getResources().getDrawable(zzasVar.f79228e == Orientation.f79403a ? R.drawable.f74689e : R.drawable.f74690f, new ContextThemeWrapper(view.getContext(), zzasVar.f79227d).getTheme()));
                } else {
                    if (!(zzbqVar instanceof zzbl)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    Intrinsics.checkNotNull(imageView);
                    zzasVar.i(imageView);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(boolean z2, int i3) {
        TextView textView;
        boolean z3 = z2 && i3 > 0;
        View view = this.f79229f;
        if (view != null) {
            view.setVisibility(true != z3 ? 8 : 0);
        }
        if (!z3 || (textView = this.f79230g) == null) {
            return;
        }
        textView.setText(String.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(ImageView imageView) {
        View view = this.f79224a;
        imageView.setImageDrawable(view.getContext().getResources().getDrawable(R.drawable.f74688d, new ContextThemeWrapper(view.getContext(), this.f79227d).getTheme()));
        view.findViewById(R.id.Z).setVisibility(0);
    }

    private static final void j(TextView textView, CharSequence charSequence, boolean z2) {
        if (!z2 || charSequence == null || StringsKt.p0(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    public final void a() {
        int lineHeight;
        Orientation orientation = this.f79228e;
        Orientation orientation2 = Orientation.f79403a;
        if (orientation == orientation2) {
            lineHeight = ((Button) this.f79224a.findViewById(R.id.f74752o0)).getLineHeight();
        } else {
            View viewFindViewById = this.f79224a.findViewById(R.id.f74748n0);
            Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.Button");
            lineHeight = ((Button) viewFindViewById).getLineHeight();
        }
        View view = this.f79224a;
        Drawable drawable = view.getContext().getDrawable(R.drawable.f74687c);
        if (drawable != null) {
            drawable.setBounds(0, 0, lineHeight, lineHeight);
        } else {
            drawable = null;
        }
        if (orientation != orientation2) {
            View viewFindViewById2 = view.findViewById(R.id.f74748n0);
            Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
            ((TextView) viewFindViewById2).setCompoundDrawablesRelative(null, null, drawable, null);
        } else {
            ImageButton imageButton = (ImageButton) view.findViewById(R.id.f74748n0);
            imageButton.setImageDrawable(drawable);
            imageButton.getLayoutParams().height = imageButton.getPaddingTop() + lineHeight + imageButton.getPaddingBottom();
            imageButton.getLayoutParams().width = lineHeight + imageButton.getPaddingStart() + imageButton.getPaddingEnd();
        }
    }

    public final void b(Place place, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(place, "place");
        View view = this.f79224a;
        TextView textView = (TextView) view.findViewById(R.id.f74776v0);
        TextView textView2 = (TextView) view.findViewById(R.id.M0);
        if (z2) {
            textView.setMaxLines(1);
            TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
            textView.setEllipsize(truncateAt);
            textView2.setMaxLines(1);
            textView2.setEllipsize(truncateAt);
        }
        Intrinsics.checkNotNull(textView2);
        j(textView2, place.p(), true);
        Intrinsics.checkNotNull(textView);
        j(textView, place.v(), z3);
    }

    public final void c(final zzbq placeImage, final boolean z2, final boolean z3, final boolean z4, final int i3) {
        Intrinsics.checkNotNullParameter(placeImage, "placeImage");
        this.f79224a.post(new Runnable() { // from class: com.google.android.libraries.places.widget.internal.placedetails.zzap
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzas.g(this.f79210a, z2, z3, placeImage, i3, z4);
            }
        });
    }

    public zzas(View view, zzpt zzptVar, CoroutineScope lifecycleScope, int i3, Orientation orientation) {
        Intrinsics.checkNotNullParameter(view, pnxuebdT.qkGGbNxgUBOv);
        Intrinsics.checkNotNullParameter(lifecycleScope, "lifecycleScope");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.f79224a = view;
        this.f79225b = zzptVar;
        this.f79226c = lifecycleScope;
        this.f79227d = i3;
        this.f79228e = orientation;
        this.f79229f = view.findViewById(R.id.C0);
        this.f79230g = (TextView) view.findViewById(R.id.K0);
    }
}
