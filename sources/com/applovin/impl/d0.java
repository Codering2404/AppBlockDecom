package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class d0 extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f59047a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AppLovinSdkUtils.Size f59048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Activity f59049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private RelativeLayout f59050d;

    public d0(ViewGroup viewGroup, AppLovinSdkUtils.Size size, Activity activity) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        this.f59047a = viewGroup;
        this.f59048b = size;
        this.f59049c = activity;
        requestWindowFeature(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        this.f59050d.removeView(this.f59047a);
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AppLovinSdkUtils.dpToPx(this.f59049c, this.f59048b.getWidth()), AppLovinSdkUtils.dpToPx(this.f59049c, this.f59048b.getHeight()));
        layoutParams.addRule(13);
        this.f59047a.setLayoutParams(layoutParams);
        int iDpToPx = AppLovinSdkUtils.dpToPx(this.f59049c, 60);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iDpToPx, iDpToPx);
        layoutParams2.addRule(14);
        layoutParams2.addRule(12);
        ImageButton imageButton = new ImageButton(this.f59049c);
        imageButton.setLayoutParams(layoutParams2);
        imageButton.setImageDrawable(this.f59049c.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_x_mark));
        imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageButton.setColorFilter(-1);
        imageButton.setBackground(null);
        imageButton.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.nu
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f62140a.a(view);
            }
        });
        RelativeLayout relativeLayout = new RelativeLayout(this.f59049c);
        this.f59050d = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f59050d.setBackgroundColor(Integer.MIN_VALUE);
        this.f59050d.addView(imageButton);
        this.f59050d.addView(this.f59047a);
        this.f59050d.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.ou
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f62386a.b(view);
            }
        });
        setContentView(this.f59050d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        dismiss();
    }
}
