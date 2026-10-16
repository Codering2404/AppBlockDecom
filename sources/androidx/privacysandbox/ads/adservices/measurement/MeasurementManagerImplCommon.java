package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.core.os.OutcomeReceiverKt;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;

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
public class MeasurementManagerImplCommon extends MeasurementManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final android.adservices.measurement.MeasurementManager f51323b;

    public MeasurementManagerImplCommon(android.adservices.measurement.MeasurementManager mMeasurementManager) {
        Intrinsics.checkNotNullParameter(mMeasurementManager, "mMeasurementManager");
        this.f51323b = mMeasurementManager;
    }

    static /* synthetic */ Object h(MeasurementManagerImplCommon measurementManagerImplCommon, DeletionRequest deletionRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().deleteRegistrations(deletionRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    static /* synthetic */ Object j(MeasurementManagerImplCommon measurementManagerImplCommon, Continuation<? super Integer> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().getMeasurementApiStatus(new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    static /* synthetic */ Object k(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().registerSource(uri, inputEvent, new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @ExperimentalFeatures.RegisterSourceOptIn
    static /* synthetic */ Object l(MeasurementManagerImplCommon measurementManagerImplCommon, SourceRegistrationRequest sourceRegistrationRequest, Continuation<? super Unit> continuation) {
        Object objF = CoroutineScopeKt.f(new MeasurementManagerImplCommon$registerSource$4(sourceRegistrationRequest, measurementManagerImplCommon, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    static /* synthetic */ Object m(MeasurementManagerImplCommon measurementManagerImplCommon, Uri uri, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().registerTrigger(uri, new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    static /* synthetic */ Object n(MeasurementManagerImplCommon measurementManagerImplCommon, WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().registerWebSource(webSourceRegistrationRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    static /* synthetic */ Object o(MeasurementManagerImplCommon measurementManagerImplCommon, WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        measurementManagerImplCommon.i().registerWebTrigger(webTriggerRegistrationRequest.a(), new androidx.credentials.c(), OutcomeReceiverKt.a(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object a(DeletionRequest deletionRequest, Continuation<? super Unit> continuation) {
        return h(this, deletionRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object b(Continuation<? super Integer> continuation) {
        return j(this, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object c(Uri uri, InputEvent inputEvent, Continuation<? super Unit> continuation) {
        return k(this, uri, inputEvent, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    @ExperimentalFeatures.RegisterSourceOptIn
    public Object d(SourceRegistrationRequest sourceRegistrationRequest, Continuation<? super Unit> continuation) {
        return l(this, sourceRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object e(Uri uri, Continuation<? super Unit> continuation) {
        return m(this, uri, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object f(WebSourceRegistrationRequest webSourceRegistrationRequest, Continuation<? super Unit> continuation) {
        return n(this, webSourceRegistrationRequest, continuation);
    }

    @Override // androidx.privacysandbox.ads.adservices.measurement.MeasurementManager
    public Object g(WebTriggerRegistrationRequest webTriggerRegistrationRequest, Continuation<? super Unit> continuation) {
        return o(this, webTriggerRegistrationRequest, continuation);
    }

    protected final android.adservices.measurement.MeasurementManager i() {
        return this.f51323b;
    }
}
