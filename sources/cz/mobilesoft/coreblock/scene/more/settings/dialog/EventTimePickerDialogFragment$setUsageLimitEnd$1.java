package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import cz.mobilesoft.coreblock.enums.EventShowAsType;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$setUsageLimitEnd$1", f = "EventTimePickerDialogFragment.kt", l = {164, 165}, m = "invokeSuspend", v = 1)
final class EventTimePickerDialogFragment$setUsageLimitEnd$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ EventTimePickerDialogFragment f109582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f109583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ EventShowAsType f109584d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EventTimePickerDialogFragment$setUsageLimitEnd$1(EventTimePickerDialogFragment eventTimePickerDialogFragment, int i3, EventShowAsType eventShowAsType, Continuation continuation) {
        super(1, continuation);
        this.f109582b = eventTimePickerDialogFragment;
        this.f109583c = i3;
        this.f109584d = eventShowAsType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new EventTimePickerDialogFragment$setUsageLimitEnd$1(this.f109582b, this.f109583c, this.f109584d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0040, code lost:
    
        if (r5.p0(r1, r4) == r0) goto L15;
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
            int r1 = r4.f109581a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L43
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
            cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment r5 = r4.f109582b
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r5 = cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment.G(r5)
            int r1 = r4.f109583c
            r4.f109581a = r3
            java.lang.Object r5 = r5.o0(r1, r4)
            if (r5 != r0) goto L32
            goto L42
        L32:
            cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment r5 = r4.f109582b
            cz.mobilesoft.coreblock.storage.datastore.NotificationDataStore r5 = cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment.G(r5)
            cz.mobilesoft.coreblock.enums.EventShowAsType r1 = r4.f109584d
            r4.f109581a = r2
            java.lang.Object r5 = r5.p0(r1, r4)
            if (r5 != r0) goto L43
        L42:
            return r0
        L43:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment$setUsageLimitEnd$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((EventTimePickerDialogFragment$setUsageLimitEnd$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
