package com.google.firebase.auth;

import android.app.Activity;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PhoneAuthOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseAuth f87784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Long f87785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks f87786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Executor f87787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f87788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Activity f87789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private PhoneAuthProvider.ForceResendingToken f87790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MultiFactorSession f87791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PhoneMultiFactorInfo f87792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f87793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f87794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f87795l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
    }

    public final Activity a() {
        return this.f87789f;
    }

    public final void b(boolean z2) {
        this.f87794k = true;
    }

    public final FirebaseAuth c() {
        return this.f87784a;
    }

    public final void d(boolean z2) {
        this.f87795l = true;
    }

    public final MultiFactorSession e() {
        return this.f87791h;
    }

    public final PhoneAuthProvider.ForceResendingToken f() {
        return this.f87790g;
    }

    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks g() {
        return this.f87786c;
    }

    public final PhoneMultiFactorInfo h() {
        return this.f87792i;
    }

    public final Long i() {
        return this.f87785b;
    }

    public final String j() {
        return this.f87788e;
    }

    public final Executor k() {
        return this.f87787d;
    }

    public final boolean l() {
        return this.f87794k;
    }

    public final boolean m() {
        return this.f87793j;
    }

    public final boolean n() {
        return this.f87795l;
    }

    public final boolean o() {
        return this.f87791h != null;
    }
}
