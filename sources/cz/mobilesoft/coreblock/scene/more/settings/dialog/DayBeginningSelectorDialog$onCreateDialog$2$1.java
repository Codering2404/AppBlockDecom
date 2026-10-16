package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import android.content.Context;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$onCreateDialog$2$1", f = "DayBeginningSelectorDialog.kt", l = {61, 62}, m = "invokeSuspend", v = 1)
final class DayBeginningSelectorDialog$onCreateDialog$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DayBeginningSelectorDialog f109555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f109556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f109557d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DayBeginningSelectorDialog$onCreateDialog$2$1(DayBeginningSelectorDialog dayBeginningSelectorDialog, int i3, Context context, Continuation continuation) {
        super(1, continuation);
        this.f109555b = dayBeginningSelectorDialog;
        this.f109556c = i3;
        this.f109557d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DayBeginningSelectorDialog$onCreateDialog$2$1(this.f109555b, this.f109556c, this.f109557d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0046, code lost:
    
        if (r6.J0(r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f109554a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L49
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L38
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog r6 = r5.f109555b
            cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao r6 = cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog.C(r6)
            cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog r1 = r5.f109555b
            int r1 = cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog.B(r1)
            int r4 = r5.f109556c
            r5.f109554a = r3
            java.lang.Object r6 = r6.Y(r1, r4, r5)
            if (r6 != r0) goto L38
            goto L48
        L38:
            cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog r6 = r5.f109555b
            cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore r6 = cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog.A(r6)
            int r1 = r5.f109556c
            r5.f109554a = r2
            java.lang.Object r6 = r6.J0(r1, r5)
            if (r6 != r0) goto L49
        L48:
            return r0
        L49:
            android.content.Intent r6 = new android.content.Intent
            java.lang.String r0 = "cz.mobilesoft.appblock.USAGE_LIMIT_SETTINGS_CHANGED"
            r6.<init>(r0)
            java.lang.String r0 = cz.mobilesoft.coreblock.LockieApplication.f95360f
            r6.setPackage(r0)
            java.lang.String r0 = "DAY_BEGINNING_HOUR"
            int r1 = r5.f109556c
            r6.putExtra(r0, r1)
            android.content.Context r0 = r5.f109557d
            r0.sendBroadcast(r6)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog$onCreateDialog$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DayBeginningSelectorDialog$onCreateDialog$2$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
