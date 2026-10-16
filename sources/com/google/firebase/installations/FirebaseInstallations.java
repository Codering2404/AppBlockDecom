package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Lazy;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.internal.FidListener;
import com.google.firebase.installations.internal.FidListenerHandle;
import com.google.firebase.installations.local.IidStore;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class FirebaseInstallations implements FirebaseInstallationsApi {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f89224m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final ThreadFactory f89225n = new ThreadFactory() { // from class: com.google.firebase.installations.FirebaseInstallations.1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f89238a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f89238a.getAndIncrement())));
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FirebaseApp f89226a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FirebaseInstallationServiceClient f89227b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistedInstallation f89228c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Utils f89229d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Lazy f89230e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RandomFidGenerator f89231f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f89232g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ExecutorService f89233h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f89234i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f89235j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Set f89236k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final List f89237l;

    /* JADX INFO: renamed from: com.google.firebase.installations.FirebaseInstallations$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements FidListenerHandle {
    }

    /* JADX INFO: renamed from: com.google.firebase.installations.FirebaseInstallations$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f89239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f89240b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f89240b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f89240b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f89240b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f89239a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f89239a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    FirebaseInstallations(final FirebaseApp firebaseApp, Provider provider, ExecutorService executorService, Executor executor) {
        this(executorService, executor, firebaseApp, new FirebaseInstallationServiceClient(firebaseApp.l(), provider), new PersistedInstallation(firebaseApp), Utils.c(), new Lazy(new Provider() { // from class: com.google.firebase.installations.a
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return FirebaseInstallations.e(firebaseApp);
            }
        }), new RandomFidGenerator());
    }

    private synchronized void A(String str) {
        this.f89235j = str;
    }

    private synchronized void B(PersistedInstallationEntry persistedInstallationEntry, PersistedInstallationEntry persistedInstallationEntry2) {
        if (this.f89236k.size() != 0 && !TextUtils.equals(persistedInstallationEntry.d(), persistedInstallationEntry2.d())) {
            Iterator it = this.f89236k.iterator();
            while (it.hasNext()) {
                ((FidListener) it.next()).a(persistedInstallationEntry2.d());
            }
        }
    }

    public static /* synthetic */ IidStore e(FirebaseApp firebaseApp) {
        return new IidStore(firebaseApp);
    }

    private Task f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new GetAuthTokenListener(this.f89229d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new GetIdListener(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void h(StateListener stateListener) {
        synchronized (this.f89232g) {
            this.f89237l.add(stateListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z2) {
        PersistedInstallationEntry persistedInstallationEntryX;
        PersistedInstallationEntry persistedInstallationEntryR = r();
        try {
            if (persistedInstallationEntryR.i() || persistedInstallationEntryR.l()) {
                persistedInstallationEntryX = x(persistedInstallationEntryR);
            } else {
                if (!z2 && !this.f89229d.f(persistedInstallationEntryR)) {
                    return;
                }
                persistedInstallationEntryX = k(persistedInstallationEntryR);
            }
            u(persistedInstallationEntryX);
            B(persistedInstallationEntryR, persistedInstallationEntryX);
            if (persistedInstallationEntryX.k()) {
                A(persistedInstallationEntryX.d());
            }
            if (persistedInstallationEntryX.i()) {
                y(new FirebaseInstallationsException(FirebaseInstallationsException.Status.BAD_CONFIG));
            } else if (persistedInstallationEntryX.j()) {
                y(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
            } else {
                z(persistedInstallationEntryX);
            }
        } catch (FirebaseInstallationsException e3) {
            y(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(final boolean z2) {
        PersistedInstallationEntry persistedInstallationEntryS = s();
        if (z2) {
            persistedInstallationEntryS = persistedInstallationEntryS.p();
        }
        z(persistedInstallationEntryS);
        this.f89234i.execute(new Runnable() { // from class: com.google.firebase.installations.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f89259a.i(z2);
            }
        });
    }

    private PersistedInstallationEntry k(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        TokenResult tokenResultE = this.f89227b.e(l(), persistedInstallationEntry.d(), t(), persistedInstallationEntry.f());
        int i3 = AnonymousClass3.f89240b[tokenResultE.b().ordinal()];
        if (i3 == 1) {
            return persistedInstallationEntry.o(tokenResultE.c(), tokenResultE.d(), this.f89229d.b());
        }
        if (i3 == 2) {
            return persistedInstallationEntry.q("BAD CONFIG");
        }
        if (i3 != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        A(null);
        return persistedInstallationEntry.r();
    }

    private synchronized String n() {
        return this.f89235j;
    }

    private IidStore o() {
        return (IidStore) this.f89230e.get();
    }

    public static FirebaseInstallations p() {
        return q(FirebaseApp.m());
    }

    public static FirebaseInstallations q(FirebaseApp firebaseApp) {
        Preconditions.b(firebaseApp != null, "Null is not a valid value of FirebaseApp.");
        return (FirebaseInstallations) firebaseApp.j(FirebaseInstallationsApi.class);
    }

    /* JADX WARN: Finally extract failed */
    private PersistedInstallationEntry r() {
        PersistedInstallationEntry persistedInstallationEntryD;
        synchronized (f89224m) {
            try {
                CrossProcessLock crossProcessLockA = CrossProcessLock.a(this.f89226a.l(), "generatefid.lock");
                try {
                    persistedInstallationEntryD = this.f89228c.d();
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                } catch (Throwable th) {
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return persistedInstallationEntryD;
    }

    /* JADX WARN: Finally extract failed */
    private PersistedInstallationEntry s() {
        PersistedInstallationEntry persistedInstallationEntryD;
        synchronized (f89224m) {
            try {
                CrossProcessLock crossProcessLockA = CrossProcessLock.a(this.f89226a.l(), "generatefid.lock");
                try {
                    persistedInstallationEntryD = this.f89228c.d();
                    if (persistedInstallationEntryD.j()) {
                        persistedInstallationEntryD = this.f89228c.b(persistedInstallationEntryD.t(w(persistedInstallationEntryD)));
                    }
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                } catch (Throwable th) {
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return persistedInstallationEntryD;
    }

    /* JADX WARN: Finally extract failed */
    private void u(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (f89224m) {
            try {
                CrossProcessLock crossProcessLockA = CrossProcessLock.a(this.f89226a.l(), "generatefid.lock");
                try {
                    this.f89228c.b(persistedInstallationEntry);
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                } catch (Throwable th) {
                    if (crossProcessLockA != null) {
                        crossProcessLockA.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void v() {
        Preconditions.h(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.h(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(Utils.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.b(Utils.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    private String w(PersistedInstallationEntry persistedInstallationEntry) {
        if ((!this.f89226a.o().equals("CHIME_ANDROID_SDK") && !this.f89226a.w()) || !persistedInstallationEntry.m()) {
            return this.f89231f.a();
        }
        String strF = o().f();
        return TextUtils.isEmpty(strF) ? this.f89231f.a() : strF;
    }

    private PersistedInstallationEntry x(PersistedInstallationEntry persistedInstallationEntry) throws FirebaseInstallationsException {
        InstallationResponse installationResponseD = this.f89227b.d(l(), persistedInstallationEntry.d(), t(), m(), (persistedInstallationEntry.d() == null || persistedInstallationEntry.d().length() != 11) ? null : o().i());
        int i3 = AnonymousClass3.f89239a[installationResponseD.e().ordinal()];
        if (i3 == 1) {
            return persistedInstallationEntry.s(installationResponseD.c(), installationResponseD.d(), this.f89229d.b(), installationResponseD.b().c(), installationResponseD.b().d());
        }
        if (i3 == 2) {
            return persistedInstallationEntry.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    private void y(Exception exc) {
        synchronized (this.f89232g) {
            try {
                Iterator it = this.f89237l.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void z(PersistedInstallationEntry persistedInstallationEntry) {
        synchronized (this.f89232g) {
            try {
                Iterator it = this.f89237l.iterator();
                while (it.hasNext()) {
                    if (((StateListener) it.next()).b(persistedInstallationEntry)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public Task a(final boolean z2) {
        v();
        Task taskF = f();
        this.f89233h.execute(new Runnable() { // from class: com.google.firebase.installations.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f89257a.j(z2);
            }
        });
        return taskF;
    }

    @Override // com.google.firebase.installations.FirebaseInstallationsApi
    public Task getId() {
        v();
        String strN = n();
        if (strN != null) {
            return Tasks.forResult(strN);
        }
        Task taskG = g();
        this.f89233h.execute(new Runnable() { // from class: com.google.firebase.installations.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f89256a.j(false);
            }
        });
        return taskG;
    }

    String l() {
        return this.f89226a.p().b();
    }

    String m() {
        return this.f89226a.p().c();
    }

    String t() {
        return this.f89226a.p().e();
    }

    FirebaseInstallations(ExecutorService executorService, Executor executor, FirebaseApp firebaseApp, FirebaseInstallationServiceClient firebaseInstallationServiceClient, PersistedInstallation persistedInstallation, Utils utils, Lazy lazy, RandomFidGenerator randomFidGenerator) {
        this.f89232g = new Object();
        this.f89236k = new HashSet();
        this.f89237l = new ArrayList();
        this.f89226a = firebaseApp;
        this.f89227b = firebaseInstallationServiceClient;
        this.f89228c = persistedInstallation;
        this.f89229d = utils;
        this.f89230e = lazy;
        this.f89231f = randomFidGenerator;
        this.f89233h = executorService;
        this.f89234i = executor;
    }
}
