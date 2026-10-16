package cz.mobilesoft.coreblock.model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.tasks.TasksKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.model.RemoteConfig$initIfNeeded$2$1", f = "RemoteConfig.kt", l = {134, 135}, m = "invokeSuspend", v = 1)
final class RemoteConfig$initIfNeeded$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Void>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Task f97103b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FirebaseRemoteConfig f97104c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfig$initIfNeeded$2$1(Task task, FirebaseRemoteConfig firebaseRemoteConfig, Continuation continuation) {
        super(2, continuation);
        this.f97103b = task;
        this.f97104c = firebaseRemoteConfig;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteConfig$initIfNeeded$2$1(this.f97103b, this.f97104c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97102a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Task task = this.f97103b;
            this.f97102a = 1;
            if (TasksKt.b(task, this) != objF) {
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Task taskX = this.f97104c.x(RemoteConfig.f97069s);
        Intrinsics.checkNotNullExpressionValue(taskX, "setDefaultsAsync(...)");
        this.f97102a = 2;
        Object objB = TasksKt.b(taskX, this);
        return objB == objF ? objF : objB;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteConfig$initIfNeeded$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
