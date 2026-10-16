package com.google.android.play.core.review.testing;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.review.ReviewException;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FakeReviewManager implements ReviewManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f83140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ReviewInfo f83141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f83142c = 0;

    public FakeReviewManager(Context context) {
        this.f83140a = context;
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public Task a() {
        ReviewInfo reviewInfoE = ReviewInfo.e(PendingIntent.getBroadcast(this.f83140a, 0, new Intent(), 67108864), false);
        this.f83141b = reviewInfoE;
        return Tasks.forResult(reviewInfoE);
    }

    @Override // com.google.android.play.core.review.ReviewManager
    public Task b(Activity activity, ReviewInfo reviewInfo) {
        if (reviewInfo != this.f83141b) {
            return Tasks.forException(new ReviewException(-2));
        }
        this.f83142c++;
        return Tasks.forResult(null);
    }
}
