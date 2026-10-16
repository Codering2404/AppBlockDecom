package androidx.credentials.playservices.controllers.CreateRestoreCredential;

import android.content.Context;
import android.os.CancellationSignal;
import androidx.credentials.CreateCredentialResponse;
import androidx.credentials.CreateRestoreCredentialRequest;
import androidx.credentials.CredentialManagerCallback;
import androidx.credentials.exceptions.CreateCredentialException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.domerrors.DataError;
import androidx.credentials.exceptions.restorecredential.CreateRestoreCredentialDomException;
import androidx.credentials.exceptions.restorecredential.E2eeUnavailableException;
import androidx.credentials.playservices.CredentialProviderPlayServicesImpl;
import androidx.credentials.playservices.controllers.CredentialProviderController;
import com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialResponse;
import com.google.android.gms.auth.blockstore.restorecredential.RestoreCredential;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
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
public final class CredentialProviderCreateRestoreCredentialController extends CredentialProviderController<CreateRestoreCredentialRequest, com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest, CreateRestoreCredentialResponse, CreateCredentialResponse, CreateCredentialException> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f35073g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CredentialProviderCreateRestoreCredentialController(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f35073g = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function1 function1, Object obj) {
        function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(CancellationSignal cancellationSignal, Executor executor, CredentialManagerCallback credentialManagerCallback, Exception e3) {
        Intrinsics.checkNotNullParameter(e3, "e");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.f140144a = new CreateCredentialUnknownException("Create restore credential failed for unknown reason, failure: " + e3.getMessage());
        if (e3 instanceof ApiException) {
            ApiException apiException = (ApiException) e3;
            switch (apiException.getStatusCode()) {
                case 40201:
                    objectRef.f140144a = new CreateCredentialUnknownException("The restore credential internal service had a failure, failure: " + e3.getMessage());
                    break;
                case 40202:
                    objectRef.f140144a = new CreateRestoreCredentialDomException(new DataError(), "The request did not match the fido spec, failure: " + e3.getMessage());
                    break;
                case 40203:
                    objectRef.f140144a = new E2eeUnavailableException("E2ee is not available on the device. Check whether the backup and screen lock are enabled.");
                    break;
                default:
                    objectRef.f140144a = new CreateCredentialUnknownException("The restore credential service failed with unsupported status code, failure: " + e3.getMessage() + ", status code: " + apiException.getStatusCode());
                    break;
            }
        }
        CredentialProviderController.e(cancellationSignal, new CredentialProviderCreateRestoreCredentialController$invokePlayServices$2$1(executor, credentialManagerCallback, objectRef));
    }

    public com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest l(CreateRestoreCredentialRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new com.google.android.gms.auth.blockstore.restorecredential.CreateRestoreCredentialRequest(request.a());
    }

    public CreateCredentialResponse m(CreateRestoreCredentialResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return androidx.credentials.CreateRestoreCredentialResponse.f34748e.a(response.M());
    }

    public void n(CreateRestoreCredentialRequest request, final CredentialManagerCallback callback, final Executor executor, final CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(executor, "executor");
        if (CredentialProviderPlayServicesImpl.Companion.a(cancellationSignal)) {
            return;
        }
        Task taskE = RestoreCredential.a(this.f35073g).e(l(request));
        final Function1<CreateRestoreCredentialResponse, Unit> function1 = new Function1<CreateRestoreCredentialResponse, Unit>() { // from class: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1

            /* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class AnonymousClass1 extends Lambda implements Function0<Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Executor f35078a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ CredentialManagerCallback f35079b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ CreateCredentialResponse f35080c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(Executor executor, CredentialManagerCallback credentialManagerCallback, CreateCredentialResponse createCredentialResponse) {
                    super(0);
                    this.f35078a = executor;
                    this.f35079b = credentialManagerCallback;
                    this.f35080c = createCredentialResponse;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(CredentialManagerCallback credentialManagerCallback, CreateCredentialResponse createCredentialResponse) {
                    credentialManagerCallback.onResult(createCredentialResponse);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m323invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m323invoke() {
                    Executor executor = this.f35078a;
                    final CredentialManagerCallback credentialManagerCallback = this.f35079b;
                    final CreateCredentialResponse createCredentialResponse = this.f35080c;
                    executor.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE 
                          (r0v0 'executor' java.util.concurrent.Executor)
                          (wrap:java.lang.Runnable:0x0008: CONSTRUCTOR 
                          (r1v0 'credentialManagerCallback' androidx.credentials.CredentialManagerCallback A[DONT_INLINE])
                          (r2v0 'createCredentialResponse' androidx.credentials.CreateCredentialResponse A[DONT_INLINE])
                         A[MD:(androidx.credentials.CredentialManagerCallback, androidx.credentials.CreateCredentialResponse):void (m), WRAPPED] call: androidx.credentials.playservices.controllers.CreateRestoreCredential.c.<init>(androidx.credentials.CredentialManagerCallback, androidx.credentials.CreateCredentialResponse):void type: CONSTRUCTOR)
                         INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1.1.invoke():void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.credentials.playservices.controllers.CreateRestoreCredential.c, state: NOT_LOADED
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
                        java.util.concurrent.Executor r0 = r4.f35078a
                        androidx.credentials.CredentialManagerCallback r1 = r4.f35079b
                        androidx.credentials.CreateCredentialResponse r2 = r4.f35080c
                        androidx.credentials.playservices.controllers.CreateRestoreCredential.c r3 = new androidx.credentials.playservices.controllers.CreateRestoreCredential.c
                        r3.<init>(r1, r2)
                        r0.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1.AnonymousClass1.m323invoke():void");
                }
            }

            /* JADX INFO: renamed from: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            static final class AnonymousClass2 extends Lambda implements Function0<Unit> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ Executor f35081a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ CredentialManagerCallback f35082b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ Exception f35083c;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(Executor executor, CredentialManagerCallback credentialManagerCallback, Exception exc) {
                    super(0);
                    this.f35081a = executor;
                    this.f35082b = credentialManagerCallback;
                    this.f35083c = exc;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void d(CredentialManagerCallback credentialManagerCallback, Exception exc) {
                    credentialManagerCallback.a(new CreateCredentialUnknownException(exc.getMessage()));
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m324invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m324invoke() {
                    Executor executor = this.f35081a;
                    final CredentialManagerCallback credentialManagerCallback = this.f35082b;
                    final Exception exc = this.f35083c;
                    executor.execute(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE 
                          (r0v0 'executor' java.util.concurrent.Executor)
                          (wrap:java.lang.Runnable:0x0008: CONSTRUCTOR 
                          (r1v0 'credentialManagerCallback' androidx.credentials.CredentialManagerCallback A[DONT_INLINE])
                          (r2v0 'exc' java.lang.Exception A[DONT_INLINE])
                         A[MD:(androidx.credentials.CredentialManagerCallback, java.lang.Exception):void (m), WRAPPED] call: androidx.credentials.playservices.controllers.CreateRestoreCredential.d.<init>(androidx.credentials.CredentialManagerCallback, java.lang.Exception):void type: CONSTRUCTOR)
                         INTERFACE call: java.util.concurrent.Executor.execute(java.lang.Runnable):void A[MD:(java.lang.Runnable):void (c)] in method: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1.2.invoke():void, file: classes3.dex
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: androidx.credentials.playservices.controllers.CreateRestoreCredential.d, state: NOT_LOADED
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
                        java.util.concurrent.Executor r0 = r4.f35081a
                        androidx.credentials.CredentialManagerCallback r1 = r4.f35082b
                        java.lang.Exception r2 = r4.f35083c
                        androidx.credentials.playservices.controllers.CreateRestoreCredential.d r3 = new androidx.credentials.playservices.controllers.CreateRestoreCredential.d
                        r3.<init>(r1, r2)
                        r0.execute(r3)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.credentials.playservices.controllers.CreateRestoreCredential.CredentialProviderCreateRestoreCredentialController$invokePlayServices$1.AnonymousClass2.m324invoke():void");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(CreateRestoreCredentialResponse createRestoreCredentialResponse) {
                try {
                    CredentialProviderCreateRestoreCredentialController credentialProviderCreateRestoreCredentialController = this.f35074a;
                    Intrinsics.checkNotNull(createRestoreCredentialResponse);
                    CreateCredentialResponse createCredentialResponseM = credentialProviderCreateRestoreCredentialController.m(createRestoreCredentialResponse);
                    CredentialProviderController.Companion companion = CredentialProviderController.f35101f;
                    CredentialProviderController.e(cancellationSignal, new AnonymousClass1(executor, callback, createCredentialResponseM));
                } catch (Exception e3) {
                    CredentialProviderController.Companion companion2 = CredentialProviderController.f35101f;
                    CredentialProviderController.e(cancellationSignal, new AnonymousClass2(executor, callback, e3));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((CreateRestoreCredentialResponse) obj);
                return Unit.f139807a;
            }
        };
        taskE.addOnSuccessListener(new OnSuccessListener() { // from class: androidx.credentials.playservices.controllers.CreateRestoreCredential.a
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                CredentialProviderCreateRestoreCredentialController.o(function1, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: androidx.credentials.playservices.controllers.CreateRestoreCredential.b
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                CredentialProviderCreateRestoreCredentialController.p(cancellationSignal, executor, callback, exc);
            }
        });
    }
}
