package cz.mobilesoft.coreblock.scene.more.backup.usecase;

import cz.mobilesoft.coreblock.repository.BackupsRepository;
import cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$invoke$2", f = "RestoreProfilesUseCase.kt", l = {81, 82, 102, 106, 114, 124, 136, 144, 149, 161, 172}, m = "invokeSuspend", v = 1)
final class RestoreProfilesUseCase$invoke$2 extends SuspendLambda implements Function1<Continuation<? super BackupsRepository.BackupRestoreSuccessDTO>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f106780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f106781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f106782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f106783d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    Object f106784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    Object f106785g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    Object f106786h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    Object f106787i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Object f106788j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    Object f106789k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    Object f106790l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    Object f106791m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    int f106792n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    int f106793o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f106794p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    int f106795q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    int f106796r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    long f106797s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    int f106798t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    final /* synthetic */ RestoreProfilesUseCase f106799u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ RestoreProfilesUseCase.Params f106800v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    final /* synthetic */ List f106801w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final /* synthetic */ List f106802x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RestoreProfilesUseCase$invoke$2(RestoreProfilesUseCase restoreProfilesUseCase, RestoreProfilesUseCase.Params params, List list, List list2, Continuation continuation) {
        super(1, continuation);
        this.f106799u = restoreProfilesUseCase;
        this.f106800v = params;
        this.f106801w = list;
        this.f106802x = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RestoreProfilesUseCase$invoke$2(this.f106799u, this.f106800v, this.f106801w, this.f106802x, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x062d, code lost:
    
        if (r1.t(r0, r32) == r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x023a, code lost:
    
        if (r1.w(r2, r0, r32) != r8) goto L23;
     */
    /* JADX WARN: Path cross not found for [B:65:0x041c, B:73:0x047d], limit reached: 184 */
    /* JADX WARN: Path cross not found for [B:73:0x047d, B:65:0x041c], limit reached: 184 */
    /* JADX WARN: Path cross not found for [B:95:0x055a, B:97:0x0560], limit reached: 184 */
    /* JADX WARN: Path cross not found for [B:97:0x0560, B:95:0x055a], limit reached: 184 */
    /* JADX WARN: Removed duplicated region for block: B:118:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x06f1  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x075b  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x07fe  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x089e  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0400  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x055a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:157:0x0897 -> B:158:0x0899). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:160:0x089e -> B:159:0x089b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 2290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.backup.usecase.RestoreProfilesUseCase$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((RestoreProfilesUseCase$invoke$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
