package cz.mobilesoft.coreblock.storage.room.dao.blocking;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.IntervalDao", f = "IntervalDao.kt", l = {124, 126}, m = "enableAllByProfileIds$suspendImpl", v = 1)
final class IntervalDao$enableAllByProfileIds$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f125051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f125052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f125053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f125054d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ IntervalDao f125055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f125056g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntervalDao$enableAllByProfileIds$1(IntervalDao intervalDao, Continuation continuation) {
        super(continuation);
        this.f125055f = intervalDao;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f125054d = obj;
        this.f125056g |= Integer.MIN_VALUE;
        return IntervalDao.S(this.f125055f, null, this);
    }
}
