package com.google.android.gms.ads.internal.overlay;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbiq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzu extends FrameLayout implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageButton f70137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzah f70138b;

    public zzu(Context context, zzt zztVar, zzah zzahVar) {
        super(context);
        this.f70138b = zzahVar;
        setOnClickListener(this);
        ImageButton imageButton = new ImageButton(context);
        this.f70137a = imageButton;
        c();
        imageButton.setBackgroundColor(0);
        imageButton.setOnClickListener(this);
        zzay.a();
        int iE = com.google.android.gms.ads.internal.util.client.zzf.e(context, zztVar.f70133a);
        zzay.a();
        int iE2 = com.google.android.gms.ads.internal.util.client.zzf.e(context, 0);
        zzay.a();
        int iE3 = com.google.android.gms.ads.internal.util.client.zzf.e(context, zztVar.f70134b);
        zzay.a();
        imageButton.setPadding(iE, iE2, iE3, com.google.android.gms.ads.internal.util.client.zzf.e(context, zztVar.f70135c));
        imageButton.setContentDescription("Interstitial close button");
        zzay.a();
        int iE4 = com.google.android.gms.ads.internal.util.client.zzf.e(context, zztVar.f70136d + zztVar.f70133a + zztVar.f70134b);
        zzay.a();
        addView(imageButton, new FrameLayout.LayoutParams(iE4, com.google.android.gms.ads.internal.util.client.zzf.e(context, zztVar.f70136d + zztVar.f70135c), 17));
        long jLongValue = ((Long) zzba.c().zzd(zzbiq.zzbO)).longValue();
        if (jLongValue <= 0) {
            return;
        }
        zzs zzsVar = ((Boolean) zzba.c().zzd(zzbiq.zzbP)).booleanValue() ? new zzs(this) : null;
        imageButton.setAlpha(0.0f);
        imageButton.animate().alpha(1.0f).setDuration(jLongValue).setListener(zzsVar);
    }

    private final void c() {
        String str = (String) zzba.c().zzd(zzbiq.zzbN);
        if (TextUtils.isEmpty(str) || "default".equals(str)) {
            this.f70137a.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.l().zzf();
        if (resourcesZzf == null) {
            this.f70137a.setImageResource(R.drawable.btn_dialog);
            return;
        }
        Drawable drawable = null;
        try {
            if ("white".equals(str)) {
                drawable = resourcesZzf.getDrawable(com.google.android.gms.ads.impl.R.drawable.f69741b);
            } else if ("black".equals(str)) {
                drawable = resourcesZzf.getDrawable(com.google.android.gms.ads.impl.R.drawable.f69740a);
            }
        } catch (Resources.NotFoundException unused) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Close button resource not found, falling back to default.");
        }
        if (drawable == null) {
            this.f70137a.setImageResource(R.drawable.btn_dialog);
            return;
        }
        ImageButton imageButton = this.f70137a;
        imageButton.setImageDrawable(drawable);
        imageButton.setScaleType(ImageView.ScaleType.CENTER);
    }

    public final void a(boolean z2) {
        if (!z2) {
            this.f70137a.setVisibility(0);
            return;
        }
        ImageButton imageButton = this.f70137a;
        imageButton.setVisibility(8);
        if (((Long) zzba.c().zzd(zzbiq.zzbO)).longValue() > 0) {
            imageButton.animate().cancel();
            imageButton.clearAnimation();
        }
    }

    final /* synthetic */ ImageButton b() {
        return this.f70137a;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        zzah zzahVar = this.f70138b;
        if (zzahVar != null) {
            zzahVar.zzd();
        }
    }
}
