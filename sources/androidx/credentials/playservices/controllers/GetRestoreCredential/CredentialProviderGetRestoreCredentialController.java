package androidx.credentials.playservices.controllers.GetRestoreCredential;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.Credential;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.CredentialOption;
import androidx.credentials.GetCredentialRequest;
import androidx.credentials.GetCredentialResponse;
import androidx.credentials.GetRestoreCredentialOption;
import androidx.credentials.exceptions.GetCredentialException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.NoCredentialException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialRequest;
import com.google.android.gms.auth.blockstore.restorecredential.GetRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.RestoreCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CredentialProviderGetRestoreCredentialController extends CredentialProviderController<GetCredentialRequest, GetRestoreCredentialRequest, GetRestoreCredentialResponse, GetCredentialResponse, GetCredentialException> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f35129g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderGetRestoreCredentialController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35129g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = new GetCredentialUnknownException("Get restore credential failed for unknown reason, failure: " + e3.getMessage());
        if (e3 instanceof ApiException) {
            ApiException apiException = (ApiException) e3;
            if (apiException.getStatusCode() == 40201) {
                objectRef.f140144a = new GetCredentialUnknownException("The restore credential internal service had a failure, failure: " + e3.getMessage());
            } else {
                objectRef.f140144a = new GetCredentialUnknownException("The restore credential service failed with unsupported status code, failure: " + e3.getMessage() + ", status code: " + apiException.getStatusCode());
            }
        }
        CredentialProviderController.e(cancellationSignal, new CredentialProviderGetRestoreCredentialController$invokePlayServices$2$1(executor, credentialManagerCallback, objectRef));
    }

    public GetRestoreCredentialRequest l(GetCredentialRequest request) {
        GetRestoreCredentialOption getRestoreCredentialOption;
        GetRestoreCredentialOption getRestoreCredentialOption2;
        Intrinsics.checkNotNullParameter(request, "request");
        Iterator it = request.a().iterator();
        while (true) {
            getRestoreCredentialOption = null;
            if (!it.hasNext()) {
                getRestoreCredentialOption2 = null;
                break;
            }
            CredentialOption credentialOption = (CredentialOption) it.next();
            if (credentialOption instanceof GetRestoreCredentialOption) {
                getRestoreCredentialOption2 = (GetRestoreCredentialOption) credentialOption;
                break;
            }
        }
        if (getRestoreCredentialOption2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("credentialOption");
        } else {
            getRestoreCredentialOption = getRestoreCredentialOption2;
        }
        return new GetRestoreCredentialRequest(getRestoreCredentialOption.c());
    }

    public GetCredentialResponse m(GetRestoreCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return new GetCredentialResponse(Credential.f34750c.b("androidx.credentials.TYPE_RESTORE_CREDENTIAL", response.M()));
    }

    public void n(GetCredentialRequest request, final CredentialManagerCallback callback, final Executor executor, final CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        Task taskC = RestoreCredential.a(this.f35129g).c(l(request));
        final Function1<GetRestoreCredentialResponse, Unit> function1 = new Function1<GetRestoreCredentialResponse, Unit>() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1

            /* JADX INFO: renamed from: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Executor f35134a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ CredentialManagerCallback f35135b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ GetCredentialResponse f35136c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Executor executor, CredentialManagerCallback credentialManagerCallback, GetCredentialResponse getCredentialResponse) {
                    super(0);
                    this.f35134a = executor;
                    this.f35135b = credentialManagerCallback;
                    this.f35136c = getCredentialResponse;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(CredentialManagerCallback credentialManagerCallback, GetCredentialResponse getCredentialResponse) {
                    credentialManagerCallback.onResult(getCredentialResponse);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m333invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m333invoke() {
                    Executor executor = this.f35134a;
                    final CredentialManagerCallback credentialManagerCallback = this.f35135b;
                    final GetCredentialResponse getCredentialResponse = this.f35136c;
                    executor.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE 
                          (r0v0 'executor' java.util.concurrent.Executor)
                          (wrap:java.lang.Runnable:0x0008: CONSTRUCTOR 
                          (r1v0 'credentialManagerCallback' androidx.credentials.CredentialManagerCallback A[DONT_INLINE])
                          (r2v0 'getCredentialResponse' androidx.credentials.GetCredentialResponse A[DONT_INLINE])
                         A[MD:(androidx.credentials.CredentialManagerCallback, androidx.credentials.GetCredentialResponse):void (m), WRAPPED] call: androidx.credentials.playservices.controllers.GetRestoreCredential.j.<init>(androidx.credentials.CredentialManagerCallback, androidx.credentials.GetCredentialResponse):void type: CONSTRUCTOR)
                         INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1.1.invoke():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.credentials.playservices.controllers.GetRestoreCredential.j, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.util.concurrent.Executor r0 = r4.f35134a
                        androidx.credentials.CredentialManagerCallback r1 = r4.f35135b
                        androidx.credentials.GetCredentialResponse r2 = r4.f35136c
                        androidx.credentials.playservices.controllers.GetRestoreCredential.j r3 = new androidx.credentials.playservices.controllers.GetRestoreCredential.j
                        r3.<init>(r1, r2)
                        r0.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1.AnonymousClass1.m333invoke():void");
                }
            }

            /* JADX INFO: renamed from: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class AnonymousClass2 extends Lambda implements Function0<Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Executor f35137a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ CredentialManagerCallback f35138b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Exception f35139c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Executor executor, CredentialManagerCallback credentialManagerCallback, Exception exc) {
                    super(0);
                    this.f35137a = executor;
                    this.f35138b = credentialManagerCallback;
                    this.f35139c = exc;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(CredentialManagerCallback credentialManagerCallback, Exception exc) {
                    credentialManagerCallback.a(exc instanceof NoCredentialException ? (GetCredentialException) exc : new GetCredentialUnknownException(exc.getMessage()));
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m334invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m334invoke() {
                    Executor executor = this.f35137a;
                    final CredentialManagerCallback credentialManagerCallback = this.f35138b;
                    final Exception exc = this.f35139c;
                    executor.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE 
                          (r0v0 'executor' java.util.concurrent.Executor)
                          (wrap:java.lang.Runnable:0x0008: CONSTRUCTOR 
                          (r1v0 'credentialManagerCallback' androidx.credentials.CredentialManagerCallback A[DONT_INLINE])
                          (r2v0 'exc' java.lang.Exception A[DONT_INLINE])
                         A[MD:(androidx.credentials.CredentialManagerCallback, java.lang.Exception):void (m), WRAPPED] call: androidx.credentials.playservices.controllers.GetRestoreCredential.k.<init>(androidx.credentials.CredentialManagerCallback, java.lang.Exception):void type: CONSTRUCTOR)
                         INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1.2.invoke():void, file: classes3.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.credentials.playservices.controllers.GetRestoreCredential.k, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                        	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                        	... 15 more
                        */
                    /*
                        this = this;
                        java.util.concurrent.Executor r0 = r4.f35137a
                        androidx.credentials.CredentialManagerCallback r1 = r4.f35138b
                        java.lang.Exception r2 = r4.f35139c
                        androidx.credentials.playservices.controllers.GetRestoreCredential.k r3 = new androidx.credentials.playservices.controllers.GetRestoreCredential.k
                        r3.<init>(r1, r2)
                        r0.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.GetRestoreCredential.CredentialProviderGetRestoreCredentialController$invokePlayServices$1.AnonymousClass2.m334invoke():void");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(GetRestoreCredentialResponse getRestoreCredentialResponse) {
                try {
                    CredentialProviderGetRestoreCredentialController credentialProviderGetRestoreCredentialController = this.f35130a;
                    Intrinsics.checkNotNull(getRestoreCredentialResponse);
                    GetCredentialResponse getCredentialResponseM = credentialProviderGetRestoreCredentialController.m(getRestoreCredentialResponse);
                    CredentialProviderController.Companion companion = CredentialProviderController.f35101f;
                    CredentialProviderController.e(cancellationSignal, new AnonymousClass1(executor, callback, getCredentialResponseM));
                } catch (Exception e3) {
                    CredentialProviderController.Companion companion2 = CredentialProviderController.f35101f;
                    CredentialProviderController.e(cancellationSignal, new AnonymousClass2(executor, callback, e3));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((GetRestoreCredentialResponse) obj);
                return Unit.f139807a;
            }
        };
        taskC.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.h
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                CredentialProviderGetRestoreCredentialController.o(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.controllers.GetRestoreCredential.i
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                CredentialProviderGetRestoreCredentialController.p(cancellationSignal, executor, callback, exc);
            }
        });
    }
}
