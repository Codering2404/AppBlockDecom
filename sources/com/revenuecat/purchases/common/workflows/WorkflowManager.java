package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.ErrorsKt;
import com.revenuecat.purchases.common.verification.SignatureVerificationException;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class WorkflowManager {
    private final Backend backend;
    private final CoroutineScope scope;
    private final WorkflowDetailResolver workflowDetailResolver;

    public WorkflowManager(Backend backend, WorkflowDetailResolver workflowDetailResolver, CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(workflowDetailResolver, "workflowDetailResolver");
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.backend = backend;
        this.workflowDetailResolver = workflowDetailResolver;
        this.scope = scope;
    }

    public final void close() {
        CoroutineScopeKt.e(this.scope, null, 1, null);
    }

    public final void getWorkflow(String appUserID, String workflowId, boolean z2, final Function1<? super WorkflowDataResult, Unit> onSuccess, final Function1<? super PurchasesError, Unit> onError) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(workflowId, "workflowId");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.backend.getWorkflow(appUserID, workflowId, z2, new Function1<WorkflowDetailResponse, Unit>() { // from class: com.revenuecat.purchases.common.workflows.WorkflowManager.getWorkflow.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.workflows.WorkflowManager$getWorkflow$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.revenuecat.purchases.common.workflows.WorkflowManager$getWorkflow$1$1", f = "WorkflowManager.kt", l = {41}, m = "invokeSuspend")
            static final class C01891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Function1<PurchasesError, Unit> $onError;
                final /* synthetic */ Function1<WorkflowDataResult, Unit> $onSuccess;
                final /* synthetic */ WorkflowDetailResponse $response;
                Object L$0;
                int label;
                final /* synthetic */ WorkflowManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C01891(Function1<? super WorkflowDataResult, Unit> function1, WorkflowManager workflowManager, WorkflowDetailResponse workflowDetailResponse, Function1<? super PurchasesError, Unit> function12, Continuation<? super C01891> continuation) {
                    super(2, continuation);
                    this.$onSuccess = function1;
                    this.this$0 = workflowManager;
                    this.$response = workflowDetailResponse;
                    this.$onError = function12;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C01891(this.$onSuccess, this.this$0, this.$response, this.$onError, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Function1<WorkflowDataResult, Unit> function1;
                    Object objF = IntrinsicsKt.f();
                    int i3 = this.label;
                    try {
                        if (i3 == 0) {
                            ResultKt.b(obj);
                            Function1<WorkflowDataResult, Unit> function12 = this.$onSuccess;
                            WorkflowDetailResolver workflowDetailResolver = this.this$0.workflowDetailResolver;
                            WorkflowDetailResponse workflowDetailResponse = this.$response;
                            this.L$0 = function12;
                            this.label = 1;
                            Object objResolve = workflowDetailResolver.resolve(workflowDetailResponse, this);
                            if (objResolve == objF) {
                                return objF;
                            }
                            function1 = function12;
                            obj = objResolve;
                        } else {
                            if (i3 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            function1 = (Function1) this.L$0;
                            ResultKt.b(obj);
                        }
                        function1.invoke(obj);
                    } catch (SignatureVerificationException e3) {
                        this.$onError.invoke(ErrorsKt.toPurchasesError(e3));
                    } catch (IOException e4) {
                        this.$onError.invoke(ErrorsKt.toPurchasesError(e4));
                    } catch (IllegalStateException e5) {
                        this.$onError.invoke(ErrorsKt.toPurchasesError(e5));
                    }
                    return Unit.f139807a;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C01891) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((WorkflowDetailResponse) obj);
                return Unit.f139807a;
            }

            public final void invoke(WorkflowDetailResponse response) {
                Intrinsics.checkNotNullParameter(response, "response");
                BuildersKt__Builders_commonKt.d(WorkflowManager.this.scope, null, null, new C01891(onSuccess, WorkflowManager.this, response, onError, null), 3, null);
            }
        }, onError);
    }

    public /* synthetic */ WorkflowManager(Backend backend, WorkflowDetailResolver workflowDetailResolver, CoroutineScope coroutineScope, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(backend, workflowDetailResolver, (i3 & 4) != 0 ? CoroutineScopeKt.a(SupervisorKt.b(null, 1, null).plus(Dispatchers.b())) : coroutineScope);
    }
}
