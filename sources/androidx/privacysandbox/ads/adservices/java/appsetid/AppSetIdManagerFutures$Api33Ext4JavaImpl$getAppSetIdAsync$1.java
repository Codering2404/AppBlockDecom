package androidx.privacysandbox.ads.adservices.java.appsetid;

import androidx.privacysandbox.ads.adservices.appsetid.AppSetId;
import androidx.privacysandbox.ads.adservices.appsetid.AppSetIdManager;
import androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.appsetid.AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1", f = "AppSetIdManagerFutures.kt", l = {49}, m = "invokeSuspend")
final class AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppSetId>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f51264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AppSetIdManagerFutures.Api33Ext4JavaImpl f51265b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(AppSetIdManagerFutures.Api33Ext4JavaImpl api33Ext4JavaImpl, Continuation continuation) {
        super(2, continuation);
        this.f51265b = api33Ext4JavaImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1(this.f51265b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f51264a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        AppSetIdManager appSetIdManager = this.f51265b.f51263b;
        this.f51264a = 1;
        Object objA = appSetIdManager.a(this);
        return objA == objF ? objF : objA;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AppSetIdManagerFutures$Api33Ext4JavaImpl$getAppSetIdAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
