package androidx.privacysandbox.ads.adservices.java.signals;

import androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures;
import androidx.privacysandbox.ads.adservices.signals.ProtectedSignalsManager;
import androidx.privacysandbox.ads.adservices.signals.UpdateSignalsRequest;
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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.java.signals.ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1", f = "ProtectedSignalsManagerFutures.kt", l = {111}, m = "invokeSuspend")
final class ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f51306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProtectedSignalsManagerFutures.JavaImpl f51307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UpdateSignalsRequest f51308c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(ProtectedSignalsManagerFutures.JavaImpl javaImpl, UpdateSignalsRequest updateSignalsRequest, Continuation continuation) {
        super(2, continuation);
        this.f51307b = javaImpl;
        this.f51308c = updateSignalsRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1(this.f51307b, this.f51308c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f51306a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ProtectedSignalsManager protectedSignalsManager = this.f51307b.f51305b;
            Intrinsics.checkNotNull(protectedSignalsManager);
            UpdateSignalsRequest updateSignalsRequest = this.f51308c;
            this.f51306a = 1;
            if (protectedSignalsManager.a(updateSignalsRequest, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProtectedSignalsManagerFutures$JavaImpl$updateSignalsAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
