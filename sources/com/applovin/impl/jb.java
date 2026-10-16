package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f60687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Activity f60688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AlertDialog f60689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f60690d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void b();

        void c();
    }

    public jb(Activity activity, com.applovin.impl.sdk.j jVar) {
        this.f60687a = jVar;
        this.f60688b = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        AlertDialog alertDialog = this.f60689c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f60689c = new AlertDialog.Builder(this.f60688b).setTitle((CharSequence) this.f60687a.a(sj.f63747h1)).setMessage((CharSequence) this.f60687a.a(sj.f63751i1)).setCancelable(false).setPositiveButton((CharSequence) this.f60687a.a(sj.f63759k1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.oy
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f62392a.a(dialogInterface, i3);
            }
        }).setNegativeButton((CharSequence) this.f60687a.a(sj.f63755j1), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.py
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                this.f62522a.b(dialogInterface, i3);
            }
        }).show();
    }

    public void a() {
        this.f60688b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.my
            @Override // java.lang.Runnable
            public final void run() {
                this.f61942a.c();
            }
        });
    }

    public boolean b() {
        AlertDialog alertDialog = this.f60689c;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public void e() {
        this.f60688b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ky
            @Override // java.lang.Runnable
            public final void run() {
                this.f61070a.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, DialogInterface dialogInterface, int i3) {
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(com.applovin.impl.sdk.ad.b bVar, final Runnable runnable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f60688b);
        builder.setTitle(bVar.c0());
        String strA0 = bVar.a0();
        if (AppLovinSdkUtils.isValidString(strA0)) {
            builder.setMessage(strA0);
        }
        builder.setPositiveButton(bVar.b0(), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.ly
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                jb.a(runnable, dialogInterface, i3);
            }
        });
        builder.setCancelable(false);
        this.f60689c = builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(DialogInterface dialogInterface, int i3) {
        this.f60690d.b();
    }

    public void b(final com.applovin.impl.sdk.ad.b bVar, final Runnable runnable) {
        this.f60688b.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ny
            @Override // java.lang.Runnable
            public final void run() {
                this.f62144a.a(bVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i3) {
        this.f60690d.c();
    }

    public void a(a aVar) {
        this.f60690d = aVar;
    }
}
