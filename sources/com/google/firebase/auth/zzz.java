package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzz extends zzbo<AuthResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f88083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f88084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f88085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ String f88086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final /* synthetic */ String f88087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88088f;

    zzz(FirebaseAuth firebaseAuth, String str, boolean z2, FirebaseUser firebaseUser, String str2, String str3) {
        this.f88083a = str;
        this.f88084b = z2;
        this.f88085c = firebaseUser;
        this.f88086d = str2;
        this.f88087e = str3;
        Objects.requireNonNull(firebaseAuth);
        this.f88088f = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.firebase.auth.internal.zzbo
    public final Task d(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Logging in as " + this.f88083a + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login with email " + this.f88083a);
        }
        if (this.f88084b) {
            FirebaseAuth firebaseAuth = this.f88088f;
            return firebaseAuth.f87745e.zzb(firebaseAuth.f87741a, (FirebaseUser) Preconditions.m(this.f88085c), this.f88083a, this.f88086d, this.f88087e, str, new FirebaseAuth.zzb(this.f88088f));
        }
        FirebaseAuth firebaseAuth2 = this.f88088f;
        return firebaseAuth2.f87745e.zzb(firebaseAuth2.f87741a, this.f88083a, this.f88086d, this.f88087e, str, new FirebaseAuth.zza(this.f88088f));
    }
}
