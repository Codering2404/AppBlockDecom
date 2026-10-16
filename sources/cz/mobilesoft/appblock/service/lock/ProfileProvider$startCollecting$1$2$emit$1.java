package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.ProfileProvider$startCollecting$1$2", f = "ProfileProvider.kt", l = {139}, m = "emit", v = 1)
final class ProfileProvider$startCollecting$1$2$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f94907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProfileProvider$startCollecting$1.AnonymousClass2 f94908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f94909d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileProvider$startCollecting$1$2$emit$1(ProfileProvider$startCollecting$1.AnonymousClass2 anonymousClass2, Continuation continuation) {
        super(continuation);
        this.f94908c = anonymousClass2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f94907b = obj;
        this.f94909d |= Integer.MIN_VALUE;
        return this.f94908c.emit(null, this);
    }
}
