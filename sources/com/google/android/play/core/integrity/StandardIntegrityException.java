package com.google.android.play.core.integrity;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class StandardIntegrityException extends ApiException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f82947a;

    StandardIntegrityException(int i3, Throwable th) {
        super(new Status(i3, String.format(Locale.ROOT, "Standard Integrity API error (%d): %s.", Integer.valueOf(i3), com.google.android.play.core.integrity.model.b.a(i3))));
        if (i3 == 0) {
            throw new IllegalArgumentException("ErrorCode should not be 0.");
        }
        this.f82947a = th;
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        return this.f82947a;
    }

    public int getErrorCode() {
        return super.getStatusCode();
    }
}
