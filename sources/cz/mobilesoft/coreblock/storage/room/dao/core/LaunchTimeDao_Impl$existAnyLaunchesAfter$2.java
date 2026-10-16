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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao_Impl$existAnyLaunchesAfter$2", f = "LaunchTimeDao_Impl.kt", l = {107}, m = "invokeSuspend", v = 1)
final class LaunchTimeDao_Impl$existAnyLaunchesAfter$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f126015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LaunchTimeDao_Impl f126016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f126017c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LaunchTimeDao_Impl$existAnyLaunchesAfter$2(LaunchTimeDao_Impl launchTimeDao_Impl, long j3, Continuation continuation) {
        super(1, continuation);
        this.f126016b = launchTimeDao_Impl;
        this.f126017c = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LaunchTimeDao_Impl$existAnyLaunchesAfter$2(this.f126016b, this.f126017c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f126015a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        LaunchTimeDao_Impl launchTimeDao_Impl = this.f126016b;
        long j3 = this.f126017c;
        this.f126015a = 1;
        Object objK = super/*cz.mobilesoft.coreblock.storage.room.dao.core.LaunchTimeDao*/.K(j3, this);
        return objK == objF ? objF : objK;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LaunchTimeDao_Impl$existAnyLaunchesAfter$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
