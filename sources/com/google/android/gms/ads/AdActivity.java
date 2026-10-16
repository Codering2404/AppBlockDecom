package com.google.android.gms.ads;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbzb;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AdActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbzb f69626a;

    private final void a() {
        zzbzb zzbzbVar = this.f69626a;
        if (zzbzbVar != null) {
            try {
                zzbzbVar.zzs();
            } catch (RemoteException e3) {
                zzo.i("#007 Could not call remote method.", e3);
            }
        }
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i3, int i4, Intent intent) {
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzm(i3, i4, intent);
            }
        } catch (Exception e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
        super.onActivityResult(i3, i4, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                if (!zzbzbVar.zzg()) {
                    return;
                }
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
        super.onBackPressed();
        try {
            zzbzb zzbzbVar2 = this.f69626a;
            if (zzbzbVar2 != null) {
                zzbzbVar2.zze();
            }
        } catch (RemoteException e4) {
            zzo.i("#007 Could not call remote method.", e4);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzn(ObjectWrapper.i5(configuration));
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // android.app.Activity
    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zzo.a("AdActivity onCreate");
        zzbzb zzbzbVarG = zzay.b().g(this);
        this.f69626a = zzbzbVarG;
        if (zzbzbVarG == null) {
            zzo.i("#007 Could not call remote method.", null);
            finish();
            return;
        }
        try {
            zzbzbVarG.zzh(bundle);
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onDestroy() {
        zzo.a("AdActivity onDestroy");
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzq();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected final void onPause() {
        zzo.a("AdActivity onPause");
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzl();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i3, String[] strArr, int[] iArr) {
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzH(i3, strArr, iArr);
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // android.app.Activity
    protected final void onRestart() {
        super.onRestart();
        zzo.a("AdActivity onRestart");
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzi();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onResume() {
        zzo.a("AdActivity onResume");
        super.onResume();
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzk();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(Bundle bundle) {
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzo(bundle);
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected final void onStart() {
        super.onStart();
        zzo.a("AdActivity onStart");
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzj();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onStop() {
        zzo.a("AdActivity onStop");
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzp();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
            finish();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    protected final void onUserLeaveHint() {
        super.onUserLeaveHint();
        try {
            zzbzb zzbzbVar = this.f69626a;
            if (zzbzbVar != null) {
                zzbzbVar.zzf();
            }
        } catch (RemoteException e3) {
            zzo.i("#007 Could not call remote method.", e3);
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i3) {
        super.setContentView(i3);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view) {
        super.setContentView(view);
        a();
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(view, layoutParams);
        a();
    }
}
