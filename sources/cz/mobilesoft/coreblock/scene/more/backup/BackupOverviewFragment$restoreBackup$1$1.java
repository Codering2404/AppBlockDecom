package cz.mobilesoft.coreblock.scene.more.backup;

import cz.mobilesoft.coreblock.scene.more.backup.dto.BackupInfoDTO;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesRepository;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.backup.BackupOverviewFragment$restoreBackup$1$1", f = "BackupOverviewFragment.kt", l = {81}, m = "invokeSuspend", v = 1)
final class BackupOverviewFragment$restoreBackup$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f106419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BackupInfoDTO f106420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BackupOverviewFragment f106421c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupOverviewFragment$restoreBackup$1$1(BackupInfoDTO backupInfoDTO, BackupOverviewFragment backupOverviewFragment, Continuation continuation) {
        super(2, continuation);
        this.f106420b = backupInfoDTO;
        this.f106421c = backupOverviewFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackupOverviewFragment$restoreBackup$1$1(this.f106420b, this.f106421c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f106419a;
        if (i3 == 0) {
            ResultKt.b(obj);
            InAppUpdatesRepository inAppUpdatesRepository = InAppUpdatesRepository.f129855a;
            this.f106419a = 1;
            obj = inAppUpdatesRepository.B(this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (this.f106420b.d() <= 9) {
            this.f106421c.x0(this.f106420b);
        } else if (this.f106420b.d() > 9 || zBooleanValue) {
            this.f106421c.A0();
        } else {
            this.f106421c.x0(this.f106420b);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BackupOverviewFragment$restoreBackup$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
