package com.google.firebase.auth.internal;

import android.util.Base64;
import android.util.Log;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p002firebaseauthapi.zzahr;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.IntegrityManager;
import com.google.android.play.core.integrity.IntegrityTokenRequest;
import com.google.android.play.core.integrity.IntegrityTokenResponse;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zze implements Continuation<zzahr, Task<IntegrityTokenResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f87981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IntegrityManager f87982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzb f87983c;

    public zze(zzb zzbVar, String str, IntegrityManager integrityManager) {
        this.f87981a = str;
        this.f87982b = integrityManager;
        Objects.requireNonNull(zzbVar);
        this.f87983c = zzbVar;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<IntegrityTokenResponse> then(Task<zzahr> task) {
        if (task.isSuccessful()) {
            this.f87983c.f87897a = task.getResult().zza();
            return this.f87982b.requestIntegrityToken(IntegrityTokenRequest.builder().setCloudProjectNumber(Long.parseLong(task.getResult().zza())).setNonce(new String(Base64.encode(MessageDigest.getInstance("SHA-256").digest(this.f87981a.getBytes(Utf8Charset.NAME)), 11))).build());
        }
        Log.e(zzb.f87895b, "Problem retrieving Play Integrity producer project:  " + task.getException().getMessage());
        return Tasks.forException(task.getException());
    }
}
