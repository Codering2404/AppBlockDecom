package com.google.android.gms.auth.api.identity;

import android.content.Intent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface SignInClient extends HasApiKey<zbv> {
    Task beginSignIn(BeginSignInRequest beginSignInRequest);

    SignInCredential getSignInCredentialFromIntent(Intent intent);

    Task getSignInIntent(GetSignInIntentRequest getSignInIntentRequest);

    Task signOut();
}
