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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.GetBackupSettingsUseCase", f = "GetBackupSettingsUseCase.kt", l = {31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42}, m = "invoke", v = 1)
final class GetBackupSettingsUseCase$invoke$1 extends ContinuationImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f106685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f106686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f106687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f106688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    boolean f106689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f106690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f106691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    int f106692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    int f106693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    /* synthetic */ Object f106694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ GetBackupSettingsUseCase f106695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f106696p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetBackupSettingsUseCase$invoke$1(GetBackupSettingsUseCase getBackupSettingsUseCase, Continuation continuation) {
        super(continuation);
        this.f106695o = getBackupSettingsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f106694n = obj;
        this.f106696p |= Integer.MIN_VALUE;
        return this.f106695o.s(null, this);
    }
}
