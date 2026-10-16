package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$3", f = "DataStoreImpl.kt", l = {298, 300}, m = "invokeSuspend")
final class DataStoreImpl$readDataAndUpdateCache$3<T> extends SuspendLambda implements Function1<Continuation<? super Pair<? extends State<T>, ? extends Boolean>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataStoreImpl f35632c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DataStoreImpl$readDataAndUpdateCache$3(DataStoreImpl dataStoreImpl, Continuation continuation) {
        super(1, continuation);
        this.f35632c = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DataStoreImpl$readDataAndUpdateCache$3(this.f35632c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Throwable th;
        State readException;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f35631b;
        try {
        } catch (Throwable th2) {
            InterProcessCoordinator interProcessCoordinatorR = this.f35632c.r();
            this.f35630a = th2;
            this.f35631b = 2;
            Object objA = interProcessCoordinatorR.a(this);
            if (objA != objF) {
                th = th2;
                obj = objA;
            }
            return objF;
        }
        if (i3 == 0) {
            ResultKt.b(obj);
            DataStoreImpl dataStoreImpl = this.f35632c;
            this.f35631b = 1;
            obj = dataStoreImpl.y(true, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) this.f35630a;
                ResultKt.b(obj);
                readException = new ReadException(th, ((Number) obj).intValue());
                return TuplesKt.a(readException, Boxing.a(true));
            }
            ResultKt.b(obj);
        }
        readException = (State) obj;
        return TuplesKt.a(readException, Boxing.a(true));
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DataStoreImpl$readDataAndUpdateCache$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
