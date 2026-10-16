package cz.mobilesoft.coreblock.scene.more.backup.usecase;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreSettingsUseCase", f = "RestoreSettingsUseCase.kt", l = {31, 32, 34, 35, 36, 37, 38, 39, 40, 41, 43}, m = "invoke", v = 1)
final class RestoreSettingsUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f106850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f106851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    /* synthetic */ Object f106852d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ RestoreSettingsUseCase f106853f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f106854g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RestoreSettingsUseCase$invoke$1(RestoreSettingsUseCase restoreSettingsUseCase, Continuation continuation) {
        super(continuation);
        this.f106853f = restoreSettingsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f106852d = obj;
        this.f106854g |= Integer.MIN_VALUE;
        return this.f106853f.m(null, this);
    }
}
