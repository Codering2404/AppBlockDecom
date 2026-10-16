package cz.mobilesoft.coreblock.util.superwall;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.superwall.SuperwallOnboardingSplit", f = "SuperwallOnboardingSplit.kt", l = {60, 61}, m = "shouldUseSuperwall", v = 1)
final class SuperwallOnboardingSplit$shouldUseSuperwall$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f129746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f129747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f129748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f129749d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    /* synthetic */ Object f129750f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ SuperwallOnboardingSplit f129751g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f129752h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuperwallOnboardingSplit$shouldUseSuperwall$1(SuperwallOnboardingSplit superwallOnboardingSplit, Continuation continuation) {
        super(continuation);
        this.f129751g = superwallOnboardingSplit;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f129750f = obj;
        this.f129752h |= Integer.MIN_VALUE;
        return this.f129751g.a(null, null, this);
    }
}
