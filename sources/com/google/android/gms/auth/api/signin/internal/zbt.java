package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.UidVerifier;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zbt extends zbo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f71262a;

    public zbt(Context context) {
        this.f71262a = context;
    }

    private final void x3() {
        if (UidVerifier.a(this.f71262a, Binder.getCallingUid())) {
            return;
        }
        throw new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbp
    public final void N() {
        x3();
        zbn.a(this.f71262a).b();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zbp
    public final void k0() {
        x3();
        Storage storageB = Storage.b(this.f71262a);
        GoogleSignInAccount googleSignInAccountC = storageB.c();
        GoogleSignInOptions googleSignInOptionsD = GoogleSignInOptions.f71197m;
        if (googleSignInAccountC != null) {
            googleSignInOptionsD = storageB.d();
        }
        GoogleSignInClient googleSignInClientA = GoogleSignIn.a(this.f71262a, googleSignInOptionsD);
        if (googleSignInAccountC != null) {
            googleSignInClientA.h();
        } else {
            googleSignInClientA.signOut();
        }
    }
}
