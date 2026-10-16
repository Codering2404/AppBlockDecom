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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2", f = "UsageLimitDao_Impl.kt", l = {152}, m = "invokeSuspend", v = 1)
final class UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2 extends SuspendLambda implements Function1<Continuation<? super List<? extends UsageLimit>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f125282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UsageLimitDao_Impl f125283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Collection f125284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Collection f125285d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ UrlDto f125286f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2(UsageLimitDao_Impl usageLimitDao_Impl, Collection collection, Collection collection2, UrlDto urlDto, Continuation continuation) {
        super(1, continuation);
        this.f125283b = usageLimitDao_Impl;
        this.f125284c = collection;
        this.f125285d = collection2;
        this.f125286f = urlDto;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2(this.f125283b, this.f125284c, this.f125285d, this.f125286f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f125282a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        UsageLimitDao_Impl usageLimitDao_Impl = this.f125283b;
        Collection collection = this.f125284c;
        Collection collection2 = this.f125285d;
        UrlDto urlDto = this.f125286f;
        this.f125282a = 1;
        Object objP = super/*cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao*/.P(collection, collection2, urlDto, this);
        return objP == objF ? objF : objP;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((UsageLimitDao_Impl$getAllByProfileIdsPackageNamesAndUrl$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
