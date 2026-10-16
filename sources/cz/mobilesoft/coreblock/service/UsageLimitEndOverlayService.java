package cz.mobilesoft.coreblock.service;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import com.facebook.internal.Utility;
import cz.mobilesoft.coreblock.databinding.LayoutUsageLimitEndBinding;
import cz.mobilesoft.coreblock.util.helperextension.StringHelper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
public class UsageLimitEndOverlayService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WindowManager f123142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutUsageLimitEndBinding f123143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f123144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f123145d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f123146f;

    private void e() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -2, 2038, 32, -3);
        layoutParams.gravity = 8388659;
        layoutParams.x = 0;
        layoutParams.y = 0;
        LayoutUsageLimitEndBinding layoutUsageLimitEndBindingC = LayoutUsageLimitEndBinding.c(LayoutInflater.from(this));
        this.f123143b = layoutUsageLimitEndBindingC;
        this.f123142a.addView(layoutUsageLimitEndBindingC.getRoot(), layoutParams);
        this.f123143b.getRoot().post(new Runnable() { // from class: cz.mobilesoft.coreblock.service.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f123151a.h();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        LayoutUsageLimitEndBinding layoutUsageLimitEndBinding = this.f123143b;
        if (layoutUsageLimitEndBinding != null) {
            layoutUsageLimitEndBinding.getRoot().animate().translationYBy(-this.f123143b.getRoot().getHeight()).setDuration(500L).setListener(new AnimatorListenerAdapter() { // from class: cz.mobilesoft.coreblock.service.UsageLimitEndOverlayService.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    UsageLimitEndOverlayService.this.f();
                }
            }).start();
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f123143b.getRoot().setTranslationY(-this.f123143b.getRoot().getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.f123143b.getRoot().animate().translationYBy(this.f123143b.getRoot().getHeight()).setDuration(500L).start();
    }

    private void k() {
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.f123144c, Utility.DEFAULT_STREAM_BUFFER_SIZE);
            if (applicationInfo != null) {
                this.f123143b.f96835d.setImageDrawable(packageManager.getApplicationIcon(applicationInfo));
                String str = this.f123145d;
                if (str != null) {
                    this.f123143b.f96837f.setText(str);
                } else {
                    this.f123143b.f96837f.setText(packageManager.getApplicationLabel(applicationInfo));
                }
            }
            this.f123143b.f96833b.setOnClickListener(new View.OnClickListener() { // from class: cz.mobilesoft.coreblock.service.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f123152a.i(view);
                }
            });
            this.f123143b.f96834c.setText(StringHelper.t(this, this.f123146f));
            this.f123143b.getRoot().post(new Runnable() { // from class: cz.mobilesoft.coreblock.service.h
                @Override // java.lang.Runnable
                public final void run() {
                    this.f123153a.j();
                }
            });
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: cz.mobilesoft.coreblock.service.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f123154a.g();
                }
            }, 9500L);
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            f();
        }
    }

    public static void l(Context context, String str, String str2, long j3) {
        Intent intent = new Intent(context, (Class<?>) UsageLimitEndOverlayService.class);
        context.stopService(intent);
        intent.putExtra("PACKAGE_NAME", str);
        intent.putExtra("URL", str2);
        intent.putExtra("REMAINING_TIME", j3);
        context.startService(intent);
    }

    public void f() {
        try {
            LayoutUsageLimitEndBinding layoutUsageLimitEndBinding = this.f123143b;
            if (layoutUsageLimitEndBinding != null) {
                this.f123142a.removeView(layoutUsageLimitEndBinding.getRoot());
                this.f123143b = null;
            }
        } catch (Exception unused) {
        }
        stopSelf();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f123142a = (WindowManager) getSystemService("window");
        try {
            e();
        } catch (WindowManager.BadTokenException unused) {
            stopSelf();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        if (intent != null && intent.getExtras() != null) {
            this.f123144c = intent.getStringExtra("PACKAGE_NAME");
            this.f123145d = intent.getStringExtra("URL");
            this.f123146f = intent.getLongExtra("REMAINING_TIME", 0L);
        }
        if (this.f123144c == null) {
            f();
        }
        k();
        return 2;
    }
}
