package cz.mobilesoft.coreblock.service.receiver;

import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.internal.instrument.anrreport.jRA.jlWo;
import cz.mobilesoft.coreblock.MainActivity;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.repository.QuickBlockRepository;
import cz.mobilesoft.coreblock.repository.StrictModeRepository;
import cz.mobilesoft.coreblock.storage.room.dao.blocking.ProfileDao;
import cz.mobilesoft.coreblock.storage.sharedprefs.PrefManager;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class QuickBlockTileService extends TileService implements KoinComponent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f123725a = CoroutinesHelperExtKt.a(Dispatchers.b());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f123726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f123727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f123728d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f123729f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MonetizationState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MonetizationState[] $VALUES;
        public static final Companion Companion;
        private final int id;
        public static final MonetizationState UNKNOWN = new MonetizationState("UNKNOWN", 0, 0);
        public static final MonetizationState FREE = new MonetizationState("FREE", 1, 1);
        public static final MonetizationState MONETIZED = new MonetizationState("MONETIZED", 2, 2);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final MonetizationState a(int i3) {
                MonetizationState next;
                Iterator<MonetizationState> it = MonetizationState.getEntries().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (next.getId() == i3) {
                        break;
                    }
                }
                MonetizationState monetizationState = next;
                return monetizationState == null ? MonetizationState.UNKNOWN : monetizationState;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ MonetizationState[] $values() {
            return new MonetizationState[]{UNKNOWN, FREE, MONETIZED};
        }

        static {
            MonetizationState[] monetizationStateArr$values = $values();
            $VALUES = monetizationStateArr$values;
            $ENTRIES = EnumEntriesKt.a(monetizationStateArr$values);
            Companion = new Companion(null);
        }

        private MonetizationState(String str, int i3, int i4) {
            this.id = i4;
        }

        public static EnumEntries<MonetizationState> getEntries() {
            return $ENTRIES;
        }

        public static MonetizationState valueOf(String str) {
            return (MonetizationState) Enum.valueOf(MonetizationState.class, str);
        }

        public static MonetizationState[] values() {
            return (MonetizationState[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuickBlockTileService() {
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f123726b = LazyKt.a(lazyThreadSafetyModeB, new Function0<ProfileDao>() { // from class: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(ProfileDao.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f123727c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<StrictModeRepository>() { // from class: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(StrictModeRepository.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f123728d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<QuickBlockRepository>() { // from class: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(QuickBlockRepository.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f123729f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr6, objArr7);
            }
        });
    }

    private final void A() {
        BuildersKt__Builders_commonKt.d(this.f123725a, null, null, new QuickBlockTileService$stopBlocking$1(this, null), 3, null);
    }

    private final void l() {
        if (isLocked()) {
            unlockAndRun(new Runnable() { // from class: cz.mobilesoft.coreblock.service.receiver.f
                @Override // java.lang.Runnable
                public final void run() {
                    QuickBlockTileService.m(this.f123791a);
                }
            });
        } else {
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(QuickBlockTileService quickBlockTileService) {
        quickBlockTileService.x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n() {
        if (isLocked()) {
            unlockAndRun(new Runnable() { // from class: cz.mobilesoft.coreblock.service.receiver.g
                @Override // java.lang.Runnable
                public final void run() {
                    QuickBlockTileService.o(this.f123792a);
                }
            });
        } else {
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(QuickBlockTileService quickBlockTileService) {
        quickBlockTileService.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0063, code lost:
    
        if (r15 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00d0, code lost:
    
        if (w(r2, r0) == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d2, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object p(kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.QuickBlockTileService.p(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int q() {
        return 201326592;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 r() {
        return (PremiumRepositoryV2) this.f123729f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QuickBlockRepository s() {
        return (QuickBlockRepository) this.f123728d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StrictModeRepository t() {
        return (StrictModeRepository) this.f123727c.getValue();
    }

    private final void u() {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            BuildersKt__Builders_commonKt.d(this.f123725a, null, null, new QuickBlockTileService$setTileState$1$1(this, qsTile, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        String string = getString(StrictModeTitleAlternatives.Companion.a());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (Build.VERSION.SDK_INT >= 31) {
            Toast.makeText(getApplicationContext(), string, 1).show();
            return;
        }
        View viewInflate = LayoutInflater.from(new ContextThemeWrapper(getApplicationContext(), R.style.f95866a)).inflate(R.layout.f95713o0, (ViewGroup) null);
        ((AppCompatTextView) viewInflate.findViewById(R.id.f95632k2)).setText(string);
        Toast toast = new Toast(getApplicationContext());
        toast.setMargin(0.0f, 0.0f);
        toast.setGravity(119, 0, 0);
        toast.setDuration(1);
        toast.setView(viewInflate);
        toast.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object w(Intent intent, Continuation continuation) {
        Object objG = BuildersKt.g(Dispatchers.c(), new QuickBlockTileService$startActivityAndCollapseOnMain$2(this, intent, null), continuation);
        return objG == IntrinsicsKt.f() ? objG : Unit.f139807a;
    }

    private final void x() {
        BuildersKt__Builders_commonKt.d(this.f123725a, null, null, new QuickBlockTileService$startBlocking$1(this, null), 3, null);
    }

    static /* synthetic */ Object z(QuickBlockTileService quickBlockTileService, boolean z2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        return quickBlockTileService.y(z2, continuation);
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            BuildersKt__Builders_commonKt.d(this.f123725a, null, null, new QuickBlockTileService$onClick$1$1(this, qsTile, null), 3, null);
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        u();
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        super.onTileAdded();
        PrefManager.f126839a.t2();
        u();
        AnswersHelper.f128199a.u4(true);
    }

    @Override // android.service.quicksettings.TileService
    public void onTileRemoved() {
        super.onTileRemoved();
        PrefManager.f126839a.v2();
        AnswersHelper.f128199a.u4(false);
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object y(boolean z2, Continuation continuation) {
        Intent intentA = MainActivity.H.a(this);
        intentA.putExtra(jlWo.CNcn, true);
        intentA.putExtra("SHOW_QUICK_BLOCK_ERROR_DIALOG", z2);
        intentA.setFlags(268468224);
        Object objW = w(intentA, continuation);
        return objW == IntrinsicsKt.f() ? objW : Unit.f139807a;
    }
}
