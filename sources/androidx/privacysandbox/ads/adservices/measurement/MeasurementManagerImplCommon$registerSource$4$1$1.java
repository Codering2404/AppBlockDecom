package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.core.os.OutcomeReceiverKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
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
@DebugMetadata(c = "androidx.privacysandbox.ads.adservices.measurement.MeasurementManagerImplCommon$registerSource$4$1$1", f = "MeasurementManagerImplCommon.kt", l = {131}, m = "invokeSuspend")
final class MeasurementManagerImplCommon$registerSource$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f51328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f51329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f51330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f51331d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MeasurementManagerImplCommon f51332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Uri f51333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ SourceRegistrationRequest f51334h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MeasurementManagerImplCommon$registerSource$4$1$1(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, SourceRegistrationRequest sourceRegistrationRequest, Continuation continuation) {
        super(2, continuation);
        this.f51332f = measurementManagerImplCommon;
        this.f51333g = uri;
        this.f51334h = sourceRegistrationRequest;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MeasurementManagerImplCommon$registerSource$4$1$1(this.f51332f, this.f51333g, this.f51334h, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f51331d;
        if (i3 == 0) {
            ResultKt.b(obj);
            MeasurementManagerImplCommon measurementManagerImplCommon = this.f51332f;
            Uri uri = this.f51333g;
            SourceRegistrationRequest sourceRegistrationRequest = this.f51334h;
            this.f51328a = measurementManagerImplCommon;
            this.f51329b = uri;
            this.f51330c = sourceRegistrationRequest;
            this.f51331d = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(this), 1);
            cancellableContinuationImpl.C();
            measurementManagerImplCommon.i().registerSource(uri, sourceRegistrationRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
            Object objV = cancellableContinuationImpl.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(this);
            }
            if (objV == objF) {
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
        return ((MeasurementManagerImplCommon$registerSource$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
