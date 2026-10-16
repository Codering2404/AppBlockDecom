package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class az implements StandardIntegrityManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final bn f82999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final bt f83000b;

    az(bn bnVar, bt btVar) {
        this.f82999a = bnVar;
        this.f83000b = btVar;
    }

    final /* synthetic */ Task a(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest, Long l3) throws Exception {
        final long jB = prepareIntegrityTokenRequest.b();
        final long jLongValue = l3.longValue();
        prepareIntegrityTokenRequest.a();
        final bt btVar = this.f83000b;
        final int i3 = 0;
        return Tasks.forResult(new StandardIntegrityManager.StandardIntegrityTokenProvider(jB, jLongValue, i3) { // from class: com.google.android.play.core.integrity.bs

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f83045b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f83046c;

            @Override // com.google.android.play.core.integrity.StandardIntegrityManager.StandardIntegrityTokenProvider
            public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
                return this.f83044a.a(this.f83045b, this.f83046c, 0, standardIntegrityTokenRequest);
            }
        });
    }

    @Override // com.google.android.play.core.integrity.StandardIntegrityManager
    public final Task<StandardIntegrityManager.StandardIntegrityTokenProvider> prepareIntegrityToken(final StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        long jB = prepareIntegrityTokenRequest.b();
        prepareIntegrityTokenRequest.a();
        return this.f82999a.e(jB, 0).onSuccessTask(new SuccessContinuation() { // from class: com.google.android.play.core.integrity.ay
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f82997a.a(prepareIntegrityTokenRequest, (Long) obj);
            }
        });
    }
}
