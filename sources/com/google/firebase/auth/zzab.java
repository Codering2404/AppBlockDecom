package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.internal.zzbo;
import com.google.firebase.auth.internal.zzcf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzab extends zzbo<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ boolean f88015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ FirebaseUser f88016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ EmailAuthCredential f88017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final /* synthetic */ FirebaseAuth f88018d;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
    /* JADX WARN: Type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
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
        if (this.f88015a) {
            if (TextUtils.isEmpty(str)) {
                Log.i("FirebaseAuth", " Email link reauth with empty reCAPTCHA token");
            } else {
                Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with email link");
            }
            FirebaseAuth firebaseAuth = this.f88018d;
            return firebaseAuth.f87745e.zza(firebaseAuth.f87741a, this.f88016b, this.f88017c, str, (zzcf) new FirebaseAuth.zzb(this.f88018d));
        }
        String strZzc = this.f88017c.zzc();
        String strZzd = this.f88017c.zzd();
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Reauthenticating " + strZzc + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for reauth with " + strZzc);
        }
        FirebaseAuth firebaseAuth2 = this.f88018d;
        return firebaseAuth2.f87745e.zza(firebaseAuth2.f87741a, this.f88016b, strZzc, Preconditions.g(strZzd), this.f88016b.g0(), str, new FirebaseAuth.zzb(this.f88018d));
    }
}
