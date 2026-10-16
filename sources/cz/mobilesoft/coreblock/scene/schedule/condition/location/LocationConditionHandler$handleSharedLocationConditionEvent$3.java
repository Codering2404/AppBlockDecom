package cz.mobilesoft.coreblock.scene.schedule.condition.location;

import cz.mobilesoft.coreblock.scene.schedule.condition.time.LocationConfigurationViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$handleSharedLocationConditionEvent$3", f = "LocationConditionScreenViewModel.kt", l = {229}, m = "invokeSuspend", v = 1)
final class LocationConditionHandler$handleSharedLocationConditionEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f115335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f115336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocationConditionHandler f115337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Boolean f115338d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$handleSharedLocationConditionEvent$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.condition.location.LocationConditionHandler$handleSharedLocationConditionEvent$3$1", f = "LocationConditionScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f115339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocationConditionHandler f115340b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LocationConditionHandler locationConditionHandler, Continuation continuation) {
            super(2, continuation);
            this.f115340b = locationConditionHandler;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f115340b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f115339a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f115340b.D();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LocationConditionHandler$handleSharedLocationConditionEvent$3(LocationConditionHandler locationConditionHandler, Boolean bool, Continuation continuation) {
        super(2, continuation);
        this.f115337c = locationConditionHandler;
        this.f115338d = bool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LocationConditionHandler$handleSharedLocationConditionEvent$3(this.f115337c, this.f115338d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f115336b;
        if (i3 == 0) {
            ResultKt.b(obj);
            boolean zS = this.f115337c.S();
            LocationConditionHandler locationConditionHandler = this.f115337c;
            locationConditionHandler.f0(LocationConfigurationViewState.d(locationConditionHandler.o(), 0, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Boxing.a(zS), null, null, null, null, 8126463, null));
            if (!Intrinsics.areEqual(this.f115338d, Boxing.a(false)) && !zS) {
                MainCoroutineDispatcher mainCoroutineDispatcherC = Dispatchers.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f115337c, null);
                this.f115335a = zS;
                this.f115336b = 1;
                if (BuildersKt.g(mainCoroutineDispatcherC, anonymousClass1, this) == objF) {
                    return objF;
                }
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
        return ((LocationConditionHandler$handleSharedLocationConditionEvent$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
