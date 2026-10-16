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
@DebugMetadata(c = "cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao", f = "ApplicationDao.kt", l = {222, 232}, m = "clearAllCategories$suspendImpl", v = 1)
final class ApplicationDao$clearAllCategories$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f124875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f124876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f124877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f124878d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f124879f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f124880g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f124881h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f124882i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f124883j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f124884k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    /* synthetic */ Object f124885l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ApplicationDao f124886m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f124887n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ApplicationDao$clearAllCategories$1(ApplicationDao applicationDao, Continuation continuation) {
        super(continuation);
        this.f124886m = applicationDao;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f124885l = obj;
        this.f124887n |= Integer.MIN_VALUE;
        return ApplicationDao.K(this.f124886m, null, this);
    }
}
