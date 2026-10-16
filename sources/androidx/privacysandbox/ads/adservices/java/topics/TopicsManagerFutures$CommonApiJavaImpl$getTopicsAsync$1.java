package androidx.privacysandbox.ads.adservices.java.topics;

import androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsRequest;
import androidx.privacysandbox.ads.adservices.topics.GetTopicsResponse;
import androidx.privacysandbox.ads.adservices.topics.TopicsManager;
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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1", f = "TopicsManagerFutures.kt", l = {55}, m = "invokeSuspend")
final class TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super GetTopicsResponse>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f51311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TopicsManagerFutures.CommonApiJavaImpl f51312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GetTopicsRequest f51313c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(TopicsManagerFutures.CommonApiJavaImpl commonApiJavaImpl, GetTopicsRequest getTopicsRequest, Continuation continuation) {
        super(2, continuation);
        this.f51312b = commonApiJavaImpl;
        this.f51313c = getTopicsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1(this.f51312b, this.f51313c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f51311a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        TopicsManager topicsManager = this.f51312b.f51310b;
        GetTopicsRequest getTopicsRequest = this.f51313c;
        this.f51311a = 1;
        Object objA = topicsManager.a(getTopicsRequest, this);
        return objA == objF ? objF : objA;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TopicsManagerFutures$CommonApiJavaImpl$getTopicsAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
