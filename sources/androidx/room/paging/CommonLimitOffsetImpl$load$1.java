package androidx.room.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

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
@DebugMetadata(c = "androidx.room.paging.CommonLimitOffsetImpl", f = "LimitOffsetPagingSource.kt", l = {102, 104}, m = "load")
final class CommonLimitOffsetImpl$load$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    /* synthetic */ Object f52689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CommonLimitOffsetImpl f52690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f52691c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CommonLimitOffsetImpl$load$1(CommonLimitOffsetImpl commonLimitOffsetImpl, Continuation continuation) {
        super(continuation);
        this.f52690b = commonLimitOffsetImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f52689a = obj;
        this.f52691c |= Integer.MIN_VALUE;
        return this.f52690b.l(null, this);
    }
}
