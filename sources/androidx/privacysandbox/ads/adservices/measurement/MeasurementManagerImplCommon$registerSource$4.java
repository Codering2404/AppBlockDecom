package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4", f = "MeasurementManagerImplCommon.kt", l = {}, m = "invokeSuspend")
final class MeasurementManagerImplCommon$registerSource$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f51324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f51325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SourceRegistrationRequest f51326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MeasurementManagerImplCommon f51327d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MeasurementManagerImplCommon$registerSource$4(SourceRegistrationRequest sourceRegistrationRequest, MeasurementManagerImplCommon measurementManagerImplCommon, Continuation continuation) {
        super(2, continuation);
        this.f51326c = sourceRegistrationRequest;
        this.f51327d = measurementManagerImplCommon;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MeasurementManagerImplCommon$registerSource$4 measurementManagerImplCommon$registerSource$4 = new MeasurementManagerImplCommon$registerSource$4(this.f51326c, this.f51327d, continuation);
        measurementManagerImplCommon$registerSource$4.f51325b = obj;
        return measurementManagerImplCommon$registerSource$4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f51324a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CoroutineScope coroutineScope = (CoroutineScope) this.f51325b;
        List listB = this.f51326c.b();
        MeasurementManagerImplCommon measurementManagerImplCommon = this.f51327d;
        SourceRegistrationRequest sourceRegistrationRequest = this.f51326c;
        Iterator it = listB.iterator();
        while (it.hasNext()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new MeasurementManagerImplCommon$registerSource$4$1$1(measurementManagerImplCommon, (Uri) it.next(), sourceRegistrationRequest, null), 3, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MeasurementManagerImplCommon$registerSource$4) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
