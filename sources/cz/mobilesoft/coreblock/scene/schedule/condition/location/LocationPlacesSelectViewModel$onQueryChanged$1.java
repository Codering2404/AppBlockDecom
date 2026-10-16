package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
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
import kotlinx.coroutines.Dispatchers;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationPlacesSelectViewModel$onQueryChanged$1", f = "LocationPlacesSelectViewModel.kt", l = {140}, m = "invokeSuspend", v = 1)
final class LocationPlacesSelectViewModel$onQueryChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f115479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f115480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f115481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f115482d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f115483f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private /* synthetic */ Object f115484g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ LocationPlacesSelectViewModel f115485h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ String f115486i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationPlacesSelectViewModel$onQueryChanged$1(LocationPlacesSelectViewModel locationPlacesSelectViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.f115485h = locationPlacesSelectViewModel;
        this.f115486i = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LocationPlacesSelectViewModel$onQueryChanged$1 locationPlacesSelectViewModel$onQueryChanged$1 = new LocationPlacesSelectViewModel$onQueryChanged$1(this.f115485h, this.f115486i, continuation);
        locationPlacesSelectViewModel$onQueryChanged$1.f115484g = obj;
        return locationPlacesSelectViewModel$onQueryChanged$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        LocationPlacesSelectViewModel locationPlacesSelectViewModel;
        Mutex mutex;
        String str;
        CoroutineScope coroutineScope = (CoroutineScope) this.f115484g;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115483f;
        if (i3 == 0) {
            ResultKt.b(obj);
            Mutex mutex2 = this.f115485h.f115472l;
            locationPlacesSelectViewModel = this.f115485h;
            String str2 = this.f115486i;
            this.f115484g = coroutineScope;
            this.f115479a = mutex2;
            this.f115480b = locationPlacesSelectViewModel;
            this.f115481c = str2;
            this.f115482d = 0;
            this.f115483f = 1;
            if (mutex2.f(null, this) == objF) {
                return objF;
            }
            mutex = mutex2;
            str = str2;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) this.f115481c;
            locationPlacesSelectViewModel = (LocationPlacesSelectViewModel) this.f115480b;
            Mutex mutex3 = (Mutex) this.f115479a;
            ResultKt.b(obj);
            mutex = mutex3;
        }
        LocationPlacesSelectViewModel locationPlacesSelectViewModel2 = locationPlacesSelectViewModel;
        try {
            locationPlacesSelectViewModel2.f115473m = BuildersKt__Builders_commonKt.d(coroutineScope, Dispatchers.c().plus(CoroutinesHelperExtKt.b()), null, new LocationPlacesSelectViewModel$onQueryChanged$1$1$1(locationPlacesSelectViewModel2, str, null), 2, null);
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
        return ((LocationPlacesSelectViewModel$onQueryChanged$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
