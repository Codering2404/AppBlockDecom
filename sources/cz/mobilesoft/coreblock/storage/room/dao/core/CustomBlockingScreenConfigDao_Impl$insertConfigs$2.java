package cz.mobilesoft.coreblock.storage.room.dao.core;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao_Impl$insertConfigs$2", f = "CustomBlockingScreenConfigDao_Impl.kt", l = {168}, m = "invokeSuspend", v = 1)
final class CustomBlockingScreenConfigDao_Impl$insertConfigs$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CustomBlockingScreenConfigDao_Impl f125861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f125862c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomBlockingScreenConfigDao_Impl$insertConfigs$2(CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl, List list, Continuation continuation) {
        super(1, continuation);
        this.f125861b = customBlockingScreenConfigDao_Impl;
        this.f125862c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new CustomBlockingScreenConfigDao_Impl$insertConfigs$2(this.f125861b, this.f125862c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125860a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CustomBlockingScreenConfigDao_Impl customBlockingScreenConfigDao_Impl = this.f125861b;
            List list = this.f125862c;
            this.f125860a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.core.CustomBlockingScreenConfigDao*/.M(list, this) == objF) {
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
        return ((CustomBlockingScreenConfigDao_Impl$insertConfigs$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
