package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzajb;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FacebookAuthCredential;
import com.google.firebase.auth.GithubAuthCredential;
import com.google.firebase.auth.GoogleAuthCredential;
import com.google.firebase.auth.PlayGamesAuthCredential;
import com.google.firebase.auth.TwitterAuthCredential;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzk {
    public static zzajb a(AuthCredential authCredential, String str) {
        Preconditions.m(authCredential);
        if (authCredential instanceof GoogleAuthCredential) {
            return GoogleAuthCredential.g0((GoogleAuthCredential) authCredential, str);
        }
        if (authCredential instanceof FacebookAuthCredential) {
            return FacebookAuthCredential.g0((FacebookAuthCredential) authCredential, str);
        }
        if (authCredential instanceof TwitterAuthCredential) {
            return TwitterAuthCredential.g0((TwitterAuthCredential) authCredential, str);
        }
        if (authCredential instanceof GithubAuthCredential) {
            return GithubAuthCredential.g0((GithubAuthCredential) authCredential, str);
        }
        if (authCredential instanceof PlayGamesAuthCredential) {
            return PlayGamesAuthCredential.g0((PlayGamesAuthCredential) authCredential, str);
        }
        if (authCredential instanceof com.google.firebase.auth.zze) {
            return com.google.firebase.auth.zze.z0((com.google.firebase.auth.zze) authCredential, str);
        }
        throw new IllegalArgumentException("Unsupported credential type.");
    }
}
