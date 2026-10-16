package cz.mobilesoft.coreblock.scene.intro.schedule;

import android.app.Application;
import cz.mobilesoft.coreblock.base.ViewCommand;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleViewEvent;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class IntroScheduleViewModel extends BaseStatefulViewModel<IntroScheduleViewState, IntroScheduleViewEvent, ViewCommand> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f104826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f104827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final Lazy f104828q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IntroScheduleViewModel(Application application) {
        super(application, new IntroScheduleViewState(null, null, 3, null));
        Intrinsics.checkNotNullParameter(application, "application");
        this.f104826o = -1L;
        this.f104828q = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.schedule.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntroScheduleViewModel.V0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppIconCache V0() {
        return new AppIconCache();
    }

    private final void Y0() {
        if (this.f104826o != -1) {
            BuildersKt__Builders_commonKt.d(C0(), null, null, new IntroScheduleViewModel$updateSchedule$1(this, null), 3, null);
        }
    }

    public final AppIconCache W0() {
        return (AppIconCache) this.f104828q.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public void O0(IntroScheduleViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!(event instanceof IntroScheduleViewEvent.OnScheduleCreated)) {
            if (!Intrinsics.areEqual(event, IntroScheduleViewEvent.OnResume.f104823a)) {
                throw new NoWhenBranchMatchedException();
            }
            Y0();
        } else {
            IntroScheduleViewEvent.OnScheduleCreated onScheduleCreated = (IntroScheduleViewEvent.OnScheduleCreated) event;
            this.f104826o = onScheduleCreated.a();
            this.f104827p = onScheduleCreated.b();
            Y0();
        }
    }
}
