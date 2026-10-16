package cz.mobilesoft.coreblock.storage.room.dao.blocking;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2", f = "BlockedNotificationDao_Impl.kt", l = {179}, m = "invokeSuspend", v = 1)
final class BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BlockedNotificationDao_Impl f124985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ long f124986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f124987d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2(BlockedNotificationDao_Impl blockedNotificationDao_Impl, long j3, long j4, Continuation continuation) {
        super(1, continuation);
        this.f124985b = blockedNotificationDao_Impl;
        this.f124986c = j3;
        this.f124987d = j4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2(this.f124985b, this.f124986c, this.f124987d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f124984a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        BlockedNotificationDao_Impl blockedNotificationDao_Impl = this.f124985b;
        long j3 = this.f124986c;
        long j4 = this.f124987d;
        this.f124984a = 1;
        Object objN = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockedNotificationDao*/.N(j3, j4, this);
        return objN == objF ? objF : objN;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BlockedNotificationDao_Impl$getAppNamesSeparateByComma$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
