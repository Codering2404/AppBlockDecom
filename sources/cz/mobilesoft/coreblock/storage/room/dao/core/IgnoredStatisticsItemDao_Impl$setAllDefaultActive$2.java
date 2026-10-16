package cz.mobilesoft.coreblock.storage.room.dao.core;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2", f = "IgnoredStatisticsItemDao_Impl.kt", l = {196}, m = "invokeSuspend", v = 1)
final class IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IgnoredStatisticsItemDao_Impl f125999b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ boolean f126000c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2(IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f125999b = ignoredStatisticsItemDao_Impl;
        this.f126000c = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2(this.f125999b, this.f126000c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125998a;
        if (i3 == 0) {
            ResultKt.b(obj);
            IgnoredStatisticsItemDao_Impl ignoredStatisticsItemDao_Impl = this.f125999b;
            boolean z2 = this.f126000c;
            this.f125998a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.core.IgnoredStatisticsItemDao*/.v0(z2, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((IgnoredStatisticsItemDao_Impl$setAllDefaultActive$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
