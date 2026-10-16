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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupProfilesUseCase", f = "GetBackupProfilesUseCase.kt", l = {46, 47, 57, 59, 64, 67, 69, 70}, m = "toDTO", v = 1)
final class GetBackupProfilesUseCase$toDTO$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f106635d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f106636f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f106637g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f106638h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f106639i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f106640j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f106641k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    /* synthetic */ Object f106642l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ GetBackupProfilesUseCase f106643m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f106644n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetBackupProfilesUseCase$toDTO$1(GetBackupProfilesUseCase getBackupProfilesUseCase, Continuation continuation) {
        super(continuation);
        this.f106643m = getBackupProfilesUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f106642l = obj;
        this.f106644n |= Integer.MIN_VALUE;
        return this.f106643m.l(null, null, this);
    }
}
