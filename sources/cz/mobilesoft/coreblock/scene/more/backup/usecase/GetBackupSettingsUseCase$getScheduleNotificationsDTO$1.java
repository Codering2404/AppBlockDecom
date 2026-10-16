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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase", f = "GetBackupSettingsUseCase.kt", l = {57, 58, 59, 60, 61, 62}, m = "getScheduleNotificationsDTO", v = 1)
final class GetBackupSettingsUseCase$getScheduleNotificationsDTO$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f106671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f106672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f106673d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f106674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    /* synthetic */ Object f106675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ GetBackupSettingsUseCase f106676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f106677i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetBackupSettingsUseCase$getScheduleNotificationsDTO$1(GetBackupSettingsUseCase getBackupSettingsUseCase, Continuation continuation) {
        super(continuation);
        this.f106676h = getBackupSettingsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f106675g = obj;
        this.f106677i |= Integer.MIN_VALUE;
        return this.f106676h.q(this);
    }
}
