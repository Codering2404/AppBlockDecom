package cz.mobilesoft.coreblock.scene.quickblock.timer;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.scene.email_consent.EmailCommunicationConsentActivity;
import cz.mobilesoft.coreblock.scene.permission.PermissionActivity;
import cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewCommand;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectActivity$CommandProcessor$1$1", f = "QuickBlockTimeSelectActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class QuickBlockTimeSelectActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<QuickBlockTimeSelectViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f114247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimePickerViewModel f114248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ QuickBlockTimeSelectActivity f114249d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f114250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f114251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ ActivityLauncher f114252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f114253i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTimeSelectActivity$CommandProcessor$1$1(TimePickerViewModel timePickerViewModel, QuickBlockTimeSelectActivity quickBlockTimeSelectActivity, Context context, MutableState mutableState, ActivityLauncher activityLauncher, boolean z2, Continuation continuation) {
        super(2, continuation);
        this.f114248c = timePickerViewModel;
        this.f114249d = quickBlockTimeSelectActivity;
        this.f114250f = context;
        this.f114251g = mutableState;
        this.f114252h = activityLauncher;
        this.f114253i = z2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        QuickBlockTimeSelectActivity$CommandProcessor$1$1 quickBlockTimeSelectActivity$CommandProcessor$1$1 = new QuickBlockTimeSelectActivity$CommandProcessor$1$1(this.f114248c, this.f114249d, this.f114250f, this.f114251g, this.f114252h, this.f114253i, continuation);
        quickBlockTimeSelectActivity$CommandProcessor$1$1.f114247b = obj;
        return quickBlockTimeSelectActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(QuickBlockTimeSelectViewCommand quickBlockTimeSelectViewCommand, Continuation continuation) {
        return ((QuickBlockTimeSelectActivity$CommandProcessor$1$1) create(quickBlockTimeSelectViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        QuickBlockTimeSelectViewCommand quickBlockTimeSelectViewCommand = (QuickBlockTimeSelectViewCommand) this.f114247b;
        IntrinsicsKt.f();
        if (this.f114246a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (quickBlockTimeSelectViewCommand instanceof QuickBlockTimeSelectViewCommand.OnTimePickerTypeChanged) {
            TimePickerViewModel timePickerViewModel = this.f114248c;
            TimePickerConfig timePickerConfig = this.f114249d.f114245f;
            QuickBlockTimeSelectViewCommand.OnTimePickerTypeChanged onTimePickerTypeChanged = (QuickBlockTimeSelectViewCommand.OnTimePickerTypeChanged) quickBlockTimeSelectViewCommand;
            Long time = onTimePickerTypeChanged.b().getTime();
            TimePickerViewModel.p1(timePickerViewModel, timePickerConfig, Boxing.e((time == null && (time = onTimePickerTypeChanged.a()) == null) ? 0L : time.longValue()), null, true, 4, null);
        } else if (quickBlockTimeSelectViewCommand instanceof QuickBlockTimeSelectViewCommand.OnQuickBlockStarted) {
            if (((QuickBlockTimeSelectViewCommand.OnQuickBlockStarted) quickBlockTimeSelectViewCommand).a()) {
                Context context = this.f114250f;
                context.startActivity(EmailCommunicationConsentActivity.f101711g.a(context, "quick_block"));
            }
            this.f114249d.finish();
        } else if (quickBlockTimeSelectViewCommand instanceof QuickBlockTimeSelectViewCommand.ShowStrictModeDialog) {
            this.f114251g.setValue(Boxing.a(true));
        } else {
            if (!(quickBlockTimeSelectViewCommand instanceof QuickBlockTimeSelectViewCommand.ShowPermissionsBeforeStart)) {
                throw new NoWhenBranchMatchedException();
            }
            QuickBlockTimeSelectViewCommand.ShowPermissionsBeforeStart showPermissionsBeforeStart = (QuickBlockTimeSelectViewCommand.ShowPermissionsBeforeStart) quickBlockTimeSelectViewCommand;
            this.f114252h.a().setValue(Boxing.e(showPermissionsBeforeStart.b()));
            PermissionActivity.Companion companion = PermissionActivity.f111772j;
            Context context2 = this.f114250f;
            List listA = showPermissionsBeforeStart.a();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listA, 10));
            Iterator it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(new PermissionDTO((Permission) it.next(), false, false, 6, null));
            }
            this.f114252h.b().b(PermissionActivity.Companion.b(companion, context2, arrayList, false, !this.f114253i, false, null, null, 116, null));
        }
        return Unit.f139807a;
    }
}
