package com.google.android.play.core.review;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.common.PlayCoreDialogWrapperActivity;
import com.revenuecat.purchases.amazon.purchasing.ProxyAmazonBillingActivity;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzd implements ReviewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzi f83146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f83147b = new Handler(Looper.getMainLooper());

    zzd(zzi zziVar) {
        this.f83146a = zziVar;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final Task a() {
        return this.f83146a.a();
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public final Task b(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo.d()) {
            return Tasks.forResult(null);
        }
        Intent intent = new Intent(activity, (Class<?>) PlayCoreDialogWrapperActivity.class);
        intent.putExtra("confirmation_intent", reviewInfo.c());
        intent.putExtra("window_flags", activity.getWindow().getDecorView().getWindowSystemUiVisibility());
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        intent.putExtra(ProxyAmazonBillingActivity.EXTRAS_RESULT_RECEIVER, new zzc(this, this.f83147b, taskCompletionSource));
        activity.startActivity(intent);
        return taskCompletionSource.getTask();
    }
}
