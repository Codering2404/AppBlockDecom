package com.google.android.play.core.review;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.internal.zzt;
import com.google.android.play.core.review.internal.zzw;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.android.play.core.review.internal.zzi f83153c = new com.google.android.play.core.review.internal.zzi("ReviewService");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    zzt f83154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f83155b;

    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.android.play.core.review.zze] */
    public zzi(Context context) {
        this.f83155b = context.getPackageName();
        if (zzw.a(context)) {
            this.f83154a = new zzt(context, f83153c, "com.google.android.finsky.inappreviewservice.InAppReviewService", new Intent("com.google.android.finsky.BIND_IN_APP_REVIEW_SERVICE").setPackage("com.android.vending"), new Object() { // from class: com.google.android.play.core.review.zze
            }, null);
        }
    }

    public final Task a() {
        String str = this.f83155b;
        com.google.android.play.core.review.internal.zzi zziVar = f83153c;
        zziVar.c("requestInAppReview (%s)", str);
        if (this.f83154a == null) {
            zziVar.a("Play Store app is either not installed or not the official version", new Object[0]);
            return Tasks.forException(new ReviewException(-1));
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f83154a.s(new zzf(this, taskCompletionSource, taskCompletionSource), taskCompletionSource);
        return taskCompletionSource.getTask();
    }
}
