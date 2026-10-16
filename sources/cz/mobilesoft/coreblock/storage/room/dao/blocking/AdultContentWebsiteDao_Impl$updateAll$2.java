package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.storage.room.management.BlockingDatabase;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao_Impl$updateAll$2", f = "AdultContentWebsiteDao_Impl.kt", l = {112}, m = "invokeSuspend", v = 1)
final class AdultContentWebsiteDao_Impl$updateAll$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f124839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdultContentWebsiteDao_Impl f124840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BlockingDatabase f124841c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f124842d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f124843f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f124844g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AdultContentWebsiteDao_Impl$updateAll$2(AdultContentWebsiteDao_Impl adultContentWebsiteDao_Impl, BlockingDatabase blockingDatabase, List list, List list2, List list3, Continuation continuation) {
        super(1, continuation);
        this.f124840b = adultContentWebsiteDao_Impl;
        this.f124841c = blockingDatabase;
        this.f124842d = list;
        this.f124843f = list2;
        this.f124844g = list3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AdultContentWebsiteDao_Impl$updateAll$2(this.f124840b, this.f124841c, this.f124842d, this.f124843f, this.f124844g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f124839a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AdultContentWebsiteDao_Impl adultContentWebsiteDao_Impl = this.f124840b;
            BlockingDatabase blockingDatabase = this.f124841c;
            List list = this.f124842d;
            List list2 = this.f124843f;
            List list3 = this.f124844g;
            this.f124839a = 1;
            if (super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.AdultContentWebsiteDao*/.N(blockingDatabase, list, list2, list3, this) == objF) {
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
        return ((AdultContentWebsiteDao_Impl$updateAll$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
