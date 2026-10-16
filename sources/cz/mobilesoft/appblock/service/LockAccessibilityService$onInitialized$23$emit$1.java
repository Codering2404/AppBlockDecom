package cz.mobilesoft.appblock.service;

import cz.mobilesoft.appblock.service.LockAccessibilityService;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$onInitialized$23", f = "LockAccessibilityService.kt", l = {708}, m = "emit", v = 1)
final class LockAccessibilityService$onInitialized$23$emit$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f94326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f94327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService.AnonymousClass23 f94328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f94329d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$onInitialized$23$emit$1(LockAccessibilityService.AnonymousClass23 anonymousClass23, Continuation continuation) {
        super(continuation);
        this.f94328c = anonymousClass23;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f94327b = obj;
        this.f94329d |= Integer.MIN_VALUE;
        return this.f94328c.a(0L, this);
    }
}
