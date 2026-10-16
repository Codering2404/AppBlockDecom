package com.google.android.play.core.review;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ReviewException extends ApiException {
    public ReviewException(int i3) {
        super(new Status(i3, String.format(Locale.getDefault(), "Review Error(%d): %s", Integer.valueOf(i3), com.google.android.play.core.review.model.zza.a(i3))));
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
