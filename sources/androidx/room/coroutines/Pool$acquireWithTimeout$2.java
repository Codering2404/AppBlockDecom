package androidx.room.coroutines;

import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "androidx.room.coroutines.Pool$acquireWithTimeout$2", f = "ConnectionPoolImpl.kt", l = {214}, m = "invokeSuspend")
final class Pool$acquireWithTimeout$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f52589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f52590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f52591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Pool f52592d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Pool$acquireWithTimeout$2(Ref.ObjectRef objectRef, Pool pool, Continuation continuation) {
        super(2, continuation);
        this.f52591c = objectRef;
        this.f52592d = pool;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new Pool$acquireWithTimeout$2(this.f52591c, this.f52592d, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((Pool$acquireWithTimeout$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Ref.ObjectRef objectRef;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f52590b;
        if (i3 != 0) {
            if (i3 == 1) {
                objectRef = (Ref.ObjectRef) this.f52589a;
                ResultKt.b(obj);
            } else {
                throw new IllegalStateException(tDEtWsFLJfe.cpbGTePGsAOpQAD);
            }
        } else {
            ResultKt.b(obj);
            Ref.ObjectRef objectRef2 = this.f52591c;
            Pool pool = this.f52592d;
            this.f52589a = objectRef2;
            this.f52590b = 1;
            Object objA = pool.a(this);
            if (objA == objF) {
                return objF;
            }
            objectRef = objectRef2;
            obj = objA;
        }
        objectRef.f140144a = obj;
        return Unit.f139807a;
    }
}
