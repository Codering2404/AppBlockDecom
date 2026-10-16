package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
final class DataStoreImpl$readDataOrHandleCorruption$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f35654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Ref.IntRef f35656f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataOrHandleCorruption$3(Ref.ObjectRef objectRef, DataStoreImpl dataStoreImpl, Ref.IntRef intRef, Continuation continuation) {
        super(1, continuation);
        this.f35654c = objectRef;
        this.f35655d = dataStoreImpl;
        this.f35656f = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.f35654c, this.f35655d, this.f35656f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.IntRef intRef;
        Ref.ObjectRef objectRef;
        Ref.IntRef intRef2;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f35653b;
        try {
        } catch (CorruptionException unused) {
            Ref.IntRef intRef3 = this.f35656f;
            DataStoreImpl dataStoreImpl = this.f35655d;
            Object obj2 = this.f35654c.f140144a;
            this.f35652a = intRef3;
            this.f35653b = 3;
            Object objB = dataStoreImpl.B(obj2, true, this);
            if (objB != objF) {
                intRef = intRef3;
                obj = objB;
            }
            return objF;
        }
        if (i3 == 0) {
            ResultKt.b(obj);
            objectRef = this.f35654c;
            DataStoreImpl dataStoreImpl2 = this.f35655d;
            this.f35652a = objectRef;
            this.f35653b = 1;
            obj = dataStoreImpl2.x(this);
            if (obj == objF) {
            }
            return objF;
        }
        if (i3 != 1) {
            if (i3 == 2) {
                intRef2 = (Ref.IntRef) this.f35652a;
                ResultKt.b(obj);
                intRef2.f140142a = ((Number) obj).intValue();
                return Unit.f139807a;
            }
            if (i3 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            intRef = (Ref.IntRef) this.f35652a;
            ResultKt.b(obj);
            intRef.f140142a = ((Number) obj).intValue();
            return Unit.f139807a;
        }
        objectRef = (Ref.ObjectRef) this.f35652a;
        ResultKt.b(obj);
        objectRef.f140144a = obj;
        intRef2 = this.f35656f;
        InterProcessCoordinator interProcessCoordinatorR = this.f35655d.r();
        this.f35652a = intRef2;
        this.f35653b = 2;
        obj = interProcessCoordinatorR.a(this);
        if (obj == objF) {
            return objF;
        }
        intRef2.f140142a = ((Number) obj).intValue();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
