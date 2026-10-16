package com.google.android.gms.common.api.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class NonGmsServiceBrokerClient implements Api.Client, ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f71588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComponentName f71590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f71591d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConnectionCallbacks f71592f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f71593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final OnConnectionFailedListener f71594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private IBinder f71595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f71596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f71597k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f71598l;

    private final void g() {
        if (Thread.currentThread() != this.f71593g.getLooper().getThread()) {
            throw new IllegalStateException("This method should only run on the NonGmsServiceBrokerClient's handler thread.");
        }
    }

    final /* synthetic */ void b() {
        this.f71596j = false;
        this.f71595i = null;
        this.f71592f.onConnectionSuspended(1);
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void connect(BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        g();
        String.valueOf(this.f71595i);
        if (isConnected()) {
            try {
                disconnect("connect() called when already connected");
            } catch (Exception unused) {
            }
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = this.f71590c;
            if (componentName != null) {
                intent.setComponent(componentName);
            } else {
                intent.setPackage(this.f71588a).setAction(this.f71589b);
            }
            boolean zBindService = this.f71591d.bindService(intent, this, GmsClientSupervisor.a());
            this.f71596j = zBindService;
            if (!zBindService) {
                this.f71595i = null;
                this.f71594h.onConnectionFailed(new ConnectionResult(16));
            }
            String.valueOf(this.f71595i);
        } catch (SecurityException e3) {
            this.f71596j = false;
            this.f71595i = null;
            throw e3;
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect() {
        g();
        String.valueOf(this.f71595i);
        try {
            this.f71591d.unbindService(this);
        } catch (IllegalArgumentException unused) {
        }
        this.f71596j = false;
        this.f71595i = null;
    }

    final /* synthetic */ void e(IBinder iBinder) {
        this.f71596j = false;
        this.f71595i = iBinder;
        String.valueOf(iBinder);
        this.f71592f.onConnected(new Bundle());
    }

    public final void f(String str) {
        this.f71598l = str;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Feature[] getAvailableFeatures() {
        return new Feature[0];
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final String getEndpointPackageName() {
        String str = this.f71588a;
        if (str != null) {
            return str;
        }
        Preconditions.m(this.f71590c);
        return this.f71590c.getPackageName();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final String getLastDisconnectMessage() {
        return this.f71597k;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return 0;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Set getScopesForConnectionlessNonSignIn() {
        return Collections.EMPTY_SET;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final Intent getSignInIntent() {
        return new Intent();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnected() {
        g();
        return this.f71595i != null;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean isConnecting() {
        g();
        return this.f71596j;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        this.f71593g.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacg
            @Override // java.lang.Runnable
            public final void run() {
                this.f71790a.e(iBinder);
            }
        });
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f71593g.post(new Runnable() { // from class: com.google.android.gms.common.api.internal.zacf
            @Override // java.lang.Runnable
            public final void run() {
                this.f71789a.b();
            }
        });
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean providesSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresGooglePlayServices() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final boolean requiresSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void disconnect(String str) {
        g();
        this.f71597k = str;
        disconnect();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void onUserSignOut(BaseGmsClient.SignOutCallbacks signOutCallbacks) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void getRemoteService(IAccountAccessor iAccountAccessor, Set set) {
    }

    @Override // com.google.android.gms.common.api.Api.Client
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }
}
