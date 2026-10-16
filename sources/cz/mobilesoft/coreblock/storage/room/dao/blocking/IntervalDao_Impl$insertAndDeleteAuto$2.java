package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao_Impl$insertAndDeleteAuto$2", f = "IntervalDao_Impl.kt", l = {162}, m = "invokeSuspend", v = 1)
final class IntervalDao_Impl$insertAndDeleteAuto$2 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IntervalDao_Impl f125082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Interval f125083c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntervalDao_Impl$insertAndDeleteAuto$2(IntervalDao_Impl intervalDao_Impl, Interval interval, Continuation continuation) {
        super(1, continuation);
        this.f125082b = intervalDao_Impl;
        this.f125083c = interval;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new IntervalDao_Impl$insertAndDeleteAuto$2(this.f125082b, this.f125083c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125081a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        IntervalDao_Impl intervalDao_Impl = this.f125082b;
        Interval interval = this.f125083c;
        this.f125081a = 1;
        Object objZ = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao*/.Z(interval, this);
        return objZ == objF ? objF : objZ;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((IntervalDao_Impl$insertAndDeleteAuto$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
