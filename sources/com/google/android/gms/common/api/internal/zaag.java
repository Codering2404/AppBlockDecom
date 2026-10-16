package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class zaag extends GoogleApiClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f71648b = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";

    public zaag(String str) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void d() {
        throw new UnsupportedOperationException(this.f71648b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void e() {
        throw new UnsupportedOperationException(this.f71648b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.f71648b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean l() {
        throw new UnsupportedOperationException(this.f71648b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void o(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f71648b);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void p(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.f71648b);
    }
}
