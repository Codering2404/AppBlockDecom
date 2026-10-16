package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1", f = "LocationPlacesSelectViewModel.kt", l = {140}, m = "invokeSuspend", v = 1)
final class LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f115476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f115477d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ LocationPlacesSelectViewModel f115478f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1(LocationPlacesSelectViewModel locationPlacesSelectViewModel, Continuation continuation) {
        super(2, continuation);
        this.f115478f = locationPlacesSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1(this.f115478f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Mutex mutex;
        LocationPlacesSelectViewModel locationPlacesSelectViewModel;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115477d;
        if (i3 == 0) {
            ResultKt.b(obj);
            mutex = this.f115478f.f115472l;
            LocationPlacesSelectViewModel locationPlacesSelectViewModel2 = this.f115478f;
            this.f115474a = mutex;
            this.f115475b = locationPlacesSelectViewModel2;
            this.f115476c = 0;
            this.f115477d = 1;
            if (mutex.f(null, this) == objF) {
                return objF;
            }
            locationPlacesSelectViewModel = locationPlacesSelectViewModel2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            locationPlacesSelectViewModel = (LocationPlacesSelectViewModel) this.f115475b;
            mutex = (Mutex) this.f115474a;
            ResultKt.b(obj);
        }
        try {
            Job job = locationPlacesSelectViewModel.f115473m;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
                locationPlacesSelectViewModel.f115473m = null;
            }
            Unit unit = Unit.f139807a;
            mutex.i(null);
            return Unit.f139807a;
        } catch (Throwable th) {
            mutex.i(null);
            throw th;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LocationPlacesSelectViewModel$cancelDelayJobIfNeeded$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
