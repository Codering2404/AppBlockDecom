package com.google.android.gms.common.api;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.api.internal.ApiKey;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.NonGmsServiceBrokerClient;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.common.api.internal.zaae;
import com.google.android.gms.common.api.internal.zabq;
import com.google.android.gms.common.api.internal.zabv;
import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.Collections;
import java.util.Set;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class GoogleApi<O extends Api.ApiOptions> implements HasApiKey<O> {
    protected final GoogleApiManager zaa;
    private final Context zab;
    private final String zac;
    private final Api zad;
    private final Api.ApiOptions zae;
    private final ApiKey zaf;
    private final Looper zag;
    private final int zah;

    @NotOnlyInitialized
    private final GoogleApiClient zai;
    private final StatusExceptionMapper zaj;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Settings {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Settings f71506c = new Builder().a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final StatusExceptionMapper f71507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Looper f71508b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private StatusExceptionMapper f71509a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Looper f71510b;

            /* JADX WARN: Multi-variable type inference failed */
            public Settings a() {
                if (this.f71509a == null) {
                    this.f71509a = new ApiExceptionMapper();
                }
                if (this.f71510b == null) {
                    this.f71510b = Looper.getMainLooper();
                }
                return new Settings(this.f71509a, this.f71510b);
            }

            public Builder b(Looper looper) {
                Preconditions.n(looper, "Looper must not be null.");
                this.f71510b = looper;
                return this;
            }

            public Builder c(StatusExceptionMapper statusExceptionMapper) {
                Preconditions.n(statusExceptionMapper, "StatusExceptionMapper must not be null.");
                this.f71509a = statusExceptionMapper;
                return this;
            }
        }

        private Settings(StatusExceptionMapper statusExceptionMapper, Account account, Looper looper) {
            this.f71507a = statusExceptionMapper;
            this.f71508b = looper;
        }
    }

    public GoogleApi(Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        this(activity, activity, api, apiOptions, settings);
    }

    private final BaseImplementation.ApiMethodImpl f(int i3, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        apiMethodImpl.zak();
        this.zaa.D(this, i3, apiMethodImpl);
        return apiMethodImpl;
    }

    private final Task g(int i3, TaskApiCall taskApiCall) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zaa.E(this, i3, taskApiCall, taskCompletionSource, this.zaj);
        return taskCompletionSource.getTask();
    }

    public GoogleApiClient asGoogleApiClient() {
        return this.zai;
    }

    protected ClientSettings.Builder createClientSettingsBuilder() {
        Account account;
        GoogleSignInAccount googleSignInAccountL;
        GoogleSignInAccount googleSignInAccountL2;
        ClientSettings.Builder builder = new ClientSettings.Builder();
        Api.ApiOptions apiOptions = this.zae;
        if (!(apiOptions instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountL2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions).L()) == null) {
            Api.ApiOptions apiOptions2 = this.zae;
            account = apiOptions2 instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) apiOptions2).getAccount() : null;
        } else {
            account = googleSignInAccountL2.getAccount();
        }
        builder.d(account);
        Api.ApiOptions apiOptions3 = this.zae;
        Set setH1 = (!(apiOptions3 instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountL = ((Api.ApiOptions.HasGoogleSignInAccountOptions) apiOptions3).L()) == null) ? Collections.EMPTY_SET : googleSignInAccountL.h1();
        builder.c(setH1);
        builder.e(this.zab.getClass().getName());
        builder.b(this.zab.getPackageName());
        return builder;
    }

    protected Task<Boolean> disconnectService() {
        return this.zaa.w(this);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doBestEffortWrite(T t2) {
        f(2, t2);
        return t2;
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doRead(T t2) {
        f(0, t2);
        return t2;
    }

    @ResultIgnorabilityUnspecified
    @Deprecated
    public <A extends Api.AnyClient, T extends RegisterListenerMethod<A, ?>, U extends UnregisterListenerMethod<A, ?>> Task<Void> doRegisterEventListener(T t2, U u2) {
        Preconditions.m(t2);
        Preconditions.m(u2);
        Preconditions.n(t2.b(), "Listener has already been released.");
        Preconditions.n(u2.a(), "Listener has already been released.");
        Preconditions.b(Objects.b(t2.b(), u2.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.zaa.x(this, t2, u2, new Runnable() { // from class: com.google.android.gms.common.api.zad
            @Override // java.lang.Runnable
            public final void run() {
            }
        });
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey) {
        return doUnregisterEventListener(listenerKey, 0);
    }

    public <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T doWrite(T t2) {
        f(1, t2);
        return t2;
    }

    protected String getApiFallbackAttributionTag(Context context) {
        return null;
    }

    public final ApiKey<O> getApiKey() {
        return this.zaf;
    }

    public O getApiOptions() {
        return (O) this.zae;
    }

    public Context getApplicationContext() {
        return this.zab;
    }

    protected String getContextAttributionTag() {
        return this.zac;
    }

    @Deprecated
    protected String getContextFeatureId() {
        return this.zac;
    }

    public Looper getLooper() {
        return this.zag;
    }

    public <L> ListenerHolder<L> registerListener(L l3, String str) {
        return ListenerHolders.a(l3, this.zag, str);
    }

    public final int zaa() {
        return this.zah;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Api.Client zab(Looper looper, zabq zabqVar) {
        ClientSettings clientSettingsA = createClientSettingsBuilder().a();
        Api.Client clientBuildClient = ((Api.AbstractClientBuilder) Preconditions.m(this.zad.a())).buildClient(this.zab, looper, clientSettingsA, this.zae, (GoogleApiClient.ConnectionCallbacks) zabqVar, (GoogleApiClient.OnConnectionFailedListener) zabqVar);
        String contextAttributionTag = getContextAttributionTag();
        if (contextAttributionTag != null && (clientBuildClient instanceof BaseGmsClient)) {
            ((BaseGmsClient) clientBuildClient).setAttributionTag(contextAttributionTag);
        }
        if (contextAttributionTag != null && (clientBuildClient instanceof NonGmsServiceBrokerClient)) {
            ((NonGmsServiceBrokerClient) clientBuildClient).f(contextAttributionTag);
        }
        return clientBuildClient;
    }

    public final zact zac(Context context, Handler handler) {
        return new zact(context, handler, createClientSettingsBuilder().a());
    }

    public GoogleApi(Activity activity, Api api, Api.ApiOptions apiOptions, StatusExceptionMapper statusExceptionMapper) {
        Settings.Builder builder = new Settings.Builder();
        builder.c(statusExceptionMapper);
        builder.b(activity.getMainLooper());
        this(activity, api, apiOptions, builder.a());
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task<TResult> doBestEffortWrite(TaskApiCall<A, TResult> taskApiCall) {
        return g(2, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task<TResult> doRead(TaskApiCall<A, TResult> taskApiCall) {
        return g(0, taskApiCall);
    }

    @ResultIgnorabilityUnspecified
    public Task<Boolean> doUnregisterEventListener(ListenerHolder.ListenerKey<?> listenerKey, int i3) {
        Preconditions.n(listenerKey, "Listener key cannot be null.");
        return this.zaa.y(this, listenerKey, i3);
    }

    @ResultIgnorabilityUnspecified
    public <TResult, A extends Api.AnyClient> Task<TResult> doWrite(TaskApiCall<A, TResult> taskApiCall) {
        return g(1, taskApiCall);
    }

    private GoogleApi(Context context, Activity activity, Api api, Api.ApiOptions apiOptions, Settings settings) {
        String apiFallbackAttributionTag;
        Preconditions.n(context, "Null context is not permitted.");
        Preconditions.n(api, "Api must not be null.");
        Preconditions.n(settings, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context2 = (Context) Preconditions.n(context.getApplicationContext(), "The provided context did not have an application context.");
        this.zab = context2;
        if (Build.VERSION.SDK_INT >= 30) {
            apiFallbackAttributionTag = context.getAttributionTag();
        } else {
            apiFallbackAttributionTag = getApiFallbackAttributionTag(context);
        }
        this.zac = apiFallbackAttributionTag;
        this.zad = api;
        this.zae = apiOptions;
        this.zag = settings.f71508b;
        ApiKey apiKeyA = ApiKey.a(api, apiOptions, apiFallbackAttributionTag);
        this.zaf = apiKeyA;
        this.zai = new zabv(this);
        GoogleApiManager googleApiManagerU = GoogleApiManager.u(context2);
        this.zaa = googleApiManagerU;
        this.zah = googleApiManagerU.l();
        this.zaj = settings.f71507a;
        if (activity != null && !(activity instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            zaae.j(activity, googleApiManagerU, apiKeyA);
        }
        googleApiManagerU.I(this);
    }

    @ResultIgnorabilityUnspecified
    public <A extends Api.AnyClient> Task<Void> doRegisterEventListener(RegistrationMethods<A, ?> registrationMethods) {
        Preconditions.m(registrationMethods);
        Preconditions.n(registrationMethods.f71604a.b(), "Listener has already been released.");
        Preconditions.n(registrationMethods.f71605b.a(), "Listener has already been released.");
        return this.zaa.x(this, registrationMethods.f71604a, registrationMethods.f71605b, registrationMethods.f71606c);
    }

    public GoogleApi(Context context, Api api, Api.ApiOptions apiOptions, Settings settings) {
        this(context, null, api, apiOptions, settings);
    }
}
