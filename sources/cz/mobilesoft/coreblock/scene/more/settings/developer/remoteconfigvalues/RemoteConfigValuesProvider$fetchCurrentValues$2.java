package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesProvider$fetchCurrentValues$2", f = "RemoteConfigValuesProvider.kt", l = {25}, m = "invokeSuspend", v = 1)
final class RemoteConfigValuesProvider$fetchCurrentValues$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Void>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ FirebaseRemoteConfig f109288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FirebaseRemoteConfigSettings f109289c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RemoteConfigValuesProvider$fetchCurrentValues$2(FirebaseRemoteConfig firebaseRemoteConfig, FirebaseRemoteConfigSettings firebaseRemoteConfigSettings, Continuation continuation) {
        super(2, continuation);
        this.f109288b = firebaseRemoteConfig;
        this.f109289c = firebaseRemoteConfigSettings;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new RemoteConfigValuesProvider$fetchCurrentValues$2(this.f109288b, this.f109289c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f109287a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Task taskV = this.f109288b.v(this.f109289c);
        Intrinsics.checkNotNullExpressionValue(taskV, "setConfigSettingsAsync(...)");
        this.f109287a = 1;
        Object objB = TasksKt.b(taskV, this);
        return objB == objF ? objF : objB;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((RemoteConfigValuesProvider$fetchCurrentValues$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
