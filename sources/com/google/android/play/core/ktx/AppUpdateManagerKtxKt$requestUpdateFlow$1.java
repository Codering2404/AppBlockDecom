package com.google.android.play.core.ktx;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallException;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.ktx.AppUpdateResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@DebugMetadata(c = "com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1", f = "AppUpdateManagerKtx.kt", l = {90}, m = "invokeSuspend")
final class AppUpdateManagerKtxKt$requestUpdateFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super AppUpdateResult>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f83083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f83084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppUpdateManager f83085c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppUpdateManagerKtxKt$requestUpdateFlow$1(AppUpdateManager appUpdateManager, Continuation continuation) {
        super(2, continuation);
        this.f83085c = appUpdateManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AppUpdateManagerKtxKt$requestUpdateFlow$1 appUpdateManagerKtxKt$requestUpdateFlow$1 = new AppUpdateManagerKtxKt$requestUpdateFlow$1(this.f83085c, continuation);
        appUpdateManagerKtxKt$requestUpdateFlow$1.f83084b = obj;
        return appUpdateManagerKtxKt$requestUpdateFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((AppUpdateManagerKtxKt$requestUpdateFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f83083a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ProducerScope producerScope = (ProducerScope) this.f83084b;
            final AppUpdateManager appUpdateManager = this.f83085c;
            final AppUpdatePassthroughListener appUpdatePassthroughListener = new AppUpdatePassthroughListener(new InstallStateUpdatedListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$1
                @Override // com.google.android.play.core.listener.StateUpdatedListener
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final void a(InstallState installState) {
                    Intrinsics.checkNotNullParameter(installState, "installState");
                    if (installState.c() == 11) {
                        AppUpdateManagerKtxKt.d(producerScope, new AppUpdateResult.Downloaded(appUpdateManager));
                    } else {
                        AppUpdateManagerKtxKt.d(producerScope, new AppUpdateResult.InProgress(installState));
                    }
                }
            }, new Function1<AppUpdatePassthroughListener, Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1$globalUpdateListener$2
                {
                    super(1);
                }

                public final void c(AppUpdatePassthroughListener $receiver) {
                    Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                    SendChannel.DefaultImpls.a(producerScope, null, 1, null);
                }

                @Override // kotlin.jvm.functions.Function1
                public final /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((AppUpdatePassthroughListener) obj2);
                    return Unit.f139807a;
                }
            });
            Task taskA = this.f83085c.a();
            final AppUpdateManager appUpdateManager2 = this.f83085c;
            taskA.addOnSuccessListener(new OnSuccessListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.1
                @Override // com.google.android.gms.tasks.OnSuccessListener
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final void onSuccess(AppUpdateInfo updateInfo) {
                    int iF = updateInfo.f();
                    if (iF == 0) {
                        producerScope.w(new InstallException(-2));
                        return;
                    }
                    if (iF == 1) {
                        AppUpdateManagerKtxKt.d(producerScope, AppUpdateResult.NotAvailable.f83106a);
                        SendChannel.DefaultImpls.a(producerScope, null, 1, null);
                    } else if (iF == 2 || iF == 3) {
                        Intrinsics.checkNotNullExpressionValue(updateInfo, "updateInfo");
                        if (updateInfo.c() == 11) {
                            AppUpdateManagerKtxKt.d(producerScope, new AppUpdateResult.Downloaded(appUpdateManager2));
                            SendChannel.DefaultImpls.a(producerScope, null, 1, null);
                        } else {
                            appUpdateManager2.b(appUpdatePassthroughListener);
                            AppUpdateManagerKtxKt.d(producerScope, new AppUpdateResult.Available(appUpdateManager2, updateInfo));
                        }
                    }
                }
            }).addOnFailureListener(new OnFailureListener() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.2
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exception) {
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    producerScope.w(exception);
                }
            });
            final AppUpdateManager appUpdateManager3 = this.f83085c;
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.google.android.play.core.ktx.AppUpdateManagerKtxKt$requestUpdateFlow$1.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Object invoke() {
                    m372invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m372invoke() {
                    appUpdateManager3.d(appUpdatePassthroughListener);
                }
            };
            this.f83083a = 1;
            if (ProduceKt.a(producerScope, function0, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
