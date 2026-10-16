package com.google.firebase.auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class FirebaseUser extends AbstractSafeParcelable implements UserInfo {
    public abstract FirebaseApp J2();

    public abstract FirebaseUser K2(List list);

    public abstract void L2(zzahv zzahvVar);

    public abstract FirebaseUserMetadata M();

    public abstract FirebaseUser M2();

    public abstract MultiFactor N();

    public abstract void N2(List list);

    public abstract List O();

    public abstract zzahv O2();

    public abstract void P2(List list);

    public abstract List Q2();

    public abstract String g0();

    public Task h1(AuthCredential authCredential) {
        Preconditions.m(authCredential);
        return FirebaseAuth.getInstance(J2()).K(this, authCredential);
    }

    public abstract String j0();

    public abstract boolean w0();

    public Task z0(AuthCredential authCredential) {
        Preconditions.m(authCredential);
        return FirebaseAuth.getInstance(J2()).p(this, authCredential);
    }

    public abstract String zzd();

    public abstract String zze();

    public abstract List zzg();
}
