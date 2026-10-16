package com.google.android.play.core.integrity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final com.google.android.play.integrity.internal.ae f82968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.android.play.integrity.internal.s f82969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f82970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final at f82971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f82972e;

    aj(Context context, com.google.android.play.integrity.internal.s sVar, at atVar, k kVar) {
        this.f82970c = context.getPackageName();
        this.f82969b = sVar;
        this.f82971d = atVar;
        this.f82972e = kVar;
        if (com.google.android.play.integrity.internal.ai.b(context)) {
            this.f82968a = new com.google.android.play.integrity.internal.ae(context, sVar, "IntegrityService", ak.f82973a, new com.google.android.play.integrity.internal.z() { // from class: com.google.android.play.core.integrity.ae
                @Override // com.google.android.play.integrity.internal.z
                public final Object a(IBinder iBinder) {
                    return com.google.android.play.integrity.internal.m.x3(iBinder);
                }
            }, null);
        } else {
            sVar.b("Phonesky is not installed.", new Object[0]);
            this.f82968a = null;
        }
    }

    static /* bridge */ /* synthetic */ Bundle a(aj ajVar, byte[] bArr, Long l3, Parcelable parcelable) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", ajVar.f82970c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 3);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l3 != null) {
            bundle.putLong("cloud.prj", l3.longValue());
        }
        ArrayList arrayList = new ArrayList();
        com.google.android.play.integrity.internal.d.b(3, arrayList);
        bundle.putParcelableArrayList("event_timestamps", new ArrayList<>(com.google.android.play.integrity.internal.d.a(arrayList)));
        return bundle;
    }

    final Task b(Activity activity, Bundle bundle) {
        if (this.f82968a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        int i3 = bundle.getInt("dialog.intent.type");
        this.f82969b.d("requestAndShowDialog(%s, %s)", this.f82970c, Integer.valueOf(i3));
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f82968a.t(new ag(this, taskCompletionSource, bundle, activity, taskCompletionSource, i3), taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public final Task c(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f82968a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, null));
        }
        try {
            byte[] bArrDecode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long lCloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            if (integrityTokenRequest instanceof ao) {
            }
            this.f82969b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f82968a.t(new af(this, taskCompletionSource, bArrDecode, lCloudProjectNumber, null, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e3) {
            return Tasks.forException(new IntegrityServiceException(-13, e3));
        }
    }
}
