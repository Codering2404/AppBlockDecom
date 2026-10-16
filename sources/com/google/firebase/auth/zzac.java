package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzac extends zzbo<AuthResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f88019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f88020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ EmailAuthCredential f88021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88022d;

    zzac(FirebaseAuth firebaseAuth, boolean z2, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.f88019a = z2;
        this.f88020b = firebaseUser;
        this.f88021c = emailAuthCredential;
        Objects.requireNonNull(firebaseAuth);
        this.f88022d = firebaseAuth;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
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
            Log.i("FirebaseAuth", "Email link login/reauth with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login/reauth with email link");
        }
        if (this.f88019a) {
            FirebaseAuth firebaseAuth = this.f88022d;
            return firebaseAuth.f87745e.zzb(firebaseAuth.f87741a, (FirebaseUser) Preconditions.m(this.f88020b), this.f88021c, str, (zzcf) new FirebaseAuth.zzb(this.f88022d));
        }
        FirebaseAuth firebaseAuth2 = this.f88022d;
        return firebaseAuth2.f87745e.zza(firebaseAuth2.f87741a, this.f88021c, str, (com.google.firebase.auth.internal.zzl) new FirebaseAuth.zza(this.f88022d));
    }
}
