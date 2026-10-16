package androidx.credentials.playservices;

import android.content.Context;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.credentials.ClearCredentialStateRequest;
import androidx.credentials.CreateCredentialRequest;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreatePasswordRequest;
import androidx.credentials.CreatePublicKeyCredentialRequest;
import androidx.credentials.CreateRestoreCredentialRequest;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CredentialOption;
import androidx.credentials.CredentialProvider;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetDigitalCredentialOption;
import androidx.credentials.GetRestoreCredentialOption;
import androidx.credentials.PrepareGetCredentialResponse;
import androidx.credentials.exceptions.ClearCredentialException;
import androidx.credentials.exceptions.ClearCredentialProviderConfigurationException;
import androidx.credentials.exceptions.ClearCredentialUnknownException;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.controllers.BeginSignIn.CredentialProviderBeginSignInController;
import androidx.credentials.playservices.controllers.CreatePassword.CredentialProviderCreatePasswordController;
import androidx.credentials.playservices.controllers.CreatePublicKeyCredential.CredentialProviderCreatePublicKeyCredentialController;
import androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController;
import androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetDigitalCredentialController;
import androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController;
import androidx.credentials.playservices.controllers.GetSignInIntent.CredentialProviderGetSignInIntentController;
import com.google.android.gms.auth.api.identity.Identity;
import com.google.android.gms.auth.blockstore.restorecredential.ClearRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.RestoreCredential;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.identity.googleid.GetSignInWithGoogleOption;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CredentialProviderPlayServicesImpl implements CredentialProvider {
    public static final Companion Companion = new Companion(null);
    public static final int MIN_GMS_APK_VERSION = 230815045;
    public static final int MIN_GMS_APK_VERSION_DIGITAL_CRED = 243100000;
    public static final int MIN_GMS_APK_VERSION_RESTORE_CRED = 242200000;
    private static final String TAG = "PlayServicesImpl";
    private final Context context;
    private GoogleApiAvailability googleApiAvailability;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(CancellationSignal cancellationSignal) {
            if (cancellationSignal == null) {
                Log.i(CredentialProviderPlayServicesImpl.TAG, "No cancellationSignal found");
                return false;
            }
            if (!cancellationSignal.isCanceled()) {
                return false;
            }
            Log.i(CredentialProviderPlayServicesImpl.TAG, "the flow has been canceled");
            return true;
        }

        public final void b(CancellationSignal cancellationSignal, Function0 callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (a(cancellationSignal)) {
                return;
            }
            callback.invoke();
        }

        public final boolean c(GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Iterator it = request.a().iterator();
            while (it.hasNext()) {
                if (((CredentialOption) it.next()) instanceof GetDigitalCredentialOption) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Iterator it = request.a().iterator();
            while (it.hasNext()) {
                if (((CredentialOption) it.next()) instanceof GetRestoreCredentialOption) {
                    return true;
                }
            }
            return false;
        }

        public final boolean e(GetCredentialRequest request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Iterator it = request.a().iterator();
            while (it.hasNext()) {
                if (((CredentialOption) it.next()) instanceof GetSignInWithGoogleOption) {
                    return true;
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onClearCredential$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f34916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34917b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Executor executor, CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f34916a = executor;
            this.f34917b = credentialManagerCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CredentialManagerCallback credentialManagerCallback) {
            credentialManagerCallback.a(new ClearCredentialProviderConfigurationException("clearCredentialStateAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m300invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m300invoke() {
            Executor executor = this.f34916a;
            final CredentialManagerCallback credentialManagerCallback = this.f34917b;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.e
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.AnonymousClass1.d(credentialManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onCreateCredential$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class C03491 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f34934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34935b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03491(Executor executor, CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f34934a = executor;
            this.f34935b = credentialManagerCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CredentialManagerCallback credentialManagerCallback) {
            credentialManagerCallback.a(new CreateCredentialProviderConfigurationException("createCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m305invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m305invoke() {
            Executor executor = this.f34934a;
            final CredentialManagerCallback credentialManagerCallback = this.f34935b;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.j
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.C03491.d(credentialManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onGetCredential$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class C03501 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f34936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34937b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C03501(Executor executor, CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f34936a = executor;
            this.f34937b = credentialManagerCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CredentialManagerCallback credentialManagerCallback) {
            credentialManagerCallback.a(new GetCredentialProviderConfigurationException("this device requires a Google Play Services update for the given feature to be supported"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m306invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m306invoke() {
            Executor executor = this.f34936a;
            final CredentialManagerCallback credentialManagerCallback = this.f34937b;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.k
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.C03501.d(credentialManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onGetCredential$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class C03512 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f34938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34939b;

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CredentialManagerCallback credentialManagerCallback) {
            credentialManagerCallback.a(new GetCredentialProviderConfigurationException("this feature requires the minimum API level to be 23"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m307invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m307invoke() {
            Executor executor = this.f34938a;
            final CredentialManagerCallback credentialManagerCallback = this.f34939b;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.l
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.C03512.d(credentialManagerCallback);
                }
            });
        }
    }

    /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onGetCredential$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass3 extends Lambda implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Executor f34940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CredentialManagerCallback f34941b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Executor executor, CredentialManagerCallback credentialManagerCallback) {
            super(0);
            this.f34940a = executor;
            this.f34941b = credentialManagerCallback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CredentialManagerCallback credentialManagerCallback) {
            credentialManagerCallback.a(new GetCredentialProviderConfigurationException("getCredentialAsync no provider dependencies found - please ensure the desired provider dependencies are added"));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m308invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m308invoke() {
            Executor executor = this.f34940a;
            final CredentialManagerCallback credentialManagerCallback = this.f34941b;
            executor.execute(new Runnable() { // from class: androidx.credentials.playservices.m
                @Override // java.lang.Runnable
                public final void run() {
                    CredentialProviderPlayServicesImpl.AnonymousClass3.d(credentialManagerCallback);
                }
            });
        }
    }

    public CredentialProviderPlayServicesImpl(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        GoogleApiAvailability googleApiAvailabilityQ = GoogleApiAvailability.q();
        Intrinsics.checkNotNullExpressionValue(googleApiAvailabilityQ, "getInstance(...)");
        this.googleApiAvailability = googleApiAvailabilityQ;
    }

    private final int isGooglePlayServicesAvailable(Context context, int i3) {
        return this.googleApiAvailability.j(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClearCredential$lambda$1(CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        Log.w(TAG, "Clearing restore credential failed", e3);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = new ClearCredentialUnknownException("Clear restore credential failed for unknown reason.");
        if ((e3 instanceof ApiException) && ((ApiException) e3).getStatusCode() == 40201) {
            objectRef.f140144a = new ClearCredentialUnknownException("The restore credential internal service had a failure.");
        }
        Companion.b(cancellationSignal, new CredentialProviderPlayServicesImpl$onClearCredential$3$1(executor, credentialManagerCallback, objectRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClearCredential$lambda$4(CredentialProviderPlayServicesImpl credentialProviderPlayServicesImpl, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        Companion.b(cancellationSignal, new CredentialProviderPlayServicesImpl$onClearCredential$5$1$1(e3, executor, credentialManagerCallback));
    }

    public final GoogleApiAvailability getGoogleApiAvailability() {
        return this.googleApiAvailability;
    }

    @Override // androidx.credentials.CredentialProvider
    public boolean isAvailableOnDevice() {
        return isAvailableOnDevice(MIN_GMS_APK_VERSION);
    }

    @Override // androidx.credentials.CredentialProvider
    public void onClearCredential(ClearCredentialStateRequest request, final CancellationSignal cancellationSignal, final Executor executor, final CredentialManagerCallback<Void, ClearCredentialException> callback) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Companion companion = Companion;
        if (companion.a(cancellationSignal)) {
            return;
        }
        if (!Intrinsics.areEqual(request.b(), "androidx.credentials.TYPE_CLEAR_RESTORE_CREDENTIAL")) {
            Task taskSignOut = Identity.c(this.context).signOut();
            final Function1<Void, Unit> function1 = new Function1<Void, Unit>() { // from class: androidx.credentials.playservices.CredentialProviderPlayServicesImpl.onClearCredential.4

                /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onClearCredential$4$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Executor f34929a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ CredentialManagerCallback f34930b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Executor executor, CredentialManagerCallback credentialManagerCallback) {
                        super(0);
                        this.f34929a = executor;
                        this.f34930b = credentialManagerCallback;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void d(CredentialManagerCallback credentialManagerCallback) {
                        credentialManagerCallback.onResult(null);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m303invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m303invoke() {
                        Log.i(CredentialProviderPlayServicesImpl.TAG, "During clear credential, signed out successfully!");
                        Executor executor = this.f34929a;
                        final CredentialManagerCallback credentialManagerCallback = this.f34930b;
                        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.h
                            @Override // java.lang.Runnable
                            public final void run() {
                                CredentialProviderPlayServicesImpl.AnonymousClass4.AnonymousClass1.d(credentialManagerCallback);
                            }
                        });
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Void r5) {
                    CredentialProviderPlayServicesImpl.Companion.b(cancellationSignal, new AnonymousClass1(executor, callback));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Void) obj);
                    return Unit.f139807a;
                }
            };
            taskSignOut.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.c
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function1.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.d
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CredentialProviderPlayServicesImpl.onClearCredential$lambda$4(this.f35202a, cancellationSignal, executor, callback, exc);
                }
            });
        } else {
            if (!isAvailableOnDevice(MIN_GMS_APK_VERSION_RESTORE_CRED)) {
                companion.b(cancellationSignal, new AnonymousClass1(executor, callback));
                return;
            }
            Task taskA = RestoreCredential.a(this.context).a(new ClearRestoreCredentialRequest(request.a()));
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: androidx.credentials.playservices.CredentialProviderPlayServicesImpl.onClearCredential.2

                /* JADX INFO: renamed from: androidx.credentials.playservices.CredentialProviderPlayServicesImpl$onClearCredential$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Executor f34921a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    final /* synthetic */ CredentialManagerCallback f34922b;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(Executor executor, CredentialManagerCallback credentialManagerCallback) {
                        super(0);
                        this.f34921a = executor;
                        this.f34922b = credentialManagerCallback;
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void d(CredentialManagerCallback credentialManagerCallback) {
                        credentialManagerCallback.onResult(null);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m301invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m301invoke() {
                        Log.i(CredentialProviderPlayServicesImpl.TAG, "Cleared restore credential successfully!");
                        Executor executor = this.f34921a;
                        final CredentialManagerCallback credentialManagerCallback = this.f34922b;
                        executor.execute(new Runnable() { // from class: androidx.credentials.playservices.f
                            @Override // java.lang.Runnable
                            public final void run() {
                                CredentialProviderPlayServicesImpl.AnonymousClass2.AnonymousClass1.d(credentialManagerCallback);
                            }
                        });
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Boolean) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Boolean bool) {
                    CredentialProviderPlayServicesImpl.Companion.b(cancellationSignal, new AnonymousClass1(executor, callback));
                }
            };
            taskA.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    function12.invoke(obj);
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    CredentialProviderPlayServicesImpl.onClearCredential$lambda$1(cancellationSignal, executor, callback, exc);
                }
            });
        }
    }

    public void onCreateCredential(Context context, CreateCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<CreateCredentialResponse, CreateCredentialException> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Companion companion = Companion;
        if (companion.a(cancellationSignal)) {
            return;
        }
        if (request instanceof CreatePasswordRequest) {
            CredentialProviderCreatePasswordController.f34991l.a(context).q((CreatePasswordRequest) request, callback, executor, cancellationSignal);
            return;
        }
        if (request instanceof CreatePublicKeyCredentialRequest) {
            CredentialProviderCreatePublicKeyCredentialController.f35008l.a(context).u((CreatePublicKeyCredentialRequest) request, callback, executor, cancellationSignal);
        } else {
            if (!(request instanceof CreateRestoreCredentialRequest)) {
                throw new UnsupportedOperationException("Create Credential request is unsupported, not password or publickeycredential");
            }
            if (isAvailableOnDevice(MIN_GMS_APK_VERSION_RESTORE_CRED)) {
                new CredentialProviderCreateRestoreCredentialController(context).n((CreateRestoreCredentialRequest) request, callback, executor, cancellationSignal);
            } else {
                companion.b(cancellationSignal, new C03491(executor, callback));
            }
        }
    }

    @Override // androidx.credentials.CredentialProvider
    public /* bridge */ /* synthetic */ void onGetCredential(Context context, PrepareGetCredentialResponse.PendingGetCredentialHandle pendingGetCredentialHandle, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        super.onGetCredential(context, pendingGetCredentialHandle, cancellationSignal, executor, credentialManagerCallback);
    }

    @Override // androidx.credentials.CredentialProvider
    public /* bridge */ /* synthetic */ void onPrepareCredential(GetCredentialRequest getCredentialRequest, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback) {
        super.onPrepareCredential(getCredentialRequest, cancellationSignal, executor, credentialManagerCallback);
    }

    public final void setGoogleApiAvailability(GoogleApiAvailability googleApiAvailability) {
        Intrinsics.checkNotNullParameter(googleApiAvailability, "<set-?>");
        this.googleApiAvailability = googleApiAvailability;
    }

    public final boolean isAvailableOnDevice(int i3) {
        int iIsGooglePlayServicesAvailable = isGooglePlayServicesAvailable(this.context, i3);
        boolean z2 = iIsGooglePlayServicesAvailable == 0;
        if (!z2) {
            Log.w(TAG, "Connection with Google Play Services was not successful. Connection result is: " + new ConnectionResult(iIsGooglePlayServicesAvailable));
        }
        return z2;
    }

    @Override // androidx.credentials.CredentialProvider
    public void onGetCredential(Context context, GetCredentialRequest request, CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback<GetCredentialResponse, GetCredentialException> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Companion companion = Companion;
        if (companion.a(cancellationSignal)) {
            return;
        }
        if (companion.c(request)) {
            if (isAvailableOnDevice(MIN_GMS_APK_VERSION_DIGITAL_CRED)) {
                new CredentialProviderGetDigitalCredentialController(context).u(request, callback, executor, cancellationSignal);
                return;
            } else {
                companion.b(cancellationSignal, new C03501(executor, callback));
                return;
            }
        }
        if (companion.d(request)) {
            if (isAvailableOnDevice(MIN_GMS_APK_VERSION_RESTORE_CRED)) {
                new CredentialProviderGetRestoreCredentialController(context).n(request, callback, executor, cancellationSignal);
                return;
            } else {
                companion.b(cancellationSignal, new AnonymousClass3(executor, callback));
                return;
            }
        }
        if (companion.e(request)) {
            new CredentialProviderGetSignInIntentController(context).r(request, callback, executor, cancellationSignal);
        } else {
            new CredentialProviderBeginSignInController(context).r(request, callback, executor, cancellationSignal);
        }
    }

    public static /* synthetic */ void getGoogleApiAvailability$annotations() {
    }
}
