package cz.mobilesoft.coreblock.storage.room.dao.blocking;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
import java.util.Collection;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl$getAllForCurrentPeriod$2", f = "UsageLimitDao_Impl.kt", l = {161}, m = "invokeSuspend", v = 1)
final class UsageLimitDao_Impl$getAllForCurrentPeriod$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends UsageLimit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UsageLimitDao_Impl f125288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f125289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f125290d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Collection f125291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ UrlDto f125292g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitDao_Impl$getAllForCurrentPeriod$2(UsageLimitDao_Impl usageLimitDao_Impl, List list, long j3, Collection collection, UrlDto urlDto, Continuation continuation) {
        super(1, continuation);
        this.f125288b = usageLimitDao_Impl;
        this.f125289c = list;
        this.f125290d = j3;
        this.f125291f = collection;
        this.f125292g = urlDto;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new UsageLimitDao_Impl$getAllForCurrentPeriod$2(this.f125288b, this.f125289c, this.f125290d, this.f125291f, this.f125292g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125287a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        UsageLimitDao_Impl usageLimitDao_Impl = this.f125288b;
        List list = this.f125289c;
        long j3 = this.f125290d;
        Collection collection = this.f125291f;
        UrlDto urlDto = this.f125292g;
        this.f125287a = 1;
        Object objT = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao*/.T(list, j3, collection, urlDto, this);
        return objT == objF ? objF : objT;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((UsageLimitDao_Impl$getAllForCurrentPeriod$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
