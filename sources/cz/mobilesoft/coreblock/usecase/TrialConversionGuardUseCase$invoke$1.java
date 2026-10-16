package cz.mobilesoft.coreblock.usecase;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.TrialConversionGuardUseCase", f = "TrialConversionGuardUseCase.kt", l = {54, 57, 72, 80, 85, 120, 131}, m = "invoke", v = 1)
final class TrialConversionGuardUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f127445c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f127446d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f127447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f127448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f127449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f127450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f127451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f127452k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f127453l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    /* synthetic */ Object f127454m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ TrialConversionGuardUseCase f127455n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f127456o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrialConversionGuardUseCase$invoke$1(TrialConversionGuardUseCase trialConversionGuardUseCase, Continuation continuation) {
        super(continuation);
        this.f127455n = trialConversionGuardUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f127454m = obj;
        this.f127456o |= Integer.MIN_VALUE;
        return this.f127455n.c(null, this);
    }
}
