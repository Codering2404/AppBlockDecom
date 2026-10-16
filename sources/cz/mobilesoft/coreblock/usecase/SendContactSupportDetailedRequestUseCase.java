package cz.mobilesoft.coreblock.usecase;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.dto.events.EventWithIdsDTO;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.enums.HiddenContactReason;
import cz.mobilesoft.coreblock.repository.PremiumRepositoryV2;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.storage.datastore.CoreMultiProcessDataStore;
import cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore;
import cz.mobilesoft.coreblock.storage.datastore.EventDataStore;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.storage.room.dao.core.EmergencyUnblockingDao;
import cz.mobilesoft.coreblock.usecase.FlowUseCase;
import cz.mobilesoft.coreblock.util.ViewModelState;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
public final class SendContactSupportDetailedRequestUseCase extends FlowUseCase<Params, ViewModelState> implements KoinComponent {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f127259j = new Companion(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f127260k = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f127262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lazy f127263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f127264d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f127265f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f127266g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Lazy f127267h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private EventWithIdsDTO f127268i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SendContactSupportDetailedRequestUseCase(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f127261a = context;
        KoinPlatformTools koinPlatformTools = KoinPlatformTools.f146106a;
        LazyThreadSafetyMode lazyThreadSafetyModeB = koinPlatformTools.b();
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f127262b = LazyKt.a(lazyThreadSafetyModeB, new Function0<CoreMultiProcessDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(CoreMultiProcessDataStore.class), qualifier, objArr);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB2 = koinPlatformTools.b();
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f127263c = LazyKt.a(lazyThreadSafetyModeB2, new Function0<EventDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EventDataStore.class), objArr2, objArr3);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB3 = koinPlatformTools.b();
        final Object[] objArr4 = 0 == true ? 1 : 0;
        final Object[] objArr5 = 0 == true ? 1 : 0;
        this.f127264d = LazyKt.a(lazyThreadSafetyModeB3, new Function0<EmergencyUnblockingDao>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(EmergencyUnblockingDao.class), objArr4, objArr5);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB4 = koinPlatformTools.b();
        final Object[] objArr6 = 0 == true ? 1 : 0;
        final Object[] objArr7 = 0 == true ? 1 : 0;
        this.f127265f = LazyKt.a(lazyThreadSafetyModeB4, new Function0<DevDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DevDataStore.class), objArr6, objArr7);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB5 = koinPlatformTools.b();
        final Object[] objArr8 = 0 == true ? 1 : 0;
        final Object[] objArr9 = 0 == true ? 1 : 0;
        this.f127266g = LazyKt.a(lazyThreadSafetyModeB5, new Function0<DiscountDataStore>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(DiscountDataStore.class), objArr8, objArr9);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyModeB6 = koinPlatformTools.b();
        final Object[] objArr10 = 0 == true ? 1 : 0;
        final Object[] objArr11 = 0 == true ? 1 : 0;
        this.f127267h = LazyKt.a(lazyThreadSafetyModeB6, new Function0<PremiumRepositoryV2>() { // from class: cz.mobilesoft.coreblock.usecase.SendContactSupportDetailedRequestUseCase$special$$inlined$inject$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KoinComponent koinComponent = this;
                return (koinComponent instanceof KoinScopeComponent ? ((KoinScopeComponent) koinComponent).getScope() : koinComponent.r0().j().d()).e(Reflection.b(PremiumRepositoryV2.class), objArr10, objArr11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File l(Uri uri) throws FileNotFoundException {
        ContentResolver contentResolver = this.f127261a.getContentResolver();
        Intrinsics.checkNotNullExpressionValue(contentResolver, "getContentResolver(...)");
        String strU = u(contentResolver, uri);
        if (strU == null) {
            strU = "";
        }
        File file = new File(this.f127261a.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), strU);
        InputStream inputStreamOpenInputStream = this.f127261a.getContentResolver().openInputStream(uri);
        if (inputStreamOpenInputStream == null) {
            return file;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ByteStreamsKt.b(inputStreamOpenInputStream, fileOutputStream, 0, 2, null);
                CloseableKt.a(fileOutputStream, null);
                CloseableKt.a(inputStreamOpenInputStream, null);
                return file;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FeedbackViewState.FreshdeskAttachment freshdeskAttachment = (FeedbackViewState.FreshdeskAttachment) it.next();
            if (freshdeskAttachment instanceof FeedbackViewState.FreshdeskAttachment.TemporaryFile) {
                ((FeedbackViewState.FreshdeskAttachment.TemporaryFile) freshdeskAttachment).c().delete();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DevDataStore n() {
        return (DevDataStore) this.f127265f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscountDataStore o() {
        return (DiscountDataStore) this.f127266g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EmergencyUnblockingDao p() {
        return (EmergencyUnblockingDao) this.f127264d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EventDataStore q() {
        return (EventDataStore) this.f127263c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoreMultiProcessDataStore r() {
        return (CoreMultiProcessDataStore) this.f127262b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PremiumRepositoryV2 s() {
        return (PremiumRepositoryV2) this.f127267h.getValue();
    }

    private final String u(ContentResolver contentResolver, Uri uri) {
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null);
        Intrinsics.checkNotNull(cursorQuery);
        int columnIndex = cursorQuery.getColumnIndex("_display_name");
        cursorQuery.moveToFirst();
        String string = cursorQuery.getString(columnIndex);
        cursorQuery.close();
        return string;
    }

    @Override // org.koin.core.component.KoinComponent
    public /* bridge */ Koin r0() {
        return KoinComponent.DefaultImpls.a(this);
    }

    public Flow t(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return FlowKt.I(new SendContactSupportDetailedRequestUseCase$invoke$1(this, params, null));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements FlowUseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f127269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f127270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ContactReason f127271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HiddenContactReason f127272d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f127273e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f127274f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f127275g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f127276h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final boolean f127277i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f127278j;

        public Params(String message, List attachments, ContactReason contactReason, HiddenContactReason hiddenContactReason, String emailText, String revenueCatUserId, String diagnosticFreshdeskString, boolean z2, boolean z3, String str) {
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(attachments, "attachments");
            Intrinsics.checkNotNullParameter(emailText, "emailText");
            Intrinsics.checkNotNullParameter(revenueCatUserId, "revenueCatUserId");
            Intrinsics.checkNotNullParameter(diagnosticFreshdeskString, "diagnosticFreshdeskString");
            this.f127269a = message;
            this.f127270b = attachments;
            this.f127271c = contactReason;
            this.f127272d = hiddenContactReason;
            this.f127273e = emailText;
            this.f127274f = revenueCatUserId;
            this.f127275g = diagnosticFreshdeskString;
            this.f127276h = z2;
            this.f127277i = z3;
            this.f127278j = str;
        }

        public final List a() {
            return this.f127270b;
        }

        public final String b() {
            return this.f127278j;
        }

        public final String c() {
            return this.f127275g;
        }

        public final String d() {
            return this.f127273e;
        }

        public final HiddenContactReason e() {
            return this.f127272d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127269a, params.f127269a) && Intrinsics.areEqual(this.f127270b, params.f127270b) && this.f127271c == params.f127271c && this.f127272d == params.f127272d && Intrinsics.areEqual(this.f127273e, params.f127273e) && Intrinsics.areEqual(this.f127274f, params.f127274f) && Intrinsics.areEqual(this.f127275g, params.f127275g) && this.f127276h == params.f127276h && this.f127277i == params.f127277i && Intrinsics.areEqual(this.f127278j, params.f127278j);
        }

        public final String f() {
            return this.f127269a;
        }

        public final ContactReason g() {
            return this.f127271c;
        }

        public final boolean h() {
            return this.f127277i;
        }

        public int hashCode() {
            int iHashCode = ((this.f127269a.hashCode() * 31) + this.f127270b.hashCode()) * 31;
            ContactReason contactReason = this.f127271c;
            int iHashCode2 = (iHashCode + (contactReason == null ? 0 : contactReason.hashCode())) * 31;
            HiddenContactReason hiddenContactReason = this.f127272d;
            int iHashCode3 = (((((((((((iHashCode2 + (hiddenContactReason == null ? 0 : hiddenContactReason.hashCode())) * 31) + this.f127273e.hashCode()) * 31) + this.f127274f.hashCode()) * 31) + this.f127275g.hashCode()) * 31) + Boolean.hashCode(this.f127276h)) * 31) + Boolean.hashCode(this.f127277i)) * 31;
            String str = this.f127278j;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public final boolean i() {
            return this.f127276h;
        }

        public String toString() {
            return "Params(message=" + this.f127269a + ", attachments=" + this.f127270b + ", selectedContactReason=" + this.f127271c + ", hiddenContactReason=" + this.f127272d + ", emailText=" + this.f127273e + ", revenueCatUserId=" + this.f127274f + ", diagnosticFreshdeskString=" + this.f127275g + ", isFromShortcut=" + this.f127276h + ", isFromRatingDialog=" + this.f127277i + ", chatbotUrl=" + this.f127278j + ")";
        }

        public /* synthetic */ Params(String str, List list, ContactReason contactReason, HiddenContactReason hiddenContactReason, String str2, String str3, String str4, boolean z2, boolean z3, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? CollectionsKt.emptyList() : list, (i3 & 4) != 0 ? null : contactReason, (i3 & 8) != 0 ? null : hiddenContactReason, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, str4, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? false : z2, (i3 & Function.MAX_NARGS) != 0 ? false : z3, (i3 & 512) != 0 ? null : str5);
        }
    }
}
