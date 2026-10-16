package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzacq;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzaeu;
import com.google.android.gms.internal.p002firebaseauthapi.zzagb;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzbi;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzca;
import com.google.firebase.auth.internal.zzcb;
import com.google.firebase.auth.internal.zzcf;
import com.google.firebase.auth.internal.zzcg;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseAuth implements InternalAuthProvider {
    protected final Executor A;
    private String B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f87741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final List f87742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final List f87743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final List f87744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final zzacq f87745e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private FirebaseUser f87746f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.firebase.auth.internal.zzac f87747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f87748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f87749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Object f87750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f87751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private zzbx f87752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final RecaptchaAction f87753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final RecaptchaAction f87754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final RecaptchaAction f87755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final RecaptchaAction f87756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final RecaptchaAction f87757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final RecaptchaAction f87758r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final zzcb f87759s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final zzcg f87760t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final com.google.firebase.auth.internal.zzb f87761u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Provider f87762v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Provider f87763w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private zzca f87764x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Executor f87765y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Executor f87766z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AuthStateListener {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface IdTokenListener {
        void a(FirebaseAuth firebaseAuth);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class zza implements com.google.firebase.auth.internal.zzl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ FirebaseAuth f87767a;

        zza(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.f87767a = firebaseAuth;
        }

        @Override // com.google.firebase.auth.internal.zzl
        public final void a(zzahv zzahvVar, FirebaseUser firebaseUser) {
            Preconditions.m(zzahvVar);
            Preconditions.m(firebaseUser);
            firebaseUser.L2(zzahvVar);
            this.f87767a.B(firebaseUser, zzahvVar, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class zzb implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ FirebaseAuth f87768a;

        zzb(FirebaseAuth firebaseAuth) {
            Objects.requireNonNull(firebaseAuth);
            this.f87768a = firebaseAuth;
        }

        @Override // com.google.firebase.auth.internal.zzl
        public final void a(zzahv zzahvVar, FirebaseUser firebaseUser) {
            Preconditions.m(zzahvVar);
            Preconditions.m(firebaseUser);
            firebaseUser.L2(zzahvVar);
            this.f87768a.C(firebaseUser, zzahvVar, true, true);
        }

        @Override // com.google.firebase.auth.internal.zzau
        public final void zza(Status status) {
            if (status.O() == 17011 || status.O() == 17021 || status.O() == 17005 || status.O() == 17091) {
                this.f87768a.l();
            }
        }
    }

    public FirebaseAuth(FirebaseApp firebaseApp, Provider provider, Provider provider2, Executor executor, Executor executor2, Executor executor3, ScheduledExecutorService scheduledExecutorService, Executor executor4) {
        this(firebaseApp, new zzacq(firebaseApp, executor2, scheduledExecutorService), new zzcb(firebaseApp.l(), firebaseApp.q()), zzcg.d(), com.google.firebase.auth.internal.zzb.b(), provider, provider2, executor, executor2, executor3, executor4);
    }

    private static void A(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser, zzahv zzahvVar, boolean z2, boolean z3) {
        boolean z4;
        Preconditions.m(firebaseUser);
        Preconditions.m(zzahvVar);
        boolean z5 = true;
        boolean z6 = firebaseAuth.f87746f != null && firebaseUser.j0().equals(firebaseAuth.f87746f.j0());
        if (z6 || !z3) {
            FirebaseUser firebaseUser2 = firebaseAuth.f87746f;
            if (firebaseUser2 == null) {
                z4 = true;
            } else {
                boolean z7 = (z6 && firebaseUser2.O2().zzc().equals(zzahvVar.zzc())) ? false : true;
                z4 = z6 ? false : true;
                z5 = z7;
            }
            Preconditions.m(firebaseUser);
            if (firebaseAuth.f87746f == null || !firebaseUser.j0().equals(firebaseAuth.h())) {
                firebaseAuth.f87746f = firebaseUser;
            } else {
                firebaseAuth.f87746f.K2(firebaseUser.O());
                if (!firebaseUser.w0()) {
                    firebaseAuth.f87746f.M2();
                }
                List listA = firebaseUser.N().a();
                List listQ2 = firebaseUser.Q2();
                firebaseAuth.f87746f.P2(listA);
                firebaseAuth.f87746f.N2(listQ2);
            }
            if (z2) {
                firebaseAuth.f87759s.j(firebaseAuth.f87746f);
            }
            if (z5) {
                FirebaseUser firebaseUser3 = firebaseAuth.f87746f;
                if (firebaseUser3 != null) {
                    firebaseUser3.L2(zzahvVar);
                }
                I(firebaseAuth, firebaseAuth.f87746f);
            }
            if (z4) {
                z(firebaseAuth, firebaseAuth.f87746f);
            }
            if (z2) {
                firebaseAuth.f87759s.e(firebaseUser, zzahvVar);
            }
            FirebaseUser firebaseUser4 = firebaseAuth.f87746f;
            if (firebaseUser4 != null) {
                R(firebaseAuth).c(firebaseUser4.O2());
            }
        }
    }

    public static void D(PhoneAuthOptions phoneAuthOptions) {
        String strG;
        String strW0;
        if (!phoneAuthOptions.o()) {
            FirebaseAuth firebaseAuthC = phoneAuthOptions.c();
            String strG2 = Preconditions.g(phoneAuthOptions.j());
            if (phoneAuthOptions.f() == null && zzagb.zza(strG2, phoneAuthOptions.g(), phoneAuthOptions.a(), phoneAuthOptions.k())) {
                return;
            }
            firebaseAuthC.f87761u.a(firebaseAuthC, strG2, phoneAuthOptions.a(), firebaseAuthC.U(), phoneAuthOptions.l(), phoneAuthOptions.n(), firebaseAuthC.f87756p).addOnCompleteListener(new zzk(firebaseAuthC, phoneAuthOptions, strG2));
            return;
        }
        FirebaseAuth firebaseAuthC2 = phoneAuthOptions.c();
        com.google.firebase.auth.internal.zzam zzamVar = (com.google.firebase.auth.internal.zzam) Preconditions.m(phoneAuthOptions.e());
        if (zzamVar.zzd()) {
            strW0 = Preconditions.g(phoneAuthOptions.j());
            strG = strW0;
        } else {
            PhoneMultiFactorInfo phoneMultiFactorInfo = (PhoneMultiFactorInfo) Preconditions.m(phoneAuthOptions.h());
            strG = Preconditions.g(phoneMultiFactorInfo.g0());
            strW0 = phoneMultiFactorInfo.w0();
        }
        if (phoneAuthOptions.f() == null || !zzagb.zza(strG, phoneAuthOptions.g(), phoneAuthOptions.a(), phoneAuthOptions.k())) {
            firebaseAuthC2.f87761u.a(firebaseAuthC2, strW0, phoneAuthOptions.a(), firebaseAuthC2.U(), phoneAuthOptions.l(), phoneAuthOptions.n(), zzamVar.zzd() ? firebaseAuthC2.f87757q : firebaseAuthC2.f87758r).addOnCompleteListener(new zzj(firebaseAuthC2, phoneAuthOptions, strG));
        }
    }

    private static void I(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying id token listeners about user ( " + firebaseUser.j0() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        firebaseAuth.A.execute(new zzv(firebaseAuth, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzd() : null)));
    }

    private final boolean J(String str) {
        ActionCodeUrl actionCodeUrlB = ActionCodeUrl.b(str);
        return (actionCodeUrlB == null || TextUtils.equals(this.f87751k, actionCodeUrlB.c())) ? false : true;
    }

    private static zzca R(FirebaseAuth firebaseAuth) {
        if (firebaseAuth.f87764x == null) {
            firebaseAuth.f87764x = new zzca((FirebaseApp) Preconditions.m(firebaseAuth.f87741a));
        }
        return firebaseAuth.f87764x;
    }

    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.m().j(FirebaseAuth.class);
    }

    private final Task o(EmailAuthCredential emailAuthCredential, FirebaseUser firebaseUser, boolean z2) {
        return new zzac(this, z2, firebaseUser, emailAuthCredential).b(this, this.f87751k, this.f87753m, "EMAIL_PASSWORD_PROVIDER");
    }

    private final Task t(String str, String str2, String str3, FirebaseUser firebaseUser, boolean z2) {
        return new zzz(this, str, z2, firebaseUser, str2, str3).b(this, str3, this.f87754n, "EMAIL_PASSWORD_PROVIDER");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhoneAuthProvider.OnVerificationStateChangedCallbacks x(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        return (this.f87747g.d() && str != null && str.equals(this.f87747g.a())) ? new zzm(this, onVerificationStateChangedCallbacks) : onVerificationStateChangedCallbacks;
    }

    public static void y(final FirebaseException firebaseException, PhoneAuthOptions phoneAuthOptions, String str) {
        Log.e("FirebaseAuth", "Invoking verification failure callback for phone number/uid - " + str);
        final PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksZza = zzagb.zza(str, phoneAuthOptions.g(), null);
        phoneAuthOptions.k().execute(new Runnable() { // from class: com.google.firebase.auth.zzi
            @Override // java.lang.Runnable
            public final void run() {
                onVerificationStateChangedCallbacksZza.onVerificationFailed(firebaseException);
            }
        });
    }

    private static void z(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            Log.d("FirebaseAuth", "Notifying auth state listeners about user ( " + firebaseUser.j0() + " ).");
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        firebaseAuth.A.execute(new zzy(firebaseAuth));
    }

    public final void B(FirebaseUser firebaseUser, zzahv zzahvVar, boolean z2) {
        C(firebaseUser, zzahvVar, true, false);
    }

    final void C(FirebaseUser firebaseUser, zzahv zzahvVar, boolean z2, boolean z3) {
        A(this, firebaseUser, zzahvVar, true, z3);
    }

    public final void E(PhoneAuthOptions phoneAuthOptions, com.google.firebase.auth.internal.zzj zzjVar) {
        PhoneAuthOptions phoneAuthOptions2;
        long jLongValue = phoneAuthOptions.i().longValue();
        if (jLongValue < 0 || jLongValue > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        String strG = Preconditions.g(phoneAuthOptions.j());
        String strC = zzjVar.c();
        String strB = zzjVar.b();
        String strD = zzjVar.d();
        if (com.google.android.gms.internal.p002firebaseauthapi.zzac.zzc(strC) && H() != null && H().d("PHONE_PROVIDER")) {
            strC = "NO_RECAPTCHA";
        }
        String str = strC;
        zzaij zzaijVar = new zzaij(strG, jLongValue, phoneAuthOptions.f() != null, this.f87749i, this.f87751k, strD, strB, str, U());
        PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacksX = x(strG, phoneAuthOptions.g());
        if (TextUtils.isEmpty(zzjVar.d())) {
            phoneAuthOptions2 = phoneAuthOptions;
            onVerificationStateChangedCallbacksX = w(phoneAuthOptions2, onVerificationStateChangedCallbacksX, com.google.firebase.auth.internal.zzj.a().d(strD).c(str).a(strB).b());
        } else {
            phoneAuthOptions2 = phoneAuthOptions;
        }
        this.f87745e.zza(this.f87741a, zzaijVar, onVerificationStateChangedCallbacksX, phoneAuthOptions2.a(), phoneAuthOptions2.k());
    }

    public final synchronized void F(zzbx zzbxVar) {
        this.f87752l = zzbxVar;
    }

    public final synchronized zzbx H() {
        return this.f87752l;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
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
    public final Task K(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.m(firebaseUser);
        Preconditions.m(authCredential);
        AuthCredential authCredentialO = authCredential.O();
        if (!(authCredentialO instanceof EmailAuthCredential)) {
            return authCredentialO instanceof PhoneAuthCredential ? this.f87745e.zzb(this.f87741a, firebaseUser, (PhoneAuthCredential) authCredentialO, this.f87751k, (zzcf) new zzb(this)) : this.f87745e.zzc(this.f87741a, firebaseUser, authCredentialO, firebaseUser.g0(), new zzb(this));
        }
        EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialO;
        return "password".equals(emailAuthCredential.N()) ? t(emailAuthCredential.zzc(), Preconditions.g(emailAuthCredential.zzd()), firebaseUser.g0(), firebaseUser, true) : J(Preconditions.g(emailAuthCredential.zze())) ? Tasks.forException(zzaen.zza(new Status(17072))) : o(emailAuthCredential, firebaseUser, true);
    }

    public final Provider M() {
        return this.f87762v;
    }

    public final Provider N() {
        return this.f87763w;
    }

    public final Executor Q() {
        return this.f87765y;
    }

    public final Executor S() {
        return this.f87766z;
    }

    public final void T() {
        Preconditions.m(this.f87759s);
        FirebaseUser firebaseUser = this.f87746f;
        if (firebaseUser != null) {
            this.f87759s.h(firebaseUser);
            this.f87746f = null;
        }
        this.f87759s.g();
        I(this, null);
        z(this, null);
    }

    final boolean U() {
        return zzaeu.zza(b().l());
    }

    public Task a(boolean z2) {
        return q(this.f87746f, z2);
    }

    public FirebaseApp b() {
        return this.f87741a;
    }

    public FirebaseUser c() {
        return this.f87746f;
    }

    public String d() {
        return this.B;
    }

    public FirebaseAuthSettings e() {
        return this.f87747g;
    }

    public String f() {
        String str;
        synchronized (this.f87748h) {
            str = this.f87749i;
        }
        return str;
    }

    public String g() {
        String str;
        synchronized (this.f87750j) {
            str = this.f87751k;
        }
        return str;
    }

    public String h() {
        FirebaseUser firebaseUser = this.f87746f;
        if (firebaseUser == null) {
            return null;
        }
        return firebaseUser.j0();
    }

    public Task i() {
        if (this.f87752l == null) {
            this.f87752l = new zzbx(this.f87741a, this);
        }
        return this.f87752l.a(this.f87751k, Boolean.FALSE).continueWithTask(new zzaa(this));
    }

    public void j(String str) {
        Preconditions.g(str);
        synchronized (this.f87750j) {
            this.f87751k = str;
        }
    }

    public Task k(AuthCredential authCredential) {
        Preconditions.m(authCredential);
        AuthCredential authCredentialO = authCredential.O();
        if (authCredentialO instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredentialO;
            return !emailAuthCredential.zzf() ? t(emailAuthCredential.zzc(), (String) Preconditions.m(emailAuthCredential.zzd()), this.f87751k, null, false) : J(Preconditions.g(emailAuthCredential.zze())) ? Tasks.forException(zzaen.zza(new Status(17072))) : o(emailAuthCredential, null, false);
        }
        if (authCredentialO instanceof PhoneAuthCredential) {
            return this.f87745e.zza(this.f87741a, (PhoneAuthCredential) authCredentialO, this.f87751k, (com.google.firebase.auth.internal.zzl) new zza(this));
        }
        return this.f87745e.zza(this.f87741a, authCredentialO, this.f87751k, new zza(this));
    }

    public void l() {
        T();
        zzca zzcaVar = this.f87764x;
        if (zzcaVar != null) {
            zzcaVar.b();
        }
    }

    public final Task m() {
        return this.f87745e.zza();
    }

    public final Task n(ActionCodeSettings actionCodeSettings, String str) {
        Preconditions.g(str);
        if (this.f87749i != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.K2();
            }
            actionCodeSettings.J2(this.f87749i);
        }
        return this.f87745e.zza(this.f87741a, actionCodeSettings, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzcf] */
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
    public final Task p(FirebaseUser firebaseUser, AuthCredential authCredential) {
        Preconditions.m(authCredential);
        Preconditions.m(firebaseUser);
        return authCredential instanceof EmailAuthCredential ? new zzo(this, firebaseUser, (EmailAuthCredential) authCredential.O()).b(this, firebaseUser.g0(), this.f87755o, "EMAIL_PASSWORD_PROVIDER") : this.f87745e.zza(this.f87741a, firebaseUser, authCredential.O(), (String) null, (zzcf) new zzb(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.firebase.auth.internal.zzcf, com.google.firebase.auth.zzx] */
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
    public final Task q(FirebaseUser firebaseUser, boolean z2) {
        if (firebaseUser == null) {
            return Tasks.forException(zzaen.zza(new Status(17495)));
        }
        zzahv zzahvVarO2 = firebaseUser.O2();
        return (!zzahvVarO2.zzg() || z2) ? this.f87745e.zza(this.f87741a, firebaseUser, zzahvVarO2.zzd(), (zzcf) new zzx(this)) : Tasks.forResult(zzbi.a(zzahvVarO2.zzc()));
    }

    public final Task r(String str) {
        return this.f87745e.zza(this.f87751k, str);
    }

    public final Task s(String str, String str2, ActionCodeSettings actionCodeSettings) {
        Preconditions.g(str);
        Preconditions.g(str2);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.K2();
        }
        String str3 = this.f87749i;
        if (str3 != null) {
            actionCodeSettings.J2(str3);
        }
        return this.f87745e.zza(str, str2, actionCodeSettings);
    }

    final PhoneAuthProvider.OnVerificationStateChangedCallbacks w(PhoneAuthOptions phoneAuthOptions, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, com.google.firebase.auth.internal.zzj zzjVar) {
        return phoneAuthOptions.l() ? onVerificationStateChangedCallbacks : new zzl(this, phoneAuthOptions, zzjVar, onVerificationStateChangedCallbacks);
    }

    public static FirebaseAuth getInstance(FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.j(FirebaseAuth.class);
    }

    private FirebaseAuth(FirebaseApp firebaseApp, zzacq zzacqVar, zzcb zzcbVar, zzcg zzcgVar, com.google.firebase.auth.internal.zzb zzbVar, Provider provider, Provider provider2, Executor executor, Executor executor2, Executor executor3, Executor executor4) {
        zzahv zzahvVarA;
        this.f87742b = new CopyOnWriteArrayList();
        this.f87743c = new CopyOnWriteArrayList();
        this.f87744d = new CopyOnWriteArrayList();
        this.f87748h = new Object();
        this.f87750j = new Object();
        this.f87753m = RecaptchaAction.custom("getOobCode");
        this.f87754n = RecaptchaAction.custom("signInWithPassword");
        this.f87755o = RecaptchaAction.custom("signUpPassword");
        this.f87756p = RecaptchaAction.custom("sendVerificationCode");
        this.f87757q = RecaptchaAction.custom("mfaSmsEnrollment");
        this.f87758r = RecaptchaAction.custom("mfaSmsSignIn");
        this.f87741a = (FirebaseApp) Preconditions.m(firebaseApp);
        this.f87745e = (zzacq) Preconditions.m(zzacqVar);
        zzcb zzcbVar2 = (zzcb) Preconditions.m(zzcbVar);
        this.f87759s = zzcbVar2;
        this.f87747g = new com.google.firebase.auth.internal.zzac();
        zzcg zzcgVar2 = (zzcg) Preconditions.m(zzcgVar);
        this.f87760t = zzcgVar2;
        this.f87761u = (com.google.firebase.auth.internal.zzb) Preconditions.m(zzbVar);
        this.f87762v = provider;
        this.f87763w = provider2;
        this.f87765y = executor2;
        this.f87766z = executor3;
        this.A = executor4;
        FirebaseUser firebaseUserB = zzcbVar2.b();
        this.f87746f = firebaseUserB;
        if (firebaseUserB != null && (zzahvVarA = zzcbVar2.a(firebaseUserB)) != null) {
            A(this, this.f87746f, zzahvVarA, false, false);
        }
        zzcgVar2.b(this);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class zzc extends zza implements com.google.firebase.auth.internal.zzau, com.google.firebase.auth.internal.zzl {
        @Override // com.google.firebase.auth.internal.zzau
        public final void zza(Status status) {
        }
    }
}
