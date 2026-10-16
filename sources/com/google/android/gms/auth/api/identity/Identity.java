package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p000authapi.zbag;
import com.google.android.gms.internal.p000authapi.zbaq;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Identity {
    public static CredentialSavingClient a(Activity activity) {
        return new zbag((Activity) Preconditions.m(activity), new zbi());
    }

    public static SignInClient b(Activity activity) {
        return new zbaq((Activity) Preconditions.m(activity), new zbv());
    }

    public static SignInClient c(Context context) {
        return new zbaq((Context) Preconditions.m(context), new zbv());
    }
}
