package cz.mobilesoft.coreblock.scene.more.settings.dialog;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$onPositiveButtonClicked$2", f = "EventTimePickerDialogFragment.kt", l = {111, 112}, m = "invokeSuspend", v = 1)
final class EventTimePickerDialogFragment$onPositiveButtonClicked$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EventTimePickerDialogFragment f109579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f109580c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventTimePickerDialogFragment$onPositiveButtonClicked$2(EventTimePickerDialogFragment eventTimePickerDialogFragment, int i3, Continuation continuation) {
        super(1, continuation);
        this.f109579b = eventTimePickerDialogFragment;
        this.f109580c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new EventTimePickerDialogFragment$onPositiveButtonClicked$2(this.f109579b, this.f109580c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
    
        if (r5.j(r1, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f109578a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L4e
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L32
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment r5 = r4.f109579b
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r5 = cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment.G(r5)
            int r1 = r4.f109580c
            r4.f109578a = r3
            java.lang.Object r5 = r5.n0(r1, r4)
            if (r5 != r0) goto L32
            goto L4d
        L32:
            cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment r5 = r4.f109579b
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r5 = cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment.H(r5)
            android.content.Context r1 = cz.mobilesoft.coreblock.LockieApplication.g()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r3 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            r4.f109578a = r2
            java.lang.Object r5 = r5.j(r1, r4)
            if (r5 != r0) goto L4e
        L4d:
            return r0
        L4e:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$onPositiveButtonClicked$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((EventTimePickerDialogFragment$onPositiveButtonClicked$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
