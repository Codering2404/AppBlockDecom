package cz.mobilesoft.coreblock.scene.more.settings.dialog;

import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragment$onCreateDialog$3$1", f = "LanguagePickerDialogFragment.kt", l = {57}, m = "invokeSuspend", v = 1)
final class LanguagePickerDialogFragment$onCreateDialog$3$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f109594a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LanguagePickerDialogFragment f109595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f109596c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LanguagePickerDialogFragment$onCreateDialog$3$1(LanguagePickerDialogFragment languagePickerDialogFragment, Ref.ObjectRef objectRef, Continuation continuation) {
        super(1, continuation);
        this.f109595b = languagePickerDialogFragment;
        this.f109596c = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LanguagePickerDialogFragment$onCreateDialog$3$1(this.f109595b, this.f109596c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        String languageTag;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f109594a;
        if (i3 == 0) {
            ResultKt.b(obj);
            CoreMultiProcessDataStore coreMultiProcessDataStoreC = this.f109595b.C();
            Locale locale = (Locale) this.f109596c.f140144a;
            if (locale == null || (languageTag = locale.toLanguageTag()) == null) {
                languageTag = "";
            }
            this.f109594a = 1;
            if (coreMultiProcessDataStoreC.T0(languageTag, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LanguagePickerDialogFragment$onCreateDialog$3$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
